package com.ss.android.ugc.aweme.discover.dynamic.ability.ecommerce;

import com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/dynamic/ability/ecommerce/LongPressAbilityFactory;", "Lcom/ss/android/ugc/aweme/search/dynamic/core/ability/ISearchDynamicAbility$IFactory;", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LongPressAbilityFactory implements ISearchDynamicAbility.IFactory {
    public LongPressAbilityFactory() {
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility.IFactory
    public final String getName() {
        return "longPressPanel";
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility.IFactory
    public final int getScope() {
        return 1;
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility.IFactory
    public final ISearchDynamicAbility create() {
        return new LongPressAbility();
    }
}
