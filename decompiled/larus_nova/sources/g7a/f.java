package g7a;

import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollView;

/* JADX INFO: loaded from: classes32.dex */
public final class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxBaseScrollView f480347a;

    @Override // g7a.g
    public final int getScrollX() {
        LynxBaseScrollView r100 = this.f480347a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getScrollOffsetHorizontally();
    }

    @Override // g7a.g
    public final int getScrollY() {
        LynxBaseScrollView r100 = this.f480347a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getScrollOffsetVertically();
    }

    public f(LynxBaseScrollView r100) {
        this.f480347a = r100;
    }

    @Override // g7a.g
    public final void scrollTo(int r100, int r101) {
        LynxBaseScrollView r102 = this.f480347a;
        if (r102 == null) goto L6;
        r102.f(new int[]{r100, r101});
        return;
    }
}
