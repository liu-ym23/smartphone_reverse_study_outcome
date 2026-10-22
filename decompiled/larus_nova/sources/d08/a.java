package d08;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import j08.d;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f466233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f466234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ double f466235c;

    public final void a() {
        if (this.f466233a != null) goto L5;
        return;
    L5:
        Log.i("LKUIStatus", "setViewOnScreenTranslation translationY =" + this.f466234b);
        float r100 = this.f466234b;
        if (r100 <= 0.0f) goto L9;
        this.f466233a.setTranslationY(r100);
        return;
    L9:
        float r101 = (float) (((double) d.c(this.f466233a.getContext()).f496835b) * this.f466235c);
        int[] r102 = new int[2];
        this.f466233a.getLocationOnScreen(r102);
        float r103 = r102[1];
        Log.i("LKUIStatus", "distance of the view relative to the top of the screen：" + r103);
        this.f466233a.setTranslationY(r101 - (r103 - this.f466233a.getTranslationY()));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(View r100, float r101) {
        this.f466233a = r100;
        this.f466234b = r101;
        this.f466235c = 0.33d;
    }
}
