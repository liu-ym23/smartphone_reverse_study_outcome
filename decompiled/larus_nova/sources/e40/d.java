package e40;

import android.content.DialogInterface;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f470964a = null;

    static {
        f470964a = new d();
    }

    public d() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        ALogger.i("CloudGroupLivePreviewView", "click leave btn, cancel");
        int r102 = f40.a.f475503a;
        f40.a.d(CloudGroupLiveTraceEvent.WINDOW_MANAGER, "clickLeaveCancel", 0, null, 28);
        r100.dismiss();
    }
}
