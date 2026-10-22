package com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.w;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.bdlocation.exception.BDLocationException;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ Ref.ObjectRef a;
    public final /* synthetic */ Ref.LongRef b;
    public final /* synthetic */ Ref.IntRef c;
    public final /* synthetic */ Ref.FloatRef d;
    public final /* synthetic */ float e;
    public final /* synthetic */ long f;
    public final /* synthetic */ Ref.FloatRef g;
    public final /* synthetic */ Ref.IntRef h;
    public final /* synthetic */ com.bytedance.android.live.ktv.common.midi.k i;

    public f(Ref.ObjectRef r1, Ref.LongRef r2, Ref.IntRef r3, Ref.FloatRef r4, float r5, long r6, Ref.FloatRef r8, Ref.IntRef r9, com.bytedance.android.live.ktv.common.midi.k r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public final void accept(Object r34) {
        com.bytedance.android.live.network.response.e r1 = (com.bytedance.android.live.network.response.e) r34;
        xe2.b r2 = xe2.b.b;
        MusicPanel r3 = (MusicPanel) this.a.element;
        String r4 = String.valueOf(this.b.element);
        RealTimeChorusBusinessContext.a r5 = RealTimeChorusBusinessContext.Companion;
        int r6 = r5.b();
        int r7 = this.c.element;
        float r8 = this.d.element;
        float r9 = this.e;
        int r10 = this.i.e + 1;
        String r14 = ((ExtraResponse) r1).logId;
        long r11 = System.currentTimeMillis() - this.f;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "chorusId");
        Intrinsics.checkNotNullParameter(r14, "logId");
        JSONObject r12 = new JSONObject();
        r12.put("chorus_id", r4);
        r12.put("cur_chorus_role", String.valueOf(r6));
        r12.put("segment", r7);
        r12.put("single_segment_midi_score", String.valueOf(r8));
        r12.put("average_midi_score", String.valueOf(r9));
        r12.put("cur_sentence_index", String.valueOf(r10));
        if (r3 == null) goto L7;
        KtvMusic r13 = r3.a;
        if (r13 == null) goto L7;
        Object r15 = Long.valueOf(r13.getMId());
    L8:
        r12.put("music_id", r15);
        if (r3 == null) goto L16;
        KtvMusic r16 = r3.a;
        if (r16 == null) goto L16;
        String r17 = r16.getMTitle();
        if (r17 == null) goto L16;
        String r21 = "";
    L17:
        r12.put("music_name", r17);
        LinkMonitorData r18 = LinkMonitorData.ReportClientChorusInfoSuccess;
        Intrinsics.checkNotNullParameter(r18, "data");
        Intrinsics.checkNotNullParameter(r14, "logId");
        Intrinsics.checkNotNullParameter(r12, "extra");
        pd2.c.a(r12);
        nd0.c.s(nd0.c.a, r18, MultiLinkEventModule.KTV_CHORUS, r11, r14, r12, 32);
        w.a("RTChorusFullLinkMonitor", "api call success:" + r18.getEventTypeValue() + ", extra:" + r12);
        int r19 = xe2.g.a;
        MusicPanel r20 = (MusicPanel) this.a.element;
        String r22 = String.valueOf(this.b.element);
        int r23 = r5.b();
        int r110 = this.c.element;
        float r111 = this.d.element;
        float r112 = this.e;
        int r113 = this.i.e + 1;
        String r24 = ((ExtraResponse) r1).logId;
        float r114 = this.g.element;
        int r115 = this.h.element;
        long r116 = System.currentTimeMillis() - this.f;
        Intrinsics.checkNotNullParameter(r22, "chorusId");
        Intrinsics.checkNotNullParameter(r24, "logId");
        JSONObject r25 = new JSONObject();
        r25.put("chorus_id", r22);
        r25.put("cur_chorus_role", String.valueOf(r23));
        r25.put("segment", r110);
        r25.put("single_segment_midi_score", String.valueOf(r111));
        r25.put("average_midi_score", String.valueOf(r112));
        r25.put("cur_sentence_index", String.valueOf(r113));
        if (r20 == null) goto L22;
        KtvMusic r26 = r20.a;
        if (r26 == null) goto L22;
        Object r27 = Long.valueOf(r26.getMId());
    L23:
        r25.put("music_id", r27);
        if (r20 == null) goto L31;
        KtvMusic r28 = r20.a;
        if (r28 == null) goto L31;
        String r29 = r28.getMTitle();
        if (r29 == null) goto L31;
        String r30 = r29;
    L32:
        r25.put("music_name", r30);
        r25.put("logId", r24);
        r25.put("volume", Float.valueOf(r114));
        r25.put("rtt", r115);
        r25.put("duration", r116);
        xe2.g.f(r25);
        int r31 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusFlow, "ReportClientInfoSuccess", 0, null, r25, 88);
        return;
    L31:
        r30 = r21;
    L22:
        r27 = BDLocationException.ERROR_TIMEOUT;
    L16:
        r17 = "";
        r21 = r17;
    L7:
        r15 = BDLocationException.ERROR_TIMEOUT;
        goto L8
    }
}
