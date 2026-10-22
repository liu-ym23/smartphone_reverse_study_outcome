package com.bytedance.applet.impl;

import com.bytedance.applet.context.ContextManager;
import com.larus.bmhome.chat.api.IAppletPayloadProviderService;
import com.larus.call_plugins_doubao_common.CommonAppletPlugin;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applet/impl/AppletPayloadProviderServiceImpl;", "Lcom/larus/bmhome/chat/api/IAppletPayloadProviderService;", "<init>", "()V", "getAppletPayload", "", "", "conversationId", "botId", "msgId", "addOnAppletPayloadChangedListener", "", "listener", "Lcom/larus/bmhome/chat/api/OnAppletPayloadChangedListener;", "removeOnAppletPayloadChangedListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletPayloadProviderServiceImpl implements IAppletPayloadProviderService {
    public AppletPayloadProviderServiceImpl() {
    }

    public final void a(com.larus.bmhome.chat.api.t0 r2) {
        ContextManager.a.a(r2);
    }

    public final void c(CommonAppletPlugin.initAppletPayloadChangeListener.1 r2) {
        ContextManager.a.c(r2);
    }

    public final Map<String, String> b(String r3, String r4, String r5) {
        ContextManager r0 = ContextManager.a;
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        return r0.b(r3, r4, r5);
    }
}
