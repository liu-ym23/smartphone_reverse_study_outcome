package mv0;

import android.app.Activity;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s extends qs0.a<ILiveVideoFloatWindowService> implements qs0.q {
    public s() {
        super(jc1.k.n(ILiveVideoFloatWindowService.class));
    }

    @Override // qs0.q
    public final void b(Activity r100, qs0.p r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "extra");
        ILiveVideoFloatWindowService r102 = (ILiveVideoFloatWindowService) this.f534640a;
        InnerContextEntity.InnerFloatExtra r103 = new InnerContextEntity.InnerFloatExtra();
        r103.setRequestPage(r101.f534641a);
        r102.startShowFloatInNextLifecycle(r100, r103);
    }
}
