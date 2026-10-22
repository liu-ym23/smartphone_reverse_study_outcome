package zn;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.window.shop.home.presenter.ECWindowLinkageHeaderLivePresenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes44.dex */
public interface c<T> {
    void a(LifecycleOwner r100, Observer<T> r101, boolean r102);

    void b(Observer<T> r100);

    void c(T r100);

    void d(LifecycleOwner r100);

    void e(LifecycleOwner r100, ECWindowLinkageHeaderLivePresenter.c r101);

    T getValue();

    void setValue(T r100);
}
