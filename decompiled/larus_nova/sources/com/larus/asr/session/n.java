package com.larus.asr.session;

import com.larus.asr.VoiceInputType;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public interface n {
    void breakAnswer(String r100);

    void cancelAudioText(Message r100);

    void deleteOnNoAudioContent(Message r100);

    void deleteOnNoAudioContentWithoutContent(Message r100);

    void failAudioText(Message r100, String r101, long r102);

    void prepareAudioText(String r100, wc9.e r101, String r102, ChatPageContext r103, Function1<? super Message, Unit> r104);

    void sendAudioText(String r100, ic8.w r101, Message r102, VoiceInputType r103);

    void sendFileAndTxt(wc9.e r100, String r101, List<? extends ic8.w> r102, String r103, Long r104);

    void streamAudioText(Message r100);

    void submitAudioText(Message r100);
}
