package wk;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f560060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f560061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f560062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f560063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f560064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f560065f;

    public c() {
        this(null, null, 0, 0, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f560060a, r101.f560060a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f560061b, r101.f560061b) == true) goto L10;
        return false;
    L10:
        if (this.f560062c == r101.f560062c) goto L12;
        return false;
    L12:
        if (this.f560063d == r101.f560063d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f560064e, r101.f560064e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f560065f, r101.f560065f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f560060a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f560061b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((r103 + r105) * 31) + this.f560062c) * 31) + this.f560063d) * 31;
        String r107 = this.f560064e;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f560065f;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECShoppingCartTaskEvent(taskId=" + this.f560060a + ", taskMetaId=" + this.f560061b + ", taskStatus=" + this.f560062c + ", taskScene=" + this.f560063d + ", taskGuideMsg=" + this.f560064e + ", passThroughJson=" + this.f560065f + ")";
    }

    public /* synthetic */ c(String r110, String r111, int r112, int r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r114 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r114 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r105 = "";
    L26:
        this(r100, r101, r102, r103, r104, r105);
        return;
    L25:
        r105 = null;
        goto L26
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public c(String r100, String r101, int r102, int r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "taskMetaId");
        Intrinsics.checkNotNullParameter(r104, "taskGuideMsg");
        Intrinsics.checkNotNullParameter(r105, "passThroughJson");
        this.f560060a = r100;
        this.f560061b = r101;
        this.f560062c = r102;
        this.f560063d = r103;
        this.f560064e = r104;
        this.f560065f = r105;
    }
}
