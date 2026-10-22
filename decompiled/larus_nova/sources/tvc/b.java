package tvc;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes42.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f547714a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f547715b = null;

    public b() {
    }

    static {
        HashMap r100 = new HashMap();
        BufferedReader r101 = new BufferedReader(new InputStreamReader(b.class.getResourceAsStream("/org/commonmark/internal/util/entities.properties"), Charset.forName("UTF-8")));     // Catch: IOException -> L22
    L25:
        String r102 = r101.readLine();     // Catch: Throwable -> L14
        if (r102 == null) goto L11;
        if (r102.length() == 0) goto L25;
        int r103 = r102.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L14
        r100.put(r102.substring(0, r103), r102.substring(r103 + 1));     // Catch: Throwable -> L14
    L11:
        r101.close();     // Catch: IOException -> L22
        r100.put("NewLine", "\n");
        f547714a = r100;
        f547715b = PatternProtector.compile("^&#[Xx]?");
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: IOException -> L22
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L22
    L22:
        e = move-exception;
        throw new IllegalStateException("Failed reading data for HTML named character references", e);
    }

    public static String a(String r100) {
        Matcher r101 = f547715b.matcher(r100);
        if (r101.find() == true) goto L5;
        String r102 = r100.substring(1, r100.length() - 1);
        String r103 = f547714a.get(r102);
        if (r103 == null) goto L17;
        return r103;
    L17:
        return r100;
    L5:
        if (r101.end() != 2) goto L7;
        int r104 = 10;
    L18:
        int r105 = CastIntegerProtector.parseInt(r100.substring(r101.end(), r100.length() - 1), r104);     // Catch: IllegalArgumentException -> L13
        if (r105 != 0) goto L11;
        return "�";
    L11:
        return new String(Character.toChars(r105));
    L13:
        return "�";
    L7:
        r104 = 16;
        goto L18
    }
}
