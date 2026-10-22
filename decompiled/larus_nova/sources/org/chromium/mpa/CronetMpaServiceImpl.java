package org.chromium.mpa;

import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.mpa.IMpaService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTMpaService;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.chromium.CronetClient;

/* JADX INFO: loaded from: classes42.dex */
public class CronetMpaServiceImpl implements IMpaService {
    private static final String PRE_CNIT_KETNEL_FUNC = "preInitCronetKernel";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private TTMpaService.ICallback mCronetAccAddressCallback;
    private CronetEngine mCronetEngine;
    private TTMpaService.ICallback mCronetInitCallback;
    private IMpaService.ICallback mOuterAccAddressCallback;
    private IMpaService.ICallback mOuterInitCallback;
    private TTMpaService mTTNetMpaService;

    public class a implements TTMpaService.ICallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CronetMpaServiceImpl f525645a;

        public a(CronetMpaServiceImpl r100) {
            this.f525645a = r100;
        }

        @Override // com.ttnet.org.chromium.net.TTMpaService.ICallback
        public final void onFinish(boolean r100, String r101) {
            if (CronetMpaServiceImpl.access$000(this.f525645a) == null) goto L6;
            CronetMpaServiceImpl.access$000(this.f525645a).onFinish(r100, r101);
            return;
        }
    }

    public class b implements TTMpaService.ICallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CronetMpaServiceImpl f525646a;

        public b(CronetMpaServiceImpl r100) {
            this.f525646a = r100;
        }

        @Override // com.ttnet.org.chromium.net.TTMpaService.ICallback
        public final void onFinish(boolean r100, String r101) {
            monitor-enter(CronetMpaServiceImpl.class);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (CronetMpaServiceImpl.access$100(this.f525646a) == null) goto L7;
            CronetMpaServiceImpl.access$100(this.f525646a).onFinish(r100, r101);     // Catch: Throwable -> L9
            CronetMpaServiceImpl.access$102(this.f525646a, null);     // Catch: Throwable -> L9
        L7:
            monitor-exit(CronetMpaServiceImpl.class);     // Catch: Throwable -> L9
        }
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private boolean loadCronetKernel() {
        if (this.mCronetEngine == null) goto L12;
        return true;
    L12:
        Reflect.on(INVOKESTATIC_org_chromium_mpa_CronetMpaServiceImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call(PRE_CNIT_KETNEL_FUNC);     // Catch: Throwable -> L8
        CronetEngine r100 = CronetClient.getCronetEngine();     // Catch: Throwable -> L8
        this.mCronetEngine = r100;     // Catch: Throwable -> L8
        if (r100 == null) goto L14;
        return true;
    L14:
        return false;
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.mpa.IMpaService
    public void start() {
        TTMpaService r100 = this.mTTNetMpaService;
        if (r100 == null) goto L6;
        r100.start();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.mpa.IMpaService
    public void stop() {
        TTMpaService r100 = this.mTTNetMpaService;
        if (r100 == null) goto L6;
        r100.stop();
        return;
    }

    public CronetMpaServiceImpl() {
        this.mCronetInitCallback = new a(this);
        this.mCronetAccAddressCallback = new b(this);
    }

    private boolean createMpaService() {
        if (loadCronetKernel() == true) goto L7;
        return false;
    L7:
        if (this.mTTNetMpaService != null) goto L11;
        this.mTTNetMpaService = this.mCronetEngine.createTTMpaService();
        return true;
    L11:
        return true;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_org_chromium_mpa_CronetMpaServiceImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static /* synthetic */ IMpaService.ICallback access$000(CronetMpaServiceImpl r100) {
        return r100.mOuterInitCallback;
    }

    public static /* synthetic */ IMpaService.ICallback access$100(CronetMpaServiceImpl r100) {
        return r100.mOuterAccAddressCallback;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.mpa.IMpaService
    public void init(IMpaService.ICallback r100) {
        if (createMpaService() == true) goto L6;
        r100.onFinish(false, "Create MpaService Failed");
        return;
    L6:
        this.mOuterInitCallback = r100;
        this.mTTNetMpaService.init(this.mCronetInitCallback);
    }

    public static /* synthetic */ IMpaService.ICallback access$102(CronetMpaServiceImpl r100, IMpaService.ICallback r101) {
        r100.mOuterAccAddressCallback = r101;
        return r101;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.mpa.IMpaService
    public void command(String r100, String r101) {
        TTMpaService r102 = this.mTTNetMpaService;
        if (r102 == null) goto L6;
        r102.command(r100, r101);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.mpa.IMpaService
    public void setAccAddress(List<String> r100, IMpaService.ICallback r101) {
        if (this.mTTNetMpaService != null) goto L5;
        if (r101 == null) goto L23;
        r101.onFinish(false, "TTNetMpaService is null");
        return;
    L23:
        return;
    L5:
        monitor-enter(CronetMpaServiceImpl.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.mOuterAccAddressCallback == null) goto L12;
        if (r101 == null) goto L10;
        r101.onFinish(false, "setAccAddress is running");     // Catch: Throwable -> L15
    L10:
        monitor-exit(CronetMpaServiceImpl.class);     // Catch: Throwable -> L15
        return;
    L12:
        this.mOuterAccAddressCallback = r101;     // Catch: Throwable -> L15
        monitor-exit(CronetMpaServiceImpl.class);     // Catch: Throwable -> L15
        this.mTTNetMpaService.setAccAddress(r100, this.mCronetAccAddressCallback);
    }
}
