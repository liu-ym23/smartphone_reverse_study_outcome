package com.larus.login.impl.utils;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f358321a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f358322b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f358323c = null;

    static {
        f358321a = LazyKt.lazy(new g());
        f358322b = LazyKt.lazy(new h());
        f358323c = LazyKt.lazy(new i());
    }

    public static int b() {
        return ((Number) f358322b.getValue()).intValue();
    }

    public static int a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        if (((Boolean) f358321a.getValue()).booleanValue() == false) goto L5;
        int r101 = R.color.larus_neutral_100;
    L7:
        return ContextCompat.getColor(r100, r101);
    L5:
        r101 = R.color.larus_primary_50;
        goto L7
    }
}
