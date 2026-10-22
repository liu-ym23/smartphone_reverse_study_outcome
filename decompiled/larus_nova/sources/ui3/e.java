package ui3;

import com.bytedance.android.shopping.store.home.event.ChangeStateType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements com.bytedance.android.ec.core.arch.event.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f550150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChangeStateType f550151b;

    public static final class a {
    }

    static {
    }

    public /* synthetic */ e(int r100) {
        this(r100, ChangeStateType.HAND);
    }

    public e(int r100, ChangeStateType r101) {
        Intrinsics.checkNotNullParameter(r101, "changeType");
        this.f550150a = r100;
        this.f550151b = r101;
    }
}
