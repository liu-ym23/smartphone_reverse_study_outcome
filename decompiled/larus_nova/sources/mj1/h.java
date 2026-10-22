package mj1;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f514164a = 0;

    static {
    }

    public static a a(com.bytedance.android.livesdk.room.b r100) {
        if (r100 != null) goto L9;
    L7:
        return null;
    L9:
        Intrinsics.checkNotNullParameter(a.class, "classT");     // Catch: Exception -> L5
        return (a) r100.f510513b.getAbility(a.class);
    L5:
        e = move-exception;
        ALogger.e("RoomContainerServiceHelper", e);
        goto L7
    }
}
