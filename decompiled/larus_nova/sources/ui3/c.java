package ui3;

import com.bytedance.android.shopping.store.home.event.ChangeStateType;
import com.bytedance.android.shopping.store.viewmodel.ShopStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements com.bytedance.android.ec.core.arch.event.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f550146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChangeStateType f550147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ShopStatus f550148c;

    public static final class a {
    }

    static {
    }

    public /* synthetic */ c(int r100, ShopStatus r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        ChangeStateType r103 = ChangeStateType.HAND;
    L7:
        if ((r102 & 4) == 0) goto L9;
        r101 = null;
    L9:
        this(r100, r103, r101);
        return;
    L5:
        r103 = null;
        goto L7
    }

    public c(int r100, ChangeStateType r101, ShopStatus r102) {
        Intrinsics.checkNotNullParameter(r101, "changeType");
        this.f550146a = r100;
        this.f550147b = r101;
        this.f550148c = r102;
    }
}
