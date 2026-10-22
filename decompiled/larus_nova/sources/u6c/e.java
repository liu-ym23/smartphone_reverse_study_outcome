package u6c;

import com.larksuite.framework.utils.FileUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.thirdshare.base.export.util.k;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.ViewUtils;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VFSPath f549007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ File f549008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u6c.c.b f549009c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VFSFile f549010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f549011b;

        @Override // java.lang.Runnable
        public final void run() {
            u6c.c.b r100 = this.f549011b.f549009c;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            k r101 = (k) r100;     // Catch: Throwable -> L6
            r101.a(this.f549010a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(e r100, VFSFile r101) {
            this.f549011b = r100;
            this.f549010a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f549012a;

        @Override // java.lang.Runnable
        public final void run() {
            u6c.c.b r100 = this.f549012a.f549009c;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            ((k) r100).b("copy image failed.");     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(e r100) {
            this.f549012a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FileNotFoundException f549013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f549014b;

        @Override // java.lang.Runnable
        public final void run() {
            u6c.c.b r100 = this.f549014b.f549009c;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            k r101 = (k) r100;     // Catch: Throwable -> L6
            r101.b(this.f549013a.getMessage());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public c(e r100, FileNotFoundException r101) {
            this.f549014b = r100;
            this.f549013a = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IOException f549015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f549016b;

        @Override // java.lang.Runnable
        public final void run() {
            u6c.c.b r100 = this.f549016b.f549009c;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            k r101 = (k) r100;     // Catch: Throwable -> L6
            r101.b(this.f549015a.getMessage());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public d(e r100, IOException r101) {
            this.f549016b = r100;
            this.f549015a = r101;
        }
    }

    public final void a() {
        VFSFile r100 = this.f549007a.subPath(System.currentTimeMillis() + ".jpg").toFile();
    L10:
        e = move-exception;
        ViewUtils.runOnUiThread(new c(this, e));
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        ViewUtils.runOnUiThread(new d(this, e));
        return;
    L4:
        if (u6c.c.a(r100, com.ss.android.lark.core.storage.a.c().j(this.f549008b)) == false) goto L6;
        ViewUtils.runOnUiThread(new a(this, r100));     // Catch: IOException -> L8 FileNotFoundException -> L10
        FileUtils.v(LarkContext.getApplication(), r100.getAbsolutePath(), u6c.c.f548996c);     // Catch: IOException -> L8 FileNotFoundException -> L10
    L13:
        return;
    L6:
        ViewUtils.runOnUiThread(new b(this));     // Catch: IOException -> L8 FileNotFoundException -> L10
        goto L13
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

    public e(VFSPath r100, File r101, u6c.c.b r102) {
        this.f549007a = r100;
        this.f549008b = r101;
        this.f549009c = r102;
    }
}
