package lb8;

import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<jc8.a> f508384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f508385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f508386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fh8.d f508387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final kc8.b f508388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f508389f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f508384a, r101.f508384a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508385b, r101.f508385b) == true) goto L15;
        return false;
    L15:
        if (this.f508386c == r101.f508386c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508387d, r101.f508387d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508388e, r101.f508388e) == true) goto L24;
        return false;
    L24:
        if (this.f508389f == r101.f508389f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f508384a.hashCode() * 31;
        Message r101 = this.f508385b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        int r105 = 1231;
        if (this.f508386c == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        fh8.d r108 = this.f508387d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        kc8.b r111 = this.f508388e;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        int r112 = (r110 + r102) * 31;
        if (this.f508389f == true) goto L23;
        r105 = 1237;
    L23:
        return r112 + r105;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DeepThinkBlockListViewInput(models=" + this.f508384a + ", message=" + this.f508385b + ", isDeepThinkingStreaming=" + this.f508386c + ", deepThinkFoldStatusManager=" + this.f508387d + ", blockDependConfig=" + this.f508388e + ", forceRefreshAllBlock=" + this.f508389f + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(List<? extends jc8.a> r100, Message r101, boolean r102, fh8.d r103, kc8.b r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "models");
        this.f508384a = r100;
        this.f508385b = r101;
        this.f508386c = r102;
        this.f508387d = r103;
        this.f508388e = r104;
        this.f508389f = r105;
    }
}
