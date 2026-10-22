package dv8;

import com.larus.platform.service.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f470223a = 0;

    static {
    }

    public d() {
    }

    public static void a(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "failReason");
        o r102 = o.f365780a;
        JSONObject r103 = new JSONObject();
        r103.put("success", r100 ? 1 : 0);
        if (r100 == true) goto L5;
        r103.put("fail_reason", r101);
    L5:
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent("create_new_bot_result", r103);
    }
}
