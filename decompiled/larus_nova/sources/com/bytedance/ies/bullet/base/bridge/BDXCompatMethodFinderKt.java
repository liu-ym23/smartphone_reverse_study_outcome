package com.bytedance.ies.bullet.base.bridge;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.bullet.assembler.leak.JsLeakFixer$bindReleaseIf$1;
import com.bytedance.ies.bullet.assembler.leak.JsLeakFixer$bindReleaseIf$observer$1;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.deprecate.fake.ContainerBidParam;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class BDXCompatMethodFinderKt {

    public static final class a implements p56.c {
        public a() {
        }
    }

    public static final class b implements XBridgeMethod.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g66.c f246272a;

        public static final class a implements com.bytedance.ies.bullet.core.kit.bridge.h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f246273a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final JSONObject f246274b;

            @Override // com.bytedance.ies.bullet.core.kit.bridge.h
            public final String getName() {
                return this.f246273a;
            }

            @Override // com.bytedance.ies.bullet.core.kit.bridge.h
            public final Object getParams() {
                return this.f246274b;
            }

            public a(String r100, XReadableMap r101) {
                this.f246273a = r100;
                if (r101 == null) goto L5;
                JSONObject r102 = com.bytedance.ies.xbridge.utils.j.d(r101);
            L6:
                this.f246274b = r102;
                return;
            L5:
                r102 = new JSONObject();
                goto L6
            }
        }

        public b(g66.c r100) {
            this.f246272a = r100;
        }

        @Override // com.bytedance.ies.xbridge.XBridgeMethod.b
        public final void sendJsEvent(String r100, XReadableMap r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            m16.b r102 = (m16.b) this.f246272a.c(m16.b.class);
            if (r102 == null) goto L8;
            h16.e r103 = (h16.e) r102.c(h16.e.class);
            if (r103 == null) goto L9;
            r103.onEvent(new a(r100, r101));
            return;
        L9:
            return;
        }
    }

    public static final class c implements p56.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g66.c f246275a;

        @Override // p56.b
        public final String provideContainerID() {
            m16.b r100 = (m16.b) this.f246275a.c(m16.b.class);
            if (r100 == null) goto L9;
            h16.e r101 = (h16.e) r100.c(h16.e.class);
            if (r101 == null) goto L9;
            String r102 = r101.getSessionId();
            if (r102 == null) goto L9;
            return r102;
        L9:
            return "";
        }

        public c(g66.c r100) {
            this.f246275a = r100;
        }
    }

    public static final class d implements IDLXBridgeMethod.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g66.c f246276a;

        public static final class a implements com.bytedance.ies.bullet.core.kit.bridge.h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f246277a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final JSONObject f246278b;

            @Override // com.bytedance.ies.bullet.core.kit.bridge.h
            public final String getName() {
                return this.f246277a;
            }

            @Override // com.bytedance.ies.bullet.core.kit.bridge.h
            public final Object getParams() {
                return this.f246278b;
            }

            public a(String r100, Map<String, ? extends Object> r101) {
                this.f246277a = r100;
                if (r101 == null) goto L5;
                JSONObject r102 = new JSONObject(r101);
            L6:
                this.f246278b = r102;
                return;
            L5:
                r102 = new JSONObject();
                goto L6
            }
        }

        public d(g66.c r100) {
            this.f246276a = r100;
        }

        @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod.b
        public final void a(String r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            m16.b r102 = (m16.b) this.f246276a.c(m16.b.class);
            if (r102 == null) goto L8;
            h16.e r103 = (h16.e) r102.c(h16.e.class);
            if (r103 == null) goto L9;
            r103.onEvent(new a(r100, r101));
            return;
        L9:
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16, types: [androidx.lifecycle.LifecycleObserver, com.bytedance.ies.bullet.assembler.leak.JsLeakFixer$bindReleaseIf$observer$1] */
    public static final g66.c a(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        ContainerBidParam r101 = (ContainerBidParam) r100.c(ContainerBidParam.class);
        boolean r102 = false;
        if (r101 == null) goto L7;
        String r103 = r101.getBid();
        if (r103 == null) goto L7;
        boolean r104 = r103.equals("webcast");
    L8:
        h16.e r105 = (h16.e) r100.c(h16.e.class);
        final g66.c r106 = new g66.c();
        r106.f(Context.class, r100.c(Context.class));
        r106.f(m16.b.class, r100);
        r106.d(p56.c.class, new a());
        boolean r107 = true;
        if (r104 == false) goto L61;
        CallContext r108 = (CallContext) r100.c(CallContext.class);
        if (r108 != null) goto L22;
        if (r105 == null) goto L22;
        r108 = new CallContext();
        com.bytedance.ies.bullet.service.base.o r109 = r105.getKitView();
        if (r109 == null) goto L16;
        r108.f249269d = r109.realView();
        r108.f249273h = new com.bytedance.ies.bullet.base.bridge.a(r109);
    L16:
        BulletContext r110 = r105.getBulletContext();
        if (r110 == null) goto L21;
        Context r111 = r110.getContext();
        if (r111 == null) goto L21;
        r108.f249266a = r111;
    L21:
        r108.f249272g = "webcast";
        r108.f249267b = String.valueOf(r105.getCurrentUri());
        r108.f249271f = true;
    L22:
        r106.d(CallContext.class, r108);
        s26.d r112 = s26.d.f540305c;
        m0 r113 = (m0) s26.d.f540305c.c(m0.class);
        if (r113 == null) goto L29;
        com.bytedance.ies.bullet.service.base.d r114 = r113.a0();
        if (r114 == null) goto L29;
        if (r114.f247830m != true) goto L29;
        boolean r115 = true;
    L30:
        if (r115 == false) goto L61;
        int r116 = w06.b.f557815a;
        LifecycleOwner r117 = null;
        if (r108 == null) goto L34;
        Context r118 = r108.getContext();
    L35:
        final Function0<Unit> r119 = new BDXCompatMethodFinderKt$getXBridgeProviderFactory$contextProvider$1$2(r106);
        Intrinsics.checkNotNullParameter(r119, "release");
        Map<String, Map<Class<?>, Object>> r120 = x26.a.f562251a;
        w26.g r121 = (w26.g) x26.a.a(w26.g.class);
        if (r121 == null) goto L42;
        w26.e r122 = (w26.e) r121.n0(w26.e.class);
        if (r122 == null) goto L42;
        Boolean r123 = r122.D();
        if (r123 == null) goto L42;
        r102 = r123.booleanValue();
    L42:
        if (r102 == false) goto L51;
        if ((r118 instanceof LifecycleOwner) == false) goto L46;
        r117 = (LifecycleOwner) r118;
    L46:
        if (r117 == null) goto L61;
        Lifecycle r124 = r117.getLifecycle();
        if (r124 == null) goto L61;
        r124.addObserver(new JsLeakFixer$bindReleaseIf$1(r119));
        goto L61
    L51:
        if ((r118 instanceof LifecycleOwner) == false) goto L53;
        r117 = (LifecycleOwner) r118;
    L53:
        if (r117 == null) goto L61;
        final Lifecycle r125 = r117.getLifecycle();
        if (r125 == 0) goto L61;
        final ?? r126 = new JsLeakFixer$bindReleaseIf$observer$1(r119);
        Looper r127 = Looper.getMainLooper();
        if (Intrinsics.areEqual(Looper.myLooper(), r127) == true) goto L60;
        new Handler(r127).post(new w06.a(r125, r126));
        goto L61
    L60:
        r125.addObserver(r126);
        goto L61
    L34:
        r118 = null;
    L29:
        r115 = false;
    L61:
        r106.d(XBridgeMethod.b.class, new b(r106));
        r106.d(p56.b.class, new c(r106));
        r106.d(IDLXBridgeMethod.b.class, new d(r106));
        if (r100.c(com.bytedance.android.anniex.worker.e.class) == null) goto L77;
        Map<String, Map<Class<?>, Object>> r128 = x26.a.f562251a;
        w26.g r129 = (w26.g) x26.a.a(w26.g.class);
        if (r129 == null) goto L70;
        w26.e r130 = (w26.e) r129.n0(w26.e.class);
        if (r130 == null) goto L70;
        Boolean r131 = r130.S1();
        if (r131 == null) goto L70;
        r107 = r131.booleanValue();
    L70:
        if (r107 == false) goto L77;
        IDLXBridgeMethod.b r132 = (IDLXBridgeMethod.b) r100.c(IDLXBridgeMethod.b.class);
        if (r132 == null) goto L74;
        r106.d(IDLXBridgeMethod.b.class, r132);
    L74:
        XBridgeMethod.b r133 = (XBridgeMethod.b) r100.c(XBridgeMethod.b.class);
        if (r133 == null) goto L77;
        r106.d(XBridgeMethod.b.class, r133);
    L77:
        return r106;
    L7:
        r104 = false;
        goto L8
    }
}
