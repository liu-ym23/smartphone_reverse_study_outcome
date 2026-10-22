package ki4;

import com.bytedance.creativex.mediaimport.repository.api.UnaryOperator;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class l0 extends j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f503634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UnaryOperator f503635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f503636d;

    @Override // ki4.j0
    public final String[] a() {
        return new String[]{this.f503636d};
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.f503634b, r101.f503634b) == true) goto L12;
        return false;
    L12:
        if (this.f503635c == r101.f503635c) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f503636d, r101.f503636d) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f503634b.hashCode() * 31) + this.f503635c.hashCode()) * 31) + this.f503636d.hashCode();
    }

    @Override // ki4.j0
    public final String b() {
        return this.f503634b + ' ' + this.f503635c.getOption() + " ?";
    }

    @Override // ki4.j0
    public final j0 c() {
        String r100 = this.f503634b;
        UnaryOperator r101 = this.f503635c;
        String r102 = this.f503636d;
        Intrinsics.checkNotNullParameter(r100, "column");
        Intrinsics.checkNotNullParameter(r101, OnekeyLoginConstants.CU_KEY_OPERATOR);
        Intrinsics.checkNotNullParameter(r102, "value");
        return new l0(r100, r101, r102);
    }

    public l0(String r100, UnaryOperator r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "column");
        Intrinsics.checkNotNullParameter(r101, OnekeyLoginConstants.CU_KEY_OPERATOR);
        Intrinsics.checkNotNullParameter(r102, "value");
        this.f503634b = r100;
        this.f503635c = r101;
        this.f503636d = r102;
    }
}
