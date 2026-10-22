package iq2;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.revenue.ktv.RevKtvRoomKind;
import fd2.y;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f495339a;

    public final Long a() {
        return this.f495339a.a();
    }

    public final RevKtvRoomKind b() {
        y r100 = this.f495339a;
        if ((r100 instanceof y.b) == false) goto L6;
        return RevKtvRoomKind.Idle;
    L6:
        if ((r100 instanceof y.d) == false) goto L9;
        return RevKtvRoomKind.Singing;
    L9:
        if ((r100 instanceof y.a) == false) goto L12;
        return RevKtvRoomKind.CountDown;
    L12:
        if ((r100 instanceof y.c) == false) goto L16;
        return RevKtvRoomKind.Paused;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public final f c() {
        KtvMusic r100 = this.f495339a.b();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new f(r100);
    }

    public h(y r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f495339a = r100;
    }
}
