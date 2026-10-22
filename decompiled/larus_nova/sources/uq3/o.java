package uq3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.common.floatelement.WindowCartEntryConfig;
import com.bytedance.android.ec.window.base.common.headlive.WindowV3LiveRoomVO;
import com.bytedance.android.ec.window.base.repository.vo.WindowAuthorReputationVO;
import com.bytedance.android.ec.window.base.shop.WindowFansClubInfo;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class o {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f551249x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f551250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WindowCartEntryConfig f551251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f551252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f551253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WindowAuthorReputationVO f551254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WindowV3LiveRoomVO f551255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ECUrlModel f551256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f551257h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f551258i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f551259j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f551260k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f551261l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ECUrlModel f551262m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public WindowFansClubInfo f551263n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f551264o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Boolean f551265p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Map<String, String> f551266q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<p> f551267r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public k f551268s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List<e> f551269t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f551270u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public m f551271v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Map<String, ? extends List<String>> f551272w;

    public static final class a {
        public a() {
        }
    }

    static {
        f551249x = new a();
    }

    public final boolean a() {
        Map<String, String> r100 = this.f551266q;
        if (r100 == null) goto L5;
        String r101 = r100.get("header_living_state_optimize");
    L7:
        return Intrinsics.areEqual(r101, "1");
    L5:
        r101 = null;
        goto L7
    }

    public o() {
        this.f551261l = "的橱窗";
        this.f551265p = Boolean.FALSE;
        this.f551272w = MapsKt.emptyMap();
    }
}
