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
import j70.h;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface d {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        a = a.a;
    }

    void C8();

    void L3(LayerDescriptorList r1, boolean r2, boolean r3, boolean r4);

    void a(f70.b r1, j70.f r2);

    void b(f70.b r1, LayerDescriptorList r2);

    void c(f70.b r1, LayerDescriptorList r2, boolean r3);

    void c5(com.bytedance.android.live.core.tetris.componentx.schedule.c r1, q r2);

    void d(f70.b r1, h<? extends h70.b> r2);

    void e();

    IComponentManager f(f70.b r1);

    void g(com.bytedance.android.live.core.tetris.componentx.schedule.c r1, ComponentSchedulingManager.ScenInfo r2, LinkedHashMap r3, e0 r4, j r5, q r6);

    Lifecycle getLifecycle();

    boolean h();

    <T extends LayerDelegate<? extends i70.a, ? extends h70.b>> T o4(f70.b r1, LayerIndex r2);

    void q6(List<? extends j70.f> r1, Map<f70.b, List<j70.f>> r2);

    void release();
}
