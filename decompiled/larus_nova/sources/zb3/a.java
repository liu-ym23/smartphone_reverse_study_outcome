package zb3;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f571127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f571128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f571129d;

    public a() {
        this(null, false, 0, 15);
    }

    public /* synthetic */ a(String r100, boolean r110, long r111, int r112) {
        String r101 = "";
        if ((r112 & 1) == 0) goto L5;
        String r102 = "";
    L7:
        if ((r112 & 2) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r112 & 4) == 0) goto L13;
        r111 = 0;
    L13:
        long r104 = r111;
        if ((r112 & 8) != 0) goto L17;
        r101 = null;
    L17:
        this(r102, r103, r104, r101);
        return;
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }

    public a(String r100, boolean r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, ReportConstant.COMMON_ACTION_TYPE);
        this.f571126a = r100;
        this.f571127b = r101;
        this.f571128c = r102;
        this.f571129d = r103;
    }
}
