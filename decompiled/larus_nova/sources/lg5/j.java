package lg5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.BatchAuthorizeActivity;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BatchAuthorizeActivity f509151a;

    public j(BatchAuthorizeActivity r100) {
        this.f509151a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Boolean r100) {
        Boolean r101 = r100;
        tt5.a.b("BatchAuthorizeActivity", "getHasPages onchanges " + r101);
        this.f509151a.f233120m.b(0, false);
        this.f509151a.f233120m.g(r101.booleanValue());
    }
}
