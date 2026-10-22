package o59;

import android.text.TextUtils;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.l0;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.util.k;
import com.larus.nova.R;
import com.larus.utils.j0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static final int[] a(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int[] r101 = r100.battery;
        if (r101 != null) goto L6;
        return new int[]{-1, -1, -1};
    L6:
        if (r101.length < 3) goto L8;
        Intrinsics.checkNotNull(r101);
        return r101;
    L8:
        int[] r102 = new int[3];
        int r103 = 0;
    L9:
        if (r103 >= 3) goto L20;
        int[] r104 = r100.battery;
        if (r103 >= r104.length) goto L13;
        int r105 = r104[r103];
    L14:
        r102[r103] = r105;
        r103 = r103 + 1;
        goto L9
    L13:
        r105 = -1;
        goto L14
    L20:
        return r102;
    }

    public static final int[] b(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int[] r101 = r100.charge;
        if (r101 != null) goto L6;
        return new int[]{0, 0, 0};
    L6:
        if (r101.length < 3) goto L8;
        return r101;
    L8:
        return Arrays.copyOf(r101, 3);
    }

    public static final int c(DoraDevice r100) {
        if (r100 == null) goto L5;
        int r101 = r100.productId;
        if (r101 == 0) goto L5;
        return r101;
    L5:
        return 1;
    }

    public static final String d(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.f204389mac;
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        return z(r101, r100.name);
    }

    public static final String e(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (l(r100) == false) goto L5;
        String r101 = r100.androidOSVersion;
    L6:
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L15;
        return "";
    L15:
        return BaseSwitches.V + r101;
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    L5:
        r101 = r100.softVersion;
        goto L6
    }

    public static final String f(DoraDevice r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        return "dora_ext_h";
    L10:
        if (r100 != null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == true) goto L37;
        if (r100 != null) goto L18;
    L20:
        boolean r104 = false;
    L21:
        if (r104 == true) goto L37;
        if (r100 != null) goto L25;
    L27:
        r101 = false;
    L28:
        if (r101 == false) goto L30;
        return "dora_e";
    L30:
        if (r100 == null) goto L32;
        Integer r105 = Integer.valueOf(r100.productId);
    L34:
        if (o(r105) == false) goto L36;
        return "dora_g";
    L36:
        return "none";
    L32:
        r105 = null;
        goto L34
    L25:
        if (ProductNameType.DORA_E.f204375id != r100.productId) goto L27;
    L18:
        if (r100.productId != 0) goto L20;
        r104 = true;
    L37:
        return "dora_d";
    L12:
        if (ProductNameType.DORA_LITE.f204375id != r100.productId) goto L14;
        r103 = true;
        goto L15
    L5:
        if (r100.vendorId != 4096) goto L7;
        r102 = true;
        goto L8
    }

    public static final String g(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (n(Integer.valueOf(r100.type)) == false) goto L5;
        int r101 = j0.f375426a;
        return j0.d(R.string.larus_dora_product_glasses_cn);
    L5:
        int r102 = j0.f375426a;
        return j0.d(R.string.larus_dora_product_headset_cn);
    }

    public static final String h(DoraDevice r100) {
        if (r100 != null) goto L5;
        return "null";
    L5:
        return "{name=" + r100.name + ", sn=" + r100.f204390sn + ", mode=" + r100.mode + ", productId=" + r100.productId + "}, type=" + r100.type;
    }

    public static final int[] i(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int[] r101 = r100.state;
        if (r101 != null) goto L6;
        return new int[]{0, 0, 0};
    L6:
        if (r101.length < 3) goto L8;
        return r101;
    L8:
        return Arrays.copyOf(r101, 3);
    }

    public static final boolean j(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r(r100) == false) goto L22;
        IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r101 == null) goto L7;
        DeviceService r102 = r101.device();
    L8:
        if (r102 != null) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == false) goto L29;
        if (r102 != null) goto L16;
    L18:
        boolean r104 = false;
    L19:
        if (r104 == false) goto L30;
    L27:
        return true;
    L30:
        return false;
    L16:
        if (r102.e(1) != true) goto L18;
        r104 = true;
        goto L19
    L29:
        return false;
    L10:
        if (r102.e(0) != true) goto L12;
        r103 = true;
        goto L13
    L7:
        r102 = null;
        goto L8
    L22:
        if (i(r100)[2] == 3) goto L24;
        return false;
    L24:
        if (b(r100)[0] != 1) goto L26;
        return false;
    L26:
        if (b(r100)[1] != 1) goto L27;
        return false;
    }

    public static final boolean k(DoraDevice r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (kj4.a.g().getDoraLinkState(r100) != 2) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean l(DoraDevice r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.productId);
    L6:
        return o(r101);
    L4:
        r101 = null;
        goto L6
    }

    public static final boolean m(Integer r100) {
        int r101 = ProductNameType.DORA_G2.f204375id;
        if (r100 != null) goto L6;
    L7:
        int r102 = ProductNameType.DORA_G_AIR.f204375id;
        if (r100 != null) goto L11;
    L12:
        int r103 = ProductNameType.DORA_G_PIN.f204375id;
        if (r100 != null) goto L16;
    L18:
        return false;
    L16:
        if (r100.intValue() != r103) goto L18;
    L19:
        return true;
    L11:
        if (r100.intValue() == r102) goto L19;
    L6:
        if (r100.intValue() == r101) goto L19;
        goto L7
    }

    public static final boolean n(Integer r100) {
        if (r100 != null) goto L5;
    L6:
        if (r100 != null) goto L9;
    L10:
        if (r100 != null) goto L13;
    L14:
        if (r100 != null) goto L17;
    L19:
        return false;
    L17:
        if (r100.intValue() != 19) goto L19;
    L20:
        return true;
    L13:
        if (r100.intValue() == 18) goto L20;
    L9:
        if (r100.intValue() == 17) goto L20;
    L5:
        if (r100.intValue() == 16) goto L20;
        goto L6
    }

    public static final boolean o(Integer r100) {
        int r101 = ProductNameType.DORA_G.f204375id;
        if (r100 != null) goto L6;
    L7:
        int r102 = ProductNameType.DORA_G2.f204375id;
        if (r100 != null) goto L11;
    L12:
        int r103 = ProductNameType.DORA_G_AIR.f204375id;
        if (r100 != null) goto L16;
    L17:
        int r104 = ProductNameType.DORA_G_PIN.f204375id;
        if (r100 != null) goto L21;
    L23:
        return false;
    L21:
        if (r100.intValue() != r104) goto L23;
    L24:
        return true;
    L16:
        if (r100.intValue() == r103) goto L24;
    L11:
        if (r100.intValue() == r102) goto L24;
    L6:
        if (r100.intValue() == r101) goto L24;
        goto L7
    }

    public static final boolean p(DoraDevice r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.type);
    L6:
        return n(r101);
    L4:
        r101 = null;
        goto L6
    }

    public static final boolean q(DoraDevice r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.productId != ProductNameType.DORA_LITE.f204375id) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean r(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (4096 != r100.vendorId) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean s(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (i(r100)[2] == 1) goto L7;
        if (i(r100)[2] == 3) goto L7;
        return false;
    L7:
        if (b(r100)[0] == 1) goto L11;
        return true;
    L11:
        return false;
    }

    public static final boolean t(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100.mode & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static final boolean u(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (i(r100)[2] == 2) goto L7;
        if (i(r100)[2] == 3) goto L7;
    L9:
        return false;
    L7:
        if (b(r100)[1] == 1) goto L9;
        return true;
    }

    public static final boolean v(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.version >= 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static final boolean w(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (y(r100, "1.3.0.55") == true) goto L9;
        int r101 = k.f338144a;
        DoraDevice r102 = ak4.a.d().current();
        if (r102 != null) goto L7;
        boolean r103 = false;
    L8:
        if (r103 == true) goto L9;
        return false;
    L7:
        r103 = TextUtils.equals(r102.getProductName(), "DoraE");
    L9:
        return true;
    }

    public static final boolean x(DoraDevice r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.vendorId != 4096) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean y(DoraDevice r110, String r111) {
        List r112 = StringsKt.split$default(r110.softVersion, new String[]{"."}, false, 0, 6, null);     // Catch: Throwable -> L22
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));     // Catch: Throwable -> L22
        Iterator r113 = r112.iterator();     // Catch: Throwable -> L22
    L5:
        if (r113.hasNext() == false) goto L7;
        r100.add(Integer.valueOf(CastIntegerProtector.parseInt((String) r113.next())));     // Catch: Throwable -> L22
        goto L5
    L7:
        List r114 = StringsKt.split$default(r111, new String[]{"."}, false, 0, 6, null);     // Catch: Throwable -> L22
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));     // Catch: Throwable -> L22
        Iterator r116 = r114.iterator();     // Catch: Throwable -> L22
    L9:
        if (r116.hasNext() == false) goto L11;
        r115.add(Integer.valueOf(CastIntegerProtector.parseInt((String) r116.next())));     // Catch: Throwable -> L22
        goto L9
    L11:
        int r117 = Math.min(r100.size(), r115.size());     // Catch: Throwable -> L22
        int r101 = 0;
    L13:
        if (r101 >= r117) goto L21;
        if (((Number) ListProtector.get(r100, r101)).intValue() > ((Number) ListProtector.get(r115, r101)).intValue()) goto L16;
        if (((Number) ListProtector.get(r100, r101)).intValue() < ((Number) ListProtector.get(r115, r101)).intValue()) goto L19;
        r101 = r101 + 1;
        goto L13
    L19:
        return false;
    L16:
        return true;
    L21:
        return true;
    L22:
        return false;
    }

    public static final String z(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "mac");
        String r102 = (String) ((LinkedHashMap) l0.f332217b).get(r100);
        boolean r103 = true;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L18;
        if (r101 != null) goto L12;
    L15:
        if (r103 == false) goto L19;
        return "Ola Friend";
    L19:
        return r101;
    L12:
        if (r101.length() == 0) goto L15;
        r103 = false;
        goto L15
    L18:
        return r102;
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    public static final String A(String r100, String r101, Integer r102) {
        boolean r103 = true;
        if (r100 != null) goto L5;
    L14:
        if (r101 == null) goto L30;
        int r104 = ProductNameType.DORA_G.f204375id;
        if (r102 != null) goto L19;
    L26:
        r103 = false;
    L27:
        if (r103 == false) goto L30;
        return r101;
    L19:
        if (r102.intValue() != r104) goto L26;
        if (r101.length() <= 0) goto L23;
        boolean r105 = true;
    L24:
        if (r105 == false) goto L26;
    L23:
        r105 = false;
    L30:
        return null;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L14;
        return r100;
    L7:
        r106 = false;
        goto L8
    }
}
