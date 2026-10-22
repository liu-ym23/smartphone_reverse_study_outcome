package com.larus.init.task.accountsdk;

import com.larus.applog.api.IApplog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements d48.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f351147a = null;

    static {
        f351147a = new j();
    }

    public j() {
    }

    @Override // d48.g
    public final void reportEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        IApplog.f287053a.reportEvent(r100, r101);
    }
}
