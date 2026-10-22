package fuc;

import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.format.DateTimeFormatter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.datetime.DateTimeFormatException;

/* JADX INFO: loaded from: classes42.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f478943a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f478944b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f478945c = null;

    static {
        f478943a = LazyKt.lazy(new k());
        f478944b = LazyKt.lazy(new l());
        f478945c = LazyKt.lazy(new m());
    }

    public static final j a(CharSequence r100, DateTimeFormatter r101) {
        return new j((ZoneOffset) r101.c(r100, new n()));
    L4:
        e = move-exception;
        throw new DateTimeFormatException(e);
    }
}
