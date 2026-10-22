package us4;

import com.bytedance.ee.bear.bitable.homepage.preview.NetError;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f551486a;

    public e(a r100) {
        this.f551486a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if ((r101 instanceof NetError) == false) goto L5;
        NetError r102 = (NetError) r101;
        int r103 = r102.getErrorCode();
        String r104 = r102.getErrorMsg();
    L9:
        j.b(null);
        this.f551486a.f551481a.postValue(null);
        int r105 = a.f551480c;
        tt5.a.e("BitableBoostDataSource", "loadBoostData>> errorCode:" + r103 + ". errorMsg:" + r104, r101, false);
        return;
    L5:
        int r106 = a.f551480c;
        r104 = r101.getMessage();
        if (r104 != null) goto L8;
        r104 = "unknown";
    L8:
        r103 = -1;
        goto L9
    }
}
