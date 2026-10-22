package com.bytedance.ee.bear.list.rename;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Fragment> f229341a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.rename.a$a, reason: collision with other inner class name */
    public interface InterfaceC3279a {
    }

    public a(Fragment r100) {
        this.f229341a = new WeakReference(r100);
    }

    public final void a(int r100) {
        if (this.f229341a.get() != null) goto L6;
        tt5.a.d("RenameWrapper", "RenameWrapper.showRenameResult, mHostRef.get() is null. ");
        return;
    L6:
        Fragment r101 = this.f229341a.get();
        Toast.showFailureText(r101.getActivity(), r101.getActivity().getResources().getText(r100), 0);
        tt5.a.b("RenameWrapper", "showRenameResult: fail");
    }
}
