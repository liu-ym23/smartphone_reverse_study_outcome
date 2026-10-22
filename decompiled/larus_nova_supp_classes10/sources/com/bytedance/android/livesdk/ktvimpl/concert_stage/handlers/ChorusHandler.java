package com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers;

import com.bytedance.android.live.liveinteract.jsbridge.method.h;
import com.bytedance.android.livesdk.ktvapi.concert_stage.interfaces.IConcertUpdateStatusCallback;
import com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.ConcertStageDataContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ChorusHandler implements ce2.a {
    public static final /* synthetic */ int d = 0;
    public final Lazy a;
    public final Lazy b;
    public final DataCenter c;

    public static final class a {
    }

    static {
    }

    @Override // ce2.a
    public final void release() {
    }

    public final ei6.a c() {
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

    public ChorusHandler(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.c = r2;
        this.a = LazyKt.lazy(new ChorusHandler$getStatusHandlers$2(this));
        this.b = LazyKt.lazy(new ChorusHandler$updateStatusHandlers$2(this));
    }

    @Override // ce2.a
    public final JsonObject b(hd2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "getStatus");
        if (r2.getType().length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        Function0 r3 = (Function0) ((Map) this.a.getValue()).get(r2.getType());
        if (r3 == null) goto L14;
        JsonObject r4 = (JsonObject) r3.invoke();
        if (r4 == null) goto L14;
        return r4;
    L14:
        return new JsonObject();
    L8:
        return new JsonObject();
    L5:
        r0 = false;
        goto L6
    }

    @Override // ce2.a
    public final void a(hd2.c r6, h.b r7) {
        Intrinsics.checkNotNullParameter(r6, "updateStatus");
        Intrinsics.checkNotNullParameter(r7, "callback");
        boolean r2 = false;
        if (r6.getType().length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        r7.a(IConcertUpdateStatusCallback.Code.Failed, "Invalid update type", null);
        return;
    L9:
        JsonObject r3 = new JsonObject();
        Function1 r4 = (Function1) ((Map) this.b.getValue()).get(r6.getType());     // Catch: Exception -> L16
        if (r4 == null) goto L14;
        r2 = ((Boolean) r4.invoke(r6.c)).booleanValue();     // Catch: Exception -> L16
        String r8 = "chorus updated successfully";
    L23:
    L18:
        if (r2 == false) goto L20;
        IConcertUpdateStatusCallback.Code r0 = IConcertUpdateStatusCallback.Code.Success;
    L21:
        r7.a(r0, r8, r3);
        return;
    L20:
        r0 = IConcertUpdateStatusCallback.Code.Failed;
        goto L21
    L14:
        r8 = "Unsupported update type: " + r6.getType();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        String r5 = "Error updating status: " + e.getMessage();
        e.printStackTrace();
        r8 = r5;
        goto L18
    L5:
        r1 = false;
        goto L6
    }
}
