package kotlinx.datetime.format;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class TimeFields {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.datetime.internal.format.w<d1> f505189a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlinx.datetime.internal.format.w<d1> f505190b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final kotlinx.datetime.internal.format.w<d1> f505191c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final kotlinx.datetime.internal.format.p<d1, guc.a> f505192d = null;

    static {
        f505189a = new kotlinx.datetime.internal.format.w(new kotlinx.datetime.internal.format.t(TimeFields$hour$1.INSTANCE), 0, 23, null, null, 56);
        f505190b = new kotlinx.datetime.internal.format.w(new kotlinx.datetime.internal.format.t(TimeFields$minute$1.INSTANCE), 0, 59, null, null, 56);
        f505191c = new kotlinx.datetime.internal.format.w(new kotlinx.datetime.internal.format.t(TimeFields$second$1.INSTANCE), 0, 59, 0, null, 40);
        f505192d = new kotlinx.datetime.internal.format.p(new kotlinx.datetime.internal.format.t(TimeFields$fractionOfSecond$1.INSTANCE), new guc.a(0, 9), 10);
        kotlinx.datetime.internal.format.t r100 = new kotlinx.datetime.internal.format.t(TimeFields$amPm$1.INSTANCE);
        String r101 = r100.getName();
        Intrinsics.checkNotNullParameter(r100, "accessor");
        Intrinsics.checkNotNullParameter(r101, "name");
        kotlinx.datetime.internal.format.t r102 = new kotlinx.datetime.internal.format.t(TimeFields$hourOfAmPm$1.INSTANCE);
        String r103 = r102.getName();
        Intrinsics.checkNotNullParameter(r102, "accessor");
        Intrinsics.checkNotNullParameter(r103, "name");
    }
}
