package com.larus.uaigc.spring.lottery;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes31.dex */
public final class ZLotteryMobHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f374125a = 0;

    static {
    }

    public static void a(String r110, boolean r111, long r112, String r113, int r114, String r210, Boolean r211) {
        Intrinsics.checkNotNullParameter(r110, "messageId");
        Intrinsics.checkNotNullParameter(r113, "cardType");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ZLotteryMobHelper$reportPocketMessageCardShowed$1(r110, r111, r112, r113, r114, r210, r211, null), 2, null);
    }
}
