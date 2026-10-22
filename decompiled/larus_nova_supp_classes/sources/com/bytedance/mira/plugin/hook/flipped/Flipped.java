package com.bytedance.mira.plugin.hook.flipped;

import android.os.Build;
import com.bytedance.mira.plugin.hook.flipped.compat.FlippedImpl;
import com.bytedance.mira.plugin.hook.flipped.compat.FlippedV1Impl;
import com.bytedance.mira.plugin.hook.flipped.compat.FlippedV2Impl;
import com.bytedance.mira.plugin.hook.flipped.compat.IFlipped;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class Flipped {
    public Flipped() {
    }

    private static boolean isAndroidPHigher() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L5;
    L10:
        return true;
    L5:
        if (r0 == 27) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    private static boolean isAndroidRHigher() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 30) goto L5;
    L10:
        return true;
    L5:
        if (r0 == 29) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    private static IFlipped generate() {
        if (isAndroidRHigher() == false) goto L6;
        return new FlippedV2Impl();
    L6:
        if (isAndroidPHigher() == false) goto L9;
        return new FlippedV1Impl();
    L9:
        return new FlippedImpl();
    }

    public static void invokeHiddenApiRestrictions() {
        generate().invokeHiddenApiRestrictions();
    }
}
