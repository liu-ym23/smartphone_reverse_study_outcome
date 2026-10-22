package com.ss.android.lark.chat.utils;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f416697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f416698b;

    public static final class a {
    }

    static {
    }

    public static boolean a() {
        if (f416698b != null) goto L5;
        f416698b = Boolean.valueOf(FeatureGatingModule.getFeatureGatingService().isEnable("im.message.thread_reply_bubble_optimize"));
    L5:
        Boolean r100 = f416698b;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Boolean");
        return r100.booleanValue();
    }
}
