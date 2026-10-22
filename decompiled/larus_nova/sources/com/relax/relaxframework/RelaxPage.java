package com.relax.relaxframework;

import android.content.Context;
import android.os.Handler;
import com.relax.RelaxEngine;
import com.relax.RelaxEnv;
import com.relax.RelaxNativeEngine;
import com.relax.RelaxNativeInvocationHandler;
import com.relax.RelaxView;
import com.relax.RuntimeType;
import com.relax.runtime.gen.AnimationFrame;
import com.relax.runtime.gen.MediaQuery;
import com.relax.runtime.gen.NativeLayoutProxy;
import com.relax.runtime.gen.RendererFunction;
import com.relax.uirender.UIRenderRegistry;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
public final class RelaxPage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RuntimeType f404901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelaxView f404902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RelaxInstance f404903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final qpa.b f404904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NativeLayoutProxy f404905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final qpa.f f404906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final qpa.e f404907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f404908h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f404909i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f404910j;

    public static final class a {
    }

    static {
        RelaxEnv.inst().setRenderType(UIRenderRegistry.RenderType.LYNX_UI);
    }

    public final void a() {
        if (this.f404910j == false) goto L5;
        return;
    L5:
        this.f404910j = true;
        this.f404902b.destroy();
        RelaxInstance r100 = this.f404903c;
        if (r100 == null) goto L10;
        RendererFunction r101 = r100.getRendererFunction();
        if (r101 == null) goto L10;
        r101.a0();
    L10:
        RelaxInstance r102 = this.f404903c;
        if (r102 == null) goto L16;
        MediaQuery r103 = r102.getMediaQuery();
        if (r103 == null) goto L16;
        r103.a();
    L16:
        if (this.f404906f == null) goto L18;
        throw null;
    L18:
        if (this.f404907g != null) goto L26;
        qpa.b r104 = this.f404904d;
        if (r104 == null) goto L22;
        r104.f534444a.a();
        r104.f534444a = null;
    L22:
        NativeLayoutProxy r105 = this.f404905e;
        if (r105 == null) goto L28;
        r105.i();
        return;
    L28:
        return;
    L26:
        throw null;
    }

    public final void b(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        if (this.f404901a != RuntimeType.RuntimeTypeVM) goto L5;
        this.f404902b.fireEvent(r100, r101);
        return;
    L5:
        RelaxInstance r102 = this.f404903c;
        if (r102 == null) goto L12;
        com.relax.relaxframework.utils.a r103 = r102.getGlobalEventEmitter();
        if (r103 == null) goto L13;
        r103.a(r100, r101);
        return;
    L13:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        final CountDownLatch r102 = new CountDownLatch(1);
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        Handler r104 = com.relax.relaxframework.utils.e.f405305a;
        com.relax.relaxframework.utils.e.a(r100, new RelaxPage$loadFile$1(r103, r102));
        r102.await();
        RelaxNativeInvocationHandler.prepareProps(r101);
        byte[] r105 = (byte[]) r103.element;
        if (r105 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r105, "byteCode");
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f404902b.loadFile(r105, r100);
    }

    public final void d(final m4 r100, final Object r101) {
        Intrinsics.checkNotNullParameter(r100, "runner");
        this.f404909i = r101;
        String r102 = this.f404908h;
        if (r102 == null) goto L6;
        Intrinsics.checkNotNull(r102);
        c(r102, r101);
        return;
    L6:
        RelaxView r103 = this.f404902b;
        Runnable r104 = new j4(r100, r101, this);
        com.relax.v r105 = r103.f404564d;
        RelaxEngine r106 = r103.f404565e;
        if (r106.f404544c.b() == false) goto L10;
        r106.f404543b.onPipelineStart();
    L10:
        r104.run();
    }

    public RelaxPage(Context r110, ppa.b r111, RuntimeType r112) {
        Intrinsics.checkNotNullParameter(r112, "runtimeType");
        Intrinsics.checkNotNullParameter(r112, "runtimeType");
        this.f404901a = r112;
        HashMap<String, String> r113 = RelaxEnv.inst().hotReloadPages();
        if (r113 == null) goto L5;
        String r114 = r113.get("default");
    L6:
        this.f404908h = r114;
        if (r114 == null) goto L9;
        this.f404901a = RuntimeType.RuntimeTypeVM;
    L9:
        RelaxEnv.inst().setRenderType(UIRenderRegistry.RenderType.LYNX_UI);
        RelaxNativeEngine r115 = new RelaxNativeEngine(r110, this.f404901a, 1.0f);
        Intrinsics.checkNotNull(r110);
        RelaxView r100 = new RelaxView(r110, r111, this.f404901a, 1.0f, false, false, null);
        this.f404902b = r100;
        r100.bindRelaxEngine(r115);
        if (this.f404901a != RuntimeType.RuntimeTypeNative) goto L12;
        RendererFunction r101 = r115.createRendererFunction();
        MediaQuery r102 = r115.createMediaQuery();
        com.relax.relaxframework.utils.a r103 = new com.relax.relaxframework.utils.a();
        AnimationFrame r104 = r115.createAnimationFrame();
        NativeLayoutProxy r105 = r115.createNativeLayoutProxy();
        this.f404905e = r105;
        r100.getUIRenderer().getClass();
        qpa.f r106 = new qpa.f();
        this.f404906f = r106;
        r100.getUIRenderer().getClass();
        qpa.e r107 = new qpa.e();
        this.f404907g = r107;
        qpa.b r108 = new qpa.b(r100);
        this.f404904d = r108;
        Intrinsics.checkNotNull(r106);
        Intrinsics.checkNotNull(r105);
        Intrinsics.checkNotNull(r107);
        Intrinsics.checkNotNull(r108);
        this.f404903c = new RelaxInstance(r101, r102, r103, r104, r106, r105, r107, r108);
        return;
    L12:
        r100.setRelaxViewClient(new k4(this));
        return;
    L5:
        r114 = null;
        goto L6
    }
}
