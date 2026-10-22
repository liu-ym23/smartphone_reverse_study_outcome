package vr2;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.scope.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements bi6.a, o {
    public l() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // bi6.a
    public final void x(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        f2.d(r100, r101);
    }

    @Override // bi6.a
    public final void centerToast(Context r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "message");
        IHostApp r103 = (IHostApp) jc1.k.f(IHostApp.class);
        if (r103 == null) goto L5;
        r103.centerToast(r100, r101, r102);
        return;
    L5:
        Toast.makeText(r100, r101, r102).show();
    }
}
