package com.bytedance.android.shopping.api.mall.common.feed.help;

import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.r;
import com.bytedance.android.shopping.api.mall.model.BffBizInfo;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallGulPrefetch implements ECHybridNetworkTask.a {
    public static final Lazy h = null;
    public final Object a;
    public HomePageDTO b;
    public ECHybridNetworkVO c;
    public Function2<? super HomePageDTO, ? super ECHybridNetworkVO, Unit> d;
    public Function0<Unit> e;
    public r93.b f;
    public String g;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/feed/help/ECMallGulPrefetch$Companion$PrefetchState;", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface PrefetchState {
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/feed/help/ECMallGulPrefetch$Companion$a;", "", "", "switch", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "pageName", "Ljava/util/ArrayList;", "getPageName", "()Ljava/util/ArrayList;", "remainNumOfUseCache", "getRemainNumOfUseCache", "remainNumOfFirstUseCache", "getRemainNumOfFirstUseCache", "waitStrategy", "f", "fetchOnFirstScreen", "getFetchOnFirstScreen", "loadMoreOnlyByManual", "c", "removeUnusedCache", "d", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class a {

            @SerializedName("fetch_on_first_screen")
            private final Integer fetchOnFirstScreen;

            @SerializedName("load_more_only_by_manual")
            private final Integer loadMoreOnlyByManual;

            @SerializedName(PdpOpenThirdParam.KEY_PAGE_NAME)
            private final ArrayList<String> pageName;

            @SerializedName("remain_num_of_first_use_cache")
            private final Integer remainNumOfFirstUseCache;

            @SerializedName("remain_num_of_use_cache")
            private final Integer remainNumOfUseCache;

            @SerializedName("remove_unused_cache")
            private final Integer removeUnusedCache;

            /* JADX INFO: renamed from: switch, reason: not valid java name */
            @SerializedName("preload_switch")
            private final Integer f1switch;

            @SerializedName("wait_new_or_ues_old")
            private final Integer waitStrategy;

            public a() {
                this(null);
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof a) == false) goto L22;
                a r4 = (a) r3;
                if (Intrinsics.areEqual(this.f1switch, r4.f1switch) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.pageName, r4.pageName) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.remainNumOfUseCache, r4.remainNumOfUseCache) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.remainNumOfFirstUseCache, r4.remainNumOfFirstUseCache) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.waitStrategy, r4.waitStrategy) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.fetchOnFirstScreen, r4.fetchOnFirstScreen) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.loadMoreOnlyByManual, r4.loadMoreOnlyByManual) == true) goto L20;
                return false;
            L20:
                if (Intrinsics.areEqual(this.removeUnusedCache, r4.removeUnusedCache) == true) goto L34;
                return false;
            L34:
                return true;
            L22:
                return false;
            }

            public final int hashCode() {
                Integer r0 = this.f1switch;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                ArrayList<String> r4 = this.pageName;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                Integer r7 = this.remainNumOfUseCache;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                Integer r10 = this.remainNumOfFirstUseCache;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                Integer r13 = this.waitStrategy;
                if (r13 == null) goto L21;
                int r14 = r13.hashCode();
            L22:
                int r15 = (r12 + r14) * 31;
                Integer r16 = this.fetchOnFirstScreen;
                if (r16 == null) goto L25;
                int r17 = r16.hashCode();
            L26:
                int r18 = (r15 + r17) * 31;
                Integer r19 = this.loadMoreOnlyByManual;
                if (r19 == null) goto L29;
                int r20 = r19.hashCode();
            L30:
                int r21 = (r18 + r20) * 31;
                Integer r22 = this.removeUnusedCache;
                if (r22 == null) goto L34;
                r1 = r22.hashCode();
            L34:
                return r21 + r1;
            L29:
                r20 = 0;
                goto L30
            L25:
                r17 = 0;
                goto L26
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
            L13:
                r8 = 0;
                goto L14
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public final String toString() {
                return "GulPrefetchConfig(switch=" + this.f1switch + ", pageName=" + this.pageName + ", remainNumOfUseCache=" + this.remainNumOfUseCache + ", remainNumOfFirstUseCache=" + this.remainNumOfFirstUseCache + ", waitStrategy=" + this.waitStrategy + ", fetchOnFirstScreen=" + this.fetchOnFirstScreen + ", loadMoreOnlyByManual=" + this.loadMoreOnlyByManual + ", removeUnusedCache=" + this.removeUnusedCache + ")";
            }

            public final Integer c() {
                return this.loadMoreOnlyByManual;
            }

            public final Integer d() {
                return this.removeUnusedCache;
            }

            public final Integer e() {
                return this.f1switch;
            }

            public final Integer f() {
                return this.waitStrategy;
            }

            public a(Object r1) {
                this.f1switch = null;
                this.pageName = null;
                this.remainNumOfUseCache = null;
                this.remainNumOfFirstUseCache = null;
                this.waitStrategy = null;
                this.fetchOnFirstScreen = null;
                this.loadMoreOnlyByManual = null;
                this.removeUnusedCache = null;
            }

            public final boolean a(String r3) {
                if (r3 != null) goto L5;
                return false;
            L5:
                ArrayList<String> r1 = this.pageName;
                if (r1 != null) goto L8;
                return false;
            L8:
                if (r1.contains(r3) != true) goto L17;
                Integer r4 = this.fetchOnFirstScreen;
                if (r4 != null) goto L13;
                return false;
            L13:
                if (r4.intValue() != 1) goto L18;
                return true;
            L18:
                return false;
            L17:
                return false;
            }

            public final boolean b(String r3) {
                if (r3 != null) goto L5;
                return false;
            L5:
                ArrayList<String> r1 = this.pageName;
                if (r1 != null) goto L8;
                return false;
            L8:
                if (r1.contains(r3) != true) goto L12;
                return true;
            L12:
                return false;
            }

            public final Integer g(String r3) {
                if (r3 != null) goto L5;
                return null;
            L5:
                ArrayList<String> r1 = this.pageName;
                if (r1 != null) goto L8;
            L11:
                return null;
            L8:
                if (r1.contains(r3) != true) goto L11;
                return this.remainNumOfUseCache;
            }

            public final Integer h(String r3) {
                if (r3 != null) goto L5;
                return null;
            L5:
                ArrayList<String> r1 = this.pageName;
                if (r1 != null) goto L8;
            L11:
                return null;
            L8:
                if (r1.contains(r3) != true) goto L11;
                return this.remainNumOfFirstUseCache;
            }
        }

        public static a a() {
            return (a) ECMallGulPrefetch.h.getValue();
        }
    }

    public final void d(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "requestVO");
    }

    static {
        h = LazyKt.lazy(ECMallGulPrefetch$Companion$gulPrefetchConfig$2.INSTANCE);
    }

    public final void a() {
        Object r0 = this.a;
        monitor-enter(r0);
        this.g = "init";     // Catch: Throwable -> L7
        this.b = null;     // Catch: Throwable -> L7
        this.e = null;     // Catch: Throwable -> L7
        this.d = null;     // Catch: Throwable -> L7
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final r93.b b() {
        HomePageDTO r0 = this.b;
        if (r0 == null) goto L18;
        ArrayList r1 = new ArrayList();
        HomePageBffDTO r2 = r0.getBff();
        if (r2 == null) goto L17;
        BffBizInfo r3 = r2.getBizInfo();
        if (r3 == null) goto L17;
        List<String> r4 = r3.getFilters();
        if (r4 == null) goto L17;
        Iterator<T> r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L17;
        List r6 = StringsKt.split$default((String) r5.next(), new String[]{"_"}, false, 0, 6, null);
        if (r6.size() != 2) goto L12;
        r1.add(new r93.a(StringsKt.toIntOrNull((String) ListProtector.get(r6, 0)), (String) ListProtector.get(r6, 1)));
    L17:
        return new r93.b(r1);
    L18:
        return null;
    }

    public final void g() {
        Object r0 = this.a;
        monitor-enter(r0);
        this.g = "running";     // Catch: Throwable -> L7
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public ECMallGulPrefetch() {
        this.a = new Object();
        this.g = "init";
    }

    public final void c(String r8, final String r9, final ECHybridNetworkVO r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "apiKey");
        Intrinsics.checkNotNullParameter(r9, "result");
        Intrinsics.checkNotNullParameter(r10, "requestVO");
        ECHybridNetworkTask.a.a.c(r8, r9, r10);
        if ((!Intrinsics.areEqual(r8, "favorite_feed")) == false) goto L5;
        return;
    L5:
        Lazy r12 = ECMallLogUtil.a;
        r.b r13 = r.b.b;
        ECMallLogUtil.c(r13, "on result in gul prefetch, state is " + this.g);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L46
        final HomePageDTO r4 = (HomePageDTO) new Gson().fromJson(r9, HomePageDTO.class);     // Catch: Throwable -> L46
        if (r4 != null) goto L13;
        Function0<Unit> r14 = this.e;     // Catch: Throwable -> L46
        if (r14 == null) goto L11;
        Unit r15 = (Unit) r14.invoke();     // Catch: Throwable -> L46
    L11:
        a();     // Catch: Throwable -> L46
        return;
    L13:
        Object r1 = this.a;     // Catch: Throwable -> L46
        monitor-enter(r1);     // Catch: Throwable -> L46
        String r2 = this.g;     // Catch: Throwable -> L43
        int r3 = r2.hashCode();     // Catch: Throwable -> L43
        if (r3 == (-180585540)) goto L33;
        if (r3 == 3237136) goto L28;
        if (r3 == 301635111) goto L23;
    L40:
        this.b = r4;     // Catch: Throwable -> L43
        this.c = r10;     // Catch: Throwable -> L43
        this.g = "finish";     // Catch: Throwable -> L43
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L43
        monitor-exit(r1);     // Catch: Throwable -> L46
        return;
    L23:
        if (r2.equals("wait_result") == false) goto L40;
        ECMallLogUtil.c(r13, "success ballback is " + this.d);     // Catch: Throwable -> L43
        final Function2<? super HomePageDTO, ? super ECHybridNetworkVO, Unit> r5 = this.d;     // Catch: Throwable -> L43
        ECHybridExtensionsKt.g(new ECMallGulPrefetch$onResult$$inlined$runCatching$lambda$1(r5, this, r4, r9, r10));     // Catch: Throwable -> L43
        this.d = null;     // Catch: Throwable -> L43
        this.e = null;     // Catch: Throwable -> L43
        this.g = "init";     // Catch: Throwable -> L43
        monitor-exit(r1);     // Catch: Throwable -> L46
        return;
    L28:
        if (r2.equals("init") == false) goto L40;
        a();     // Catch: Throwable -> L43
        monitor-exit(r1);     // Catch: Throwable -> L46
        return;
    L33:
        if (r2.equals("invalid_second") == false) goto L40;
        Function0<Unit> r17 = this.e;     // Catch: Throwable -> L43
        if (r17 == null) goto L37;
        Unit r18 = (Unit) r17.invoke();     // Catch: Throwable -> L43
    L37:
        a();     // Catch: Throwable -> L43
        monitor-exit(r1);     // Catch: Throwable -> L46
        return;
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        Function0<Unit> r20 = this.e;
        if (r20 == null) goto L53;
        Unit r21 = (Unit) r20.invoke();
        return;
    }

    public final void e(String r1, Throwable r2, ECHybridNetworkVO r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r2, "t");
        Object r5 = this.a;
        monitor-enter(r5);
        this.g = "init";     // Catch: Throwable -> L10
        Function0<Unit> r6 = this.e;     // Catch: Throwable -> L10
        if (r6 == null) goto L7;
        Unit r7 = (Unit) r6.invoke();     // Catch: Throwable -> L10
    L7:
        this.e = null;     // Catch: Throwable -> L10
        this.d = null;     // Catch: Throwable -> L10
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r5);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void f(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "requestVO");
        ECHybridNetworkTask.a.a.b(r1, r2, r3);
    }
}
