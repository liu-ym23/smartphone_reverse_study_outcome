package zy9;

import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f573980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<CreationItem> f573981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f573982c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f573980a, r101.f573980a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f573981b, r101.f573981b) == true) goto L15;
        return false;
    L15:
        if (this.f573982c == r101.f573982c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f573980a.hashCode() * 31;
        List<CreationItem> r101 = this.f573981b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f573982c;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CorrectionImageVMData(message=" + this.f573980a + ", creationItems=" + this.f573981b + ", maxContentWidth=" + this.f573982c + ')';
    }

    public a(Message r100, List<CreationItem> r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f573980a = r100;
        this.f573981b = r101;
        this.f573982c = r102;
    }
}
