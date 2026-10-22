package vl2;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.multilink.impl.o1;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l {

    public interface a {
        void a(vl2.a r1);

        void onFail();
    }

    public l() {
    }

    public final void a(final Context r3, final vl2.a r4, final a r5) {
        if (TextUtils.isEmpty(r4.a) == false) goto L5;
    L9:
        if (r5 == null) goto L12;
        r5.onFail();
        return;
    L12:
        return;
    L5:
        if (new PolarisFileWrapper(r4.a).exists() == false) goto L9;
        r4.b++;
        Observable.create(new k(r4.a)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r4, r5, r3), new o1());
    }
}
