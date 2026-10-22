package com.bytedance.applet.dora.payload;

import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.api.IAppletPayloadProviderService;
import com.larus.bmhome.chat.api.t0;
import com.larus.call_plugins_doubao_common.CommonAppletPlugin;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/applet/dora/payload/CommonBusinessProvider;", "Lcom/larus/bmhome/chat/api/IAppletPayloadProviderService;", "<init>", "()V", "getAppletPayload", "", "", "conversationId", "botId", "msgId", "addOnAppletPayloadChangedListener", "", "listener", "Lcom/larus/bmhome/chat/api/OnAppletPayloadChangedListener;", "removeOnAppletPayloadChangedListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonBusinessProvider implements IAppletPayloadProviderService {

    public static final class a {
    }

    static {
    }

    public CommonBusinessProvider() {
    }

    public final void a(t0 r1) {
    }

    public final void c(CommonAppletPlugin.initAppletPayloadChangeListener.1 r1) {
    }

    public final Map<String, String> b(String r1, String r2, String r3) {
        if (AudioServiceDelegate.a.P().isRecording() == false) goto L5;
        String r4 = "2";
    L6:
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("record_status", r4);
        return r5;
    L5:
        r4 = CommentScene.COMMENTSCENE_NO_AWEME;
        goto L6
    }
}
