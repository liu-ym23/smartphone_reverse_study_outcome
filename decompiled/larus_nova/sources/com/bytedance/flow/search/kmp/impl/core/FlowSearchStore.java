package com.bytedance.flow.search.kmp.impl.core;

import com.bytedance.flow.search.kmp.api.store.SearchLoadingState;
import com.larus.im.internal.delegate.c0;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.n;
import ouc.v;

/* JADX INFO: loaded from: classes3.dex */
public final class FlowSearchStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<aw5.b> f243564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f243565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateFlowImpl f243566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final buc.d f243567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f243568e;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowSearchStore(List<? extends aw5.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "middlewares");
        this.f243564a = r100;
        this.f243565b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        this.f243566c = j1.a(new aw5.c(0));
        this.f243567d = buc.b.c(0);
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        aw5.b r102 = (aw5.b) r101.next();
        Function1<? super aw5.a, Unit> r103 = new d(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "dispatcher");
        r102.f16540a = r103;
        goto L4
    }

    public final void b(aw5.a r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        Ref.LongRef r100 = new Ref.LongRef();
        r100.element = this.f243567d.c();
        monitor-enter(this);
        Job r101 = this.f243568e;     // Catch: Throwable -> L12
        if ((r110 instanceof aw5.a.i) == false) goto L9;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);     // Catch: Throwable -> L12
    L8:
        r100.element = this.f243567d.a(1);     // Catch: Throwable -> L12
    L9:
        this.f243568e = BuildersKt.launch$default(this.f243565b, null, null, new FlowSearchStore$dispatch$1$1(r110, r101, this, r100, null), 3, null);     // Catch: Throwable -> L12
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x02b7 -> B:56:0x02c9). Please report as a decompilation issue!!! */
    public static final Object a(FlowSearchStore r310, aw5.a r410, long r411, Continuation r412) {
        FlowSearchStore r100 = r310;
        r310.getClass();
        if ((r412 instanceof FlowSearchStore$processAction$1) == false) goto L7;
        FlowSearchStore$processAction$1 r101 = (FlowSearchStore$processAction$1) r412;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        String r106 = "aggregate_search_impl";
        String r107 = " state=";
        String r108 = "reducer_scope=";
        String r110 = "actionScopeId";
        String r111 = "action";
        String r112 = "state";
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        long r113 = r101.J$0;
        Ref.IntRef r109 = (Ref.IntRef) r101.L$5;
        String r114 = (String) r101.L$4;
        Iterator<aw5.b> r115 = (Iterator) r101.L$3;
        Ref.ObjectRef r116 = (Ref.ObjectRef) r101.L$2;
        String r117 = (String) r101.L$1;
        aw5.a r118 = (aw5.a) r101.L$0;
        ResultKt.throwOnFailure(r103);
        String r119 = "state";
        aw5.a r120 = r118;
        FlowSearchStore$processAction$1 r311 = r101;
        String r121 = r117;
        FlowSearchStore r413 = r100;
        String r122 = r114;
        Ref.ObjectRef r123 = r116;
        Object r124 = r104;
        FlowSearchStore$processAction$1 r125 = r311;
        Ref.IntRef r126 = r109;
        Iterator<aw5.b> r127 = r115;
        long r128 = r113;
    L56:
        List<String> r129 = b.f243569a;
        long r414 = r128;
        aw5.c r130 = (aw5.c) r123.element;
        int r131 = r126.element;
        Intrinsics.checkNotNullParameter(r130, r119);
        Intrinsics.checkNotNullParameter(r120, r111);
        Intrinsics.checkNotNullParameter(r121, r110);
        Intrinsics.checkNotNullParameter(r122, "middlewareName");
        c0 r132 = c0.f348199b;
        String r133 = r119;
        StringBuilder r134 = new StringBuilder(r108);
        r134.append(r121);
        String r135 = r121;
        r134.append(" middleware_finished action=");
        r134.append(Reflection.getOrCreateKotlinClass(r120.getClass()).getSimpleName());
        r134.append(" middleware=");
        r134.append(r122);
        r134.append(" updates=");
        r134.append(r131);
        r134.append(r107);
        r134.append(b.a(r130));
        r132.i(r106, r134.toString());
        r100 = r413;
        long r136 = r414;
        aw5.a r137 = r120;
        Iterator<aw5.b> r138 = r127;
        Ref.ObjectRef r139 = r123;
        r112 = r133;
        String r140 = r135;
    L22:
        if (r138.hasNext() == false) goto L58;
        aw5.b r141 = r138.next();
        String r142 = r106;
        if (r100.f243567d.c() == r136) goto L26;
        boolean r143 = true;
    L27:
        if (r143 == false) goto L29;
        c0.f348199b.i("FlowSearchStore", "action_cancelled scope=" + r140 + " action=" + Reflection.getOrCreateKotlinClass(r137.getClass()).getSimpleName() + " at middleware=" + Reflection.getOrCreateKotlinClass(r141.getClass()).getSimpleName());
        return Unit.INSTANCE;
    L29:
        String r144 = Reflection.getOrCreateKotlinClass(r141.getClass()).getSimpleName();
        if (r144 != null) goto L32;
        r144 = "";
    L32:
        String r145 = r107;
        Ref.IntRef r146 = new Ref.IntRef();
        String r147 = r108;
        c r148 = new c(r100);     // Catch: CancellationException -> L45 Throwable -> L47
        r125.L$0 = r137;     // Catch: CancellationException -> L45 Throwable -> L47
        r125.L$1 = r140;     // Catch: CancellationException -> L45 Throwable -> L47
        r125.L$2 = r139;     // Catch: CancellationException -> L45 Throwable -> L47
        r125.L$3 = r138;     // Catch: CancellationException -> L45 Throwable -> L47
        r125.L$4 = r144;     // Catch: CancellationException -> L45 Throwable -> L47
        r125.L$5 = r146;     // Catch: CancellationException -> L45 Throwable -> L47
        r125.J$0 = r136;     // Catch: CancellationException -> L45 Throwable -> L47
        FlowSearchStore r312 = r100;
        r125.label = 1;     // Catch: Throwable -> L43 CancellationException -> L45
        r103 = r141.a(r137, r148);     // Catch: Throwable -> L43 CancellationException -> L45
        if (r103 == r124) goto L70;
        String r149 = r144;
        aw5.a r313 = r137;
        FlowSearchStore r150 = r312;
        long r314 = r136;
        aw5.a r151 = r313;
        Object r152 = r124;
        long r153 = r314;
    L62:
        Flow r154 = (Flow) r103;     // Catch: Throwable -> L41 CancellationException -> L45
        String r210 = r110;
        String r211 = r111;
        String r315 = r112;
        FlowSearchStore r155 = r150;
        Object r156 = r152;
        r120 = r151;
        String r316 = r149;
        FlowSearchStore$processAction$1 r157 = r125;
        String r158 = r316;
        Iterator<aw5.b> r317 = r138;
        r126 = r146;
        long r159 = r153;
        Ref.ObjectRef r160 = r139;
        r127 = r317;
    L52:
        FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 r161 = new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(r154, new FlowSearchStore$processAction$2(null));
        r413 = r155;
        String r415 = r158;
        Ref.ObjectRef r416 = r160;
        Object r162 = r156;
        long r163 = r159;
        FlowSearchStore$processAction$1 r164 = r157;
        e r165 = new e(r155, r159, r140, r120, r415, r126, r416);
        r164.L$0 = r120;
        r164.L$1 = r140;
        r164.L$2 = r416;
        r164.L$3 = r127;
        r164.L$4 = r415;
        r164.L$5 = r126;
        r164.J$0 = r163;
        r164.label = 2;
        if (r161.collect(r165, r164) == r162) goto L69;
        r125 = r164;
        r124 = r162;
        r128 = r163;
        r121 = r140;
        r106 = r142;
        r107 = r145;
        r110 = r210;
        r111 = r211;
        r119 = r315;
        r123 = r416;
        r122 = r415;
        r108 = r147;
        goto L56
    L69:
        return r162;
    L41:
        Throwable th10 = th;
    L50:
        aw5.a r212 = r151;
        long r213 = r153;
        Ref.IntRef r214 = r146;
        String r215 = r149;
        r210 = r110;
        r211 = r111;
        r315 = r112;
        Iterator<aw5.b> r318 = r138;
        Ref.ObjectRef r319 = r139;
        String r320 = r140;
        String r216 = r142;
        String r217 = r145;
        String r218 = r147;
        Throwable r166 = th10;
        Object r167 = r152;
        FlowSearchStore$processAction$1 r168 = r125;
    L51:
        n r169 = new n(new aw5.d(SearchLoadingState.LoadFailed, null, null, false, null, r166, null, false, true, null, null, null, null, null, 1031934));
        r157 = r168;
        r155 = r150;
        r154 = r169;
        r156 = r167;
        r159 = r213;
        r120 = r212;
        r126 = r214;
        r158 = r215;
        r142 = r216;
        r145 = r217;
        r147 = r218;
        r127 = r318;
        r160 = r319;
        r140 = r320;
        goto L52
    L70:
        return r124;
    L43:
        th10 = th;
    L49:
        r149 = r144;
        aw5.a r321 = r137;
        r150 = r312;
        long r322 = r136;
        r151 = r321;
        r152 = r124;
        r153 = r322;
        goto L50
    L45:
        e = move-exception;
        throw e;
    L47:
        th10 = th;
        r312 = r100;
        goto L49
    L26:
        r143 = false;
        goto L27
    L58:
        List<String> r170 = b.f243569a;
        aw5.c r171 = (aw5.c) r139.element;
        Intrinsics.checkNotNullParameter(r171, r112);
        Intrinsics.checkNotNullParameter(r137, r111);
        Intrinsics.checkNotNullParameter(r140, r110);
        c0.f348199b.i(r106, r108 + r140 + " action_finished action=" + Reflection.getOrCreateKotlinClass(r137.getClass()).getSimpleName() + r107 + b.a(r171));
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r172 = r101.J$0;
        Ref.IntRef r173 = (Ref.IntRef) r101.L$5;
        String r174 = (String) r101.L$4;
        r138 = (Iterator) r101.L$3;
        r139 = (Ref.ObjectRef) r101.L$2;
        r140 = (String) r101.L$1;
        aw5.a r175 = (aw5.a) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L18 CancellationException -> L45
        r151 = r175;
        r145 = " state=";
        r147 = "reducer_scope=";
        r152 = r104;
        r146 = r173;
        r149 = r174;
        r142 = "aggregate_search_impl";
        r153 = r172;
        r125 = r101;
        r150 = r100;
    L18:
        th = move-exception;
        r213 = r172;
        r212 = r175;
        r214 = r173;
        r215 = r174;
        r216 = "aggregate_search_impl";
        r217 = " state=";
        r218 = "reducer_scope=";
        r210 = "actionScopeId";
        r211 = "action";
        r315 = "state";
        r318 = r138;
        r319 = r139;
        r320 = r140;
        r167 = r104;
        r166 = th;
        r168 = r101;
        r150 = r100;
        goto L51
    L20:
        ResultKt.throwOnFailure(r103);
        v r176 = com.bytedance.flow.search.kmp.impl.util.d.f243664a;
        String r177 = com.bytedance.flow.search.kmp.impl.util.d.a(8) + '-' + com.bytedance.flow.search.kmp.impl.util.d.a(4) + '-' + com.bytedance.flow.search.kmp.impl.util.d.a(4) + '-' + com.bytedance.flow.search.kmp.impl.util.d.a(4) + '-' + com.bytedance.flow.search.kmp.impl.util.d.a(12);
        Ref.ObjectRef r178 = new Ref.ObjectRef();
        r178.element = r100.f243566c.getValue();
        r140 = r177;
        r125 = r101;
        r139 = r178;
        r138 = r100.f243564a.iterator();
        r124 = r104;
        r137 = r410;
        r136 = r411;
    L7:
        r101 = new FlowSearchStore$processAction$1(r100, r412);
        goto L8
    }
}
