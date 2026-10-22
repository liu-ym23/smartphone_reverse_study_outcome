package nj5;

import com.bytedance.supervisor.token.Token;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oj5.c f519445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Token f519446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f519447c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f519445a, r101.f519445a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f519446b, r101.f519446b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f519447c, r101.f519447c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f519445a.hashCode() * 31) + this.f519446b.hashCode()) * 31;
        e r101 = this.f519447c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CopyLinkRequest(moreInfo=" + this.f519445a + ", token=" + this.f519446b + ", urlTransformer=" + this.f519447c + ')';
    }

    public b(oj5.c r100, e r101) {
        Token r102 = new Token("LARK-PSDA-ccm_android_more_dialog_copy_link");
        Intrinsics.checkNotNullParameter(r100, "moreInfo");
        Intrinsics.checkNotNullParameter(r102, "token");
        this.f519445a = r100;
        this.f519446b = r102;
        this.f519447c = r101;
    }
}
