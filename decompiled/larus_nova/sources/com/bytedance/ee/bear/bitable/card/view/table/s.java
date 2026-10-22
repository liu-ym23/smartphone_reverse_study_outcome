package com.bytedance.ee.bear.bitable.card.view.table;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class s implements com.larksuite.component.ignition.widget.blur.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecordPageCoverAdapter f208899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f208900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ImageView f208901c;

    @Override // com.larksuite.component.ignition.widget.blur.a
    public final void a(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        RecordPageCoverAdapter r101 = this.f208899a;
        ImageView r102 = this.f208900b;
        int r103 = RecordPageCoverAdapter.f208851d;
        r101.getClass();
        com.bytedance.ee.util.ui.j.f(new u(r102, r100));
        RecordPageCoverAdapter r104 = this.f208899a;
        ImageView r105 = this.f208901c;
        r104.getClass();
        com.bytedance.ee.util.ui.j.f(new r(r105));
    }

    public s(RecordPageCoverAdapter r100, ImageView r101, ImageView r102) {
        this.f208899a = r100;
        this.f208900b = r101;
        this.f208901c = r102;
    }
}
