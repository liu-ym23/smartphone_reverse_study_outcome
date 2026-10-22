package com.larus.common_res.common_ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusItemLoadMoreBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f326720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f326721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f326722c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f326720a;
    }

    public static LarusItemLoadMoreBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_item_load_more, r101, false);
        int r103 = R.id.error_lay;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r102, R.id.error_lay);
        if (r104 == null) goto L9;
        r103 = R.id.loading;
        ProgressBar r105 = (ProgressBar) ViewBindings.findChildViewById(r102, R.id.loading);
        if (r105 == null) goto L9;
        return new LarusItemLoadMoreBinding((FrameLayout) r102, r104, r105);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusItemLoadMoreBinding(FrameLayout r100, LinearLayout r101, ProgressBar r102) {
        this.f326720a = r100;
        this.f326721b = r101;
        this.f326722c = r102;
    }
}
