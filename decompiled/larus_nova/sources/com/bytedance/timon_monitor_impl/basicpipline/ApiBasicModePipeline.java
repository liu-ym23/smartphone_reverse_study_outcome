package com.bytedance.timon_monitor_impl.basicpipline;

import com.bytedance.timon.pipeline.TimonSystem;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.timonbase.utils.TMThreadUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/timon_monitor_impl/basicpipline/ApiBasicModePipeline;", "Lcom/bytedance/timonbase/pipeline/TimonPipeline;", "Ldh7/c;", "entity", "", "preInvoke", "postInvoke", "<init>", "()V", "AsyncReportPipeline", "timon-monitor-impl_release"}, k = 1, mv = {1, 4, 0})
public final class ApiBasicModePipeline extends TimonPipeline {
    public static final ApiBasicModePipeline INSTANCE = null;

    public static final class AsyncReportPipeline extends TimonPipeline {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f270738a = 0;

        public AsyncReportPipeline() {
            super("AsyncReportPipeline");
        }

        @Override // com.bytedance.timonbase.pipeline.TimonPipeline, com.bytedance.timon.pipeline.TimonSystem
        public final boolean postInvoke(final dh7.c r100) {
            TMThreadUtils r101 = TMThreadUtils.f270906d;
            Function0<Unit> r102 = new ApiBasicModePipeline$AsyncReportPipeline$postInvoke$1(this, r100);
            r101.getClass();
            TMThreadUtils.a(r102);
            return true;
        }

        @Override // com.bytedance.timonbase.pipeline.TimonPipeline, com.bytedance.timon.pipeline.TimonSystem
        public final boolean preInvoke(final dh7.c r100) {
            TMThreadUtils r101 = TMThreadUtils.f270906d;
            Function0<Unit> r102 = new ApiBasicModePipeline$AsyncReportPipeline$preInvoke$1(this, r100);
            r101.getClass();
            TMThreadUtils.a(r102);
            return true;
        }
    }

    static {
        ApiBasicModePipeline r100 = new ApiBasicModePipeline();
        INSTANCE = r100;
        TimonPipeline.addSystem$default(r100, new a(), null, false, null, 14, null);
        TimonPipeline.addSystem$default(r100, new BasicSkipFilterSystem(), "BasicFastPass", false, null, 12, null);
        TimonPipeline.addSystem$default(r100, new d(), "BasicSkipFilterSystem", false, null, 12, null);
        TimonPipeline.addSystem$default(r100, new AheadCacheSystem(), "BasicSkipFilterSystem", false, AnonymousClass1.INSTANCE, 4, null);
        RuleEngineHardCodeSystem r101 = RuleEngineHardCodeSystem.f270743d;
        TimonSystem.InvokeType r102 = TimonSystem.InvokeType.PRE_INVOKE;
        TimonSystem r110 = dh7.e.a(r101, r102);
        TimonSystem.InvokeType r103 = TimonSystem.InvokeType.POST_INVOKE;
        TimonSystem r104 = dh7.e.a(r101, r103);
        AsyncReportPipeline r105 = new AsyncReportPipeline();
        TimonPipeline.addSystem$default(r105, r104, null, false, null, 14, null);
        e r111 = e.f270748a;
        TimonPipeline.addSystem$default(r105, r111, r104.name(), false, null, 12, null);
        TimonPipeline.addSystem$default(r105, new c(), r104.name(), false, null, 12, null);
        AsyncReportPipeline r112 = new AsyncReportPipeline();
        TimonPipeline.addSystem$default(r112, r111, null, false, null, 14, null);
        TimonPipeline.addSystem$default(r112, new c(), null, false, null, 14, null);
        TimonPipeline.addSystem$default(r100, CollectionsKt.listOf(new TimonSystem[]{r110, dh7.e.a(r105, r103)}), "BasicSkipFilterSystem", false, AnonymousClass2.INSTANCE, 4, null);
        TimonPipeline.addSystem$default(r100, dh7.e.a(r112, r102), r110.name(), false, null, 12, null);
        r100.markInitialed();
    }

    private ApiBasicModePipeline() {
        super("ApiBasicModePipeline");
    }

    @Override // com.bytedance.timonbase.pipeline.TimonPipeline, com.bytedance.timon.pipeline.TimonSystem
    public boolean postInvoke(final dh7.c r100) {
        if (getInitialed().get() == true) goto L5;
        return false;
    L5:
        traverseSystem("pipeline_root", new C106581(r100));
        return false;
    }

    @Override // com.bytedance.timonbase.pipeline.TimonPipeline, com.bytedance.timon.pipeline.TimonSystem
    public boolean preInvoke(final dh7.c r100) {
        if (getInitialed().get() == true) goto L5;
        return false;
    L5:
        traverseSystem("pipeline_root", new C106591(r100));
        return false;
    }
}
