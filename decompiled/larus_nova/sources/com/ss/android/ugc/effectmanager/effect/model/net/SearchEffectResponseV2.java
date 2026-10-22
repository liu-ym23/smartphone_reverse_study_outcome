package com.ss.android.ugc.effectmanager.effect.model.net;

import com.ss.android.ugc.effectmanager.common.model.BaseNetResponse;
import com.ss.android.ugc.effectmanager.effect.model.SearchEffectModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/net/SearchEffectResponseV2;", "Lcom/ss/android/ugc/effectmanager/common/model/BaseNetResponse;", "()V", "data", "Lcom/ss/android/ugc/effectmanager/effect/model/SearchEffectModel;", "getData", "()Lcom/ss/android/ugc/effectmanager/effect/model/SearchEffectModel;", "setData", "(Lcom/ss/android/ugc/effectmanager/effect/model/SearchEffectModel;)V", "checkValue", "", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class SearchEffectResponseV2 extends BaseNetResponse {
    private SearchEffectModel data;

    @Override // com.ss.android.ugc.effectmanager.common.model.BaseNetResponse
    public boolean checkValue() {
        if (this.data == null) goto L5;
        return true;
    L5:
        return false;
    }

    public SearchEffectResponseV2() {
    }

    public final SearchEffectModel getData() {
        return this.data;
    }

    public final void setData(SearchEffectModel r100) {
        this.data = r100;
    }
}
