package vw6;

import android.view.View;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f557434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f557435b;

    public f(String r100, c r101) {
        this.f557434a = r100;
        this.f557435b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        String r101 = this.f557434a;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L14;
        b r103 = this.f557435b;
        if (r103 == null) goto L15;
        r103.a(this.f557434a);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
