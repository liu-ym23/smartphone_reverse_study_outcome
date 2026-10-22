package f83;

import com.bytedance.android.shopping.anchorv4.voavhs.head.CommonFindSameElement;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4DownTabIndicator;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4HeadIndicator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements l {
    public final AnchorV4HeadIndicator a;
    public final AnchorV4DownTabIndicator b;

    @Override // f83.l
    public final CommonFindSameElement getFindSameElement() {
        CommonFindSameElement r0 = this.a.getFindSameElement();
        if (r0 != null) goto L9;
        AnchorV4DownTabIndicator r1 = this.b;
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getFindSameElement();
    L9:
        return r0;
    }

    public k(AnchorV4HeadIndicator r2) {
        Intrinsics.checkNotNullParameter(r2, "headIndicator");
        this.a = r2;
        this.b = null;
    }

    @Override // f83.l
    public final void a(boolean r2) {
        this.a.a(r2);
        AnchorV4DownTabIndicator r0 = this.b;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // f83.l
    public final void h(boolean r2) {
        this.a.h(r2);
        AnchorV4DownTabIndicator r0 = this.b;
        if (r0 == null) goto L6;
        r0.h(r2);
        return;
    }

    @Override // f83.l
    public final void c(List<String> r2, List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "titleTags");
        Intrinsics.checkNotNullParameter(r3, "originTags");
        Intrinsics.checkNotNullParameter(r4, "tabTypes");
        this.a.c(r2, r3, r4);
        AnchorV4DownTabIndicator r0 = this.b;
        if (r0 == null) goto L6;
        r0.c(r2, r3, r4);
        return;
    }

    @Override // f83.l
    public final void b(Integer r2, int r3, String r4, boolean r5) {
        this.a.b(r2, r3, r4, r5);
        AnchorV4DownTabIndicator r0 = this.b;
        if (r0 == null) goto L6;
        r0.b(r2, r3, r4, r5);
        return;
    }
}
