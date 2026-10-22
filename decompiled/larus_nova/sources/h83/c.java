package h83;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.CombinationVO;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.m;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECUrlModel f484075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CombinationVO f484076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f484077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f484078d;

    public c() {
        this(null, null, null, true);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final List<ECUrlModel> b() {
        return CollectionsKt.listOfNotNull(this.f484075a);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final ECUrlModel a() {
        return this.f484075a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final String getDescription() {
        return this.f484077c;
    }

    public c(ECUrlModel r100, CombinationVO r101, String r102, boolean r103) {
        this.f484075a = r100;
        this.f484076b = r101;
        this.f484077c = r102;
        this.f484078d = r103;
    }
}
