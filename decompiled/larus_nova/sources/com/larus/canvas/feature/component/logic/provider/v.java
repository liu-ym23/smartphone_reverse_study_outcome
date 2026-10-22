package com.larus.canvas.feature.component.logic.provider;

import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.larus.bmhome.bigimg.m1;
import com.larus.bmhome.bigimg.widget.CreationSidebarView;
import com.larus.gallery.impl.databinding.LarusLayoutGalleryCreationSideBarBinding;
import com.larus.utils.e1;
import com.larus.utils.y0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class v extends com.larus.gallery.api.t<ky8.a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f323463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LarusLayoutGalleryCreationSideBarBinding f323464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f323465h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f323466i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ky8.a f323467j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f323468k;

    @Override // com.larus.gallery.api.t
    public final void v() {
        ValueAnimator r100 = this.f323466i;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f323466i = null;
    }

    public v(j r100) {
        Intrinsics.checkNotNullParameter(r100, "canvasGalleryContext");
        this.f323463f = r100;
        this.f323465h = LazyKt.lazy(new k(this));
        int r101 = r100.f323442a;
        this.f323468k = true;
    }

    @Override // com.larus.gallery.api.t
    public final View p(ViewGroup r110) {
        LarusLayoutGalleryCreationSideBarBinding r111 = LarusLayoutGalleryCreationSideBarBinding.a(LayoutInflater.from(getContext()), r110);
        this.f323464g = r111;
        CreationSidebarView r100 = r111.f343988b;
        if (r100 == null) goto L5;
        ic8.d r101 = ((jy9.e) this.f323465h.getValue()).f500981a;
        CreationSidebarView.S5(r100, ((jy9.e) this.f323465h.getValue()).f500982b, r101, ((jy9.e) this.f323465h.getValue()).f500983c, ((jy9.e) this.f323465h.getValue()).f500984d, ((jy9.e) this.f323465h.getValue()).f500985e, null, new n(this), null, 416);
    L5:
        LarusLayoutGalleryCreationSideBarBinding r112 = this.f323464g;
        if (r112 != null) goto L10;
        return null;
    L10:
        return r112.f343987a;
    }

    /* JADX WARN: Type inference failed for: r13v1, types: [T, java.lang.Object, ky8.a] */
    @Override // com.larus.gallery.api.t
    public final void w(ky8.a r110, int r111) {
        ky8.a r112 = r110;
        Intrinsics.checkNotNullParameter(r112, "data");
        this.f343898d = r112;
        this.f323467j = r112;
        boolean r100 = true;
        if (r111 != this.f323463f.f323442a) goto L5;
        boolean r113 = true;
    L7:
        if (r113 == false) goto L28;
        if (this.f323468k == false) goto L28;
        this.f323468k = false;
        if (Intrinsics.areEqual(r112.f506662a, PlayerResolution.SDKKEY.ORIGIN) == false) goto L17;
        LarusLayoutGalleryCreationSideBarBinding r114 = this.f323464g;
        if (r114 == null) goto L56;
        CreationSidebarView r115 = r114.f343988b;
        if (r115 == null) goto L57;
        e1.o(r115);
        return;
    L57:
        return;
    L56:
        return;
    L17:
        LarusLayoutGalleryCreationSideBarBinding r116 = this.f323464g;
        if (r116 == null) goto L22;
        CreationSidebarView r117 = r116.f343988b;
        if (r117 == null) goto L22;
        e1.x(r117);
    L22:
        LarusLayoutGalleryCreationSideBarBinding r118 = this.f323464g;
        if (r118 == null) goto L59;
        CreationSidebarView r101 = r118.f343988b;
        if (r101 == null) goto L60;
        CreationSidebarView.R5(r101, y0.j(r112.f506668g), new m1(null, null, null, r112.f506670i, r112.f506671j, r112.f506664c, 7), null, null, false, null, 48);
        return;
    L60:
        return;
    L59:
        return;
    L28:
        if (Intrinsics.areEqual(r112.f506662a, PlayerResolution.SDKKEY.ORIGIN) == false) goto L42;
        LarusLayoutGalleryCreationSideBarBinding r119 = this.f323464g;
        if (r119 == null) goto L39;
        CreationSidebarView r120 = r119.f343988b;
        if (r120 == null) goto L39;
        if (r120.getVisibility() != 0) goto L36;
        boolean r121 = true;
    L37:
        if (r121 != true) goto L39;
    L40:
        if (r100 == false) goto L62;
        ValueAnimator r122 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r122.setDuration(this.f323463f.f323444c);
        r122.addUpdateListener(new l(this));
        r122.addListener(new t(this));
        this.f323466i = r122;
        r122.start();
        return;
    L62:
        return;
    L36:
        r121 = false;
    L39:
        r100 = false;
        goto L40
    L42:
        LarusLayoutGalleryCreationSideBarBinding r123 = this.f323464g;
        if (r123 == null) goto L52;
        CreationSidebarView r124 = r123.f343988b;
        if (r124 == null) goto L52;
        if (r124.getVisibility() != 0) goto L49;
        boolean r125 = true;
    L50:
        if (r125 == true) goto L52;
    L53:
        if (r100 == false) goto L64;
        ValueAnimator r126 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r126.setDuration(this.f323463f.f323444c);
        r126.addUpdateListener(new m(this));
        r126.addListener(new u(this, r112));
        this.f323466i = r126;
        r126.start();
        return;
    L64:
        return;
    L49:
        r125 = false;
    L52:
        r100 = false;
        goto L53
    L5:
        r113 = false;
        goto L7
    }
}
