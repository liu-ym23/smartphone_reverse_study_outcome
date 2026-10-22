package com.ss.android.lark.im.sdk;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ImSdk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImSdk f425890a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f425891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f425892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f425893d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f425894e = null;

    public ImSdk() {
    }

    static {
        f425890a = new ImSdk();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.SYNCHRONIZED;
        f425893d = LazyKt.lazy(r100, ImSdk$MESSAGE_CLIENT$2.INSTANCE);
        f425894e = LazyKt.lazy(r100, ImSdk$CHAT_CLIENT$2.INSTANCE);
    }

    public final Context getContext() {
        Context r100 = f425891b;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    L6:
        return r100;
    }
}
