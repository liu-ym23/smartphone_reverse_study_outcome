package com.ss.android.lark.player.player;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g implements com.ss.android.lark.passport.auth.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f438672a;

    public g() {
        this.f438672a = d.f438669a;
    }

    @Override // com.ss.android.lark.passport.auth.i
    public final Map<String, String> a(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "authHeaders");
        return this.f438672a.a(r100);
    }
}
