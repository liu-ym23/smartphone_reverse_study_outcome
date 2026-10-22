package vc3;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InFeedProductV2 f554093a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f554093a, ((b) r100).f554093a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        InFeedProductV2 r100 = this.f554093a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "SlcActionBase(cardData=" + this.f554093a + ")";
    }

    public b(InFeedProductV2 r100) {
        this.f554093a = r100;
    }
}
