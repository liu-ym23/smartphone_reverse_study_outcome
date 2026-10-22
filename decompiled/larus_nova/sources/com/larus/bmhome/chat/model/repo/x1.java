package com.larus.bmhome.chat.model.repo;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.tts.ITtsReaderFactory;
import com.larus.tts.TtsScene;
import com.larus.tts.impl.TtsReader;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f307866a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f307867a = null;

        static {
            f307867a = new a();
        }

        public a() {
        }

        public static x1 a() {
            ITtsReaderFactory r100 = (ITtsReaderFactory) ServiceManager.get().getService(ITtsReaderFactory.class);
            if (r100 == null) goto L7;
            TtsReader r101 = r100.a();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return new c2();
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class b {
        public static /* synthetic */ Object b(x1 r110, Message r111, SpeakerVoice r112, boolean r113, String r114, String r115, TtsScene r116, Continuation r117, int r118) {
            if ((r118 & 2) == 0) goto L5;
            SpeakerVoice r100 = null;
        L7:
            if ((r118 & 4) == 0) goto L9;
            boolean r101 = false;
        L11:
            if ((r118 & 8) == 0) goto L13;
            String r102 = null;
        L15:
            if ((r118 & 32) == 0) goto L17;
            String r103 = null;
        L19:
            if ((r118 & 64) == 0) goto L21;
            TtsScene r104 = null;
        L23:
            return r110.j6(r111, r100, r101, r102, null, r103, r104, r117);
        L21:
            r104 = r116;
            goto L23
        L17:
            r103 = r115;
            goto L19
        L13:
            r102 = r114;
            goto L15
        L9:
            r101 = r113;
            goto L11
        L5:
            r100 = r112;
            goto L7
        }

        public static /* synthetic */ Object a(x1 r110, Message r111, String r112, String r113, String r114, boolean r115, JSONObject r210, TtsScene r211, String r212, Continuation r213, int r214) {
            if ((r214 & 8) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r214 & 16) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r214 & 32) == 0) goto L13;
            boolean r102 = false;
        L15:
            if ((r214 & 64) == 0) goto L17;
            JSONObject r116 = null;
        L19:
            if ((r214 & 128) == 0) goto L21;
            TtsScene r117 = null;
        L23:
            if ((r214 & 256) == 0) goto L25;
            String r118 = null;
        L27:
            return r110.m6(r111, r112, r113, r100, r101, r102, r116, r117, r118, r213);
        L25:
            r118 = r212;
            goto L27
        L21:
            r117 = r211;
            goto L23
        L17:
            r116 = r210;
            goto L19
        L13:
            r102 = r115;
            goto L15
        L9:
            r101 = r114;
            goto L11
        L5:
            r100 = "long_press_play";
            goto L7
        }
    }

    static {
        f307866a = a.f307867a;
    }

    void i6(String r100, boolean r101);

    Object j6(Message r100, SpeakerVoice r101, boolean r102, String r103, CoroutineScope r104, String r105, TtsScene r106, Continuation<? super Unit> r107);

    void k6(String r100, Map r101, Function0 r102, Function1 r103);

    void l6();

    Object m6(Message r100, String r101, String r102, String r103, String r104, boolean r105, JSONObject r106, TtsScene r107, String r108, Continuation<? super Unit> r110);

    boolean n6();

    String o6();

    void p6(Message r100, String r101, CoroutineScope r102, TtsScene r103);

    String q6();

    void r6(String r100);
}
