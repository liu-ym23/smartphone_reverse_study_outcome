package zg1;

import com.bytedance.android.livesdkapi.depend.model.InsertStickerInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InsertStickerInfo f571808a;

    public c2() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c2) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f571808a, ((c2) r100).f571808a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        InsertStickerInfo r100 = this.f571808a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "OpenStickerEventKt(insertStickerInfo=" + this.f571808a + ")";
    }

    public c2(InsertStickerInfo r100) {
        this.f571808a = r100;
    }
}
