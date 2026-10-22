package com.obric.audio.enroll.sidauth;

import com.larus.utils.logger.FLogger;
import com.obric.audio.continuous_talk.s0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f395567a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f395569b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f395570c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f395571d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f395568a == r101.f395568a) goto L12;
            return false;
        L12:
            if (this.f395569b == r101.f395569b) goto L15;
            return false;
        L15:
            if (this.f395570c == r101.f395570c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f395568a * 31) + this.f395569b) * 31;
            if (this.f395570c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Segment(startBytes=" + this.f395568a + ", endBytes=" + this.f395569b + ", isOpenEnded=" + this.f395570c + ')';
        }

        public a(int r100, int r101, boolean r102) {
            this.f395568a = r100;
            this.f395569b = r101;
            this.f395570c = r102;
            this.f395571d = r101 - r100;
        }
    }

    static {
    }

    public static long a(int r100) {
        return (((long) r100) * 1000) / ((long) 32000);
    }

    public static a b(s0 r210, byte[] r211) {
        byte[] r100 = r211;
        long r101 = a(r100.length);
        int r102 = 0;
        float[] r103 = null;
        float[] r104 = null;
        int r105 = 0;
    L4:
        if (r102 >= r100.length) goto L43;
        if ((r102 % 2) == 0) goto L10;
        r102 = r102 - 1;
    L10:
        if (r102 >= r100.length) goto L43;
        int r110 = RangesKt.coerceAtMost(r102 + 16000, r100.length);
        if ((r110 % 2) == 0) goto L15;
        r110 = r110 - 1;
    L15:
        if (r110 <= r102) goto L43;
        int r106 = r110 - r102;
        boolean r111 = r210.b(r100, r102, r106);
        Object r107 = r210.f395223c;
        monitor-enter(r107);
        float[] r108 = r210.f395228h;     // Catch: Throwable -> L40
        if (r108 == null) goto L22;
        float[] r109 = Arrays.copyOf(r108, r108.length);     // Catch: Throwable -> L40
    L23:
        monitor-exit(r107);
        if (r109 == null) goto L26;
        float[] r112 = Arrays.copyOf(r109, r109.length);
    L27:
        if (r112 != null) goto L29;
    L35:
        FLogger r113 = FLogger.f375446a;
        StringBuilder r114 = new StringBuilder("vad frame result index=");
        r114.append(r105);
        r114.append(" startMs=");
        r114.append(a(r102));
        r114.append(" endMs=");
        r114.append(a(r110));
        r114.append(" frameDurationMs=");
        r114.append(a(r106));
        r114.append(" hasFeature=");
        r114.append(r111);
        r114.append(" featureValuesMs=");
        if (r112 == null) goto L38;
        String r115 = Arrays.toString(r112);
    L39:
        r114.append(r115);
        r113.i("SidAuthVadAudioSlicer", r114.toString());
        r105 = r105 + 1;
        r100 = r211;
        r103 = r112;
        r102 = r110;
        goto L4
    L38:
        r115 = null;
        goto L39
    L29:
        if (r112.length != 0) goto L31;
        boolean r116 = true;
    L33:
        if ((!r116) == false) goto L35;
        r104 = r112;
        goto L35
    L31:
        r116 = false;
        goto L33
    L26:
        r112 = null;
        goto L27
    L22:
        r109 = null;
    L40:
        th = move-exception;
        throw th;
    L43:
        if (r103 == null) goto L52;
        if (r103.length != 0) goto L47;
        boolean r117 = true;
    L49:
        if ((!r117) == false) goto L52;
    L61:
        if (r103 != null) goto L63;
    L141:
        FLogger.f375446a.i("SidAuthVadAudioSlicer", "findLongestVoiceSegment no valid featureValues, pcmDurationMs=" + r101);
        return null;
    L63:
        if (r103.length != 0) goto L65;
        boolean r118 = true;
    L66:
        if (r118 == true) goto L141;
        ArrayList r119 = new ArrayList();
        int r120 = 0;
    L70:
        if (r120 >= r103.length) goto L101;
        long r121 = RangesKt.coerceAtLeast(MathKt.roundToLong(r103[r120]), 0);
        Float r122 = ArraysKt.getOrNull(r103, r120 + 1);
        if (r122 == null) goto L74;
        Long r123 = Long.valueOf(MathKt.roundToLong(r122.floatValue()));
    L75:
        if (r123 != null) goto L77;
    L80:
        boolean r124 = true;
    L81:
        if (r124 == false) goto L83;
        long r125 = r101;
    L84:
        long r126 = RangesKt.coerceAtMost(r121, r101);
        long r127 = RangesKt.coerceAtMost(r125, r101);
        ArrayList r212 = r119;
        long r128 = 32000;
        int r213 = r120;
        int r129 = (int) ((r126 * r128) / 1000);
        if ((r129 % 2) == 0) goto L88;
        r129 = r129 - 1;
    L88:
        int r130 = (int) ((r128 * r127) / 1000);
        if ((r130 % 2) == 0) goto L92;
        r130 = r130 - 1;
    L92:
        float[] r131 = r103;
        int r132 = (int) (((long) 32) * r101);
        if ((r132 % 2) == 0) goto L96;
        r132 = r132 - 1;
    L96:
        int r133 = RangesKt.coerceAtMost(r130, r132);
        if (r133 <= r129) goto L99;
        a r134 = new a(r129, r133, r124);
        ArrayList r135 = r212;
        r135.add(r134);
    L100:
        r103 = r131;
        r120 = r213 + 2;
        r119 = r135;
        goto L70
    L99:
        r135 = r212;
        FLogger.f375446a.w("SidAuthVadAudioSlicer", "skip invalid vad segment startMs=" + r126 + " endMs=" + r127 + " isOpenEnded=" + r124 + " featureValuesMs=" + Arrays.toString(r131));
        goto L100
    L83:
        r125 = RangesKt.coerceAtLeast(r123.longValue(), r121);
        goto L84
    L77:
        if (r123.longValue() <= 0) goto L80;
        r124 = false;
        goto L81
    L74:
        r123 = null;
        goto L75
    L101:
        ArrayList r136 = r119;
        FLogger.f375446a.i("SidAuthVadAudioSlicer", "vad final featureValuesMs=" + Arrays.toString(r103) + " pcmDurationMs=" + r101);
        Iterator r137 = r136.iterator();
        int r138 = 0;
    L103:
        if (r137.hasNext() == false) goto L108;
        Object r139 = r137.next();
        int r140 = r138 + 1;
        if (r138 >= 0) goto L107;
        CollectionsKt.throwIndexOverflow();
    L107:
        a r141 = (a) r139;
        FLogger.f375446a.i("SidAuthVadAudioSlicer", "vad segment[" + r138 + "] startMs=" + a(r141.f395568a) + " endMs=" + a(r141.f395569b) + " durationMs=" + a(r141.f395571d) + " isOpenEnded=" + r141.f395570c);
        r138 = r140;
        goto L103
    L108:
        ArrayList r142 = new ArrayList();
        Iterator r143 = r136.iterator();
    L110:
        if (r143.hasNext() == false) goto L118;
        Object r144 = r143.next();
        if (((a) r144).f395571d <= 0) goto L114;
        boolean r145 = true;
    L115:
        if (r145 == false) goto L110;
        r142.add(r144);
        goto L110
    L114:
        r145 = false;
        goto L115
    L118:
        if (r142.isEmpty() == false) goto L120;
        a r146 = null;
    L135:
        if (r146 != null) goto L138;
        FLogger.f375446a.i("SidAuthVadAudioSlicer", "findLongestVoiceSegment no valid segment after select, pcmDurationMs=" + a(r211.length));
        return null;
    L138:
        FLogger.f375446a.i("SidAuthVadAudioSlicer", "findLongestVoiceSegment final startMs=" + a(r146.f395568a) + " endMs=" + a(r146.f395569b) + " durationMs=" + a(r146.f395571d) + " isOpenEnded=" + r146.f395570c);
        return r146;
    L120:
        Iterator r147 = r142.iterator();
        if (r147.hasNext() == true) goto L123;
        Object r148 = null;
    L132:
        r146 = (a) r148;
        if (r146 == null) goto L135;
        FLogger.f375446a.i("SidAuthVadAudioSlicer", "selectLongestSegment use longest segment startMs=" + a(r146.f395568a) + " endMs=" + a(r146.f395569b) + " durationMs=" + a(r146.f395571d) + " isOpenEnded=" + r146.f395570c);
        goto L135
    L123:
        r148 = r147.next();
        if (r147.hasNext() == false) goto L132;
        int r149 = ((a) r148).f395571d;
    L127:
        Object r150 = r147.next();
        int r151 = ((a) r150).f395571d;
        if (r149 >= r151) goto L131;
        r148 = r150;
        r149 = r151;
    L131:
        if (r147.hasNext() == true) goto L127;
    L65:
        r118 = false;
        goto L66
    L47:
        r117 = false;
    L52:
        if (r104 != null) goto L54;
    L60:
        r103 = null;
        goto L61
    L54:
        if (r104.length != 0) goto L56;
        boolean r152 = true;
    L58:
        if ((!r152) == false) goto L60;
        r103 = r104;
        goto L61
    L56:
        r152 = false;
        goto L58
    }
}
