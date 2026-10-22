package gm3;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f481669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f481670b;

    public c(a r100, b r101) {
        this.f481669a = r100;
        this.f481670b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        hm3.b r101 = this.f481670b.f481662a;
        if (r101 == null) goto L6;
        r101.a(this.f481669a);
    L6:
        if (this.f481669a.f481661c == false) goto L11;
        b r102 = this.f481670b;
        r102.f481667f = true;
        Dialog r103 = r102.f481666e;
        if (r103 == null) goto L12;
        b.a(r103);
        return;
    L12:
        return;
    }
}
