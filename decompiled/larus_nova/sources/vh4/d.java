package vh4;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import org.json.JSONArray;
import zg4.i;

/* JADX INFO: loaded from: classes15.dex */
public final class d extends oh4.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f554967h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f554968i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f554969j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f554970k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f554971l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f554972m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f554973n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f554974o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f554975p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f554976q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f554977r;

    @Override // oh4.d
    public final String toString() {
        return "monitorType=" + this.f554971l + "\nwaterLineMB=" + this.f554967h + "\ndumpSizeMB=" + this.f554968i + "\nmprotectProts=" + this.f554970k + "\nmemType=" + this.f554974o + "\nmemSize=" + this.f554975p + "\nbacktraceRules=" + this.f554976q + "\nmonitorRules=" + this.f554977r + "\nsleepTime=" + this.f554969j + "\ndebug=" + this.f554972m + "\npEnable=" + this.f554973n + "\n";
    }

    public d(int r110, JSONArray r210, JSONArray r211, JSONArray r212, JSONArray r213) {
        super(23, 35, 3);
        this.f554967h = TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG;
        this.f554968i = 650;
        this.f554969j = 3000;
        int r100 = 0;
        this.f554970k = 0;
        this.f554972m = false;
        this.f554973n = false;
        this.f554974o = EffectConstants.CHANNEL_TEST;
        this.f554975p = "0";
        this.f554976q = "0";
        this.f554977r = "0";
        if (i.b() == false) goto L5;
        this.f554971l = 3;
        this.f554967h = 0;
        this.f554968i = 200;
        this.f554969j = 1000;
        this.f554974o = "new_test";
        this.f554976q = "3";
        this.f554977r = "5";
        this.f554970k = 32;
        this.f554973n = true;
        this.f554972m = true;
        return;
    L5:
        this.f554971l = r110;
        if (r210 != null) goto L8;
    L10:
        if (r211 != null) goto L12;
    L47:
        if (r212 == null) goto L52;
        this.f554970k = 0;
        int r101 = 0;
    L50:
        if (r101 >= r212.length()) goto L52;
        this.f554970k |= 1 << r212.optInt(r101);
        r101 = r101 + 1;
    L52:
        if (r213 != null) goto L54;
        return;
    L54:
        if (r213.length() == 2) goto L56;
        return;
    L56:
        if (r100 >= r213.length()) goto L84;
        String r102 = r213.optString(r100);
        if (r100 == 0) goto L64;
        if (r100 != 1) goto L65;
        if (this.f554973n == false) goto L65;
        this.f554974o = r102;
    L65:
        r100 = r100 + 1;
        goto L56
    L64:
        this.f554973n = "1".equals(r102);
        goto L65
    L84:
        return;
    L12:
        if (r211.length() != 5) goto L47;
        int r103 = 0;
        int r104 = 0;
    L15:
        if (r103 >= r211.length()) goto L46;
        String r111 = r211.optString(r103);
        if (r103 == 0) goto L44;
        if (r103 == 1) goto L28;
        if (r103 == 2) goto L26;
        if (r103 != 3) goto L22;
        int r112 = CastIntegerProtector.parseInt(r111) << 1;
    L27:
        r104 = r104 | r112;
    L45:
        r103 = r103 + 1;
        goto L15
    L22:
        if (r103 != 4) goto L45;
        this.f554977r = r111;
        goto L45
    L26:
        r112 = CastIntegerProtector.parseInt(r111) << 0;
        goto L27
    L28:
        String r113 = null;
        if (r111 != null) goto L68;
    L43:
        this.f554975p = r113;
        goto L45
    L68:
        if (r111.endsWith("M") == false) goto L34;
        Long r114 = Long.valueOf((CastLongProtector.parseLong(r111.substring(0, r111.indexOf("M"))) * 1024) * 1024);     // Catch: Throwable -> L67
    L40:
        if (r114 == null) goto L43;
        r113 = r114.toString();     // Catch: Throwable -> L67
        goto L43
    L34:
        if (r111.endsWith("G") == false) goto L37;
        r114 = Long.valueOf(((CastLongProtector.parseLong(r111.substring(0, r111.indexOf("G"))) * 1024) * 1024) * 1024);     // Catch: Throwable -> L67
        goto L40
    L37:
        if (r111.endsWith("K") == false) goto L39;
        r114 = Long.valueOf(CastLongProtector.parseLong(r111.substring(0, r111.indexOf("K"))) * 1024);     // Catch: Throwable -> L67
        goto L40
    L39:
        r114 = null;
        goto L40
    L44:
        this.f554974o = r111;
        goto L45
    L46:
        this.f554976q = String.valueOf(r104);
        goto L47
    L8:
        if (r210.length() != 2) goto L10;
        this.f554967h = r210.optInt(0);
        this.f554968i = r210.optInt(1);
        goto L10
    }
}
