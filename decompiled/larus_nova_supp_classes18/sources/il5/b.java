package il5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.operation.view.OperationNotPermissionFragment;
import com.bytedance.ee.util.ui.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements a {
    public b() {
    }

    @Override // il5.a
    public final void a(FragmentActivity r5) {
        int r0 = OperationNotPermissionFragment.k;
        Intrinsics.checkNotNullParameter(r5, "activity");
        tt5.a.h("OperationNotPermissionFragment", "OperationNotPermissionFragment show");
        tt5.a.h("OperationNotPermissionFragment", "currentState +=" + r5.getLifecycle().getCurrentState());
        if (r5.getSupportFragmentManager().findFragmentByTag("OperationNotPermissionFragment") != null) goto L5;
        j.f(new com.bytedance.ee.bear.operation.view.a(r5));
        return;
    L5:
        tt5.a.h("OperationNotPermissionFragment", "already has fragment");
    }
}
