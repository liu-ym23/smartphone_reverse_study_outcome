package o87;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.reader_apk.SignatureNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String[] f522388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f522389b;

    static {
        f522388a = new String[3];
    }

    public static String a(Context r100) {
        if (f522389b == true) goto L6;
        b(r100);
        f522389b = true;
    L6:
        if (f522389b == true) goto L9;
        b(r100);
        f522389b = true;
    L9:
        if (TextUtils.isEmpty(f522388a[0]) == true) goto L12;
        String r101 = f522388a[0];
    L15:
        HashMap r102 = null;
        if (TextUtils.isEmpty(r101) == false) goto L34;
    L28:
        if (r102 != null) goto L30;
    L33:
        return "";
    L30:
        if (r102.size() <= 0) goto L33;
        return (String) r102.get("meta_umeng_channel");
    L34:
        JSONObject r103 = new JSONObject(r101);     // Catch: Exception -> L24 JSONException -> L26
        Iterator<String> r104 = r103.keys();     // Catch: Exception -> L24 JSONException -> L26
        HashMap r105 = new HashMap();     // Catch: Exception -> L24 JSONException -> L26
    L20:
        if (r104.hasNext() == false) goto L23;
        String r106 = r104.next().toString();     // Catch: Exception -> L24 JSONException -> L26
        r105.put(r106, JSONObjectProtectorUtils.getString(r103, r106));     // Catch: Exception -> L24 JSONException -> L26
    L23:
        r102 = r105;
    L26:
        e = move-exception;
        e.printStackTrace();
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L12:
        if (TextUtils.isEmpty(f522388a[1]) == true) goto L14;
        r101 = f522388a[1];
        goto L15
    L14:
        r101 = "";
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r6v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36 */
    public static void b(Context r110) {
        int[] r100 = {-1721342362, 1903654775, 1903654776};
        ?? r101 = 0;
        String r102 = null;
        r102 = null;
        r102 = null;
        r102 = null;
        r102 = null;
        r102 = null;
        ApplicationInfo r111 = r110.getApplicationInfo();     // Catch: Throwable -> L153
        if (r111 == null) goto L8;
        String r112 = r111.sourceDir;     // Catch: Throwable -> L153
    L10:
        if (TextUtils.isEmpty(r112) == false) goto L12;
        f522388a = new String[]{"", "", ""};
    L12:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r112);
        RandomAccessFile r113 = new RandomAccessFile(r103, "r");     // Catch: Throwable -> L24 IOException -> L33
        FileChannel r104 = r113.getChannel();     // Catch: Throwable -> L21 IOException -> L23
    L182:
        Map<Integer, ByteBuffer> r105 = a.b(a.a(r104).f522386a);     // Catch: Throwable -> L18 IOException -> L20
        r104.close();     // Catch: IOException -> L151 Throwable -> L43
    L46:
        if (r105 == null) goto L53;
        byte[][] r106 = new byte[3][];
        int r107 = 0;
    L48:
        if (r107 >= 3) goto L55;
        ByteBuffer r108 = r105.get(Integer.valueOf(r100[r107]));
        if (r108 == null) goto L52;
        byte[] r114 = r108.array();
        int r115 = r108.arrayOffset();
        r106[r107] = Arrays.copyOfRange(r114, r108.position() + r115, r115 + r108.limit());
    L52:
        r107 = r107 + 1;
    L55:
        if (r106 != null) goto L57;
        String[] r109 = null;
    L66:
        if (r109 != null) goto L69;
        r109 = f522388a;
    L69:
        f522388a = r109;
        if (r109.length >= 2) goto L72;
    L142:
        String[] r116 = f522388a;
        if (r116.length >= 3) goto L145;
        return;
    L145:
        if (TextUtils.isEmpty(r116[2]) == true) goto L198;
        int r117 = f522388a[2].length();
        if (r117 <= 4) goto L149;
        String[] r118 = f522388a;
        r118[2] = r118[2].substring(2, r117 - 2);
        return;
    L149:
        f522388a[2] = "";
        return;
    L198:
        return;
    L72:
        if (TextUtils.isEmpty(r109[0]) == false) goto L142;
        ?? r119 = TextUtils.isEmpty(f522388a[1]);
        if (r119 == 0) goto L142;
        RandomAccessFile r120 = new RandomAccessFile(r103, "r");     // Catch: Throwable -> L105 Exception -> L107 IOException -> L112 FileNotFoundException -> L118 UnsupportedEncodingException -> L123
        byte[] r121 = new byte[8];     // Catch: Exception -> L97 IOException -> L99 FileNotFoundException -> L101 UnsupportedEncodingException -> L103 Throwable -> L134
        long r122 = r120.length() - ((long) 8);     // Catch: Exception -> L97 IOException -> L99 FileNotFoundException -> L101 UnsupportedEncodingException -> L103 Throwable -> L134
        r120.seek(r122);     // Catch: Exception -> L97 IOException -> L99 FileNotFoundException -> L101 UnsupportedEncodingException -> L103 Throwable -> L134
        r120.readFully(r121);     // Catch: Exception -> L97 IOException -> L99 FileNotFoundException -> L101 UnsupportedEncodingException -> L103 Throwable -> L134
        if (p87.a.a(r121) == false) goto L160;
        long r123 = r122 - 2;
        r120.seek(r123);     // Catch: Exception -> L97 IOException -> L99 FileNotFoundException -> L101 UnsupportedEncodingException -> L103 Throwable -> L134
        int r124 = p87.a.b(r120);     // Catch: Exception -> L97 IOException -> L99 FileNotFoundException -> L101 UnsupportedEncodingException -> L103 Throwable -> L134
        if (r124 > 0) goto L91;
        r120.close();     // Catch: IOException -> L88
    L82:
        r102 = "";
        r119 = r120;
    L130:
        String[] r125 = f522388a;
        if (r102 != null) goto L133;
        r102 = "";
    L133:
        r125[0] = r102;
    L88:
        e = e;
    L81:
        e.printStackTrace();
        goto L82
    L91:
        r120.seek(r123 - ((long) r124));     // Catch: Exception -> L97 IOException -> L99 FileNotFoundException -> L101 UnsupportedEncodingException -> L103 Throwable -> L134
        byte[] r126 = new byte[r124];     // Catch: Exception -> L97 IOException -> L99 FileNotFoundException -> L101 UnsupportedEncodingException -> L103 Throwable -> L134
        r120.readFully(r126);     // Catch: Exception -> L97 IOException -> L99 FileNotFoundException -> L101 UnsupportedEncodingException -> L103 Throwable -> L134
        String r127 = new String(r126, "UTF-8");     // Catch: Exception -> L97 IOException -> L99 FileNotFoundException -> L101 UnsupportedEncodingException -> L103 Throwable -> L134
        r120.close();     // Catch: IOException -> L94
    L96:
        r102 = r127;
        r119 = r120;
    L94:
        e = move-exception;
        e.printStackTrace();
        goto L96
    L160:
        r120.close();     // Catch: IOException -> L80
    L80:
        e = e;
    L101:
        e = e;
    L120:
        e.printStackTrace();     // Catch: Throwable -> L134
        r119 = r120;
        if (r120 == null) goto L130;
        RandomAccessFile r128 = r120;
    L178:
        r128.close();     // Catch: IOException -> L128
        r119 = r128;
    L128:
        e = move-exception;
        e.printStackTrace();
        r119 = r128;
    L103:
        e = e;
    L125:
        e.printStackTrace();     // Catch: Throwable -> L134
        r119 = r120;
        r128 = r120;
        if (r120 == null) goto L130;
    L99:
        e = e;
    L114:
        e.printStackTrace();     // Catch: Throwable -> L134
        r119 = r120;
        r128 = r120;
        if (r120 == null) goto L130;
    L97:
        e = e;
    L109:
        e.printStackTrace();     // Catch: Throwable -> L134
        r119 = r120;
        if (r120 == null) goto L130;
        r128 = r120;
        goto L178
    L118:
        e = e;
        r120 = null;
    L123:
        e = e;
        r120 = null;
    L112:
        e = e;
        r120 = null;
    L107:
        e = e;
        r120 = null;
    L105:
        th = th;
    L136:
        if (r101 != 0) goto L154;
    L141:
        throw th;
    L154:
        r101.close();     // Catch: IOException -> L139
    L139:
        e = move-exception;
        e.printStackTrace();
    L134:
        th = th;
        r101 = r119;
        goto L136
    L57:
        r109 = new String[3];
        int r129 = 0;
    L58:
        if (r129 >= 3) goto L66;
        byte[] r130 = r106[r129];     // Catch: UnsupportedEncodingException -> L64
        if (r130 == null) goto L62;
        r109[r129] = new String(r130, "UTF-8");     // Catch: UnsupportedEncodingException -> L64
    L63:
        r129 = r129 + 1;
        goto L58
    L62:
        r109[r129] = "";     // Catch: UnsupportedEncodingException -> L64
    L64:
        e = move-exception;
        e.printStackTrace();
        goto L66
    L53:
        r106 = null;
    L41:
        r113.close();     // Catch: Throwable -> L43
        goto L46
    L18:
        Throwable th10 = th;
    L26:
        if (r104 != null) goto L168;
    L30:
        if (r113 == null) goto L195;
        r113.close();     // Catch: IOException -> L152 SignatureNotFoundException -> L37
        throw th10;     // Catch: SignatureNotFoundException -> L37
    L196:
        throw th10;     // Catch: SignatureNotFoundException -> L37
    L195:
        throw th10;     // Catch: SignatureNotFoundException -> L37
    L168:
        r104.close();     // Catch: IOException -> L29 SignatureNotFoundException -> L37
    L34:
        if (r104 != null) goto L176;
    L39:
        if (r113 == null) goto L44;
        r105 = null;
        goto L41
    L176:
        r104.close();     // Catch: SignatureNotFoundException -> L37 IOException -> L38
    L23:
        r104 = null;
    L21:
        th10 = th;
        r104 = null;
        goto L26
    L33:
        r113 = null;
        r104 = null;
    L24:
        th = move-exception;
        th10 = th;
        r113 = null;
        r104 = null;
    L44:
        r105 = null;
    L8:
        r112 = null;
        goto L10
    }
}
