package sz9;

import com.larus.bmhome.bigimg.l;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.tencent.open.SocialConstants;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zo8.e;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f544077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f544078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zo8.b f544079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f544080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l f544081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f544082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f544083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f544084h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final JSONObject f544085i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f544086j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, UserCreationFromIM> f544087k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f544088l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f544089m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f544090n;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f544077a, r101.f544077a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f544078b, r101.f544078b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f544079c, r101.f544079c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f544080d, r101.f544080d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f544081e, r101.f544081e) == true) goto L24;
        return false;
    L24:
        if (this.f544082f == r101.f544082f) goto L27;
        return false;
    L27:
        if (this.f544083g == r101.f544083g) goto L30;
        return false;
    L30:
        if (this.f544084h == r101.f544084h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f544085i, r101.f544085i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f544086j, r101.f544086j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f544087k, r101.f544087k) == true) goto L42;
        return false;
    L42:
        if (this.f544088l == r101.f544088l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f544089m, r101.f544089m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f544090n, r101.f544090n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        Message r100 = this.f544077a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f544078b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        zo8.b r107 = this.f544079c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        e r110 = this.f544080d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        l r113 = this.f544081e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        int r116 = 1231;
        if (this.f544082f == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r115 + r117) * 31;
        if (this.f544083g == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (r118 + r119) * 31;
        if (this.f544084h == false) goto L33;
        int r121 = 1231;
    L34:
        int r122 = (r120 + r121) * 31;
        JSONObject r123 = this.f544085i;
        if (r123 != null) goto L37;
        int r124 = 0;
    L38:
        int r125 = (((((r122 + r124) * 31) + this.f544086j.hashCode()) * 31) + this.f544087k.hashCode()) * 31;
        if (this.f544088l == true) goto L42;
        r116 = 1237;
    L42:
        int r126 = (r125 + r116) * 31;
        Integer r127 = this.f544089m;
        if (r127 != null) goto L45;
        int r128 = 0;
    L46:
        int r129 = (r126 + r128) * 31;
        Integer r130 = this.f544090n;
        if (r130 == null) goto L51;
        r101 = r130.hashCode();
    L51:
        return r129 + r101;
    L45:
        r128 = r127.hashCode();
        goto L46
    L37:
        r124 = r123.hashCode();
        goto L38
    L33:
        r121 = 1237;
        goto L34
    L29:
        r119 = 1237;
        goto L30
    L25:
        r117 = 1237;
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationGalleryData(message=" + this.f544077a + ", isCaseMode=" + this.f544078b + ", imageContent=" + this.f544079c + ", videoContent=" + this.f544080d + ", imageInfo=" + this.f544081e + ", disableCollection=" + this.f544082f + ", isBlockContent=" + this.f544083g + ", isMixed=" + this.f544084h + ", reportParams=" + this.f544085i + ", desc=" + this.f544086j + ", creationStatus=" + this.f544087k + ", noWatermarkSelected=" + this.f544088l + ", currentCreationTypeFromIM=" + this.f544089m + ", taskType=" + this.f544090n + ')';
    }

    public b(Message r110, Boolean r111, zo8.b r112, e r210, boolean r211, boolean r212, JSONObject r213, String r214, Map r215, boolean r216, Integer r217, Integer r218, int r219) {
        if ((r219 & 1) == 0) goto L5;
        Message r100 = null;
    L7:
        if ((r219 & 2) == 0) goto L9;
        Boolean r101 = Boolean.FALSE;
    L11:
        if ((r219 & 4) == 0) goto L13;
        zo8.b r102 = null;
    L15:
        if ((r219 & 8) == 0) goto L17;
        e r103 = null;
    L19:
        if ((r219 & 32) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r219 & 128) == 0) goto L25;
        boolean r113 = false;
    L27:
        if ((r219 & 256) == 0) goto L29;
        JSONObject r114 = null;
    L31:
        if ((r219 & 512) == 0) goto L33;
        String r115 = "";
    L35:
        if ((r219 & 2048) == 0) goto L37;
        boolean r116 = false;
    L39:
        if ((r219 & 4096) == 0) goto L41;
        Integer r117 = null;
    L43:
        if ((r219 & 8192) == 0) goto L45;
        Integer r105 = null;
    L46:
        Intrinsics.checkNotNullParameter(r115, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r215, "creationStatus");
        this.f544077a = r100;
        this.f544078b = r101;
        this.f544079c = r102;
        this.f544080d = r103;
        this.f544081e = null;
        this.f544082f = r104;
        this.f544083g = false;
        this.f544084h = r113;
        this.f544085i = r114;
        this.f544086j = r115;
        this.f544087k = r215;
        this.f544088l = r116;
        this.f544089m = r117;
        this.f544090n = r105;
        return;
    L45:
        r105 = r218;
        goto L46
    L41:
        r117 = r217;
        goto L43
    L37:
        r116 = r216;
        goto L39
    L33:
        r115 = r214;
        goto L35
    L29:
        r114 = r213;
        goto L31
    L25:
        r113 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
