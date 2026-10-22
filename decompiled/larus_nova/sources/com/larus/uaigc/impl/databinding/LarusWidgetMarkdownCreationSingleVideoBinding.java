package com.larus.uaigc.impl.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusWidgetMarkdownCreationSingleVideoBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f373268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f373269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f373270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f373271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProgressBar f373272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f373273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewStub f373274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewStub f373275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final VideoPlayView f373276i;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373268a;
    }

    public static LarusWidgetMarkdownCreationSingleVideoBinding a(View r110) {
        int r100 = R.id.play_btn;
        ImageView r101 = (ImageView) ViewBindings.findChildViewById(r110, R.id.play_btn);
        if (r101 == null) goto L21;
        r100 = R.id.video_cite;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r110, R.id.video_cite);
        if (r102 == null) goto L21;
        r100 = R.id.video_download;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r110, R.id.video_download);
        if (r103 == null) goto L21;
        r100 = R.id.video_download_loading;
        ProgressBar r104 = (ProgressBar) ViewBindings.findChildViewById(r110, R.id.video_download_loading);
        if (r104 == null) goto L21;
        r100 = R.id.video_extend;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r110, R.id.video_extend);
        if (r105 == null) goto L21;
        r100 = R.id.video_generate_failed_view_stub;
        ViewStub r106 = (ViewStub) ViewBindings.findChildViewById(r110, R.id.video_generate_failed_view_stub);
        if (r106 == null) goto L21;
        r100 = R.id.video_loading;
        ViewStub r111 = (ViewStub) ViewBindings.findChildViewById(r110, R.id.video_loading);
        if (r111 == null) goto L21;
        r100 = R.id.video_view;
        VideoPlayView r112 = (VideoPlayView) ViewBindings.findChildViewById(r110, R.id.video_view);
        if (r112 == null) goto L21;
        return new LarusWidgetMarkdownCreationSingleVideoBinding(r110, r101, r102, r103, r104, r105, r106, r111, r112);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r100)));
    }

    public LarusWidgetMarkdownCreationSingleVideoBinding(View r100, ImageView r101, ImageView r102, ImageView r103, ProgressBar r104, TextView r105, ViewStub r106, ViewStub r107, VideoPlayView r108) {
        this.f373268a = r100;
        this.f373269b = r101;
        this.f373270c = r102;
        this.f373271d = r103;
        this.f373272e = r104;
        this.f373273f = r105;
        this.f373274g = r106;
        this.f373275h = r107;
        this.f373276i = r108;
    }
}
