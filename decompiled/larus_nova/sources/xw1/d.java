package xw1;

import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveModuleCrashFixConfig;
import java.util.ArrayList;
import java.util.List;
import jc1.k;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f565210k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f565211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f565212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f565213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f565214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f565215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f565216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f565217g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f565218h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f565219i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String[] f565220j;

    @Override // xw1.c
    public final List<e> a() {
        ArrayList r100 = new ArrayList(1);
        int r101 = 0;
    L4:
        if (r101 >= this.f565211a.length) goto L6;
        e r102 = new e();
        r102.x(this.f565217g[r101]);
        r102.w(this.f565213c[r101]);
        r102.A(this.f565213c[r101]);
        r102.z(this.f565211a[r101]);
        r102.F(this.f565212b[r101]);
        r102.B(this.f565214d[r101]);
        r102.D(this.f565215e[r101]);
        r102.E(this.f565216f[r101]);
        r102.C(this.f565218h[r101]);
        r102.u(this.f565219i[r101]);
        r102.y(this.f565220j[r101]);
        r100.add(r102);
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    static {
        if (LiveModuleCrashFixConfig.getLiveFixHostInitializeNpe() == true) goto L5;
        String r100 = ((INetworkService) k.f(INetworkService.class)).getHostDomain();
    L9:
        f565210k = r100;
        return;
    L5:
        if (k.f(INetworkService.class) == null) goto L7;
        r100 = ((INetworkService) k.f(INetworkService.class)).getHostDomain();
        goto L9
    L7:
        r100 = "webcast.amemv.com";
        goto L9
    }

    public d() {
        this.f565211a = new String[]{"直播"};
        StringBuilder r100 = new StringBuilder("https://");
        String r101 = f565210k;
        r100.append(r101);
        r100.append(FeedApi.DEFAULT_FEED_API);
        this.f565212b = new String[]{r100.toString()};
        this.f565213c = new String[]{"live"};
        new String[]{"live"};
        this.f565214d = new int[]{1};
        int[] r102 = {1};
        this.f565215e = r102;
        this.f565216f = new int[]{1};
        this.f565217g = new int[]{1};
        this.f565218h = new int[]{1001};
        this.f565219i = new int[]{0};
        this.f565220j = new String[]{"https://" + r101 + "/webcast/feed/?cate_id=0&channel_id=21&content_type=0&req_type=0&show_location=0&style=3&sub_channel_id=0&sub_type=live_merge&tab_id=1&type=live"};
        this.f565212b = new String[]{"https://" + r101 + "/webcast/feed/?cate_id=0&channel_id=21&content_type=0&req_type=0&show_location=0&style=2&sub_channel_id=0&sub_type=live_merge&tab_id=1&type=live"};
        r102[0] = 3;
    }
}
