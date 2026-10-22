package s10;

import android.content.Context;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.yj1;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.ugc.live.sdk.msg.network.l;
import im2.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.j;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements amc.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f540115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, String> f540116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final im2.d f540117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f540118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bc2.a f540119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bc2.e f540120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f540121g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f540122h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<String> f540123i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f540124j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f540125k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e f540126l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f540127m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f540128n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f540129o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<vlc.b> f540130p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<j> f540131q;

    /* JADX INFO: renamed from: s10.a$a, reason: collision with other inner class name */
    public static final class C7554a {
    }

    static {
    }

    @Override // amc.e
    public final List<cmc.b<?>> e() {
        return null;
    }

    public final Map<String, String> f() {
        IHostContext r100 = (IHostContext) k.n(IHostContext.class);
        HashMap r101 = new HashMap(((INetworkService) k.n(INetworkService.class)).getCommonParams());
        r101.put("room_id", String.valueOf(this.f540127m));
        r101.put("rid", String.valueOf(this.f540127m));
        r101.put("aid", String.valueOf(r100.appId()));
        r101.put("user_id", this.f540128n.toString());
        r101.put(DownloadHelper.IDENTITY, this.f540115a);
        r101.put("live_id", String.valueOf(((IHostContext) k.n(IHostContext.class)).liveId()));
        String r102 = this.f540129o;
        if (r102 == null) goto L5;
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_LOG_ROOM_TAG, r102);
    L5:
        r101.putAll(this.f540116b);
        return r101;
    }

    @Override // amc.e
    public final amc.b b() {
        return this.f540124j;
    }

    @Override // amc.e
    public final com.ss.ugc.live.sdk.msg.b c() {
        return this.f540125k;
    }

    @Override // amc.e
    public final amc.i d() {
        return this.f540126l;
    }

    @Override // amc.e
    public final n g() {
        return this.f540118d;
    }

    @Override // amc.e
    public final vlc.c getLogger() {
        return this.f540119e;
    }

    @Override // amc.e
    public final bc2.e getMonitor() {
        return this.f540120f;
    }

    @Override // amc.e
    public final amc.g getNetworkConfig() {
        return this.f540122h;
    }

    @Override // amc.e
    public final long getRoomId() {
        return this.f540127m;
    }

    public a(Context r100, long r101, String r110, boolean r111, List r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "userId");
        this.f540127m = r101;
        this.f540128n = r110;
        this.f540129o = null;
        this.f540130p = r112;
        this.f540131q = null;
        if (r111 == false) goto L5;
        String r102 = "anchor";
    L6:
        this.f540115a = r102;
        this.f540116b = new HashMap();
        this.f540117c = new im2.d(r111);
        Context r103 = r100.getApplicationContext();
        this.f540118d = new n();
        this.f540119e = new bc2.a("BroadcastGame");
        this.f540120f = new bc2.e();
        if (yj1.f121695a.getValue().booleanValue() == true) goto L9;
    L11:
        l r104 = new im2.k(10009, r103, i.f540142a, new f(this), new g(this), new h(this));
    L12:
        this.f540121g = r104;
        this.f540122h = new d(this);
        this.f540123i = CollectionsKt.toSet(d4.m());
        this.f540124j = new b(this);
        this.f540125k = new c(this);
        this.f540126l = new e();
        return;
    L9:
        if (v.a() == false) goto L11;
        r104 = new com.ss.ugc.live.sdk.msg.network.a();
        goto L12
    L5:
        r102 = SourceType.DEFAULT;
        goto L6
    }
}
