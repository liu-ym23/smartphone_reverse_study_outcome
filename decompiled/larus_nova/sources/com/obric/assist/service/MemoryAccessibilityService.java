package com.obric.assist.service;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import com.obric.memorydata.screencapture.service.IMemoryAccessibilityDelegate;
import com.obric.memorydata.screencapture.service.MemoryAccessibilityRegistry;

/* JADX INFO: loaded from: classes4.dex */
public class MemoryAccessibilityService extends AccessibilityService {
    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
        IMemoryAccessibilityDelegate r100 = MemoryAccessibilityRegistry.getDelegate();
        if (r100 == null) goto L6;
        r100.onInterrupt();
        return;
    }

    public MemoryAccessibilityService() {
    }

    @Override // android.app.Service
    public void onDestroy() {
        MemoryAccessibilityRegistry.onServiceDestroyed();
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onServiceConnected() {
        MemoryAccessibilityRegistry.onServiceConnected(this);
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent r100) {
        IMemoryAccessibilityDelegate r101 = MemoryAccessibilityRegistry.getDelegate();
        if (r101 == null) goto L6;
        r101.onAccessibilityEvent(r100);
        return;
    }
}
