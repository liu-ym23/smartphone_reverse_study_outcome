package com.larus.search.impl.global.view.aggregate.kmp;

import com.bytedance.flow.search.kmp.api.spi.SearchDomainGateService;
import com.larus.platform.exp.LarkSocialExp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/search/impl/global/view/aggregate/kmp/KmpAggregateSearchDomainGateServiceImpl;", "Lcom/bytedance/flow/search/kmp/api/spi/SearchDomainGateService;", "<init>", "()V", "filterVisibleDomains", "", "", "domainKeys", "canConsumeLarkMessage", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpAggregateSearchDomainGateServiceImpl implements SearchDomainGateService {
    public KmpAggregateSearchDomainGateServiceImpl() {
    }

    @Override // com.bytedance.flow.search.kmp.api.spi.SearchDomainGateService
    public final boolean E() {
        LarkSocialExp.f365340a.getClass();
        return LarkSocialExp.f();
    }

    @Override // com.bytedance.flow.search.kmp.api.spi.SearchDomainGateService
    public final List<String> j0(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "domainKeys");
        if (r100.isEmpty() == true) goto L5;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L18;
        Object r103 = r102.next();
        if (Intrinsics.areEqual((String) r103, "contact") == false) goto L15;
        LarkSocialExp.f365340a.getClass();
        if (LarkSocialExp.f() == true) goto L15;
        boolean r104 = false;
    L16:
        if (r104 == false) goto L8;
        r101.add(r103);
    L15:
        r104 = true;
        goto L16
    L18:
        return r101;
    L5:
        return CollectionsKt.emptyList();
    }
}
