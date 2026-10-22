package vt9;

import com.google.gson.JsonObject;
import com.larus.common.apphost.AppHost;
import hq9.q4;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
public final class c1 {
    public c1() {
    }

    public static q4 a() {
        if (AppHost.f326268a.isOversea() == true) goto L7;
        JsonObject r100 = new JsonObject();
        com.larus.utils.l.c(r100, "stream_model", "bigasr-acllm-release-streaming-grpc-4");
        Unit r101 = Unit.INSTANCE;
        return new q4(true, 300, 1500, true, r100);
    L7:
        return new q4(0);
    }
}
