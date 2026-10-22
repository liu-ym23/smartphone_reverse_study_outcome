package ur5;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import zr5.b;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f551379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pxb.a f551380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f551381c;

    public final Context getContext() {
        return this.f551379a;
    }

    public a(Context r100, pxb.a r101, b r102) {
        Intrinsics.checkNotNullParameter(r101, "webView");
        this.f551379a = r100;
        this.f551380b = r101;
        this.f551381c = r102;
    }
}
