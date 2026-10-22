package t75;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public final int a;
    public final int b;
    public final BaseOpenEntity c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "DrivePreviewAiPageSnapshot(index=" + this.a + ", totalCount=" + this.b + ", entity=" + this.c + ')';
    }

    public e(int r2, int r3, BaseOpenEntity r4) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
