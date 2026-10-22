package com.lynx.tasm.behavior.ui.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;

/* JADX INFO: loaded from: classes32.dex */
public final class c extends View.AccessibilityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f382453a;

    public c(d r100) {
        this.f382453a = r100;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View r100) {
        return this.f382453a.f382466l;
    }
}
