package e40;

import android.content.DialogInterface;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f470965a;

    public e(a r100) {
        this.f470965a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        ALogger.i("CloudGroupLivePreviewView", "click leave btn, confirm");
        int r102 = f40.a.f475503a;
        f40.a.d(CloudGroupLiveTraceEvent.WINDOW_MANAGER, "clickLeaveConfirm", 0, null, 28);
        this.f470965a.f470961e.f();
        r100.dismiss();
    }
}
