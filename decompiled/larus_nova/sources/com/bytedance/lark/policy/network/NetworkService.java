package com.bytedance.lark.policy.network;

import com.bytedance.lark.policy.utils.Logger;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import ke6.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ne6.c;
import ne6.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class NetworkService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f253874a = 0;

    static {
    }

    public static JSONObject b(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "api");
        Intrinsics.checkNotNullParameter(r101, "jsonObject");
        Logger.c("NetworkService", "start syncPostData.");
        d.f503032a.getClass();
        c r102 = d.c();
        if (r102 == null) goto L6;
        JSONObject r103 = r102.a(r100, r101);
        if (r103 == null) goto L6;
        return r103;
    L6:
        Logger.b("NetworkService", "syncPostData, PolicyEngine.getNetwork() is null.");
        return null;
    }

    public static void a(final String r100, final JSONObject r101, final Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "api");
        Intrinsics.checkNotNullParameter(r101, "jsonObject");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("security.policy_engine.fix_thread_pool") == false) goto L7;
        d.f503032a.getClass();
        c r103 = d.c();
        if (r103 == null) goto L11;
        r103.c(r100, r101, r102);
        return;
    L11:
        return;
    L7:
        d.f503032a.getClass();
        e r104 = d.d();
        if (r104 == null) goto L13;
        r104.b(new NetworkService$postData$1(r100, r101, r102));
        return;
    }
}
