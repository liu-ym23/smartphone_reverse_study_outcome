package j14;

import com.bytedance.awemeopen.bizmodels.user.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import q34.b;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements Function1<b, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f496862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<b, Unit> f496863b;

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(b r100) {
        b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "c");
        f r102 = this.f496862a;
        if (r102 == null) goto L6;
        r102.f198225d = true;
    L6:
        this.f496863b.invoke(r101);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(f r100, Function1<? super b, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "incomeCall");
        this.f496862a = r100;
        this.f496863b = r101;
    }
}
