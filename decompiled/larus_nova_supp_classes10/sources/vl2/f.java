package vl2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.android.livesdk.utils.q1;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public static m a(String r12, int r13) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r12);
        JSONObject r4 = null;
        if (r0.exists() == true) goto L6;
    L7:
        File[] r1 = null;
    L17:
        boolean r2 = true;
    L19:
        if (r2 == false) goto L21;
        return null;
    L21:
        HashMap<String, Bitmap> r3 = new HashMap();
        int r5 = r1.length;
        int r6 = 0;
        boolean r7 = false;
    L22:
        if (r6 >= r5) goto L43;
        File r8 = r1[r6];
        String r9 = r8.getName();
        if (r8.isDirectory() == false) goto L32;
        File[] r10 = r8.listFiles();
        int r11 = r10.length;
        int r14 = 0;
    L26:
        if (r14 >= r11) goto L42;
        File r15 = r10[r14];
        String r16 = r15.getName();
        if (r16.contains(".png") == false) goto L30;
        r3.put(r16, BitmapFactory.decodeFile(r15.getAbsolutePath()));
    L30:
        r14 = r14 + 1;
    L42:
        r6 = r6 + 1;
        goto L22
    L32:
        if (r9.contains(".json") == false) goto L42;
        if (r7 == true) goto L42;
        PolarisFileInputStreamWrapper r17 = new PolarisFileInputStreamWrapper(r8);     // Catch: Exception -> L40
        BufferedReader r18 = new BufferedReader(new InputStreamReader(r17));     // Catch: Exception -> L40
        StringBuilder r19 = new StringBuilder();     // Catch: Exception -> L40
    L35:
        String r20 = r18.readLine();     // Catch: Exception -> L40
        if (r20 == null) goto L38;
        r19.append(r20);     // Catch: Exception -> L40
        goto L35
    L38:
        r18.close();     // Catch: Exception -> L40
        r17.close();     // Catch: Exception -> L40
        r4 = new JSONObject(r19.toString());     // Catch: Exception -> L40
        r7 = true;
    L40:
        e = move-exception;
        e.printStackTrace();
        goto L42
    L43:
        m r21 = new m();
        r21.a = r13;
        r21.b = r12;
        r21.c = r4;
        r21.d = r3;
        return r21;
    L6:
        if (r0.isFile() == true) goto L7;
        r1 = r0.listFiles();
        if (r1 == null) goto L17;
        if (r1.length == 1) goto L45;
    L18:
        r2 = false;
        goto L19
    L45:
        q1.b(r1[0].getPath(), r12);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }
}
