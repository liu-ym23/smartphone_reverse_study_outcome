package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.os.Bundle;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/BaseLazyFragment;", "Lcom/bytedance/android/livesdk/livecommerce/iron/ui/BaseVisibilityFragment;", "Lcom/bytedance/android/livesdk/livecommerce/iron/ui/l;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseLazyFragment extends BaseVisibilityFragment {
    public boolean h;

    public BaseLazyFragment() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.iron.ui.BaseVisibilityFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.g.add(this);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.iron.ui.BaseVisibilityFragment, com.bytedance.android.livesdk.livecommerce.iron.ui.l
    public final void qP(boolean r2) {
        if (this.h == true) goto L7;
        if (r2 == false) goto L8;
        this.h = true;
        return;
    L8:
        return;
    }
}
