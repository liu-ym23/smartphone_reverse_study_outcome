package com.bytedance.awemeopen.apps.framework.utils;

import android.app.Activity;
import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class UserLoginUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f197663a = null;

    public static final class a implements com.bytedance.awemeopen.bizmodels.user.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f197664a;

        @Override // com.bytedance.awemeopen.bizmodels.user.b
        public final void onFail(Exception r100) {
        }

        public a(Function0<Unit> r100) {
            this.f197664a = r100;
        }

        @Override // com.bytedance.awemeopen.bizmodels.user.b
        public final void a(com.bytedance.awemeopen.bizmodels.user.c r100) {
            Intrinsics.checkNotNullParameter(r100, "tokenResult");
            this.f197664a.invoke();
        }
    }

    static {
        f197663a = LazyKt.lazy(UserLoginUtil$loginService$2.INSTANCE);
    }

    public static void b(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != (-888)) goto L5;
        zx3.a.c(r100, R.string.aos_you_can_not_follow_yourself).d();
        return;
    L5:
        zx3.a.b(r100, R.string.aos_follow_failed).d();
    }

    public static void a(Activity r100, String r101, Map r102, Function0 r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "loginSource");
        Intrinsics.checkNotNullParameter(r103, "action");
        Lazy r104 = f197663a;
        if (((k34.b) r104.getValue()).isLogin() == true) goto L5;
        ((k34.b) r104.getValue()).l0(new com.bytedance.awemeopen.bizmodels.user.f(r100, r101, r102), new a(r103));
        return;
    L5:
        r103.invoke();
    }
}
