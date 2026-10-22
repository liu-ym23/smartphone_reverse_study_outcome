package com.ss.android.lark.conditional.access.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.ui.loading.LKUILoadingView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes35.dex */
public final class ScsWidgetLoadingViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f417996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LKUILoadingView f417997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f417998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f417999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f418000e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f417996a;
    }

    public static ScsWidgetLoadingViewBinding a(View r100) {
        int r101 = R.id.lkui_loading_view;
        LKUILoadingView r102 = (LKUILoadingView) ViewBindings.findChildViewById(r100, R.id.lkui_loading_view);
        if (r102 == null) goto L11;
        LinearLayout r103 = (LinearLayout) r100;
        r101 = R.id.loadingMessage;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r100, R.id.loadingMessage);
        if (r104 == null) goto L11;
        r101 = R.id.loadingTitle;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r100, R.id.loadingTitle);
        if (r105 == null) goto L11;
        return new ScsWidgetLoadingViewBinding(r103, r102, r103, r104, r105);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public ScsWidgetLoadingViewBinding(LinearLayout r100, LKUILoadingView r101, LinearLayout r102, TextView r103, TextView r104) {
        this.f417996a = r100;
        this.f417997b = r101;
        this.f417998c = r102;
        this.f417999d = r103;
        this.f418000e = r104;
    }
}
