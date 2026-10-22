package n4a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Vector;

/* JADX INFO: loaded from: classes32.dex */
public final class e1 extends h1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f517246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f517247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f517248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f517249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f517250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f517251g;

    @Override // n4a.h1
    public final int d() {
        if (x4.r(this.f517247c) == 1) goto L6;
        int r100 = this.f517249e;
        if (r100 <= 0) goto L6;
    L11:
        h1 r101 = this.f517339a;
        if (r101 != null) goto L14;
        return r100;
    L14:
        return Math.max(r100, r101.d());
    L6:
        r100 = this.f517251g;
        if (r100 <= 0) goto L10;
        if (r100 < Integer.MAX_VALUE) goto L11;
    L10:
        r100 = Integer.MAX_VALUE;
        goto L11
    }

    @Override // n4a.h1
    public final boolean c() {
        if (x4.r(this.f517247c) != 1) goto L6;
        return true;
    L6:
        if (this.f517248d == true) goto L8;
        return false;
    L8:
        Context r100 = this.f517247c;
        String r101 = this.f517246b;
        Vector<e5> r102 = p.f517579b;
        String r103 = r100.getSharedPreferences("AMSKLG_CFG", 0).getString(r101, "");
        if (TextUtils.isEmpty(r103) == false) goto L11;
        return true;
    L11:
        String[] r104 = r103.split("\\|");
        if (r104 != null) goto L14;
    L22:
        Context r105 = this.f517247c;
        String r106 = this.f517246b;
        SharedPreferences.Editor r107 = r105.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r107.remove(r106);
        r107.apply();
        return true;
    L14:
        if (r104.length < 2) goto L22;
        String r108 = r104[0];
        if (f5.b(System.currentTimeMillis(), "yyyyMMdd").equals(r108) == true) goto L19;
    L21:
        return true;
    L19:
        if (CastIntegerProtector.parseInt(r104[1]) < this.f517250f) goto L21;
        return false;
    }

    @Override // n4a.h1
    public final void b(int r100) {
        if (x4.r(this.f517247c) != 1) goto L5;
        return;
    L5:
        String r101 = f5.b(System.currentTimeMillis(), "yyyyMMdd");
        Context r102 = this.f517247c;
        String r103 = this.f517246b;
        Vector<e5> r104 = p.f517579b;
        String r105 = r102.getSharedPreferences("AMSKLG_CFG", 0).getString(r103, "");
        if (TextUtils.isEmpty(r105) == true) goto L16;
        String[] r106 = r105.split("\\|");
        if (r106 != null) goto L10;
    L15:
        Context r107 = this.f517247c;
        String r108 = this.f517246b;
        SharedPreferences.Editor r109 = r107.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r109.remove(r108);
        r109.apply();
        goto L16
    L10:
        if (r106.length < 2) goto L15;
        if (r101.equals(r106[0]) == false) goto L16;
        r100 = r100 + CastIntegerProtector.parseInt(r106[1]);
    L16:
        Context r110 = this.f517247c;
        String r111 = this.f517246b;
        String r112 = r101 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r100;
        SharedPreferences.Editor r113 = r110.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r113.putString(r111, r112);
        r113.apply();
    }

    public e1(Context r100, boolean r101, int r102, int r103) {
        this.f517247c = r100;
        this.f517248d = r101;
        this.f517249e = r102;
        this.f517250f = r103;
        this.f517246b = "carrierLocKey";
        this.f517251g = 0;
    }

    public e1(Context r100, boolean r101, int r102, int r103, String r104, int r105) {
        this.f517247c = r100;
        this.f517248d = r101;
        this.f517249e = r102;
        this.f517250f = r103;
        this.f517246b = r104;
        this.f517251g = r105;
    }
}
