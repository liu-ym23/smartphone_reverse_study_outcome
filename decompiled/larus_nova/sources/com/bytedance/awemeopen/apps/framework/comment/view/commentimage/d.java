package com.bytedance.awemeopen.apps.framework.comment.view.commentimage;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.feed.desc.MentionTextView;
import com.bytedance.awemeopen.bizmodels.comment.CommentImageStruct;
import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimConfig;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimationLottieView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.infra.util.f;
import com.larus.nova.R;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends qy3.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AoImageView f194220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AoAnimationLottieView f194221i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f194222j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MentionTextView f194223k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public o14.a f194224l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public t14.a f194225m;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b
    public final ImageView a() {
        throw null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b
    public final void b(boolean r100) {
        throw null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void g() {
        this.f194222j.setVisibility(8);
        AoAnimationLottieView r100 = this.f194221i;
        if (r100 == null) goto L5;
        x54.b.a(r100);
        r100.f198576h.cancelAnimation();
    L5:
        this.f194220h.setImageBitmap(null);
    }

    public final String n() {
        o14.a r100 = this.f194224l;
        if (r100 == null) goto L8;
        User r101 = r100.o();
        if (r101 == null) goto L8;
        String r102 = r101.t();
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    public d(View r100, py3.a r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "params");
        super(r100, r101);
        this.f194220h = (AoImageView) r100.findViewById(R.id.image_iv);
        this.f194221i = (AoAnimationLottieView) this.f197058a.findViewById(R.id.loading_view);
        this.f194222j = (ImageView) this.f197058a.findViewById(R.id.image_load_fail);
        this.f194223k = (MentionTextView) this.f197058a.findViewById(R.id.tv_image_comment_content);
        if (r101.f531024c.getAdapterSkinMode() == false) goto L5;
        this.f197058a.setBackgroundColor(ContextCompat.getColor(this.f535187g, R.color.aos_bg_container));
    L5:
        o14.a r102 = this.f194224l;
        if (r102 == null) goto L15;
        List<CommentImageStruct> r103 = r102.f();
        if (r103 == null) goto L16;
        CommentImageStruct r104 = (CommentImageStruct) CollectionsKt.firstOrNull(r103);
        if (r104 != null) goto L12;
        return;
    L12:
        if (r104.getOriginUrl() != null) goto L18;
        r104.getCropUrl();
        return;
    L18:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void e(o14.a r100, int r101) {
        o14.a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        this.f194224l = r102;
        List<CommentImageStruct> r103 = r102.f();
        if (r103 == null) goto L9;
        CommentImageStruct r104 = (CommentImageStruct) CollectionsKt.firstOrNull(r103);
        if (r104 == null) goto L9;
        t14.a r105 = r104.getOriginUrl();
        if (r105 != null) goto L10;
        r105 = r104.getCropUrl();
    L10:
        this.f194225m = r105;
        this.f194220h.setTag(R.id.slides_photo_preview_id, r105);
        this.f194221i.setAnimationConfigAndStartLoad(new AoAnimConfig(AoAnimConfig.ResMode.JSON_STRING, f.b(this.f535187g.getAssets().open("aos_common_feed_photo_loading.json")), null, SlidesImageItemViewHolder$setLoadImageAnimation$config$1.INSTANCE, 20));
        t14.a r106 = this.f194225m;
        if (r106 == null) goto L18;
        x54.b.a(this.f194222j);
        AoAnimationLottieView r107 = this.f194221i;
        if (r107 == null) goto L16;
        x54.b.d(r107);
        r107.start();
    L16:
        AoImageView r108 = this.f194220h;
        com.bytedance.awemeopen.infra.base.image.b r109 = new com.bytedance.awemeopen.infra.base.image.b(r106.g());
        r109.b(R.drawable.aos_common_feed_ic_video_loading_background);
        r109.f198632m = ImageView.ScaleType.FIT_CENTER;
        r109.f198624e = new e(this, r106);
        r108.j(r109);
    L18:
        if (TextUtils.isEmpty(n()) == false) goto L24;
        o14.a r110 = this.f194224l;
        if (r110 == null) goto L23;
        String r111 = r110.l();
        if (r111 == null) goto L23;
    L37:
        if (TextUtils.isEmpty(r111) == true) goto L39;
        this.f194223k.setText(r111);
        this.f194223k.setVisibility(0);
        v04.b.a(this.f194223k);
    L40:
        o14.a r112 = this.f194224l;
        if (r112 == null) goto L43;
        List<TextExtraStruct> r113 = r112.m();
    L45:
        if (com.bytedance.awemeopen.infra.util.d.a(r113) == true) goto L47;
        this.f194223k.setSpanColor(this.f197058a.getResources().getColor(R.color.aos_color_eba825_90));
        o14.a r114 = this.f194224l;
        Intrinsics.checkNotNull(r114);
        this.f194223k.y(com.bytedance.awemeopen.apps.framework.comment.util.e.b(r114, this.f197058a.getContext()), null);
    L47:
        this.f535185e.setOnTouchListener(new b(this));
        this.f535185e.setOnClickListener(new c(this));
        return;
    L43:
        r113 = null;
        goto L45
    L39:
        this.f194223k.setVisibility(8);
    L23:
        r111 = "";
        goto L37
    L24:
        o14.a r115 = this.f194224l;
        if (r115 == null) goto L27;
        String r116 = r115.l();
    L29:
        if (TextUtils.isEmpty(r116) == false) goto L31;
        r111 = "@".concat(n());
        goto L37
    L31:
        StringBuilder r117 = new StringBuilder("@");
        r117.append(n());
        r117.append("：");
        o14.a r118 = this.f194224l;
        if (r118 == null) goto L34;
        String r119 = r118.l();
    L35:
        r117.append(r119);
        r111 = r117.toString();
        goto L37
    L34:
        r119 = null;
        goto L35
    L27:
        r116 = null;
    L9:
        r105 = null;
        goto L10
    }
}
