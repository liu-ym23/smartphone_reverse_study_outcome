package g85;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;
import com.bytedance.ee.drive.mime.DriveLocalMime;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import i75.h;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;
import w55.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements f {
    public static final e g = null;
    public final Object a;
    public volatile boolean b;
    public ArrayMap c;
    public ArrayMap d;
    public Throwable e;
    public final com.bytedance.ee.bear.drive.report.a f;

    static {
        MimeTypeCategory r1 = MimeTypeCategory.NONE;
        SparseArray<String> r0 = g.a;
        DriveLocalMime r2 = DriveLocalMime.NOT_SUPPORT;
        int r3 = r2.getValue();
        int r4 = r2.getValue();
        r2.getValue();
        r2.getValue();
        g = new e(r1, "*/*", r3, r4, Collections.singletonList(-1));
    }

    public final void a() {
        if (this.b == true) goto L6;
        tt5.a.h("MimeTypeManager", ThreadMethodProxy.currentThread().getName() + " waiting mime type loading from disk...");
    L6:
        if (this.b == true) goto L12;
        this.a.wait();     // Catch: InterruptedException -> L9
    L9:
        e = move-exception;
        tt5.a.f("MimeTypeManager", e, false);
        goto L6
    L12:
        if (this.e == null) goto L25;
        tt5.a.e("MimeTypeManager", ThreadMethodProxy.currentThread().getName() + " load from disk throw error", this.e, false);
        com.bytedance.ee.bear.drive.report.a r0 = this.f;
        Throwable r1 = this.e;
        r0.getClass();
        HashMap r2 = new HashMap();
        String r3 = r1.getMessage();
        if (r3 != null) goto L16;
        r3 = "unknown";
    L16:
        r2.put("drive_load_mime_types_properties", r3);
        r0.a.v("load_mimetype_properties", r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.List] */
    public static e q(String[] r12) {
        ?? r1 = new ArrayList(3);
    L15:
        e = move-exception;
        tt5.a.f("MimeTypeManager", e, false);
        SparseArray<String> r2 = g.a;
        r1 = Collections.singletonList(-1);
    L17:
        ?? r11 = r1;
        MimeTypeCategory r7 = MimeTypeCategory.valueOf(r12[0].trim());     // Catch: Exception -> L20
        String r8 = r12[1].trim();     // Catch: Exception -> L20
        int r9 = CastIntegerProtector.parseInt(r12[2].trim());     // Catch: Exception -> L20
        int r10 = CastIntegerProtector.parseInt(r12[3].trim());     // Catch: Exception -> L20
        CastIntegerProtector.parseInt(r12[4].trim());     // Catch: Exception -> L20
        CastIntegerProtector.parseInt(r12[5].trim());     // Catch: Exception -> L20
        return new e(r7, r8, r9, r10, r11);
    L20:
        e = move-exception;
        tt5.a.f("MimeTypeManager", e, false);
        return null;
    L4:
        if (TextUtils.isEmpty(r12[6]) == false) goto L6;
    L13:
        SparseArray<String> r3 = g.a;     // Catch: Exception -> L15
        r1 = Collections.singletonList(-1);     // Catch: Exception -> L15
        goto L17
    L6:
        if (TextUtils.isEmpty(r12[6].trim()) == true) goto L13;
        String[] r4 = TextUtils.split(r12[6], ">");     // Catch: Exception -> L15
        if (r4 == null) goto L17;
        int r6 = r4.length;     // Catch: Exception -> L15
        int r13 = 0;
    L11:
        if (r13 >= r6) goto L17;
        r1.add(Integer.valueOf(CastIntegerProtector.parseInt(r4[r13].trim())));     // Catch: Exception -> L15
        r13 = r13 + 1;     // Catch: Exception -> L15
        goto L11
    }

    public final e c(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L5;
        Object r0 = this.a;
        monitor-enter(r0);
        a();     // Catch: Throwable -> L19
        List r4 = (List) this.c.get(r3.toLowerCase());     // Catch: Throwable -> L19
        if (r4 != null) goto L11;
    L16:
        e r5 = g;     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r5;
    L11:
        if (r4.isEmpty() == true) goto L16;
        e r6 = (e) r4.get(0);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r6;
    L19:
        th = move-exception;
        throw th;
    L5:
        return g;
    }

    public final boolean d(String r2) {
        if (b(r2, null).a.compareTo(MimeTypeCategory.COMPRESS) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean e(String r2) {
        if (b(r2, null).a.compareTo(MimeTypeCategory.AUDIO) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean f(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        return "csv".equalsIgnoreCase(r2);
    }

    public final boolean g(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        if ("xls".equalsIgnoreCase(r3) == false) goto L8;
    L11:
        return true;
    L8:
        if ("xlsx".equalsIgnoreCase(r3) == true) goto L11;
        if ("xlsm".equalsIgnoreCase(r3) == true) goto L11;
        return false;
    }

    public final boolean h(String r4) {
        e r5 = b(r4, null);
        if (r5.a.compareTo(MimeTypeCategory.IMAGE) != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return false;
    L8:
        if (r5.b.contains("gif") == false) goto L12;
        return true;
    L12:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean k(String r4) {
        if ("key".equalsIgnoreCase(r4) == false) goto L5;
    L16:
        boolean r0 = true;
    L17:
        if (r0 == false) goto L19;
    L20:
        return true;
    L19:
        if (l(r4) == false) goto L20;
        return false;
    L5:
        if ("pages".equalsIgnoreCase(r4) == true) goto L16;
        if ("numbers".equalsIgnoreCase(r4) == true) goto L16;
        if ("keynote".equalsIgnoreCase(r4) == true) goto L16;
        if ("heic".equalsIgnoreCase(r4) == true) goto L16;
        if ("heif".equalsIgnoreCase(r4) == true) goto L16;
        r0 = false;
        goto L17
    }

    public final boolean l(String r4) {
        int r0 = c(r4).c;
        SparseArray<String> r1 = g.a;
        if (r0 == DriveLocalMime.NOT_SUPPORT.getValue()) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L23;
        if (h.g(r4) == false) goto L11;
        r2 = n.k(o75.b.a().getDriveConfig());
        goto L23
    L11:
        if (h.h(r4) == false) goto L13;
    L21:
        r2 = n.h(o75.b.a().getDriveConfig());
        goto L23
    L13:
        if (h.f(r4) == true) goto L21;
        if (h.j(r4) == false) goto L19;
        r2 = n.i(o75.b.a().getDriveConfig());
        goto L23
    L19:
        if (d(r4) == false) goto L23;
        r2 = h.b(r4);
    L23:
        if ("ogg".equalsIgnoreCase(r4) == false) goto L25;
        return false;
    L25:
        return r2;
    L5:
        r2 = false;
        goto L6
    }

    public final boolean m(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        return TextUtils.equals("pdf", r2.toLowerCase());
    }

    public final boolean n(String r2) {
        if (b(r2, null).a.compareTo(MimeTypeCategory.TEXT) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void p(Context r13) {
        InputStream r3 = null;
        this.c = new ArrayMap();     // Catch: Throwable -> L19
        this.d = new ArrayMap();     // Catch: Throwable -> L19
        r3 = r13.getResources().openRawResource(2131820564);     // Catch: Throwable -> L19
        Properties r14 = new Properties();     // Catch: Throwable -> L19
        r14.load(r3);     // Catch: Throwable -> L19
        Enumeration r4 = r14.keys();     // Catch: Throwable -> L19
    L4:
        if (r4.hasMoreElements() == false) goto L24;
        String r5 = ((String) r4.nextElement()).trim();     // Catch: Throwable -> L19 Exception -> L21
        String r6 = r14.getProperty(r5);     // Catch: Throwable -> L19 Exception -> L21
        Pattern r7 = yu5.c.a;     // Catch: Throwable -> L19 Exception -> L21
        String[] r8 = r6.split(",");     // Catch: Throwable -> L19 Exception -> L21
        int r9 = r8.length;     // Catch: Throwable -> L19 Exception -> L21
        int r10 = 0;
    L7:
        if (r10 >= r9) goto L4;
        String r11 = r8[r10];     // Catch: Throwable -> L19 Exception -> L21
        Pattern r12 = yu5.c.a;     // Catch: Throwable -> L19 Exception -> L21
        e r16 = q(r11.split("\\|"));     // Catch: Throwable -> L19 Exception -> L21
        if (r16 != null) goto L12;
    L18:
        r10 = r10 + 1;
        goto L7
    L12:
        if (this.c.get(r5) != null) goto L14;
        ArrayList r17 = new ArrayList();     // Catch: Throwable -> L19 Exception -> L21
        r17.add(r16);     // Catch: Throwable -> L19 Exception -> L21
        this.c.put(r5, r17);     // Catch: Throwable -> L19 Exception -> L21
    L15:
        String r18 = r5 + r16.b.trim();     // Catch: Throwable -> L19 Exception -> L21
        if (this.d.get(r18) != null) goto L18;
        this.d.put(r18, r16);     // Catch: Throwable -> L19 Exception -> L21
        goto L18
    L14:
        ((ArrayList) this.c.get(r5)).add(r16);     // Catch: Throwable -> L19 Exception -> L21
    L21:
        e = move-exception;
        tt5.a.e("MimeTypeManager", "Fail to parse mime type", e, false);     // Catch: Throwable -> L19
        this.e = e;     // Catch: Throwable -> L19
        goto L4
    L24:
        if (r3 == null) goto L58;
    L48:
        r3.close();     // Catch: IOException -> L30
        return;
    L30:
        e = move-exception;
        tt5.a.e("MimeTypeManager", "Close Fail to load mime types raw file.", e, false);
        return;
    L58:
        return;
    L19:
        th = move-exception;
        tt5.a.e("MimeTypeManager", "Fail to load mime types raw file.", th, false);     // Catch: Throwable -> L33
        this.e = th;     // Catch: Throwable -> L33
        if (r3 != null) goto L48;
        return;
    L33:
        th = move-exception;
        if (r3 != null) goto L40;
    L39:
        throw th;
    L40:
        r3.close();     // Catch: IOException -> L37
    L37:
        e = move-exception;
        tt5.a.e("MimeTypeManager", "Close Fail to load mime types raw file.", e, false);
        goto L39
    }

    public b(final Context r3, com.bytedance.ee.bear.drive.report.a r4) {
        Object r0 = new Object();
        this.a = r0;
        this.b = false;
        this.f = r4;
        monitor-enter(r0);
        this.b = false;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new a(this, r3));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final e b(String r3, String r4) {
        if (TextUtils.isEmpty(r3) == true) goto L5;
        String r5 = yu5.c.m(r3).toLowerCase();
        Object r0 = this.a;
        monitor-enter(r0);
        a();     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r4) == false) goto L13;
        e r6 = c(r5);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return r6;
    L13:
        String r7 = r5.concat(r4.trim());     // Catch: Throwable -> L21
        if (this.d.containsKey(r7) == false) goto L18;
        e r8 = (e) this.d.get(r7);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return r8;
    L18:
        e r9 = c(r5);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return r9;
    L21:
        th = move-exception;
        throw th;
    L5:
        return g;
    }

    public final boolean i(String r1, String r2) {
        return TextUtils.equals(b(r1, r2).b, "text/html");
    }

    public final boolean j(String r1, String r2) {
        if (b(r1, r2).a.compareTo(MimeTypeCategory.IMAGE) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean o(String r1, String r2) {
        if (b(r1, r2).a.compareTo(MimeTypeCategory.VIDEO) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
