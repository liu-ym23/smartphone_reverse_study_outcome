package h86;

import java.util.Calendar;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements f86.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.xelement.picker.view.f f484222a;

    public g(com.bytedance.ies.xelement.picker.view.f r100) {
        this.f484222a = r100;
    }

    @Override // f86.d
    public final void onItemSelected(int r100) {
        Calendar r101 = this.f484222a.f250294g;
        r101.set(2000, 0, 1);
        int r102 = this.f484222a.f250292e.get(11) + this.f484222a.f250289b.getCurrentItem();
        if (r102 < 24) goto L5;
        r101.set(11, r102 - 24);
        r101.add(5, 1);
    L6:
        this.f484222a.a(r101);
        this.f484222a.getClass();
        return;
    L5:
        r101.set(11, r102);
        goto L6
    }
}
