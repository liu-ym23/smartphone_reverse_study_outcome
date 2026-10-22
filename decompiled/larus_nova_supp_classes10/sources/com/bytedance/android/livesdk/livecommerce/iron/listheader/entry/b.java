package com.bytedance.android.livesdk.livecommerce.iron.listheader.entry;

import com.bytedance.android.livesdk.livecommerce.iron.listheader.i;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements i.b {
    public final /* synthetic */ IronListHeaderEntryLayout a;
    public final /* synthetic */ Map b;

    @Override // com.bytedance.android.livesdk.livecommerce.iron.listheader.i.b
    public final ECLottieAnimationView b() {
        return this.a.getCartEntryView();
    }

    public b(IronListHeaderEntryLayout r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }
}
