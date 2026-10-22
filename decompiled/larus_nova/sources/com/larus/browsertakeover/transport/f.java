package com.larus.browsertakeover.transport;

import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f319693a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f319694b = null;

    public f() {
    }

    static {
        f319693a = new f();
        f319694b = SetsKt.setOf(new String[]{"Page.screencastVisibilityChanged", "Page.frameNavigated", "Page.navigatedWithinDocument", "Page.loadEventFired", "Inspector.targetCrashed", "Inspector.detached"});
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        JSONObject r103 = (JSONObject) r102;
        if (r103 != null) goto L14;
        return true;
    L14:
        if (r103.has("id") == false) goto L16;
        return true;
    L16:
        String r104 = r103.optString(com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r104, com.alipay.sdk.m.p.e.f25671s);
        if (Intrinsics.areEqual(r104, "Page.screencastFrame") == false) goto L20;
        return false;
    L20:
        return f319694b.contains(r104);
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
