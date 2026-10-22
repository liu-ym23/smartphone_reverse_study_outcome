package com.ss.android.ugc.aweme.discover.dynamic.ability.ecommerce;

import com.ss.android.ugc.aweme.search.dynamic.core.ability.BaseDynamicAbility;
import com.ss.android.ugc.aweme.search.dynamic.core.data.DynamicData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/dynamic/ability/ecommerce/DRFallBackAbility;", "Lcom/ss/android/ugc/aweme/search/dynamic/core/ability/BaseDynamicAbility;", "<init>", "()V", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DRFallBackAbility extends BaseDynamicAbility {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/dynamic/ability/ecommerce/DRFallBackAbility$Companion;", "", "()V", "NAME", "", "TAG", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final String getName() {
        return "drFallbackStatus";
    }

    public DRFallBackAbility() {
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.BaseDynamicAbility, com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility
    public final void a(DynamicData r100) {
        Intrinsics.checkNotNullParameter(r100, "cardData");
        Intrinsics.checkNotNullParameter(r100, "cardData");
    }
}
