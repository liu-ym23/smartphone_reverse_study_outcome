package com.ss.android.lark.widget.ptr;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public abstract class LKUIPtrDefaultHandler implements LKUIPtrHandler {
    public LKUIPtrDefaultHandler() {
    }

    public static boolean canChildScrollUp(View r100) {
        return r100.canScrollVertically(-1);
    }

    public static boolean checkContentCanBePulledDown(LKUIPtrFrameLayout r100, View r101, View r102) {
        return !canChildScrollUp(r101);
    }

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrHandler
    public boolean checkCanDoRefresh(LKUIPtrFrameLayout r100, View r101, View r102) {
        return checkContentCanBePulledDown(r100, r101, r102);
    }
}
