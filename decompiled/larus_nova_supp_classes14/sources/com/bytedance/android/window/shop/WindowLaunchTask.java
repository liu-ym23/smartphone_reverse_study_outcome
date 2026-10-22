package com.bytedance.android.window.shop;

import com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode;
import com.bytedance.android.ec.window.base.common.taskgraph.ProcessorNode;
import com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.TimePointProcessorNode;
import com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider;
import com.bytedance.android.window.shop.repository.vo.ShopComponentResponseVO;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowLaunchTask {
    public static final ao.b<Unit, Unit> a = null;
    public static final com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c<Unit, Unit> b = null;
    public static final ao.b<Unit, Unit> c = null;
    public static final com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c<Unit, WindowTabInfoProvider> d = null;
    public static final com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c<Unit, uq3.a> e = null;
    public static final com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c<Unit, ShopComponentResponseVO> f = null;
    public static final com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c<WindowTabInfoProvider, Unit> g = null;
    public static final com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c<uq3.a, Unit> h = null;
    public static final com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c<ShopComponentResponseVO, Unit> i = null;
    public static final ao.b<Unit, Unit> j = null;
    public static final ao.b<Unit, Unit> k = null;
    public static final ao.b<Unit, Unit> l = null;
    public static final ao.b<Unit, Unit> m = null;

    static {
        a = new ao.b("window_source");
        b = new com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c("window_create");
        c = new ao.b("window_create_done");
        d = new com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c("window_tab");
        e = new com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c("window_header");
        f = new com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c("window_component");
        g = new com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c("tab_render");
        h = new com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c("header_render");
        i = new com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c("component_render");
        j = new ao.b("tab_render_done");
        k = new ao.b("header_render_done");
        l = new ao.b("component_render_done");
        m = new ao.b("window_done");
    }

    public static com.bytedance.android.ec.window.base.common.taskgraph.b a(CoroutineScope r17) {
        Intrinsics.checkNotNullParameter(r17, "coroutineScope");
        com.bytedance.android.ec.window.base.common.taskgraph.b r3 = new com.bytedance.android.ec.window.base.common.taskgraph.b(new ao.a(0));
        final com.bytedance.android.ec.window.base.common.taskgraph.context.processor.impl.c r1 = new com.bytedance.android.ec.window.base.common.taskgraph.context.processor.impl.c();
        List r4 = CollectionsKt.listOf(r1);
        Intrinsics.checkNotNullParameter(r4, "processors");
        ao.a r6 = r3.e;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r4, "processors");
        do.a r7 = r6.b;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r4, "processors");
        r7.a.addAll(r4);
        com.bytedance.android.ec.window.base.common.taskgraph.c r5 = new com.bytedance.android.ec.window.base.common.taskgraph.c(a, WindowLaunchTask$makeWindowPipeline$windowSourceNode$1.INSTANCE);
        TimePointProcessorNode r8 = new TimePointProcessorNode(b);
        eo.a r9 = new eo.a(c, WindowLaunchTask$makeWindowPipeline$windowCreateDoneNode$1.INSTANCE, null);
        TimePointProcessorNode r10 = new TimePointProcessorNode(d);
        TimePointProcessorNode r11 = new TimePointProcessorNode(e);
        TimePointProcessorNode r12 = new TimePointProcessorNode(f);
        ProcessorNode r13 = new TimePointProcessorNode(h);
        ProcessorNode r14 = new TimePointProcessorNode(g);
        ProcessorNode r15 = new TimePointProcessorNode(i);
        eo.a r16 = new eo.a(j, WindowLaunchTask$makeWindowPipeline$tabSinkNode$1.INSTANCE, null);
        eo.a r2 = new eo.a(k, WindowLaunchTask$makeWindowPipeline$headerSinkNode$1.INSTANCE, null);
        eo.a r0 = new eo.a(l, WindowLaunchTask$makeWindowPipeline$componentSinkNode$1.INSTANCE, null);
        com.bytedance.android.ec.window.base.common.taskgraph.d r18 = new com.bytedance.android.ec.window.base.common.taskgraph.d(m, new WindowLaunchTask$makeWindowPipeline$allDoneNode$1(r1));
        r5.d(r8);
        r8.f(r9);
        r5.d(r11);
        r11.d(r13);
        r13.f(r2);
        r5.d(r10);
        r5.d(r12);
        com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector.c.a(r11, r10, WindowLaunchTask$makeWindowPipeline$5.INSTANCE).d(r14);
        r14.f(r16);
        com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector.c.a(r10, r12, WindowLaunchTask$makeWindowPipeline$6.INSTANCE).d(r15);
        r15.f(r0);
        WindowLaunchTask$makeWindowPipeline$7 r19 = WindowLaunchTask$makeWindowPipeline$7.INSTANCE;
        Intrinsics.checkNotNullParameter(r13, "processorNodeA");
        Intrinsics.checkNotNullParameter(r14, "processorNodeB");
        Intrinsics.checkNotNullParameter(r15, "processorNodeC");
        Intrinsics.checkNotNullParameter(r19, "transformer");
        com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector.a r20 = new com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector.a(new ao.b(com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector.c.b(new ProcessorNode[]{r13, r14, r15})), r19);
        Intrinsics.checkNotNullParameter(r13, "nodeA");
        Intrinsics.checkNotNullParameter(r14, "nodeB");
        Intrinsics.checkNotNullParameter(r15, "nodeC");
        r13.d((PipelineNode) ((com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector.d) r20.j).a);
        r14.d((PipelineNode) ((com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector.d) r20.j).b);
        r15.d((PipelineNode) r20.j.c);
        r20.f(r18);
        r3.a(r5, Unit.INSTANCE, r17);
        return r3;
    }
}
