package com.larus.navigation.impl.platform;

import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes30.dex */
public final class l implements e37.e {

    public static final class a {
    }

    static {
    }

    public l() {
    }

    @Override // e37.e
    public final Object a(String r100, String r110, Map r111, Map r112, Continuation r113) {
        return BuildersKt.withContext(Dispatchers.getIO(), new NavigationNetwork$doGetJson$2(r100, r110, r111, r112, null), r113);
    }

    @Override // e37.e
    public final Object b(String r110, String r111, Map r112, String r113, Map r114, ContinuationImpl r115) {
        return BuildersKt.withContext(Dispatchers.getIO(), new NavigationNetwork$doPostJson$2(r110, r111, r113, r112, r114, null), r115);
    }
}
