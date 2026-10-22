package va8;

import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.outerinput.OuterInputEventBus;
import com.larus.bmhome.view.ChatInputReply;
import com.zhpan.bannerview.indicator.DrawableIndicator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes4.dex */
public interface o extends m1a.a {

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ void a(o r100, boolean r101) {
            r100.CJ(r101, null, false);
        }
    }

    void AK(int r100, int r101, int r102, int r103);

    void AZ(int r100);

    void B90(int r100);

    void C40(int r100);

    void CE(Function0<Unit> r100);

    void CF(com.larus.bmhome.chat.component.receive.r r100);

    void CJ(boolean r100, MotionEvent r101, boolean r102);

    void Ca(ConstraintLayout r100, int r101);

    void D60(boolean r100);

    void E40();

    void F40(int r100);

    void FD(Boolean r100);

    void Fn(Integer r100);

    void G60(int r100);

    void GE();

    void GM(Function1<? super Boolean, Unit> r100);

    void HH(String r100);

    void JP(Boolean r100);

    void Jv();

    void L70(boolean r100);

    void N4();

    void RQ();

    void S6(String r100);

    void SA(int r100);

    void SB(boolean r100);

    boolean TV(jd8.l r100, int r101);

    void U70(float r100, int r101);

    void Ug(CharSequence r100);

    com.larus.bmhome.chat.component.bottom.core.a Uv();

    void Vc();

    void Ww(ChatInputReply r100);

    void XW(boolean r100);

    void Y4(float r100);

    void Yv();

    boolean ZI(com.larus.bmhome.chat.component.bottom.attachment.j0 r100);

    boolean ZL();

    void ZV(CharSequence r100, Integer r101, Integer r102);

    boolean a8();

    void c3();

    void c70(int r100);

    i1<Integer> cv();

    void d90(boolean r100, boolean r101);

    void e10(boolean r100);

    int e60();

    void fq(int r100);

    CharSequence getHint();

    Integer hH();

    boolean hh();

    void i00();

    void i1(Function0<Boolean> r100);

    void k3(boolean r100);

    void l70(Drawable r100, int r101);

    void lj();

    void m1(ViewGroup r100);

    boolean n5();

    void nX();

    void oD(InputFilter[] r100);

    void oR(Function1<? super Boolean, Unit> r100);

    void p9(int r100);

    void qG(boolean r100);

    void qs(Object r100);

    b rX();

    void ra();

    void requestDisallowInterceptTouchEvent(boolean r100);

    void setVisibility(int r100);

    void t50(DrawableIndicator r100, int r101);

    void u60(boolean r100);

    String u7();

    void ur(Integer r100, String r101, String r102, OuterInputEventBus.OuterInputEvent r103);

    void v3(int r100);

    void vI(boolean r100);

    boolean w();

    boolean xM();

    boolean xO(MotionEvent r100);
}
