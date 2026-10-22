package k27;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.HashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f501595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f501596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f501597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f501598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f501599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f501600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f501601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f501602h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f501603i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f501604j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f501605k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f501606l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f501607m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f501608n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f501609o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f501610p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f501611q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f501612r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f501613s;

    public final String c() {
        StringBuilder r100 = new StringBuilder();
        boolean r101 = this.f501595a;
        String r102 = ExifInterface.GPS_DIRECTION_TRUE;
        if (r101 == false) goto L5;
        String r103 = ExifInterface.GPS_DIRECTION_TRUE;
    L6:
        r100.append(r103);
        r100.append("#");
        r100.append(this.f501596b);
        r100.append("#");
        r100.append(this.f501597c);
        r100.append("#");
        if (this.f501598d == false) goto L9;
        String r104 = ExifInterface.GPS_DIRECTION_TRUE;
    L10:
        r100.append(r104);
        r100.append("#");
        r100.append(this.f501599e);
        r100.append("#");
        r100.append(this.f501600f);
        r100.append("#");
        r100.append(this.f501601g);
        r100.append("#");
        if (this.f501602h == false) goto L13;
        String r105 = ExifInterface.GPS_DIRECTION_TRUE;
    L14:
        r100.append(r105);
        r100.append("#");
        r100.append(this.f501603i);
        r100.append("#");
        if (this.f501604j == false) goto L17;
        String r106 = ExifInterface.GPS_DIRECTION_TRUE;
    L18:
        r100.append(r106);
        r100.append("#");
        r100.append(this.f501605k);
        r100.append("#");
        r100.append(this.f501606l);
        r100.append("#");
        r100.append(this.f501607m);
        r100.append("#");
        if (this.f501608n == false) goto L21;
        String r107 = ExifInterface.GPS_DIRECTION_TRUE;
    L22:
        r100.append(r107);
        r100.append("#");
        r100.append(this.f501609o);
        r100.append("#");
        r100.append(this.f501610p);
        r100.append("#");
        r100.append(this.f501611q);
        r100.append("#");
        r100.append(this.f501613s);
        r100.append("#");
        if (this.f501612r == true) goto L26;
        r102 = FaceService.girlLabel;
    L26:
        r100.append(r102);
        return r100.toString();
    L21:
        r107 = FaceService.girlLabel;
        goto L22
    L17:
        r106 = FaceService.girlLabel;
        goto L18
    L13:
        r105 = FaceService.girlLabel;
        goto L14
    L9:
        r104 = FaceService.girlLabel;
        goto L10
    L5:
        r103 = FaceService.girlLabel;
        goto L6
    }

    public e(String[] r100) {
        this.f501601g = "";
        this.f501603i = "";
        this.f501607m = "";
        this.f501611q = "";
        this.f501613s = "";
        this.f501595a = TextUtils.equals(ExifInterface.GPS_DIRECTION_TRUE, r100[0]);
        this.f501596b = CastLongProtector.parseLong(r100[1]);
        this.f501597c = CastLongProtector.parseLong(r100[2]);
        this.f501598d = TextUtils.equals(ExifInterface.GPS_DIRECTION_TRUE, r100[3]);
        this.f501599e = CastLongProtector.parseLong(r100[4]);
        this.f501600f = CastLongProtector.parseLong(r100[5]);
        this.f501601g = r100[6];
        this.f501602h = TextUtils.equals(ExifInterface.GPS_DIRECTION_TRUE, r100[7]);
        this.f501603i = r100[8];
        this.f501604j = TextUtils.equals(ExifInterface.GPS_DIRECTION_TRUE, r100[9]);
        this.f501605k = CastIntegerProtector.parseInt(r100[10]);
        this.f501606l = CastLongProtector.parseLong(r100[11]);
        this.f501607m = r100[12];
        this.f501608n = TextUtils.equals(ExifInterface.GPS_DIRECTION_TRUE, r100[13]);
        this.f501609o = CastLongProtector.parseLong(r100[14]);
        this.f501610p = CastLongProtector.parseLong(r100[15]);
        this.f501611q = r100[16];
        this.f501613s = r100[17];
        this.f501612r = TextUtils.equals(ExifInterface.GPS_DIRECTION_TRUE, r100[18]);
    }

    public e(boolean r100) {
        this.f501601g = "";
        this.f501603i = "";
        this.f501607m = "";
        this.f501611q = "";
        this.f501613s = "";
        this.f501595a = r100;
        this.f501596b = System.currentTimeMillis();
    }

    public final void b(String r100, int r101) {
        long r102 = System.currentTimeMillis() - this.f501596b;
        if (this.f501595a == false) goto L36;
        if (this.f501598d == false) goto L29;
        if (this.f501602h == false) goto L22;
        if (this.f501604j == false) goto L15;
        if (this.f501612r == false) goto L13;
        String r103 = "R14";
    L42:
        HashMap r104 = new HashMap();
        r104.put("pkg", r100);
        r104.put("ver", "" + r101);
        r104.put(CloudControlInf.ROUTE, r103);
        r104.put("time", "" + r102);
        r104.put("alg", "" + this.f501605k);
        r104.put("time_down_patch", "" + this.f501599e);
        r104.put("time_apply", "" + this.f501606l);
        r104.put("time_down_full", "" + this.f501609o);
        r104.put("length_patch", "" + this.f501600f);
        r104.put("length_full", "" + this.f501610p);
        r104.put("fail_down_patch", this.f501601g);
        r104.put("fail_verify_patch", this.f501603i);
        r104.put("fail_apply", this.f501607m);
        r104.put("fail_down_full", this.f501611q);
        r104.put("fail_verify_full", this.f501613s);
        r104.toString();
        h27.a.f483619b.d(r104);
        return;
    L13:
        r103 = "R13";
        goto L42
    L15:
        if (this.f501608n == true) goto L17;
        r103 = "R10";
        goto L42
    L17:
        if (this.f501612r == false) goto L19;
        r103 = "R12";
        goto L42
    L19:
        r103 = "R11";
        goto L42
    L22:
        if (this.f501608n == true) goto L24;
        r103 = "R7";
        goto L42
    L24:
        if (this.f501612r == false) goto L26;
        r103 = "R9";
        goto L42
    L26:
        r103 = "R8";
        goto L42
    L29:
        if (this.f501608n == true) goto L31;
        r103 = "R4";
        goto L42
    L31:
        if (this.f501612r == false) goto L33;
        r103 = "R6";
        goto L42
    L33:
        r103 = "R5";
        goto L42
    L36:
        if (this.f501608n == true) goto L38;
        r103 = "R1";
        goto L42
    L38:
        if (this.f501612r == false) goto L40;
        r103 = "R3";
        goto L42
    L40:
        r103 = "R2";
        goto L42
    }

    public final void a(boolean r100, int r101, long r102, long r103, int r104) {
        this.f501604j = r100;
        this.f501605k = r101;
        this.f501610p = r102;
        this.f501606l = r103;
        if (r104 <= 0) goto L6;
        this.f501607m = "" + r104;
        return;
    }
}
