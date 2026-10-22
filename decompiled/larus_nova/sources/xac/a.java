package xac;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f563099a;

    public final String toString() {
        return "VoiceContext(size=" + this.f563099a.size() + ')';
    }

    public a() {
        this.f563099a = new LinkedHashMap();
    }

    public final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (String) a(r100, Reflection.getOrCreateKotlinClass(String.class));
    }

    public final <T> T a(String r100, KClass<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        T r102 = (T) ((LinkedHashMap) this.f563099a).get(r100);
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r101.isInstance(r102) == false) goto L9;
        return r102;
    L9:
        return null;
    }

    public final void c(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if ((!StringsKt.isBlank(r100)) == false) goto L8;
        if (r101 != null) goto L6;
        this.f563099a.remove(r100);
        return;
    L6:
        this.f563099a.put(r100, r101);
        return;
    }
}
