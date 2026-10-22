package com.bytedance.ee.bear.bitable.jsapi.common;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonAttachmentPanel f214403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f214404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Integer f214405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Integer f214406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ za5.a f214407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ bb5.c f214408f;

    public f(CommonAttachmentPanel r100, Context r101, Integer r102, Integer r103, CommonAttachmentPanel.f r104, bb5.c r105) {
        this.f214403a = r100;
        this.f214404b = r101;
        this.f214405c = r102;
        this.f214406d = r103;
        this.f214407e = r104;
        this.f214408f = r105;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CommonAttachmentPanel r101 = this.f214403a;
        Context r102 = this.f214404b;
        Integer r103 = this.f214405c;
        Integer r104 = this.f214406d;
        za5.a r105 = this.f214407e;
        bb5.c r106 = this.f214408f;
        r101.getClass();
        CommonAttachmentPanel.i(r102, r103, r104, r105, r106);
    }
}
