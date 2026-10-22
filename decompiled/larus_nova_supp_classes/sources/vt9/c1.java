package vt9;

import com.google.gson.JsonObject;
import com.larus.common.apphost.AppHost;
import hq9.q4;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c1 {
    public c1() {
    }

    public static q4 a() {
        if (AppHost.a.isOversea() == true) goto L7;
        JsonObject r9 = new JsonObject();
        com.larus.utils.l.c(r9, "stream_model", "bigasr-acllm-release-streaming-grpc-4");
        Unit r0 = Unit.INSTANCE;
        return new q4(true, 300, 1500, true, r9);
    L7:
        return new q4(0);
    }
}
