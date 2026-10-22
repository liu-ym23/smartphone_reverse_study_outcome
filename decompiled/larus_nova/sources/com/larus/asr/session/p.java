package com.larus.asr.session;

import android.content.Context;
import com.larus.asr.BottomViewModelSpeakerViewModel;
import com.larus.asr.VoiceInputType;
import com.larus.asr.handsfree.AsrInputMode;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public interface p {
    AsrInputMode B5();

    void Bb(Function2<? super Boolean, ? super Boolean, Unit> r100);

    boolean Cb();

    List<String> E9();

    long Ea();

    Object F9();

    void Fa();

    ReferenceInfo G9();

    void Ga(Message r100);

    void Gb(String r100);

    boolean I9();

    void J9(String r100, boolean r101);

    void Ja(String r100, Message r101);

    String Jb(String r100);

    boolean Kb(VoiceInputType r100);

    List<String> L0();

    void L8(boolean r100, boolean r101, String r102, VoiceInputType r103, String r104);

    ChatPageContext M1();

    void Ma(String r100, byte[] r101);

    void O9(String r100);

    void Q9(Map<String, String> r100);

    String Qa();

    void R9(String r100);

    boolean Ra();

    boolean Sa();

    boolean Ua(String r100);

    void V9(String r100);

    void W9(VoiceInputType r100);

    AttachmentInfo X9();

    JSONArray Xa();

    void ca(String r100);

    Map<String, String> eb(String r100, Message r101, ReferenceInfo r102, Object r103, Map<String, String> r104);

    BottomViewModelSpeakerViewModel f();

    Context getSessionContext();

    wc9.e h();

    void ha(String r100);

    BotModel i();

    void ib(String r100, Map<String, String> r101, VoiceInputType r102);

    boolean m2(String r100);

    void m8();

    String nb();

    boolean ob();

    void onAsrStart(String r100);

    Map<String, String> qa();

    void sa(Message r100, String r101, VoiceInputType r102);

    void sb(String r100);

    void setKeepScreenOn(boolean r100);

    boolean ta();

    String ua();

    String ub(String r100);

    void vb();

    boolean xa();

    boolean ya();
}
