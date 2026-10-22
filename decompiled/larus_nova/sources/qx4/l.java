package qx4;

import android.view.View;
import com.bytedance.ee.bear.debug.net.RequestListFragment;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class l extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f535120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RequestListFragment f535121d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        ((SpaceEditText) this.f535120c.findViewById(R.id.inputEt)).setText("");
        RequestListFragment.U90(this.f535121d, "");
    }

    public l(View r100, RequestListFragment r101) {
        this.f535120c = r100;
        this.f535121d = r101;
    }
}
