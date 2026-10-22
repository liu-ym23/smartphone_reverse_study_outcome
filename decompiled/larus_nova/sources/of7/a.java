package of7;

import com.bytedance.supervisor.token.Token;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Token f523108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f523109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f523110c;

    public final String toString() {
        return "CheckResult: {token: " + this.f523108a.getIdentifier() + ", CheckResultCode: " + this.f523109b + '}';
    }

    public a(Token r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        this.f523108a = r100;
        this.f523109b = r101;
        this.f523110c = -1;
    }
}
