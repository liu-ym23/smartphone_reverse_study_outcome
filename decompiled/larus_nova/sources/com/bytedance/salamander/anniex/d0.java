package com.bytedance.salamander.anniex;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class d0 implements g3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f268017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ra.a f268018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnnieXLynxView f268019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public na.c f268020d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.salamander.anniex.g3
    public final void c() {
        na.c r100 = this.f268020d;
        if (r100 == null) goto L5;
        r100.onRelease();
    L5:
        AnnieXLynxView r101 = this.f268019c;
        if (r101 == null) goto L8;
        r101.destroy();
    L8:
        this.f268019c = null;
        this.f268020d = null;
    }

    @Override // com.bytedance.salamander.anniex.g3
    public final void d() {
        AnnieXLynxView r100 = this.f268019c;
        if (r100 == null) goto L6;
        r100.H();
        return;
    }

    @Override // com.bytedance.salamander.anniex.g3
    public final void e() {
        AnnieXLynxView r100 = this.f268019c;
        if (r100 == null) goto L6;
        r100.F();
        return;
    }

    @Override // com.bytedance.salamander.anniex.g3
    public final View getEngineView() {
        AnnieXLynxView r100 = this.f268019c;
        if ((r100 instanceof View) == true) goto L7;
        return null;
    L7:
        return r100;
    }

    public d0(e0 r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_PROPS);
        this.f268017a = r110;
        String r100 = r110.f268245a;
        String r101 = r110.f268246b;
        Uri r102 = UriProtector.parse(r110.f268247c);
        Context r103 = r110.a().getContext();
        Intrinsics.checkNotNull(r102);
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        Object r104 = com.bytedance.android.anniex.lite.flow.base.a.f40919a.a(r101);
        if ((r104 instanceof na.c) == false) goto L5;
        na.c r105 = (na.c) r104;
    L7:
        if (r105 == null) goto L9;
        this.f268020d = r105;
        ra.a r106 = r105.c(r100, r102, r101, null);
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("AnnieXLynxEngine", "get or create AnnieXLynxModel from IAnnieXLynxPreloadProvider");
    L10:
        if (r106 != null) goto L12;
        com.bytedance.android.anniex.lite.b.f40795a.getClass();
        r106 = com.bytedance.android.anniex.lite.b.b(r100, r102, r101, null);
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("AnnieXLynxEngine", "get or create AnnieXLynxModel from AnnieXLynxProcessCenter");
    L12:
        Intrinsics.checkNotNull(r106);
        this.f268018b = r106;
        int r107 = com.bytedance.android.anniex.api.b.f40245a;
        AnnieXLynxView r108 = com.bytedance.android.anniex.api.b.f(r103, r106, null);
        r108.setArch$anniex_release(r110.a().f268382d);
        r108.setViewScene$anniex_release(r110.a().f268383e);
        na.c r111 = this.f268020d;
        if (r111 == null) goto L15;
        r111.a();
    L15:
        this.f268019c = r108;
        return;
    L9:
        r106 = null;
        goto L10
    L5:
        r105 = null;
        goto L7
    }

    @Override // com.bytedance.salamander.anniex.g3
    public final void a(l r100) {
        e0 r101 = this.f268017a;
        e0 r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(SlcElement.KEY_PROPS);
        r101 = null;
    L5:
        Uri r103 = UriProtector.parse(r101.f268247c);
        e0 r104 = this.f268017a;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(SlcElement.KEY_PROPS);
        r104 = null;
    L8:
        com.bytedance.android.anniex.base.lifecycle.a r105 = r104.a().f268381c;
        e0 r106 = this.f268017a;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException(SlcElement.KEY_PROPS);
    L12:
        ia.c r107 = r102.a().f268380b;
        if (r103 == null) goto L16;
        String r108 = r103.toString();
        if (r108 == null) goto L16;
    L17:
        f(new u0(r100, r105, r107, r108));
        return;
    L16:
        r108 = "";
        goto L17
    L11:
        r102 = r106;
        goto L12
    }

    @Override // com.bytedance.salamander.anniex.g3
    public final void b(l r100) {
        e0 r101 = this.f268017a;
        e0 r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(SlcElement.KEY_PROPS);
        r101 = null;
    L5:
        Uri r103 = UriProtector.parse(r101.f268247c);
        e0 r104 = this.f268017a;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(SlcElement.KEY_PROPS);
        r104 = null;
    L8:
        com.bytedance.android.anniex.base.lifecycle.a r105 = r104.a().f268381c;
        e0 r106 = this.f268017a;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException(SlcElement.KEY_PROPS);
        r106 = null;
    L11:
        ia.c r107 = r106.a().f268380b;
        if (r103 == null) goto L15;
        String r108 = r103.toString();
        if (r108 == null) goto L15;
    L16:
        u0 r109 = new u0(r100, r105, r107, r108);
        AnnieXLynxView r110 = this.f268019c;
        if (r110 == null) goto L21;
        boolean r111 = true;
        if (r110.getIsFromEngine() != true) goto L21;
    L22:
        if (r111 == false) goto L32;
        AnnieXLynxView r112 = this.f268019c;
        Intrinsics.checkNotNull(r112);
        ra.a r113 = this.f268018b;
        if (r113 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("lynxModel");
        r113 = null;
    L26:
        r112.r(r109, null, r113);
        e0 r114 = this.f268017a;
        if (r114 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException(SlcElement.KEY_PROPS);
    L30:
        r102.getClass();
        return;
    L29:
        r102 = r114;
        goto L30
    L32:
        f(r109);
        return;
    L21:
        r111 = false;
    L15:
        r108 = "";
        goto L16
    }

    public final void f(u0 r100) {
        if (this.f268019c != null) goto L20;
        int r101 = com.bytedance.android.anniex.api.b.f40245a;
        e0 r102 = this.f268017a;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException(SlcElement.KEY_PROPS);
        r102 = null;
    L7:
        Context r103 = r102.a().getContext();
        ra.a r104 = this.f268018b;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("lynxModel");
        r104 = null;
    L10:
        AnnieXLynxView r105 = com.bytedance.android.anniex.api.b.f(r103, r104, null);
        e0 r106 = this.f268017a;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException(SlcElement.KEY_PROPS);
        r106 = null;
    L13:
        r105.setArch$anniex_release(r106.a().f268382d);
        e0 r107 = this.f268017a;
        if (r107 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException(SlcElement.KEY_PROPS);
        r107 = null;
    L16:
        r105.setViewScene$anniex_release(r107.a().f268383e);
        na.c r108 = this.f268020d;
        if (r108 == null) goto L19;
        r108.a();
    L19:
        this.f268019c = r105;
    L20:
        AnnieXLynxView r109 = this.f268019c;
        if (r109 == null) goto L27;
        ra.a r110 = this.f268018b;
        if (r110 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("lynxModel");
        r110 = null;
    L25:
        r109.A(r110, null, r100);
        return;
    }

    @Override // com.bytedance.salamander.anniex.g3
    public final void sendEvent(String r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        AnnieXLynxView r102 = this.f268019c;
        if (r102 == null) goto L6;
        int r103 = AnnieXLynxView.B;
        r102.O(r100, r101, true);
        return;
    }
}
