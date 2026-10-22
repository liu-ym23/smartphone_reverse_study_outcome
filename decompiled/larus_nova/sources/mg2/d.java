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

/* JADX INFO: loaded from: classes10.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f513706a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f513707a = null;

        public a() {
        }

        static {
            f513707a = new a();
        }
    }

    static {
        f513706a = a.f513707a;
    }

    void C8();

    void L3(LayerDescriptorList r100, boolean r101, boolean r102, boolean r103);

    void a(f70.b r100, j70.f r101);

    void b(f70.b r100, LayerDescriptorList r101);

    void c(f70.b r100, LayerDescriptorList r101, boolean r102);

    void c5(com.bytedance.android.live.core.tetris.componentx.schedule.c r100, q r101);

    void d(f70.b r100, h<? extends h70.b> r101);

    void e();

    IComponentManager f(f70.b r100);

    void g(com.bytedance.android.live.core.tetris.componentx.schedule.c r100, ComponentSchedulingManager.ScenInfo r101, LinkedHashMap r102, e0 r103, j r104, q r105);

    Lifecycle getLifecycle();

    boolean h();

    <T extends LayerDelegate<? extends i70.a, ? extends h70.b>> T o4(f70.b r100, LayerIndex r101);

    void q6(List<? extends j70.f> r100, Map<f70.b, List<j70.f>> r101);

    void release();
}
