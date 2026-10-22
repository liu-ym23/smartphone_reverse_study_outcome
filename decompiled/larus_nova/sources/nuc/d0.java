package nuc;

import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.CoreFriendModuleApi;

/* JADX INFO: loaded from: classes5.dex */
@CoreFriendModuleApi
public final class d0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long[] f520653e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final luc.f f520654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<luc.f, Integer, Boolean> f520655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f520656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f520657d;

    public static final class a {
    }

    static {
        f520653e = new long[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d0(luc.f r100, Function2<? super luc.f, ? super Integer, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        Intrinsics.checkNotNullParameter(r101, "readIfAbsent");
        this.f520654a = r100;
        this.f520655b = r101;
        int r102 = r100.d();
        long r103 = 0;
        if (r102 > 64) goto L8;
        if (r102 == 64) goto L7;
        r103 = (-1) << r102;
    L7:
        this.f520656c = r103;
        this.f520657d = f520653e;
        return;
    L8:
        this.f520656c = 0;
        long[] r104 = new long[(r102 - 1) >>> 6];
        if ((r102 & 63) == 0) goto L11;
        r104[ArraysKt.getLastIndex(r104)] = (-1) << r102;
    L11:
        this.f520657d = r104;
    }
}
