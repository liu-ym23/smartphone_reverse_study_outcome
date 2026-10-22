package v26;

import com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient;
import com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f552680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f552681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f552682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f552683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f552684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f552685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final GeckoConfig f552686g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, GeckoConfig> f552687h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f552688i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f552689j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f552690k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f552691l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f552692m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f552693n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f552694o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<String> f552695p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<String, String> f552696q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b26.a f552697r;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("{[host]=");
        r100.append(this.f552680a);
        r100.append(",[region]=");
        r100.append(this.f552681b);
        r100.append(",[prefix]=");
        Object[] r101 = this.f552682c.toArray(new String[0]);
        if (r101 == null) goto L7;
        r100.append(Arrays.toString(r101));
        r100.append(",[appId]=");
        r100.append(this.f552683d);
        r100.append(",[appVersion]=");
        r100.append(this.f552684e);
        r100.append(",[did]=");
        r100.append(this.f552685f);
        r100.append('}');
        return r100.toString();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final GeckoConfig a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "ak");
        GeckoConfig r101 = this.f552687h.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return this.f552686g;
    }

    public j(String r100, String r101, List r102, String r103, String r104, String r105, GeckoConfig r106, Map r110, com.bytedance.ies.bullet.kit.resourceloader.c r111, OfflineResourceClient.NetWorkImpl r112, OfflineResourceClient.NetWorkImpl r113, int r114) {
        if ((r114 & 128) == 0) goto L6;
        r110 = new LinkedHashMap();
    L6:
        if ((r114 & 512) == 0) goto L9;
        r112 = null;
    L9:
        if ((r114 & 1024) == 0) goto L11;
        r113 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, EffectConfiguration.KEY_REGION);
        Intrinsics.checkNotNullParameter(r102, "prefix");
        Intrinsics.checkNotNullParameter(r103, "appId");
        Intrinsics.checkNotNullParameter(r104, "appVersion");
        Intrinsics.checkNotNullParameter(r105, com.bytedance.android.ec.core.event.a.KEY_DID);
        Intrinsics.checkNotNullParameter(r106, "dftGeckoCfg");
        Intrinsics.checkNotNullParameter(r110, "geckoConfigs");
        Intrinsics.checkNotNullParameter(r111, "downloadDepender");
        this.f552680a = r100;
        this.f552681b = r101;
        this.f552682c = r102;
        this.f552683d = r103;
        this.f552684e = r104;
        this.f552685f = r105;
        this.f552686g = r106;
        this.f552687h = r110;
        this.f552688i = r111;
        this.f552689j = r112;
        this.f552690k = r113;
        this.f552691l = 10;
        this.f552692m = 25165824;
        this.f552694o = true;
        this.f552695p = new ArrayList();
        this.f552696q = new LinkedHashMap();
        this.f552697r = new i();
    }
}
