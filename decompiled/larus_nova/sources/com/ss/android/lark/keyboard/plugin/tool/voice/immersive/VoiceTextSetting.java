package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@AppConfig(key = "voice_text_setting")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/VoiceTextSetting;", "", "<init>", "()V", "chatPageVoiceButtonText", "", "voicePageSecondVoiceButtonText", "myAIKnowledgeVoiceButtonText", "voicePageSecondVoiceSendAllBtnText", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceTextSetting {

    @SerializedName("Lark_IM_AudioMsg_HoldToRecord_Button")
    public String chatPageVoiceButtonText;

    @SerializedName("MyAI_KnoAiNew_HoldToSpeak_Button")
    public String myAIKnowledgeVoiceButtonText;

    @SerializedName("Lark_IM_AudioReedit_HoldRecord_Button")
    public String voicePageSecondVoiceButtonText;

    @SerializedName("Lark_IM_AudioMsg_HoldContinueRecord_Button")
    public String voicePageSecondVoiceSendAllBtnText;

    public VoiceTextSetting() {
        this.chatPageVoiceButtonText = UIHelper.getString(R.string.Lark_IM_AudioMsg_HoldToRecord_Button);
        this.voicePageSecondVoiceButtonText = UIHelper.getString(R.string.Lark_IM_AudioReedit_HoldRecord_Button);
        this.myAIKnowledgeVoiceButtonText = UIHelper.getString(R.string.MyAI_KnoAiNew_HoldToSpeak_Button);
        this.voicePageSecondVoiceSendAllBtnText = UIHelper.getString(R.string.Lark_IM_AudioMsg_HoldContinueRecord_Button);
    }
}
