package com.larus.bmhome.instruction.core.impl.base;

import com.larus.bmhome.actionbar.model.u;
import com.larus.im.internal.delegate.c0;
import cq8.a0;
import cq8.q0;
import cq8.y;
import cq8.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes26.dex */
public abstract class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f311919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u f311920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f311921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f311922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super y, Unit> f311923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<e> f311924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CoroutineScope f311925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f311926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final StateFlowImpl f311927i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b1 f311928j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableSharedFlow<d> f311929k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a1 f311930l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MutableSharedFlow<k> f311931m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a1 f311932n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final C4081b f311933o;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.bmhome.instruction.core.impl.base.b$b, reason: collision with other inner class name */
    public static final class C4081b implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f311934a;

        public C4081b(b r100) {
            this.f311934a = r100;
        }

        @Override // cq8.z
        public final void a(y r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.f311934a.f311923e.invoke(r100);
        }
    }

    static {
    }

    public List<u> c() {
        return null;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public abstract /* synthetic */ int getType();

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public void h(Integer r100) {
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public void i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public void l(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public void m(y r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
    }

    public void onEvent(d r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    public a0 d() {
        return new q0(getWidgetId(), this.f311933o);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String getWidgetId() {
        return this.f311919a + '#' + hashCode();
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final void j() {
        a0 r100 = d();
        c0.f348199b.i("AbsInstructionController", "[emitDescriptor] from:" + this.f311919a + ", descriptor:" + r100.f464801a + ", version:" + r100.a());
        this.f311927i.setValue(r100);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String f() {
        return this.f311919a;
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "logName");
        this.f311919a = r100;
        this.f311923e = new com.larus.bmhome.instruction.core.impl.base.a();
        this.f311924f = new ArrayList();
        this.f311925g = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        StateFlowImpl r101 = j1.a(null);
        this.f311927i = r101;
        this.f311928j = kotlinx.coroutines.flow.e.b(r101);
        MutableSharedFlow<d> r102 = SharedFlowKt.MutableSharedFlow$default(0, 8, null, 5, null);
        this.f311929k = r102;
        this.f311930l = kotlinx.coroutines.flow.e.a(r102);
        MutableSharedFlow<k> r103 = SharedFlowKt.MutableSharedFlow$default(0, 16, null, 5, null);
        this.f311931m = r103;
        this.f311932n = kotlinx.coroutines.flow.e.a(r103);
        this.f311933o = new C4081b(this);
    }

    public final void e(d r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        c0.f348199b.i("AbsInstructionController", "[emitControllerEvent] from:" + this.f311919a + ", event:" + r100.f311938a + ", sourceWidgetId:" + r100.a());
        this.f311929k.tryEmit(r100);
    }

    public final void o(k r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        c0.f348199b.i("AbsInstructionController", "[emitToHostEvent] from:" + this.f311919a + ", event:" + r100.f311945a);
        this.f311931m.tryEmit(r100);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 k(u r100, c r101, Function1<? super y, Unit> r102, e r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "controllerContext");
        Intrinsics.checkNotNullParameter(r102, "dispatcher");
        this.f311920b = r100;
        this.f311921c = r101;
        this.f311925g = r101.f311936b;
        this.f311922d = r103;
        this.f311923e = r102;
        if (r104 != null) goto L8;
        if (r100 == null) goto L6;
        r104 = r100.f295477d;
        goto L8
    L6:
        r104 = null;
    L8:
        return n(r104);
    }
}
