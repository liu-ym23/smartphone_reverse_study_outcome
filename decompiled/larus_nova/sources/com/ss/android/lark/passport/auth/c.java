package com.ss.android.lark.passport.auth;

import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class c implements f {
    @Inject
    public c() {
    }

    @Override // com.ss.android.lark.passport.auth.f
    public final Map<String, String> a(String r100, String r101, Function1<? super Map<String, String>, ? extends Map<String, String>> r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "build");
        return r102.invoke(MapsKt.emptyMap());
    }
}
