package uu1;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import java.util.List;
import java.util.Map;
import ju1.c;
import ju1.h;
import ju1.l;
import ju1.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes8.dex */
public interface b {
    <T> void a(DynamicFactor<T> r100);

    void b(List<? extends DynamicFactor<? extends Object>> r100);

    void c(iu1.b r100);

    void destroy();

    n e(String r100);

    List<DynamicFactor<?>> f();

    Map<String, n> g();

    List<l> getSceneList();

    void h(String r100);

    long i();

    List<h> j();

    void k(Function2<? super String, ? super n, Unit> r100);

    List<c<Object>> m();

    List<iu1.b> o();

    void p(String r100, Object r101);

    void prepare();

    Map<String, Object> q();
}
