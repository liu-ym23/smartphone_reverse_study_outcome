package com.larus.dora.impl.resource;

import com.bytedance.keva.Keva;
import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.DoraResourceState;
import com.larus.platform.service.AccountService;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<DoraEnableScope> f337907a = null;

    static {
        f337907a = CollectionsKt.listOf(new DoraEnableScope[]{DoraEnableScope.G1, DoraEnableScope.G2});
    }

    public static DoraResourceState c(DoraEnableScope r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        boolean r101 = true;
        if (r100 != DoraEnableScope.G_SERIES) goto L15;
        List r102 = CollectionsKt.listOf(new DoraResourceState[]{c(DoraEnableScope.G1), c(DoraEnableScope.G2)});
        DoraResourceState r103 = DoraResourceState.PENDING;
        if (r102.contains(r103) == true) goto L48;
        DoraResourceState r104 = DoraResourceState.FAILED;
        if (r102.contains(r104) == true) goto L49;
        DoraResourceState r105 = DoraResourceState.READY;
        if (r102.contains(r105) == false) goto L14;
        return r105;
    L14:
        return DoraResourceState.DISABLED;
    L49:
        return r104;
    L48:
        return r103;
    L15:
        AccountService r106 = AccountService.f365697a;
        String r107 = r106.getUserId();
        if (r106.isLogin().booleanValue() == true) goto L18;
    L20:
        r101 = false;
    L21:
        Object r108 = null;
        if (r101 == true) goto L25;
        r107 = null;
    L25:
        if (r107 == null) goto L27;
        Keva r109 = d(r107);
        if (r109.getBoolean("grant_" + r100.name(), false) == false) goto L51;
        String r110 = r109.getString(e(r100), null);
        if (r110 == null) goto L45;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L35
        Object r112 = Result.m9449constructorimpl(DoraResourceState.valueOf(r110));     // Catch: Throwable -> L35
    L38:
        if (Result.m9455isFailureimpl(r112) == true) goto L41;
        r108 = r112;
    L41:
        DoraResourceState r113 = (DoraResourceState) r108;
        if (r113 == null) goto L45;
        return r113;
    L35:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L45:
        return DoraResourceState.PENDING;
    L51:
        return DoraResourceState.DISABLED;
    L27:
        return DoraResourceState.DISABLED;
    L18:
        if ((!StringsKt.isBlank(r107)) == false) goto L20;
        goto L20
    }

    public static Keva d(String r100) {
        return Keva.getRepo("dora_resource_grants_" + r100, 0);
    }

    public static String e(DoraEnableScope r100) {
        return "state_" + r100.name();
    }

    public static void b(String r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "accountId");
        Intrinsics.checkNotNullParameter(r101, "snapshot");
        Iterator<T> r102 = f337907a.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        DoraEnableScope r103 = (DoraEnableScope) r102.next();
        boolean r104 = r101.f337874a.containsKey(r103);
        d(r100).storeBoolean("grant_" + r103.name(), r104);
        if (r104 == true) goto L7;
        d(r100).erase(e(r103));
        goto L4
    L7:
        d(r100).storeString(e(r103), "PENDING");
        goto L4
    }

    public static void a(String r100, g r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "accountId");
        Intrinsics.checkNotNullParameter(r101, "snapshot");
        Iterator<T> r103 = r101.f337874a.keySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        DoraEnableScope r104 = (DoraEnableScope) r103.next();
        Keva r105 = d(r100);
        String r106 = e(r104);
        if (r102 == false) goto L8;
        String r107 = "READY";
    L9:
        r105.storeString(r106, r107);
        goto L4
    L8:
        r107 = "FAILED";
        goto L9
    }
}
