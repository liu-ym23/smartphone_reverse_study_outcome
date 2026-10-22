package w8;

import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements e {
    public b() {
    }

    @Override // w8.e
    public final void b(String r100, JSONArray r101, Function1<? super String, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, "stateSubscriber");
    }

    @Override // w8.e
    public final void release() {
    }

    @Override // w8.e
    public final Map<String, Object> a() {
        return MapsKt.emptyMap();
    }
}
