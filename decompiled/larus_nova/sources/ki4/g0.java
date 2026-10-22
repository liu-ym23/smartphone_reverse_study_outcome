package ki4;

import com.bytedance.creativex.mediaimport.repository.api.MultivariateOperator;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g0 extends j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f503625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MultivariateOperator f503626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f503627d;

    @Override // ki4.j0
    public final String b() {
        StringBuilder r100 = new StringBuilder(this.f503625b + ' ' + this.f503626c.getOption() + ' ');
        Iterator<Integer> r101 = ArraysKt.getIndices(this.f503627d).iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        int r102 = ((IntIterator) r101).nextInt();
        if (r102 == 0) goto L7;
        if (r102 == ArraysKt.getLastIndex(this.f503627d)) goto L10;
        r100.append(",?");
        goto L4
    L10:
        r100.append(",?)");
        goto L4
    L7:
        r100.append("(?");
        goto L4
    L13:
        return r100.toString();
    }

    @Override // ki4.j0
    public final j0 c() {
        String r100 = this.f503625b;
        MultivariateOperator r101 = this.f503626c;
        String[] r102 = this.f503627d;
        Intrinsics.checkNotNullParameter(r100, "column");
        Intrinsics.checkNotNullParameter(r101, OnekeyLoginConstants.CU_KEY_OPERATOR);
        Intrinsics.checkNotNullParameter(r102, "values");
        return new g0(r100, r101, r102);
    }

    public final int hashCode() {
        return (((this.f503625b.hashCode() * 31) + this.f503626c.hashCode()) * 31) + Arrays.hashCode(this.f503627d);
    }

    @Override // ki4.j0
    public final String[] a() {
        return this.f503627d;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(g0.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.creativex.mediaimport.repository.api.MultivariateOperatorSelection");
        g0 r102 = (g0) r100;
        if (Intrinsics.areEqual(this.f503625b, r102.f503625b) == true) goto L16;
        return false;
    L16:
        if (this.f503626c == r102.f503626c) goto L19;
        return false;
    L19:
        if (Arrays.equals(this.f503627d, r102.f503627d) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public g0(String r100, MultivariateOperator r101, String[] r102) {
        Intrinsics.checkNotNullParameter(r100, "column");
        Intrinsics.checkNotNullParameter(r101, OnekeyLoginConstants.CU_KEY_OPERATOR);
        Intrinsics.checkNotNullParameter(r102, "values");
        this.f503625b = r100;
        this.f503626c = r101;
        this.f503627d = r102;
    }
}
