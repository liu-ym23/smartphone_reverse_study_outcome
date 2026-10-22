package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import android.view.View;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;

/* JADX INFO: loaded from: classes16.dex */
public final class t extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f226355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ItemV2 f226356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ OfficeBaseToolbarV2PanelFragment f226357e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        String r101 = String.valueOf(this.f226355c);
        this.f226357e.ma0(this.f226356d.id(), r101);
    }

    public t(OfficeBaseToolbarV2PanelFragment r100, boolean r101, ItemV2 r102) {
        this.f226357e = r100;
        this.f226355c = r101;
        this.f226356d = r102;
    }
}
