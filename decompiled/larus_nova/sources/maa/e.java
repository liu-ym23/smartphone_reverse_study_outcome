package maa;

import com.larus.im.bean.message.Message;
import com.obric.assistant.ability.audio.ExitClickSpeakerType;
import com.obric.assistant.util.g2;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public interface e extends m1a.a {

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a {
        public static /* synthetic */ void b(e r100, int r101, Integer r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = 0;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = null;
        L8:
            r100.nO(r101, null, r102);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(e r100, ExitClickSpeakerType r101, Map r102, boolean r103, int r104) {
            if ((r104 & 1) == 0) goto L6;
            r101 = ExitClickSpeakerType.MANUAL;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = null;
        L9:
            if ((r104 & 4) == 0) goto L11;
            r103 = true;
        L11:
            r100.e70(r101, r102, r103);
        }
    }

    boolean Ds();

    String Js(String r100, String r101, boolean r102, String r103, String r104);

    void KW(String r100, String r101, String r102, String r103, int r104);

    boolean L4();

    void TE(boolean r100, String r101, Function1<? super String, Unit> r102);

    void Te();

    void XB(g2 r100);

    void e70(ExitClickSpeakerType r100, Map<String, Object> r101, boolean r102);

    void ea(float r100);

    boolean gn();

    void nN(c r100);

    void nO(int r100, Map<String, Object> r101, Integer r102);

    int nZ();

    void oG(Message r100);

    Object rP(String r100, String r101, Map<String, String> r102, boolean r103, Continuation<? super maa.a> r104);

    void setAudioData(byte[] r100);

    void updateScreenshotForAsr(String r100);

    void v50(String r100);

    boolean x3();
}
