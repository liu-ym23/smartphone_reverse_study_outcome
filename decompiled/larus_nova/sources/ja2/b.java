package ja2;

import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenIndividualPriorityState;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public interface b {

    public interface a {
        void a(f<?> r100, int r101);

        void b();

        void c(f<?> r100);
    }

    void a();

    f<?> b(Function1<? super f<?>, Boolean> r100);

    int c();

    void clearAll();

    int d();

    void e(Function1<? super f<?>, Unit> r100);

    void f(PublicScreenIndividualPriorityState r100);

    int g();

    void h(f<?> r100, boolean r101, boolean r102);

    int i();

    void j(Function1<? super f<?>, Boolean> r100);

    long k();

    List<f<?>> l(ka2.a r100);

    void m(long r100);

    void onLoad();

    void onUnload();
}
