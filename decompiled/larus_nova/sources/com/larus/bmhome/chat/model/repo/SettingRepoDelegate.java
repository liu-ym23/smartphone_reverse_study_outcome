package com.larus.bmhome.chat.model.repo;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.model.api.DefaultActiveModeSettingValue;
import com.larus.bmhome.chat.model.api.DefaultActiveModelSettingItem;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuData;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuDataV2;
import com.larus.bmhome.chat.model.api.UserConfigActiveModeMenu;
import com.larus.bmhome.chat.setting.KevaLiveData;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\u0002\n\u0002\bI\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\t\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u001d\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\u0004\u0018\u0001`\u0015H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u0096\u0001J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0001J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0001J\t\u0010\u001d\u001a\u00020\bH\u0096\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u0096\u0001J\t\u0010 \u001a\u00020\u001fH\u0096\u0001J\t\u0010!\u001a\u00020\u001fH\u0096\u0001J\t\u0010\"\u001a\u00020\bH\u0096\u0001J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\t\u0010$\u001a\u00020\u001fH\u0096\u0001J\t\u0010%\u001a\u00020\u001fH\u0096\u0001J\t\u0010&\u001a\u00020\u001fH\u0096\u0001J\t\u0010'\u001a\u00020\u001fH\u0096\u0001J\t\u0010(\u001a\u00020\u001fH\u0096\u0001J\t\u0010)\u001a\u00020\u001fH\u0096\u0001J\t\u0010*\u001a\u00020\u001fH\u0096\u0001J\t\u0010+\u001a\u00020\u001fH\u0096\u0001J\t\u0010,\u001a\u00020\u001fH\u0096\u0001J\t\u0010-\u001a\u00020\u001fH\u0096\u0001J\t\u0010.\u001a\u00020\u001fH\u0096\u0001J\t\u0010/\u001a\u00020\u001fH\u0096\u0001J\t\u00100\u001a\u00020\u001fH\u0096\u0001J\t\u00101\u001a\u00020\u001fH\u0096\u0001J\t\u00102\u001a\u00020\u001fH\u0096\u0001J\t\u00103\u001a\u00020\u001fH\u0096\u0001J\t\u00104\u001a\u00020\u001fH\u0096\u0001J\t\u00105\u001a\u00020\u001fH\u0096\u0001J\t\u00106\u001a\u00020\u001fH\u0096\u0001J\t\u00107\u001a\u00020\u001fH\u0096\u0001J\t\u00108\u001a\u00020\u001fH\u0096\u0001J\t\u00109\u001a\u00020\u001fH\u0096\u0001J\t\u0010:\u001a\u00020\u001fH\u0096\u0001J\t\u0010;\u001a\u00020\u001fH\u0096\u0001J\t\u0010<\u001a\u00020\u001fH\u0096\u0001J\t\u0010=\u001a\u00020\u001fH\u0096\u0001J\t\u0010>\u001a\u00020\u001fH\u0096\u0001J\t\u0010?\u001a\u00020\u001fH\u0096\u0001J\t\u0010@\u001a\u00020\u001fH\u0096\u0001J\t\u0010A\u001a\u00020\u001fH\u0096\u0001J\u0011\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u001fH\u0096\u0001J\u0011\u0010D\u001a\u00020E2\u0006\u0010C\u001a\u00020\u001fH\u0096\u0001J\t\u0010F\u001a\u00020EH\u0096\u0001J\u0016\u0010G\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010J\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010K\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010L\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010M\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010N\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010O\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0011\u0010P\u001a\u00020E2\u0006\u0010Q\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010R\u001a\u00020E2\u0006\u0010C\u001a\u00020\u001fH\u0096\u0001J\u0011\u0010S\u001a\u00020E2\u0006\u0010T\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010U\u001a\u00020E2\u0006\u0010V\u001a\u00020\bH\u0096\u0001J\u0016\u0010W\u001a\u00020\u001f2\u0006\u0010X\u001a\u00020\u000fH\u0096A¢\u0006\u0002\u0010YJ&\u0010Z\u001a\u00020\u001f2\u0016\u0010[\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u0013j\u0002`\u0015H\u0096A¢\u0006\u0002\u0010\\J\u001e\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020\u00052\u0006\u0010_\u001a\u00020\bH\u0096A¢\u0006\u0002\u0010`J\u0016\u0010a\u001a\u00020\u001f2\u0006\u0010b\u001a\u00020\u001cH\u0096A¢\u0006\u0002\u0010cJ\u0011\u0010d\u001a\u00020E2\u0006\u0010e\u001a\u00020\bH\u0096\u0001J\u0016\u0010f\u001a\u00020\u001f2\u0006\u0010g\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010h\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010i\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010j\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010k\u001a\u00020\u001f2\u0006\u0010g\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010l\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0011\u0010m\u001a\u00020E2\u0006\u0010n\u001a\u00020\u001fH\u0096\u0001J\u0016\u0010o\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010p\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010q\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010r\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010s\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010t\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ6\u0010u\u001a\u00020\u001f2\u0006\u0010v\u001a\u00020\u001f2\u0006\u0010w\u001a\u00020\u001f2\u0006\u0010x\u001a\u00020\u001f2\u0006\u0010y\u001a\u00020\u001f2\u0006\u0010z\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010{J\u0011\u0010|\u001a\u00020E2\u0006\u0010C\u001a\u00020\u001fH\u0096\u0001J\u0016\u0010}\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010~\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0016\u0010\u007f\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\u0013\u0010\u0080\u0001\u001a\u00020E2\u0007\u0010\u0081\u0001\u001a\u00020\bH\u0096\u0001J\u0014\u0010\u0082\u0001\u001a\u00020E2\b\u0010Q\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u0012\u0010\u0083\u0001\u001a\u00020E2\u0006\u0010H\u001a\u00020\u001fH\u0096\u0001J\u0012\u0010\u0084\u0001\u001a\u00020E2\u0006\u0010C\u001a\u00020\u001fH\u0096\u0001J\u0012\u0010\u0085\u0001\u001a\u00020E2\u0006\u0010C\u001a\u00020\u001fH\u0096\u0001J\u0017\u0010\u0086\u0001\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IJ\n\u0010\u0087\u0001\u001a\u00020EH\u0096\u0001J\n\u0010\u0088\u0001\u001a\u00020EH\u0096\u0001J\n\u0010\u0089\u0001\u001a\u00020EH\u0096\u0001J\u0013\u0010\u008a\u0001\u001a\u00020E2\u0007\u0010\u008b\u0001\u001a\u00020\u0005H\u0096\u0001J\u0012\u0010\u008c\u0001\u001a\u00020E2\u0006\u0010C\u001a\u00020\u001fH\u0096\u0001J\u0017\u0010\u008d\u0001\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u001fH\u0096A¢\u0006\u0002\u0010IR\u001f\u0010\u008e\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0090\u00010\u008f\u0001X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001c\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u0094\u0001X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001¨\u0006\u0097\u0001"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/SettingRepoDelegate;", "Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "<init>", "()V", "currentAsrLanguage", "", "currentAsrModelLanguageKey", "currentDataModelType", "", "currentVoiceModelType", "asrLanguage", "getChatBotId", "getDefaultActiveModeMenu", "Lcom/larus/bmhome/chat/model/api/UserConfigActiveModeMenu;", "getDefaultActiveModeSettingValue", "Lcom/larus/bmhome/chat/model/api/DefaultActiveModeSettingValue;", "getDefaultActiveModelMenu", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuDataV2;", "getDefaultActiveModelSettingItem", "", "Lcom/larus/bmhome/chat/model/api/DefaultActiveModelSettingItem;", "Lcom/larus/bmhome/chat/model/api/DefaultActiveModelSettingItemMap;", "getDefaultModelItemKey", "Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "getDefaultModelItemMenu", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuData;", "getDefaultReplyMenuDataV2", "getDefaultReplyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "getEngineType", "getExpertSwitchState", "", "getFaceMemoryEnabled", "getGpt4SwitchState", "getSpeechLanguage", "getSpeechLanguageCode", "getVoiceHasEdit", "isAllowTrainByText", "isAllowTrainByUpload", "isAllowTrainByVideo", "isAllowTrainingEnable", "isAnswerWithSuggest", "isAppNotifyDetailEnable", "isAppNotifyEnable", "isCardSearchEnabled", "isFindByDoubaoUserNameEnable", "isFindByPhoneEnable", "isHighlightEnabled", "isHighlightGoWebview", "isInputSuggestEnable", "isInterruptEnabled", "isOptOutVoiceEnable", "isOrderMessageNotifyEnable", "isPersonalizedRecommendEnable", "isPictureLocationEnabled", "isRealtimeCallEnabled", "isRealtimeVoiceDenoiseTrainAuthorize", "isRelatedVideoEnabled", "isSaveChatHistoryEnable", "isScheduledJobNotifyEnable", "isStreamChat", "isSugAllEnabled", "isSugSearchEnabled", "isSystemNotifyEnable", "isUserClickBottom", "isUserClickSlidesBottom", "localToggleVoiceFeatureTrainAuthorizeChange", "enable", "onAdvancedWhiteStatusChanged", "", "preloadDefaultReplyOption", "saveAllowTrainByText", "toggle", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAllowTrainByUpload", "saveAllowTrainByVideo", "saveAllowTrainingEnable", "saveAnswerWithSuggest", "saveAppNotifyDetailEnable", "saveAppNotifyEnable", "saveAsrLanguage", "language", "saveCardSearchEnabled", "saveChatBotId", "botId", "saveDataModelType", "modelType", "saveDefaultActiveMode", "defaultActiveModeSettingValue", "(Lcom/larus/bmhome/chat/model/api/DefaultActiveModeSettingValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDefaultActiveModelSettingItemMap", "defaultActiveModelSettingItemMap", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDefaultModelItemKey", "modelItemKey", "itemId", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDefaultReplyOption", "replyOption", "(Lcom/larus/bmhome/actionbar/model/ReplyOption;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveEngineType", "type", "saveExpertSwitchState", "switch", "saveFaceMemoryEnabled", "saveFindByDoubaoUserNameEnable", "saveFindByPhoneEnable", "saveGpt4SwitchState", "saveHighlightEnabled", "saveHighlightGoWebview", "value", "saveInputSuggestEnable", "saveOptOutVoiceEnable", "saveOrderMessageNotifyEnable", "savePersonalizedRecommend", "savePersonalizedRecommendEnable", "savePictureLocationEnable", "savePrivacySettings", "optOutVoice", "allowTrainByText", "allowTrainByVideo", "allowTrainByUpload", "notifyServer", "(ZZZZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveRealtimeCallEnabled", "saveRelatedVideoEnabled", "saveSaveChatHistoryEnable", "saveScheduledJobNotifyEnable", "saveSpeechLanguage", "index", "saveSpeechLanguageCode", "saveStreamChat", "saveSugAllEnabled", "saveSugSearchEnabled", "saveSystemNotifyEnable", "saveUserClickBottom", "saveUserClickSlidesBottom", "saveVoiceHasEdit", "saveVoiceModelType", "modelName", "setInterruptEnabled", "toggleVoiceFeatureTrainAuthorizeChange", "checkLimitLive", "Lcom/larus/bmhome/chat/setting/KevaLiveData;", "Lcom/larus/bmhome/chat/setting/ChatLimitInfo;", "getCheckLimitLive", "()Lcom/larus/bmhome/chat/setting/KevaLiveData;", "promptStyleLive", "Landroidx/lifecycle/MutableLiveData;", "getPromptStyleLive", "()Landroidx/lifecycle/MutableLiveData;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SettingRepoDelegate implements ISettingRepoService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SettingRepoDelegate f307752b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ISettingRepoService f307753a;

    static {
        f307752b = new SettingRepoDelegate();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean A() {
        return this.f307753a.A();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void A0() {
        this.f307753a.A0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean B() {
        return this.f307753a.B();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object B0(boolean r100, boolean r101, boolean r110, boolean r111, boolean r112, Continuation<? super Boolean> r113) {
        return this.f307753a.B0(r100, r101, r110, r111, r112, r113);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object C(String r100, int r101, Continuation<? super Boolean> r102) {
        return this.f307753a.C(r100, r101, r102);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void C0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "language");
        this.f307753a.C0(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean D() {
        return this.f307753a.D();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object D0(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.D0(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean E() {
        return this.f307753a.E();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean E0() {
        return this.f307753a.E0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void F() {
        this.f307753a.F();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object F0(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.F0(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object G(DefaultActiveModeSettingValue r100, Continuation<? super Boolean> r101) {
        return this.f307753a.G(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean G0() {
        return this.f307753a.G0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean H() {
        return this.f307753a.H();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object H0(Map<String, DefaultActiveModelSettingItem> r100, Continuation<? super Boolean> r101) {
        return this.f307753a.H0(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean I() {
        return this.f307753a.I();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void I0(boolean r100) {
        this.f307753a.I0(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean J() {
        return this.f307753a.J();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object J0(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.J0(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final int K() {
        return this.f307753a.K();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void K0(boolean r100) {
        this.f307753a.K0(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Map<String, DefaultActiveModelSettingItem> L() {
        return this.f307753a.L();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final DefaultReplyMenuData L0() {
        return this.f307753a.L0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object M(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.M(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void M0(boolean r100) {
        this.f307753a.M0(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object N(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.N(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object N0(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.N0(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object O(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.O(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final ModelItemIdentity O0() {
        return this.f307753a.O0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object P(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.P(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean P0() {
        return this.f307753a.P0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object Q(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.Q(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final String Q0() {
        return this.f307753a.Q0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object R(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.R(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean R0() {
        return this.f307753a.R0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final ReplyOption S() {
        return this.f307753a.S();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final String S0() {
        return this.f307753a.S0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final UserConfigActiveModeMenu T() {
        return this.f307753a.T();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void T0(int r100) {
        this.f307753a.T0(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object U(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.U(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void U0(boolean r100) {
        this.f307753a.U0(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean V() {
        return this.f307753a.V();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final int V0() {
        return this.f307753a.V0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void W(boolean r100) {
        this.f307753a.W(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object W0(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.W0(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object X(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.X(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final KevaLiveData<wi8.a> Y() {
        return this.f307753a.Y();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final String Z(String r100) {
        return this.f307753a.Z(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void a0(boolean r100) {
        this.f307753a.a0(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final String b0() {
        return this.f307753a.b0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean c0() {
        return this.f307753a.c0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object d0(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.d0(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final DefaultReplyMenuDataV2 e0() {
        return this.f307753a.e0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean f0() {
        return this.f307753a.f0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean g() {
        return this.f307753a.g();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void g0() {
        this.f307753a.g0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean h() {
        return this.f307753a.h();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean h0() {
        return this.f307753a.h0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean i() {
        return this.f307753a.i();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean i0() {
        return this.f307753a.i0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean j() {
        return this.f307753a.j();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean j0() {
        return this.f307753a.j0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean k(boolean r100) {
        return this.f307753a.k(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean k0() {
        return this.f307753a.k0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object l(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.l(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean l0() {
        return this.f307753a.l0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean m() {
        return this.f307753a.m();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object m0(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.m0(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void n(int r100) {
        this.f307753a.n(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object n0(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.n0(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean o() {
        return this.f307753a.o();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object o0(ReplyOption r100, Continuation<? super Boolean> r101) {
        return this.f307753a.o0(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean p() {
        return this.f307753a.p();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final DefaultActiveModeSettingValue p0() {
        return this.f307753a.p0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean q() {
        return this.f307753a.q();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean q0() {
        return this.f307753a.q0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void r(int r100) {
        this.f307753a.r(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final String r0() {
        return this.f307753a.r0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final int s() {
        return this.f307753a.s();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean s0() {
        return this.f307753a.s0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object t(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.t(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean t0() {
        return this.f307753a.t0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void u(String r100) {
        this.f307753a.u(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object u0(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.u0(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object v(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.v(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object v0(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.v0(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final MutableLiveData<Integer> w() {
        return this.f307753a.w();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object w0(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.w0(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final Object x(boolean r100, Continuation<? super Boolean> r101) {
        return this.f307753a.x(r100, r101);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean x0() {
        return this.f307753a.x0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final DefaultReplyMenuDataV2 y() {
        return this.f307753a.y();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final boolean y0() {
        return this.f307753a.y0();
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void z(boolean r100) {
        this.f307753a.z(r100);
    }

    @Override // com.larus.bmhome.chat.model.repo.ISettingRepoService
    public final void z0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "modelName");
        this.f307753a.z0(r100);
    }

    private SettingRepoDelegate() {
        ISettingRepoService r100 = (ISettingRepoService) ServiceManager.get().getService(ISettingRepoService.class);
        if (r100 != null) goto L5;
        r100 = new SettingRepoServiceNoop();
    L5:
        this.f307753a = r100;
    }
}
