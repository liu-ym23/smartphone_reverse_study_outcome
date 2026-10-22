package com.ss.android.ugc.aweme.search.dynamic.core.ability;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.lynx.tasm.LynxError;
import com.ss.android.ugc.aweme.search.dynamic.core.DynamicCardContext;
import com.ss.android.ugc.aweme.search.dynamic.core.data.DynamicData;
import com.ss.android.ugc.aweme.search.dynamic.core.monitor.DefaultPerformanceMonitor;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/ability/SearchAbilityDispatcher;", "Lcom/ss/android/ugc/aweme/search/dynamic/core/ability/ISearchDynamicAbility;", "<init>", "()V", "Companion", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class SearchAbilityDispatcher implements ISearchDynamicAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, ISearchDynamicAbility> f452651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IDynamicAbilityOwner f452652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f452653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f452654d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/ability/SearchAbilityDispatcher$Companion;", "", "()V", "JS_HANDLE_ABILITY", "", "TAG", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public final void k() {
        if (this.f452653c == true) goto L5;
        return;
    L5:
        j(SearchAbilityDispatcher$onDestroy$1.INSTANCE);
        this.f452653c = false;
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void l() {
        j(SearchAbilityDispatcher$onBindFinish$2.INSTANCE);
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void onViewRecycled() {
        j(C122921.INSTANCE);
    }

    public SearchAbilityDispatcher() {
        this.f452651a = new LinkedHashMap();
        this.f452654d = "";
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final String getName() {
        return this.f452654d;
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void a(final DynamicData r100) {
        Intrinsics.checkNotNullParameter(r100, "cardData");
        j(new SearchAbilityDispatcher$onBindStart$2(r100));
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void c(final AnnieXLynxView r100) {
        j(new SearchAbilityDispatcher$onPageUpdate$1(r100));
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void e(final AnnieXLynxView r100) {
        j(new SearchAbilityDispatcher$onFirstScreen$1(r100));
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void f(final AnnieXLynxView r100) {
        j(new SearchAbilityDispatcher$onDataUpdated$1(r100));
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void h(final DynamicData r100) {
        Intrinsics.checkNotNullParameter(r100, "cardData");
        j(new SearchAbilityDispatcher$onSkipBind$2(r100));
    }

    public final void j(Function1<? super ISearchDynamicAbility, ? extends Object> r100) {
        Iterator r101 = CollectionsKt.toList(((LinkedHashMap) this.f452651a).entrySet()).iterator();
    L4:
        if (r101.hasNext() == false) goto L16;
        Map.Entry r102 = (Map.Entry) r101.next();
        String r103 = (String) r102.getKey();
        ISearchDynamicAbility r104 = (ISearchDynamicAbility) r102.getValue();
        long r105 = System.nanoTime();     // Catch: Throwable -> L14
        r100.invoke(r104);     // Catch: Throwable -> L14
        long r106 = System.nanoTime() - r105;     // Catch: Throwable -> L14
        IDynamicAbilityOwner r107 = this.f452652b;     // Catch: Throwable -> L14
        if (r107 == null) goto L4;
        DynamicCardContext r108 = r107.i();     // Catch: Throwable -> L14
        if (r108 == null) goto L4;
        DefaultPerformanceMonitor r109 = r108.f452597f;     // Catch: Throwable -> L14
        if (r109 == null) goto L4;
        r109.k(r103, r106);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void m(final AnnieXLynxView r100) {
        j(new SearchAbilityDispatcher$onLynxViewCreated$1(r100));
    }

    public final void n(ISearchDynamicAbility r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getName().length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L16;
        if (((LinkedHashMap) this.f452651a).get(r100.getName()) != null) goto L14;
        ((BaseDynamicAbility) r100).o(this);
        this.f452651a.put(r100.getName(), r100);
        return;
    L14:
        throw new IllegalArgumentException(" ability name is exist: name: " + r100.getName());
    L16:
        throw new IllegalArgumentException(" ability name is empty!");
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void onViewAttachedToWindow(final View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        j(new AnonymousClass1(r100));
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void onViewDetachedFromWindow(final View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        j(new C122911(r100));
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void b(final AnnieXLynxView r100, final String r101) {
        j(new SearchAbilityDispatcher$onLoadFailed$1(r100, r101));
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void d(final Uri r100, final AnnieXLynxView r101) {
        j(new SearchAbilityDispatcher$onLoadUriSuccess$1(r100, r101));
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void g(final AnnieXLynxView r100, final LynxError r101) {
        j(new SearchAbilityDispatcher$onReceivedError$1(r100, r101));
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.legacy.ISearchDynamicAbilityLegacy
    public final void i(final String r100, final JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "value");
        j(new SearchAbilityDispatcher$handlePageScrollData$1(r100, r101));
    }
}
