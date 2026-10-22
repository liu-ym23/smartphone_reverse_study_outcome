package gp4;

import com.bytedance.ee.bear.bitable.card.view.BitableCardFragment;
import com.bytedance.ee.bear.bitable.loading.BitableLoadingWrapper;
import com.bytedance.ee.util.observer.DiffObserver;

/* JADX INFO: loaded from: classes15.dex */
public final class f extends DiffObserver<Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitableCardFragment f482012b;

    public f(BitableCardFragment r100) {
        this.f482012b = r100;
    }

    @Override // com.bytedance.ee.util.observer.DiffObserver
    public final void a(Boolean r100) {
        Boolean r101 = r100;
        tt5.a.h("BitableCardFragment", "first record page drew=" + r101);
        if (Boolean.TRUE.equals(r101) == false) goto L6;
        this.f482012b.aS(BitableLoadingWrapper.LoadingState.SUC);
        return;
    }
}
