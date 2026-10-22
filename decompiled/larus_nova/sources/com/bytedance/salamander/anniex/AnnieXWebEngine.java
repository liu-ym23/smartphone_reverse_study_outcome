package com.bytedance.salamander.anniex;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import android.view.View;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ies.bullet.core.common.Arch;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class AnnieXWebEngine implements l3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f2 f267865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnnieXWebModel f267866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AnnieXWebKit f267867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.anniex.lite.flow.web.b f267868d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.salamander.anniex.g3
    public final void c() {
        com.bytedance.android.anniex.lite.flow.web.b r100 = this.f267868d;
        if (r100 == null) goto L5;
        r100.onRelease();
    L5:
        AnnieXWebKit r101 = this.f267867c;
        if (r101 == null) goto L9;
        r101.f();
        return;
    }

    @Override // com.bytedance.salamander.anniex.l3
    public final boolean canGoBack() {
        AnnieXWebKit r100 = this.f267867c;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.A == SccConfig.SccLevel.SAFE) goto L8;
    L10:
        boolean r101 = false;
    L11:
        if (r101 != true) goto L15;
        return true;
    L15:
        return false;
    L8:
        if (r100.f41435w <= 0) goto L10;
        r101 = true;
        goto L11
    }

    @Override // com.bytedance.salamander.anniex.g3
    public final void d() {
        AnnieXWebKit r100 = this.f267867c;
        if (r100 == null) goto L6;
        r100.k();
        return;
    }

    @Override // com.bytedance.salamander.anniex.g3
    public final void e() {
        AnnieXWebKit r100 = this.f267867c;
        if (r100 == null) goto L6;
        r100.j();
        return;
    }

    @Override // com.bytedance.salamander.anniex.g3
    public final View getEngineView() {
        AnnieXWebKit r100 = this.f267867c;
        if (r100 == null) goto L5;
        SSWebView r101 = r100.f41417e;
    L7:
        if ((r101 instanceof View) == true) goto L9;
        return null;
    L9:
        return r101;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.salamander.anniex.l3
    public final void goBack() {
        AnnieXWebKit r100 = this.f267867c;
        if (r100 == null) goto L8;
        SSWebView r101 = r100.f41417e;
        if (r101 == null) goto L9;
        r101.goBack();
        return;
    L9:
        return;
    }

    public AnnieXWebEngine(f2 r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_PROPS);
        this.f267865a = r110;
        String r100 = r110.f268245a;
        String r101 = r110.f268246b;
        Uri r102 = UriProtector.parse(r110.f268247c);
        Context r103 = r110.a().getContext();
        Intrinsics.checkNotNull(r102);
        com.bytedance.android.anniex.lite.flow.web.b r104 = com.bytedance.android.anniex.lite.flow.web.a.a(r101);
        MutableContextWrapper r105 = null;
        if (r104 == null) goto L5;
        this.f267868d = r104;
        AnnieXWebModel r106 = r104.b(r100, r102, r101);
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("AnnieXWebEngine", "get or create AnnieXWebModel from IAnnieXWebPreloadProvider");
    L6:
        if (r106 != null) goto L8;
        r106 = com.bytedance.android.anniex.lite.c.b(r100, r102, r101);
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("AnnieXWebEngine", "get or create AnnieXWebModel from AnnieXProcessCenter");
    L8:
        Intrinsics.checkNotNull(r106);
        this.f267866b = r106;
        com.bytedance.android.anniex.lite.flow.web.b r107 = this.f267868d;
        if (r107 == null) goto L11;
        Intrinsics.checkNotNull(r107);
        AnnieXWebKit r108 = r107.d();
    L12:
        if (r108 == null) goto L25;
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("AnnieXWebEngine", "get preload AnnieXWebKit from IAnnieXWebPreloadProvider");
        AnnieXWebModel r109 = r108.f41415c;
        if (r109 == null) goto L16;
        r109.f41477l.b(r103);
    L16:
        SSWebView r111 = r108.f41417e;
        if (r111 == null) goto L19;
        Context r112 = r111.getContext();
    L21:
        if ((r112 instanceof MutableContextWrapper) == false) goto L23;
        r105 = (MutableContextWrapper) r112;
    L23:
        if (r105 == null) goto L26;
        r105.setBaseContext(r110.a().getContext());
    L26:
        Intrinsics.checkNotNull(r108);
        Arch r113 = r110.a().f268382d;
        Intrinsics.checkNotNullParameter(r113, "arch");
        r108.f41422j = r113;
        Scenes r114 = r110.a().f268383e;
        Intrinsics.checkNotNullParameter(r114, "scene");
        r108.f41421i = r114;
        com.bytedance.android.anniex.lite.flow.web.b r115 = this.f267868d;
        if (r115 == null) goto L29;
        r115.a();
    L29:
        this.f267867c = r108;
        return;
    L19:
        r112 = null;
        goto L21
    L25:
        LruCache<String, AnnieXWebModel> r116 = com.bytedance.android.anniex.lite.c.f40797a;
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "bid");
        r108 = ib.c.a(r103, r100);
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("AnnieXWebEngine", "get or create AnnieXWebKit from AnnieXProcessCenter");
        goto L26
    L11:
        r108 = null;
        goto L12
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.bytedance.salamander.anniex.g3
    public final void a(l r100) {
        f(new v0(r100));
    }

    @Override // com.bytedance.salamander.anniex.g3
    public final void b(l r100) {
        v0 r101 = new v0(r100);
        AnnieXWebKit r102 = this.f267867c;
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L42;
        AnnieXWebModel r104 = this.f267866b;
        f2 r105 = null;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("webModel");
        r104 = null;
    L13:
        if (r104.f41472g == null) goto L24;
        ConcurrentHashMap<String, Object> r106 = com.bytedance.android.anniex.ability.f.f40204a;
        AnnieXWebModel r107 = this.f267866b;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("webModel");
        r107 = null;
    L17:
        String r108 = r107.f41466a;
        KitType r109 = KitType.WEB;
        f2 r110 = this.f267865a;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException(SlcElement.KEY_PROPS);
        r110 = null;
    L20:
        Context r111 = r110.a().getContext();
        AnnieXWebModel r112 = this.f267866b;
        if (r112 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("webModel");
        r112 = null;
    L23:
        String r113 = r112.f41469d;
        com.bytedance.android.anniex.ability.f.p(r108, r109, r111);
    L24:
        AnnieXWebKit r114 = this.f267867c;
        Intrinsics.checkNotNull(r114);
        ib.f r115 = r114.I;
        if ((r115 instanceof com.bytedance.android.anniex.lite.container.n) == false) goto L27;
        com.bytedance.android.anniex.lite.container.n r116 = (com.bytedance.android.anniex.lite.container.n) r115;
    L28:
        if (r116 != null) goto L35;
        AnnieXWebKit r117 = this.f267867c;
        Intrinsics.checkNotNull(r117);
        r117.getClass();
        new Handler(Looper.getMainLooper()).post(new com.bytedance.android.anniex.web.a(r117));
        f2 r118 = this.f267865a;
        if (r118 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException(SlcElement.KEY_PROPS);
    L33:
        r105.getClass();
        return;
    L32:
        r105 = r118;
        goto L33
    L35:
        Intrinsics.checkNotNullParameter(r101, NewBroadcastMonitor.STAGE.LIFECYCLE);
        r116.f40887c = r101;
        monitor-enter(r116);
        r116.f40888d = true;     // Catch: Throwable -> L39
        throw null;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    L27:
        r116 = null;
        goto L28
    L42:
        f(r101);
        return;
    L5:
        if (r102.f41425m != true) goto L7;
        r103 = true;
        goto L8
    }

    public final void f(v0 r100) {
        AnnieXWebKit r101 = this.f267867c;
        if (r101 == null) goto L13;
        f2 r102 = this.f267865a;
        AnnieXWebModel r103 = null;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException(SlcElement.KEY_PROPS);
        r102 = null;
    L7:
        Context r104 = r102.a().getContext();
        AnnieXWebModel r105 = this.f267866b;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("webModel");
    L11:
        r101.i(r104, r100, r103, new m16.b());
        return;
    L10:
        r103 = r105;
        goto L11
    }

    @Override // com.bytedance.salamander.anniex.g3
    public final void sendEvent(String r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        AnnieXWebKit r102 = this.f267867c;
        if (r102 == null) goto L6;
        r102.p(r100, r101);
        return;
    }
}
