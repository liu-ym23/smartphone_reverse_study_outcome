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
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\n\u0010\r\u001a\u0004\u0018\u00010\tH&J\u0014\u0010\u000e\u001a\u00020\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0014H&J\b\u0010\u0018\u001a\u00020\u0014H&J\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0014H&J\u0016\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\u0016\u0010 \u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\u0016\u0010!\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\"\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\u0016\u0010#\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\u0016\u0010$\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\b\u0010%\u001a\u00020\u0014H&J\b\u0010&\u001a\u00020\u0014H&J\b\u0010'\u001a\u00020\u0014H&J\b\u0010(\u001a\u00020\u0014H&J\u0016\u0010)\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\u0016\u0010*\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\u0016\u0010+\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\u0016\u0010,\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\b\u00106\u001a\u00020\u0014H&J\u0010\u00107\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u00108\u001a\u00020\u0014H&J\u0010\u00109\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010:\u001a\u00020\u0014H&J\u0010\u0010;\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010<\u001a\u00020\u0014H&J\u0010\u0010=\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010>\u001a\u00020\u0005H&J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u0005H&J\b\u0010A\u001a\u00020\u0014H&J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u0014H&J\b\u0010D\u001a\u00020\u0014H&J\u0016\u0010E\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\b\u0010F\u001a\u00020\u0014H&J\u0010\u0010G\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010H\u001a\u00020\u0014H&J\b\u0010I\u001a\u00020\u0014H&J\b\u0010J\u001a\u00020\u0014H&J\b\u0010K\u001a\u00020\u0014H&J\b\u0010L\u001a\u00020\u0014H&J\b\u0010M\u001a\u00020\u0014H&J\b\u0010N\u001a\u00020\u0014H&J\b\u0010O\u001a\u00020\u0014H&J\u0016\u0010P\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\b\u0010Q\u001a\u00020\u0014H&J\u0016\u0010R\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\b\u0010S\u001a\u00020\u0014H&J\u0016\u0010T\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\b\u0010U\u001a\u00020\u0014H&J\u0016\u0010V\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\b\u0010W\u001a\u00020\u0014H&J\u0010\u0010X\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0016\u0010Y\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\b\u0010Z\u001a\u00020\u0014H&J\b\u0010[\u001a\u00020\u0014H&J\b\u0010\\\u001a\u00020\u0003H&J\u0016\u0010]\u001a\u00020\u00142\u0006\u0010^\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\b\u0010_\u001a\u00020\u0014H&J\u0016\u0010`\u001a\u00020\u00142\u0006\u0010^\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\b\u0010a\u001a\u00020\u0005H&J\u0010\u0010b\u001a\u00020\u00032\u0006\u0010c\u001a\u00020\u0005H&J\u0010\u0010d\u001a\u00020\u00032\u0006\u0010e\u001a\u00020\tH&J\b\u0010f\u001a\u00020\tH&J\b\u0010g\u001a\u00020\u0003H&J\b\u0010h\u001a\u00020\u0014H&J\b\u0010i\u001a\u00020\u0003H&J\b\u0010j\u001a\u00020\u0014H&J\b\u0010k\u001a\u00020\u0014H&J\u0016\u0010l\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\b\u0010m\u001a\u00020nH&J\n\u0010o\u001a\u0004\u0018\u00010pH&J\b\u0010q\u001a\u00020\u0003H&J\n\u0010r\u001a\u0004\u0018\u00010sH&J\n\u0010t\u001a\u0004\u0018\u00010uH&J\n\u0010v\u001a\u0004\u0018\u00010wH&J\n\u0010x\u001a\u0004\u0018\u00010yH&J\n\u0010z\u001a\u0004\u0018\u00010uH&J\u001c\u0010{\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020}\u0018\u00010|j\u0004\u0018\u0001`~H&J\u0018\u0010\u007f\u001a\u00020\u00142\u0007\u0010\u0080\u0001\u001a\u00020yH¦@¢\u0006\u0003\u0010\u0081\u0001J)\u0010\u0082\u0001\u001a\u00020\u00142\u0017\u0010\u0083\u0001\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020}0|j\u0002`~H¦@¢\u0006\u0003\u0010\u0084\u0001J\"\u0010\u0085\u0001\u001a\u00020\u00142\u0007\u0010\u0086\u0001\u001a\u00020\t2\u0007\u0010\u0087\u0001\u001a\u00020\u0005H¦@¢\u0006\u0003\u0010\u0088\u0001J\u0019\u0010\u0089\u0001\u001a\u00020\u00142\u0007\u0010\u008a\u0001\u001a\u00020pH¦@¢\u0006\u0003\u0010\u008b\u0001J\u0017\u0010\u008c\u0001\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001aJ\t\u0010\u008d\u0001\u001a\u00020\u0014H&J=\u0010\u008e\u0001\u001a\u00020\u00142\u0007\u0010\u008f\u0001\u001a\u00020\u00142\u0007\u0010\u0090\u0001\u001a\u00020\u00142\u0007\u0010\u0091\u0001\u001a\u00020\u00142\u0007\u0010\u0092\u0001\u001a\u00020\u00142\u0007\u0010\u0093\u0001\u001a\u00020\u0014H¦@¢\u0006\u0003\u0010\u0094\u0001R\u0018\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050.X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u001a\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010302X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u0006\u0095\u0001"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "", "saveSpeechLanguage", "", "index", "", "getSpeechLanguage", "saveAsrLanguage", "language", "", "currentAsrLanguage", "currentAsrModelLanguageKey", "saveSpeechLanguageCode", "getSpeechLanguageCode", "currentVoiceModelType", "asrLanguage", "saveVoiceModelType", "modelName", "onAdvancedWhiteStatusChanged", "enable", "", "isStreamChat", "saveStreamChat", "toggle", "isAnswerWithSuggest", "saveAnswerWithSuggest", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isOptOutVoiceEnable", "saveOptOutVoiceEnable", "saveFindByPhoneEnable", "saveFindByDoubaoUserNameEnable", "saveSystemNotifyEnable", "saveAppNotifyEnable", "saveAppNotifyDetailEnable", "saveScheduledJobNotifyEnable", "saveOrderMessageNotifyEnable", "savePersonalizedRecommend", "isAllowTrainingEnable", "isAllowTrainByText", "isAllowTrainByVideo", "isAllowTrainByUpload", "saveAllowTrainingEnable", "saveAllowTrainByText", "saveAllowTrainByVideo", "saveAllowTrainByUpload", "promptStyleLive", "Landroidx/lifecycle/MutableLiveData;", "getPromptStyleLive", "()Landroidx/lifecycle/MutableLiveData;", "checkLimitLive", "Lcom/larus/bmhome/chat/setting/KevaLiveData;", "Lcom/larus/bmhome/chat/setting/ChatLimitInfo;", "getCheckLimitLive", "()Lcom/larus/bmhome/chat/setting/KevaLiveData;", "isInterruptEnabled", "setInterruptEnabled", "isSugAllEnabled", "saveSugAllEnabled", "isSugSearchEnabled", "saveSugSearchEnabled", "isCardSearchEnabled", "saveCardSearchEnabled", "getEngineType", "saveEngineType", "type", "isHighlightGoWebview", "saveHighlightGoWebview", "value", "isHighlightEnabled", "saveHighlightEnabled", "isRealtimeCallEnabled", "saveRealtimeCallEnabled", "isPersonalizedRecommendEnable", "isFindByPhoneEnable", "isFindByDoubaoUserNameEnable", "isSystemNotifyEnable", "isAppNotifyEnable", "isAppNotifyDetailEnable", "isScheduledJobNotifyEnable", "isOrderMessageNotifyEnable", "savePersonalizedRecommendEnable", "isPictureLocationEnabled", "savePictureLocationEnable", "isInputSuggestEnable", "saveInputSuggestEnable", "isSaveChatHistoryEnable", "saveSaveChatHistoryEnable", "isRealtimeVoiceDenoiseTrainAuthorize", "localToggleVoiceFeatureTrainAuthorizeChange", "toggleVoiceFeatureTrainAuthorizeChange", "getGpt4SwitchState", "getVoiceHasEdit", "saveVoiceHasEdit", "saveGpt4SwitchState", "switch", "getExpertSwitchState", "saveExpertSwitchState", "currentDataModelType", "saveDataModelType", "modelType", "saveChatBotId", "botId", "getChatBotId", "saveUserClickBottom", "isUserClickBottom", "saveUserClickSlidesBottom", "isUserClickSlidesBottom", "isRelatedVideoEnabled", "saveRelatedVideoEnabled", "getDefaultModelItemKey", "Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "getDefaultReplyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "preloadDefaultReplyOption", "getDefaultModelItemMenu", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuData;", "getDefaultReplyMenuDataV2", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuDataV2;", "getDefaultActiveModeMenu", "Lcom/larus/bmhome/chat/model/api/UserConfigActiveModeMenu;", "getDefaultActiveModeSettingValue", "Lcom/larus/bmhome/chat/model/api/DefaultActiveModeSettingValue;", "getDefaultActiveModelMenu", "getDefaultActiveModelSettingItem", "", "Lcom/larus/bmhome/chat/model/api/DefaultActiveModelSettingItem;", "Lcom/larus/bmhome/chat/model/api/DefaultActiveModelSettingItemMap;", "saveDefaultActiveMode", "defaultActiveModeSettingValue", "(Lcom/larus/bmhome/chat/model/api/DefaultActiveModeSettingValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDefaultActiveModelSettingItemMap", "defaultActiveModelSettingItemMap", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDefaultModelItemKey", "modelItemKey", "itemId", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDefaultReplyOption", "replyOption", "(Lcom/larus/bmhome/actionbar/model/ReplyOption;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveFaceMemoryEnabled", "getFaceMemoryEnabled", "savePrivacySettings", "optOutVoice", "allowTrainByText", "allowTrainByVideo", "allowTrainByUpload", "notifyServer", "(ZZZZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISettingRepoService {
    boolean A();

    void A0();

    boolean B();

    Object B0(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, Continuation<? super Boolean> r105);

    Object C(String r100, int r101, Continuation<? super Boolean> r102);

    void C0(String r100);

    boolean D();

    Object D0(boolean r100, Continuation<? super Boolean> r101);

    boolean E();

    boolean E0();

    void F();

    Object F0(boolean r100, Continuation<? super Boolean> r101);

    Object G(DefaultActiveModeSettingValue r100, Continuation<? super Boolean> r101);

    boolean G0();

    boolean H();

    Object H0(Map<String, DefaultActiveModelSettingItem> r100, Continuation<? super Boolean> r101);

    boolean I();

    void I0(boolean r100);

    boolean J();

    Object J0(boolean r100, Continuation<? super Boolean> r101);

    int K();

    void K0(boolean r100);

    Map<String, DefaultActiveModelSettingItem> L();

    DefaultReplyMenuData L0();

    Object M(boolean r100, Continuation<? super Boolean> r101);

    void M0(boolean r100);

    Object N(boolean r100, Continuation<? super Boolean> r101);

    Object N0(boolean r100, Continuation<? super Boolean> r101);

    Object O(boolean r100, Continuation<? super Boolean> r101);

    ModelItemIdentity O0();

    Object P(boolean r100, Continuation<? super Boolean> r101);

    boolean P0();

    Object Q(boolean r100, Continuation<? super Boolean> r101);

    String Q0();

    Object R(boolean r100, Continuation<? super Boolean> r101);

    boolean R0();

    ReplyOption S();

    String S0();

    UserConfigActiveModeMenu T();

    void T0(int r100);

    Object U(boolean r100, Continuation<? super Boolean> r101);

    void U0(boolean r100);

    boolean V();

    int V0();

    void W(boolean r100);

    Object W0(boolean r100, Continuation<? super Boolean> r101);

    Object X(boolean r100, Continuation<? super Boolean> r101);

    KevaLiveData<wi8.a> Y();

    String Z(String r100);

    void a0(boolean r100);

    String b0();

    boolean c0();

    Object d0(boolean r100, Continuation<? super Boolean> r101);

    DefaultReplyMenuDataV2 e0();

    boolean f0();

    boolean g();

    void g0();

    boolean h();

    boolean h0();

    boolean i();

    boolean i0();

    boolean j();

    boolean j0();

    boolean k(boolean r100);

    boolean k0();

    Object l(boolean r100, Continuation<? super Boolean> r101);

    boolean l0();

    boolean m();

    Object m0(boolean r100, Continuation<? super Boolean> r101);

    void n(int r100);

    Object n0(boolean r100, Continuation<? super Boolean> r101);

    boolean o();

    Object o0(ReplyOption r100, Continuation<? super Boolean> r101);

    boolean p();

    DefaultActiveModeSettingValue p0();

    boolean q();

    boolean q0();

    void r(int r100);

    String r0();

    int s();

    boolean s0();

    Object t(boolean r100, Continuation<? super Boolean> r101);

    boolean t0();

    void u(String r100);

    Object u0(boolean r100, Continuation<? super Boolean> r101);

    Object v(boolean r100, Continuation<? super Boolean> r101);

    Object v0(boolean r100, Continuation<? super Boolean> r101);

    MutableLiveData<Integer> w();

    Object w0(boolean r100, Continuation<? super Boolean> r101);

    Object x(boolean r100, Continuation<? super Boolean> r101);

    boolean x0();

    DefaultReplyMenuDataV2 y();

    boolean y0();

    void z(boolean r100);

    void z0(String r100);
}
