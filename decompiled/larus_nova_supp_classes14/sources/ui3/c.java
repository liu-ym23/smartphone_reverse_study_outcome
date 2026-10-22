package ui3;

import com.bytedance.android.shopping.store.home.event.ChangeStateType;
import com.bytedance.android.shopping.store.viewmodel.ShopStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements com.bytedance.android.ec.core.arch.event.d {
    public final int a;
    public final ChangeStateType b;
    public final ShopStatus c;

    public static final class a {
    }

    static {
    }

    public /* synthetic */ c(int r3, ShopStatus r4, int r5) {
        if ((r5 & 2) == 0) goto L5;
        ChangeStateType r0 = ChangeStateType.HAND;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        this(r3, r0, r4);
        return;
    L5:
        r0 = null;
        goto L7
    }

    public c(int r2, ChangeStateType r3, ShopStatus r4) {
        Intrinsics.checkNotNullParameter(r3, "changeType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
