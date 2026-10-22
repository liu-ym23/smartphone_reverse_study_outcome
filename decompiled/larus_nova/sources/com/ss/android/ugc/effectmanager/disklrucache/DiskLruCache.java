package com.ss.android.ugc.effectmanager.disklrucache;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
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
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes40.dex */
public final class DiskLruCache implements Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = null;
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final OutputStream NULL_OUTPUT_STREAM = null;
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String STRING_KEY_PATTERN = "[a-z0-9_-]{1,120}";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable<Void> cleanupCallable;
    private boolean closed;
    private final File directory;
    final ExecutorService executorService;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
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
                Editor.access$2402(this.this$1, true);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                ((FilterOutputStream) this).out.flush();     // Catch: IOException -> L4
                return;
            L4:
                Editor.access$2402(this.this$1, true);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int r100) {
                ((FilterOutputStream) this).out.write(r100);     // Catch: IOException -> L4
                return;
            L4:
                Editor.access$2402(this.this$1, true);
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
                Editor.access$2402(this.this$1, true);
            }
        }

        public void abort() throws IOException {
            DiskLruCache.access$2300(this.this$0, this, false);
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
            DiskLruCache.access$2300(this.this$0, this, false);
            this.this$0.remove(Entry.access$1200(this.entry));
        L6:
            this.committed = true;
            return;
        L5:
            DiskLruCache.access$2300(this.this$0, this, true);
            goto L6
        }

        public static /* synthetic */ Entry access$1500(Editor r100) {
            return r100.entry;
        }

        public static /* synthetic */ boolean[] access$1600(Editor r100) {
            return r100.written;
        }

        public String getString(int r100) throws IOException {
            InputStream r101 = newInputStream(r100);
            if (r101 != null) goto L7;
            return null;
        L7:
            return DiskLruCache.access$1800(r101);
        }

        public InputStream newInputStream(int r100) throws IOException {
            DiskLruCache r101 = this.this$0;
            monitor-enter(r101);
        L17:
            th = move-exception;
            throw th;
        L5:
            if (Entry.access$800(this.entry) != this) goto L16;
            if (Entry.access$700(this.entry) == true) goto L20;
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
            if (r100 >= DiskLruCache.access$1900(this.this$0)) goto L29;
            DiskLruCache r101 = this.this$0;
            monitor-enter(r101);
        L25:
            th = move-exception;
            throw th;
        L8:
            if (Entry.access$800(this.entry) != this) goto L24;
            if (Entry.access$700(this.entry) == true) goto L12;
            this.written[r100] = true;     // Catch: Throwable -> L25
        L12:
            File r102 = this.entry.getDirtyFile(r100);     // Catch: Throwable -> L25
            PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r102);     // Catch: FileNotFoundException -> L15 Throwable -> L25
        L17:
            FaultHidingOutputStream r104 = new FaultHidingOutputStream(this, r103, null);     // Catch: Throwable -> L25
            monitor-exit(r101);     // Catch: Throwable -> L25
            return r104;
        L15:
            DiskLruCache.access$2000(this.this$0).mkdirs();     // Catch: Throwable -> L25
            r103 = new PolarisFileOutputStreamWrapper(r102);     // Catch: FileNotFoundException -> L20 Throwable -> L25
        L22:
            return DiskLruCache.access$2100();
        L24:
            throw new IllegalStateException();     // Catch: Throwable -> L25
        L29:
            throw new IllegalArgumentException("Expected index " + r100 + " to be greater than 0 and less than the maximum value count of " + DiskLruCache.access$1900(this.this$0));
        }

        private Editor(DiskLruCache r100, Entry r101) {
            this.this$0 = r100;
            this.entry = r101;
            if (Entry.access$700(r101) == false) goto L5;
            boolean[] r102 = null;
        L6:
            this.written = r102;
            return;
        L5:
            r102 = new boolean[DiskLruCache.access$1900(r100)];
            goto L6
        }

        public static /* synthetic */ boolean access$2402(Editor r100, boolean r101) {
            r100.hasErrors = r101;
            return r101;
        }

        public void set(int r100, String r101) throws IOException {
            OutputStreamWriter r102 = null;
            OutputStreamWriter r103 = new OutputStreamWriter(newOutputStream(r100), Util.UTF_8);     // Catch: Throwable -> L9
            r103.write(r101);     // Catch: Throwable -> L7
            Util.closeQuietly(r103);
            return;
        L7:
            th = th;
            r102 = r103;
        L10:
            Util.closeQuietly(r102);
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

        public static /* synthetic */ long[] access$1100(Entry r100) {
            return r100.lengths;
        }

        public static /* synthetic */ String access$1200(Entry r100) {
            return r100.key;
        }

        public static /* synthetic */ long access$1300(Entry r100) {
            return r100.sequenceNumber;
        }

        public static /* synthetic */ boolean access$700(Entry r100) {
            return r100.readable;
        }

        public static /* synthetic */ Editor access$800(Entry r100) {
            return r100.currentEditor;
        }

        private IOException invalidLengths(String[] r100) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(r100));
        }

        private void setLengths(String[] r100) throws IOException {
            if (r100.length != DiskLruCache.access$1900(this.this$0)) goto L13;
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
            return new PolarisFileWrapper(DiskLruCache.access$2000(this.this$0), this.key);
        L6:
            return new PolarisFileWrapper(DiskLruCache.access$2000(this.this$0), this.key + "." + r100);
        }

        public File getDirtyFile(int r100) {
            if (r100 != 0) goto L7;
            return new PolarisFileWrapper(DiskLruCache.access$2000(this.this$0), this.key + DefaultDiskStorage.FileType.TEMP);
        L7:
            return new PolarisFileWrapper(DiskLruCache.access$2000(this.this$0), this.key + "." + r100 + DefaultDiskStorage.FileType.TEMP);
        }

        private Entry(DiskLruCache r100, String r101) {
            this.this$0 = r100;
            this.key = r101;
            this.lengths = new long[DiskLruCache.access$1900(r100)];
        }

        public static /* synthetic */ long access$1302(Entry r100, long r101) {
            r100.sequenceNumber = r101;
            return r101;
        }

        public static /* synthetic */ boolean access$702(Entry r100, boolean r101) {
            r100.readable = r101;
            return r101;
        }

        public static /* synthetic */ Editor access$802(Entry r100, Editor r101) {
            r100.currentEditor = r101;
            return r101;
        }

        public static /* synthetic */ void access$900(Entry r100, String[] r101) throws IOException {
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
            Util.closeQuietly(r100[r102]);
            r102 = r102 + 1;
            goto L3
        }

        public Editor edit() throws IOException {
            return DiskLruCache.access$1700(this.this$0, this.key, this.sequenceNumber);
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
            return DiskLruCache.access$1800(getInputStream(r100));
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
        Writer r100 = this.journalWriter;     // Catch: Throwable -> L27
        if (r100 == null) goto L30;
        r100.close();     // Catch: Throwable -> L27
    L30:
        PolarisFileOutputStreamWrapper r101 = new PolarisFileOutputStreamWrapper(this.journalFileTmp);     // Catch: FileNotFoundException -> L8 Throwable -> L27
    L9:
        BufferedWriter r102 = new BufferedWriter(new OutputStreamWriter(r101, Util.US_ASCII));     // Catch: Throwable -> L27
        r102.write(MAGIC);     // Catch: Throwable -> L24
        r102.write("\n");     // Catch: Throwable -> L24
        r102.write("1");     // Catch: Throwable -> L24
        r102.write("\n");     // Catch: Throwable -> L24
        r102.write(Integer.toString(this.appVersion));     // Catch: Throwable -> L24
        r102.write("\n");     // Catch: Throwable -> L24
        r102.write(Integer.toString(this.valueCount));     // Catch: Throwable -> L24
        r102.write("\n");     // Catch: Throwable -> L24
        r102.write("\n");     // Catch: Throwable -> L24
        Iterator<Entry> r103 = this.lruEntries.values().iterator();     // Catch: Throwable -> L24
    L11:
        if (r103.hasNext() == false) goto L18;
        Entry r104 = r103.next();     // Catch: Throwable -> L24
        if (Entry.access$800(r104) != null) goto L15;
        r102.write("CLEAN " + Entry.access$1200(r104) + r104.getLengths() + '\n');     // Catch: Throwable -> L24
        goto L11
    L15:
        r102.write("DIRTY " + Entry.access$1200(r104) + '\n');     // Catch: Throwable -> L24
        goto L11
    L18:
        r102.close();     // Catch: Throwable -> L27
        if (this.journalFile.exists() == false) goto L21;
        renameTo(this.journalFile, this.journalFileBackup, true);     // Catch: Throwable -> L27
    L21:
        renameTo(this.journalFileTmp, this.journalFile, false);     // Catch: Throwable -> L27
        this.journalFileBackup.delete();     // Catch: Throwable -> L27
        this.journalWriter = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.journalFile, true), Util.US_ASCII));     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L8:
        this.journalFileTmp.getParentFile().mkdirs();     // Catch: Throwable -> L27
        r101 = new PolarisFileOutputStreamWrapper(this.journalFileTmp);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    private synchronized void trimToSize() throws IOException {
        monitor-enter(this);
    L12:
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.size <= this.maxSize) goto L7;
        remove(this.lruEntries.entrySet().iterator().next().getKey());     // Catch: Throwable -> L9
        goto L12
    L7:
        monitor-exit(this);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.initialized == true) goto L6;
    L17:
        this.closed = true;     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L6:
        if (this.closed == true) goto L17;
        Iterator r100 = new ArrayList(this.lruEntries.values()).iterator();     // Catch: Throwable -> L20
    L10:
        if (r100.hasNext() == false) goto L14;
        Entry r101 = (Entry) r100.next();     // Catch: Throwable -> L20
        if (Entry.access$800(r101) == null) goto L10;
        Entry.access$800(r101).abort();     // Catch: Throwable -> L20
        goto L10
    L14:
        trimToSize();     // Catch: Throwable -> L20
        this.journalWriter.close();     // Catch: Throwable -> L20
        this.journalWriter = null;     // Catch: Throwable -> L20
        this.closed = true;     // Catch: Throwable -> L20
        monitor-exit(this);
    }

    public synchronized void flush() throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.initialized == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        checkNotClosed();     // Catch: Throwable -> L10
        trimToSize();     // Catch: Throwable -> L10
        this.journalWriter.flush();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public Set<String> getLruEntryKeys() throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L6
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
        boolean r100 = this.closed;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long size() throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L6
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
        if (Entry.access$800(r101) == null) goto L8;
        Entry.access$802(r101, null);
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
        this.size += Entry.access$1100(r101)[r102];
        r102 = r102 + 1;
        goto L8
    }

    private void readJournal() throws IOException {
        StrictLineReader r100 = new StrictLineReader(new PolarisFileInputStreamWrapper(this.journalFile), Util.US_ASCII);
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
    L27:
        readJournalLine(r100.readLine());     // Catch: EOFException -> L16 Throwable -> L24
        r106 = r106 + 1;
        goto L27
    L16:
        this.redundantOpCount = r106 - this.lruEntries.size();     // Catch: Throwable -> L24
        if (r100.hasUnterminatedLine() == false) goto L19;
        rebuildJournal();     // Catch: Throwable -> L24
    L20:
        Util.closeQuietly(r100);
        return;
    L19:
        this.journalWriter = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.journalFile, true), Util.US_ASCII));     // Catch: Throwable -> L24
    L23:
        throw new IOException("unexpected journal header: [" + r101 + ", " + r102 + ", " + r104 + ", " + r105 + "]");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Util.closeQuietly(r100);
        throw th;
    }

    public synchronized void initialize() throws IOException {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L5:
        if (this.initialized == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (this.journalFileBackup.exists() == false) goto L22;
        if (this.journalFile.exists() == true) goto L13;
        renameTo(this.journalFileBackup, this.journalFile, false);     // Catch: Throwable -> L36
        goto L22
    L13:
        if (this.journalFileBackup.delete() == false) goto L22;
        if (this.journalFileBackup.exists() == false) goto L22;
        throw new IOException("failed to delete " + this.journalFileBackup);     // Catch: Throwable -> L36
    L22:
        if (this.journalFile.exists() == true) goto L42;
    L33:
        rebuildJournal();     // Catch: Throwable -> L36
        this.initialized = true;     // Catch: Throwable -> L36
        monitor-exit(this);
        return;
    L42:
        readJournal();     // Catch: IOException -> L26 Throwable -> L36
        processJournal();     // Catch: IOException -> L26 Throwable -> L36
        this.initialized = true;     // Catch: IOException -> L26 Throwable -> L36
        monitor-exit(this);
        return;
    L26:
        e = move-exception;
        System.out.println("DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing");     // Catch: Throwable -> L36
        delete();     // Catch: Throwable -> L30
        this.closed = false;     // Catch: Throwable -> L36
        goto L33
    L30:
        th = move-exception;
        this.closed = false;     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    }

    public boolean isValid() {
        File r100 = this.directory;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.exists() == false) goto L9;
        if (this.journalFile.exists() == false) goto L9;
        return true;
    }

    private void checkNotClosed() {
        if (isClosed() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    public void delete() throws IOException {
        close();
        Util.deleteContents(this.directory);
    }

    public static /* synthetic */ OutputStream access$2100() {
        return NULL_OUTPUT_STREAM;
    }

    public File getDirectory() {
        return this.directory;
    }

    public static /* synthetic */ boolean access$000(DiskLruCache r100) {
        return r100.initialized;
    }

    public static /* synthetic */ boolean access$100(DiskLruCache r100) {
        return r100.closed;
    }

    public static /* synthetic */ String access$1800(InputStream r100) throws IOException {
        return inputStreamToString(r100);
    }

    public static /* synthetic */ int access$1900(DiskLruCache r100) {
        return r100.valueCount;
    }

    public static /* synthetic */ void access$200(DiskLruCache r100) throws IOException {
        r100.trimToSize();
    }

    public static /* synthetic */ File access$2000(DiskLruCache r100) {
        return r100.directory;
    }

    public static /* synthetic */ boolean access$300(DiskLruCache r100) {
        return r100.journalRebuildRequired();
    }

    public static /* synthetic */ void access$400(DiskLruCache r100) throws IOException {
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
        return Util.readFully(new InputStreamReader(r100, Util.UTF_8));
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
        Entry.access$702(r105, true);
        Entry.access$802(r105, null);
        Entry.access$900(r105, r107);
        return;
    L22:
        if (r103 != (-1)) goto L27;
        if (r101 != 5) goto L27;
        if (r100.startsWith(DIRTY) == false) goto L27;
        Entry.access$802(r105, new Editor(this, r105, r106));
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

    private boolean validateKey(String r100) {
        return LEGAL_KEY_PATTERN.matcher(r100).matches();
    }

    public Editor edit(String r100) throws IOException {
        return edit(r100, -1);
    }

    public synchronized Snapshot get(String r110) throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L37
        checkNotClosed();     // Catch: Throwable -> L37
        if (validateKey(r110) == false) goto L35;
        Entry r100 = this.lruEntries.get(r110);     // Catch: Throwable -> L37
        if (r100 != null) goto L12;
        monitor-exit(this);
        return null;
    L12:
        if (Entry.access$700(r100) == true) goto L15;
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
        Snapshot r106 = new Snapshot(this, r110, Entry.access$1300(r100), r103, r102, Entry.access$1100(r100), null);     // Catch: Throwable -> L37
        monitor-exit(this);
        return r106;
    L28:
        if (r104 >= this.valueCount) goto L33;
        InputStream r111 = r102[r104];     // Catch: Throwable -> L37
        if (r111 == null) goto L33;
        Util.closeQuietly(r111);     // Catch: Throwable -> L37
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

    public synchronized boolean remove(String r110) throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L31
        checkNotClosed();     // Catch: Throwable -> L31
        if (validateKey(r110) == false) goto L30;
        Entry r100 = this.lruEntries.get(r110);     // Catch: Throwable -> L31
        int r101 = 0;
        if (r100 != null) goto L9;
    L27:
        monitor-exit(this);
        return false;
    L9:
        if (Entry.access$800(r100) != null) goto L27;
        this.redundantOpCount++;     // Catch: Throwable -> L31
        this.journalWriter.append("REMOVE " + r110 + '\n');     // Catch: Throwable -> L31
        this.journalWriter.flush();     // Catch: Throwable -> L31
        this.lruEntries.remove(r110);     // Catch: Throwable -> L31
    L13:
        if (r101 >= this.valueCount) goto L23;
        File r111 = r100.getCleanFile(r101);     // Catch: Throwable -> L31
        if (r111.exists() == false) goto L21;
        if (r111.delete() == true) goto L21;
        throw new IOException("failed to delete " + r111);     // Catch: Throwable -> L31
    L21:
        this.size -= Entry.access$1100(r100)[r101];     // Catch: Throwable -> L31
        Entry.access$1100(r100)[r101] = 0;     // Catch: Throwable -> L31
        r101 = r101 + 1;     // Catch: Throwable -> L31
        goto L13
    L23:
        if (journalRebuildRequired() == false) goto L25;
        this.executorService.submit(this.cleanupCallable);     // Catch: Throwable -> L31
    L25:
        monitor-exit(this);
        return true;
    L30:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r110 + "\"");     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public synchronized void setMaxSize(long r100) {
        monitor-enter(this);
        this.maxSize = r100;     // Catch: Throwable -> L8
        if (this.initialized == false) goto L6;
        this.executorService.submit(this.cleanupCallable);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ int access$502(DiskLruCache r100, int r101) {
        r100.redundantOpCount = r101;
        return r101;
    }

    private synchronized void completeEdit(Editor r110, boolean r111) throws IOException {
        monitor-enter(this);
        Entry r100 = Editor.access$1500(r110);     // Catch: Throwable -> L46
        if (Entry.access$800(r100) != r110) goto L45;
        int r101 = 0;
        if (r111 == false) goto L23;
        if (Entry.access$700(r100) == true) goto L23;
        int r102 = 0;
    L11:
        if (r102 >= this.valueCount) goto L23;
        if (Editor.access$1600(r110)[r102] == false) goto L20;
        if (r100.getDirtyFile(r102).exists() == false) goto L16;
        r102 = r102 + 1;
        goto L11
    L16:
        r110.abort();     // Catch: Throwable -> L46
        monitor-exit(this);
        return;
    L20:
        r110.abort();     // Catch: Throwable -> L46
        throw new IllegalStateException("Newly created entry didn't create value for index " + r102);     // Catch: Throwable -> L46
    L23:
        if (r101 >= this.valueCount) goto L31;
        File r112 = r100.getDirtyFile(r101);     // Catch: Throwable -> L46
        if (r111 == true) goto L27;
        deleteIfExists(r112);     // Catch: Throwable -> L46
    L30:
        r101 = r101 + 1;     // Catch: Throwable -> L46
        goto L23
    L27:
        if (r112.exists() == false) goto L30;
        File r103 = r100.getCleanFile(r101);     // Catch: Throwable -> L46
        r112.renameTo(r103);     // Catch: Throwable -> L46
        long r104 = Entry.access$1100(r100)[r101];     // Catch: Throwable -> L46
        long r105 = r103.length();     // Catch: Throwable -> L46
        Entry.access$1100(r100)[r101] = r105;     // Catch: Throwable -> L46
        this.size = (this.size - r104) + r105;     // Catch: Throwable -> L46
        goto L30
    L31:
        this.redundantOpCount++;     // Catch: Throwable -> L46
        Entry.access$802(r100, null);     // Catch: Throwable -> L46
        if ((Entry.access$700(r100) | r111) == false) goto L36;
        Entry.access$702(r100, true);     // Catch: Throwable -> L46
        this.journalWriter.write("CLEAN " + Entry.access$1200(r100) + r100.getLengths() + '\n');     // Catch: Throwable -> L46
        if (r111 == false) goto L37;
        long r113 = this.nextSequenceNumber;     // Catch: Throwable -> L46
        this.nextSequenceNumber = 1 + r113;     // Catch: Throwable -> L46
        Entry.access$1302(r100, r113);     // Catch: Throwable -> L46
    L37:
        this.journalWriter.flush();     // Catch: Throwable -> L46
        if (this.size <= this.maxSize) goto L40;
    L41:
        this.executorService.submit(this.cleanupCallable);     // Catch: Throwable -> L46
    L42:
        monitor-exit(this);
        return;
    L40:
        if (journalRebuildRequired() == false) goto L42;
    L36:
        this.lruEntries.remove(Entry.access$1200(r100));     // Catch: Throwable -> L46
        this.journalWriter.write("REMOVE " + Entry.access$1200(r100) + '\n');     // Catch: Throwable -> L46
        goto L37
    L45:
        throw new IllegalStateException();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }

    private synchronized Editor edit(String r100, long r101) throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L25
        checkNotClosed();     // Catch: Throwable -> L25
        validateKey(r100);     // Catch: Throwable -> L25
        if (validateKey(r100) == false) goto L24;
        Entry r102 = this.lruEntries.get(r100);     // Catch: Throwable -> L25
        AnonymousClass1 r103 = null;
        if (r101 == (-1)) goto L14;
        if (r102 != null) goto L11;
    L12:
        monitor-exit(this);
        return null;
    L11:
        if (Entry.access$1300(r102) != r101) goto L12;
    L14:
        if (r102 != null) goto L17;
        r102 = new Entry(this, r100, r103);     // Catch: Throwable -> L25
        this.lruEntries.put(r100, r102);     // Catch: Throwable -> L25
    L20:
        Editor r104 = new Editor(this, r102, r103);     // Catch: Throwable -> L25
        Entry.access$802(r102, r104);     // Catch: Throwable -> L25
        this.journalWriter.write("DIRTY " + r100 + '\n');     // Catch: Throwable -> L25
        this.journalWriter.flush();     // Catch: Throwable -> L25
        monitor-exit(this);
        return r104;
    L17:
        if (Entry.access$800(r102) == null) goto L20;
        monitor-exit(this);
        return null;
    L24:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r100 + "\"");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Editor access$1700(DiskLruCache r100, String r101, long r102) throws IOException {
        return r100.edit(r101, r102);
    }

    public static /* synthetic */ void access$2300(DiskLruCache r100, Editor r101, boolean r102) throws IOException {
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

    public static DiskLruCache open(File r100, int r110, int r111, long r112) throws IOException {
        if (r112 <= 0) goto L10;
        if (r111 <= 0) goto L8;
        return new DiskLruCache(r100, r110, r111, r112);
    L8:
        throw new IllegalArgumentException("valueCount <= 0");
    L10:
        throw new IllegalArgumentException("maxSize <= 0");
    }
}
