package com.bytedance.lark.rustclient.api;

import com.bytedance.larksuite.wire.CommandScope;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class y extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f253936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f253937b;

    public y(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        CommandScope r102 = CommandScope.GlobalScope;
        this.f253936a = r100;
        this.f253937b = r101;
    }
}
