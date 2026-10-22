package ha4;

import android.content.DialogInterface;
import com.bytedance.bdp.bdpplatform.service.ui.BdpGameHostBaseUIServiceImpl;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f484371a;

    public c(BdpGameHostBaseUIServiceImpl.b.a r100) {
        this.f484371a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        d r101 = this.f484371a;
        if (r101 != null) goto L5;
        return;
    L5:
        ((BdpGameHostBaseUIServiceImpl.b.a) r101).f201404a.getClass();
        throw null;
    }
}
