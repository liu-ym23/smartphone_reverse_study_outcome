package zqa;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class c {
    public static String b(List<String> r100) {
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

    public static List<String> a(Context r110, String r111) {
        if (TextUtils.isEmpty(r111) == false) goto L27;
        return null;
    L27:
        PackageInfo r112 = r110.getPackageManager().getPackageInfo(r111, 64);     // Catch: PackageManager.NameNotFoundException -> L24
        if (r112 != null) goto L8;
        return null;
    L8:
        ArrayList r113 = new ArrayList();
        Signature[] r114 = r112.signatures;
        if (r114 == null) goto L23;
        int r100 = r114.length;
        int r101 = 0;
    L11:
        if (r101 >= r100) goto L22;
        byte[] r102 = r114[r101].toByteArray();
        MessageDigest r103 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L19
        r103.update(r102);     // Catch: Exception -> L19
        byte[] r104 = r103.digest();     // Catch: Exception -> L19
        char[] r105 = new char[32];     // Catch: Exception -> L19
        int r106 = 0;
        int r107 = 0;
    L15:
        if (r106 >= 16) goto L17;
        byte r108 = r104[r106];     // Catch: Exception -> L19
        int r109 = r107 + 1;     // Catch: Exception -> L19
        char[] r115 = b.f573357a;     // Catch: Exception -> L19
        r105[r107] = r115[(r108 >>> 4) & 15];     // Catch: Exception -> L19
        r107 = r109 + 1;     // Catch: Exception -> L19
        r105[r109] = r115[r108 & 15];     // Catch: Exception -> L19
        r106 = r106 + 1;     // Catch: Exception -> L19
        goto L15
    L17:
        String r116 = new String(r105);     // Catch: Exception -> L19
    L21:
        r113.add(r116);
        r101 = r101 + 1;
    L19:
        e = move-exception;
        e.printStackTrace();
        r116 = null;
        goto L21
    L22:
        return r113;
    L23:
        return null;
    }
}
