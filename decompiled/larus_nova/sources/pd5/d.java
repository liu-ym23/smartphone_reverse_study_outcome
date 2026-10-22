package pd5;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.list.list.OptimizedListRecyclerView;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.preload.RecentListContainer;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecentListContainer f528678a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f528679a = null;

        static {
            f528679a = new d();
        }
    }

    public d() {
    }

    public final ViewGroup a(FragmentActivity r100) {
        RecentListContainer r101 = this.f528678a;
        if (r101 != null) goto L5;
    L6:
        RecentListContainer r102 = new RecentListContainer(r100);
        r102.setId(R.id.list_layout_root);
        r102.setBackgroundColor(r100.getResources().getColor(R.color.bg_body));
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        OptimizedListRecyclerView r103 = new OptimizedListRecyclerView(r100);
        r103.setId(R.id.list_recycler_view);
        r103.setOverScrollMode(2);
        r102.addView(r103, new FrameLayout.LayoutParams(-1, -1));
        LoadStateView r104 = new LoadStateView(r100);
        r104.setId(R.id.list_state_view_root);
        r102.addView(r104, new FrameLayout.LayoutParams(-1, -1));
        r102.f229182a = (BaseRecyclerView) r102.findViewById(R.id.list_recycler_view);
        this.f528678a = r102;
    L7:
        RecentListContainer r105 = this.f528678a;
        this.f528678a = null;
        return r105;
    L5:
        if (r101.getContext() == r100) goto L7;
        goto L6
    }
}
