package com.bytedance.ee.bear.bitable.jsapi.common;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Integer f214398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CommonAttachmentPanel f214399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f214400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ za5.a f214401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CommonAttachmentPanel.c f214402e;

    public e(Integer r100, CommonAttachmentPanel r101, Context r102, CommonAttachmentPanel.f r103, CommonAttachmentPanel.c r104) {
        this.f214398a = r100;
        this.f214399b = r101;
        this.f214400c = r102;
        this.f214401d = r103;
        this.f214402e = r104;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Integer r101 = this.f214398a;
        boolean r102 = false;
        if (r101 != null) goto L6;
    L7:
        Integer r103 = this.f214398a;
        if (r103 != null) goto L11;
    L13:
        boolean r104 = false;
    L15:
        Integer r105 = this.f214398a;
        if (r105 != null) goto L19;
    L20:
        Integer r106 = this.f214398a;
        if (r106 != null) goto L24;
    L26:
        CommonAttachmentPanel r107 = this.f214399b;
        Context r108 = this.f214400c;
        za5.a r109 = this.f214401d;
        CommonAttachmentPanel.c r110 = this.f214402e;
        r107.getClass();
        CommonAttachmentPanel.j(r108, r104, r102, r109, r110);
        return;
    L24:
        if (r106.intValue() != 1) goto L26;
    L25:
        r102 = true;
        goto L26
    L19:
        if (r105.intValue() == 2) goto L25;
    L11:
        if (r103.intValue() != 0) goto L13;
    L14:
        r104 = true;
        goto L15
    L6:
        if (r101.intValue() == 2) goto L14;
        goto L7
    }
}
