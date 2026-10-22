package com.bytedance.applet.debug;

import com.bytedance.ai.debug.IAISDKDebugService;
import com.larus.bmhome.chat.api.IMessageExtService;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/debug/AppletDebugMessageExtServiceImpl;", "Lcom/larus/bmhome/chat/api/IMessageExtService;", "<init>", "()V", "setSendMessageExt", "", "map", "", "", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "metadata", "Lcom/larus/bmhome/chat/api/IMessageExtService$QueryData;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletDebugMessageExtServiceImpl implements IMessageExtService {

    public static final class a {
    }

    static {
    }

    public AppletDebugMessageExtServiceImpl() {
    }

    public final String service() {
        return "";
    }

    public final void b(Map r1, IMessageExtService.a r2) {
        Intrinsics.checkNotNullParameter(r1, "map");
    }

    public final void a(Map<String, String> r5, e r6, IMessageExtService.a r7) {
        Intrinsics.checkNotNullParameter(r5, "map");
        IAISDKDebugService.Companion r8 = IAISDKDebugService.a;
        IAISDKDebugService.DebugMode r9 = r8.getDebugMode();
        boolean r1 = true;
        if (r9 != IAISDKDebugService.DebugMode.LEGACY_SCAN_PREVIEW) goto L13;
        boolean r10 = AppletDebugManager.a;
        String r11 = r8.o();
        if (r11 != null) goto L7;
    L10:
        if (r1 == true) goto L25;
        FLogger.a.i("AppletDebugMessageExtServiceImpl", "debugConfig: " + r11);
        r5.put("mini_app_debug_info", r11);
        return;
    L25:
        return;
    L7:
        if (r11.length() == 0) goto L10;
        r1 = false;
        goto L10
    L13:
        if (r9 != IAISDKDebugService.DebugMode.SCAN_PREVIEW) goto L15;
    L16:
        String r12 = r8.b();
        if (r12 != null) goto L19;
    L22:
        if (r1 == true) goto L28;
        FLogger.a.i("AppletDebugMessageExtServiceImpl", "remoteDebugConfig: " + r12);
        r5.put("doubao_miniapp_debug_info", r12);
        r5.put("doubao_miniapp_debug_flag", "true");
        return;
    L28:
        return;
    L19:
        if (r12.length() == 0) goto L22;
        r1 = false;
        goto L22
    L15:
        if (r9 == IAISDKDebugService.DebugMode.LOCAL_DEBUG) goto L16;
    }
}
