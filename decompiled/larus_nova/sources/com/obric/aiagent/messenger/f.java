package com.obric.aiagent.messenger;

import com.larus.applog.api.IApplog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f384792a = null;

    static {
        f384792a = new ConcurrentHashMap();
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        String r101 = f384792a.remove(r100);
        IApplog.Companion r102 = IApplog.f287053a;
        JSONObject r103 = new JSONObject();
        if (r101 == null) goto L5;
        r103.put("res", "fail");
        r103.put("msg", r101);
    L6:
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent("obric_pcc_encrypt_result", r103);
        return;
    L5:
        r103.put("res", "success");
        goto L6
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f384792a.put(r100, r101);
    }
}
