package fw1;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.DoubleBallSwipeRefreshLayout;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.SwipeRefreshLayout;
import com.bytedance.android.livesdkapi.drawer.ILiveDoubleBallSwipeRefreshLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements ILiveDoubleBallSwipeRefreshLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoubleBallSwipeRefreshLayout f478998a;

    /* JADX INFO: renamed from: fw1.a$a, reason: collision with other inner class name */
    public static final class C5954a implements SwipeRefreshLayout.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ILiveDoubleBallSwipeRefreshLayout.OnRefreshListener f478999a;

        public C5954a(ILiveDoubleBallSwipeRefreshLayout.OnRefreshListener r100) {
            this.f478999a = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.pullrefresh.SwipeRefreshLayout.f
        public final void onRefresh() {
            ILiveDoubleBallSwipeRefreshLayout.OnRefreshListener r100 = this.f478999a;
            if (r100 == null) goto L6;
            r100.onRefresh();
            return;
        }
    }

    @Override // com.bytedance.android.livesdkapi.drawer.ILiveDoubleBallSwipeRefreshLayout
    public final boolean isRefreshing() {
        return this.f478998a.f113780c;
    }

    @Override // com.bytedance.android.livesdkapi.drawer.ILiveDoubleBallSwipeRefreshLayout
    public final ViewGroup getView() {
        return this.f478998a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f478998a = new DoubleBallSwipeRefreshLayout(r100);
    }

    @Override // com.bytedance.android.livesdkapi.drawer.ILiveDoubleBallSwipeRefreshLayout
    public final void setEnabledPull(boolean r100) {
        this.f478998a.setEnabled(r100);
    }

    @Override // com.bytedance.android.livesdkapi.drawer.ILiveDoubleBallSwipeRefreshLayout
    public final void setOnRefreshListener(ILiveDoubleBallSwipeRefreshLayout.OnRefreshListener r100) {
        this.f478998a.setOnRefreshListener(new C5954a(r100));
    }

    @Override // com.bytedance.android.livesdkapi.drawer.ILiveDoubleBallSwipeRefreshLayout
    public final void setRefreshing(boolean r100) {
        this.f478998a.setRefreshing(r100);
    }
}
