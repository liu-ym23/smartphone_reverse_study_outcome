package ad5;

import com.bytedance.ee.bear.list.homepage.tab.HomeTabEnum;
import com.bytedance.ee.bear.list.pinview.PinFragment;
import com.bytedance.ee.bear.list.recent.RecentDocumentFragment;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements f {
    public d() {
    }

    @Override // ad5.f
    public final List<e> a(boolean r5) {
        ArrayList r6 = new ArrayList();
        r6.add(new e(HomeTabEnum.RECENT.id, 2131887956, RecentDocumentFragment.class.getName()));
        r6.add(new e(HomeTabEnum.PIN.id, 2131887955, PinFragment.class.getName()));
        return r6;
    }
}
