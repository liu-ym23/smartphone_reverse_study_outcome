package com.larksuite.framework.section.utils;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f extends com.ss.android.lark.ui.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larksuite.framework.section.c f285717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.todo.impl.features.detail.viewmodel.a[] f285718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f285719f;

    @Override // com.ss.android.lark.ui.IActionTitlebar$BaseAction, com.ss.android.lark.ui.IActionTitlebar$Action
    public final void performAction(View r100) {
        if ((System.currentTimeMillis() - this.f285719f) >= 1000) goto L5;
        return;
    L5:
        this.f285719f = System.currentTimeMillis();
        com.ss.android.lark.todo.impl.features.detail.viewmodel.a[] r101 = this.f285718e;
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        com.ss.android.lark.todo.impl.features.detail.viewmodel.a r104 = r101[r103];
        this.f285717d.a(r104);
        r103 = r103 + 1;
        goto L6
    }

    public f(Drawable r100, com.larksuite.framework.section.c r101, com.ss.android.lark.todo.impl.features.detail.viewmodel.a... r102) {
        Intrinsics.checkNotNullParameter(r100, "image");
        Intrinsics.checkNotNullParameter(r101, "dispatcher");
        Intrinsics.checkNotNullParameter(r102, SlcCommonAction.KEY_ACTIONS);
        super(r100);
        this.f285717d = r101;
        this.f285718e = r102;
    }
}
