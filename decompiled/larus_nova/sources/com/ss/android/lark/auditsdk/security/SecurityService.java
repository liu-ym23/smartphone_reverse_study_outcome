package com.ss.android.lark.auditsdk.security;

import com.ss.android.lark.utils.LarkContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import p4c.b;

/* JADX INFO: loaded from: classes34.dex */
public final class SecurityService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<SecurityService> f409594a = null;

    public static final class a {
    }

    public SecurityService() {
    }

    static {
        f409594a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, SecurityService$Companion$instance$2.INSTANCE);
    }

    public final boolean a(int r100, final String r101) {
        if (r100 == 7005) goto L15;
        return false;
    L15:
        qqb.a.h("");     // Catch: Throwable -> L10
        b r102 = (b) LarkContext.spiByDwarf(b.class);     // Catch: Throwable -> L10
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r102.e(new SecurityService$handleSecurityAction$1$1(r101));     // Catch: Throwable -> L10
        qqb.a.a();
        return true;
    L10:
        th = move-exception;
        qqb.a.a();
        throw th;
    }
}
