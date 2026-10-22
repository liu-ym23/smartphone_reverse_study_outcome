package com.ss.android.lark.security.compliance.infra.network.manager;

import com.ss.android.lark.security.compliance.infra.network.d;
import com.ss.android.lark.security.compliance.infra.network.f;
import com.ss.android.lark.security.compliance.infra.network.g;
import com.ss.android.lark.security.compliance.infra.network.i;
import com.ss.android.lark.security.compliance.infra.network.userscpoe.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import w4c.c;

/* JADX INFO: loaded from: classes38.dex */
public final class RequestManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f440449a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f440450b = null;

    static {
        if (c.a().x() == false) goto L5;
        f r100 = new b();
    L6:
        f440449a = r100;
        f440450b = LazyKt.lazy(RequestManager$slaFgValue$2.INSTANCE);
        return;
    L5:
        r100 = new i();
        goto L6
    }

    public static void a(g r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (r100.getHost().length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        int r103 = v4c.a.f553226a;
        r100.c("https://" + jcb.b.c().a("security_and_compliance"));
    L9:
        if (((Boolean) f440450b.getValue()).booleanValue() == false) goto L11;
        v4c.c.c(r100);
    L11:
        f440449a.a(r100, new a(r101, r100));
        return;
    L5:
        r102 = false;
        goto L6
    }
}
