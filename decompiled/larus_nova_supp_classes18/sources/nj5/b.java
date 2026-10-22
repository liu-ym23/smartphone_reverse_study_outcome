package nj5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.supervisor.token.Token;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final oj5.c a;
    public final Token b;
    public final e c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        e r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "CopyLinkRequest(moreInfo=" + this.a + ", token=" + this.b + ", urlTransformer=" + this.c + ')';
    }

    public b(oj5.c r3, e r4) {
        Token r0 = new Token("LARK-PSDA-ccm_android_more_dialog_copy_link");
        Intrinsics.checkNotNullParameter(r3, "moreInfo");
        Intrinsics.checkNotNullParameter(r0, ResourceData.KEY_TOKEN);
        this.a = r3;
        this.b = r0;
        this.c = r4;
    }
}
