package iq2;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fd2.f f495332a;

    public final com.bytedance.android.live.liveinteract.model.a c() {
        return this.f495332a.getChorusInfo();
    }

    public final int d() {
        return this.f495332a.i0();
    }

    public final boolean e() {
        return this.f495332a.Pp();
    }

    public b(fd2.f r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f495332a = r100;
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.CHANNEL_ID);
        fd2.f r101 = this.f495332a;
        Long r102 = StringsKt.toLongOrNull(r100);
        if (r102 == null) goto L5;
        long r103 = r102.longValue();
    L6:
        r101.xk(r103, 1);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.CHANNEL_ID);
        fd2.f r101 = this.f495332a;
        Long r102 = StringsKt.toLongOrNull(r100);
        if (r102 == null) goto L5;
        long r103 = r102.longValue();
    L6:
        r101.xk(r103, 9);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.CHANNEL_ID);
        fd2.f r101 = this.f495332a;
        Long r102 = StringsKt.toLongOrNull(r100);
        if (r102 == null) goto L5;
        long r103 = r102.longValue();
    L6:
        r101.Xj(r103);
        return;
    L5:
        r103 = 0;
        goto L6
    }
}
