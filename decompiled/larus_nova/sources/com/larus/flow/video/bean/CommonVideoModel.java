package com.larus.flow.video.bean;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.HttpLiveData;
import com.larus.network.http.ServiceType;
import com.larus.network.http.f;
import com.larus.network.http.y;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.platform.uimodel.SearchLoadMoreResult;
import com.larus.utils.logger.FLogger;
import com.larus.utils.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 22\u00020\u0001:\u000223B'\u0012\u001e\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010&J\u0006\u0010'\u001a\u00020\u001dJ\"\u0010(\u001a\u00020#2\b\b\u0002\u0010)\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010&J\u001a\u0010*\u001a\u00020+2\u0006\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J$\u0010,\u001a\u00020+2\b\b\u0002\u0010)\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010-\u001a\u00020#H\u0002J\u001f\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/2\u0006\u0010$\u001a\u00020\u000bH\u0002¢\u0006\u0002\u00101R)\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00064"}, d2 = {"Lcom/larus/flow/video/bean/CommonVideoModel;", "Landroidx/lifecycle/ViewModel;", "items", "Ljava/util/ArrayList;", "Lcom/larus/platform/uimodel/MediaEntity;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getItems", "()Ljava/util/ArrayList;", "loadMoreContainer", "Lcom/larus/platform/uimodel/MediaEntityContainer;", "getLoadMoreContainer", "()Lcom/larus/platform/uimodel/MediaEntityContainer;", "setLoadMoreContainer", "(Lcom/larus/platform/uimodel/MediaEntityContainer;)V", "offset", "", "getOffset", "()I", "setOffset", "(I)V", "source", "getSource", "()Ljava/lang/Integer;", "setSource", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "useNewApiGetVideoModel", "", "getUseNewApiGetVideoModel", "()Z", "setUseNewApiGetVideoModel", "(Z)V", "requestPreloadVideoByItemIds", "", PlayerResolution.SDKKEY.ORIGIN, "callback", "Lcom/larus/flow/video/bean/CommonVideoModel$MediaDataCallback;", "isInSearchList", "requestLoadMore", "isFirst", "requestLoadMoreForSearchList", "Lkotlinx/coroutines/Job;", "requestLoadMoreForVideo", "requestVideoNew", "getMediaIds", "", "", "(Lcom/larus/platform/uimodel/MediaEntityContainer;)[Ljava/lang/String;", "Companion", "MediaDataCallback", "media_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonVideoModel extends ViewModel {
    public static final a Companion = null;
    private static final String LOAD_MORE_PATH_FOR_SEARCH = "/alice/media/card_search/";
    private static final String LOAD_MORE_PATH_FOR_VIDEO = "/alice/media/source/";
    private static final String LOAD_VIDEO_PATH_FROM_FLOW = "/alice/media/video_model";
    private static final int QUERY_TYPE_DOUYIN = 1;
    private static final String TAG = "CommonVideoModel";
    private static int bottomBarHeight;
    private static final Lazy<HttpLiveData<MediaEntityContainer>> create$delegate = null;
    private static final Gson mGson = null;
    private static int topBarHeight;
    private final ArrayList<MediaEntity> items;
    private MediaEntityContainer loadMoreContainer;
    private int offset;
    private Integer source;
    private boolean useNewApiGetVideoModel;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.flow.video.bean.CommonVideoModel$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/flow/video/bean/CommonVideoModel$Companion$getMediaDataFromJson$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/platform/uimodel/MediaEntityContainer;", "media_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C4313a extends TypeToken<MediaEntityContainer> {
            public C4313a() {
            }
        }

        public a() {
        }

        public static MediaEntityContainer a(String r100) {
            return (MediaEntityContainer) CommonVideoModel.access$getMGson$cp().fromJson(r100, new C4313a().getType());
        L4:
            return null;
        }
    }

    public interface b {
        void a(MediaEntityContainer r100);

        void b(AsyncThrowable r100);
    }

    /* JADX INFO: renamed from: com.larus.flow.video.bean.CommonVideoModel$requestLoadMoreForSearchList$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.flow.video.bean.CommonVideoModel$requestLoadMoreForSearchList$1", f = "CommonVideoModel.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ b $callback;
        final /* synthetic */ MediaEntityContainer $origin;
        int label;
        final /* synthetic */ CommonVideoModel this$0;

        public AnonymousClass1(CommonVideoModel r100, b r101, MediaEntityContainer r102, Continuation<? super AnonymousClass1> r103) {
            this.this$0 = r100;
            this.$callback = r101;
            this.$origin = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$callback, this.$origin, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r100 = this.label;
            if (r100 == 0) goto L8;
            if (r100 != 1) goto L7;
            ResultKt.throwOnFailure(r210);
            Object r101 = r210;
        L11:
            com.larus.network.http.a r102 = (com.larus.network.http.a) r101;
            if ((r102 instanceof y) == false) goto L86;
            SearchLoadMoreResult r103 = (SearchLoadMoreResult) ((y) r102).f360135b;
            MediaEntityContainer r104 = this.this$0.getLoadMoreContainer();
            List<MediaEntity> r105 = null;
            if (r104 == null) goto L73;
            CommonVideoModel r106 = this.this$0;
            if (r103 == null) goto L73;
            r104.setQueryParams(String.valueOf(r103.getQueryParams()));
            ur9.a r107 = r103.getSearchResult();
            boolean r108 = false;
            if (r107 == null) goto L69;
            ur9.a.b r109 = r107.a();
            if (r109 == null) goto L69;
            List<MediaEntity> r111 = r109.a();
            if (r111 == null) goto L69;
            ArrayList<MediaEntity> r112 = r104.mediaList();
            if (r112 == null) goto L46;
            a r113 = CommonVideoModel.Companion;
            Iterator<T> r114 = r111.iterator();
        L27:
            if (r114.hasNext() == false) goto L46;
            MediaEntity r115 = (MediaEntity) r114.next();
            if (r115 == null) goto L27;
            if (r112.isEmpty() == true) goto L43;
            Iterator<T> r116 = r112.iterator();
        L35:
            if (r116.hasNext() == false) goto L43;
            MediaEntity r117 = (MediaEntity) r116.next();
            if (r117 == null) goto L39;
            String r118 = r117.getItem_id();
        L41:
            if (Intrinsics.areEqual(r118, r115.getItem_id()) == false) goto L35;
            boolean r119 = false;
        L44:
            if (r119 == false) goto L27;
            r112.add(r115);
            goto L27
        L39:
            r118 = null;
        L43:
            r119 = true;
        L46:
            ArrayList<MediaEntity> r120 = r106.getItems();
            if (r120 == null) goto L69;
            a r121 = CommonVideoModel.Companion;
            Iterator<T> r122 = r111.iterator();
        L50:
            if (r122.hasNext() == false) goto L69;
            MediaEntity r123 = (MediaEntity) r122.next();
            if (r123 == null) goto L50;
            if (r120.isEmpty() == true) goto L66;
            Iterator<T> r124 = r120.iterator();
        L58:
            if (r124.hasNext() == false) goto L66;
            MediaEntity r125 = (MediaEntity) r124.next();
            if (r125 == null) goto L62;
            String r126 = r125.getItem_id();
        L64:
            if (Intrinsics.areEqual(r126, r123.getItem_id()) == false) goto L58;
            boolean r127 = false;
        L67:
            if (r127 == false) goto L50;
            r120.add(r123);
            goto L50
        L62:
            r126 = null;
        L66:
            r127 = true;
        L69:
            Boolean r128 = r103.getHasMore();
            if (r128 == null) goto L72;
            r108 = r128.booleanValue();
        L72:
            r104.setHas_more(r108);
        L73:
            b r129 = this.$callback;
            if (r129 == null) goto L92;
            if (r103 == null) goto L82;
            ur9.a r130 = r103.getSearchResult();
            if (r130 == null) goto L82;
            ur9.a.b r131 = r130.a();
            if (r131 == null) goto L82;
            r105 = r131.a();
        L82:
            if (r105 != null) goto L84;
            r105 = CollectionsKt.emptyList();
        L84:
            r129.a(new MediaEntityContainer(null, new ArrayList(r105), null, null, false, 0, 0, null, 253, null));
        L92:
            return Unit.INSTANCE;
        L86:
            if ((r102 instanceof f) == false) goto L92;
            b r132 = this.$callback;
            if (r132 == null) goto L90;
            r132.b(((f) r102).f360157d);
        L90:
            FLogger.f375446a.e(CommonVideoModel.TAG, "[requestLoadMoreForSearchList] error!!! error code : " + ((f) r102).f360157d.getCode());
            goto L92
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r210);
            JSONObject r133 = new JSONObject();
            MediaEntityContainer r134 = this.$origin;
            r133.put("query_type", 1);
            Gson r135 = z.f375499a;
            r133.put("query_params", z.b(r134.getQueryParams()));
            Unit r136 = Unit.INSTANCE;
            this.label = 1;
            r101 = HttpExtKt.k(ServiceType.BASIC_SERVICE, SearchLoadMoreResult.class, "/alice/media/card_search/", r133, null, null, false, null, null, null, this, 1008);
            if (r101 != r110) goto L11;
            return r110;
        }
    }

    /* JADX INFO: renamed from: com.larus.flow.video.bean.CommonVideoModel$requestLoadMoreForVideo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.flow.video.bean.CommonVideoModel$requestLoadMoreForVideo$1", f = "CommonVideoModel.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
    public static final class C114441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ b $callback;
        final /* synthetic */ boolean $isFirst;
        final /* synthetic */ MediaEntityContainer $origin;
        int label;
        final /* synthetic */ CommonVideoModel this$0;

        public C114441(CommonVideoModel r100, b r101, boolean r102, MediaEntityContainer r103, Continuation<? super C114441> r104) {
            this.this$0 = r100;
            this.$callback = r101;
            this.$isFirst = r102;
            this.$origin = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C114441(this.this$0, this.$callback, this.$isFirst, this.$origin, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C114441) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r100 = this.label;
            if (r100 == 0) goto L8;
            if (r100 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
            Object r101 = r110;
        L25:
            com.larus.network.http.a r102 = (com.larus.network.http.a) r101;
            if ((r102 instanceof y) == false) goto L100;
            MediaEntityContainer r103 = (MediaEntityContainer) ((y) r102).f360135b;
            MediaEntityContainer r104 = this.this$0.getLoadMoreContainer();
            if (r104 == null) goto L96;
            boolean r105 = this.$isFirst;
            CommonVideoModel r106 = this.this$0;
            if (r103 == null) goto L96;
            if (r105 == true) goto L33;
            r104.setHas_more(r103.getHas_more());
            r104.setLimit(r103.getLimit());
            r104.setOffset(r103.getOffset());
            r104.setQuery(r103.getQuery());
        L33:
            r104.setSearch_id(r103.getSearch_id());
            ArrayList<MediaEntity> r107 = r103.mediaList();
            if (r107 != null) goto L36;
        L39:
            boolean r108 = true;
        L40:
            if (r108 == true) goto L96;
            List r109 = r103.mediaList();
            if (r109 != null) goto L44;
            r109 = CollectionsKt.emptyList();
        L44:
            r106.setOffset(r109.size());
            ArrayList<MediaEntity> r112 = r104.mediaList();
            if (r112 == null) goto L70;
            a r113 = CommonVideoModel.Companion;
            Iterable r114 = r103.mediaList();
            if (r114 != null) goto L49;
            r114 = CollectionsKt.emptyList();
        L49:
            Iterator r115 = r114.iterator();
        L51:
            if (r115.hasNext() == false) goto L70;
            MediaEntity r116 = (MediaEntity) r115.next();
            if (r116 == null) goto L51;
            if (r112.isEmpty() == true) goto L67;
            Iterator<T> r117 = r112.iterator();
        L59:
            if (r117.hasNext() == false) goto L67;
            MediaEntity r118 = (MediaEntity) r117.next();
            if (r118 == null) goto L63;
            String r119 = r118.getItem_id();
        L65:
            if (Intrinsics.areEqual(r119, r116.getItem_id()) == false) goto L59;
            boolean r120 = false;
        L68:
            if (r120 == false) goto L51;
            r112.add(r116);
            goto L51
        L63:
            r119 = null;
        L67:
            r120 = true;
        L70:
            ArrayList<MediaEntity> r121 = r106.getItems();
            if (r121 == null) goto L96;
            a r122 = CommonVideoModel.Companion;
            Iterable r123 = r103.mediaList();
            if (r123 != null) goto L75;
            r123 = CollectionsKt.emptyList();
        L75:
            Iterator r124 = r123.iterator();
        L77:
            if (r124.hasNext() == false) goto L96;
            MediaEntity r125 = (MediaEntity) r124.next();
            if (r125 == null) goto L77;
            if (r121.isEmpty() == true) goto L93;
            Iterator<T> r126 = r121.iterator();
        L85:
            if (r126.hasNext() == false) goto L93;
            MediaEntity r127 = (MediaEntity) r126.next();
            if (r127 == null) goto L89;
            String r128 = r127.getItem_id();
        L91:
            if (Intrinsics.areEqual(r128, r125.getItem_id()) == false) goto L85;
            boolean r129 = false;
        L94:
            if (r129 == false) goto L77;
            r121.add(r125);
            goto L77
        L89:
            r128 = null;
        L93:
            r129 = true;
            goto L94
        L36:
            if (r107.isEmpty() == true) goto L39;
            r108 = false;
        L96:
            b r130 = this.$callback;
            if (r130 == null) goto L106;
            r130.a(r103);
        L106:
            return Unit.INSTANCE;
        L100:
            if ((r102 instanceof f) == false) goto L106;
            b r131 = this.$callback;
            if (r131 == null) goto L104;
            r131.b(((f) r102).f360157d);
        L104:
            FLogger.f375446a.e(CommonVideoModel.TAG, "[requestLoadMoreForVideo] error!!! error code : " + ((f) r102).f360157d.getCode());
            goto L106
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            if (this.this$0.getUseNewApiGetVideoModel() == false) goto L11;
            String r132 = CommonVideoModel.LOAD_VIDEO_PATH_FROM_FLOW;
        L12:
            JSONObject r133 = new JSONObject();
            boolean r134 = this.$isFirst;
            MediaEntityContainer r135 = this.$origin;
            CommonVideoModel r136 = this.this$0;
            if (r134 == false) goto L20;
            JSONArray r137 = new JSONArray();
            String[] r138 = CommonVideoModel.access$getMediaIds(r136, r135);
            if (r138 == null) goto L19;
            int r139 = r138.length;
            int r140 = 0;
        L17:
            if (r140 >= r139) goto L19;
            r137.put(r138[r140]);
            r140 = r140 + 1;
        L19:
            Unit r141 = Unit.INSTANCE;
            r133.put("item_ids", r137);
        L20:
            if (r134 == true) goto L22;
            r133.put("query", r135.getQuery());
        L22:
            r133.put(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, r135.getLimit());
            r133.put("offset", r135.getOffset());
            r133.put("has_more", r135.getHas_more());
            r133.put("search_id", r135.getSearch_id());
            Unit r142 = Unit.INSTANCE;
            this.label = 1;
            r101 = HttpExtKt.k(ServiceType.BASIC_SERVICE, MediaEntityContainer.class, r132, r133, null, null, false, null, null, null, this, 1008);
            if (r101 != r111) goto L25;
            return r111;
        L11:
            r132 = CommonVideoModel.LOAD_MORE_PATH_FOR_VIDEO + this.this$0.getSource();
            goto L12
        }
    }

    private final void requestVideoNew() {
    }

    public static /* synthetic */ HttpLiveData yo() {
        return create_delegate$lambda$1();
    }

    static {
        Companion = new a();
        mGson = new Gson();
        create$delegate = LazyKt.lazy(new com.larus.flow.video.bean.a());
        bottomBarHeight = -1;
        topBarHeight = -1;
    }

    private static final HttpLiveData create_delegate$lambda$1() {
        return new HttpLiveData(MediaEntityContainer.class);
    }

    public final boolean isInSearchList() {
        MediaEntityContainer r100 = this.loadMoreContainer;
        if (r100 == null) goto L5;
        String r101 = r100.getQueryParams();
    L6:
        if (r101 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r101 = null;
        goto L6
    }

    public static final /* synthetic */ int access$getBottomBarHeight$cp() {
        return bottomBarHeight;
    }

    public static final /* synthetic */ Lazy access$getCreate$delegate$cp() {
        return create$delegate;
    }

    public static final /* synthetic */ Gson access$getMGson$cp() {
        return mGson;
    }

    public static final /* synthetic */ int access$getTopBarHeight$cp() {
        return topBarHeight;
    }

    public final ArrayList<MediaEntity> getItems() {
        return this.items;
    }

    public final MediaEntityContainer getLoadMoreContainer() {
        return this.loadMoreContainer;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final Integer getSource() {
        return this.source;
    }

    public final boolean getUseNewApiGetVideoModel() {
        return this.useNewApiGetVideoModel;
    }

    public CommonVideoModel(ArrayList<MediaEntity> r100) {
        this.items = r100;
        this.source = -1;
    }

    public static final /* synthetic */ void access$setBottomBarHeight$cp(int r100) {
        bottomBarHeight = r100;
    }

    public static final /* synthetic */ void access$setTopBarHeight$cp(int r100) {
        topBarHeight = r100;
    }

    private final String[] getMediaIds(MediaEntityContainer r100) {
        ArrayList<MediaEntity> r101 = r100.mediaList();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        FLogger.f375446a.e(TAG, "[getMediaIds] error!!! origin.music_list is empty  ");
        return null;
    L13:
        ArrayList r103 = new ArrayList();
        ArrayList<MediaEntity> r104 = r100.mediaList();
        if (r104 == null) goto L27;
        Iterator<T> r105 = r104.iterator();
        int r106 = 0;
    L17:
        if (r105.hasNext() == false) goto L27;
        Object r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        MediaEntity r109 = (MediaEntity) r107;
        if (r109 == null) goto L24;
        String r110 = r109.getItem_id();
    L25:
        r103.add(r110);
        r106 = r108;
        goto L17
    L24:
        r110 = null;
    L27:
        return (String[]) r103.toArray(new String[0]);
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L10
    }

    public final void setLoadMoreContainer(MediaEntityContainer r100) {
        this.loadMoreContainer = r100;
    }

    public final void setOffset(int r100) {
        this.offset = r100;
    }

    public final void setSource(Integer r100) {
        this.source = r100;
    }

    public final void setUseNewApiGetVideoModel(boolean r100) {
        this.useNewApiGetVideoModel = r100;
    }

    public static final /* synthetic */ String[] access$getMediaIds(CommonVideoModel r100, MediaEntityContainer r101) {
        return r100.getMediaIds(r101);
    }

    private final Job requestLoadMoreForSearchList(MediaEntityContainer r100, b r101) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r101, r100, null), 3, null);
    }

    public final void requestPreloadVideoByItemIds(MediaEntityContainer r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        if (this.useNewApiGetVideoModel == true) goto L9;
        Integer r102 = this.source;
        if (r102 == null) goto L7;
        int r103 = r102.intValue();
    L8:
        if (r103 > 0) goto L9;
        return;
    L7:
        r103 = 0;
    L9:
        FLogger.f375446a.d(TAG, "[requestPreloadVideoByItemIds]");
        requestLoadMoreForVideo(true, r100, r101);
    }

    private final Job requestLoadMoreForVideo(boolean r110, MediaEntityContainer r111, b r112) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C114441(this, r112, r110, r111, null), 3, null);
    }

    public final void requestLoadMore(boolean r100, MediaEntityContainer r101, b r102) {
        Intrinsics.checkNotNullParameter(r101, PlayerResolution.SDKKEY.ORIGIN);
        FLogger.f375446a.d(TAG, "[requestLoadMore] isFirst:" + r100 + " isInSearchList:" + isInSearchList());
        if (isInSearchList() == false) goto L6;
        if (r100 == true) goto L6;
        requestLoadMoreForSearchList(r101, r102);
        return;
    L6:
        requestLoadMoreForVideo(r100, r101, r102);
    }

    public static /* synthetic */ void requestLoadMore$default(CommonVideoModel r100, boolean r101, MediaEntityContainer r102, b r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L5;
        r101 = false;
    L5:
        r100.requestLoadMore(r101, r102, r103);
    }

    public static /* synthetic */ Job requestLoadMoreForVideo$default(CommonVideoModel r100, boolean r101, MediaEntityContainer r102, b r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = false;
    L6:
        return r100.requestLoadMoreForVideo(r101, r102, r103);
    }
}
