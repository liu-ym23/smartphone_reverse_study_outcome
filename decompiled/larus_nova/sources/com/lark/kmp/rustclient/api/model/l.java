package com.lark.kmp.rustclient.api.model;

import com.bytedance.larksuite.wire.CommandScope;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class l extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f282483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f282484b;

    public l(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        CommandScope r102 = CommandScope.GlobalScope;
        this.f282483a = r100;
        this.f282484b = r101;
    }
}
