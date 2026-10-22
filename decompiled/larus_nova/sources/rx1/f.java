package rx1;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;

/* JADX INFO: loaded from: classes8.dex */
public final class f extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowManager f539745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WindowManager.LayoutParams f539746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f539747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f539748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f539749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f539750f;

    public f(Context r100) {
        this.f539750f = true;
        this.f539745a = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        WindowManager.LayoutParams r101 = new WindowManager.LayoutParams();
        this.f539746b = r101;
        r101.format = 1;
        r101.flags = 552;
        r101.windowAnimations = 0;
    }

    public final void a(int r100, int r101) {
        if (this.f539750f == false) goto L5;
        return;
    L5:
        WindowManager.LayoutParams r102 = this.f539746b;
        r102.x = r100;
        this.f539748d = r100;
        r102.y = r101;
        this.f539749e = r101;
        this.f539745a.updateViewLayout(this.f539747c, r102);
    }
}
