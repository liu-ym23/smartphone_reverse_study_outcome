package pk4;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.Build;
import android.os.ParcelUuid;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.ttvideoengine.model.VideoRef;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f529595a = null;

    /* JADX INFO: renamed from: pk4.a$a, reason: collision with other inner class name */
    public static final class C7204a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f529596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f529597b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f529598c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f529599d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f529600e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f529601f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f529602g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f529603h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f529604i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f529605j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f529606k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f529607l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f529608m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f529609n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f529610o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final int f529611p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f529612q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final int f529613r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int f529614s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final String f529615t;

        public C7204a(byte[] r110) {
            int r100 = r110[0] & UByte.MAX_VALUE;
            this.f529596a = r100 & 7;
            this.f529597b = (r100 >> 3) & 31;
            this.f529598c = r110[1] & UByte.MAX_VALUE;
            long r101 = (((((long) (r110[2] & UByte.MAX_VALUE)) << 24) | (((long) (r110[3] & UByte.MAX_VALUE)) << 16)) | (((long) (r110[4] & UByte.MAX_VALUE)) << 8)) | ((long) (r110[5] & UByte.MAX_VALUE));
            Locale r111 = Locale.US;
            this.f529599d = String.format(r111, "%08X", new Object[]{Long.valueOf(r101)});
            int r102 = r110[6] & UByte.MAX_VALUE;
            this.f529600e = r102;
            this.f529601f = r102 & 15;
            this.f529602g = (r102 >> 4) & 15;
            this.f529603h = r110[7] & UByte.MAX_VALUE;
            int r103 = r110[8] & UByte.MAX_VALUE;
            this.f529604i = String.format(r111, "%02X", new Object[]{Integer.valueOf(r103)});
            this.f529605j = r103 & 15;
            this.f529606k = (r103 >> 4) & 15;
            this.f529607l = r110[9] & UByte.MAX_VALUE;
            this.f529608m = r110[10] & UByte.MAX_VALUE;
            this.f529609n = r110[11] & UByte.MAX_VALUE;
            this.f529610o = r110[12] & UByte.MAX_VALUE;
            this.f529611p = r110[13] & UByte.MAX_VALUE;
            this.f529612q = r110[14] & UByte.MAX_VALUE;
            this.f529613r = r110[15] & UByte.MAX_VALUE;
            this.f529614s = r110[22] & UByte.MAX_VALUE;
            if (r110.length >= 22) goto L5;
            String r112 = "";
        L6:
            this.f529615t = r112;
            return;
        L5:
            r112 = String.format(r111, "%02X:%02X:%02X:%02X:%02X:%02X", new Object[]{Integer.valueOf(r110[16] & UByte.MAX_VALUE), Integer.valueOf(r110[17] & UByte.MAX_VALUE), Integer.valueOf(r110[18] & UByte.MAX_VALUE), Integer.valueOf(r110[19] & UByte.MAX_VALUE), Integer.valueOf(r110[20] & UByte.MAX_VALUE), Integer.valueOf(r110[21] & UByte.MAX_VALUE)});
            goto L6
        }
    }

    public static boolean e(int r100, int r101) {
        if ((r100 & r101) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        f529595a = new int[]{VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL, 223, 198, 189, 52, 214, 183, 108};
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.bluetooth.BluetoothDevice");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.bluetooth.BluetoothDevice");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.bluetooth.BluetoothDevice");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.bluetooth.BluetoothDevice");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.bluetooth.BluetoothDevice");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.bluetooth.BluetoothDevice");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.bluetooth.BluetoothDevice");
    }

    public static String d(BluetoothDevice r100) {
        if (Build.VERSION.SDK_INT < 30) goto L23;
        String r101 = r100.getAlias();
        if (TextUtils.isEmpty(r101) == true) goto L23;
        return r101;
    L23:
        String r102 = (String) r100.getClass().getDeclaredMethod("getAlias", new Class[0]).invoke(r100, new Object[0]);     // Catch: Exception -> L11
        j.d("BTUtils", "Get device getAlias : " + r100.getAddress() + " ,alias : " + r102);     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r102) == true) goto L25;
        return r102;
    L25:
        String r103 = (String) a().getDeclaredMethod("getAliasName", new Class[0]).invoke(r100, new Object[0]);     // Catch: Exception -> L16
        j.d("BTUtils", "Get device getAliasName : " + r100.getAddress() + " ,alias : " + r103);     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r103) == true) goto L27;
        return r103;
    L27:
        return r100.getName();
    L20:
        e = move-exception;
        j.e("BTUtils", "Get device getName failed : " + e.getMessage(), e);
        return "";
    L16:
        e = move-exception;
        j.e("BTUtils", "Get device getAliasName failed : " + e.getMessage(), e);
    L11:
        e = move-exception;
        j.e("BTUtils", "Get device alias failed : " + e.getMessage(), e);
        goto L25
    }

    public static boolean f(BluetoothDevice r100) {
        if (r100 != null) goto L12;
        return false;
    L12:
        Method r101 = BluetoothDevice.class.getMethod("isConnected", new Class[0]);     // Catch: Exception -> L9
        r101.setAccessible(true);     // Catch: Exception -> L9
        Boolean r102 = (Boolean) r101.invoke(r100, new Object[0]);     // Catch: Exception -> L9
        j.d("BTUtils", "Get device : " + r100.getAddress() + " ,isConnected : " + r102);     // Catch: Exception -> L9
        if (r102 == null) goto L11;
        return r102.booleanValue();
    L11:
        return false;
    L9:
        e = move-exception;
        j.e("BTUtils", "Get device isConnected failed : " + e.getMessage(), e);
        goto L11
    }

    public static DoraDevice h(ScanResult r110) {
        r110.getDevice().getAddress();
        ScanRecord r100 = r110.getScanRecord();
        DoraDevice r111 = DoraDevice.from(r110.getDevice());
        if (r111 != null) goto L5;
        r111 = new DoraDevice();
    L5:
        if (r100 == null) goto L7;
        byte[] r101 = r100.getBytes();
    L8:
        if (r101 != null) goto L10;
    L34:
        return r111;
    L10:
        if (r101.length < 17) goto L34;
        j.d("BTUtils", "scanRecord: " + r101.length + " - " + n.e(r101));
        String r102 = String.format("%02X:%02X:%02X:%02X:%02X:%02X", new Object[]{Byte.valueOf(r101[11]), Byte.valueOf(r101[12]), Byte.valueOf(r101[13]), Byte.valueOf(r101[14]), Byte.valueOf(r101[15]), Byte.valueOf(r101[16])});
        r111.f204389mac = r102;
        r111.name = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(r102).getName();
        if (r101.length < 20) goto L15;
        byte r103 = r101[17];
        byte r112 = r101[18];
        byte r113 = r101[19];
        r111.charge = new int[]{r103 & ByteCompanionObject.MIN_VALUE, r112 & ByteCompanionObject.MIN_VALUE, r113 & ByteCompanionObject.MIN_VALUE};
        r111.battery = new int[]{r103 & ByteCompanionObject.MAX_VALUE, r112 & ByteCompanionObject.MAX_VALUE, r113 & ByteCompanionObject.MAX_VALUE};
    L15:
        if (r101.length < 21) goto L18;
        r111.version = r101[20];
    L18:
        if (r101.length < 22) goto L21;
        r111.type = r101[21];
    L21:
        if (r101.length < 44) goto L26;
        byte[] r104 = new byte[20];
        System.arraycopy(r101, 22, r104, 0, 9);
        System.arraycopy(r101, 33, r104, 9, 11);
        j.d("BTUtils", "name: " + n.e(r104));
        String r105 = n.g(r104).replace("\u0000", "");
        if (TextUtils.isEmpty(r111.name) == false) goto L26;
        r111.name = r105;
    L26:
        if (r101.length < 60) goto L29;
        byte[] r106 = new byte[16];
        System.arraycopy(r101, 44, r106, 0, 16);
        j.d("BTUtils", "sn: " + n.e(r106));
        r111.f204390sn = n.g(r106).replace("\u0000", "");
    L29:
        if (r101.length < 61) goto L32;
        r111.sku = r101[60];
    L32:
        if (r101.length < 62) goto L34;
        r111.mode = r101[61];
        goto L34
    L7:
        r101 = null;
        goto L8
    }

    public static DoraDevice i(ScanResult r110) {
        String r100 = null;
        if (r110 != null) goto L5;
        return null;
    L5:
        ScanRecord r101 = r110.getScanRecord();
        if (r101 != null) goto L8;
        return null;
    L8:
        SparseArray<byte[]> r102 = r101.getManufacturerSpecificData();
        if (r102 == null) goto L17;
        int r103 = 0;
    L12:
        if (r103 >= r102.size()) goto L17;
        byte[] r104 = c(r102.valueAt(r103), 0);
        if (r104 != null) goto L18;
        r103 = r103 + 1;
    L18:
        if (r104 != null) goto L20;
    L23:
        C7204a r105 = null;
    L25:
        if (r105 != null) goto L28;
        j.d("BTUtils", "readBTMacV2 ignored: Dora V2 payload not found");
        return null;
    L28:
        int r106 = r105.f529598c;
        if (r106 == 1) goto L33;
        if (r106 == 0) goto L33;
        boolean r107 = false;
    L34:
        if (r107 == true) goto L38;
        j.d("BTUtils", "readBTMacV2 ignored unexpected vendorId : " + r105.f529598c);
        return null;
    L38:
        if (ProductNameType.isDoraGSeriesProduct(r105.f529603h) == true) goto L41;
        j.d("BTUtils", "readBTMacV2 ignored unsupported Dora productId : " + r105.f529603h);
        return null;
    L41:
        ProductNameType r108 = ProductNameType.fromProductId(r105.f529603h);
        DoraDevice r109 = DoraDevice.from(r110.getDevice());
        if (r109 != null) goto L45;
        r109 = new DoraDevice();
    L45:
        if (r110.getDevice() == null) goto L49;
        r100 = r110.getDevice().getName();
    L49:
        if (TextUtils.isEmpty(r100) == false) goto L52;
        r100 = r101.getDeviceName();
    L52:
        if (TextUtils.isEmpty(r100) == false) goto L56;
        if (r108 == null) goto L56;
        r100 = r108.getName();
    L56:
        if (TextUtils.isEmpty(r100) == false) goto L58;
        r100 = "Anonymous Dora Device";
    L58:
        r109.name = r100;
        r109.vendorId = r105.f529598c;
        r109.type = ProductNameType.getDeviceTypeByProductId(r105.f529603h);
        r109.productId = r105.f529603h;
        int r111 = r105.f529607l;
        r109.status = r111;
        int r112 = r105.f529597b;
        r109.protocol = r112;
        r109.version = r112;
        r109.mode = e(r111, 8) ? 1 : 0;
        r109.transferAbility = r105.f529609n;
        r109.f204390sn = r105.f529599d;
        r109.model = r105.f529604i;
        r109.sku = r105.f529606k;
        String r113 = r105.f529615t;
        if (TextUtils.isEmpty(r113) == true) goto L61;
        r109.f204389mac = r113;
    L62:
        int r114 = r105.f529611p;
        r109.battery = new int[]{r114 & 127, r105.f529612q & 127, r105.f529610o & 127};
        r109.charge = new int[]{e(r114, 128) ? 1 : 0, e(r105.f529612q, 128) ? 1 : 0, e(r105.f529610o, 128) ? 1 : 0};
        r109.isResetFlag = e(r105.f529607l, 128);
        r109.vendorCapabilities = 0;
        r109.reason = "linkType=0x" + Integer.toHexString(r105.f529596a) + ",protocolVersion=" + r105.f529597b + ",deviceType=0x" + Integer.toHexString(r105.f529600e) + ",majorType=0x" + Integer.toHexString(r105.f529601f) + ",subType=0x" + Integer.toHexString(r105.f529602g) + ",model=0x" + Integer.toHexString(r105.f529605j) + ",color=0x" + Integer.toHexString(r105.f529606k) + ",deviceStatus=0x" + Integer.toHexString(r105.f529607l) + ",blePairing=" + e(r105.f529607l, 8) + ",resetFlag=" + e(r105.f529607l, 128) + ",deviceStatusFlags=" + b(r105.f529607l, new int[]{1, 2, 4, 8, 64, 128}, new String[]{"paired", "sppConnected", "bleConnected", "blePairing", "ancs", "resetFlag"}) + ",linkAbility=0x" + Integer.toHexString(r105.f529608m) + ",linkAbilityFlags=" + b(r105.f529608m, new int[]{1, 2, 4, 8}, new String[]{"ble", "btClassic", "wifi", "eth"}) + ",transferAbility=0x" + Integer.toHexString(r105.f529609n) + ",transferAbilityFlags=" + b(r105.f529609n, new int[]{1, 2, 4, 8, 16}, new String[]{"gatt", "spp", "iap2", "coc", "sppInsecure"}) + ",txPower=0x" + Integer.toHexString(r105.f529613r) + ",serviceFlag=0x" + Integer.toHexString(r105.f529614s);
        StringBuilder r115 = new StringBuilder("readBTMacV2 success, productId : ");
        r115.append(r105.f529603h);
        r115.append(" ,device : ");
        r115.append(r109);
        j.d("BTUtils", r115.toString());
        return r109;
    L61:
        j.f("BTUtils", "fillV2DoraDevice: btMac empty from advertisement, productId=" + r105.f529603h + ", wDid will be empty for G series");
    L33:
        r107 = true;
        goto L34
    L20:
        if (r104.length < 23) goto L23;
        r105 = new C7204a(r104);
    L17:
        r104 = c(r101.getBytes(), 8);
        goto L18
    }

    public static byte[] c(byte[] r100, int r101) {
        if (r100 == null) goto L16;
        if (r101 < 0) goto L16;
        if (r100.length < (r101 + 23)) goto L16;
        int r102 = r100[r101 + 1] & UByte.MAX_VALUE;
        int r103 = r100[r101 + 7] & UByte.MAX_VALUE;
        if (r102 == 1) goto L12;
        if (r102 == 0) goto L12;
    L13:
        return null;
    L12:
        if (ProductNameType.isDoraGSeriesProduct(r103) == false) goto L13;
        byte[] r104 = new byte[23];
        System.arraycopy(r100, r101, r104, 0, 23);
        return r104;
    L16:
        return null;
    }

    public static DoraDevice j(ScanResult r100, int r101) {
        if (r100 != null) goto L6;
        j.d("BTUtils", "readSmartDevice failed: result is null");
        return null;
    L6:
        BluetoothDevice r102 = r100.getDevice();
        if (r102 != null) goto L10;
        j.d("BTUtils", "readSmartDevice failed: BluetoothDevice is null");
        return null;
    L10:
        DoraDevice r103 = DoraDevice.from(r102);
        if (r103 != null) goto L14;
        j.d("BTUtils", "readSmartDevice failed: DoraDevice is null");
        return null;
    L14:
        BluetoothAdapter r104 = BluetoothAdapter.getDefaultAdapter();
        if (r104 != null) goto L17;
        BluetoothDevice r105 = null;
    L19:
        if (TextUtils.isEmpty(r103.name) == false) goto L23;
        if (r105 == null) goto L23;
        r103.name = r105.getName();
    L23:
        if (TextUtils.isEmpty(r103.name) == false) goto L25;
        r103.name = r102.getName();
    L25:
        ScanRecord r106 = r100.getScanRecord();
        if (TextUtils.isEmpty(r103.name) == false) goto L30;
        if (r106 == null) goto L30;
        r103.name = r106.getDeviceName();
        j.d("BTUtils", "Device name is empty. get scan record device name : " + r103.name);
    L30:
        if (TextUtils.isEmpty(r103.name) == false) goto L34;
        if (r105 == null) goto L34;
        r103.name = d(r105);
        j.d("BTUtils", "Device name is empty. getAlias byRemoteDevice : " + r103.name + " ,device mac : " + r103.f204389mac);
    L34:
        if (TextUtils.isEmpty(r103.name) == false) goto L36;
        r103.name = d(r102);
        j.d("BTUtils", "Device name is empty. getAlias byDevice : " + r103.name);
    L36:
        r103.vendorId = r101;
        if (r106 != null) goto L39;
        byte[] r107 = null;
    L41:
        if (r107 != null) goto L43;
    L46:
        byte r108 = 0;
    L47:
        g(r103, r108, 0, r107);
        if (TextUtils.isEmpty(r103.name) == false) goto L50;
        r103.name = ProductNameType.getDeviceName(r103.model);
        j.d("BTUtils", "Device name is empty. get device name by model : " + r103.name);
    L50:
        StringBuilder r109 = new StringBuilder("scanRecord: ");
        if (r107 != null) goto L53;
        int r110 = -1;
    L54:
        r109.append(r110);
        r109.append(" - ");
        r109.append(n.e(r107));
        r109.append(" ,device : ");
        r109.append(r103.name);
        j.d("BTUtils", r109.toString());
        if (r103.vendorCapabilities == 1) goto L58;
        j.d("BTUtils", "Smart device Capabilities is not 0x01, ignore this device : " + r103.name);
        return null;
    L58:
        return r103;
    L53:
        r110 = r107.length;
        goto L54
    L43:
        if (r107.length == 0) goto L46;
        r108 = r107[0];
        goto L47
    L39:
        r107 = r106.getServiceData(ParcelUuid.fromString("0000FDEE-0000-1000-8000-00805F9B34FB"));
        goto L41
    L17:
        r105 = r104.getRemoteDevice(r103.f204389mac);
        goto L19
    }

    public static String b(int r100, int[] r101, String[] r102) {
        StringBuilder r103 = new StringBuilder();
        int r104 = 0;
    L4:
        if (r104 >= r101.length) goto L13;
        if (e(r100, r101[r104]) == false) goto L11;
        if (r103.length() <= 0) goto L10;
        r103.append('|');
    L10:
        r103.append(r102[r104]);
    L11:
        r104 = r104 + 1;
        goto L4
    L13:
        if (r103.length() != 0) goto L16;
        return "none";
    L16:
        return r103.toString();
    }

    public static void g(DoraDevice r100, byte r101, int r102, byte[] r103) {
        if (r103 != null) goto L4;
        return;
    L4:
        if (r102 < r103.length) goto L7;
        return;
    L7:
        if (r101 == 0) goto L44;
        if (r101 == 1) goto L39;
        if (r101 == 2) goto L34;
        if (r101 != 3) goto L14;
        int r104 = r102 + 1;
        if (r103.length <= r104) goto L61;
        byte r105 = r103[r104];
        r100.sku = r105 & UByte.MAX_VALUE;
        j.d("BTUtils", "Smart device sub model id : " + n.e(new byte[]{r105}) + " ,convert to sku : " + r100.sku);
        int r106 = r104 + 1;
        if (r103.length <= r106) goto L62;
        g(r100, r103[r106], r106, r103);
        return;
    L62:
        return;
    L61:
        return;
    L14:
        if (r101 == 4) goto L24;
        if (r101 == 9) goto L19;
        return;
    L19:
        if (r103.length <= (r102 + 2)) goto L55;
        int r107 = r102 + 1;
        byte r108 = r103[r107];
        int r109 = r107 + 1;
        byte r110 = r103[r109];
        r100.vendorCapabilities = r108 & UByte.MAX_VALUE;
        j.d("BTUtils", "Smart device Capabilities : " + r100.vendorCapabilities);
        int r111 = r109 + 1;
        if (r103.length <= r111) goto L56;
        g(r100, r103[r111], r111, r103);
        return;
    L56:
        return;
    L55:
        return;
    L24:
        if (r103.length <= (r102 + 3)) goto L58;
        int r112 = r102 + 1;
        int r113 = r112 + 1;
        int r114 = r113 + 1;
        String r115 = n.f(new byte[]{r103[r112], r103[r113], r103[r114]});
        r100.productId = ProductNameType.getProductIDByModelID(r115);
        r100.model = r115;
        j.d("BTUtils", "Smart device model : " + r100.model + " ,covert to product id : " + r100.productId);
        int r116 = r114 + 1;
        if (r103.length <= r116) goto L59;
        g(r100, r103[r116], r116, r103);
        return;
    L59:
        return;
    L58:
        return;
    L34:
        if (r103.length <= (r102 + 4)) goto L64;
        int r117 = r102 + 1;
        byte r118 = r103[r117];
        int r119 = r117 + 1;
        byte r120 = r103[r119];
        int r121 = r119 + 1;
        byte r122 = r103[r121];
        int r123 = r121 + 1;
        byte r124 = r103[r123];
        int r125 = r123 + 1;
        if (r103.length <= r125) goto L65;
        g(r100, r103[r125], r125, r103);
        return;
    L65:
        return;
    L64:
        return;
    L39:
        if (r103.length <= (r102 + 6)) goto L67;
        int r126 = r102 + 1;
        byte r127 = r103[r126];
        int r128 = r126 + 1;
        byte r129 = r103[r128];
        int r130 = r128 + 1;
        byte r131 = r103[r130];
        int r132 = r130 + 1;
        byte r133 = r103[r132];
        int r134 = r132 + 1;
        byte r135 = r103[r134];
        int r136 = r134 + 1;
        byte r137 = r103[r136];
        int r138 = r136 + 1;
        if (r103.length <= r138) goto L68;
        g(r100, r103[r138], r138, r103);
        return;
    L68:
        return;
    L67:
        return;
    L44:
        if (r103.length <= (r102 + 2)) goto L70;
        int r139 = r102 + 1;
        byte r140 = r103[r139];
        int r141 = r139 + 1;
        byte r142 = r103[r141];
        int r143 = r141 + 1;
        if (r103.length > r143) goto L53;
        return;
    L53:
        g(r100, r103[r143], r143, r103);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    }
}
