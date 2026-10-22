package com.bytedance.lynx.service.security;

import android.content.Context;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.service.security.ILynxSecurityService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import i8a.l;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00014B\u0007¢\u0006\u0004\b1\u00102JD\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\r\u001a\u00020\fH\u0082 ¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0082 J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0014J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001aJ\u0016\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001aJ\u0016\u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005J\u000e\u0010$\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\nJ8\u0010)\u001a\u00020(2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010%\u001a\u0004\u0018\u00010\n2\u0006\u0010'\u001a\u00020&H\u0016R\u001a\u0010*\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R \u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001a0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00065"}, d2 = {"Lcom/bytedance/lynx/service/security/LynxSecurityService;", "Li8a/l;", "Lcom/lynx/tasm/service/security/ILynxSecurityService;", "", ThumbGlideUrl.SOURCE_TEMPLATE, "Ljava/nio/ByteBuffer;", "buffer", "", "signIdBuffer", "", "", "extras", "", "errorCodeBuffer", "", "nativeVerifySignBlock", "([BLjava/nio/ByteBuffer;[J[Ljava/lang/String;[I)Z", "publicKeys", "nativeUpdateRsaPublicKeys", "Lcom/bytedance/lynx/service/security/e;", "verifyPayloadInternal", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "onInitialize", "doInitialize", "Lcom/bytedance/lynx/service/security/a;", "delegate", "setSecurityDelegate", "Lj8a/a;", PickerReporterConstants.KEY.TARGET, "setSecurityDelegateForTarget", "payloadData", "signBlockData", "Lcom/bytedance/lynx/service/security/b;", "verifyPayload", "updateRSAPublicKeys", "url", "Lcom/lynx/tasm/service/security/ILynxSecurityService$LynxTasmType;", "type", "Lj8a/b;", "verifyTASM", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "Lcom/bytedance/lynx/service/security/c;", "delegateRegistry", "Lcom/bytedance/lynx/service/security/c;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LynxSecurityService_release"}, k = 1, mv = {1, 6, 0})
public final class LynxSecurityService extends l implements ILynxSecurityService {
    public static final a Companion = null;
    private static final Lazy<LynxSecurityService> INSTANCE$delegate = null;
    private final String TAG;
    private final c<j8a.a, com.bytedance.lynx.service.security.a> delegateRegistry;

    public static final class a {
        public a() {
        }
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private final native boolean nativeUpdateRsaPublicKeys(String r100);

    private final native boolean nativeVerifySignBlock(byte[] r100, ByteBuffer r101, long[] r102, String[] r103, int[] r104);

    @Override // com.lynx.tasm.service.security.ILynxSecurityService, com.lynx.tasm.service.IServiceProvider
    public final /* synthetic */ Class getServiceClass() {
        return ILynxSecurityService.CC.$default$getServiceClass(this);
    }

    static {
        Companion = new a();
        INSTANCE$delegate = LazyKt.lazy(LynxSecurityService$Companion$INSTANCE$2.INSTANCE);
    }

    @Override // i8a.l
    public boolean doInitialize() {
        INativeLibraryLoader r100 = LynxEnv.inst().getLibraryLoader();     // Catch: UnsatisfiedLinkError -> L12 Exception -> L15
        if (r100 == null) goto L7;
        r100.loadLibrary("lynxsecurity");     // Catch: UnsatisfiedLinkError -> L12 Exception -> L15
        Unit r101 = Unit.INSTANCE;     // Catch: UnsatisfiedLinkError -> L12 Exception -> L15
    L8:
        if (r101 != null) goto L20;
        INVOKESTATIC_com_bytedance_lynx_service_security_LynxSecurityService_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lynxsecurity");     // Catch: UnsatisfiedLinkError -> L12 Exception -> L15
        return true;
    L20:
        return true;
    L7:
        r101 = null;
    L15:
        e = move-exception;
        LLog.e(this.TAG, "fail to load lynxsecurity.so, error message is: " + e);
        return false;
    L12:
        e = move-exception;
        LLog.e(this.TAG, "fail to load lynxsecurity.so, error message is: " + e);
        return false;
    }

    public LynxSecurityService() {
        this.TAG = "LynxSecurityService";
        this.delegateRegistry = new c();
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$delegate$cp() {
        return INSTANCE$delegate;
    }

    public final String getTAG() {
        return this.TAG;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_lynx_service_security_LynxSecurityService_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    private final e verifyPayloadInternal(ByteBuffer r210) {
        if (ensureInitialized() == true) goto L6;
        LLog.e(this.TAG, "lynxsecurity.so load failed.");
        return new e(false, "lynxsecurity.so load failed.", null, -1, null);
    L6:
        long[] r100 = {-1};
        int[] r110 = {0};
        String[] r111 = new String[2];
        boolean r112 = nativeVerifySignBlock(null, r210, r100, r111, r110);
        String r113 = r111[1];
        LynxSecurityErrorCode.a r101 = LynxSecurityErrorCode.Companion;
        int r102 = r110[0];
        r101.getClass();
        return new e(r112, r113, LynxSecurityErrorCode.a.a(r102), r100[0], r111[0]);
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    public void onInitialize(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        initialize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setSecurityDelegate(com.bytedance.lynx.service.security.a r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        c<j8a.a, com.bytedance.lynx.service.security.a> r101 = this.delegateRegistry;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Object r102 = r101.f264930a;
        monitor-enter(r102);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r101.f264931b == null) goto L7;
        boolean r103 = false;
    L9:
        monitor-exit(r102);
        if (r103 == true) goto L18;
        LLog.e(this.TAG, "SecurityDelegate can not be override.");
        return;
    L18:
        return;
    L7:
        r101.f264931b = r100;     // Catch: Throwable -> L13
        r103 = true;
        goto L9
    }

    public final void updateRSAPublicKeys(String r100) {
        Intrinsics.checkNotNullParameter(r100, "publicKeys");
        if (ensureInitialized() == true) goto L6;
        LLog.e("LynxSecurityService", "lynxsecurity.so load failed.");
        return;
    L6:
        nativeUpdateRsaPublicKeys(r100);
    }

    public final void setSecurityDelegateForTarget(j8a.a r100, com.bytedance.lynx.service.security.a r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "delegate");
        c<j8a.a, com.bytedance.lynx.service.security.a> r102 = this.delegateRegistry;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "delegate");
        Object r103 = r102.f264930a;
        monitor-enter(r103);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r102.f264932c.containsKey(r100) == false) goto L7;
        boolean r104 = false;
    L9:
        monitor-exit(r103);
        if (r104 == true) goto L18;
        LLog.e(this.TAG, "SecurityDelegate for target can not be override.");
        return;
    L18:
        return;
    L7:
        r102.f264932c.put(r100, r101);     // Catch: Throwable -> L13
        r104 = true;
        goto L9
    }

    public final b verifyPayload(ByteBuffer r100, ByteBuffer r101) {
        Intrinsics.checkNotNullParameter(r100, "payloadData");
        Intrinsics.checkNotNullParameter(r101, "signBlockData");
        int r102 = d.f264933a;
        int r103 = 0;
        ByteBuffer[] r104 = {r100, r101};
        Intrinsics.checkNotNullParameter(r104, "buffers");
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r105 >= 2) goto L5;
        r106 = r106 + r104[r105].remaining();
        r105 = r105 + 1;
        goto L3
    L5:
        int r107 = r106 + 4;
        ByteBuffer r108 = ByteBuffer.allocateDirect(r107).order(ByteOrder.nativeOrder());
        r108.putInt(r107);
    L6:
        if (r103 >= 2) goto L8;
        r108.put(r104[r103].duplicate().slice());
        r103 = r103 + 1;
        goto L6
    L8:
        r108.flip();
        return verifyPayloadInternal(r108);
    }

    @Override // com.lynx.tasm.service.security.ILynxSecurityService
    public j8a.b verifyTASM(j8a.a r210, byte[] r211, ByteBuffer r212, String r213, ILynxSecurityService.LynxTasmType r214) {
        Intrinsics.checkNotNullParameter(r214, "type");
        if (ensureInitialized() == true) goto L6;
        LLog.e(this.TAG, "lynxsecurity.so load failed");
        return j8a.b.b();
    L6:
        if (r211 != null) goto L10;
        if (r212 != null) goto L10;
        return j8a.b.a("empty tasm file.");
    L10:
        c<j8a.a, com.bytedance.lynx.service.security.a> r100 = this.delegateRegistry;
        Object r101 = r100.f264930a;
        monitor-enter(r101);
        if (r210 != null) goto L33;
    L15:
        com.bytedance.lynx.service.security.a r102 = r100.f264931b;     // Catch: Throwable -> L30
    L16:
        monitor-exit(r101);
        com.bytedance.lynx.service.security.a r110 = r102;
        if (r110 == null) goto L29;
        if (r110.a() == false) goto L29;
        long[] r103 = {-1};
        int[] r111 = {0};
        String[] r112 = new String[2];
        boolean r104 = nativeVerifySignBlock(r211, r212, r103, r112, r111);
        long r113 = r103[0];
        LynxSecurityErrorCode.a r105 = LynxSecurityErrorCode.Companion;
        int r106 = r111[0];
        r105.getClass();
        LynxSecurityErrorCode r114 = LynxSecurityErrorCode.a.a(r106);
        String r115 = r112[0];
        String r107 = r112[1];
        WeakReference r108 = new WeakReference(r210);
        if ((r210 instanceof LynxView) == false) goto L25;
        LynxView r109 = (LynxView) r210;
    L27:
        return r110.b(new f(r108, new WeakReference(r109), r213, r211, r212, r104, r107, r114, r113, r115, r214));
    L25:
        r109 = null;
    L29:
        return j8a.b.b();
    L30:
        th = move-exception;
        throw th;
    L33:
        r102 = r100.f264932c.get(r210);     // Catch: Throwable -> L30
        if (r102 != null) goto L16;
        goto L15
    }
}
