package com.larus.bmhome.chat.component.list;

import android.os.Bundle;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.auth.OnboardingActionCardData;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.bean.ChatMsgDeleteScene;
import com.larus.im.bean.conversation.ForkType;
import com.larus.im.bean.message.Message;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface u7 extends t1a.a {

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ void d(u7 r100) {
            r100.TP(false);
        }

        public static /* synthetic */ void a(u7 r100, boolean r101) {
            r100.vk(r101, new t7());
        }

        public static /* synthetic */ void b(u7 r100, String r101, ForkType r102, ReplyOption r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = null;
        L6:
            if ((r104 & 4) == 0) goto L8;
            r103 = null;
        L8:
            r100.Ee(r101, r102, r103, null);
        }

        public static /* synthetic */ void c(u7 r110, wc9.e r111, Message r112, String r113, by7.e r114, boolean r115, String r116, long r117, String r210, int r211) {
            if ((r211 & 16) == 0) goto L5;
            boolean r100 = false;
        L7:
            if ((r211 & 32) == 0) goto L9;
            String r101 = "";
        L11:
            if ((r211 & 128) == 0) goto L13;
            String r118 = null;
        L14:
            r110.g3(r111, r112, r113, r114, r100, r101, r117, r118);
            return;
        L13:
            r118 = r210;
            goto L14
        L9:
            r101 = r116;
            goto L11
        L5:
            r100 = r115;
            goto L7
        }
    }

    void A5(boolean r100);

    void BN();

    void Bm(Message r100, String r101);

    void C90();

    void CX(List<Message> r100);

    boolean D80();

    void E4(Message r100);

    void Ee(String r100, ForkType r101, ReplyOption r102, String r103);

    void G2();

    void HL(Message r100, String r101, Map<String, String> r102, boolean r103);

    boolean Hl();

    boolean IS();

    void J80(Message r100);

    void JE();

    StateFlowImpl Le();

    MessageAdapter MF();

    void MQ(boolean r100);

    void Mf(Message r100, Integer r101);

    long Mg();

    void O5(boolean r100);

    boolean O7(String r100);

    void OD(Message r100, Integer r101, Function1<? super Boolean, Unit> r102);

    com.larus.bmhome.chat.trace.l0 ON();

    void Os();

    void P80();

    void PI(Function0<Unit> r100);

    boolean Qf();

    void Rc();

    Pair<Boolean, OnboardingActionCardData> TM(OnboardingActionCardData.CardScene r100);

    void TP(boolean r100);

    void U1();

    void V70(List<Message> r100, String r101, JSONObject r102, ChatMsgDeleteScene r103, Function0<Unit> r104);

    boolean W1();

    void W70();

    void Y70(Message r100, Integer r101);

    void a90();

    void cE();

    int[] dZ();

    void dismissLoading();

    boolean fJ();

    void fh(Message r100, Integer r101);

    void g3(wc9.e r100, Message r101, String r102, by7.e r103, boolean r104, String r105, long r106, String r107);

    void iE(List<Message> r100, boolean r101);

    int k70();

    com.larus.bmhome.chat.trace.l0 ku();

    void kx(String r100, boolean r101);

    void l10(OnboardingActionCardData.CardScene r100, String r101, String r102);

    void lB(String r100, ic8.p0 r101);

    void lm();

    void ln(Bundle r100);

    MutableSharedFlow m30();

    void mA(te8.c r100);

    Integer n00(String r100);

    void pe(String r100, ic8.p0 r101);

    void showLoading();

    void tJ(boolean r100);

    void tU(int r100);

    void um(te8.c r100);

    void vk(boolean r100, Function1<? super Boolean, Unit> r101);

    void vv(Message r100);

    void w70();

    void wt(Message r100);

    void ye(boolean r100);

    void z();

    void z50();

    void zZ(Message r100);

    List<Message> zj();
}
