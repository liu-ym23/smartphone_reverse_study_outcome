package c58;

import android.os.Handler;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.larus.asr.direct.AsrDirectFillComponent;
import com.larus.asr.direct.IAsrDirectFillAbility$DirectFillStatus;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.speaker.e;
import com.larus.common_ui.view.TouchInterceptingView;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t19.s;
import va8.l;
import va8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ AsrDirectFillComponent a;

    public /* synthetic */ c(AsrDirectFillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r13) {
        AsrDirectFillComponent r0 = this.a;
        e.c.f r14 = (e.c) r13;
        int r1 = AsrDirectFillComponent.A;
        Intrinsics.checkNotNullParameter(r14, "event");
        if ((r14 instanceof e.c.c) == true) goto L72;
        if ((r14 instanceof e.c.e) == true) goto L72;
        if ((r14 instanceof e.c.f) == false) goto L11;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("StreamResult text='");
        e.c.f r15 = r14;
        r3.append(r15.a);
        r3.append("' len=");
        r3.append(r15.a.length());
        r2.i("AsrDirectFillComponent", r3.toString());
        ICoreInputAbility r4 = r0.P2();
        if (r4 == null) goto L72;
        ICoreInputAbility.b.d(r4, r15.a, false, false, null, null, false, 62);
        goto L72
    L11:
        String r5 = null;
        if ((r14 instanceof e.c.g) == false) goto L34;
        m r6 = r0.N2();
        if (r6 == null) goto L20;
        l r7 = r6.iX();
        if (r7 == null) goto L20;
        FrameLayout r8 = r7.getInput();
        if (r8 == null) goto L20;
        EditText r9 = (EditText) r8.findViewById(2131375415);
    L21:
        r0.T70(r9);
        TouchInterceptingView r10 = r0.t;
        if (r10 == null) goto L24;
        e1.o(r10);
    L24:
        ICoreInputAbility r11 = r0.P2();
        if (r11 == null) goto L27;
        r11.aR(((e.c.g) r14).a);
    L27:
        String r16 = ((e.c.g) r14).c;
        if (r16 != null) goto L30;
    L32:
        r0.v = r5;
        FLogger.a.i("AsrDirectFillComponent", "[SpeakerPressLifecycle]: receive Success event, change status to FillBackClickSend");
        r0.Y2(IAsrDirectFillAbility$DirectFillStatus.FillBackClickSend);
        goto L72
    L30:
        if ((!StringsKt.isBlank(r16)) == false) goto L32;
        r5 = r16;
    L20:
        r9 = null;
        goto L21
    L34:
        if ((r14 instanceof e.c.b) == false) goto L36;
    L52:
        m r17 = r0.N2();
        if (r17 == null) goto L59;
        l r19 = r17.iX();
        if (r19 == null) goto L59;
        FrameLayout r110 = r19.getInput();
        if (r110 == null) goto L59;
        EditText r111 = (EditText) r110.findViewById(2131375415);
    L60:
        r0.T70(r111);
        TouchInterceptingView r112 = r0.t;
        if (r112 == null) goto L63;
        e1.o(r112);
    L63:
        r0.F2("failed_or_canceled");
        r0.Y2(null);
        ICoreInputAbility r113 = r0.P2();
        if (r113 == null) goto L67;
        r113.p80(true);
    L67:
        if (r0.s == false) goto L72;
        r0.s = false;
        ICoreInputAbility r114 = r0.P2();
        if (r114 == null) goto L72;
        r114.g2(2, true);
    L59:
        r111 = null;
        goto L60
    L36:
        if ((r14 instanceof e.c.a) == true) goto L52;
        if ((r14 instanceof e.c.d) == false) goto L48;
        ICoreInputAbility r115 = r0.P2();
        if (r115 == null) goto L43;
        r115.g2(1, true);
    L43:
        TouchInterceptingView r116 = r0.t;
        if (r116 == null) goto L46;
        e1.x(r116);
    L46:
        ((Handler) r0.o.getValue()).postDelayed(r0.p, 500);
        goto L72
    L48:
        if ((r14 instanceof e.c.h) == false) goto L51;
        s.a.g(r0.getContext(), 2131899524, false);
        goto L72
    L51:
        throw new NoWhenBranchMatchedException();
    L72:
        return Unit.INSTANCE;
    }
}
