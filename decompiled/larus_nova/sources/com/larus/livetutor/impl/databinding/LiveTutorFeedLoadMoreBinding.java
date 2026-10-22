package com.larus.livetutor.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class LiveTutorFeedLoadMoreBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f355943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f355944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f355945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProgressBar f355946d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f355943a;
    }

    public static LiveTutorFeedLoadMoreBinding a(View r100) {
        int r101 = R.id.end_view;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r100, R.id.end_view);
        if (r102 == null) goto L11;
        r101 = R.id.error_lay;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.error_lay);
        if (r103 == null) goto L11;
        r101 = R.id.loading_view;
        ProgressBar r104 = (ProgressBar) ViewBindings.findChildViewById(r100, R.id.loading_view);
        if (r104 == null) goto L11;
        return new LiveTutorFeedLoadMoreBinding((FrameLayout) r100, r102, r103, r104);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LiveTutorFeedLoadMoreBinding(FrameLayout r100, TextView r101, LinearLayout r102, ProgressBar r103) {
        this.f355943a = r100;
        this.f355944b = r101;
        this.f355945c = r102;
        this.f355946d = r103;
    }
}
