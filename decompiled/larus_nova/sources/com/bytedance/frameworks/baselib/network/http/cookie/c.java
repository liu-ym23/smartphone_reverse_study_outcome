package com.bytedance.frameworks.baselib.network.http.cookie;

import com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements SSCookieHandler.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.InterfaceC3502b f244697a;

    @Override // com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler.a
    public final ArrayList<String> getCookieFlushPathList() {
        return this.f244697a.getCookieFlushPathList();
    }

    public c(b.InterfaceC3502b r100) {
        this.f244697a = r100;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler.a
    public final void onEvent(String r100, JSONObject r101) {
        if (ix5.b.f496367f == false) goto L6;
        this.f244697a.OnReportEvent("TTNET-COOKIE", r100, r101);
        return;
    }
}
