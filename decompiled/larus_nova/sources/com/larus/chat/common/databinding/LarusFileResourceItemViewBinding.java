package com.larus.chat.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ImageCoverEditView;
import com.larus.common_ui.widget.CircleProgressBarView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusFileResourceItemViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f323956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f323957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f323958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f323959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f323960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewStub f323961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewStub f323962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrameLayout f323963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f323964i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AppCompatImageView f323965j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CircleProgressBarView f323966k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AppCompatTextView f323967l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AppCompatImageView f323968m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AppCompatTextView f323969n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CircleProgressBarView f323970o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final FrameLayout f323971p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final FrameLayout f323972q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final SimpleDraweeView f323973r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ImageCoverEditView f323974s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final FrameLayout f323975t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AppCompatTextView f323976u;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f323956a;
    }

    public static LarusFileResourceItemViewBinding a(LayoutInflater r210, ViewGroup r211) {
        View r100 = r210.inflate(R.layout.larus_file_resource_item_view, r211, false);
        int r101 = R.id.duration_container_view;
        FrameLayout r102 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.duration_container_view);
        if (r102 == null) goto L49;
        r101 = R.id.duration_view;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r100, R.id.duration_view);
        if (r103 == null) goto L49;
        r101 = R.id.file_resource_content_border;
        View r104 = ViewBindings.findChildViewById(r100, R.id.file_resource_content_border);
        if (r104 == null) goto L49;
        r101 = R.id.file_resource_content_layout;
        ConstraintLayout r105 = (ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.file_resource_content_layout);
        if (r105 == null) goto L49;
        r101 = R.id.file_resource_inspect_failed_layout;
        ViewStub r106 = (ViewStub) ViewBindings.findChildViewById(r100, R.id.file_resource_inspect_failed_layout);
        if (r106 == null) goto L49;
        r101 = R.id.file_resource_parse_failed_layout;
        ViewStub r110 = (ViewStub) ViewBindings.findChildViewById(r100, R.id.file_resource_parse_failed_layout);
        if (r110 == null) goto L49;
        r101 = R.id.file_resource_re_select;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.file_resource_re_select)) == null) goto L49;
        r101 = R.id.file_resource_re_select_layout;
        FrameLayout r111 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.file_resource_re_select_layout);
        if (r111 == null) goto L49;
        r101 = R.id.file_resource_re_uplink;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.file_resource_re_uplink)) == null) goto L49;
        r101 = R.id.file_resource_re_uplink_layout;
        FrameLayout r112 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.file_resource_re_uplink_layout);
        if (r112 == null) goto L49;
        r101 = R.id.file_resource_remove;
        AppCompatImageView r113 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.file_resource_remove);
        if (r113 == null) goto L49;
        ConstraintLayout r107 = (ConstraintLayout) r100;
        r101 = R.id.file_resource_spring_review_progress;
        CircleProgressBarView r114 = (CircleProgressBarView) ViewBindings.findChildViewById(r100, R.id.file_resource_spring_review_progress);
        if (r114 == null) goto L49;
        r101 = R.id.file_resource_title;
        AppCompatTextView r115 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.file_resource_title);
        if (r115 == null) goto L49;
        r101 = R.id.file_resource_type_icon;
        AppCompatImageView r116 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.file_resource_type_icon);
        if (r116 == null) goto L49;
        r101 = R.id.file_resource_type_txt;
        AppCompatTextView r117 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.file_resource_type_txt);
        if (r117 == null) goto L49;
        r101 = R.id.file_resource_uplink_progress;
        CircleProgressBarView r118 = (CircleProgressBarView) ViewBindings.findChildViewById(r100, R.id.file_resource_uplink_progress);
        if (r118 == null) goto L49;
        r101 = R.id.file_resource_uplink_progress_layout;
        FrameLayout r119 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.file_resource_uplink_progress_layout);
        if (r119 == null) goto L49;
        r101 = R.id.file_resource_uplink_spring_review_layout;
        FrameLayout r212 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.file_resource_uplink_spring_review_layout);
        if (r212 == null) goto L49;
        r101 = R.id.image;
        SimpleDraweeView r213 = (SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.image);
        if (r213 == null) goto L49;
        r101 = R.id.image_cover_edit;
        ImageCoverEditView r214 = (ImageCoverEditView) ViewBindings.findChildViewById(r100, R.id.image_cover_edit);
        if (r214 == null) goto L49;
        r101 = R.id.subscript_container_view;
        FrameLayout r215 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.subscript_container_view);
        if (r215 == null) goto L49;
        r101 = R.id.subscript_view;
        AppCompatTextView r216 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.subscript_view);
        if (r216 == null) goto L49;
        return new LarusFileResourceItemViewBinding(r107, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r212, r213, r214, r215, r216);
    L49:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusFileResourceItemViewBinding(ConstraintLayout r100, FrameLayout r101, TextView r102, View r103, ConstraintLayout r104, ViewStub r105, ViewStub r106, FrameLayout r110, FrameLayout r111, AppCompatImageView r112, CircleProgressBarView r113, AppCompatTextView r114, AppCompatImageView r115, AppCompatTextView r116, CircleProgressBarView r117, FrameLayout r118, FrameLayout r119, SimpleDraweeView r210, ImageCoverEditView r211, FrameLayout r212, AppCompatTextView r213) {
        this.f323956a = r100;
        this.f323957b = r101;
        this.f323958c = r102;
        this.f323959d = r103;
        this.f323960e = r104;
        this.f323961f = r105;
        this.f323962g = r106;
        this.f323963h = r110;
        this.f323964i = r111;
        this.f323965j = r112;
        this.f323966k = r113;
        this.f323967l = r114;
        this.f323968m = r115;
        this.f323969n = r116;
        this.f323970o = r117;
        this.f323971p = r118;
        this.f323972q = r119;
        this.f323973r = r210;
        this.f323974s = r211;
        this.f323975t = r212;
        this.f323976u = r213;
    }
}
