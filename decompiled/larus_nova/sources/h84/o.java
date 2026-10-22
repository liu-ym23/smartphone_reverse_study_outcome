package h84;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.o0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f484141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedPreferences f484142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o0 f484143d;

    @Override // h84.e
    public final String[] f() {
        String r100 = i("sim_serial_number").getString("sim_serial_number", null);
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        return r100.split("\n");
    }

    @Override // h84.e, h84.n
    public final String a(String r100) {
        return i(r100).getString(r100, null);
    }

    @Override // h84.e
    public final void d(String[] r100) {
        if (r100 == null) goto L9;
        String r101 = TextUtils.join("\n", r100);
        if (TextUtils.isEmpty(r101) == true) goto L10;
        SharedPreferences.Editor r102 = i("sim_serial_number").edit();
        r102.putString("sim_serial_number", r101);
        r102.apply();
        return;
    L10:
        return;
    }

    @Override // h84.e
    public final void e(List<String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        String r103 = r102.next();
        if (TextUtils.isEmpty(r103) == true) goto L6;
        SharedPreferences r104 = i(r103);
        SharedPreferences.Editor r105 = (SharedPreferences.Editor) r101.get(r104);
        if (r105 != null) goto L12;
        r105 = i(r103).edit();
        r101.put(r104, r105);
    L12:
        if (r104 == null) goto L6;
        if (r104.contains(r103) == false) goto L6;
        r105.remove(r103);
        goto L6
    L16:
        Iterator r106 = r101.entrySet().iterator();
    L18:
        if (r106.hasNext() == false) goto L20;
        ((SharedPreferences.Editor) ((Map.Entry) r106.next()).getValue()).apply();
        goto L18
    L20:
        super.e(r100);
    }

    public final SharedPreferences i(String r100) {
        if ("device_id".equals(r100) == true) goto L12;
        if ("install_id".equals(r100) == true) goto L12;
        if ("bd_did".equals(r100) == true) goto L12;
        return i84.a.a(this.f484141b, this.f484143d);
    L12:
        return this.f484142c;
    }

    @Override // h84.e, h84.n
    public final void c(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L7;
        SharedPreferences.Editor r102 = i(r100).edit();
        r102.putString(r100, r101);
        r102.apply();
        return;
    }

    public o(Context r100, SharedPreferences r101, o0 r102) {
        if (r100 == null) goto L7;
        this.f484141b = r100;
        this.f484142c = r101;
        this.f484143d = r102;
        return;
    L7:
        throw new IllegalArgumentException("context can't be null");
    }
}
