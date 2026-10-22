package r4;

import android.content.Context;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes43.dex */
public interface h {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(h r100, String r101, String r102, String r103, Map r110, int r111) {
            if ((r111 & 8) == 0) goto L5;
            r110 = null;
        L5:
            r100.d(r101, r102, r103, r110, null);
        }
    }

    Object a(Context r100, String r101, Continuation<? super Boolean> r102);

    void b(String r100, String r101);

    Object c(String r100, int r101, String r102, String r103, Continuation<? super Boolean> r104);

    void d(String r100, String r101, String r102, Map<String, String> r103, Function0<Unit> r104);

    Object e(String r100, Continuation<? super String> r101);

    Object f(String r100, String r101, String r102, String r103, Continuation<? super Boolean> r104);

    void g(Map<String, String> r100, Function0<Unit> r101);

    Object h(j2.b r100, Continuation<? super Boolean> r101);

    void i(String r100, String r101, String r102, List<j2.a> r103, List<String> r104, List<String> r105);

    j2.a j(j2.b r100);

    void k(String r100, String r101);

    void l(String r100, String r101);

    void m(String r100, String r101, String r102);
}
