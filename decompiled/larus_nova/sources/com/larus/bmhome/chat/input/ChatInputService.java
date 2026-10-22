package com.larus.bmhome.chat.input;

import android.content.Context;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalDowngradeData;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ye8.a;
import ye8.b;
import ye8.c;
import ye8.e;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0097\u0001J\r\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0097\u0001J\t\u0010\b\u001a\u00020\tH\u0097\u0001J\r\u0010\n\u001a\u00060\u0005j\u0002`\u0006H\u0097\u0001J\u001b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0001J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0096\u0001J'\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001eH\u0096\u0001J\u0011\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0096\u0001J\u001f\u0010$\u001a\u0004\u0018\u00010\u001e2\b\u0010%\u001a\u0004\u0018\u00010\u001e2\b\u0010&\u001a\u0004\u0018\u00010\u001eH\u0096\u0001J\t\u0010'\u001a\u00020(H\u0096\u0001J\u0011\u0010)\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0096\u0001J\u0019\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001¨\u0006,"}, d2 = {"Lcom/larus/bmhome/chat/input/ChatInputService;", "Lcom/larus/bmhome/chat/input/IChatInputService;", "<init>", "()V", "compatBuildBottomAttachmentPanel", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "compatBuildBottomLatestPhotoShortcut", "compatBuildBottomMultimodal", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "compatBuildBottomMultimodalBottomMenu", "createChatInputPlaceholder", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "config", "Lcom/larus/bmhome/chat/input/ChatInputPlaceholderConfig;", "execSendImgMsgCacheScanner", "", "getInputResourceManager", "Lcom/larus/bmhome/chat/input/InputResourceManager;", "getInputUploadManager", "Lcom/larus/bmhome/chat/input/InputUploadManager;", "getMultimodalDowngradeData", "Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalDowngradeData;", "getSendImageCacheCleanupTargets", "", "Lcom/larus/bmhome/chat/input/SendImageCacheCleanupTarget;", "recordCameraParam", "clickFrom", "", GXTemplateKey.GAIAX_TEMPLATE_ID, GXTemplateKey.GAIAX_TEMPLATE_TYPE, "registerOnChatInputIntercept", "onChatInputIntercept", "Lcom/larus/bmhome/chat/input/OnChatInputIntercept;", "resolveChatInputPlaceholderHint", "conversationId", "configuredHint", "resolveInitialChatInputPlaceholderMode", "Lcom/larus/bmhome/chat/input/ChatInputPlaceholderMode;", "unregisterOnChatInputIntercept", "updateChatInputPlaceholder", "view", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatInputService implements IChatInputService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ChatInputService f303327b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IChatInputService f303328a;

    static {
        f303327b = new ChatInputService();
    }

    @Override // com.larus.bmhome.chat.input.IChatInputService
    public final MultimodalDowngradeData A6() {
        return this.f303328a.A6();
    }

    @Override // com.larus.bmhome.chat.input.IChatInputService
    @Deprecated(message = "use component registry instead")
    public final BaseContentWidget a() {
        return this.f303328a.a();
    }

    @Override // com.larus.bmhome.chat.input.IChatInputService
    @Deprecated(message = "use component registry instead")
    public final ComponentFeature b() {
        return this.f303328a.b();
    }

    @Override // com.larus.bmhome.chat.input.IChatInputService
    public final void c() {
        this.f303328a.c();
    }

    @Override // com.larus.bmhome.chat.input.IChatInputService
    public final void d(String r100, String r101, String r102) {
        this.f303328a.d(r100, r101, r102);
    }

    @Override // com.larus.bmhome.chat.input.IChatInputService
    public final void e(View r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f303328a.e(r100, r101);
    }

    @Override // com.larus.bmhome.chat.input.IChatInputService
    public final b f() {
        return this.f303328a.f();
    }

    @Override // com.larus.bmhome.chat.input.IChatInputService
    public final c g() {
        return this.f303328a.g();
    }

    @Override // com.larus.bmhome.chat.input.IChatInputService
    @Deprecated(message = "use component registry instead")
    public final BaseContentWidget h() {
        return this.f303328a.h();
    }

    @Override // com.larus.bmhome.chat.input.IChatInputService
    public final String i(String r100, String r101) {
        return this.f303328a.i(r100, r101);
    }

    @Override // com.larus.bmhome.chat.input.IChatInputService
    public final ChatInputPlaceholderMode j() {
        return this.f303328a.j();
    }

    @Override // com.larus.bmhome.chat.input.IChatInputService
    public final List<e> k() {
        return this.f303328a.k();
    }

    @Override // com.larus.bmhome.chat.input.IChatInputService
    public final View l(Context r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        return this.f303328a.l(r100, r101);
    }

    @Override // com.larus.bmhome.chat.input.IChatInputService
    @Deprecated(message = "use component registry instead")
    public final BaseContentWidget m() {
        return this.f303328a.m();
    }

    private ChatInputService() {
        IChatInputService r100 = (IChatInputService) ServiceManager.get().getService(IChatInputService.class);
        if (r100 != null) goto L5;
        r100 = new ChatInputServiceNoop();
    L5:
        this.f303328a = r100;
    }
}
