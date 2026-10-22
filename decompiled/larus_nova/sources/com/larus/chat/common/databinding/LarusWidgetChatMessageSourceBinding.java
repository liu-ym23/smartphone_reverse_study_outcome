package com.larus.chat.common.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes4.dex */
public final class LarusWidgetChatMessageSourceBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f324079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f324080b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f324079a;
    }

    public LarusWidgetChatMessageSourceBinding(View r100, TextView r101) {
        this.f324079a = r100;
        this.f324080b = r101;
    }
}
