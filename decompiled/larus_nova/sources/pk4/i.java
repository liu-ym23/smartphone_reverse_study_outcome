package pk4;

import android.text.TextUtils;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f529627a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f529628a = null;

        static {
            f529628a = new i();
        }
    }

    public final long b() {
        return this.f529627a.getLong("_d_c", 0);
    }

    public final Set<DoraDevice> c() {
        Set<String> r100 = this.f529627a.getStringSet("_d", Collections.emptySet());
        HashSet r101 = new HashSet();
        if (r100 != null) goto L5;
    L12:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L12;
        Iterator<String> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        DoraDevice r103 = h(r102.next());
        if (r103 == null) goto L8;
        r101.add(r103);
        goto L8
    }

    public i() {
        KevaBuilder.getInstance().setContext(n.f529659c);
        Keva r100 = Keva.getRepo("_d", 0);
        this.f529627a = r100;
        k.a.f529632a.a(r100.getStringArray("_d_bind", new String[0]));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        j.c("KevaUtils", "syncMultiProcessBindDoraDevicesOnInit failed", th);
    }

    public static boolean e(DoraDevice r100) {
        if (ProductNameType.isDoraGSeriesProduct(r100.productId) == true) goto L5;
        return false;
    L5:
        int r101 = ProductNameType.getDeviceTypeByProductId(r100.productId);
        if (r100.type != r101) goto L8;
        return false;
    L8:
        j.d("KevaUtils", "normalizeDoraGSeriesDeviceType: mac=" + r100.f204389mac + ", productId=" + r100.productId + ", oldType=" + r100.type + ", newType=" + r101);
        r100.type = r101;
        return true;
    }

    public final void a(DoraDevice r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        e(r110);
        Set<DoraDevice> r100 = c();
        Set<String> r101 = this.f529627a.getStringSet("_d", Collections.emptySet());
        if (r101.contains(r110.f204389mac) == true) goto L7;
        this.f529627a.storeLong("_d_c", b() + 1);
    L7:
        Iterator r102 = ((HashSet) r100).iterator();
        DoraDevice r103 = null;
    L9:
        if (r102.hasNext() == false) goto L14;
        DoraDevice r104 = (DoraDevice) r102.next();
        if (TextUtils.equals(r104.f204389mac, r110.f204389mac) == false) goto L13;
        r103 = r104;
    L13:
        r101.add(r104.f204389mac);
        goto L9
    L14:
        j.d("KevaUtils", "device: " + r110.f204389mac + " added, all: " + r101 + ", count: " + b());
        r101.add(r110.f204389mac);
        if (r103 != null) goto L17;
    L20:
        JSONObject r105 = new JSONObject();
        r105.put("_t", r110.typeName);     // Catch: JSONException -> L28
        r105.put("_mv", r110.modelVersion);     // Catch: JSONException -> L28
        r105.put("_s", r110.sku);     // Catch: JSONException -> L28
        r105.put("_hv", r110.hwVersion);     // Catch: JSONException -> L28
        r105.put("_sv", r110.softVersion);     // Catch: JSONException -> L28
        r105.put("_sn", r110.f204390sn);     // Catch: JSONException -> L28
        r105.put("_bt", r110.buildTime);     // Catch: JSONException -> L28
        r105.put("_m", r110.model);     // Catch: JSONException -> L28
        r105.put("_n", r110.name);     // Catch: JSONException -> L28
        r105.put("_vendor", r110.vendorId);     // Catch: JSONException -> L28
        r105.put("_p", r110.productId);     // Catch: JSONException -> L28
        r105.put("_did", r110.getDeviceId());     // Catch: JSONException -> L28
        r105.put("_dt", r110.type);     // Catch: JSONException -> L28
        r105.put("_csv", r110.caseSoftVersion);     // Catch: JSONException -> L28
        r105.put("_transfer_ability", r110.transferAbility);     // Catch: JSONException -> L28
        String r106 = r110.androidOSVersion;     // Catch: JSONException -> L28
        if (r106 != null) goto L24;
    L26:
        r105.put("_ability", r110.ability);     // Catch: JSONException -> L28
        r105.put("_headphone_mode_state", r110.headphoneModeState);     // Catch: JSONException -> L28
        String r107 = r105.toString();     // Catch: JSONException -> L28
        j.d("KevaUtils", "info: " + r107);     // Catch: JSONException -> L28
        this.f529627a.storeString(r110.f204389mac, r107);     // Catch: JSONException -> L28
    L30:
        this.f529627a.storeStringSet("_d", r101);
        String[] r108 = this.f529627a.getStringArray("_d_bind", new String[0]);
        if (r108 != null) goto L33;
        r108 = new String[0];
    L33:
        int r109 = r108.length;
        int r111 = 0;
    L35:
        if (r111 >= r109) goto L40;
        if (Objects.equals(r110.f204389mac, r108[r111]) == true) goto L38;
        r111 = r111 + 1;
        goto L35
    L38:
        boolean r112 = true;
    L41:
        if (r112 == true) goto L51;
        LinkedHashSet r113 = new LinkedHashSet();
        r113.add(r110.f204389mac);
        Collections.addAll(r113, r108);
        j.a("KevaUtils", "addBindDoraDevice device: " + r110.f204389mac + " added, all: " + r113 + ", count: " + b());
        this.f529627a.storeStringArray("_d_bind", (String[]) r113.toArray(new String[0]));
        j(r110, true);
        return;
    L51:
        return;
    L40:
        r112 = false;
        goto L41
    L24:
        if (r106.isEmpty() == true) goto L26;
        r105.put("_a", r110.androidOSVersion);     // Catch: JSONException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L30
    L17:
        if (r103.hasInfoChanged(r110) == true) goto L20;
        j.f("KevaUtils", "device: " + r110.f204390sn + " info not changed");
        goto L30
    }

    public final boolean d(String r100) {
        return this.f529627a.getBoolean(r100, false);
    }

    public final void f(DoraDevice r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100.f204389mac) == true) goto L7;
        this.f529627a.erase(r100.f204389mac + "_bytelink_encrypt_enabled");
    L7:
        String[] r101 = this.f529627a.getStringArray("_d_bind", new String[0]);
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.length == 0) goto L24;
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L18;
        String r105 = r101[r104];
        if (Objects.equals(r100.f204389mac, r105) == true) goto L17;
        r102.add(r105);
    L17:
        r104 = r104 + 1;
        goto L13
    L18:
        this.f529627a.storeStringArray("_d_bind", (String[]) r102.toArray(new String[0]));
        j(r100, false);
        return;
    }

    public final void g(DoraDevice r100) {
        Set<DoraDevice> r101 = c();
        HashSet r102 = new HashSet();
        Iterator r103 = ((HashSet) r101).iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        DoraDevice r104 = (DoraDevice) r103.next();
        if (Objects.equals(r100.f204389mac, r104.f204389mac) == true) goto L4;
        r102.add(r104.f204389mac);
        goto L4
    L9:
        this.f529627a.storeStringSet("_d", r102);
        f(r100);
    }

    public final DoraDevice h(String r100) {
        DoraDevice r101 = DoraDevice.from(r100);
        if (r101 == null) goto L12;
        String r102 = this.f529627a.getString(r100, null);
        if (r102 == null) goto L12;
        JSONObject r103 = new JSONObject(r102);     // Catch: JSONException -> L10
        r101.typeName = r103.optString("_t");     // Catch: JSONException -> L10
        r101.modelVersion = r103.optString("_mv");     // Catch: JSONException -> L10
        r101.sku = r103.optInt("_s");     // Catch: JSONException -> L10
        r101.hwVersion = r103.optString("_hv");     // Catch: JSONException -> L10
        r101.softVersion = r103.optString("_sv");     // Catch: JSONException -> L10
        r101.f204390sn = r103.optString("_sn");     // Catch: JSONException -> L10
        r101.buildTime = r103.optString("_bt");     // Catch: JSONException -> L10
        r101.model = r103.optString("_m");     // Catch: JSONException -> L10
        r101.name = r103.optString("_n");     // Catch: JSONException -> L10
        r101.type = r103.optInt("_dt", -1);     // Catch: JSONException -> L10
        r101.productId = r103.optInt("_p");     // Catch: JSONException -> L10
        r101.androidOSVersion = r103.optString("_a");     // Catch: JSONException -> L10
        r101.vendorId = r103.optInt("_vendor");     // Catch: JSONException -> L10
        r101.setDeviceId(r103.optString("_did"));     // Catch: JSONException -> L10
        r101.caseSoftVersion = r103.optString("_csv");     // Catch: JSONException -> L10
        r101.transferAbility = r103.optInt("_transfer_ability");     // Catch: JSONException -> L10
        r101.ability = r103.optString("_ability");     // Catch: JSONException -> L10
        r101.headphoneModeState = r103.optInt("_headphone_mode_state", r101.headphoneModeState);     // Catch: JSONException -> L10
        if (e(r101) == false) goto L12;
        r103.put("_dt", r101.type);     // Catch: JSONException -> L10
        this.f529627a.storeString(r101.f204389mac, r103.toString());     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        return r101;
    }

    public static void j(DoraDevice r100, boolean r101) {
        if (r101 == false) goto L15;
        k r102 = k.a.f529632a;     // Catch: Throwable -> L12
        r102.getClass();     // Catch: Throwable -> L12
        if (r100 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r100.f204389mac) == true) goto L35;
        String[] r103 = r102.f529631a.getStringArray("_d_bind", new String[0]);     // Catch: Throwable -> L12
        if (r103 != null) goto L14;
        r103 = new String[0];     // Catch: Throwable -> L12
    L14:
        LinkedHashSet r104 = new LinkedHashSet(Arrays.asList(r103));     // Catch: Throwable -> L12
        r104.add(r100.f204389mac);     // Catch: Throwable -> L12
        r102.b(r104);     // Catch: Throwable -> L12
        return;
    L35:
        return;
    L15:
        k r105 = k.a.f529632a;     // Catch: Throwable -> L12
        r105.getClass();     // Catch: Throwable -> L12
        if (r100 != null) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(r100.f204389mac) == true) goto L38;
        String[] r106 = r105.f529631a.getStringArray("_d_bind", new String[0]);     // Catch: Throwable -> L12
        if (r106 != null) goto L23;
        r106 = new String[0];     // Catch: Throwable -> L12
    L23:
        LinkedHashSet r107 = new LinkedHashSet(Arrays.asList(r106));     // Catch: Throwable -> L12
        if (r107.remove(r100.f204389mac) == false) goto L39;
        r105.b(r107);     // Catch: Throwable -> L12
        return;
    L39:
        return;
    L38:
        return;
    L12:
        th = move-exception;
        StringBuilder r108 = new StringBuilder("syncMultiProcessBindDoraDevice failed, isAdd: ");
        r108.append(r101);
        r108.append(", mac: ");
        if (r100 != null) goto L30;
        String r109 = "null";
    L31:
        r108.append(r109);
        j.c("KevaUtils", r108.toString(), th);
        return;
    L30:
        r109 = r100.f204389mac;
        goto L31
    }

    public final void i(String r100, Boolean r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.f529627a.storeBoolean(r100, r101.booleanValue());
    }
}
