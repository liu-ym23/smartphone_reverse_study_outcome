package kc8;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DeepThinkFoldStatus f502563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f502564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f502565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f502566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f502567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f502568f;

    public r() {
        this(null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (this.f502563a == r101.f502563a) goto L12;
        return false;
    L12:
        if (this.f502564b == r101.f502564b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f502565c, r101.f502565c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f502566d, r101.f502566d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f502567e, r101.f502567e) == true) goto L24;
        return false;
    L24:
        if (this.f502568f == r101.f502568f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        DeepThinkFoldStatus r100 = this.f502563a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.f502564b == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f502565c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f502566d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f502567e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        int r114 = (r112 + r101) * 31;
        if (this.f502568f == true) goto L27;
        r104 = 1237;
    L27:
        return r114 + r104;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DeepThinkBlockUIConfig(initialDeepThinkFoldStatus=" + this.f502563a + ", showHeader=" + this.f502564b + ", expandAllDividerColor=" + this.f502565c + ", expandAllMaskRes=" + this.f502566d + ", halfFoldExpandHeight=" + this.f502567e + ", ignoreMessageDeepThinkTyping=" + this.f502568f + ')';
    }

    public /* synthetic */ r(DeepThinkFoldStatus r110, Integer r111, Integer r112, Integer r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        DeepThinkFoldStatus r100 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Integer r104 = null;
    L22:
        this(r100, r101, r102, r103, r104, false);
        return;
    L21:
        r104 = r113;
        goto L22
    L17:
        r103 = r112;
        goto L19
    L13:
        r102 = r111;
        goto L15
    L9:
        r101 = false;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public r(DeepThinkFoldStatus r100, boolean r101, Integer r102, Integer r103, Integer r104, boolean r105) {
        this.f502563a = r100;
        this.f502564b = r101;
        this.f502565c = r102;
        this.f502566d = r103;
        this.f502567e = r104;
        this.f502568f = r105;
    }
}
