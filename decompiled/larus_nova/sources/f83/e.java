package f83;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4FoldableTabIndicator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f475835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f475836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AnchorV4FoldableTabIndicator f475837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f475838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ List f475839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ List f475840f;

    public e(n r100, int r101, AnchorV4FoldableTabIndicator r102, List r103, List r104, List r105) {
        this.f475835a = r100;
        this.f475836b = r101;
        this.f475837c = r102;
        this.f475838d = r103;
        this.f475839e = r104;
        this.f475840f = r105;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f475835a.f475857a = true;
        m r101 = this.f475837c.f168748o;
        if (r101 == null) goto L6;
        r101.a(this.f475836b);
        return;
    }
}
