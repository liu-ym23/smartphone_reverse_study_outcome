package qx4;

import android.view.View;
import com.bytedance.ee.bear.contract.DebugRequest;
import com.bytedance.ee.bear.contract.o0;
import com.bytedance.ee.bear.debug.net.RequestListFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n extends BaseTitleBar.e {
    public final /* synthetic */ RequestListFragment j;

    public n(RequestListFragment r1) {
        this.j = r1;
        super("清除");
    }

    public final void performAction(View r1) {
        ArrayList<DebugRequest> r2 = o0.a;
        o0.a.clear();
        this.j.e.notifyDataSetChanged();
    }
}
