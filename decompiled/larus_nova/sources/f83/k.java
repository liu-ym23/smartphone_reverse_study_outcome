package f83;

import com.bytedance.android.shopping.anchorv4.voavhs.head.CommonFindSameElement;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4DownTabIndicator;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4HeadIndicator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnchorV4HeadIndicator f475855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnchorV4DownTabIndicator f475856b;

    @Override // f83.l
    public final CommonFindSameElement getFindSameElement() {
        CommonFindSameElement r100 = this.f475855a.getFindSameElement();
        if (r100 != null) goto L9;
        AnchorV4DownTabIndicator r101 = this.f475856b;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.getFindSameElement();
    L9:
        return r100;
    }

    public k(AnchorV4HeadIndicator r100) {
        Intrinsics.checkNotNullParameter(r100, "headIndicator");
        this.f475855a = r100;
        this.f475856b = null;
    }

    @Override // f83.l
    public final void a(boolean r100) {
        this.f475855a.a(r100);
        AnchorV4DownTabIndicator r101 = this.f475856b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // f83.l
    public final void h(boolean r100) {
        this.f475855a.h(r100);
        AnchorV4DownTabIndicator r101 = this.f475856b;
        if (r101 == null) goto L6;
        r101.h(r100);
        return;
    }

    @Override // f83.l
    public final void c(List<String> r100, List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "titleTags");
        Intrinsics.checkNotNullParameter(r101, "originTags");
        Intrinsics.checkNotNullParameter(r102, "tabTypes");
        this.f475855a.c(r100, r101, r102);
        AnchorV4DownTabIndicator r103 = this.f475856b;
        if (r103 == null) goto L6;
        r103.c(r100, r101, r102);
        return;
    }

    @Override // f83.l
    public final void b(Integer r100, int r101, String r102, boolean r103) {
        this.f475855a.b(r100, r101, r102, r103);
        AnchorV4DownTabIndicator r104 = this.f475856b;
        if (r104 == null) goto L6;
        r104.b(r100, r101, r102, r103);
        return;
    }
}
