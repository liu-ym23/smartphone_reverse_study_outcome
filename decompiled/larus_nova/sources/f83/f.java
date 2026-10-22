package f83;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4FoldableTabIndicator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f475841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f475842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AnchorV4FoldableTabIndicator f475843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f475844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ List f475845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ List f475846f;

    public f(n r100, int r101, AnchorV4FoldableTabIndicator r102, List r103, List r104, List r105) {
        this.f475841a = r100;
        this.f475842b = r101;
        this.f475843c = r102;
        this.f475844d = r103;
        this.f475845e = r104;
        this.f475846f = r105;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f475841a.f475857a = true;
        m r101 = this.f475843c.f168748o;
        if (r101 == null) goto L6;
        r101.a(this.f475842b);
        return;
    }
}
