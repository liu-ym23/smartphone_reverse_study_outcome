package com.bytedance.dux.text;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f205762a;

    public static a b() {
        if (f205762a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f205762a != null) goto L9;
        f205762a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f205762a;
    }

    public a() {
    }

    public final synchronized void a(TextView r100, AttributeSet r101) {
        monitor-enter(this);
        if (r100 == null) goto L13;
        if (r101 == null) goto L13;
        TypedArray r102 = r100.getContext().obtainStyledAttributes(r101, new int[]{R.attr.fontType, R.attr.forceExcludeFontPadding, R.attr.forceIncludeFontPadding});     // Catch: Throwable -> L10
        boolean r103 = r102.getBoolean(1, false);     // Catch: Throwable -> L10
        r102.recycle();     // Catch: Throwable -> L10
        if (r103 == true) goto L13;
        r100.setIncludeFontPadding(true);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(this);
    }
}
