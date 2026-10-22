package com.ss.android.lark.keyboard.edittext2.span;

import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f429213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f429214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f429215c;

    public e() {
        this(0, 0, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f429213a == r101.f429213a) goto L12;
        return false;
    L12:
        if (this.f429214b == r101.f429214b) goto L15;
        return false;
    L15:
        if (this.f429215c == r101.f429215c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f429213a * 31) + this.f429214b) * 31) + this.f429215c;
    }

    public final String toString() {
        return "IconTitleStyle(iconSize=" + this.f429213a + ", iconColor=" + this.f429214b + ", textColor=" + this.f429215c + ')';
    }

    public e(int r100, int r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = UIHelper.dp2px(14.0f);
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = UIHelper.getColor(R.color.text_link_normal);
    L9:
        if ((r102 & 4) == 0) goto L11;
        int r103 = UIHelper.getColor(R.color.text_link_normal);
    L12:
        this.f429213a = r100;
        this.f429214b = r101;
        this.f429215c = r103;
        return;
    L11:
        r103 = 0;
        goto L12
    }
}
