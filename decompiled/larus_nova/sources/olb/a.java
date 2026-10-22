package olb;

import android.os.Looper;
import android.view.View;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.RotateLoadingView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f524189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f524190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f524191c;

    /* JADX INFO: renamed from: olb.a$a, reason: collision with other inner class name */
    public static final class C7068a {
    }

    static {
    }

    public final void a() {
        Log.i("LazyLoadingHelper", "hideLoading");
        d.a(this.f524190b);
        d.a(this.f524191c);
        b r100 = this.f524191c;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        r100.run();
        return;
    L5:
        d.f524194a.post(r100);
    }

    public a(RotateLoadingView r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingView");
        this.f524189a = r100;
        r100.setVisibility(8);
        this.f524190b = new c(this);
        this.f524191c = new b(this);
    }
}
