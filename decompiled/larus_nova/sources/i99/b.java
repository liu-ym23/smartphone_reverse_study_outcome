package i99;

import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f488805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f488806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f488807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f488808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f488809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f488810f;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public static void a(View r100) {
        r100.animate().translationX(0.0f).alpha(1.0f).setDuration(180).setInterpolator(new DecelerateInterpolator()).start();
    }
}
