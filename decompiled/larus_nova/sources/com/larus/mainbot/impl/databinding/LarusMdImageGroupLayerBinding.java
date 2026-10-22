package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusMdImageGroupLayerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f358733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f358734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f358735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f358736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CardView f358737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f358738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RelativeLayout f358739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f358740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MarkdownSourceImageView f358741i;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358733a;
    }

    public static LarusMdImageGroupLayerBinding a(View r110) {
        int r100 = R.id.image_group_img;
        SimpleDraweeView r101 = (SimpleDraweeView) ViewBindings.findChildViewById(r110, R.id.image_group_img);
        if (r101 == null) goto L21;
        r100 = R.id.image_group_img_more_tag;
        AppCompatTextView r102 = (AppCompatTextView) ViewBindings.findChildViewById(r110, R.id.image_group_img_more_tag);
        if (r102 == null) goto L21;
        r100 = R.id.maskView;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r110, R.id.maskView);
        if (r103 == null) goto L21;
        r100 = R.id.mdCardView;
        CardView r104 = (CardView) ViewBindings.findChildViewById(r110, R.id.mdCardView);
        if (r104 == null) goto L21;
        LinearLayout r105 = (LinearLayout) r110;
        r100 = R.id.md_image_group_main_layer;
        ConstraintLayout r106 = (ConstraintLayout) ViewBindings.findChildViewById(r110, R.id.md_image_group_main_layer);
        if (r106 == null) goto L21;
        r100 = R.id.md_image_group_retry_layer;
        RelativeLayout r107 = (RelativeLayout) ViewBindings.findChildViewById(r110, R.id.md_image_group_retry_layer);
        if (r107 == null) goto L21;
        r100 = R.id.mdImgCaption;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r110, R.id.mdImgCaption);
        if (r111 == null) goto L21;
        r100 = R.id.sourceIcon;
        MarkdownSourceImageView r112 = (MarkdownSourceImageView) ViewBindings.findChildViewById(r110, R.id.sourceIcon);
        if (r112 == null) goto L21;
        return new LarusMdImageGroupLayerBinding(r105, r101, r102, r103, r104, r106, r107, r111, r112);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r100)));
    }

    public LarusMdImageGroupLayerBinding(LinearLayout r100, SimpleDraweeView r101, AppCompatTextView r102, ImageView r103, CardView r104, ConstraintLayout r105, RelativeLayout r106, TextView r107, MarkdownSourceImageView r108) {
        this.f358733a = r100;
        this.f358734b = r101;
        this.f358735c = r102;
        this.f358736d = r103;
        this.f358737e = r104;
        this.f358738f = r105;
        this.f358739g = r106;
        this.f358740h = r107;
        this.f358741i = r108;
    }
}
