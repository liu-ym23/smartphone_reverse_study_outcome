package com.bytedance.ee.bear.list.rename;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final WeakReference<Fragment> a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.rename.a$a, reason: collision with other inner class name */
    public interface InterfaceC0032a {
    }

    public a(Fragment r2) {
        this.a = new WeakReference(r2);
    }

    public final void a(int r4) {
        if (this.a.get() != null) goto L6;
        tt5.a.d("RenameWrapper", "RenameWrapper.showRenameResult, mHostRef.get() is null. ");
        return;
    L6:
        Fragment r0 = this.a.get();
        Toast.showFailureText(r0.getActivity(), r0.getActivity().getResources().getText(r4), 0);
        tt5.a.b("RenameWrapper", "showRenameResult: fail");
    }
}
