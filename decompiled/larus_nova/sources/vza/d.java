package vza;

import com.ss.android.lark.blueprint.p;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, p> f557758a;

    public d() {
        this.f557758a = new LinkedHashMap();
    }

    public final <EnvType extends p> EnvType a(Class<EnvType> r100) {
        Intrinsics.checkNotNullParameter(r100, "clz");
        Object r101 = ((LinkedHashMap) this.f557758a).get(r100);
        if ((r101 instanceof p) == true) goto L7;
        return null;
    L7:
        return (EnvType) r101;
    }
}
