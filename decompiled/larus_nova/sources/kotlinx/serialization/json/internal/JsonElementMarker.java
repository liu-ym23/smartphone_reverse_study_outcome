package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class JsonElementMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nuc.d0 f505372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f505373b;

    public JsonElementMarker(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        this.f505372a = new nuc.d0(r100, new JsonElementMarker$origin$1(this));
    }
}
