package com.larus.gallery.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusGalleryChatTitleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f343957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f343958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f343959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f343960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f343961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f343962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f343963g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f343957a;
    }

    public static LarusGalleryChatTitleBinding a(LayoutInflater r100, ViewGroup r110) {
        View r101 = r100.inflate(R.layout.larus_gallery_chat_title, r110, false);
        int r111 = R.id.close;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r101, R.id.close);
        if (r102 == null) goto L17;
        r111 = R.id.right_img;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r101, R.id.right_img);
        if (r103 == null) goto L17;
        r111 = R.id.title_arrow;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r101, R.id.title_arrow);
        if (r104 == null) goto L17;
        r111 = R.id.title_container;
        ConstraintLayout r105 = (ConstraintLayout) ViewBindings.findChildViewById(r101, R.id.title_container);
        if (r105 == null) goto L17;
        r111 = R.id.title_desc;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r101, R.id.title_desc);
        if (r106 == null) goto L17;
        r111 = R.id.title_text;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r101, R.id.title_text);
        if (r107 == null) goto L17;
        return new LarusGalleryChatTitleBinding((ConstraintLayout) r101, r102, r103, r104, r105, r106, r107);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r111)));
    }

    public LarusGalleryChatTitleBinding(ConstraintLayout r100, ImageView r101, ImageView r102, ImageView r103, ConstraintLayout r104, TextView r105, TextView r106) {
        this.f343957a = r100;
        this.f343958b = r101;
        this.f343959c = r102;
        this.f343960d = r103;
        this.f343961e = r104;
        this.f343962f = r105;
        this.f343963g = r106;
    }
}
