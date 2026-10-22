package s17;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile c f540157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f540158h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PolarisFileWrapper f540159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PolarisFileWrapper f540160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PolarisFileWrapper f540161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PolarisFileWrapper f540162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PolarisFileWrapper f540163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f540164f;

    public final void a() {
        r17.c.b("deleteWorkSpace", new Object[0]);
        r17.d.a(this.f540163e);
        com.bytedance.memory.heap.a.b().g("");
        com.bytedance.memory.heap.a.b().i("");
        com.bytedance.memory.heap.a.b().f(0);
        r17.d.a(new PolarisFileWrapper(this.f540164f, "memorywidget"));     // Catch: Exception -> L5
        r17.d.a(new PolarisFileWrapper(this.f540164f, "memorywidgets"));     // Catch: Exception -> L5
        return;
    }

    public final void d() {
        r17.c.b("resetDir", new Object[0]);
        f540158h = UUID.randomUUID().toString();
        r17.c.b("UUID_STRING " + f540158h, new Object[0]);
        x17.a r100 = x17.a.f562123j;
        String r101 = f540158h;
        r100.getClass();
        x17.a.f562122i = r101;
        if (com.bytedance.apm.d.c() == null) goto L5;
        this.f540163e = new PolarisFileWrapper(this.f540164f + "/memorywidget2/" + f540158h);
    L7:
        if (this.f540163e.exists() == true) goto L9;
        this.f540163e.mkdirs();
    L9:
        PolarisFileWrapper r102 = new PolarisFileWrapper(this.f540163e, "cache");
        this.f540161c = r102;
        if (r102.exists() == true) goto L12;
        this.f540161c.mkdirs();
    L12:
        this.f540159a = new PolarisFileWrapper(this.f540163e, "festival.jpg");
        this.f540160b = new PolarisFileWrapper(this.f540163e, "festival.jpg.heap");
        PolarisFileWrapper r103 = new PolarisFileWrapper(this.f540163e, "shrink");
        this.f540162d = r103;
        if (r103.exists() == true) goto L16;
        this.f540162d.mkdirs();
        return;
    L16:
        return;
    L5:
        this.f540163e = new PolarisFileWrapper(this.f540164f + "/memorywidget2/" + f540158h);
        goto L7
    }

    public static c b() {
        if (f540157g != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f540157g != null) goto L9;
        f540157g = new c(q17.a.e().getContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f540157g;
    }

    public final boolean c() {
        return new PolarisFileWrapper(this.f540163e, "festival.jpg.heap").exists();
    }

    public c(Context r100) {
        String r101 = q17.a.e().f531306h;
        if (TextUtils.isEmpty(r101) == true) goto L5;
        this.f540164f = new PolarisFileWrapper(r101).getAbsolutePath();
    L6:
        PolarisFileWrapper r102 = new PolarisFileWrapper(this.f540164f + "/memorywidget2");
        if (r102.exists() == true) goto L9;
        r102.mkdirs();
    L9:
        File[] r103 = r102.listFiles();
        if (r103 != null) goto L12;
    L22:
        r17.d.a(r102);
        f540158h = UUID.randomUUID().toString();
    L23:
        r17.c.b("UUID_STRING " + f540158h, new Object[0]);
        this.f540163e = new PolarisFileWrapper(this.f540164f + "/memorywidget2/" + f540158h);
        this.f540161c = new PolarisFileWrapper(this.f540163e, "cache");
        this.f540159a = new PolarisFileWrapper(this.f540163e, "festival.jpg");
        this.f540160b = new PolarisFileWrapper(this.f540163e, "festival.jpg.heap");
        this.f540162d = new PolarisFileWrapper(this.f540163e, "shrink");
        r17.d.a(new PolarisFileWrapper(this.f540164f, "memorywidget"));     // Catch: Exception -> L26
        r17.d.a(new PolarisFileWrapper(this.f540164f, "memorywidgets"));     // Catch: Exception -> L26
        return;
    L33:
        return;
    L12:
        if (r103.length != 1) goto L22;
        int r104 = r103.length;
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L23;
        File r106 = r103[r105];
        if (r106.isDirectory() == false) goto L21;
        if (r106.getName().equals("null") == false) goto L20;
        r17.d.a(r106);
        f540158h = UUID.randomUUID().toString();
        goto L21
    L20:
        f540158h = r106.getName();
    L21:
        r105 = r105 + 1;
        goto L14
    L5:
        this.f540164f = r100.getExternalFilesDir(null).getParentFile().getAbsolutePath();
        goto L6
    }
}
