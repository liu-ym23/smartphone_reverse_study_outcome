package com.larus.bmhome.instruction;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.bmhome.view.actionbar.custom.CustomActionBar;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Image;
import com.obric.assistant.component.o6;
import com.obric.assistant.component.p6;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public interface g extends m1a.a {

    public static final class a {
        public static /* synthetic */ com.larus.bmhome.actionbar.model.z0 d(g r100, ActiveSwitchType r101) {
            return r100.un(r101, null);
        }

        public static /* synthetic */ com.larus.bmhome.actionbar.model.z0 c(g r100, ActiveSwitchType r101, String r102) {
            return r100.wc(r101, r102, "");
        }

        public static /* synthetic */ void b(g r100, com.larus.bmhome.actionbar.model.z0 r101, ReplyOption r102, boolean r103, int r104) {
            if ((r104 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = null;
        L9:
            if ((r104 & 4) == 0) goto L11;
            r103 = true;
        L11:
            r100.QW(r101, r102, r103);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(g r100, List r101, Function1 r102, o6 r103, p6 r110, int r111) {
            if ((r111 & 4) == 0) goto L5;
            Function1 r104 = null;
        L7:
            if ((r111 & 8) == 0) goto L9;
            o6 r105 = null;
        L11:
            if ((r111 & 16) == 0) goto L13;
            p6 r106 = null;
        L14:
            r100.Td(r101, null, r104, r105, r106);
            return;
        L13:
            r106 = r110;
            goto L14
        L9:
            r105 = r103;
            goto L11
        L5:
            r104 = r102;
            goto L7
        }

        public static /* synthetic */ void e(g r100, String r101, Integer r102, aq8.e r103, int r104, int r105) {
            if ((r105 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = null;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = null;
        L12:
            if ((r105 & 8) == 0) goto L14;
            r104 = 0;
        L14:
            r100.Iu(r101, r102, r103, r104);
        }
    }

    void A1();

    Pair<com.larus.bmhome.actionbar.model.z0, Boolean> A7();

    void A8(String r100);

    boolean Aq();

    void BP();

    boolean Ch();

    void EF(Function1<? super up8.b, Unit> r100);

    Pair<Boolean, Boolean> F7();

    void FC(com.larus.bmhome.chat.model.b0 r100);

    void FP();

    ReplyOption Fe(com.larus.bmhome.actionbar.model.z0 r100);

    void GR();

    boolean HM();

    ReplyOption IT(ModelItemIdentity r100);

    void Iu(String r100, Integer r101, aq8.e r102, int r103);

    @Deprecated(message = "do not use, use your segment by refresh")
    void K90();

    String KU();

    void LB(rs8.f r100);

    void LW();

    void Lg(com.larus.bmhome.chat.model.j1 r100, boolean r101);

    String M10();

    int M4();

    void M80(ReplyOption r100, boolean r101);

    kotlinx.coroutines.flow.d1<Integer> Mp();

    Pair<com.larus.bmhome.actionbar.model.z0, Boolean> N8();

    void NZ();

    void Nb(Bundle r100);

    void Ot();

    boolean P0();

    void PL(Map<String, String> r100);

    void Ps(Bundle r100);

    int Q1();

    void QW(com.larus.bmhome.actionbar.model.z0 r100, ReplyOption r101, boolean r102);

    void QX(rs8.f r100);

    String Qh(String r100);

    ReplyOption Ql();

    void S7();

    void SF();

    void SJ(String r100);

    void ST();

    void SU(boolean r100);

    void T1();

    void T40(boolean r100);

    void Td(List<? extends ss8.e> r100, String r101, Function1<? super com.larus.bmhome.actionbar.model.z0, Boolean> r102, Function0<BotModel> r103, Function0<wc9.e> r104);

    boolean Ty();

    boolean Uc();

    String Un();

    void VQ(String r100);

    void Vm(boolean r100, String r101);

    ReplyOption WK(String r100);

    boolean Wa();

    o Wp();

    int X1();

    boolean Xl();

    MutableLiveData Zb();

    int bd();

    String c0();

    void c6();

    void cO();

    void ck();

    boolean eB();

    void fN(View r100);

    boolean fu();

    void fz(ReplyOption r100);

    String gm();

    boolean i3();

    void ip(boolean r100);

    void j90(com.larus.bmhome.actionbar.model.z0 r100);

    Pair<com.larus.bmhome.actionbar.model.z0, Boolean> jo();

    boolean jt();

    ViewGroup jy();

    boolean k20();

    boolean k5();

    String kb(String r100);

    void ls();

    AttachmentInfo n4();

    void nB(String r100);

    Map<String, String> nK(String r100);

    void oP(View r100);

    boolean of(com.larus.audio.asr.c0 r100);

    void onInputHintChanged(String r100, String r101);

    void p00();

    boolean qf(com.larus.bmhome.actionbar.model.r r100, String r101, String r102, List<com.larus.bmhome.actionbar.model.z0> r103, Image r104);

    boolean rA();

    void requestFocus();

    boolean rm();

    List<com.larus.bmhome.actionbar.model.z0> tq();

    LiveData<List<com.larus.bmhome.actionbar.model.z0>> uE();

    com.larus.bmhome.actionbar.model.z0 un(ActiveSwitchType r100, String r101);

    boolean vO(Integer r100);

    void vW(boolean r100);

    boolean vX();

    CustomActionBar.d vp();

    boolean w4();

    com.larus.bmhome.actionbar.model.z0 wc(ActiveSwitchType r100, String r101, String r102);

    boolean x(String r100);

    void xy();

    void y20(Function0<Unit> r100);

    com.larus.bmhome.actionbar.model.z0 yF();

    boolean yW();

    boolean z0();

    MutableLiveData zU();
}
