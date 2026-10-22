package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model.PhotoModel;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimConfig;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimationLottieView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r14.y;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AoImageView f195374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AoAnimationLottieView f195375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f195376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PhotoModel f195377k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public y f195378l;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void g() {
        this.f195376j.setVisibility(8);
        AoAnimationLottieView r100 = this.f195375i;
        if (r100 == null) goto L5;
        x54.b.a(r100);
        r100.f198576h.cancelAnimation();
    L5:
        this.f195374h.setImageBitmap(null);
    }

    public final void q() {
        y r100 = this.f195378l;
        if (r100 == null) goto L6;
        o(this.f195374h, r100.a(), r100.d());
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b
    public final ImageView a() {
        return this.f195374h;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a
    public final PhotoModel n() {
        return this.f195377k;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b
    public final void b(boolean r100) {
        if (r100 == false) goto L4;
        this.f197058a.setBackgroundColor(ContextCompat.getColor(this.f195372g, R.color.aos_const_bg_inverse));
        return;
    L4:
        this.f197058a.setBackgroundColor(ContextCompat.getColor(this.f195372g, R.color.aos_bg_container));
    }

    public d(View r100, lz3.b r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "params");
        super(r100, r101);
        this.f195374h = (AoImageView) r100.findViewById(R.id.image_iv);
        this.f195375i = (AoAnimationLottieView) this.f197058a.findViewById(R.id.loading_view);
        this.f195376j = (ImageView) this.f197058a.findViewById(R.id.image_load_fail);
        if (r101.f511362b.getAdapterSkinMode() == false) goto L6;
        this.f197058a.setBackgroundColor(ContextCompat.getColor(this.f195372g, R.color.aos_bg_container));
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void e(PhotoModel r110, int r111) {
        PhotoModel r112 = r110;
        Intrinsics.checkNotNullParameter(r112, "data");
        this.f195377k = r112;
        this.f195378l = r112.getUrlStruct();
        this.f195374h.setOptVisibilityAggregated(Intrinsics.areEqual(this.f195371f.f511362b.getOptVisibilityAggregated(), Boolean.TRUE));
        this.f195374h.setTag(R.id.slides_photo_preview_id, this.f195378l);
        this.f195375i.setAnimationConfigAndStartLoad(new AoAnimConfig(AoAnimConfig.ResMode.JSON_STRING, com.bytedance.awemeopen.infra.util.f.b(this.f195372g.getAssets().open("aos_common_feed_photo_loading.json")), null, SlidesDetailPhotoItemViewHolder$setLoadImageAnimation$config$1.INSTANCE, 20));
        AoImageView r113 = this.f195374h;
        y r100 = this.f195378l;
        boolean r101 = false;
        if (r100 == null) goto L5;
        int r102 = r100.a();
    L6:
        y r103 = this.f195378l;
        if (r103 == null) goto L9;
        int r104 = r103.d();
    L10:
        o(r113, r102, r104);
        y r105 = this.f195378l;
        if (r105 == null) goto L42;
        x54.b.a(this.f195376j);
        AoAnimationLottieView r114 = this.f195375i;
        if (r114 == null) goto L45;
        x54.b.d(r114);
        r114.start();
    L45:
        String r106 = this.f195371f.f511362b.getHostPlaceHolderUrl();     // Catch: Throwable -> L44
        if (r106 != null) goto L20;
    L23:
        boolean r107 = true;
    L24:
        if (r107 == true) goto L27;
        Uri r108 = UriProtector.parse(this.f195371f.f511362b.getHostPlaceHolderUrl());     // Catch: Throwable -> L44
    L28:
        if (r108 == null) goto L31;
        if (r111 != 0) goto L31;
        r101 = true;
    L31:
        long r109 = System.currentTimeMillis();
        Ref.IntRef r115 = new Ref.IntRef();
        r115.element = 1;
        lz3.b r116 = this.f195371f;
        if (r116.f511364d == null) goto L34;
        Map<Integer, Map<Integer, c04.f>> r117 = c04.e.f21917a;
        c04.f r118 = c04.e.a(r116.hashCode(), r111);
        r118.f21919b = r109;
        r118.f21918a++;
        r118.f21923f = 2;
    L34:
        AoImageView r119 = this.f195374h;
        com.bytedance.awemeopen.infra.base.image.b r120 = new com.bytedance.awemeopen.infra.base.image.b(r105.c());
        if (r101 == false) goto L37;
        r120.f198631l = r108;
    L39:
        if (this.f195371f.f511364d == null) goto L41;
        r120.f198625f = new e(r115);
    L41:
        r120.f198624e = new f(this, r105, r111, r109, r115);
        r119.j(r120);
        goto L42
    L37:
        r120.b(R.drawable.aos_common_feed_ic_video_loading_background);
        goto L39
    L20:
        if (r106.length() == 0) goto L23;
        r107 = false;
    L27:
        r108 = null;
    L42:
        this.f195370e.setOnTouchListener(new c(this));
        return;
    L9:
        r104 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public static final void p(d r210, boolean r211, int r212, long r213, int r214) {
        if (r210.f195371f.f511364d == null) goto L45;
        long r110 = System.currentTimeMillis();
        Map<Integer, Map<Integer, c04.f>> r100 = c04.e.f21917a;
        c04.f r101 = c04.e.a(r210.f195371f.hashCode(), r212);
        r101.f21920c = r110;
        r101.f21924g = r214;
        r101.f21923f = r211 ? 1 : 0;
        if (r212 != 0) goto L8;
        boolean r102 = true;
    L9:
        lz3.a r103 = r210.f195371f.f511364d;
        if (r103 == null) goto L12;
        boolean r111 = r103.f511355a;
    L13:
        if (r102 == false) goto L17;
        if (r103 == null) goto L17;
        r103.f511355a = true;
    L17:
        d14.a r104 = b14.a.f16924a;
        t24.a r105 = (t24.a) b14.a.a(t24.a.class);
        r14.c r106 = r210.f195371f.f511363c;
        if (r106 == null) goto L21;
        String r107 = r106.c();
        if (r107 == null) goto L21;
    L22:
        lz3.a r108 = r210.f195371f.f511364d;
        if (r108 == null) goto L25;
        boolean r109 = r108.f511360f;
    L27:
        if (r214 < 3) goto L29;
        boolean r112 = true;
    L30:
        int r113 = !r211 ? 1 : 0;
        if (r108 == null) goto L33;
        long r114 = r108.f511356b;
    L34:
        if (r108 == null) goto L36;
        long r115 = r108.f511357c;
    L37:
        if (r108 == null) goto L39;
        long r116 = r108.f511358d;
    L40:
        if (r108 == null) goto L42;
        long r215 = r108.f511359e;
    L43:
        r105.t(r107, r102, r109, r112, r113, r114, r115, r116, r215, r213, r110, r111, r214);
        return;
    L42:
        r215 = 0;
        goto L43
    L39:
        r116 = 0;
        goto L40
    L36:
        r115 = 0;
        goto L37
    L33:
        r114 = 0;
        goto L34
    L29:
        r112 = false;
        goto L30
    L25:
        r109 = false;
    L21:
        r107 = "";
        goto L22
    L12:
        r111 = false;
        goto L13
    L8:
        r102 = false;
        goto L9
    }
}
