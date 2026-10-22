package p2a;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.tts.impl.ChatTitleTtsComponent;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public interface f extends pd6.a {

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a {
        public static /* synthetic */ void a() {
            i.f527471b.b2("");
        }
    }

    List<SpeakerVoice> D1();

    Object F1(w2a.f r100, String r101, Continuation<? super SpeakerVoice> r102);

    void N(ChatTitleTtsComponent.f r100);

    void O(ChatTitleTtsComponent.f r100);

    void R(String r100, String r101);

    void Z();

    void b2(String r100);

    void d1(k r100, boolean r101);

    Object y2(w2a.f r100, String r101, String r102, String r103, Continuation<? super m<SpeakerVoice>> r104);
}
