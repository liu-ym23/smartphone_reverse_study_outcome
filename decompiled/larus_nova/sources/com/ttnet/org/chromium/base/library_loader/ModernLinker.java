package com.ttnet.org.chromium.base.library_loader;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.utils.logger.FLogger;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.TimeUtils;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
class ModernLinker extends Linker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String DETAILED_LOAD_TIME_HISTOGRAM_PREFIX = "ChromiumAndroidLinker.ModernLinkerDetailedLoadTime.";
    private static final String DETAILED_LOAD_TIME_HISTOGRAM_PREFIX_BLKIO_CGROUP = "ChromiumAndroidLinker.ModernLinkerDetailedLoadTimeByBlkioCgroup.";
    private static final String SELF_CGROUP_FILE_NAME = "/proc/self/cgroup";
    private static final String SUFFIX_UNKNOWN = "Unknown";
    private static final String TAG = "ModernLinker";
    private static Natives sNativesInstance;

    public interface Natives {
        int getRelroSharingResult();

        boolean loadLibrary(String r100, Linker.LibInfo r101, boolean r102);

        boolean useRelros(long r100, Linker.LibInfo r101);
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    public boolean keepMemoryReservationUntilLoad() {
        return true;
    }

    public static Natives getModernLinkerJni() {
        Natives r100 = sNativesInstance;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new ModernLinkerJni();
    }

    private String readBackgroundStateFromCgroups() {
        BufferedReader r100 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper(SELF_CGROUP_FILE_NAME)));     // Catch: IOException -> L33
        String r101 = null;
    L36:
        String r102 = r100.readLine();     // Catch: Throwable -> L27
        if (r102 == null) goto L10;
        r101 = extractBlkioCgroupFromLine(r102);     // Catch: Throwable -> L27
        if (r101.equals("") == true) goto L36;
    L10:
        if (r101 == null) goto L25;
        if (r101.equals("") == true) goto L25;
        r100.close();     // Catch: IOException -> L33
        if (r101.equals(HTTP.URL_DEFAULT) == false) goto L20;
        return "Foreground";
    L20:
        if (r101.equals("/background") == false) goto L23;
        return "Background";
    L23:
        Log.e(TAG, "blkio cgroup with unexpected name: '%s'", new Object[]{r101});
        return "Unknown";
    L25:
        r100.close();     // Catch: IOException -> L33
        return "Unknown";
    L27:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L30
    L32:
        throw th;     // Catch: IOException -> L33
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L33
    L33:
        Log.e(TAG, "IOException while reading %s", new Object[]{SELF_CGROUP_FILE_NAME});
        return "Unknown";
    }

    static {
    }

    public ModernLinker() {
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ttnet_org_chromium_base_library_loader_ModernLinker_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    private static String extractBlkioCgroupFromLine(String r100) {
        int r101 = r100.indexOf(":blkio:");
        if (r101 != (-1)) goto L7;
        return "";
    L7:
        return r100.substring(r101 + 7);
    }

    private void loadAndProduceSharedRelro(String r100) {
        this.mLocalLibInfo.mLibFilePath = r100;
        boolean r101 = true;
        if (getModernLinkerJni().loadLibrary(r100, this.mLocalLibInfo, true) == true) goto L7;
        Log.e(TAG, "Unable to load with ModernLinker, using the system linker instead", new Object[0]);
        this.mLocalLibInfo.mRelroFd = -1;
    L7:
        if (this.mLocalLibInfo.mRelroFd != (-1)) goto L10;
        r101 = false;
    L10:
        RecordHistogram.recordBooleanHistogram("ChromiumAndroidLinker.RelroProvidedSuccessfully", r101);
    }

    private void loadWithoutProducingRelro(String r100) {
        if (getModernLinkerJni().loadLibrary(r100, this.mLocalLibInfo, false) == true) goto L6;
        resetAndThrow(String.format("Unable to load library: %s", new Object[]{r100}));
        return;
    }

    public static void reportDlopenExtTime(long r100) {
        RecordHistogram.recordTimesHistogram("ChromiumAndroidLinker.ModernLinkerDlopenExtTime", r100);
    }

    public static void reportIteratePhdrTime(long r100) {
        RecordHistogram.recordTimesHistogram("ChromiumAndroidLinker.ModernLinkerIteratePhdrTime", r100);
    }

    private void resetAndThrow(String r100) {
        this.mState = 1;
        Log.e(TAG, r100, new Object[0]);
        throw new UnsatisfiedLinkError(r100);
    }

    public static void setModernLinkerNativesForTesting(Natives r100) {
        sNativesInstance = r100;
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    public void atomicReplaceRelroLocked(boolean r100) {
        if (this.mRemoteLibInfo.mRelroFd != (-1)) goto L6;
        return;
    L6:
        if (this.mLocalLibInfo != null) goto L8;
        return;
    L8:
        getModernLinkerJni().useRelros(this.mLocalLibInfo.mLoadAddress, this.mRemoteLibInfo);
        RecordHistogram.recordBooleanHistogram("ChromiumAndroidLinker.RelroAvailableImmediately", r100);
        RecordHistogram.recordEnumeratedHistogram("ChromiumAndroidLinker.RelroSharingStatus2", getModernLinkerJni().getRelroSharingResult(), 9);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    public void loadLibraryImplLocked(String r100, int r101) {
        boolean r102 = false;
        if ("monochrome".equals(r100) == true) goto L6;
        Log.i(TAG, "loadLibraryImplLocked: %s, relroMode=%d", new Object[]{r100, Integer.valueOf(r101)});
    L6:
        String r103 = readBackgroundStateFromCgroups();
        TimeUtils.UptimeMillisTimer r104 = new TimeUtils.UptimeMillisTimer();
        String r105 = System.mapLibraryName(r100);
        if (r101 != 0) goto L9;
        this.mState = 3;
    L13:
        String r106 = readBackgroundStateFromCgroups();
        if (r103.equals(r106) == false) goto L16;
    L22:
        if (r102 == false) goto L27;
        if (r101 != 1) goto L25;
        String r107 = "Produce";
    L26:
        recordDetailedLoadTimeSince(r104, r107, r103);
        goto L27
    L25:
        r107 = "Consume";
    L27:
        TimeUtils.UptimeMillisTimer r108 = new TimeUtils.UptimeMillisTimer();
        INVOKESTATIC_com_ttnet_org_chromium_base_library_loader_ModernLinker_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);     // Catch: UnsatisfiedLinkError -> L30
    L31:
        if (r102 == false) goto L33;
        String r109 = "Second";
    L34:
        recordDetailedLoadTimeSince(r108, r109, r103);
        return;
    L33:
        r109 = "NoSharing";
    L30:
        resetAndThrow("Failed at System.loadLibrary()");
        goto L31
    L16:
        if (r103.equals("Unknown") == false) goto L18;
    L21:
        r103 = "Unknown";
        goto L22
    L18:
        if (r106.equals("Unknown") == true) goto L21;
        r103 = "Mixed";
        goto L22
    L9:
        if (r101 != 1) goto L11;
        loadAndProduceSharedRelro(r105);
        this.mState = 2;
    L12:
        r102 = true;
        goto L13
    L11:
        loadWithoutProducingRelro(r105);
        this.mState = 3;
        goto L12
    }

    private void recordDetailedLoadTimeSince(TimeUtils.UptimeMillisTimer r100, String r101, String r102) {
        long r103 = r100.getElapsedMillis();
        RecordHistogram.recordTimesHistogram(DETAILED_LOAD_TIME_HISTOGRAM_PREFIX + r101, r103);
        RecordHistogram.recordTimesHistogram(DETAILED_LOAD_TIME_HISTOGRAM_PREFIX_BLKIO_CGROUP + r101 + "." + r102, r103);
    }
}
