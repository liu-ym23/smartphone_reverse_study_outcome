package com.bytedance.locallife.biz.utils;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f256985a;

    public a(b r100) {
        this.f256985a = r100;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        b r102 = this.f256985a;
        if (r102 == null) goto L6;
        r102.a(r101);
        return;
    }
}
