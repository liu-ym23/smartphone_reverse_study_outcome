package com.bytedance.ee.bear.wikiv2.home2.model;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ?2\u00020\u0001:\u0002>?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u001bJ\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u001bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006J\b\u0010 \u001a\u0004\u0018\u00010\u0006J\u0006\u0010!\u001a\u00020\u000eJ\u0010\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\u0016H\u0002J\u0006\u0010'\u001a\u00020\u0016J\u0006\u0010(\u001a\u00020\u0016J\u000e\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020.JG\u0010/\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%2\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001012%\b\u0002\u00102\u001a\u001f\u0012\u0013\u0012\u001104¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0016\u0018\u000103JG\u00108\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%2\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001012%\b\u0002\u00102\u001a\u001f\u0012\u0013\u0012\u001104¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0016\u0018\u000103J\u001a\u00109\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\u0006\u0010:\u001a\u00020\u001eH\u0002J\u001a\u0010;\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010#2\u0006\u0010:\u001a\u00020\u001eH\u0002J\b\u0010=\u001a\u00020\u0016H\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006@"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiHomeViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "topWikiSpaces", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceUIList;", "recentWikiSpaces", "Lcom/bytedance/ee/util/Result;", "wikiHomeRepo", "Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiHomeRepository;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "filterInfo", "Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceFilterInfo;", "accountChangeCallback", "Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiHomeViewModel$AccountChangeCallbackImpl;", "getAccountChangeCallback", "()Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiHomeViewModel$AccountChangeCallbackImpl;", "accountChangeCallback$delegate", "Lkotlin/Lazy;", "init", "", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "registerListener", "getTopWikiSpaces", "Landroidx/lifecycle/LiveData;", "getRecentWikiSpaces", "isOriginCache", "", "getTopWikiSpaceList", "getRecentWikiSpaceList", "getFilterInfo", "getWikiSpace", "Lcom/bytedance/ee/bear/wikiv2/home/api/SpaceBean;", "spaceId", "", "firstRender", "refresh", "loadMoreRecent", "loadMoreStar", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "sortAndFilter", "filter", "Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceFilter;", "starWikiSpace", "onSuccess", "Lkotlin/Function0;", "onFailure", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "t", "unStarWikiSpace", "setRecentSpaceStar", "isStar", "setTopSpaceStar", "wikiSpace", "onCleared", "AccountChangeCallbackImpl", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiHomeViewModel extends ViewModel {
    public static final b Companion = null;
    private static final String TAG = "WikiHomeViewModel";
    private final Lazy accountChangeCallback$delegate;
    private final CompositeDisposable disposable;
    private WikiSpaceFilterInfo filterInfo;
    private final MutableLiveData<cu5.b<com.bytedance.ee.bear.wikiv2.home2.model.l>> recentWikiSpaces;
    private final MutableLiveData<com.bytedance.ee.bear.wikiv2.home2.model.l> topWikiSpaces;
    private com.bytedance.ee.bear.wikiv2.home2.model.a wikiHomeRepo;

    public static final class a implements com.bytedance.ee.bear.contract.b {
        public WeakReference<WikiHomeViewModel> a;
        public AccountService.Account b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.home2.model.WikiHomeViewModel$a$a, reason: collision with other inner class name */
        public static final class RunnableC0203a implements Runnable {
            public final /* synthetic */ AccountService.Account a;
            public final /* synthetic */ a b;

            public final void a() {
                AccountService.Account r0 = this.a;
                if (r0 != null) goto L5;
                return;
            L5:
                WeakReference<WikiHomeViewModel> r1 = this.b.a;
                if (r1 == null) goto L17;
                WikiHomeViewModel r2 = r1.get();
                if (r2 == null) goto L18;
                AccountService.Account r3 = this.b.b;
                if (r3 != null) goto L13;
            L15:
                this.b.b = r0;
                return;
            L13:
                if (TextUtils.equals(r3.uid, r0.uid) == true) goto L15;
                tt5.a.h(WikiHomeViewModel.TAG, "onAccountChange.");
                WikiHomeViewModel.access$getTopWikiSpaces$p(r2).setValue(new com.bytedance.ee.bear.wikiv2.home2.model.l(CollectionsKt.emptyList()));
                WikiHomeViewModel.access$getRecentWikiSpaces$p(r2).setValue(new cu5.b.c(new com.bytedance.ee.bear.wikiv2.home2.model.l(CollectionsKt.emptyList())));
                WikiHomeViewModel.access$firstRender(r2);
                goto L15
            L18:
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

            public RunnableC0203a(AccountService.Account r1, a r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public a(WikiHomeViewModel r2) {
            Intrinsics.checkNotNullParameter(r2, "viewModel");
            this.a = new WeakReference(r2);
        }

        public final void a(AccountService.Account r2) {
            com.bytedance.ee.util.ui.m.a(new RunnableC0203a(r2, this));
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ WikiHomeViewModel a;

        public c(WikiHomeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            WikiSpacesResp r5 = (WikiSpacesResp) r4;
            tt5.a.h(WikiHomeViewModel.TAG, "getFirstRenderStarSpace ok, size: " + r5.a() + ", origin: " + r5.e.name());
            MutableLiveData r0 = WikiHomeViewModel.access$getTopWikiSpaces$p(this.a);
            Intrinsics.checkNotNull(r5);
            r0.setValue(new com.bytedance.ee.bear.wikiv2.home2.model.l(r5, null));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ WikiHomeViewModel a;

        public d(WikiHomeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.e(WikiHomeViewModel.TAG, "getFirstRenderStarSpace err", (Throwable) r4, false);
            if (this.a.getTopWikiSpaceList() != null) goto L6;
            WikiHomeViewModel.access$getTopWikiSpaces$p(this.a).setValue(new com.bytedance.ee.bear.wikiv2.home2.model.l(CollectionsKt.emptyList()));
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ WikiHomeViewModel a;

        public e(WikiHomeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            wwc.c r4 = (wwc.c) r3;
            WikiHomeViewModel.access$getRecentWikiSpaces$p(this.a).setValue(new cu5.b.b(null));
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ WikiHomeViewModel a;

        public f(WikiHomeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            WikiSpacesResp r6 = (WikiSpacesResp) r5;
            tt5.a.h(WikiHomeViewModel.TAG, "getFirstRenderRecentSpace ok, size: " + r6.a() + ", origin: " + r6.e.name());
            WikiHomeViewModel.access$setFilterInfo$p(this.a, r6.a);
            MutableLiveData r0 = WikiHomeViewModel.access$getRecentWikiSpaces$p(this.a);
            Intrinsics.checkNotNull(r6);
            r0.setValue(new cu5.b.c(new com.bytedance.ee.bear.wikiv2.home2.model.l(r6, null)));
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ WikiHomeViewModel a;

        public g(WikiHomeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e(WikiHomeViewModel.TAG, "getFirstRenderRecentSpace err", r5, false);
            if (this.a.getRecentWikiSpaceList() != null) goto L6;
            MutableLiveData r0 = WikiHomeViewModel.access$getRecentWikiSpaces$p(this.a);
            Intrinsics.checkNotNull(r5);
            r0.setValue(new cu5.b.a(r5, null));
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ WikiHomeViewModel a;

        public h(WikiHomeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            WikiSpacesResp r4 = (WikiSpacesResp) r3;
            tt5.a.h(WikiHomeViewModel.TAG, "getMoreRecentSpace ok. size: " + r4.a());
            com.bytedance.ee.bear.wikiv2.home2.model.l r0 = this.a.getRecentWikiSpaceList();
            if (r0 == null) goto L7;
            Intrinsics.checkNotNull(r4);
            WikiHomeViewModel.access$getRecentWikiSpaces$p(this.a).setValue(new cu5.b.c(r0.a(r4)));
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ WikiHomeViewModel a;

        public i(WikiHomeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.e(WikiHomeViewModel.TAG, "getMoreRecentSpace err", (Throwable) r4, false);
            WikiHomeViewModel.access$getRecentWikiSpaces$p(this.a).setValue(WikiHomeViewModel.access$getRecentWikiSpaces$p(this.a).getValue());
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ WikiHomeViewModel a;

        public j(WikiHomeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            WikiSpacesResp r4 = (WikiSpacesResp) r3;
            tt5.a.h(WikiHomeViewModel.TAG, "getMoreStarSpace ok. size: " + r4.a());
            com.bytedance.ee.bear.wikiv2.home2.model.l r0 = this.a.getTopWikiSpaceList();
            if (r0 == null) goto L7;
            Intrinsics.checkNotNull(r4);
            WikiHomeViewModel.access$getTopWikiSpaces$p(this.a).setValue(r0.a(r4));
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ WikiHomeViewModel a;

        public k(WikiHomeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.e(WikiHomeViewModel.TAG, "getMoreStarSpace err", (Throwable) r4, false);
            WikiHomeViewModel.access$getTopWikiSpaces$p(this.a).setValue(WikiHomeViewModel.access$getTopWikiSpaces$p(this.a).getValue());
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ WikiHomeViewModel a;

        public l(WikiHomeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            WikiSpacesResp r5 = (WikiSpacesResp) r4;
            tt5.a.h(WikiHomeViewModel.TAG, "getStarSpace ok, size: " + r5.a() + ", origin: " + r5.e.name());
            MutableLiveData r0 = WikiHomeViewModel.access$getTopWikiSpaces$p(this.a);
            Intrinsics.checkNotNull(r5);
            r0.setValue(new com.bytedance.ee.bear.wikiv2.home2.model.l(r5, null));
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ WikiHomeViewModel a;

        public m(WikiHomeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.e(WikiHomeViewModel.TAG, "getStarSpace err", (Throwable) r4, false);
            if (this.a.getTopWikiSpaceList() != null) goto L6;
            WikiHomeViewModel.access$getTopWikiSpaces$p(this.a).setValue(new com.bytedance.ee.bear.wikiv2.home2.model.l(CollectionsKt.emptyList()));
            return;
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ WikiHomeViewModel a;

        public n(WikiHomeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            WikiSpacesResp r6 = (WikiSpacesResp) r5;
            tt5.a.h(WikiHomeViewModel.TAG, "getRecentSpace ok, size: " + r6.a() + ", origin: " + r6.e.name());
            WikiHomeViewModel.access$setFilterInfo$p(this.a, r6.a);
            MutableLiveData r0 = WikiHomeViewModel.access$getRecentWikiSpaces$p(this.a);
            Intrinsics.checkNotNull(r6);
            r0.setValue(new cu5.b.c(new com.bytedance.ee.bear.wikiv2.home2.model.l(r6, null)));
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ WikiHomeViewModel a;

        public o(WikiHomeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.e(WikiHomeViewModel.TAG, "getRecentSpace err", (Throwable) r4, false);
            WikiHomeViewModel.access$getRecentWikiSpaces$p(this.a).setValue(WikiHomeViewModel.access$getRecentWikiSpaces$p(this.a).getValue());
        }
    }

    public static final class p<T, R> implements Function {
        public final /* synthetic */ WikiHomeViewModel a;

        public p(WikiHomeViewModel r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Boolean) r2, "it");
            com.bytedance.ee.bear.wikiv2.home2.model.a r3 = WikiHomeViewModel.access$getWikiHomeRepo$p(this.a);
            if (r3 != null) goto L7;
            return null;
        L7:
            return r3.g();
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ WikiHomeViewModel a;

        public q(WikiHomeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            WikiSpacesResp r6 = (WikiSpacesResp) r5;
            tt5.a.h(WikiHomeViewModel.TAG, "sortAndFilter ok, size: " + r6.a() + ", origin: " + r6.e.name());
            if (r6.e != WikiSpacesResp.Origin.Cache) goto L5;
            WikiSpaceFilterInfo r0 = WikiHomeViewModel.access$getFilterInfo$p(this.a);
        L6:
            WikiHomeViewModel.access$setFilterInfo$p(this.a, r0);
            MutableLiveData r1 = WikiHomeViewModel.access$getRecentWikiSpaces$p(this.a);
            Intrinsics.checkNotNull(r6);
            r1.setValue(new cu5.b.c(new com.bytedance.ee.bear.wikiv2.home2.model.l(r6, r0)));
            return;
        L5:
            r0 = r6.a;
            goto L6
        }
    }

    public static final class r<T> implements Consumer {
        public static final r<T> a = null;

        static {
            a = new r();
        }

        public r() {
        }

        public final void accept(Object r4) {
            tt5.a.e(WikiHomeViewModel.TAG, "sortAndFilter err", (Throwable) r4, false);
        }
    }

    public static final class s<T> implements Consumer {
        public final /* synthetic */ WikiHomeViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function0<Unit> c;

        public s(WikiHomeViewModel r1, String r2, Function0<Unit> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            SpaceBean r5 = WikiHomeViewModel.access$setRecentSpaceStar(this.a, this.b, true);
            WikiHomeViewModel.access$setTopSpaceStar(this.a, r5, true);
            Function0<Unit> r6 = this.c;
            if (r6 == null) goto L6;
            r6.invoke();
            return;
        }
    }

    public static final class t<T> implements Consumer {
        public final /* synthetic */ Function1<Throwable, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public t(Function1<? super Throwable, Unit> r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            tt5.a.i(WikiHomeViewModel.TAG, "starWikiSpace err", r4);
            Function1<Throwable, Unit> r0 = this.a;
            if (r0 == null) goto L6;
            Intrinsics.checkNotNull(r4);
            r0.invoke(r4);
            return;
        }
    }

    public static final class u<T> implements Consumer {
        public final /* synthetic */ WikiHomeViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function0<Unit> c;

        public u(WikiHomeViewModel r1, String r2, Function0<Unit> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            SpaceBean r5 = WikiHomeViewModel.access$setRecentSpaceStar(this.a, this.b, false);
            WikiHomeViewModel.access$setTopSpaceStar(this.a, r5, false);
            Function0<Unit> r6 = this.c;
            if (r6 == null) goto L6;
            r6.invoke();
            return;
        }
    }

    public static final class v<T> implements Consumer {
        public final /* synthetic */ Function1<Throwable, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public v(Function1<? super Throwable, Unit> r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            tt5.a.i(WikiHomeViewModel.TAG, "unStarWikiSpace err", r4);
            Function1<Throwable, Unit> r0 = this.a;
            if (r0 == null) goto L6;
            Intrinsics.checkNotNull(r4);
            r0.invoke(r4);
            return;
        }
    }

    static {
        Companion = new b();
    }

    private final void firstRender() {
        tt5.a.h(TAG, "firstRender.");
        com.bytedance.ee.bear.wikiv2.home2.model.a r0 = this.wikiHomeRepo;
        if (r0 == null) goto L9;
        Flowable<WikiSpacesResp> r1 = r0.f();
        if (r1 == null) goto L9;
        Disposable r2 = r1.subscribe(new c(this), new d(this));
        if (r2 == null) goto L9;
        up5.g.a(r2, this.disposable);
    L9:
        com.bytedance.ee.bear.wikiv2.home2.model.a r3 = this.wikiHomeRepo;
        if (r3 == null) goto L19;
        Flowable<WikiSpacesResp> r4 = r3.g();
        if (r4 == null) goto L20;
        Flowable r5 = r4.doOnSubscribe(new e(this));
        if (r5 == null) goto L21;
        Disposable r6 = r5.subscribe(new f(this), new g(this));
        if (r6 == null) goto L22;
        up5.g.a(r6, this.disposable);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    private final a getAccountChangeCallback() {
        return (a) this.accountChangeCallback$delegate.getValue();
    }

    public final WikiSpaceFilterInfo getFilterInfo() {
        WikiSpaceFilterInfo r0 = this.filterInfo;
        if (r0 != null) goto L6;
        WikiSpaceFilterInfo.Companion.getClass();
        return WikiSpaceFilterInfo.access$getNoFilterInfo$cp();
    L6:
        return r0;
    }

    public final com.bytedance.ee.bear.wikiv2.home2.model.l getRecentWikiSpaceList() {
        cu5.b.c r0 = (cu5.b) this.recentWikiSpaces.getValue();
        if (r0 != null) goto L5;
    L7:
        return null;
    L5:
        if ((r0 instanceof cu5.b.c) == false) goto L7;
        return (com.bytedance.ee.bear.wikiv2.home2.model.l) r0.a;
    }

    public final com.bytedance.ee.bear.wikiv2.home2.model.l getTopWikiSpaceList() {
        return (com.bytedance.ee.bear.wikiv2.home2.model.l) this.topWikiSpaces.getValue();
    }

    public final void loadMoreRecent() {
        tt5.a.h(TAG, "loadMoreRecent.");
        com.bytedance.ee.bear.wikiv2.home2.model.a r0 = this.wikiHomeRepo;
        if (r0 == null) goto L10;
        Flowable<WikiSpacesResp> r1 = r0.b();
        if (r1 == null) goto L11;
        Disposable r2 = r1.subscribe(new h(this), new i(this));
        if (r2 == null) goto L12;
        up5.g.a(r2, this.disposable);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void refresh() {
        tt5.a.h(TAG, "refresh.");
        com.bytedance.ee.bear.wikiv2.home2.model.a r0 = this.wikiHomeRepo;
        if (r0 == null) goto L9;
        Flowable<WikiSpacesResp> r1 = r0.c();
        if (r1 == null) goto L9;
        Disposable r2 = r1.subscribe(new l(this), new m(this));
        if (r2 == null) goto L9;
        up5.g.a(r2, this.disposable);
    L9:
        com.bytedance.ee.bear.wikiv2.home2.model.a r3 = this.wikiHomeRepo;
        if (r3 == null) goto L17;
        Flowable<WikiSpacesResp> r4 = r3.a();
        if (r4 == null) goto L18;
        Disposable r5 = r4.subscribe(new n(this), new o(this));
        if (r5 == null) goto L19;
        up5.g.a(r5, this.disposable);
        return;
    L19:
        return;
    L18:
        return;
    }

    public WikiHomeViewModel() {
        this.topWikiSpaces = new MutableLiveData();
        this.recentWikiSpaces = new MutableLiveData();
        this.disposable = new CompositeDisposable();
        this.accountChangeCallback$delegate = LazyKt.lazy(new WikiHomeViewModel$accountChangeCallback$2(this));
    }

    private final void registerListener() {
        a r0 = getAccountChangeCallback();
        r0.getClass();
        ((h0) org.koin.java.a.c(h0.class, null, null, 6)).Pe(r0);
    }

    public final boolean isOriginCache() {
        com.bytedance.ee.bear.wikiv2.home2.model.l r0 = getTopWikiSpaceList();
        WikiSpacesResp.Origin r1 = null;
        if (r0 == null) goto L5;
        WikiSpacesResp.Origin r2 = r0.c;
    L6:
        WikiSpacesResp.Origin r3 = WikiSpacesResp.Origin.Network;
        if (r2 != r3) goto L14;
        com.bytedance.ee.bear.wikiv2.home2.model.l r4 = getRecentWikiSpaceList();
        if (r4 == null) goto L11;
        r1 = r4.c;
    L11:
        if (r1 != r3) goto L14;
        return false;
    L14:
        return true;
    L5:
        r2 = null;
        goto L6
    }

    public void onCleared() {
        super.onCleared();
        tt5.a.h(TAG, "onCleared");
        this.disposable.clear();
        a r0 = getAccountChangeCallback();
        r0.a = null;
        ((h0) org.koin.java.a.c(h0.class, null, null, 6)).qc(r0);
    }

    public final LiveData<cu5.b<com.bytedance.ee.bear.wikiv2.home2.model.l>> getRecentWikiSpaces() {
        return this.recentWikiSpaces;
    }

    public final LiveData<com.bytedance.ee.bear.wikiv2.home2.model.l> getTopWikiSpaces() {
        return this.topWikiSpaces;
    }

    public static final /* synthetic */ void access$firstRender(WikiHomeViewModel r0) {
        r0.firstRender();
    }

    public static final /* synthetic */ WikiSpaceFilterInfo access$getFilterInfo$p(WikiHomeViewModel r0) {
        return r0.filterInfo;
    }

    public static final /* synthetic */ MutableLiveData access$getRecentWikiSpaces$p(WikiHomeViewModel r0) {
        return r0.recentWikiSpaces;
    }

    public static final /* synthetic */ MutableLiveData access$getTopWikiSpaces$p(WikiHomeViewModel r0) {
        return r0.topWikiSpaces;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.wikiv2.home2.model.a access$getWikiHomeRepo$p(WikiHomeViewModel r0) {
        return r0.wikiHomeRepo;
    }

    public final SpaceBean getWikiSpace(String r2) {
        Intrinsics.checkNotNullParameter(r2, "spaceId");
        com.bytedance.ee.bear.wikiv2.home2.model.l r0 = getTopWikiSpaceList();
        if (r0 == null) goto L6;
        SpaceBean r1 = r0.c(r2);
        if (r1 == null) goto L6;
        return r1;
    L6:
        com.bytedance.ee.bear.wikiv2.home2.model.l r3 = getRecentWikiSpaceList();
        if (r3 != null) goto L12;
        return null;
    L12:
        return r3.c(r2);
    }

    public final void init(ce5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        tt5.a.h(TAG, "onInit.");
        this.wikiHomeRepo = new WikiHomeRepositoryImpl(r3);
        firstRender();
        registerListener();
    }

    public final void loadMoreStar(NetService r3) {
        Intrinsics.checkNotNullParameter(r3, "netService");
        tt5.a.h(TAG, "loadMoreStar.");
        com.bytedance.ee.bear.wikiv2.home2.model.a r4 = this.wikiHomeRepo;
        if (r4 == null) goto L10;
        Flowable<WikiSpacesResp> r5 = r4.e();
        if (r5 == null) goto L11;
        Disposable r6 = r5.subscribe(new j(this), new k(this));
        if (r6 == null) goto L12;
        up5.g.a(r6, this.disposable);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void sortAndFilter(WikiSpaceFilter r3) {
        Intrinsics.checkNotNullParameter(r3, "filter");
        tt5.a.h(TAG, "sortAndFilter.");
        WikiSpaceFilterInfo r0 = this.filterInfo;
        if (r0 != null) goto L5;
    L7:
        com.bytedance.ee.bear.wikiv2.home2.model.a r1 = this.wikiHomeRepo;
        if (r1 == null) goto L17;
        Flowable<Boolean> r4 = r1.i(r3);
        if (r4 == null) goto L18;
        Flowable r5 = r4.flatMap(new p(this));
        if (r5 == null) goto L19;
        Disposable r6 = r5.subscribe(new q(this), r.a);
        if (r6 == null) goto L20;
        up5.g.a(r6, this.disposable);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if (r0.isSameFilterWith(r3) == false) goto L7;
    }

    public static final /* synthetic */ void access$setFilterInfo$p(WikiHomeViewModel r0, WikiSpaceFilterInfo r1) {
        r0.filterInfo = r1;
    }

    private final SpaceBean setRecentSpaceStar(String r9, boolean r10) {
        com.bytedance.ee.bear.wikiv2.home2.model.l r0 = getRecentWikiSpaceList();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.b(r9) == false) goto L27;
        Intrinsics.checkNotNullParameter(r9, "spaceId");
        if (r0.b(r9) == false) goto L17;
        ArrayList r3 = new ArrayList();
        Iterator<SpaceBean> r1 = r0.a.iterator();
    L11:
        if (r1.hasNext() == false) goto L16;
        SpaceBean r2 = r1.next();
        if (Intrinsics.areEqual(r2.space_id, r9) == true) goto L14;
        r3.add(r2);
        goto L11
    L14:
        Intrinsics.checkNotNullParameter(r2, "<this>");
        SpaceBean r4 = new SpaceBean();
        r4.space_id = r2.space_id;
        r4.space_name = r2.space_name;
        r4.description = r2.description;
        r4.space_icon = r2.space_icon;
        r4.tenant_id = r2.tenant_id;
        r4.space_cover = r2.space_cover;
        r4.root_token = r2.root_token;
        r4.space_type = r2.space_type;
        r4.wiki_scope = r2.wiki_scope;
        r4.is_star = r10;
        r4.browse_time = r2.browse_time;
        r4.open_sharing = r2.open_sharing;
        r4.display_tag = r2.display_tag;
        r3.add(r4);
        goto L11
    L16:
        r0 = new com.bytedance.ee.bear.wikiv2.home2.model.l(r3, r0.b, r0.c, r0.d, r0.e);
    L17:
        this.recentWikiSpaces.setValue(new cu5.b.c(r0));
        return r0.c(r9);
    L27:
        return null;
    }

    private final void setTopSpaceStar(SpaceBean r8, boolean r9) {
        if (r8 == null) goto L29;
        com.bytedance.ee.bear.wikiv2.home2.model.l r0 = getTopWikiSpaceList();
        if (r0 == null) goto L30;
        if (r9 == false) goto L11;
        if (r0.b(r8.space_id) == true) goto L11;
        Intrinsics.checkNotNullParameter(r8, "wikiSpace");
        ArrayList r2 = new ArrayList(r0.a);
        ListProtector.add(r2, 0, r8);
        com.bytedance.ee.bear.wikiv2.home2.model.l r10 = new com.bytedance.ee.bear.wikiv2.home2.model.l(r2, r0.b, r0.c, r0.d, r0.e);
    L9:
        r0 = r10;
    L22:
        this.topWikiSpaces.setValue(r0);
        return;
    L11:
        if (r0.b(r8.space_id) == false) goto L22;
        String r11 = r8.space_id;
        Intrinsics.checkNotNullParameter(r11, "spaceId");
        if (r0.b(r11) == false) goto L22;
        ArrayList r3 = new ArrayList();
        Iterator<SpaceBean> r12 = r0.a.iterator();
    L17:
        if (r12.hasNext() == false) goto L21;
        SpaceBean r1 = r12.next();
        if (Intrinsics.areEqual(r1.space_id, r11) == true) goto L17;
        r3.add(r1);
        goto L17
    L21:
        r10 = new com.bytedance.ee.bear.wikiv2.home2.model.l(r3, r0.b, r0.c, r0.d, r0.e);
        goto L9
    L30:
        return;
    }

    public static final /* synthetic */ SpaceBean access$setRecentSpaceStar(WikiHomeViewModel r0, String r1, boolean r2) {
        return r0.setRecentSpaceStar(r1, r2);
    }

    public static final /* synthetic */ void access$setTopSpaceStar(WikiHomeViewModel r0, SpaceBean r1, boolean r2) {
        r0.setTopSpaceStar(r1, r2);
    }

    public final void starWikiSpace(String r3, Function0<Unit> r4, Function1<? super Throwable, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "spaceId");
        com.bytedance.ee.bear.wikiv2.home2.model.a r0 = this.wikiHomeRepo;
        if (r0 == null) goto L10;
        Flowable<Boolean> r1 = r0.h(r3);
        if (r1 == null) goto L11;
        Disposable r6 = r1.subscribe(new s(this, r3, r4), new t(r5));
        if (r6 == null) goto L12;
        up5.g.a(r6, this.disposable);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void unStarWikiSpace(String r3, Function0<Unit> r4, Function1<? super Throwable, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "spaceId");
        com.bytedance.ee.bear.wikiv2.home2.model.a r0 = this.wikiHomeRepo;
        if (r0 == null) goto L10;
        Flowable<Boolean> r1 = r0.d(r3);
        if (r1 == null) goto L11;
        Disposable r6 = r1.subscribe(new u(this, r3, r4), new v(r5));
        if (r6 == null) goto L12;
        up5.g.a(r6, this.disposable);
        return;
    L12:
        return;
    L11:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void starWikiSpace$default(WikiHomeViewModel r1, String r2, Function0 r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.starWikiSpace(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void unStarWikiSpace$default(WikiHomeViewModel r1, String r2, Function0 r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.unStarWikiSpace(r2, r3, r4);
    }
}
