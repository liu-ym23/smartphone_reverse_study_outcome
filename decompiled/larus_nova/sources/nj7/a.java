package nj7;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ug.sdk.luckycat.impl.model.d;
import gn7.b;
import ij7.i;
import org.json.JSONObject;
import vi7.c;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends ni7.a<si7.a> implements si7.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f519460b = null;

    @Override // ni7.a
    public final String i0() {
        return "com.bytedance.ug.sdk.luckycat.container.LuckyCatBulletImpl";
    }

    static {
        f519460b = new a();
    }

    @Override // si7.a
    public final void b() {
        si7.a r100 = h0();
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // si7.a
    public final void d() {
        si7.a r100 = h0();
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    @Override // si7.a
    public final String getBid() {
        si7.a r100 = h0();
        if (r100 == null) goto L7;
        String r101 = r100.getBid();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return "BDUG_BID";
    }

    @Override // si7.a
    public final void j() {
        si7.a r100 = h0();
        if (r100 == null) goto L6;
        r100.j();
        return;
    }

    @Override // si7.a
    public final String z() {
        si7.a r100 = h0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.z();
    }

    public a() {
    }

    @Override // si7.a
    public final c S(Context r100, i r101) {
        si7.a r102 = h0();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.S(r100, r101);
    }

    @Override // si7.a
    public final String X(Context r100, String r101) {
        si7.a r102 = h0();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.X(r100, r101);
    }

    @Override // bk7.b
    public final boolean p(FragmentActivity r100, String r101, bk7.c r102) {
        si7.a r103 = h0();
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.p(r100, r101, r102);
    }

    @Override // si7.a
    public final boolean L(Context r100, String r101, String r102, String r103) {
        si7.a r104 = h0();
        if (r104 != null) goto L7;
        return false;
    L7:
        return r104.L(r100, r101, r102, r103);
    }

    @Override // si7.a
    public final boolean W(Context r100, String r101, b r102, JSONObject r103) {
        d.b(true, r101);
        si7.a r104 = h0();
        if (r104 != null) goto L7;
        return false;
    L7:
        return r104.W(r100, r101, r102, r103);
    }

    @Override // bk7.b
    public final boolean N(FragmentActivity r100, String r101, JSONObject r110, bk7.c r111, boolean r112) {
        si7.a r102 = h0();
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.N(r100, r101, r110, r111, r112);
    }
}
