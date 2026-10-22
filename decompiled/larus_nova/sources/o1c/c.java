package o1c;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.preload.v2.condition.ConditionSet;
import java.util.Map;

/* JADX INFO: loaded from: classes37.dex */
public interface c<P, T> extends Runnable, Comparable<c<?, ?>> {

    public interface a {
        void b(c<?, ?> r100, int r101, Map<String, ? extends Object> r102);

        void e(c<?, ?> r100, int r101);

        void g(c<?, ?> r100);

        void k(c r100, boolean r101, Map r102);

        void m(c r100, Map r101);
    }

    ConditionSet C1();

    void J0(e1c.a r100);

    void J1(P r100, IGetDataCallback<?> r101);

    void K(e1c.d r100);

    void L(ConditionSet r100);

    long L0();

    void N0(boolean r100);

    d R();

    void S(int r100);

    boolean T0();

    void b0(IGetDataCallback<?> r100);

    void e1(ConditionSet r100);

    int f0();

    Biz getBiz();

    int getPriority();

    String getTaskId();

    void h1(P r100);

    boolean isInterrupted();

    Object j(Object r100);

    void k(boolean r100);

    void o0(ConditionSet r100);

    ConditionSet p0();

    void s1();

    void setPriority(int r100);

    ConditionSet w0();

    void y0(long r100);
}
