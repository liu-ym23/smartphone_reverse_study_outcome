package ph1;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.model.vr.VrMediaViewType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f529241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VrMediaViewType f529242b;

    public final VrMediaViewType getType() {
        return this.f529242b;
    }

    public b(View r100, VrMediaViewType r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f529241a = r100;
        this.f529242b = r101;
    }
}
