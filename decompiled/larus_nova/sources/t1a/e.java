package t1a;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import t1a.c;

/* JADX INFO: loaded from: classes31.dex */
public interface e<T extends c> {

    public static final class a {
        public static /* synthetic */ void a(e r100, boolean r101, Function1 r102) {
            r100.b(new d(), r101, r102);
        }
    }

    void a(Function1<? super T, ? extends T> r100);

    void b(Function2<? super T, ? super T, Boolean> r100, boolean r101, Function1<? super T, Unit> r102);

    void destroy();

    T getSource();
}
