package hp3;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486389b;

    @Override // hp3.b
    public final Map<String, Object> a() {
        return MapsKt.mapOf(TuplesKt.to("current", this.f486389b));
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "current");
        super("windowTabSwitch");
        this.f486389b = r100;
    }
}
