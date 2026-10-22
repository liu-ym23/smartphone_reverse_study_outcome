package ec0;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public interface a {
    boolean a();

    boolean b();

    long c();

    void clearData();

    boolean d();

    MusicPanel e();

    void f(LifecycleOwner r100, Observer<Boolean> r101);

    boolean g();

    boolean h();

    void i();

    void j();

    void k();

    boolean l();

    void m(MusicPanel r100);

    Disposable n(Consumer<fd2.a> r100);

    long o();

    void p(LifecycleOwner r100, Observer<Boolean> r101);

    void q(boolean r100);

    void r(LifecycleOwner r100, Observer<Boolean> r101);

    void s(Context r100);
}
