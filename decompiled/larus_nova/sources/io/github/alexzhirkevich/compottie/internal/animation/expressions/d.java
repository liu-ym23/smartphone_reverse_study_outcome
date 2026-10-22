package io.github.alexzhirkevich.compottie.internal.animation.expressions;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class d extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f490819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, urc.i> f490820d;

    public d() {
        w r100 = new w();
        Intrinsics.checkNotNullParameter(r100, "random");
        this.f490819c = r100;
        this.f490820d = new LinkedHashMap();
    }

    public final void e() {
        ((LinkedHashMap) this.f490816a).clear();
        ((LinkedHashMap) this.f490820d).clear();
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.e
    public final w a() {
        return this.f490819c;
    }
}
