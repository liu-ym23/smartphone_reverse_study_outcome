package com.larus.bmhome.video;

import com.bytedance.awemeopen.apps.photo.pinch.PinchStableView;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.auth.FeedItemConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.CachedVideosPreloadFrom;
import com.larus.platform.api.k;
import com.larus.platform.api.r2;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class RecommendVideoApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RecommendVideoApi f315177a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f315178b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f315179c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Content> f315180d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f315181e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f315182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f315183g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f315184h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f315185i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f315186j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final List<Content> f315187k = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f315188a = null;

        static {
            int[] r100 = new int[SortRequestType.values().length];
            r100[SortRequestType.Unknown.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r100[SortRequestType.PreLoad.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r100[SortRequestType.UserClickEnterPage.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r100[SortRequestType.UserSlideEnterPage.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[SortRequestType.LandingEnterPage.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r100[SortRequestType.UserLoadMore.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r100[SortRequestType.UserPullRefresh.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r100[SortRequestType.UserClickTabRefresh.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r100[SortRequestType.AutoRefresh.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            f315188a = r100;
        }
    }

    public RecommendVideoApi() {
    }

    static {
        f315177a = new RecommendVideoApi();
        f315178b = new ArrayList();
        f315179c = new ArrayList();
        f315180d = new ArrayList();
        Lazy r100 = b.f315193a;
        f315181e = ((long) z2.f365865a.getAwemeVideoFeedConfig().j()) * 1000;
        AuthModelDelegate r101 = AuthModelDelegate.f297134b;
        LaunchInfo r102 = r101.x().getValue();
        if (r102 == null) goto L7;
        FeedItemConfig r103 = r102.F0();
        if (r103 == null) goto L7;
        int r104 = r103.c();
    L8:
        f315183g = r104;
        LaunchInfo r105 = r101.x().getValue();
        if (r105 == null) goto L13;
        FeedItemConfig r106 = r105.F0();
        if (r106 == null) goto L13;
        int r107 = r106.a();
    L14:
        f315184h = r107;
        f315185i = LazyKt.lazy(new f());
        f315186j = new ConcurrentHashMap();
        f315187k = new ArrayList();
        return;
    L13:
        r107 = 8;
    L7:
        r104 = 6;
        goto L8
    }

    public static void a() {
        FLogger.f375446a.i("RecommendVideoApi", "exposePrefetchData");
        ((ArrayList) f315180d).clear();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0080 -> B:27:0x0083). Please report as a decompilation issue!!! */
    public final Object c(SortScene r110, Continuation<? super List<Content>> r111) {
        if ((r111 instanceof RecommendVideoApi$prefetchData$1) == false) goto L7;
        RecommendVideoApi$prefetchData$1 r100 = (RecommendVideoApi$prefetchData$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        RecommendVideoApi r102 = this;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        int r106 = r100.I$0;
        SortScene r107 = (SortScene) r100.L$0;
        ResultKt.throwOnFailure(r103);
        RecommendVideoApi r112 = r102;
    L27:
        RecommendVideoData r108 = (RecommendVideoData) r103;
        if (r108 == null) goto L30;
        List<Content> r109 = r108.getItemLists();
    L31:
        if (r109 != null) goto L33;
    L35:
        boolean r113 = false;
    L36:
        if (r113 == true) goto L44;
        if (r108 != null) goto L40;
    L42:
        boolean r114 = false;
    L43:
        if (r114 == true) goto L44;
        r106 = r106 + 1;
        SortScene r115 = r107;
        List<Content> r116 = r109;
    L22:
        if (r106 >= 4) goto L46;
        SortRequestType r117 = SortRequestType.PreLoad;
        int r118 = f315183g;
        r100.L$0 = r115;
        r100.I$0 = r106;
        r100.label = 1;
        Object r119 = f(r112, r115, r117, r118, false, r100);
        if (r119 != r104) goto L26;
        return r104;
    L26:
        r107 = r115;
        r103 = r119;
    L46:
        if (r116 == null) goto L49;
        f315182f = AppHost.f326268a.getAppClock().currentTimeMillis();
        Boxing.boxBoolean(((ArrayList) f315180d).addAll(r116));
    L49:
        if (r115 != SortScene.InnerStream) goto L51;
    L54:
        return r116;
    L51:
        if (((ArrayList) f315187k).size() >= 2) goto L54;
        FLogger.f375446a.i("RecommendVideoApi", "prefetchForInnerStream");
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new RecommendVideoApi$tryPrefetchInnerStreamData$1(null), 3, null);
        goto L54
    L40:
        if (r108.getHasMore() == true) goto L42;
        r114 = true;
    L44:
        r115 = r107;
        r116 = r109;
        goto L46
    L33:
        if ((!r109.isEmpty()) != true) goto L35;
        r113 = true;
        goto L36
    L30:
        r109 = null;
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        List<Content> r120 = f315180d;
        if (((ArrayList) r120).isEmpty() == false) goto L17;
    L20:
        r115 = r110;
        r112 = r102;
        r116 = null;
        r106 = 0;
        goto L22
    L17:
        if ((AppHost.f326268a.getAppClock().currentTimeMillis() - f315182f) > f315181e) goto L20;
        return r120;
    L7:
        r102 = this;
        r100 = new RecommendVideoApi$prefetchData$1(r102, r111);
        goto L8
    }

    public static void d(boolean r100, SortScene r101, SortRequestType r102, long r103, String r104) {
        if (r101 != SortScene.InnerStream) goto L6;
        return;
    L6:
        switch(a.f315188a[r102.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            default: goto L8;
        };
    L9:
        String r105 = "auto_request";
    L17:
        Integer r106 = Integer.valueOf(r100 ? 1 : 0);
        Long r107 = Long.valueOf(r103);
        JSONObject r108 = new JSONObject();
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r106 != null) goto L32;
    L20:
        r108.put("host_enter_from", "chat_feed_tab");     // Catch: JSONException -> L28
        if (r105 == null) goto L23;
        r108.put("click_from", r105);     // Catch: JSONException -> L28
    L23:
        if (r107 == null) goto L25;
        r108.put("duration", r107.longValue());     // Catch: JSONException -> L28
    L25:
        if (r104 == null) goto L30;
        r108.put("req_id", r104);     // Catch: JSONException -> L28
    L28:
        e = move-exception;
        FLogger.f375446a.e("AwemeFeedEventHelper", "error in AwemeFeedEventHelper mobRefreshFeedResult " + e.getLocalizedMessage());
    L30:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r110 = new by7.a("refresh_feed_result");
        r110.f21463a.merge(r109);
        r110.b();
        return;
    L32:
        r108.put("success", r106.intValue());     // Catch: JSONException -> L28
        goto L20
    L10:
        r105 = "click_tab";
        goto L17
    L11:
        r105 = PinchStableView.Gesture.PULL_UP;
        goto L17
    L12:
        r105 = "slide_down";
        goto L17
    L13:
        r105 = "landing";
        goto L17
    L14:
        r105 = "auto_request_more";
        goto L17
    L15:
        r105 = "preload";
        goto L17
    L16:
        r105 = null;
        goto L17
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Object f(RecommendVideoApi r110, SortScene r111, SortRequestType r112, int r113, boolean r114, Continuation r115) {
        return r110.e(r111, r112, 1, r113, true, r114, null, null, null, null, null, r115);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static Object b(SortScene r110, SortRequestType r111, int r112, List r113, List r114, String r115, String r116, String r210, Continuation r211, int r212) {
        RecommendVideoApi r100 = f315177a;
        if ((r212 & 8) == 0) goto L5;
        List r101 = null;
    L7:
        if ((r212 & 16) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r212 & 32) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 64) == 0) goto L17;
        String r117 = null;
    L19:
        if ((r212 & 128) == 0) goto L21;
        String r118 = null;
    L23:
        if (r110 != SortScene.InnerStream) goto L25;
        int r104 = f315184h;
    L27:
        return r100.e(r110, r111, r112, r104, true, false, r101, r102, r103, r117, r118, r211);
    L25:
        r104 = f315184h + 2;
        goto L27
    L21:
        r118 = r210;
        goto L23
    L17:
        r117 = r116;
        goto L19
    L13:
        r103 = r115;
        goto L15
    L9:
        r102 = r114;
        goto L11
    L5:
        r101 = r113;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object e(SortScene r210, SortRequestType r211, int r212, int r213, boolean r214, boolean r215, List<String> r216, List<String> r217, String r310, String r311, String r312, Continuation<? super RecommendVideoData> r313) {
        if ((r313 instanceof RecommendVideoApi$requestRecommendVideo$1) == false) goto L7;
        RecommendVideoApi$requestRecommendVideo$1 r100 = (RecommendVideoApi$requestRecommendVideo$1) r313;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        RecommendVideoApi$requestRecommendVideo$1 r110 = r100;
        Object r102 = r110.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        long r105 = r110.J$0;
        boolean r106 = r110.Z$0;
        int r107 = r110.I$0;
        String r108 = (String) r110.L$3;
        String r109 = (String) r110.L$2;
        SortRequestType r111 = (SortRequestType) r110.L$1;
        SortScene r112 = (SortScene) r110.L$0;
        ResultKt.throwOnFailure(r102);
        long r113 = r105;
        Object r114 = r102;
        boolean r115 = r106;
    L28:
        com.larus.network.http.a r116 = (com.larus.network.http.a) r114;
        long r117 = System.currentTimeMillis() - r113;
        if ((r116 instanceof y) == false) goto L52;
        RecommendVideoData r118 = (RecommendVideoData) ((y) r116).f360135b;
        FLogger r119 = FLogger.f375446a;
        StringBuilder r120 = new StringBuilder("[");
        r120.append(r112);
        r120.append("] Request page.");
        r120.append(r107);
        r120.append(" recommend video success, return ");
        if (r118 == null) goto L42;
        List<Content> r121 = r118.getItemLists();
        if (r121 == null) goto L42;
        ArrayList r122 = new ArrayList();
        Iterator<T> r123 = r121.iterator();
    L36:
        if (r123.hasNext() == false) goto L41;
        String r124 = ((Content) r123.next()).getItemId();
        if (r124 == null) goto L36;
        r122.add(r124);
        goto L36
    L41:
        Integer r125 = Boxing.boxInt(r122.size());
    L43:
        r120.append(r125);
        r120.append(" data, hasMore: ");
        if (r118 == null) goto L46;
        Boolean r126 = Boxing.boxBoolean(r118.getHasMore());
    L47:
        r120.append(r126);
        r119.d("RecommendVideoApi", r120.toString());
        if (r118 == null) goto L50;
        String r127 = r118.getRequestId();
    L51:
        d(true, r112, r111, r117, r127);
    L60:
        if (r118 == null) goto L74;
        List<Content> r128 = r118.getItemLists();
        if (r128 == null) goto L74;
        Iterator<T> r129 = r128.iterator();
    L65:
        if (r129.hasNext() == false) goto L74;
        Content r130 = (Content) r129.next();
        r130.setImprIndex(Boxing.boxInt(r107));
        if (r112 != SortScene.WelcomeBack) goto L70;
        String r131 = "wcb_feed";
    L73:
        r130.setBizTag(r131);
        goto L65
    L70:
        if (r112 != SortScene.Recommend) goto L72;
        r131 = "chat_feed";
        goto L73
    L72:
        r131 = null;
    L74:
        if (r118 == null) goto L83;
        List<Content> r132 = r118.getItemLists();
        if (r132 == null) goto L83;
        ArrayList r133 = new ArrayList();
        Iterator<T> r134 = r132.iterator();
    L79:
        if (r134.hasNext() == false) goto L85;
        String r135 = ((Content) r134.next()).getItemId();
        if (r135 == null) goto L79;
        r133.add(r135);
    L85:
        if (r133 == null) goto L90;
        List<String> r136 = f315178b;
        ArrayList r137 = (ArrayList) r136;
        r137.addAll(0, r133);
        if (r137.size() <= 32) goto L90;
        List r138 = CollectionsKt.take(r136, 32);
        r137.clear();
        r137.addAll(r138);
    L90:
        if (r112 != SortScene.InnerStream) goto L127;
        if (r115 == true) goto L127;
        if (r118 == null) goto L127;
        List<Content> r139 = r118.getItemLists();
        if (r139 == null) goto L127;
        Map<String, CopyOnWriteArrayList<g>> r140 = e.f315241a;
        if (r108 != null) goto L99;
        r108 = "AwemeFeed";
    L99:
        ArrayList r141 = new ArrayList();
        Iterator<T> r142 = r139.iterator();
    L101:
        if (r142.hasNext() == false) goto L125;
        Content r143 = (Content) r142.next();
        String r144 = r143.getItemId();
        if (r144 != null) goto L105;
    L108:
        boolean r145 = true;
    L109:
        if (r145 == false) goto L111;
        g r146 = null;
    L123:
        if (r146 == null) goto L101;
        r141.add(r146);
        goto L101
    L111:
        String r147 = r143.getItemId();
        Integer r148 = r143.getItemType();
        int r149 = ItemType.VIDEO.getValue();
        if (r148 != null) goto L115;
    L117:
        GroupType r150 = GroupType.Graphic;
    L118:
        String r151 = r143.getRequestId();
        Integer r152 = Integer.valueOf(r107);
        Integer r153 = r143.getRecChannelId();
        if (r153 == null) goto L121;
        String r154 = r153.toString();
    L122:
        r146 = new g(r147, r150, r151, r152, r154);
        goto L123
    L121:
        r154 = null;
        goto L122
    L115:
        if (r148.intValue() != r149) goto L117;
        r150 = GroupType.Video;
        goto L118
    L105:
        if (r144.length() == 0) goto L108;
        r145 = false;
        goto L109
    L125:
        e.b(r108, r141);
    L127:
        if (r112 != SortScene.InnerStream) goto L129;
        if (r115 == true) goto L129;
    L167:
        if (o0.d(r109) == false) goto L231;
        if (r118 == null) goto L173;
        List<Content> r155 = r118.getItemLists();
        if (r155 == null) goto L173;
        List r156 = CollectionsKt.takeLast(r155, 2);
        if (r156 == null) goto L173;
    L174:
        if (r109 == null) goto L231;
        HashMap r157 = new HashMap();
        HashMap r158 = new HashMap();
        List r159 = r156;
        Iterator r160 = r159.iterator();
    L178:
        if (r160.hasNext() == false) goto L216;
        Content r161 = (Content) r160.next();
        String r162 = r161.getItemId();
        String r163 = r161.getRequestId();
        if (r162 != null) goto L182;
    L185:
        boolean r164 = true;
    L186:
        if (r164 == true) goto L195;
        if (r163 != null) goto L189;
    L192:
        boolean r165 = true;
    L193:
        if (r165 == true) goto L195;
        r157.put(r162, r163);
        goto L195
    L189:
        if (r163.length() == 0) goto L192;
        r165 = false;
    L195:
        if (r162 != null) goto L197;
    L200:
        boolean r166 = true;
    L201:
        if (r166 == true) goto L178;
        Integer r167 = r161.getRecChannelId();
        if (r167 != null) goto L205;
    L214:
        String r168 = "414";
    L215:
        r158.put(r162, r168);
        goto L178
    L205:
        if (r167.intValue() == 0) goto L207;
        boolean r169 = true;
    L208:
        if (r169 == true) goto L211;
        r167 = null;
    L211:
        if (r167 == null) goto L214;
        r168 = r167.toString();
        if (r168 != null) goto L215;
    L207:
        r169 = false;
        goto L208
    L197:
        if (r162.length() == 0) goto L200;
        r166 = false;
        goto L201
    L182:
        if (r162.length() == 0) goto L185;
        r164 = false;
        goto L186
    L216:
        long r170 = AppHost.f326268a.getAppClock().currentTimeMillis();
        ArrayList r171 = new ArrayList();
        Iterator r172 = r159.iterator();
    L218:
        if (r172.hasNext() == false) goto L222;
        String r173 = ((Content) r172.next()).getItemId();
        if (r173 == null) goto L218;
        r171.add(r173);
        goto L218
    L222:
        ArrayList r174 = new ArrayList(r171);
        CachedVideosPreloadFrom r175 = CachedVideosPreloadFrom.UNLIMITED_FLOW;
        Content r176 = (Content) CollectionsKt.firstOrNull(r156);
        if (r176 == null) goto L225;
        Integer r177 = r176.getImprIndex();
    L226:
        k r178 = new k(r157, r109, r170, r174, r175, r177, r158);
        IFlowSdkDepend r179 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r179 == null) goto L231;
        r2 r180 = r179.A0();
        if (r180 == null) goto L231;
        r180.o(r178, true);
        goto L231
    L225:
        r177 = null;
    L173:
        r156 = CollectionsKt.emptyList();
    L231:
        if (r118 == null) goto L237;
        List<Content> r181 = r118.getItemLists();
        if (r181 == null) goto L235;
        List r182 = CollectionsKt.take(r181, f315184h);
    L271:
        return RecommendVideoData.copy$default(r118, r182, null, false, 6, null);
    L235:
        r182 = null;
        goto L271
    L237:
        return null;
    L129:
        if (r118 == null) goto L131;
        List<Content> r183 = r118.getItemLists();
    L132:
        List<Content> r184 = r183;
        if (r184 != null) goto L135;
    L138:
        boolean r185 = true;
    L139:
        if (r185 == true) goto L167;
        ArrayList r186 = new ArrayList();
        Iterator<T> r187 = r183.iterator();
    L143:
        if (r187.hasNext() == false) goto L163;
        Content r188 = (Content) r187.next();
        String r189 = r188.getItemId();
        if (r189 != null) goto L147;
    L150:
        boolean r190 = true;
    L151:
        if (r190 == false) goto L153;
        pr9.a r191 = null;
    L161:
        if (r191 == null) goto L143;
        r186.add(r191);
        goto L143
    L153:
        String r192 = r188.getItemId();
        Integer r193 = r188.getItemType();
        int r194 = ItemType.ARTICLE.getValue();
        if (r193 != null) goto L157;
    L159:
        boolean r195 = false;
    L160:
        r191 = new pr9.a(r192, r195, 12);
        goto L161
    L157:
        if (r193.intValue() != r194) goto L159;
        r195 = true;
        goto L160
    L147:
        if (r189.length() == 0) goto L150;
        r190 = false;
        goto L151
    L163:
        qr9.c r196 = VideoFeedProviderDelegate.f365695b.b();
        if (r196 == null) goto L167;
        r196.b(r186);
        goto L167
    L135:
        if (r184.isEmpty() == true) goto L138;
        r185 = false;
        goto L139
    L131:
        r183 = null;
    L83:
        r133 = null;
        goto L85
    L50:
        r127 = null;
        goto L51
    L46:
        r126 = null;
    L42:
        r125 = null;
        goto L43
    L52:
        FLogger r197 = FLogger.f375446a;
        StringBuilder r198 = new StringBuilder("[");
        r198.append(r112);
        r198.append("] Request page.");
        r198.append(r107);
        r198.append(" recommend video failed: ");
        if ((r116 instanceof com.larus.network.http.f) == false) goto L55;
        com.larus.network.http.f r199 = (com.larus.network.http.f) r116;
    L56:
        if (r199 == null) goto L58;
        AsyncThrowable r200 = r199.f360157d;
    L59:
        r198.append(r200);
        r197.d("RecommendVideoApi", r198.toString());
        d(false, r112, r111, r117, null);
        r118 = null;
        goto L60
    L58:
        r200 = null;
        goto L59
    L55:
        r199 = null;
        goto L56
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        long r1100 = System.currentTimeMillis();
        JSONObject r201 = new JSONObject();
        r201.put("user_id", AccountService.f365697a.getUserId());
        if (r216 == null) goto L18;
        r201.put("reply_item_ids", new JSONArray(r216));
    L18:
        if (r217 != null) goto L20;
        List<String> r202 = CollectionsKt.plus(f315178b, f315179c);
    L21:
        r201.put("last_item_ids", new JSONArray(r202));
        r201.put("count", r213);
        r201.put("sort_scene", r210.getValue());
        r201.put("sort_request_type", r211.getValue());
        r201.put("session_index", r212);
        r201.put("need_pack", r214);
        r201.put("entrance_item_id", r310);
        ConcurrentHashMap<String, Integer> r203 = f315186j;
        if ((!r203.isEmpty()) == false) goto L24;
        r201.put("playlist_playtime", new JSONObject(GsonProtectorUtils.toJson((Gson) f315185i.getValue(), r203)));
    L24:
        Unit r204 = Unit.INSTANCE;
        r110.L$0 = r210;
        r110.L$1 = r211;
        r110.L$2 = r311;
        r110.L$3 = r312;
        r110.I$0 = r212;
        r110.Z$0 = r215;
        r110.J$0 = r1100;
        r110.label = 1;
        r113 = r1100;
        r114 = HttpExtKt.k(ServiceType.BASIC_SERVICE, RecommendVideoData.class, "/biz/feed/get_rec_video_ids", r201, null, null, false, null, null, null, r110, 1008);
        if (r114 != r103) goto L27;
        return r103;
    L27:
        r112 = r210;
        r107 = r212;
        r109 = r311;
        r108 = r312;
        r111 = r211;
        r115 = r215;
        goto L28
    L20:
        r202 = r217;
    L7:
        r100 = new RecommendVideoApi$requestRecommendVideo$1(this, r313);
        goto L8
    }
}
