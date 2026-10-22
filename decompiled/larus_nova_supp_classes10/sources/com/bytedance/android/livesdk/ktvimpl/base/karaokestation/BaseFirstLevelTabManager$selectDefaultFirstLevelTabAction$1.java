package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final class BaseFirstLevelTabManager$selectDefaultFirstLevelTabAction$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BaseFirstLevelTabManager this$0;

    public BaseFirstLevelTabManager$selectDefaultFirstLevelTabAction$1(BaseFirstLevelTabManager r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m29invoke() {
        BaseFirstLevelTabManager r0 = this.this$0;
        Integer r1 = r0.h;
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        String r3 = this.this$0.i;
        if (r3 != null) goto L9;
        r3 = "recommend";
    L9:
        r0.a(r2, r3);
        return;
    L5:
        r2 = FirstLevelTab.OrderSongTab.getValue();
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m29invoke();
        return Unit.INSTANCE;
    }
}
