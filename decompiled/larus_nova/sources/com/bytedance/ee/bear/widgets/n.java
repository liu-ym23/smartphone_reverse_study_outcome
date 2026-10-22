package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class n extends avc.a {

    public static final class a {
    }

    static {
    }

    @Override // avc.c, xuc.b
    public int getContentLeft() {
        return getLeft();
    }

    @Override // avc.c, xuc.b
    public int getContentRight() {
        return getRight();
    }

    @Override // avc.a, avc.c, xuc.d
    public void a(int r100, int r101) {
        setTextColor(getSelectedColor());
    }

    @Override // avc.a, avc.c, xuc.d
    public void b(int r100, int r101) {
        setTextColor(getNormalColor());
    }

    public n(Context r100, int r101, int r102, String r103, View.OnClickListener r104) {
        Intrinsics.checkNotNullParameter(r103, "text");
        Intrinsics.checkNotNullParameter(r104, "clickListener");
        super(r100);
        setSelectedColor(r101);
        setNormalColor(r102);
        setTextSize(14.0f);
        setText(r103);
        setOnClickListener(r104);
    }
}
