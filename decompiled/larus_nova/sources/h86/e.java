package h86;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements f86.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.xelement.picker.view.d f484219a;

    public e(com.bytedance.ies.xelement.picker.view.d r100) {
        this.f484219a = r100;
    }

    @Override // f86.d
    public final void onItemSelected(int r100) {
        com.bytedance.ies.xelement.picker.view.d r101 = this.f484219a;
        if (r101.f250279k == r101.f250273e) goto L5;
    L7:
        r101.f250281m = r100 + 1;
        return;
    L5:
        if (r101.f250280l != r101.f250275g) goto L7;
        r101.f250281m = r100 + r101.f250277i;
    }
}
