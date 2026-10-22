package lx4;

import com.bytedance.ee.bear.contract.NetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f511189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f511190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f511191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f511192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f511193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f511194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f511195g;

    public i(NetService r100) {
        Intrinsics.checkNotNullParameter(r100, "mNetService");
        this.f511189a = r100;
        this.f511190b = "RequestWikiImpl";
        this.f511191c = "/space/api/wiki/v2/space/get_all_space/";
        this.f511192d = "offset";
        this.f511193e = "size";
        this.f511194f = "20";
    }
}
