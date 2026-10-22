package pd5;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.ListRecyclerView;
import com.bytedance.ee.bear.list.list.OptimizedListRecyclerView;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.preload.RecentListContainer;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public RecentListContainer a;

    public static class a {
        public static final d a = null;

        static {
            a = new d();
        }
    }

    public d() {
    }

    public final ViewGroup a(FragmentActivity r6) {
        RecentListContainer r0 = this.a;
        if (r0 != null) goto L5;
    L6:
        RecentListContainer r1 = new RecentListContainer(r6);
        r1.setId(2131378147);
        r1.setBackgroundColor(r6.getResources().getColor(2131100548));
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ListRecyclerView r2 = new OptimizedListRecyclerView(r6);
        r2.setId(2131378168);
        r2.setOverScrollMode(2);
        r1.addView(r2, new FrameLayout.LayoutParams(-1, -1));
        LoadStateView r3 = new LoadStateView(r6);
        r3.setId(2131378179);
        r1.addView(r3, new FrameLayout.LayoutParams(-1, -1));
        r1.a = (BaseRecyclerView) r1.findViewById(2131378168);
        this.a = r1;
    L7:
        RecentListContainer r7 = this.a;
        this.a = null;
        return r7;
    L5:
        if (r0.getContext() == r6) goto L7;
        goto L6
    }
}
