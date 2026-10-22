package qx4;

import android.view.View;
import com.bytedance.ee.bear.contract.DebugRequest;
import com.bytedance.ee.bear.contract.o0;
import com.bytedance.ee.bear.debug.net.RequestListFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class n extends BaseTitleBar.e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ RequestListFragment f535124j;

    public n(RequestListFragment r100) {
        this.f535124j = r100;
        super("清除");
    }

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
    public final void performAction(View r100) {
        ArrayList<DebugRequest> r101 = o0.f217119a;
        o0.f217119a.clear();
        this.f535124j.f217405e.notifyDataSetChanged();
    }
}
