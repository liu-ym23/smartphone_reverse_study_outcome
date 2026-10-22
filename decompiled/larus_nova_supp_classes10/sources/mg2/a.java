package mg2;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.tetris.ComponentManagerFactory;
import com.bytedance.android.live.core.tetris.IComponentManager;
import com.bytedance.android.live.core.tetris.componentx.ComponentManager;
import com.bytedance.android.live.core.tetris.componentx.schedule.BatchTogetherConditionManager;
import com.bytedance.android.live.core.tetris.componentx.schedule.ComponentSchedulingManager;
import com.bytedance.android.live.core.tetris.componentx.schedule.j;
import com.bytedance.android.live.core.tetris.componentx.schedule.q;
import com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import j70.h;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements d {
    public final h70.b b;
    public final IComponentManager c;

    @Override // mg2.d
    public final boolean h() {
        return true;
    }

    @Override // mg2.d
    public final void C8() {
        this.c.C8();
    }

    @Override // mg2.d
    public final void e() {
        ALogger.i("ComponentX_Batch_Condition", "updateRoomEnterSuccessCondition currentTimeMillis = " + System.currentTimeMillis());
        this.c.rq(BatchTogetherConditionManager.BatchLoadConditionType.END_ROOM_ENTER);
    }

    @Override // mg2.d
    public final Lifecycle getLifecycle() {
        return this.c.getLifecycle();
    }

    @Override // mg2.d
    public final void release() {
        this.c.release();
    }

    public a(ComponentManager r2) {
        Intrinsics.checkNotNullParameter(r2, "combineLayerManager");
        this.c = r2;
        com.bytedance.android.live.core.tetris.componentx.a r3 = r2.r;
        if (r3 == null) goto L5;
        h70.b r4 = r3.getComponentContext();
    L6:
        this.b = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // mg2.d
    public final IComponentManager f(f70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerType");
        return this.c;
    }

    public final Element<?> j(j70.f r2) {
        Intrinsics.checkNotNullParameter(r2, "elementType");
        return this.c.f2(r2);
    }

    public final void k(h<? extends h70.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        this.c.X7(r2);
    }

    public final void m(j70.f r2) {
        Intrinsics.checkNotNullParameter(r2, "elementType");
        this.c.dl(r2);
    }

    @Override // mg2.d
    public final void a(f70.b r2, j70.f r3) {
        Intrinsics.checkNotNullParameter(r2, "layerType");
        Intrinsics.checkNotNullParameter(r3, "elementType");
        this.c.dl(r3);
    }

    @Override // mg2.d
    public final void b(f70.b r2, LayerDescriptorList r3) {
        Intrinsics.checkNotNullParameter(r2, "layerType");
        Intrinsics.checkNotNullParameter(r3, "descriptorList");
        i(r2, r3);
        this.c.dd(r3);
    }

    @Override // mg2.d
    public final void c5(com.bytedance.android.live.core.tetris.componentx.schedule.c r2, q r3) {
        Intrinsics.checkNotNullParameter(r2, "conditionConfig");
        this.c.c5(r2, r3);
    }

    @Override // mg2.d
    public final void d(f70.b r3, h<? extends h70.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "layerType");
        Intrinsics.checkNotNullParameter(r4, "descriptor");
        if ((!Intrinsics.areEqual(r4.L(), r3)) == false) goto L5;
        f70.b r0 = r4.L();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r4.b = r3;
        l(r0, r3, r4);
    L5:
        this.c.X7(r4);
    }

    public final void i(f70.b r4, LayerDescriptorList r5) {
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        h<? extends h70.b> r0 = (h) r6.next();
        if ((!Intrinsics.areEqual(r0.L(), r4)) == false) goto L4;
        f70.b r1 = r0.L();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.b = r4;
        l(r1, r4, r0);
        goto L4
    }

    @Override // mg2.d
    public final <T extends LayerDelegate<? extends i70.a, ? extends h70.b>> T o4(f70.b r2, LayerIndex r3) {
        Intrinsics.checkNotNullParameter(r2, "layerType");
        Intrinsics.checkNotNullParameter(r3, "layerIndex");
        return (T) this.c.o4(r2, r3);
    }

    @Override // mg2.d
    public final void q6(List<? extends j70.f> r2, Map<f70.b, List<j70.f>> r3) {
        Intrinsics.checkNotNullParameter(r2, "refreshFreeComponents");
        this.c.q6(r2, r3);
    }

    @Override // mg2.d
    public final void c(f70.b r3, LayerDescriptorList r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "layerType");
        Intrinsics.checkNotNullParameter(r4, "descriptorList");
        i(r3, r4);
        this.c.L3(r4, true, r5, false);
    }

    public final void l(f70.b r6, f70.b r7, h<? extends h70.b> r8) {
        h70.b r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r8 instanceof h) == true) goto L7;
        r8 = null;
    L7:
        if (r8 == null) goto L9;
        j70.f r9 = r8.C(r0);
    L10:
        if (r9 == null) goto L20;
        com.bytedance.android.live.core.tetris.componentx.a r1 = this.c.config();
        if (r1 == null) goto L17;
        ComponentManagerFactory.config.1.a r2 = r1.getLogger();
        if (r2 == null) goto L17;
        r2.b("LiveLayerType error, element is " + r9 + ", origin is " + r6 + ", update is " + r7);
    L17:
        SafetyGuard.a(null, null, "LiveLayerType error, element is " + r9);
        return;
    L20:
        return;
    L9:
        r9 = null;
        goto L10
    }

    @Override // mg2.d
    public final void L3(LayerDescriptorList r2, boolean r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "descriptorList");
        this.c.L3(r2, r3, r4, r5);
    }

    @Override // mg2.d
    public final void g(com.bytedance.android.live.core.tetris.componentx.schedule.c r9, ComponentSchedulingManager.ScenInfo r10, LinkedHashMap r11, e0 r12, j r13, q r14) {
        Intrinsics.checkNotNullParameter(r9, "conditionConfig");
        Intrinsics.checkNotNullParameter(r10, "scene");
        Intrinsics.checkNotNullParameter(r11, "backgroundMap");
        Intrinsics.checkNotNullParameter(r12, "layerContext");
        Intrinsics.checkNotNullParameter(r13, LocationMonitorConst.INFO);
        Intrinsics.checkNotNullParameter(r14, "endAllComponentLoad");
        this.c.iS(r9, r10, r11, r12, r13, r14);
    }
}
