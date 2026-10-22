package e40;

import android.view.View;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.widget.x0;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f470963a;

    public c(a r100) {
        this.f470963a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a r101 = this.f470963a;
        r101.getClass();
        ALogger.i("CloudGroupLivePreviewView", "click leave btn, show double check dialog");
        int r102 = f40.a.f475503a;
        f40.a.d(CloudGroupLiveTraceEvent.WINDOW_MANAGER, "clickLeaveBtn", 0, null, 28);
        x0.b r103 = new x0.b(r101.getContext(), 4);
        r103.f162238a.f162244c = s1.B(R.string.ttlive_cloud_group_live_leave_title);
        r103.f162238a.f162245d = s1.B(R.string.ttlive_cloud_group_live_leave_double_check_content);
        r103.i(1, R.string.ttlive_cloud_group_live_leave_double_check_cancel, d.f470964a);
        r103.i(0, R.string.ttlive_cloud_group_live_leave_double_check_confirm, new e(r101));
        r103.k(0, true);
        r103.n();
    }
}
