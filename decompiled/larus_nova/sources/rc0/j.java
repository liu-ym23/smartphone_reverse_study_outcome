package rc0;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f537032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f537033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveMode f537034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f537035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q f537036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f537037f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f537038g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f537039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f537040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f537041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f537042k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f537043l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L30;
        j r101 = (j) r100;
        if (this.f537032a == r101.f537032a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f537033b, r101.f537033b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f537034c, r101.f537034c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f537035d, r101.f537035d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f537036e, r101.f537036e) == true) goto L16;
        return false;
    L16:
        if (this.f537037f == r101.f537037f) goto L18;
        return false;
    L18:
        if (this.f537038g == r101.f537038g) goto L20;
        return false;
    L20:
        if (this.f537039h == r101.f537039h) goto L22;
        return false;
    L22:
        if (this.f537040i == r101.f537040i) goto L24;
        return false;
    L24:
        if (this.f537041j == r101.f537041j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f537042k, r101.f537042k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f537043l, r101.f537043l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    public final int hashCode() {
        boolean r100 = this.f537032a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        View r104 = this.f537033b;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        LiveMode r108 = this.f537034c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f537035d;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        q r114 = this.f537036e;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.f537037f;
        ?? r118 = r117;
        if (r117 == false) goto L24;
        r118 = 1;
    L24:
        int r119 = (((r116 + r118) * 31) + this.f537038g) * 31;
        boolean r120 = this.f537039h;
        ?? r121 = r120;
        if (r120 == false) goto L27;
        r121 = 1;
    L27:
        int r122 = (((r119 + r121) * 31) + this.f537040i) * 31;
        boolean r123 = this.f537041j;
        if (r123 == true) goto L31;
        r101 = r123;
    L31:
        int r124 = (r122 + r101) * 31;
        String r125 = this.f537042k;
        if (r125 == null) goto L34;
        int r126 = r125.hashCode();
    L35:
        int r127 = (r124 + r126) * 31;
        Context r128 = this.f537043l;
        if (r128 == null) goto L39;
        r105 = r128.hashCode();
    L39:
        return r127 + r105;
    L34:
        r126 = 0;
        goto L35
    L20:
        r115 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L12:
        r109 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("InRoomStreamParam{source=");
        r100.append(this.f537042k);
        r100.append(",liveMode=");
        r100.append(this.f537034c);
        r100.append(",pkBarHeight=");
        r100.append(this.f537038g);
        r100.append(",transForPkBar=");
        r100.append(this.f537037f);
        r100.append(",allowRotateScreen=");
        r100.append(this.f537041j);
        r100.append(",");
        q r101 = this.f537036e;
        JSONObject r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f537068a;
    L6:
        if (r103 != null) goto L8;
        r100.append("appDataString=null,");
    L8:
        q r104 = this.f537036e;
        if (r104 == null) goto L11;
        r102 = r104.f537069b;
    L11:
        if (r102 != null) goto L13;
        r100.append("appDataJson=null,");
    L13:
        r100.append("seiRaw=");
        r100.append(this.f537035d);
        r100.append(",playerView=");
        r100.append(this.f537033b);
        r100.append(com.alipay.sdk.m.u.i.f25855d);
        return r100.toString();
    L5:
        r103 = null;
        goto L6
    }

    public final Context getContext() {
        return this.f537043l;
    }

    public j(boolean r100, AbsLivePlayerView r101, LiveMode r102, String r103, q r104, boolean r105, int r106, boolean r107, int r110, boolean r111, String r112, Context r113) {
        Intrinsics.checkNotNullParameter(r101, "playerView");
        Intrinsics.checkNotNullParameter(r102, "liveMode");
        Intrinsics.checkNotNullParameter(r103, "seiRaw");
        Intrinsics.checkNotNullParameter(r112, "source");
        Intrinsics.checkNotNullParameter(r113, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f537032a = r100;
        this.f537033b = r101;
        this.f537034c = r102;
        this.f537035d = r103;
        this.f537036e = r104;
        this.f537037f = r105;
        this.f537038g = r106;
        this.f537039h = r107;
        this.f537040i = r110;
        this.f537041j = r111;
        this.f537042k = r112;
        this.f537043l = r113;
    }
}
