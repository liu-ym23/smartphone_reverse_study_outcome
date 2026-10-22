package qx4;

import android.view.View;
import com.bytedance.ee.bear.contract.DebugRequest;
import com.bytedance.ee.bear.contract.o0;
import com.bytedance.ee.bear.debug.net.RequestAdapter;
import com.bytedance.ee.bear.debug.net.RequestListFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o extends BaseTitleBar.e {
    public final /* synthetic */ RequestListFragment j;

    public o(RequestListFragment r1) {
        this.j = r1;
        super("刷新");
    }

    public final void performAction(View r2) {
        RequestAdapter r3 = this.j.e;
        ArrayList<DebugRequest> r0 = o0.a;
        r3.setNewData(o0.a);
    }
}
