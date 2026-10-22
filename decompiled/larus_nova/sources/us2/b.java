package us2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.nova.R;
import ita.i;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f551463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f551464b;

    public b(a r100) {
        this.f551463a = r100;
        this.f551464b = 1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (1 != this.f551464b) goto L5;
        this.f551463a.b();
        return;
    L5:
        a r101 = this.f551463a;
        Context r102 = r101.getContext();
        int r103 = i.f495747a;
        if (NetworkUtils.isNetworkAvailable(r102) == true) goto L10;
        IESUIUtils.displayToast(r101.getContext(), R.string.ttlive_core_network_unavailable);
        ((LoadingStatusView) r101.a(R.id.room_manage_list_status_view)).showError();
        return;
    }
}
