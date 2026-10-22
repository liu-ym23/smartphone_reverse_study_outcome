package com.larus.asr;

import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.larus.asr.direct.IAsrDirectFillAbility;
import com.larus.asr.handsfree.HandsfreeDirectEntry;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class r5 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f287422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f287423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TouchSpeakerComponent f287424c;

    public r5(TouchSpeakerComponent r100) {
        this.f287424c = r100;
        this.f287423b = "";
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r110, MotionEvent r111) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        TouchSpeakerComponent r100 = this.f287424c;
        int r101 = TouchSpeakerComponent.E;
        boolean r102 = false;
        if (r100.z3().speakerTouchEnable() == true) goto L11;
        if (r111 != null) goto L6;
    L8:
        if (r102 == false) goto L10;
        this.f287424c.C3(R.string.larus_memo_recording_deny_actions_error_toast, true);
    L10:
        return true;
    L6:
        if (r111.getActionMasked() != 0) goto L8;
        r102 = true;
        goto L8
    L11:
        if (r111 != null) goto L13;
        return true;
    L13:
        int r103 = r111.getActionMasked();
        Pair<Float, Float> r104 = TouchSpeakerComponent.N2(this.f287424c, r110, r111);
        Pair r105 = TouchSpeakerComponent.L2(this.f287424c, r110);
        if (r103 != 0) goto L16;
        this.f287423b = UUID.randomUUID().toString();
    L16:
        Boolean r106 = null;
        if (r103 != 2) goto L22;
        int r112 = this.f287422a + 1;
        this.f287422a = r112;
        if (r112 != 1) goto L26;
        f2a.c r113 = this.f287424c.f287151w.b("Touch EVENT: ACTION_MOVE, MOVE START");
        LinkedHashMap r114 = new LinkedHashMap();
        r114.put(new f2a.f("global_touch_action_x"), String.valueOf(r104.getFirst().floatValue()));
        r114.put(new f2a.f("global_touch_action_y"), String.valueOf(r104.getSecond().floatValue()));
        r113.d(r114);
        r113.f475230c.f475256d = "buildTouchListenerOnPressActionSpeak.onTouch";
        List<String> r107 = CollectionsKt.listOf(this.f287423b);
        f2a.g r108 = r113.f475230c;
        r108.f475254b = r107;
        r108.f475257e = "PressActionSpeak";
        f2a.c.c(r113, null, 15);
    L26:
        if (r103 != 0) goto L28;
        maa.f r109 = (maa.f) this.f287424c.f287145q.getValue();
        if (r109 == null) goto L94;
        r109.ga(r104);
    L94:
        f2a.c r115 = this.f287424c.f287151w.b("Touch EVENT: ACTION_DOWN");
        f2a.g r116 = r115.f475230c;
        r116.f475257e = "PressActionSpeak";
        r116.f475256d = "buildTouchListenerOnPressActionSpeak.onTouch";
        r115.f475230c.f475254b = CollectionsKt.listOf(this.f287423b);
        f2a.c.c(r115, null, 15);
        TouchSpeakerComponent.U2(this.f287424c);
        x5.d().a(true);
        va8.o r117 = this.f287424c.Y2();
        if (r117 == null) goto L97;
        r117.requestDisallowInterceptTouchEvent(true);
    L97:
        Message r118 = this.f287424c.p3().obtainMessage(10001);
        r118.getData().putBoolean("from_text_area", true);
        r118.getData().putString("asr_input_trace_id", this.f287423b);
        r118.getData().putString("asr_input_enter_from", "PressActionSpeak");
        this.f287424c.p3().sendMessageDelayed(r118, this.f287424c.z3().longPressTimeout());
        return true;
    L28:
        if (r103 != 1) goto L30;
    L40:
        maa.f r119 = (maa.f) this.f287424c.f287145q.getValue();
        if (r119 == null) goto L43;
        r119.ga(null);
    L43:
        x5.d().a(false);
        boolean r120 = this.f287424c.p3().hasMessages(10001);
        f2a.c r121 = this.f287424c.f287151w.b("Touch EVENT: ACTION_UP or ACTION_CANCEL");
        LinkedHashMap r122 = new LinkedHashMap();
        f2a.f r123 = new f2a.f("touch_event");
        if (r103 != 1) goto L46;
        String r124 = "ACTION_UP";
    L47:
        r122.put(r123, r124);
        r122.put(new f2a.f("has_on_speak_msg"), String.valueOf(r120));
        r121.d(r122);
        f2a.g r125 = r121.f475230c;
        r125.f475257e = "PressActionSpeak";
        r125.f475256d = "buildTouchListenerOnPressActionSpeak.onTouch";
        r121.f475230c.f475254b = CollectionsKt.listOf(this.f287423b);
        f2a.c.c(r121, null, 15);
        if (r120 == false) goto L81;
        this.f287424c.p3().removeMessages(10001);
        if (r103 != 1) goto L52;
    L54:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r126 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.f287424c.f287141m.getValue();
        if (r126 == null) goto L59;
        boolean r127 = true;
        if (r126.dz(HandsfreeDirectEntry.MIC_ICON_CLICK, this.f287423b, "PressActionSpeak") != true) goto L61;
        r102 = true;
    L61:
        if (r102 == false) goto L64;
        f58.a.a("click");
        return r127;
    L64:
        ICoreInputAbility r128 = this.f287424c.h3();
        if (r128 == null) goto L70;
        long r129 = de8.d.a((de8.c) this.f287424c.f287144p.getValue());
        va8.o r130 = this.f287424c.Y2();
        if (r130 == null) goto L69;
        r106 = Boolean.valueOf(r130.w());
    L69:
        r128.Wy("audio", r129, r106);
    L70:
        ICoreInputAbility r131 = this.f287424c.h3();
        if (r131 == null) goto L73;
        r131.g2(2, true);
    L73:
        va8.o r132 = this.f287424c.Y2();
        if (r132 == null) goto L76;
        r132.ra();
    L76:
        ICoreInputAbility r133 = this.f287424c.h3();
        if (r133 == null) goto L79;
        r133.qp(true);
    L79:
        f58.a.a("click");
        return true;
    L59:
        r127 = true;
        goto L61
    L52:
        if (this.f287424c.nt() == false) goto L54;
        return true;
    L81:
        if (r103 != 1) goto L85;
        IAsrDirectFillAbility r134 = this.f287424c.m3();
        if (r134 == null) goto L88;
        r134.S60();
    L88:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r135 = TouchSpeakerComponent.P2(this.f287424c);
        if (r135 == null) goto L103;
        r135.pv(-1, r104.getFirst().floatValue(), r104.getSecond().floatValue(), ((Number) r105.getFirst()).floatValue(), ((Number) r105.getSecond()).floatValue());
        return true;
    L103:
        return true;
    L85:
        IAsrDirectFillAbility r136 = this.f287424c.m3();
        if (r136 == null) goto L88;
        r136.cancel();
        goto L88
    L46:
        r124 = "ACTION_CANCEL";
        goto L47
    L30:
        if (r103 != 2) goto L32;
        maa.f r137 = (maa.f) this.f287424c.f287145q.getValue();
        if (r137 == null) goto L37;
        r137.ga(r104);
    L37:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r138 = TouchSpeakerComponent.P2(this.f287424c);
        if (r138 == null) goto L100;
        r138.pv(0, r104.getFirst().floatValue(), r104.getSecond().floatValue(), ((Number) r105.getFirst()).floatValue(), ((Number) r105.getSecond()).floatValue());
        return true;
    L100:
        return true;
    L32:
        if (r103 == 3) goto L40;
        return true;
    L22:
        if (this.f287422a <= 0) goto L24;
        f2a.c r139 = this.f287424c.f287151w.b("Touch EVENT: touchMoveCount > 0, MOVE END");
        r139.f475230c.f475257e = "PressActionSpeak";
        LinkedHashMap r140 = new LinkedHashMap();
        r140.put(new f2a.f("action_masked"), String.valueOf(r103));
        r140.put(new f2a.f("touch_move_count"), String.valueOf(this.f287422a));
        r140.put(new f2a.f("global_touch_action_x"), String.valueOf(r104.getFirst().floatValue()));
        r140.put(new f2a.f("global_touch_action_y"), String.valueOf(r104.getSecond().floatValue()));
        r139.d(r140);
        r139.f475230c.f475256d = "buildTouchListenerOnPressActionSpeak.onTouch";
        r139.f475230c.f475254b = CollectionsKt.listOf(this.f287423b);
        f2a.c.c(r139, null, 15);
        this.f287422a = 0;
        goto L26
    L24:
        f2a.c r141 = this.f287424c.f287151w.b("Touch EVENT: touchMoveCount <= 0");
        r141.f475230c.f475257e = "PressActionSpeak";
        LinkedHashMap r142 = new LinkedHashMap();
        r142.put(new f2a.f("action_masked"), String.valueOf(r103));
        r142.put(new f2a.f("touch_move_count"), String.valueOf(this.f287422a));
        r142.put(new f2a.f("global_touch_action_x"), String.valueOf(r104.getFirst().floatValue()));
        r142.put(new f2a.f("global_touch_action_y"), String.valueOf(r104.getSecond().floatValue()));
        r141.d(r142);
        r141.f475230c.f475256d = "buildTouchListenerOnPressActionSpeak.onTouch";
        r141.f475230c.f475254b = CollectionsKt.listOf(this.f287423b);
        f2a.c.c(r141, null, 15);
        goto L26
    }
}
