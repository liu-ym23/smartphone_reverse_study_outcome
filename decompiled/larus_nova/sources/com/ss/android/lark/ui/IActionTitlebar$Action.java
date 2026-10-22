package com.ss.android.lark.ui;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public interface IActionTitlebar$Action {
    int getBackground();

    int getDrawableRes();

    Rect getPadding();

    Object getTag();

    String getText();

    void performAction(View r100);

    IActionTitlebar$Action setTag(Object r100);
}
