package lx4;

import com.bytedance.ee.bear.contract.NetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i {
    public final NetService a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public int g;

    public i(NetService r2) {
        Intrinsics.checkNotNullParameter(r2, "mNetService");
        this.a = r2;
        this.b = "RequestWikiImpl";
        this.c = "/space/api/wiki/v2/space/get_all_space/";
        this.d = "offset";
        this.e = "size";
        this.f = "20";
    }
}
