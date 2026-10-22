package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class n extends avc.a {

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int getContentLeft() {
        return getLeft();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int getContentRight() {
        return getRight();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(int r1, int r2) {
        setTextColor(getSelectedColor());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(int r1, int r2) {
        setTextColor(getNormalColor());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(Context r2, int r3, int r4, String r5, View.OnClickListener r6) {
        Intrinsics.checkNotNullParameter(r5, "text");
        Intrinsics.checkNotNullParameter(r6, "clickListener");
        super(r2);
        setSelectedColor(r3);
        setNormalColor(r4);
        setTextSize(14.0f);
        setText(r5);
        setOnClickListener(r6);
    }
}
