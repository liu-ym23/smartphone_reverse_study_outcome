package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class b extends avc.a {

    public static final class a {
    }

    static {
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
    public b(Context r2, int r3, int r4, String r5, View.OnClickListener r6) {
        Intrinsics.checkNotNullParameter(r5, "text");
        Intrinsics.checkNotNullParameter(r6, "clickListener");
        super(r2);
        setSelectedColor(r3);
        setNormalColor(r4);
        setTextSize(12.0f);
        setText(r5);
        setOnClickListener(r6);
    }
}
