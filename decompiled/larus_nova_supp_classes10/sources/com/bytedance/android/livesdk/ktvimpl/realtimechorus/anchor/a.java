package com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor;

import com.bytedance.android.live.liveinteract.api.utils.LiveSeiCreator;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.w;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamVideoType;
import fd2.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ti6.f;
import ti6.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements j {
    public fi6.a a;
    public he0.b.a b;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.a$a, reason: collision with other inner class name */
    public static final class C0046a {
    }

    static {
    }

    public a() {
    }

    public final /* synthetic */ boolean b(aj6.d r1, aj6.b r2) {
        ti6.a.a(r1, r2);
        return false;
    }

    public final String a(int r17, int r18, List<f> r19) {
        Intrinsics.checkNotNullParameter(r19, "mixRegions");
        if (r19.isEmpty() == false) goto L6;
        return "";
    L6:
        RealTimeChorusBusinessContext.a r2 = RealTimeChorusBusinessContext.Companion;
        s r3 = r2.c();
        if (r3 == null) goto L9;
        String r4 = r3.Kb();
    L10:
        s r5 = r2.c();
        if (r5 == null) goto L13;
        String r6 = r5.Mm();
    L14:
        f r7 = new f();
        Iterator<f> r8 = r19.iterator();
    L15:
        boolean r9 = true;
        if (r8.hasNext() == false) goto L55;
        f r10 = r8.next();
        if (r10 == null) goto L20;
        String r11 = r10.b;
    L21:
        if (r11 == null) goto L15;
        if (r10 == null) goto L24;
        String r12 = r10.b;
    L26:
        if (Intrinsics.areEqual(r12, r4) == false) goto L15;
        if (r10 == null) goto L29;
        String r13 = r10.v;
    L30:
        r7.b(r13);
        if (r10 == null) goto L33;
        String r14 = r10.b;
    L34:
        r7.a(r14);
        r7.d(LiveWrappedMixedStreamVideoType.MIXED_STREAM_VIDEO_TYPE_MAIN);
        r7.m = true;
        if (r10 == null) goto L37;
        Integer r15 = Integer.valueOf(r10.a);
    L38:
        r7.a = r15.intValue();
        if (r10 == null) goto L41;
        String r16 = r10.c;
    L42:
        r7.c(r16);
        if (r10 == null) goto L45;
        Double r20 = Double.valueOf(r10.u);
    L46:
        r7.u = r20.doubleValue();
        if (r10 == null) goto L49;
        Integer r21 = Integer.valueOf(r10.s);
    L50:
        r7.s = r21.intValue();
        if (r10 == null) goto L53;
        Integer r22 = Integer.valueOf(r10.i);
    L54:
        r7.i = r22.intValue();
        r10.d(LiveWrappedMixedStreamVideoType.MIXED_STREAM_VIDEO_TYPE_3RD);
        r10.b(r6);
        w.a("ChorusCDNStreamMixer", "leadSingerId : " + r10.b + " subRoom " + r6);
        goto L15
    L53:
        r22 = null;
        goto L54
    L49:
        r21 = null;
        goto L50
    L45:
        r20 = null;
        goto L46
    L41:
        r16 = null;
        goto L42
    L37:
        r15 = null;
        goto L38
    L33:
        r14 = null;
        goto L34
    L29:
        r13 = null;
        goto L30
    L24:
        r12 = null;
        goto L26
    L20:
        r11 = null;
        goto L21
    L55:
        String r23 = r7.b;
        if (r23 != null) goto L58;
    L61:
        if (r9 == false) goto L63;
    L69:
        Map r24 = MapsKt.emptyMap();
        fi6.a r25 = this.a;
        long r26 = tc0.c.h().getChannelId();
        he0.b.a r110 = this.b;
        if (r110 == null) goto L72;
        boolean r111 = r110.J8();
    L73:
        he0.b.a r27 = this.b;
        if (r27 == null) goto L76;
        int r112 = r27.he();
    L77:
        he0.b.a r28 = this.b;
        if (r28 == null) goto L80;
        List r113 = r28.R4();
    L81:
        String r1 = LiveSeiCreator.b(r19, null, r25, r24, r26, 61, r111, 0, r112, r113, 9).toString();
        w.a("ChorusCDNStreamMixer", "mixStream appData " + r1);
        return r1;
    L80:
        r113 = null;
        goto L81
    L76:
        r112 = -1;
        goto L77
    L72:
        r111 = false;
        goto L73
    L63:
        if ((r19 instanceof ArrayList) == true) goto L65;
        List<f> r29 = null;
    L66:
        ArrayList r30 = (ArrayList) r29;
        if (r30 == null) goto L69;
        r30.add(r7);
        goto L69
    L65:
        r29 = r19;
        goto L66
    L58:
        if (r23.length() == 0) goto L61;
        r9 = false;
        goto L61
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    }
}
