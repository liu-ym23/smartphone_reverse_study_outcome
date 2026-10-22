package h86;

import java.util.Calendar;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements f86.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.xelement.picker.view.f f484223a;

    public h(com.bytedance.ies.xelement.picker.view.f r100) {
        this.f484223a = r100;
    }

    @Override // f86.d
    public final void onItemSelected(int r100) {
        Calendar r101 = this.f484223a.f250294g;
        int r102 = r101.get(11);
        int r103 = this.f484223a.f250292e.get(11);
        int r104 = this.f484223a.f250292e.get(12);
        if (r103 != r102) goto L5;
        r101.set(12, r104 + this.f484223a.f250290c.getCurrentItem());
    L6:
        this.f484223a.a(r101);
        this.f484223a.getClass();
        return;
    L5:
        r101.set(12, this.f484223a.f250290c.getCurrentItem());
        goto L6
    }
}
