package ok8;

import com.larus.im.bean.message.block.ResearchProcessBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f523697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ResearchProcessBlock f523698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f523699c;

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
        if (this.f523697a == r101.f523697a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f523698b, r101.f523698b) == true) goto L15;
        return false;
    L15:
        if (this.f523699c == r101.f523699c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f523697a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        ResearchProcessBlock r103 = this.f523698b;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f523699c == true) goto L15;
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
        return "CycleInfo(canExecute=" + this.f523697a + ", block=" + this.f523698b + ", started=" + this.f523699c + ')';
    }

    public a(int r100) {
        this.f523697a = false;
        this.f523698b = null;
        this.f523699c = false;
    }
}
