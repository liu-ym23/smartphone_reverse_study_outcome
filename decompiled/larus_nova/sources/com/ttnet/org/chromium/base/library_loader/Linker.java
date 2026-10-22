package com.ttnet.org.chromium.base.library_loader;

import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.larus.utils.logger.FLogger;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.StreamUtil;
import com.ttnet.org.chromium.base.TimeUtils;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
abstract class Linker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String BASE_LOAD_ADDRESS = "com.ttnet.org.chromium.base.android.linker.base_load_address";
    protected static final boolean DEBUG = false;
    protected static final String LINKER_JNI_LIBRARY = "chromium_android_linker";
    static final String SHARED_RELROS = "com.ttnet.org.chromium.base.android.linker.shared_relros";
    private static final String TAG = "Linker";
    private static Linker sLinkerForAssert;
    private static Natives sNativesInstance;
    private boolean mLinkerWasWaitingSynchronously;
    protected LibInfo mLocalLibInfo;
    protected final Object mLock;
    boolean mRelroProducer;
    protected LibInfo mRemoteLibInfo;
    protected int mState;
    WebViewReservationSearchResult mWebviewReservationSearchResult;

    public static class LibInfo implements Parcelable {
        public static final Parcelable.Creator<LibInfo> CREATOR = null;
        private static final String EXTRA_LINKER_LIB_INFO = "libinfo";
        public String mLibFilePath;
        public long mLoadAddress;
        public long mLoadSize;
        public int mRelroFd;
        public long mRelroSize;
        public long mRelroStart;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public void close() {
            int r100 = this.mRelroFd;
            if (r100 < 0) goto L6;
            StreamUtil.closeQuietly(ParcelFileDescriptor.adoptFd(r100));
            this.mRelroFd = -1;
            return;
        }

        public Bundle toBundle() {
            Bundle r100 = new Bundle();
            r100.putParcelable(EXTRA_LINKER_LIB_INFO, this);
            return r100;
        }

        public LibInfo() {
            this.mRelroFd = -1;
        }

        public LibInfo(Parcel r100) {
            this.mRelroFd = -1;
            this.mLibFilePath = r100.readString();
            this.mLoadAddress = r100.readLong();
            this.mLoadSize = r100.readLong();
            this.mRelroStart = r100.readLong();
            this.mRelroSize = r100.readLong();
            if (r100.readInt() == 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L10;
            ParcelFileDescriptor r102 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(r100);
            if (r102 == null) goto L12;
            this.mRelroFd = r102.detachFd();
            return;
        L12:
            return;
        L10:
            this.mRelroFd = -1;
            return;
        L5:
            r101 = false;
            goto L6
        }

        public static LibInfo fromBundle(Bundle r100) {
            r100.setClassLoader(Linker.class.getClassLoader());
            return (LibInfo) r100.getParcelable(EXTRA_LINKER_LIB_INFO);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.mLibFilePath);
            r100.writeLong(this.mLoadAddress);
            r100.writeLong(this.mLoadSize);
            r100.writeLong(this.mRelroStart);
            r100.writeLong(this.mRelroSize);
            if (this.mRelroFd < 0) goto L5;
            int r102 = 1;
        L6:
            r100.writeInt(r102);
            int r103 = this.mRelroFd;
            if (r103 < 0) goto L15;
            ParcelFileDescriptor r104 = ParcelFileDescriptor.fromFd(r103);     // Catch: IOException -> L10
            r104.writeToParcel(r100, 0);     // Catch: IOException -> L10
            r104.close();     // Catch: IOException -> L10
            return;
        L10:
            e = move-exception;
            Log.e(Linker.TAG, "Can't write LibInfo file descriptor to parcel", new Object[]{e});
            return;
        L15:
            return;
        L5:
            r102 = 0;
            goto L6
        }
    }

    public interface Natives {
        void findMemoryRegionAtRandomAddress(LibInfo r100, boolean r101);

        boolean findRegionReservedByWebViewZygote(LibInfo r100);

        void reserveMemoryForLibrary(LibInfo r100);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PreferAddress {
        public static final int FIND_RESERVED = 0;
        public static final int RESERVE_HINT = 1;
        public static final int RESERVE_RANDOM = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RelroSharingMode {
        public static final int CONSUME = 2;
        public static final int NO_SHARING = 0;
        public static final int PRODUCE = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int DONE = 3;
        public static final int DONE_PROVIDE_RELRO = 2;
        public static final int INITIALIZED = 1;
        public static final int UNINITIALIZED = 0;
    }

    public static class WebViewReservationSearchResult {
        private final long mDurationMs;
        private final boolean mSuccess;

        private void recordHistograms(String r100) {
            if (this.mSuccess == false) goto L5;
            String r101 = "Found";
        L6:
            RecordHistogram.recordTimesHistogram("ChromiumAndroidLinker.TimeToFindWebViewReservation." + r101 + "." + r100, this.mDurationMs);
            return;
        L5:
            r101 = "NotFound";
            goto L6
        }

        public WebViewReservationSearchResult(boolean r100, long r101) {
            this.mSuccess = r100;
            this.mDurationMs = r101;
        }

        public static /* synthetic */ void access$000(WebViewReservationSearchResult r100, String r101) {
            r100.recordHistograms(r101);
        }
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public void atomicReplaceRelroLocked(boolean r100) {
    }

    public final void ensureInitializedImplicitlyAsLastResort() {
        ensureInitialized(true, 2, 0);
    }

    public abstract boolean keepMemoryReservationUntilLoad();

    public abstract void loadLibraryImplLocked(String r100, int r101);

    public void setApkFilePath(String r100) {
    }

    public final void waitForSharedRelrosLocked() {
        this.mLinkerWasWaitingSynchronously = true;
    L4:
        if (this.mRemoteLibInfo != null) goto L8;
        this.mLock.wait();     // Catch: InterruptedException -> L7
        goto L4
    }

    public static Natives getLinkerJni() {
        Natives r100 = sNativesInstance;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new LinkerJni();
    }

    private boolean shouldAtomicallyReplaceRelroAfterLoad() {
        if (this.mLinkerWasWaitingSynchronously == false) goto L6;
        return false;
    L6:
        if (this.mRemoteLibInfo != null) goto L8;
        return false;
    L8:
        if (this.mState == 3) goto L10;
        return false;
    L10:
        if (this.mLocalLibInfo.mLoadAddress == 0) goto L15;
        return true;
    L15:
        return false;
    }

    public void pretendLibraryIsLoadedForTesting() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        this.mState = 3;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public Linker() {
        this.mLock = new Object();
        this.mRelroProducer = true;
        this.mState = 0;
        sLinkerForAssert = this;
    }

    public void loadLinkerJniLibraryLocked() {
        LibraryLoader.setEnvForNative();
        INVOKESTATIC_com_ttnet_org_chromium_base_library_loader_Linker_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(LINKER_JNI_LIBRARY);
    }

    static {
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ttnet_org_chromium_base_library_loader_Linker_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static long extractLoadAddressFromBundle(Bundle r100) {
        return r100.getLong(BASE_LOAD_ADDRESS, 0);
    }

    private String preferAddressToString(int r100) {
        if (r100 != 0) goto L4;
        return "FIND_RESERVED";
    L4:
        if (r100 != 1) goto L6;
        return "RESERVE_HINT";
    L6:
        if (r100 != 2) goto L8;
        return "RESERVE_RANDOM";
    L8:
        return String.valueOf(r100);
    }

    public static void setNativesForTesting(Natives r100) {
        sNativesInstance = r100;
        sLinkerForAssert = null;
    }

    public boolean isNonZeroLoadAddress(LibInfo r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.mLoadAddress == 0) goto L6;
        return true;
    }

    public final void loadLibrary(String r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        ensureInitializedImplicitlyAsLastResort();     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (this.mRelroProducer == false) goto L7;
        int r102 = 1;
    L8:
        attemptLoadLibraryLocked(r100, r102);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L7:
        r102 = 2;
    L10:
        th = move-exception;
        throw th;
    L12:
        Log.w(TAG, "Failed to load native library with shared RELRO, retrying without", new Object[0]);     // Catch: Throwable -> L10
        this.mLocalLibInfo.mLoadAddress = 0;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L16
        attemptLoadLibraryLocked(r100, 0);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L16
    L16:
        e = move-exception;
        Log.w(TAG, "Failed to load native library without RELRO sharing", new Object[0]);     // Catch: Throwable -> L10
        throw e;     // Catch: Throwable -> L10
    }

    public void putLoadAddressToBundle(Bundle r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        LibInfo r102 = this.mLocalLibInfo;     // Catch: Throwable -> L13
        if (r102 == null) goto L9;
        long r103 = r102.mLoadAddress;     // Catch: Throwable -> L13
        if (r103 == 0) goto L9;
        r100.putLong(BASE_LOAD_ADDRESS, r103);     // Catch: Throwable -> L13
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void putSharedRelrosToBundle(Bundle r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != 2) goto L7;
        Bundle r102 = this.mLocalLibInfo.toBundle();     // Catch: Throwable -> L11
    L8:
        r100.putBundle(SHARED_RELROS, r102);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L7:
        r102 = null;
        goto L8
    }

    public void recordHistograms(String r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        WebViewReservationSearchResult r102 = this.mWebviewReservationSearchResult;     // Catch: Throwable -> L11
        if (r102 != null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        WebViewReservationSearchResult.access$000(r102, r100);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void takeSharedRelrosFromBundle(Bundle r100) {
        Bundle r101 = r100.getBundle(SHARED_RELROS);
        if (r101 != null) goto L5;
        return;
    L5:
        LibInfo r102 = LibInfo.fromBundle(r101);
        if (r102 != null) goto L8;
        return;
    L8:
        Object r103 = this.mLock;
        monitor-enter(r103);
        LibInfo r104 = this.mRemoteLibInfo;     // Catch: Throwable -> L24
        if (r104 != null) goto L13;
    L16:
        this.mRemoteLibInfo = r102;     // Catch: Throwable -> L24
        int r105 = this.mState;     // Catch: Throwable -> L24
        if (r105 != 3) goto L20;
        atomicReplaceRelroLocked(false);     // Catch: Throwable -> L24
    L22:
        monitor-exit(r103);     // Catch: Throwable -> L24
        return;
    L20:
        if (r105 == 2) goto L22;
        this.mLock.notifyAll();     // Catch: Throwable -> L24
        goto L22
    L13:
        if (r104.mRelroFd == (-1)) goto L16;
        monitor-exit(r103);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    }

    private void attemptLoadLibraryLocked(String r100, int r101) {
        loadLibraryImplLocked(r100, r101);     // Catch: Throwable -> L8
        if (shouldAtomicallyReplaceRelroAfterLoad() == false) goto L6;
        atomicReplaceRelroLocked(true);     // Catch: Throwable -> L8
    L6:
        this.mLinkerWasWaitingSynchronously = false;
        return;
    L8:
        th = move-exception;
        this.mLinkerWasWaitingSynchronously = false;
        throw th;
    }

    private void saveWebviewReservationSearchStats(boolean r100, long r101) {
        this.mWebviewReservationSearchResult = new WebViewReservationSearchResult(r100, r101);
    }

    private void chooseAndReserveMemoryRange(boolean r100, int r101, long r102) {
        this.mLocalLibInfo = new LibInfo();
        this.mRelroProducer = r100;
        loadLinkerJniLibraryLocked();
        boolean r103 = keepMemoryReservationUntilLoad();
        if (r101 != 0) goto L5;
        TimeUtils.UptimeMillisTimer r104 = new TimeUtils.UptimeMillisTimer();
        boolean r105 = getLinkerJni().findRegionReservedByWebViewZygote(this.mLocalLibInfo);
        saveWebviewReservationSearchStats(r105, r104.getElapsedMillis());
        if (r105 == true) goto L12;
    L16:
        this.mLocalLibInfo.mLoadAddress = r102;
        if (r102 == 0) goto L23;
        if (r103 == true) goto L20;
        return;
    L20:
        getLinkerJni().reserveMemoryForLibrary(this.mLocalLibInfo);
        if (this.mLocalLibInfo.mLoadAddress == 0) goto L23;
        return;
    L23:
        getLinkerJni().findMemoryRegionAtRandomAddress(this.mLocalLibInfo, r103);
        return;
    L12:
        if (r102 != 0) goto L14;
        return;
    L14:
        if (r102 != this.mLocalLibInfo.mLoadAddress) goto L16;
        return;
    L5:
        if (r101 == 1) goto L16;
        if (r101 == 2) goto L23;
    }

    public final void ensureInitialized(boolean r100, int r101, long r102) {
        Object r103 = this.mLock;
        monitor-enter(r103);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mState == 0) goto L8;
        monitor-exit(r103);     // Catch: Throwable -> L11
        return;
    L8:
        chooseAndReserveMemoryRange(r100, r101, r102);     // Catch: Throwable -> L11
        this.mState = 1;     // Catch: Throwable -> L11
        monitor-exit(r103);     // Catch: Throwable -> L11
    }
}
