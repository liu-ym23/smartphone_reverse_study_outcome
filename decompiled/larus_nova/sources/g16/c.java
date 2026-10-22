package g16;

import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c {
    public static final void a(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        if (r101 == null) goto L11;
        Iterator<String> r103 = r101.keys();     // Catch: Throwable -> L14
        if (r103 == null) goto L11;
    L8:
        if (r103.hasNext() == false) goto L10;
        String r104 = r103.next();     // Catch: Throwable -> L14
        r100.put(r104, r101.opt(r104));     // Catch: Throwable -> L14
        goto L8
    L10:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L14
    L16:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L23;
        ExecutorService r108 = BulletLogger.f247763a;
        BulletLogger.j("JsonUtils.wrap " + r107.getMessage(), LogLevel.E, "Monitor");
        return;
    L23:
        return;
    L11:
        r105 = null;
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }
}
