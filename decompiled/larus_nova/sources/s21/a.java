package s21;

import android.view.View;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f540222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f540223b;

    public a(b r100, Runnable r101) {
        this.f540222a = r100;
        this.f540223b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = System.currentTimeMillis();
        b r102 = this.f540222a;
        if ((r101 - r102.F) <= 500) goto L8;
        r102.F = System.currentTimeMillis();
        Runnable r103 = this.f540223b;
        if (r103 == null) goto L9;
        r103.run();
        return;
    L9:
        return;
    }
}
