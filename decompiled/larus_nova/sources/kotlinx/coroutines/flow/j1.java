package kotlinx.coroutines.flow;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f504898a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f504899b = null;

    static {
        f504898a = new kotlinx.coroutines.internal.b0(UserProfileEvent.POSITION_NONE);
        f504899b = new kotlinx.coroutines.internal.b0("PENDING");
    }

    public static final StateFlowImpl a(Object r100) {
        if (r100 != null) goto L6;
        r100 = kotlinx.coroutines.flow.internal.o.f504892a;
    L6:
        return new StateFlowImpl(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void update(z0<T> r100, Function1<? super T, ? extends T> r101) {
    L2:
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r102 = (Object) r100.getValue();
        if (r100.compareAndSet(r102, r101.invoke(r102)) == false) goto L2;
    }
}
