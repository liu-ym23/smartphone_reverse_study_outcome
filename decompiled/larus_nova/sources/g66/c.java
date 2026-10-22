package g66;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, a<?>> f480166a;

    public final void g() {
        ((LinkedHashMap) this.f480166a).clear();
    }

    public c() {
        this.f480166a = new LinkedHashMap();
    }

    public final <T> a<T> a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        a<T> r101 = (a) ((LinkedHashMap) this.f480166a).get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101;
    }

    public final <T> boolean b(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return this.f480166a.containsKey(r100);
    }

    public final <T> T c(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        a r101 = (a) ((LinkedHashMap) this.f480166a).get(r100);
        if (r101 == null) goto L13;
        Object r102 = r101.provideInstance();
        if (r102 != null) goto L7;
        return null;
    L7:
        if (r100.isAssignableFrom(r102.getClass()) == true) goto L10;
        r102 = null;
    L10:
        if (r102 != null) goto L12;
        return null;
    L12:
        return (T) r102;
    L13:
        return null;
    }

    public final <T> void d(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        e(r100, new b(r101));
    }

    public final <T> void e(Class<T> r100, a<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        a<? extends T> r102 = (a) ((LinkedHashMap) this.f480166a).get(r100);
        if (r102 == null) goto L12;
        if (r102 != r101) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L12;
        r102.release();
        goto L12
    L6:
        r103 = false;
    L12:
        this.f480166a.put(r100, r101);
    }

    public final <T> void f(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        e(r100, new d(r101));
    }
}
