package com.bytedance.android.shopping.store.mall.follows.basic;

import android.content.Context;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.k0;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.mall.follows.DisplayType;
import com.bytedance.android.shopping.store.mall.follows.FollowStoreResponse;
import com.bytedance.android.shopping.store.mall.follows.PageLoadStatus;
import com.bytedance.android.shopping.store.mall.follows.ThemeStatus;
import com.bytedance.android.shopping.store.mall.follows.apidata.FollowStoreApiDataCacheKey;
import com.bytedance.android.shopping.store.mall.follows.apidata.FollowStoreApiDataManager;
import com.bytedance.android.shopping.store.moments.dto.HybridListDTO;
import com.bytedance.android.shopping.store.moments.dto.ItemDTO;
import com.bytedance.android.shopping.store.moments.dto.SectionDTO;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 o2\u00020\u0001:\u0001pB\u0007¢\u0006\u0004\bm\u0010nJI\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022#\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005H\u0002J \u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J>\u0010\u001d\u001a\u00020\t2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00132\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u001e\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u001f2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002JB\u0010'\u001a\u00020\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020%H\u0016J\u001c\u0010(\u001a\u00020\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0016J\u0006\u0010)\u001a\u00020\u0005J\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013JK\u0010-\u001a\u00020\t2\u0006\u0010,\u001a\u00020+2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004R$\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R0\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010/\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0017\u00106\u001a\u0002058\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR(\u0010H\u001a\b\u0012\u0004\u0012\u00020+0:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010;\u001a\u0004\bI\u0010=\"\u0004\bJ\u0010?R(\u0010L\u001a\b\u0012\u0004\u0012\u00020K0:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010;\u001a\u0004\bM\u0010=\"\u0004\bN\u0010?R(\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00050:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010;\u001a\u0004\bP\u0010=\"\u0004\bQ\u0010?R\u0016\u0010R\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010CR\u0017\u0010S\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR.\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010/\u001a\u0004\bW\u00102\"\u0004\bX\u00104R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010/R\u0018\u0010Z\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R$\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001d\u0010h\u001a\u0004\u0018\u00010c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\u001d\u0010l\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010e\u001a\u0004\bj\u0010k¨\u0006q"}, d2 = {"Lcom/bytedance/android/shopping/store/mall/follows/basic/BaseFollowStoreViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "callback", "enableCache", "requestAfterCache", "fetchTab", "Lcom/bytedance/android/shopping/store/mall/follows/FollowStoreResponse;", "response", "firstFrame", "hasMore", "preprocessListData", "", "", "", "bizConfig", "Lcom/bytedance/android/shopping/store/moments/dto/ItemDTO;", "itemDTO", "", "displayType", "index", "isCacheData", "appendDisplayType", "loadMore", "", "apiConfig", "pageParams", "reqParams", "Lorg/json/JSONObject;", "perfParams", "Lcom/bytedance/android/shopping/store/mall/follows/apidata/FollowStoreApiDataCacheKey;", "cacheKey", "init", "updatePageParams", "isDoubleRaw", "buildInitialData", "Lcom/bytedance/android/ec/store/shopping/paging/LoadStatus;", "status", "loadData", "passThroughParams", "Ljava/util/Map;", "paramsMap", "getParamsMap", "()Ljava/util/Map;", "setParamsMap", "(Ljava/util/Map;)V", "Lcom/bytedance/android/ec/hybrid/list/util/l;", "hybridListSession", "Lcom/bytedance/android/ec/hybrid/list/util/l;", "getHybridListSession", "()Lcom/bytedance/android/ec/hybrid/list/util/l;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getResponse", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "setResponse", "(Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;)V", "", "cursor", "J", "Z", "getHasMore", "()Z", "setHasMore", "(Z)V", "loadStatus", "getLoadStatus", "setLoadStatus", "Lcom/bytedance/android/shopping/store/mall/follows/ThemeStatus;", "themeStatus", "getThemeStatus", "setThemeStatus", "pageVisible", "getPageVisible", "setPageVisible", "fetchLock", "sceneId", "Ljava/lang/String;", "getSceneId", "()Ljava/lang/String;", "getPageParams", "setPageParams", "Lcom/bytedance/android/shopping/store/mall/follows/apidata/FollowStoreApiDataManager;", "dataManager", "Lcom/bytedance/android/shopping/store/mall/follows/apidata/FollowStoreApiDataManager;", "Lhj3/e;", "perfMonitor", "Lhj3/e;", "getPerfMonitor", "()Lhj3/e;", "setPerfMonitor", "(Lhj3/e;)V", "Lhj3/g;", "momentConfig$delegate", "Lkotlin/Lazy;", "getMomentConfig", "()Lhj3/g;", "momentConfig", "resourceVersion$delegate", "getResourceVersion", "()Ljava/lang/Long;", "resourceVersion", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseFollowStoreViewModel extends BaseViewModel {
    public static final a Companion = null;
    public static final String KEY_APP_THEME = "app_theme";
    public static final String KEY_BTM_KEY = "btm_key";
    public static final String KEY_ECOM_SCENE_ID = "ecom_scene_id";
    public static final String KEY_PREVIOUS_PAGE = "previous_page";
    public static final String KEY_SKIN_INFO = "skin_info";
    public static final String KEY_TAB_ID = "tab_id";
    private long cursor;
    private FollowStoreApiDataManager dataManager;
    private boolean fetchLock;
    private boolean hasMore;
    private final com.bytedance.android.ec.hybrid.list.util.l hybridListSession;
    private QLiveData<LoadStatus> loadStatus;
    private final Lazy momentConfig$delegate;
    private Map<String, Object> pageParams;
    private QLiveData<Boolean> pageVisible;
    private Map<String, String> paramsMap;
    private Map<String, String> passThroughParams;
    private hj3.e perfMonitor;
    private final Map<String, Object> reqParams;
    private final Lazy resourceVersion$delegate;
    private QLiveData<FollowStoreResponse> response;
    private final String sceneId;
    private QLiveData<ThemeStatus> themeStatus;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BaseFollowStoreViewModel a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ Function1 c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ boolean h;

        public b(BaseFollowStoreViewModel r1, Context r2, Function1 r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public final void accept(Object r7) {
            FollowStoreResponse r8 = (FollowStoreResponse) r7;
            boolean r1 = false;
            if (r8.isCache() == false) goto L5;
            BaseFollowStoreViewModel.access$fetchTab(this.a, this.b, null, false, true);
        L5:
            hj3.e r0 = this.a.getPerfMonitor();
            if (r0 == null) goto L8;
            r0.d = Long.valueOf(System.currentTimeMillis());
        L8:
            Function1 r2 = this.c;
            if (r2 == null) goto L12;
            Unit r3 = (Unit) r2.invoke(Boolean.TRUE);
        L12:
            if (r8.getStatusCode() == 0) goto L29;
            if (this.d == false) goto L16;
        L22:
            LoadStatus r4 = LoadStatus.InitializeError;
        L23:
            this.a.getLoadStatus().g(r4);
            if (this.d == false) goto L50;
            hj3.e r5 = this.a.getPerfMonitor();
            if (r5 == null) goto L51;
            r5.a(this.d, PageLoadStatus.ERROR, Integer.valueOf(r8.getStatusCode()));
            return;
        L51:
            return;
        L50:
            return;
        L16:
            if (this.e == true) goto L22;
            if (this.f == false) goto L21;
            r4 = LoadStatus.RefreshError;
            goto L23
        L21:
            r4 = LoadStatus.LoadMoreError;
            goto L23
        L29:
            if (this.d == true) goto L31;
        L37:
            BaseFollowStoreViewModel.access$setCursor$p(this.a, r8.getCursor());
            this.a.setHasMore(r8.getHasMore());
            r8.setFirstFrame(this.g);
            r8.setInitFetch(this.d);
            if (this.h == false) goto L40;
        L41:
            r1 = true;
        L42:
            r8.setRequestAfterCache(r1);
            BaseFollowStoreViewModel.access$setPassThroughParams$p(this.a, r8.getPassThroughParams());
            BaseFollowStoreViewModel r6 = this.a;
            BaseFollowStoreViewModel.access$preprocessListData(r6, r8, this.g, r6.getHasMore());
            this.a.getResponse().g(r8);
            if (this.a.getHasMore() == true) goto L46;
            this.a.getLoadStatus().g(LoadStatus.LoadMoreEnd);
            return;
        L46:
            if (this.d == false) goto L48;
            this.a.getLoadStatus().g(LoadStatus.InitializeSuccess);
            return;
        L48:
            this.a.getLoadStatus().g(LoadStatus.LoadMoreSuccess);
            return;
        L40:
            if (r8.isFeCache() == false) goto L42;
        L31:
            if (r8.isListEmpty() == false) goto L37;
            BaseFollowStoreViewModel.access$setFetchLock$p(this.a, false);
            this.a.getLoadStatus().g(LoadStatus.InitializeEmpty);
            if (this.d == false) goto L53;
            hj3.e r9 = this.a.getPerfMonitor();
            if (r9 == null) goto L54;
            r9.a(this.d, PageLoadStatus.EMPTY, null);
            return;
        L54:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ BaseFollowStoreViewModel a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        public c(BaseFollowStoreViewModel r1, Function1 r2, boolean r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            Function1 r6 = this.b;
            if (r6 == null) goto L6;
            Unit r7 = (Unit) r6.invoke(Boolean.FALSE);
        L6:
            if (this.c == false) goto L13;
            hj3.e r8 = this.a.getPerfMonitor();
            if (r8 == null) goto L10;
            r8.d = Long.valueOf(System.currentTimeMillis());
        L10:
            hj3.e r9 = this.a.getPerfMonitor();
            if (r9 == null) goto L13;
            r9.a(this.c, PageLoadStatus.ERROR, 100);
        L13:
            QLiveData<LoadStatus> r10 = this.a.getLoadStatus();
            if (this.c == false) goto L16;
        L19:
            LoadStatus r0 = LoadStatus.InitializeError;
        L20:
            r10.g(r0);
            BaseFollowStoreViewModel.access$setFetchLock$p(this.a, false);
            return;
        L16:
            if (this.d == true) goto L19;
            r0 = LoadStatus.LoadMoreError;
            goto L20
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ BaseFollowStoreViewModel a;

        public d(BaseFollowStoreViewModel r1) {
            this.a = r1;
        }

        public final void run() {
            BaseFollowStoreViewModel.access$setFetchLock$p(this.a, false);
            com.bytedance.android.ec.hybrid.list.util.l r0 = this.a.getHybridListSession();
            r0.d = Long.valueOf(System.currentTimeMillis());
        }
    }

    static {
        Companion = new a();
    }

    public BaseFollowStoreViewModel() {
        super(null, null, 3, null);
        this.hybridListSession = new com.bytedance.android.ec.hybrid.list.util.l();
        this.response = new QLiveData();
        this.hasMore = true;
        this.loadStatus = new QLiveData();
        this.themeStatus = new QLiveData();
        this.pageVisible = new QLiveData();
        this.sceneId = UUID.randomUUID().toString();
        this.pageParams = new LinkedHashMap();
        this.reqParams = new LinkedHashMap();
        this.momentConfig$delegate = LazyKt.lazy(BaseFollowStoreViewModel$momentConfig$2.INSTANCE);
        this.resourceVersion$delegate = LazyKt.lazy(new BaseFollowStoreViewModel$resourceVersion$2(this));
    }

    private final Long getResourceVersion() {
        return (Long) this.resourceVersion$delegate.getValue();
    }

    public final hj3.g getMomentConfig() {
        return (hj3.g) this.momentConfig$delegate.getValue();
    }

    public final Map<String, Object> buildInitialData() {
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("btm_ab", this.pageParams.get(KEY_BTM_KEY));
        r2.put("skin", this.pageParams.get(KEY_SKIN_INFO));
        r2.put("theme", this.pageParams.get(KEY_APP_THEME));
        JSONObject r3 = new JSONObject();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        r3.put(KEY_PREVIOUS_PAGE, this.pageParams.get(KEY_PREVIOUS_PAGE));     // Catch: Throwable -> L5
        Object r0 = Result.constructor-impl(r3.put(KEY_ECOM_SCENE_ID, this.pageParams.get(KEY_ECOM_SCENE_ID)));     // Catch: Throwable -> L5
    L7:
        JSONObject r1 = new JSONObject();
        if (Result.isFailure-impl(r0) == false) goto L10;
        r0 = r1;
    L10:
        r2.put("log_extra", r0);
        return r2;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean isDoubleRaw() {
        if (this.response.a() != null) goto L19;
        hj3.g r0 = getMomentConfig();
        if (r0 != null) goto L7;
        return true;
    L7:
        if (r0.j() != null) goto L9;
        return true;
    L9:
        if (r0.c() == null) goto L33;
        Long r2 = getResourceVersion();
        if (r2 == null) goto L13;
        long r3 = r2.longValue();
    L15:
        if (r3 >= r0.c().longValue()) goto L34;
        return false;
    L34:
        return true;
    L13:
        r3 = Long.MAX_VALUE;
        goto L15
    L33:
        return true;
    L19:
        FollowStoreResponse r1 = (FollowStoreResponse) this.response.a();
        Object r4 = null;
        if (r1 == null) goto L24;
        Map<String, Object> r5 = r1.getBizConfig();
        if (r5 == null) goto L24;
        Object r6 = r5.get("card_column_style");
    L26:
        if ((r6 instanceof Double) == false) goto L30;
        r4 = r6;
    L30:
        return Intrinsics.areEqual((Double) r4, 1.0d);
    L24:
        r6 = null;
        goto L26
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final com.bytedance.android.ec.hybrid.list.util.l getHybridListSession() {
        return this.hybridListSession;
    }

    public final QLiveData<LoadStatus> getLoadStatus() {
        return this.loadStatus;
    }

    public final Map<String, Object> getPageParams() {
        return this.pageParams;
    }

    public final QLiveData<Boolean> getPageVisible() {
        return this.pageVisible;
    }

    public final Map<String, String> getParamsMap() {
        return this.paramsMap;
    }

    public final hj3.e getPerfMonitor() {
        return this.perfMonitor;
    }

    public final QLiveData<FollowStoreResponse> getResponse() {
        return this.response;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final QLiveData<ThemeStatus> getThemeStatus() {
        return this.themeStatus;
    }

    public static final /* synthetic */ long access$getCursor$p(BaseFollowStoreViewModel r2) {
        return r2.cursor;
    }

    public static final /* synthetic */ boolean access$getFetchLock$p(BaseFollowStoreViewModel r0) {
        return r0.fetchLock;
    }

    public static final /* synthetic */ Map access$getPassThroughParams$p(BaseFollowStoreViewModel r0) {
        return r0.passThroughParams;
    }

    private final Map<String, Object> apiConfig(boolean r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r3 == false) goto L7;
        Map<String, String> r4 = this.passThroughParams;
        if (r4 == null) goto L7;
        r0.putAll(r4);
    L7:
        Map<String, String> r5 = this.paramsMap;
        if (r5 == null) goto L10;
        String r6 = r5.get("feed_back");
    L11:
        r0.put("feed_back", r6);
        return r0;
    L10:
        r6 = null;
        goto L11
    }

    public final void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public final void setLoadStatus(QLiveData<LoadStatus> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.loadStatus = r2;
    }

    public final void setPageParams(Map<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pageParams = r2;
    }

    public final void setPageVisible(QLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pageVisible = r2;
    }

    public final void setParamsMap(Map<String, String> r1) {
        this.paramsMap = r1;
    }

    public final void setPerfMonitor(hj3.e r1) {
        this.perfMonitor = r1;
    }

    public final void setResponse(QLiveData<FollowStoreResponse> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.response = r2;
    }

    public final void setThemeStatus(QLiveData<ThemeStatus> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.themeStatus = r2;
    }

    public void updatePageParams(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "pageParams");
        this.pageParams.putAll(r2);
    }

    public static final /* synthetic */ void access$setCursor$p(BaseFollowStoreViewModel r0, long r1) {
        r0.cursor = r1;
    }

    public static final /* synthetic */ void access$setFetchLock$p(BaseFollowStoreViewModel r0, boolean r1) {
        r0.fetchLock = r1;
    }

    public static final /* synthetic */ void access$setPassThroughParams$p(BaseFollowStoreViewModel r0, Map r1) {
        r0.passThroughParams = r1;
    }

    private final void preprocessListData(FollowStoreResponse r12, boolean r13, boolean r14) {
        HybridListDTO r0 = r12.getHybridList();
        if (r0 == null) goto L46;
        List<SectionDTO> r1 = r0.getSections();
        if (r1 == null) goto L63;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L64;
        SectionDTO r3 = (SectionDTO) r2.next();
        if (Intrinsics.areEqual(r3.getSectionId(), "feed_section") == true) goto L11;
        ArrayList<ItemDTO> r4 = r3.getItems();
        if (r4 == null) goto L8;
        Iterator<T> r5 = r4.iterator();
        int r8 = 0;
    L41:
        if (r5.hasNext() == false) goto L8;
        Object r6 = r5.next();
        int r7 = r8 + 1;
        if (r8 >= 0) goto L45;
        CollectionsKt.throwIndexOverflow();
    L45:
        appendDisplayType(r12.getBizConfig(), (ItemDTO) r6, DisplayType.NORMAL.getValue(), r8, r12.isCache());
        r8 = r7;
        goto L41
    L11:
        ArrayList<ItemDTO> r9 = r3.getItems();
        if (r9 == null) goto L8;
        Iterator<T> r10 = r9.iterator();
        int r11 = 0;
    L15:
        if (r10.hasNext() == false) goto L8;
        Object r15 = r10.next();
        int r16 = r11 + 1;
        if (r11 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        ItemDTO r17 = (ItemDTO) r15;
        if (r17.getItemType() != 50106) goto L25;
        if (r11 != 0) goto L25;
        if (r13 == false) goto L25;
        appendDisplayType(r12.getBizConfig(), r17, DisplayType.FILTER_CARD_FIRST.getValue(), r11, r12.isCache());
    L36:
        r11 = r16;
    L25:
        if (r17.getItemType() != 50106) goto L27;
    L31:
        if (r14 == false) goto L33;
    L35:
        appendDisplayType(r12.getBizConfig(), r17, DisplayType.NORMAL.getValue(), r11, r12.isCache());
        goto L36
    L33:
        if (r11 != (r9.size() - 1)) goto L35;
        appendDisplayType(r12.getBizConfig(), r17, DisplayType.CONTENT_CARD_LAST.getValue(), r11, r12.isCache());
        goto L36
    L27:
        if (r16 >= r9.size()) goto L31;
        if (((ItemDTO) ListProtector.get(r9, r16)).getItemType() != 50106) goto L31;
        appendDisplayType(r12.getBizConfig(), r17, DisplayType.CONTENT_CARD_BOTTOM_WITH_FILTER.getValue(), r11, r12.isCache());
        goto L36
    L64:
        return;
    L63:
        return;
    }

    public static final /* synthetic */ void access$preprocessListData(BaseFollowStoreViewModel r0, FollowStoreResponse r1, boolean r2, boolean r3) {
        r0.preprocessListData(r1, r2, r3);
    }

    private final void fetchTab(Context r19, Function1<? super Boolean, Unit> r20, boolean r21, boolean r22) {
        if (((LoadStatus) this.loadStatus.a()) != LoadStatus.Refresh) goto L5;
        boolean r7 = true;
    L7:
        if (((LoadStatus) this.loadStatus.a()) != LoadStatus.RefreshWhenError) goto L9;
        boolean r11 = true;
    L11:
        if (((LoadStatus) this.loadStatus.a()) != LoadStatus.Initialize) goto L13;
        boolean r12 = true;
    L14:
        if (r7 == true) goto L19;
        if (r12 == true) goto L19;
        if (r11 == true) goto L19;
        boolean r8 = false;
    L20:
        if (r12 == false) goto L24;
        hj3.e r0 = this.perfMonitor;
        if (r0 == null) goto L24;
        r0.c = Long.valueOf(System.currentTimeMillis());
    L24:
        Map<String, Object> r1 = apiConfig(!r8);
        r1.putAll(this.reqParams);
        r1.put("gecko_version", getResourceVersion());
        if (r8 == false) goto L27;
        r1.put("source", "mall_follow_tab_feed_follow");
        this.cursor = 0;
    L27:
        FollowStoreApiDataManager r2 = this.dataManager;
        if (r2 == null) goto L146;
        long r13 = this.cursor;
        HashMap<String, Object> r6 = (HashMap) r1;
        Intrinsics.checkNotNullParameter(r6, "apiConfig");
        if (r21 == false) goto L139;
        String r3 = r2.e.getFeData();
        if (r3 == null) goto L75;
        if ((!StringsKt.isBlank(r3)) == true) goto L37;
        r3 = null;
    L37:
        if (r3 == null) goto L75;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L53
        Object r4 = new com.bytedance.android.shopping.store.mall.follows.apidata.b(r19).a(r3);     // Catch: Throwable -> L51
        if (r4 != null) goto L43;
    L48:
        FollowStoreResponse r5 = null;
    L49:
        Object r9 = Result.constructor-impl(r5);     // Catch: Throwable -> L51
    L57:
        if (Result.isFailure-impl(r9) == false) goto L59;
        r9 = null;
    L59:
        FollowStoreResponse r10 = (FollowStoreResponse) r9;
        if (r10 == null) goto L75;
        Lazy r14 = ECStoreSettings.a;
        int r16 = p.a;
        jj4.b r17 = jj4.b.b;     // Catch: Throwable -> L64
        Object r18 = jj4.a.a("follow_shop_remove_storage_configs", com.bytedance.android.ec.store.setting.b.class, null, false);     // Catch: Throwable -> L64
    L69:
        if (r2.a((com.bytedance.android.ec.store.setting.b) r18, Long.valueOf(System.currentTimeMillis())) == false) goto L75;
        r10.setFeCache(true);
        hj3.e r23 = r2.d;
        if (r23 == null) goto L73;
        r23.b(0, k0.b(r10));
    L73:
        Observable<FollowStoreResponse> r24 = Observable.just(r10);
    L76:
        if (r24 == null) goto L139;
        r2.a = null;
    L128:
        if (r24 == null) goto L147;
        Observable r25 = bg4.b.b(r24);
        if (r25 == null) goto L148;
        Disposable r26 = r25.subscribe(new b(this, r19, r20, r12, r11, r7, r8, r22), new c(this, r20, r12, r11), new d(this));
        if (r26 == null) goto L149;
        com.bytedance.android.ec.core.async.a.a(r26, this);
        return;
    L149:
        return;
    L148:
        return;
    L147:
        return;
    L64:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r18) == false) goto L69;
        r18 = null;
        goto L69
    L43:
        if ((r4 instanceof String) == true) goto L45;
        r4 = null;
    L45:
        String r27 = (String) r4;     // Catch: Throwable -> L51
        if (r27 == null) goto L48;
        int r28 = t0.a;     // Catch: Throwable -> L51
        r5 = (FollowStoreResponse) t0.a.a.fromJson(r27, FollowStoreResponse.class);     // Catch: Throwable -> L51
    L51:
        th = th;
    L55:
        Result.Companion r29 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L53:
        th = th;
    L75:
        r24 = null;
    L139:
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L92
        io.reactivex.internal.observers.h<FollowStoreResponse> r31 = r2.a;     // Catch: Throwable -> L92
        if (r31 != null) goto L82;
    L90:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L92
    L94:
        if (r21 == true) goto L96;
    L122:
        io.reactivex.internal.observers.h<FollowStoreResponse> r32 = r2.a;
        if (r32 != null) goto L125;
    L127:
        r24 = r2.b(r13, r6);
        goto L128
    L125:
        if (r32.isCancelled() == true) goto L127;
        r24 = Observable.fromFuture(r2.a);
        r2.a = null;
        goto L128
    L96:
        if (ECSettingKeys.h0() == 0) goto L119;
        String r33 = com.bytedance.android.shopping.store.mall.follows.apidata.a.a.query(r2.c());
        if (r33 == null) goto L119;
        int r34 = t0.a;     // Catch: Throwable -> L102
        Object r35 = Result.constructor-impl((FollowStoreResponse) t0.a.a.fromJson(r33, FollowStoreResponse.class));     // Catch: Throwable -> L102
    L105:
        if (Result.isFailure-impl(r35) == false) goto L107;
        r35 = null;
    L107:
        FollowStoreResponse r36 = (FollowStoreResponse) r35;
        if (r36 == null) goto L119;
        Lazy r37 = ECStoreSettings.a;
        int r38 = p.a;
        jj4.b r39 = jj4.b.b;     // Catch: Throwable -> L112
        Object r40 = jj4.a.a("follow_page_remove_storage_configs", com.bytedance.android.ec.store.setting.b.class, null, false);     // Catch: Throwable -> L112
    L117:
        if (r2.a((com.bytedance.android.ec.store.setting.b) r40, null) == false) goto L119;
        r36.setCache(true);
        r24 = Observable.just(r36);
    L120:
        if (r24 == null) goto L122;
    L112:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r40 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r40) == false) goto L117;
        r40 = null;
    L102:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r35 = Result.constructor-impl(ResultKt.createFailure(th));
    L119:
        r24 = null;
        goto L120
    L82:
        if (r31.isDone() != true) goto L90;
        io.reactivex.internal.observers.h<FollowStoreResponse> r43 = r2.a;     // Catch: Throwable -> L92
        if (r43 == null) goto L90;
        FollowStoreResponse r44 = (FollowStoreResponse) r43.get();     // Catch: Throwable -> L92
        if (r44 == null) goto L90;
        if (r44.getStatusCode() != 0) goto L90;
        r24 = Observable.fromFuture(r2.a);     // Catch: Throwable -> L92
        r2.a = null;     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L94
    L146:
        return;
    L19:
        r8 = true;
        goto L20
    L13:
        r12 = false;
        goto L14
    L9:
        r11 = false;
        goto L11
    L5:
        r7 = false;
        goto L7
    }

    public void init(Map<String, ? extends Object> r3, Map<String, ? extends Object> r4, JSONObject r5, FollowStoreApiDataCacheKey r6) {
        Intrinsics.checkNotNullParameter(r3, "pageParams");
        Intrinsics.checkNotNullParameter(r4, "reqParams");
        Intrinsics.checkNotNullParameter(r6, "cacheKey");
        this.pageParams.clear();
        this.reqParams.clear();
        this.pageParams.putAll(r3);
        this.reqParams.putAll(r4);
        this.loadStatus.g(LoadStatus.Initialize);
        hj3.e r7 = new hj3.e(r5);
        this.perfMonitor = r7;
        this.dataManager = new FollowStoreApiDataManager(r7, r6);
        if (ECSettingKeys.h0() != 1) goto L13;
        FollowStoreApiDataManager r8 = this.dataManager;
        if (r8 == null) goto L14;
        Intrinsics.checkNotNullParameter(r4, "reqParams");
        io.reactivex.internal.observers.h<FollowStoreResponse> r9 = new io.reactivex.internal.observers.h();
        HashMap<String, Object> r10 = new HashMap();
        r10.put("source", "mall_follow_tab_feed_follow");
        r10.put("gecko_version", (Long) r8.c.getValue());
        r10.putAll(r4);
        Unit r11 = Unit.INSTANCE;
        Observable<FollowStoreResponse> r12 = r8.b(0, r10);
        if (r12 == null) goto L11;
        Observable r13 = r12.subscribeOn(Schedulers.io());
        if (r13 == null) goto L11;
        r13.subscribe(r9);
    L11:
        r8.a = r9;
        return;
    L14:
        return;
    }

    public final void loadData(LoadStatus r9, Context r10, boolean r11, Function1<? super Boolean, Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "status");
        if (this.fetchLock == false) goto L7;
        if (r12 == null) goto L9;
        Unit r13 = (Unit) r12.invoke(Boolean.FALSE);
        return;
    L9:
        return;
    L7:
        this.fetchLock = true;
        this.loadStatus.g(r9);
        com.bytedance.android.ec.hybrid.list.util.l r14 = this.hybridListSession;
        r14.c = Long.valueOf(System.currentTimeMillis());
        fetchTab$default(this, r10, r12, r11, false, 8, null);
    }

    public static final /* synthetic */ void access$fetchTab(BaseFollowStoreViewModel r0, Context r1, Function1 r2, boolean r3, boolean r4) {
        r0.fetchTab(r1, r2, r3, r4);
    }

    private final void appendDisplayType(Map<String, ? extends Object> r6, ItemDTO r7, int r8, int r9, boolean r10) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L40
        JSONObject r3 = new JSONObject(r7.getItemData());     // Catch: Throwable -> L40
        r3.put("card_display_type", r8);     // Catch: Throwable -> L40
        r3.put("index", r9);     // Catch: Throwable -> L40
        r3.put("item_id", r7.getItemId());     // Catch: Throwable -> L40
        if (r9 != 0) goto L6;
        boolean r11 = true;
    L7:
        r3.put("is_first_card", r11);     // Catch: Throwable -> L40
        String r12 = CommentScene.COMMENTSCENE_NO_AWEME;
        if (r10 == false) goto L11;
        Object r4 = CommentScene.COMMENTSCENE_NO_AWEME;
    L12:
        r3.put("is_cache_data", r4);     // Catch: Throwable -> L40
        if (r6 == null) goto L45;
        Iterator<Map.Entry<String, ? extends Object>> r13 = r6.entrySet().iterator();     // Catch: Throwable -> L40
    L16:
        if (r13.hasNext() == false) goto L45;
        Map.Entry<String, ? extends Object> r5 = r13.next();     // Catch: Throwable -> L40
        r3.put(r5.getKey(), r5.getValue());     // Catch: Throwable -> L40
    L45:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L21
        Object r15 = Result.constructor-impl(JSONObjectProtectorUtils.getJSONObject(r3, "log_extra"));     // Catch: Throwable -> L21
    L23:
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L40
        if (Result.isFailure-impl(r15) == false) goto L26;
        r15 = r16;
    L26:
        JSONObject r17 = (JSONObject) r15;     // Catch: Throwable -> L40
        if (r10 == true) goto L30;
        r12 = "0";
    L30:
        r17.put("is_cache_data", r12);     // Catch: Throwable -> L40
        r3.put("log_extra", r17);     // Catch: Throwable -> L40
        Map<String, String> r18 = this.passThroughParams;     // Catch: Throwable -> L36
        if (r18 != null) goto L34;
        r18 = MapsKt.emptyMap();     // Catch: Throwable -> L36
    L34:
        Result.constructor-impl(r3.put("pass_through_params", new JSONObject(r18)));     // Catch: Throwable -> L36
    L38:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L40
        r7.setItemData(r3.toString());     // Catch: Throwable -> L40
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L40
        return;
    L36:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L40
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L40
        goto L38
    L21:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L40
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L40
        goto L23
    L11:
        r4 = "0";
        goto L12
    L6:
        r11 = false;
    L40:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static /* synthetic */ void fetchTab$default(BaseFollowStoreViewModel r0, Context r1, Function1 r2, boolean r3, boolean r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L6;
        r4 = false;
    L6:
        r0.fetchTab(r1, r2, r3, r4);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchTab");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadData$default(BaseFollowStoreViewModel r1, LoadStatus r2, Context r3, boolean r4, Function1 r5, int r6, Object r7) {
        if (r7 != null) goto L15;
        if ((r6 & 2) == 0) goto L7;
        r3 = null;
    L7:
        if ((r6 & 4) == 0) goto L10;
        r4 = false;
    L10:
        if ((r6 & 8) == 0) goto L12;
        r5 = null;
    L12:
        r1.loadData(r2, r3, r4, r5);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadData");
    }
}
