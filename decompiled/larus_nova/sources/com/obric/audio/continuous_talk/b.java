package com.obric.audio.continuous_talk;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.im.bean.bot.SpeakerVoice;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public interface b extends m1a.a {
    void B6(String r100);

    boolean I0(JSONObject r100);

    boolean a0();

    String hr(String r100, String r101, Integer r102, Integer r103, String r104, String r105, SpeakerVoice r106, de8.c r107, by7.e r108, String r110, String r111, String r112, boolean r113, RealtimeCallParam.l r114);

    boolean m0();

    void stop(boolean r100);

    ContinuousTalkStatus u10();

    void updateIntentExt(Map<String, String> r100);

    void updateScreenshotForAsr(String r100);
}
