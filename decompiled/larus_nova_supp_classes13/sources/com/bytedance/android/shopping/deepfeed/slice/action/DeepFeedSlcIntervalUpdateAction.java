package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.deepfeed.slice.DeepFeedSlcCardContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedSlcIntervalUpdateAction extends com.bytedance.android.shopping.deepfeed.slice.action.b {
    public static final WeakHashMap<w, Job> g = null;
    public final CoroutineScope d;
    public Job e;
    public w f;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final int c;
        public final int d;
        public final boolean e;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L16;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L14;
            return false;
        L14:
            if (this.e == r4.e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v8 */
        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L9;
            r1 = r4.hashCode();
        L9:
            int r5 = (((((r3 + r1) * 31) + this.c) * 31) + this.d) * 31;
            boolean r6 = this.e;
            ?? r7 = r6;
            if (r6 == false) goto L13;
            r7 = 1;
        L13:
            return r5 + r7;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "StateUpdateSpec(key=" + this.a + ", value=" + this.b + ", startAt=" + this.c + ", endAt=" + this.d + ", relativeCounter=" + this.e + ")";
        }

        public b(String r2, String r3, int r4, int r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    static {
        g = new WeakHashMap();
    }

    public final void f() {
        Job r0 = this.e;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        w r1 = this.f;
        if (r1 == null) goto L10;
        WeakHashMap<w, Job> r2 = g;
        if (r2.get(r1) != this.e) goto L10;
        r2.remove(r1);
    L10:
        this.e = null;
        this.f = null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a, com.bytedance.android.shopping.deepfeed.slice.action.v
    public final void dispose() {
        f();
        CoroutineScopeKt.cancel$default(this.d, null, 1, null);
        super.dispose();
    }

    public DeepFeedSlcIntervalUpdateAction(w r3) {
        Intrinsics.checkNotNullParameter(r3, "container");
        super(r3);
        this.d = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.b, com.bytedance.android.shopping.deepfeed.slice.action.v
    public final void c(DeepFeedSlcCardContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        f();
        super.c(r2);
    }

    public static Map e(List r6, int r7) {
        List r8 = r6;
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r8, 10)), 16));
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L18;
        b r0 = (b) r9.next();
        String r2 = r0.a;
        String r3 = r0.b;
        if (r3 == null) goto L13;
        if (r0.e == false) goto L10;
        int r4 = RangesKt.coerceIn(r7 - r0.c, 0, r3.length());
    L11:
        Object r5 = StringsKt.take(r0.b, r4);
    L17:
        Pair r10 = TuplesKt.to(r2, r5);
        r1.put(r10.getFirst(), r10.getSecond());
        goto L4
    L10:
        r4 = RangesKt.coerceIn(r7, 0, r3.length());
        goto L11
    L13:
        if (r0.e == false) goto L15;
        int r11 = r0.c;
        int r12 = RangesKt.coerceIn(r7 - r11, 0, r0.d - r11);
    L16:
        r5 = Integer.valueOf(r12);
        goto L17
    L15:
        r12 = RangesKt.coerceIn(r7, 0, r0.d);
        goto L16
    L18:
        return r1;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r21, View r22) {
        Intrinsics.checkNotNullParameter(r21, "action");
        Intrinsics.checkNotNullParameter(r22, "targetView");
        Map r0 = r21.getParams();
        if (r0 == null) goto L5;
        Object r1 = r0.get("interval");
    L7:
        if ((r1 instanceof Number) == true) goto L9;
        r1 = null;
    L9:
        Number r2 = (Number) r1;
        if (r2 == null) goto L20;
        Long r3 = Long.valueOf(r2.longValue());
        if (r3.longValue() <= 0) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L18;
        r3 = null;
    L18:
        if (r3 == null) goto L20;
        long r5 = r3.longValue();
    L21:
        long r7 = r5;
        Map r6 = r21.getParams();
        if (r6 == null) goto L24;
        Object r8 = r6.get("step");
    L26:
        if ((r8 instanceof Number) == true) goto L28;
        r8 = null;
    L28:
        Number r9 = (Number) r8;
        if (r9 == null) goto L39;
        Integer r10 = Integer.valueOf(r9.intValue());
        if (r10.intValue() <= 0) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == true) goto L37;
        r10 = null;
    L37:
        if (r10 == null) goto L39;
        int r12 = r10.intValue();
    L40:
        Map r13 = r21.getParams();
        if (r13 == null) goto L43;
        Object r14 = r13.get("value");
    L45:
        if ((r14 instanceof Map) == true) goto L47;
        r14 = null;
    L47:
        Map r15 = (Map) r14;
        if (r15 == null) goto L82;
        ArrayList r16 = new ArrayList();
        Iterator r17 = r15.entrySet().iterator();
    L52:
        if (r17.hasNext() == false) goto L80;
        Map.Entry r18 = (Map.Entry) r17.next();
        Object r19 = r18.getKey();
        Object r110 = r18.getValue();
        if ((r19 instanceof String) == true) goto L56;
        r19 = null;
    L56:
        String r111 = (String) r19;
        if (r111 != null) goto L60;
    L77:
        Triple r112 = null;
    L78:
        if (r112 == null) goto L52;
        r16.add(r112);
        goto L52
    L60:
        if ((r110 instanceof Map) == true) goto L62;
        r110 = null;
    L62:
        Map r113 = (Map) r110;
        if (r113 == null) goto L77;
        Object r114 = r113.get("index");
        if ((r114 instanceof Number) == true) goto L68;
        r114 = null;
    L68:
        Number r115 = (Number) r114;
        if (r115 == null) goto L77;
        int r116 = r115.intValue();
        Object r117 = r113.get("value");
        if ((r117 instanceof String) == true) goto L73;
        r117 = null;
    L73:
        String r118 = (String) r117;
        if (r118 == null) goto L77;
        r112 = new Triple(Integer.valueOf(r116), r111, r118);
        goto L78
    L80:
        List r20 = CollectionsKt.sortedWith(r16, new l());
        if (r20.isEmpty() == true) goto L82;
        Map r23 = r21.getParams();
        if (r23 == null) goto L86;
        Object r24 = r23.get("from");
    L88:
        if ((r24 instanceof Number) == true) goto L90;
        r24 = null;
    L90:
        Number r25 = (Number) r24;
        if (r25 == null) goto L93;
        int r26 = r25.intValue();
    L94:
        List r27 = r20;
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator r28 = r27.iterator();
    L95:
        int r120 = r26;
        if (r28.hasNext() == false) goto L98;
        Triple r29 = (Triple) r28.next();
        String r121 = (String) r29.component2();
        String r122 = (String) r29.component3();
        r26 = r122.length() + r120;
        r119.add(new b(r121, r122, r120, r26, true));
    L98:
        if (r119 != null) goto L122;
        Map r30 = r21.getParams();
        if (r30 == null) goto L102;
        Object r31 = r30.get("int_key");
    L104:
        if ((r31 instanceof String) == true) goto L106;
        r31 = null;
    L106:
        String r123 = (String) r31;
        if (r123 == null) goto L122;
        Map r32 = r21.getParams();
        if (r32 == null) goto L112;
        Object r33 = r32.get("count");
    L114:
        if ((r33 instanceof Number) == true) goto L116;
        r33 = null;
    L116:
        Number r34 = (Number) r33;
        if (r34 == null) goto L122;
        int r35 = r34.intValue();
        if (r35 <= 0) goto L122;
        b r36 = new b(r123, null, 0, r35 - 1, false);
    L123:
        if (r119 != null) goto L127;
        if (r36 == null) goto L126;
        List r37 = CollectionsKt.listOf(r36);
    L129:
        if (r37 != null) goto L176;
        Map r38 = r21.getParams();
        if (r38 == null) goto L133;
        Object r39 = r38.get("key");
    L135:
        if ((r39 instanceof String) == true) goto L137;
        r39 = null;
    L137:
        String r124 = (String) r39;
        if (r124 == null) goto L174;
        Map r40 = r21.getParams();
        if (r40 == null) goto L143;
        Object r41 = r40.get("from");
    L145:
        if ((r41 instanceof Number) == true) goto L147;
        r41 = null;
    L147:
        Number r42 = (Number) r41;
        if (r42 == null) goto L150;
        int r125 = r42.intValue();
    L151:
        Map r43 = r21.getParams();
        if (r43 == null) goto L154;
        Object r44 = r43.get("value");
    L156:
        if ((r44 instanceof String) == true) goto L158;
        r44 = null;
    L158:
        String r126 = (String) r44;
        Map r45 = r21.getParams();
        if (r45 == null) goto L161;
        Object r46 = r45.get("to");
    L163:
        if ((r46 instanceof Number) == true) goto L165;
        r46 = null;
    L165:
        Number r47 = (Number) r46;
        if (r47 == null) goto L168;
        int r48 = r47.intValue();
    L170:
        Integer r49 = Integer.valueOf(r48);
    L172:
        if (r49 == null) goto L174;
        b r50 = new b(r124, r126, r125, r49.intValue(), false);
    L175:
        r37 = CollectionsKt.listOfNotNull(r50);
        goto L176
    L168:
        if (r126 == null) goto L171;
        r48 = r126.length();
        goto L170
    L171:
        r49 = null;
        goto L172
    L161:
        r46 = null;
        goto L163
    L154:
        r44 = null;
        goto L156
    L150:
        r125 = 0;
        goto L151
    L143:
        r41 = null;
    L174:
        r50 = null;
        goto L175
    L133:
        r39 = null;
    L176:
        List r51 = r37;
        if (r51.isEmpty() == false) goto L179;
        return false;
    L179:
        if (r119 != null) goto L192;
        if (r36 != null) goto L192;
        Map r52 = r21.getParams();
        if (r52 == null) goto L185;
        Object r53 = r52.get("from");
    L187:
        if ((r53 instanceof Number) == true) goto L189;
        r53 = null;
    L189:
        Number r54 = (Number) r53;
        if (r54 == null) goto L192;
        int r55 = r54.intValue();
    L193:
        if (r119 == null) goto L203;
        Iterator r56 = r51.iterator();
        if (r56.hasNext() == true) goto L197;
    L196:
        Integer r57 = null;
    L224:
        if (r57 == null) goto L232;
        int r58 = r57.intValue();
        w r127 = this.c;
        f();
        WeakHashMap<w, Job> r128 = g;
        Job r59 = r128.remove(r127);
        if (r59 == null) goto L228;
        Job.DefaultImpls.cancel$default(r59, null, 1, null);
    L228:
        if (r55 < r58) goto L231;
        r127.C(MapsKt.mapOf(TuplesKt.to("state", e(r51, r58))));
        return false;
    L231:
        Job r60 = BuildersKt.launch$default(this.d, null, null, new DeepFeedSlcIntervalUpdateAction$onHandleAction$job$1(this, r55, r127, r51, r58, r12, r7, null), 3, null);
        this.e = r60;
        this.f = r127;
        r128.put(r127, r60);
    L232:
        return false;
    L197:
        r57 = Integer.valueOf(((b) r56.next()).d);
    L199:
        if (r56.hasNext() == false) goto L224;
        Integer r61 = Integer.valueOf(((b) r56.next()).d);
        if (r57.compareTo(r61) >= 0) goto L199;
        r57 = r61;
        goto L199
    L203:
        if (r36 == null) goto L205;
        r57 = Integer.valueOf(r36.d);
        goto L224
    L205:
        Map r62 = r21.getParams();
        if (r62 == null) goto L208;
        Object r63 = r62.get("to");
    L210:
        if ((r63 instanceof Number) == true) goto L212;
        r63 = null;
    L212:
        Number r64 = (Number) r63;
        if (r64 == null) goto L215;
        r57 = Integer.valueOf(r64.intValue());
        goto L224
    L215:
        Iterator r65 = r51.iterator();
        if (r65.hasNext() == false) goto L196;
        r57 = Integer.valueOf(((b) r65.next()).d);
    L220:
        if (r65.hasNext() == false) goto L224;
        Integer r66 = Integer.valueOf(((b) r65.next()).d);
        if (r57.compareTo(r66) >= 0) goto L220;
        r57 = r66;
        goto L220
    L208:
        r63 = null;
        goto L210
    L185:
        r53 = null;
    L192:
        r55 = 0;
        goto L193
    L126:
        r37 = null;
        goto L129
    L127:
        r37 = r119;
        goto L129
    L112:
        r33 = null;
        goto L114
    L102:
        r31 = null;
    L122:
        r36 = null;
        goto L123
    L93:
        r26 = 0;
        goto L94
    L86:
        r24 = null;
    L82:
        r119 = null;
        goto L98
    L43:
        r14 = null;
        goto L45
    L33:
        r11 = false;
    L39:
        r12 = 1;
        goto L40
    L24:
        r8 = null;
        goto L26
    L14:
        r4 = false;
    L20:
        r5 = 60;
        goto L21
    L5:
        r1 = null;
        goto L7
    }
}
