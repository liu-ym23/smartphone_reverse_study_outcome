package com.bytedance.android.livesdk.live.listprovider;

import am2.x;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.bytedance.android.live.LiveGsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseFeedMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.FeedDraw;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.rerank.ILiveReRankService;
import com.bytedance.android.livehostapi.business.depend.rerank.IWebcastReRankDelegate;
import com.bytedance.android.livesdk.chatroom.c0;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.chatroom.utils.u2;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.bu0;
import com.bytedance.android.livesdk.config.feed.InnerFeedDeduplicationConfig;
import com.bytedance.android.livesdk.config.i00;
import com.bytedance.android.livesdk.config.j6;
import com.bytedance.android.livesdk.config.k41;
import com.bytedance.android.livesdk.config.l10;
import com.bytedance.android.livesdk.config.l41;
import com.bytedance.android.livesdk.config.m10;
import com.bytedance.android.livesdk.config.my;
import com.bytedance.android.livesdk.config.n4;
import com.bytedance.android.livesdk.config.qr;
import com.bytedance.android.livesdk.config.r10;
import com.bytedance.android.livesdk.config.tv;
import com.bytedance.android.livesdk.config.uv;
import com.bytedance.android.livesdk.config.ww;
import com.bytedance.android.livesdk.feedback.FeedbackManager;
import com.bytedance.android.livesdk.feedback.LightFeedbackDataManager;
import com.bytedance.android.livesdk.landscapeslide.LiveLandSlideContext;
import com.bytedance.android.livesdk.live.rerank.LiveInnerReRankUtils;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.model.a0;
import com.bytedance.android.livesdk.preview.u;
import com.bytedance.android.livesdk.u8;
import com.bytedance.android.livesdk.utils.EnterOptimizeUtil;
import com.bytedance.android.livesdk.utils.landscape.FeedAction;
import com.bytedance.android.livesdk.utils.landscape.LandscapeLiveMonitor;
import com.bytedance.android.livesdk.utils.personalfeed.PersonalizedFeedUtils;
import com.bytedance.android.livesdk.viewmodel.MergeDrawerViewModel;
import com.bytedance.android.livesdk.y0;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.log.LiveFeedMainMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IGameCPData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomFlushInfo;
import com.bytedance.android.livesdkapi.depend.model.live.VerticalTypeInfo;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.feed.IAutoPull;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.android.livesdkapi.feed.ILiveRoomPersonalizedBackup;
import com.bytedance.android.livesdkapi.feed.ILoadMore;
import com.bytedance.android.livesdkapi.feed.IPersonalizedContext;
import com.bytedance.android.livesdkapi.feed.IPullable;
import com.bytedance.android.livesdkapi.feed.IPullableForSaas;
import com.bytedance.android.livesdkapi.feed.IRetryLoadMore;
import com.bytedance.android.livesdkapi.feed.LoadMoreRetryConfig;
import com.bytedance.android.livesdkapi.model.LiveRoomMemoryOptConfig;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class DrawRoomListProvider extends ILiveRoomListProvider implements IPullable<Integer>, IAutoPull, com.bytedance.android.livesdk.landscapeslide.b, IRetryLoadMore, ILoadMore, pg2.e, ILiveRoomPersonalizedBackup {
    public static final List<String> S1 = null;
    public boolean A;
    public String B;
    public long C;
    public final long D;
    public final String E;
    public final String F;
    public final String G;
    public HashSet<Long> G1;
    public final Long H;
    public LoadMoreRetryConfig H0;
    public final Bundle H1;
    public final String I;
    public final jg2.a J;
    public boolean K;
    public pg2.d L;
    public long L0;
    public final MergeDrawerViewModel L1;
    public final Lazy M;
    public final Room M1;
    public final Lazy N;
    public Pair<List<FeedItem>, FeedExtra> O;
    public final Lazy P;
    public FeedExtra P0;
    public com.bytedance.android.livesdk.live.f P1;
    public final Lazy Q;
    public final boolean Q1;
    public long R;
    public final boolean S;
    public int T;
    public boolean U;
    public boolean V;
    public ArrayList<FeedItem> V0;
    public final String W;
    public boolean X;
    public final com.bytedance.android.livesdk.live.rerank.a Y;
    public final Map<String, Object> Z;
    public kf2.g a;
    public final ArrayList<Room> b;
    public Disposable b1;
    public final ArrayList<Bundle> c;
    public final ArrayList<FeedItem> d;
    public final List<Long> e;
    public final ConcurrentHashMap<String, mz.b> f;
    public final long g;
    public LiveLandSlideContext g1;
    public final HashSet<Long> h;
    public int h1;
    public final HashMap<String, HashSet<Long>> i;
    public final HashSet<Long> j;
    public final HashMap<String, HashSet<Long>> k;
    public boolean k0;
    public boolean k1;
    public FeedExtra l;
    public Disposable m;
    public long n;
    public final int o;
    public final int p;
    public ILoadMore.ILoadMoreCallback p0;
    public final List<String> p1;
    public String q;
    public final long r;
    public final long s;
    public final String t;
    public String u;
    public final String v;
    public boolean v1;
    public boolean w;
    public boolean x;
    public boolean x1;
    public final CompositeDisposable y;
    public HashSet<Long> y1;
    public int z;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Logger.d("DrawRoomListProvider", "Collecting unread room result, extra: " + this.a + ", statusCode: " + ((BaseResponse) ((Response) r3)).statusCode + '.');
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ DrawRoomListProvider a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ List f;

        public c(DrawRoomListProvider r1, Ref.IntRef r2, int r3, int r4, int r5, List r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void accept(Object r30) {
            Pair r1 = (Pair) r30;
            if (r1 == null) goto L188;
            i00 r3 = i00.a;
            if (((Boolean) r3.getValue()).booleanValue() == true) goto L188;
            if (((Boolean) r3.getValue()).booleanValue() == true) goto L10;
            this.a.O((FeedExtra) r1.second);
        L10:
            Object r4 = r1.first;
            if (r4 != null) goto L13;
        L183:
            Ref.IntRef r2 = this.b;
            if (r1.first != null) goto L186;
            int r5 = LocationAnnotation.NetworkStatusType.LOWPAN;
        L187:
            r2.element = r5;
            this.a.x = false;
            return;
        L186:
            r5 = 108;
            goto L187
        L13:
            if (((List) r4).isEmpty() == true) goto L183;
            ArrayList r6 = new ArrayList();
            DrawRoomListProvider r7 = this.a;
            r7.getClass();
            LinkedHashMap r8 = new LinkedHashMap();
            HashMap<String, HashSet<Long>> r9 = r7.i;
            LinkedHashMap r10 = new LinkedHashMap();
            Iterator<Map.Entry<String, HashSet<Long>>> r11 = r9.entrySet().iterator();
        L17:
            if (r11.hasNext() == false) goto L24;
            Map.Entry<String, HashSet<Long>> r12 = r11.next();
            r12.getValue().removeAll(r7.h);
            if (r12.getValue().size() <= 0) goto L21;
            boolean r13 = true;
        L22:
            if (r13 == false) goto L17;
            r10.put(r12.getKey(), r12.getValue());
            goto L17
        L21:
            r13 = false;
            goto L22
        L24:
            Iterator r14 = r10.entrySet().iterator();
        L26:
            if (r14.hasNext() == false) goto L33;
            Map.Entry r15 = (Map.Entry) r14.next();
            HashSet r16 = (HashSet) r15.getValue();
            if (r16 == null) goto L26;
            Iterator<T> r17 = r16.iterator();
        L31:
            if (r17.hasNext() == false) goto L26;
            r8.put(Long.valueOf(((Number) r17.next()).longValue()), r15.getKey());
            goto L31
        L33:
            ArrayList r18 = new ArrayList(r8.size());
            Iterator r19 = r8.entrySet().iterator();
        L35:
            if (r19.hasNext() == false) goto L37;
            r18.add(Long.valueOf(((Number) ((Map.Entry) r19.next()).getKey()).longValue()));
            goto L35
        L37:
            List r20 = CollectionsKt.toMutableList(r18);
            Iterator<T> r21 = this.a.i.values().iterator();
        L39:
            if (r21.hasNext() == false) goto L41;
            ((HashSet) r21.next()).removeAll(r20);
            goto L39
        L41:
            int r22 = this.a.b.size();
            if (this.c != 2) goto L104;
            ArrayList r23 = new ArrayList();
            ArrayList r110 = new ArrayList();
            ArrayList r111 = new ArrayList();
            ArrayList r112 = new ArrayList();
            ArrayList r113 = new ArrayList();
            ArrayList r114 = new ArrayList();
            ArrayList r115 = new ArrayList();
            ArrayList r24 = new ArrayList();
            Iterator<Room> r25 = this.a.b.iterator();
            int r26 = 0;
        L45:
            if (r25.hasNext() == false) goto L57;
            Room r116 = r25.next();
            int r117 = r26 + 1;
            if (r26 >= 0) goto L49;
            CollectionsKt.throwIndexOverflow();
        L49:
            Iterator<Room> r118 = r25;
            Room r27 = r116;
            ArrayList r119 = r114;
            ArrayList r120 = r115;
            if (r20.contains(Long.valueOf(r27.id)) == false) goto L55;
            ArrayList r121 = r6;
            if (((ArrayList) this.a.e).contains(Long.valueOf(r27.id)) == false) goto L54;
            r23.add(Integer.valueOf(r26));
            r110.add(ListProtector.get(this.a.d, r26));
            r111.add(r27);
            r112.add(ListProtector.get(this.a.c, r26));
        L54:
            ArrayList r28 = r121;
            r113.add(new Pair(r8.get(Long.valueOf(r27.id)), Long.valueOf(r27.id)));
            ArrayList r29 = r119;
            r29.add(ListProtector.get(this.a.d, r26));
            ArrayList r31 = r120;
            r31.add(r27);
            r24.add(ListProtector.get(this.a.c, r26));
        L56:
            r114 = r29;
            r8 = r8;
            r26 = r117;
            r25 = r118;
            r20 = r20;
            r115 = r31;
            r6 = r28;
            goto L45
        L55:
            r28 = r6;
            r29 = r119;
            r31 = r120;
            goto L56
        L57:
            ArrayList r210 = r6;
            List r211 = r20;
            ArrayList r32 = r114;
            ArrayList r33 = r115;
            Iterator<T> r34 = r211.iterator();
        L59:
            if (r34.hasNext() == false) goto L61;
            long r122 = ((Number) r34.next()).longValue();
            DrawRoomListProvider r35 = this.a;
            r35.getClass();
            DrawRoomListProvider.p(r35, r122);
            r210.add(Long.valueOf(r122));
            goto L59
        L61:
            ArrayList r36 = r210;
            DrawRoomListProvider r37 = this.a;
            ((ILiveRoomListProvider) r37).flushTimes++;
            DrawRoomListProvider.J(r37, (List) r1.first, (FeedExtra) r1.second, true, 0, false, false, 56);
            Iterator<T> r38 = ((Iterable) r1.first).iterator();
        L63:
            if (r38.hasNext() == false) goto L66;
            FeedItem r39 = (FeedItem) r38.next();
            Map r123 = u.a;
            u.e(r39.getRoom());
            goto L63
        L66:
            if ((!r23.isEmpty()) == true) goto L68;
        L80:
            int r40 = r23.size();
            int r41 = this.a.b.size();
            if (r41 <= r22) goto L89;
            ArrayList r42 = new ArrayList();
            r42.addAll(this.a.b);
        L83:
            if (r22 >= r41) goto L109;
            DrawRoomListProvider r43 = this.a;
            long r44 = ((Room) ListProtector.get(r42, r22)).id;
            r43.getClass();
            DrawRoomListProvider.p(r43, r44);
            r36.add(Long.valueOf(((Room) ListProtector.get(r42, r22)).id));
            Iterator<T> r45 = this.a.i.values().iterator();
        L86:
            if (r45.hasNext() == false) goto L88;
            ((HashSet) r45.next()).remove(Long.valueOf(((Room) ListProtector.get(r42, r22)).id));
            goto L86
        L88:
            r22 = r22 + 1;
        L109:
            HashSet r46 = new HashSet();
            Iterator<Room> r47 = this.a.b.iterator();
        L111:
            if (r47.hasNext() == false) goto L113;
            r46.add(Long.valueOf(r47.next().id));
            goto L111
        L113:
            r36.removeAll(r46);
            kf2.g r48 = this.a.a;
            if (r48 != null) goto L116;
        L128:
            this.a.dispatchChange();
            Iterator<Room> r49 = this.a.b.iterator();
            int r50 = 0;
        L130:
            if (r49.hasNext() == false) goto L138;
            List r51 = r211;
            if (r49.next().getRoomId() != ((Number) ListProtector.get(r51, 0)).longValue()) goto L134;
            boolean r52 = true;
        L135:
            if (r52 == true) goto L139;
            r50 = r50 + 1;
            r211 = r51;
        L139:
            Iterable r53 = new ArrayList();
            if (r50 >= 0) goto L142;
        L150:
            DrawRoomListProvider r54 = this.a;
            r54.x = false;
            r54.C++;
            jg2.a r55 = r54.J;
            if (r55 == null) goto L153;
            r55.b++;
            Unit r56 = Unit.INSTANCE;
        L153:
            int r57 = xe1.a.c;
            LinkedHashMap r58 = new LinkedHashMap();
            r58.put("draw_order", String.valueOf(this.d));
            r58.put(LocationMonitorConst.IS_SUCCESS, "1");
            r58.put("drop_room_cnt", String.valueOf(r51.size()));
            r58.put("refresh_room_cnt", String.valueOf(((List) r1.first).size()));
            DrawRoomListProvider r59 = this.a;
            List r60 = (List) r1.first;
            r59.getClass();
            if (r60 != null) goto L156;
            int r61 = 0;
        L166:
            r58.put("same_room_cnt", String.valueOf(r61));
            r58.put("room_ids_replace_before", CollectionsKt.joinToString$default(r51, ",", null, null, 0, null, null, 62, null));
            r58.put("room_ids_replace_after", CollectionsKt.joinToString$default(r53, ",", null, null, 0, null, null, 62, null));
            Unit r62 = Unit.INSTANCE;
            LinkedHashMap r63 = new LinkedHashMap();
            r63.putAll(r58);
            r63.put("duration", String.valueOf(System.currentTimeMillis() - xe1.a.b));
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_internal_flow_refresh_result", r63, new Object[]{Room.class, x.class});
            int r64 = this.e;
            if (r64 == 1) goto L171;
            if (r64 == 2) goto L170;
            String r65 = "other";
        L172:
            LinkedHashMap r66 = new LinkedHashMap();
            r66.put("enter_from_merge", "inner_feed");
            r66.put("scene", r65);
            r66.put("exempt_impression_count", String.valueOf(this.f.size()));
            r66.put("return_count", String.valueOf(((List) r1.first).size()));
            r66.put("replace_success", String.valueOf(r51.size() - r40));
            r66.put("replace_count", String.valueOf(r51.size() - r40));
            r66.put("refresh_fail_reason", String.valueOf(this.b.element));
            Iterable r67 = (Iterable) r1.first;
            ArrayList r68 = new ArrayList();
            Iterator<T> r69 = r67.iterator();
        L174:
            if (r69.hasNext() == false) goto L182;
            T r70 = r69.next();
            List r71 = this.f;
            Room r72 = ((FeedItem) r70).getRoom();
            if (r72 == null) goto L178;
            Long r73 = Long.valueOf(r72.id);
        L180:
            if (CollectionsKt.contains(r71, r73) == false) goto L174;
            r68.add(r70);
            goto L174
        L178:
            r73 = null;
            goto L180
        L182:
            r66.put("repeat_count", String.valueOf(r68.size()));
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_feed_refresh", r66, new Object[0]);
            return;
        L170:
            r65 = "high_value";
            goto L172
        L171:
            r65 = "interval";
            goto L172
        L156:
            Iterator<T> r74 = r60.iterator();
            r61 = 0;
        L158:
            if (r74.hasNext() == false) goto L166;
            List r124 = r51;
            Room r75 = ((FeedItem) r74.next()).getRoom();
            if (r75 == null) goto L162;
            Long r76 = Long.valueOf(r75.id);
        L164:
            if (CollectionsKt.contains(r124, r76) == false) goto L158;
            r61 = r61 + 1;
            goto L158
        L162:
            r76 = null;
            goto L164
        L142:
            if (r50 >= this.a.b.size()) goto L150;
            ArrayList<Room> r77 = this.a.b;     // Catch: Exception -> L149
            List<Room> r78 = r77.subList(r50, r77.size());     // Catch: Exception -> L149
            ArrayList r79 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r78, 10));     // Catch: Exception -> L149
            Iterator<T> r80 = r78.iterator();     // Catch: Exception -> L149
        L145:
            if (r80.hasNext() == false) goto L147;
            r79.add(Long.valueOf(((Room) r80.next()).getRoomId()));     // Catch: Exception -> L149
            goto L145
        L147:
            r53 = CollectionsKt.toMutableList(r79);     // Catch: Exception -> L149
            goto L150
        L134:
            r52 = false;
            goto L135
        L138:
            r51 = r211;
            r50 = -1;
            goto L139
        L116:
            if ((!r36.isEmpty()) == true) goto L119;
            r48 = null;
        L119:
            if (r48 == null) goto L128;
            DrawRoomListProvider r81 = this.a;
            long r82 = r81.n;
            String r83 = r81.q;
            FeedExtra r85 = r81.l;
            if (r85 == null) goto L124;
            String r86 = r85.unreadExtra;
            if (r86 == null) goto L124;
        L125:
            Observable r87 = kf2.g.c(r82, r83, r86, r36);
            if (r87 == null) goto L128;
            r87.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.live.listprovider.c(this), com.bytedance.android.livesdk.live.listprovider.d.a);
        L124:
            r86 = "";
            goto L125
        L89:
            if (r41 >= r22) goto L109;
            r32.removeAll(this.a.d);
            r33.removeAll(this.a.b);
            r24.removeAll(this.a.c);
            if ((!r32.isEmpty()) == false) goto L109;
            if ((!r33.isEmpty()) == false) goto L109;
            if ((!r24.isEmpty()) == false) goto L109;
            int r88 = r22 - r41;
            int r89 = 0;
        L97:
            if (r89 >= r88) goto L109;
            if (r89 >= r32.size()) goto L103;
            this.a.d.add((FeedItem) ListProtector.get(r32, r89));
            this.a.b.add((Room) ListProtector.get(r33, r89));
            this.a.c.add((Bundle) ListProtector.get(r24, r89));
            HashSet r90 = this.a.i.get(((Pair) ListProtector.get(r113, r89)).first);
            if (r90 == null) goto L103;
            r90.add(((Pair) ListProtector.get(r113, r89)).second);
        L103:
            r89 = r89 + 1;
            goto L97
        L68:
            if ((!r110.isEmpty()) == false) goto L80;
            if ((!r111.isEmpty()) == false) goto L80;
            if ((!r112.isEmpty()) == false) goto L80;
            Iterator r91 = r23.iterator();
            int r92 = 0;
        L75:
            if (r91.hasNext() == false) goto L80;
            Object r125 = r91.next();
            int r126 = r92 + 1;
            if (r92 >= 0) goto L79;
            CollectionsKt.throwIndexOverflow();
        L79:
            int r127 = ((Number) r125).intValue();
            ListProtector.add(this.a.d, r127, ListProtector.get(r110, r92));
            ListProtector.add(this.a.b, r127, ListProtector.get(r111, r92));
            ListProtector.add(this.a.c, r127, ListProtector.get(r112, r92));
            r91 = r91;
            r92 = r126;
            goto L75
        L104:
            r36 = r6;
            r211 = r20;
            Iterator<T> r93 = r211.iterator();
        L106:
            if (r93.hasNext() == false) goto L108;
            long r94 = ((Number) r93.next()).longValue();
            DrawRoomListProvider r95 = this.a;
            r95.getClass();
            DrawRoomListProvider.p(r95, r94);
            r36.add(Long.valueOf(r94));
            goto L106
        L108:
            DrawRoomListProvider.J(this.a, (List) r1.first, (FeedExtra) r1.second, true, 0, false, false, 56);
            r40 = 0;
        L188:
            Ref.IntRef r96 = this.b;
            if (r1 != null) goto L191;
            int r97 = 105;
        L192:
            r96.element = r97;
            this.a.x = false;
            return;
        L191:
            r97 = 106;
            goto L192
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ DrawRoomListProvider a;

        public d(DrawRoomListProvider r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.x = false;
            ((Throwable) r3).printStackTrace();
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ DrawRoomListProvider a;

        public e(DrawRoomListProvider r1) {
            this.a = r1;
        }

        public final void accept(Object r15) {
            Pair r16 = (Pair) r15;
            this.a.v().p(BaseFeedMonitor.RequestType.SERVICE_REQUEST_TYPE_LOADMORE);
            if (r16 != null) goto L15;
            DrawRoomListProvider r17 = this.a;
            ILoadMore.ILoadMoreCallback r1 = r17.p0;
            if (r1 == null) goto L8;
            r1.onSuccess(0, r17.n(r17.l), false);
        L8:
            if (com.bytedance.android.livesdk.utils.landscape.f.a.b() == true) goto L14;
            LiveLandSlideContext r18 = this.a.g1;
            if (r18 == null) goto L14;
            com.bytedance.live.datacontext.m<Boolean> r19 = r18.isDataReady();
            if (r19 == null) goto L14;
            r19.setValue(Boolean.FALSE);
        L14:
            this.a.k1 = false;
            return;
        L15:
            this.a.O((FeedExtra) r16.second);
            List r2 = (List) r16.first;
            Integer r3 = null;
            if (r2 == null) goto L23;
            ArrayList r4 = new ArrayList();
            Iterator<T> r5 = r2.iterator();
        L19:
            if (r5.hasNext() == false) goto L24;
            T r6 = r5.next();
            if (com.bytedance.android.livesdk.landscapeslide.f.b(((FeedItem) r6).getRoom(), "loadmore") == false) goto L19;
            r4.add(r6);
        L24:
            boolean r7 = true;
            if (r4 != null) goto L27;
        L30:
            boolean r8 = true;
        L31:
            if (r8 == false) goto L42;
            DrawRoomListProvider r110 = this.a;
            ILoadMore.ILoadMoreCallback r9 = r110.p0;
            if (r9 == null) goto L35;
            r9.onSuccess(0, r110.n(r110.l), false);
        L35:
            this.a.k1 = false;
            if (com.bytedance.android.livesdk.utils.landscape.f.a.b() == true) goto L82;
            LiveLandSlideContext r111 = this.a.g1;
            if (r111 == null) goto L83;
            com.bytedance.live.datacontext.m<Boolean> r112 = r111.isDataReady();
            if (r112 == null) goto L84;
            r112.setValue(Boolean.FALSE);
            return;
        L84:
            return;
        L83:
            return;
        L82:
            return;
        L42:
            DrawRoomListProvider r10 = this.a;
            int r11 = (r10.h1 + 1) + r10.i();
            DrawRoomListProvider.J(this.a, r4, (FeedExtra) r16.second, true, r11, false, false, 48);
            ArrayList<FeedItem> r113 = this.a.V0;
            if (r113 != null) goto L45;
        L48:
            if (r7 == true) goto L63;
            LiveLandSlideContext r114 = this.a.g1;
            if (r114 == null) goto L54;
            com.bytedance.live.datacontext.m<Boolean> r115 = r114.isDataReady();
            if (r115 == null) goto L54;
            r115.setValue(Boolean.TRUE);
        L54:
            LiveLandSlideContext r116 = this.a.g1;
            if (r116 == null) goto L59;
            com.bytedance.live.datacontext.m<Boolean> r117 = r116.isDataEmpty();
            if (r117 == null) goto L59;
            r117.setValue(Boolean.FALSE);
        L59:
            LandscapeLiveMonitor.a r118 = LandscapeLiveMonitor.Companion;
            long r12 = this.a.R;
            r118.getClass();
            LandscapeLiveMonitor r119 = LandscapeLiveMonitor.a.b();
            if (r119 == null) goto L62;
            r119.onEndFeed(r12);
        L62:
            this.a.R = 0;
        L68:
            DrawRoomListProvider r120 = this.a;
            StringBuilder r13 = new StringBuilder("insert index: ");
            r13.append(r11);
            r13.append(" | done: ");
            r13.append(this.a.d.size());
            r13.append(" | internal: ");
            ArrayList<FeedItem> r14 = this.a.V0;
            if (r14 == null) goto L71;
            r3 = Integer.valueOf(r14.size());
        L71:
            r13.append(r3);
            r120.F(r13.toString());
            this.a.dispatchChange();
            ILoadMore.ILoadMoreCallback r121 = this.a.p0;
            if (r121 == null) goto L74;
            int r20 = r4.size();
            DrawRoomListProvider r21 = this.a;
            r121.onSuccess(r20, r21.n(r21.l), false);
        L74:
            DrawRoomListProvider r122 = this.a;
            r122.k1 = false;
            r122.C++;
            return;
        L63:
            LiveLandSlideContext r123 = this.a.g1;
            if (r123 == null) goto L68;
            com.bytedance.live.datacontext.m<Boolean> r124 = r123.isDataEmpty();
            if (r124 == null) goto L68;
            r124.setValue(Boolean.TRUE);
            goto L68
        L45:
            if (r113.isEmpty() == true) goto L48;
            r7 = false;
            goto L48
        L27:
            if (r4.isEmpty() == true) goto L30;
            r8 = false;
            goto L31
        L23:
            r4 = null;
            goto L24
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ DrawRoomListProvider a;

        public f(DrawRoomListProvider r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            DrawRoomListProvider r0 = this.a;
            ILoadMore.ILoadMoreCallback r1 = r0.p0;
            if (r1 == null) goto L6;
            r1.onError(r5, r0.n(r0.l));
        L6:
            if (com.bytedance.android.livesdk.utils.landscape.f.a.b() == true) goto L12;
            LiveLandSlideContext r2 = this.a.g1;
            if (r2 == null) goto L12;
            com.bytedance.live.datacontext.m<Boolean> r3 = r2.isDataReady();
            if (r3 == null) goto L12;
            r3.setValue(Boolean.FALSE);
        L12:
            this.a.k1 = false;
            r5.printStackTrace();
            this.a.v().o(r5, BaseFeedMonitor.RequestType.SERVICE_REQUEST_TYPE_LOADMORE);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ DrawRoomListProvider a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public g(DrawRoomListProvider r1, long r2, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r10) {
            Pair<List<FeedItem>, FeedExtra> r11 = (Pair) r10;
            long r0 = SystemClock.elapsedRealtime() - this.b;
            LiveFeedMainMonitor.printFeedLog("inder_draw", "preloadPersonalizedRoomList", String.valueOf(this.a.n), "", this.a.s(), "preloadPersonalizedRoomList,costTime=" + r0);
            if (r11 != null) goto L7;
            DrawRoomListProvider r12 = this.a;
            ILoadMore.ILoadMoreCallback r1 = r12.p0;
            if (r1 == null) goto L11;
            r1.onSuccess(0, r12.n(r12.l), true);
            return;
        L11:
            return;
        L7:
            this.a.C(r11);
            ConcurrentHashMap<String, Object> r13 = m.a;
            m.a(this.c, this.a.n);
            jg2.a r14 = this.a.J;
            if (r14 == null) goto L13;
            r14.onFetchSuccess();
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ DrawRoomListProvider a;

        public h(DrawRoomListProvider r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            PersonalizedFeedUtils.d("DrawRoomListProvider", "preloadPersonalizedRoomList response error " + ((Throwable) r3).getMessage());
            jg2.a r4 = this.a.J;
            if (r4 == null) goto L6;
            r4.onFetchError();
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ DrawRoomListProvider a;
        public final /* synthetic */ IPullable.IPullCallback b;
        public final /* synthetic */ IPullable.IPullCheck c;

        public i(DrawRoomListProvider r1, IPullable.IPullCallback r2, IPullable.IPullCheck r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r11) {
            Pair r12 = (Pair) r11;
            this.a.v().p(BaseFeedMonitor.RequestType.SERVICE_REQUEST_TYPE_REFRESH);
            boolean r0 = false;
            if (r12 != null) goto L7;
            IPullable.IPullCallback r13 = this.b;
            if (r13 == null) goto L58;
            r13.onSuccess(0);
            return;
        L58:
            return;
        L7:
            Object r2 = r12.first;
            if (r2 != null) goto L10;
        L51:
            IPullable.IPullCallback r14 = this.b;
            if (r14 == null) goto L64;
            r14.onSuccess(0);
            return;
        L64:
            return;
        L10:
            if (((List) r2).isEmpty() == true) goto L51;
            IPullable.IPullCheck r1 = this.c;
            if (r1 != null) goto L15;
        L45:
            this.a.O((FeedExtra) r12.second);
            this.a.c.clear();
            this.a.b.clear();
            this.a.f.clear();
            this.a.k.clear();
            DrawRoomListProvider.J(this.a, (List) r12.first, (FeedExtra) r12.second, false, 0, true, false, 40);
            if (this.a.b.size() <= 0) goto L48;
            ((Room) ListProtector.get(this.a.b, 0)).getOwner();
        L48:
            this.a.dispatchChange();
            IPullable.IPullCallback r15 = this.b;
            if (r15 == null) goto L62;
            r15.onSuccess(Integer.valueOf(this.a.size()));
            return;
        L62:
            return;
        L15:
            if (r1.checkEnable() == true) goto L45;
            this.a.k.clear();
            DrawRoomListProvider r3 = this.a;
            List r4 = (List) r12.first;
            FeedExtra r16 = (FeedExtra) r12.second;
            r3.getClass();
            if (((Boolean) r10.a.getValue()).booleanValue() == true) goto L20;
            return;
        L20:
            if (r4.isEmpty() == true) goto L66;
            HashSet<Long> r5 = new HashSet();
            Iterator<T> r6 = r4.iterator();
            int r7 = 0;
        L23:
            String r8 = null;
            if (r6.hasNext() == false) goto L36;
            T r9 = r6.next();
            int r10 = r7 + 1;
            if (r7 >= 0) goto L28;
            CollectionsKt.throwIndexOverflow();
        L28:
            String r17 = ((FeedItem) r9).getItem();
            if ((r17 instanceof Room) == false) goto L32;
            r8 = r17;
        L32:
            Room r18 = (Room) r8;
            if (r18 == null) goto L35;
            r5.add(Long.valueOf(r18.id));
        L35:
            r7 = r10;
            goto L23
        L36:
            String r19 = r16.unreadExtra;
            if (r19 != null) goto L39;
        L40:
            r0 = true;
        L41:
            if (r0 == true) goto L43;
            r8 = r19;
        L43:
            if (r8 == null) goto L60;
            r3.i.put(r8 + '_' + r3.z, r5);
            r3.k.put(r8 + '_' + r3.z, r5);
            r3.z = r3.z + 1;
            return;
        L60:
            return;
        L39:
            if (r19.length() != 0) goto L41;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ DrawRoomListProvider a;
        public final /* synthetic */ IPullable.IPullCallback b;
        public final /* synthetic */ IPullable.IPullCheck c;

        public j(DrawRoomListProvider r1, IPullable.IPullCallback r2, IPullable.IPullCheck r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            this.a.v().o(r4, BaseFeedMonitor.RequestType.SERVICE_REQUEST_TYPE_REFRESH);
            IPullable.IPullCallback r0 = this.b;
            if (r0 == null) goto L6;
            r0.onError(r4);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/livesdk/live/listprovider/DrawRoomListProvider$k", "Lcom/google/gson/reflect/TypeToken;", "", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class k extends TypeToken<Map<String, String>> {
        public k() {
        }
    }

    public static final class l<T> implements Consumer {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public final void alterSpecificItem(int r1, FeedItem r2) {
    }

    public final void cancelAutoLoadMore() {
        this.x = false;
        Disposable r0 = this.m;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.m = null;
    }

    public String providerType() {
        return "DrawRoomListProvider";
    }

    public final /* synthetic */ void pullToRefresh(IPullable.IPullCallback r1) {
        IPullableForSaas.-CC.$default$pullToRefresh(this, r1);
    }

    public final og2.a v() {
        return (og2.a) this.M.getValue();
    }

    static {
        S1 = CollectionsKt.listOf(new String[]{"homepage_hot_live_cell", "homepage_follow_live_cell", "homepage_hot_video_head", "homepage_follow_video_head"});
    }

    public static String w() {
        ILiveReRankService r0 = jc1.k.n(IHostBusiness.class).getReRankWebcastService();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRecentItems();
    }

    public final void G() {
        if (((Boolean) bu0.a.getValue()).booleanValue() == false) goto L5;
        FeedExtra r0 = this.l;
        if (r0 == null) goto L10;
        String r1 = r0.unreadExtra;
    L11:
        if (r1 != null) goto L13;
    L16:
        boolean r2 = true;
    L17:
        if (r2 == true) goto L22;
        P();
        return;
    L22:
        return;
    L13:
        if (r1.length() == 0) goto L16;
        r2 = false;
        goto L17
    L10:
        r1 = null;
        goto L11
    L5:
        if (FeedDraw.needCollectUnRead(this.v) == false) goto L20;
        P();
        return;
    }

    public final void P() {
        HashMap<String, HashSet<Long>> r0 = this.i;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, HashSet<Long>>> r2 = r0.entrySet().iterator();
    L3:
        boolean r3 = false;
        if (r2.hasNext() == false) goto L10;
        Map.Entry<String, HashSet<Long>> r4 = r2.next();
        r4.getValue().removeAll(this.h);
        if (r4.getValue().size() <= 0) goto L8;
        r3 = true;
    L8:
        if (r3 == false) goto L3;
        r1.put(r4.getKey(), r4.getValue());
        goto L3
    L10:
        Iterator r5 = r1.entrySet().iterator();
    L12:
        if (r5.hasNext() == false) goto L48;
        Map.Entry r6 = (Map.Entry) r5.next();
        String r7 = (String) r6.getKey();     // Catch: Exception -> L19
        int r8 = StringsKt.lastIndexOf$default((CharSequence) r6.getKey(), "_", 0, false, 6, null);     // Catch: Exception -> L19
        if (r7 == null) goto L18;
        String r9 = r7.substring(0, r8);     // Catch: Exception -> L19
    L21:
        if (this.a != null) goto L23;
        this.a = new kf2.g();
    L23:
        ArrayList r10 = new ArrayList((Collection) r6.getValue());
        if (LiveInnerReRankUtils.c() <= 0) goto L44;
        com.bytedance.android.livesdk.live.rerank.a r11 = this.Y;
        r11.getClass();
        if (LiveInnerReRankUtils.c() <= 0) goto L44;
        if (r9 == null) goto L44;
        FeedExtra r12 = r11.d;
        List r13 = null;
        if (r12 == null) goto L33;
        String r14 = r12.unreadExtra;
    L35:
        if (Intrinsics.areEqual(r9, r14) == false) goto L44;
        List r15 = com.bytedance.android.livesdk.live.rerank.a.a(r11);
        if (r15 == null) goto L44;
        if ((!r15.isEmpty()) == false) goto L41;
        r13 = r15;
    L41:
        if (r13 == null) goto L44;
        r10.addAll(r13);
        LiveInnerReRankUtils.e("packIfInvalidHideBucketGids " + r13 + ' ');
        goto L44
    L33:
        r14 = null;
    L44:
        if (this.a == null) goto L12;
        Observable r16 = kf2.g.c(this.n, this.q, r9, r10);
        if (r16 == null) goto L12;
        r16.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r9), l.a);
        goto L12
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L19
    L19:
        r9 = (String) r6.getKey();
        goto L21
    }

    @Override // pg2.e
    public final boolean d() {
        FeedExtra r0 = this.l;
        if (r0 == null) goto L8;
        if (r0 == null) goto L8;
        if (((Extra) r0).hasMore == true) goto L8;
        return true;
    L8:
        return false;
    }

    public final void delayParseAndDispatch() {
        a0.e("delayParseAndDispatch");
        H(this.O);
    }

    @Override // com.bytedance.android.livesdk.landscapeslide.b
    public final int e() {
        return Math.max(this.h1, 0);
    }

    public final int getPersonalizedUnreadCount() {
        jg2.a r0 = this.J;
        int r1 = 0;
        if (r0 != null) goto L5;
    L40:
        PersonalizedFeedUtils.e("DrawRoomListProvider", "getPersonalizedUnreadCount, personalizedUnreadCount:" + r1);
        return r1;
    L5:
        if (r0.a != true) goto L40;
        if (PersonalizedFeedUtils.c() == false) goto L40;
        jg2.a r2 = this.J;
        if (r2 == null) goto L40;
        ArrayList<FeedItem> r3 = this.d;
        if (r3 == null) goto L38;
        long[] r4 = r2.c;
        int r5 = r4.length;
        int r6 = 0;
    L13:
        if (r6 >= r5) goto L21;
        if (r4[r6] != 0) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == true) goto L22;
        r6 = r6 + 1;
    L22:
        if (r6 < 0) goto L38;
        if (r6 >= r3.size()) goto L38;
        int r8 = r3.size();
        int r9 = 0;
    L26:
        if (r6 >= r8) goto L37;
        if (r6 == 0) goto L36;
        FeedItem r10 = (FeedItem) ListProtector.get(r3, r6);
        if (r10 != null) goto L31;
    L33:
        boolean r11 = false;
    L34:
        if (r11 == false) goto L36;
        r9 = r9 + 1;
        goto L36
    L31:
        if (r10.contentCategory != 6) goto L33;
        r11 = true;
    L36:
        r6 = r6 + 1;
        goto L26
    L37:
        r1 = r9;
        goto L38
    L17:
        r7 = false;
        goto L18
    L21:
        r6 = -1;
    L38:
        if (r1 <= 0) goto L40;
        r2.a(r2.c);
        goto L40
    }

    @Override // com.bytedance.android.livesdk.landscapeslide.b
    public final void h() {
        if (this.v1 == true) goto L7;
        this.C = this.L0;
        O(this.P0);
        Disposable r0 = this.b1;
        if (r0 == null) goto L7;
        r0.dispose();
    L7:
        LiveLandSlideContext r1 = this.g1;
        if (r1 == null) goto L26;
        long r4 = r1.getCurrentRoomId();
        int r2 = r1.getRelateRoomIndex() - 1;
        ArrayList<FeedItem> r6 = this.V0;
        if (r4 == 0) goto L12;
        Long r3 = Long.valueOf(r4);
    L27:
        ArrayList<FeedItem> r5 = this.V0;
        if (r5 != null) goto L30;
    L113:
        this.v1 = false;
        this.x1 = false;
        this.V0 = null;
        this.y1 = null;
        this.G1 = null;
        this.g1 = null;
        this.h1 = -1;
        this.k1 = false;
        return;
    L30:
        if (this.v1 == false) goto L94;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<FeedItem> r8 = r5.iterator();
    L33:
        if (r8.hasNext() == false) goto L39;
        Room r9 = r8.next().getRoom();
        if (r9 == null) goto L37;
        Long r10 = Long.valueOf(r9.id);
    L38:
        r7.add(Long.valueOf(r10.longValue()));
        goto L33
    L37:
        r10 = null;
        goto L38
    L39:
        Iterator r11 = r7.iterator();
    L41:
        if (r11.hasNext() == false) goto L112;
        long r12 = ((Number) r11.next()).longValue();
        HashSet<Long> r13 = this.y1;
        if (r13 == null) goto L47;
        if (r13.contains(Long.valueOf(r12)) != true) goto L47;
        F("skip remove room: " + r12);
    L47:
        HashSet<Long> r14 = this.G1;
        if (r14 == null) goto L93;
        if (r14.contains(Long.valueOf(r12)) != true) goto L93;
        ArrayList<Room> r15 = this.b;
        if (r15 != null) goto L54;
    L57:
        boolean r16 = true;
    L58:
        if (r16 == true) goto L92;
        ArrayList<Bundle> r17 = this.c;
        if (r17 != null) goto L62;
    L65:
        boolean r18 = true;
    L66:
        if (r18 == true) goto L92;
        ArrayList<FeedItem> r19 = this.d;
        if (r19 != null) goto L70;
    L73:
        boolean r20 = true;
    L74:
        if (r20 == true) goto L92;
        int r21 = this.b.size();
        int r22 = 0;
        boolean r23 = true;
    L77:
        if (r22 >= r21) goto L92;
        if (((Room) ListProtector.get(this.b, r22)).id != r12) goto L91;
        if (r23 == false) goto L83;
        r23 = false;
        goto L91
    L83:
        if (this.c.size() <= r22) goto L86;
        ListProtector.remove(this.c, r22);
    L86:
        if (this.b.size() <= r22) goto L89;
        ListProtector.remove(this.b, r22);
    L89:
        if (this.d.size() <= r22) goto L92;
        ListProtector.remove(this.d, r22);
    L91:
        r22 = r22 + 1;
        goto L77
    L70:
        if (r19.isEmpty() == true) goto L73;
        r20 = false;
        goto L74
    L62:
        if (r17.isEmpty() == true) goto L65;
        r18 = false;
    L92:
        F("remove duplicateRoom: " + r12);
        goto L41
    L54:
        if (r15.isEmpty() == true) goto L57;
        r16 = false;
    L93:
        p(this, r12);
        F("remove unread room: " + r12);
    L112:
        F("quitLand done: " + this.d.size() + " internalSize: " + r5.size());
        dispatchChange();
        goto L113
    L94:
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<FeedItem> r25 = r5.iterator();
    L96:
        if (r25.hasNext() == false) goto L102;
        Room r26 = r25.next().getRoom();
        if (r26 == null) goto L100;
        Long r27 = Long.valueOf(r26.id);
    L101:
        r24.add(r27);
        goto L96
    L100:
        r27 = null;
        goto L101
    L102:
        ArrayList r28 = new ArrayList();
        Iterator r29 = r24.iterator();
    L104:
        if (r29.hasNext() == false) goto L108;
        Object r30 = r29.next();
        if ((!Intrinsics.areEqual((Long) r30, r3)) == false) goto L104;
        r28.add(r30);
        goto L104
    L108:
        Iterator r31 = r28.iterator();
    L110:
        if (r31.hasNext() == false) goto L112;
        p(this, ((Long) r31.next()).longValue());
        goto L110
    L12:
        if (r6 != null) goto L14;
    L17:
        boolean r32 = true;
    L18:
        if (r32 == true) goto L26;
        int r33 = r6.size();
        if (r2 < 0) goto L26;
        if (r33 <= r2) goto L26;
        Room r34 = ((FeedItem) ListProtector.get(r6, r2)).getRoom();
        if (r34 == null) goto L26;
        r3 = Long.valueOf(r34.getRoomId());
        goto L27
    L14:
        if (r6.isEmpty() == true) goto L17;
        r32 = false;
    L26:
        r3 = null;
        goto L27
    }

    @Override // com.bytedance.android.livesdk.landscapeslide.b
    public final int i() {
        ArrayList<FeedItem> r0 = this.V0;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final String r() {
        InnerFeedDeduplicationConfig r0 = (InnerFeedDeduplicationConfig) LiveConfigSettingKeys.LIVE_INNER_FEED_REPEAT_DEDUPLICATION.getValue();
        if (r0.getEnable() == true) goto L5;
        return null;
    L5:
        com.bytedance.android.livesdk.log.filter.o r1 = com.bytedance.android.livesdk.log.u.l().c(x.class);
        String r3 = "";
        if (r1 == null) goto L11;
        Map<String, String> r4 = r1.getMap();
        if (r4 == null) goto L11;
        String r5 = r4.get("enter_from_merge");
        if (r5 == null) goto L11;
    L12:
        if (r1 == null) goto L19;
        Map<String, String> r2 = r1.getMap();
        if (r2 == null) goto L19;
        String r6 = r2.get("enter_method");
        if (r6 == null) goto L19;
        r3 = r6;
    L19:
        String r7 = r5 + '_' + r3;
        List r8 = r0.getEnterSource();
        if (r8 != null) goto L22;
    L33:
        return null;
    L22:
        if (r8.contains(r7) != true) goto L33;
        if (this.b.isEmpty() == false) goto L27;
        return null;
    L27:
        int r9 = Math.max(0, this.b.size() - r0.getMaxCount());
        ArrayList<Room> r10 = this.b;
        List<Room> r11 = r10.subList(r9, r10.size());
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L29:
        if (r13.hasNext() == false) goto L32;
        r12.add(Long.valueOf(((Room) r13.next()).id));
        goto L29
    L32:
        return CollectionsKt.joinToString$default(r12, ",", null, null, 0, null, null, 62, null);
    L11:
        r5 = "";
        goto L12
    }

    public void release() {
        jg2.a r0 = this.J;
        if (r0 == null) goto L5;
        r0.d.clear();
        r0.c = new long[16];
    L5:
        this.h.clear();
        this.i.clear();
        this.k.clear();
        this.j.clear();
        this.c.clear();
        this.b.clear();
        this.f.clear();
        this.y.clear();
        this.w = false;
        this.K = false;
        com.bytedance.android.livesdk.live.rerank.a r1 = this.Y;
        r1.getClass();
        if (LiveInnerReRankUtils.b() == false) goto L10;
        LiveInnerReRankUtils.e("LiveInnerHideBucketCache clear ");
        ((ArrayList) r1.a).clear();
        ((ArrayList) r1.b).clear();
        ((ArrayList) r1.c).clear();
        return;
    }

    public final String s() {
        String r2 = "";
        String r0 = this.H1.getString("extra_enter_source_uniqueid", "");
        StringBuilder r1 = new StringBuilder();
        if (TextUtils.isEmpty(r0) == true) goto L6;
        r2 = r0 + "_";
    L6:
        r1.append(r2);
        r1.append("Provider-");
        r1.append(hashCode());
        return r1.toString();
    }

    public final int size() {
        return this.c.size();
    }

    public final String t() {
        FeedExtra r0 = this.l;
        if (r0 == null) goto L5;
        long r3 = r0.maxTime;
    L7:
        if (r3 != 0) goto L9;
        return "refresh";
    L9:
        return "loadmore";
    L5:
        r3 = 0;
        goto L7
    }

    public final long u() {
        if (this.d.size() <= 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        DrawRoomListProvider r1 = this;
    L9:
        if (r1 == null) goto L12;
        ArrayList<FeedItem> r2 = this.d;
        return ((FeedItem) ListProtector.get(r2, r2.size() - 1)).latestWatchTime;
    L12:
        return this.r;
    L8:
        r1 = null;
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public final String x() {
        if (TextUtils.isEmpty(this.v) == false) goto L6;
        return "_".concat(t());
    L6:
        return this.v + '_' + t();
    }

    public final List<FeedItem> getHideBucketFeedItems() {
        if (LiveInnerReRankUtils.b() == false) goto L7;
        return this.Y.c;
    L7:
        return new ArrayList();
    }

    public final Bundle getBundle() {
        return this.H1;
    }

    public final FeedExtra getFeedExtra() {
        return this.l;
    }

    public final List<FeedItem> getFeedItems() {
        return this.d;
    }

    public final IPersonalizedContext getPersonalizedContext() {
        return this.J;
    }

    public final List<Room> getRoomList() {
        return this.b;
    }

    @Override // pg2.e
    public final String j() {
        return this.u;
    }

    @Override // pg2.e
    public final String k() {
        return this.v;
    }

    public final void A(FeedItem r5) {
        int r0 = r5.type;
        boolean r1 = true;
        if (r0 != 1) goto L5;
    L10:
        if (r1 == true) goto L12;
        return;
    L12:
        if ((r5.getItem() instanceof Room) == false) goto L25;
        Item r2 = r5.getItem();
        if ((r2 instanceof Room) == true) goto L16;
        r2 = null;
    L16:
        Room r3 = (Room) r2;
        if (r3 != null) goto L19;
        return;
    L19:
        r3.setLog_pb(r5.logPb);
        User r4 = r3.getOwner();
        if (r4 == null) goto L22;
        r4.setLogPb(r5.logPb);
    L22:
        r3.setRequestId(r5.resId);
        r3.set_isFromRecommendCard(r5.isRecommendCard);
        r3.set_liveReason(r5.liveReason);
        r3.liveRecommendInfo = r5.liveRecommendInfo;
        r3.adRawString = r5.adRawString;
        nn2.a r6 = nn2.a.d;
        nn2.a.a.a().c(r3.id, r5.type);
        return;
    L25:
        return;
    L5:
        if (r0 == 2) goto L10;
        if (r0 == 14) goto L10;
        r1 = false;
        goto L10
    }

    public final void C(Pair<List<FeedItem>, FeedExtra> r14) {
        PersonalizedFeedUtils.e("DrawRoomListProvider", "insertCacheRoomList response");
        jg2.a r1 = this.J;
        Unit r2 = null;
        int r3 = 0;
        if (r1 == null) goto L39;
        int r4 = r1.b;
        int r6 = -1;
        if (PersonalizedFeedUtils.c() == false) goto L7;
        r6 = (-1) + PersonalizedFeedUtils.b().e();
    L7:
        if (r4 > r6) goto L9;
        boolean r5 = true;
    L10:
        if (r5 != true) goto L39;
        if (r14.second == null) goto L22;
        Collection r7 = (Collection) r14.first;
        if (r7 != null) goto L16;
    L19:
        boolean r8 = true;
    L20:
        if (r8 == true) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == true) goto L26;
        r14 = null;
    L26:
        if (r14 == null) goto L37;
        PersonalizedFeedUtils.e("DrawRoomListProvider", "insertCacheRoomList parseRoomStart");
        jg2.a r10 = this.J;
        if (r10 == null) goto L30;
        r10.a = true;
    L30:
        J(this, (List) r14.first, (FeedExtra) r14.second, true, 0, false, true, 24);
        dispatchChange();
        ILoadMore.ILoadMoreCallback r11 = this.p0;
        if (r11 == null) goto L36;
        List r12 = (List) r14.first;
        if (r12 == null) goto L35;
        r3 = r12.size();
    L35:
        r11.onSuccess(r3, n((FeedExtra) r14.second), true);
    L36:
        PersonalizedFeedUtils.e("DrawRoomListProvider", "insertCacheRoomList success");
        return;
    L37:
        PersonalizedFeedUtils.d("DrawRoomListProvider", "insertCacheRoomList response failed, data is empty");
        return;
    L16:
        if (r7.isEmpty() == true) goto L19;
        r8 = false;
    L22:
        r9 = false;
        goto L23
    L9:
        r5 = false;
    L39:
        if (r14.second == null) goto L49;
        Collection r13 = (Collection) r14.first;
        if (r13 != null) goto L43;
    L46:
        boolean r15 = true;
    L47:
        if (r15 == true) goto L49;
        boolean r16 = true;
    L50:
        if (r16 == true) goto L53;
        r14 = null;
    L53:
        if (r14 == null) goto L80;
        FeedExtra r17 = (FeedExtra) r14.second;
        if (r17 == null) goto L79;
        String r18 = r17.unreadExtra;
        if (r18 == null) goto L79;
        if (r18.length() != 0) goto L61;
        r3 = 1;
    L61:
        if (r3 == 0) goto L64;
        r18 = null;
    L64:
        if (r18 == null) goto L79;
        HashSet r19 = new HashSet();
        Iterable r110 = (Iterable) r14.first;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r111 = r110.iterator();
    L67:
        if (r111.hasNext() == false) goto L75;
        FeedItem r21 = (FeedItem) r111.next();
        if (r21 == null) goto L73;
        Room r22 = r21.getRoom();
        if (r22 == null) goto L73;
        long r23 = r22.getRoomId();
    L74:
        r20.add(Long.valueOf(r23));
    L73:
        r23 = 0;
        goto L74
    L75:
        r19.addAll(r20);
        jg2.a r112 = this.J;
        if (r112 == null) goto L78;
        r112.c(r18, new ArrayList(r19));
    L78:
        PersonalizedFeedUtils.e("DrawRoomListProvider", "insertCacheRoomList only report");
        r2 = Unit.INSTANCE;
    L79:
        if (r2 == null) goto L80;
        return;
    L80:
        PersonalizedFeedUtils.d("DrawRoomListProvider", "insertCacheRoomList only report, data is empty");
        Unit r113 = Unit.INSTANCE;
        return;
    L43:
        if (r13.isEmpty() == true) goto L46;
        r15 = false;
    L49:
        r16 = false;
        goto L50
    }

    public final boolean D(int r3) {
        Bundle r4 = (Bundle) CollectionsKt.getOrNull(this.c, r3);
        if (r4 == null) goto L7;
        String r5 = r4.getString("live.intent.extra.LIVE_FOLLOW_RECOMMEND_UNREAD_EXTRA", "");
        if (r5 == null) goto L7;
        return com.bytedance.android.livesdk.chatroom.followrecommendguide.a.d(r5);
    L7:
        return false;
    }

    public final boolean E(long r10) {
        int r1 = this.b.size();
        if (((Boolean) uv.a.getValue()).booleanValue() == true) goto L5;
    L30:
        return false;
    L5:
        if (r1 < 2) goto L30;
        Integer r2 = (Integer) tv.a.getValue();     // Catch: Exception -> L29
        if (this.v1 == false) goto L9;
    L11:
        boolean r4 = false;
    L13:
        if (this.g1 == null) goto L17;
        if (r4 == false) goto L17;
    L15:
        int r5 = 0;
    L19:
        int r3 = r1 - 1;     // Catch: Exception -> L29
        if (r3 < r5) goto L30;
    L21:
        Room r6 = (Room) ListProtector.get(this.b, r3);     // Catch: Exception -> L29
        if (r6 != null) goto L24;
    L27:
        if (r3 == r5) goto L30;
        r3 = r3 - 1;
        goto L21
    L24:
        if (r10 != r6.getRoomId()) goto L27;
        ALogger.i("DrawRoomListDuplicateOpt", "连续 " + r2 + "个直播间内出现相同直播间 roomid =  " + r10);     // Catch: Exception -> L29
        return true;
    L17:
        if (r1 <= r2.intValue()) goto L15;
        r5 = r1 - r2.intValue();     // Catch: Exception -> L29
        goto L19
    L9:
        if (com.bytedance.android.livesdk.utils.landscape.f.a.a() == false) goto L11;
        r4 = true;
    L29:
        ALogger.e("DrawRoomListDuplicateOpt", "Remove repeat continuously room " + r10 + " exception");
        goto L30
    }

    public final void F(String r3) {
        com.bytedance.android.livesdk.landscapeslide.f.d("Draw：" + r3);
    }

    public final void H(Pair<List<FeedItem>, FeedExtra> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        a0.e("parseAndDispatch");
        J(this, (List) r10.first, (FeedExtra) r10.second, true, 0, false, false, 56);
        int r11 = ((LiveRoomMemoryOptConfig) this.P.getValue()).getMaxCacheCount();
        if (((LiveRoomMemoryOptConfig) this.P.getValue()).getEnable() == true) goto L7;
    L20:
        dispatchChange();
        ILiveReRankService r12 = jc1.k.n(IHostBusiness.class).getReRankWebcastService();
        if (r12 == null) goto L25;
        IWebcastReRankDelegate r13 = r12.getDelegate();
        if (r13 == null) goto L25;
        r13.onLoadMore();
    L25:
        this.w = false;
        this.C++;
        jg2.a r14 = this.J;
        if (r14 == null) goto L28;
        r14.b++;
    L28:
        this.O = null;
        return;
    L7:
        if (this.b.size() <= r11) goto L20;
        if (r11 <= 0) goto L20;
        int r0 = this.b.size() - r11;
        int r15 = this.T;
        if (r15 >= r0) goto L20;
    L12:
        if (r15 >= r0) goto L19;
        if (this.b.size() <= r15) goto L18;
        if (this.d.size() <= r15) goto L18;
        Room r1 = (Room) ListProtector.get(this.b, r15);
        FeedItem r2 = (FeedItem) ListProtector.get(this.d, r15);
        Room r3 = new Room();
        r3.id = r1.getRoomId();
        r3.setUserCount(r1.getUserCount());
        r3.setIdStr(r1.getIdStr());
        r3.set_liveReason(r1.getLiveReason());
        r3.setItemExplicitInfo(r1.getItemExplicitInfo());
        r3.withAggregateColumn = r1.withAggregateColumn;
        r3.mVerticalTypeInfo = r1.mVerticalTypeInfo;
        r3.isSimilarRoom = r1.isSimilarRoom;
        User r4 = new User();
        r4.setIdString(r1.getOwnerUserIdString());
        Unit r5 = Unit.INSTANCE;
        r3.setOwner(r4);
        ListProtector.set(this.b, r15, r3);
        ArrayList<FeedItem> r6 = this.d;
        FeedItem r7 = new FeedItem();
        r7.setRoom(r3);
        r7.isPseudoLiving = r2.isPseudoLiving;
        r7.contentCategory = r2.contentCategory;
        ListProtector.set(r6, r15, r7);
    L18:
        r15 = r15 + 1;
        goto L12
    L19:
        this.T = r0;
        goto L20
    }

    public final void I(Room r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        FeedItem r0 = new FeedItem();
        r0.setRoom(r8);
        Room r9 = r0.getRoom();
        if (r9 == null) goto L9;
        FeedbackCard r10 = r9.mFeedbackCard;
        if (r10 == null) goto L9;
        r10.feedbackType = r10.inflowFeedbackType;
    L9:
        FeedbackCard r11 = r0.feedbackCard;
        if (r11 == null) goto L13;
        r11.feedbackType = r11.inflowFeedbackType;
    L13:
        if (r0.getItem() == null) goto L73;
    L18:
        Item r12 = r0.getItem();
        if ((r12 instanceof Room) == true) goto L21;
        r12 = null;
    L21:
        Room r13 = (Room) r12;
        if (r13 != null) goto L24;
        return;
    L24:
        if (E(r13.getRoomId()) == false) goto L27;
        return;
    L27:
        if (q(r13.getRoomId()) == true) goto L77;
        this.Y.b(r13.getRoomId());
        r13.set_isFromRecommendCard(r0.isRecommendCard);
        r13.set_liveReason(r0.liveReason);
        if (r13.withAggregateColumn != true) goto L45;
        MergeDrawerViewModel r1 = this.L1;
        if (r1 == null) goto L45;
        if (r1.getMergeDrawFeed() != true) goto L45;
        MergeDrawerViewModel r2 = this.L1;
        if (r2 == null) goto L40;
        Map r3 = r2.getRoomWithAggregateMap();
        if (r3 == null) goto L40;
        Long r4 = Long.valueOf(r13.id);
        VerticalTypeInfo r5 = new VerticalTypeInfo();
        r5.name = this.H1.getString("aggregate_column_title");
        Unit r6 = Unit.INSTANCE;
        VerticalTypeInfo r7 = (VerticalTypeInfo) r3.put(r4, r5);
    L40:
        MergeDrawerViewModel r14 = this.L1;
        if (r14 == null) goto L45;
        List r15 = r14.getRoomListCache();
        if (r15 == null) goto L45;
        r15.add(r13);
    L45:
        MergeDrawerViewModel r16 = this.L1;
        if (r16 != null) goto L48;
    L59:
        Bundle r17 = ArgumentsBuilder.buildRoomArgs(r13);
        N(r17);
        M(r17, r0);
        L(r17, r13);
        z(r17, r13);
        if (this.S == false) goto L62;
        r17.putBoolean("live.intent.extra.is_multi_tab_container", true);
    L62:
        r17.putString("extra_content_category", String.valueOf(r0.contentCategory));
        if (tb1.c.a == false) goto L66;
        qg2.a.a(r17, r0);
    L66:
        if (r0.isAd == false) goto L71;
        List<Long> r18 = this.e;
        ArrayList r19 = (ArrayList) r18;
        if (r19.contains(Long.valueOf(r13.getRoomId())) == true) goto L78;
        List<Long> r20 = this.e;
        ArrayList r21 = (ArrayList) r20;
        r21.add(Long.valueOf(r13.getRoomId()));
        goto L71
    L78:
        return;
    L71:
        this.b.add(r13);
        this.c.add(r17);
        this.d.add(r0);
        K(r13);
        return;
    L48:
        if (r16.isSimilarRoom() != true) goto L59;
        MergeDrawerViewModel r22 = this.L1;
        if (r22 == null) goto L59;
        if (r22.isMergePull() != true) goto L59;
        MergeDrawerViewModel r23 = this.L1;
        if (r23 == null) goto L58;
        ArrayList r24 = r23.getSimilarRoomCache();
        if (r24 == null) goto L58;
        r24.add(Long.valueOf(r13.id));
    L58:
        r13.isSimilarRoom = true;
        goto L59
    L77:
        return;
    L73:
        r0.setItem(r0.getRoom());     // Catch: Exception -> L16
        A(r0);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public final void K(Room r6) {
        if (((l41) InnerLiveRecFeatureManager.a.getValue()).a() == true) goto L5;
        return;
    L5:
        String r0 = r6.getItemExplicitInfo();
        if (r0 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L29;
        return;
    L29:
        JSONObject r3 = new JSONObject(r0);     // Catch: Exception -> L26
        String r1 = r3.optString("feed_draw_client_targets_rec_info");     // Catch: Exception -> L26
        if ((true ^ StringsKt.isBlank(r1)) == true) goto L27;
    L19:
        JSONObject r4 = null;
    L20:
        String r5 = String.valueOf(r6.getRoomId());     // Catch: Exception -> L26
        if (this.f.containsKey(r5) == true) goto L23;
        mz.b r7 = new mz.b(r3, r4);     // Catch: Exception -> L26
        this.f.put(r5, r7);     // Catch: Exception -> L26
    L23:
        InnerLiveRecFeatureManager.b(r6, r3, r4);     // Catch: Exception -> L26
        return;
    L27:
        r4 = new JSONObject(r1);     // Catch: Exception -> L25
    L31:
        return;
    L8:
        if (StringsKt.isBlank(r0) == true) goto L11;
        r2 = false;
        goto L12
    }

    public final void N(Bundle r3) {
        boolean r0 = this.A;
        if (r0 == false) goto L8;
        if (r3 == null) goto L9;
        r3.putBoolean("live.intent.extra.FROM_NEW_STYLE", r0);
        r3.putString("enter_from_live_source", this.B);
        r3.putString("live.intent.extra.FEED_URL", this.u);
        r3.putString("live.intent.extra.WINDOW_MODE", "full_screen");
        return;
    L9:
        return;
    }

    public final void O(FeedExtra r2) {
        if (r2 == null) goto L6;
        MergeDrawerViewModel r0 = this.L1;
        if (r0 == null) goto L6;
        r0.setFeedExtra(r2);
    L6:
        this.l = r2;
    }

    @Override // com.bytedance.android.livesdk.landscapeslide.b
    public final void a(int r35) {
        LiveFeedMainMonitor.printFeedLog("inder_draw", "loadLand", String.valueOf(this.n), "", s(), "list provider loadLand,index=" + r35 + " isLimit=" + this.v1 + ",isEnough=" + this.x1);
        Integer r3 = null;
        long r4 = 0;
        if (this.v1 == true) goto L5;
        FeedExtra r1 = this.l;
        if (r1 == null) goto L98;
        if (((Extra) r1).hasMore == true) goto L98;
        return;
    L98:
        if (this.a != null) goto L101;
        this.a = new kf2.g();
    L101:
        if (this.k1 == false) goto L105;
        F("is load more running");
        return;
    L105:
        if (this.V0 != null) goto L108;
        F("internal list is null");
        return;
    L108:
        LandscapeLiveMonitor.Companion.getClass();
        LandscapeLiveMonitor r2 = LandscapeLiveMonitor.a.b();
        if (r2 == null) goto L111;
        r2.onStartFeed();
    L111:
        FeedAction r5 = FeedAction.PRODUCE;
        Intrinsics.checkNotNullParameter(r5, "action");
        LandscapeLiveMonitor r6 = LandscapeLiveMonitor.a.b();
        if (r6 == null) goto L114;
        LandscapeLiveMonitor.access$reportFeedAction(r6, r5);
    L114:
        HashMap r7 = new HashMap();
        r7.put("room_offset", Long.valueOf(this.C));
        if (c0.b().i <= 0) goto L117;
        r7.put("trigger_stay_duration", Long.valueOf(c0.b().i));
    L117:
        r7.put("action_type", t());
        if (((Number) qr.a.getValue()).intValue() <= 0) goto L120;
        r7.put("viewed_history", com.bytedance.android.livesdk.log.c0.a());
    L120:
        FeedExtra r8 = this.l;
        if (r8 == null) goto L123;
        long r9 = r8.offset;
    L124:
        r7.put(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, Long.valueOf(r9));
        Long r10 = Long.valueOf(u());
        if (r10.longValue() == 0) goto L127;
        boolean r16 = true;
    L128:
        if (r16 == true) goto L131;
        r10 = null;
    L131:
        if (r10 == null) goto L133;
        r7.put("latest_watch_time", Long.valueOf(r10.longValue()));
    L133:
        FeedExtra r11 = this.l;
        if (r11 == null) goto L141;
        Boolean r12 = Boolean.valueOf(r11.directSort);
        if (r12.booleanValue() == true) goto L139;
        r12 = null;
    L139:
        if (r12 == null) goto L141;
        r12.booleanValue();
        r7.put("content_category", 4);
    L141:
        Map r13 = u.a;
        r7.putAll(u.d());
        r7.putAll(this.Z);
        kf2.g r14 = this.a;
        if (r14 == null) goto L147;
        FeedExtra r15 = this.l;
        if (r15 == null) goto L146;
        r4 = r15.maxTime;
    L146:
        r3 = kf2.g.f(r14, r4, x(), this.n, this.q, this.u, r7, this.s, this.t, this.g, this.o, null, 30720);
    L147:
        if (r3 == null) goto L166;
        this.k1 = true;
        v().l();
        Disposable r17 = r3.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), new f(this));
        this.b1 = r17;
        this.y.add(r17);
        return;
    L166:
        return;
    L127:
        r16 = false;
        goto L128
    L123:
        r9 = 0;
        goto L124
    L5:
        if (this.x1 == true) goto L89;
        int r18 = (e() + i()) + 1;
        ArrayList r19 = new ArrayList();
        int r20 = this.b.size();
        int r21 = 2;
        int r110 = r18;
        int r111 = r110;
    L8:
        if (r110 >= r20) goto L45;
        if (r21 <= 0) goto L45;
        if (D(r110) == true) goto L45;
        Room r112 = (Room) ListProtector.get(this.b, r110);
        ArrayList<FeedItem> r113 = this.V0;
        if (r113 == null) goto L28;
        Iterator<FeedItem> r114 = r113.iterator();
    L17:
        if (r114.hasNext() == false) goto L26;
        FeedItem r115 = r114.next();
        Room r116 = r115.getRoom();
        if (r116 != null) goto L21;
    L23:
        boolean r117 = false;
    L24:
        if (r117 == false) goto L17;
    L27:
        FeedItem r118 = r115;
    L29:
        if (r118 != null) goto L44;
        if (com.bytedance.android.livesdk.landscapeslide.f.b(r112, "loadmore") == false) goto L44;
        if (r111 != r110) goto L39;
        HashSet<Long> r119 = this.y1;
        if (r119 == null) goto L38;
        r119.add(Long.valueOf(r112.getRoomId()));
    L38:
        F("loading skip " + r111 + ' ' + r112.getRoomId());
        r111 = r111 + 1;
    L40:
        ArrayList<FeedItem> r120 = this.V0;
        if (r120 == null) goto L43;
        r120.add((FeedItem) ListProtector.get(this.d, r110));
    L43:
        r21 = r21 - 1;
        goto L44
    L39:
        r19.add(Integer.valueOf(r110));
    L44:
        r110 = r110 + 1;
        goto L8
    L21:
        if (r116.getRoomId() != r112.getRoomId()) goto L23;
        r117 = true;
        goto L24
    L26:
        r115 = null;
        goto L27
    L28:
        r118 = null;
    L45:
        if (r21 <= 0) goto L47;
        this.x1 = true;
        F("limit land is enough");
    L47:
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r23 = r19.iterator();
    L49:
        if (r23.hasNext() == false) goto L51;
        int r121 = ((Number) r23.next()).intValue();
        r22.add(new Triple(ListProtector.get(this.d, r121), ListProtector.get(this.b, r121), ListProtector.get(this.c, r121)));
        goto L49
    L51:
        Iterator r24 = r22.iterator();
    L53:
        if (r24.hasNext() == false) goto L55;
        Triple r25 = (Triple) r24.next();
        ListProtector.add(this.d, r111, r25.getFirst());
        ListProtector.add(this.b, r111, r25.getSecond());
        ListProtector.add(this.c, r111, r25.getThird());
        F("loading insert " + r111 + ' ' + ((Room) r25.getSecond()).getRoomId());
        r111 = r111 + 1;
        goto L53
    L55:
        StringBuilder r26 = new StringBuilder("load done size: ");
        ArrayList<FeedItem> r27 = this.V0;
        if (r27 == null) goto L58;
        r3 = Integer.valueOf(r27.size());
    L58:
        r26.append(r3);
        r26.append(" insert: ");
        r26.append(r18);
        F(r26.toString());
        ArrayList<FeedItem> r28 = this.V0;
        if (r28 != null) goto L61;
    L64:
        boolean r29 = true;
    L65:
        if (r29 == true) goto L80;
        LiveLandSlideContext r30 = this.g1;
        if (r30 == null) goto L71;
        com.bytedance.live.datacontext.m<Boolean> r31 = r30.isDataReady();
        if (r31 == null) goto L71;
        r31.setValue(Boolean.TRUE);
    L71:
        LiveLandSlideContext r32 = this.g1;
        if (r32 == null) goto L76;
        com.bytedance.live.datacontext.m<Boolean> r33 = r32.isDataEmpty();
        if (r33 == null) goto L76;
        r33.setValue(Boolean.FALSE);
    L76:
        LandscapeLiveMonitor.a r34 = LandscapeLiveMonitor.Companion;
        long r36 = this.R;
        r34.getClass();
        LandscapeLiveMonitor r37 = LandscapeLiveMonitor.a.b();
        if (r37 == null) goto L79;
        r37.onEndFeed(r36);
    L79:
        this.R = 0;
    L86:
        if ((!r19.isEmpty()) == false) goto L163;
        dispatchChange();
        return;
    L163:
        return;
    L80:
        LiveLandSlideContext r38 = this.g1;
        if (r38 == null) goto L86;
        com.bytedance.live.datacontext.m<Boolean> r39 = r38.isDataEmpty();
        if (r39 == null) goto L86;
        r39.setValue(Boolean.TRUE);
        goto L86
    L61:
        if (r28.isEmpty() == true) goto L64;
        r29 = false;
        goto L65
    L89:
        if (d() == true) goto L165;
        loadMore(r35);
        return;
    }

    @Override // pg2.e
    public final void b(int r8) {
        if (PersonalizedFeedUtils.b().c() == false) goto L9;
        jg2.a r0 = this.J;
        if (r0 == null) goto L7;
        r0.onItemShow(r8);
    L7:
        LiveFeedMainMonitor.printFeedLog("inder_draw", "onRoomWillShow", String.valueOf(this.n), "", s(), "pos = " + r8 + ", ");
        return;
    }

    public final void configReplaceExtra(com.bytedance.android.live.base.model.feed.b r1) {
        super.configReplaceExtra(null);
    }

    @Override // pg2.e
    public final void f(int r1) {
        loadMore(r1);
        this.X = true;
    }

    public final FeedItem getFeedItem(int r2) {
        int r0 = this.d.size();
        if (r2 < 0) goto L7;
        if (r0 <= r2) goto L7;
        return (FeedItem) ListProtector.get(this.d, r2);
    L7:
        return null;
    }

    public final Bundle getRoomArgs(int r2) {
        if (((Boolean) this.Q.getValue()).booleanValue() == false) goto L11;
        if (r2 >= this.c.size()) goto L9;
        if (r2 < 0) goto L9;
        return (Bundle) ListProtector.get(this.c, r2);
    L9:
        return new Bundle();
    L11:
        return (Bundle) ListProtector.get(this.c, r2);
    }

    public final RoomFlushInfo getRoomFlushInfo(int r2) {
        if (this.b.size() <= r2) goto L7;
        return ((Room) ListProtector.get(this.b, r2)).getRoomFlushInfo();
    L7:
        return super.getRoomFlushInfo(r2);
    }

    public final int indexOf(Bundle r13) {
        if (((Boolean) ww.a.getValue()).booleanValue() == true) goto L5;
    L28:
        long r5 = -1;
        if (r13 == null) goto L31;
        r5 = r13.getLong("live.intent.extra.ROOM_ID", -1);
    L31:
        int r14 = this.c.size();
        int r7 = 0;
    L32:
        if (r7 >= r14) goto L44;
        Object r8 = ListProtector.get(this.c, r7);
        if (((Bundle) r8).getLong("live.intent.extra.ROOM_ID", 0) != r5) goto L36;
        boolean r9 = true;
    L37:
        if (r9 == true) goto L41;
        r8 = null;
    L41:
        if (((Bundle) r8) != null) goto L42;
        r7 = r7 + 1;
        goto L32
    L42:
        return r7;
    L36:
        r9 = false;
        goto L37
    L44:
        return -1;
    L5:
        if (r13 == null) goto L7;
        String r6 = r13.getString("live.intent.extra.EXTRA_ROOM_UNIQUE_KEY");
    L8:
        if (r6 != null) goto L10;
    L13:
        boolean r10 = true;
    L14:
        if (r10 == true) goto L26;
        int r11 = this.c.size();
        int r12 = 0;
    L16:
        if (r12 >= r11) goto L26;
        Object r15 = ListProtector.get(this.c, r12);
        if (Intrinsics.areEqual(((Bundle) r15).getString("live.intent.extra.EXTRA_ROOM_UNIQUE_KEY"), r6) == true) goto L22;
        r15 = null;
    L22:
        if (((Bundle) r15) != null) goto L23;
        r12 = r12 + 1;
        goto L16
    L23:
        return r12;
    L26:
        if (((Boolean) l10.a.getValue()).booleanValue() == false) goto L28;
        return -1;
    L10:
        if (StringsKt.isBlank(r6) == true) goto L13;
        r10 = false;
        goto L14
    L7:
        r6 = null;
        goto L8
    }

    @Override // pg2.e
    public final void l(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        this.u = r2;
    }

    public final void loadMore(int r44) {
        LiveFeedMainMonitor.printFeedLog("inder_draw", "loadMore", String.valueOf(this.n), "", s(), "loadMore called START,isPreLoadConsumed=" + this.U + ",isLoadMoreRunning=" + this.w + ",isFromPreload=" + this.V);
        if (this.U == true) goto L18;
        StringBuilder r2 = new StringBuilder("loadMore from preload size = ");
        Pair<List<FeedItem>, FeedExtra> r5 = this.O;
        if (r5 == null) goto L9;
        List r6 = (List) r5.first;
        if (r6 == null) goto L9;
        Object r7 = Integer.valueOf(r6.size());
    L10:
        r2.append(r7);
        kg2.b.c(r2.toString());
        this.U = true;
        Pair<List<FeedItem>, FeedExtra> r3 = this.O;
        if (r3 == null) goto L18;
        List r4 = (List) r3.first;
        if (r4 == null) goto L18;
        if ((!r4.isEmpty()) != true) goto L18;
        delayParseAndDispatch();
        return;
    L9:
        r7 = null;
    L18:
        MergeDrawerViewModel r8 = this.L1;
        if (r8 != null) goto L21;
    L96:
        FeedExtra r9 = this.l;
        if (r9 == null) goto L99;
        String r10 = r9.personalStrategy;
    L101:
        if (Intrinsics.areEqual(r10, PromotionCategory.CATEGORY_TYPE_SECOND) == true) goto L103;
    L105:
        boolean r15 = false;
    L106:
        if (r15 == false) goto L110;
        LiveFeedMainMonitor.printFeedLog("inder_draw", "loadMore", String.valueOf(this.n), "", s(), "loadMore called START,curIndex=" + r44 + ", roomList.size:" + this.b.size());
        return;
    L110:
        if (this.n > 0) goto L112;
        return;
    L112:
        FeedExtra r11 = this.l;
        if (r11 == null) goto L123;
        if (((Extra) r11).hasMore == true) goto L123;
        pg2.d r12 = this.L;
        if (r12 == null) goto L119;
        boolean r16 = r12.b();
    L120:
        if (r16 == true) goto L123;
        return;
    L119:
        r16 = false;
    L123:
        if (this.a != null) goto L126;
        this.a = new kf2.g();
    L126:
        if (this.w == false) goto L128;
        return;
    L128:
        HashMap<String, Object> r13 = new HashMap();
        r13.put("room_offset", Long.valueOf(this.C));
        long r14 = this.D;
        if (r14 <= 0) goto L132;
        r13.put("trigger_product_id", Long.valueOf(r14));
        r13.put("related_gid", Long.valueOf(this.n));
    L132:
        if (c0.b().i <= 0) goto L134;
        r13.put("trigger_stay_duration", Long.valueOf(c0.b().i));
    L134:
        r13.put("action_type", t());
        if (((Number) qr.a.getValue()).intValue() <= 0) goto L137;
        r13.put("viewed_history", com.bytedance.android.livesdk.log.c0.a());
    L137:
        String r17 = w();
        if (r17 == null) goto L140;
        r13.put("recent_items", r17);
    L140:
        Long r18 = this.H;
        List r19 = com.bytedance.android.livesdk.live.rerank.a.a(this.Y);
        String r20 = x();
        if (LiveInnerReRankUtils.b() == true) goto L143;
        int r21 = k41.a;
    L151:
        int r22 = -1;
    L153:
        String r23 = com.bytedance.android.livesdk.live.a.b(r18, r19, r22, this.H1, null, null, 48);
        if (r23 == null) goto L156;
        r13.put("sort_info", r23);
    L156:
        String r24 = com.bytedance.android.livesdk.live.a.a(this.I);
        if (r24 == null) goto L159;
        r13.put("sati_info", r24);
    L159:
        FeedExtra r25 = this.l;
        if (r25 == null) goto L162;
        long r26 = r25.offset;
    L163:
        r13.put(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, Long.valueOf(r26));
        String r27 = this.F;
        if (r27 == null) goto L166;
        r13.put("content_category", r27);
    L166:
        String r28 = this.G;
        if (r28 == null) goto L169;
        r13.put("similar_anchor_id", r28);
    L169:
        Long r29 = Long.valueOf(u());
        if (r29.longValue() == 0) goto L172;
        boolean r110 = true;
    L173:
        if (r110 == true) goto L176;
        r29 = null;
    L176:
        if (r29 == null) goto L178;
        r13.put("latest_watch_time", Long.valueOf(r29.longValue()));
    L178:
        FeedExtra r30 = this.l;
        if (r30 == null) goto L186;
        Boolean r31 = Boolean.valueOf(r30.directSort);
        if (r31.booleanValue() == true) goto L184;
        r31 = null;
    L184:
        if (r31 == null) goto L186;
        r31.booleanValue();
        r13.put("content_category", 4);
    L186:
        String r32 = this.H1.getString("live_recommend_info");
        if (r32 == null) goto L189;
        r13.put("live_recommend_info", r32);
    L189:
        Map r33 = u.a;
        r13.putAll(u.d());
        r13.putAll(this.Z);
        FeedExtra r34 = this.l;
        if (r34 == null) goto L192;
        Long r35 = Long.valueOf(r34.maxTime);
    L193:
        FeedExtra r36 = this.l;
        if (r36 != null) goto L196;
    L207:
        String r37 = null;
    L209:
        if (this.X == false) goto L218;
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a.b() == false) goto L218;
        pg2.d r38 = this.L;
        if (r38 == null) goto L215;
        r37 = r38.a();
    L216:
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.g("hasLoadMoreRecommend enterSource  = " + r37);
        goto L218
    L215:
        r37 = null;
    L218:
        if (this.V == false) goto L220;
        r37 = this.W;
        this.V = false;
    L220:
        FeedExtra r39 = this.l;
        if (r39 == null) goto L225;
        String r40 = r39.impressionGids;
        if (r40 == null) goto L225;
        r13.put("toplist_impr_gids", r40);
    L225:
        long r41 = SystemClock.elapsedRealtime();
        LiveFeedMainMonitor.printFeedLog("inder_draw", "doLoadmoreInner", String.valueOf(this.n), "", s(), "direct data loadmore inner " + this.U);
        ArrayList<Room> r111 = this.b;
        ArrayList<Bundle> r112 = this.c;
        Lazy r113 = EnterOptimizeUtil.a;
        Intrinsics.checkNotNullParameter(r111, "roomList");
        Intrinsics.checkNotNullParameter(r112, "argsList");
        if (r44 == 0) goto L228;
    L232:
        boolean r210 = false;
    L233:
        if (r44 == 0) goto L235;
    L239:
        boolean r114 = false;
    L240:
        if (r44 == 0) goto L242;
    L244:
        String r115 = "";
    L245:
        Iterator r116 = ((j6) EnterOptimizeUtil.b.getValue()).c().iterator();
    L247:
        if (r116.hasNext() == false) goto L259;
        Object r117 = r116.next();
        n4 r118 = (n4) r117;
        if (r118.a() == true) goto L251;
    L255:
        boolean r42 = false;
    L256:
        if (r42 == false) goto L247;
    L260:
        if (r117 == null) goto L262;
        boolean r43 = true;
    L264:
        if (EnterOptimizeUtil.b() == false) goto L269;
        if (r210 == true) goto L267;
        if (r114 == false) goto L269;
    L267:
        if (r43 == false) goto L269;
        ALogger.d("EnterOptimizeUtil", "enableFeedOptimize true ");
        boolean r45 = true;
    L270:
        String r46 = r();
        kf2.g r47 = this.a;
        if (r47 == null) goto L276;
        if (r35 == null) goto L274;
        long r211 = r35.longValue();
    L275:
        Observable<Pair<List<FeedItem>, FeedExtra>> r48 = r47.e(r211, x(), this.n, this.q, this.u, null, r13, this.s, this.t, this.g, this.o, r37, this.k0, r45, r46);
    L277:
        if (r48 == null) goto L283;
        this.w = true;
        v().l();
        int r49 = com.bytedance.android.live.network.impl.utils.b.c;
        StringBuilder r50 = new StringBuilder("isRetry: ");
        boolean r51 = this.k0;
        Handler r52 = UtilityKotlinExtentionsKt.a;
        r50.append(r51 ? 1 : 0);
        r50.append(", /webcast/feed/ request start .... ");
        com.bytedance.android.live.network.impl.utils.b.a.a(r50.toString());
        int r53 = com.bytedance.android.live.core.utils.d.a;
        if (r37 == null) goto L281;
        boolean r54 = StringsKt.startsWith$default(r37, "homepage_hot", false, 2, null);
    L282:
        this.y.add(r48.compose(com.bytedance.android.live.core.utils.d.a(r54)).subscribe(new com.bytedance.android.livesdk.live.listprovider.e(this, r41, r44), new com.bytedance.android.livesdk.live.listprovider.f(this)));
        goto L283
    L281:
        r54 = false;
    L283:
        LiveFeedMainMonitor.printFeedLog("inder_draw", "loadMore", String.valueOf(this.n), "", s(), "loadMore called END,isPreLoadConsumed=" + this.U + ", mEnterSourceV2=" + this.W + ",enterSource=" + r37 + ",provider= " + hashCode());
        return;
    L274:
        r211 = 0;
        goto L275
    L276:
        r48 = null;
    L269:
        r45 = false;
        goto L270
    L262:
        r43 = false;
        goto L264
    L251:
        if (Intrinsics.areEqual(r118.b(), r37) == false) goto L255;
        if (Intrinsics.areEqual(r118.c(), r115) == false) goto L255;
        r42 = true;
        goto L256
    L259:
        r117 = null;
        goto L260
    L242:
        if ((!r112.isEmpty()) == false) goto L244;
        r115 = ((Bundle) ListProtector.get(r112, r44)).getString("live.intent.extra.ENTER_TYPE", "click");
        goto L245
    L235:
        if ((!r112.isEmpty()) == false) goto L239;
        if (((Bundle) ListProtector.get(r112, r44)).getBoolean("live.intent.extra.is_game_live") == false) goto L239;
        r114 = true;
        goto L240
    L228:
        if ((!r111.isEmpty()) == false) goto L232;
        if (((Room) ListProtector.get(r111, r44)).isGameRoom() != 1) goto L232;
        r210 = true;
        goto L233
    L196:
        if (((Extra) r36).hasMore == true) goto L207;
        pg2.d r55 = this.L;
        if (r55 == null) goto L200;
        boolean r119 = r55.b();
    L201:
        if (r119 == false) goto L207;
        r35 = 0L;
        r13.put("action_type", "refresh");
        pg2.d r56 = this.L;
        if (r56 == null) goto L205;
        r37 = r56.a();
    L206:
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.g("enterSource  = " + r37);
        goto L209
    L205:
        r37 = null;
        goto L206
    L200:
        r119 = false;
        goto L201
    L192:
        r35 = null;
        goto L193
    L172:
        r110 = false;
        goto L173
    L162:
        r26 = 0;
        goto L163
    L143:
        if (r20 != null) goto L146;
        int r57 = k41.a;
    L146:
        if ("homepage_hot_head_loadmore".equals(r20) == false) goto L148;
    L152:
        r22 = LiveInnerReRankUtils.c();
        goto L153
    L148:
        if ("homepage_hot_draw_loadmore".equals(r20) == true) goto L152;
        int r58 = k41.a;
        goto L151
    L103:
        if (r44 == (this.b.size() - 1)) goto L105;
        r15 = true;
        goto L106
    L99:
        r10 = null;
        goto L101
    L21:
        if (r8.getMergeDrawFeed() != true) goto L96;
        if (this.a != null) goto L26;
        this.a = new kf2.g();
    L26:
        if (this.w == true) goto L288;
        FeedExtra r59 = this.l;
        if (r59 != null) goto L31;
    L33:
        long r60 = CastLongProtector.parseLong(this.H1.getString("aggregate_banner_id", BDLocationException.ERROR_TIMEOUT));
        if (this.H1.getString("isInnerFromDrawer", "").equals("true") == false) goto L36;
        long r212 = 1;
    L37:
        long r120 = this.H1.getLong("similar_room_id", 0);
        if (r120 != 0) goto L40;
        boolean r61 = false;
    L41:
        kf2.g r121 = this.a;
        if (r121 == null) goto L92;
        MergeDrawerViewModel r122 = this.L1;
        if (r122 == null) goto L46;
        boolean r123 = r122.isMergePull();
    L47:
        long r124 = this.H1.getLong("live.intent.extra.ROOM_ID", 0);
        FeedExtra r62 = this.l;
        if (r62 == null) goto L50;
        long r63 = r62.maxTime;
    L51:
        com.bytedance.android.livesdk.log.filter.o r64 = com.bytedance.android.livesdk.log.u.l().c(x.class);
        if (r64 == null) goto L57;
        Map<String, String> r125 = r64.getMap();
        if (r125 == null) goto L57;
        String r65 = r125.get("enter_from_merge");
        if (r65 == null) goto L57;
    L58:
        if (r64 == null) goto L63;
        Map<String, String> r66 = r64.getMap();
        if (r66 == null) goto L63;
        String r67 = r66.get("enter_method");
        if (r67 == null) goto L63;
    L64:
        String r68 = r65 + "_" + r67;
        String r213 = r65 + "-" + r67;
        if (r123 == true) goto L80;
        ILiveService r69 = TTLiveService.getLiveService();
        if (r69 == null) goto L79;
        ILiveOntologyInfoManager r70 = r69.getLiveOntologyRecord();
        if (r70 == null) goto L79;
        if (r70.isEnableReplaceRecommend() != true) goto L79;
        c0 r71 = c0.b();
        if (r71.a == false) goto L78;
        c0.a r72 = r71.b;
        if (r72 == null) goto L78;
        String r73 = r72.a;
    L81:
        com.bytedance.android.livesdk.service.l.d().getClass();
        FeedApi r74 = (FeedApi) com.bytedance.android.live.network.c.b().e(FeedApi.class);
        if (r123 == true) goto L85;
        r60 = 0;
    L85:
        if (r123 == false) goto L87;
        long r214 = r120;
    L88:
        if (r123 == false) goto L90;
        boolean r310 = r61;
    L91:
        Observable r75 = r74.feed(1, r124, r63, 1, r73, "loadmore", r213, r60, r212, r214, r310).map(kf2.c.a).doOnNext(new kf2.d(r121));
    L93:
        if (r75 == null) goto L287;
        this.w = true;
        v().l();
        this.y.add(r75.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.live.listprovider.g(this, r44), new com.bytedance.android.livesdk.live.listprovider.h(this)));
        return;
    L287:
        return;
    L90:
        r310 = false;
        goto L91
    L87:
        r214 = 0;
    L78:
        r73 = null;
    L79:
        r73 = "drawer_hot_drawer_cover";
        goto L81
    L80:
        r73 = r68;
    L63:
        r67 = "";
    L57:
        r65 = "";
        goto L58
    L50:
        r63 = 0;
        goto L51
    L46:
        r123 = true;
        goto L47
    L92:
        r75 = null;
        goto L93
    L40:
        r61 = this.H1.getBoolean("open_merge_drawer", false);
        goto L41
    L36:
        r212 = 0;
        goto L37
    L31:
        if (((Extra) r59).hasMore == true) goto L33;
        return;
    }

    @Override // pg2.e
    public final void m(pg2.i r1) {
        this.L = r1;
    }

    public final boolean n(FeedExtra r4) {
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.a(this.W) == true) goto L5;
        if (r4 != null) goto L13;
    L14:
        return true;
    L13:
        if (((Extra) r4).hasMore == true) goto L14;
        return false;
    L5:
        if (this.X == false) goto L9;
        if (r4 == null) goto L9;
        if (((Extra) r4).hasMore == true) goto L9;
        return false;
    L9:
        return true;
    }

    public final void preLoad(int r2) {
        super.preLoad(r2);
        this.V = true;
        loadMore(r2);
        this.U = false;
    }

    public final void preloadPersonalizedRoomList(String r25) {
        Intrinsics.checkNotNullParameter(r25, "sourceKey");
        if (PersonalizedFeedUtils.a(this.H1) == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        this.a = new kf2.g();
    L8:
        long r12 = SystemClock.elapsedRealtime();
        jg2.a r2 = this.J;
        if (r2 == null) goto L11;
        r2.onFetchStart();
    L11:
        LiveFeedMainMonitor.printFeedLog("inder_draw", "preloadPersonalizedRoomList", String.valueOf(this.n), "", s(), "sourceKey=" + r25);
        ConcurrentHashMap<String, Object> r3 = m.a;
        long r4 = this.n;
        Intrinsics.checkNotNullParameter(r25, "enterFromMerge");
        Observable r5 = null;
        if (PersonalizedFeedUtils.c() == true) goto L14;
    L17:
        Object r6 = null;
    L19:
        if ((r6 instanceof Pair) == true) goto L21;
        Object r7 = null;
    L22:
        Pair<List<FeedItem>, FeedExtra> r8 = (Pair) r7;
        if (r8 == null) goto L32;
        C(r8);
        jg2.a r1 = this.J;
        if (r1 == null) goto L27;
        r1.j.putInt("personalized_feed_backend_index", -1);
    L27:
        jg2.a r9 = this.J;
        if (r9 == null) goto L30;
        r9.onFetchSuccess();
    L30:
        m.a(r25, this.n);
        return;
    L32:
        if ((r6 instanceof Observable) == true) goto L34;
        r6 = null;
    L34:
        Observable r10 = (Observable) r6;
        if (r10 != null) goto L44;
        kf2.g r11 = this.a;
        if (r11 == null) goto L45;
        String r13 = this.W;
        long r14 = this.n;
        Intrinsics.checkNotNullParameter(r25, "sourceKey");
        Intrinsics.checkNotNullParameter(r13, "enterSource");
        com.bytedance.android.livesdk.service.l.d().getClass();
        FeedApi r15 = (FeedApi) com.bytedance.android.live.network.c.b().e(FeedApi.class);
        if (((Boolean) y0.a.getValue()).booleanValue() == false) goto L41;
        long r19 = 1;
    L42:
        r5 = r15.feed(r25, r13, 1, 1, r14, 2, LocationMonitorConst.CACHE, r19).map(kf2.e.a).doOnNext(new kf2.f(r11));
        goto L45
    L41:
        r19 = 0;
    L45:
        if (r5 == null) goto L52;
        Disposable r16 = r5.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r12, r25), new h(this));
        jg2.a r17 = this.J;
        if (r17 == null) goto L49;
        r17.j.putInt("personalized_feed_backend_index", -1);
    L49:
        this.y.add(r16);
        return;
    L52:
        return;
    L44:
        r5 = r10;
        goto L45
    L21:
        r7 = r6;
        goto L22
    L14:
        if (PersonalizedFeedUtils.b().a() == false) goto L17;
        r6 = m.a.get(r25 + '_' + r4);
        goto L19
    }

    public final boolean q(long r17) {
        long r3 = ((u8) m10.a.getValue()).a();
        ArrayList<FeedItem> r5 = this.d;
        ListIterator<FeedItem> r6 = r5.listIterator(r5.size());
    L4:
        if (r6.hasPrevious() == false) goto L15;
        FeedItem r7 = r6.previous();
        FeedItem r11 = r7;
        Room r12 = r11.getRoom();
        if (r12 != null) goto L8;
    L12:
        boolean r13 = false;
    L13:
        if (r13 == false) goto L4;
    L16:
        FeedItem r8 = r7;
        if (r8 != null) goto L19;
        return false;
    L19:
        long r14 = System.currentTimeMillis();
        StringBuilder r9 = new StringBuilder("roomid = ");
        r9.append(r17);
        r9.append("  checkTime =  ");
        long r15 = ((long) 1000) * r3;
        r9.append(r15);
        r9.append("  curTime =  ");
        r9.append(r14);
        r9.append("   enterSource = ");
        r9.append(this.E);
        ALogger.i("DrawRoomListDuplicateOpt", r9.toString());
        if (r3 <= 0) goto L31;
        List r4 = ((u8) m10.a.getValue()).b();
        if (r4 != null) goto L24;
        return false;
    L24:
        if (r4.contains(this.E) != true) goto L39;
        long r10 = r8.lastPlayTime;
        if (r10 != 0) goto L28;
    L29:
        ALogger.i("DrawRoomListDuplicateOpt", "roomid = " + r17 + "  过滤新直播间");
        return true;
    L28:
        if ((r14 - r10) < r15) goto L29;
        return false;
    L39:
        return false;
    L31:
        return false;
    L8:
        if (r12.getRoomId() != r17) goto L12;
        if (r11.lastPlayTime < 0) goto L12;
        r13 = true;
        goto L13
    L15:
        r7 = null;
        goto L16
    }

    public final void removeAntiItem(FeedItem r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r2 = String.valueOf(this.n);
        String r4 = s();
        StringBuilder r5 = new StringBuilder("feedItem->roomId：");
        Room r6 = r10.getRoom();
        if (r6 == null) goto L7;
        Long r7 = Long.valueOf(r6.getRoomId());
    L8:
        r5.append(r7);
        LiveFeedMainMonitor.printFeedLog("inder_draw", "removeAntiItem", r2, "", r4, r5.toString());
        Iterator<T> r0 = this.b.iterator();
        int r1 = -1;
        int r3 = 0;
    L10:
        if (r0.hasNext() == false) goto L20;
        Object r8 = r0.next();
        int r9 = r3 + 1;
        if (r3 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        Room r11 = (Room) r8;
        Room r12 = r10.getRoom();
        if (r12 == null) goto L19;
        if (r12.id != r11.id) goto L19;
        r1 = r3;
    L19:
        r3 = r9;
        goto L10
    L20:
        if (r1 >= 0) goto L22;
        return;
    L22:
        if (r1 > this.d.size()) goto L31;
        ListProtector.remove(this.b, r1);
        ListProtector.remove(this.d, r1);
        ListProtector.remove(this.c, r1);
        dispatchChange();
        return;
    L31:
        return;
    L7:
        r7 = null;
        goto L8
    }

    public final void removeFeedItem(FeedItem r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        String r2 = String.valueOf(this.n);
        String r4 = s();
        StringBuilder r5 = new StringBuilder("room_id=");
        Room r6 = r9.getRoom();
        if (r6 == null) goto L7;
        Long r7 = Long.valueOf(r6.getRoomId());
    L8:
        r5.append(r7);
        LiveFeedMainMonitor.printFeedLog("inder_draw", "removeFeedItem", r2, "", r4, r5.toString());
        Iterator<T> r0 = this.d.iterator();
        int r1 = 0;
    L10:
        if (r0.hasNext() == false) goto L18;
        Object r3 = r0.next();
        int r8 = r1 + 1;
        if (r1 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        if (com.bytedance.android.livesdk.feedback.c.c((FeedItem) r3, r9) == true) goto L19;
        r1 = r8;
    L19:
        if (r1 >= 0) goto L21;
        return;
    L21:
        if (r1 >= this.d.size()) goto L27;
        ListProtector.remove(this.d, r1);
        ListProtector.remove(this.b, r1);
        ListProtector.remove(this.c, r1);
        dispatchChange();
        return;
    L27:
        return;
    L18:
        r1 = -1;
        goto L19
    L7:
        r7 = null;
        goto L8
    }

    public final void removeRoom(long r3) {
        if (this.w == true) goto L13;
        ArrayList<Room> r0 = this.b;
        if (r0 == null) goto L13;
        if (r0.size() != 1) goto L13;
        FeedExtra r1 = this.l;
        if (r1 == null) goto L13;
        if (((Extra) r1).hasMore == true) goto L13;
        return;
    L13:
        o(r3, new AnonymousClass1(this));
    }

    public final void setLoadMoreCallback(ILoadMore.ILoadMoreCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (this.p0 != null) goto L6;
        this.p0 = r2;
        return;
    }

    public final void setLoadMoreState(boolean r1) {
        this.k0 = r1;
    }

    public final void setRetryConfig(LoadMoreRetryConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "retryConfig");
        this.H0 = r2;
    }

    public final mz.b y(int r4) {
        Object r0 = null;
        if (r4 >= 0) goto L5;
        return null;
    L5:
        if (r4 >= this.b.size()) goto L24;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Room r5 = (Room) ListProtector.get(this.b, r4);     // Catch: Throwable -> L13
        String r2 = String.valueOf(r5.getRoomId());     // Catch: Throwable -> L13
        if (this.f.containsKey(r2) == false) goto L10;
        mz.b r6 = this.f.get(r2);     // Catch: Throwable -> L13
    L11:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r7) == true) goto L20;
        r0 = r7;
    L20:
        return (mz.b) r0;
    L10:
        Intrinsics.checkNotNullParameter(r5, "$this$explicitInfo");     // Catch: Throwable -> L13
        mz.b r3 = new mz.b(r5.getItemExplicitInfo());     // Catch: Throwable -> L13
        this.f.put(r2, r3);     // Catch: Throwable -> L13
        r6 = r3;
    L13:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L24:
        return null;
    }

    public static /* synthetic */ void p(DrawRoomListProvider r1, long r2) {
        r1.o(r2, DrawRoomListProvider$doRemoveRoom$1.INSTANCE);
    }

    public static void z(Bundle r5, Room r6) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
        String r7 = r6.getItemExplicitInfo();     // Catch: Throwable -> L21
        Unit r3 = null;
        if (com.bytedance.android.livesdk.live.a.c(r7) == true) goto L7;
        r7 = null;
    L7:
        JSONObject r4 = new JSONObject(r7);     // Catch: Throwable -> L21
        String r8 = r4.optString("qpon_token");     // Catch: Throwable -> L21
        if (com.bytedance.android.livesdk.live.a.c(r8) == true) goto L11;
        r8 = null;
    L11:
        if (r5 == null) goto L13;
        r5.putString("qpon_token", r8);     // Catch: Throwable -> L21
    L13:
        String r9 = r4.optString("qpon_biz_tag");     // Catch: Throwable -> L21
        if (com.bytedance.android.livesdk.live.a.c(r9) == true) goto L17;
        r9 = null;
    L17:
        if (r5 == null) goto L19;
        r5.putString("qpon_biz_tag", r9);     // Catch: Throwable -> L21
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L19:
        Result.constructor-impl(r3);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void B(Bundle r7, Room r8) {
        if (r7 != null) goto L5;
    L21:
        if (r7 != null) goto L23;
    L24:
        MergeDrawerViewModel r9 = this.L1;
        if (r9 == null) goto L29;
        ArrayList r10 = r9.getSimilarRoomCache();
        if (r10 == null) goto L29;
        r10.add(Long.valueOf(r8.id));
    L29:
        r8.isSimilarRoom = true;
        return;
    L23:
        if (r7.getLong("similar_room_id", 0) != 0) goto L24;
        return;
    L5:
        if (r7.getBoolean("open_merge_drawer", false) != true) goto L21;
        r8.withAggregateColumn = true;
        VerticalTypeInfo r1 = new VerticalTypeInfo();
        r1.name = r7.getString("aggregate_column_title");
        MergeDrawerViewModel r2 = this.L1;
        if (r2 == null) goto L11;
        Map r3 = r2.getRoomWithAggregateMap();
        if (r3 == null) goto L11;
        VerticalTypeInfo r4 = (VerticalTypeInfo) r3.put(Long.valueOf(r8.id), r1);
    L11:
        Unit r5 = Unit.INSTANCE;
        r8.mVerticalTypeInfo = r1;
        MergeDrawerViewModel r6 = this.L1;
        if (r6 == null) goto L16;
        List r11 = r6.getRoomListCache();
        if (r11 == null) goto L16;
        r11.clear();
    L16:
        MergeDrawerViewModel r12 = this.L1;
        if (r12 == null) goto L21;
        List r13 = r12.getRoomListCache();
        if (r13 == null) goto L21;
        r13.add(r8);
        goto L21
    }

    public final void L(Bundle r3, Room r4) {
        if (((Boolean) my.a.getValue()).booleanValue() == false) goto L14;
        if (r3 == null) goto L15;
        IGameCPData r5 = r4.getGameCPData();
        if (r5 == null) goto L11;
        Long r6 = r5.getPromoteInstanceId();
        if (r6 == null) goto L11;
        String r7 = String.valueOf(r6.longValue());
        if (r7 == null) goto L11;
    L12:
        r3.putString("promote_instance_id", r7);
        return;
    L11:
        r7 = "";
        goto L12
    L15:
        return;
    }

    public final void M(Bundle r3, FeedItem r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        Room r0 = r4.getRoom();
        if (r0 == null) goto L7;
        String r1 = r0.getOwnerUserIdString();
    L8:
        r3.putString("enter_from_user_id", r1);
        if (r4.isPseudoLiving == false) goto L12;
        r3.putBoolean("live.intent.extra.IS_PSEUDO_LIVING", true);
        return;
    L12:
        return;
    L7:
        r1 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.landscapeslide.b
    public final void c(int r4, LiveLandSlideContext r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (this.p1.contains(this.E) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.v1 = r0;
        F("initLand index: " + r4 + " list: " + com.bytedance.android.livesdk.landscapeslide.f.e(this.b, r4, new DrawRoomListProvider$initLand$1(this)));
        if (this.v1 == true) goto L11;
        this.L0 = this.C;
        this.P0 = this.l;
        this.C = 0;
        O(null);
    L12:
        this.g1 = r5;
        this.V0 = new ArrayList();
        this.h1 = r4;
        a(r4);
        return;
    L11:
        this.y1 = new HashSet();
        this.G1 = new HashSet();
        goto L12
    L5:
        if (D(r4) == true) goto L7;
        r0 = true;
        goto L8
    }

    @Override // pg2.e
    public final void g(long r11, int r13) {
        this.h.add(Long.valueOf(r11));
        int r0 = this.d.size();
        if (r13 < 0) goto L7;
        if (r0 <= r13) goto L7;
        boolean r1 = ((FeedItem) ListProtector.get(this.d, r13)).isHideBucketItem();
    L8:
        int r2 = this.d.size();
        if (r13 < 0) goto L13;
        if (r2 <= r13) goto L13;
        int r3 = ((FeedItem) ListProtector.get(this.d, r13)).contentCategory;
    L14:
        jg2.a r4 = this.J;
        if (r4 == null) goto L18;
        r4.onItemShow(r13);
    L18:
        if (this.v1 == false) goto L22;
        HashSet<Long> r5 = this.G1;
        if (r5 == null) goto L22;
        r5.add(Long.valueOf(r11));
    L22:
        LiveFeedMainMonitor.printFeedLog("inder_draw", "onRoomShow", String.valueOf(this.n), "", s(), "roomId=" + r11 + " is showing;pos=" + r13 + ", contentCategory:" + r3 + ",isHideBucket =  " + r1);
        return;
    L13:
        r3 = -1;
    L7:
        r1 = false;
        goto L8
    }

    public final void o(long r11, Function0<Unit> r13) {
        ArrayList<Room> r0 = this.b;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L88;
        ArrayList<Bundle> r3 = this.c;
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == true) goto L93;
        ArrayList<FeedItem> r5 = this.d;
        if (r5 != null) goto L21;
    L24:
        boolean r6 = true;
    L25:
        if (r6 == true) goto L95;
        LiveFeedMainMonitor.printFeedLog("inder_draw", "doRemoveRoom", String.valueOf(this.n), "", s(), "room:" + r11);
        int r7 = this.b.size();
        int r8 = 0;
    L28:
        if (r8 >= r7) goto L96;
        if (((Room) ListProtector.get(this.b, r8)).id == r11) goto L32;
        r8 = r8 + 1;
        goto L28
    L32:
        if (this.c.size() <= r8) goto L35;
        ListProtector.remove(this.c, r8);
    L35:
        if (this.b.size() <= r8) goto L38;
        ListProtector.remove(this.b, r8);
    L38:
        if (this.d.size() <= r8) goto L40;
        ListProtector.remove(this.d, r8);
    L40:
        MergeDrawerViewModel r9 = this.L1;
        if (r9 == null) goto L45;
        ArrayList r10 = r9.getSimilarRoomCache();
        if (r10 == null) goto L45;
        r10.remove(Long.valueOf(r11));
    L45:
        Integer r12 = null;
        if (this.d.size() <= r8) goto L61;
        FeedbackCard r14 = ((FeedItem) ListProtector.get(this.d, r8)).feedbackCard;
        if (r14 == null) goto L50;
        Long r15 = r14.roomId;
    L51:
        if (r15 == null) goto L61;
        if (r15.longValue() != r11) goto L61;
        ListProtector.remove(this.d, r8);
        if (this.b.size() <= r8) goto L59;
        ListProtector.remove(this.b, r8);
    L59:
        if (this.c.size() <= r8) goto L61;
        ListProtector.remove(this.c, r8);
        goto L61
    L50:
        r15 = null;
    L61:
        ArrayList<FeedItem> r16 = this.V0;
        if (r16 == null) goto L86;
        int r17 = this.h1;
        int r18 = -1;
        if (r8 > r17) goto L67;
        if (r17 <= 0) goto L67;
        F("doRemoveRoom: index degrade " + this.h1);
        this.h1 = this.h1 + (-1);
    L67:
        Iterator<FeedItem> r19 = r16.iterator();
        int r20 = 0;
    L69:
        if (r19.hasNext() == false) goto L79;
        Room r21 = r19.next().getRoom();
        if (r21 != null) goto L73;
    L75:
        boolean r22 = false;
    L76:
        if (r22 == true) goto L77;
        r20 = r20 + 1;
        goto L69
    L77:
        r18 = r20;
        goto L79
    L73:
        if (r21.getRoomId() != r11) goto L75;
        r22 = true;
    L79:
        Integer r110 = Integer.valueOf(r18);
        if (r110.intValue() < 0) goto L82;
        r1 = true;
    L82:
        if (r1 == false) goto L84;
        r12 = r110;
    L84:
        if (r12 == null) goto L86;
        FeedItem r111 = (FeedItem) ListProtector.remove(r16, r12.intValue());
    L86:
        r13.invoke();
        return;
    L96:
        return;
    L95:
        return;
    L21:
        if (r5.isEmpty() == true) goto L24;
        r6 = false;
        goto L25
    L93:
        return;
    L13:
        if (r3.isEmpty() == true) goto L16;
        r4 = false;
        goto L17
    L88:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public final void pullToRefresh(IPullable.IPullCallback<Integer> r22, IPullable.IPullCheck r23) {
        Intrinsics.checkNotNullParameter(r22, "callback");
        ALogger.i("DrawRoomListProvider", "start pull to refresh");
        if (this.a != null) goto L5;
        this.a = new kf2.g();
    L5:
        if (r23 == null) goto L7;
        r23.triggerAction();
    L7:
        HashMap r12 = new HashMap();
        long r3 = 0;
        r12.put("room_offset", 0L);
        String r5 = com.bytedance.android.livesdk.live.a.b(this.H, null, 0, this.H1, null, null, 54);
        if (r5 == null) goto L10;
        r12.put("sort_info", r5);
    L10:
        String r6 = com.bytedance.android.livesdk.live.a.a(this.I);
        if (r6 == null) goto L13;
        r12.put("sati_info", r6);
    L13:
        Long r7 = Long.valueOf(u());
        if (r7.longValue() == 0) goto L16;
        boolean r8 = true;
    L17:
        Observable r9 = null;
        if (r8 == true) goto L21;
        r7 = null;
    L21:
        if (r7 == null) goto L23;
        r12.put("latest_watch_time", Long.valueOf(r7.longValue()));
    L23:
        FeedExtra r10 = this.l;
        if (r10 == null) goto L31;
        Boolean r11 = Boolean.valueOf(r10.directSort);
        if (r11.booleanValue() == true) goto L29;
        r11 = null;
    L29:
        if (r11 == null) goto L31;
        r11.booleanValue();
        r12.put("content_category", 4);
    L31:
        long r13 = this.D;
        if (r13 <= 0) goto L35;
        r12.put("trigger_product_id", Long.valueOf(r13));
        r12.put("related_gid", Long.valueOf(this.n));
    L35:
        if (c0.b().i <= 0) goto L37;
        r12.put("trigger_stay_duration", Long.valueOf(c0.b().i));
    L37:
        String r14 = w();
        if (r14 == null) goto L40;
        r12.put("recent_items", r14);
    L40:
        this.C = 0;
        if (((Number) qr.a.getValue()).intValue() <= 0) goto L43;
        r12.put("viewed_history", com.bytedance.android.livesdk.log.c0.a());
    L43:
        r12.put("action_type", "pull_refresh");
        FeedExtra r15 = this.l;
        if (r15 == null) goto L46;
        r3 = r15.offset;
    L46:
        r12.put(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, Long.valueOf(r3));
        String r4 = this.F;
        if (r4 == null) goto L49;
        r12.put("content_category", r4);
    L49:
        String r16 = this.G;
        if (r16 == null) goto L52;
        r12.put("similar_anchor_id", r16);
    L52:
        Map r17 = u.a;
        r12.putAll(u.d());
        r12.putAll(this.Z);
        kf2.g r18 = this.a;
        if (r18 == null) goto L55;
        r9 = kf2.g.f(r18, 0, this.v + "_pull_refresh", this.n, this.q, this.u, r12, this.s, this.t, this.g, this.o, null, 30720);
    L55:
        if (r9 == null) goto L58;
        v().l();
        this.y.add(r9.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this, r22, r23), new j(this, r22, r23)));
        return;
    L58:
        return;
    L16:
        r8 = false;
        goto L17
    }

    public final void autoLoadMore(int r32, int r33, int r34, Long r35) {
        Ref.IntRef r2 = new Ref.IntRef();
        r2.element = 100;
        long r3 = 0;
        if (this.n > 0) goto L6;
        r2.element = 101;
        return;
    L6:
        MergeDrawerViewModel r0 = this.L1;
        if (r0 != null) goto L9;
    L12:
        FeedExtra r1 = this.l;
        if (r1 == null) goto L19;
        if (((Extra) r1).hasMore == true) goto L19;
        r2.element = 103;
        return;
    L19:
        if (this.a != null) goto L22;
        this.a = new kf2.g();
    L22:
        if (this.x == false) goto L25;
        r2.element = 104;
        return;
    L25:
        this.x = true;
        HashMap<String, Object> r4 = new HashMap();
        r4.put("room_offset", Long.valueOf(this.C));
        long r5 = this.D;
        if (r5 <= 0) goto L29;
        r4.put("trigger_product_id", Long.valueOf(r5));
        r4.put("related_gid", Long.valueOf(this.n));
    L29:
        if (c0.b().i <= 0) goto L31;
        r4.put("trigger_stay_duration", Long.valueOf(c0.b().i));
    L31:
        r4.put("action_type", t());
        ArrayList r6 = new ArrayList();
        HashMap<String, HashSet<Long>> r7 = this.i;
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator<Map.Entry<String, HashSet<Long>>> r9 = r7.entrySet().iterator();
    L32:
        boolean r29 = false;
        if (r9.hasNext() == false) goto L39;
        Map.Entry<String, HashSet<Long>> r10 = r9.next();
        r10.getValue().removeAll(this.h);
        if (r10.getValue().size() <= 0) goto L37;
        r29 = true;
    L37:
        if (r29 == false) goto L32;
        r8.put(r10.getKey(), r10.getValue());
        goto L32
    L39:
        Iterator r11 = r8.entrySet().iterator();
    L41:
        if (r11.hasNext() == false) goto L43;
        r6.addAll((Collection) ((Map.Entry) r11.next()).getValue());
        goto L41
    L43:
        r6.removeAll(this.e);
        if (((Number) qr.a.getValue()).intValue() <= 0) goto L46;
        r4.put("viewed_history", com.bytedance.android.livesdk.log.c0.a());
    L46:
        String r12 = w();
        if (r12 == null) goto L49;
        r4.put("recent_items", r12);
    L49:
        String r13 = com.bytedance.android.livesdk.live.a.b(this.H, null, 0, this.H1, Integer.valueOf(r34), r35, 6);
        if (r13 == null) goto L52;
        r4.put("sort_info", r13);
    L52:
        String r14 = com.bytedance.android.livesdk.live.a.a(this.I);
        if (r14 == null) goto L55;
        r4.put("sati_info", r14);
    L55:
        Long r15 = Long.valueOf(u());
        if (r15.longValue() == 0) goto L58;
        boolean r16 = true;
    L59:
        Disposable r30 = null;
        if (r16 == true) goto L63;
        r15 = null;
    L63:
        if (r15 == null) goto L65;
        r4.put("latest_watch_time", Long.valueOf(r15.longValue()));
    L65:
        FeedExtra r17 = this.l;
        if (r17 == null) goto L73;
        Boolean r18 = Boolean.valueOf(r17.directSort);
        if (r18.booleanValue() == true) goto L71;
        r18 = null;
    L71:
        if (r18 == null) goto L73;
        r18.booleanValue();
        r4.put("content_category", 4);
    L73:
        Map r19 = u.a;
        r4.putAll(u.d());
        r4.putAll(this.Z);
        String r28 = r();
        kf2.g r20 = this.a;
        if (r20 == null) goto L79;
        FeedExtra r21 = this.l;
        if (r21 == null) goto L78;
        r3 = r21.maxTime;
    L78:
        Observable<Pair<List<FeedItem>, FeedExtra>> r22 = r20.e(r3, x(), this.n, this.q, this.u, r6, r4, this.s, this.t, this.g, this.o, null, false, false, r28);
    L80:
        if (r22 == null) goto L86;
        Observable r23 = r22.subscribeOn(Schedulers.io());
        if (r23 == null) goto L86;
        Observable r24 = r23.observeOn(AndroidSchedulers.mainThread());
        if (r24 == null) goto L86;
        r30 = r24.subscribe(new c(this, r2, r33, r32, r34, r6), new d(this));
    L86:
        Disposable r25 = r30;
        this.m = r25;
        if (r25 == null) goto L89;
        this.y.add(r25);
    L89:
        int r26 = xe1.a.c;
        xe1.a.a = System.currentTimeMillis();
        LinkedHashMap r27 = new LinkedHashMap();
        r27.put("draw_order", String.valueOf(r32));
        Unit r31 = Unit.INSTANCE;
        LinkedHashMap r36 = new LinkedHashMap();
        r36.putAll(r27);
        r36.put("duration", String.valueOf(System.currentTimeMillis() - xe1.a.b));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_internal_flow_refresh", r36, new Object[]{Room.class, x.class});
        return;
    L79:
        r22 = null;
        goto L80
    L58:
        r16 = false;
        goto L59
    L9:
        if (r0.getMergeDrawFeed() != true) goto L12;
        r2.element = 102;
    }

    public final void insertAntiItem(FeedItem r2, Room r3, Bundle r4, int r5) {
        if (r3 == null) goto L16;
        if (r2 == null) goto L17;
        if (r4 != null) goto L6;
        return;
    L6:
        if (this.b.size() >= r5) goto L8;
    L14:
        ALogger.d("DrawRoomListProvider", "insert antiAddiction item error:index: " + r5 + ", listSize" + this.d.size());
        return;
    L8:
        if (this.d.size() < r5) goto L14;
        if (this.c.size() < r5) goto L14;
        if (r5 < 0) goto L14;
        ListProtector.add(this.b, r5, r3);
        ListProtector.add(this.d, r5, r2);
        N(r4);
        ListProtector.add(this.c, r5, r4);
        dispatchChange();
        return;
    L17:
        return;
    }

    public final void insertFeedItem(FeedItem r9, Room r10, Bundle r11, Long r12) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (r12 == null) goto L40;
        r12.longValue();
        Iterator<T> r0 = this.b.iterator();
        int r1 = 0;
    L7:
        if (r0.hasNext() == false) goto L15;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        long r4 = ((Room) r2).getRoomId();
        if (r12.longValue() == r4) goto L16;
        r1 = r3;
    L16:
        if (r1 >= 0) goto L19;
        return;
    L19:
        if (r1 >= this.d.size()) goto L21;
        ListProtector.add(this.d, r1 + 1, r9);
    L21:
        if (r10 != null) goto L23;
        Room r13 = r9.getRoom();
    L25:
        if (r1 >= this.b.size()) goto L27;
        ListProtector.add(this.b, r1 + 1, r13);
    L27:
        if (r11 != null) goto L29;
        r11 = ArgumentsBuilder.buildRoomArgs(r13);
    L29:
        N(r11);
        if (r1 >= this.c.size()) goto L32;
        ListProtector.add(this.c, r1 + 1, r11);
    L32:
        String r5 = String.valueOf(this.n);
        String r6 = s();
        StringBuilder r14 = new StringBuilder("room=");
        if (r10 == null) goto L35;
        String r15 = r10.getIdStr();
    L36:
        r14.append(r15);
        LiveFeedMainMonitor.printFeedLog("inder_draw", "insertFeedItem", r5, "", r6, r14.toString());
        dispatchChange();
        return;
    L35:
        r15 = null;
        goto L36
    L23:
        r13 = r10;
        goto L25
    L15:
        r1 = -1;
        goto L16
    }

    public final void insertFeedItemForIndex(FeedItem r11, Room r12, Bundle r13, int r14, Function1<? super Boolean, Unit> r15) {
        if (r12 == null) goto L44;
        if (r11 == null) goto L44;
        if (r13 == null) goto L44;
        if (this.b.size() >= r14) goto L8;
    L40:
        ALogger.d("DrawRoomListProvider", "insert feed item error:index: " + r14 + ", listSize" + this.d.size());
        if (r15 == null) goto L50;
        Unit r16 = (Unit) r15.invoke(Boolean.FALSE);
        return;
    L50:
        return;
    L8:
        if (this.d.size() < r14) goto L40;
        if (this.c.size() < r14) goto L40;
        if (r14 < 0) goto L40;
        long r2 = r12.getRoomId();
        Integer r0 = (Integer) tv.a.getValue();
        boolean r5 = false;
        if ((r14 - r0.intValue()) >= 0) goto L16;
        int r4 = 0;
    L18:
        if ((r0.intValue() + r14) < this.b.size()) goto L20;
        int r1 = this.b.size() - 1;
    L21:
        if (r4 > r1) goto L29;
    L22:
        Room r6 = (Room) ListProtector.get(this.b, r4);
        if (r6 != null) goto L25;
    L27:
        if (r4 == r1) goto L29;
        r4 = r4 + 1;
        goto L22
    L25:
        if (r6.getRoomId() != r2) goto L27;
        ALogger.i("DrawRoomListProvider", "Remove behind and after repeat continuously room " + r2);
        r5 = true;
    L29:
        if (r5 == true) goto L31;
    L35:
        ListProtector.add(this.b, r14, r12);
        ListProtector.add(this.d, r14, r11);
        N(r13);
        ListProtector.add(this.c, r14, r13);
        if (r15 == null) goto L38;
        Unit r17 = (Unit) r15.invoke(Boolean.TRUE);
    L38:
        dispatchChange();
        return;
    L31:
        if (((Boolean) LiveInfraSettingKeys.LIVE_INNER_TAB_GUIDE_DUPLICATE_ENABLE.getValue()).booleanValue() == false) goto L35;
        if (r15 == null) goto L49;
        Unit r18 = (Unit) r15.invoke(Boolean.FALSE);
        return;
    L49:
        return;
    L20:
        r1 = r0.intValue() + r14;
        goto L21
    L16:
        r4 = r14 - r0.intValue();
    L44:
        if (r15 == null) goto L51;
        Unit r19 = (Unit) r15.invoke(Boolean.FALSE);
        return;
    }

    public final void replaceFeedItems(int r22, int r23, List<FeedItem> r24, List<FeedItem> r25, ILiveRoomListProvider.ReplaceFeedItemsCallback r26) {
        List<FeedItem> r2 = r24;
        int r3 = 0;
        boolean r5 = true;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        Room r6 = null;
        if (r4 == false) goto L14;
        if (r26 == null) goto L126;
        r26.onFail("return list is empty", null);
        return;
    L126:
        return;
    L14:
        StringBuilder r7 = new StringBuilder("feedItemList size ");
        if (r24 == null) goto L17;
        Integer r8 = Integer.valueOf(r24.size());
    L18:
        r7.append(r8.intValue());
        r7.append(", beginIndex = ");
        r7.append(r23);
        LiveInnerReRankUtils.e(r7.toString());
        LinkedHashMap r9 = new LinkedHashMap();
        ArrayList r11 = new ArrayList();
        Iterator<T> r10 = r24.iterator();
    L20:
        if (r10.hasNext() == false) goto L38;
        FeedItem r12 = (FeedItem) r10.next();
        Room r13 = r12.getRoom();
        if (r13 == null) goto L24;
        String r14 = r13.getIdStr();
    L26:
        if (r9.containsKey(r14) == false) goto L32;
        Room r15 = r12.getRoom();
        if (r15 == null) goto L30;
        String r16 = r15.getIdStr();
    L31:
        r11.add(r16);
        goto L32
    L30:
        r16 = null;
    L32:
        Room r17 = r12.getRoom();
        if (r17 == null) goto L35;
        String r18 = r17.getIdStr();
    L36:
        r9.put(r18, r12);
        goto L20
    L35:
        r18 = null;
        goto L36
    L24:
        r14 = null;
        goto L26
    L38:
        if ((!r11.isEmpty()) == false) goto L41;
        if (r26 == null) goto L41;
        r26.onDeduplication(CollectionsKt.joinToString$default(r11, ",", null, null, 0, null, null, 62, null));
    L41:
        int r19 = LiveInnerReRankUtils.c();
        boolean r20 = LiveInnerReRankUtils.a.e();
        LiveInnerReRankUtils.e("setting reRankHideBucketCount: " + r19 + ", useNewAdjust: " + r20);
        if (r19 > 0) goto L109;
        if (r20 == true) goto L109;
        if ((r24.size() + r23) == this.d.size()) goto L116;
        if (r26 == null) goto L127;
        r26.onFail("data list has changed", null);
        return;
    L127:
        return;
    L116:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L106
        int r27 = r24.size();     // Catch: Throwable -> L106
        int r28 = 0;
    L51:
        if (r28 >= r27) goto L75;
        Room r29 = ((FeedItem) ListProtector.get(r24, r28)).getRoom();     // Catch: Throwable -> L106
        if (r29 == null) goto L55;
        Long r30 = Long.valueOf(r29.id);     // Catch: Throwable -> L106
    L56:
        int r110 = r28 + r23;     // Catch: Throwable -> L106
        Room r31 = ((FeedItem) ListProtector.get(this.d, r110)).getRoom();     // Catch: Throwable -> L106
        if (r31 == null) goto L59;
        Long r32 = Long.valueOf(r31.id);     // Catch: Throwable -> L106
    L61:
        if ((!Intrinsics.areEqual(r30, r32)) == true) goto L62;
        r28 = r28 + 1;     // Catch: Throwable -> L106
        goto L51
    L62:
        if (r28 != 0) goto L68;
        Room r0 = ((FeedItem) ListProtector.get(this.d, r23 - 1)).getRoom();     // Catch: Throwable -> L106
        if (r0 == null) goto L66;
        Long r1 = Long.valueOf(r0.id);     // Catch: Throwable -> L106
    L67:
        long r33 = r1.longValue();     // Catch: Throwable -> L106
    L73:
        FeedItem r34 = (FeedItem) ListProtector.get(r24, r28);     // Catch: Throwable -> L106
    L76:
        if (r110 > r22) goto L80;
        if (r26 == null) goto L128;
        r26.onFail("index is invalid, cannot replace", null);     // Catch: Throwable -> L106
        return;
    L128:
        return;
    L80:
        int r35 = this.d.size();     // Catch: Throwable -> L106
    L81:
        if (r3 >= r35) goto L97;
        if (((FeedItem) ListProtector.get(this.d, r3)).getRoom() == null) goto L96;
        Room r36 = ((FeedItem) ListProtector.get(this.d, r3)).getRoom();     // Catch: Throwable -> L106
        if (r36 == null) goto L87;
        Long r37 = Long.valueOf(r36.id);     // Catch: Throwable -> L106
    L88:
        if (r34 == null) goto L92;
        Room r38 = r34.getRoom();     // Catch: Throwable -> L106
        if (r38 == null) goto L92;
        Long r39 = Long.valueOf(r38.id);     // Catch: Throwable -> L106
    L94:
        if (Intrinsics.areEqual(r37, r39) == false) goto L96;
        Bundle r40 = (Bundle) ListProtector.get(this.c, r3);     // Catch: Throwable -> L106
        Room r41 = (Room) ListProtector.get(this.b, r3);     // Catch: Throwable -> L106
        removeFeedItem((FeedItem) ListProtector.get(this.d, r3));     // Catch: Throwable -> L106
        r6 = r41;
        Bundle r42 = r40;
    L98:
        insertFeedItem(r34, r6, r42, Long.valueOf(r33));     // Catch: Throwable -> L106
        if (r26 == null) goto L101;
        r26.onSuccess(this.d);     // Catch: Throwable -> L106
    L101:
        if (r5 == false) goto L104;
        if (r26 == null) goto L104;
        r26.preloadNextRoom();     // Catch: Throwable -> L106
    L104:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L106
        return;
    L92:
        r39 = null;
        goto L94
    L87:
        r37 = null;
    L96:
        r3 = r3 + 1;     // Catch: Throwable -> L106
        goto L81
    L97:
        r42 = null;
        goto L98
    L66:
        r1 = null;
        goto L67
    L68:
        Room r43 = ((FeedItem) ListProtector.get(this.d, r110 - 1)).getRoom();     // Catch: Throwable -> L106
        if (r43 == null) goto L71;
        Long r44 = Long.valueOf(r43.id);     // Catch: Throwable -> L106
    L72:
        r33 = r44.longValue();     // Catch: Throwable -> L106
        r5 = false;
        goto L73
    L71:
        r44 = null;
        goto L72
    L59:
        r32 = null;
        goto L61
    L55:
        r30 = null;
        goto L56
    L75:
        r33 = 0;
        r34 = null;
        r5 = false;
        r110 = 0;
    L106:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L109:
        if (this.g1 == null) goto L114;
        LiveInnerReRankUtils.e("current orientation is horizontal, landscape draw mode");
        if (r26 == null) goto L129;
        r26.onFail("current orientation is horizontal, landscape draw mode", null);
        return;
    L129:
        return;
    L114:
        LiveInnerReRankUtils.f(r22, r23, r24, r25, this.d, this.c, this.b, this.Y, r26, new AnonymousClass2(this));
        return;
    L17:
        r8 = null;
        goto L18
    L5:
        if (r2.isEmpty() == true) goto L8;
        r4 = false;
        goto L9
    }

    public DrawRoomListProvider(Bundle r19, String r20, String r21, MergeDrawerViewModel r22, Room r23, com.bytedance.android.livesdk.live.f r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r19, "roomArgs");
        Intrinsics.checkNotNullParameter(r20, "url");
        Intrinsics.checkNotNullParameter(r21, "requestFrom");
        this.H1 = r19;
        this.L1 = r22;
        this.M1 = r23;
        this.P1 = r24;
        this.Q1 = r25;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ConcurrentHashMap();
        this.g = 1;
        this.h = new HashSet();
        this.i = new HashMap();
        this.j = new HashSet();
        this.k = new HashMap();
        this.q = BDLocationException.ERROR_TIMEOUT;
        this.s = -1;
        this.u = "";
        this.v = "";
        this.y = new CompositeDisposable();
        this.E = "";
        this.M = LazyKt.lazy(DrawRoomListProvider$mFeedMonitor$2.INSTANCE);
        this.N = LazyKt.lazy(DrawRoomListProvider$mLiveApiRetryLogger$2.INSTANCE);
        this.P = LazyKt.lazy(DrawRoomListProvider$liveRoomMemoryOpt$2.INSTANCE);
        this.Q = LazyKt.lazy(DrawRoomListProvider$listProviderExpFix$2.INSTANCE);
        this.U = true;
        this.W = "";
        this.Y = new com.bytedance.android.livesdk.live.rerank.a();
        this.Z = new LinkedHashMap();
        this.u = r20;
        this.n = r19.getLong("live.intent.extra.ROOM_ID", 0);
        this.r = r19.getLong("live.intent.extra.latest_watch_time", 0);
        int r11 = com.bytedance.android.livesdk.live.a.a;
        Intrinsics.checkNotNullParameter(r19, "args");
        int r12 = 0;
        boolean r13 = r19.getBoolean("enter_from_effect_ad", false);
        boolean r14 = r19.getBoolean("enter_from_dou_plus", false);
        Serializable r15 = r19.getSerializable("live_effect_ad_log_extra_map");
        Serializable r16 = r19.getSerializable("live_douplus_log_extra");
        boolean r8 = r15 instanceof HashMap;
        if (r8 == false) goto L10;
        if (r8 == true) goto L6;
        r15 = null;
    L6:
        HashMap r17 = (HashMap) r15;
        if (r17 == null) goto L10;
        String r9 = (String) r17.get("is_other_channel");
        if (r9 == null) goto L10;
    L11:
        boolean r18 = r16 instanceof HashMap;
        if (r18 == false) goto L21;
        if (r18 == true) goto L15;
        r16 = null;
    L15:
        HashMap r110 = (HashMap) r16;
        if (r110 == null) goto L19;
        r9 = (String) r110.get("is_other_channel");
        if (r9 != null) goto L21;
    L19:
        r9 = "";
    L21:
        if (r13 == false) goto L23;
        r9 = "effective_ad";
    L25:
        String r10 = r19.getString("is_other_channel");
        if (TextUtils.isEmpty(r10) == true) goto L29;
        Intrinsics.checkNotNull(r10);
        r9 = r10;
    L29:
        if (Intrinsics.areEqual(r9, "dou_plus") == false) goto L32;
        int r26 = 2;
    L35:
        this.o = r26;
        this.p = r19.getInt("live.intent.extra.USER_COUNT", 0);
        this.s = r19.getLong("follow_group_id", -1);
        this.t = r19.getString("follow_group_type", null);
        this.F = r19.getString("content_category", null);
        this.G = r19.getString("similar_anchor_id", null);
        Bundle r0 = m0.a(r19);
        if (r0 == null) goto L38;
        long r111 = 0;
        Long r6 = Long.valueOf(r0.getLong("video_id", 0));
    L39:
        this.H = r6;
        if (r6 != null) goto L43;
    L65:
        this.S = this.H1.getBoolean("live.intent.extra.is_multi_tab_container", false);
        o0.a r1 = o0.a;
        Bundle r5 = this.H1;
        r1.getClass();
        this.q = o0.a.c(r5, "anchor_id", BDLocationException.ERROR_TIMEOUT);
        this.I = this.H1.getString("sati_rec_pred_scores");
        Bundle r2 = m0.a(this.H1);
        if (r2 != null) goto L68;
    L72:
        String r3 = this.H1.getString("ecom_live_params", null);
        String r27 = "DrawRoomListProvider";
        if (TextUtils.isEmpty(r3) == true) goto L79;
        this.D = JSONObjectProtectorUtils.getLong(new JSONObject(r3), "product_id");     // Catch: JSONException -> L76
    L76:
        e = move-exception;
        ALogger.d("DrawRoomListProvider", e.getMessage());
    L79:
        if (r21.length() != 0) goto L81;
        boolean r4 = true;
    L83:
        if (r4 == false) goto L87;
        Bundle r7 = m0.a(this.H1);
        if (r7 == null) goto L88;
        this.v = FeedDraw.conventRequestFrom(r7.getString("enter_from_merge", ""), r7.getString("enter_method", ""), r7);
    L88:
        Bundle r28 = m0.a(this.H1);
        if (r28 == null) goto L103;
        String r29 = r28.getString("enter_from_merge", "");
        String r112 = r28.getString("enter_method", "");
        if (TextUtils.isEmpty(r29) == false) goto L93;
    L96:
        String r30 = "";
    L97:
        this.E = r30;
        String r31 = r28.getString("enter_from_merge", "");
        String r32 = r28.getString("enter_method", "");
        if (r31 != null) goto L100;
        r31 = "";
    L100:
        if (r32 != null) goto L102;
        r32 = "";
    L102:
        this.W = r31 + "-" + r32;
        goto L103
    L93:
        if (TextUtils.isEmpty(r112) == true) goto L96;
        r30 = r29 + "_" + r112;
    L103:
        o0.a r33 = o0.a;
        Bundle r34 = this.H1;
        r33.getClass();
        if (q0.a(o0.a.c(r34, "anchor_id", BDLocationException.ERROR_TIMEOUT)) == true) goto L106;
        this.H1.putString("anchor_id", this.q);
    L106:
        this.H1.putString("enter_from_user_id", this.q);
        if (StringUtils.isEmpty(this.H1.getString("live.intent.extra.REQUEST_ID", "")) == false) goto L110;
        Bundle r35 = this.H1;
        r35.putString("live.intent.extra.REQUEST_ID", r35.getString("request_id", ""));
    L110:
        if (StringUtils.isEmpty(this.H1.getString("live.intent.extra.LOG_PB", "")) == false) goto L112;
        Bundle r36 = this.H1;
        r36.putString("live.intent.extra.LOG_PB", r36.getString("log_pb", ""));
    L112:
        Bundle r37 = m0.a(this.H1);
        if (r37 == null) goto L115;
        String r113 = r37.getString("live_reason");
        String r114 = r37.getString("live_recommend_info");
    L116:
        RoomFlushInfo r115 = this.H1.getParcelable("live.intent.provider_room_flush_info");
        if (r115 == null) goto L119;
        int r38 = r115.getFlushTimes();
    L120:
        ((ILiveRoomListProvider) this).flushTimes = r38;
        String r39 = this.H1.getString("feed_extra_params");
        if (StringUtils.isEmpty(r39) == true) goto L128;
        Type r116 = new k().getType();
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L125
        this.Z.putAll((Map) LiveGsonHelper.get().fromJson(r39, r116));     // Catch: Throwable -> L125
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L125
    L125:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L128:
        if (this.H1.containsKey("live.intent.extra.item_id_for_view_pager") == false) goto L130;
        this.H1.remove("live.intent.extra.item_id_for_view_pager");
    L130:
        this.c.add(this.H1);
        Room r41 = this.M1;
        if (r41 == null) goto L133;
        this.b.add(r41);
    L139:
        if (((LiveRoomMemoryOptConfig) this.P.getValue()).getEnable() == false) goto L141;
        ALogger.i("DrawRoomListProvider", "Memory opt: limit maxCacheCount = " + ((LiveRoomMemoryOptConfig) this.P.getValue()).getMaxCacheCount());
    L141:
        FeedItem r42 = new FeedItem();
        if (this.H1.getBoolean("live.intent.extra.IS_PSEUDO_LIVING", false) == false) goto L144;
        boolean r43 = true;
        r42.isPseudoLiving = true;
    L146:
        if (this.H1.getBoolean("open_merge_drawer", false) != r43) goto L148;
    L149:
        r42.setRoom((Room) ListProtector.get(this.b, 0));
    L150:
        this.d.add(r42);
        jg2.a r44 = new jg2.a(this.n, this.q, this.H1, this);
        this.J = r44;
        r44.onItemShow(0);
        Bundle r45 = this.H1;
        String r46 = "live.intent.extra.OFFSET";
        String r118 = "live.intent.extra.MAX_TIME";
        String r119 = "live.intent.extra.HAS_MORE";
        if (r45 == null) goto L155;
        HashSet<Long> r120 = new HashSet();
        this.A = r45.getBoolean("live.intent.extra.FROM_NEW_STYLE", false);
        this.B = r45.getString("enter_from_live_source", "");
        Intrinsics.checkNotNullParameter(r45, "$this$getMoreBundle");
        SparseArray r121 = yt2.a.d(r45);
        if (r121 == null) goto L155;
        int r122 = r121.size() + 1;
    L157:
        if (r12 >= r122) goto L183;
        SparseArray r123 = r121;
        Bundle r124 = (Bundle) r121.get(r12);
        if (r124 == null) goto L181;
        N(r124);
        this.c.add(r124);
        ArrayList<Room> r125 = this.b;
        Room r47 = new Room();
        int r126 = r12;
        long r127 = r124.getLong("live.intent.extra.ROOM_ID", 0);
        r47.id = r127;
        r47.setIdStr(String.valueOf(r127));
        r47.set_isFromRecommendCard(!TextUtils.isEmpty(r124.getString("enter_from_merge_recommend", null)));
        r47.set_liveReason(r124.getString("live_reason", null));
        r47.setItemExplicitInfo(r124.getString("live_recommend_info", null));
        User r48 = new User();
        o0.a.getClass();
        r48.setIdString(o0.a.c(r124, "anchor_id", BDLocationException.ERROR_TIMEOUT));
        Unit r128 = Unit.INSTANCE;
        r47.setOwner(r48);
        r47.adRawString = r124.getString("data_live_effect_ad_log_extra_string", null);
        if (((Boolean) LiveConfigSettingKeys.LIVE_HANDLE_AD_IN_NewFeedStyleEntranceUtils.getValue()).booleanValue() == false) goto L180;
        String r129 = r47.adRawString;
        if (r129 != null) goto L165;
    L168:
        boolean r130 = true;
    L169:
        if (r130 == false) goto L171;
        r47.adRawString = r124.getString("data_live_effect_ad_log_extra_string");
    L171:
        String r131 = r47.adRawString;
        if (r131 != null) goto L174;
    L177:
        boolean r132 = true;
    L178:
        if (r132 == true) goto L180;
        r124.remove("data_live_effect_ad_log_extra_string");
        goto L180
    L174:
        if (r131.length() == 0) goto L177;
        r132 = false;
        goto L178
    L165:
        if (r129.length() == 0) goto L168;
        r130 = false;
    L180:
        r47.setRoomFlushInfo(new RoomFlushInfo(((ILiveRoomListProvider) this).flushTimes, r126 + 1));
        r125.add(r47);
        this.d.add(new FeedItem());
        r120.add(Long.valueOf(r124.getLong("live.intent.extra.ROOM_ID", 0)));
    L182:
        r12 = r126 + 1;
        r121 = r123;
        r122 = r122;
        r27 = r27;
        r46 = r46;
        r118 = r118;
        r119 = r119;
        goto L157
    L181:
        r126 = r12;
        goto L182
    L183:
        String r210 = r27;
        String r211 = r46;
        String r212 = r118;
        String r49 = r119;
        if (r45.containsKey(r49) == false) goto L189;
        String r50 = r212;
        if (r45.containsKey(r50) == false) goto L188;
        FeedExtra r51 = new FeedExtra();
        ((Extra) r51).hasMore = r45.getBoolean(r49, false);
        r51.maxTime = r45.getLong(r50, 0);
        String r52 = r211;
        r51.offset = r45.getLong(r52, 0);
        Unit r53 = Unit.INSTANCE;
        O(r51);
    L191:
        if (StringUtils.isEmpty(r45.getString("live.intent.extra.UNREAD_ID", "")) == true) goto L216;
        FeedExtra r54 = this.l;
        if (r54 == null) goto L195;
        r54.unreadExtra = r45.getString("live.intent.extra.UNREAD_ID", "");
    L195:
        FeedExtra r55 = this.l;
        if (r55 == null) goto L198;
        String r56 = r55.unreadExtra;
    L200:
        if (StringUtils.isEmpty(r56) == true) goto L216;
        FeedExtra r57 = this.l;
        if (r57 == null) goto L204;
        String r58 = r57.unreadExtra;
    L205:
        if (r58 != null) goto L207;
    L210:
        boolean r59 = true;
    L211:
        if (r59 == true) goto L213;
        String r60 = r58;
    L214:
        if (r60 == null) goto L216;
        this.i.put(r60 + '_' + this.z, r120);
        this.k.put(r60 + '_' + this.z, r120);
        this.z = this.z + 1;
        goto L216
    L213:
        r60 = null;
        goto L214
    L207:
        if (r58.length() == 0) goto L210;
        r59 = false;
        goto L211
    L204:
        r58 = null;
        goto L205
    L198:
        r56 = null;
    L216:
        String r61 = r210;
        Logger.d(r61, "handleSingleDrawFeedMode isSingleRoomDrawFeedMode = " + this.Q1);
        if (this.Q1 == false) goto L219;
        FeedExtra r62 = new FeedExtra();
        ((Extra) r62).hasMore = this.H1.getBoolean(r49, false);
        r62.maxTime = this.H1.getLong(r50, 0);
        r62.offset = this.H1.getLong(r52, 0);
        Unit r63 = Unit.INSTANCE;
        O(r62);
    L219:
        Logger.d(r61, "Enter room id: " + this.n + ", anchor id: " + this.q + ", request from: " + this.v);
        this.h1 = -1;
        this.p1 = CollectionsKt.listOf(new String[]{"homepage_follow_live_cell", "homepage_follow_video_head", "homepage_follow_live_cover"});
        return;
    L188:
        r52 = r211;
        goto L191
    L189:
        r52 = r211;
        r50 = r212;
    L155:
        r210 = "DrawRoomListProvider";
        r52 = "live.intent.extra.OFFSET";
        r50 = "live.intent.extra.MAX_TIME";
        r49 = "live.intent.extra.HAS_MORE";
        goto L216
    L148:
        if (this.S == false) goto L150;
    L144:
        r43 = true;
        goto L146
    L133:
        ArrayList<Room> r64 = this.b;
        Room r65 = new Room();
        r65.id = this.n;
        r65.setUserCount(this.p);
        r65.setIdStr(String.valueOf(this.n));
        r65.set_liveReason(r113);
        r65.setItemExplicitInfo(r114);
        r65.liveRecommendInfo = r114;
        B(this.H1, r65);
        User r133 = new User();
        r133.setIdString(this.q);
        Unit r134 = Unit.INSTANCE;
        r65.setOwner(r133);
        int r135 = ((ILiveRoomListProvider) this).flushTimes;
        if (r115 == null) goto L136;
        int r136 = r115.getPositionInFlush();
    L137:
        r65.setRoomFlushInfo(new RoomFlushInfo(r135, r136));
        r64.add(r65);
        goto L139
    L136:
        r136 = 1;
        goto L137
    L119:
        r38 = 1;
        goto L120
    L115:
        r114 = "";
        r113 = r114;
        goto L116
    L87:
        this.v = r21;
        goto L88
    L81:
        r4 = false;
        goto L83
    L68:
        if (Intrinsics.areEqual(r2.getString("is_mini_window", ""), "1") == false) goto L72;
        if (this.H1.getBoolean("live.intent.extra.IS_FROM_XTAB") == false) goto L72;
        this.g = 0;
        goto L72
    L43:
        if (r6.longValue() != r111) goto L65;
        if (lg2.a.a.b() == false) goto L65;
        Result.Companion r66 = Result.Companion;     // Catch: Throwable -> L59
        if (r0 == null) goto L56;
        String r67 = r0.getString("video_id");     // Catch: Throwable -> L59
        if (r67 == null) goto L56;
        if (com.bytedance.android.livesdk.live.a.c(r67) == true) goto L54;
        r67 = null;
    L54:
        if (r67 == null) goto L56;
        Long r68 = Long.valueOf(CastLongProtector.parseLong(r67));     // Catch: Throwable -> L59
    L57:
        Object r69 = Result.constructor-impl(r68);     // Catch: Throwable -> L59
    L62:
        if (Result.isFailure-impl(r69) == false) goto L64;
        r69 = 0L;
    L64:
        this.H = (Long) r69;
    L56:
        r68 = null;
    L59:
        th = move-exception;
        Result.Companion r70 = Result.Companion;
        r69 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L62
    L38:
        r111 = 0;
        r6 = null;
        goto L39
    L32:
        if (Intrinsics.areEqual(r9, "effective_ad") == false) goto L34;
        r26 = 3;
        goto L35
    L34:
        r26 = 0;
        goto L35
    L23:
        if (r14 == false) goto L25;
        r9 = "dou_plus";
    L10:
        r9 = "";
        goto L11
    }

    public static void J(final DrawRoomListProvider r31, List r32, FeedExtra r33, boolean r34, int r35, boolean r36, boolean r37, int r38) {
        List r2 = r32;
        if ((r38 & 8) == 0) goto L5;
        int r5 = -1;
    L7:
        if ((r38 & 16) == 0) goto L9;
        boolean r7 = false;
    L11:
        if ((r38 & 32) == 0) goto L13;
        boolean r8 = false;
    L14:
        r31.getClass();
        Intrinsics.checkNotNullParameter(r2, "items");
        Intrinsics.checkNotNullParameter(r33, "extra");
        ((ILiveRoomListProvider) r31).flushTimes++;
        if (r32.isEmpty() == true) goto L519;
        String r10 = "DrawRoomListProvider";
        PersonalizedFeedUtils.e("DrawRoomListProvider", "checkPersonalizedCacheIndexIfNeed personalized:" + r8);
        if (r8 == false) goto L20;
    L167:
        boolean r20 = r7;
        boolean r23 = r8;
    L168:
        int r4 = -1;
    L169:
        PersonalizedFeedUtils.e("DrawRoomListProvider", "parseRoom personalizedInsertIndex:" + r4 + ", insertIndex:" + r5);
        HashSet<Long> r3 = new HashSet();
        int r6 = r31.d.size();
        boolean r9 = S1.contains(r31.E);
        int r0 = u2.a;
        String[] r1 = Keva.getRepo("need_delete_room_after_report").getStringArray("room_list", new String[0]);
        if (r1 != null) goto L172;
        r1 = new String[0];
    L172:
        ALogger.d("ReportRoomHelper", "recorded deleted room id's size in keva " + r1.length);
        List r11 = ArraysKt.toList(r1);
        boolean r12 = r11.isEmpty() ^ true;
        Iterator r13 = r2.iterator();
        int r15 = r5;
        int r14 = 1;
        boolean r16 = false;
        int r17 = 0;
    L173:
        int r18 = r5;
        String r19 = "";
        if (r13.hasNext() == false) goto L446;
        Object r21 = r13.next();
        int r110 = r17 + 1;
        if (r17 >= 0) goto L178;
        CollectionsKt.throwIndexOverflow();
    L178:
        Iterator r22 = r13;
        FeedItem r24 = (FeedItem) r21;
        Room r25 = r24.getRoom();
        if (r25 == null) goto L184;
        FeedbackCard r26 = r25.mFeedbackCard;
        if (r26 == null) goto L184;
        r26.feedbackType = r26.inflowFeedbackType;
    L184:
        FeedbackCard r27 = r24.feedbackCard;
        if (r27 == null) goto L188;
        r27.feedbackType = r27.inflowFeedbackType;
    L188:
        if (r24.getItem() == null) goto L489;
    L193:
        int r28 = r4;
        r24.setFeedFetchCount(r31.C);
        FeedbackManager.Companion.getClass();
        Room r29 = r24.getRoom();
        if (r29 == null) goto L196;
        FeedbackCard r30 = r29.mFeedbackCard;
    L197:
        if (r30 == null) goto L199;
        boolean r39 = true;
    L200:
        if (r39 == false) goto L214;
        Room r40 = r24.getRoom();
        if (r40 == null) goto L206;
        FeedbackCard r41 = r40.mFeedbackCard;
        if (r41 == null) goto L206;
        r41.setIndex(Integer.valueOf(r6 + r17));
    L206:
        LightFeedbackDataManager.Companion.getClass();
        LightFeedbackDataManager r42 = LightFeedbackDataManager.a.a();
        if (r42 == null) goto L214;
        Room r43 = r24.getRoom();
        if (r43 == null) goto L211;
        Long r44 = Long.valueOf(r43.getRoomId());
    L212:
        r42.saveRoomFeedback(r44.longValue(), r24);
        Unit r45 = Unit.INSTANCE;
        goto L214
    L211:
        r44 = null;
    L214:
        if (FeedbackManager.b.b(r24) == false) goto L254;
        FeedbackCard r46 = r24.feedbackCard;
        if (r46 == null) goto L218;
        r46.setIndex(Integer.valueOf(r6 + r17));
    L218:
        FeedbackManager r47 = FeedbackManager.b.a();
        if (r47 == null) goto L225;
        FeedExtra r48 = r31.l;
        if (r48 == null) goto L223;
        String r49 = r48.unreadExtra;
    L224:
        r47.saveUnReadFeedback(r24, r49);
        Unit r50 = Unit.INSTANCE;
        goto L225
    L223:
        r49 = null;
    L225:
        FeedbackCard r51 = r24.feedbackCard;
        if (r51 == null) goto L228;
        Long r52 = r51.roomId;
    L229:
        if (r52 == null) goto L254;
        if (r51 == null) goto L232;
        Room r53 = r51.room;
    L233:
        if (r53 == null) goto L254;
        if (r17 < 1) goto L252;
        if (r51 == null) goto L238;
        Long r54 = r51.roomId;
    L239:
        Room r55 = ((FeedItem) ListProtector.get(r2, r17 - 1)).getRoom();
        if (r55 == null) goto L242;
        Long r56 = Long.valueOf(r55.getRoomId());
    L244:
        if (Intrinsics.areEqual(r54, r56) == false) goto L252;
        FeedbackManager r57 = FeedbackManager.b.a();
        if (r57 == null) goto L252;
        FeedbackCard r58 = r24.feedbackCard;
        if (r58 == null) goto L250;
        Long r59 = r58.roomId;
    L251:
        Intrinsics.checkNotNull(r59);
        r57.saveRoomFeedback(r59.longValue(), r24);
        Unit r60 = Unit.INSTANCE;
        goto L252
    L250:
        r59 = null;
        goto L251
    L242:
        r56 = null;
        goto L244
    L238:
        r54 = null;
    L252:
        boolean r210 = r9;
        r11 = r11;
        int r61 = r15;
        r4 = r28;
        int r111 = r6;
        r12 = r12;
        HashSet<Long> r62 = r3;
        r10 = r10;
    L445:
        r3 = r62;
        r11 = r11;
        r6 = r111;
        r5 = r18;
        r17 = r110;
        r13 = r22;
        r10 = r10;
        r12 = r12;
        r9 = r210;
        r15 = r61;
        r2 = r32;
        goto L173
    L232:
        r53 = null;
        goto L233
    L228:
        r52 = null;
    L254:
        if (r24.type != 3) goto L256;
        r32.size();
    L256:
        Item r63 = r24.getItem();
        if ((r63 instanceof Room) == true) goto L259;
        r63 = null;
    L259:
        Room r64 = (Room) r63;
        if (r64 == null) goto L424;
        if (r34 == false) goto L268;
        long r65 = r31.n;
        User r211 = r64.getOwner();
        if (r211 == null) goto L268;
        if (r65 != r211.getLiveRoomId()) goto L268;
        ALogger.i(r10, "Remove duplicate room " + r31.n);
    L269:
        int r66 = r15;
    L287:
        r61 = r66;
        r111 = r6;
        r210 = r9;
        boolean r67 = r16;
        r62 = r3;
        r4 = r28;
    L423:
        Unit r68 = Unit.INSTANCE;
        r16 = r67;
    L425:
        FeedbackManager.Companion.getClass();
        if (FeedbackManager.b.b(r24) == false) goto L428;
        FeedItem r69 = r24;
    L429:
        if (r69 == null) goto L441;
        FeedbackCard r70 = r69.feedbackCard;
        if (r70 == null) goto L441;
        Room r71 = new Room();
        Long r72 = r70.feedbackId;
        if (r72 == null) goto L435;
        long r73 = r72.longValue();
    L436:
        r71.id = r73;
        r31.b.add(r71);
        Bundle r74 = new Bundle();
        Long r75 = r70.feedbackId;
        if (r75 == null) goto L439;
        long r76 = r75.longValue();
    L440:
        r74.putLong("live.intent.extra.ROOM_ID", r76 + ((long) r70.hashCode()));
        r31.c.add(r74);
        r31.d.add(r24);
    L442:
        Map r77 = u.a;
        u.e(r24.getRoom());
        Room r78 = r24.getRoom();
        if (r78 == null) goto L445;
        r31.K(r78);
        Unit r79 = Unit.INSTANCE;
        goto L445
    L439:
        r76 = 0;
        goto L440
    L435:
        r73 = 0;
    L441:
        r11 = r11;
        goto L442
    L428:
        r69 = null;
    L268:
        if (r31.E(r64.getRoomId()) == true) goto L269;
        if (r31.q(r64.getRoomId()) == false) goto L282;
        kotlin.Pair[] r112 = new kotlin.Pair[6];
        r112[0] = TuplesKt.to("enter_from_merge", r31.H1.getString("enter_from_merge", ""));
        r112[1] = TuplesKt.to("enter_method", r31.H1.getString("enter_method", ""));
        r112[2] = TuplesKt.to("action_type", "draw");
        r112[3] = TuplesKt.to("room_id", String.valueOf(r64.getRoomId()));
        User r80 = r64.getOwner();
        if (r80 == null) goto L276;
        String r81 = r80.getIdStr();
        if (r81 == null) goto L276;
    L277:
        r112[4] = TuplesKt.to("anchor_id", r81);
        String r82 = r64.getRequestId();
        if (r82 == null) goto L281;
        r19 = r82;
    L281:
        r112[5] = TuplesKt.to("request_id", r19);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_client_duplicate_removal", MapsKt.hashMapOf(r112), new Object[0]);
    L276:
        r81 = "";
        goto L277
    L282:
        r66 = r15;
        r31.Y.b(r64.getRoomId());
        if (r9 == false) goto L289;
        if (r12 == false) goto L289;
        if (r11.contains(String.valueOf(r64.getRoomId())) == true) goto L287;
    L289:
        if (r24.type != 28) goto L291;
        r64.setHybridAdExtra(r24.adRawString);
    L292:
        r64.set_isFromRecommendCard(r24.isRecommendCard);
        r64.set_liveReason(r24.liveReason);
        r64.liveRecommendInfo = r24.liveRecommendInfo;
        if (r64.withAggregateColumn != true) goto L309;
        MergeDrawerViewModel r83 = r31.L1;
        if (r83 == null) goto L309;
        if (r83.getMergeDrawFeed() != true) goto L309;
        MergeDrawerViewModel r85 = r31.L1;
        if (r85 == null) goto L304;
        Map r86 = r85.getRoomWithAggregateMap();
        if (r86 == null) goto L304;
        Long r113 = Long.valueOf(r64.id);
        VerticalTypeInfo r114 = new VerticalTypeInfo();
        r114.name = r31.H1.getString("aggregate_column_title");
        Unit r87 = Unit.INSTANCE;
        VerticalTypeInfo r88 = (VerticalTypeInfo) r86.put(r113, r114);
    L304:
        MergeDrawerViewModel r89 = r31.L1;
        if (r89 == null) goto L310;
        List r90 = r89.getRoomListCache();
        if (r90 == null) goto L310;
        r90.add(r64);
    L310:
        MergeDrawerViewModel r91 = r31.L1;
        if (r91 != null) goto L313;
    L324:
        r64.setRoomFlushInfo(new RoomFlushInfo(((ILiveRoomListProvider) r31).flushTimes, r14));
        r14 = r14 + 1;
        Bundle r92 = ArgumentsBuilder.buildRoomArgs(r64);
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.e() == false) goto L338;
        if (r92 == null) goto L338;
        FeedExtra r93 = r33;
        if (r93 == null) goto L330;
        String r94 = r93.unreadExtra;
    L332:
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.d(r94) == false) goto L339;
        if (r93 == null) goto L336;
        String r95 = r93.unreadExtra;
        if (r95 == null) goto L336;
    L337:
        r92.putString("live.intent.extra.LIVE_FOLLOW_RECOMMEND_UNREAD_EXTRA", r95);
    L336:
        r95 = r19;
    L339:
        r31.N(r92);
        r31.M(r92, r24);
        com.bytedance.android.livesdk.log.n.a(r92, r24);
        r31.L(r92, r64);
        z(r92, r64);
        if (((Boolean) r10.a.getValue()).booleanValue() == false) goto L348;
        r111 = r6;
        r210 = r9;
        if (r31.j.contains(Long.valueOf(r64.id)) == false) goto L344;
        r92.putString("is_refresh_redistribute", "1");
    L345:
        if (r20 == false) goto L349;
        if (r16 == true) goto L349;
        r92.putBoolean("live_pull_refresh_finish_flag", true);
    L349:
        if (r20 == false) goto L352;
        r92.putString("is_refresh", "1");
    L352:
        if (r31.S == false) goto L354;
        r92.putBoolean("live.intent.extra.is_multi_tab_container", true);
    L354:
        r92.putString("extra_content_category", String.valueOf(r24.contentCategory));
        if (tb1.c.a == false) goto L358;
        qg2.a.a(r92, r24);
    L358:
        if (LiveInnerReRankUtils.b() == true) goto L361;
    L363:
        boolean r96 = false;
    L364:
        if (r96 == false) goto L390;
        com.bytedance.android.livesdk.live.rerank.a r97 = r31.Y;
        r97.getClass();
        Intrinsics.checkNotNullParameter(r64, "room");
        Intrinsics.checkNotNullParameter(r24, "feedItem");
        if (LiveInnerReRankUtils.b() == false) goto L389;
        List<Room> r98 = r97.a;
        if ((r98 instanceof Collection) == true) goto L371;
    L373:
        Iterator r99 = ((ArrayList) r98).iterator();
    L375:
        if (r99.hasNext() == false) goto L383;
        Iterator r115 = r99;
        if (((Room) r99.next()).getRoomId() != r64.id) goto L379;
        boolean r100 = true;
    L380:
        if (r100 == true) goto L381;
        r99 = r115;
        goto L375
    L381:
        boolean r101 = true;
    L384:
        if (r101 == false) goto L386;
        LiveInnerReRankUtils.e("LiveInnerHideBucketCache updateHideList duplicate room " + r64.id);
        goto L389
    L386:
        LiveInnerReRankUtils.e("LiveInnerHideBucketCache updateHideList room " + r64.id);
        if (r64.id <= 0) goto L389;
        ((ArrayList) r97.a).add(r64);
        ((ArrayList) r97.b).add(r92);
        r24.setHideBucketItem(true);
        ((ArrayList) r97.c).add(r24);
        r97.d = r93;
        goto L389
    L379:
        r100 = false;
    L383:
        r101 = false;
        goto L384
    L371:
        if (((ArrayList) r98).isEmpty() == false) goto L373;
    L389:
        r61 = r66;
        r62 = r3;
        r4 = r28;
    L422:
        r67 = true;
        goto L423
    L390:
        int r102 = r31.d.size();
        if (r66 < 0) goto L405;
        if (r102 < r66) goto L405;
        ListProtector.add(r31.b, r66, r64);
        ListProtector.add(r31.c, r66, r92);
        ListProtector.add(r31.d, r66, r24);
        ArrayList<FeedItem> r103 = r31.V0;
        if (r103 == null) goto L397;
        r103.add(r24);
    L397:
        r61 = r66 + 1;
        if (r31.R != 0) goto L404;
        Room r104 = r24.getRoom();
        if (r104 == null) goto L402;
        Long r105 = Long.valueOf(r104.getRoomId());
    L403:
        r31.R = r105.longValue();
        goto L404
    L402:
        r105 = null;
    L404:
        r4 = r28;
    L419:
        r62 = r3;
        r62.add(Long.valueOf(r64.id));
        IFeatureService r106 = jc1.k.f(IFeatureService.class);
        if (r106 == null) goto L422;
        r106.saveUnreadRoomFeature(r64, r31.b.size() - 1);
        Unit r107 = Unit.INSTANCE;
    L405:
        int r108 = r31.d.size();
        if (r28 < 0) goto L410;
        if (r108 < r28) goto L410;
        ListProtector.add(r31.b, r28, r64);
        ListProtector.add(r31.c, r28, r92);
        ListProtector.add(r31.d, r28, r24);
        r4 = r28 + 1;
        r61 = r66;
    L410:
        if (r66 < 0) goto L412;
    L418:
        r61 = r66;
        r4 = r28;
        goto L419
    L412:
        if (r24.isAd == true) goto L414;
    L417:
        r31.b.add(r64);
        r31.c.add(r92);
        r31.d.add(r24);
        goto L418
    L414:
        if (((ArrayList) r31.e).contains(Long.valueOf(r64.getRoomId())) == false) goto L416;
        r61 = r66;
        r67 = r16;
        r4 = r28;
        r62 = r3;
        goto L423
    L416:
        ((ArrayList) r31.e).add(Long.valueOf(r64.getRoomId()));
        goto L417
    L361:
        if (r24.contentCategory != 5) goto L363;
        r96 = true;
        goto L364
    L344:
        r92.putString("is_refresh_redistribute", BDLocationException.ERROR_TIMEOUT);
        goto L345
    L348:
        r111 = r6;
        r210 = r9;
        goto L349
    L330:
        r94 = null;
    L338:
        r93 = r33;
        goto L339
    L313:
        if (r91.isSimilarRoom() != true) goto L324;
        MergeDrawerViewModel r109 = r31.L1;
        if (r109 == null) goto L324;
        if (r109.isMergePull() != true) goto L324;
        MergeDrawerViewModel r116 = r31.L1;
        if (r116 == null) goto L323;
        ArrayList r117 = r116.getSimilarRoomCache();
        if (r117 == null) goto L323;
        r117.add(Long.valueOf(r64.id));
    L323:
        r64.isSimilarRoom = true;
    L309:
        r19 = "";
        goto L310
    L291:
        r64.adRawString = r24.adRawString;
        goto L292
    L424:
        r210 = r9;
        int r118 = r15;
        r111 = r6;
        r62 = r3;
        r61 = r118;
        r4 = r28;
        goto L425
    L199:
        r39 = false;
        goto L200
    L196:
        r30 = null;
        goto L197
    L489:
        r24.setItem(r24.getRoom());     // Catch: Exception -> L191
        r31.A(r24);     // Catch: Exception -> L191
    L191:
        e = move-exception;
        e.printStackTrace();
        goto L193
    L446:
        HashSet<Long> r119 = r3;
        String r120 = r33.unreadExtra;
        if (r120 != null) goto L449;
    L452:
        boolean r121 = true;
    L453:
        if (r121 == true) goto L455;
        String r122 = r120;
    L456:
        if (r122 == null) goto L463;
        String r123 = r122 + '_' + r31.z;
        r31.i.put(r123, r119);
        r31.k.put(r123, r119);
        if (r23 == false) goto L462;
        jg2.a r124 = r31.J;
        if (r124 == null) goto L462;
        Intrinsics.checkNotNullParameter(r123, "resKey");
        Intrinsics.checkNotNullParameter(r119, "idSet");
        r124.d.put(r123, r119);
        Unit r125 = Unit.INSTANCE;
    L462:
        r31.z++;
    L463:
        String r126 = r33.satiParamForPitaya;
        if (r126 == null) goto L468;
        ILiveReRankService r127 = jc1.k.n(IHostBusiness.class).getReRankWebcastService();
        if (r127 == null) goto L468;
        r127.updateLastServerSideParam(r126);
        Unit r128 = Unit.INSTANCE;
    L468:
        String r129 = r33.userExtraInfo;
        if (r129 == null) goto L474;
        ILiveReRankService r130 = jc1.k.n(IHostBusiness.class).getReRankWebcastService();
        if (r130 == null) goto L474;
        r130.updateUserSideParam(r129);
        Unit r131 = Unit.INSTANCE;
    L474:
        if (r31.Z.containsKey("search_offset") == false) goto L476;
        r31.Z.put("search_offset", Integer.valueOf(r33.searchOffset));
    L476:
        String r132 = String.valueOf(r31.n);
        String r133 = r31.s();
        StringBuilder r134 = new StringBuilder("insertIndex=");
        r134.append(r18);
        r134.append("，isPersonalized=");
        r134.append(r23);
        r134.append(",roomlist=");
        r134.append(r119);
        r134.append(",log=");
        JsonObject r135 = r33.getLogPb();
        if (r135 == null) goto L482;
        JsonElement r136 = r135.get("impr_id");
        if (r136 == null) goto L482;
        String r137 = r136.getAsString();
        if (r137 == null) goto L482;
    L483:
        r134.append(r137);
        LiveFeedMainMonitor.printFeedLog("inder_draw", "parseRoom", r132, "", r133, r134.toString());
        return;
    L482:
        r137 = "";
        goto L483
    L455:
        r122 = null;
        goto L456
    L449:
        if (r120.length() == 0) goto L452;
        r121 = false;
        goto L453
    L20:
        if (PersonalizedFeedUtils.c() == false) goto L167;
        jg2.a r138 = r31.J;
        if (r138 != null) goto L24;
    L136:
        r20 = r7;
        r23 = r8;
    L137:
        jg2.a r139 = r31.J;
        if (r139 == null) goto L168;
        if (r139.a != true) goto L168;
        ArrayList<FeedItem> r140 = r31.d;
        Intrinsics.checkNotNullParameter(r140, "feedItems");
        r139.a(r139.c);
        long[] r141 = r139.c;
        int r142 = r141.length;
        int r143 = 0;
    L142:
        if (r143 >= r142) goto L150;
        if (r141[r143] != 0) goto L146;
        boolean r144 = true;
    L147:
        if (r144 == true) goto L151;
        r143 = r143 + 1;
    L151:
        Iterator<FeedItem> r145 = r140.iterator();
        int r146 = 0;
    L153:
        if (r145.hasNext() == false) goto L168;
        FeedItem r147 = r145.next();
        int r148 = r146 + 1;
        if (r146 >= 0) goto L157;
        CollectionsKt.throwIndexOverflow();
    L157:
        FeedItem r149 = r147;
        if (r146 < r143) goto L166;
        if (r149 != null) goto L161;
    L163:
        boolean r150 = false;
    L164:
        if (r150 == false) goto L166;
        PersonalizedFeedUtils.e("DrawRoomPersonalizedContext", "findFirstValidPersonalizedFeedIndex: " + r146);
        r4 = r146;
        goto L169
    L161:
        if (r149.contentCategory != 6) goto L163;
        r150 = true;
    L166:
        r146 = r148;
        goto L153
    L146:
        r144 = false;
        goto L147
    L150:
        r143 = -1;
        goto L151
    L24:
        if (r138.a == false) goto L31;
        int r151 = r138.b;
        if (PersonalizedFeedUtils.c() == false) goto L28;
        int r152 = PersonalizedFeedUtils.b().e() - 1;
    L29:
        if (r151 < r152) goto L31;
        boolean r153 = true;
    L32:
        if (r153 != true) goto L136;
        jg2.a r154 = r31.J;
        if (r154 == null) goto L132;
        ArrayList<FeedItem> r155 = r31.d;
        ArrayList<Bundle> r156 = r31.c;
        ArrayList<Room> r157 = r31.b;
        HashSet<Long> r158 = r31.h;
        Function1<HashMap<String, HashSet<Long>>, Unit> r159 = new DrawRoomListProvider$checkPersonalizedCacheIndexIfNeed$1(r31);
        Intrinsics.checkNotNullParameter(r158, "readRoomSet");
        if (r155 != null) goto L38;
    L41:
        boolean r160 = true;
    L42:
        if (r160 == true) goto L132;
        if (r156 != null) goto L45;
    L48:
        boolean r161 = true;
    L49:
        if (r161 == true) goto L132;
        if (r157 != null) goto L52;
    L55:
        boolean r162 = true;
    L56:
        if (r162 == true) goto L132;
        ArrayList r163 = new ArrayList();     // Catch: Exception -> L86
        Iterator<FeedItem> r164 = r155.iterator();     // Catch: Exception -> L86
        int r212 = 0;
    L60:
        if (r164.hasNext() == false) goto L88;
        FeedItem r213 = r164.next();     // Catch: Exception -> L86
        int r214 = r212 + 1;     // Catch: Exception -> L86
        if (r212 >= 0) goto L64;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L86
    L64:
        r23 = r8;
        FeedItem r165 = r213;     // Catch: Exception -> L84
        if (r212 == 0) goto L82;
        if (r165 == null) goto L74;
        r20 = r7;
    L72:
        e = e;
    L131:
        PersonalizedFeedUtils.d("DrawRoomPersonalizedContext", "removeUnreadAndUploadPersonalizedFeed error: " + Log.getStackTraceString(e));
    L133:
        jg2.a r166 = r31.J;
        if (r166 == null) goto L137;
        r166.a = false;
        goto L137
    L70:
        if (r165.contentCategory != 6) goto L75;
        boolean r167 = true;
    L76:
        if (r167 == false) goto L83;
        Room r168 = r165.getRoom();     // Catch: Exception -> L72
        if (r168 == null) goto L80;
        long r169 = r168.getRoomId();     // Catch: Exception -> L72
    L81:
        r163.add(Long.valueOf(r169));     // Catch: Exception -> L72
        goto L83
    L80:
        r169 = -1;
    L83:
        r7 = r20;
        r212 = r214;
        r8 = r23;
    L75:
        r167 = false;
        goto L76
    L74:
        r20 = r7;
        goto L75
    L82:
        r20 = r7;
    L84:
        e = e;
        r20 = r7;
        goto L131
    L88:
        r20 = r7;
        r23 = r8;
        r154.a(r154.c);     // Catch: Exception -> L72
        long[] r170 = r154.c;     // Catch: Exception -> L72
        int r171 = r170.length;     // Catch: Exception -> L72
        int r172 = 0;
    L89:
        if (r172 >= r171) goto L97;
        if (r170[r172] != 0) goto L93;
        boolean r173 = true;
    L94:
        if (r173 == true) goto L98;
        r172 = r172 + 1;     // Catch: Exception -> L72
    L98:
        PersonalizedFeedUtils.e("DrawRoomPersonalizedContext", "removeUnreadAndUploadPersonalizedFeed before feed size:" + r155.size() + ", indexSize: " + r163.size() + ", " + r163 + "., firstUnreadIndex:" + r172);     // Catch: Exception -> L72
        if ((!r163.isEmpty()) == true) goto L102;
        r163 = null;
    L102:
        if (r163 == null) goto L129;
        Iterator r174 = r163.iterator();     // Catch: Exception -> L72
    L105:
        if (r174.hasNext() == false) goto L129;
        long r215 = ((Number) r174.next()).longValue();     // Catch: Exception -> L72
        if (r172 >= 0) goto L109;
    L123:
        Iterator r216 = r174;
        int r175 = r172;
        int r176 = -1;
    L124:
        if (r176 < 0) goto L128;
        if (r176 >= r155.size()) goto L128;
        ListProtector.remove(r155, r176);     // Catch: Exception -> L72
        ListProtector.remove(r156, r176);     // Catch: Exception -> L72
        ListProtector.remove(r157, r176);     // Catch: Exception -> L72
    L128:
        r172 = r175;
        r174 = r216;
        goto L105
    L109:
        if (r172 >= r155.size()) goto L123;
        int r177 = r155.size();     // Catch: Exception -> L72
        int r178 = r172;
        r176 = -1;
    L111:
        if (r178 >= r177) goto L122;
        FeedItem r179 = (FeedItem) ListProtector.get(r155, r178);     // Catch: Exception -> L72
        if (r179 == null) goto L119;
        Iterator r217 = r174;
        Room r180 = r179.getRoom();     // Catch: Exception -> L72
        if (r180 == null) goto L120;
        int r218 = r177;
        int r181 = r172;
        if (r180.id != r215) goto L121;
        r176 = r178;
    L121:
        r178 = r178 + 1;     // Catch: Exception -> L72
        r172 = r181;
        r174 = r217;
        r177 = r218;
    L120:
        r218 = r177;
        r181 = r172;
        goto L121
    L119:
        r217 = r174;
        goto L120
    L122:
        r216 = r174;
        r175 = r172;
    L129:
        PersonalizedFeedUtils.e("DrawRoomPersonalizedContext", "removeUnreadAndUploadPersonalizedFeed after feed size:" + r155.size());     // Catch: Exception -> L72
        r154.b(r158, r159);     // Catch: Exception -> L72
        goto L133
    L93:
        r173 = false;
        goto L94
    L97:
        r172 = -1;
    L86:
        e = e;
        r20 = r7;
        r23 = r8;
        goto L131
    L52:
        if (r157.isEmpty() == true) goto L55;
        r162 = false;
        goto L56
    L45:
        if (r156.isEmpty() == true) goto L48;
        r161 = false;
        goto L49
    L38:
        if (r155.isEmpty() == true) goto L41;
        r160 = false;
    L132:
        r20 = r7;
        r23 = r8;
        goto L133
    L28:
        r152 = -1;
    L31:
        r153 = false;
        goto L32
    L519:
        return;
    L13:
        r8 = r37;
        goto L14
    L9:
        r7 = r36;
        goto L11
    L5:
        r5 = r35;
        goto L7
    }
}
