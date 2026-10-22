package lc5;

import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.list.dto.Document;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f508489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AccountService$Account f508490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Document f508492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f508493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f508494f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f508489a, r101.f508489a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508490b, r101.f508490b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508491c, r101.f508491c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508492d, r101.f508492d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508493e, r101.f508493e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f508494f, r101.f508494f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f508489a.hashCode() * 31;
        AccountService$Account r101 = this.f508490b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((((((r100 + r102) * 31) + this.f508491c.hashCode()) * 31) + this.f508492d.hashCode()) * 31) + this.f508493e.hashCode()) * 31) + this.f508494f.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ReportLeftSideClickParam(analyticService=" + this.f508489a + ", account=" + this.f508490b + ", action=" + this.f508491c + ", document=" + this.f508492d + ", module=" + this.f508493e + ", source=" + this.f508494f + ')';
    }

    public n(com.bytedance.ee.bear.contract.d r100, AccountService$Account r101, String r102, Document r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "analyticService");
        Intrinsics.checkNotNullParameter(r102, "action");
        Intrinsics.checkNotNullParameter(r103, "document");
        Intrinsics.checkNotNullParameter(r104, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r105, "source");
        this.f508489a = r100;
        this.f508490b = r101;
        this.f508491c = r102;
        this.f508492d = r103;
        this.f508493e = r104;
        this.f508494f = r105;
    }
}
