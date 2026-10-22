package wl1;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.comment.ReplayCommentPresenter;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class a<T> implements Observer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f560167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveTracingMonitor.EventModule f560168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Observer<T> f560169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f560170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f560171e;

    @Override // io.reactivex.Observer
    public final void onComplete() {
        Observer<T> r100 = this.f560169c;
        if (r100 == null) goto L6;
        r100.onComplete();
        return;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r110) {
        if ((r110 instanceof CustomApiServerException) == false) goto L5;
        CustomApiServerException r100 = (CustomApiServerException) r110;
        int r101 = r100.getErrorCode();
        String r102 = r100.getXTtLogId();
        String r103 = "CustomApiServerException(" + r100.getErrorMsg() + ")";
    L18:
        long r104 = System.currentTimeMillis();
        long r105 = this.f560170d;
        if (r105 <= 0) goto L31;
        LiveMonitor.a r106 = new LiveMonitor.a(this.f560167a, this.f560168b);
        r106.j(r104 - r105);
        r106.l(r101);
        r106.i("status_msg", r103);
        r106.i("log_id", r102);
        r106.i("status_code", Integer.valueOf(r101));
        r106.i("duration", Long.valueOf(r104 - this.f560170d));
        Map<String, String> r107 = this.f560171e;
        if (r107 == null) goto L30;
        Iterator<Map.Entry<String, String>> r108 = r107.entrySet().iterator();
    L24:
        if (r108.hasNext() == false) goto L30;
        Map.Entry<String, String> r109 = r108.next();
        if (r109.getKey() == null) goto L24;
        if (r109.getValue() == null) goto L24;
        r106.i(r109.getKey(), r109.getValue());
    L30:
        r106.a().report();
    L31:
        Observer<T> r111 = this.f560169c;
        if (r111 == null) goto L42;
        r111.onError(r110);
        return;
    L42:
        return;
    L5:
        r102 = null;
        if ((r110 instanceof ApiServerException) == false) goto L9;
        ApiServerException r112 = (ApiServerException) r110;
        String r113 = "ApiServerException(" + r112.getErrorMsg() + ")";
        r101 = r112.getErrorCode();
        r103 = r113;
        goto L18
    L9:
        if ((r110 instanceof ApiException) == false) goto L12;
        ApiException r114 = (ApiException) r110;
        r101 = r114.getErrorCode();
        r103 = "ApiException(" + r114.getMessage() + ")";
        goto L18
    L12:
        if ((r110 instanceof IOException) == false) goto L14;
        r103 = "IOException(" + r110.getMessage() + ")";
        r101 = 103;
        goto L18
    L14:
        r101 = -1;
        if (r110 == null) goto L17;
        r103 = r110.getMessage();
        goto L18
    L17:
        r103 = null;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Observer
    public final void onNext(T r110) {
        long r100 = System.currentTimeMillis();
        long r101 = this.f560170d;
        if (r101 <= 0) goto L21;
        String r102 = null;
        if ((r110 instanceof BaseResponse) == false) goto L9;
        BaseResponse r103 = (BaseResponse) r110;
        String r104 = r103.logId;
        int r105 = r103.statusCode;
        RequestError r106 = r103.error;
        if (r106 == null) goto L10;
        r102 = r106.message;
    L10:
        LiveMonitor.a r107 = new LiveMonitor.a(this.f560167a, this.f560168b);
        r107.j(r100 - r101);
        r107.l(r105);
        r107.i("status_msg", r102);
        r107.i("log_id", r104);
        r107.i("status_code", Integer.valueOf(r105));
        r107.i("duration", Long.valueOf(r100 - this.f560170d));
        Map<String, String> r108 = this.f560171e;
        if (r108 == null) goto L20;
        Iterator<Map.Entry<String, String>> r109 = r108.entrySet().iterator();
    L14:
        if (r109.hasNext() == false) goto L20;
        Map.Entry<String, String> r111 = r109.next();
        if (r111.getKey() == null) goto L14;
        if (r111.getValue() == null) goto L14;
        r107.i(r111.getKey(), r111.getValue());
    L20:
        r107.a().report();
        goto L21
    L9:
        r105 = 0;
        r104 = null;
    L21:
        Observer<T> r112 = this.f560169c;
        if (r112 == null) goto L32;
        r112.onNext(r110);
        return;
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        this.f560170d = System.currentTimeMillis();
        Observer<T> r101 = this.f560169c;
        if (r101 == null) goto L6;
        r101.onSubscribe(r100);
        return;
    }

    public a(String r100, LiveTracingMonitor.EventModule r101) {
        this.f560167a = r100;
        this.f560168b = r101;
    }

    public a(String r100, LiveTracingMonitor.EventModule r101, ReplayCommentPresenter.a r102) {
        this.f560167a = r100;
        this.f560168b = r101;
        this.f560169c = r102;
    }
}
