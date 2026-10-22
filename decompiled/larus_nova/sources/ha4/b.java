package ha4;

import android.content.DialogInterface;
import com.bytedance.bdp.bdpplatform.service.ui.BdpGameHostBaseUIServiceImpl;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f484370a;

    public b(BdpGameHostBaseUIServiceImpl.b.a r100) {
        this.f484370a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        d r102 = this.f484370a;
        if (r102 != null) goto L5;
        return;
    L5:
        ((BdpGameHostBaseUIServiceImpl.b.a) r102).f201404a.getClass();
        throw null;
    }
}
