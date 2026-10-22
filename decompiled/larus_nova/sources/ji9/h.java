package ji9;

import android.view.View;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f499242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f499243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<View> f499244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f499245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Integer> f499246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f499247f;

    public static final class a {
    }

    static {
    }

    public h(ii9.a r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f499242a = r100;
        this.f499243b = LazyKt.lazy(new g());
        this.f499244c = r100.f490001a;
        this.f499245d = ArraysKt.sortedArrayDescending(r100.f490004d);
        this.f499246e = r100.f490005e;
        this.f499247f = r100.f490007g;
    }

    public final boolean a(String r100, float r101) {
        if (StringsKt.isBlank(r100) == false) goto L5;
        return false;
    L5:
        Float r102 = (Float) ((Map) this.f499243b.getValue()).get(r100);
        if (r102 == null) goto L8;
        float r103 = r102.floatValue();
    L10:
        if (r103 < r101) goto L13;
        return true;
    L13:
        return false;
    L8:
        r103 = -1.0f;
        goto L10
    }
}
