package com.larus.bmhome.chat.standarduikit.browsercontrol.vm;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f308958a = 0;

    static {
    }

    public static Object a(String r110, Continuation r111) {
        JSONObject r100 = new JSONObject();
        r100.put("tool_call_id", r110);
        r100.put("action", 1);
        Unit r112 = Unit.INSTANCE;
        Object r113 = HttpExtKt.k(ServiceType.BASIC_SERVICE, Object.class, "/alice/general_task/control_browser/useraction", r100, null, null, false, null, null, null, r111, 1008);
        if (r113 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r113;
    L6:
        return Unit.INSTANCE;
    }
}
