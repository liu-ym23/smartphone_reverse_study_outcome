package com.obric.memorydata.screencapture.service;

import android.accessibilityservice.AccessibilityService;

/* JADX INFO: loaded from: classes33.dex */
public class MemoryAccessibilityRegistry {
    private static IMemoryAccessibilityDelegate sDelegate;
    private static AccessibilityService sService;

    public MemoryAccessibilityRegistry() {
    }

    public static void unregisterDelegate() {
        sDelegate = null;
    }

    public static void onServiceDestroyed() {
        IMemoryAccessibilityDelegate r100 = sDelegate;
        if (r100 == null) goto L5;
        r100.onDestroy();
    L5:
        sService = null;
    }

    public static IMemoryAccessibilityDelegate getDelegate() {
        return sDelegate;
    }

    public static void onServiceConnected(AccessibilityService r100) {
        sService = r100;
        IMemoryAccessibilityDelegate r101 = sDelegate;
        if (r101 == null) goto L6;
        r101.onServiceConnected(r100);
        return;
    }

    public static void registerDelegate(IMemoryAccessibilityDelegate r100) {
        sDelegate = r100;
        AccessibilityService r101 = sService;
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r100.onServiceConnected(r101);
        return;
    L8:
        return;
    }
}
