package hu2;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.model.GetCertificationEntranceResponse;
import com.bytedance.android.livesdk.verify.VerifyActivityProxy;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerifyActivityProxy f487212a;

    public b(VerifyActivityProxy r100) {
        this.f487212a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        if (r101 == null) goto L6;
        VerifyActivityProxy r102 = this.f487212a;
        GetCertificationEntranceResponse r103 = (GetCertificationEntranceResponse) r101.data;
        r102.f159249c = r103.zhima_entrance;
        r102.f159250d = r103.manual_entrance;
        VerifyActivityProxy.b(r102);
        return;
    }
}
