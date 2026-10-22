package com.bytedance.live.kmp.util;

import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f255167a = null;

    public c() {
    }

    static {
        f255167a = new c();
    }

    public final Context getContext() {
        return s1.getContext();
    }

    public static String a(int r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r101, "formatArgs");
        if (r101.length != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        return s1.B(r100);
    L10:
        return s1.C(r100, Arrays.copyOf(r101, r101.length));
    L5:
        r102 = false;
        goto L6
    }
}
