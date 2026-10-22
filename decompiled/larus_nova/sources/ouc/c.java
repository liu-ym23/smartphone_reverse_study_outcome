package ouc;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonDslMarker;

/* JADX INFO: loaded from: classes5.dex */
@JsonDslMarker
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i> f526807a;

    public c() {
        this.f526807a = new ArrayList();
    }

    public final void a(i r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        ((ArrayList) this.f526807a).add(r100);
    }
}
