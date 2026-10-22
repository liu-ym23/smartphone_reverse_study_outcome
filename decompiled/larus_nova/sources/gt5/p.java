package gt5;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.utils.p0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f482566a = 0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ft5.a f482567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f482568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f482569c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f482570d;

        public a(ft5.a r100, boolean r101, String r102, String r103) {
            this.f482567a = r100;
            this.f482568b = r101;
            this.f482569c = r102;
            this.f482570d = r103;
        }

        public final void a() {
            OPMonitor r100 = new g("webview_container_report", e.f482518b, this.f482567a).addCategoryValue("is_first_page", Boolean.valueOf(this.f482568b)).addCategoryValue("scene", "performance_timing");
            String r101 = this.f482569c;
            String r102 = this.f482570d;
            int r103 = p.f482566a;
            Intrinsics.checkNotNull(r100);
            p.c(r100, r101);
            JSONObject r104 = new JSONObject(r102);     // Catch: Throwable -> L8
            Iterator<String> r105 = r104.keys();     // Catch: Throwable -> L8
        L5:
            if (r105.hasNext() == false) goto L10;
            String r106 = r105.next();     // Catch: Throwable -> L8
            r100.addCategoryValue(r106, r104.opt(r106));     // Catch: Throwable -> L8
        L10:
            r100.flush();
            return;
        L8:
            th = move-exception;
            Log.e("WebMonitorManager", th);
            goto L10
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static void b(OPMonitor r100, Uri r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        String r102 = p0.a(r101);
        String r103 = p0.c(r101);
        r100.addCategoryValue("host", r102);
        r100.addCategoryValue("current_url", r103);
    }

    public static void c(OPMonitor r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        b(r100, UriProtector.parse(r101));
    }

    public static void a(ft5.a r100, g r101, String r102) {
        if (r100 == null) goto L4;
        String r103 = r100.getBizType();
    L6:
        if (Intrinsics.areEqual(r103, d.f482513c.a()) == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r102) == true) goto L17;
        Uri r104 = UriProtector.parse(r102);     // Catch: Exception -> L11
        r101.addCategoryValue("host", r104.getHost());     // Catch: Exception -> L11
        List<String> r105 = p0.f444745a;     // Catch: Exception -> L11
        r101.addCategoryValue("path", p0.b(r104.getPath()));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        Log.e("WebMonitorManager", "add url exception " + e);
        return;
    L17:
        return;
    L4:
        r103 = null;
        goto L6
    }

    public static void d(boolean r100, String r101, String r102, ft5.a r103) {
        Intrinsics.checkNotNullParameter(r103, "dependency");
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return;
    L5:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new a(r103, r100, r101, r102));
    }
}
