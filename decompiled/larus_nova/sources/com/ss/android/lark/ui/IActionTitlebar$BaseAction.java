package com.ss.android.lark.ui;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public class IActionTitlebar$BaseAction implements IActionTitlebar$Action {
    private Object mTag;

    public IActionTitlebar$BaseAction() {
    }

    @Override // com.ss.android.lark.ui.IActionTitlebar$Action
    public int getBackground() {
        return 0;
    }

    @Override // com.ss.android.lark.ui.IActionTitlebar$Action
    public int getDrawableRes() {
        return 0;
    }

    @Override // com.ss.android.lark.ui.IActionTitlebar$Action
    public Rect getPadding() {
        return null;
    }

    @Override // com.ss.android.lark.ui.IActionTitlebar$Action
    public String getText() {
        return null;
    }

    @Override // com.ss.android.lark.ui.IActionTitlebar$Action
    public void performAction(View r100) {
    }

    @Override // com.ss.android.lark.ui.IActionTitlebar$Action
    public Object getTag() {
        return this.mTag;
    }

    @Override // com.ss.android.lark.ui.IActionTitlebar$Action
    public IActionTitlebar$Action setTag(Object r100) {
        this.mTag = r100;
        return this;
    }
}
