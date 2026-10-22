package com.larus.bmhome.chat.input;

import android.content.Context;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalDowngradeData;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import ye8.a;
import ye8.b;
import ye8.c;
import ye8.e;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 *2\u00020\u0001:\u0001*J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\fH&J\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u0011\u001a\u00020\tH&J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J&\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001d\u001a\u00020\u001eH&J\b\u0010\u001f\u001a\u00020 H&J\n\u0010!\u001a\u0004\u0018\u00010\"H&J\b\u0010#\u001a\u00020$H'J\f\u0010%\u001a\u00060&j\u0002`'H'J\f\u0010(\u001a\u00060&j\u0002`'H'J\f\u0010)\u001a\u00060&j\u0002`'H'¨\u0006+"}, d2 = {"Lcom/larus/bmhome/chat/input/IChatInputService;", "", "createChatInputPlaceholder", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "config", "Lcom/larus/bmhome/chat/input/ChatInputPlaceholderConfig;", "updateChatInputPlaceholder", "", "view", "resolveInitialChatInputPlaceholderMode", "Lcom/larus/bmhome/chat/input/ChatInputPlaceholderMode;", "resolveChatInputPlaceholderHint", "", "conversationId", "configuredHint", "execSendImgMsgCacheScanner", "getSendImageCacheCleanupTargets", "", "Lcom/larus/bmhome/chat/input/SendImageCacheCleanupTarget;", "recordCameraParam", "clickFrom", GXTemplateKey.GAIAX_TEMPLATE_ID, GXTemplateKey.GAIAX_TEMPLATE_TYPE, "registerOnChatInputIntercept", "onChatInputIntercept", "Lcom/larus/bmhome/chat/input/OnChatInputIntercept;", "unregisterOnChatInputIntercept", "getInputUploadManager", "Lcom/larus/bmhome/chat/input/InputUploadManager;", "getInputResourceManager", "Lcom/larus/bmhome/chat/input/InputResourceManager;", "getMultimodalDowngradeData", "Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalDowngradeData;", "compatBuildBottomMultimodal", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "compatBuildBottomMultimodalBottomMenu", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "compatBuildBottomAttachmentPanel", "compatBuildBottomLatestPhotoShortcut", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IChatInputService {
    MultimodalDowngradeData A6();

    @Deprecated(message = "use component registry instead")
    BaseContentWidget a();

    @Deprecated(message = "use component registry instead")
    ComponentFeature b();

    void c();

    void d(String r100, String r101, String r102);

    void e(View r100, a r101);

    b f();

    c g();

    @Deprecated(message = "use component registry instead")
    BaseContentWidget h();

    String i(String r100, String r101);

    ChatInputPlaceholderMode j();

    List<e> k();

    View l(Context r100, a r101);

    @Deprecated(message = "use component registry instead")
    BaseContentWidget m();
}
