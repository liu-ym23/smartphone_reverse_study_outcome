package loc;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f510165a;

    public b(String r100) {
        this.f510165a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        joc.c r101 = e.f510168a;
        joc.c r102 = e.f510168a;
        if (r102 == null) goto L6;
        r102.a(this.f510165a);
        return;
    }
}
