package com.bytedance.awemeopen.apps.framework.comment.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.larus.nova.R;
import uy3.a;

/* JADX INFO: loaded from: classes14.dex */
public class DmtEditText extends AppCompatEditText {
    public DmtEditText(Context r100) {
        this(r100, null);
    }

    public final void c(AttributeSet r100) {
        a r101 = a.a();
        monitor-enter(r101);
        if (r100 != null) goto L14;
    L9:
        monitor-exit(r101);
        return;
    L14:
        TypedArray r102 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.fontType, R.attr.forceExcludeFontPadding, R.attr.forceIncludeFontPadding});     // Catch: Throwable -> L11
        boolean r103 = r102.getBoolean(1, false);     // Catch: Throwable -> L11
        r102.recycle();     // Catch: Throwable -> L11
        if (r103 == true) goto L9;
        setIncludeFontPadding(true);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setFontType(String r100) {
        a r101 = a.a();
        monitor-enter(r101);
        monitor-exit(r101);
    }

    public DmtEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
        c(r101);
    }

    public DmtEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        c(r101);
    }
}
