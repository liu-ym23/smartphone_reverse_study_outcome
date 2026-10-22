package vc2;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements kf6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f554084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f554085b;

    @Override // kf6.a
    public final void debug(String r100, String r101) {
        Intrinsics.checkNotNullParameter("TimeCost", "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "alias");
        this.f554085b = r100;
        if (v.a() == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        this.f554084a = r101;
        return;
    L5:
        if (l42.a.f507321h.getValue().booleanValue() == false) goto L7;
        r101 = true;
        goto L8
    }

    @Override // kf6.a
    public final void error(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter("CoreEngine", "tag");
        Intrinsics.checkNotNullParameter(r100, "message");
        if (this.f554084a == true) goto L7;
        SafetyGuard.a(null, r101, "Danmaku: " + this.f554085b + " Exception");
        return;
    L7:
        throw new RuntimeException(r101);
    }
}
