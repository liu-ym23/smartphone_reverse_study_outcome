package mh9;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ouc.d0;

/* JADX INFO: loaded from: classes30.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f514022a = 0;

    static {
    }

    public static void a(String r100, d0 r101) {
        int r102 = t.f514021a;
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        com.larus.platform.service.g.f365738a.monitorEventForSlardar(r100, new JSONObject(r101.toString()), null, null);
        u.a(r100, r101);
    }
}
