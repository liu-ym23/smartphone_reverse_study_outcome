package ty8;

import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Message> f548015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f548016b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f548015a, r101.f548015a) == true) goto L12;
        return false;
    L12:
        if (this.f548016b == r101.f548016b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<Message> r100 = this.f548015a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f548016b == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "GalleryMessageLoadResult(messageList=" + this.f548015a + ", hasMore=" + this.f548016b + ')';
    }

    public c(List<Message> r100, boolean r101) {
        this.f548015a = r100;
        this.f548016b = r101;
    }
}
