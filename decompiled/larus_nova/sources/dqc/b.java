package dqc;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.util.FieldUtils;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import mqc.i;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f469728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Integer> f469729b = null;

    static {
        HashMap r100 = new HashMap();
        f469729b = r100;
        r100.put("arm64-v8a", 64);
        r100.put("armeabi-v7a", 32);
        r100.put("armeabi", 32);
        r100.put("x86_64", 64);
        r100.put("x86", 32);
        r100.put("mips64", 64);
        r100.put("mips", 32);
        f469728a = h();
    }

    public static String f() {
        String r100 = f469728a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        String r101 = h();
        f469728a = r101;
        return r101;
    }

    public static String h() {
        JSONObject r110 = new JSONObject();
        r110.put(MiraMonitor.KEY_PRIMARY_CPU_ABI, "0");     // Catch: JSONException -> L5
        r110.put(MiraMonitor.KEY_PROCESS_MODE, "0");     // Catch: JSONException -> L5
        r110.put(MiraMonitor.KEY_SUPPORTED_ABI0, "0");     // Catch: JSONException -> L5
        r110.put(MiraMonitor.KEY_MATCH_CPU_ABI, "0");     // Catch: JSONException -> L5
        r110.put(MiraMonitor.KEY_DEFAULT_ABI0, "0");     // Catch: JSONException -> L5
        r110.put(MiraMonitor.KEY_DEFAULT_ABI, "0");     // Catch: JSONException -> L5
        r110.put(MiraMonitor.KEY_AUTO_ERROR, "0");     // Catch: JSONException -> L5
        r110.put(MiraMonitor.KEY_MANUAL_ERROR, "0");     // Catch: JSONException -> L5
    L64:
        String r100 = (String) FieldUtils.readField(Zeus.getAppApplication().getApplicationInfo(), MiraMonitor.KEY_PRIMARY_CPU_ABI);     // Catch: Exception -> L36
        String r111 = MiraMonitor.KEY_MANUAL_ERROR;
        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=" + r100);     // Catch: Exception -> L32
        a(r110, MiraMonitor.KEY_PRIMARY_CPU_ABI, r100);     // Catch: Exception -> L32
        if (r100 != null) goto L14;
    L39:
        r100 = null;
    L40:
        if (r100 == null) goto L70;
        return r100;
    L70:
        PolarisZipFileWrapper r101 = new PolarisZipFileWrapper(new PolarisFileWrapper(Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0).applicationInfo.sourceDir));     // Catch: Throwable -> L56
        HashSet r102 = new HashSet(((HashMap) e(r101)).keySet());     // Catch: Throwable -> L56
        r101.close();     // Catch: IOException -> L45 Throwable -> L56
    L46:
        String[] r103 = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L56
        if (r102.isEmpty() == false) goto L49;
        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + r103[0]);     // Catch: Throwable -> L56
        a(r110, MiraMonitor.KEY_SUPPORTED_ABI0, r103[0]);     // Catch: Throwable -> L56
        String r104 = r103[0];     // Catch: Throwable -> L56
    L60:
        return r104;
    L49:
        int r105 = r103.length;     // Catch: Throwable -> L56
        int r106 = 0;
    L50:
        if (r106 >= r105) goto L58;
        String r107 = r103[r106];     // Catch: Throwable -> L56
        if (r102.contains(r107) == true) goto L53;
        r106 = r106 + 1;
        goto L50
    L53:
        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, match cpuAbi=" + r107);     // Catch: Throwable -> L56
        a(r110, MiraMonitor.KEY_MATCH_CPU_ABI, r107);     // Catch: Throwable -> L56
        return r107;
    L58:
        String[] r108 = Build.SUPPORTED_ABIS;
        a(r110, MiraMonitor.KEY_DEFAULT_ABI0, r108[0]);
        r104 = r108[0];
        goto L60
    L45:
        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual failed!", th);
        a(r110, r111, "1");
        goto L58
    L14:
        if (Build.VERSION.SDK_INT < 23) goto L16;
        boolean r109 = true;
    L17:
        if (r109 == true) goto L62;
        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode default=0");     // Catch: Exception -> L32
        int r112 = 0;
    L27:
        a(r110, MiraMonitor.KEY_PROCESS_MODE, "" + r112);     // Catch: Exception -> L32
        if (r112 != 0) goto L30;
        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(r100));     // Catch: Exception -> L32
        goto L40
    L30:
        if (((Integer) ((HashMap) f469729b).get(r100)).intValue() != r112) goto L39;
        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(r100));     // Catch: Exception -> L32
        goto L40
    L62:
        if (Process.is64Bit() == false) goto L21;
        r112 = 64;
    L72:
        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode=" + r112);     // Catch: Exception -> L61
    L25:
        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode exception default=" + r112);     // Catch: Exception -> L32
        goto L27
    L21:
        r112 = 32;
    L24:
        r112 = 0;
        goto L25
    L16:
        r109 = false;
    L32:
        e = e;
    L38:
        ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto failed!", e);
        a(r110, MiraMonitor.KEY_AUTO_ERROR, "1");
    L36:
        e = e;
        r111 = MiraMonitor.KEY_MANUAL_ERROR;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L64
    }

    public static Map e(PolarisZipFileWrapper r100) {
        HashMap r101 = new HashMap();
        Enumeration<? extends ZipEntry> r102 = r100.entries();
        Pattern r103 = PatternProtector.compile("^lib/[^/]+/lib[^/]+.so$");
    L4:
        if (r102.hasMoreElements() == false) goto L24;
        ZipEntry r104 = r102.nextElement();
        if (r104.isDirectory() == true) goto L4;
        if (r104.getName().contains("../") == true) goto L4;
        if (r104.getName().startsWith("lib/") == false) goto L4;
        if (r103.matcher(r104.getName()).matches() == false) goto L4;
        String[] r105 = r104.getName().split(File.separator);
        if (r105 == null) goto L4;
        if (r105.length < 2) goto L4;
        String r106 = r105[r105.length - 2];
        if (((HashMap) f469729b).containsKey(r106) == false) goto L4;
        if (r101.get(r106) != null) goto L23;
        r101.put(r106, new LinkedList());
    L23:
        ((List) r101.get(r106)).add(r104);
        goto L4
    L24:
        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper getAllSoZipEntries, zipFile=" + r100.getName() + ", soEntries=" + r101.toString());
        return r101;
    }

    public static List<ZipEntry> g(Map<String, List<ZipEntry>> r110) {
        if (r110.isEmpty() == false) goto L6;
        return null;
    L6:
        LinkedList r100 = new LinkedList();
        HashSet r101 = new HashSet();
        String r102 = f469728a;
        r102.getClass();
        byte r111 = -1;
        switch(r102.hashCode()) {
            case -1073971299: goto L34;
            case -806050265: goto L30;
            case -738963905: goto L26;
            case 117110: goto L22;
            case 3351711: goto L18;
            case 145444210: goto L14;
            case 1431565292: goto L10;
            default: goto L37;
        };
    L37:
        switch(r111) {
            case 0: goto L45;
            case 1: goto L44;
            case 2: goto L43;
            case 3: goto L42;
            case 4: goto L41;
            case 5: goto L40;
            case 6: goto L39;
            default: goto L46;
        };
    L39:
        b(r110, "arm64-v8a", r100, r101);
        goto L46
    L40:
        b(r110, "armeabi-v7a", r100, r101);
        b(r110, "armeabi", r100, r101);
        goto L46
    L41:
        b(r110, "mips", r100, r101);
        goto L46
    L42:
        b(r110, "x86", r100, r101);
        goto L46
    L43:
        b(r110, "armeabi", r100, r101);
        b(r110, "armeabi-v7a", r100, r101);
        goto L46
    L44:
        b(r110, "x86_64", r100, r101);
        goto L46
    L45:
        b(r110, "mips64", r100, r101);
    L46:
        return r100;
    L10:
        if (r102.equals("arm64-v8a") == false) goto L37;
        r111 = 6;
        goto L37
    L14:
        if (r102.equals("armeabi-v7a") == false) goto L37;
        r111 = 5;
        goto L37
    L18:
        if (r102.equals("mips") == false) goto L37;
        r111 = 4;
        goto L37
    L22:
        if (r102.equals("x86") == false) goto L37;
        r111 = 3;
        goto L37
    L26:
        if (r102.equals("armeabi") == false) goto L37;
        r111 = 2;
        goto L37
    L30:
        if (r102.equals("x86_64") == false) goto L37;
        r111 = 1;
        goto L37
    L34:
        if (r102.equals("mips64") == false) goto L37;
        r111 = 0;
        goto L37
    }

    public static mqc.f<Boolean, Map<String, List<ZipEntry>>> i(File r100) {
        String r101 = f();
        HashMap r102 = new HashMap();
        PolarisZipFileWrapper r103 = null;
        PolarisZipFileWrapper r104 = new PolarisZipFileWrapper(r100);     // Catch: Throwable -> L23 IOException -> L25
        r102.putAll(e(r104));     // Catch: IOException -> L18 Throwable -> L20
        if (r102.isEmpty() == false) goto L7;
        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [true] soEntries empty, " + r100);     // Catch: IOException -> L18 Throwable -> L20
        boolean r105 = true;
    L13:
        mqc.f<Boolean, Map<String, List<ZipEntry>>> r106 = new mqc.f(Boolean.valueOf(r105), r102);     // Catch: IOException -> L18 Throwable -> L20
        r104.close();     // Catch: IOException -> L16
    L17:
        return r106;
    L16:
        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
        goto L17
    L7:
        boolean r107 = j(r102, r101);     // Catch: IOException -> L18 Throwable -> L20
        if (r107 == false) goto L11;
        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + r107 + "], " + r100);     // Catch: IOException -> L18 Throwable -> L20
    L12:
        r105 = r107;
        goto L13
    L11:
        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + r107 + "], " + r100);     // Catch: IOException -> L18 Throwable -> L20
    L18:
        e = e;
        r103 = r104;
    L26:
        ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, get sourceApk ZipFile failed!", e);     // Catch: Throwable -> L23
        mqc.f<Boolean, Map<String, List<ZipEntry>>> r108 = new mqc.f(Boolean.FALSE, r102);     // Catch: Throwable -> L23
        if (r103 != null) goto L40;
    L31:
        return r108;
    L40:
        r103.close();     // Catch: IOException -> L30
    L30:
        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
    L20:
        th = th;
    L33:
        if (r104 != null) goto L45;
    L37:
        throw th;
    L45:
        r104.close();     // Catch: IOException -> L36
    L36:
        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
    L23:
        th = th;
        r104 = r103;
    L25:
        e = e;
        goto L26
    }

    public static boolean j(Map<String, List<ZipEntry>> r100, String r101) {
        if (TextUtils.equals(r101, "armeabi") == true) goto L10;
        if (TextUtils.equals(r101, "armeabi-v7a") == true) goto L10;
        return r100.containsKey(r101);
    L10:
        if (r100.containsKey("armeabi") == false) goto L12;
    L15:
        return true;
    L12:
        if (r100.containsKey("armeabi-v7a") == true) goto L15;
        return false;
    }

    public static void a(JSONObject r100, String r101, String r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void d(PolarisZipFileWrapper r100, ZipEntry r101, PolarisFileWrapper r102) throws IOException {
        String r103 = r101.getName();
        if (r103.contains(DownloadConstants.VULNERABILITY_PATH) == false) goto L5;
        return;
    L5:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r102, r103.substring(r103.lastIndexOf(File.separator) + 1));
        int r105 = 0;
        boolean r106 = false;
    L7:
        if (r104.exists() == false) goto L18;
        r104.delete();
    L18:
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copySoZipEntry, soZipEntry=" + r101 + ", targetSoFile=" + r104);     // Catch: IOException -> L11
        i.d(r100.getInputStream(r101), new PolarisFileOutputStreamWrapper(r104));     // Catch: IOException -> L11
        r106 = true;
    L15:
        if (r106 == false) goto L7;
        return;
    L11:
        e = move-exception;
        if (r105 >= 3) goto L17;
        r105 = r105 + 1;
        goto L15
    L17:
        throw e;
    }

    public static void b(Map<String, List<ZipEntry>> r100, String r101, List<ZipEntry> r102, Set<String> r103) {
        List<ZipEntry> r104 = r100.get(r101);
        if (r104 != null) goto L5;
        return;
    L5:
        if (r104.size() == 0) goto L19;
        Iterator<ZipEntry> r105 = r104.iterator();
    L9:
        if (r105.hasNext() == false) goto L20;
        ZipEntry r106 = r105.next();
        String r107 = r106.getName().substring(r106.getName().lastIndexOf(File.separator) + 1);
        HashSet r108 = (HashSet) r103;
        if (r108.contains(r107) == true) goto L9;
        ((LinkedList) r102).add(r106);
        r108.add(r107);
        goto L9
    L20:
        return;
    }

    public static void c(PolarisFileWrapper r100, PolarisFileWrapper r101, String r102, Map r103) throws IOException {
        PolarisZipFileWrapper r104 = new PolarisZipFileWrapper(r100);     // Catch: Throwable -> L29 IOException -> L31
        if (r103 == null) goto L40;
    L8:
        boolean r105 = j(r103, f());     // Catch: Throwable -> L6 IOException -> L27
        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper copyNativeLib pre-verify-matchHostAbi[" + r105 + "], pkg=" + r102 + ", plugin so entries = " + r103.keySet());     // Catch: Throwable -> L6 IOException -> L27
        if (r105 == false) goto L25;
        List<ZipEntry> r106 = g(r103);     // Catch: Throwable -> L6 IOException -> L27
        if (r106 != null) goto L13;
    L22:
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copyNativeLib, supportedSoEntries empty, pkg=" + r102);     // Catch: Throwable -> L6 IOException -> L27
        r104.close();
        return;
    L13:
        if (r106.isEmpty() == true) goto L22;
        if (r101.exists() == true) goto L18;
        r101.mkdirs();     // Catch: Throwable -> L6 IOException -> L27
    L18:
        Iterator<ZipEntry> r107 = r106.iterator();     // Catch: Throwable -> L6 IOException -> L27
    L20:
        if (r107.hasNext() == false) goto L25;
        d(r104, r107.next(), r101);     // Catch: Throwable -> L6 IOException -> L27
    L25:
        r104.close();
        return;
    L40:
        r103 = e(r104);     // Catch: Throwable -> L6 IOException -> L27
    L27:
        e = e;
    L32:
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "NativeLibHelper copyNativeLib, IOException, pkg=" + r102, e);     // Catch: Throwable -> L29
        throw e;     // Catch: Throwable -> L29
    L6:
        th = th;
    L35:
        if (r104 == null) goto L37;
        r104.close();
    L37:
        throw th;
    L29:
        th = th;
        r104 = null;
    L31:
        e = e;
        goto L32
    }
}
