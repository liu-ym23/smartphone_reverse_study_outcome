package f83;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4FoldableTabIndicator;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ n a;
    public final /* synthetic */ AnchorV4FoldableTabIndicator b;
    public final /* synthetic */ List c;
    public final /* synthetic */ List d;
    public final /* synthetic */ List e;

    public g(n r1, AnchorV4FoldableTabIndicator r2, List r3, List r4, List r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        this.b.a.setVisibility(8);
        this.b.b.setVisibility(0);
        this.a.b = true;
        c63.d r7 = this.b.getLogAction();
        if (r7 == null) goto L11;
        HashMap<Integer, String> r1 = com.bytedance.android.shopping.anchorv4.voavhs.head.c.J;
        Object r2 = this.b.l;
        if (r2 != null) goto L7;
        r2 = -1;
    L7:
        String r3 = r1.get(r2);
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        c63.d.a.a(r7, "expand", r3, null, 12);
    L11:
        AnchorV4FoldableTabIndicator r8 = this.b;
        r8.d(r8.k, r8.l, true);
    }
}
