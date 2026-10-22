package com.bytedance.ee.bear.facade.common;

import android.app.Activity;
import android.content.Context;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.utils.ContextsKt;
import kotlin.jvm.internal.Intrinsics;
import sa5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class FragmentBackPressedHelperKt {
    public static final void a(final Fragment r3, final d r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "backPressHandler");
        OnBackPressedCallback r0 = new FragmentBackPressedHelperKt$handleBackPress$backPressedCallback$1(r3, r4);
        Context r5 = r3.getContext();
        FragmentActivity r1 = null;
        if (r5 == null) goto L5;
        Activity r6 = ContextsKt.findActivity(r5);
    L7:
        if ((r6 instanceof FragmentActivity) == false) goto L9;
        r1 = (FragmentActivity) r6;
    L9:
        if (r1 == null) goto L14;
        OnBackPressedDispatcher r7 = r1.getOnBackPressedDispatcher();
        if (r7 == null) goto L15;
        r7.addCallback(r3, r0);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r6 = null;
        goto L7
    }
}
