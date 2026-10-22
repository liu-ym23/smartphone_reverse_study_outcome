package se7;

import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.network.RequestMethod;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import te7.h;
import te7.j;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f541605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedHashMap<String, String> f541606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f541607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f541608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f541609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f541610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f541611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f541612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f541613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinkedHashMap<String, File> f541614j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f541615k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f541616l;

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f541605a = r100;
        this.f541616l = -1;
    }

    public final j a(IHostNetworkDepend r100) {
        Intrinsics.checkNotNullParameter(r100, "hostNetworkDepend");
        h r101 = h.f545610a;
        RequestMethod r102 = RequestMethod.POST;
        r101.getClass();
        return h.f(r102, this, r100);
    }
}
