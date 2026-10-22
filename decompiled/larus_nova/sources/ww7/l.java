package ww7;

import android.os.Looper;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes23.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f561673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile IPushInvoke f561674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f561675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r f561676d;

    public l(g r100) {
        this.f561673a = new AtomicInteger(1);
        this.f561675c = r100;
    }

    public final void a(int r100) {
        g r101 = this.f561675c;
        if (r101 == null) goto L9;
        y0.a r102 = (y0.a) r101;
        if (Looper.myLooper() != r102.f561733f.f561726a.getLooper()) goto L7;
        r102.b(HonorPushErrorEnum.fromCode(r100));
        return;
    L7:
        r102.f561733f.f561726a.post(new x0(r102, r100));
        return;
    }
}
