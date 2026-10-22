package com.larus.chat.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LarusWidgetChatRetryBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f324081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProgressBar f324082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f324083c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f324081a;
    }

    public static LarusWidgetChatRetryBinding a(LayoutInflater r100, ViewGroup r101) {
        if (r101 == null) goto L12;
        r100.inflate(R.layout.larus_widget_chat_retry, r101);
        int r102 = R.id.progress;
        ProgressBar r103 = (ProgressBar) ViewBindings.findChildViewById(r101, R.id.progress);
        if (r103 == null) goto L10;
        r102 = R.id.retry;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r101, R.id.retry);
        if (r104 == null) goto L10;
        return new LarusWidgetChatRetryBinding(r101, r103, r104);
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    L12:
        throw new NullPointerException("parent");
    }

    public LarusWidgetChatRetryBinding(View r100, ProgressBar r101, ImageView r102) {
        this.f324081a = r100;
        this.f324082b = r101;
        this.f324083c = r102;
    }
}
