package okio;

import com.byted.cast.common.Constants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f524017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f524018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f524019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f524020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f524021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g0 f524022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g0 f524023g;

    public static final class a {
    }

    static {
    }

    public final g0 c() {
        this.f524020d = true;
        return new g0(this.f524017a, this.f524018b, this.f524019c, true, false);
    }

    public final g0 a() {
        g0 r100 = this.f524022f;
        if (r100 != this) goto L6;
        r100 = null;
    L6:
        g0 r101 = this.f524023g;
        Intrinsics.checkNotNull(r101);
        r101.f524022f = this.f524022f;
        g0 r102 = this.f524022f;
        Intrinsics.checkNotNull(r102);
        r102.f524023g = this.f524023g;
        this.f524022f = null;
        this.f524023g = null;
        return r100;
    }

    public g0() {
        this.f524017a = new byte[8192];
        this.f524021e = true;
        this.f524020d = false;
    }

    public final void b(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, MonitorConstants.SEGMENT);
        r100.f524023g = this;
        r100.f524022f = this.f524022f;
        g0 r101 = this.f524022f;
        Intrinsics.checkNotNull(r101);
        r101.f524023g = r100;
        this.f524022f = r100;
    }

    public final void d(g0 r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        if (r100.f524021e == false) goto L18;
        int r101 = r100.f524019c;
        if ((r101 + r110) > 8192) goto L7;
    L15:
        byte[] r102 = this.f524017a;
        byte[] r103 = r100.f524017a;
        int r104 = r100.f524019c;
        int r105 = this.f524018b;
        ArraysKt.copyInto(r102, r103, r104, r105, r105 + r110);
        r100.f524019c += r110;
        this.f524018b += r110;
        return;
    L7:
        if (r100.f524020d == true) goto L14;
        int r106 = r100.f524018b;
        if (((r101 + r110) - r106) > 8192) goto L12;
        byte[] r107 = r100.f524017a;
        ArraysKt.copyInto$default(r107, r107, 0, r106, r101, 2, null);
        r100.f524019c -= r100.f524018b;
        r100.f524018b = 0;
        goto L15
    L12:
        throw new IllegalArgumentException();
    L14:
        throw new IllegalArgumentException();
    L18:
        throw new IllegalStateException("only owner can write".toString());
    }

    public g0(byte[] r100, int r101, int r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f524017a = r100;
        this.f524018b = r101;
        this.f524019c = r102;
        this.f524020d = r103;
        this.f524021e = r104;
    }
}
