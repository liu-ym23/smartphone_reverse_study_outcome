package com.larus.share.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusDialogFragmentSlidesShareBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f368603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f368604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f368605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f368606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f368607e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f368608f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f368609g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f368603a;
    }

    public static LarusDialogFragmentSlidesShareBinding a(LayoutInflater r100, ViewGroup r110) {
        View r101 = r100.inflate(R.layout.larus_dialog_fragment_slides_share, r110, false);
        int r111 = R.id.close_iv;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r101, R.id.close_iv);
        if (r102 == null) goto L23;
        r111 = R.id.divider;
        if (((ImageView) ViewBindings.findChildViewById(r101, R.id.divider)) == null) goto L23;
        r111 = R.id.privacy_iv;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r101, R.id.privacy_iv);
        if (r103 == null) goto L23;
        r111 = R.id.privacy_title;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r101, R.id.privacy_title);
        if (r104 == null) goto L23;
        r111 = R.id.private_next;
        if (((ImageView) ViewBindings.findChildViewById(r101, R.id.private_next)) == null) goto L23;
        r111 = R.id.share_panel;
        RecyclerView r105 = (RecyclerView) ViewBindings.findChildViewById(r101, R.id.share_panel);
        if (r105 == null) goto L23;
        r111 = R.id.share_subtitle_privacy;
        ConstraintLayout r106 = (ConstraintLayout) ViewBindings.findChildViewById(r101, R.id.share_subtitle_privacy);
        if (r106 == null) goto L23;
        r111 = R.id.share_title;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r101, R.id.share_title);
        if (r107 == null) goto L23;
        r111 = R.id.share_title_container;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r101, R.id.share_title_container)) == null) goto L23;
        return new LarusDialogFragmentSlidesShareBinding((FrameLayout) r101, r102, r103, r104, r105, r106, r107);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r111)));
    }

    public LarusDialogFragmentSlidesShareBinding(FrameLayout r100, ImageView r101, ImageView r102, TextView r103, RecyclerView r104, ConstraintLayout r105, TextView r106) {
        this.f368603a = r100;
        this.f368604b = r101;
        this.f368605c = r102;
        this.f368606d = r103;
        this.f368607e = r104;
        this.f368608f = r105;
        this.f368609g = r106;
    }
}
