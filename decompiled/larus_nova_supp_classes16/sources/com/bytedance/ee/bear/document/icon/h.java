package com.bytedance.ee.bear.document.icon;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.contract.icon.IconInfo;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h extends BaseTitleBar.e {
    public final /* synthetic */ IconSelectFragment j;

    public final void performAction(View r9) {
        IconSelectFragment r10 = this.j;
        int r0 = IconSelectFragment.s;
        r10.getClass();
        tt5.a.b("IconSelectFragment", "random select icon");
        IconViewModel r1 = r10.i;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L5:
        List r2 = (List) r1.getIconInfoList().getValue();
        if (r2 == null) goto L8;
        Integer r3 = Integer.valueOf(r2.size());
    L9:
        if (r3 != null) goto L11;
    L30:
        this.j.close();
        return;
    L11:
        if (r3.intValue() == 0) goto L30;
        IconViewModel r4 = r10.i;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L16:
        IconInfo r5 = (IconInfo) r4.getSelectedIcon().getValue();
        ArrayList r6 = new ArrayList();
        Iterator r7 = r2.iterator();
    L18:
        if (r7.hasNext() == false) goto L27;
        Object r8 = r7.next();
        DocIconNetResult.Icon r11 = (DocIconNetResult.Icon) r8;
        if (r5 == null) goto L22;
        String r12 = r5.getKey();
    L24:
        if ((true ^ TextUtils.equals(r12, r11.key)) == false) goto L18;
        r6.add(r8);
        goto L18
    L22:
        r12 = null;
        goto L24
    L27:
        if (r6.isEmpty() == true) goto L30;
        r10.U90((DocIconNetResult.Icon) CollectionsKt.random(r6, Random.Default), true);
        goto L30
    L8:
        r3 = null;
        goto L9
    }

    public h(IconSelectFragment r1, CharSequence r2) {
        this.j = r1;
        super(r2, 2131101336);
    }
}
