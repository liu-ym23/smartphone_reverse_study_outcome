package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import android.text.TextUtils;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PanelBottomDialog f411504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PanelItem f411505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f411506c;

    public b(PanelBottomDialog r100, PanelItem r101, g r102) {
        this.f411504a = r100;
        this.f411505b = r101;
        this.f411506c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        g r101 = this.f411504a.f411473h;
        PanelItem r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f411511a;
    L7:
        if (TextUtils.equals(r103, this.f411505b.getId()) == false) goto L9;
        PanelBottomDialog r104 = this.f411504a;
        r104.f411473h = null;
        Intrinsics.checkNotNull(r100);
        r104.aa0(r100, false, this.f411506c.f411513c);
        return;
    L9:
        PanelBottomDialog r105 = this.f411504a;
        g r106 = r105.f411473h;
        if (r106 == null) goto L16;
        View r107 = r106.f411512b;
        if (r107 == null) goto L16;
        if (r106 == null) goto L15;
        r102 = r106.f411513c;
    L15:
        r105.aa0(r107, false, r102);
    L16:
        PanelBottomDialog r108 = this.f411504a;
        r108.f411473h = this.f411506c;
        Intrinsics.checkNotNull(r100);
        r108.aa0(r100, true, this.f411506c.f411513c);
        return;
    L5:
        r103 = null;
        goto L7
    }
}
