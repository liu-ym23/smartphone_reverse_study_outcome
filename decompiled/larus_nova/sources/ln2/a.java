package ln2;

import android.view.View;
import android.widget.HorizontalScrollView;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HorizontalScrollView f509994a;

    @Override // ln2.b
    public final boolean a() {
        return !this.f509994a.canScrollHorizontally(-1);
    }

    @Override // ln2.b
    public final boolean b() {
        return !this.f509994a.canScrollHorizontally(1);
    }

    @Override // ln2.b
    public final View getView() {
        return this.f509994a;
    }

    public a(HorizontalScrollView r100) {
        this.f509994a = r100;
    }
}
