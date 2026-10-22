package com.bytedance.android.livesdk.ktvimpl.base.lyricmodule;

import android.graphics.Paint;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvapi.config.ScrollLyricConfigV2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends a {
    public final Map<String, Float> j;
    public final ScrollLyricConfigV2 k;

    @Override // ud2.a
    public final void clear() {
        this.a.clear();
        this.b = 0;
        this.c = 0;
        Iterator<Function1<List<com.bytedance.component.lyric.model.b>, Unit>> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().invoke(this.a);
        goto L4
    L6:
        ((LinkedHashMap) this.j).clear();
    }

    public d(ScrollLyricConfigV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        super(r2);
        this.k = r2;
        this.j = new LinkedHashMap();
    }

    @Override // ud2.a
    public final void e(long r18) {
        f(r18);
        int r3 = this.c;
        if (r3 >= 0) goto L5;
        return;
    L5:
        if (r3 >= this.a.size()) goto L37;
        com.bytedance.component.lyric.model.b r4 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.a, this.c);
        Intrinsics.checkNotNullParameter(r4, "lyricsLineInfo");
        Intrinsics.checkNotNullParameter(r4, "lyricsLineInfo");
        float r6 = 0.0f;
        if (TextUtils.isEmpty(r4.d) == false) goto L9;
        Pair r1 = new Pair(Float.valueOf(0.0f), Float.valueOf(0.0f));
    L30:
        if (((Number) r1.getFirst()).floatValue() <= 0) goto L32;
        r6 = ((Number) r1.getSecond()).floatValue() / ((Number) r1.getFirst()).floatValue();
    L32:
        this.k.j.setValue(Float.valueOf(r6));
        return;
    L9:
        float r5 = h(r4.d);
        long r7 = r4.b;
        if (r18 >= r7) goto L12;
        String r2 = "calculateLineProgressPercent error, playTime:" + r18 + ", startTime:" + r4.b;
        ALogger.e(bb0.b.b(), r2 + ", invoke class :" + com.bytedance.component.lyric.model.b.class.getSimpleName());
        r1 = new Pair(Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L30
    L12:
        long r8 = r18 - r7;
        StringBuilder r9 = new StringBuilder();
        int[] r10 = r4.g;
        if (r10 == null) goto L27;
        int r11 = r10.length;
        long r12 = 0;
        int r13 = 0;
    L15:
        if (r13 >= r11) goto L27;
        long r14 = r10[r13];
        r12 = r12 + r14;
        String[] r15 = r4.f;
        if (r15 == null) goto L20;
        String r16 = r15[r13];
        if (r16 == null) goto L20;
    L22:
        if (r8 < r12) goto L23;
        r9.append(r16);
        r13 = r13 + 1;
        goto L15
    L23:
        if (r13 <= 0) goto L25;
        r8 = r8 - (r12 - r14);
    L25:
        float r17 = (h(r16) / r10[r13]) * r8;
    L28:
        r1 = new Pair(Float.valueOf(r5), Float.valueOf(r17 + h(r9.toString())));
    L20:
        r16 = "";
    L27:
        r17 = 0.0f;
        goto L28
    }

    public final float h(String r4) {
        if (r4 != null) goto L4;
    L9:
        return 0.0f;
    L4:
        if (((LinkedHashMap) this.j).get(r4) == null) goto L6;
        Float r5 = (Float) ((LinkedHashMap) this.j).get(r4);
    L7:
        if (r5 == null) goto L9;
        return r5.floatValue();
    L6:
        float r0 = ((com.bytedance.android.livesdk.ktvapi.config.a) this.k).b.measureText(r4);
        this.j.put(r4, Float.valueOf(r0));
        r5 = Float.valueOf(r0);
        goto L7
    }

    @Override // ud2.a
    public final void a(List<com.bytedance.component.lyric.model.b> r22, int r23, long r24) {
        StringBuilder r2 = new StringBuilder("addLyrics ");
        if (r22 == null) goto L5;
        Integer r3 = Integer.valueOf(r22.size());
    L6:
        r2.append(r3);
        ALogger.i("CommonLyricDisplayModel", r2.toString());
        clear();
        if (r22 == null) goto L86;
        Iterator<com.bytedance.component.lyric.model.b> r4 = r22.iterator();
    L10:
        if (r4.hasNext() == false) goto L86;
        com.bytedance.component.lyric.model.b r5 = r4.next();
        if (TextUtils.isEmpty(r5.d) == true) goto L84;
        com.bytedance.android.livesdk.ktvapi.config.a r6 = this.i;
        Paint r7 = r6.c;
        float r8 = r6.e;
        Intrinsics.checkNotNullParameter(r5, "lyricsLineInfo");
        Intrinsics.checkNotNullParameter(r7, "toolPaint");
        String r9 = r5.d;
        int r10 = 0;
        this.b = 0;
        if (r7.measureText(r9) > r8) goto L19;
        int r11 = this.d + 1;
        this.d = r11;
        if (this.b >= r11) goto L84;
        this.a.add(r5);
        goto L84
    L19:
        if (r23 != 2) goto L36;
        com.bytedance.component.lyric.model.b r12 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r13 = new com.bytedance.component.lyric.model.b();
        StringBuilder r14 = new StringBuilder();
        StringBuilder r15 = new StringBuilder();
        StringBuilder r16 = new StringBuilder();
        String r17 = r5.d;
        if (r17 == null) goto L84;
        int r18 = r17.length();
    L23:
        if (r10 >= r18) goto L29;
        char r19 = r17.charAt(r10);
        r14.append(r19);
        if (r7.measureText(r14.toString()) <= r8) goto L27;
        r16.append(r19);
    L28:
        r10 = r10 + 1;
        goto L23
    L27:
        r15.append(r19);
        goto L28
    L29:
        r12.b = r5.b;
        r12.d = r15.toString();
        int r20 = this.d + 1;
        this.d = r20;
        if (this.b >= r20) goto L32;
        this.a.add(r12);
    L32:
        r13.b = r5.b + 4000;
        r13.d = r16.toString();
        int r21 = this.d + 1;
        this.d = r21;
        if (this.b >= r21) goto L84;
        this.a.add(r13);
        goto L84
    L36:
        if (r23 != 3) goto L84;
        com.bytedance.component.lyric.model.b r25 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r26 = new com.bytedance.component.lyric.model.b();
        StringBuilder r27 = new StringBuilder();
        String[] r110 = r5.f;
        if (r110 == null) goto L84;
        ArrayList r111 = new ArrayList();
        ArrayList r112 = new ArrayList();
        ArrayList r113 = new ArrayList();
        StringBuilder r114 = new StringBuilder();
        StringBuilder r115 = new StringBuilder();
        ArrayList r28 = new ArrayList();
        int r1 = r5.b;
        int r29 = r110.length;
        Iterator<com.bytedance.component.lyric.model.b> r116 = r4;
        int r30 = 0;
        int r31 = r1;
    L40:
        if (r30 >= r29) goto L54;
        int r117 = r29;
        String r32 = r110[r30];
        r27.append(r32);
        String[] r118 = r110;
        if (r7.measureText(r27.toString()) <= r8) goto L48;
        r113.add(r32);
        r115.append(r32);
        int[] r33 = r5.g;
        if (r33 == null) goto L53;
        if (r30 >= r33.length) goto L53;
        r28.add(Integer.valueOf(r33[r30]));
    L53:
        r30 = r30 + 1;
        r29 = r117;
        r110 = r118;
        goto L40
    L48:
        r111.add(r32);
        r114.append(r32);
        int[] r34 = r5.g;
        if (r34 == null) goto L53;
        if (r30 >= r34.length) goto L53;
        r112.add(Integer.valueOf(r34[r30]));
        r31 = r31 + r34[r30];
        goto L53
    L54:
        r25.b = r5.b;
        Object[] r35 = r111.toArray(new String[0]);
        if (r35 == null) goto L83;
        r25.f = (String[]) r35;
        r25.g = new int[r112.size()];
        int r36 = r112.size();
        int r37 = 0;
    L57:
        if (r37 >= r36) goto L62;
        int[] r38 = r25.g;
        if (r38 == null) goto L61;
        r38[r37] = ((Number) ListProtector.get(r112, r37)).intValue();
    L61:
        r37 = r37 + 1;
        goto L57
    L62:
        String r39 = r114.toString();
        if (r39 == null) goto L81;
        r25.d = StringsKt.trim(r39).toString();
        int r40 = this.d + 1;
        this.d = r40;
        if (this.b >= r40) goto L67;
        this.a.add(r25);
    L67:
        r26.b = r31;
        int r41 = 0;
        Object[] r42 = r113.toArray(new String[0]);
        if (r42 == null) goto L79;
        r26.f = (String[]) r42;
        r26.g = new int[r28.size()];
        int r43 = r28.size();
    L70:
        if (r41 >= r43) goto L75;
        int[] r44 = r26.g;
        if (r44 == null) goto L74;
        r44[r41] = ((Number) ListProtector.get(r28, r41)).intValue();
    L74:
        r41 = r41 + 1;
        goto L70
    L75:
        r26.d = r115.toString();
        int r45 = this.d + 1;
        this.d = r45;
        if (this.b >= r45) goto L85;
        this.a.add(r26);
    L85:
        r4 = r116;
        goto L10
    L79:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L81:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L83:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L84:
        r116 = r4;
    L86:
        this.c = f(r24);
        Iterator<Function1<List<com.bytedance.component.lyric.model.b>, Unit>> r46 = this.e.iterator();
    L88:
        if (r46.hasNext() == false) goto L91;
        r46.next().invoke(this.a);
        goto L88
    L91:
        if (this.a.size() != 0) goto L93;
        return;
    L93:
        ArrayList<com.bytedance.component.lyric.model.b> r47 = this.a;
        com.bytedance.component.lyric.model.b r48 = new com.bytedance.component.lyric.model.b();
        r48.a = 3;
        Unit r49 = Unit.INSTANCE;
        r47.add(r48);
        this.f.clear();
        this.f.addAll(this.a);
        g();
        return;
    L5:
        r3 = null;
        goto L6
    }
}
