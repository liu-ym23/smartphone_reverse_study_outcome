package h86;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements f86.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.xelement.picker.view.d f484217a;

    public c(com.bytedance.ies.xelement.picker.view.d r100) {
        this.f484217a = r100;
    }

    @Override // f86.d
    public final void onItemSelected(int r100) {
        int r101 = this.f484217a.f250271c.getCurrentItem();
        com.bytedance.ies.xelement.picker.view.d r102 = this.f484217a;
        int r103 = r102.f250273e;
        int r104 = r100 + r103;
        r102.f250279k = r104;
        int r105 = r102.f250274f;
        if (r103 != r105) goto L5;
        int r106 = r102.f250275g;
        int r107 = r102.f250276h;
    L11:
        r102.f250271c.setAdapter(new b86.b(r106, r107));
        int r108 = this.f484217a.f250271c.getAdapter().getItemsCount() - 1;
        if (r101 <= r108) goto L14;
        this.f484217a.f250271c.setCurrentIndex(r108);
        r101 = r108;
    L14:
        int r109 = r106 + r101;
        com.bytedance.ies.xelement.picker.view.d r110 = this.f484217a;
        r110.f250280l = r109;
        r110.c(false, r104, r109, r110.f250281m);
        this.f484217a.getClass();
        return;
    L5:
        if (r104 != r103) goto L7;
        r106 = r102.f250275g;
    L10:
        r107 = 12;
        goto L11
    L7:
        if (r104 != r105) goto L9;
        r107 = r102.f250276h;
        r106 = 1;
        goto L11
    L9:
        r106 = 1;
        goto L10
    }
}
