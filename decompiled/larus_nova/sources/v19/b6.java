package v19;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b6 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f552445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View.OnClickListener f552446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f552447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a6 f552448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f552449e;

    /* JADX WARN: Type inference failed for: r2v2, types: [v19.a6] */
    public b6(com.larus.bmhome.bot.m4 r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f552445a = 2;
        this.f552446b = r100;
        this.f552447c = new Handler(Looper.getMainLooper());
        this.f552448d = new a6(this);
        this.f552449e = 1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = this.f552449e;
        if (r101 < this.f552445a) goto L5;
        this.f552447c.removeCallbacks(this.f552448d);
        this.f552449e = 1;
        this.f552446b.onClick(r100);
        return;
    L5:
        this.f552449e = r101 + 1;
        this.f552447c.removeCallbacks(this.f552448d);
        this.f552447c.postDelayed(this.f552448d, 500);
    }
}
