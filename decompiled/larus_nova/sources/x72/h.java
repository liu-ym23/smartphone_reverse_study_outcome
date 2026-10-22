package x72;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.o0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.common.utility.Lists;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements b {
    public h() {
    }

    @Override // x72.b
    public final boolean a(a r100, k32.a r101) {
        if (r101 == null) goto L12;
        va.a r102 = r101.f501694k;
        if (r102 == null) goto L12;
        if (r102.getText() == null) goto L12;
        a5 r103 = r102.getText();
        if (Lists.isEmpty(sb2.a.d(r103)) == true) goto L12;
        ALogger.d("TextParseInterceptor", "intercept message due to downloading img");
        new o0().a(sb2.a.d(r103), new f(this, r100, r101));
        return true;
    L12:
        return r100.a(r101);
    }

    public static void b(h r100, b.a r101, k32.a r102) {
        r100.getClass();
        Observable.just(0).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(r101, r102));
    }
}
