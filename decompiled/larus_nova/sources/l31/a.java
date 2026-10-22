package l31;

import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.model.n0;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdk.model.q0;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.List;
import k31.f;
import k31.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;
import rc0.q;
import z41.d;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f507223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f507224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f507225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f507226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f507227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f507228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q f507229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k f507230h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k31.a f507231i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f507232j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f507233k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L26;
        a r101 = (a) r100;
        if (this.f507224b == r101.f507224b) goto L8;
        return false;
    L8:
        if (this.f507225c == r101.f507225c) goto L10;
        return false;
    L10:
        if (this.f507226d == r101.f507226d) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f507227e, r101.f507227e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f507228f, r101.f507228f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f507229g, r101.f507229g) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f507230h, r101.f507230h) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f507231i, r101.f507231i) == true) goto L22;
        return false;
    L22:
        if (this.f507232j == r101.f507232j) goto L24;
        return false;
    L24:
        if (this.f507233k == r101.f507233k) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = ((this.f507224b * 31) + this.f507225c) * 31;
        boolean r101 = this.f507226d;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f507227e;
        int r106 = 0;
        if (r105 == null) goto L8;
        int r107 = r105.hashCode();
    L9:
        int r108 = (r104 + r107) * 31;
        f r109 = this.f507228f;
        if (r109 == null) goto L12;
        int r110 = r109.hashCode();
    L13:
        int r111 = (r108 + r110) * 31;
        q r112 = this.f507229g;
        if (r112 == null) goto L16;
        int r113 = r112.hashCode();
    L17:
        int r114 = (r111 + r113) * 31;
        k r115 = this.f507230h;
        if (r115 == null) goto L20;
        int r116 = r115.hashCode();
    L21:
        int r117 = (r114 + r116) * 31;
        k31.a r118 = this.f507231i;
        if (r118 == null) goto L24;
        r106 = r118.hashCode();
    L24:
        int r119 = (((r117 + r106) * 31) + this.f507232j) * 31;
        boolean r120 = this.f507233k;
        if (r120 == true) goto L29;
        r102 = r120;
    L29:
        return r119 + r102;
    L20:
        r116 = 0;
        goto L21
    L16:
        r113 = 0;
        goto L17
    L12:
        r110 = 0;
        goto L13
    L8:
        r107 = 0;
        goto L9
    }

    public final String toString() {
        return "TransferParam(parentW=" + this.f507224b + ", parentH=" + this.f507225c + ", isFullScreen=" + this.f507226d + ", sei=" + this.f507227e + ", seiCache=" + this.f507228f + ", seiOptExtra=" + this.f507229g + ", statusBarOption=" + this.f507230h + ", components=" + this.f507231i + ", uiLayout=" + this.f507232j + ", isGameLink=" + this.f507233k + ")";
    }

    public final Float a() {
        f r100 = this.f507228f;
        String r101 = this.f507227e;
        if (r100 == null) goto L33;
        p0 r102 = r100.f501646b;
        if (r102 == null) goto L79;
        List<RevSeiRegion> r103 = r102.e();
        if (r103 == null) goto L80;
        double r104 = n11.a.d(r103);
        double r105 = n11.a.a(r103);
        if (r104 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        return null;
    L13:
        if (r105 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L81;
        n0 r106 = r100.f501645a;
        if (r106 == null) goto L21;
        Pair r107 = TuplesKt.to(Integer.valueOf(r106.b()), Integer.valueOf(r106.a()));
        int r108 = ((Number) r107.component1()).intValue();
        int r109 = ((Number) r107.component2()).intValue();
        if (r108 == 0) goto L21;
        if (r109 == 0) goto L21;
        return Float.valueOf(((float) (((double) r108) * r104)) / ((float) (((double) r109) * r105)));
    L21:
        q0 r110 = r102.getCanvas();
        if (r110 != null) goto L24;
        Pair r111 = null;
    L25:
        if (r111 != null) goto L27;
        r111 = TuplesKt.to(0, 0);
    L27:
        int r112 = ((Number) r111.component1()).intValue();
        int r113 = ((Number) r111.component2()).intValue();
        if (r112 == 0) goto L78;
        if (r113 != 0) goto L32;
        return null;
    L32:
        return Float.valueOf(((float) (((double) r112) * r104)) / ((float) (((double) r113) * r105)));
    L78:
        return null;
    L24:
        r111 = TuplesKt.to(Integer.valueOf(r110.b()), Integer.valueOf(r110.a()));
        goto L25
    L81:
        return null;
    L80:
        return null;
    L79:
        return null;
    L33:
        if (r101 == null) goto L83;
        q r114 = this.f507229g;
        if (r114 == null) goto L37;
        JSONObject r115 = r114.f537069b;
    L39:
        if (this.f507223a == false) goto L44;
        if (r115 == null) goto L44;
        JSONArray r116 = com.bytedance.android.live.revenue.common.player.utils.a.c(r115);
        if (r116 == null) goto L87;
    L47:
        double r117 = com.bytedance.android.live.revenue.common.player.utils.a.i(r116);
        double r118 = com.bytedance.android.live.revenue.common.player.utils.a.d(r116);
        if (r117 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L50;
        return null;
    L50:
        if (r118 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L89;
        n0 r119 = com.bytedance.android.live.revenue.common.player.utils.a.a(r101, this.f507223a);
        if (r119 == null) goto L58;
        Pair r120 = TuplesKt.to(Integer.valueOf(r119.b()), Integer.valueOf(r119.a()));
        int r121 = ((Number) r120.component1()).intValue();
        int r122 = ((Number) r120.component2()).intValue();
        if (r121 == 0) goto L58;
        if (r122 == 0) goto L58;
        return Float.valueOf(((float) (((double) r121) * r117)) / ((float) (((double) r122) * r118)));
    L58:
        Intrinsics.checkNotNullParameter(r101, "sei");
        if (r115 != null) goto L67;
        JSONObject r123 = com.bytedance.android.live.revenue.common.player.utils.a.j(r101);
        if (r123 != null) goto L64;
    L65:
        Pair r124 = null;
    L68:
        if (r124 != null) goto L70;
        r124 = TuplesKt.to(0, 0);
    L70:
        int r125 = ((Number) r124.component1()).intValue();
        int r126 = ((Number) r124.component2()).intValue();
        if (r125 == 0) goto L86;
        if (r126 != 0) goto L75;
        return null;
    L75:
        return Float.valueOf(((float) (((double) r125) * r117)) / ((float) (((double) r126) * r118)));
    L86:
        return null;
    L64:
        if (r123.has("app_data") == false) goto L65;
        r115 = new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r123, "app_data"), ""));
    L67:
        JSONObject r127 = new JSONObject(r115.optString("canvas"));
        r124 = TuplesKt.to(Integer.valueOf(r127.optInt("width")), Integer.valueOf(r127.optInt("height")));
        goto L68
    L89:
        return null;
    L87:
        return null;
    L44:
        r116 = com.bytedance.android.live.revenue.common.player.utils.a.b(r101);
        if (r116 != null) goto L47;
        return null;
    L37:
        r115 = null;
        goto L39
    L83:
        return null;
    }

    public /* synthetic */ a(int r110, int r111, boolean r112, String r113, f r114, q r115, k r116, k31.a r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, 0, false);
    }

    public a(int r100, int r101, boolean r102, String r103, f r104, q r105, k r106, k31.a r107, int r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r106, "statusBarOption");
        this.f507224b = r100;
        this.f507225c = r101;
        this.f507226d = r102;
        this.f507227e = r103;
        this.f507228f = r104;
        this.f507229g = r105;
        this.f507230h = r106;
        this.f507231i = r107;
        this.f507232j = r110;
        this.f507233k = r111;
        this.f507223a = d.f569904c.B6();
    }
}
