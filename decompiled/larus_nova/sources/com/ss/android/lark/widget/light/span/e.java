package com.ss.android.lark.widget.light.span;

import android.os.SystemClock;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f446238a;

    public static final class a {
    }

    static {
    }

    public e() {
    }

    public final boolean a() {
        long r100 = SystemClock.uptimeMillis();
        long r101 = r100 - this.f446238a;
        this.f446238a = r100;
        if (r101 >= 500) goto L5;
        Log.i("OnSingleClickListener", "elapsedTime is short than LENGTH_SHORT");
        return false;
    L5:
        return true;
    }
}
