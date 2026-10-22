package zac;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f571111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f571112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f571113d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f571110a, r101.f571110a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f571111b, r101.f571111b) == true) goto L15;
        return false;
    L15:
        if (this.f571112c == r101.f571112c) goto L18;
        return false;
    L18:
        if (this.f571113d == r101.f571113d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f571110a.hashCode() * 31) + this.f571111b.hashCode()) * 31) + this.f571112c) * 31;
        if (this.f571113d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "VoiceAsrResult(taskId=" + this.f571110a + ", content=" + this.f571111b + ", sequenceId=" + this.f571112c + ", isFinish=" + this.f571113d + ')';
    }

    public a() {
        this("", new c(null), 0, false);
    }

    public a(String r100, c r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "content");
        this.f571110a = r100;
        this.f571111b = r101;
        this.f571112c = r102;
        this.f571113d = r103;
    }
}
