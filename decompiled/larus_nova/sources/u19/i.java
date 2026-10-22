package u19;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class i extends u19.a<Toast> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f548345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f548346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f548347c;

    public static final class a {
    }

    static {
    }

    @Override // u19.a
    public final boolean getSupportLottie() {
        return false;
    }

    @Override // u19.a, u19.f
    public final void dismiss() {
        h r100 = this.f548347c;
        if (r100 == null) goto L5;
        this.f548346b.removeCallbacks(r100);
    L5:
        this.f548347c = null;
        super.dismiss();
        Toast r101 = getInstance();
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        setInstance(null);
    }

    public i() {
        this.f548345a = 1;
        this.f548346b = new Handler(Looper.getMainLooper());
    }

    @Override // u19.a
    public final int getDisplayDuration() {
        return this.f548345a;
    }

    @Override // u19.a
    public final void setDisplayDuration(int r100) {
        this.f548345a = r100;
    }

    @Override // u19.f
    public final void setDuration(int r100) {
        long r101 = r100;
        if (0 <= r101) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        this.f548345a = 0;
        return;
    L10:
        this.f548345a = 1;
        return;
    L5:
        if (r101 >= 1501) goto L7;
        r102 = true;
        goto L8
    }

    @Override // u19.a, u19.f
    public final void show(Fragment r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Context r102 = r100.getContext();
        if (r102 != null) goto L5;
        return;
    L5:
        super.show(r100, r101);
        showInternal(r102, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Runnable, u19.h] */
    public final void showInternal(Context r100, boolean r101) {
        h r102 = this.f548347c;
        if (r102 == null) goto L5;
        this.f548346b.removeCallbacks(r102);
    L5:
        this.f548347c = null;
        Toast r103 = getInstance();
        if (r103 == null) goto L8;
        r103.cancel();
    L8:
        setInstance(null);
        final Toast r104 = ensureInstance(r100, null, -1, r101);
        r104.show();
        if (this.f548345a != 1) goto L11;
        long r105 = 3500;
    L12:
        ?? r106 = new h(this, r104);
        this.f548347c = r106;
        this.f548346b.postDelayed(r106, r105);
        return;
    L11:
        r105 = 2000;
        goto L12
    }

    @Override // u19.a
    public final void show(Activity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super.show(r100, r101);
        showInternal(r100, r101);
    }

    @Override // u19.a, u19.f
    public final void show(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.show(r100, r101);
        showInternal(r100, r101);
    }

    @Override // u19.a
    public final Toast newInstance(Context r100, LifecycleOwner r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r104 = r100.getApplicationContext();
        if (r104 == null) goto L6;
        r100 = r104;
    L6:
        Toast r105 = new Toast(r100);
        r105.setView(buildLayout(r100, r103));
        r105.setDuration(this.f548345a);
        r105.setGravity(55, 0, 0);
        return r105;
    }
}
