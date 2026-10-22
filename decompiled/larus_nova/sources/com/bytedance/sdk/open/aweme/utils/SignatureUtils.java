package com.bytedance.sdk.open.aweme.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class SignatureUtils {
    public SignatureUtils() {
    }

    public static List<String> getMd5Signs(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L14;
        return null;
    L14:
        PackageInfo r102 = r100.getPackageManager().getPackageInfo(r101, 64);     // Catch: PackageManager.NameNotFoundException -> L13
        ArrayList r103 = new ArrayList();
        Signature[] r104 = r102.signatures;
        if (r104 == null) goto L12;
        int r105 = r104.length;
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L11;
        r103.add(Md5Utils.hexDigest(r104[r106].toByteArray()));
        r106 = r106 + 1;
        goto L9
    L11:
        return r103;
    L12:
        return null;
    }

    public static String packageSignature(List<String> r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == true) goto L18;
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L7:
        if (r102 >= r100.size()) goto L12;
        if (r102 == 0) goto L10;
        r101.append(",");
    L10:
        r101.append((String) ListProtector.get(r100, r102));
        r102 = r102 + 1;
        goto L7
    L12:
        return r101.toString();
    L18:
        return null;
    }

    public static boolean validateSign(Context r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L19;
        if (r100 == null) goto L19;
        List<String> r103 = getMd5Signs(r100, r101);
        if (r103 == null) goto L19;
        if (r103.size() <= 0) goto L19;
        Iterator<String> r104 = r103.iterator();
    L14:
        if (r104.hasNext() == false) goto L19;
        if (r102.equalsIgnoreCase(r104.next()) == false) goto L14;
        return true;
    }
}
