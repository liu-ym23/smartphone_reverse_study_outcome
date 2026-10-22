package f83;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.voavhs.head.CommonFindSameElement;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4FindSameIndicator;
import com.bytedance.android.shopping.anchorv4.voavhs.head.t;
import kotlin.Pair;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4FindSameIndicator f475824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.head.base.d f475825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CommonFindSameElement f475826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.dto.business.d f475827d;

    public b(AnchorV4FindSameIndicator r100, t r101, CommonFindSameElement r102, com.bytedance.android.shopping.anchorv4.dto.business.d r103) {
        this.f475824a = r100;
        this.f475825b = r101;
        this.f475826c = r102;
        this.f475827d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r101 = this.f475825b;
        if (r101 == null) goto L15;
        CommonFindSameElement r102 = this.f475826c;
        if (r102 == null) goto L9;
        String r103 = r102.getSchema();
        if (r103 == null) goto L9;
        String r104 = com.bytedance.android.ec.core.btm.c.c(r103, this.f475824a, "a1.b8094.c86220.d28012", new Pair[0]);
    L10:
        com.bytedance.android.shopping.anchorv4.dto.business.d r105 = this.f475827d;
        CommonFindSameElement r106 = this.f475826c;
        if (r106 == null) goto L13;
        Integer r107 = r106.getType();
    L14:
        r101.g(r104, r105, r107);
        goto L15
    L13:
        r107 = null;
    L9:
        r104 = null;
    L15:
        c63.d r108 = this.f475824a.f168731a;
        if (r108 == null) goto L23;
        CommonFindSameElement r109 = this.f475826c;
        if (r109 == null) goto L20;
        Integer r110 = r109.getType();
    L21:
        r108.m(1, null, r110);
        return;
    L20:
        r110 = null;
        goto L21
    }
}
