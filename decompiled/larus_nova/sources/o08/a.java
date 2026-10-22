package o08;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f521643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f521644b;

    public final void b() {
        this.f521643a.removeAllViews();
    }

    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f521644b = r100;
        this.f521643a.addView(r100);
    }

    public a(Context r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "childView");
        FrameLayout r102 = new FrameLayout(r100);
        this.f521643a = r102;
        r102.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f521644b = r101;
        a(r101);
    }
}
