package com.bytedance.awemeopen.apps.framework.comment.view.commentimage;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.feed.desc.MentionTextView;
import com.bytedance.awemeopen.bizmodels.comment.CommentImageStruct;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimConfig;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimationLottieView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.infra.util.f;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends qy3.a {
    public final AoImageView h;
    public final AoAnimationLottieView i;
    public final ImageView j;
    public final MentionTextView k;
    public o14.a l;
    public t14.a m;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b
    public final ImageView a() {
        throw null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b
    public final void b(boolean r1) {
        throw null;
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

    public final String n() {
        o14.a r0 = this.l;
        if (r0 == null) goto L8;
        User r1 = r0.o();
        if (r1 == null) goto L8;
        String r2 = r1.t();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public d(View r2, py3.a r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "params");
        super(r2, r3);
        this.h = r2.findViewById(2131375012);
        this.i = this.a.findViewById(2131379091);
        this.j = (ImageView) this.a.findViewById(2131375018);
        this.k = (MentionTextView) this.a.findViewById(2131390765);
        if (r3.c.getAdapterSkinMode() == false) goto L5;
        this.a.setBackgroundColor(ContextCompat.getColor(this.g, 2131100237));
    L5:
        o14.a r4 = this.l;
        if (r4 == null) goto L15;
        List r5 = r4.f();
        if (r5 == null) goto L16;
        CommentImageStruct r6 = (CommentImageStruct) CollectionsKt.firstOrNull(r5);
        if (r6 != null) goto L12;
        return;
    L12:
        if (r6.getOriginUrl() != null) goto L18;
        r6.getCropUrl();
        return;
    L18:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void e(o14.a r7, int r8) {
        o14.a r9 = r7;
        Intrinsics.checkNotNullParameter(r9, "data");
        this.l = r9;
        List r10 = r9.f();
        if (r10 == null) goto L9;
        CommentImageStruct r11 = (CommentImageStruct) CollectionsKt.firstOrNull(r10);
        if (r11 == null) goto L9;
        t14.a r0 = r11.getOriginUrl();
        if (r0 != null) goto L10;
        r0 = r11.getCropUrl();
    L10:
        this.m = r0;
        this.h.setTag(2131386907, r0);
        this.i.setAnimationConfigAndStartLoad(new AoAnimConfig(AoAnimConfig.ResMode.JSON_STRING, f.b(this.g.getAssets().open("aos_common_feed_photo_loading.json")), null, SlidesImageItemViewHolder$setLoadImageAnimation$config$1.INSTANCE, 20));
        t14.a r12 = this.m;
        if (r12 == null) goto L18;
        x54.b.a(this.j);
        AoAnimationLottieView r1 = this.i;
        if (r1 == null) goto L16;
        x54.b.d(r1);
        r1.start();
    L16:
        AoImageView r2 = this.h;
        com.bytedance.awemeopen.infra.base.image.b r3 = new com.bytedance.awemeopen.infra.base.image.b(r12.g());
        r3.b(2131231413);
        r3.m = ImageView.ScaleType.FIT_CENTER;
        r3.e = new e(this, r12);
        r2.j(r3);
    L18:
        if (TextUtils.isEmpty(n()) == false) goto L24;
        o14.a r13 = this.l;
        if (r13 == null) goto L23;
        CharSequence r14 = r13.l();
        if (r14 == null) goto L23;
    L37:
        if (TextUtils.isEmpty(r14) == true) goto L39;
        this.k.setText(r14);
        this.k.setVisibility(0);
        v04.b.a(this.k);
    L40:
        o14.a r15 = this.l;
        if (r15 == null) goto L43;
        List r16 = r15.m();
    L45:
        if (com.bytedance.awemeopen.infra.util.d.a(r16) == true) goto L47;
        this.k.setSpanColor(this.a.getResources().getColor(2131100246));
        o14.a r17 = this.l;
        Intrinsics.checkNotNull(r17);
        this.k.y(com.bytedance.awemeopen.apps.framework.comment.util.e.b(r17, this.a.getContext()), null);
    L47:
        this.e.setOnTouchListener(new b(this));
        this.e.setOnClickListener(new c(this));
        return;
    L43:
        r16 = null;
        goto L45
    L39:
        this.k.setVisibility(8);
    L23:
        r14 = "";
        goto L37
    L24:
        o14.a r18 = this.l;
        if (r18 == null) goto L27;
        String r19 = r18.l();
    L29:
        if (TextUtils.isEmpty(r19) == false) goto L31;
        r14 = "@".concat(n());
        goto L37
    L31:
        StringBuilder r20 = new StringBuilder("@");
        r20.append(n());
        r20.append("：");
        o14.a r4 = this.l;
        if (r4 == null) goto L34;
        String r5 = r4.l();
    L35:
        r20.append(r5);
        r14 = r20.toString();
        goto L37
    L34:
        r5 = null;
        goto L35
    L27:
        r19 = null;
    L9:
        r0 = null;
        goto L10
    }
}
