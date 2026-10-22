package com.bytedance.android.livesdk.ktvimpl.base.util;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.message.model.LinkMicBigEventMessage;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import fd2.x;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements vlc.l {
    public final vlc.d a;
    public final NextLiveData<Boolean> b;
    public final NextLiveData<Boolean> c;
    public final NextLiveData<String> d;
    public final NextLiveData e;
    public final NextLiveData f;
    public final boolean g;

    public static final class a {
    }

    static {
    }

    public h(DataCenter r5) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        vlc.d r6 = (vlc.d) r5.get("data_message_manager", null);
        this.a = r6;
        this.b = new NextLiveData();
        NextLiveData<Boolean> r0 = new NextLiveData();
        this.c = r0;
        NextLiveData<String> r2 = new NextLiveData();
        this.d = r2;
        this.e = r0;
        this.f = r2;
        this.g = ((Boolean) vm2.h.Y0.getValue(null, vm2.h.a[101(0x65, float:1.42E-43)])).booleanValue();
        if (r6 == null) goto L6;
        r6.addMessageListener(MessageType.LINK_MIC_BIG_EVENT.getIntType(), this);
        return;
    }

    public final void onMessage(tlc.d r18) {
        if (this.g == true) goto L5;
        return;
    L5:
        StringBuilder r1 = new StringBuilder("on LinkMicBigEventMessage, type:");
        tlc.d r2 = r18;
        boolean r3 = r2 instanceof LinkMicBigEventMessage;
        Integer r4 = null;
        String r5 = null;
        Integer r6 = null;
        if (r3 == true) goto L8;
        tlc.d r7 = null;
    L9:
        LinkMicBigEventMessage r8 = (LinkMicBigEventMessage) r7;
        if (r8 == null) goto L12;
        Integer r9 = Integer.valueOf(r8.msgType);
    L13:
        r1.append(r9);
        String r10 = r1.toString();
        ALogger.i(bb0.b.b(), r10 + ", invoke class :" + h.class.getSimpleName());
        if (r3 == true) goto L16;
        r2 = null;
    L16:
        LinkMicBigEventMessage r11 = (LinkMicBigEventMessage) r2;
        if (r11 == null) goto L85;
        int r12 = r11.msgType;
        boolean r13 = false;
        if (r12 != 5) goto L21;
        LinkMicBigEventMessage.SwitchKtvModeContent r14 = r11.switch_ktv_mode_content;
        if (r14 == null) goto L67;
        int r15 = r14.ktv_mode;
    L69:
        if (r15 != LinkMicBigEventMessage.KtvMode.KTVMODE_VIDEOKTV.getValue()) goto L71;
        boolean r16 = true;
    L72:
        boolean r17 = jc0.a.c();
        IKtvService r19 = jc1.k.n(IKtvService.class);
        if (r16 == false) goto L75;
        Boolean r110 = Boolean.TRUE;
        x r20 = new x(1, r110, "ktv_big_event", null, r110, "ktv_big_event", null, null, 200);
    L79:
        r19.sendKtvComponentV2Command(r20);
        if (r16 == false) goto L82;
        String r21 = "VIDEOKTV";
    L83:
        ALogger.i("KtvBigEventHelper", "Switch KTV mode to ".concat(r21));
        return;
    L82:
        r21 = "NONE";
        goto L83
    L75:
        if (r17 == false) goto L77;
        String r22 = "click";
    L78:
        r20 = new x(0, null, r22, null, null, null, null, null, 250);
        goto L79
    L77:
        r22 = "ktv_big_event";
        goto L78
    L71:
        r16 = false;
        goto L72
    L67:
        r15 = LinkMicBigEventMessage.KtvMode.KTVMODE_NONE.getValue();
        goto L69
    L21:
        if (r12 != 6) goto L23;
        LinkMicBigEventMessage.SwitchLyricStatusContent r23 = r11.switch_lyric_status_content;
        if (r23 == null) goto L93;
        Integer r24 = Integer.valueOf(r23.to_status);
        if (r24.intValue() == 0) goto L56;
        boolean r25 = true;
    L57:
        if (r25 == false) goto L59;
        r4 = r24;
    L59:
        if (r4 == null) goto L94;
        int r26 = r4.intValue();
        NextLiveData<Boolean> r27 = this.b;
        if (r26 != 1) goto L63;
        r13 = true;
    L63:
        r27.setValue(Boolean.valueOf(r13));
        return;
    L94:
        return;
    L56:
        r25 = false;
        goto L57
    L93:
        return;
    L23:
        if (r12 != 7) goto L25;
        LinkMicBigEventMessage.SwitchFullSongStatusContent r28 = r11.switch_full_song_status_content;
        if (r28 == null) goto L90;
        Integer r29 = Integer.valueOf(r28.to_status);
        if (r29.intValue() == 0) goto L43;
        boolean r30 = true;
    L44:
        if (r30 == false) goto L46;
        r6 = r29;
    L46:
        if (r6 == null) goto L91;
        int r31 = r6.intValue();
        NextLiveData<Boolean> r32 = this.c;
        if (r31 != 1) goto L50;
        r13 = true;
    L50:
        r32.setValue(Boolean.valueOf(r13));
        return;
    L91:
        return;
    L43:
        r30 = false;
        goto L44
    L90:
        return;
    L25:
        if (r12 != 8) goto L96;
        LinkMicBigEventMessage.SwitchTuningEffectContent r33 = r11.switch_tuning_effect_content;
        if (r33 == null) goto L86;
        String r34 = r33.to_effect_name;
        if (r34 != null) goto L32;
        return;
    L32:
        if (r34.length() <= 0) goto L34;
        r13 = true;
    L34:
        if (r13 == false) goto L36;
        r5 = r34;
    L36:
        if (r5 == null) goto L88;
        this.d.setValue(r5);
        return;
    L88:
        return;
    L86:
        return;
    L96:
        return;
    L85:
        return;
    L12:
        r9 = null;
        goto L13
    L8:
        r7 = r2;
        goto L9
    }
}
