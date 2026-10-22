package un8;

import com.larus.im.bean.message.block.TaskCardBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f550854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TaskCardBlock f550855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f550856c;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f550854a == r101.f550854a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f550855b, r101.f550855b) == true) goto L15;
        return false;
    L15:
        if (this.f550856c == r101.f550856c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f550854a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        TaskCardBlock r103 = this.f550855b;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f550856c == true) goto L15;
        r100 = 1237;
    L15:
        return r105 + r100;
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CycleInfo(canExecute=" + this.f550854a + ", block=" + this.f550855b + ", started=" + this.f550856c + ')';
    }

    public a(int r100) {
        this.f550854a = false;
        this.f550855b = null;
        this.f550856c = false;
    }
}
