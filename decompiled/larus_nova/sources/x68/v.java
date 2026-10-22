package x68;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class v implements Function1<Map<String, Object>, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f562700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f562701b;

    public v(String r100, Map<String, ? extends Object> r101) {
        this.f562700a = r100;
        this.f562701b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Map<String, Object> r100) {
        Map<String, Object> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "$this$params2");
        r101.put("type", this.f562700a);
        r101.putAll(this.f562701b);
        return Unit.INSTANCE;
    }
}
