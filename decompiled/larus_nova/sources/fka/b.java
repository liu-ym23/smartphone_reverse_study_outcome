package fka;

import android.util.Log;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f477674a = 0;

    static {
    }

    public static void a(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "category");
        Intrinsics.checkNotNullParameter(r102, "metric");
        Intrinsics.checkNotNullParameter(r103, "logExtr");
        bka.a r104 = bka.a.f19387a;     // Catch: Exception -> L5
        gka.b.a("SdkMonitorManager", "on event device_id = null");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        gka.b.a("SdkMonitorManager", "event report exception " + Log.getStackTraceString(e));
    }
}
