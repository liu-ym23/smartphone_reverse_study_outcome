package com.ss.android.rust.molten.ffi;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00060\u0001j\u0002`\u0002:\u0001$B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u008d\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0004H\u0082 J+\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0082 J\u0011\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0004H\u0082 J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0082\u0001\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0004J \u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/rust/molten/ffi/MoltenLogger;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "handle", "", "<init>", "(J)V", "nativeHandle", "nativeLogV2", "", "level", "message", "", "tag", "logId", "params", "time", TextureRenderKeys.KEY_MODULE_NAME, "file", "line", PickerReporterConstants.KEY.TARGET, "thread", "pid", "nativeExtractLogChunk", "timestampSBegin", "timestampSEnd", "outputDir", "nativeDestroy", "", "close", "logV2", "Lcom/ss/android/rust/molten/ffi/MoltenLogStatus;", "Lcom/ss/android/rust/molten/ffi/LogLevel;", "extractLogChunk", "beginTimestampSec", "endTimestampSec", "Companion", "molten-log_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoltenLogger implements AutoCloseable {
    public static final Companion Companion = null;
    public static final String LIB_NAME_PROPERTY = "molten_ffi.molten_log.lib_name";
    private static final MoltenLogError[] errorValues = null;
    private static final MoltenLogStatus[] statusValues = null;
    private final long nativeHandle;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010JI\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0083 R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/rust/molten/ffi/MoltenLogger$Companion;", "", "<init>", "()V", "statusValues", "", "Lcom/ss/android/rust/molten/ffi/MoltenLogStatus;", "[Lcom/ss/android/rust/molten/ffi/MoltenLogStatus;", "errorValues", "Lcom/ss/android/rust/molten/ffi/MoltenLogError;", "[Lcom/ss/android/rust/molten/ffi/MoltenLogError;", "LIB_NAME_PROPERTY", "", "newWithConfig", "Lcom/ss/android/rust/molten/ffi/MoltenLogger;", "config", "Lcom/ss/android/rust/molten/ffi/LogConfig;", "nativeInit", "", "name", "path", "appId", "limitSize", "limitFileCount", "encodedPublicKey", "keyId", "molten-log_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        private final long nativeInit(String r100, String r101, long r102, Long r103, Long r104, String r105, String r106) throws Exception {
            return MoltenLogger.access$nativeInit(r100, r101, r102, r103, r104, r105, r106);
        }

        public final MoltenLogger newWithConfig(LogConfig r110) {
            Intrinsics.checkNotNullParameter(r110, "config");
            return new MoltenLogger(nativeInit(r110.getName(), r110.getPath(), r110.getAppId(), r110.getLimitSize(), r110.getLimitFileCount(), r110.getEncodedPublicKey(), r110.getKeyId()), null);
        }
    }

    public /* synthetic */ MoltenLogger(long r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private final native void nativeDestroy(long r100);

    private final native int nativeExtractLogChunk(long r100, long r101, long r102, String r103);

    @JvmStatic
    private static final native long nativeInit(String r100, String r101, long r102, Long r103, Long r104, String r105, String r106) throws Exception;

    private final native int nativeLogV2(long r100, int r101, String r102, String r103, String r104, String r105, long r106, String r110, String r111, long r112, String r113, String r114, long r115);

    static {
        Companion = new Companion(null);
        statusValues = MoltenLogStatus.values();
        errorValues = MoltenLogError.values();
        String r100 = System.getProperty(LIB_NAME_PROPERTY);
        if (r100 != null) goto L5;
        r100 = "molten_log";
    L5:
        INVOKESTATIC_com_ss_android_rust_molten_ffi_MoltenLogger_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        nativeDestroy(this.nativeHandle);
    }

    private MoltenLogger(long r100) {
        this.nativeHandle = r100;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_android_rust_molten_ffi_MoltenLogger_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public final void extractLogChunk(long r100, long r110, String r111) throws MoltenLogErrorException {
        int r101 = nativeExtractLogChunk(this.nativeHandle, r100, r110, r111);
        if (r101 > 0) goto L6;
        return;
    L6:
        throw new MoltenLogErrorException(MoltenLogError.values()[r101 - 1]);
    }

    public static final /* synthetic */ long access$nativeInit(String r100, String r101, long r102, Long r103, Long r104, String r105, String r106) {
        return nativeInit(r100, r101, r102, r103, r104, r105, r106);
    }

    public final MoltenLogStatus logV2(LogLevel r110, String r210, String r211, String r212, String r213, long r214, String r215, String r216, long r217, String r310, String r311, long r312) {
        Intrinsics.checkNotNullParameter(r110, "level");
        Intrinsics.checkNotNullParameter(r210, "message");
        int r100 = nativeLogV2(this.nativeHandle, r110.getIndex(), r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312);
        return statusValues[r100];
    }

    public static /* synthetic */ MoltenLogStatus logV2$default(MoltenLogger r110, LogLevel r210, String r211, String r212, String r213, String r214, long r215, String r216, String r217, long r218, String r310, String r311, long r312, int r313, Object r314) {
        if ((r313 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r313 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r313 & 16) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r313 & 64) == 0) goto L17;
        String r111 = null;
    L19:
        if ((r313 & 128) == 0) goto L21;
        String r112 = null;
    L23:
        if ((r313 & 512) == 0) goto L25;
        String r113 = null;
    L27:
        if ((r313 & 1024) == 0) goto L29;
        String r114 = null;
    L31:
        return r110.logV2(r210, r211, r100, r101, r102, r215, r111, r112, r218, r113, r114, r312);
    L29:
        r114 = r311;
        goto L31
    L25:
        r113 = r310;
        goto L27
    L21:
        r112 = r217;
        goto L23
    L17:
        r111 = r216;
        goto L19
    L13:
        r102 = r214;
        goto L15
    L9:
        r101 = r213;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }

    public static /* synthetic */ int nativeLogV2$default(MoltenLogger r210, long r211, int r212, String r213, String r214, String r215, String r216, long r217, String r310, String r311, long r312, String r313, String r314, long r315, int r316, Object r410) {
        if ((r316 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r316 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r316 & 32) == 0) goto L13;
        String r110 = null;
    L15:
        if ((r316 & 128) == 0) goto L17;
        String r111 = null;
    L19:
        if ((r316 & 256) == 0) goto L21;
        String r112 = null;
    L23:
        if ((r316 & 1024) == 0) goto L25;
        String r113 = null;
    L27:
        if ((r316 & 2048) == 0) goto L29;
        String r114 = null;
    L31:
        return r210.nativeLogV2(r211, r212, r213, r100, r101, r110, r217, r111, r112, r312, r113, r114, r315);
    L29:
        r114 = r314;
        goto L31
    L25:
        r113 = r313;
        goto L27
    L21:
        r112 = r311;
        goto L23
    L17:
        r111 = r310;
        goto L19
    L13:
        r110 = r216;
        goto L15
    L9:
        r101 = r215;
        goto L11
    L5:
        r100 = r214;
        goto L7
    }
}
