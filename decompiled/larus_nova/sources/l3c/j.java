package l3c;

import com.ss.android.lark.scaffold.Component;
import com.ss.android.lark.scaffold.PagePlugin;
import com.ss.android.lark.scaffold.ScaffoldDsl;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes38.dex */
@ScaffoldDsl
public interface j {
    void a(Function1<? super d, ? extends c> r100);

    void b(Function1<? super b, ? extends Component> r100);

    void c(int r100, Function1<? super b, ? extends Component> r101);

    void d(Function1<? super h, ? extends List<? extends PagePlugin>> r100);

    <T> void e(Class<T> r100, Function1<? super e, ? extends T> r101);

    void f(Function1<? super d, ? extends List<? extends c>> r100);

    <T extends g> void g(Class<T> r100, Function1<? super k, ? extends T> r101);
}
