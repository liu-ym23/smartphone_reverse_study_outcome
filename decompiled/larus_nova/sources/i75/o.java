package i75;

import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.ss.android.lark.passportc.entity.UserSession;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes16.dex */
public final class o {

    public interface a {
        void a(String r100);
    }

    public static String b(DriveFilePath r100, UserSession r101) {
        StringBuilder r102 = new StringBuilder();
        BufferedReader r103 = null;
        InputStream r104 = z75.b.e(r100, r101).newInputStream();     // Catch: Throwable -> L23 Exception -> L25
        BufferedReader r105 = new BufferedReader(new InputStreamReader(r104));     // Catch: Throwable -> L19 Exception -> L21
        String r106 = r105.readLine();     // Catch: Throwable -> L15 Exception -> L17
    L6:
        if (r106 == null) goto L9;
        r102.append(r106);     // Catch: Throwable -> L15 Exception -> L17
        r102.append("\n");     // Catch: Throwable -> L15 Exception -> L17
        r106 = r105.readLine();     // Catch: Throwable -> L15 Exception -> L17
        goto L6
    L9:
        r105.close();     // Catch: Exception -> L13
        if (r104 == null) goto L33;
        r104.close();     // Catch: Exception -> L13
    L33:
        return r102.toString();
    L17:
        Exception e100 = e;
    L27:
        tt5.a.f("ReadFileLineHelper", e100, false);     // Catch: Throwable -> L15
        if (r105 == null) goto L30;
        r105.close();     // Catch: Exception -> L13
    L30:
        if (r104 == null) goto L33;
        r104.close();     // Catch: Exception -> L13
    L15:
        th = th;
        r103 = r105;
    L35:
        if (r103 != null) goto L46;
    L39:
        if (r104 == null) goto L43;
        r104.close();     // Catch: Exception -> L37
    L37:
        e = move-exception;
        tt5.a.f("ReadFileLineHelper", e, false);
    L43:
        throw th;
    L46:
        r103.close();     // Catch: Exception -> L37
        goto L39
    L21:
        e = move-exception;
        e100 = e;
        r105 = null;
    L19:
        th = th;
        goto L35
    L13:
        e = move-exception;
        tt5.a.f("ReadFileLineHelper", e, false);
    L25:
        e = move-exception;
        r105 = null;
        e100 = e;
        r104 = null;
    L23:
        th = th;
        r104 = null;
        goto L35
    }

    public static void a(DriveFilePath r100, a r101, int r102, int r110, boolean r111, UserSession r112) {
        if (r102 <= 0) goto L6;
        if (r110 <= 0) goto L6;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        tt5.a.d("ReadFileLineHelper", "blockReadFileLineCallback is null or blockStringMinLength or blockStringMaxLength <= 0");
        return;
    L11:
        StringBuilder r104 = new StringBuilder();
        BufferedReader r105 = null;
        InputStream r106 = z75.b.e(r100, r112).newInputStream();     // Catch: Throwable -> L39 Exception -> L41
        BufferedReader r113 = new BufferedReader(new InputStreamReader(r106));     // Catch: Throwable -> L35 Exception -> L37
        int r107 = r113.read();     // Catch: Throwable -> L31 Exception -> L33
        int r108 = 0;
    L16:
        if (r107 == (-1)) goto L26;
        r104.append((char) r107);     // Catch: Throwable -> L31 Exception -> L33
        r108 = r108 + 1;     // Catch: Throwable -> L31 Exception -> L33
        if (r108 <= r102) goto L20;
        if (r107 != 10) goto L20;
    L21:
        if (r107 != 10) goto L24;
        if (r111 == false) goto L24;
        r104.deleteCharAt(r104.length() - 1);     // Catch: Throwable -> L31 Exception -> L33
    L24:
        r101.a(r104.toString().trim());     // Catch: Throwable -> L31 Exception -> L33
        r104.delete(0, r104.length());     // Catch: Throwable -> L31 Exception -> L33
        r108 = 0;
    L25:
        r107 = r113.read();     // Catch: Throwable -> L31 Exception -> L33
    L20:
        if (r108 <= r110) goto L25;
    L26:
        r101.a(r104.toString());     // Catch: Throwable -> L31 Exception -> L33
        r113.close();     // Catch: Exception -> L47
        if (r106 == null) goto L75;
    L29:
        r106.close();     // Catch: Exception -> L47
        return;
    L75:
        return;
    L33:
        Exception e100 = e;
        r105 = r113;
    L43:
        tt5.a.f("ReadFileLineHelper", e100, false);     // Catch: Throwable -> L35
        if (r105 == null) goto L49;
        r105.close();     // Catch: Exception -> L47
    L49:
        if (r106 != null) goto L29;
        return;
    L31:
        Throwable th10 = th;
        r105 = r113;
    L53:
        if (r105 != null) goto L64;
    L57:
        if (r106 == null) goto L61;
        r106.close();     // Catch: Exception -> L55
    L55:
        e = move-exception;
        tt5.a.f("ReadFileLineHelper", e, false);
    L61:
        throw th10;
    L64:
        r105.close();     // Catch: Exception -> L55
    L37:
        e100 = e;
    L35:
        th10 = th;
        goto L53
    L47:
        e = move-exception;
        tt5.a.f("ReadFileLineHelper", e, false);
        return;
    L41:
        e = move-exception;
        e100 = e;
        r106 = null;
    L39:
        th = move-exception;
        th10 = th;
        r106 = null;
    L6:
        r103 = false;
        goto L8
    }
}
