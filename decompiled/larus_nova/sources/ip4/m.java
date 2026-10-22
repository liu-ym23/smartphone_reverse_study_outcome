package ip4;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gp4.h f495287a;

    @Override // java.lang.Runnable
    public final void run() {
        Toast.showFailureText(this.f495287a.getActivity(), R.string.CreationMobile_ECM_AdminDisableToast);     // Catch: Throwable -> L4
        tt5.a.d("AttachmentCellViewHolder", "can not upload attachment by auth!!");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public m(gp4.h r100) {
        this.f495287a = r100;
    }
}
