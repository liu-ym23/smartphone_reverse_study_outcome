package n86;

import android.content.Context;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends OverScroller {
    public c(Context r100, b r101) {
        super(r100, r101);
    }

    @Override // android.widget.OverScroller
    public final void startScroll(int r100, int r101, int r110, int r111, int r112) {
        super.startScroll(r100, r101, r110, r111, Math.min(300, r112));
    }
}
