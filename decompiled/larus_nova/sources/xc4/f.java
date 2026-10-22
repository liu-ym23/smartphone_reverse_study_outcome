package xc4;

import com.android.ttcjpaysdk.integrated.counter.outerpay.CJOuterPayManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f563208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f563209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f563210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f563211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f563212e;

    public f(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "nickName");
        Intrinsics.checkNotNullParameter(r102, "secUid");
        Intrinsics.checkNotNullParameter(r103, CJOuterPayManager.KEY_BINDPHONE);
        Intrinsics.checkNotNullParameter(r104, "avatar");
        this.f563208a = r100;
        this.f563209b = r101;
        this.f563210c = r102;
        this.f563211d = r103;
        this.f563212e = r104;
    }
}
