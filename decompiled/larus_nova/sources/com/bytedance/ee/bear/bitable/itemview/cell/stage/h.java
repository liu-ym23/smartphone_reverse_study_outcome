package com.bytedance.ee.bear.bitable.itemview.cell.stage;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class h extends pr4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StageTabCell f213977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.card.model.stmodel.field.d f213978c;

    @Override // pr4.a
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        StageActionPayload r101 = this.f213977b.b("ItemViewStageRecoverAction", this.f213978c.f207141a);
        if (r101 == null) goto L8;
        gv4.a r102 = this.f213977b.getMHandler();
        if (r102 == null) goto L9;
        r102.a(r101);
        return;
    L9:
        return;
    }

    public h(StageTabCell r100, com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r101) {
        this.f213977b = r100;
        this.f213978c = r101;
    }
}
