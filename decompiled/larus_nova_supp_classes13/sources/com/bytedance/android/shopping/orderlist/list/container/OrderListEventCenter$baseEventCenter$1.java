package com.bytedance.android.shopping.orderlist.list.container;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.orderlist.common.controller.OrderCommonPageConfig;
import com.bytedance.android.shopping.orderlist.common.controller.OrderCommonScrollStrategyController;
import com.bytedance.android.shopping.orderlist.common.controller.l;
import com.bytedance.android.shopping.orderlist.common.controller.o;
import com.bytedance.android.shopping.orderlist.common.controller.p;
import com.bytedance.android.shopping.orderlist.common.controller.q;
import com.bytedance.android.shopping.orderlist.common.controller.w;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.OrderSelfRegisterBridgeFunction$onExecuteAsync$1;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.j0;
import com.bytedance.android.shopping.orderlist.common.freq.OrderFreqControlManager;
import com.bytedance.android.shopping.orderlist.list.tracker.OrderListTracker;
import com.bytedance.android.shopping.orderlist.list.widget.linkedlist.OrderListLinkedScrollView;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListEventCenter$baseEventCenter$1 implements com.bytedance.android.shopping.orderlist.common.eventcenter.core.a {
    public final /* synthetic */ d a;

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void F0() {
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void B0() {
        nj.d r0 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r0 == null) goto L6;
        Activity r1 = this.a.c;
        r0.n();
        return;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final OrderFreqControlManager C0() {
        return (OrderFreqControlManager) this.a.d.C.getValue();
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final c53.d D0() {
        return this.a.d;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final com.bytedance.android.shopping.orderlist.common.monitor.error.a E0() {
        return this.a.e.getTracker();
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final boolean G0() {
        return this.a.d.o;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final eg3.b H0() {
        return this.a.d.E;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final Map<String, Map<String, Object>> P0() {
        return this.a.e.getCustomDynamicParams();
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void Q0() {
        c r0 = this.a.d.I;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void R0() {
        if (this.a.e.isSplitMode() == false) goto L7;
        nj.d r0 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r0 == null) goto L9;
        Activity r1 = this.a.c;
        r0.m();
        return;
    L9:
        return;
    L7:
        int r2 = com.bytedance.android.shopping.orderlist.common.utils.c.a;
        com.bytedance.android.shopping.orderlist.common.utils.c.a(this.a.d);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final ig3.a S0() {
        Map<String, ig3.a> r0 = ig3.a.h;
        return ig3.a.C0206a.a(getCurrentSessionId());
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final View T0() {
        return this.a.d.getView();
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final SlcRenderContext f() {
        return this.a.d.l;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final String getCurrentSessionId() {
        return this.a.e.getStaticState().b;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void t0() {
        this.a.g.n();
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void w0() {
        final OrderListRequestType r0 = OrderListRequestType.NORMAL;
        c r1 = this.a.d.I;
        if (r1 == null) goto L6;
        new OrderListEventCenter$baseEventCenter$1$operateSuccessToRefresh$1(this, r0);
        OrderListEventCenter$baseEventCenter$1$operateSuccessToRefresh$2 r2 = OrderListEventCenter$baseEventCenter$1$operateSuccessToRefresh$2.INSTANCE;
        r1.l(r0);
        return;
    }

    public OrderListEventCenter$baseEventCenter$1(d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void A0(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "newData");
        this.a.e.updateSchemaMap(r2);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void I0(j0 r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        this.a.e.getStaticState().o = r2;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void J0(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        ((ArrayList) this.a.d.p).add(r2);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void K0(float r2) {
        this.a.g.m(r2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v5 java.lang.String
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void M0(org.json.JSONObject r8) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v5 java.lang.String
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.shopping.orderlist.list.container.OrderListEventCenter$baseEventCenter$1.M0(org.json.JSONObject):void");
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void O0(JSONObject r9) {
        Intrinsics.checkNotNullParameter(r9, "param");
        if ((!Intrinsics.areEqual(r9.optString("sku_session_id"), this.a.e.getStaticState().b)) == false) goto L5;
        return;
    L5:
        Map<String, Object> r0 = l.b;
        if (r0 == null) goto L8;
        Object r1 = r0.get("event_name");
    L9:
        String r5 = String.valueOf(r1);
        Intrinsics.checkNotNullParameter("listSkuPanelItemRefresh", "default");
        JSONObject r2 = r9.optJSONObject("response");
        if (r2 == null) goto L13;
        String r3 = r2.toString();
        if (r3 == null) goto L13;
    L14:
        r9.put("response", r3);
        AndroidYaTaInstance r4 = this.a.f;
        if (r4 == null) goto L20;
        YataEventCenter r6 = r4.k();
        if (r6 == null) goto L21;
        r6.d(com.bytedance.kmp.ec.yata.event.common.e.a.a(this.a.f, null, l.a, r5, com.bytedance.android.shopping.orderlist.common.utils.l.a(r9), "operateCartAdd"));
        return;
    L21:
        return;
    L20:
        return;
    L13:
        r3 = "";
        goto L14
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void U0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "bridgeName");
        ti.j r0 = this.a.e.getStaticState().w.remove(r2);
        if (r0 == null) goto L6;
        ECLiveHybridUtil.p(r2, r0);
        return;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void u0(int r2) {
        c r0 = this.a.d.I;
        if (r0 == null) goto L6;
        r0.u0(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void z0(com.bytedance.kmp.ec.yata.store.node.c r9) {
        OrderListFragment r0 = this.a.d;
        OrderListLinkedScrollView r1 = r0.v;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkedScrollView");
    L5:
        RecyclerView r2 = r1.getYataRecyclerView();
        AndroidYaTaInstance r3 = r0.k;
        RecyclerView.LayoutManager r4 = null;
        if (r3 == null) goto L8;
        List r5 = r3.n("body");
    L9:
        boolean r6 = false;
        if (r5 == null) goto L24;
        Iterator r7 = r5.iterator();
        int r8 = 0;
    L13:
        if (r7.hasNext() == false) goto L22;
        String r10 = ((com.bytedance.kmp.ec.yata.store.node.c) r7.next()).getKey();
        if (r9 == null) goto L17;
        String r11 = r9.getKey();
    L19:
        if (Intrinsics.areEqual(r10, r11) == true) goto L23;
        r8 = r8 + 1;
    L23:
        Integer r12 = Integer.valueOf(r8);
    L25:
        if (r12 != null) goto L27;
        return;
    L27:
        if (r12.intValue() < 0) goto L29;
        r6 = true;
    L29:
        if (r6 == true) goto L32;
        r12 = null;
    L32:
        if (r12 == null) goto L48;
        int r13 = r12.intValue();
        final Context r14 = r0.getContext();
        LinearSmoothScroller r15 = new OrderListFragment$scrollWithView$$inlined$let$lambda$1(r14);
        r15.setTargetPosition(r13);
        if (r2 == null) goto L36;
        RecyclerView.LayoutManager r16 = r2.getLayoutManager();
    L38:
        if ((r16 instanceof LinearLayoutManager) == false) goto L41;
        r4 = r16;
    L41:
        LinearLayoutManager r17 = (LinearLayoutManager) r4;
        if (r17 == null) goto L49;
        r17.startSmoothScroll(r15);
        return;
    L49:
        return;
    L36:
        r16 = null;
        goto L38
    L48:
        return;
    L17:
        r11 = null;
        goto L19
    L22:
        r8 = -1;
        goto L23
    L24:
        r12 = null;
        goto L25
    L8:
        r5 = null;
        goto L9
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void L0(String r2, w r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "scrollStrategy");
        ((OrderCommonScrollStrategyController) this.a.a.getValue()).a(r2, r3);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void N0(String r3, String r4) {
        OrderListTracker.ChangeTabType r0 = OrderListTracker.ChangeTabType.SLIDE;
        if (Intrinsics.areEqual(r3, r0.getValue()) == true) goto L6;
        r0 = OrderListTracker.ChangeTabType.CLICK;
    L6:
        c r5 = this.a.d.I;
        if (r5 == null) goto L10;
        r5.m(r0, r4);
        return;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void v0(int r4, boolean r5) {
        OrderListFragment r0 = this.a.d;
        r0.getClass();
        int r6 = SlcDimensExtensionsKt.a(Integer.valueOf(r4), OrderCommonPageConfig.b(false));
        if (r5 == false) goto L8;
        OrderListLinkedScrollView r7 = r0.v;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("linkedScrollView");
    L7:
        r7.getYataRecyclerView().smoothScrollBy(0, r6);
        return;
    L8:
        OrderListLinkedScrollView r8 = r0.v;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("linkedScrollView");
    L11:
        r8.getYataRecyclerView().scrollBy(0, r6);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void x0(String r5, o r6) {
        Intrinsics.checkNotNullParameter(r6, "chainEvent");
        OrderListFragment r1 = this.a.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "chainEvent");
        p r2 = (p) r1.D.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "chainEvent");
        if (r5 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L16;
        Map<String, o> r3 = (Map) ((LinkedHashMap) r2.a).get(r5);
        if (r3 != null) goto L14;
        r3 = new LinkedHashMap();
    L14:
        r3.put(r6.a + '_' + r6.b, r6);
        r2.a.put(r5, r3);
        q r7 = new q(r2, r5);
        r2.b.put(r5, r7);
        ECLiveHybridUtil.m(r5, r7);
        return;
    L16:
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void y0(String r2, OrderSelfRegisterBridgeFunction$onExecuteAsync$1.a r3) {
        Intrinsics.checkNotNullParameter(r2, "bridgeName");
        Intrinsics.checkNotNullParameter(r3, "subscriber");
        this.a.e.getStaticState().w.put(r2, r3);
    }
}
