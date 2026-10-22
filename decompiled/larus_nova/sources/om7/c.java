package om7;

import android.text.TextUtils;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements nm7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f524301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f524302b;

    public c(d r100, CountDownLatch r101) {
        this.f524302b = r100;
        this.f524301a = r101;
    }

    @Override // nm7.a
    public final void a(String r100, String r101) {
        um7.e.b("doGetUnionValue() DataUnionProviderUtils 获取回调; onCallback 结束; value = " + r101);
        if (TextUtils.isEmpty(r101) == true) goto L5;
        this.f524302b.d(r100, r101);
        this.f524301a.countDown();
    L5:
        this.f524301a.countDown();
    }
}
