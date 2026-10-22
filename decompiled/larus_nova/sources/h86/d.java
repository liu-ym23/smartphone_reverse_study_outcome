package h86;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements f86.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.xelement.picker.view.d f484218a;

    public d(com.bytedance.ies.xelement.picker.view.d r100) {
        this.f484218a = r100;
    }

    @Override // f86.d
    public final void onItemSelected(int r100) {
        com.bytedance.ies.xelement.picker.view.d r101 = this.f484218a;
        int r102 = r101.f250279k;
        int r103 = 1;
        if (r102 != r101.f250273e) goto L5;
        int r104 = r101.f250275g;
    L6:
        int r105 = r104 + r100;
        r101.f250280l = r105;
        r101.c(false, r102, r105, r101.f250281m);
        com.bytedance.ies.xelement.picker.view.d r106 = this.f484218a;
        int r107 = r106.f250273e;
        int r108 = r106.f250274f;
        if (r107 == r108) goto L9;
    L11:
        if (r102 == r107) goto L13;
    L15:
        if (r102 == r108) goto L17;
    L19:
        int r109 = 31;
    L20:
        int r110 = com.bytedance.ies.xelement.picker.view.d.a(r102, r105, r109);
        com.bytedance.ies.xelement.picker.view.d r111 = this.f484218a;
        r111.b(false, r111.f250272d.getCurrentItem(), r103, r110);
        this.f484218a.getClass();
        return;
    L17:
        if (r105 != r106.f250276h) goto L19;
        r109 = r106.f250278j;
        goto L20
    L13:
        if (r105 != r106.f250275g) goto L15;
        r103 = r106.f250277i;
        goto L19
    L9:
        if (r106.f250275g != r106.f250276h) goto L11;
        r103 = r106.f250277i;
        r109 = r106.f250278j;
        goto L20
    L5:
        r104 = 1;
        goto L6
    }
}
