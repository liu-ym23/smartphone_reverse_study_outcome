package t38;

import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f544448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f544449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f544450d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f544447a, r101.f544447a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f544448b, r101.f544448b) == true) goto L15;
        return false;
    L15:
        if (this.f544449c == r101.f544449c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f544450d, r101.f544450d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f544447a.hashCode() * 31) + this.f544448b.hashCode()) * 31) + this.f544449c) * 31) + this.f544450d.hashCode();
    }

    public final String toString() {
        return "DoubaoOpenAuthCodeRequest(clientKey=" + this.f544447a + ", scopes=" + this.f544448b + ", aid=" + this.f544449c + ", source=" + this.f544450d + ')';
    }

    public a(List r100) {
        Intrinsics.checkNotNullParameter("tyfhrugobjy5d9cu", "clientKey");
        Intrinsics.checkNotNullParameter(r100, ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE);
        Intrinsics.checkNotNullParameter(PrefetchTiming.JSB, "source");
        this.f544447a = "tyfhrugobjy5d9cu";
        this.f544448b = r100;
        this.f544449c = 482431;
        this.f544450d = PrefetchTiming.JSB;
    }
}
