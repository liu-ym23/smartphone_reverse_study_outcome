package kf2;

import am2.x;
import android.util.Pair;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.feature.config.LivePostClientSequenceConfig;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.config.e81;
import com.bytedance.android.livesdk.config.j41;
import com.bytedance.android.livesdk.config.k41;
import com.bytedance.android.livesdk.live.rerank.LiveInnerReRankUtils;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.x0;
import com.bytedance.android.livesdk.y0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.LiveInnerCheckLiveConfig;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import j40.w2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g {
    public final Set<Long> a;

    public static final class a<T> implements ObservableOnSubscribe {
        public final /* synthetic */ g a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ List g;
        public final /* synthetic */ HashMap h;
        public final /* synthetic */ long i;
        public final /* synthetic */ String j;
        public final /* synthetic */ long k;
        public final /* synthetic */ int l;
        public final /* synthetic */ String m;
        public final /* synthetic */ boolean n;
        public final /* synthetic */ String o;

        public a(g r4, long r5, String r7, long r8, String r10, String r11, List r12, HashMap r13, long r14, String r16, long r17, int r19, String r20, boolean r21, String r22) {
            this.a = r4;
            this.b = r5;
            this.c = r7;
            this.d = r8;
            this.e = r10;
            this.f = r11;
            this.g = r12;
            this.h = r13;
            this.i = r14;
            this.j = r16;
            this.k = r17;
            this.l = r19;
            this.m = r20;
            this.n = r21;
            this.o = r22;
        }

        public final void subscribe(ObservableEmitter<h> r24) {
            Intrinsics.checkNotNullParameter(r24, "it");
            g r2 = this.a;
            long r3 = this.b;
            String r5 = this.c;
            long r6 = this.d;
            String r8 = this.e;
            String r9 = this.f;
            List r10 = this.g;
            HashMap r11 = this.h;
            long r12 = this.i;
            String r14 = this.j;
            long r4 = this.k;
            int r7 = this.l;
            String r13 = this.m;
            boolean r15 = this.n;
            String r16 = this.o;
            r2.getClass();
            r24.onNext(g.b(r3, r5, r6, r8, r9, r10, r11, r12, r14, r4, r7, r13, r15, r16));
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ g a;

        public b(g r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            h r3 = (h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return this.a.g(r3);
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ g a;

        public c(g r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            BaseListResponse r4 = (BaseListResponse) r3;
            Intrinsics.checkNotNullParameter(r4, "response");
            if (((LiveInnerCheckLiveConfig) x0.a.getValue()).getHighValueHotUpdateEnable() == false) goto L9;
            FeedExtra r0 = r4.extra;
            if (r0 == null) goto L9;
            List r1 = r0.needPushAnchorIds;
            if (r1 == null) goto L9;
            this.a.a.clear();
            this.a.a.addAll(r1);
        L9:
            ArrayList r2 = new ArrayList();
            List r5 = r4.data;
            if (r5 == null) goto L13;
            r2.addAll(r5);
        L13:
            return Pair.create(r2, r4.extra);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ h b;

        public d(g r1, h r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            Pair r9 = (Pair) r8;
            if (r9 == null) goto L5;
            List r0 = (List) r9.first;
        L6:
            if (r0 != null) goto L8;
            return;
        L8:
            if (((List) r9.first).isEmpty() == true) goto L26;
            Object r1 = r9.second;
            if (r1 == null) goto L28;
            JsonObject r2 = ((FeedExtra) r1).getLogPb();
            if (r2 == null) goto L27;
            Iterator<T> r10 = ((Iterable) r9.first).iterator();
        L16:
            if (r10.hasNext() == false) goto L29;
            FeedItem r3 = (FeedItem) r10.next();
            r3.logPb = r2.toString();
            if (this.b.b != 0) goto L20;
            int r4 = 1;
        L21:
            r3.setPullType(r4);
            g.a(this.a, r3);
            goto L16
        L20:
            r4 = 2;
            goto L21
        L29:
            return;
        L27:
            return;
        L28:
            return;
        L26:
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    public g() {
        this.a = new LinkedHashSet();
    }

    public static String d(List r6) {
        if (r6 != null) goto L4;
        return "";
    L4:
        if (r6.isEmpty() == true) goto L25;
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.size();
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L19;
        r0.append(ListProtector.get(r6, r3).toString());
        boolean r5 = true;
        if (r3 < (r6.size() - 1)) goto L12;
        r5 = false;
    L12:
        if (r5 == false) goto L14;
        StringBuilder r4 = r0;
    L15:
        if (r4 == null) goto L17;
        r4.append(",");
    L17:
        r3 = r3 + 1;
        goto L7
    L14:
        r4 = null;
        goto L15
    L19:
        return r0.toString();
    L25:
        return "";
    }

    public final Observable<Pair<List<FeedItem>, FeedExtra>> g(h r30) {
        com.bytedance.android.livesdk.service.l.d().getClass();
        FeedApi r2 = (FeedApi) com.bytedance.android.live.network.c.b().e(FeedApi.class);
        LivePostClientSequenceConfig r26 = (LivePostClientSequenceConfig) e81.h.getValue();
        Observable r3 = r2.feed(r30.a, r30.b, r30.c, r30.d, r30.e, r30.f, r30.g, r30.h, r30.i, r30.j, r30.k, r30.l, r30.m, r30.n, r30.o, r30.p, r30.q);
        if (r26.getFeedRequestEnable() == false) goto L8;
        if (r26.feedRequestPostEnable() == false) goto L8;
        r3 = r2.feedPost(r30.a, r30.b, r30.c, r30.d, r30.e, r30.f, r30.g, r30.h, r30.i, r30.j, r30.k, r30.l, r30.m, r30.o, r30.p, "enable", "enable", r30.q);
    L8:
        return r3.map(new c(this)).doOnNext(new d(this, r30));
    }

    public static final void a(g r2, FeedItem r3) {
        r2.getClass();
        int r4 = r3.type;
        if (r4 == 1) goto L7;
        if (r4 == 2) goto L7;
        return;
    L7:
        if ((r3.getItem() instanceof Room) == false) goto L23;
        Item r5 = r3.getItem();
        if ((r5 instanceof Room) == true) goto L11;
        r5 = null;
    L11:
        Room r6 = (Room) r5;
        if (r6 == null) goto L24;
        r6.setLog_pb(r3.logPb);
        User r0 = r6.getOwner();
        if (r0 == null) goto L20;
        String r1 = r3.logPb;
        if (r1 != null) goto L19;
        r1 = "";
    L19:
        r0.setLogPb(r1);
    L20:
        r6.setRequestId(r3.resId);
        r6.set_isFromRecommendCard(r3.isRecommendCard);
        r6.set_liveReason(r3.liveReason);
        r6.set_pullType(r3.getPullType());
        return;
    L24:
        return;
    }

    public static Observable c(long r7, String r9, String r10, List r11) {
        Intrinsics.checkNotNullParameter(r9, "anchorId");
        Intrinsics.checkNotNullParameter(r10, "unreadExtra");
        Intrinsics.checkNotNullParameter(r11, "roomIds");
        com.bytedance.android.livesdk.service.l.d().getClass();
        return ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).collectUnreadRequest(r7, r9, r10, d(r11));
    }

    public static /* synthetic */ Observable f(g r20, long r21, String r23, long r24, String r26, String r27, HashMap r28, long r29, String r31, long r32, int r34, String r35, int r36) {
        if ((r36 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L5;
        long r10 = -1;
    L7:
        if ((r36 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L9;
        String r12 = null;
    L11:
        if ((r36 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L13;
        long r13 = 1;
    L15:
        if ((r36 & 2048) == 0) goto L17;
        String r16 = null;
    L19:
        return r20.e(r21, r23, r24, r26, r27, null, r28, r10, r12, r13, r34, r16, false, false, null);
    L17:
        r16 = r35;
        goto L19
    L13:
        r13 = r32;
        goto L15
    L9:
        r12 = r31;
        goto L11
    L5:
        r10 = r29;
        goto L7
    }

    public static h b(long r24, String r26, long r27, String r29, String r30, List r31, HashMap r32, long r33, String r35, long r36, int r38, String r39, boolean r40, String r41) {
        o r0 = u.l().c(x.class);
        if (r0 == null) goto L8;
        Map<String, String> r2 = r0.getMap();
        if (r2 == null) goto L8;
        String r3 = r2.get("enter_from_merge");
        if (r3 == null) goto L8;
    L9:
        if (r0 == null) goto L14;
        Map<String, String> r1 = r0.getMap();
        if (r1 == null) goto L14;
        String r4 = r1.get("enter_method");
        if (r4 == null) goto L14;
    L15:
        String r5 = r3 + "-" + r4;
        if (r39 == null) goto L18;
        String r10 = r39;
    L19:
        LivePostClientSequenceConfig r6 = (LivePostClientSequenceConfig) e81.h.getValue();
        boolean r7 = false;
        if ("homepage_hot_head_loadmore".equals(r26) == false) goto L22;
    L23:
        IStrategyService r8 = jc1.k.f(IStrategyService.class);
        int r9 = -1;
        if (r8 == null) goto L29;
        LiveData r11 = IStrategyService.a.a(r8, "live_inner_draw_feed_count", -1, false, 12);
        if (r11 == null) goto L29;
        Integer r12 = (Integer) r11.getValue();
        if (r12 == null) goto L29;
    L30:
        int r13 = r12.intValue();
        if (LiveInnerReRankUtils.b() == true) goto L33;
        int r14 = k41.a;
    L35:
        if (r9 <= 0) goto L37;
        r32.put("custom_count", Integer.valueOf(r9));
    L40:
        if (r38 == 0) goto L42;
        int r15 = r38;
    L46:
        r32.put("traffic_type", Integer.valueOf(r15));
        if (((Boolean) y0.a.getValue()).booleanValue() == false) goto L49;
        r32.put("inner_style", 1);
    L49:
        JSONObject r16 = new JSONObject();
        Iterator r17 = r32.entrySet().iterator();
    L51:
        if (r17.hasNext() == false) goto L53;
        Map.Entry r18 = (Map.Entry) r17.next();
        r16.putOpt((String) r18.getKey(), r18.getValue());
        goto L51
    L53:
        r16.putOpt("request_from", r26);
        r16.putOpt("draw_room_id", Long.valueOf(r27));
        r16.putOpt("draw_anchor_id", r29);
        r16.putOpt("enter_source", r10);
        j41 r19 = com.bytedance.android.livesdk.live.b.a;
        Object r20 = r32.get("action_type");
        j41 r21 = com.bytedance.android.livesdk.live.b.a;
        if (r21.a() == false) goto L87;
        if (r10 == null) goto L87;
        if (Intrinsics.areEqual(r20, "refresh") == false) goto L87;
        List r22 = r21.c();
        if (r22 == null) goto L87;
        if ((!r22.isEmpty()) == true) goto L66;
        r22 = null;
    L66:
        if (r22 == null) goto L87;
        Iterator r23 = r22.iterator();
    L69:
        if (r23.hasNext() == false) goto L87;
        String r25 = (String) r23.next();
        if (Intrinsics.areEqual(r25, r10) == true) goto L85;
        if (StringsKt.startsWith$default(r25, "*", false, 2, null) == false) goto L79;
        if (StringsKt.endsWith$default(r10, StringsKt.replace$default(r25, "*", "", false, 4, null), false, 2, null) == true) goto L85;
    L79:
        if (StringsKt.endsWith$default(r25, "*", false, 2, null) == false) goto L84;
        if (StringsKt.startsWith$default(r10, StringsKt.replace$default(r25, "*", "", false, 4, null), false, 2, null) == true) goto L85;
    L84:
        if (Intrinsics.areEqual(r25, "*") == false) goto L69;
    L85:
        boolean r28 = true;
    L88:
        if (r28 == false) goto L90;
        String r210 = "refresh";
    L127:
        if (r6.getFeedRequestEnable() == false) goto L134;
        IFeatureService r34 = jc1.k.f(IFeatureService.class);
        if (r34 == null) goto L134;
        String r37 = r34.getRealtimeSequenceJson(1, r16);
        if (r37 == null) goto L134;
        String r110 = r37;
    L136:
        if (((aa0.b) w2.a.getValue()).a() == false) goto L143;
        IFeatureService r42 = jc1.k.f(IFeatureService.class);
        if (r42 == null) goto L143;
        String r43 = r42.getSkipSequenceJson();
        if (r43 == null) goto L143;
        String r111 = r43;
    L144:
        Object r44 = r32.get("toplist_impr_gids");
        if ((r44 instanceof String) == true) goto L147;
        r44 = null;
    L147:
        String r45 = (String) r44;
        if (r45 != null) goto L150;
        String r112 = "";
    L151:
        String r113 = d(r31);
        if ("custom".equals(r35) == false) goto L154;
        long r46 = 0;
    L155:
        long r114 = r46;
        if (r41 != null) goto L158;
        String r211 = "";
    L159:
        if (r40 == false) goto L161;
        String r212 = PromotionCategory.CATEGORY_TYPE_SECOND;
    L163:
        return new h(r30, r24, r26, r36, r27, r29, r10, r113, r32, r33, r114, r110, r111, r112, r211, r212, r210);
    L161:
        r212 = null;
        goto L163
    L158:
        r211 = r41;
        goto L159
    L154:
        r46 = 1;
        goto L155
    L150:
        r112 = r45;
    L143:
        r111 = "";
    L134:
        r110 = "";
        goto L136
    L90:
        j41 r47 = com.bytedance.android.livesdk.live.b.a;
        if (r47.b() == false) goto L123;
        if (r10 == null) goto L123;
        if (Intrinsics.areEqual(r20, "loadmore") == false) goto L123;
        List r48 = r47.d();
        if (r48 == null) goto L123;
        if ((!r48.isEmpty()) == true) goto L103;
        r48 = null;
    L103:
        if (r48 == null) goto L123;
        Iterator r49 = r48.iterator();
    L106:
        if (r49.hasNext() == false) goto L123;
        String r50 = (String) r49.next();
        if (Intrinsics.areEqual(r50, r10) == true) goto L122;
        if (StringsKt.startsWith$default(r50, "*", false, 2, null) == false) goto L116;
        if (StringsKt.endsWith$default(r10, StringsKt.replace$default(r50, "*", "", false, 4, null), false, 2, null) == true) goto L122;
    L116:
        if (StringsKt.endsWith$default(r50, "*", false, 2, null) == false) goto L121;
        if (StringsKt.startsWith$default(r10, StringsKt.replace$default(r50, "*", "", false, 4, null), false, 2, null) == true) goto L122;
    L121:
        if (Intrinsics.areEqual(r50, "*") == false) goto L106;
    L122:
        r7 = true;
    L123:
        if (r7 == false) goto L125;
        r210 = "loadmore";
        goto L127
    L125:
        r210 = null;
    L87:
        r28 = false;
        goto L88
    L42:
        if (Intrinsics.areEqual(r4, "live_cell") == false) goto L44;
        r15 = 4;
        goto L46
    L44:
        r15 = 1;
        goto L46
    L37:
        if (r13 <= 0) goto L40;
        r32.put("custom_count", Integer.valueOf(r13));
        goto L40
    L33:
        r9 = LiveInnerReRankUtils.a.a();
    L29:
        r12 = -1;
        goto L30
    L22:
        if ("homepage_hot_draw_loadmore".equals(r26) == false) goto L40;
    L18:
        r10 = r5;
    L14:
        r4 = "";
    L8:
        r3 = "";
        goto L9
    }

    public final Observable<Pair<List<FeedItem>, FeedExtra>> e(long r22, String r24, long r25, String r27, String r28, List<Long> r29, HashMap<String, Object> r30, long r31, String r33, long r34, int r36, String r37, boolean r38, boolean r39, String r40) {
        Intrinsics.checkNotNullParameter(r24, "reqFrom");
        Intrinsics.checkNotNullParameter(r27, "anchorId");
        Intrinsics.checkNotNullParameter(r28, "url");
        Intrinsics.checkNotNullParameter(r30, "feedValue");
        if (r39 == false) goto L7;
        return Observable.create(new a(this, r22, r24, r25, r27, r28, r29, r30, r31, r33, r34, r36, r37, r38, r40)).subscribeOn(Schedulers.io()).concatMap(new b(this));
    L7:
        return g(b(r22, r24, r25, r27, r28, r29, r30, r31, r33, r34, r36, r37, r38, r40));
    }
}
