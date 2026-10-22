package f83;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.voavhs.head.CommonFindSameElement;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4FindSameIndicator;
import com.bytedance.android.shopping.anchorv4.voavhs.head.t;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ AnchorV4FindSameIndicator a;
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.head.base.d b;
    public final /* synthetic */ CommonFindSameElement c;
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.dto.business.d d;

    public b(AnchorV4FindSameIndicator r1, t r2, CommonFindSameElement r3, com.bytedance.android.shopping.anchorv4.dto.business.d r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r7 = this.b;
        if (r7 == null) goto L15;
        CommonFindSameElement r1 = this.c;
        if (r1 == null) goto L9;
        String r2 = r1.getSchema();
        if (r2 == null) goto L9;
        String r3 = com.bytedance.android.ec.core.btm.c.c(r2, this.a, "a1.b8094.c86220.d28012", new Pair[0]);
    L10:
        com.bytedance.android.shopping.anchorv4.dto.business.d r4 = this.d;
        CommonFindSameElement r5 = this.c;
        if (r5 == null) goto L13;
        Integer r8 = r5.getType();
    L14:
        r7.g(r3, r4, r8);
        goto L15
    L13:
        r8 = null;
    L9:
        r3 = null;
    L15:
        c63.d r9 = this.a.a;
        if (r9 == null) goto L23;
        CommonFindSameElement r10 = this.c;
        if (r10 == null) goto L20;
        Integer r11 = r10.getType();
    L21:
        r9.m(1, null, r11);
        return;
    L20:
        r11 = null;
        goto L21
    }
}
