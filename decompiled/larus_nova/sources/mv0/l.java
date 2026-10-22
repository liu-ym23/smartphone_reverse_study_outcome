package mv0;

import com.bytedance.android.livesdk.ktvapi.IKtvService;

/* JADX INFO: loaded from: classes47.dex */
public final class l extends qs0.a<IKtvService> implements qs0.j {
    public l() {
        super(jc1.k.n(IKtvService.class));
    }

    @Override // qs0.j
    public final boolean isInKtvState(int r100) {
        return ((IKtvService) this.f534640a).isInKtvState(r100);
    }
}
