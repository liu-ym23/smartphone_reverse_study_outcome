package ex7;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, a<?>> f474722a;

    public d() {
        this.f474722a = new LinkedHashMap();
    }

    public final <T> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        a r101 = (a) ((LinkedHashMap) this.f474722a).get(r100);
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

    public final <T> void b(Class<T> r100, a<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        a<? extends T> r102 = (a) ((LinkedHashMap) this.f474722a).get(r100);
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
        this.f474722a.put(r100, r101);
    }
}
