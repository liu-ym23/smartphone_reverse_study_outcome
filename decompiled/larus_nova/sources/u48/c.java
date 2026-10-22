package u48;

import com.larus.share.impl.view.k0;
import com.larus.share.service.IShareDoubaoForwardService;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements mpc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IShareDoubaoForwardService.a f548714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<kw9.a> f548715b;

    @Override // mpc.b
    public final void onSuccess() {
        this.f548714a.a((kw9.a) CollectionsKt.singleOrNull(this.f548715b));
    }

    public c(k0 r100, List r101) {
        this.f548714a = r100;
        this.f548715b = r101;
    }

    @Override // mpc.b
    public final void onFailure(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        this.f548714a.onFailure(Integer.valueOf(r100), r101);
    }
}
