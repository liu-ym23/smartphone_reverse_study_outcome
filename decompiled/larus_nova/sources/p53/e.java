package p53;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductSkuStruct;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PromotionProductSkuStruct> f527774a;

    public e() {
        this(new ArrayList());
    }

    public e(List<PromotionProductSkuStruct> r100) {
        Intrinsics.checkNotNullParameter(r100, "skuInfoList");
        this.f527774a = r100;
    }
}
