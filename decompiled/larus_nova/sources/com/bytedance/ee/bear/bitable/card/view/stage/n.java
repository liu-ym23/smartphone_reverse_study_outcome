package com.bytedance.ee.bear.bitable.card.view.stage;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class n extends pr4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StageDataViewHolder f208741b;

    public n(StageDataViewHolder r100) {
        this.f208741b = r100;
    }

    @Override // pr4.a
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        b r101 = this.f208741b.f208670a.getView();
        if (r101 == null) goto L5;
        r101.GY(r100);
    L5:
        Toast.showText(r100.getContext(), R.string.Bitable_Flow_RecordCard_NoPermitComplete_Desc);
    }
}
