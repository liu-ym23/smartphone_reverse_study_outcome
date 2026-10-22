package qx4;

import android.view.View;
import com.bytedance.ee.bear.contract.DebugRequest;
import com.bytedance.ee.bear.contract.o0;
import com.bytedance.ee.bear.debug.net.RequestAdapter;
import com.bytedance.ee.bear.debug.net.RequestListFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class o extends BaseTitleBar.e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ RequestListFragment f535125j;

    public o(RequestListFragment r100) {
        this.f535125j = r100;
        super("刷新");
    }

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
    public final void performAction(View r100) {
        RequestAdapter r101 = this.f535125j.f217405e;
        ArrayList<DebugRequest> r102 = o0.f217119a;
        r101.setNewData(o0.f217119a);
    }
}
