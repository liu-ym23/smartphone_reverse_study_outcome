package is8;

import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f495677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f495678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f495679e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f495680f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f495675a, r101.f495675a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495676b, r101.f495676b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495677c, r101.f495677c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495678d, r101.f495678d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f495679e, r101.f495679e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f495680f, r101.f495680f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f495675a.hashCode() * 31) + this.f495676b.hashCode()) * 31;
        String r101 = this.f495677c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        l r105 = this.f495678d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f495679e.hashCode()) * 31;
        k r108 = this.f495680f;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "UploadResult(taskId=" + this.f495675a + ", remoteKey=" + this.f495676b + ", resourceId=" + this.f495677c + ", mediaMeta=" + this.f495678d + ", route=" + this.f495679e + ", traceSnapshot=" + this.f495680f + ')';
    }

    public h(String r100, String r101, String r102, l r103, a r104, k r105) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "remoteKey");
        Intrinsics.checkNotNullParameter(r104, CloudControlInf.ROUTE);
        this.f495675a = r100;
        this.f495676b = r101;
        this.f495677c = r102;
        this.f495678d = r103;
        this.f495679e = r104;
        this.f495680f = r105;
    }
}
