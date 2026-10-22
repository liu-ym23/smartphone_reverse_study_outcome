package com.bytedance.ee.bear.document.associateddocs.view;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes16.dex */
public final class j extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AssociatedAppUrlListAdapter f219075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f219076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f219077e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        AssociatedAppUrlListAdapter.a r101 = this.f219075c.f219024a;
        if (r101 == null) goto L6;
        r101.a(this.f219076d, this.f219077e);
        return;
    }

    public j(AssociatedAppUrlListAdapter r100, String r101, String r102) {
        this.f219075c = r100;
        this.f219076d = r101;
        this.f219077e = r102;
    }
}
