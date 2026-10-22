package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class TimerTaskKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f396880a = null;

    static {
        f396880a = LazyKt.lazy(TimerTaskKt$gson$2.INSTANCE);
    }

    public static final String a(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.readString();
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }
}
