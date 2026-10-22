package com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
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
public final class g<T> implements Consumer {
    public final /* synthetic */ Ref.ObjectRef a;
    public final /* synthetic */ Ref.LongRef b;
    public final /* synthetic */ Ref.IntRef c;
    public final /* synthetic */ Ref.FloatRef d;
    public final /* synthetic */ float e;
    public final /* synthetic */ long f;
    public final /* synthetic */ Ref.FloatRef g;
    public final /* synthetic */ Ref.IntRef h;
    public final /* synthetic */ com.bytedance.android.live.ktv.common.midi.k i;

    public g(Ref.ObjectRef r1, Ref.LongRef r2, Ref.IntRef r3, Ref.FloatRef r4, float r5, long r6, Ref.FloatRef r8, Ref.IntRef r9, com.bytedance.android.live.ktv.common.midi.k r10) {
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

    public final void accept(Object r33) {
        Throwable r9 = (Throwable) r33;
        xe2.b r1 = xe2.b.b;
        MusicPanel r2 = (MusicPanel) this.a.element;
        String r3 = String.valueOf(this.b.element);
        RealTimeChorusBusinessContext.a r10 = RealTimeChorusBusinessContext.Companion;
        int r4 = r10.b();
        int r5 = this.c.element;
        float r6 = this.d.element;
        float r7 = this.e;
        int r8 = this.i.e + 1;
        long r11 = System.currentTimeMillis() - this.f;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "chorusId");
        JSONObject r14 = new JSONObject();
        r14.put("chorus_id", r3);
        r14.put("cur_chorus_role", String.valueOf(r4));
        r14.put("segment", r5);
        r14.put("single_segment_midi_score", String.valueOf(r6));
        r14.put("average_midi_score", String.valueOf(r7));
        r14.put("cur_sentence_index", String.valueOf(r8));
        Object r16 = BDLocationException.ERROR_TIMEOUT;
        if (r2 == null) goto L7;
        KtvMusic r12 = r2.a;
        if (r12 == null) goto L7;
        Object r13 = Long.valueOf(r12.getMId());
    L8:
        r14.put("music_id", r13);
        if (r2 == null) goto L14;
        KtvMusic r15 = r2.a;
        if (r15 == null) goto L14;
        String r17 = r15.getMTitle();
        if (r17 == null) goto L14;
    L15:
        r14.put("music_name", r17);
        LinkMonitorData r18 = LinkMonitorData.ReportClientChorusInfoFailed;
        Intrinsics.checkNotNullParameter(r18, "data");
        Intrinsics.checkNotNullParameter(r14, "extra");
        pd2.c.a(r14);
        nd0.c.a.q(r18, MultiLinkEventModule.KTV_CHORUS, r11, r9, r14, false);
        w.a("RTChorusFullLinkMonitor", "api call fail:" + r18.getEventTypeValue() + ", extra:" + r14);
        int r19 = xe2.g.a;
        MusicPanel r20 = (MusicPanel) this.a.element;
        String r21 = String.valueOf(this.b.element);
        int r22 = r10.b();
        int r23 = this.c.element;
        float r24 = this.d.element;
        float r25 = this.e;
        int r26 = this.i.e + 1;
        float r27 = this.g.element;
        int r110 = this.h.element;
        long r28 = System.currentTimeMillis() - this.f;
        Intrinsics.checkNotNullParameter(r21, "chorusId");
        JSONObject r111 = new JSONObject();
        r111.put("chorus_id", r21);
        r111.put("cur_chorus_role", String.valueOf(r22));
        r111.put("segment", r23);
        r111.put("single_segment_midi_score", String.valueOf(r24));
        r111.put("average_midi_score", String.valueOf(r25));
        r111.put("cur_sentence_index", String.valueOf(r26));
        if (r20 == null) goto L20;
        KtvMusic r29 = r20.a;
        if (r29 == null) goto L20;
        r16 = Long.valueOf(r29.getMId());
    L20:
        r111.put("music_id", r16);
        if (r20 == null) goto L26;
        KtvMusic r30 = r20.a;
        if (r30 == null) goto L26;
        String r31 = r30.getMTitle();
        if (r31 == null) goto L26;
    L27:
        r111.put("music_name", r31);
        r111.put("volume", Float.valueOf(r27));
        r111.put("rtt", r110);
        r111.put("duration", r28);
        nd0.c.t(r9, r111);
        int r32 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusFlow, "ReportClientInfoFailed", 0, null, r111, 88);
        return;
    L26:
        r31 = "";
    L14:
        r17 = "";
    L7:
        r13 = BDLocationException.ERROR_TIMEOUT;
        goto L8
    }
}
