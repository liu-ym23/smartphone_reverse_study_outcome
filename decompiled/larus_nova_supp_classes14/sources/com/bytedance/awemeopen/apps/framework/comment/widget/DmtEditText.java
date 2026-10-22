package com.bytedance.awemeopen.apps.framework.comment.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import uy3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class DmtEditText extends AppCompatEditText {
    public DmtEditText(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(AttributeSet r4) {
        a r0 = a.a();
        monitor-enter(r0);
        if (r4 != null) goto L14;
    L9:
        monitor-exit(r0);
        return;
    L14:
        TypedArray r5 = getContext().obtainStyledAttributes(r4, new int[]{2130970128, 2130970133, 2130970135});     // Catch: Throwable -> L11
        boolean r1 = r5.getBoolean(1, false);     // Catch: Throwable -> L11
        r5.recycle();     // Catch: Throwable -> L11
        if (r1 == true) goto L9;
        setIncludeFontPadding(true);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setFontType(String r1) {
        a r2 = a.a();
        monitor-enter(r2);
        monitor-exit(r2);
    }

    public DmtEditText(Context r1, AttributeSet r2) {
        super(r1, r2);
        c(r2);
    }

    public DmtEditText(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        c(r2);
    }
}
