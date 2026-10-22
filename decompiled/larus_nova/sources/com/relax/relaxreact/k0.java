package com.relax.relaxreact;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.rts.gen.CommonCallbackNG;
import com.lynx.rts.gen.RendererFunctionNG;
import com.relax.relaxreact.shared.TaskScheduler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class k0 implements l0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static k0 f405535i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o0 f405536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m0 f405537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.relax.relaxreact.a f405538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RenderFnRenderer f405539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public x0 f405540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final EventEmitter f405541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EventEmitter f405542g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f405543h;

    public static final class a {
    }

    static {
    }

    @Override // com.relax.relaxreact.l0
    public final void dispose() {
        if (this.f405543h == false) goto L5;
        return;
    L5:
        this.f405543h = true;
        com.relax.relaxreact.a r100 = this.f405538c;
        if (r100 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("beforePublishEvent");
        r100 = null;
    L9:
        Map<String, ArrayList<Function1<Map<String, Object>, Unit>>> r101 = r100.f405460a;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        ((LinkedHashMap) r101).clear();
        x0 r102 = this.f405540e;
        if (r102 == null) goto L12;
        r102.f405596a.q(new Reconciler$dispose$1(r102));
    L12:
        this.f405540e = null;
        final EventEmitter r103 = this.f405541f;
        if (r103 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("eventEmitter");
        r103 = null;
    L16:
        if (r103.f405406f == true) goto L19;
        r103.f405406f = true;
        com.bytedance.rts.kmp.foundation.j.b(r103.f405403c, new EventEmitter$dispose$1(r103));
        Map<String, b1> r104 = r103.f405403c;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        ((LinkedHashMap) r104).clear();
        Map<String, ArrayList<Function1<Map<String, Object>, Unit>>> r105 = r103.f405402b;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        ((LinkedHashMap) r105).clear();
        Set<String> r106 = r103.f405404d;
        Intrinsics.checkNotNullParameter(r106, "<this>");
        r106.clear();
        r103.f405405e = null;
    L19:
        this.f405542g = null;
        RenderFnRenderer r107 = this.f405539d;
        if (r107 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r107 = null;
    L22:
        r107.f405421e = null;
        RenderFnRenderer r108 = this.f405539d;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r108 = null;
    L26:
        if (r108.f405426j == true) goto L133;
        l0 r109 = r108.f405421e;
        if (r109 == null) goto L34;
        r109.dispose();
        if (r108.f405426j == true) goto L133;
        r108.f405421e = null;
    L34:
        r108.f405426j = true;
        TaskScheduler r110 = r108.f405425i;
        if (r110 != null) goto L37;
    L72:
        Map<Long, o> r111 = r108.f405423g;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        ((LinkedHashMap) r111).clear();
        mpa.l r112 = r108.f405417a;
        if (r112 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r112 = null;
    L75:
        long r113 = r108.f405418b;
        r112.getClass();
        int r114 = mpa.e.f514751a;
        mpa.k r115 = r112.f514759a;
        Intrinsics.checkNotNullParameter(r115, "renderer");
        r115.a().p(r113);
        if (r108.f405427k == false) goto L133;
        mpa.l r116 = r108.f405417a;
        if (r116 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r116 = null;
    L81:
        if (r116.f514760b == true) goto L133;
        r116.f514760b = true;
        mpa.k r117 = r116.f514759a;
        Intrinsics.checkNotNullParameter(r117, "renderer");
        mpa.a r118 = mpa.a.f514744a;
        long r119 = r117.f514757a;
        monitor-enter(r118);
        Set r120 = ((LinkedHashMap) mpa.a.f514745b).keySet();     // Catch: Throwable -> L129
        ArrayList r121 = new ArrayList();     // Catch: Throwable -> L129
        Iterator r122 = r120.iterator();     // Catch: Throwable -> L129
    L87:
        if (r122.hasNext() == false) goto L94;
        Object r123 = r122.next();     // Catch: Throwable -> L129
        ((mpa.d) r123).getClass();     // Catch: Throwable -> L129
        if (0 != r119) goto L91;
        boolean r124 = true;
    L92:
        if (r124 == false) goto L87;
        r121.add(r123);     // Catch: Throwable -> L129
        goto L87
    L91:
        r124 = false;
        goto L92
    L94:
        List r125 = CollectionsKt.toList(r121);     // Catch: Throwable -> L129
        Map<mpa.d, CommonCallbackNG> r126 = mpa.a.f514745b;     // Catch: Throwable -> L129
        Iterator r127 = r125.iterator();     // Catch: Throwable -> L129
    L96:
        if (r127.hasNext() == false) goto L98;
        r126.remove((mpa.d) r127.next());     // Catch: Throwable -> L129
        goto L96
    L98:
        Set r128 = ((LinkedHashMap) mpa.a.f514746c).keySet();     // Catch: Throwable -> L129
        ArrayList r129 = new ArrayList();     // Catch: Throwable -> L129
        Iterator r130 = r128.iterator();     // Catch: Throwable -> L129
    L100:
        if (r130.hasNext() == false) goto L107;
        Object r131 = r130.next();     // Catch: Throwable -> L129
        if (((mpa.m) r131).f514761a != r119) goto L104;
        boolean r132 = true;
    L105:
        if (r132 == false) goto L100;
        r129.add(r131);     // Catch: Throwable -> L129
        goto L100
    L104:
        r132 = false;
        goto L105
    L107:
        List r133 = CollectionsKt.toList(r129);     // Catch: Throwable -> L129
        Map<mpa.m, CommonCallbackNG> r134 = mpa.a.f514746c;     // Catch: Throwable -> L129
        Iterator r135 = r133.iterator();     // Catch: Throwable -> L129
    L109:
        if (r135.hasNext() == false) goto L111;
        r134.remove((mpa.m) r135.next());     // Catch: Throwable -> L129
        goto L109
    L111:
        Set r136 = ((LinkedHashMap) mpa.a.f514747d).keySet();     // Catch: Throwable -> L129
        ArrayList r137 = new ArrayList();     // Catch: Throwable -> L129
        Iterator r138 = r136.iterator();     // Catch: Throwable -> L129
    L113:
        if (r138.hasNext() == false) goto L120;
        Object r139 = r138.next();     // Catch: Throwable -> L129
        ((mpa.n) r139).getClass();     // Catch: Throwable -> L129
        if (0 != r119) goto L117;
        boolean r140 = true;
    L118:
        if (r140 == false) goto L113;
        r137.add(r139);     // Catch: Throwable -> L129
        goto L113
    L117:
        r140 = false;
        goto L118
    L120:
        List r141 = CollectionsKt.toList(r137);     // Catch: Throwable -> L129
        Map<mpa.n, CommonCallbackNG> r142 = mpa.a.f514747d;     // Catch: Throwable -> L129
        Iterator r143 = r141.iterator();     // Catch: Throwable -> L129
    L121:
        if (r143.hasNext() == false) goto L125;
        r142.remove((mpa.n) r143.next());     // Catch: Throwable -> L129
        goto L121
    L125:
        monitor-exit(r118);
        RendererFunctionNG r144 = r117.f514758b.getAndSet(null);
        if (r144 == null) goto L133;
        r144.e();
    L129:
        th = move-exception;
        throw th;
    L37:
        if (r110.f405579n == true) goto L72;
        r110.f405579n = true;
        Long r145 = r110.f405574i;
        if (r145 == null) goto L45;
        Intrinsics.checkNotNull(r145);
        long r146 = r145.longValue();
        com.relax.relaxreact.shared.c r147 = r110.f405566a;
        if (r147 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("schedulerBridge");
        r147 = null;
    L44:
        r147.c(r146);
        r110.f405574i = null;
    L45:
        Long r148 = r110.f405575j;
        if (r148 == null) goto L51;
        Intrinsics.checkNotNull(r148);
        long r149 = r148.longValue();
        com.relax.relaxreact.shared.c r150 = r110.f405566a;
        if (r150 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("schedulerBridge");
        r150 = null;
    L50:
        r150.b(r149);
        r110.f405575j = null;
    L51:
        r110.f405568c = new ArrayList();
        r110.f405569d = new ArrayList();
        r110.f405570e = new ArrayList();
        r110.f405578m++;
        r110.f405576k = null;
        r110.f405577l = false;
        ArrayList<Long> r151 = r110.f405571f;
        r110.f405571f = new ArrayList();
        int r152 = 0;
    L52:
        IntCompanionObject r153 = IntCompanionObject.INSTANCE;
        int r154 = com.bytedance.rts.kmp.foundation.i.a(r151);
        Intrinsics.checkNotNullParameter(r153, "<this>");
        if (r152 >= r154) goto L58;
        com.relax.relaxreact.shared.c r155 = r110.f405566a;
        if (r155 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("schedulerBridge");
        r155 = null;
    L57:
        r155.c(((Number) ListProtector.get(r151, r152)).longValue());
        r152 = r152 + 1;
        goto L52
    L58:
        ArrayList<Long> r156 = r110.f405572g;
        r110.f405572g = new ArrayList();
        int r157 = 0;
    L59:
        IntCompanionObject r158 = IntCompanionObject.INSTANCE;
        int r159 = com.bytedance.rts.kmp.foundation.i.a(r156);
        Intrinsics.checkNotNullParameter(r158, "<this>");
        if (r157 >= r159) goto L65;
        com.relax.relaxreact.shared.c r160 = r110.f405566a;
        if (r160 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("schedulerBridge");
        r160 = null;
    L64:
        r160.e(((Number) ListProtector.get(r156, r157)).longValue());
        r157 = r157 + 1;
        goto L59
    L65:
        ArrayList<Long> r161 = r110.f405573h;
        r110.f405573h = new ArrayList();
        int r162 = 0;
    L66:
        IntCompanionObject r163 = IntCompanionObject.INSTANCE;
        int r164 = com.bytedance.rts.kmp.foundation.i.a(r161);
        Intrinsics.checkNotNullParameter(r163, "<this>");
        if (r162 >= r164) goto L72;
        com.relax.relaxreact.shared.c r165 = r110.f405566a;
        if (r165 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("schedulerBridge");
        r165 = null;
    L71:
        r165.b(((Number) ListProtector.get(r161, r162)).longValue());
        r162 = r162 + 1;
    L133:
        if (f405535i != this) goto L165;
        f405535i = null;
        return;
    }

    public k0(RenderFnRenderer r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        this.f405539d = r100;
        mpa.l r101 = r100.f405417a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r101 = null;
    L5:
        EventEmitter r102 = new EventEmitter(r101);
        this.f405541f = r102;
        o0 r103 = new o0(r100);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f405536a = r103;
        m0 r104 = new m0(r102);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f405537b = r104;
        com.relax.relaxreact.a r105 = new com.relax.relaxreact.a();
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f405538c = r105;
        final com.bytedance.rts.kmp.foundation.p r106 = new com.bytedance.rts.kmp.foundation.p(this);
        r102.f405405e = new Lynx$createEventContextRunner$1(r106);
        if (this.f405542g == r102) goto L9;
        final com.bytedance.rts.kmp.foundation.p r107 = new com.bytedance.rts.kmp.foundation.p(this);
        Function1<Map<String, Object>, Unit> r108 = new Lynx$ensureDestroyListener$1(r107);
        Intrinsics.checkNotNullParameter(r108, "listener");
        r102.b();
        r102.a("__DestroyLifetime", r108);
        this.f405542g = r102;
    L9:
        r100.f405421e = this;
    }

    @Override // com.relax.relaxreact.l0
    public final <T> T c(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        Intrinsics.checkNotNullParameter(r100, "cb");
        k0 r101 = f405535i;
        f405535i = this;
        T r102 = r100.invoke();     // Catch: Throwable -> L6
        f405535i = r101;
        return r102;
    L6:
        th = move-exception;
        f405535i = r101;
        throw th;
    }

    @Override // com.relax.relaxreact.l0
    public final void b(String r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        com.relax.relaxreact.a r102 = this.f405538c;
        com.relax.relaxreact.a r103 = null;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("beforePublishEvent");
        r102 = null;
    L6:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "eventName");
        ArrayList r104 = (ArrayList) com.bytedance.rts.kmp.foundation.j.c(r102.f405460a, r100);
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        if (r106 != 0) goto L12;
        return;
    L12:
        com.relax.relaxreact.a r107 = this.f405538c;
        if (r107 == null) goto L15;
        r103 = r107;
    L16:
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "event");
        ArrayList r108 = (ArrayList) com.bytedance.rts.kmp.foundation.j.c(r103.f405460a, r100);
        if (r108 == null) goto L22;
    L19:
        IntCompanionObject r109 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r108, "<this>");
        int r110 = r108.size();
        Intrinsics.checkNotNullParameter(r109, "<this>");
        if (r105 >= r110) goto L24;
        ((Function1) ListProtector.get(r108, r105)).invoke(r101);
        r105 = r105 + 1;
        goto L19
    L24:
        return;
    L22:
        return;
    L15:
        Intrinsics.throwUninitializedPropertyAccessException("beforePublishEvent");
        goto L16
    L9:
        IntCompanionObject r111 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        r106 = r104.size();
        Intrinsics.checkNotNullParameter(r111, "<this>");
        goto L10
    }
}
