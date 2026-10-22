package com.bytedance.ee.bear.edit.component.toolbar2;

import android.view.View;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;

/* JADX INFO: loaded from: classes16.dex */
public final class s extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f226191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ItemIdV2 f226192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BaseToolbarV2PanelFragment f226193e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        String r101 = String.valueOf(this.f226191c);
        this.f226193e.fa0(this.f226192d, r101);
    }

    public s(BaseToolbarV2PanelFragment r100, boolean r101, ItemIdV2 r102) {
        this.f226193e = r100;
        this.f226191c = r101;
        this.f226192d = r102;
    }
}
