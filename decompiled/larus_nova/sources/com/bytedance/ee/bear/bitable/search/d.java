package com.bytedance.ee.bear.bitable.search;

import android.text.Editable;
import com.bytedance.ee.bear.bitable.common.j;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableSearchFragment f215303a;

    public d(BitableSearchFragment r100) {
        this.f215303a = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.common.j, android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        BitableSearchModel r101 = this.f215303a.f215280e.getValue();
        if (r101 == null) goto L12;
        ActionPayload r102 = r101.getSearchAction();
        if (r102 == null) goto L13;
        BitableSearchFragment r103 = this.f215303a;
        if (r100 == null) goto L9;
        String r104 = r100.toString();
    L10:
        r102.setContent(r104);
        r103.f215281f.a(r102);
        return;
    L9:
        r104 = null;
        goto L10
    L13:
        return;
    }
}
