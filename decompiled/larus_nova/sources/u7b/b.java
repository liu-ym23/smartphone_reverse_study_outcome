package u7b;

import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f549135a = null;

    public b() {
    }

    static {
        HashMap r100 = new HashMap();
        InputStream r101 = b.class.getResourceAsStream("/org/org.commonmark/internal/util/entities.properties");
        if (r101 != null) goto L29;
        r100.put("NewLine", "\n");
    L16:
        f549135a = r100;
        return;
    L29:
        BufferedReader r102 = new BufferedReader(new InputStreamReader(r101, StandardCharsets.UTF_8));     // Catch: IOException -> L24
    L30:
        String r103 = r102.readLine();     // Catch: Throwable -> L18
        if (r103 == null) goto L14;
        if (r103.length() == 0) goto L30;
        int r104 = r103.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L18
        r100.put(r103.substring(0, r104), r103.substring(r104 + 1));     // Catch: Throwable -> L18
    L14:
        r102.close();     // Catch: IOException -> L24
        r100.put("NewLine", "\n");
    L18:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L21
    L23:
        throw th;     // Catch: IOException -> L24
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L24
    L24:
        e = move-exception;
        throw new IllegalStateException("Failed reading data for HTML named character references", e);
    }

    public static String a(String r100) {
        if (r100.startsWith("&") == true) goto L5;
    L25:
        return r100;
    L5:
        if (r100.endsWith(i.f25853b) == false) goto L25;
        String r101 = r100.substring(1, r100.length() - 1);
        if (r101.startsWith("#") == false) goto L22;
        String r102 = r101.substring(1);
        if (r102.startsWith("x") == false) goto L12;
    L15:
        r102 = r102.substring(1);
        int r103 = 16;
    L26:
        int r104 = CastIntegerProtector.parseInt(r102, r103);     // Catch: IllegalArgumentException -> L21
        if (r104 != 0) goto L19;
        return "�";
    L19:
        return new String(Character.toChars(r104));
    L21:
        return "�";
    L12:
        if (r102.startsWith("X") == true) goto L15;
        r103 = 10;
        goto L26
    L22:
        String r105 = (String) ((HashMap) f549135a).get(r101);
        if (r105 == null) goto L25;
        return r105;
    }
}
