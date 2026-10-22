package f83;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4FoldableTabIndicator;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f475847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnchorV4FoldableTabIndicator f475848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f475849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f475850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ List f475851e;

    public g(n r100, AnchorV4FoldableTabIndicator r101, List r102, List r103, List r104) {
        this.f475847a = r100;
        this.f475848b = r101;
        this.f475849c = r102;
        this.f475850d = r103;
        this.f475851e = r104;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f475848b.f168734a.setVisibility(8);
        this.f475848b.f168735b.setVisibility(0);
        this.f475847a.f475858b = true;
        c63.d r101 = this.f475848b.getLogAction();
        if (r101 == null) goto L11;
        HashMap<Integer, String> r102 = com.bytedance.android.shopping.anchorv4.voavhs.head.c.f168527J;
        Object r103 = this.f475848b.f168745l;
        if (r103 != null) goto L7;
        r103 = -1;
    L7:
        String r104 = r102.get(r103);
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        c63.d.a.a(r101, BitableAnalytic.LinkSceneClickType.EXPAND, r104, null, 12);
    L11:
        AnchorV4FoldableTabIndicator r105 = this.f475848b;
        r105.d(r105.f168744k, r105.f168745l, true);
    }
}
