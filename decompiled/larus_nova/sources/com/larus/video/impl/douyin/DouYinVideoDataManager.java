package com.larus.video.impl.douyin;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.gallery.api.PreviewChangeWay;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.FirstFramePreloadVideoData;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.platform.uimodel.VideoParam;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class DouYinVideoDataManager {
    public String A;
    public final Set<String> B;
    public MediaEntityContainer C;
    public String D;
    public String E;
    public final Map<String, String> F;
    public final Map<String, String> G;
    public String H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f375711J;
    public String K;
    public ArrayList<MediaEntity> L;
    public VideoParam.RecommendType M;
    public boolean N;
    public boolean O;
    public PrefetchRecommendVideoParam P;
    public FirstFramePreloadVideoData Q;
    public ArrayList<String> R;
    public boolean S;
    public JSONObject T;
    public String U;
    public JSONObject V;
    public int W;
    public final List<String> X;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<String> f375712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f375713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f375714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f375715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f375716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f375717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f375718g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f375719h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f375720i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f375721j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f375722k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f375723l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f375724m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f375725n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f375726o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f375727p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f375728q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f375729r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Integer f375730s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f375731t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f375732u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f375733v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f375734w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f375735x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f375736y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f375737z;

    public static final class a {
    }

    static {
    }

    public DouYinVideoDataManager() {
        this.f375717f = -1;
        this.f375721j = "";
        this.f375722k = "";
        this.f375723l = 10;
        this.f375724m = 10;
        this.f375733v = new ConcurrentHashMap();
        this.f375734w = LazyKt.lazy(new o());
        this.f375735x = true;
        this.f375736y = "";
        this.B = new LinkedHashSet();
        this.F = new LinkedHashMap();
        this.G = new LinkedHashMap();
        this.M = VideoParam.RecommendType.Non;
        this.O = true;
        this.W = 1;
        this.X = new ArrayList();
    }

    public final Object a(Continuation<? super JSONObject> r110) {
        if ((r110 instanceof DouYinVideoDataManager$generateRecommendRequestParams$1) == false) goto L7;
        DouYinVideoDataManager$generateRecommendRequestParams$1 r100 = (DouYinVideoDataManager$generateRecommendRequestParams$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        Object r104 = null;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L42:
        Message r112 = (Message) r111;
        if (r112 == null) goto L45;
        String r113 = r112.getReplyId();
    L46:
        if (r113 != null) goto L48;
        r113 = "";
    L48:
        ArrayList<MediaEntity> r105 = this.L;
        if (r105 == null) goto L60;
        ArrayList<String> r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L52:
        if (r107.hasNext() == false) goto L61;
        MediaEntity r108 = (MediaEntity) r107.next();
        if (r108 == null) goto L56;
        String r109 = r108.getItem_id();
    L57:
        if (r109 != null) goto L59;
        r109 = "";
    L59:
        r106.add(r109);
        goto L52
    L56:
        r109 = null;
    L61:
        JSONObject r114 = new JSONObject();
        int r115 = this.f375715d;
        if (r115 != 1) goto L65;
        r114.put("scene", r115);
        r114.put("query", new JSONArray(this.f375716e));
        r114.put("reply_item_ids", new JSONArray(r106));
    L86:
        r114.put("page_index", this.W);
        r114.put(PreviewChangeWay.CLICK_INDEX, this.f375717f);
        r114.put("playlist_item_ids", new JSONArray(this.X));
        String r116 = this.f375727p;
        if (r116 == null) goto L89;
        r114.put("click_item_id", r116);
    L89:
        Integer r117 = this.f375729r;
        if (r117 == null) goto L92;
        r114.put("stream_index", r117.intValue());
    L92:
        r114.put("playlist_playtime", new JSONObject(GsonProtectorUtils.toJson((Gson) this.f375734w.getValue(), this.f375733v)));
        return r114;
    L65:
        if (r115 != 2) goto L74;
        r114.put("scene", r115);
        r114.put(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID, StringsKt.toLongOrNull(r113));
        String r118 = this.E;
        if (r118 == null) goto L69;
        Long r119 = StringsKt.toLongOrNull(r118);
    L70:
        r114.put("answer_id", r119);
        if (r106 == null) goto L73;
        r104 = (String) CollectionsKt.getOrNull(r106, this.f375717f);
    L73:
        r114.put("reply_item_ids", new JSONArray(CollectionsKt.listOf(r104)));
        goto L86
    L69:
        r119 = null;
        goto L70
    L74:
        List<String> r120 = this.f375716e;
        if (r120 != null) goto L77;
    L79:
        r114.put(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID, StringsKt.toLongOrNull(r113));
        String r121 = this.E;
        if (r121 == null) goto L82;
        r104 = StringsKt.toLongOrNull(r121);
    L82:
        r114.put("answer_id", r104);
        ArrayList<String> r122 = this.R;
        if (r122 == null) goto L85;
        r106 = r122;
    L85:
        r114.put("reply_item_ids", new JSONArray(r106));
        goto L86
    L77:
        if ((true ^ r120.isEmpty()) == false) goto L79;
        r114.put("query", new JSONArray(r120));
        goto L79
    L60:
        r106 = null;
        goto L61
    L45:
        r113 = null;
        goto L46
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        if (o0.d(this.f375731t) == false) goto L20;
        String r123 = this.f375731t;
        if (r123 != null) goto L19;
        r123 = "";
    L19:
        List r124 = CollectionsKt.listOf(r123);
    L22:
        if (((ArrayList) this.X).isEmpty() == false) goto L34;
        ((ArrayList) this.X).addAll(r124);
        if (this.f375732u == false) goto L34;
        List<String> r125 = this.X;
        FirstFramePreloadVideoData r126 = this.Q;
        if (r126 == null) goto L32;
        ArrayList<String> r127 = r126.getPreLoadFirstRequestItemIdList();
        if (r127 == null) goto L32;
        List r128 = CollectionsKt.filterNotNull(r127);
        if (r128 == null) goto L32;
    L33:
        ((ArrayList) r125).addAll(r128);
    L32:
        r128 = CollectionsKt.emptyList();
    L34:
        r113 = this.f375737z;
        if (r113 != null) goto L48;
        IChatRepoService r129 = RepoDispatcherDelegate.f307737b.e();
        String r130 = this.E;
        if (r130 != null) goto L39;
        r130 = "";
    L39:
        r100.label = 1;
        r111 = r129.E1(r130, r100);
        if (r111 != r102) goto L42;
        return r102;
    L20:
        r124 = CollectionsKt.emptyList();
    L7:
        r100 = new DouYinVideoDataManager$generateRecommendRequestParams$1(this, r110);
        goto L8
    }
}
