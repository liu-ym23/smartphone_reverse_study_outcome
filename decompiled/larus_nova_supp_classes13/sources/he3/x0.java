package he3;

import com.bytedance.android.shopping.infeed.data.idl.HeaderBannerItemType;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class x0 {
    public HeaderBannerItemType a;
    public InFeedUrlModel b;
    public qe3.a c;
    public int d;
    public String e;
    public int f;
    public int g;
    public h h;

    public x0() {
        this.a = HeaderBannerItemType.Image;
        this.d = -1;
        this.f = -1;
    }

    public final HeaderBannerItemType getType() {
        return this.a;
    }

    public final void a(HeaderBannerItemType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }
}
