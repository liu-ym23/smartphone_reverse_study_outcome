package s21;

import android.view.View;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f540251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f540252b;

    public d(e r100, Runnable r101) {
        this.f540251a = r100;
        this.f540252b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = System.currentTimeMillis();
        e r102 = this.f540251a;
        if ((r101 - r102.C) <= 500) goto L8;
        r102.C = System.currentTimeMillis();
        Runnable r103 = this.f540252b;
        if (r103 == null) goto L9;
        r103.run();
        return;
    L9:
        return;
    }
}
