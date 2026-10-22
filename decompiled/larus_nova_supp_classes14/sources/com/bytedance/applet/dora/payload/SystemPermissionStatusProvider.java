package com.bytedance.applet.dora.payload;

import androidx.core.content.ContextCompat;
import com.bytedance.applet.aibridge.permission.PermissionEnum;
import com.bytedance.applet.utils.t;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.larus.bmhome.chat.api.IAppletPayloadProviderService;
import com.larus.bmhome.chat.api.t0;
import com.larus.call_plugins_doubao_common.CommonAppletPlugin;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/applet/dora/payload/SystemPermissionStatusProvider;", "Lcom/larus/bmhome/chat/api/IAppletPayloadProviderService;", "<init>", "()V", "getAppletPayload", "", "", "conversationId", "botId", "msgId", "addOnAppletPayloadChangedListener", "", "listener", "Lcom/larus/bmhome/chat/api/OnAppletPayloadChangedListener;", "removeOnAppletPayloadChangedListener", "getPermissionGrantedValue", "permission", "isPermissionGranted", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemPermissionStatusProvider implements IAppletPayloadProviderService {

    public static final class a {
    }

    static {
    }

    public SystemPermissionStatusProvider() {
    }

    public final void a(t0 r1) {
    }

    public final void c(CommonAppletPlugin.initAppletPayloadChangeListener.1 r1) {
    }

    public final Map<String, String> b(String r3, String r4, String r5) {
        JSONObject r6 = new JSONObject();
        boolean r7 = t.a();
        String r8 = CommentScene.COMMENTSCENE_NO_AWEME;
        if (r7 == false) goto L5;
        Object r9 = CommentScene.COMMENTSCENE_NO_AWEME;
    L6:
        r6.put(PermissionEnum.NOTIFICATION, r9);
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.RECORD_AUDIO") != 0) goto L9;
        boolean r10 = true;
    L10:
        if (r10 == true) goto L13;
        r8 = "0";
    L13:
        r6.put("microphone", r8);
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("client_system_permission", r6.toString());
        IFlowSdkDepend r12 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r12 == null) goto L18;
        FlowAppletServiceImpl r13 = r12.g0();
        if (r13 == null) goto L18;
        Map r14 = r13.h();
    L19:
        r11.putAll(r14);
        return r11;
    L18:
        r14 = MapsKt.emptyMap();
        goto L19
    L9:
        r10 = false;
        goto L10
    L5:
        r9 = "0";
        goto L6
    }
}
