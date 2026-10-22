package cw1;

import android.util.Pair;
import bw1.e;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.feed.IFeedRepository;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.TabListModel;
import com.bytedance.android.livesdk.log.a0;
import com.bytedance.android.livesdk.log.c0;
import com.bytedance.android.livesdk.viewmodel.SingleDrawViewModel;
import com.bytedance.android.livesdk.viewmodel.j;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.m;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends bw1.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f465563d;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f465564a = null;

        static {
            f465564a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            BaseListResponse r101 = (BaseListResponse) r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            ArrayList r102 = new ArrayList();
            List<T> r103 = r101.data;
            if (r103 == null) goto L6;
            r102.addAll(r103);
        L6:
            return Pair.create(r102, r101.extra);
        }
    }

    /* JADX INFO: renamed from: cw1.b$b, reason: collision with other inner class name */
    public static final class C5597b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f465565a;

        public C5597b(b r100) {
            this.f465565a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Pair r101 = (Pair) r100;
            if (r101 == null) goto L5;
            List r102 = (List) r101.first;
        L6:
            if (r102 != null) goto L8;
            return;
        L8:
            if (((List) r101.first).isEmpty() == true) goto L44;
            Object r103 = r101.second;
            if (r103 == null) goto L46;
            JsonObject r104 = ((FeedExtra) r103).getLogPb();
            if (r104 == null) goto L45;
            Iterator<T> r105 = ((Iterable) r101.first).iterator();
        L16:
            if (r105.hasNext() == false) goto L47;
            FeedItem r106 = (FeedItem) r105.next();
            r106.logPb = r104.toString();
            this.f465565a.getClass();
            int r107 = r106.type;
            if (r107 == 1) goto L22;
            if (r107 != 2) goto L16;
        L22:
            if ((r106.getItem() instanceof Room) == false) goto L16;
            Item r108 = r106.getItem();
            if (r108 == null) goto L33;
            Room r109 = (Room) r108;
            r109.setLog_pb(r106.logPb);
            User r110 = r109.mo8271getOwner();
            if (r110 == null) goto L31;
            String r111 = r106.logPb;
            if (r111 != null) goto L30;
            r111 = "";
        L30:
            r110.setLogPb(r111);
        L31:
            r109.setRequestId(r106.resId);
            r109.setIsFromRecommendCard(r106.isRecommendCard);
            r109.setLiveReason(r106.liveReason);
            goto L16
        L33:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.Room");
        L47:
            return;
        L45:
            return;
        L46:
            return;
        L44:
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f465566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f465567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f465568c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f465569d;

        public c(b r100, e r101, long r102, int r103) {
            this.f465566a = r100;
            this.f465567b = r101;
            this.f465568c = r102;
            this.f465569d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Pair r101 = (Pair) r100;
            SingleDrawViewModel r102 = this.f465566a.f21000a;
            if (r102 == null) goto L5;
            r102.setFetchingData(false);
        L5:
            if (r101 == null) goto L23;
            FeedExtra r103 = (FeedExtra) r101.second;
            if (r103 == null) goto L12;
            e r104 = this.f465567b;
            if (r104 == null) goto L12;
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r104.f21005c = r103;
        L12:
            Object r105 = r101.first;
            if (r105 != null) goto L15;
            return;
        L15:
            if (((List) r105).isEmpty() == true) goto L24;
            TabListModel r106 = this.f465566a.f21001b;
            if (r106 == null) goto L22;
            r106.onDataUpdata(this.f465568c, (List) r101.first, this.f465569d);
            return;
        L22:
            return;
        L24:
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f465570a;

        public d(b r100) {
            this.f465570a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            SingleDrawViewModel r102 = this.f465570a.f21000a;
            if (r102 == null) goto L6;
            r102.setFetchingData(false);
            return;
        }
    }

    @Override // bw1.d
    public final void a() {
    }

    public b() {
    }

    @Override // bw1.d
    public final void b(long r110) {
        TabListModel r100 = this.f21001b;
        if (r100 == null) goto L5;
        r100.setCurrentStatus(2);
    L5:
        TabListModel r101 = this.f21001b;
        if (r101 == null) goto L12;
        e r102 = r101.getCurrentTabModel();
        if (r102 == null) goto L12;
        FeedExtra r103 = r102.f21005c;
        if (r103 == null) goto L12;
        long r104 = r103.maxTime;
    L13:
        long r105 = r104;
        TabListModel.Companion.getClass();
        e(r105, TabListModel.access$getREQ_FROM_FEED_LOAD_MORE$cp(), r110, 2);
        return;
    L12:
        r104 = 0;
        goto L13
    }

    @Override // bw1.d
    public final void c(long r110) {
        TabListModel r100 = this.f21001b;
        if (r100 == null) goto L5;
        r100.setCurrentStatus(1);
    L5:
        TabListModel.Companion.getClass();
        e(0, TabListModel.access$getREQ_FROM_ENTER_AUTO$cp(), r110, 1);
    }

    @Override // bw1.d
    public final void d(long r110) {
        TabListModel r100 = this.f21001b;
        if (r100 == null) goto L5;
        r100.setCurrentStatus(0);
    L5:
        TabListModel r101 = this.f21001b;
        if (r101 == null) goto L26;
        e r102 = r101.getCurrentTabModel();
        if (r102 == null) goto L26;
        LinkedList<FeedItem> r103 = r102.f21004b;
        if (r103 == null) goto L26;
        if ((!r103.isEmpty()) != true) goto L26;
        SingleDrawViewModel r111 = this.f21000a;
        if (r111 == null) goto L28;
        NextLiveData<j> r112 = r111.getItemsUpdate();
        if (r112 == null) goto L29;
        TabListModel r104 = this.f21001b;
        if (r104 == null) goto L24;
        e r105 = r104.getCurrentTabModel();
        if (r105 == null) goto L24;
        List r106 = r105.f21004b;
        if (r106 == null) goto L24;
    L25:
        r112.postValue(new j(r106, true));
        return;
    L24:
        r106 = CollectionsKt.emptyList();
        goto L25
    L29:
        return;
    L28:
        return;
    L26:
        TabListModel.Companion.getClass();
        e(0, TabListModel.access$getREQ_FROM_ENTER_AUTO$cp(), r110, 0);
    }

    public final void e(long r110, String r111, long r210, @IFeedRepository.FEED_ACTION int r211) {
        Intrinsics.checkNotNullParameter(r111, "from");
        TabListModel r100 = this.f21001b;
        Disposable r101 = null;
        if (r100 == null) goto L5;
        e r102 = r100.getCurrentTabModel();
    L6:
        if (r102 == null) goto L8;
        FeedExtra r103 = r102.f21005c;
    L9:
        if (r103 == null) goto L19;
        if (r102 == null) goto L19;
        FeedExtra r104 = r102.f21005c;
        if (r104 == null) goto L19;
        if (r104.hasMore == true) goto L19;
        if (r211 != 2) goto L19;
        return;
    L19:
        if (r102 == null) goto L21;
        String r105 = r102.e(uv1.c.c(r102.f21008f));
    L22:
        if (r102 == null) goto L24;
        String r112 = r102.f();
    L26:
        if (r102 == null) goto L28;
        long r106 = r102.g();
    L29:
        FeedApi r107 = (FeedApi) com.bytedance.android.live.network.c.b().e(FeedApi.class);
        int r113 = TimeZone.getDefault().getRawOffset() / 1000;
        HashMap r114 = new HashMap();
        r114.put("action_type", r111);
        r114.put("req_from", r111);
        if (r106 <= 0) goto L32;
        r114.put("draw_room_tag_id", Long.valueOf(r106));
    L32:
        r114.put("viewed_history", c0.a());
        r114.put("viewed_room_details", a0.a());
        RoomContext.a r108 = RoomContext.Companion;
        if (RoomContext.a.c(r108, null, 0, 3) == null) goto L35;
        RoomContext r115 = RoomContext.a.c(r108, null, 0, 3);
        Intrinsics.checkNotNull(r115);
        Room r116 = r115.getRoom().getValue();
    L37:
        if (r116 == null) goto L75;
        RoomContext r117 = RoomContext.a.c(r108, null, 0, 3);
        if (r117 == null) goto L75;
        if (r117.isVSSpecialDrawer() != true) goto L75;
        r114.put("is_vs_config_drawer", 1);
        RoomContext r118 = RoomContext.a.c(r108, null, 0, 3);
        if (r118 == null) goto L49;
        m<Long> r119 = r118.getCameraId();
        if (r119 == null) goto L49;
        Long r120 = r119.getValue();
        if (r120 == null) goto L49;
        long r121 = r120.longValue();
    L50:
        IVSCameraInfo r122 = ew1.a.a(r116, r121);
        if (r122 == null) goto L53;
        long r123 = r122.getCameraId();
    L54:
        r114.put(VSConstants.VS_CAMERA_ID, Long.valueOf(r123));
        RoomContext r124 = RoomContext.a.c(r108, null, 0, 3);
        if (r124 == null) goto L61;
        m<Room> r125 = r124.getRoom();
        if (r125 == null) goto L61;
        Room r126 = r125.getValue();
        if (r126 == null) goto L61;
        long r127 = r126.f162599id;
    L62:
        r114.put("draw_room_id", Long.valueOf(r127));
        RoomContext r109 = RoomContext.a.c(r108, null, 0, 3);
        if (r109 == null) goto L70;
        m<Room> r128 = r109.getRoom();
        if (r128 == null) goto L70;
        Room r129 = r128.getValue();
        if (r129 == null) goto L70;
        String r130 = r129.getAnchorId();
        if (r130 == null) goto L70;
    L71:
        r114.put("draw_room_owner_id", r130);
        r114.put("show_type", 3);
        r114.put(FeedApi.NEED_MAP_KEY, 1);
        r114.put(FeedApi.SOURCE_KEY, "vs_config_drawer_live_cover");
        if (r105 != null) goto L74;
        r105 = "";
    L74:
        r105 = ew1.c.a(r105, CollectionsKt.arrayListOf(new String[]{"show_type", FeedApi.NEED_MAP_KEY, FeedApi.SOURCE_KEY}));
    L70:
        r130 = "";
    L61:
        r127 = 0;
        goto L62
    L53:
        r123 = 0;
    L49:
        r121 = 0;
    L75:
        String r131 = r105;
        SingleDrawViewModel r132 = this.f21000a;
        if (r132 == null) goto L78;
        r132.setFetchingData(true);
    L78:
        Observable<BaseListResponse<FeedItem, FeedExtra>> r133 = r107.drawerFeed(r131, r110, r112, r114);
        if (r133 == null) goto L85;
        Observable<R> r134 = r133.map(a.f465564a);
        if (r134 == 0) goto L85;
        Observable r135 = r134.doOnNext(new C5597b(this));
        if (r135 == null) goto L85;
        r101 = r135.subscribe(new c(this, r102, r210, r211), new d(this));
    L85:
        this.f465563d = r101;
        return;
    L35:
        r116 = null;
        goto L37
    L28:
        r106 = 0;
        goto L29
    L24:
        r112 = null;
        goto L26
    L21:
        r105 = null;
        goto L22
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }
}
