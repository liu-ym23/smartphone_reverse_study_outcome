package com.ss.android.ugc.effectmanager.common.cachemanager.common;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.android.ugc.effectmanager.common.logger.EPLog;
import com.ss.android.ugc.effectmanager.common.utils.FileUtils;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes40.dex */
public final class DiskLruCache implements Closeable {
    private static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    private static final String JOURNAL_FILE = "journal";
    private static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    private static final String JOURNAL_FILE_TEMP = "journal.tmp";
    private static final Pattern LEGAL_KEY_PATTERN = null;
    private static final String MAGIC = "libcore.io.DiskLruCache";
    private static final OutputStream NULL_OUTPUT_STREAM = null;
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    private static final String STRING_KEY_PATTERN = "[a-z0-9_-]{1,120}";
    private static final String TAG = "DiskLruCache";
    private static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable<Void> cleanupCallable;
    private final File directory;
    private final ExecutorService executorService;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private IAllowListRule mAllowKeyRule;
    private long maxSize;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    public final class Editor {
        private boolean committed;
        private final Entry entry;
        private boolean hasErrors;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        public class FaultHidingOutputStream extends FilterOutputStream {
            final /* synthetic */ Editor this$1;

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                ((FilterOutputStream) this).out.close();     // Catch: IOException -> L4
                return;
            L4:
                Editor.access$2302(this.this$1, true);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                ((FilterOutputStream) this).out.flush();     // Catch: IOException -> L4
                return;
            L4:
                Editor.access$2302(this.this$1, true);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int r100) {
                ((FilterOutputStream) this).out.write(r100);     // Catch: IOException -> L4
                return;
            L4:
                Editor.access$2302(this.this$1, true);
            }

            private FaultHidingOutputStream(Editor r100, OutputStream r101) {
                this.this$1 = r100;
                super(r101);
            }

            public /* synthetic */ FaultHidingOutputStream(Editor r100, OutputStream r101, AnonymousClass1 r102) {
                this(r100, r101);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] r100, int r101, int r102) {
                ((FilterOutputStream) this).out.write(r100, r101, r102);     // Catch: IOException -> L4
                return;
            L4:
                Editor.access$2302(this.this$1, true);
            }
        }

        public void abort() throws IOException {
            DiskLruCache.access$2200(this.this$0, this, false);
        }

        public void abortUnlessCommitted() {
            if (this.committed == true) goto L9;
            abort();     // Catch: IOException -> L6
            return;
        L10:
            return;
        }

        public void commit() throws IOException {
            if (this.hasErrors == false) goto L5;
            DiskLruCache.access$2200(this.this$0, this, false);
            this.this$0.remove(Entry.access$1100(this.entry));
        L6:
            this.committed = true;
            return;
        L5:
            DiskLruCache.access$2200(this.this$0, this, true);
            goto L6
        }

        public static /* synthetic */ Entry access$1400(Editor r100) {
            return r100.entry;
        }

        public static /* synthetic */ boolean[] access$1500(Editor r100) {
            return r100.written;
        }

        public String getString(int r100) throws IOException {
            InputStream r101 = newInputStream(r100);
            if (r101 != null) goto L7;
            return null;
        L7:
            return DiskLruCache.access$1700(r101);
        }

        public InputStream newInputStream(int r100) throws IOException {
            DiskLruCache r101 = this.this$0;
            monitor-enter(r101);
        L17:
            th = move-exception;
            throw th;
        L5:
            if (Entry.access$700(this.entry) != this) goto L16;
            if (Entry.access$600(this.entry) == true) goto L20;
            monitor-exit(r101);     // Catch: Throwable -> L17
            return null;
        L20:
            PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(this.entry.getCleanFile(r100));     // Catch: FileNotFoundException -> L13 Throwable -> L17
            monitor-exit(r101);     // Catch: Throwable -> L17
            return r102;
        L14:
            return null;
        L16:
            throw new IllegalStateException();     // Catch: Throwable -> L17
        }

        public OutputStream newOutputStream(int r100) throws IOException {
            if (r100 < 0) goto L29;
            if (r100 >= DiskLruCache.access$1800(this.this$0)) goto L29;
            DiskLruCache r101 = this.this$0;
            monitor-enter(r101);
        L25:
            th = move-exception;
            throw th;
        L8:
            if (Entry.access$700(this.entry) != this) goto L24;
            if (Entry.access$600(this.entry) == true) goto L12;
            this.written[r100] = true;     // Catch: Throwable -> L25
        L12:
            File r102 = this.entry.getDirtyFile(r100);     // Catch: Throwable -> L25
            PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r102);     // Catch: FileNotFoundException -> L15 Throwable -> L25
        L17:
            FaultHidingOutputStream r104 = new FaultHidingOutputStream(this, r103, null);     // Catch: Throwable -> L25
            monitor-exit(r101);     // Catch: Throwable -> L25
            return r104;
        L15:
            DiskLruCache.access$1900(this.this$0).mkdirs();     // Catch: Throwable -> L25
            r103 = new PolarisFileOutputStreamWrapper(r102);     // Catch: FileNotFoundException -> L20 Throwable -> L25
        L22:
            return DiskLruCache.access$2000();
        L24:
            throw new IllegalStateException();     // Catch: Throwable -> L25
        L29:
            throw new IllegalArgumentException("Expected index " + r100 + " to be greater than 0 and less than the maximum value count of " + DiskLruCache.access$1800(this.this$0));
        }

        private Editor(DiskLruCache r100, Entry r101) {
            this.this$0 = r100;
            this.entry = r101;
            if (Entry.access$600(r101) == false) goto L5;
            boolean[] r102 = null;
        L6:
            this.written = r102;
            return;
        L5:
            r102 = new boolean[DiskLruCache.access$1800(r100)];
            goto L6
        }

        public static /* synthetic */ boolean access$2302(Editor r100, boolean r101) {
            r100.hasErrors = r101;
            return r101;
        }

        public void set(int r100, String r101) throws IOException {
            OutputStreamWriter r102 = null;
            OutputStream r103 = newOutputStream(r100);     // Catch: Throwable -> L9
            FileUtils r104 = FileUtils.INSTANCE;     // Catch: Throwable -> L9
            OutputStreamWriter r105 = new OutputStreamWriter(r103, r104.getUTF_8());     // Catch: Throwable -> L9
            r105.write(r101);     // Catch: Throwable -> L7
            r104.closeQuietly(r105);
            return;
        L7:
            th = th;
            r102 = r105;
        L10:
            FileUtils.INSTANCE.closeQuietly(r102);
            throw th;
        L9:
            th = th;
            goto L10
        }

        public /* synthetic */ Editor(DiskLruCache r100, Entry r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public final class Entry {
        private Editor currentEditor;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;

        public String getLengths() throws IOException {
            StringBuilder r100 = new StringBuilder();
            long[] r101 = this.lengths;
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L6;
            long r104 = r101[r103];
            r100.append(' ');
            r100.append(r104);
            r103 = r103 + 1;
            goto L3
        L6:
            return r100.toString();
        }

        public static /* synthetic */ long[] access$1000(Entry r100) {
            return r100.lengths;
        }

        public static /* synthetic */ String access$1100(Entry r100) {
            return r100.key;
        }

        public static /* synthetic */ long access$1200(Entry r100) {
            return r100.sequenceNumber;
        }

        public static /* synthetic */ boolean access$600(Entry r100) {
            return r100.readable;
        }

        public static /* synthetic */ Editor access$700(Entry r100) {
            return r100.currentEditor;
        }

        private IOException invalidLengths(String[] r100) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(r100));
        }

        private void setLengths(String[] r100) throws IOException {
            if (r100.length != DiskLruCache.access$1800(this.this$0)) goto L13;
            int r101 = 0;
        L14:
            if (r101 >= r100.length) goto L9;
            this.lengths[r101] = CastLongProtector.parseLong(r100[r101]);     // Catch: NumberFormatException -> L10
            r101 = r101 + 1;
            goto L14
        L9:
            return;
        L11:
            throw invalidLengths(r100);
        L13:
            throw invalidLengths(r100);
        }

        public File getCleanFile(int r100) {
            if (r100 != 0) goto L6;
            return new PolarisFileWrapper(DiskLruCache.access$1900(this.this$0), this.key);
        L6:
            return new PolarisFileWrapper(DiskLruCache.access$1900(this.this$0), this.key + "." + r100);
        }

        public File getDirtyFile(int r100) {
            if (r100 != 0) goto L7;
            return new PolarisFileWrapper(DiskLruCache.access$1900(this.this$0), this.key + DefaultDiskStorage.FileType.TEMP);
        L7:
            return new PolarisFileWrapper(DiskLruCache.access$1900(this.this$0), this.key + "." + r100 + DefaultDiskStorage.FileType.TEMP);
        }

        private Entry(DiskLruCache r100, String r101) {
            this.this$0 = r100;
            this.key = r101;
            this.lengths = new long[DiskLruCache.access$1800(r100)];
        }

        public static /* synthetic */ long access$1202(Entry r100, long r101) {
            r100.sequenceNumber = r101;
            return r101;
        }

        public static /* synthetic */ boolean access$602(Entry r100, boolean r101) {
            r100.readable = r101;
            return r101;
        }

        public static /* synthetic */ Editor access$702(Entry r100, Editor r101) {
            r100.currentEditor = r101;
            return r101;
        }

        public static /* synthetic */ void access$800(Entry r100, String[] r101) throws IOException {
            r100.setLengths(r101);
        }

        public /* synthetic */ Entry(DiskLruCache r100, String r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public final class Snapshot implements Closeable {
        private final File[] cleanFiles;
        private final InputStream[] ins;
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            InputStream[] r100 = this.ins;
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            InputStream r103 = r100[r102];
            FileUtils.INSTANCE.closeQuietly(r103);
            r102 = r102 + 1;
            goto L3
        }

        public Editor edit() throws IOException {
            return DiskLruCache.access$1600(this.this$0, this.key, this.sequenceNumber);
        }

        public File getCleanFile(int r100) {
            return this.cleanFiles[r100];
        }

        public InputStream getInputStream(int r100) {
            return this.ins[r100];
        }

        public long getLength(int r100) {
            return this.lengths[r100];
        }

        public String getString(int r100) throws IOException {
            return DiskLruCache.access$1700(getInputStream(r100));
        }

        private Snapshot(DiskLruCache r100, String r101, long r102, File[] r103, InputStream[] r104, long[] r105) {
            this.this$0 = r100;
            this.key = r101;
            this.sequenceNumber = r102;
            this.cleanFiles = r103;
            this.ins = r104;
            this.lengths = r105;
        }

        public /* synthetic */ Snapshot(DiskLruCache r100, String r101, long r102, File[] r103, InputStream[] r104, long[] r105, AnonymousClass1 r106) {
            this(r100, r101, r102, r103, r104, r105);
        }
    }

    private synchronized void rebuildJournal() throws IOException {
        monitor-enter(this);
        Writer r100 = this.journalWriter;     // Catch: Throwable -> L24
        if (r100 == null) goto L6;
        r100.close();     // Catch: Throwable -> L24
    L6:
        BufferedWriter r101 = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.journalFileTmp), FileUtils.INSTANCE.getUS_ASCII()));     // Catch: Throwable -> L24
        r101.write(MAGIC);     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write("1");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write(Integer.toString(this.appVersion));     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write(Integer.toString(this.valueCount));     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        Iterator<Entry> r102 = this.lruEntries.values().iterator();     // Catch: Throwable -> L21
    L8:
        if (r102.hasNext() == false) goto L15;
        Entry r103 = r102.next();     // Catch: Throwable -> L21
        if (Entry.access$700(r103) != null) goto L12;
        r101.write("CLEAN " + Entry.access$1100(r103) + r103.getLengths() + '\n');     // Catch: Throwable -> L21
        goto L8
    L12:
        r101.write("DIRTY " + Entry.access$1100(r103) + '\n');     // Catch: Throwable -> L21
        goto L8
    L15:
        r101.close();     // Catch: Throwable -> L24
        if (this.journalFile.exists() == false) goto L18;
        renameTo(this.journalFile, this.journalFileBackup, true);     // Catch: Throwable -> L24
    L18:
        renameTo(this.journalFileTmp, this.journalFile, false);     // Catch: Throwable -> L24
        this.journalFileBackup.delete();     // Catch: Throwable -> L24
        this.journalWriter = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.journalFile, true), FileUtils.INSTANCE.getUS_ASCII()));     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.journalWriter != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r100 = new ArrayList(this.lruEntries.values()).iterator();     // Catch: Throwable -> L16
    L9:
        if (r100.hasNext() == false) goto L13;
        Entry r101 = (Entry) r100.next();     // Catch: Throwable -> L16
        if (Entry.access$700(r101) == null) goto L9;
        Entry.access$700(r101).abort();     // Catch: Throwable -> L16
        goto L9
    L13:
        trimToSize();     // Catch: Throwable -> L16
        this.journalWriter.close();     // Catch: Throwable -> L16
        this.journalWriter = null;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public synchronized void flush() throws IOException {
        monitor-enter(this);
        EPLog.d(TAG, "flush");     // Catch: Throwable -> L6
        checkNotClosed();     // Catch: Throwable -> L6
        trimToSize();     // Catch: Throwable -> L6
        this.journalWriter.flush();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public Set<String> getLruEntryKeys() {
        monitor-enter(this);
        Set<String> r100 = Collections.unmodifiableSet(new LinkedHashSet(this.lruEntries.keySet()));     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long getMaxSize() {
        monitor-enter(this);
        long r100 = this.maxSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isClosed() {
        monitor-enter(this);
        if (this.journalWriter != null) goto L6;
        boolean r100 = true;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isValid() {
        monitor-enter(this);
        File r100 = this.directory;     // Catch: Throwable -> L13
        if (r100 != null) goto L6;
    L10:
        boolean r101 = false;
    L11:
        monitor-exit(this);
        return r101;
    L6:
        if (r100.exists() == false) goto L10;
        if (this.journalFile.exists() == false) goto L10;
        r101 = true;
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized long size() {
        monitor-enter(this);
        long r100 = this.size;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        LEGAL_KEY_PATTERN = PatternProtector.compile(STRING_KEY_PATTERN);
        NULL_OUTPUT_STREAM = new AnonymousClass2();
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    private boolean journalRebuildRequired() {
        int r100 = this.redundantOpCount;
        if (r100 >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (r100 < this.lruEntries.size()) goto L7;
        return true;
    }

    private void processJournal() throws IOException {
        deleteIfExists(this.journalFileTmp);
        Iterator<Entry> r100 = this.lruEntries.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L15;
        Entry r101 = r100.next();
        int r102 = 0;
        if (Entry.access$700(r101) == null) goto L8;
        Entry.access$702(r101, null);
    L12:
        if (r102 >= this.valueCount) goto L14;
        deleteIfExists(r101.getCleanFile(r102));
        deleteIfExists(r101.getDirtyFile(r102));
        r102 = r102 + 1;
        goto L12
    L14:
        r100.remove();
    L8:
        if (r102 >= this.valueCount) goto L4;
        this.size += Entry.access$1000(r101)[r102];
        r102 = r102 + 1;
        goto L8
    }

    private void readJournal() throws IOException {
        StrictLineReader r100 = new StrictLineReader(new PolarisFileInputStreamWrapper(this.journalFile), FileUtils.INSTANCE.getUS_ASCII());
        String r101 = r100.readLine();     // Catch: Throwable -> L24
        String r102 = r100.readLine();     // Catch: Throwable -> L24
        String r103 = r100.readLine();     // Catch: Throwable -> L24
        String r104 = r100.readLine();     // Catch: Throwable -> L24
        String r105 = r100.readLine();     // Catch: Throwable -> L24
        if (MAGIC.equals(r101) == false) goto L23;
        if ("1".equals(r102) == false) goto L23;
        if (Integer.toString(this.appVersion).equals(r103) == false) goto L23;
        if (Integer.toString(this.valueCount).equals(r104) == false) goto L23;
        if ("".equals(r105) == false) goto L23;
        int r106 = 0;
    L28:
        readJournalLine(r100.readLine());     // Catch: EOFException -> L16 Throwable -> L24
        r106 = r106 + 1;
        goto L28
    L16:
        this.redundantOpCount = r106 - this.lruEntries.size();     // Catch: Throwable -> L24
        if (r100.hasUnterminatedLine() == false) goto L19;
        rebuildJournal();     // Catch: Throwable -> L24
    L20:
        FileUtils.INSTANCE.closeQuietly(r100);
        return;
    L19:
        this.journalWriter = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.journalFile, true), FileUtils.INSTANCE.getUS_ASCII()));     // Catch: Throwable -> L24
    L23:
        throw new IOException("unexpected journal header: [" + r101 + ", " + r102 + ", " + r104 + ", " + r105 + "]");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        FileUtils.INSTANCE.closeQuietly(r100);
        throw th;
    }

    public void delete() throws IOException {
        EPLog.d(TAG, "delete");
        close();
        FileUtils.INSTANCE.deleteContents(this.directory);
    }

    private synchronized void trimToSize() throws IOException {
        monitor-enter(this);
        EPLog.d(TAG, "trimToSize size: " + this.size);     // Catch: Throwable -> L22
    L5:
        if (this.size <= this.maxSize) goto L20;
        int r100 = this.lruEntries.size();     // Catch: Throwable -> L22
        Iterator<Map.Entry<String, Entry>> r101 = this.lruEntries.entrySet().iterator();     // Catch: Throwable -> L22
        int r102 = 0;
    L9:
        if (r101.hasNext() == false) goto L5;
        Map.Entry<String, Entry> r103 = r101.next();     // Catch: Throwable -> L22
        EPLog.d(TAG, "trimToSize key:" + r103.getKey());     // Catch: Throwable -> L22
        IAllowListRule r104 = this.mAllowKeyRule;     // Catch: Throwable -> L22
        if (r104 == null) goto L15;
        if (r104.isAllowed(r103.getKey()) == false) goto L15;
        r102 = r102 + 1;     // Catch: Throwable -> L22
    L15:
        EPLog.d(TAG, "trimToSize exe");     // Catch: Throwable -> L22
        if ((r100 - r102) >= 10) goto L18;
        setMaxSize(getMaxSize() * 2);     // Catch: Throwable -> L22
    L18:
        remove(r103.getKey());     // Catch: Throwable -> L22
        goto L5
    L20:
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ OutputStream access$2000() {
        return NULL_OUTPUT_STREAM;
    }

    public File getDirectory() {
        return this.directory;
    }

    public static /* synthetic */ Writer access$000(DiskLruCache r100) {
        return r100.journalWriter;
    }

    public static /* synthetic */ void access$100(DiskLruCache r100) throws IOException {
        r100.trimToSize();
    }

    public static /* synthetic */ String access$1700(InputStream r100) throws IOException {
        return inputStreamToString(r100);
    }

    public static /* synthetic */ int access$1800(DiskLruCache r100) {
        return r100.valueCount;
    }

    public static /* synthetic */ File access$1900(DiskLruCache r100) {
        return r100.directory;
    }

    public static /* synthetic */ boolean access$200(DiskLruCache r100) {
        return r100.journalRebuildRequired();
    }

    public static /* synthetic */ void access$300(DiskLruCache r100) throws IOException {
        r100.rebuildJournal();
    }

    private static void deleteIfExists(File r100) throws IOException {
        if (r100.exists() == true) goto L5;
        return;
    L5:
        if (r100.delete() == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    private static String inputStreamToString(InputStream r100) throws IOException {
        FileUtils r101 = FileUtils.INSTANCE;
        return r101.readFully(new InputStreamReader(r100, r101.getUTF_8()));
    }

    private void readJournalLine(String r100) throws IOException {
        int r101 = r100.indexOf(32);
        if (r101 == (-1)) goto L36;
        int r102 = r101 + 1;
        int r103 = r100.indexOf(32, r102);
        if (r103 != (-1)) goto L12;
        String r104 = r100.substring(r102);
        if (r101 == 6) goto L9;
    L13:
        Entry r105 = this.lruEntries.get(r104);
        AnonymousClass1 r106 = null;
        if (r105 != null) goto L17;
        r105 = new Entry(this, r104, r106);
        this.lruEntries.put(r104, r105);
    L17:
        if (r103 == (-1)) goto L22;
        if (r101 != 5) goto L22;
        if (r100.startsWith(CLEAN) == false) goto L22;
        String[] r107 = r100.substring(r103 + 1).split(" ");
        Entry.access$602(r105, true);
        Entry.access$702(r105, null);
        Entry.access$800(r105, r107);
        return;
    L22:
        if (r103 != (-1)) goto L27;
        if (r101 != 5) goto L27;
        if (r100.startsWith(DIRTY) == false) goto L27;
        Entry.access$702(r105, new Editor(this, r105, r106));
        return;
    L27:
        if (r103 != (-1)) goto L34;
        if (r101 != 4) goto L34;
        if (r100.startsWith(READ) == false) goto L34;
        return;
    L34:
        throw new IOException("unexpected journal line: ".concat(r100));
    L9:
        if (r100.startsWith(REMOVE) == false) goto L13;
        this.lruEntries.remove(r104);
        return;
    L12:
        r104 = r100.substring(r102, r103);
        goto L13
    L36:
        throw new IOException("unexpected journal line: ".concat(r100));
    }

    public static String toDiskLruCacheKey(String r100) {
        char[] r101 = r100.toCharArray();
        int r102 = 0;
    L4:
        if (r102 >= r101.length) goto L20;
        char r103 = r101[r102];
        if (r103 == '_') goto L18;
        if (r103 == '-') goto L18;
        if (r103 < 'a') goto L14;
        if (r103 <= 'z') goto L18;
    L14:
        if (r103 >= '0') goto L16;
    L17:
        r101[r102] = '_';
        goto L18
    L16:
        if (r103 > '9') goto L17;
    L18:
        r102 = r102 + 1;
        goto L4
    L20:
        return new String(r101);
    }

    public static String toDiskLruCacheKeyPattern(String r100) {
        char[] r101 = r100.toCharArray();
        int r102 = 0;
    L4:
        if (r102 >= r101.length) goto L10;
        if (r101[r102] != File.separatorChar) goto L8;
        r101[r102] = '_';
    L8:
        r102 = r102 + 1;
        goto L4
    L10:
        return new String(r101);
    }

    private boolean validateKey(String r100) {
        return LEGAL_KEY_PATTERN.matcher(r100).matches();
    }

    public synchronized boolean addEntryToCache(String r110) throws IOException {
        monitor-enter(this);
        EPLog.d(TAG, "addEntryToCache:" + r110);     // Catch: Throwable -> L30
        checkNotClosed();     // Catch: Throwable -> L30
        if (validateKey(r110) == false) goto L29;
        Entry r100 = this.lruEntries.get(r110);     // Catch: Throwable -> L30
        AnonymousClass1 r101 = null;
        if (r100 != null) goto L10;
        r100 = new Entry(this, r110, r101);     // Catch: Throwable -> L30
        this.lruEntries.put(r110, r100);     // Catch: Throwable -> L30
    L13:
        File r111 = r100.getCleanFile(0);     // Catch: Throwable -> L30
        if (r111.exists() == false) goto L25;
        long r102 = Entry.access$1000(r100)[0];     // Catch: Throwable -> L30
        long r103 = r111.length();     // Catch: Throwable -> L30
        if (r111.isDirectory() == false) goto L18;
        r103 = FileUtils.INSTANCE.getFolderSize(r111);     // Catch: Throwable -> L30
    L18:
        Entry.access$1000(r100)[0] = r103;     // Catch: Throwable -> L30
        this.size = (this.size - r102) + r103;     // Catch: Throwable -> L30
        this.redundantOpCount++;     // Catch: Throwable -> L30
        Entry.access$702(r100, null);     // Catch: Throwable -> L30
        Entry.access$602(r100, true);     // Catch: Throwable -> L30
        this.journalWriter.write("CLEAN " + Entry.access$1100(r100) + r100.getLengths() + '\n');     // Catch: Throwable -> L30
        long r104 = this.nextSequenceNumber;     // Catch: Throwable -> L30
        this.nextSequenceNumber = 1 + r104;     // Catch: Throwable -> L30
        Entry.access$1202(r100, r104);     // Catch: Throwable -> L30
        this.journalWriter.flush();     // Catch: Throwable -> L30
        if (this.size <= this.maxSize) goto L21;
    L22:
        this.executorService.submit(this.cleanupCallable);     // Catch: Throwable -> L30
    L23:
        monitor-exit(this);
        return true;
    L21:
        if (journalRebuildRequired() == false) goto L23;
    L25:
        this.lruEntries.remove(Entry.access$1100(r100));     // Catch: Throwable -> L30
        this.journalWriter.write("REMOVE " + Entry.access$1100(r100) + '\n');     // Catch: Throwable -> L30
        monitor-exit(this);
        return false;
    L10:
        if (Entry.access$700(r100) == null) goto L13;
        monitor-exit(this);
        return false;
    L29:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r110 + "\"");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    public Editor edit(String r100) throws IOException {
        return edit(r100, -1);
    }

    public synchronized Snapshot get(String r110) throws IOException {
        monitor-enter(this);
        checkNotClosed();     // Catch: Throwable -> L37
        if (validateKey(r110) == false) goto L35;
        Entry r100 = this.lruEntries.get(r110);     // Catch: Throwable -> L37
        if (r100 != null) goto L12;
        monitor-exit(this);
        return null;
    L12:
        if (Entry.access$600(r100) == true) goto L15;
        monitor-exit(this);
        return null;
    L15:
        int r101 = this.valueCount;     // Catch: Throwable -> L37
        InputStream[] r102 = new InputStream[r101];     // Catch: Throwable -> L37
        File[] r103 = new File[r101];     // Catch: Throwable -> L37
        int r104 = 0;
        int r105 = 0;
    L42:
        if (r105 >= this.valueCount) goto L21;
        r103[r105] = r100.getCleanFile(r105);     // Catch: FileNotFoundException -> L40 Throwable -> L37
        r102[r105] = new PolarisFileInputStreamWrapper(r103[r105]);     // Catch: FileNotFoundException -> L40 Throwable -> L37
        r105 = r105 + 1;
        goto L42
    L21:
        this.redundantOpCount++;     // Catch: Throwable -> L37
        this.journalWriter.append("READ " + r110 + '\n');     // Catch: Throwable -> L37
        this.journalWriter.flush();     // Catch: Throwable -> L37
        if (journalRebuildRequired() == false) goto L24;
        this.executorService.submit(this.cleanupCallable);     // Catch: Throwable -> L37
    L24:
        Snapshot r106 = new Snapshot(this, r110, Entry.access$1200(r100), r103, r102, Entry.access$1000(r100), null);     // Catch: Throwable -> L37
        monitor-exit(this);
        return r106;
    L28:
        if (r104 >= this.valueCount) goto L33;
        InputStream r111 = r102[r104];     // Catch: Throwable -> L37
        if (r111 == null) goto L33;
        FileUtils.INSTANCE.closeQuietly(r111);     // Catch: Throwable -> L37
        r104 = r104 + 1;
    L33:
        monitor-exit(this);
        return null;
    L35:
        remove(r110);     // Catch: Throwable -> L37
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r110 + "\"");     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    }

    public synchronized boolean has(String r100) {
        monitor-enter(this);
        checkNotClosed();     // Catch: Throwable -> L23
        if (validateKey(r100) == false) goto L22;
        Entry r101 = this.lruEntries.get(r100);     // Catch: Throwable -> L23
        if (r101 != null) goto L12;
        monitor-exit(this);
        return false;
    L12:
        if (Entry.access$600(r101) == true) goto L27;
        monitor-exit(this);
        return false;
    L27:
        this.redundantOpCount++;     // Catch: IOException -> L26 Throwable -> L23
        this.journalWriter.write("READ " + r100 + '\n');     // Catch: IOException -> L26 Throwable -> L23
        this.journalWriter.flush();     // Catch: IOException -> L26 Throwable -> L23
        if (journalRebuildRequired() == false) goto L19;
        this.executorService.submit(this.cleanupCallable);     // Catch: IOException -> L26 Throwable -> L23
    L19:
        monitor-exit(this);
        return true;
    L22:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r100 + "\"");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public synchronized void readKeyInMemory(String r100) {
        monitor-enter(this);
        checkNotClosed();     // Catch: Throwable -> L6
        this.lruEntries.get(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean remove(String r100) throws IOException {
        monitor-enter(this);
        EPLog.d(TAG, "remove:" + r100);     // Catch: Throwable -> L45
        checkNotClosed();     // Catch: Throwable -> L45
        if (validateKey(r100) == false) goto L44;
        Entry r101 = this.lruEntries.get(r100);     // Catch: Throwable -> L45
        int r102 = 0;
        boolean r103 = true;
        if (r101 != null) goto L9;
    L36:
        StringBuilder r104 = new StringBuilder("remove: can not:");     // Catch: Throwable -> L45
        if (r101 == null) goto L40;
        r103 = false;
    L40:
        r104.append(r103);     // Catch: Throwable -> L45
        EPLog.e(TAG, r104.toString());     // Catch: Throwable -> L45
        monitor-exit(this);
        return false;
    L9:
        if (Entry.access$700(r101) != null) goto L36;
        this.redundantOpCount++;     // Catch: Throwable -> L45
        this.journalWriter.append("REMOVE " + r100 + '\n');     // Catch: Throwable -> L45
        this.journalWriter.flush();     // Catch: Throwable -> L45
        this.lruEntries.remove(r100);     // Catch: Throwable -> L45
    L13:
        if (r102 >= this.valueCount) goto L32;
        File r105 = r101.getCleanFile(r102);     // Catch: Throwable -> L45
        if (r105.exists() == false) goto L30;
        if (r105.isFile() == false) goto L24;
        if (r105.delete() == true) goto L24;
        EPLog.e(TAG, "remove  err:" + r100);     // Catch: Throwable -> L45
        throw new IOException("failed to delete " + r105);     // Catch: Throwable -> L45
    L24:
        if (r105.isDirectory() == false) goto L30;
        if (FileUtils.INSTANCE.deleteDir(r105) == true) goto L30;
        EPLog.e(TAG, "remove  err:" + r100);     // Catch: Throwable -> L45
        throw new IOException("failed to delete " + r105);     // Catch: Throwable -> L45
    L30:
        this.size -= Entry.access$1000(r101)[r102];     // Catch: Throwable -> L45
        Entry.access$1000(r101)[r102] = 0;     // Catch: Throwable -> L45
        r102 = r102 + 1;     // Catch: Throwable -> L45
        goto L13
    L32:
        if (journalRebuildRequired() == false) goto L34;
        this.executorService.submit(this.cleanupCallable);     // Catch: Throwable -> L45
    L34:
        monitor-exit(this);
        return true;
    L44:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r100 + "\"");     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public synchronized void setMaxSize(long r100) {
        monitor-enter(this);
        this.maxSize = r100;     // Catch: Throwable -> L6
        this.executorService.submit(this.cleanupCallable);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ int access$402(DiskLruCache r100, int r101) {
        r100.redundantOpCount = r101;
        return r101;
    }

    private synchronized void completeEdit(Editor r110, boolean r111) throws IOException {
        monitor-enter(this);
        Entry r100 = Editor.access$1400(r110);     // Catch: Throwable -> L51
        StringBuilder r101 = new StringBuilder("completeEdit start, key: ");     // Catch: Throwable -> L51
        if (r100 != null) goto L7;
        String r102 = "null";
    L8:
        r101.append(r102);     // Catch: Throwable -> L51
        r101.append(", success: ");     // Catch: Throwable -> L51
        r101.append(r111);     // Catch: Throwable -> L51
        EPLog.d(TAG, r101.toString());     // Catch: Throwable -> L51
        if (Entry.access$700(r100) != r110) goto L50;
        int r103 = 0;
        if (r111 == false) goto L28;
        if (Entry.access$600(r100) == true) goto L28;
        int r104 = 0;
    L16:
        if (r104 >= this.valueCount) goto L28;
        if (Editor.access$1500(r110)[r104] == false) goto L25;
        if (r100.getDirtyFile(r104).exists() == false) goto L21;
        r104 = r104 + 1;
        goto L16
    L21:
        r110.abort();     // Catch: Throwable -> L51
        monitor-exit(this);
        return;
    L25:
        r110.abort();     // Catch: Throwable -> L51
        throw new IllegalStateException("Newly created entry didn't create value for index " + r104);     // Catch: Throwable -> L51
    L28:
        if (r103 >= this.valueCount) goto L36;
        File r112 = r100.getDirtyFile(r103);     // Catch: Throwable -> L51
        if (r111 == true) goto L32;
        deleteIfExists(r112);     // Catch: Throwable -> L51
    L35:
        r103 = r103 + 1;     // Catch: Throwable -> L51
        goto L28
    L32:
        if (r112.exists() == false) goto L35;
        File r105 = r100.getCleanFile(r103);     // Catch: Throwable -> L51
        r112.renameTo(r105);     // Catch: Throwable -> L51
        long r106 = Entry.access$1000(r100)[r103];     // Catch: Throwable -> L51
        long r107 = r105.length();     // Catch: Throwable -> L51
        Entry.access$1000(r100)[r103] = r107;     // Catch: Throwable -> L51
        this.size = (this.size - r106) + r107;     // Catch: Throwable -> L51
        goto L35
    L36:
        this.redundantOpCount++;     // Catch: Throwable -> L51
        Entry.access$702(r100, null);     // Catch: Throwable -> L51
        if ((Entry.access$600(r100) | r111) == false) goto L41;
        Entry.access$602(r100, true);     // Catch: Throwable -> L51
        this.journalWriter.write("CLEAN " + Entry.access$1100(r100) + r100.getLengths() + '\n');     // Catch: Throwable -> L51
        if (r111 == false) goto L42;
        long r113 = this.nextSequenceNumber;     // Catch: Throwable -> L51
        this.nextSequenceNumber = 1 + r113;     // Catch: Throwable -> L51
        Entry.access$1202(r100, r113);     // Catch: Throwable -> L51
    L42:
        this.journalWriter.flush();     // Catch: Throwable -> L51
        if (this.size <= this.maxSize) goto L45;
    L46:
        this.executorService.submit(this.cleanupCallable);     // Catch: Throwable -> L51
    L47:
        monitor-exit(this);
        return;
    L45:
        if (journalRebuildRequired() == false) goto L47;
    L41:
        this.lruEntries.remove(Entry.access$1100(r100));     // Catch: Throwable -> L51
        this.journalWriter.write("REMOVE " + Entry.access$1100(r100) + '\n');     // Catch: Throwable -> L51
        goto L42
    L50:
        throw new IllegalStateException();     // Catch: Throwable -> L51
    L7:
        r102 = Entry.access$1100(r100);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;
    }

    private synchronized Editor edit(String r100, long r101) throws IOException {
        monitor-enter(this);
        checkNotClosed();     // Catch: Throwable -> L25
        if (validateKey(r100) == false) goto L24;
        Entry r102 = this.lruEntries.get(r100);     // Catch: Throwable -> L25
        AnonymousClass1 r103 = null;
        if (r101 == (-1)) goto L14;
        if (r102 != null) goto L11;
    L12:
        monitor-exit(this);
        return null;
    L11:
        if (Entry.access$1200(r102) != r101) goto L12;
    L14:
        if (r102 != null) goto L17;
        r102 = new Entry(this, r100, r103);     // Catch: Throwable -> L25
        this.lruEntries.put(r100, r102);     // Catch: Throwable -> L25
    L20:
        Editor r104 = new Editor(this, r102, r103);     // Catch: Throwable -> L25
        Entry.access$702(r102, r104);     // Catch: Throwable -> L25
        this.journalWriter.write("DIRTY " + r100 + '\n');     // Catch: Throwable -> L25
        this.journalWriter.flush();     // Catch: Throwable -> L25
        monitor-exit(this);
        return r104;
    L17:
        if (Entry.access$700(r102) == null) goto L20;
        monitor-exit(this);
        return null;
    L24:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r100 + "\"");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Editor access$1600(DiskLruCache r100, String r101, long r102) throws IOException {
        return r100.edit(r101, r102);
    }

    public static /* synthetic */ void access$2200(DiskLruCache r100, Editor r101, boolean r102) throws IOException {
        r100.completeEdit(r101, r102);
    }

    private static void renameTo(File r100, File r101, boolean r102) throws IOException {
        if (r102 == false) goto L5;
        deleteIfExists(r101);
    L5:
        if (r100.renameTo(r101) == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    private DiskLruCache(File r100, int r101, int r102, long r110) {
        this.size = 0;
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.nextSequenceNumber = 0;
        this.executorService = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("/DiskLruCache"));
        this.cleanupCallable = new AnonymousClass1(this);
        this.directory = r100;
        this.appVersion = r101;
        this.journalFile = new PolarisFileWrapper(r100, JOURNAL_FILE);
        this.journalFileTmp = new PolarisFileWrapper(r100, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new PolarisFileWrapper(r100, JOURNAL_FILE_BACKUP);
        this.valueCount = r102;
        this.maxSize = r110;
    }

    public static synchronized DiskLruCache open(File r100, int r110, int r111, long r112, IAllowListRule r113) throws IOException {
        monitor-enter(DiskLruCache.class);
        if (r112 <= 0) goto L28;
        if (r111 <= 0) goto L26;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100, JOURNAL_FILE_BACKUP);     // Catch: Throwable -> L29
        if (r101.exists() == false) goto L13;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100, JOURNAL_FILE);     // Catch: Throwable -> L29
        if (r102.exists() == false) goto L12;
        r101.delete();     // Catch: Throwable -> L29
        goto L13
    L12:
        renameTo(r101, r102, false);     // Catch: Throwable -> L29
    L13:
        DiskLruCache r103 = new DiskLruCache(r100, r110, r111, r112);     // Catch: Throwable -> L29
        if (r103.journalFile.exists() == true) goto L32;
    L20:
        r100.mkdirs();     // Catch: Throwable -> L29
        DiskLruCache r104 = new DiskLruCache(r100, r110, r111, r112);     // Catch: Throwable -> L29
        r104.rebuildJournal();     // Catch: Throwable -> L29
        if (r113 == null) goto L23;
        r104.mAllowKeyRule = r113;     // Catch: Throwable -> L29
    L23:
        monitor-exit(DiskLruCache.class);
        return r104;
    L32:
        r103.readJournal();     // Catch: IOException -> L18 Throwable -> L29
        r103.processJournal();     // Catch: IOException -> L18 Throwable -> L29
        monitor-exit(DiskLruCache.class);
        return r103;
    L18:
        e = move-exception;
        System.out.println("DiskLruCache " + r100 + " is corrupt: " + e.getMessage() + ", removing");     // Catch: Throwable -> L29
        r103.delete();     // Catch: Throwable -> L29
        goto L20
    L26:
        throw new IllegalArgumentException("valueCount <= 0");     // Catch: Throwable -> L29
    L28:
        throw new IllegalArgumentException("maxSize <= 0");     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }
}
