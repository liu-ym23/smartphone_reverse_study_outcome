package com.ss.android.lark.widget.ptr;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public abstract class LKUIPtrDefaultHandler2 extends LKUIPtrDefaultHandler implements LKUIPtrHandler2 {
    public LKUIPtrDefaultHandler2() {
    }

    public static boolean canChildScrollDown(View r100) {
        return r100.canScrollVertically(1);
    }

    public static boolean checkContentCanBePulledUp(LKUIPtrFrameLayout r100, View r101, View r102) {
        return !canChildScrollDown(r101);
    }

    public boolean checkCanDoLoadMore(LKUIPtrFrameLayout r100, View r101, View r102) {
        return checkContentCanBePulledUp(r100, r101, r102);
    }
}
