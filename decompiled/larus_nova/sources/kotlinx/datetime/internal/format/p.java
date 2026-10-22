package kotlinx.datetime.internal.format;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class p<Target, Type> extends a<Target, Type> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<Target, Type> f505293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f505294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type f505295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l<Target> f505296d;

    @Override // kotlinx.datetime.internal.format.m
    public final b<Target, Type> a() {
        return this.f505293a;
    }

    @Override // kotlinx.datetime.internal.format.m
    public final Type getDefaultValue() {
        return this.f505295c;
    }

    @Override // kotlinx.datetime.internal.format.m
    public final String getName() {
        return this.f505294b;
    }

    @Override // kotlinx.datetime.internal.format.m
    public final l<Target> getSign() {
        return this.f505296d;
    }

    public p(t r100, guc.a r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        String r103 = r100.getName();
    L6:
        Object r104 = r101;
        if ((r102 & 4) == 0) goto L9;
        r104 = (Type) null;
    L9:
        Intrinsics.checkNotNullParameter(r100, "accessor");
        Intrinsics.checkNotNullParameter(r103, "name");
        this.f505293a = r100;
        this.f505294b = r103;
        this.f505295c = (Type) r104;
        this.f505296d = null;
        return;
    L5:
        r103 = null;
        goto L6
    }
}
