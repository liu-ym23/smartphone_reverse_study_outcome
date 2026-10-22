package com.relax.relaxreact;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.rts.gen.ComponentAtIndexesCallbackNG;
import com.lynx.rts.gen.RendererFunctionNG;
import com.relax.relaxreact.shared.TaskScheduler;
import com.relax.relaxreact.utils.__utils;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class RenderFnRenderer implements z0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f405416l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mpa.l f405417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f405418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f405419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f405420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l0 f405421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ListRuntime f405422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Long, o> f405423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f405424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TaskScheduler f405425i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f405426j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f405427k;

    public static final class a {
    }

    static {
    }

    @Override // com.relax.relaxreact.z0
    public final void e(p r100) {
        Intrinsics.checkNotNullParameter(r100, "ele");
    }

    @Override // com.relax.relaxreact.z0
    public final void o() {
        Intrinsics.checkNotNullParameter(null, "ele");
        Intrinsics.checkNotNullParameter(null, "eventName");
        Intrinsics.checkNotNullParameter(null, "options");
    }

    @Override // com.relax.relaxreact.z0
    public final p A() {
        mpa.l r100 = this.f405417a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r100 = null;
    L5:
        long r101 = this.f405420d;
        r100.getClass();
        int r102 = mpa.e.f514751a;
        mpa.k r103 = r100.f514759a;
        Intrinsics.checkNotNullParameter(r103, "renderer");
        return new p(r103.a().l(r101));
    }

    @Override // com.relax.relaxreact.z0
    public final p a() {
        mpa.l r100 = this.f405417a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r100 = null;
    L5:
        long r101 = this.f405420d;
        r100.getClass();
        int r102 = mpa.e.f514751a;
        mpa.k r103 = r100.f514759a;
        Intrinsics.checkNotNullParameter(r103, "renderer");
        return new p(r103.a().m(r101));
    }

    @Override // com.relax.relaxreact.z0
    public final p h() {
        p r100 = this.f405419c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rootNode");
        return null;
    L6:
        return r100;
    }

    @Override // com.relax.relaxreact.z0
    public final ListRuntime m() {
        if (this.f405422f != null) goto L5;
        this.f405422f = new ListRuntime();
    L5:
        ListRuntime r100 = this.f405422f;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // com.relax.relaxreact.z0
    public final p n() {
        mpa.l r100 = this.f405417a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r100 = null;
    L5:
        long r101 = this.f405420d;
        Map<String, Object> r102 = a1.f405463a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "options");
        int r103 = mpa.e.f514751a;
        mpa.k r104 = r100.f514759a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        return new p(r104.a().n(r101, new HashMap()));
    }

    @Override // com.relax.relaxreact.z0
    public final p r() {
        mpa.l r100 = this.f405417a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r100 = null;
    L5:
        r100.getClass();
        int r101 = mpa.e.f514751a;
        mpa.k r102 = r100.f514759a;
        Intrinsics.checkNotNullParameter(r102, "renderer");
        Intrinsics.checkNotNullParameter("", "content");
        return new p(r102.a().k(""));
    }

    @Override // com.relax.relaxreact.z0
    public final void s() {
        ListRuntime r100 = this.f405422f;
        if (r100 == null) goto L11;
        Intrinsics.checkNotNull(r100);
        r100.getClass();
        Intrinsics.checkNotNullParameter(this, "renderer");
        s0 r101 = r100.f405415c;
        r101.getClass();
        Intrinsics.checkNotNullParameter(this, "renderer");
        Intrinsics.checkNotNullParameter(r100, "runtime");
        if (r101.f405565a == null) goto L13;
        int r102 = 0;
        final ArrayList r103 = com.bytedance.rts.kmp.foundation.i.b(new Long[0]);
        Map<Long, j0> r104 = r101.f405565a;
        Intrinsics.checkNotNull(r104);
        com.bytedance.rts.kmp.foundation.j.b(r104, new PendingListUpdates$flush$1(r103));
    L8:
        IntCompanionObject r105 = IntCompanionObject.INSTANCE;
        int r106 = com.bytedance.rts.kmp.foundation.i.a(r103);
        Intrinsics.checkNotNullParameter(r105, "<this>");
        if (r102 >= r106) goto L14;
        r101.a(this, r100, ((Number) ListProtector.get(r103, r102)).longValue());
        r102 = r102 + 1;
        goto L8
    L14:
        return;
    L13:
        return;
    }

    @Override // com.relax.relaxreact.z0
    public final TaskScheduler v() {
        TaskScheduler r100 = this.f405425i;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // com.relax.relaxreact.z0
    public final com.relax.relaxreact.shared.a p() {
        Intrinsics.checkNotNullParameter("updateTriggeredByBts", "pipelineOrigin");
        String r100 = "";
        this.f405424h = "";
        mpa.l r101 = this.f405417a;
        String r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r101 = null;
    L5:
        r101.getClass();
        int r103 = mpa.e.f514751a;
        mpa.k r104 = r101.f514759a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        Object r105 = r104.a().B();
        com.relax.relaxreact.shared.a r106 = new com.relax.relaxreact.shared.a();
        Intrinsics.checkNotNullParameter("updateTriggeredByBts", "<set-?>");
        r106.f405581b = "updateTriggeredByBts";
        Map<String, Object> r107 = n1.b(r105);
        int r108 = com.bytedance.rts.kmp.foundation.g.f267611a;
        Object r109 = com.bytedance.rts.kmp.foundation.g.a.a(r107, "pipelineID");
        if ((r109 instanceof String) == false) goto L8;
        r102 = (String) r109;
    L8:
        if (r102 == null) goto L11;
        r100 = r102;
    L11:
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r106.f405580a = r100;
        return r106;
    }

    public RenderFnRenderer(mpa.l r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        this.f405423g = new LinkedHashMap();
        this.f405424h = "";
        this.f405417a = r100;
        Intrinsics.checkNotNullParameter("page", "tag");
        int r101 = mpa.e.f514751a;
        mpa.k r102 = r100.f514759a;
        Intrinsics.checkNotNullParameter(r102, "renderer");
        Intrinsics.checkNotNullParameter("page", "tag");
        long r103 = r102.a().j();
        this.f405418b = r103;
        this.f405419c = new p(r103);
        mpa.k r104 = r100.f514759a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        this.f405420d = r104.a().q(r103);
        final com.bytedance.rts.kmp.foundation.p r105 = new com.bytedance.rts.kmp.foundation.p(this);
        this.f405425i = new TaskScheduler(new RendererSchedulerBridge(r100), new AnonymousClass1(r105));
    }

    @Override // com.relax.relaxreact.z0
    public final void d(ArrayList<p> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = 0;
    L3:
        IntCompanionObject r102 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = r100.size();
        Intrinsics.checkNotNullParameter(r102, "<this>");
        if (r101 >= r103) goto L6;
        com.bytedance.rts.kmp.foundation.j.a(this.f405423g, Long.valueOf(((p) ListProtector.get(r100, r101)).f405555a));
        r101 = r101 + 1;
        goto L3
    }

    @Override // com.relax.relaxreact.z0
    public final long f(p r100) {
        Intrinsics.checkNotNullParameter(r100, "ele");
        mpa.l r101 = this.f405417a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r101 = null;
    L5:
        long r102 = r100.f405555a;
        r101.getClass();
        int r103 = mpa.e.f514751a;
        mpa.k r104 = r101.f514759a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        return r104.a().q(r102);
    }

    @Override // com.relax.relaxreact.z0
    public final void i(p r100) {
        Intrinsics.checkNotNullParameter(r100, "ele");
        mpa.l r101 = this.f405417a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r101 = null;
    L5:
        long r102 = r100.f405555a;
        r101.getClass();
        int r103 = mpa.e.f514751a;
        mpa.k r104 = r101.f514759a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        r104.a().p(r102);
    }

    @Override // com.relax.relaxreact.z0
    public final <T> T q(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        l0 r101 = this.f405421e;
        if (r101 != null) goto L7;
        return r100.invoke();
    L7:
        return (T) r101.c(r100);
    }

    @Override // com.relax.relaxreact.z0
    public final void w(com.relax.relaxreact.shared.a r100) {
        Intrinsics.checkNotNullParameter(r100, "pipelineOptions");
        mpa.l r101 = this.f405417a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r101 = null;
    L5:
        String r102 = r100.f405580a;
        String r103 = r100.f405581b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "pipelineId");
        Intrinsics.checkNotNullParameter(r103, "pipelineOrigin");
        int r104 = mpa.e.f514751a;
        mpa.k r105 = r101.f514759a;
        Intrinsics.checkNotNullParameter(r105, "renderer");
        Intrinsics.checkNotNullParameter(r102, "pipelineId");
        Intrinsics.checkNotNullParameter(r103, "pipelineOrigin");
        r105.a().G(r102, r103);
    }

    @Override // com.relax.relaxreact.z0
    public final void z(p r100) {
        Intrinsics.checkNotNullParameter(r100, "ele");
        mpa.l r101 = this.f405417a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r101 = null;
    L5:
        long r102 = r100.f405555a;
        r101.getClass();
        Intrinsics.checkNotNullParameter("0 1", "value");
        int r103 = mpa.e.f514751a;
        mpa.k r104 = r101.f514759a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        Intrinsics.checkNotNullParameter("0 1", "value");
        r104.a().L(r102, "0 1".toString());
    }

    @Override // com.relax.relaxreact.z0
    public final void b(String r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        l0 r102 = this.f405421e;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.b(r100, r101);
    }

    @Override // com.relax.relaxreact.z0
    public final void c(p r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "element");
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        mpa.l r102 = this.f405417a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r102 = null;
    L8:
        long r103 = r100.f405555a;
        r102.getClass();
        Intrinsics.checkNotNullParameter("text", "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        int r104 = mpa.e.f514751a;
        mpa.k r105 = r102.f514759a;
        Intrinsics.checkNotNullParameter(r105, "renderer");
        Intrinsics.checkNotNullParameter("text", "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        r105.a().z(r103, "text", r101);
    }

    @Override // com.relax.relaxreact.z0
    public final void g(p r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        mpa.l r102 = this.f405417a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r102 = null;
    L5:
        long r103 = r100.f405555a;
        long r104 = r101.f405555a;
        r102.getClass();
        int r105 = mpa.e.f514751a;
        mpa.k r106 = r102.f514759a;
        Intrinsics.checkNotNullParameter(r106, "renderer");
        r106.a().t(r103, r104);
    }

    @Override // com.relax.relaxreact.z0
    public final void k(p r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        mpa.l r102 = this.f405417a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r102 = null;
    L5:
        long r103 = r100.f405555a;
        long r104 = r101.f405555a;
        r102.getClass();
        int r105 = mpa.e.f514751a;
        mpa.k r106 = r102.f514759a;
        Intrinsics.checkNotNullParameter(r106, "renderer");
        r106.a().h(r103, r104);
    }

    @Override // com.relax.relaxreact.z0
    public final void l(p r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        mpa.l r102 = this.f405417a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r102 = null;
    L5:
        long r103 = r100.f405555a;
        long r104 = r101.f405555a;
        r102.getClass();
        int r105 = mpa.e.f514751a;
        mpa.k r106 = r102.f514759a;
        Intrinsics.checkNotNullParameter(r106, "renderer");
        r106.a().w(r103, r104);
    }

    @Override // com.relax.relaxreact.z0
    public final void u(p r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "ele");
        Intrinsics.checkNotNullParameter("update-list-info", "key");
        mpa.l r102 = null;
        if (Intrinsics.areEqual("update-list-info", "__lynx_timing_flag") == true) goto L5;
    L12:
        mpa.l r103 = this.f405417a;
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
    L16:
        long r104 = r100.f405555a;
        r102.getClass();
        Intrinsics.checkNotNullParameter("update-list-info", "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        int r105 = mpa.e.f514751a;
        mpa.k r106 = r102.f514759a;
        Intrinsics.checkNotNullParameter(r106, "renderer");
        Intrinsics.checkNotNullParameter("update-list-info", "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        r106.a().x(r104, "update-list-info", r101);
        return;
    L15:
        r102 = r103;
        goto L16
    L5:
        if ((r101 instanceof String) == false) goto L7;
        String r107 = (String) r101;
    L8:
        if (r107 == null) goto L12;
        if (Intrinsics.areEqual(r107, "") == true) goto L12;
        this.f405424h = r107;
        goto L12
    L7:
        r107 = null;
        goto L8
    }

    @Override // com.relax.relaxreact.z0
    public final void x(p r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "flushOptions");
        mpa.l r102 = null;
        if ((r101 instanceof com.relax.relaxreact.shared.a) == false) goto L5;
        com.relax.relaxreact.shared.a r103 = (com.relax.relaxreact.shared.a) r101;
    L7:
        if (r103 != null) goto L9;
    L16:
        mpa.l r104 = this.f405417a;
        if (r104 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
    L20:
        long r105 = r100.f405555a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "options");
        int r106 = mpa.e.f514751a;
        mpa.k r107 = r102.f514759a;
        Intrinsics.checkNotNullParameter(r107, "renderer");
        Intrinsics.checkNotNullParameter(r101, "options");
        r107.a().o(r105, r101);
        return;
    L19:
        r102 = r104;
        goto L20
    L9:
        if (Intrinsics.areEqual(r103.f405580a, "") == true) goto L16;
        v0 r108 = new v0(r103, this.f405424h);
        this.f405424h = "";
        mpa.l r109 = this.f405417a;
        if (r109 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
    L14:
        long r110 = r100.f405555a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r108, "options");
        int r111 = mpa.e.f514751a;
        mpa.k r112 = r102.f514759a;
        Intrinsics.checkNotNullParameter(r112, "renderer");
        Intrinsics.checkNotNullParameter(r108, "options");
        r112.a().o(r110, r108);
        return;
    L13:
        r102 = r109;
        goto L14
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.relax.relaxreact.z0
    public final void y(com.relax.relaxreact.shared.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "pipelineOptions");
        Intrinsics.checkNotNullParameter(r101, "timingKey");
        mpa.l r102 = this.f405417a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r102 = null;
    L5:
        String r103 = r100.f405580a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "pipelineId");
        Intrinsics.checkNotNullParameter(r101, "timingKey");
        int r104 = mpa.e.f514751a;
        mpa.k r105 = r102.f514759a;
        Intrinsics.checkNotNullParameter(r105, "renderer");
        Intrinsics.checkNotNullParameter(r103, "pipelineId");
        Intrinsics.checkNotNullParameter(r101, "timingKey");
        r105.a().F(r103, r101);
    }

    @Override // com.relax.relaxreact.z0
    public final void t(p r110, p r111, p r112) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r111, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r112, "beforeChild");
        mpa.l r100 = this.f405417a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r100 = null;
    L5:
        long r101 = r110.f405555a;
        long r102 = r111.f405555a;
        long r103 = r112.f405555a;
        r100.getClass();
        int r113 = mpa.e.f514751a;
        mpa.k r114 = r100.f514759a;
        Intrinsics.checkNotNullParameter(r114, "renderer");
        r114.a().r(r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [mpa.h] */
    /* JADX WARN: Type inference failed for: r9v0, types: [mpa.i] */
    @Override // com.relax.relaxreact.z0
    public final void j(p r110, final Function3<? super Integer, ? super Long, ? super Boolean, Integer> r111, final Function1<? super Long, Unit> r112, Function4<? super ArrayList<Integer>, ? super ArrayList<Long>, ? super Boolean, ? super Boolean, Unit> r113) {
        Intrinsics.checkNotNullParameter(r110, "ele");
        Intrinsics.checkNotNullParameter(r111, "componentAtIndex");
        Intrinsics.checkNotNullParameter(r112, "enqueueComponent");
        final Function5<Long, Long, Integer, Long, Boolean, Integer> r100 = new RenderFnRenderer$updateListCallbacks$componentAtIndexCallback$1(r111);
        final Function3<Long, Long, Long, Unit> r114 = new RenderFnRenderer$updateListCallbacks$enqueueComponentCallback$1(r112);
        final Function6 r115 = __utils.a(r113);
        mpa.l r116 = this.f405417a;
        ComponentAtIndexesCallbackNG r101 = null;
        if (r116 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r116 = null;
    L5:
        long r102 = r110.f405555a;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r100, "componentAtIndex");
        Intrinsics.checkNotNullParameter(r114, "enqueueComponent");
        int r117 = mpa.e.f514751a;
        mpa.k r118 = r116.f514759a;
        Intrinsics.checkNotNullParameter(r118, "renderer");
        Intrinsics.checkNotNullParameter(r100, "componentAtIndex");
        Intrinsics.checkNotNullParameter(r114, "enqueueComponent");
        RendererFunctionNG r103 = r118.a();
        AtomicLong r119 = mpa.j.f514756a;
        ?? r104 = new mpa.h(r100);
        ?? r105 = new mpa.i(r114);
        if (r115 == null) goto L8;
        r101 = new mpa.f(r115);
    L8:
        r103.A(r102, r104, r105, r101);
    }
}
