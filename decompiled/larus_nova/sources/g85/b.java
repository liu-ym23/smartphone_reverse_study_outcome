package g85;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.bytedance.ee.drive.mime.DriveLocalMime;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes16.dex */
public final class b implements f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f480385g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f480386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f480387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayMap f480388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayMap f480389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Throwable f480390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.report.a f480391f;

    static {
        MimeTypeCategory r100 = MimeTypeCategory.NONE;
        SparseArray<String> r101 = g.f480400a;
        DriveLocalMime r102 = DriveLocalMime.NOT_SUPPORT;
        int r103 = r102.getValue();
        int r104 = r102.getValue();
        r102.getValue();
        r102.getValue();
        f480385g = new e(r100, "*/*", r103, r104, Collections.singletonList(-1));
    }

    public final void a() {
        if (this.f480387b == true) goto L6;
        tt5.a.h("MimeTypeManager", ThreadMethodProxy.currentThread().getName() + " waiting mime type loading from disk...");
    L6:
        if (this.f480387b == true) goto L12;
        this.f480386a.wait();     // Catch: InterruptedException -> L9
    L9:
        e = move-exception;
        tt5.a.f("MimeTypeManager", e, false);
        goto L6
    L12:
        if (this.f480390e == null) goto L25;
        tt5.a.e("MimeTypeManager", ThreadMethodProxy.currentThread().getName() + " load from disk throw error", this.f480390e, false);
        com.bytedance.ee.bear.drive.report.a r100 = this.f480391f;
        Throwable r101 = this.f480390e;
        r100.getClass();
        HashMap r102 = new HashMap();
        String r103 = r101.getMessage();
        if (r103 != null) goto L16;
        r103 = "unknown";
    L16:
        r102.put("drive_load_mime_types_properties", r103);
        r100.f224576a.v("load_mimetype_properties", r102);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.List] */
    public static e q(String[] r110) {
        ?? r100 = new ArrayList(3);
    L15:
        e = move-exception;
        tt5.a.f("MimeTypeManager", e, false);
        SparseArray<String> r101 = g.f480400a;
        r100 = Collections.singletonList(-1);
    L17:
        ?? r111 = r100;
        MimeTypeCategory r102 = MimeTypeCategory.valueOf(r110[0].trim());     // Catch: Exception -> L20
        String r103 = r110[1].trim();     // Catch: Exception -> L20
        int r104 = CastIntegerProtector.parseInt(r110[2].trim());     // Catch: Exception -> L20
        int r112 = CastIntegerProtector.parseInt(r110[3].trim());     // Catch: Exception -> L20
        CastIntegerProtector.parseInt(r110[4].trim());     // Catch: Exception -> L20
        CastIntegerProtector.parseInt(r110[5].trim());     // Catch: Exception -> L20
        return new e(r102, r103, r104, r112, r111);
    L20:
        e = move-exception;
        tt5.a.f("MimeTypeManager", e, false);
        return null;
    L4:
        if (TextUtils.isEmpty(r110[6]) == false) goto L6;
    L13:
        SparseArray<String> r105 = g.f480400a;     // Catch: Exception -> L15
        r100 = Collections.singletonList(-1);     // Catch: Exception -> L15
        goto L17
    L6:
        if (TextUtils.isEmpty(r110[6].trim()) == true) goto L13;
        String[] r106 = TextUtils.split(r110[6], ">");     // Catch: Exception -> L15
        if (r106 == null) goto L17;
        int r107 = r106.length;     // Catch: Exception -> L15
        int r108 = 0;
    L11:
        if (r108 >= r107) goto L17;
        r100.add(Integer.valueOf(CastIntegerProtector.parseInt(r106[r108].trim())));     // Catch: Exception -> L15
        r108 = r108 + 1;     // Catch: Exception -> L15
        goto L11
    }

    public final e c(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        Object r101 = this.f480386a;
        monitor-enter(r101);
        a();     // Catch: Throwable -> L19
        List r102 = (List) this.f480388c.get(r100.toLowerCase());     // Catch: Throwable -> L19
        if (r102 != null) goto L11;
    L16:
        e r103 = f480385g;     // Catch: Throwable -> L19
        monitor-exit(r101);     // Catch: Throwable -> L19
        return r103;
    L11:
        if (r102.isEmpty() == true) goto L16;
        e r104 = (e) r102.get(0);     // Catch: Throwable -> L19
        monitor-exit(r101);     // Catch: Throwable -> L19
        return r104;
    L19:
        th = move-exception;
        throw th;
    L5:
        return f480385g;
    }

    public final boolean d(String r100) {
        if (b(r100, null).f480395a.compareTo(MimeTypeCategory.COMPRESS) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean e(String r100) {
        if (b(r100, null).f480395a.compareTo(MimeTypeCategory.AUDIO) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean f(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return "csv".equalsIgnoreCase(r100);
    }

    public final boolean g(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if ("xls".equalsIgnoreCase(r100) == false) goto L8;
    L11:
        return true;
    L8:
        if ("xlsx".equalsIgnoreCase(r100) == true) goto L11;
        if ("xlsm".equalsIgnoreCase(r100) == true) goto L11;
        return false;
    }

    public final boolean h(String r100) {
        e r101 = b(r100, null);
        if (r101.f480395a.compareTo(MimeTypeCategory.IMAGE) != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        return false;
    L8:
        if (r101.f480396b.contains("gif") == false) goto L12;
        return true;
    L12:
        return false;
    L5:
        r102 = false;
        goto L6
    }

    public final boolean k(String r100) {
        if ("key".equalsIgnoreCase(r100) == false) goto L5;
    L16:
        boolean r101 = true;
    L17:
        if (r101 == false) goto L19;
    L20:
        return true;
    L19:
        if (l(r100) == false) goto L20;
        return false;
    L5:
        if ("pages".equalsIgnoreCase(r100) == true) goto L16;
        if ("numbers".equalsIgnoreCase(r100) == true) goto L16;
        if ("keynote".equalsIgnoreCase(r100) == true) goto L16;
        if ("heic".equalsIgnoreCase(r100) == true) goto L16;
        if ("heif".equalsIgnoreCase(r100) == true) goto L16;
        r101 = false;
        goto L17
    }

    public final boolean l(String r100) {
        int r101 = c(r100).f480397c;
        SparseArray<String> r102 = g.f480400a;
        if (r101 == DriveLocalMime.NOT_SUPPORT.getValue()) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L23;
        if (h.g(r100) == false) goto L11;
        r103 = n.k(o75.b.a().getDriveConfig());
        goto L23
    L11:
        if (h.h(r100) == false) goto L13;
    L21:
        r103 = n.h(o75.b.a().getDriveConfig());
        goto L23
    L13:
        if (h.f(r100) == true) goto L21;
        if (h.j(r100) == false) goto L19;
        r103 = n.i(o75.b.a().getDriveConfig());
        goto L23
    L19:
        if (d(r100) == false) goto L23;
        r103 = h.b(r100);
    L23:
        if ("ogg".equalsIgnoreCase(r100) == false) goto L25;
        return false;
    L25:
        return r103;
    L5:
        r103 = false;
        goto L6
    }

    public final boolean m(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return TextUtils.equals(ExportFileExtension.PDF, r100.toLowerCase());
    }

    public final boolean n(String r100) {
        if (b(r100, null).f480395a.compareTo(MimeTypeCategory.TEXT) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p(Context r110) {
        InputStream r100 = null;
        this.f480388c = new ArrayMap();     // Catch: Throwable -> L19
        this.f480389d = new ArrayMap();     // Catch: Throwable -> L19
        r100 = r110.getResources().openRawResource(R.raw.drive_preview_mime_types);     // Catch: Throwable -> L19
        Properties r111 = new Properties();     // Catch: Throwable -> L19
        r111.load(r100);     // Catch: Throwable -> L19
        Enumeration r101 = r111.keys();     // Catch: Throwable -> L19
    L4:
        if (r101.hasMoreElements() == false) goto L24;
        String r102 = ((String) r101.nextElement()).trim();     // Catch: Throwable -> L19 Exception -> L21
        String r103 = r111.getProperty(r102);     // Catch: Throwable -> L19 Exception -> L21
        Pattern r104 = yu5.c.f569228a;     // Catch: Throwable -> L19 Exception -> L21
        String[] r105 = r103.split(",");     // Catch: Throwable -> L19 Exception -> L21
        int r106 = r105.length;     // Catch: Throwable -> L19 Exception -> L21
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L4;
        String r108 = r105[r107];     // Catch: Throwable -> L19 Exception -> L21
        Pattern r112 = yu5.c.f569228a;     // Catch: Throwable -> L19 Exception -> L21
        e r109 = q(r108.split("\\|"));     // Catch: Throwable -> L19 Exception -> L21
        if (r109 != null) goto L12;
    L18:
        r107 = r107 + 1;
        goto L7
    L12:
        if (this.f480388c.get(r102) != 0) goto L14;
        ArrayList r113 = new ArrayList();     // Catch: Throwable -> L19 Exception -> L21
        r113.add(r109);     // Catch: Throwable -> L19 Exception -> L21
        this.f480388c.put(r102, r113);     // Catch: Throwable -> L19 Exception -> L21
    L15:
        String r114 = r102 + r109.f480396b.trim();     // Catch: Throwable -> L19 Exception -> L21
        if (this.f480389d.get(r114) != 0) goto L18;
        this.f480389d.put(r114, r109);     // Catch: Throwable -> L19 Exception -> L21
        goto L18
    L14:
        ((ArrayList) this.f480388c.get(r102)).add(r109);     // Catch: Throwable -> L19 Exception -> L21
    L21:
        e = move-exception;
        tt5.a.e("MimeTypeManager", "Fail to parse mime type", e, false);     // Catch: Throwable -> L19
        this.f480390e = e;     // Catch: Throwable -> L19
        goto L4
    L24:
        if (r100 == null) goto L58;
    L48:
        r100.close();     // Catch: IOException -> L30
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
        this.f480390e = th;     // Catch: Throwable -> L33
        if (r100 != null) goto L48;
        return;
    L33:
        th = move-exception;
        if (r100 != null) goto L40;
    L39:
        throw th;
    L40:
        r100.close();     // Catch: IOException -> L37
    L37:
        e = move-exception;
        tt5.a.e("MimeTypeManager", "Close Fail to load mime types raw file.", e, false);
        goto L39
    }

    public b(final Context r100, com.bytedance.ee.bear.drive.report.a r101) {
        Object r102 = new Object();
        this.f480386a = r102;
        this.f480387b = false;
        this.f480391f = r101;
        monitor-enter(r102);
        this.f480387b = false;     // Catch: Throwable -> L8
        monitor-exit(r102);     // Catch: Throwable -> L8
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new a(this, r100));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e b(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        String r102 = yu5.c.m(r100).toLowerCase();
        Object r103 = this.f480386a;
        monitor-enter(r103);
        a();     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r101) == false) goto L13;
        e r104 = c(r102);     // Catch: Throwable -> L21
        monitor-exit(r103);     // Catch: Throwable -> L21
        return r104;
    L13:
        String r105 = r102.concat(r101.trim());     // Catch: Throwable -> L21
        if (this.f480389d.containsKey(r105) == false) goto L18;
        e r106 = (e) this.f480389d.get(r105);     // Catch: Throwable -> L21
        monitor-exit(r103);     // Catch: Throwable -> L21
        return r106;
    L18:
        e r107 = c(r102);     // Catch: Throwable -> L21
        monitor-exit(r103);     // Catch: Throwable -> L21
        return r107;
    L21:
        th = move-exception;
        throw th;
    L5:
        return f480385g;
    }

    public final boolean i(String r100, String r101) {
        return TextUtils.equals(b(r100, r101).f480396b, "text/html");
    }

    public final boolean j(String r100, String r101) {
        if (b(r100, r101).f480395a.compareTo(MimeTypeCategory.IMAGE) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean o(String r100, String r101) {
        if (b(r100, r101).f480395a.compareTo(MimeTypeCategory.VIDEO) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
