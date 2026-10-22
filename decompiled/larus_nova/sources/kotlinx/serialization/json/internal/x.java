package kotlinx.serialization.json.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class x extends g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ouc.i f505465g;

    @Override // kotlinx.serialization.json.internal.g
    public final ouc.i q() {
        ouc.i r100 = this.f505465g;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Primitive element has not been recorded. Is call to .encodeXxx is missing in serializer?".toString());
    }

    public x(ouc.a r100, Function1<? super ouc.i, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "nodeConsumer");
        super(r100, r101);
        this.f520801a.add("primitive");
    }

    @Override // kotlinx.serialization.json.internal.g
    public final void r(String r100, ouc.i r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "element");
        boolean r102 = true;
        if (r100 != "primitive") goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L17;
        if (this.f505465g == null) goto L11;
        r102 = false;
    L11:
        if (r102 == false) goto L15;
        this.f505465g = r101;
        this.f505406c.invoke(r101);
        return;
    L15:
        throw new IllegalArgumentException("Primitive element was already recorded. Does call to .encodeXxx happen more than once?".toString());
    L17:
        throw new IllegalArgumentException("This output can only consume primitives with 'primitive' tag".toString());
    L5:
        r103 = false;
        goto L6
    }
}
