package com.bytedance.mira.core;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.IOUtils;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.mira.util.XmlUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.bduploader.UploadKeys;
import el9.a;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes21.dex */
public class SharedPreferencesImpl implements SharedPreferences {
    private static final String TAG = "SharedPreferencesImpl";
    private static final Object mContent = null;
    private final File mBackupFile;
    private int mDiskWritesInFlight;
    private final File mFile;
    private final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Object> mListeners;
    private boolean mLoaded;
    private Map<String, Object> mMap;
    private final int mMode;
    private long mStatSize;
    private long mStatTimestamp;
    private final Object mWritingToDiskLock;

    public final class EditorImpl implements SharedPreferences.Editor {
        private boolean mClear;
        private final Map<String, Object> mModified;
        final /* synthetic */ SharedPreferencesImpl this$0;

        @Override // com.bytedance.mira.core.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            monitor-enter(this);
            this.mClear = true;     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        private MemoryCommitResult commitToMemory() {
            MemoryCommitResult r100 = new MemoryCommitResult(null);
            SharedPreferencesImpl r101 = this.this$0;
            monitor-enter(r101);
        L47:
            th = move-exception;
            throw th;
        L5:
            if (SharedPreferencesImpl.access$300(this.this$0) <= 0) goto L7;
            SharedPreferencesImpl.access$402(this.this$0, new HashMap(SharedPreferencesImpl.access$400(this.this$0)));     // Catch: Throwable -> L47
        L7:
            r100.mapToWriteToDisk = SharedPreferencesImpl.access$400(this.this$0);     // Catch: Throwable -> L47
            SharedPreferencesImpl.access$308(this.this$0);     // Catch: Throwable -> L47
            if (SharedPreferencesImpl.access$500(this.this$0).size() <= 0) goto L10;
            boolean r102 = true;
        L11:
            if (r102 == false) goto L13;
            r100.keysModified = new ArrayList();     // Catch: Throwable -> L47
            r100.listeners = new HashSet(SharedPreferencesImpl.access$500(this.this$0).keySet());     // Catch: Throwable -> L47
        L13:
            monitor-enter(this);     // Catch: Throwable -> L47
        L44:
            th = move-exception;
            throw th;     // Catch: Throwable -> L47
        L15:
            if (this.mClear == true) goto L17;
        L20:
            Iterator<Map.Entry<String, Object>> r103 = this.mModified.entrySet().iterator();     // Catch: Throwable -> L44
        L22:
            if (r103.hasNext() == false) goto L40;
            Map.Entry<String, Object> r104 = r103.next();     // Catch: Throwable -> L44
            String r105 = r104.getKey();     // Catch: Throwable -> L44
            Object r106 = r104.getValue();     // Catch: Throwable -> L44
            if (r106 == this) goto L26;
            if (SharedPreferencesImpl.access$400(this.this$0).containsKey(r105) == false) goto L36;
            Object r107 = SharedPreferencesImpl.access$400(this.this$0).get(r105);     // Catch: Throwable -> L44
            if (r107 == null) goto L36;
            if (r107.equals(r106) == true) goto L22;
        L36:
            SharedPreferencesImpl.access$400(this.this$0).put(r105, r106);     // Catch: Throwable -> L44
        L37:
            r100.changesMade = true;     // Catch: Throwable -> L44
            if (r102 == false) goto L22;
            r100.keysModified.add(r105);     // Catch: Throwable -> L44
            goto L22
        L26:
            if (SharedPreferencesImpl.access$400(this.this$0).containsKey(r105) == false) goto L22;
            SharedPreferencesImpl.access$400(this.this$0).remove(r105);     // Catch: Throwable -> L44
            goto L37
        L40:
            this.mModified.clear();     // Catch: Throwable -> L44
            monitor-exit(this);     // Catch: Throwable -> L44
            monitor-exit(r101);     // Catch: Throwable -> L47
            return r100;
        L17:
            if (SharedPreferencesImpl.access$400(this.this$0).isEmpty() == true) goto L19;
            r100.changesMade = true;     // Catch: Throwable -> L44
            SharedPreferencesImpl.access$400(this.this$0).clear();     // Catch: Throwable -> L44
        L19:
            this.mClear = false;     // Catch: Throwable -> L44
            goto L20
        L10:
            r102 = false;
            goto L11
        }

        @Override // com.bytedance.mira.core.SharedPreferences.Editor
        public void apply() {
            final MemoryCommitResult r100 = commitToMemory();
            final Runnable r101 = new AnonymousClass1(this, r100);
            QueuedWork.add(r101);
            Runnable r102 = new AnonymousClass2(this, r101);
            SharedPreferencesImpl.access$100(this.this$0, r100, r102);
            notifyListeners(r100);
        }

        @Override // com.bytedance.mira.core.SharedPreferences.Editor
        public boolean commit() {
            MemoryCommitResult r100 = commitToMemory();
            SharedPreferencesImpl.access$100(this.this$0, r100, null);
            r100.writtenToDiskLatch.await();     // Catch: InterruptedException -> L6
            notifyListeners(r100);
            return r100.writeToDiskResult;
        L6:
            return false;
        }

        public EditorImpl(SharedPreferencesImpl r100) {
            this.this$0 = r100;
            this.mModified = new HashMap();
            this.mClear = false;
        }

        private void notifyListeners(final MemoryCommitResult r100) {
            if (r100.listeners == null) goto L28;
            List<String> r101 = r100.keysModified;
            if (r101 != null) goto L7;
            return;
        L7:
            if (r101.size() != 0) goto L10;
            return;
        L10:
            if (Looper.myLooper() != Looper.getMainLooper()) goto L20;
            int r102 = r100.keysModified.size() - 1;
        L12:
            if (r102 < 0) goto L31;
            String r103 = (String) ListProtector.get(r100.keysModified, r102);
            Iterator<SharedPreferences.OnSharedPreferenceChangeListener> r104 = r100.listeners.iterator();
        L15:
            if (r104.hasNext() == false) goto L19;
            SharedPreferences.OnSharedPreferenceChangeListener r105 = r104.next();
            if (r105 == null) goto L15;
            r105.onSharedPreferenceChanged(this.this$0, r103);
            goto L15
        L19:
            r102 = r102 - 1;
            goto L12
        L31:
            return;
        L20:
            new Handler(Looper.getMainLooper()).post(new AnonymousClass3(this, r100));
            return;
        }

        @Override // com.bytedance.mira.core.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String r100) {
            monitor-enter(this);
            this.mModified.put(r100, this);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return this;
        L6:
            th = move-exception;
            throw th;
        }

        public static /* synthetic */ void access$600(EditorImpl r100, MemoryCommitResult r101) {
            r100.notifyListeners(r101);
        }

        @Override // com.bytedance.mira.core.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String r100, boolean r101) {
            monitor-enter(this);
            this.mModified.put(r100, Boolean.valueOf(r101));     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return this;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.core.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String r100, float r101) {
            monitor-enter(this);
            this.mModified.put(r100, Float.valueOf(r101));     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return this;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.core.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String r100, int r101) {
            monitor-enter(this);
            this.mModified.put(r100, Integer.valueOf(r101));     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return this;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.core.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String r100, long r101) {
            monitor-enter(this);
            this.mModified.put(r100, Long.valueOf(r101));     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return this;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.core.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String r100, String r101) {
            monitor-enter(this);
            this.mModified.put(r100, r101);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return this;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.core.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String r100, Set<String> r101) {
            monitor-enter(this);
            Map<String, Object> r102 = this.mModified;     // Catch: Throwable -> L10
            if (r101 != null) goto L6;
            HashSet r103 = null;
        L7:
            r102.put(r100, r103);     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return this;
        L6:
            r103 = new HashSet(r101);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }
    }

    public static class MemoryCommitResult {
        public boolean changesMade;
        public List<String> keysModified;
        public Set<SharedPreferences.OnSharedPreferenceChangeListener> listeners;
        public Map<?, ?> mapToWriteToDisk;
        public volatile boolean writeToDiskResult;
        public final CountDownLatch writtenToDiskLatch;

        private MemoryCommitResult() {
            this.writtenToDiskLatch = new CountDownLatch(1);
            this.writeToDiskResult = false;
        }

        public /* synthetic */ MemoryCommitResult(AnonymousClass1 r100) {
            this();
        }

        public void setDiskWriteResult(boolean r100) {
            this.writeToDiskResult = r100;
            this.writtenToDiskLatch.countDown();
        }
    }

    public static class QueuedWork {
        private static final ConcurrentLinkedQueue<Runnable> sPendingWorkFinishers = null;
        private static ExecutorService sSingleThreadExecutor;

        private QueuedWork() {
        }

        static {
            sPendingWorkFinishers = new ConcurrentLinkedQueue();
            sSingleThreadExecutor = null;
        }

        public static boolean hasPendingWork() {
            return !sPendingWorkFinishers.isEmpty();
        }

        public static ExecutorService singleThreadExecutor() {
            monitor-enter(QueuedWork.class);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (sSingleThreadExecutor != null) goto L7;
            sSingleThreadExecutor = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("SharedPreferencesImpl$QueuedWork"));     // Catch: Throwable -> L10
        L7:
            ExecutorService r100 = sSingleThreadExecutor;     // Catch: Throwable -> L10
            monitor-exit(QueuedWork.class);     // Catch: Throwable -> L10
            return r100;
        }

        public static void waitToFinish() {
        L2:
            Runnable r100 = sPendingWorkFinishers.poll();
            if (r100 == null) goto L5;
            r100.run();
            goto L2
        }

        public static void add(Runnable r100) {
            sPendingWorkFinishers.add(r100);
        }

        public static void remove(Runnable r100) {
            sPendingWorkFinishers.remove(r100);
        }
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private boolean hasFileChangedUnexpectedly() {
        monitor-enter(this);
        boolean r100 = false;
        if (this.mDiskWritesInFlight <= 0) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L19
        return false;
    L7:
        monitor-exit(this);     // Catch: Throwable -> L19
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L10:
        if (this.mStatTimestamp == this.mFile.lastModified()) goto L12;
    L13:
        r100 = true;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return r100;
    L12:
        if (this.mStatSize == this.mFile.length()) goto L14;
    L19:
        th = move-exception;
        throw th;
    }

    private void startLoadFromDisk() {
        monitor-enter(this);
        this.mLoaded = false;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        final String r100 = "SharedPreferencesImpl-load";
        ThreadMethodProxy.start(new AnonymousClass1(this, r100));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.mira.core.SharedPreferences
    public SharedPreferences.Editor edit() {
        monitor-enter(this);
        awaitLoadedLocked();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return new EditorImpl(this);
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.mira.core.SharedPreferences
    public Map<String, ?> getAll() {
        monitor-enter(this);
        awaitLoadedLocked();     // Catch: Throwable -> L6
        HashMap r100 = new HashMap(this.mMap);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public void startReloadIfChangedUnexpectedly() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (hasFileChangedUnexpectedly() == true) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        startLoadFromDisk();     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    static {
        mContent = new Object();
    }

    private void awaitLoadedLocked() {
    L3:
        if (this.mLoaded == true) goto L7;
        wait();     // Catch: InterruptedException -> L6
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v4 */
    private void loadFromDiskLocked() {
        if (this.mLoaded == false) goto L6;
        return;
    L6:
        if (this.mBackupFile.exists() == false) goto L8;
        this.mFile.delete();
        this.mBackupFile.renameTo(this.mFile);
    L8:
        HashMap r100 = null;
        ?? r101 = this.mFile.canRead();     // Catch: Exception -> L36
        if (r101 == 0) goto L37;
        BufferedInputStream r102 = new BufferedInputStream(new PolarisFileInputStreamWrapper(this.mFile), 16384);     // Catch: Throwable -> L21 IOException -> L23 FileNotFoundException -> L26 XmlPullParserException -> L29
        r100 = XmlUtils.readMapXml(r102);     // Catch: IOException -> L15 FileNotFoundException -> L17 XmlPullParserException -> L19 Throwable -> L33
        r101 = r102;
    L13:
        IOUtils.closeSilently(r101);     // Catch: Exception -> L36
        goto L37
    L17:
        e = e;
    L28:
        MiraLogger.e(MiraLogger.TAG, "SharedPreferencesImpl getSharedPreferences", e);     // Catch: Throwable -> L33
        r101 = r102;
    L15:
        e = e;
    L25:
        MiraLogger.e(MiraLogger.TAG, "SharedPreferencesImpl getSharedPreferences", e);     // Catch: Throwable -> L33
        r101 = r102;
    L19:
        e = e;
    L31:
        MiraLogger.e(MiraLogger.TAG, "SharedPreferencesImpl getSharedPreferences", e);     // Catch: Throwable -> L33
        r101 = r102;
        goto L13
    L26:
        e = e;
        r102 = null;
    L23:
        e = e;
        r102 = null;
    L29:
        e = e;
        r102 = null;
    L21:
        th = th;
        r101 = 0;
    L34:
        IOUtils.closeSilently(r101);     // Catch: Exception -> L36
        throw th;     // Catch: Exception -> L36
    L33:
        th = th;
    L37:
        this.mLoaded = true;
        if (r100 == null) goto L40;
        this.mMap = r100;
        this.mStatTimestamp = this.mFile.lastModified();
        this.mStatSize = this.mFile.length();
    L41:
        notifyAll();
        return;
    L40:
        this.mMap = new HashMap();
        goto L41
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_core_SharedPreferencesImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static /* synthetic */ void access$000(SharedPreferencesImpl r100) {
        r100.loadFromDiskLocked();
    }

    public static /* synthetic */ int access$300(SharedPreferencesImpl r100) {
        return r100.mDiskWritesInFlight;
    }

    public static /* synthetic */ int access$308(SharedPreferencesImpl r100) {
        int r101 = r100.mDiskWritesInFlight;
        r100.mDiskWritesInFlight = r101 + 1;
        return r101;
    }

    public static /* synthetic */ int access$310(SharedPreferencesImpl r100) {
        int r101 = r100.mDiskWritesInFlight;
        r100.mDiskWritesInFlight = r101 - 1;
        return r101;
    }

    public static /* synthetic */ Map access$400(SharedPreferencesImpl r100) {
        return r100.mMap;
    }

    public static /* synthetic */ WeakHashMap access$500(SharedPreferencesImpl r100) {
        return r100.mListeners;
    }

    public static /* synthetic */ Object access$700(SharedPreferencesImpl r100) {
        return r100.mWritingToDiskLock;
    }

    private static FileOutputStream createFileOutputStream(File r100) {
        return new PolarisFileOutputStreamWrapper(r100);
    L5:
        if (r100.getParentFile().mkdir() == true) goto L11;
        return null;
    L11:
        return new PolarisFileOutputStreamWrapper(r100);
    L10:
        return null;
    }

    private static File makeBackupFile(File r100) {
        return new PolarisFileWrapper(r100.getPath() + ".bak");
    }

    private void writeToFile(MemoryCommitResult r100) {
        if (this.mFile.exists() == true) goto L5;
    L41:
        FileOutputStream r101 = createFileOutputStream(this.mFile);     // Catch: Exception -> L35
        if (r101 != null) goto L19;
        r100.setDiskWriteResult(false);     // Catch: Exception -> L35
        return;
    L19:
        XmlUtils.writeMapXml(r100.mapToWriteToDisk, r101);     // Catch: Exception -> L35
        r101.flush();     // Catch: Exception -> L35
        r101.close();     // Catch: Exception -> L35
        int r102 = this.mMode;     // Catch: Exception -> L35
        if ((r102 & 1) == 0) goto L22;
        int r103 = UploadKeys.KeyIsEstimatedVideoInfo;
    L24:
        if ((r102 & 2) == 0) goto L26;
        r103 = r103 | 2;     // Catch: Exception -> L35
    L26:
        setPermissions(this.mFile.getPath(), r103);     // Catch: Exception -> L35
        monitor-enter(this);     // Catch: Exception -> L35
        this.mStatTimestamp = this.mFile.lastModified();     // Catch: Throwable -> L32
        this.mStatSize = this.mFile.length();     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        this.mBackupFile.delete();     // Catch: Exception -> L35
        r100.setDiskWriteResult(true);     // Catch: Exception -> L35
        return;
    L32:
        th = move-exception;
        throw th;     // Catch: Exception -> L35
    L22:
        r103 = 432;
    L35:
        e = move-exception;
        e.printStackTrace();
        if (this.mFile.exists() == false) goto L39;
        this.mFile.delete();
    L39:
        r100.setDiskWriteResult(false);
        return;
    L5:
        if (r100.changesMade == true) goto L9;
        r100.setDiskWriteResult(true);
        return;
    L9:
        if (this.mBackupFile.exists() == false) goto L11;
        this.mFile.delete();
        goto L41
    L11:
        if (this.mFile.renameTo(this.mBackupFile) == true) goto L41;
        r100.setDiskWriteResult(false);
    }

    @Override // com.bytedance.mira.core.SharedPreferences
    public boolean contains(String r100) {
        monitor-enter(this);
        awaitLoadedLocked();     // Catch: Throwable -> L6
        boolean r101 = this.mMap.containsKey(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.mira.core.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
        monitor-enter(this);
        this.mListeners.put(r100, mContent);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.mira.core.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
        monitor-enter(this);
        this.mListeners.remove(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public SharedPreferencesImpl(File r100, int r101) {
        this.mDiskWritesInFlight = 0;
        this.mLoaded = false;
        this.mWritingToDiskLock = new Object();
        this.mListeners = new WeakHashMap();
        this.mFile = r100;
        this.mBackupFile = makeBackupFile(r100);
        this.mMode = r101;
        this.mLoaded = false;
        this.mMap = null;
        startLoadFromDisk();
    }

    public static /* synthetic */ Map access$402(SharedPreferencesImpl r100, Map r101) {
        r100.mMap = r101;
        return r101;
    }

    public static /* synthetic */ void access$800(SharedPreferencesImpl r100, MemoryCommitResult r101) {
        r100.writeToFile(r101);
    }

    private void enqueueDiskWrite(final MemoryCommitResult r100, final Runnable r101) {
        Runnable r102 = new AnonymousClass2(this, r100, r101);
        boolean r103 = false;
        if (r101 != null) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L18;
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L9:
        if (this.mDiskWritesInFlight != 1) goto L11;
        r103 = true;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r103 == false) goto L18;
        r102.run();
        return;
    L18:
        QueuedWork.singleThreadExecutor().execute(r102);
        return;
    L5:
        r104 = false;
        goto L6
    }

    private void setPermissions(String r100, int r110) {
        Object r101 = FieldUtils.readStaticField(INVOKESTATIC_com_bytedance_mira_core_SharedPreferencesImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("libcore.io.Libcore"), "os");     // Catch: Exception -> L6
        Method r102 = MethodUtils.getAccessibleMethod(r101.getClass(), "chmod", new Class[]{String.class, Integer.TYPE});     // Catch: Exception -> L6
        if (r102 == null) goto L11;
        r102.invoke(r101, new Object[]{r100, Integer.valueOf(r110)});     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.mira.core.SharedPreferences
    public boolean getBoolean(String r100, boolean r101) {
        monitor-enter(this);
        awaitLoadedLocked();     // Catch: Throwable -> L8
        Boolean r102 = (Boolean) this.mMap.get(r100);     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        r101 = r102.booleanValue();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.mira.core.SharedPreferences
    public float getFloat(String r100, float r101) {
        monitor-enter(this);
        awaitLoadedLocked();     // Catch: Throwable -> L8
        Float r102 = (Float) this.mMap.get(r100);     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        r101 = r102.floatValue();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.mira.core.SharedPreferences
    public int getInt(String r100, int r101) {
        monitor-enter(this);
        awaitLoadedLocked();     // Catch: Throwable -> L8
        Integer r102 = (Integer) this.mMap.get(r100);     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        r101 = r102.intValue();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.mira.core.SharedPreferences
    public long getLong(String r100, long r101) {
        monitor-enter(this);
        awaitLoadedLocked();     // Catch: Throwable -> L8
        Long r102 = (Long) this.mMap.get(r100);     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        r101 = r102.longValue();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.mira.core.SharedPreferences
    public String getString(String r100, String r101) {
        monitor-enter(this);
        awaitLoadedLocked();     // Catch: Throwable -> L8
        String r102 = (String) this.mMap.get(r100);     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        r101 = r102;
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.mira.core.SharedPreferences
    public Set<String> getStringSet(String r100, Set<String> r101) {
        monitor-enter(this);
        awaitLoadedLocked();     // Catch: Throwable -> L8
        Set<String> r102 = (Set) this.mMap.get(r100);     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        r101 = r102;
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$100(SharedPreferencesImpl r100, MemoryCommitResult r101, Runnable r102) {
        r100.enqueueDiskWrite(r101, r102);
    }
}
