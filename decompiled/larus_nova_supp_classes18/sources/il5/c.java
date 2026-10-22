package il5;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.operation.view.OperationSuiteDisableFragment;
import com.bytedance.ee.util.ui.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements a {
    public final String a;

    public c(Intent r2) {
        this.a = r2.getExtras().getString("SUITE_TYPE");
    }

    @Override // il5.a
    public final void a(FragmentActivity r6) {
        String r0 = this.a;
        int r1 = OperationSuiteDisableFragment.m;
        Intrinsics.checkNotNullParameter(r6, "activity");
        tt5.a.h("OperationSuiteDisableFragment", "SingleFileExceedQuotaFragment show");
        tt5.a.h("OperationSuiteDisableFragment", "currentState +=" + r6.getLifecycle().getCurrentState());
        if (r6.getSupportFragmentManager().findFragmentByTag("OperationSuiteDisableFragment") != null) goto L5;
        j.f(new com.bytedance.ee.bear.operation.view.b(r0, r6));
        return;
    L5:
        tt5.a.h("OperationSuiteDisableFragment", "already has fragment");
    }
}
