package ubc;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.FragmentActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f549414e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f549415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f549416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f549417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f549418d;

    /* JADX INFO: renamed from: ubc.a$a, reason: collision with other inner class name */
    public static final class C7859a {
    }

    public interface b {
        void a();

        void z();
    }

    static {
        int r100 = com.larksuite.framework.utils.autoscale.a.f285947a;
        Resources r101 = Resources.getSystem();
        f549414e = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).heightPixels / 4;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View r100 = this.f549417c;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f549416b <= 0) goto L16;
        Intrinsics.checkNotNull(r100);
        int r101 = r100.getHeight() - this.f549416b;
        int r102 = f549414e;
        if (r101 >= (-r102)) goto L12;
        Math.abs(r101);
        b r103 = this.f549418d;
        if (r103 == null) goto L16;
        r103.z();
        goto L16
    L12:
        if (r101 <= r102) goto L16;
        Math.abs(r101);
        b r104 = this.f549418d;
        if (r104 == null) goto L16;
        r104.a();
    L16:
        View r105 = this.f549417c;
        Intrinsics.checkNotNull(r105);
        this.f549416b = r105.getHeight();
    }

    public a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f549415a = r100;
    }
}
