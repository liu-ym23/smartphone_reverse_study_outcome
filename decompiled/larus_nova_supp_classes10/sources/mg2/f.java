package mg2;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.tetris.IComponentManager;
import com.bytedance.android.live.core.tetris.componentx.schedule.ComponentSchedulingManager;
import com.bytedance.android.live.core.tetris.componentx.schedule.j;
import com.bytedance.android.live.core.tetris.componentx.schedule.q;
import com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import j70.h;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements d {
    public final IComponentManager b;
    public final IComponentManager c;

    @Override // mg2.d
    public final void L3(LayerDescriptorList r1, boolean r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "descriptorList");
    }

    @Override // mg2.d
    public final void c5(com.bytedance.android.live.core.tetris.componentx.schedule.c r1, q r2) {
        Intrinsics.checkNotNullParameter(r1, "conditionConfig");
    }

    @Override // mg2.d
    public final void e() {
    }

    @Override // mg2.d
    public final void g(com.bytedance.android.live.core.tetris.componentx.schedule.c r2, ComponentSchedulingManager.ScenInfo r3, LinkedHashMap r4, e0 r5, j r6, q r7) {
        Intrinsics.checkNotNullParameter(r2, "conditionConfig");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "backgroundMap");
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        Intrinsics.checkNotNullParameter(r6, LocationMonitorConst.INFO);
        Intrinsics.checkNotNullParameter(r7, "endAllComponentLoad");
    }

    @Override // mg2.d
    public final boolean h() {
        return false;
    }

    @Override // mg2.d
    public final void q6(List<? extends j70.f> r1, Map<f70.b, List<j70.f>> r2) {
        Intrinsics.checkNotNullParameter(r1, "refreshFreeComponents");
    }

    @Override // mg2.d
    public final void C8() {
        this.b.C8();
        this.c.C8();
    }

    @Override // mg2.d
    public final Lifecycle getLifecycle() {
        return this.b.getLifecycle();
    }

    @Override // mg2.d
    public final void release() {
        this.b.release();
        this.c.release();
    }

    @Override // mg2.d
    public final IComponentManager f(f70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerType");
        if (Intrinsics.areEqual(r2, e.c) == false) goto L6;
        return this.c;
    L6:
        return this.b;
    }

    public f(IComponentManager r2, IComponentManager r3) {
        Intrinsics.checkNotNullParameter(r2, "layerManager");
        Intrinsics.checkNotNullParameter(r3, "fontLayerManager");
        this.b = r2;
        this.c = r3;
    }

    @Override // mg2.d
    public final void a(f70.b r2, j70.f r3) {
        Intrinsics.checkNotNullParameter(r2, "layerType");
        Intrinsics.checkNotNullParameter(r3, "elementType");
        f(r2).dl(r3);
    }

    @Override // mg2.d
    public final void b(f70.b r2, LayerDescriptorList r3) {
        Intrinsics.checkNotNullParameter(r2, "layerType");
        Intrinsics.checkNotNullParameter(r3, "descriptorList");
        f(r2).dd(r3);
    }

    @Override // mg2.d
    public final void d(f70.b r2, h<? extends h70.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "layerType");
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        f(r2).X7(r3);
    }

    @Override // mg2.d
    public final <T extends LayerDelegate<? extends i70.a, ? extends h70.b>> T o4(f70.b r2, LayerIndex r3) {
        Intrinsics.checkNotNullParameter(r2, "layerType");
        Intrinsics.checkNotNullParameter(r3, "layerIndex");
        return (T) f(r2).o4(r2, r3);
    }

    @Override // mg2.d
    public final void c(f70.b r3, LayerDescriptorList r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "layerType");
        Intrinsics.checkNotNullParameter(r4, "descriptorList");
        f(r3).L3(r4, true, r5, false);
    }
}
