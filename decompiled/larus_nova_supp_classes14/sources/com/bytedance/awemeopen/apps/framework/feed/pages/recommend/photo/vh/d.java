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
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r14.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a {
    public final AoImageView h;
    public final AoAnimationLottieView i;
    public final ImageView j;
    public PhotoModel k;
    public y l;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void g() {
        this.j.setVisibility(8);
        AoAnimationLottieView r0 = this.i;
        if (r0 == null) goto L5;
        x54.b.a(r0);
        r0.h.cancelAnimation();
    L5:
        this.h.setImageBitmap(null);
    }

    public final void q() {
        y r0 = this.l;
        if (r0 == null) goto L6;
        o(this.h, r0.a(), r0.d());
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b
    public final ImageView a() {
        return this.h;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a
    public final PhotoModel n() {
        return this.k;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b
    public final void b(boolean r3) {
        if (r3 == false) goto L4;
        this.a.setBackgroundColor(ContextCompat.getColor(this.g, 2131100268));
        return;
    L4:
        this.a.setBackgroundColor(ContextCompat.getColor(this.g, 2131100237));
    }

    public d(View r2, lz3.b r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "params");
        super(r2, r3);
        this.h = r2.findViewById(2131375012);
        this.i = this.a.findViewById(2131379091);
        this.j = (ImageView) this.a.findViewById(2131375018);
        if (r3.b.getAdapterSkinMode() == false) goto L6;
        this.a.setBackgroundColor(ContextCompat.getColor(this.g, 2131100237));
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void e(PhotoModel r11, int r12) {
        PhotoModel r13 = r11;
        Intrinsics.checkNotNullParameter(r13, "data");
        this.k = r13;
        this.l = r13.getUrlStruct();
        this.h.setOptVisibilityAggregated(Intrinsics.areEqual(this.f.b.getOptVisibilityAggregated(), Boolean.TRUE));
        this.h.setTag(2131386907, this.l);
        this.i.setAnimationConfigAndStartLoad(new AoAnimConfig(AoAnimConfig.ResMode.JSON_STRING, com.bytedance.awemeopen.infra.util.f.b(this.g.getAssets().open("aos_common_feed_photo_loading.json")), null, SlidesDetailPhotoItemViewHolder$setLoadImageAnimation$config$1.INSTANCE, 20));
        AoImageView r14 = this.h;
        y r0 = this.l;
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.a();
    L6:
        y r3 = this.l;
        if (r3 == null) goto L9;
        int r4 = r3.d();
    L10:
        o(r14, r2, r4);
        y r5 = this.l;
        if (r5 == null) goto L42;
        x54.b.a(this.j);
        AoAnimationLottieView r15 = this.i;
        if (r15 == null) goto L45;
        x54.b.d(r15);
        r15.start();
    L45:
        String r6 = this.f.b.getHostPlaceHolderUrl();     // Catch: Throwable -> L44
        if (r6 != null) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == true) goto L27;
        Uri r8 = UriProtector.parse(this.f.b.getHostPlaceHolderUrl());     // Catch: Throwable -> L44
    L28:
        if (r8 == null) goto L31;
        if (r12 != 0) goto L31;
        r1 = true;
    L31:
        long r9 = System.currentTimeMillis();
        Ref.IntRef r10 = new Ref.IntRef();
        r10.element = 1;
        lz3.b r16 = this.f;
        if (r16.d == null) goto L34;
        Map<Integer, Map<Integer, c04.f>> r17 = c04.e.a;
        c04.f r18 = c04.e.a(r16.hashCode(), r12);
        r18.b = r9;
        r18.a++;
        r18.f = 2;
    L34:
        AoImageView r19 = this.h;
        com.bytedance.awemeopen.infra.base.image.b r20 = new com.bytedance.awemeopen.infra.base.image.b(r5.c());
        if (r1 == false) goto L37;
        r20.l = r8;
    L39:
        if (this.f.d == null) goto L41;
        r20.f = new e(r10);
    L41:
        r20.e = new f(this, r5, r12, r9, r10);
        r19.j(r20);
        goto L42
    L37:
        r20.b(2131231413);
        goto L39
    L20:
        if (r6.length() == 0) goto L23;
        r7 = false;
    L27:
        r8 = null;
    L42:
        this.e.setOnTouchListener(new c(this));
        return;
    L9:
        r4 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public static final void p(d r23, boolean r24, int r25, long r26, int r28) {
        if (r23.f.d == null) goto L45;
        long r12 = System.currentTimeMillis();
        Map<Integer, Map<Integer, c04.f>> r3 = c04.e.a;
        c04.f r4 = c04.e.a(r23.f.hashCode(), r25);
        r4.c = r12;
        r4.g = r28;
        r4.f = r24 ? 1 : 0;
        if (r25 != 0) goto L8;
        boolean r2 = true;
    L9:
        lz3.a r5 = r23.f.d;
        if (r5 == null) goto L12;
        boolean r18 = r5.a;
    L13:
        if (r2 == false) goto L17;
        if (r5 == null) goto L17;
        r5.a = true;
    L17:
        d14.a r6 = b14.a.a;
        t24.a r7 = b14.a.a(t24.a.class);
        r14.c r8 = r23.f.c;
        if (r8 == null) goto L21;
        String r9 = r8.c();
        if (r9 == null) goto L21;
    L22:
        lz3.a r0 = r23.f.d;
        if (r0 == null) goto L25;
        boolean r10 = r0.f;
    L27:
        if (r28 < 3) goto L29;
        boolean r11 = true;
    L30:
        int r13 = !r24 ? 1 : 0;
        if (r0 == null) goto L33;
        long r14 = r0.b;
    L34:
        if (r0 == null) goto L36;
        long r15 = r0.c;
    L37:
        if (r0 == null) goto L39;
        long r19 = r0.d;
    L40:
        if (r0 == null) goto L42;
        long r21 = r0.e;
    L43:
        r7.t(r9, r2, r10, r11, r13, r14, r15, r19, r21, r26, r12, r18, r28);
        return;
    L42:
        r21 = 0;
        goto L43
    L39:
        r19 = 0;
        goto L40
    L36:
        r15 = 0;
        goto L37
    L33:
        r14 = 0;
        goto L34
    L29:
        r11 = false;
        goto L30
    L25:
        r10 = false;
    L21:
        r9 = "";
        goto L22
    L12:
        r18 = false;
        goto L13
    L8:
        r2 = false;
        goto L9
    }
}
