package com.bytedance.kmp.ec.yata.event.ability.uplink;

import com.bytedance.kmp.ec.yata.event.common.e;
import kotlin.jvm.internal.Intrinsics;
import v96.j;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f251633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f251634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.common.protocol.data.e f251635c;

    public a(e r100, j r101, com.bytedance.kmp.ec.yata.common.protocol.data.e r102) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "requestApi");
        this.f251633a = r100;
        this.f251634b = r101;
        this.f251635c = r102;
    }
}
