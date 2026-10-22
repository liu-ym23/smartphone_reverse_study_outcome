package h83;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.m;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECUrlModel f484080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECUrlModel f484081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Link f484082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f484083e;

    public d() {
        this(null, null, null, null, null);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final List<ECUrlModel> b() {
        return CollectionsKt.listOfNotNull(this.f484080b);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final ECUrlModel a() {
        return this.f484080b;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final String getDescription() {
        return this.f484083e;
    }

    public d(String r100, ECUrlModel r101, ECUrlModel r102, Link r103, String r104) {
        this.f484079a = r100;
        this.f484080b = r101;
        this.f484081c = r102;
        this.f484082d = r103;
        this.f484083e = r104;
    }
}
