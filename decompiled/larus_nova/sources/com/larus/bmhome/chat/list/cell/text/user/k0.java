package com.larus.bmhome.chat.list.cell.text.user;

import android.view.View;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;

/* JADX INFO: loaded from: classes25.dex */
public final class k0 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f306484a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
    }

    public k0(CustomMarkdownTextView r100) {
        this.f306484a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        this.f306484a.removeOnAttachStateChangeListener(this);
    }
}
