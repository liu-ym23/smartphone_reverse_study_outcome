package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class b extends avc.a {

    public static final class a {
    }

    static {
    }

    @Override // avc.a, avc.c, xuc.d
    public void a(int r100, int r101) {
        setTextColor(getSelectedColor());
    }

    @Override // avc.a, avc.c, xuc.d
    public void b(int r100, int r101) {
        setTextColor(getNormalColor());
    }

    public b(Context r100, int r101, int r102, String r103, View.OnClickListener r104) {
        Intrinsics.checkNotNullParameter(r103, "text");
        Intrinsics.checkNotNullParameter(r104, "clickListener");
        super(r100);
        setSelectedColor(r101);
        setNormalColor(r102);
        setTextSize(12.0f);
        setText(r103);
        setOnClickListener(r104);
    }
}
