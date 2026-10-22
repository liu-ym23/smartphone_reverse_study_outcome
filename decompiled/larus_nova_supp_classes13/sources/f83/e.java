package f83;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4FoldableTabIndicator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ n a;
    public final /* synthetic */ int b;
    public final /* synthetic */ AnchorV4FoldableTabIndicator c;
    public final /* synthetic */ List d;
    public final /* synthetic */ List e;
    public final /* synthetic */ List f;

    public e(n r1, int r2, AnchorV4FoldableTabIndicator r3, List r4, List r5, List r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.a = true;
        m r3 = this.c.o;
        if (r3 == null) goto L6;
        r3.a(this.b);
        return;
    }
}
