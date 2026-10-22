package com.ss.android.lark.ui;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes38.dex */
public class c extends IActionTitlebar$BaseAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f444571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f444572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f444573c;

    public c() {
        throw null;
    }

    @Override // com.ss.android.lark.ui.IActionTitlebar$BaseAction, com.ss.android.lark.ui.IActionTitlebar$Action
    public final int getDrawableRes() {
        return this.f444571a;
    }

    public c(Drawable r100) {
        this.f444572b = r100;
    }

    public c(int r100, int r101) {
        this.f444571a = r100;
        this.f444573c = r101;
    }
}
