package com.larus.commercecredit.impl.utils;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import qz8.m;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f325824a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f325825b = null;

    static {
        f325824a = LazyKt.lazy(new g());
        f325825b = LazyKt.lazy(new h());
    }

    public static Keva a() {
        return (Keva) f325825b.getValue();
    }

    public static void b(m r100) {
        Intrinsics.checkNotNullParameter(r100, "inviteInfo");
        a().storeString("zlink_invite_info", GsonProtectorUtils.toJson((Gson) f325824a.getValue(), r100));
    }
}
