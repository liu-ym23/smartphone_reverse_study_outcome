package com.bytedance.locallife.poi.poidetail.screenshot.ui;

import android.view.View;
import androidx.core.app.LifeAccessibilityUtil;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements LifeAccessibilityUtil.AccessibilityDelegateCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f264206a;

    public b(String r100) {
        this.f264206a = r100;
    }

    @Override // androidx.core.app.LifeAccessibilityUtil.AccessibilityDelegateCallBack
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        r101.setContentDescription(this.f264206a);
    }
}
