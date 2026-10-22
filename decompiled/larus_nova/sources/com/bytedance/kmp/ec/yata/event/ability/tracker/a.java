package com.bytedance.kmp.ec.yata.event.ability.tracker;

import com.bytedance.kmp.ec.yata.event.common.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f251622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f251623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f251624c;

    public a(com.bytedance.kmp.ec.yata.event.core.a r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f251622a = r100;
        this.f251623b = r101;
        this.f251624c = r102;
    }
}
