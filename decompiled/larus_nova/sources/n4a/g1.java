package n4a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Vector;

/* JADX INFO: loaded from: classes32.dex */
public final class g1 extends h1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f517291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f517292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f517293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f517294e;

    public g1(Context r100, int r101, String r102, h1 r103) {
        super(r103);
        this.f517291b = r101;
        this.f517293d = r102;
        this.f517294e = r100;
    }

    @Override // n4a.h1
    public final boolean c() {
        long r100 = 0;
        if (this.f517292c != 0) goto L10;
        String r101 = this.f517293d;
        Context r102 = this.f517294e;
        Vector<e5> r103 = p.f517579b;
        String r104 = r102.getSharedPreferences("AMSKLG_CFG", 0).getString(r101, "");
        if (TextUtils.isEmpty(r104) == true) goto L8;
        r100 = CastLongProtector.parseLong(r104);
    L8:
        this.f517292c = r100;
    L10:
        if ((System.currentTimeMillis() - this.f517292c) >= this.f517291b) goto L12;
        return false;
    L12:
        return true;
    }

    @Override // n4a.h1
    public final void a() {
        super.a();
        String r100 = this.f517293d;
        long r101 = System.currentTimeMillis();
        this.f517292c = r101;
        Context r102 = this.f517294e;
        String r103 = String.valueOf(r101);
        Vector<e5> r104 = p.f517579b;
        SharedPreferences.Editor r105 = r102.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r105.putString(r100, r103);
        r105.apply();
    }
}
