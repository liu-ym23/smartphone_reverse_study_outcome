package com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers;

import androidx.collection.ArraySet;
import com.bytedance.android.live.liveinteract.jsbridge.method.h;
import com.bytedance.android.livesdk.ktvapi.concert_stage.interfaces.IConcertUpdateStatusCallback;
import com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.ConcertStageDataContext;
import com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.w;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.google.gson.JsonObject;
import gd2.d;
import gd2.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class TuningHandler implements ce2.a {
    public final String a;
    public final Map<String, Integer> b;
    public final Lazy c;
    public final Lazy d;

    @Override // ce2.a
    public final void release() {
    }

    public static d e() {
        f r0 = ConcertStageDataContext.Companion.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getConcertEarMonitor();
    }

    public final ei6.a d() {
        ConcertStageDataContext r0 = ConcertStageDataContext.Companion.getContext();
        if (r0 == null) goto L9;
        j<js1.a> r1 = r0.getLinkComponent();
        if (r1 == null) goto L9;
        js1.a r2 = (js1.a) r1.getValue();
        if (r2 == null) goto L9;
        return r2.a();
    L9:
        return null;
    }

    public TuningHandler(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.a = "TuningHandler";
        this.b = new LinkedHashMap();
        new ArraySet();
        this.c = LazyKt.lazy(new TuningHandler$getStatusHandlers$2(this));
        this.d = LazyKt.lazy(new TuningHandler$updateStatusHandlers$2(this));
    }

    public static JsonObject c(String r3) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("code", -1);
        r0.addProperty("message", r3);
        return r0;
    }

    @Override // ce2.a
    public final JsonObject b(hd2.a r5) {
        Intrinsics.checkNotNullParameter(r5, "getStatus");
        String r1 = r5.getType();
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L21;
        w.a(this.a, "getStatus: type is null or empty");
        return c("Invalid type");
    L21:
        Function0 r3 = (Function0) ((Map) this.c.getValue()).get(r5.getType());     // Catch: Exception -> L18
        if (r3 == null) goto L16;
        JsonObject r4 = (JsonObject) r3.invoke();     // Catch: Exception -> L18
        if (r4 == null) goto L16;
        return r4;
    L16:
        w.a(this.a, "getStatus: Unsupported type=" + r5.getType());     // Catch: Exception -> L18
        return c("Unsupported type");
    L18:
        e = move-exception;
        w.a(this.a, "getStatus: Error handling type=" + r5.getType() + ", e=" + e.getMessage());
        return c("Internal error: " + e.getMessage());
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // ce2.a
    public final void a(hd2.c r6, h.b r7) {
        Intrinsics.checkNotNullParameter(r6, "updateStatus");
        Intrinsics.checkNotNullParameter(r7, "callback");
        String r1 = r6.getType();
        boolean r2 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        r7.a(IConcertUpdateStatusCallback.Code.Failed, "Invalid update type", null);
        return;
    L12:
        JsonObject r4 = new JsonObject();
        Function1 r5 = (Function1) ((Map) this.d.getValue()).get(r6.getType());     // Catch: Exception -> L19
        if (r5 == null) goto L17;
        r2 = ((Boolean) r5.invoke(r6.c)).booleanValue();     // Catch: Exception -> L19
        String r8 = "Tuning updated successfully";
    L26:
    L21:
        if (r2 == false) goto L23;
        IConcertUpdateStatusCallback.Code r0 = IConcertUpdateStatusCallback.Code.Success;
    L24:
        r7.a(r0, r8, r4);
        return;
    L23:
        r0 = IConcertUpdateStatusCallback.Code.Failed;
        goto L24
    L17:
        r8 = "Unsupported update type: " + r6.getType();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        String r9 = "Error updating status: " + e.getMessage();
        e.printStackTrace();
        r8 = r9;
        goto L21
    L5:
        if (r1.length() == 0) goto L8;
        r3 = false;
        goto L9
    }
}
