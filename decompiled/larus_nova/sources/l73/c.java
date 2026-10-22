package l73;

import com.bytedance.android.shopping.anchorv4.dto.QuestionnaireEntrance;
import com.bytedance.android.shopping.extensions.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f507786e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f507787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f507788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f507789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f507790d;

    public static final class a {
        public static c a(QuestionnaireEntrance r100) {
            if (r100 != null) goto L4;
        L9:
            return null;
        L4:
            if (r100.getLynxUrl() == null) goto L9;
            if (k.c(r100.getLynxUrl()) == false) goto L9;
            return new c(r100.getLynxUrl(), r100.getHeight(), r100.getWidth(), 8);
        }
    }

    static {
    }

    public c() {
        this(null, null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f507787a, r101.f507787a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f507788b, r101.f507788b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f507789c, r101.f507789c) == true) goto L12;
        return false;
    L12:
        if (this.f507790d == r101.f507790d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f507787a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f507788b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f507789c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.f507790d;
        ?? r110 = r109;
        if (r109 == false) goto L17;
        r110 = 1;
    L17:
        return r108 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "QuestionnaireEntranceVO(lynxUrl=" + this.f507787a + ", height=" + this.f507788b + ", width=" + this.f507789c + ", show=" + this.f507790d + ")";
    }

    public c(String r100, Integer r101, Integer r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r103 & 8) == 0) goto L14;
        boolean r104 = true;
    L15:
        this.f507787a = r100;
        this.f507788b = r101;
        this.f507789c = r102;
        this.f507790d = r104;
        return;
    L14:
        r104 = false;
        goto L15
    }
}
