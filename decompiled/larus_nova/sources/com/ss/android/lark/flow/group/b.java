package com.ss.android.lark.flow.group;

import android.content.Context;
import com.ss.android.lark.applink.api.AppLinkHandlerPlugin;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
@AppLinkHandlerPlugin
public final class b implements pva.b {
    public b() {
    }

    @Override // pva.b
    public final Map<String, ova.d> a(Context r100) {
        HashMap r101 = new HashMap();
        r101.put("/client/chat/chatter/add_by_link", new e());
        return r101;
    }
}
