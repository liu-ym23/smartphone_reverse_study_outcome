package com.bytedance.android.livesdk.list;

import am2.x;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.Pair;
import android.util.SparseArray;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.radio.api.IRadioService;
import com.bytedance.android.live.network.c;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.follow.ILiveFeedCacheHelper;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.c0;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.chatroom.utils.h2;
import com.bytedance.android.livesdk.chatroom.utils.m4;
import com.bytedance.android.livesdk.config.du;
import com.bytedance.android.livesdk.config.fa1;
import com.bytedance.android.livesdk.config.fu0;
import com.bytedance.android.livesdk.config.h31;
import com.bytedance.android.livesdk.config.nv;
import com.bytedance.android.livesdk.config.qr;
import com.bytedance.android.livesdk.config.r4;
import com.bytedance.android.livesdk.config.tl0;
import com.bytedance.android.livesdk.landscapeslide.LiveLandSlideContext;
import com.bytedance.android.livesdk.landscapeslide.b;
import com.bytedance.android.livesdk.landscapeslide.f;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f0;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.android.livesdkapi.feed.ILoadMore;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import if2.h;
import if2.i;
import if2.j;
import if2.m;
import if2.n;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ita.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kf2.g;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pg2.d;
import pg2.e;
import yh0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class RandomAccessRoomListProvider extends ILiveRoomListProvider implements LifecycleObserver, e, b, ILoadMore {
    public String A;
    public boolean B;
    public long C;
    public final boolean D;
    public final boolean E;
    public ILoadMore.ILoadMoreCallback F;
    public String G;
    public d H;
    public final boolean I;
    public List<Room> J;
    public ArrayList<Room> K;
    public LiveLandSlideContext L;
    public int M;
    public boolean N;
    public boolean O;
    public HashSet<Long> P;
    public HashSet<Long> Q;
    public final List<Long> a;
    public final List<Boolean> b;
    public final List<Room> c;
    public final List<Long> d;
    public final List<Long> e;
    public final LongSparseArray<Integer> f;
    public final Map<Long, Room> g;
    public final Map<Long, Bundle> h;
    public final List<FeedItem> i;
    public final Bundle j;
    public boolean k;
    public boolean l;
    public int m;
    public final CompositeDisposable n;
    public a o;
    public boolean p;
    public boolean q;
    public int r;
    public boolean s;
    public String t;
    public boolean u;
    public FeedExtra v;
    public g w;
    public long x;
    public long y;
    public String z;

    @Override // pg2.e
    public final void b(int r1) {
    }

    @Override // pg2.e
    public final String k() {
        return "";
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.l = true;
        this.B = false;
        this.u = false;
        this.q = false;
        CompositeDisposable r0 = this.n;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.o = null;
    }

    public final String providerType() {
        return "RandomAccessRoomListProvider";
    }

    @Override // com.bytedance.android.livesdk.landscapeslide.b
    public final int e() {
        return Math.max(this.M, 0);
    }

    public final List<Room> getRoomList() {
        List<Room> r0 = this.c;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.landscapeslide.b
    public final void h() {
        LiveLandSlideContext r0 = this.L;
        if (r0 == null) goto L13;
        long r4 = r0.getCurrentRoomId();
        int r1 = this.L.getRelateRoomIndex() - 1;
        if (r4 != 0) goto L15;
        if (this.K.isEmpty() == true) goto L13;
        if (r1 < 0) goto L13;
        if (r1 >= this.K.size()) goto L13;
        r4 = ((Room) ListProtector.get(this.K, r1)).getRoomId();
    L15:
        if (this.N == false) goto L54;
        Iterator<Room> r2 = this.K.iterator();
    L18:
        if (r2.hasNext() == false) goto L60;
        long r5 = r2.next().getRoomId();
        if (this.P.contains(Long.valueOf(r5)) == true) goto L21;
        if (this.Q.contains(Long.valueOf(r5)) == true) goto L25;
        p(r5, null);
        s("remove unread room: " + r5);
        goto L18
    L25:
        if (r5 > 0) goto L27;
    L52:
        s("remove duplicate room: " + r5);
        goto L18
    L27:
        if (this.a == null) goto L52;
        if (this.c == null) goto L52;
        if (this.h == null) goto L52;
        int r8 = 0;
        boolean r9 = true;
    L35:
        if (r8 >= ((ArrayList) this.c).size()) goto L52;
        if (((Room) ListProtector.get(this.c, r8)).getRoomId() != r5) goto L51;
        if (r9 == false) goto L41;
        r9 = false;
        goto L51
    L41:
        if (((ArrayList) this.a).size() <= r8) goto L44;
        ListProtector.remove(this.a, r8);
    L44:
        if (((ArrayList) this.c).size() <= r8) goto L47;
        ListProtector.remove(this.c, r8);
    L47:
        if (this.D == false) goto L52;
        if (((ArrayList) this.i).size() <= r8) goto L52;
        ListProtector.remove(this.i, r8);
    L51:
        r8 = r8 + 1;
        goto L35
    L21:
        s("skip remove room: " + r5);
    L60:
        s("quitLand done: " + ((ArrayList) this.c).size() + " internalSize: " + this.K.size());
        dispatchChange();
        this.N = false;
        this.O = false;
        this.K = null;
        this.P = null;
        this.Q = null;
        this.L = null;
        this.M = -1;
        return;
    L54:
        Iterator<Room> r3 = this.K.iterator();
    L56:
        if (r3.hasNext() == false) goto L60;
        long r6 = r3.next().getRoomId();
        if (r6 == r4) goto L56;
        p(r6, null);
    L13:
        r4 = 0;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.landscapeslide.b
    public final int i() {
        ArrayList<Room> r0 = this.K;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.size();
    }

    public final int size() {
        List<Long> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return ((ArrayList) r0).size();
    }

    public final void y() {
        List<Room> r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.g != null) goto L7;
        return;
    L7:
        if (this.a == null) goto L30;
        r0.clear();
        int r1 = 0;
    L11:
        if (r1 >= this.a.size()) goto L21;
        long r2 = ((Long) ListProtector.get(this.a, r1)).longValue();
        if (r2 < 0) goto L21;
        if (this.g.containsKey(Long.valueOf(r2)) == false) goto L21;
        this.c.add(this.g.get(Long.valueOf(r2)));
        if (this.D == false) goto L20;
        FeedItem r3 = new FeedItem();
        r3.setRoom(this.g.get(Long.valueOf(r2)));
        this.i.add(r3);
    L20:
        r1 = r1 + 1;
    L21:
        dispatchChange();
        return;
    }

    public final void release() {
        super.release();
        if (this.s == false) goto L12;
        IHostBusiness r0 = k.f(IHostBusiness.class);
        if (r0 == null) goto L13;
        ILiveFeedCacheHelper r1 = r0.getLiveFeedCacheHelper();
        if (r1 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.t) == true) goto L15;
        ALogger.i("RandomAccessRoomListProvider", "removeCacheData " + this.t);
        r1.removeFeedCacheData(this.t);
        return;
    L15:
        return;
    L13:
        return;
    }

    @Override // pg2.e
    public final boolean d() {
        return this.u;
    }

    public final List<Room> getPreloadRooms() {
        return this.J;
    }

    @Override // pg2.e
    public final String j() {
        return this.A;
    }

    @Override // com.bytedance.android.livesdk.landscapeslide.b
    public final void a(int r18) {
        s("loadLand index: " + r18 + " isLimit: " + this.N + " isEnough: " + this.O);
        if (this.N == true) goto L5;
        f(r18);
        return;
    L5:
        if (this.O == true) goto L54;
        if (this.K != null) goto L9;
        return;
    L9:
        if (this.P == null) goto L76;
        int r1 = (e() + i()) + 1;
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        int r5 = 2;
        int r6 = r1;
        int r7 = r6;
    L12:
        int r10 = 0;
        if (r6 >= ((ArrayList) this.c).size()) goto L38;
        if (r5 <= 0) goto L38;
        if (q(r6) == true) goto L38;
        Room r8 = (Room) ListProtector.get(this.c, r6);
        Iterator<Room> r11 = this.K.iterator();
    L21:
        if (r11.hasNext() == false) goto L25;
        if (r11.next().getRoomId() != r8.getRoomId()) goto L21;
        r10 = 1;
    L25:
        if (r10 != 0) goto L37;
        if (f.b(r8, "loadmore") == false) goto L37;
        if (r7 != r6) goto L33;
        this.P.add(Long.valueOf(r8.getRoomId()));
        s("loading skip " + r7 + " " + r8.getRoomId());
        r7 = r7 + 1;
    L36:
        this.K.add(r8);
        r5 = r5 - 1;
        goto L37
    L33:
        if (this.D == false) goto L35;
        r3.add((FeedItem) ListProtector.get(this.i, r6));
    L35:
        r4.add(r8);
    L37:
        r6 = r6 + 1;
    L38:
        if (r5 <= 0) goto L41;
        this.O = true;
        s("limit land is enough");
    L41:
        if (r10 >= r4.size()) goto L46;
        Room r2 = (Room) ListProtector.get(r4, r10);
        ListProtector.add(this.c, r7, r2);
        ListProtector.add(this.a, r7, Long.valueOf(r2.getRoomId()));
        if (this.D == false) goto L45;
        ListProtector.add(this.i, r7, (FeedItem) ListProtector.get(r3, r10));
    L45:
        s("loading insert " + r7 + " " + r2.getRoomId());
        r7 = r7 + 1;
        r10 = r10 + 1;
        goto L41
    L46:
        s("load done size: " + this.K.size() + " insert: " + r1);
        if (this.K.isEmpty() == true) goto L49;
        this.L.isDataReady().setValue(Boolean.TRUE);
        this.L.isDataEmpty().setValue(Boolean.FALSE);
    L51:
        if (r4.isEmpty() == true) goto L72;
        dispatchChange();
        return;
    L72:
        return;
    L49:
        this.L.isDataEmpty().setValue(Boolean.TRUE);
        goto L51
    L76:
        return;
    L54:
        if (this.u == true) goto L74;
        loadMore(r18);
        return;
    }

    public final void addPreloadRooms(List<Room> r2) {
        if (Lists.isEmpty(r2) == false) goto L6;
        return;
    L6:
        if (this.J != null) goto L8;
        this.J = new ArrayList();
    L8:
        this.J.clear();
        this.J.addAll(r2);
    }

    @Override // pg2.e
    public final void f(int r26) {
        if (this.l == false) goto L5;
    L101:
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.g("RandomAccess  loadMoreForRecommend is isLoadMoreRunning = " + this.B + ", mDestroyFlag = " + this.l);
        return;
    L5:
        if (this.B == true) goto L101;
        FeedExtra r1 = this.v;
        if (r1 == null) goto L14;
        if (((Extra) r1).hasMore == true) goto L14;
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.g("RandomAccess loadMoreForRecommend hasmore is false");
        return;
    L14:
        if (this.L == null) goto L16;
    L17:
        LiveLandSlideContext r2 = this.L;
        if (r2 == null) goto L24;
        if (r2.checkLoad(2) == true) goto L24;
    L21:
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.g("RandomAccess loadMoreForRecommend unread has count > 2");
        return;
    L24:
        if (this.w != null) goto L26;
        this.w = new g();
    L26:
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.g("RandomAccess loadMoreForRecommend common load");
        HashMap<String, Object> r12 = new HashMap();
        r12.put("room_offset", Long.valueOf(this.x));
        if (c0.b().i <= 0) goto L29;
        r12.put("trigger_stay_duration", Long.valueOf(c0.b().i));
    L29:
        FeedExtra r3 = this.v;
        if (r3 != null) goto L32;
    L35:
        String r4 = "refresh";
    L36:
        r12.put("action_type", r4);
        if (((Integer) qr.a.getValue()).intValue() <= 0) goto L39;
        r12.put("viewed_history", com.bytedance.android.livesdk.log.c0.a());
    L39:
        FeedExtra r5 = this.v;
        if (r5 == null) goto L42;
        long r6 = r5.offset;
    L43:
        r12.put(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, Long.valueOf(r6));
        if (((ArrayList) this.i).size() <= 1) goto L46;
        List<FeedItem> r7 = this.i;
        long r8 = ((FeedItem) ListProtector.get(r7, ((ArrayList) r7).size() - 1)).latestWatchTime;
    L48:
        if (r8 <= 0) goto L50;
        r12.put("latest_watch_time", Long.valueOf(r8));
    L50:
        FeedExtra r9 = this.v;
        if (r9 != null) goto L53;
    L55:
        FeedExtra r10 = this.v;
        if (r10 == null) goto L58;
        long r23 = r10.maxTime;
    L60:
        if (this.y == 0) goto L62;
    L68:
        d r11 = this.H;
        String r13 = "";
        if (r11 == null) goto L71;
        String r14 = r11.a();
    L73:
        if (this.I == false) goto L81;
        Bundle r15 = this.j;
        if (r15 == null) goto L79;
        Bundle r16 = m0.a(r15);
        if (r16 == null) goto L79;
        r13 = r16.getString("enter_from_merge");
        String r17 = r16.getString("enter_method");
    L80:
        r14 = r13 + "_" + r17;
        l r18 = new l("/webcast/feed/");
        r18.c("source_key", r14);
        r18.a("need_map", 1);
        r18.a("show_type", 2);
        this.A = r18.d();
    L79:
        r17 = "";
    L81:
        String r19 = r14;
        if (this.w == null) goto L103;
        this.B = true;
        if (((Boolean) fu0.a.getValue()).booleanValue() == false) goto L99;
        Bundle r20 = this.j;
        if (r20 == null) goto L88;
        String r21 = r20.getString("live.intent.extra.MULTI_ROOM_PROVIDER");
    L90:
        if ("true".equals(r21) == false) goto L99;
        Bundle r22 = m0.a(this.j);
        if (r22 == null) goto L99;
        String r24 = r22.getString("live.intent.extra.FEED_URL_REQ_PARAMS");
        HashMap r25 = new HashMap();
        if (TextUtils.isEmpty(r24) == true) goto L96;
        r25.put("req_param", r24);
    L96:
        String r27 = h2.a(r25, this.A);
        if (StringUtils.isEmpty(r27) == true) goto L99;
        this.A += r27;
        goto L99
    L88:
        r21 = null;
    L99:
        this.n.add(this.w.e(r23, "", this.y, this.z, this.A, null, r12, -1, null, 1, 0, r19, false, false, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new if2.g(this), new h(this)));
        return;
    L103:
        return;
    L71:
        r14 = "";
        goto L73
    L62:
        if (((ArrayList) this.c).size() <= 0) goto L68;
        List<Room> r28 = this.c;
        Room r29 = (Room) ListProtector.get(r28, ((ArrayList) r28).size() - 1);
        if (r29 == null) goto L68;
        this.y = r29.getRoomId();
        User r30 = r29.getBaseOwner();
        if (r30 == null) goto L68;
        this.z = r30.getIdStr();
        goto L68
    L58:
        r23 = 0;
        goto L60
    L53:
        if (r9.directSort == false) goto L55;
        r12.put("content_category", 4);
        goto L55
    L46:
        r8 = 0;
        goto L48
    L42:
        r6 = 0;
        goto L43
    L32:
        if (r3.maxTime == 0) goto L35;
        r4 = "loadmore";
        goto L36
    L16:
        if ((r26 + 2) < ((ArrayList) this.c).size()) goto L21;
        goto L17
    }

    public final FeedItem getFeedItem(int r2) {
        if (this.D == true) goto L5;
    L8:
        if (r2 >= 0) goto L10;
        return null;
    L10:
        if (r2 < ((ArrayList) this.i).size()) goto L12;
        return null;
    L12:
        return (FeedItem) ListProtector.get(this.i, r2);
    L5:
        if (((ArrayList) this.i).size() <= r2) goto L8;
        return (FeedItem) ListProtector.get(this.i, r2);
    }

    public final Bundle getRoomArgs(int r7) {
        loadMore(r7);
        if (r7 >= 0) goto L5;
    L7:
        long r2 = 0;
    L8:
        Bundle r4 = (Bundle) ((HashMap) this.h).get(Long.valueOf(r2));
        if (r4 != null) goto L11;
        r4 = new Bundle();
        w(r2, r4);
        v(r2, r4);
        u(r2, r4);
    L11:
        if (r7 >= 0) goto L13;
    L19:
        if (r7 >= 0) goto L21;
    L27:
        return r4;
    L21:
        if (r7 >= ((ArrayList) this.e).size()) goto L27;
        if (ListProtector.get(this.e, r7) == null) goto L27;
        if (((Long) ListProtector.get(this.e, r7)).longValue() == 0) goto L27;
        r4.putString("joint_anchor_id", ((Long) ListProtector.get(this.e, r7)).toString());
        goto L27
    L13:
        if (r7 >= ((ArrayList) this.d).size()) goto L19;
        if (ListProtector.get(this.d, r7) == null) goto L19;
        if (((Long) ListProtector.get(this.d, r7)).longValue() == 0) goto L19;
        r4.putString("link_user_id", ((Long) ListProtector.get(this.d, r7)).toString());
        goto L19
    L5:
        if (r7 >= ((ArrayList) this.a).size()) goto L7;
        r2 = ((Long) ListProtector.get(this.a, r7)).longValue();
        goto L8
    }

    public final int indexOf(Bundle r5) {
        long r0 = r5.getLong("live.intent.extra.ROOM_ID", 0);
        List<Boolean> r2 = this.b;
        if (r2 != null) goto L5;
    L12:
        List<Long> r6 = this.a;
        ArrayList r7 = (ArrayList) r6;
        return r7.indexOf(Long.valueOf(r0));
    L5:
        if (((ArrayList) r2).size() != ((ArrayList) this.a).size()) goto L12;
        boolean r8 = r5.getBoolean("live.intent.extra.IS_PSEUDO_LIVING", false);
        List<Long> r3 = this.a;
        ArrayList r4 = (ArrayList) r3;
        int r1 = r4.indexOf(Long.valueOf(r0));
        if (r1 != (-1)) goto L9;
    L11:
        return -1;
    L9:
        if (((Boolean) ListProtector.get(this.b, r1)).booleanValue() != r8) goto L11;
        return r1;
    }

    @Override // pg2.e
    public final void l(String r1) {
        this.A = r1;
    }

    public final void loadMore(final int r25) {
        if (this.l == false) goto L5;
        return;
    L5:
        if (this.k == true) goto L113;
        List<Room> r2 = this.c;
        int r4 = 0;
        if (r2 != null) goto L10;
    L48:
        d r3 = this.H;
        if (r3 == null) goto L51;
        boolean r5 = r3.b();
    L53:
        if (this.u == false) goto L59;
        if (r5 == false) goto L56;
    L57:
        h31 r1 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a;
        return;
    L56:
        if (this.I == true) goto L57;
    L59:
        List<Room> r6 = this.c;
        if (r6 != null) goto L62;
    L103:
        h31 r7 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a;
        this.u = true;
        return;
    L62:
        if (this.a == null) goto L103;
        if (((ArrayList) r6).size() >= ((ArrayList) this.a).size()) goto L103;
        if (this.L == null) goto L69;
    L70:
        LiveLandSlideContext r8 = this.L;
        if (r8 != null) goto L73;
    L75:
        int r9 = ((ArrayList) this.c).size();
        if (((Boolean) tl0.a.getValue()).booleanValue() == false) goto L81;
        if (r9 != 1) goto L79;
    L80:
        r9 = 0;
        goto L81
    L79:
        if (r9 == this.r) goto L80;
    L81:
        int r10 = Math.min(((ArrayList) this.a).size(), Math.max(((Integer) fa1.a.getValue()).intValue(), 1) + r9) - r9;
        final long[] r11 = new long[r10];
    L82:
        if (r4 >= r10) goto L89;
        Long r12 = (Long) ListProtector.get(this.a, r9 + r4);
        if (r12 != null) goto L86;
        long r13 = 0;
    L87:
        r11[r4] = r13;
        r4 = r4 + 1;
        goto L82
    L86:
        r13 = r12.longValue();
        goto L87
    L89:
        if (this.s == false) goto L101;
        String r14 = this.t;
        this.k = true;
        IHostBusiness r15 = k.f(IHostBusiness.class);
        if (r15 == null) goto L95;
        ILiveFeedCacheHelper r16 = r15.getLiveFeedCacheHelper();
        if (r16 == null) goto L95;
        ALogger.i("RandomAccessRoomListProvider", "getRoomFromFollowSkyFeedData is direct");
        Observable r17 = r16.getLiveFeedCacheHelper(r11, r14);
    L96:
        if (r17 != null) goto L98;
        r(r25, r11);
        return;
    L98:
        Disposable r18 = r17.observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this, r11, r25), new j(this, r25, r11));
        CompositeDisposable r19 = this.n;
        if (r19 == null) goto L110;
        r19.add(r18);
        return;
    L110:
        return;
    L95:
        r17 = null;
        goto L96
    L101:
        r(r25, r11);
        return;
    L73:
        if (r8.checkLoad(5) == true) goto L75;
        return;
    L69:
        if ((r25 + 5) > ((ArrayList) this.c).size()) goto L70;
        return;
    L51:
        r5 = false;
        goto L53
    L10:
        if (((ArrayList) r2).isEmpty() == true) goto L48;
        if (this.p == false) goto L48;
        if (this.q == false) goto L48;
        if (this.l == false) goto L18;
    L45:
        m4.a("pre condition intercept, maybe is requesting or destroyed");
    L46:
        this.p = false;
        return;
    L18:
        if (this.B == true) goto L45;
        if (this.k == true) goto L45;
        if (this.w != null) goto L25;
        m4.a("listModel is null, create a new instance");
        this.w = new g();
    L25:
        m4.a("start top list loading");
        Bundle r20 = this.j;
        if (r20 == null) goto L30;
        Bundle r21 = m0.a(r20);
        if (r21 == null) goto L30;
        String r22 = r21.getString("enter_from_merge");
        String r110 = r21.getString("enter_method");
        String r111 = r22;
    L32:
        if (TextUtils.isEmpty(r111) == false) goto L34;
    L44:
        m4.a("empty enterFromMerge or empty enterMethod");
        goto L46
    L34:
        if (TextUtils.isEmpty(r110) == true) goto L44;
        this.B = true;
        this.k = true;
        g r23 = this.w;
        ArrayList r112 = new ArrayList(this.a);
        r23.getClass();
        Intrinsics.checkNotNullParameter(r112, "roomIds");
        Intrinsics.checkNotNullParameter(r111, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r110, "enterMethod");
        u.l().c(x.class);
        String r113 = r111 + "_" + r110;
        String r114 = CollectionsKt.joinToString$default(r112, ",", null, null, 0, null, null, 62, null);
        com.bytedance.android.livesdk.service.f r24 = TTLiveSDKContext.getHostService();
        if (r24 == null) goto L42;
        f0 r26 = r24.h();
        if (r26 == null) goto L42;
        String r27 = r26.n();
        if (r27 == null) goto L42;
    L43:
        com.bytedance.android.livesdk.service.l.d().getClass();
        this.n.add(((FeedApi) c.b().e(FeedApi.class)).feed(1, 1, r113, r27, r114, r113, r111, r110).map(kf2.a.a).doOnNext(new kf2.b(r23)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new if2.l(this), new m(this)));
    L42:
        r27 = BDLocationException.ERROR_TIMEOUT;
    L30:
        r111 = "";
        r110 = r111;
        goto L32
    }

    @Override // pg2.e
    public final void m(pg2.i r1) {
        this.H = r1;
    }

    public final void n(Room r4) {
        Bundle r0 = this.j;
        if (r0 == null) goto L10;
        String r1 = r0.getString("live.intent.extra.REQUEST_ID");
        String r2 = this.j.getString("live.intent.extra.LOG_PB");
        if (TextUtils.isEmpty(r1) == false) goto L8;
        r1 = this.j.getString("request_id");
    L8:
        if (TextUtils.isEmpty(r2) == false) goto L12;
        r2 = this.j.getString("log_pb");
    L12:
        if (r4.getLog_pb() != null) goto L14;
    L15:
        r4.setLog_pb(r2);
    L17:
        if (r4.getRequestId() != null) goto L19;
    L20:
        r4.setRequestId(r1);
        return;
    L19:
        if (r4.getRequestId().length() == 0) goto L20;
        return;
    L14:
        if (r4.getLog_pb().length() != 0) goto L17;
    L10:
        r2 = "";
        r1 = "";
        goto L12
    }

    public final boolean o(FeedExtra r5) {
        Bundle r0 = this.j;
        if (r0 == null) goto L30;
        String r1 = r0.getString("pre_enter_from");
        if (r1 == null) goto L30;
        if (((List) du.a.getValue()).contains(r1) == false) goto L30;
        h31 r2 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a;
        Intrinsics.checkNotNullParameter(r1, "enterComponent");
        boolean r3 = false;
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.b() == false) goto L22;
        h31 r4 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a;
        if (r4 == null) goto L22;
        Map r6 = r4.c();
        if (r6 == null) goto L22;
        if (r6.containsKey(r1) != true) goto L22;
        r4 r7 = (r4) com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a.c().get(r1);
        if (r7 == null) goto L22;
        if (r7.h() != true) goto L22;
        r3 = true;
    L22:
        if (r3 == false) goto L30;
        if (this.u == false) goto L28;
        if (r5 == null) goto L28;
        return ((Extra) r5).hasMore;
    L28:
        return true;
    L30:
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a(this.G) == true) goto L32;
        if (r5 == null) goto L41;
        return ((Extra) r5).hasMore;
    L41:
        return this.u;
    L32:
        if (this.u == false) goto L36;
        if (r5 == null) goto L36;
        return ((Extra) r5).hasMore;
    L36:
        return true;
    }

    public final boolean q(int r3) {
        if (r3 >= 0) goto L4;
        return false;
    L4:
        if (r3 >= ((ArrayList) this.c).size()) goto L11;
        Map<Long, Bundle> r0 = this.h;
        HashMap r1 = (HashMap) r0;
        Bundle r4 = (Bundle) r1.get(ListProtector.get(this.a, r3));
        if (r4 != null) goto L8;
        return false;
    L8:
        return com.bytedance.android.livesdk.chatroom.followrecommendguide.a.d(r4.getString("live.intent.extra.LIVE_FOLLOW_RECOMMEND_UNREAD_EXTRA", ""));
    L11:
        return false;
    }

    public final void removeFeedItem(FeedItem r9) {
        if (this.D == true) goto L6;
        super.removeFeedItem(r9);
        return;
    L6:
        if (r9 != null) goto L8;
        return;
    L8:
        int r0 = 0;
    L10:
        if (r0 >= ((ArrayList) this.i).size()) goto L17;
        FeedItem r1 = (FeedItem) ListProtector.get(this.i, r0);
        if (r1 == null) goto L16;
        int r2 = com.bytedance.android.livesdk.feedback.b.a;
        Intrinsics.checkNotNullParameter(r1, "item1");
        Intrinsics.checkNotNullParameter(r9, "item2");
        if (com.bytedance.android.livesdk.feedback.c.c(r1, r9) == false) goto L16;
    L18:
        if (r0 >= 0) goto L20;
        return;
    L20:
        if (r0 >= ((ArrayList) this.i).size()) goto L51;
        ListProtector.remove(this.i, r0);
        FeedbackCard r10 = r9.feedbackCard;
        if (r10 == null) goto L26;
        Long r11 = r10.feedbackId;
        if (r11 == null) goto L26;
        long r3 = r11.longValue();
    L27:
        Room r12 = new Room();
        r12.setId(r3);
        if (r0 >= ((ArrayList) this.c).size()) goto L35;
        if (ListProtector.get(this.c, r0) == null) goto L35;
        if (((Room) ListProtector.get(this.c, r0)).getRoomId() != r12.getRoomId()) goto L35;
        ListProtector.remove(this.c, r0);
    L35:
        if (r0 >= ((ArrayList) this.a).size()) goto L42;
        if (ListProtector.get(this.a, r0) == null) goto L42;
        if (((Long) ListProtector.get(this.a, r0)).longValue() != r12.getRoomId()) goto L42;
        ListProtector.remove(this.a, r0);
    L42:
        if (r12.getRoomId() <= 0) goto L44;
        ((HashMap) this.h).remove(Long.valueOf(r12.getRoomId()));
    L44:
        dispatchChange();
        return;
    L26:
        r3 = 0;
        goto L27
    L51:
        return;
    L16:
        r0 = r0 + 1;
        goto L10
    L17:
        r0 = -1;
        goto L18
    }

    public final void removeRoom(long r2) {
        p(r2, new if2.k(this, r2));
    }

    public final void s(String r3) {
        f.c("Random: " + r3, "LiveLandScapeSlideExtUtil");
    }

    public final void setLoadMoreCallback(ILoadMore.ILoadMoreCallback r2) {
        if (this.F != null) goto L6;
        this.F = r2;
        return;
    }

    @Override // com.bytedance.android.livesdk.landscapeslide.b
    public final void c(int r4, LiveLandSlideContext r5) {
        s("initLand index: " + r4 + " list: " + f.e(this.c, r4, new n(this)));
        boolean r0 = q(r4) ^ true;
        this.N = r0;
        if (r0 == false) goto L5;
        this.P = new HashSet();
        this.Q = new HashSet();
    L5:
        this.L = r5;
        this.K = new ArrayList();
        this.M = r4;
        a(r4);
    }

    @Override // pg2.e
    public final void g(long r1, int r3) {
        if (this.N == false) goto L8;
        HashSet<Long> r4 = this.Q;
        if (r4 == null) goto L9;
        r4.add(Long.valueOf(r1));
        return;
    L9:
        return;
    }

    public final void p(long r4, Function1<Integer, Void> r6) {
        if (r4 <= 0) goto L44;
        List<Long> r0 = this.a;
        if (r0 != null) goto L7;
        return;
    L7:
        if (this.c != null) goto L9;
        return;
    L9:
        if (this.h != null) goto L12;
        return;
    L12:
        if (((ArrayList) r0).size() != 1) goto L14;
        return;
    L14:
        List<Long> r1 = this.a;
        ArrayList r2 = (ArrayList) r1;
        int r3 = r2.indexOf(Long.valueOf(r4));
        if (r3 != (-1)) goto L17;
        return;
    L17:
        if (r3 >= ((ArrayList) this.a).size()) goto L20;
        ListProtector.remove(this.a, r3);
    L20:
        if (r3 >= ((ArrayList) this.b).size()) goto L23;
        ListProtector.remove(this.b, r3);
    L23:
        if (r3 >= ((ArrayList) this.c).size()) goto L25;
        ListProtector.remove(this.c, r3);
    L25:
        List<Long> r5 = this.d;
        if (r5 != null) goto L28;
    L30:
        List<Long> r7 = this.e;
        if (r7 == null) goto L36;
        if (((ArrayList) r7).size() <= r3) goto L36;
        ListProtector.remove(this.e, r3);
    L36:
        if (this.D == true) goto L38;
    L40:
        Map<Long, Room> r8 = this.g;
        HashMap r9 = (HashMap) r8;
        r9.remove(Long.valueOf(r4));
        Map<Long, Bundle> r10 = this.h;
        HashMap r11 = (HashMap) r10;
        r11.remove(Long.valueOf(r4));
        if (r6 == null) goto L48;
        if2.k r12 = (if2.k) r6;
        r12.invoke(Integer.valueOf(r3));
        return;
    L48:
        return;
    L38:
        if (((ArrayList) this.i).size() <= r3) goto L40;
        ListProtector.remove(this.i, r3);
        goto L40
    L28:
        if (((ArrayList) r5).size() <= r3) goto L30;
        ListProtector.remove(this.d, r3);
        goto L30
    }

    public final void r(final int r3, final long[] r4) {
        if (k.f(IRoomModuleService.class) != null) goto L5;
        return;
    L5:
        this.k = true;
        Disposable r5 = k.f(IRoomModuleService.class).getRoomManager().p0(r4).observeOn(AndroidSchedulers.mainThread()).subscribe(new if2.e(this, r4, r3), new if2.f(this, r3));
        CompositeDisposable r6 = this.n;
        if (r6 == null) goto L9;
        r6.add(r5);
        return;
    }

    public final void t(Pair<List<FeedItem>, FeedExtra> r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.g("parseAndDispatch start");
        List r0 = (List) r10.first;
        FeedExtra r12 = (FeedExtra) r10.second;
        if (r0 != null) goto L7;
    L59:
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.g("parseAndDispatch items is empty");
        return;
    L7:
        if (r0.isEmpty() == true) goto L59;
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.g("parseAndDispatch items size = " + r0.size());
        int r1 = 0;
    L11:
        if (r1 >= r0.size()) goto L57;
        FeedItem r2 = (FeedItem) ListProtector.get(r0, r1);
        if (r2 == null) goto L14;
        Room r3 = r2.getRoom();
        if (r3 == null) goto L56;
        long r4 = r3.getRoomId();
        List<Long> r6 = this.a;
        if (r6 != null) goto L21;
    L23:
        boolean r5 = false;
    L24:
        if (r5 == false) goto L26;
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.g("RandomAccess parseAndDispatch isRemoveDuplicateRoom roomId = " + r3.getRoomId());
        goto L56
    L26:
        if (r11 >= 0) goto L28;
    L30:
        long r7 = r3.getRoomId();
        n(r3);
        ((HashMap) this.g).put(Long.valueOf(r7), r3);
        if (r11 >= 0) goto L33;
        ((ArrayList) this.a).add(Long.valueOf(r7));
    L34:
        Bundle r8 = ArgumentsBuilder.buildRoomArgs(r3);
        FeedExtra r9 = this.v;
        if (r8 == null) goto L43;
        if (r9 == null) goto L43;
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.e() == false) goto L43;
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.d(r9.unreadExtra) == false) goto L43;
        r8.putString("live.intent.extra.LIVE_FOLLOW_RECOMMEND_UNREAD_EXTRA", r9.unreadExtra);
    L43:
        w(r7, r8);
        v(r7, r8);
        u(r7, r8);
        if (((HashMap) this.h).get(Long.valueOf(r7)) == null) goto L46;
        ((Bundle) ((HashMap) this.h).get(Long.valueOf(r7))).putAll(r8);
    L47:
        if (r11 >= 0) goto L49;
        ((ArrayList) this.c).add(r3);
    L50:
        if (r11 >= 0) goto L53;
        ((ArrayList) this.i).add(r2);
        goto L56
    L53:
        if (this.D == false) goto L55;
        ListProtector.add(this.i, r11, r2);
    L55:
        r11 = r11 + 1;
        goto L56
    L49:
        ListProtector.add(this.c, r11, r3);
        this.K.add(r3);
        goto L50
    L46:
        ((HashMap) this.h).put(Long.valueOf(r7), r8);
        goto L47
    L33:
        ListProtector.add(this.a, r11, Long.valueOf(r7));
        goto L34
    L28:
        if (f.b(r3, "random-loadmore") == true) goto L30;
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.g("parseAndDispatch land slide is not support roomId = " + r3.getRoomId());
        goto L56
    L21:
        if (((ArrayList) r6).contains(Long.valueOf(r4)) == false) goto L23;
        r5 = true;
    L56:
        r1 = r1 + 1;
        goto L11
    L14:
        return;
    L57:
        dispatchChange();
        this.B = false;
        this.x++;
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.g("parseAndDispatch end");
    }

    public final void u(long r3, Bundle r5) {
        if (this.a != null) goto L5;
        return;
    L5:
        if (this.b != null) goto L8;
        return;
    L8:
        if (this.f.get(r3) != null) goto L10;
        return;
    L10:
        if (this.f.get(r3).intValue() < 0) goto L17;
        r5.putInt(VSConstants.EXTRA_ITEM_TYPE, this.f.get(r3).intValue());
        return;
    }

    public final void v(long r3, Bundle r5) {
        List<Long> r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.b == null) goto L16;
        ArrayList r1 = (ArrayList) r0;
        int r4 = r1.indexOf(Long.valueOf(r3));
        if (r4 >= 0) goto L10;
        return;
    L10:
        if (r4 >= ((ArrayList) this.b).size()) goto L17;
        r5.putBoolean("live.intent.extra.IS_PSEUDO_LIVING", ((Boolean) ListProtector.get(this.b, r4)).booleanValue());
        return;
    L17:
        return;
    }

    public final void w(long r4, Bundle r6) {
        r6.putLong("live.intent.extra.ROOM_ID", r4);
        if (n0.b(n0.c(r6, "anchor_id")) == true) goto L10;
        Map<Long, Room> r1 = this.g;
        if (r1 == null) goto L11;
        HashMap r2 = (HashMap) r1;
        if (r2.get(Long.valueOf(r4)) == null) goto L12;
        Map<Long, Room> r3 = this.g;
        HashMap r5 = (HashMap) r3;
        r6.putString("anchor_id", ((Room) r5.get(Long.valueOf(r4))).getOwnerUserIdString());
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void x(int r3, FeedExtra r4) {
        ILoadMore.ILoadMoreCallback r0 = this.F;
        if (r0 == null) goto L6;
        r0.onSuccess(r3, o(r4), false);
        return;
    }

    public final void insertFeedItem(FeedItem r9, Room r10, Bundle r11, Long r12) {
        if (this.D == true) goto L6;
        super.insertFeedItem(r9, r10, r11, r12);
        return;
    L6:
        if (r9 != null) goto L8;
        return;
    L8:
        if (r12.longValue() == 0) goto L54;
        int r0 = 0;
    L12:
        if (r0 >= ((ArrayList) this.c).size()) goto L19;
        if (ListProtector.get(this.c, r0) == null) goto L18;
        if (((Room) ListProtector.get(this.c, r0)).getRoomId() != r12.longValue()) goto L18;
    L20:
        if (r0 >= 0) goto L23;
        return;
    L23:
        if (r0 < ((ArrayList) this.i).size()) goto L25;
    L27:
        if (r10 != null) goto L29;
        Room r13 = r9.getRoom();
    L31:
        if (r0 >= ((ArrayList) this.c).size()) goto L34;
        ListProtector.add(this.c, r0 + 1, r13);
    L34:
        if (r0 < ((ArrayList) this.a).size()) goto L36;
    L38:
        new Bundle();
        if (r11 != null) goto L42;
        r11 = ArgumentsBuilder.buildRoomArgs(r13);
    L42:
        if (r10.getRoomId() <= 0) goto L45;
        w(r10.getRoomId(), r11);
    L45:
        if (r10.getRoomId() <= 0) goto L47;
        Map<Long, Bundle> r14 = this.h;
        HashMap r15 = (HashMap) r14;
        r15.put(Long.valueOf(r10.getRoomId()), r11);
    L47:
        dispatchChange();
        return;
    L36:
        if (r10.getRoomId() <= 0) goto L38;
        ListProtector.add(this.a, r0 + 1, Long.valueOf(r10.getRoomId()));
        goto L38
    L29:
        r13 = r10;
        goto L31
    L25:
        if (r10.getRoomId() <= 0) goto L27;
        ListProtector.add(this.i, r0 + 1, r9);
    L18:
        r0 = r0 + 1;
        goto L12
    L19:
        r0 = -1;
        goto L20
    }

    public RandomAccessRoomListProvider(Lifecycle r18, List<Long> r19, List<Integer> r20, List<Boolean> r21, Bundle r22, List<Long> r23, List<Long> r24) {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new LongSparseArray();
        this.g = new HashMap();
        this.h = new HashMap();
        this.i = new ArrayList();
        this.j = null;
        this.k = false;
        this.l = false;
        this.m = 2;
        this.n = new CompositeDisposable();
        this.o = k.f(IRadioService.class).createRadioBundleInserter();
        this.p = false;
        this.q = false;
        this.r = 1;
        this.s = false;
        String r10 = "";
        this.t = "";
        this.u = false;
        this.x = 0;
        this.y = 0;
        this.z = BDLocationException.ERROR_TIMEOUT;
        this.A = "";
        this.B = false;
        this.C = 0;
        this.D = ((Boolean) nv.a.getValue()).booleanValue();
        this.E = true;
        this.F = null;
        this.G = "";
        this.I = false;
        this.J = new ArrayList();
        this.K = null;
        this.L = null;
        this.M = -1;
        this.N = false;
        this.O = false;
        this.P = null;
        this.Q = null;
        int r14 = 0;
    L4:
        if (r14 >= ((ArrayList) r19).size()) goto L15;
        ((ArrayList) this.a).add((Long) ListProtector.get(r19, r14));
        if (r14 >= ((ArrayList) r20).size()) goto L9;
        this.f.put(((Long) ListProtector.get(r19, r14)).longValue(), (Integer) ListProtector.get(r20, r14));
    L9:
        if (r14 >= ((ArrayList) r23).size()) goto L12;
        ((ArrayList) this.d).add((Long) ListProtector.get(r23, r14));
    L12:
        if (r14 >= ((ArrayList) r24).size()) goto L14;
        ((ArrayList) this.e).add((Long) ListProtector.get(r24, r14));
    L14:
        r14 = r14 + 1;
        goto L4
    L15:
        int r2 = 0;
    L17:
        if (r2 >= ((ArrayList) r21).size()) goto L19;
        ((ArrayList) this.b).add((Boolean) ListProtector.get(r21, r2));
        r2 = r2 + 1;
        goto L17
    L19:
        this.j = r22;
        this.I = r22.getBoolean("live.intent.extra.IS_ENTER_FROM_LITE_LITE", false);
        if (((ArrayList) r19).size() != 1) goto L23;
        this.q = true;
    L23:
        if (r22.getInt("request_feed_once", 0) != 1) goto L25;
        boolean r3 = true;
    L26:
        this.p = r3;
        if (r3 == false) goto L29;
        r22.putInt("request_feed_once", 0);
    L29:
        m4.a("requestFeedOnce = " + this.p);
        if (this.g != null) goto L32;
    L39:
        this.s = r22.getBoolean("live.intent.extra.EXTRA_FOLLOW_SKY_FEED_DATA_KEY", false);
        this.t = r22.getString("live.intent.extra.EXTRA_FOLLOW_SKY_FEED_DATA_EXTRA_TOKEN", "");
        Bundle r1 = m0.a(r22);
        if (r1 == null) goto L48;
        String r4 = r1.getString("enter_from_merge", "");
        String r5 = r1.getString("enter_method", "");
        if (r5 == null) goto L46;
        if (r4 == null) goto L46;
        r10 = r4 + "-" + r5;
    L46:
        this.G = r10;
    L48:
        if (this.g != null) goto L50;
    L75:
        r18.addObserver(this);
        loadMore(0);
        return;
    L50:
        if (this.h == null) goto L75;
        if (this.s == true) goto L75;
        SparseArray r6 = yt2.a.d(r22);
        if (r6 == null) goto L75;
        int r7 = 0;
    L58:
        if (r7 >= r6.size()) goto L74;
        Bundle r8 = (Bundle) r6.get(r7);
        long r11 = r8.getLong("live.intent.extra.ROOM_ID", 0);
        if (r11 <= 0) goto L73;
        if (((ArrayList) this.a).contains(Long.valueOf(r11)) == false) goto L73;
        this.r++;
        Room r9 = new Room();
        r9.setId(r11);
        r9.setIdStr(String.valueOf(r11));
        r9.setIsFromRecommendCard(!TextUtils.isEmpty(r8.getString("enter_from_merge_recommend", null)));
        r9.setLiveReason(r8.getString("live_reason", null));
        new User().setIdString(r9.getOwnerUserIdString());
        r9.setOwner(new User());
        n(r9);
        Bundle r12 = (Bundle) ((HashMap) this.h).get(Long.valueOf(r11));
        if (r12 != null) goto L67;
        r12 = new Bundle();
    L67:
        r12.putString("live.intent.extra.REQUEST_ID", r9.getRequestId());
        r12.putString("live.intent.extra.LOG_PB", r9.getLog_pb());
        r12.putAll(r8);
        u(r11, r12);
        v(r11, r12);
        if (r7 >= ((ArrayList) this.b).size()) goto L70;
        boolean r13 = ((Boolean) ListProtector.get(this.b, r7)).booleanValue();
    L71:
        r12.putBoolean("live.intent.extra.IS_PSEUDO_LIVING", r13);
        v(r11, r12);
        ((HashMap) this.g).put(Long.valueOf(r11), r9);
        ((HashMap) this.h).put(Long.valueOf(r11), r12);
        goto L73
    L70:
        r13 = false;
    L73:
        r7 = r7 + 1;
        goto L58
    L74:
        y();
        goto L75
    L32:
        if (this.h == null) goto L39;
        if (r22.getLong("live.intent.extra.ROOM_ID", 0) == 0) goto L39;
        long r15 = r22.getLong("live.intent.extra.ROOM_ID", 0);
        this.C = r15;
        if (((ArrayList) this.a).indexOf(Long.valueOf(r15)) == (-1)) goto L39;
        Bundle r16 = new Bundle(r22);
        ((HashMap) this.h).put(Long.valueOf(r15), r16);
        Room r17 = new Room();
        r17.setId(r15);
        r17.setIdStr(String.valueOf(r15));
        ((HashMap) this.g).put(Long.valueOf(r15), r17);
        this.r = 1;
        y();
        goto L39
    L25:
        r3 = false;
        goto L26
    }
}
