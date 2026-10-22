package gl5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.operation.net.OperationUploadRequester;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes18.dex */
public final class h extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OperationUploadRequester f481596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f481597c;

    public h() {
        this.f481596b = new OperationUploadRequester((NetService) org.koin.java.a.a(NetService.class));
    }
}
