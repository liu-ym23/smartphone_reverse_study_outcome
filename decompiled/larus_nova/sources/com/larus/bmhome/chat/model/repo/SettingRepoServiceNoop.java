package com.larus.bmhome.chat.model.repo;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.keva.Keva;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.model.api.DefaultActiveModeSettingValue;
import com.larus.bmhome.chat.model.api.DefaultActiveModelSettingItem;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuData;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuDataV2;
import com.larus.bmhome.chat.model.api.UserConfigActiveModeMenu;
import com.larus.bmhome.chat.setting.KevaLiveData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\bP\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0017H\u0016J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\"H\u0016J\u0016\u0010'\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\"H\u0016J\u0016\u0010*\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\u0016\u0010+\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\u0016\u0010,\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\u0016\u0010-\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\u0016\u0010.\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\u0016\u0010/\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\u0016\u00100\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\"H\u0016J\b\u00103\u001a\u00020\"H\u0016J\b\u00104\u001a\u00020\"H\u0016J\u0016\u00105\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\u0016\u00106\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\u0016\u00107\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\u0016\u00108\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\b\u00109\u001a\u00020\"H\u0016J\u0010\u0010:\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010;\u001a\u00020\"H\u0016J\u0010\u0010<\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010=\u001a\u00020\"H\u0016J\u0010\u0010>\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010?\u001a\u00020\"H\u0016J\u0010\u0010@\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010A\u001a\u00020\tH\u0016J\u0010\u0010B\u001a\u00020\u00122\u0006\u0010C\u001a\u00020\tH\u0016J\b\u0010D\u001a\u00020\"H\u0016J\u0010\u0010E\u001a\u00020\u00122\u0006\u0010F\u001a\u00020\"H\u0016J\b\u0010G\u001a\u00020\"H\u0016J\u0016\u0010H\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\b\u0010I\u001a\u00020\"H\u0016J\u0010\u0010J\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010K\u001a\u00020\"H\u0016J\b\u0010L\u001a\u00020\"H\u0016J\b\u0010M\u001a\u00020\"H\u0016J\b\u0010N\u001a\u00020\"H\u0016J\b\u0010O\u001a\u00020\"H\u0016J\b\u0010P\u001a\u00020\"H\u0016J\u0016\u0010Q\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\b\u0010R\u001a\u00020\"H\u0016J\u0016\u0010S\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\b\u0010T\u001a\u00020\"H\u0016J\u0016\u0010U\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\b\u0010V\u001a\u00020\"H\u0016J\u0016\u0010W\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\b\u0010X\u001a\u00020\"H\u0016J\u0010\u0010Y\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"H\u0016J\u0016\u0010Z\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\b\u0010[\u001a\u00020\"H\u0016J\b\u0010\\\u001a\u00020\"H\u0016J\b\u0010]\u001a\u00020\u0012H\u0016J\u0016\u0010^\u001a\u00020\"2\u0006\u0010_\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\b\u0010`\u001a\u00020\"H\u0016J\u0016\u0010a\u001a\u00020\"2\u0006\u0010_\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\b\u0010b\u001a\u00020\tH\u0016J\u0010\u0010c\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\tH\u0016J\u0010\u0010e\u001a\u00020\u00122\u0006\u0010f\u001a\u00020\u0017H\u0016J\b\u0010g\u001a\u00020\u0017H\u0016J\b\u0010h\u001a\u00020\u0012H\u0016J\b\u0010i\u001a\u00020\"H\u0016J\b\u0010j\u001a\u00020\u0012H\u0016J\b\u0010k\u001a\u00020\"H\u0016J\b\u0010l\u001a\u00020\"H\u0016J\u0016\u0010m\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\u0016\u0010n\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\b\u0010o\u001a\u00020\"H\u0016J\u0016\u0010p\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\b\u0010q\u001a\u00020\"H\u0016J\b\u0010r\u001a\u00020sH\u0016J\n\u0010t\u001a\u0004\u0018\u00010uH\u0016J\b\u0010v\u001a\u00020\u0012H\u0016J\n\u0010w\u001a\u0004\u0018\u00010xH\u0016J\n\u0010y\u001a\u0004\u0018\u00010zH\u0016J\n\u0010{\u001a\u0004\u0018\u00010|H\u0016J\n\u0010}\u001a\u0004\u0018\u00010~H\u0016J\n\u0010\u007f\u001a\u0004\u0018\u00010zH\u0016J \u0010\u0080\u0001\u001a\u0019\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030\u0082\u0001\u0018\u00010\u0081\u0001j\u0005\u0018\u0001`\u0083\u0001H\u0016J\u0019\u0010\u0084\u0001\u001a\u00020\"2\u0007\u0010\u0085\u0001\u001a\u00020~H\u0096@¢\u0006\u0003\u0010\u0086\u0001J,\u0010\u0087\u0001\u001a\u00020\"2\u001a\u0010\u0088\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030\u0082\u00010\u0081\u0001j\u0003`\u0083\u0001H\u0096@¢\u0006\u0003\u0010\u0089\u0001J\"\u0010\u008a\u0001\u001a\u00020\"2\u0007\u0010\u008b\u0001\u001a\u00020\u00172\u0007\u0010\u008c\u0001\u001a\u00020\tH\u0096@¢\u0006\u0003\u0010\u008d\u0001J\u0019\u0010\u008e\u0001\u001a\u00020\"2\u0007\u0010\u008f\u0001\u001a\u00020uH\u0096@¢\u0006\u0003\u0010\u0090\u0001J\u0017\u0010\u0091\u0001\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010(J\t\u0010\u0092\u0001\u001a\u00020\"H\u0016J=\u0010\u0093\u0001\u001a\u00020\"2\u0007\u0010\u0094\u0001\u001a\u00020\"2\u0007\u0010\u0095\u0001\u001a\u00020\"2\u0007\u0010\u0096\u0001\u001a\u00020\"2\u0007\u0010\u0097\u0001\u001a\u00020\"2\u0007\u0010\u0098\u0001\u001a\u00020\"H\u0096@¢\u0006\u0003\u0010\u0099\u0001R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u009a\u0001"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/SettingRepoServiceNoop;", "Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "<init>", "()V", "noopKeva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "promptStyleLive", "Landroidx/lifecycle/MutableLiveData;", "", "getPromptStyleLive", "()Landroidx/lifecycle/MutableLiveData;", "checkLimitLive", "Lcom/larus/bmhome/chat/setting/KevaLiveData;", "Lcom/larus/bmhome/chat/setting/ChatLimitInfo;", "getCheckLimitLive", "()Lcom/larus/bmhome/chat/setting/KevaLiveData;", "saveSpeechLanguage", "", "index", "getSpeechLanguage", "saveAsrLanguage", "language", "", "currentAsrLanguage", "currentAsrModelLanguageKey", "saveSpeechLanguageCode", "getSpeechLanguageCode", "currentVoiceModelType", "asrLanguage", "saveVoiceModelType", "modelName", "onAdvancedWhiteStatusChanged", "enable", "", "isStreamChat", "saveStreamChat", "toggle", "isAnswerWithSuggest", "saveAnswerWithSuggest", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isOptOutVoiceEnable", "saveOptOutVoiceEnable", "saveFindByPhoneEnable", "saveFindByDoubaoUserNameEnable", "saveSystemNotifyEnable", "saveAppNotifyEnable", "saveAppNotifyDetailEnable", "savePersonalizedRecommend", "isAllowTrainingEnable", "isAllowTrainByText", "isAllowTrainByVideo", "isAllowTrainByUpload", "saveAllowTrainingEnable", "saveAllowTrainByText", "saveAllowTrainByVideo", "saveAllowTrainByUpload", "isInterruptEnabled", "setInterruptEnabled", "isSugAllEnabled", "saveSugAllEnabled", "isSugSearchEnabled", "saveSugSearchEnabled", "isCardSearchEnabled", "saveCardSearchEnabled", "getEngineType", "saveEngineType", "type", "isHighlightGoWebview", "saveHighlightGoWebview", "value", "isHighlightEnabled", "saveHighlightEnabled", "isRealtimeCallEnabled", "saveRealtimeCallEnabled", "isPersonalizedRecommendEnable", "isFindByPhoneEnable", "isFindByDoubaoUserNameEnable", "isSystemNotifyEnable", "isAppNotifyEnable", "isAppNotifyDetailEnable", "savePersonalizedRecommendEnable", "isPictureLocationEnabled", "savePictureLocationEnable", "isInputSuggestEnable", "saveInputSuggestEnable", "isSaveChatHistoryEnable", "saveSaveChatHistoryEnable", "isRealtimeVoiceDenoiseTrainAuthorize", "localToggleVoiceFeatureTrainAuthorizeChange", "toggleVoiceFeatureTrainAuthorizeChange", "getGpt4SwitchState", "getVoiceHasEdit", "saveVoiceHasEdit", "saveGpt4SwitchState", "switch", "getExpertSwitchState", "saveExpertSwitchState", "currentDataModelType", "saveDataModelType", "modelType", "saveChatBotId", "botId", "getChatBotId", "saveUserClickBottom", "isUserClickBottom", "saveUserClickSlidesBottom", "isUserClickSlidesBottom", "isRelatedVideoEnabled", "saveRelatedVideoEnabled", "saveScheduledJobNotifyEnable", "isScheduledJobNotifyEnable", "saveOrderMessageNotifyEnable", "isOrderMessageNotifyEnable", "getDefaultModelItemKey", "Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "getDefaultReplyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "preloadDefaultReplyOption", "getDefaultModelItemMenu", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuData;", "getDefaultReplyMenuDataV2", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuDataV2;", "getDefaultActiveModeMenu", "Lcom/larus/bmhome/chat/model/api/UserConfigActiveModeMenu;", "getDefaultActiveModeSettingValue", "Lcom/larus/bmhome/chat/model/api/DefaultActiveModeSettingValue;", "getDefaultActiveModelMenu", "getDefaultActiveModelSettingItem", "", "Lcom/larus/bmhome/chat/model/api/DefaultActiveModelSettingItem;", "Lcom/larus/bmhome/chat/model/api/DefaultActiveModelSettingItemMap;", "saveDefaultActiveMode", "defaultActiveModeSettingValue", "(Lcom/larus/bmhome/chat/model/api/DefaultActiveModeSettingValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDefaultActiveModelSettingItemMap", "defaultActiveModelSettingItemMap", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDefaultModelItemKey", "modelItemKey", "itemId", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDefaultReplyOption", "replyOption", "(Lcom/larus/bmhome/actionbar/model/ReplyOption;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveFaceMemoryEnabled", "getFaceMemoryEnabled", "savePrivacySettings", "optOutVoice", "allowTrainByText", "allowTrainByVideo", "allowTrainByUpload", "notifyServer", "(ZZZZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SettingRepoServiceNoop implements ISettingRepoService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<Integer> f307754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KevaLiveData<wi8.a> f307755b;

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean A() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void A0() {
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean B() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void C0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "language");
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean D() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean E() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean E0() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void F() {
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean G0() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean H() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean I() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void I0(boolean r100) {
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean J() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final int K() {
        return 0;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void K0(boolean r100) {
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Map<String, DefaultActiveModelSettingItem> L() {
        return null;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final DefaultReplyMenuData L0() {
        return null;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void M0(boolean r100) {
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean P0() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final String Q0() {
        return null;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean R0() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final ReplyOption S() {
        return null;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final String S0() {
        return "";
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final UserConfigActiveModeMenu T() {
        return null;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void T0(int r100) {
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void U0(boolean r100) {
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean V() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final int V0() {
        return 0;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void W(boolean r100) {
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final String Z(String r100) {
        return "";
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void a0(boolean r100) {
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final String b0() {
        return "";
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean c0() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final DefaultReplyMenuDataV2 e0() {
        return null;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean f0() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean g() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void g0() {
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean h() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean h0() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean i() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean i0() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean j() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean j0() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean k(boolean r100) {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean k0() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean l0() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean m() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void n(int r100) {
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean o() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean p() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final DefaultActiveModeSettingValue p0() {
        return null;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean q() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean q0() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void r(int r100) {
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final String r0() {
        return "";
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final int s() {
        return 0;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean s0() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean t0() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void u(String r100) {
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean x0() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final DefaultReplyMenuDataV2 y() {
        return null;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean y0() {
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void z(boolean r100) {
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void z0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "modelName");
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final ModelItemIdentity O0() {
        return new ModelItemIdentity(null, null);
    }

    public SettingRepoServiceNoop() {
        Keva r100 = Keva.getRepo("flow_setting_repo_noop");
        this.f307754a = new MutableLiveData(0);
        this.f307755b = new KevaLiveData(r100, "noop_check_limit", new g2(), new h2());
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final KevaLiveData<wi8.a> Y() {
        return this.f307755b;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final MutableLiveData<Integer> w() {
        return this.f307754a;
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object D0(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object F0(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object G(DefaultActiveModeSettingValue r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object H0(Map<String, DefaultActiveModelSettingItem> r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object J0(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object M(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object N(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object N0(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object O(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object P(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object Q(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object R(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object U(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object W0(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object X(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object d0(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object l(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object m0(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object n0(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object o0(ReplyOption r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object t(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object u0(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object v(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object v0(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object w0(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object x(boolean r100, Continuation<? super Boolean> r101) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object C(String r100, int r101, Continuation<? super Boolean> r102) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object B0(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, Continuation<? super Boolean> r105) {
        return Boxing.boxBoolean(false);
    }
}
