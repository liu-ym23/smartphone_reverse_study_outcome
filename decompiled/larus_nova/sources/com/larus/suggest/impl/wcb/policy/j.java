package com.larus.suggest.impl.wcb.policy;

import com.larus.suggest.impl.wcb.request.WcbRequestTrigger;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f369973a = null;

    static {
        f369973a = new j();
    }

    public j() {
    }

    @Override // com.larus.suggest.impl.wcb.policy.b0
    public final a0 a(com.larus.suggest.impl.wcb.request.f r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        y r102 = r100.f370118f.f370099a.h();
        if (r102.l(r100) == false) goto L7;
        return new a0.d("wcb consumed in conversation");
    L7:
        if (r100.f370118f.f370100b == WcbRequestTrigger.REGENERATE) goto L9;
        v r103 = r102.k(r100);
        if (Intrinsics.areEqual(r103, v.b.f370010a) == false) goto L13;
        if (r101 == true) goto L24;
        long r104 = r102.i(r100);
        long r105 = r102.c(r100) * 1000;
        if (r104 >= r105) goto L32;
        if (r105 <= 0) goto L32;
        FLogger.f375446a.i("WcbLog", "intercept next pulse request, reqInterval=" + r104 + " minInterval=" + r105);
        return new a0.d("request within freqReqInterval");
    L32:
        return a0.c.f369959a;
    L24:
        return a0.c.f369959a;
    L13:
        if ((r103 instanceof v.a) == false) goto L17;
        return new a0.a(((v.a) r103).f370009a);
    L17:
        if ((r103 instanceof v.c) == false) goto L21;
        ((v.c) r103).getClass();
        Intrinsics.checkNotNullParameter(null, "reason");
        throw null;
    L21:
        throw new NoWhenBranchMatchedException();
    L9:
        return a0.c.f369959a;
    }
}
