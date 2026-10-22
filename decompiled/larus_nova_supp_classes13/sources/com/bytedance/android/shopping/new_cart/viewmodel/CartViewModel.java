package com.bytedance.android.shopping.new_cart.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.marketing.sdk.api.IMarketingServiceV2;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.CartSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.new_cart.dto.CartMarketingResourceSchemaResponse;
import com.bytedance.android.shopping.new_cart.params.CartParams;
import com.bytedance.android.shopping.new_cart.repo.CartRepository;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.reflect.TypeToken;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001SB\u0007¢\u0006\u0004\bP\u0010QJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0003J\u001c\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0006*\u00020\u0005H\u0002J4\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002J\"\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0006H\u0002J2\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00032\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u000eJ*\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00192\b\b\u0001\u0010\n\u001a\u00020\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ\b\u0010%\u001a\u00020\u0002H\u0014J\u000e\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&J\u001e\u0010*\u001a\u00020\u00192\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0006R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u00107\u001a\b\u0012\u0004\u0012\u000206058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u000206098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020>058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00108R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020>098\u0006¢\u0006\f\n\u0004\b@\u0010;\u001a\u0004\bA\u0010=R\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010BR\u001d\u0010H\u001a\u0004\u0018\u00010C8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001d\u0010M\u001a\u0004\u0018\u00010I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006T"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/viewmodel/CartViewModel;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/android/shopping/new_cart/viewmodel/CartState;", "", "getCartResourceExposeRecords", "", "", "toMutableStringKeyMapOrNull", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/e;", "response", "queryScene", "", "versionCode", "Lkotlin/Function0;", "", "successCallBack", "onGetQuery", "", "e", "onGetQueryErr", "getCommonTrackerParams", "name", "params", "duplicateKey", "doEventAction", "", "hasMore", "updateHasMore", "Landroid/content/Context;", "context", "queryForCoupon", "Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;", "objectContainer", "onCreate", "onDestroy", "reloadGul", "doQuery", "defaultState", "", "fps", "changeFps", "map", "updateExtraParam", "Lcom/bytedance/android/shopping/new_cart/yata/customdata/a;", "customDataCenter", "Lcom/bytedance/android/shopping/new_cart/yata/customdata/a;", "getCustomDataCenter", "()Lcom/bytedance/android/shopping/new_cart/yata/customdata/a;", "setCustomDataCenter", "(Lcom/bytedance/android/shopping/new_cart/yata/customdata/a;)V", "Lbg3/a;", "trackerImpl", "Lbg3/a;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/shopping/new_cart/viewmodel/d;", "_onQueryStartLiveData", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "onQueryStartLiveData", "Landroidx/lifecycle/LiveData;", "getOnQueryStartLiveData", "()Landroidx/lifecycle/LiveData;", "Lcom/bytedance/android/shopping/new_cart/viewmodel/c;", "_onQueryEndLiveData", "onQueryEndLiveData", "getOnQueryEndLiveData", "Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;", "Lvf3/a;", "multiUpdateImpl$delegate", "Lkotlin/Lazy;", "getMultiUpdateImpl", "()Lvf3/a;", "multiUpdateImpl", "Lcom/bytedance/android/shopping/new_cart/container/CartSliceCustomWidgetAdapterComponent;", "cartSliceCustomWidgetAdapterComponent$delegate", "getCartSliceCustomWidgetAdapterComponent", "()Lcom/bytedance/android/shopping/new_cart/container/CartSliceCustomWidgetAdapterComponent;", "cartSliceCustomWidgetAdapterComponent", "isInSplitScreen", "()Z", "<init>", "()V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartViewModel extends JediViewModel<CartState> {
    public static final a Companion = null;
    private static final String MARKETING_PLAN_REPORT_RECORDS_CART = "marketing_plan_report_records_cart_popup";
    private static final String VMTAG = "CartViewModel";
    private final MutableLiveData<com.bytedance.android.shopping.new_cart.viewmodel.c> _onQueryEndLiveData;
    private final MutableLiveData<com.bytedance.android.shopping.new_cart.viewmodel.d> _onQueryStartLiveData;
    private final Lazy cartSliceCustomWidgetAdapterComponent$delegate;
    private com.bytedance.android.shopping.new_cart.yata.customdata.a customDataCenter;
    private final Lazy multiUpdateImpl$delegate;
    private CartObjectContainer objectContainer;
    private final LiveData<com.bytedance.android.shopping.new_cart.viewmodel.c> onQueryEndLiveData;
    private final LiveData<com.bytedance.android.shopping.new_cart.viewmodel.d> onQueryStartLiveData;
    private final bg3.a trackerImpl;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Observer<SsResponse<String>> {
        public final /* synthetic */ long a;
        public final /* synthetic */ CartViewModel b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Function0 d;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ Throwable b;

            public a(b r1, Throwable r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b r0 = this.a;     // Catch: Throwable -> L4
                CartViewModel.access$onGetQueryErr(r0.b, this.b, r0.c, r0.a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void onComplete() {
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
        }

        public final void onError(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
            com.bytedance.android.shopping.new_cart.utils.a.f(new a(this, r2));
        }

        public final void onNext(Object r2) {
            SsResponse<String> r3 = (SsResponse) r2;
            Intrinsics.checkNotNullParameter(r3, "o");
            com.bytedance.kmp.ec.yata.common.protocol.data.e r4 = CartRepository.INSTANCE.transformToDTO(r3);
            if (r4 == null) goto L6;
            bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
            com.bytedance.android.shopping.new_cart.utils.a.f(new com.bytedance.android.shopping.new_cart.viewmodel.a(r4, this));
            return;
        }

        public b(long r1, CartViewModel r3, String r4, Function0 r5) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ CartViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public c(CartViewModel r1, String r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CartViewModel.access$get_onQueryStartLiveData$p(this.a).setValue(new com.bytedance.android.shopping.new_cart.viewmodel.d(this.b, this.c));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ CartViewModel a;
        public final /* synthetic */ com.bytedance.kmp.ec.yata.common.protocol.data.e b;
        public final /* synthetic */ String c;

        public d(CartViewModel r1, com.bytedance.kmp.ec.yata.common.protocol.data.e r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            if (com.bytedance.kmp.ec.yata.common.protocol.data.f.d(this.b) == false) goto L6;
            ((AndroidYaTaInstance) CartViewModel.access$getObjectContainer$p(this.a).e.d.invoke()).x(this.b.g(), aa6.a.b.a.b, new com.bytedance.kmp.ec.yata.common.perf.d("biz_" + this.c), com.bytedance.kmp.ec.yata.common.protocol.data.f.b(this.b));
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ CartViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ com.bytedance.kmp.ec.yata.common.protocol.data.e c;

        public e(CartViewModel r1, String r2, com.bytedance.kmp.ec.yata.common.protocol.data.e r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CartViewModel.access$get_onQueryEndLiveData$p(this.a).setValue(new com.bytedance.android.shopping.new_cart.viewmodel.c(this.b, this.c));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ CartViewModel a;
        public final /* synthetic */ String b;

        public f(CartViewModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CartViewModel.access$get_onQueryEndLiveData$p(this.a).setValue(new com.bytedance.android.shopping.new_cart.viewmodel.c(this.b, null));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ CartViewModel a;
        public final /* synthetic */ Context b;

        public static final class a<V> implements Callable {
            public final /* synthetic */ g a;
            public final /* synthetic */ Object b;

            public a(g r1, Object r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                String r0 = CartViewModel.access$getCartResourceExposeRecords(this.a.a);
                if (r0 != null) goto L5;
            L8:
                boolean r1 = true;
            L9:
                if (r1 == true) goto L16;
                Map r2 = CartViewModel.access$toMutableStringKeyMapOrNull(this.a.a, this.b);
                LinkedHashMap r3 = new LinkedHashMap();
                if (r2 == null) goto L14;
                r3.putAll(r2);
            L14:
                r3.put("resource_expose_records", r0);
                return r3;
            L16:
                return this.b;
            L5:
                if (r0.length() == 0) goto L8;
                r1 = false;
                goto L9
            }
        }

        public static final class b<T, R> implements Function {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final Object apply(Object r2) {
                Intrinsics.checkNotNullParameter(r2, "req");
                Observable<wf3.b> r3 = CartRepository.INSTANCE.queryForCoupon(r2);
                if (r3 == null) goto L6;
                return r3;
            L6:
                return Observable.empty();
            }
        }

        public static final class c implements Observer<wf3.b> {
            public final /* synthetic */ g a;

            public static final class a implements Runnable {
                public final /* synthetic */ Throwable a;

                public a(Throwable r1) {
                    this.a = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.printStackTrace();     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public final void onComplete() {
            }

            public final void onSubscribe(Disposable r2) {
                Intrinsics.checkNotNullParameter(r2, "d");
            }

            public c(g r1) {
                this.a = r1;
            }

            public final void onError(Throwable r3) {
                Intrinsics.checkNotNullParameter(r3, "e");
                com.bytedance.android.shopping.new_cart.utils.a.c.d("queryForCoupon", new a(r3));
            }

            public final void onNext(Object r2) {
                wf3.b r3 = (wf3.b) r2;
                Intrinsics.checkNotNullParameter(r3, "t");
                CartMarketingResourceSchemaResponse r4 = r3.a();
                if (r4 != null) goto L6;
                return;
            L6:
                if (r4.isShow() == false) goto L11;
                bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
                com.bytedance.android.shopping.new_cart.utils.a.f(new com.bytedance.android.shopping.new_cart.viewmodel.b(this, r4));
                return;
            }
        }

        public g(CartViewModel r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            Object r0 = ((AndroidYaTaInstance) CartViewModel.access$getObjectContainer$p(this.a).e.d.invoke()).i("growth_marketing_request");
            if (r0 != null) goto L5;
            return;
        L5:
            Observable.fromCallable(new a(this, r0)).subscribeOn(Schedulers.io()).flatMap(b.a).subscribe(new c(this));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/shopping/new_cart/viewmodel/CartViewModel$h", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class h extends TypeToken<Map<String, Object>> {
        public h() {
        }
    }

    static {
        Companion = new a();
    }

    private final CartSliceCustomWidgetAdapterComponent getCartSliceCustomWidgetAdapterComponent() {
        return (CartSliceCustomWidgetAdapterComponent) this.cartSliceCustomWidgetAdapterComponent$delegate.getValue();
    }

    public final vf3.a getMultiUpdateImpl() {
        return (vf3.a) this.multiUpdateImpl$delegate.getValue();
    }

    public final void onDestroy() {
    }

    private final String getCartResourceExposeRecords() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(((IMarketingServiceV2) ServiceManager.get().getService(IMarketingServiceV2.class)).a());     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        return (String) r1;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private final Map<String, Object> getCommonTrackerParams() {
        CartObjectContainer r0 = this.objectContainer;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L5:
        CartParams r1 = r0.e.c;
        Pair[] r2 = new Pair[8];
        r2[0] = TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        r2[1] = TuplesKt.to("area_type", "104");
        r2[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_cart_page");
        if (r1 == null) goto L9;
        String r3 = r1.getNewSourceType();
        if (r3 == null) goto L9;
    L10:
        r2[3] = TuplesKt.to("new_source_type", r3);
        if (r1 == null) goto L14;
        String r4 = r1.getHistoryPath();
        if (r4 == null) goto L14;
    L15:
        r2[4] = TuplesKt.to("previous_page", r4);
        CartSliceCustomWidgetAdapterComponent r5 = getCartSliceCustomWidgetAdapterComponent();
        if (r5 == null) goto L19;
        String r6 = r5.c;
        if (r6 == null) goto L19;
    L20:
        r2[5] = TuplesKt.to("top_tab_name", r6);
        CartObjectContainer r7 = this.objectContainer;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L23:
        String r8 = r7.e.m;
        if (r8 != null) goto L26;
        r8 = "none";
    L26:
        r2[6] = TuplesKt.to("session_id", r8);
        CartObjectContainer r9 = this.objectContainer;
        if (r9 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L29:
        r2[7] = TuplesKt.to("is_split_screen", Integer.valueOf(k.q(Boolean.valueOf(r9.e.p))));
        return MapsKt.mapOf(r2);
    L19:
        r6 = "MAIN";
    L14:
        r4 = "";
    L9:
        r3 = "local_test";
        goto L10
    }

    private final boolean isInSplitScreen() {
        int r0 = com.bytedance.android.shopping.new_cart.utils.c.a;
        CartObjectContainer r1 = this.objectContainer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L5:
        CartParams r2 = r1.e.c;
        if (r2 == null) goto L8;
        String r3 = r2.getSplitActivityScene();
    L10:
        return com.bytedance.android.shopping.new_cart.utils.c.a(r3);
    L8:
        r3 = null;
        goto L10
    }

    public CartState defaultState() {
        return new CartState(0);
    }

    public CartViewModel() {
        this.trackerImpl = new bg3.a();
        MutableLiveData<com.bytedance.android.shopping.new_cart.viewmodel.d> r0 = new MutableLiveData();
        this._onQueryStartLiveData = r0;
        this.onQueryStartLiveData = r0;
        MutableLiveData<com.bytedance.android.shopping.new_cart.viewmodel.c> r1 = new MutableLiveData();
        this._onQueryEndLiveData = r1;
        this.onQueryEndLiveData = r1;
        this.multiUpdateImpl$delegate = LazyKt.lazy(new CartViewModel$multiUpdateImpl$2(this));
        this.cartSliceCustomWidgetAdapterComponent$delegate = LazyKt.lazy(new CartViewModel$cartSliceCustomWidgetAdapterComponent$2(this));
    }

    public final com.bytedance.android.shopping.new_cart.yata.customdata.a getCustomDataCenter() {
        return this.customDataCenter;
    }

    public final LiveData<com.bytedance.android.shopping.new_cart.viewmodel.c> getOnQueryEndLiveData() {
        return this.onQueryEndLiveData;
    }

    public final LiveData<com.bytedance.android.shopping.new_cart.viewmodel.d> getOnQueryStartLiveData() {
        return this.onQueryStartLiveData;
    }

    /* JADX INFO: renamed from: defaultState, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ State m1776defaultState() {
        return defaultState();
    }

    public static final /* synthetic */ String access$getCartResourceExposeRecords(CartViewModel r0) {
        return r0.getCartResourceExposeRecords();
    }

    public static final /* synthetic */ CartObjectContainer access$getObjectContainer$p(CartViewModel r1) {
        CartObjectContainer r2 = r1.objectContainer;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L5:
        return r2;
    }

    public static final /* synthetic */ MutableLiveData access$get_onQueryEndLiveData$p(CartViewModel r0) {
        return r0._onQueryEndLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_onQueryStartLiveData$p(CartViewModel r0) {
        return r0._onQueryStartLiveData;
    }

    public static final /* synthetic */ boolean access$isInSplitScreen$p(CartViewModel r0) {
        return r0.isInSplitScreen();
    }

    private final Map<String, Object> toMutableStringKeyMapOrNull(Object r4) {
        boolean r0 = r4 instanceof Map;
        Object r1 = null;
        if (r0 == false) goto L9;
        if (r0 == true) goto L7;
        r4 = null;
    L7:
        return (Map) r4;
    L9:
        if ((r4 instanceof String) == true) goto L11;
        Object r2 = null;
    L12:
        String r3 = (String) r2;
        if (r3 == null) goto L34;
    L22:
        if (r3 != null) goto L36;
        return null;
    L36:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L26
        Object r6 = Result.constructor-impl((Map) u0.c().fromJson(r3, new h().getType()));     // Catch: Throwable -> L26
    L29:
        if (Result.isFailure-impl(r6) == true) goto L33;
        r1 = r6;
    L33:
        return (Map) r1;
    L26:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L34:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L16
        Object r9 = Result.constructor-impl(u0.c().toJson(r4));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r9) == false) goto L21;
        r9 = null;
    L21:
        r3 = (String) r9;
    L16:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L11:
        r2 = r4;
        goto L12
    }

    public final void changeFps(final int r2) {
        if (ECAppInfoService.e.i() == false) goto L6;
        withState(new AnonymousClass1(this, r2));
        return;
    }

    public final void onCreate(CartObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.objectContainer = r2;
    }

    public final void queryForCoupon(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        com.bytedance.android.shopping.new_cart.utils.a.c.d("queryForCoupon", new g(this, r3));
    }

    public final void setCustomDataCenter(com.bytedance.android.shopping.new_cart.yata.customdata.a r1) {
        this.customDataCenter = r1;
    }

    public final boolean updateExtraParam(Map<String, ? extends Object> r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<String, ? extends Object>> r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L12;
        Map.Entry<String, ? extends Object> r0 = r6.next();
        CartObjectContainer r1 = this.objectContainer;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L11:
        com.bytedance.android.shopping.new_cart.container.b r2 = r1.e;
        String r3 = r0.getKey();
        Object r4 = r0.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "key");
        r2.b.put(r3, r4);
        goto L7
    L12:
        return true;
    }

    public final void updateHasMore(final boolean r2) {
        withState(new C02831(this, r2));
    }

    public static final /* synthetic */ void access$setObjectContainer$p(CartViewModel r0, CartObjectContainer r1) {
        r0.objectContainer = r1;
    }

    public static final /* synthetic */ void access$setState(CartViewModel r0, Function1 r1) {
        r0.setState(r1);
    }

    public static final /* synthetic */ Map access$toMutableStringKeyMapOrNull(CartViewModel r0, Object r1) {
        return r0.toMutableStringKeyMapOrNull(r1);
    }

    private final void onGetQueryErr(Throwable r3, @QueryScene String r4, long r5) {
        vf3.a r0 = getMultiUpdateImpl();
        if (r0 == null) goto L22;
        boolean r6 = true;
        if (r0.p(r5, null) != true) goto L22;
        bg3.a r7 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.f(new f(this, r4));
        String r8 = r3.getMessage();
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        if (r8.length() == 0) goto L14;
        r6 = false;
    L14:
        if (r6 == false) goto L16;
        EnsureManager.ensureNotReachHere(r3);
        r8 = com.bytedance.android.shopping.new_cart.utils.g.a(r3);
    L16:
        StringBuilder r9 = new StringBuilder();
        r9.append(r8);
        r9.append("; cause: ");
        Throwable r10 = r3.getCause();
        if (r10 == null) goto L19;
        String r11 = r10.getMessage();
    L20:
        r9.append(r11);
        com.bytedance.android.shopping.new_cart.utils.a.j("PREFETCH-ON-Error", r9.toString(), null, 12);
        return;
    L19:
        r11 = null;
    L22:
        bg3.a r12 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.g(this, "onGetQueryErr_reject", r3.getMessage(), MapsKt.emptyMap());
    }

    public final void doEventAction(String r4, Map<String, ? extends Object> r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, "params");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(getCommonTrackerParams());
        r0.putAll(r5);
        bg3.a r7 = this.trackerImpl;
        CartObjectContainer r1 = this.objectContainer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L5:
        r7.a(r4, r0, r1.e.j, r6);
    }

    public final void doQuery(boolean r8, @QueryScene String r9, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r9, "queryScene");
        bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.f(new c(this, r9, r8));
        vf3.a r11 = getMultiUpdateImpl();
        if (r11 == null) goto L9;
        long r1 = r11.o();
        CartRepository r12 = CartRepository.INSTANCE;
        CartObjectContainer r2 = this.objectContainer;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L7:
        r12.query(r2, r9, r1).subscribeOn(Schedulers.newThread()).subscribe(new b(r1, this, r9, r10));
        return;
    }

    public static final /* synthetic */ void access$onGetQueryErr(CartViewModel r0, Throwable r1, String r2, long r3) {
        r0.onGetQueryErr(r1, r2, r3);
    }

    private final void onGetQuery(com.bytedance.kmp.ec.yata.common.protocol.data.e r2, @QueryScene String r3, long r4, Function0<Unit> r6) {
        vf3.a r0 = getMultiUpdateImpl();
        if (r0 != null) goto L5;
    L11:
        dm.a.a(VMTAG).i("onGetQuery reject");
        return;
    L5:
        if (r0.p(r4, r2) != true) goto L11;
        bg3.a r5 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(this, "refreshProtocol", new d(this, r2, r3), null);
        com.bytedance.android.shopping.new_cart.utils.a.f(new e(this, r3, r2));
        if (r6 == null) goto L13;
        Unit r7 = (Unit) r6.invoke();
        return;
    }

    public static final /* synthetic */ void access$onGetQuery(CartViewModel r0, com.bytedance.kmp.ec.yata.common.protocol.data.e r1, String r2, long r3, Function0 r5) {
        r0.onGetQuery(r1, r2, r3, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void doEventAction$default(CartViewModel r0, String r1, Map r2, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = MapsKt.emptyMap();
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        r0.doEventAction(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void doQuery$default(CartViewModel r0, boolean r1, String r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.doQuery(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onGetQuery$default(CartViewModel r6, com.bytedance.kmp.ec.yata.common.protocol.data.e r7, String r8, long r9, Function0 r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r11 = null;
    L5:
        r6.onGetQuery(r7, r8, r9, r11);
    }
}
