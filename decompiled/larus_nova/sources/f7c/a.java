package f7c;

import com.ss.android.lark.notification.export.entity.Notice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends Notice {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f475819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f475820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f475821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f475822d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f475819a, r101.f475819a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f475820b, r101.f475820b) == true) goto L15;
        return false;
    L15:
        if (this.f475821c == r101.f475821c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f475822d, r101.f475822d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f475819a.hashCode() * 31) + this.f475820b.hashCode()) * 31;
        long r101 = this.f475821c;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f475822d.hashCode();
    }

    public final String toString() {
        return "TodoNotice(guid=" + this.f475819a + ", summary=" + this.f475820b + ", dueTime=" + this.f475821c + ", dueTimezone=" + this.f475822d + ')';
    }

    public a(String r100, String r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        Intrinsics.checkNotNullParameter(r101, "summary");
        Intrinsics.checkNotNullParameter(r103, "dueTimezone");
        this.f475819a = r100;
        this.f475820b = r101;
        this.f475821c = r102;
        this.f475822d = r103;
    }
}
