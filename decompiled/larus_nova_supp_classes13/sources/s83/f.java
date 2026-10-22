package s83;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.l;
import io.reactivex.Observable;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface f {
    void a(Context r1, String r2, String r3, ViewGroup r4);

    void b(String r1, String r2);

    void c(Context r1, List r2, String r3, String r4, ViewGroup r5, Function1 r6);

    void d(l r1);

    void e(String r1);

    void f(ECVideoPlayerView r1);

    void g(String r1);

    void getDuration(String r1);

    void h(String r1);

    void i();

    void j();

    void k();

    Observable<Boolean> l(List<String> r1);

    void m(String r1, String r2);

    void n(String r1);

    void o(String r1);

    void p(String r1, ViewGroup r2);

    void q(String r1);

    void r(String r1);
}
