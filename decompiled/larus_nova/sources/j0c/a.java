package j0c;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f496839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f496840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f496841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<c> f496842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f496843e;

    public a() {
        this(false, null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f496839a == r101.f496839a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f496840b, r101.f496840b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f496841c, r101.f496841c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f496842d, r101.f496842d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f496843e, r101.f496843e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.f496839a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f496840b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (((((r101 + r104) * 31) + this.f496841c.hashCode()) * 31) + this.f496842d.hashCode()) * 31;
        c r106 = this.f496843e;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ExecuteTaskResult(isSuccess=" + this.f496839a + ", errorMessage=" + this.f496840b + ", successTaskResults=" + this.f496841c + ", errorTaskResults=" + this.f496842d + ", blockTaskResult=" + this.f496843e + ')';
    }

    public final a a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        if (this.f496839a == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        String r102 = this.f496840b + r100.f496840b;
        List r103 = CollectionsKt.plus(this.f496841c, r100.f496841c);
        List r104 = CollectionsKt.plus(this.f496842d, r100.f496842d);
        c r105 = this.f496843e;
        if (r105 == null) goto L13;
        if (r105 == null) goto L13;
        c r106 = r105;
    L15:
        return new a(r101, r102, r103, r104, r106);
    L13:
        r106 = r100.f496843e;
        goto L15
    L5:
        if (r100.f496839a == false) goto L7;
        r101 = true;
        goto L8
    }

    public /* synthetic */ a(boolean r100, String r101, List r102, List r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        boolean r103 = false;
    L7:
        if ((r111 & 2) == 0) goto L9;
        r101 = "";
    L9:
        String r104 = r101;
        if ((r111 & 4) == 0) goto L12;
        r102 = CollectionsKt.emptyList();
    L12:
        List r105 = r102;
        if ((r111 & 8) == 0) goto L15;
        r110 = CollectionsKt.emptyList();
    L15:
        this(r103, r104, r105, r110, null);
        return;
    L5:
        r103 = r100;
        goto L7
    }

    public a(boolean r100, String r101, List<c> r102, List<c> r103, c r104) {
        Intrinsics.checkNotNullParameter(r102, "successTaskResults");
        Intrinsics.checkNotNullParameter(r103, "errorTaskResults");
        this.f496839a = r100;
        this.f496840b = r101;
        this.f496841c = r102;
        this.f496842d = r103;
        this.f496843e = r104;
    }
}
