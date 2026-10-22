package com.lynx.clay.embedding.android;

import android.view.accessibility.AccessibilityManager;

/* JADX INFO: loaded from: classes32.dex */
public final class g implements AccessibilityManager.AccessibilityStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlutterView f380661a;

    public g(FlutterView r100) {
        this.f380661a = r100;
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean r100) {
        if (r100 == true) goto L4;
        return;
    L4:
        if (this.f380661a.i() == false) goto L8;
        this.f380661a.e();
        return;
    }
}
