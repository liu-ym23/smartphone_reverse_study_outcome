package mpa;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements Function1<Object, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Object, Unit> f514749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f514750b;

    /* JADX WARN: Type inference failed for: r2v1, types: [mpa.b] */
    public c(Function1<Object, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f514749a = r100;
        this.f514750b = new b(this);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Object r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f514749a.invoke(r100);
        return Unit.INSTANCE;
    }
}
