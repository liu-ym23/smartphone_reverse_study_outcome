package ic3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f489157a;

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam(this.f489157a);
    }

    public a(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "trackParams");
        super(r100);
        this.f489157a = r101;
    }
}
