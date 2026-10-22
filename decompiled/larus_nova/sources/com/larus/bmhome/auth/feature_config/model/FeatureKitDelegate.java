package com.larus.bmhome.auth.feature_config.model;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b7\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0012\u0010\f\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0012\u0010\u000e\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0012\u0010\u0010\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0012\u0010\u0012\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0012\u0010\u0014\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0012\u0010\u0016\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0012\u0010\u0018\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0012\u0010\u001a\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u0012\u0010\u001c\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007R\u0012\u0010\u001e\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0007R\u0012\u0010 \u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\u0007R\u0012\u0010\"\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010\u0007R\u0012\u0010$\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010\u0007R\u0012\u0010&\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b'\u0010\u0007R\u0012\u0010(\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010\u0007R\u0012\u0010*\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b+\u0010\u0007R\u0012\u0010,\u001a\u00020-X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0012\u00100\u001a\u00020-X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u0010/R\u0012\u00102\u001a\u00020-X\u0096\u0005¢\u0006\u0006\u001a\u0004\b3\u0010/R\u0012\u00104\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b5\u0010\u0007R\u0012\u00106\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b7\u0010\u0007R\u0012\u00108\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b9\u0010\u0007R\u0012\u0010:\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b;\u0010\u0007R\u0012\u0010<\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b=\u0010\u0007R\u0012\u0010>\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b?\u0010\u0007R\u0012\u0010@\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bA\u0010\u0007R\u0012\u0010B\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bC\u0010\u0007R\u0012\u0010D\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bE\u0010\u0007R\u0012\u0010F\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bG\u0010\u0007R\u0012\u0010H\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bI\u0010\u0007R\u0012\u0010J\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bK\u0010\u0007R\u0012\u0010L\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bM\u0010\u0007R\u0012\u0010N\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bO\u0010\u0007R\u0012\u0010P\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bQ\u0010\u0007R\u0012\u0010R\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bS\u0010\u0007R\u0012\u0010T\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bU\u0010\u0007R\u0012\u0010V\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bW\u0010\u0007R\u0012\u0010X\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bY\u0010\u0007R\u0012\u0010Z\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b[\u0010\u0007R\u0012\u0010\\\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b]\u0010\u0007R\u0012\u0010^\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b_\u0010\u0007R\u0012\u0010`\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\ba\u0010\u0007R\u0012\u0010b\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bc\u0010\u0007¨\u0006d"}, d2 = {"Lcom/larus/bmhome/auth/feature_config/model/FeatureKitDelegate;", "Lcom/larus/bmhome/auth/feature_config/model/IFeatureKitService;", "<init>", "()V", "actionbarConfigurable", "Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;", "getActionbarConfigurable", "()Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;", "actionbarExpert", "getActionbarExpert", "activeVoiceConfig", "getActiveVoiceConfig", "answerWithSuggest", "getAnswerWithSuggest", "answerWithVideo", "getAnswerWithVideo", "attachFile", "getAttachFile", "attachImgAlbum", "getAttachImgAlbum", "attachImgCamera", "getAttachImgCamera", "attachSug", "getAttachSug", "attachmentAreaDebug", "getAttachmentAreaDebug", "bio", "getBio", "botCreateEnableSticky", "getBotCreateEnableSticky", "botHeat", "getBotHeat", "botSearch", "getBotSearch", "defaultActiveModeMenu", "getDefaultActiveModeMenu", "defaultReplyModeMenu", "getDefaultReplyModeMenu", "defaultReplyModeMenuUseV3", "getDefaultReplyModeMenuUseV3", "discoverTag", "getDiscoverTag", "discoveryTag", "getDiscoveryTag", "enableGen", "Lcom/larus/bmhome/auth/feature_config/model/FeatureDetailWithSwitch;", "getEnableGen", "()Lcom/larus/bmhome/auth/feature_config/model/FeatureDetailWithSwitch;", "enableSearch", "getEnableSearch", "enableSearchAndGen", "getEnableSearchAndGen", "enableSendAudio", "getEnableSendAudio", "enableShowSaveChatHistoryItem", "getEnableShowSaveChatHistoryItem", "enableShowThirdService", "getEnableShowThirdService", "expertCardAutoCollapse", "getExpertCardAutoCollapse", "feishuDoubaoDispatch", "getFeishuDoubaoDispatch", "filterAddedConversationInRecommend", "getFilterAddedConversationInRecommend", "inputWithSuggest", "getInputWithSuggest", "namedEntityHighlight", "getNamedEntityHighlight", "personalizedRecommend", "getPersonalizedRecommend", "previewImgCamera", "getPreviewImgCamera", "previewSug", "getPreviewSug", "profileJump", "getProfileJump", "recordReplyMode", "getRecordReplyMode", "relatedVideo", "getRelatedVideo", "sendFileMsgDebug", "getSendFileMsgDebug", "sendImgMsgDebug", "getSendImgMsgDebug", "sendMultiFileImageMsg", "getSendMultiFileImageMsg", "sendMultiFileMsg", "getSendMultiFileMsg", "sendMultiImageMsg", "getSendMultiImageMsg", "sendVLMImgMsgDebug", "getSendVLMImgMsgDebug", "settingExpert", "getSettingExpert", "textToImageReverse", "getTextToImageReverse", "ugcVoice", "getUgcVoice", "voiceCallEnabled", "getVoiceCallEnabled", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureKitDelegate implements IFeatureKitService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FeatureKitDelegate f295792b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IFeatureKitService f295793a;

    static {
        f295792b = new FeatureKitDelegate();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail A0() {
        return this.f295793a.A0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail B0() {
        return this.f295793a.B0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail C0() {
        return this.f295793a.C0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail D0() {
        return this.f295793a.D0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail E0() {
        return this.f295793a.E0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail R() {
        return this.f295793a.R();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail S() {
        return this.f295793a.S();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail T() {
        return this.f295793a.T();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail U() {
        return this.f295793a.U();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail V() {
        return this.f295793a.V();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail W() {
        return this.f295793a.W();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail X() {
        return this.f295793a.X();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail Y() {
        return this.f295793a.Y();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail Z() {
        return this.f295793a.Z();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetailWithSwitch a0() {
        return this.f295793a.a0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail b() {
        return this.f295793a.b();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetailWithSwitch b0() {
        return this.f295793a.b0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail c0() {
        return this.f295793a.c0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail d0() {
        return this.f295793a.d0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail e0() {
        return this.f295793a.e0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail f0() {
        return this.f295793a.f0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail g0() {
        return this.f295793a.g0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail h0() {
        return this.f295793a.h0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail i0() {
        return this.f295793a.i0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail j0() {
        return this.f295793a.j0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail k0() {
        return this.f295793a.k0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail l0() {
        return this.f295793a.l0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail m0() {
        return this.f295793a.m0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail n0() {
        return this.f295793a.n0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail o0() {
        return this.f295793a.o0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail p0() {
        return this.f295793a.p0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail q0() {
        return this.f295793a.q0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail r0() {
        return this.f295793a.r0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail s0() {
        return this.f295793a.s0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail t0() {
        return this.f295793a.t0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail u0() {
        return this.f295793a.u0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail v0() {
        return this.f295793a.v0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail w0() {
        return this.f295793a.w0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail x0() {
        return this.f295793a.x0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail y0() {
        return this.f295793a.y0();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail z0() {
        return this.f295793a.z0();
    }

    private FeatureKitDelegate() {
        IFeatureKitService r100 = (IFeatureKitService) ServiceManager.get().getService(IFeatureKitService.class);
        if (r100 != null) goto L5;
        r100 = new FeatureKitServiceNoop();
    L5:
        this.f295793a = r100;
    }
}
