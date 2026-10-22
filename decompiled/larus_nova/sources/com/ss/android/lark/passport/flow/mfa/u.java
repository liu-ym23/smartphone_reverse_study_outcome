package com.ss.android.lark.passport.flow.mfa;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.fastjson.JSONObject;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes37.dex */
@UserScope
public final class u implements yyb.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f437917c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowMfaEngine f437918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f437919b;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f437920a = null;

        static {
            int[] r100 = new int[FlowMfaTokenStatus.values().length];
            r100[FlowMfaTokenStatus.VALID.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[FlowMfaTokenStatus.INVALID.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[FlowMfaTokenStatus.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f437920a = r100;
        }
    }

    static {
    }

    @Inject
    public u(FlowMfaEngine r100) {
        Intrinsics.checkNotNullParameter(r100, "engine");
        this.f437918a = r100;
        this.f437919b = new Handler(Looper.getMainLooper());
    }

    public static ErrorResult b(FlowMfaError r100) {
        return new ErrorResult(r100.getCategory().ordinal(), r100.getMessage());
    }

    @Override // yyb.b
    public final void a(Activity r110, String r111, JSONObject r112, IGetDataCallback r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FlowPassportMFAServiceImpl$startMFA$1(this, r110, r111, r112, r113, null), 3, null);
    }
}
