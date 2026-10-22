package com.bytedance.locallife.poi.poidetail.screenshot.ui;

import android.view.View;
import com.bytedance.locallife.common.utils.g;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f264203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PoiScreenshotPanelAdapter f264204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.locallife.poi.poidetail.screenshot.model.a f264205c;

    public a(View r100, PoiScreenshotPanelAdapter r101, com.bytedance.locallife.poi.poidetail.screenshot.model.a r102) {
        this.f264203a = r100;
        this.f264204b = r101;
        this.f264205c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (g.a(this.f264203a) == false) goto L5;
        return;
    L5:
        az6.a r101 = this.f264204b.f264189b;
        String r102 = this.f264205c.a();
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        r101.a(r102);
        this.f264205c.d();
        this.f264205c.getClass();
    }
}
