package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ImageCoverEditView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusItemMarkdownCreationImageScrollBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f373174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f373175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageCoverEditView f373176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f373177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProgressBar f373178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewStub f373179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f373180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f373181h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f373182i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SimpleDraweeView f373183j;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373174a;
    }

    public static LarusItemMarkdownCreationImageScrollBinding a(LayoutInflater r110, ViewGroup r111) {
        View r112 = r110.inflate(R.layout.larus_item_markdown_creation_image_scroll, r111, false);
        int r113 = R.id.image_cite;
        ImageView r100 = (ImageView) ViewBindings.findChildViewById(r112, R.id.image_cite);
        if (r100 == null) goto L23;
        r113 = R.id.image_cover_edit;
        ImageCoverEditView r101 = (ImageCoverEditView) ViewBindings.findChildViewById(r112, R.id.image_cover_edit);
        if (r101 == null) goto L23;
        r113 = R.id.image_download;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r112, R.id.image_download);
        if (r102 == null) goto L23;
        r113 = R.id.image_download_loading;
        ProgressBar r103 = (ProgressBar) ViewBindings.findChildViewById(r112, R.id.image_download_loading);
        if (r103 == null) goto L23;
        r113 = R.id.image_loading;
        ViewStub r104 = (ViewStub) ViewBindings.findChildViewById(r112, R.id.image_loading);
        if (r104 == null) goto L23;
        r113 = R.id.image_share;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r112, R.id.image_share);
        if (r105 == null) goto L23;
        r113 = R.id.image_tips_layout;
        LinearLayout r106 = (LinearLayout) ViewBindings.findChildViewById(r112, R.id.image_tips_layout);
        if (r106 == null) goto L23;
        r113 = R.id.image_tips_text;
        AppCompatTextView r114 = (AppCompatTextView) ViewBindings.findChildViewById(r112, R.id.image_tips_text);
        if (r114 == null) goto L23;
        r113 = R.id.image_view;
        SimpleDraweeView r115 = (SimpleDraweeView) ViewBindings.findChildViewById(r112, R.id.image_view);
        if (r115 == null) goto L23;
        return new LarusItemMarkdownCreationImageScrollBinding((ConstraintLayout) r112, r100, r101, r102, r103, r104, r105, r106, r114, r115);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r113)));
    }

    public LarusItemMarkdownCreationImageScrollBinding(ConstraintLayout r100, ImageView r101, ImageCoverEditView r102, ImageView r103, ProgressBar r104, ViewStub r105, ImageView r106, LinearLayout r107, AppCompatTextView r108, SimpleDraweeView r110) {
        this.f373174a = r100;
        this.f373175b = r101;
        this.f373176c = r102;
        this.f373177d = r103;
        this.f373178e = r104;
        this.f373179f = r105;
        this.f373180g = r106;
        this.f373181h = r107;
        this.f373182i = r108;
        this.f373183j = r110;
    }
}
