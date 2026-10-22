package rw1;

import com.bytedance.android.livesdk.feed.adapter.FeedLiveAdapter;
import com.bytedance.android.livesdk.feed.dislike.DislikeApi;
import com.bytedance.android.livesdk.feed.fragment.FeedLiveFragment;
import com.bytedance.android.livesdk.feed.j;
import com.bytedance.android.livesdk.feed.tab.repository.l;
import com.bytedance.android.livesdk.feed.tab.repository.p;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import com.bytedance.android.livesdkapi.feed.LiveRoomListDataSource;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: classes8.dex */
public final class i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Map<Integer, Function5<tv1.c, com.bytedance.android.livesdk.feed.f, j, ILiveRoomListDataSource, com.bytedance.android.livesdk.feed.h, b90.a>> f539583h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FeedLiveFragment f539584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.feed.f f539585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f539586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveRoomListDataSource f539587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final tv1.c f539588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FeedLiveFragment.a f539589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.livesdk.feed.h f539590g;

    public class a implements com.bytedance.android.livesdk.feed.l {
        @Override // com.bytedance.android.livesdk.feed.l
        public final void a() {
        }

        public a() {
        }
    }

    public final FeedLiveAdapter a() {
        if (this.f539584a == null) goto L7;
        return new FeedLiveAdapter(b(), this.f539585b, this.f539584a);
    L7:
        return new FeedLiveAdapter(b(), this.f539585b, this.f539590g);
    }

    public final Map<Integer, b90.a> b() {
        HashMap r100 = new HashMap();
        Map<Integer, Function5<tv1.c, com.bytedance.android.livesdk.feed.f, j, ILiveRoomListDataSource, com.bytedance.android.livesdk.feed.h, b90.a>> r101 = f539583h;
        if (r101 == null) goto L8;
        Iterator r102 = ((HashMap) r101).keySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        Integer r103 = (Integer) r102.next();
        r100.put(r103, (b90.a) ((Function5) ((HashMap) f539583h).get(r103)).invoke(this.f539588e, this.f539585b, this.f539586c, this.f539587d, this.f539590g));
    L8:
        Integer r104 = Integer.valueOf(R.layout.ttlive_item_feed_live_large);
        final tv1.c r105 = this.f539588e;
        final com.bytedance.android.livesdk.feed.f r106 = this.f539585b;
        final l r107 = this.f539586c;
        final LiveRoomListDataSource r108 = this.f539587d;
        r100.put(r104, new rw1.a(this, r105, r106, r107, r108));
        Integer r109 = Integer.valueOf(R.layout.ttlive_item_feed_live_small);
        final tv1.c r110 = this.f539588e;
        final com.bytedance.android.livesdk.feed.f r111 = this.f539585b;
        final l r112 = this.f539586c;
        final LiveRoomListDataSource r113 = this.f539587d;
        r100.put(r109, new d(this, r110, r111, r112, r113));
        Integer r114 = Integer.valueOf(R.layout.ttlive_view_feed_live_tab);
        final FeedLiveFragment.a r115 = this.f539589f;
        r100.put(r114, new f(r115));
        Integer r116 = Integer.valueOf(R.layout.ttlive_view_feed_live_banner);
        final a r117 = new a();
        r100.put(r116, new g(r117));
        r100.put(Integer.valueOf(R.layout.ttlive_view_feed_live_rank), new c());
        r100.put(Integer.valueOf(R.layout.ttlive_view_feed_live_gap), new e());
        r100.put(Integer.valueOf(R.layout.ttlive_item_follow_feed), new h());
        Integer r118 = Integer.valueOf(R.layout.ttlive_item_feed_ad);
        final tv1.c r119 = this.f539588e;
        final com.bytedance.android.livesdk.feed.f r120 = this.f539585b;
        final l r121 = this.f539586c;
        final LiveRoomListDataSource r122 = this.f539587d;
        r100.put(r118, new b(r119, r120, r121, r122));
        return r100;
    }

    public i(FeedLiveFragment r100, com.bytedance.android.livesdk.feed.h r101) {
        this.f539588e = new tv1.c((DislikeApi) com.bytedance.android.live.network.c.b().e(DislikeApi.class));
        this.f539585b = com.bytedance.android.livesdk.feed.services.d.a();
        if (r100 != null) goto L5;
        l r102 = p.f();
    L6:
        this.f539586c = r102;
        this.f539587d = LiveRoomListDataSource.instance();
        this.f539584a = r100;
        if (r100 == null) goto L9;
        this.f539589f = r100.f124059J;
    L9:
        this.f539590g = r101;
        return;
    L5:
        r102 = r100.D;
        goto L6
    }
}
