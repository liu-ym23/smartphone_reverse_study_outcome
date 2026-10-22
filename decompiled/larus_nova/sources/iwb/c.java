package iwb;

import android.view.View;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f496278a;

    public c(a r100) {
        this.f496278a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        d r101 = this.f496278a.f496267i;
        if (r101.f496279a.isLaidOut() == false) goto L6;
        r101.b();
        r101.f496282d = false;
        r101.f496283e = false;
        r101.f496279a.c(false, false);
        r101.d(true);
    L6:
        a r102 = this.f496278a;
        r102.f496270l = false;
        r102.removeCallbacks(r102.f496274p);
        d r103 = r102.f496267i;
        if (r103.f496281c == true) goto L10;
        r102.b(r103.c());
        return;
    }
}
