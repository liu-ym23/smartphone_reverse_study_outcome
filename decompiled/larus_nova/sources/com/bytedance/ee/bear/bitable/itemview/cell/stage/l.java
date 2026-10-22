package com.bytedance.ee.bear.bitable.itemview.cell.stage;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class l extends pr4.a {
    public l() {
    }

    @Override // pr4.a
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Toast.showText(r100.getContext(), R.string.Bitable_Flow_RecordCard_NoPermitComplete_Desc);
    }
}
