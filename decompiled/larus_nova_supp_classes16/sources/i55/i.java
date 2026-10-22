package i55;

import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import io.reactivex.disposables.CompositeDisposable;
import m75.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface i<V extends m75.e> extends m75.d<V> {
    void a(ImportFileEntity r1);

    void b();

    String c();

    void d();

    void g(LiveData<ConnectionService.NetworkState> r1);

    CompositeDisposable getCompositeDisposable();

    void r();
}
