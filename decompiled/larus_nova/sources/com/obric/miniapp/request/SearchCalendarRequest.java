package com.obric.miniapp.request;

import android.os.Bundle;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.protocol.model.TargetEntity;
import com.google.gson.JsonObject;
import com.larus.home.api.main.IPrivacyService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import d3.w;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: classes33.dex */
public final class SearchCalendarRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f398374a;

    public static final class a {
    }

    static {
    }

    public SearchCalendarRequest() {
        this.f398374a = 2;
    }

    public final Bundle b(Bundle r110) {
        Intrinsics.checkNotNullParameter(r110, "args");
        IPrivacyService r100 = (IPrivacyService) ServiceManager.get().getService(IPrivacyService.class);
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == true) goto L11;
        return null;
    L11:
        String r102 = r110.getString("eventUuid");
        if (r102 == null) goto L14;
        JsonObject r111 = new JsonObject();
        r111.addProperty("eventUuid", r102);
    L22:
        FLogger.f375446a.d("SearchCalendarRequest", "params: " + r111);
        if (r111 != null) goto L25;
        return null;
    L25:
        return (Bundle) BuildersKt.runBlocking$default(null, new SearchCalendarRequest$handle$1$1(this, r111, null), 1, null);
    L14:
        String r103 = r110.getString("keyword");
        long r104 = r110.getLong("start");
        long r112 = r110.getLong("end");
        if (r103 != null) goto L17;
    L21:
        FLogger.f375446a.w("SearchCalendarRequest", "invalid args: eventId: " + r102 + ", keyword: " + r103 + ", start: " + r104 + ", end: " + r112);
        r111 = null;
        goto L22
    L17:
        if (r104 == 0) goto L21;
        if (r112 == 0) goto L21;
        r111 = new JsonObject();
        r111.addProperty("keyword", r103);
        r111.addProperty("start", Long.valueOf(r104));
        r111.addProperty("end", Long.valueOf(r112));
        goto L22
    L5:
        if (r100.a() != true) goto L7;
        r101 = true;
        goto L9
    }

    public static final void a(final SearchCalendarRequest r100, final w r101, final JsonObject r110, final CompletableDeferred r111) {
        r100.getClass();
        r101.c(new ProtocolMessage("applet.calendar.search", r110, null, new TargetEntity(TargetEntity.Scope.Main, TargetEntity.Target.Self, 4), ProtocolMessage.Type.Call, 36), new SearchCalendarRequest$executeFunction$1(r111), new SearchCalendarRequest$executeFunction$2(r100, r101, r110, r111), null);
    }
}
