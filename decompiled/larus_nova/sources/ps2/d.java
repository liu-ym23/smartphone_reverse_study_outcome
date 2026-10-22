package ps2;

import android.util.Log;
import com.bytedance.android.livesdk.room.LiveScope;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f530436a = 0;

    public d() {
    }

    static {
    }

    public static /* synthetic */ void b(Throwable r100, String r101, LiveScope r102, String r110, String r111, String r112) {
        a(r100, r101, r102, r110, r111, r112, null);
    }

    public static void a(Throwable r100, String r101, LiveScope r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "e");
        JSONObject r107 = new JSONObject();
        r107.put("error_code", r101);
        r107.put("error_scope", String.valueOf(r102));
        if (r104 != null) goto L5;
        r104 = "-1";
    L5:
        r107.put("enter_from_merge", r104);
        if (r105 != null) goto L8;
        r105 = "-1";
    L8:
        r107.put("enter_method", r105);
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        r107.put("source", r106);
        JSONObject r108 = new JSONObject();
        r108.put("error_msg", Log.getStackTraceString(r100));
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        r108.put("room_id", r103);
        wm0.b r109 = om0.c.j();
        Unit r110 = null;
        if (r109 == null) goto L25;
        r109.monitorEvent("livesdk_room_framework_error", r107, null, r108);
    L25:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L22
        pm0.a r112 = om0.c.c();     // Catch: Throwable -> L22
        if (r112 == null) goto L20;
        r112.i("livesdk_room_framework_error", "category:" + r107 + " extra:" + r108);     // Catch: Throwable -> L22
        r110 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L20:
        Result.m9449constructorimpl(r110);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
