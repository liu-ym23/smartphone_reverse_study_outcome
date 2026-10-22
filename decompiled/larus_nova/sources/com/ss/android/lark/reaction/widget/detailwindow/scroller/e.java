package com.ss.android.lark.reaction.widget.detailwindow.scroller;

/* JADX INFO: loaded from: classes37.dex */
public class e implements b {
    public e() {
    }

    @Override // com.ss.android.lark.reaction.widget.detailwindow.scroller.b
    public int a(boolean r100, int r101, int r102) {
        if (r100 == false) goto L5;
        return 0;
    L5:
        return r102;
    }

    @Override // com.ss.android.lark.reaction.widget.detailwindow.scroller.b
    public int b(int r100, int r101) {
        if (r100 >= (r101 / 2)) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return 0;
    L9:
        return r101;
    L5:
        r102 = false;
        goto L6
    }
}
