package com.ss.lens.algorithm;

import android.graphics.Bitmap;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class DocAIScan {
    private static boolean isLibLoaded;
    private static LibLoaderListener mLoaderListener;
    private static long mNativePtr;

    public static final enum DocumentType extends Enum<DocumentType> {
        private static final /* synthetic */ DocumentType[] $VALUES = null;
        public static final DocumentType IMAGE = null;
        public static final DocumentType VIDEO = null;

        static {
            DocumentType r100 = new DocumentType("IMAGE", 0);
            IMAGE = r100;
            DocumentType r101 = new DocumentType("VIDEO", 1);
            VIDEO = r101;
            $VALUES = new DocumentType[]{r100, r101};
        }

        public static DocumentType[] values() {
            return (DocumentType[]) $VALUES.clone();
        }

        public static DocumentType valueOf(String r100) {
            return (DocumentType) a.a(DocumentType.class, r100);
        }

        private DocumentType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface LibLoaderListener {
        boolean onLoader(String r100);
    }

    public static final enum QuadStatus extends Enum<QuadStatus> {
        private static final /* synthetic */ QuadStatus[] $VALUES = null;
        public static final QuadStatus QUAD_KEEP = null;
        public static final QuadStatus QUAD_NO = null;
        public static final QuadStatus QUAD_UPDATE = null;

        static {
            QuadStatus r100 = new QuadStatus("QUAD_UPDATE", 0);
            QUAD_UPDATE = r100;
            QuadStatus r101 = new QuadStatus("QUAD_KEEP", 1);
            QUAD_KEEP = r101;
            QuadStatus r102 = new QuadStatus("QUAD_NO", 2);
            QUAD_NO = r102;
            $VALUES = new QuadStatus[]{r100, r101, r102};
        }

        public static QuadStatus[] values() {
            return (QuadStatus[]) $VALUES.clone();
        }

        public static QuadStatus valueOf(String r100) {
            return (QuadStatus) a.a(QuadStatus.class, r100);
        }

        private QuadStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public DocAIScan() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native long nativeDocAIInitScan(String r100, String r101);

    private static native void nativeDocAIReleaseScan(long r100);

    private static native int nativeDocAIScan(long r100, Bitmap r101, float[] r102, int r103);

    public static void DocAIReleaseScan() {
        long r100 = mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeDocAIReleaseScan(r100);
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_lens_algorithm_DocAIScan_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static synchronized void setOutLoader(LibLoaderListener r100) {
        monitor-enter(DocAIScan.class);
        mLoaderListener = r100;     // Catch: Throwable -> L7
        monitor-exit(DocAIScan.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0026 -> B:36:0x0029). Please report as a decompilation issue!!! */
    public static synchronized boolean DocAIInitScan(String r100, String r101) {
        monitor-enter(DocAIScan.class);
    L33:
        th = move-exception;
        throw th;
    L6:
        if (isLibLoaded == false) goto L37;
    L26:
        long r102 = nativeDocAIInitScan(r100, r101);     // Catch: Throwable -> L33
        mNativePtr = r102;     // Catch: Throwable -> L33
        if (r102 != 0) goto L31;
        monitor-exit(DocAIScan.class);
        return false;
    L31:
        monitor-exit(DocAIScan.class);
        return true;
    L37:
        LibLoaderListener r103 = mLoaderListener;     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L33
        if (r103 == null) goto L10;
        r103.onLoader("c++_shared");     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L33
        mLoaderListener.onLoader("bytenn");     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L33
    L36:
        LibLoaderListener r104 = mLoaderListener;     // Catch: UnsatisfiedLinkError -> L22 Throwable -> L33
        if (r104 != null) goto L17;
        INVOKESTATIC_com_ss_lens_algorithm_DocAIScan_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lens");     // Catch: UnsatisfiedLinkError -> L22 Throwable -> L33
    L21:
        isLibLoaded = true;     // Catch: Throwable -> L33
        goto L26
    L17:
        if (r104.onLoader("lens") == true) goto L21;
        monitor-exit(DocAIScan.class);
        return false;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L33
        return false;
    L10:
        INVOKESTATIC_com_ss_lens_algorithm_DocAIScan_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("c++_shared");     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L33
        INVOKESTATIC_com_ss_lens_algorithm_DocAIScan_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bytenn");     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L33
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L33
        goto L36
    }

    public static int DocAIScan(Bitmap r100, float[] r101, int r102) {
        long r103 = mNativePtr;
        if (r103 != 0) goto L7;
        return -1;
    L7:
        return nativeDocAIScan(r103, r100, r101, r102);
    }
}
