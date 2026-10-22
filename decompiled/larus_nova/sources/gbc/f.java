package gbc;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f480817a = 0;

    static {
    }

    public f() {
    }

    public static void b(xac.a r100, c r101, Map r102) {
        b r103 = new b(new a(r100, r102));
        Intrinsics.checkNotNullParameter(r101, "event");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L13
        e r105 = r103.f480811a.a(r101);     // Catch: Throwable -> L13
        if (r105 == null) goto L10;
        String r106 = r105.f480815a;     // Catch: Throwable -> L13
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L13
        Iterator<Map.Entry<String, Object>> r108 = r105.f480816b.entrySet().iterator();     // Catch: Throwable -> L13
    L7:
        if (r108.hasNext() == false) goto L9;
        Map.Entry<String, Object> r109 = r108.next();     // Catch: Throwable -> L13
        r107.put(r109.getKey(), r109.getValue());     // Catch: Throwable -> L13
        goto L7
    L9:
        Statistics.sendEvent(r106, r107);     // Catch: Throwable -> L13
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L13
    L15:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L22;
        Log.e("VoiceAnalytics", "Failed to report voice analytics", r112);
        return;
    L22:
        return;
    L10:
        r110 = null;
    L13:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static Map a(String r100, String r101, boolean r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = false;
    L5:
        Map r104 = MapsKt.createMapBuilder();
        r104.put("source_id", r100);
        r104.put("user_lng", r101);
        r104.put("is_result", Boolean.valueOf(r102));
        r104.put("is_user_edited", false);
        return MapsKt.build(r104);
    }
}
