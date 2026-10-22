package com.larus.home.impl.sdk;

import com.bytedance.ai.api.AppletService;
import com.google.gson.JsonObject;
import com.larus.platform.api.IAppletJsbEventService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class e implements IAppletJsbEventService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f346162a = null;

    static {
        f346162a = new e();
    }

    public e() {
    }

    @Override // com.larus.platform.api.IAppletJsbEventService
    public final void a(IAppletJsbEventService.TriggeredEvent r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        AppletService r102 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r102 != null) goto L5;
        return;
    L5:
        JsonObject r103 = new JsonObject();
        r103.addProperty("event", r100.getScene());
        if (r101 == null) goto L8;
        r103.add("extra", r101);
    L8:
        FLogger.f375446a.i("send_applet_jsb_event", "flow.onEventTriggered, event:" + r100 + ", params:" + r103);
        r102.a("flow.onEventTriggered", r103);
    }
}
