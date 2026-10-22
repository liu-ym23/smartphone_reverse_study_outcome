package r69;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class a extends u19.a<Toast> {
    public abstract ConstraintLayout a(Context r100);

    @Override // u19.a
    public final boolean getSupportLottie() {
        return false;
    }

    @Override // u19.f
    public final void setDuration(int r100) {
    }

    @Override // u19.a, u19.f
    public final void dismiss() {
        super.dismiss();
        Toast r100 = getInstance();
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        setInstance(null);
    }

    public a() {
    }

    @Override // u19.a, u19.f
    public final void show(Fragment r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Context r101 = r100.getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        super.show(r100, r110);
        Toast r102 = getInstance();
        if (r102 == null) goto L8;
        r102.cancel();
    L8:
        setInstance(null);
        ((Toast) u19.a.ensureInstance$default(this, r101, null, -1, false, 8, null)).show();
    }

    @Override // u19.a
    public final void show(Activity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super.show(r100, r101);
        Toast r102 = getInstance();
        if (r102 == null) goto L5;
        r102.cancel();
    L5:
        setInstance(null);
        ((Toast) u19.a.ensureInstance$default(this, r100, null, -1, false, 8, null)).show();
    }

    @Override // u19.a, u19.f
    public final void show(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.show(r100, r101);
        Toast r102 = getInstance();
        if (r102 == null) goto L5;
        r102.cancel();
    L5:
        setInstance(null);
        ((Toast) u19.a.ensureInstance$default(this, r100, null, -1, false, 8, null)).show();
    }

    @Override // u19.a
    public final Toast newInstance(Context r100, LifecycleOwner r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Toast r104 = new Toast(r100);
        r104.setView(a(r100));
        r104.setDuration(0);
        r104.setGravity(49, 0, r100.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_76, r100, R.dimen.larus_dp_76)));
        return r104;
    }
}
