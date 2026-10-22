package com.bytedance.dora.voice;

import java.util.Map;
import sk4.a;
import sk4.c;
import sk4.d;
import sk4.e;
import sk4.g;
import tk4.l;

/* JADX INFO: loaded from: classes3.dex */
public interface IDoraVoice {
    int clearAudioPlayer();

    int commonTxSync(int r100, int r101, int r102, byte[] r103);

    boolean getRtosPlayerSwitchState();

    boolean getRtosPlayerSwitchVisiable();

    int pauseAudioPlayer();

    int playPrompt(int r100);

    void registerDoraVoiceCallback(d r100);

    void registerProtocolInfoCallback(c r100, boolean r101);

    e requestProtocolInfo();

    int resumeAudioPlayer();

    int sendAudioPlayerData(byte[] r100);

    int sendAudioPlayerDataEnd();

    int setAudioPlayerConfig(l r100);

    int setAudioPlayerVolume(float r100);

    int setConversationMode(int r100, int r101, int r102, int r103, int r104);

    void setRtosPlayerSwitchState(boolean r100);

    void setRtosPlayerSwitchVisiable(boolean r100);

    int setVUI(int r100);

    int setVUI(int r100, byte[] r101);

    int startConversationMode(int r100, int r101);

    int startVUI(int r100);

    int startVUI(int r100, int r101);

    int startVUI(int r100, int r101, int r102);

    int stopConversationMode(int r100);

    int stopVUI(int r100);

    int stopVUI(int r100, int r101);

    int syncPlayCommand(int r100);

    void syncVUICommand(int r100);

    void syncVUIData(byte[] r100);

    int syncVUIError(int r100);

    int syncVUIError(int r100, Map<String, Object> r101);

    int syncVUIEvent(g r100);

    int syncVUIEvent(g r100, byte[] r101);

    int syncVUIPreWakeUp(int r100);

    int syncVUIPreWakeUp(int r100, String r101);

    int syncVUIPreWakeUpEnable(int r100);

    int syncVolCommand(int r100);

    int syncVolLevel(int r100);

    a takeConversationModeInfo();

    int takeVolAbs();

    int takeVolLevel();

    void unRegisterDoraVoiceCallback(d r100);

    void unregisterProtocolInfoCallback(c r100);

    int updateVUIState(int r100);

    int updateVUIState(int r100, int r101);
}
