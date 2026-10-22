package z40;

import com.bytedance.android.livesdk.utils.a2;
import com.bytedance.android.livesdk.utils.b2;
import com.bytedance.android.livesdk.utils.f2;
import com.bytedance.android.livesdk.utils.g2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a<INTENT, STATE extends g2> implements f2<INTENT, STATE> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a2<? extends DataContext> f569885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataCenter f569886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b2<INTENT, STATE> f569887c;

    public a() {
    }

    public final void b(com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        b2<INTENT, STATE> r101 = this.f569887c;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
