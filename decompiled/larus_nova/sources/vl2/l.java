package vl2;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.multilink.impl.o1;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: classes10.dex */
public final class l {

    public interface a {
        void a(vl2.a r100);

        void onFail();
    }

    public l() {
    }

    public final void a(final Context r100, final vl2.a r101, final a r102) {
        if (TextUtils.isEmpty(r101.f555633a) == false) goto L5;
    L9:
        if (r102 == null) goto L12;
        r102.onFail();
        return;
    L12:
        return;
    L5:
        if (new PolarisFileWrapper(r101.f555633a).exists() == false) goto L9;
        r101.f555634b++;
        Observable.create(new k(r101.f555633a)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r101, r102, r100), new o1());
    }
}
