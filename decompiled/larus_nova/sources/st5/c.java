package st5;

import android.net.Uri;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f543563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f543564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f543565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f543566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<com.bytedance.lark.inject_request_android.b> f543567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f543568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f543569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f543570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f543571i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f543572j;

    public c(long r110, long r111, Uri r112, String r113, int r210, List r211, boolean r212, String r213, byte[] r214, int r215, String r216, int r217) {
        long r100 = 0;
        if ((r217 & 1) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r217 & 2) != 0) goto L11;
        r100 = r111;
    L11:
        if ((r217 & 128) == 0) goto L13;
        String r102 = "OK";
    L15:
        if ((r217 & 256) == 0) goto L17;
        byte[] r103 = null;
    L19:
        if ((r217 & 512) == 0) goto L21;
        int r114 = 0;
    L23:
        if ((r217 & 1024) == 0) goto L25;
        String r104 = "";
    L26:
        Intrinsics.checkNotNullParameter(r112, "uri");
        Intrinsics.checkNotNullParameter(r113, "requestId");
        Intrinsics.checkNotNullParameter(r211, "headers");
        Intrinsics.checkNotNullParameter(r102, "reason");
        Intrinsics.checkNotNullParameter(r104, "errorMsg");
        this.f543563a = r101;
        this.f543564b = r100;
        this.f543565c = r112;
        this.f543566d = r210;
        this.f543567e = r211;
        this.f543568f = r212;
        this.f543569g = r102;
        this.f543570h = r103;
        this.f543571i = r114;
        this.f543572j = r104;
        return;
    L25:
        r104 = r216;
        goto L26
    L21:
        r114 = r215;
        goto L23
    L17:
        r103 = r214;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }
}
