package com.obric.memorydata.screencapture.service;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes6.dex */
public interface IMemoryAccessibilityDelegate {
    void onAccessibilityEvent(AccessibilityEvent r100);

    void onDestroy();

    void onInterrupt();

    void onServiceConnected(AccessibilityService r100);
}
