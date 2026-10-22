package com.bytedance.android.shopping.utils.gallery;

import com.bytedance.android.shopping.anchorv3.detail.widget.VideoHolder;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.utils.r;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnDismissListener;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i implements OnDismissListener {
    public final /* synthetic */ List a;
    public final /* synthetic */ VideoHolder b;
    public final /* synthetic */ List c;

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.OnDismissListener
    public final void onDismiss(int r2) {
        VideoHolder r3 = this.b;
        if (r3 == null) goto L7;
        PlayerBlock r4 = r3.g;
        if (r4 == null) goto L7;
        r4.B();
    L7:
        int r5 = r.a;
        Intrinsics.checkNotNullParameter("willDismiss", "type");
    }

    public i(List r1, VideoHolder r2, List r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
