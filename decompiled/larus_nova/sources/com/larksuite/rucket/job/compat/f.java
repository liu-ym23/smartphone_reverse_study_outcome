package com.larksuite.rucket.job.compat;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f286080a = 0;

    static {
    }

    @JvmStatic
    public static final CallbackCompatRucketJob a(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        CallbackCompatRucketJob r101 = new CallbackCompatRucketJob(r100);
        r101.registerCallback();
        return r101;
    }
}
