package i0c;

import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e<S, C, R> implements d<S, C, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f487920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S f487921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b<S, C, R> f487922c;

    @Override // i0c.d
    public final S getFrom() {
        return this.f487920a;
    }

    @Override // i0c.d
    public final S getTo() {
        return this.f487921b;
    }

    @Override // i0c.d
    public final h0c.b a(UpdateUserContext r100) {
        return this.f487922c.a(r100, this.f487920a, this.f487921b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Object r100, Object r101, com.ss.android.lark.passportc.impl.v2.action.d r102) {
        Intrinsics.checkNotNullParameter(r102, "action");
        this.f487920a = r100;
        this.f487921b = r101;
        this.f487922c = r102;
    }
}
