package mb8;

import com.larus.im.bean.message.Message;
import fh8.d;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<jc8.a> f512782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f512783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Message f512784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final kc8.b f512785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f512786e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f512787f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f512782a, r101.f512782a) == true) goto L12;
        return false;
    L12:
        if (this.f512783b == r101.f512783b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f512784c, r101.f512784c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f512785d, r101.f512785d) == true) goto L21;
        return false;
    L21:
        if (this.f512786e == r101.f512786e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f512787f, r101.f512787f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f512782a.hashCode() * 31;
        int r101 = 1231;
        if (this.f512783b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f512784c.hashCode()) * 31;
        kc8.b r104 = this.f512785d;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        if (this.f512786e == true) goto L14;
        r101 = 1237;
    L14:
        int r108 = (r107 + r101) * 31;
        d r109 = this.f512787f;
        if (r109 == null) goto L19;
        r105 = r109.hashCode();
    L19:
        return r108 + r105;
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeepThinkBlockListVMData(blockList=" + this.f512782a + ", forceRefreshAllBlock=" + this.f512783b + ", message=" + this.f512784c + ", blockDependConfig=" + this.f512785d + ", isDeepThinkingStreaming=" + this.f512786e + ", deepThinkFoldStatusManager=" + this.f512787f + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends jc8.a> r100, boolean r101, Message r102, kc8.b r103, boolean r104, d r105) {
        Intrinsics.checkNotNullParameter(r100, "blockList");
        Intrinsics.checkNotNullParameter(r102, "message");
        this.f512782a = r100;
        this.f512783b = r101;
        this.f512784c = r102;
        this.f512785d = r103;
        this.f512786e = r104;
        this.f512787f = r105;
    }
}
