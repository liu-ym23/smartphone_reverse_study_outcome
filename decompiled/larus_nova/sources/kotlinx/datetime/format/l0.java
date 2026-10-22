package kotlinx.datetime.format;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;

/* JADX INFO: loaded from: classes42.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f505225a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f505226b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c0 f505227c = null;

    static {
        f505225a = LazyKt.lazy(new h0());
        f505226b = LazyKt.lazy(new i0());
        f505227c = new c0(null, null, null, null);
    }

    public static final void a(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100 == null) goto L6;
        return;
    L6:
        throw new DateTimeFormatException("Can not create a " + r101 + " from the given input: the field " + r101 + " is missing");
    }
}
