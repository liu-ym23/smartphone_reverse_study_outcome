package io.ktor.http;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "Empty headers is internal", replaceWith = @ReplaceWith(expression = "Headers.Empty", imports = {}))
public final class h implements n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f491872c = null;

    static {
        f491872c = new h();
    }

    public h() {
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

    public final String toString() {
        return "Headers " + SetsKt.emptySet();
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

    @Override // io.ktor.util.p
    public final String get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r100, "name");
        a(r100);
        return null;
    }
}
