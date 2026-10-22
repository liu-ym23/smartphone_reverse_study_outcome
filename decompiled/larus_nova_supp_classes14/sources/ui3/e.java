package ui3;

import com.bytedance.android.shopping.store.home.event.ChangeStateType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements com.bytedance.android.ec.core.arch.event.d {
    public final int a;
    public final ChangeStateType b;

    public static final class a {
    }

    static {
    }

    public /* synthetic */ e(int r2) {
        this(r2, ChangeStateType.HAND);
    }

    public e(int r2, ChangeStateType r3) {
        Intrinsics.checkNotNullParameter(r3, "changeType");
        this.a = r2;
        this.b = r3;
    }
}
