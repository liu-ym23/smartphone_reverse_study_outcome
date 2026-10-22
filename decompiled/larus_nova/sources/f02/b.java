package f02;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f474969a;

    public b(View r100) {
        this.f474969a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a.C5841a r101 = a.f474962h;
        Context r102 = this.f474969a.getContext();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        WindowManager r103 = (WindowManager) r102.getSystemService(WindowManager.class);
        a r104 = a.f474960f;
        if (r104 == null) goto L5;
        r103.removeView(r104);
    L5:
        a.f474961g = false;
    }
}
