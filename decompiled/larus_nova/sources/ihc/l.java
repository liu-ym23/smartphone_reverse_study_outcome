package ihc;

import android.content.DialogInterface;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;

/* JADX INFO: loaded from: classes40.dex */
public final class l implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ControlRule f489947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f489948b;

    public l(ControlRule r100, m r101) {
        this.f489947a = r100;
        this.f489948b = r101;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r100) {
        this.f489948b.d(this.f489947a);
    }
}
