package mv1;

import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.utils.r1;
import com.bytedance.android.live.multilink.impl.o1;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter;
import com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes8.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseFeedAdapter f515850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f515851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BaseFeedDataViewModel f515852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView.LayoutManager f515853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView.ItemDecoration f515854e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LifecycleOwner f515855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f515856g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f515857h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BannerSwipeRefreshLayout.a f515858i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f515859j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f515860k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f515861l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f515862m;

    public class a implements Observer<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f515863a;

        public a(k r100) {
            this.f515863a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 == null) goto L12;
            RecyclerView r102 = this.f515863a.f515851b;
            if (r102 == null) goto L14;
            r1.a(r102, 0);
            if (this.f515863a.f515852c.scrollTop() == false) goto L10;
            r1.a(this.f515863a.f515851b, r101.intValue());
            return;
        L10:
            this.f515863a.f515851b.scrollToPosition(r101.intValue());
            return;
        L14:
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BaseFeedAdapter f515864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f515865b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public BaseFeedDataViewModel f515866c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView.LayoutManager f515867d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f515868e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public RecyclerView.ItemDecoration f515869f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public LifecycleOwner f515870g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f515871h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public c f515872i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public BannerSwipeRefreshLayout.a f515873j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f515874k;

        public final k a() {
            RecyclerView r100 = this.f515865b;
            if (r100 == null) goto L22;
            r100.setItemAnimator(null);
            BaseFeedAdapter r101 = this.f515864a;
            if (r101 == null) goto L20;
            BaseFeedDataViewModel r102 = this.f515866c;
            if (r102 == null) goto L18;
            LifecycleOwner r103 = this.f515870g;
            if (r103 == null) goto L16;
            k r104 = new k(r103, r101, this.f515865b, r102);
            RecyclerView.LayoutManager r105 = this.f515867d;
            r104.f515853d = r105;
            if ((r105 instanceof StaggeredGridLayoutManager) == false) goto L13;
            ((StaggeredGridLayoutManager) r105).setSpanCount(this.f515868e);
        L13:
            r104.f515857h = this.f515872i;
            r104.f515854e = this.f515869f;
            r104.f515856g = this.f515871h;
            r104.f515858i = this.f515873j;
            r104.f515859j = this.f515874k;
            r104.f515860k = false;
            return r104;
        L16:
            throw new IllegalStateException("lifecycleOwner must not be null");
        L18:
            throw new IllegalStateException("viewModel must not be null");
        L20:
            throw new IllegalStateException("adapter must not be null");
        L22:
            throw new IllegalStateException("recyclerView must not be null");
        }

        public b() {
            this.f515868e = 2;
            StaggeredGridLayoutManager r100 = new StaggeredGridLayoutManager(2, 1);
            r100.setGapStrategy(0);
            this.f515867d = r100;
        }
    }

    public interface c {
        void a(FeedItem r100);
    }

    public final void a() {
        this.f515850a.H2(new i(this));
        this.f515851b.setAdapter(this.f515850a);
        this.f515850a.setRecyclerView(this.f515851b);
        this.f515851b.setLayoutManager(this.f515853d);
        this.f515851b.addOnScrollListener(new j(this));
        RecyclerView.ItemDecoration r100 = this.f515854e;
        if (r100 == null) goto L5;
        this.f515851b.addItemDecoration(r100);
    L5:
        this.f515850a.setViewModel(this.f515852c);
        this.f515850a.f123601i.subscribe(new e(this), new o1());
        this.f515850a.f123602j.subscribe(new f(this), new o1());
        this.f515852c.start();
        this.f515852c.feedRepository().vK(this.f515855f);
        this.f515852c.pos().observeForever(this.f515862m);
        this.f515852c.userStatus().observe(this.f515855f, new g(this));
        this.f515852c.refreshApiStatus().observe(this.f515855f, new h(this));
    }

    public k(LifecycleOwner r100, BaseFeedAdapter r101, RecyclerView r102, BaseFeedDataViewModel r103) {
        this.f515862m = new a(this);
        this.f515855f = r100;
        this.f515850a = r101;
        this.f515851b = r102;
        this.f515852c = r103;
    }
}
