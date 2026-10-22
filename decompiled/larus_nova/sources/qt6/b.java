package qt6;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.locallife.dito.data.k;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ Object a(b r100, String r101, boolean r110, Class r111, List r112, String r113, String r114) {
            return r100.a(r101, r110, r111, r112, r113, null, r114);
        }
    }

    <T> T a(String r100, boolean r101, Class<T> r102, List<? extends Interceptor> r103, String r104, Converter.Factory r105, String r106);

    <T> T b(String r100, Class<T> r101, List<? extends Interceptor> r102);

    Object c(Bundle r100, k r101);

    <T> T create(String r100, Class<T> r101);

    Object d(Map r100);

    Map<String, String> e(Uri r100);

    Map<String, String> f(String r100, Map<String, String> r101);

    void g(String r100, String r101, Function1<? super String, Unit> r102);

    void h();

    String i(Bundle r100);

    void j(Throwable r100);

    Map k();

    Map<String, String> l(Map<String, String> r100);

    void m();

    Object n(Bundle r100);
}
