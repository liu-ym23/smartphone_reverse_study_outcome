package ihc;

import android.content.DialogInterface;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;

/* JADX INFO: loaded from: classes40.dex */
public final class i implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ControlRule f489941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f489942b;

    public i(ControlRule r100, m r101) {
        this.f489941a = r100;
        this.f489942b = r101;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r100) {
        this.f489942b.d(this.f489941a);
    }
}
