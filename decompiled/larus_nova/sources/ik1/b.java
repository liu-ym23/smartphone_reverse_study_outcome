package ik1;

import com.bytedance.android.livesdk.chatroom.adapter.LiveDetailPagerAdapter;
import com.bytedance.android.livesdk.chatroom.d0;
import com.bytedance.android.livesdk.chatroom.i;
import com.bytedance.android.livesdk.chatroom.newcontainer.business.community.innerfeed.page.LiveSessionRoomPageChange;
import com.bytedance.android.livesdk.chatroom.utils.DrawToNextReason;
import com.bytedance.android.livesdk.chatroom.utils.LiveInnerFeedHelper;
import com.bytedance.android.livesdk.chatroom.wornhole.Wormhole;
import com.bytedance.android.livesdk.config.i5;
import com.bytedance.android.livesdk.config.vv;
import com.bytedance.android.livesdk.live.LiveInnerCommonController;
import com.bytedance.android.livesdk.viewmodel.MergeDrawerViewModel;
import com.bytedance.android.livesdk.widget.LiveSwipeRefreshLayout;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.android.livesdkapi.feed.tabviewmodel.LiveMultiTabRoomViewModel;
import com.bytedance.android.livesdkapi.roomset.IRoomSetManager;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends ls2.c {
    public final LiveInnerCommonController A;
    public com.bytedance.android.livesdk.live.f B;
    public LiveMultiTabRoomViewModel C;
    public final List<Room> D;
    public ILiveRoomPlayFragment E;
    public z90.a.b F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f490185J;
    public final Wormhole K;
    public int L;
    public DrawToNextReason M;
    public String N;
    public final PublishSubject<Boolean> O;
    public jo2.e P;
    public kk1.a Q;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ILiveRoomListProvider f490186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MergeDrawerViewModel f490187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveVerticalViewPager f490188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LiveSessionRoomPageChange f490189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LiveSwipeRefreshLayout f490190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LiveDetailPagerAdapter f490191h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i f490192i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public kn2.b f490193j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IRoomSetManager f490194k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f490195l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f490196m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f490197n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f490198o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f490199p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f490200q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f490201r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f490202s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final i5 f490203t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final pg2.i f490204u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d0 f490205v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final LiveInnerFeedHelper f490206w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f490207x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f490208y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f490209z;

    public b() {
        this.f490196m = -1;
        this.f490203t = vv.f121480a.getValue();
        this.f490204u = new pg2.i();
        this.f490205v = new d0();
        this.f490206w = new LiveInnerFeedHelper();
        this.f490208y = -1;
        this.A = new LiveInnerCommonController();
        this.D = new ArrayList();
        this.G = true;
        this.K = new Wormhole();
        this.M = DrawToNextReason.OTHERS;
        this.N = "";
        this.O = PublishSubject.create();
    }

    public final ILiveRoomListProvider d() {
        return this.f490186c;
    }

    public final LiveMultiTabRoomViewModel e() {
        return this.C;
    }
}
