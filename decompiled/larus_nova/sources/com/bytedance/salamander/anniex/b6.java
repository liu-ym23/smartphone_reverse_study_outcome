package com.bytedance.salamander.anniex;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class b6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<? super JSONObject, Unit> f267984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<? super Throwable, Unit> f267985b;

    public b6(Function1<? super JSONObject, Unit> r100, Function1<? super Throwable, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onSuccess");
        Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f267984a = r100;
        this.f267985b = r101;
    }
}
