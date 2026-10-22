package io.ktor.http;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class i implements z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f491873c = null;

    static {
        f491873c = new i();
    }

    public i() {
    }

    @Override // io.ktor.util.p
    public final List<String> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return null;
    }

    @Override // io.ktor.util.p
    public final boolean c() {
        return true;
    }

    @Override // io.ktor.util.p
    public final boolean isEmpty() {
        return true;
    }

    public final String toString() {
        return "Parameters " + SetsKt.emptySet();
    }

    @Override // io.ktor.util.p
    public final Set<Map.Entry<String, List<String>>> entries() {
        return SetsKt.emptySet();
    }

    @Override // io.ktor.util.p
    public final Set<String> names() {
        return SetsKt.emptySet();
    }

    @Override // io.ktor.util.p
    public final void d(Function2<? super String, ? super List<String>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
        io.ktor.util.p.a.a(this, r100);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof z) == true) goto L5;
    L7:
        return false;
    L5:
        if (((z) r100).isEmpty() == false) goto L7;
        return true;
    }

    @Override // io.ktor.util.p
    public final String get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r100, "name");
        a(r100);
        return null;
    }
}
