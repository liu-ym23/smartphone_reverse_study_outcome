package v12;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftStrategy;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f552418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SendGiftSource f552419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f552420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f552421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f552422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f552423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f552424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SendGiftStrategy f552425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f552426i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f552427j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f552428k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f552429l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f552430m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f552431n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<IBaseUser> f552432o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final h1 f552433p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f552434q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final JSONObject f552435r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<String, Boolean> f552436s;

    /* JADX WARN: Multi-variable type inference failed */
    public g(long r100, SendGiftSource r110, String r111, String r112, int r113, int r114, boolean r115, SendGiftStrategy r116, int r117, boolean r118, long r210, int r211, boolean r212, String r213, List<? extends IBaseUser> r214, h1 r215, String r216, JSONObject r217, Map<String, Boolean> r218) {
        Intrinsics.checkNotNullParameter(r110, "sendGiftFrom");
        Intrinsics.checkNotNullParameter(r111, "toUserId");
        Intrinsics.checkNotNullParameter(r112, "toRoomId");
        Intrinsics.checkNotNullParameter(r116, "sendGiftStrategy");
        Intrinsics.checkNotNullParameter(r213, "extra");
        this.f552418a = r100;
        this.f552419b = r110;
        this.f552420c = r111;
        this.f552421d = r112;
        this.f552422e = r113;
        this.f552423f = r114;
        this.f552424g = r115;
        this.f552425h = r116;
        this.f552426i = r117;
        this.f552427j = r118;
        this.f552428k = r210;
        this.f552429l = r211;
        this.f552430m = r212;
        this.f552431n = r213;
        this.f552432o = r214;
        this.f552433p = r215;
        this.f552434q = r216;
        this.f552435r = r217;
        this.f552436s = r218;
    }
}
