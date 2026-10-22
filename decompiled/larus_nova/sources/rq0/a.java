package rq0;

import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.e;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements com.bytedance.android.live.openplatform.api.model.shelf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShelfCardInfo f538918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f538919b;

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final Pair<Integer, String> a(String r100) {
        return this.f538918a.a(r100);
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final String b() {
        return this.f538918a.b();
    }

    public final String c(String r100) {
        return this.f538918a.k(r100);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f538918a, r101.f538918a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f538919b, r101.f538919b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final long getCardId() {
        return this.f538918a.getCardId();
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final ProductInfo getProductInfo() {
        return this.f538918a.getProductInfo();
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final long getStatus() {
        return this.f538918a.getStatus();
    }

    public final int hashCode() {
        ShelfCardInfo r100 = this.f538918a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        e r104 = this.f538919b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AudienceShelfDisplayCardInfo(shelfCardInfo=" + this.f538918a + ", shelfCardSupplementInfo=" + this.f538919b + ")";
    }

    public a(ShelfCardInfo r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "shelfCardInfo");
        this.f538918a = r100;
        this.f538919b = r101;
    }
}
