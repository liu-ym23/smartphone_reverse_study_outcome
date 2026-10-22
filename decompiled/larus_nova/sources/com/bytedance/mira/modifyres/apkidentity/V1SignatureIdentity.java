package com.bytedance.mira.modifyres.apkidentity;

import android.text.TextUtils;
import com.bytedance.mira.util.EncryptUtils;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes21.dex */
public class V1SignatureIdentity {
    private static final String CERT_RSA_FILE = ".RSA";
    private static final String CERT_SF_FILE = ".SF";
    private static final String MANIFEST_MF_FILE = "MANIFEST.MF";
    private static final String SIGNATURE_VERSION = "V1";
    private static final String V1_SIG_DIR = "META-INF/";

    public V1SignatureIdentity() {
    }

    public static String[] getIdentity(File r110) {
        String r100 = "";
        PolarisZipFileWrapper r101 = null;
        PolarisZipFileWrapper r102 = new PolarisZipFileWrapper(r110);     // Catch: Throwable -> L33 Exception -> L43
        Enumeration<? extends ZipEntry> r111 = r102.entries();     // Catch: Throwable -> L30 Exception -> L32
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L30 Exception -> L32
        boolean r104 = false;
        boolean r105 = false;
        boolean r106 = false;
    L6:
        if (r111.hasMoreElements() == false) goto L19;
        ZipEntry r107 = r111.nextElement();     // Catch: Throwable -> L30 Exception -> L32
        if (r107.getName().startsWith(V1_SIG_DIR) == false) goto L6;
        if (r107.getName().endsWith(MANIFEST_MF_FILE) == false) goto L13;
        r106 = true;
    L18:
        r103.add(Long.valueOf(r107.getCrc()));     // Catch: Throwable -> L30 Exception -> L32
        goto L6
    L13:
        if (r107.getName().endsWith(CERT_SF_FILE) == false) goto L16;
        r104 = true;
        goto L18
    L16:
        if (r107.getName().endsWith(CERT_RSA_FILE) == false) goto L18;
        r105 = true;
        goto L18
    L19:
        Collections.sort(r103, Collections.reverseOrder());     // Catch: Throwable -> L30 Exception -> L32
        StringBuilder r112 = new StringBuilder();     // Catch: Throwable -> L30 Exception -> L32
        Iterator r108 = r103.iterator();     // Catch: Throwable -> L30 Exception -> L32
    L21:
        if (r108.hasNext() == false) goto L23;
        r112.append((Long) r108.next());     // Catch: Throwable -> L30 Exception -> L32
        goto L21
    L23:
        if (r106 == false) goto L28;
        if (r104 == false) goto L28;
        if (r105 == false) goto L28;
        String r113 = EncryptUtils.encryptMD5ToString(r112.toString());     // Catch: Throwable -> L30 Exception -> L32
        String r109 = "";
    L29:
        ZipUtils.safeCloseZipFile(r102);
    L37:
        String[] r114 = new String[3];
        r114[0] = r113;
        if (TextUtils.isEmpty(r113) == true) goto L41;
        r100 = "V1";
    L41:
        r114[1] = r100;
        r114[2] = r109;
        return r114;
    L28:
        r109 = "without v1 signature.";
        r113 = "";
    L32:
        r101 = r102;
    L30:
        th = th;
        r101 = r102;
    L34:
        ZipUtils.safeCloseZipFile(r101);
        throw th;
    L33:
        th = th;
    L36:
        ZipUtils.safeCloseZipFile(r101);
        r113 = "";
        r109 = r113;
        goto L37
    }
}
