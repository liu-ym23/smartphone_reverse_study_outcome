package com.ss.android.lark.contact.base.contact_search;

import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: classes35.dex */
public final class a0 implements ApiUtils.a<Boolean> {
    public a0() {
    }

    @Override // com.ss.android.lark.utils.ApiUtils.a
    public final void consume(Boolean r100) {
        InvHitPoint.d(r100.booleanValue());
    }
}
