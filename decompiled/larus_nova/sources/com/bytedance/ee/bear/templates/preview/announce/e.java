package com.bytedance.ee.bear.templates.preview.announce;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PanelTemplateAdapter f239179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f239180b;

    public e(PanelTemplateAdapter r100, int r101) {
        this.f239179a = r100;
        this.f239180b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PanelTemplateAdapter r101 = this.f239179a;
        PanelTemplateAdapter.b r102 = r101.f239156c;
        if (r102 == null) goto L6;
        int r103 = this.f239180b;
        r102.a(r103, (AnnounceTemplate) ListProtector.get(r101.f239155b, r103));
        return;
    }
}
