package com.larus.bmhome.chat.layout.holder.answeraction;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.LruCache;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.screenmenu.i0;
import com.larus.bmhome.view.screenmenu.j0;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.MsgRegenMode;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.skydoves.balloon.Balloon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import v19.h;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class RegenInstructionPanel {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f303495i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f303496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f303497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f303498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q0.a f303499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f303500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Balloon f303501f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompletableDeferred<Boolean> f303502g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f303503h;

    public static final class a {
    }

    static {
    }

    public final void b() {
        if (this.f303501f == null) goto L6;
        FLogger.f375446a.d("RegenInstructionPanel", "show called, balloon is not null, skip");
        return;
    L6:
        q0.a r100 = this.f303499d;
        if (r100 == null) goto L11;
        y r101 = r100.u0();
        if (r101 == null) goto L11;
        BotModel r102 = r101.j0();
    L12:
        boolean r103 = this.f303500e;
        if (r102 == null) goto L15;
        List<MsgRegenMode> r104 = r102.getMsgRegenModeList();
    L16:
        ArrayList r105 = new ArrayList();
        if (r103 == false) goto L23;
        View r106 = this.f303496a;
        if (r106 == null) goto L21;
        Context r107 = r106.getContext();
    L22:
        r105.add(new l0(R.string.larus_regenerate_button_hover_text, R.string.larus_regenerate_button_hover_text, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(R.attr.larus_ic_screen_menu_regenerate, r107, R.drawable.larus_ic_screen_menu_regenerate)), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127));
        LruCache<String, wc9.e> r108 = ko8.a.f504531a;
        Message r109 = this.f303497b;
        long r110 = this.f303498c;
        Intrinsics.checkNotNullParameter(r109, "message");
        Intrinsics.checkNotNullParameter("default", "regenInstruction");
        IAIChatControlTraceService.f365889a.Ib(r109, r110, "default");
        goto L23
    L21:
        r107 = null;
    L23:
        List<MsgRegenMode> r111 = r104;
        boolean r112 = true;
        if (r111 != null) goto L26;
    L29:
        boolean r113 = true;
    L31:
        if (r113 == false) goto L33;
        FLogger.f375446a.d("RegenInstructionPanel", "msgRegenModeList is empty, addRegen: " + r103);
    L72:
        if (r105.isEmpty() == false) goto L75;
        FLogger.f375446a.d("ActionCreator", "showRegenInstructionPanel called, buildMenuItems empty, skip");
        this.f303502g.complete(Boolean.FALSE);
        return;
    L75:
        CommonMenu r114 = new CommonMenu(this.f303496a.getContext());
        r114.h(Reflection.getOrCreateKotlinClass(i0.class), new j0());
        r114.g(r105, new RegenInstructionPanel$show$commonMenu$1(this));
        r114.f317230h = i5.H();
        Paint r115 = new Paint(1);
        r115.setTextSize(i5.q());
        r115.setTypeface(Typeface.create("sans-serif-medium", 0));
        if (r105.isEmpty() == true) goto L114;
        Iterator r116 = r105.iterator();
    L80:
        if (r116.hasNext() == false) goto L114;
        ot8.a r117 = (ot8.a) r116.next();
        if ((r117 instanceof l0) == false) goto L111;
        l0 r118 = (l0) r117;
        String r119 = r118.f317322c;
        if (r119 != null) goto L86;
    L89:
        boolean r120 = true;
    L90:
        if (r120 == true) goto L95;
        String r121 = r118.f317322c;
        if (r121 != null) goto L99;
    L97:
        r121 = "";
    L99:
        if (r118.f317332m == null) goto L101;
    L104:
        boolean r122 = true;
    L105:
        if (r122 == false) goto L107;
        int r123 = i5.A() + i5.h();
    L109:
        if (((((r118.f317334o + i5.A()) + r123) + i5.C()) + ((int) Math.ceil(r115.measureText(r121)))) <= i5.F()) goto L111;
        boolean r124 = true;
    L112:
        if (r124 == false) goto L80;
    L115:
        if (r112 == false) goto L117;
        r114.d(i5.F());
    L120:
        View r125 = r114.i();
        Balloon r126 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.f317270a, this.f303496a, r125, false, null, new c(), null, new d(this), 44);
        this.f303501f = r126;
        r125.measure(0, 0);
        int r127 = ((this.f303496a.getWidth() / 2) + r125.getPaddingEnd()) - (r125.getMeasuredWidth() / 2);
        int r128 = r125.getPaddingBottom() - i5.g();
        FLogger.f375446a.d("ActionCreator", "xOff: " + r127 + ", yOff: " + r128 + ", menuView.measuredWidth: " + r125.getMeasuredWidth() + ", menuView.measuredHeight: " + r125.getMeasuredHeight() + ", menuView.paddingEnd: " + r125.getPaddingEnd() + ", menuView.paddingBottom: " + r125.getPaddingBottom());
        r126.v(this.f303496a, r127, r128);
        return;
    L117:
        ViewGroup.LayoutParams r129 = r114.getLayoutParams();
        if (r129.width == (-2)) goto L120;
        r129.width = -2;
        r114.setLayoutParams(r129);
        goto L120
    L107:
        r123 = 0;
        goto L109
    L101:
        if (o0.d(r118.f317333n) == true) goto L104;
        r122 = false;
        goto L105
    L95:
        if (r118.f317321b == 0) goto L97;
        r121 = this.f303496a.getContext().getText(r118.f317321b).toString();
        goto L99
    L86:
        if (r119.length() == 0) goto L89;
        r120 = false;
    L111:
        r124 = false;
    L114:
        r112 = false;
        goto L115
    L33:
        ArrayList r130 = new ArrayList();
        Iterator<T> r131 = r104.iterator();
    L35:
        if (r131.hasNext() == false) goto L48;
        Object r132 = r131.next();
        Integer r133 = ((MsgRegenMode) r132).getRegenType();
        int r134 = RegenInstructionEnum.REGEN_DEEP_THINK.getType();
        if (r133 != null) goto L40;
    L45:
        boolean r135 = true;
    L46:
        if (r135 == false) goto L35;
        r130.add(r132);
        goto L35
    L40:
        if (r133.intValue() != r134) goto L45;
        if (com.larus.im.bean.message.a.C0(this.f303497b) == false) goto L45;
        r135 = false;
        goto L46
    L48:
        Iterator r136 = r130.iterator();
    L50:
        if (r136.hasNext() == false) goto L72;
        MsgRegenMode r137 = (MsgRegenMode) r136.next();
        boolean r138 = h.f552477a;
        if (h.a(null) == false) goto L54;
        String r139 = r137.getRegenDarkIcon();
    L55:
        String r610 = r139;
        if (o0.d(r137.getRegenText()) == true) goto L58;
    L67:
        l0 r140 = null;
    L68:
        if (r140 != null) goto L69;
        FLogger.f375446a.d("RegenInstructionPanel", "createMenuItem failed, msgRegenMode: " + r137);
        goto L50
    L69:
        r105.add(r140);
        goto L50
    L58:
        if (o0.d(r610) == false) goto L67;
        LruCache<String, wc9.e> r141 = ko8.a.f504531a;
        Message r142 = this.f303497b;
        long r143 = this.f303498c;
        String r144 = r137.getRegenInstruction();
        if (r144 != null) goto L62;
        r144 = "";
    L62:
        Intrinsics.checkNotNullParameter(r142, "message");
        Intrinsics.checkNotNullParameter(r144, "regenInstruction");
        IAIChatControlTraceService.f365889a.Ib(r142, r143, r144);
        String r510 = r137.getRegenText();
        View r145 = this.f303496a;
        if (r145 == null) goto L65;
        Context r146 = r145.getContext();
    L66:
        r140 = new l0(R.id.msg_action_regen_instruct, 0, r510, null, null, null, null, null, null, false, false, r137, Integer.valueOf(v19.c.b(R.attr.larus_ic_regen_instruction_prefix, r146, R.drawable.larus_ic_regen_instruction_prefix)), r610, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -14342, 127);
        goto L68
    L65:
        r146 = null;
        goto L66
    L54:
        r139 = r137.getRegenLightIcon();
        goto L55
    L26:
        if (r111.isEmpty() == true) goto L29;
        r113 = false;
        goto L31
    L15:
        r104 = null;
    L11:
        r102 = null;
        goto L12
    }

    public final Object a(Continuation<? super e> r100) {
        if ((r100 instanceof RegenInstructionPanel$getResult$1) == false) goto L7;
        RegenInstructionPanel$getResult$1 r101 = (RegenInstructionPanel$getResult$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L18:
        if (((Boolean) r103).booleanValue() == true) goto L20;
        return null;
    L20:
        return this.f303503h;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        CompletableDeferred<Boolean> r106 = this.f303502g;
        r101.label = 1;
        r103 = r106.await(r101);
        if (r103 != r104) goto L18;
        return r104;
    L7:
        r101 = new RegenInstructionPanel$getResult$1(this, r100);
        goto L8
    }

    public RegenInstructionPanel(View r100, Message r101, long r102, q0.a r103) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        Intrinsics.checkNotNullParameter(r101, "answer");
        this.f303496a = r100;
        this.f303497b = r101;
        this.f303498c = r102;
        this.f303499d = r103;
        this.f303500e = true;
        this.f303502g = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }
}
