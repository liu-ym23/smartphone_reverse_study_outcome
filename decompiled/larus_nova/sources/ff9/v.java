package ff9;

import android.view.View;
import com.larus.audio.call.plugins.CommonVideoAutoTestPlugin;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes30.dex */
public interface v {
    boolean b(boolean r100);

    boolean c(boolean r100);

    void d();

    void e(boolean r100, Function0<Unit> r101, Function1<? super Long, Unit> r102);

    void f(float r100, float r101);

    void g();

    void h(tf9.b r100);

    void i(View r100, boolean r101);

    boolean isCameraTorchSupported();

    int j(tf9.a r100);

    void k();

    void l();

    void o();

    void p();

    void q(CommonVideoAutoTestPlugin.a r100);

    void release();
}
