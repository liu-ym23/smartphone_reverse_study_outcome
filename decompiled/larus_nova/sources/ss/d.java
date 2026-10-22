package ss;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;

/* JADX INFO: loaded from: classes44.dex */
public final class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowManager f543281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WindowManager.LayoutParams f543282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f543283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f543284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f543285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f543286f;

    public d(Context r100) {
        this.f543286f = true;
        this.f543281a = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        WindowManager.LayoutParams r101 = new WindowManager.LayoutParams();
        this.f543282b = r101;
        r101.format = 1;
        r101.flags = 552;
        r101.windowAnimations = 0;
    }

    public final void a(int r100, int r101) {
        if (this.f543286f == false) goto L5;
        return;
    L5:
        WindowManager.LayoutParams r102 = this.f543282b;
        r102.x = r100;
        this.f543284d = r100;
        r102.y = r101;
        this.f543285e = r101;
        this.f543281a.updateViewLayout(this.f543283c, r102);
    }
}
