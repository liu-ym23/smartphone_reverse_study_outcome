package h86;

import java.util.Calendar;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements f86.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.xelement.picker.view.f f484224a;

    public i(com.bytedance.ies.xelement.picker.view.f r100) {
        this.f484224a = r100;
    }

    @Override // f86.d
    public final void onItemSelected(int r100) {
        Calendar r101 = this.f484224a.f250294g;
        int r102 = r101.get(11);
        int r103 = r101.get(12);
        int r104 = this.f484224a.f250292e.get(11);
        int r105 = this.f484224a.f250292e.get(12);
        int r106 = this.f484224a.f250292e.get(13);
        if (r104 != r102) goto L6;
        if (r103 != r105) goto L6;
        r101.set(13, r106 + this.f484224a.f250291d.getCurrentItem());
    L7:
        this.f484224a.a(r101);
        this.f484224a.getClass();
        return;
    L6:
        r101.set(13, this.f484224a.f250291d.getCurrentItem());
        goto L7
    }
}
