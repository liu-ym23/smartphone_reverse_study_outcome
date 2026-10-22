package com.bytedance.forest;

import com.bytedance.forest.model.Response;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<fx5.a> f244205a = null;

    static {
        f244205a = new ArrayList();
    }

    public static void a(Response r110, String r111, JSONObject r112, JSONObject r113, JSONObject r114, int r115, com.bytedance.forest.utils.e r116) {
        List<fx5.a> r117 = f244205a;
        monitor-enter(r117);
        Iterator r118 = ((ArrayList) r117).iterator();     // Catch: Throwable -> L34
    L6:
        if (r118.hasNext() == false) goto L31;
        fx5.a r100 = (fx5.a) r118.next();     // Catch: Throwable -> L34
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L25
        String r102 = r110.f244315q.getOriginUrl();     // Catch: Throwable -> L25
        String r103 = r110.f244315q.getGroupId();     // Catch: Throwable -> L25
        if (r103.length() <= 0) goto L11;
        boolean r104 = true;
    L12:
        Object r105 = null;
        if (r104 == true) goto L16;
        r103 = null;
    L16:
        if (r103 == null) goto L18;
        String r106 = r103;
    L23:
        r100.a(r110, r111, r102, r106, r112, r113, r114, r115);     // Catch: Throwable -> L25
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L34
        if (r108 == null) goto L6;
        com.bytedance.forest.utils.c.a(r116.f244543g, 6, "ResourceReporter", "custom report error", false, r108, null, 40);     // Catch: Throwable -> L34
        goto L6
    L18:
        Object r109 = r110.f244315q.getCustomParams().get("rl_container_uuid");     // Catch: Throwable -> L25
        if ((r109 instanceof String) == false) goto L22;
        r105 = r109;
    L22:
        r106 = (String) r105;     // Catch: Throwable -> L25
        goto L23
    L11:
        r104 = false;
        goto L12
    L25:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L34
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L34
        goto L27
    L31:
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(r117);
        return;
    L34:
        th = move-exception;
        throw th;
    }
}
