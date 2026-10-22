package com.larus.bmhome.auth.feature_config;

import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import com.larus.bmhome.auth.feature_config.model.FeatureDetailWithSwitch;
import com.larus.bmhome.auth.feature_config.model.IFeatureKitService;
import com.larus.utils.l0;
import kotlin.Metadata;
import za8.a0;
import za8.b;
import za8.b0;
import za8.c;
import za8.c0;
import za8.d;
import za8.d0;
import za8.e;
import za8.e0;
import za8.f;
import za8.f0;
import za8.g;
import za8.g0;
import za8.h;
import za8.h0;
import za8.i;
import za8.i0;
import za8.j;
import za8.j0;
import za8.k;
import za8.k0;
import za8.l;
import za8.m;
import za8.m0;
import za8.n;
import za8.n0;
import za8.o;
import za8.o0;
import za8.p;
import za8.p0;
import za8.q;
import za8.r;
import za8.t;
import za8.u;
import za8.v;
import za8.w;
import za8.x;
import za8.y;
import za8.z;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b7\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0014\u0010\u0018\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0014\u0010\u001a\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u0014\u0010\u001c\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007R\u0014\u0010\u001e\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0007R\u0014\u0010 \u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0007R\u0014\u0010\"\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0007R\u0014\u0010$\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0007R\u0014\u0010&\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0007R\u0014\u0010(\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0007R\u0014\u0010*\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0007R\u0014\u0010,\u001a\u00020-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u00020-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010/R\u0014\u00102\u001a\u00020-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010/R\u0014\u00104\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0007R\u0014\u00106\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0007R\u0014\u00108\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0007R\u0014\u0010:\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0007R\u0014\u0010<\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0007R\u0014\u0010>\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0007R\u0014\u0010@\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0007R\u0014\u0010B\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0007R\u0014\u0010D\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u0007R\u0014\u0010F\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0007R\u0014\u0010H\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u0007R\u0014\u0010J\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0007R\u0014\u0010L\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u0007R\u0014\u0010N\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u0007R\u0014\u0010P\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\u0007R\u0014\u0010R\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\u0007R\u0014\u0010T\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u0010\u0007R\u0014\u0010V\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010\u0007R\u0014\u0010X\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010\u0007R\u0014\u0010Z\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u0007R\u0014\u0010\\\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b]\u0010\u0007R\u0014\u0010^\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010\u0007R\u0014\u0010`\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010\u0007R\u0014\u0010b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010\u0007¨\u0006d"}, d2 = {"Lcom/larus/bmhome/auth/feature_config/FeatureKitImpl;", "Lcom/larus/bmhome/auth/feature_config/model/IFeatureKitService;", "<init>", "()V", "personalizedRecommend", "Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;", "getPersonalizedRecommend", "()Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;", "answerWithSuggest", "getAnswerWithSuggest", "answerWithVideo", "getAnswerWithVideo", "inputWithSuggest", "getInputWithSuggest", "namedEntityHighlight", "getNamedEntityHighlight", "ugcVoice", "getUgcVoice", "botHeat", "getBotHeat", "bio", "getBio", "voiceCallEnabled", "getVoiceCallEnabled", "discoveryTag", "getDiscoveryTag", "enableShowSaveChatHistoryItem", "getEnableShowSaveChatHistoryItem", "sendImgMsgDebug", "getSendImgMsgDebug", "sendVLMImgMsgDebug", "getSendVLMImgMsgDebug", "enableSendAudio", "getEnableSendAudio", "enableShowThirdService", "getEnableShowThirdService", "sendFileMsgDebug", "getSendFileMsgDebug", "sendMultiFileMsg", "getSendMultiFileMsg", "sendMultiImageMsg", "getSendMultiImageMsg", "sendMultiFileImageMsg", "getSendMultiFileImageMsg", "enableSearchAndGen", "Lcom/larus/bmhome/auth/feature_config/model/FeatureDetailWithSwitch;", "getEnableSearchAndGen", "()Lcom/larus/bmhome/auth/feature_config/model/FeatureDetailWithSwitch;", "enableSearch", "getEnableSearch", "enableGen", "getEnableGen", "botSearch", "getBotSearch", "discoverTag", "getDiscoverTag", "profileJump", "getProfileJump", "filterAddedConversationInRecommend", "getFilterAddedConversationInRecommend", "attachmentAreaDebug", "getAttachmentAreaDebug", "settingExpert", "getSettingExpert", "actionbarExpert", "getActionbarExpert", "expertCardAutoCollapse", "getExpertCardAutoCollapse", "actionbarConfigurable", "getActionbarConfigurable", "botCreateEnableSticky", "getBotCreateEnableSticky", "activeVoiceConfig", "getActiveVoiceConfig", "textToImageReverse", "getTextToImageReverse", "attachImgCamera", "getAttachImgCamera", "attachImgAlbum", "getAttachImgAlbum", "attachFile", "getAttachFile", "previewImgCamera", "getPreviewImgCamera", "attachSug", "getAttachSug", "previewSug", "getPreviewSug", "relatedVideo", "getRelatedVideo", "recordReplyMode", "getRecordReplyMode", "defaultReplyModeMenu", "getDefaultReplyModeMenu", "defaultReplyModeMenuUseV3", "getDefaultReplyModeMenuUseV3", "defaultActiveModeMenu", "getDefaultActiveModeMenu", "feishuDoubaoDispatch", "getFeishuDoubaoDispatch", "impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureKitImpl implements IFeatureKitService {
    public FeatureKitImpl() {
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail A0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, false), new b0());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail B0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new o0());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail C0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new e());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail D0() {
        p0.a r100 = p0.f571095a;
        return (FeatureDetail) p0.f571096b.getValue();
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail E0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new u());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail R() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new j());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail S() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new k0());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail T() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new e0());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail U() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new h());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail V() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new x());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail W() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new k());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail X() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new n());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail Y() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new t());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail Z() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new c());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetailWithSwitch a0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetailWithSwitch) l0.a(new FeatureDetailWithSwitch(0), new m0());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail b() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new z());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetailWithSwitch b0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetailWithSwitch) l0.a(new FeatureDetailWithSwitch(0), new c0());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail c0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new g0());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail d0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new za8.l0());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail e0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new d());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail f0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new b());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail g0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new i());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail h0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new i0());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail i0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new y());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail j0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new w());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail k0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(true, true), new d0());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail l0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new m());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail m0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new o());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail n0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(true, true), new v());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail o0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new i());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail p0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(true, true), new q());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail q0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(true, true), new a0());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail r0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new f());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail s0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new n0());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail t0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new l());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail u0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(true, true), new h0());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail v0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new r());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail w0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new p());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail x0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new j0());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail y0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new g());
    }

    @Override // com.larus.bmhome.auth.feature_config.model.IFeatureKitService
    public final FeatureDetail z0() {
        p0.a r100 = p0.f571095a;
        int r101 = l0.f375430a;
        return (FeatureDetail) l0.a(new FeatureDetail(false, 3), new f0());
    }
}
