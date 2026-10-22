package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import com.bytedance.android.live.ktv.common.midi.KSongToneLinesView;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.KtvDressDataKt;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvMidiLineRender extends com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a {
    public final Lazy k;
    public final Paint l;
    public final ConcurrentHashMap<Path, c0> m;
    public final a n;
    public final long o;
    public Pair<Integer, Integer> p;
    public final Lazy q;

    public static final class a {
        public int a;
        public int b;

        public a() {
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void f() {
        ((Path) this.k.getValue()).reset();
        i();
    }

    public final void i() {
        if ((!this.m.keySet().isEmpty()) == false) goto L11;
        Iterator<Path> r0 = this.m.keySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        r0.next().reset();
        goto L6
    L8:
        this.m.clear();
        return;
    }

    public KtvMidiLineRender() {
        this.k = InfraKotlinExtsKt.mainThreadLazy(KtvMidiLineRender$linePath$2.INSTANCE);
        Paint r0 = new Paint();
        r0.setStyle(Paint.Style.STROKE);
        r0.setStrokeCap(Paint.Cap.ROUND);
        int r1 = KSongToneLinesView.r;
        r0.setStrokeWidth(KSongToneLinesView.t);
        Unit r2 = Unit.INSTANCE;
        this.l = r0;
        this.m = new ConcurrentHashMap();
        this.n = new a();
        Lazy r3 = KtvSettingHelper.a;
        this.o = ((Number) KtvSettingHelper.B0.getValue()).longValue();
        this.p = new Pair(Integer.valueOf(KSongToneLinesView.r), Integer.valueOf(KSongToneLinesView.s));
        this.q = InfraKotlinExtsKt.mainThreadLazy(KtvMidiLineRender$linePaint$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void e() {
        super.e();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.t
    public final synchronized void a(Canvas r13) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r13, "canvas");     // Catch: Throwable -> L12
        r13.drawPath((Path) this.k.getValue(), (Paint) this.q.getValue());     // Catch: Throwable -> L12
        if ((!this.m.isEmpty()) == false) goto L10;
        Iterator<Map.Entry<Path, c0>> r0 = this.m.entrySet().iterator();     // Catch: Throwable -> L12
    L7:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<Path, c0> r1 = r0.next();     // Catch: Throwable -> L12
        Path r2 = r1.getKey();     // Catch: Throwable -> L12
        c0 r3 = r1.getValue();     // Catch: Throwable -> L12
        float r4 = r3.a;     // Catch: Throwable -> L12
        float r7 = r3.c;     // Catch: Throwable -> L12
        this.l.setShader(new LinearGradient(r4, r7, r3.b, r7, ((Number) this.p.getFirst()).intValue(), ((Number) this.p.getSecond()).intValue(), Shader.TileMode.CLAMP));     // Catch: Throwable -> L12
        r13.drawPath(r2, this.l);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void d(db0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r2, "model");
        this.e = r2;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void g(long r18) {
        this.h = r18;
        v r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        db0.a r4 = this.e;
        if (r4 == null) goto L57;
        List r1 = r4.findMidiSegmentsOpt(r18 - r0.j, r0.k + r18);
        if (r1 == null) goto L73;
        monitor-enter(this);
        v r5 = this.f;     // Catch: Throwable -> L54
        if (r5 != null) goto L16;
        monitor-exit(this);
        return;
    L16:
        if (r5.l > 0) goto L19;
        monitor-exit(this);
        return;
    L19:
        long r6 = r18 - r5.j;     // Catch: Throwable -> L54
        ((Path) this.k.getValue()).reset();     // Catch: Throwable -> L54
        i();     // Catch: Throwable -> L54
        float r7 = r5.j * r5.m;     // Catch: Throwable -> L54
        float r8 = r5.b;     // Catch: Throwable -> L54
        int r9 = (int) ((r7 - r8) + r8);     // Catch: Throwable -> L54
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L54
    L20:
        if (r2.hasNext() == false) goto L52;
        cb0.c r10 = (cb0.c) r2.next();     // Catch: Throwable -> L54
        j(r10.a, r6, r5.m);     // Catch: Throwable -> L54
        v r11 = this.f;     // Catch: Throwable -> L54
        if (r11 == null) goto L50;
        int r12 = r11.a(this.a, r10.b);     // Catch: Throwable -> L54
        a r13 = this.n;     // Catch: Throwable -> L54
        if (r13.a >= r13.b) goto L28;
        float r14 = r12;
        ((Path) this.k.getValue()).moveTo(this.n.a, r14);     // Catch: Throwable -> L54
        ((Path) this.k.getValue()).lineTo(this.n.b, r14);     // Catch: Throwable -> L54
    L28:
        if (r10.a.a > (r18 - ((long) r5.n))) goto L20;
        List r15 = r10.c;     // Catch: Throwable -> L54
        if (r15 == null) goto L20;
        Path r16 = new Path();     // Catch: Throwable -> L54
        Iterator r17 = r15.iterator();     // Catch: Throwable -> L54
        int r19 = 0;
        float r110 = 0.0f;
        float r111 = 0.0f;
    L34:
        if (r17.hasNext() == false) goto L48;
        Object r112 = r17.next();     // Catch: Throwable -> L54
        int r113 = r19 + 1;     // Catch: Throwable -> L54
        if (r19 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L54
    L38:
        j((cb0.a) r112, r6, r5.m);     // Catch: Throwable -> L54
        if (r110 != 0.0f) goto L41;
        r110 = this.n.a;     // Catch: Throwable -> L54
    L41:
        r111 = Math.max(this.n.b, r111);     // Catch: Throwable -> L54
        a r114 = this.n;     // Catch: Throwable -> L54
        int r115 = r114.a;     // Catch: Throwable -> L54
        if (r115 >= r114.b) goto L47;
        float r116 = r115;
        float r117 = r12;
        r16.moveTo(r116, r117);     // Catch: Throwable -> L54
        int r118 = this.n.b;     // Catch: Throwable -> L54
        if (r118 <= r9) goto L46;
        r16.lineTo(r9, r117);     // Catch: Throwable -> L54
        goto L47
    L46:
        r16.lineTo(r118, r117);     // Catch: Throwable -> L54
    L47:
        r19 = r113;
        goto L34
    L48:
        ConcurrentHashMap<Path, c0> r20 = this.m;     // Catch: Throwable -> L54
        c0 r119 = new c0();     // Catch: Throwable -> L54
        r119.a = r110;     // Catch: Throwable -> L54
        r119.b = r111;     // Catch: Throwable -> L54
        r119.c = r12;     // Catch: Throwable -> L54
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L54
        r20.put(r16, r119);     // Catch: Throwable -> L54
        goto L20
    L50:
        monitor-exit(this);
        return;
    L52:
        monitor-exit(this);
        return;
    L54:
        th = move-exception;
        throw th;
    L73:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void h(MidiSkinDressInfo r3) {
        this.g = r3;
        String r0 = null;
        if (r3 != null) goto L5;
    L18:
        k(null);
        return;
    L5:
        if (KtvDressDataKt.isAvailableMidiSkin(r3) == false) goto L18;
        MidiSkinMaterial r1 = r3.getMaterial();
        if (r1 == null) goto L11;
        BackgroundMaterial r2 = r1.getBg();
        if (r2 == null) goto L11;
        String r4 = r2.getToneLineStart();
    L12:
        MidiSkinMaterial r5 = r3.getMaterial();
        if (r5 == null) goto L17;
        BackgroundMaterial r6 = r5.getBg();
        if (r6 == null) goto L17;
        r0 = r6.getToneLineEnd();
    L17:
        k(TuplesKt.to(r4, r0));
        return;
    L11:
        r4 = null;
        goto L12
    }

    public final void k(Pair<String, String> r3) {
        if (r3 == null) goto L4;
        this.p = new Pair(Integer.valueOf(ColorProtector.parseColor((String) r3.getFirst())), Integer.valueOf(ColorProtector.parseColor((String) r3.getSecond())));
        return;
    L4:
        int r0 = KSongToneLinesView.r;
        this.p = new Pair(Integer.valueOf(KSongToneLinesView.r), Integer.valueOf(KSongToneLinesView.s));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void b(com.bytedance.android.live.ktv.common.midi.k r13, Long r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "scoreInfo");
        super.b(r13, r14, r15);
        if (c(r13) == false) goto L38;
        db0.a r16 = this.e;
        if (r16 == null) goto L39;
        cb0.c r17 = r16.findMidiSegmentOpt(this.h);
        if (r17 == null) goto L40;
        List r18 = r17.c;
        if (r18 != null) goto L11;
        r18 = new CopyOnWriteArrayList();
    L11:
        long r0 = this.h;
        r18.add(new cb0.a(r0, Math.min(r0, r17.a.b)));
        int r1 = 1;
        if (r18.size() <= 1) goto L22;
        CopyOnWriteArrayList r19 = new CopyOnWriteArrayList();
        long r2 = ((cb0.a) ListProtector.get(r18, 0)).a;
        long r4 = ((cb0.a) ListProtector.get(r18, 0)).b;
        cb0.a r3 = new cb0.a(r2, r4);
        r19.add(r3);
        int r5 = r18.size();
    L15:
        if (r1 >= r5) goto L21;
        cb0.a r6 = (cb0.a) ListProtector.get(r18, r1);
        long r7 = r6.a;
        if (r7 > ((this.o * ((long) 2)) + r4)) goto L19;
        long r8 = Math.max(r6.b, r4);
        r3.b = r8;
    L20:
        r4 = r8;
        r1 = r1 + 1;
        goto L15
    L19:
        r8 = r6.b;
        r3 = new cb0.a(r7, r8);
        r19.add(r3);
        goto L20
    L21:
        r18 = r19;
    L22:
        r17.c = r18;
        cb0.a r110 = (cb0.a) CollectionsKt.firstOrNull(r18);
        if (r110 != null) goto L25;
    L27:
        List r111 = r17.c;
        if (r111 == null) goto L41;
        cb0.a r112 = (cb0.a) CollectionsKt.lastOrNull(r111);
        if (r112 != null) goto L32;
        return;
    L32:
        if ((r17.a.b - r112.b) > KtvSettingHelper.s()) goto L43;
        r112.b = r17.a.b;
        return;
    L43:
        return;
    L41:
        return;
    L25:
        if ((r110.a - r17.a.a) > KtvSettingHelper.s()) goto L27;
        r110.a = r17.a.a;
        goto L27
    L40:
        return;
    L39:
        return;
    }

    public final void j(cb0.a r10, long r11, float r13) {
        a r0 = this.n;
        Long r1 = Long.valueOf(r10.a - r11);
        boolean r4 = true;
        int r7 = 0;
        if (r1.longValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        Long r3 = null;
        if (r2 == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        int r5 = (int) (r1.longValue() * r13);
    L13:
        r0.a = r5;
        a r6 = this.n;
        Long r12 = Long.valueOf(r10.b - r11);
        if (r12.longValue() > 0) goto L17;
        r4 = false;
    L17:
        if (r4 == false) goto L19;
        r3 = r12;
    L19:
        if (r3 == null) goto L21;
        int r14 = (int) (r3.longValue() * r13);
        int r15 = KSongToneLinesView.r;
        r7 = r14 - (((int) KSongToneLinesView.t) * 2);
    L21:
        r6.b = r7;
        return;
    L12:
        r5 = 0;
        goto L13
    L5:
        r2 = false;
        goto L6
    }
}
