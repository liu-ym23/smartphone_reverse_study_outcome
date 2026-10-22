package i75;

import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.document.DocViewModel;
import com.ss.android.lark.passportc.entity.UserSession;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o {

    public interface a {
        void a(String r1);
    }

    public static String b(DriveFilePath r6, UserSession r7) {
        StringBuilder r1 = new StringBuilder();
        BufferedReader r3 = null;
        InputStream r8 = z75.b.e(r6, r7).newInputStream();     // Catch: Throwable -> L23 Exception -> L25
        BufferedReader r9 = new BufferedReader(new InputStreamReader(r8));     // Catch: Throwable -> L19 Exception -> L21
        String r4 = r9.readLine();     // Catch: Throwable -> L15 Exception -> L17
    L6:
        if (r4 == null) goto L9;
        r1.append(r4);     // Catch: Throwable -> L15 Exception -> L17
        r1.append(DocViewModel.ENTER_CHAR);     // Catch: Throwable -> L15 Exception -> L17
        r4 = r9.readLine();     // Catch: Throwable -> L15 Exception -> L17
        goto L6
    L9:
        r9.close();     // Catch: Exception -> L13
        if (r8 == null) goto L33;
        r8.close();     // Catch: Exception -> L13
    L33:
        return r1.toString();
    L17:
        Exception e = e;
    L27:
        tt5.a.f("ReadFileLineHelper", e, false);     // Catch: Throwable -> L15
        if (r9 == null) goto L30;
        r9.close();     // Catch: Exception -> L13
    L30:
        if (r8 == null) goto L33;
        r8.close();     // Catch: Exception -> L13
    L15:
        th = th;
        r3 = r9;
    L35:
        if (r3 != null) goto L46;
    L39:
        if (r8 == null) goto L43;
        r8.close();     // Catch: Exception -> L37
    L37:
        e = move-exception;
        tt5.a.f("ReadFileLineHelper", e, false);
    L43:
        throw th;
    L46:
        r3.close();     // Catch: Exception -> L37
        goto L39
    L21:
        e = move-exception;
        e = e;
        r9 = null;
    L19:
        th = th;
        goto L35
    L13:
        e = move-exception;
        tt5.a.f("ReadFileLineHelper", e, false);
    L25:
        e = move-exception;
        r9 = null;
        e = e;
        r8 = null;
    L23:
        th = th;
        r8 = null;
        goto L35
    }

    public static void a(DriveFilePath r7, a r8, int r9, int r10, boolean r11, UserSession r12) {
        if (r9 <= 0) goto L6;
        if (r10 <= 0) goto L6;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        tt5.a.d("ReadFileLineHelper", "blockReadFileLineCallback is null or blockStringMinLength or blockStringMaxLength <= 0");
        return;
    L11:
        StringBuilder r3 = new StringBuilder();
        BufferedReader r4 = null;
        InputStream r13 = z75.b.e(r7, r12).newInputStream();     // Catch: Throwable -> L39 Exception -> L41
        BufferedReader r14 = new BufferedReader(new InputStreamReader(r13));     // Catch: Throwable -> L35 Exception -> L37
        int r5 = r14.read();     // Catch: Throwable -> L31 Exception -> L33
        int r6 = 0;
    L16:
        if (r5 == (-1)) goto L26;
        r3.append((char) r5);     // Catch: Throwable -> L31 Exception -> L33
        r6 = r6 + 1;     // Catch: Throwable -> L31 Exception -> L33
        if (r6 <= r9) goto L20;
        if (r5 != 10) goto L20;
    L21:
        if (r5 != 10) goto L24;
        if (r11 == false) goto L24;
        r3.deleteCharAt(r3.length() - 1);     // Catch: Throwable -> L31 Exception -> L33
    L24:
        r8.a(r3.toString().trim());     // Catch: Throwable -> L31 Exception -> L33
        r3.delete(0, r3.length());     // Catch: Throwable -> L31 Exception -> L33
        r6 = 0;
    L25:
        r5 = r14.read();     // Catch: Throwable -> L31 Exception -> L33
    L20:
        if (r6 <= r10) goto L25;
    L26:
        r8.a(r3.toString());     // Catch: Throwable -> L31 Exception -> L33
        r14.close();     // Catch: Exception -> L47
        if (r13 == null) goto L75;
    L29:
        r13.close();     // Catch: Exception -> L47
        return;
    L75:
        return;
    L33:
        Exception e = e;
        r4 = r14;
    L43:
        tt5.a.f("ReadFileLineHelper", e, false);     // Catch: Throwable -> L35
        if (r4 == null) goto L49;
        r4.close();     // Catch: Exception -> L47
    L49:
        if (r13 != null) goto L29;
        return;
    L31:
        Throwable th = th;
        r4 = r14;
    L53:
        if (r4 != null) goto L64;
    L57:
        if (r13 == null) goto L61;
        r13.close();     // Catch: Exception -> L55
    L55:
        e = move-exception;
        tt5.a.f("ReadFileLineHelper", e, false);
    L61:
        throw th;
    L64:
        r4.close();     // Catch: Exception -> L55
    L37:
        e = e;
    L35:
        th = th;
        goto L53
    L47:
        e = move-exception;
        tt5.a.f("ReadFileLineHelper", e, false);
        return;
    L41:
        e = move-exception;
        e = e;
        r13 = null;
    L39:
        th = move-exception;
        th = th;
        r13 = null;
    L6:
        r2 = false;
        goto L8
    }
}
