package com.ss.android.ugc.aweme.search.dynamic.core.ability;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.lynx.tasm.LynxError;
import com.ss.android.ugc.aweme.search.dynamic.core.data.DynamicData;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/ability/BaseDynamicAbility;", "Lcom/ss/android/ugc/aweme/search/dynamic/core/ability/ISearchDynamicAbility;", "<init>", "()V", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public abstract class BaseDynamicAbility implements ISearchDynamicAbility {
    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public void a(DynamicData r100) {
        Intrinsics.checkNotNullParameter(r100, "cardData");
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void b(AnnieXLynxView r100, String r101) {
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void c(AnnieXLynxView r100) {
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public void d(Uri r100, AnnieXLynxView r101) {
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void e(AnnieXLynxView r100) {
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public void f(AnnieXLynxView r100) {
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void g(AnnieXLynxView r100, LynxError r101) {
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public void l() {
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void m(AnnieXLynxView r100) {
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void onViewRecycled() {
    }

    public BaseDynamicAbility() {
    }

    public void n() {
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void h(DynamicData r100) {
        Intrinsics.checkNotNullParameter(r100, "cardData");
    }

    public void o(SearchAbilityDispatcher r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.legacy.ISearchDynamicAbilityLegacy
    public final void i(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "value");
    }
}
