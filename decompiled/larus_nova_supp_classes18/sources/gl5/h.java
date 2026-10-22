package gl5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.operation.net.OperationUploadRequester;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h extends a {
    public final OperationUploadRequester b;
    public Disposable c;

    public h() {
        this.b = new OperationUploadRequester((NetService) org.koin.java.a.a(NetService.class));
    }
}
