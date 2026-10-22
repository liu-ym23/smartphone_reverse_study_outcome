package com.bytedance.awemeopen.apps.framework.utils;

import android.app.Activity;
import android.content.Context;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class UserLoginUtil {
    public static final Lazy a = null;

    public static final class a implements com.bytedance.awemeopen.bizmodels.user.b {
        public final /* synthetic */ Function0<Unit> a;

        public final void onFail(Exception r1) {
        }

        public a(Function0<Unit> r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.awemeopen.bizmodels.user.c r2) {
            Intrinsics.checkNotNullParameter(r2, "tokenResult");
            this.a.invoke();
        }
    }

    static {
        a = LazyKt.lazy(UserLoginUtil$loginService$2.INSTANCE);
    }

    public static void b(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r2 != (-888)) goto L5;
        zx3.a.c(r1, 2131894306).d();
        return;
    L5:
        zx3.a.b(r1, 2131894204).d();
    }

    public static void a(Activity r2, String r3, Map r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "loginSource");
        Intrinsics.checkNotNullParameter(r5, "action");
        Lazy r0 = a;
        if (((k34.b) r0.getValue()).isLogin() == true) goto L5;
        ((k34.b) r0.getValue()).l0(new com.bytedance.awemeopen.bizmodels.user.f(r2, r3, r4), new a(r5));
        return;
    L5:
        r5.invoke();
    }
}
