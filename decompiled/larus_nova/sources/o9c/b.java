package o9c;

import com.bytedance.lark.pb.ugreach.v1.LocalRule;
import com.bytedance.lark.pb.ugreach.v1.ScenarioContext;
import com.ss.android.lark.ug.integrator.UgReachSdkIntegrator;
import com.ss.android.lark.ug.scheduler.common.entity.ReachPointState;
import java.util.Collection;

/* JADX INFO: loaded from: classes38.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f522512a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f522513a = null;

        static {
            f522513a = new a();
        }

        public a() {
        }
    }

    static {
        f522512a = a.f522513a;
    }

    boolean b(q9c.a r100, LocalRule r101);

    void c(UgReachSdkIntegrator.e r100);

    void clear();

    void d(ReachPointState r100, Collection<String> r101);

    void f(UgReachSdkIntegrator.e r100);

    void g(ScenarioContext r100);
}
