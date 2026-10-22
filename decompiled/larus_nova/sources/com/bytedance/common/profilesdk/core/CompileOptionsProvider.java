package com.bytedance.common.profilesdk.core;

import android.os.Build;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.profilesdk.AppContext;
import com.bytedance.common.profilesdk.util.FileUtils;
import com.bytedance.common.profilesdk.util.Logger;
import com.bytedance.mira.oat.Dex2OatHelper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes15.dex */
public class CompileOptionsProvider {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v31, types: [java.util.regex.Pattern] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.security.android.aopcheck.PolarisFileWrapper, java.io.File] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v9 */
    private static long getImageBaseAddress() {
        if (Build.VERSION.SDK_INT <= 28) goto L5;
        return 0;
    L5:
        ?? r100 = new PolarisFileWrapper("/proc/self/maps");
        ?? r101 = 0;
        r101 = 0;
        r101 = 0;
        r101 = 0;
        r101 = 0;
        r101 = 0;
        r101 = 0;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L72 Exception -> L74 IllegalArgumentException -> L81 IOException -> L88 FileNotFoundException -> L95
        r100 = new BufferedReader(new InputStreamReader(r102));     // Catch: Throwable -> L57 Exception -> L60 IllegalArgumentException -> L63 IOException -> L66 FileNotFoundException -> L69
    L129:
        String r103 = System.getenv("DEX2OATBOOTCLASSPATH");     // Catch: Throwable -> L47 Exception -> L49 IllegalArgumentException -> L51 IOException -> L53 FileNotFoundException -> L55
        if (TextUtils.isEmpty(r103) == false) goto L12;
        r103 = System.getenv("BOOTCLASSPATH");     // Catch: Throwable -> L47 Exception -> L49 IllegalArgumentException -> L51 IOException -> L53 FileNotFoundException -> L55
    L12:
        if (TextUtils.isEmpty(r103) == false) goto L16;
        Logger.d("Can't get bootclasspath for relocate.");     // Catch: Throwable -> L47 Exception -> L49 IllegalArgumentException -> L51 IOException -> L53 FileNotFoundException -> L55
        r102.close();     // Catch: IOException -> L109
        r100.close();     // Catch: IOException -> L109
    L15:
        return 0;
    L16:
        String[] r104 = r103.split(":");     // Catch: Throwable -> L47 Exception -> L49 IllegalArgumentException -> L51 IOException -> L53 FileNotFoundException -> L55
        if (r104.length >= 2) goto L21;
        Logger.d("Illegal bootclasspath.");     // Catch: Throwable -> L47 Exception -> L49 IllegalArgumentException -> L51 IOException -> L53 FileNotFoundException -> L55
        r102.close();     // Catch: IOException -> L110
        r100.close();     // Catch: IOException -> L110
    L20:
        return 0;
    L21:
        String r105 = r104[r104.length - 1];     // Catch: Throwable -> L47 Exception -> L49 IllegalArgumentException -> L51 IOException -> L53 FileNotFoundException -> L55
        String r106 = "boot-" + r105.substring(r105.lastIndexOf(HTTP.URL_DEFAULT) + 1, r105.lastIndexOf(".")) + ".oat";     // Catch: Throwable -> L47 Exception -> L49 IllegalArgumentException -> L51 IOException -> L53 FileNotFoundException -> L55
        Logger.d("Get last boot oat:" + r106);     // Catch: Throwable -> L47 Exception -> L49 IllegalArgumentException -> L51 IOException -> L53 FileNotFoundException -> L55
        boolean r107 = false;
    L22:
        String r108 = r100.readLine();     // Catch: Throwable -> L47 Exception -> L49 IllegalArgumentException -> L51 IOException -> L53 FileNotFoundException -> L55
        if (r108 == null) goto L30;
        if (r108.endsWith(r106) == true) goto L26;
        if (r108.endsWith("/system@framework@boot.oat") == false) goto L22;
    L26:
        r101 = r108;
        r107 = true;
        goto L22
    L30:
        if (r107 == false) goto L44;
        Matcher r109 = Pattern.compile("([0-9a-zA-Z]+)-([0-9a-zA-Z]+)\\s+([rwxps-]+)\\s+([0-9a-zA-Z]+)\\s+([^\\s]+)[\\s+]([^\\s]+)\\s+(.*)").matcher(r101);     // Catch: Throwable -> L47 Exception -> L49 IllegalArgumentException -> L51 IOException -> L53 FileNotFoundException -> L55
        if (r109.matches() == false) goto L44;
        if (r109.groupCount() < 7) goto L44;
        String r110 = r109.group(2);     // Catch: Throwable -> L47 Exception -> L49 IllegalArgumentException -> L51 IOException -> L53 FileNotFoundException -> L55
        if (TextUtils.isEmpty(r110) == true) goto L44;
        long r111 = (Long.parseLong(r110, 16) + 67108864) + 67108864;     // Catch: Throwable -> L47 Exception -> L49 IllegalArgumentException -> L51 IOException -> L53 FileNotFoundException -> L55
        if (r101.contains("arm64") == false) goto L40;
    L41:
        r111 = (r111 + 536870912) + 67108864;
    L114:
        r102.close();     // Catch: IOException -> L111
        r100.close();     // Catch: IOException -> L111
    L43:
        return r111;
    L40:
        if (r101.contains("x86_64") == false) goto L114;
    L44:
        r102.close();     // Catch: IOException -> L112
    L45:
        r100.close();     // Catch: IOException -> L112
    L120:
    L55:
        e = e;
    L71:
        r101 = r102;
        r100 = r100;
    L97:
        e.printStackTrace();     // Catch: Throwable -> L103
        if (r101 == 0) goto L100;
        r101.close();     // Catch: IOException -> L112
    L100:
        if (r100 == 0) goto L120;
    L53:
        e = e;
    L68:
        r101 = r102;
        r100 = r100;
    L90:
        e.printStackTrace();     // Catch: Throwable -> L103
        if (r101 == 0) goto L93;
        r101.close();     // Catch: IOException -> L112
    L93:
        if (r100 == 0) goto L120;
    L51:
        e = e;
    L65:
        r101 = r102;
        r100 = r100;
    L83:
        e.printStackTrace();     // Catch: Throwable -> L103
        if (r101 == 0) goto L86;
        r101.close();     // Catch: IOException -> L112
    L86:
        if (r100 == 0) goto L120;
    L49:
        e = e;
    L62:
        r101 = r102;
        r100 = r100;
    L76:
        e.printStackTrace();     // Catch: Throwable -> L103
        if (r101 == 0) goto L79;
        r101.close();     // Catch: IOException -> L112
    L79:
        if (r100 == 0) goto L120;
    L47:
        th = th;
    L59:
        r101 = r102;
    L104:
        if (r101 != 0) goto L123;
    L106:
        if (r100 == 0) goto L108;
        r100.close();     // Catch: IOException -> L113
    L108:
        throw th;
    L123:
        r101.close();     // Catch: IOException -> L113
    L69:
        e = e;
        r100 = 0;
    L66:
        e = e;
        r100 = 0;
    L63:
        e = e;
        r100 = 0;
    L60:
        e = e;
        r100 = 0;
    L57:
        th = th;
        r100 = 0;
        goto L59
    L95:
        e = e;
        r100 = 0;
    L88:
        e = e;
        r100 = 0;
    L81:
        e = e;
        r100 = 0;
    L74:
        e = e;
        r100 = 0;
    L72:
        th = th;
        r100 = 0;
    L102:
        return 0;
    L103:
        th = th;
        goto L104
    }

    public static List<String> getCompileOptions(String r100, String r101, String r102, String r103) {
        ArrayList r104 = new ArrayList();
        int r105 = Build.VERSION.SDK_INT;
        if (r105 < 24) goto L5;
        r104.add("--runtime-arg");
        r104.add("-classpath");
        r104.add("--runtime-arg");
        r104.add("&");
    L5:
        r104.add("--instruction-set=" + AppContext.getInstructionSet());
        r104.add("--dex-file=" + r100);
        r104.add("--oat-file=" + r101);
        StringBuilder r106 = new StringBuilder("--app-image-file=");
        boolean r107 = false;
        r106.append(r101.substring(0, r101.lastIndexOf(".")));
        r106.append(Dex2OatHelper.ART_SUFFIX);
        r104.add(r106.toString());
        if (r105 < 27) goto L8;
        r104.add("--class-loader-context=" + r102);
    L8:
        if (r103 != null) goto L10;
    L12:
        if (r107 == false) goto L14;
        r104.add("--compiler-filter=speed-profile");
        r104.add("--profile-file=" + r103);
    L16:
        if ((AppContext.getContext().getApplicationInfo().flags & 2) == 0) goto L18;
        r104.add("--debuggable");
    L18:
        long r108 = getImageBaseAddress();
        if (r108 == 0) goto L21;
        r104.add("--base=0x" + Long.toHexString(r108));
    L21:
        return r104;
    L14:
        r104.add("--compiler-filter=speed");
        goto L16
    L10:
        if (FileUtils.isFileValid(new PolarisFileWrapper(r103)) == false) goto L12;
        r107 = true;
        goto L12
    }
}
