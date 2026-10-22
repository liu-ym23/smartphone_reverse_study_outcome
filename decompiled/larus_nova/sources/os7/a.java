package os7;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.dtf.face.config.OSSConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f526516l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<b> f526517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<b> f526518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<b> f526519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<b> f526520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicInteger f526521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f526522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f526523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f526524h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f526525i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f526526j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C7107a f526527k;

    /* JADX INFO: renamed from: os7.a$a, reason: collision with other inner class name */
    public class C7107a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f526528a;

        public C7107a(a r100) {
            this.f526528a = r100;
        }

        public final void a(int r100, int r101, int r102, d r103) {
            if (r100 != 0) goto L5;
            a r104 = this.f526528a;
            r104.c(1, r104.f526527k, r103);
            return;
        L5:
            String r105 = "";
            if (r100 == 1) goto L8;
            this.f526528a.a(r103, "");
            return;
        L8:
            if (r101 != r102) goto L10;
            a r106 = this.f526528a;
            r106.c(2, r106.f526527k, r103);
            return;
        L10:
            a r107 = this.f526528a;
            if (r107.f526526j == false) goto L13;
            r107.c(2, r107.f526527k, r103);
            return;
        L13:
            boolean r108 = false;
            if (r107.f526520d.size() > 0) goto L16;
        L18:
            String r109 = "";
        L20:
            if (TextUtils.isEmpty(r105) == false) goto L22;
        L35:
            if (r108 == false) goto L37;
            a r110 = this.f526528a;
            r110.c(1, r110.f526527k, r103);
            return;
        L37:
            r103.c(new String[]{"errMsg", "backup config is null"});
            a r111 = this.f526528a;
            r111.c(2, r111.f526527k, r103);
            return;
        L22:
            if (TextUtils.isEmpty(r109) == true) goto L35;
            if (r107.f526520d.size() <= 0) goto L30;
            if (((b) ListProtector.get(r107.f526520d, 0)).f526533e == null) goto L30;
            ((b) ListProtector.get(r107.f526520d, 0)).f526533e.BucketName = r105;
            ((b) ListProtector.get(r107.f526520d, 0)).f526533e.OssEndPoint = r109;
        L30:
            if (r107.f526519c.size() > 0) goto L32;
        L34:
            r107.f526526j = true;
            r108 = true;
            goto L35
        L32:
            if (((b) ListProtector.get(r107.f526519c, 0)).f526533e == null) goto L34;
            ((b) ListProtector.get(r107.f526519c, 0)).f526533e.BucketName = r105;
            ((b) ListProtector.get(r107.f526519c, 0)).f526533e.OssEndPoint = r109;
            goto L34
        L16:
            if (((b) ListProtector.get(r107.f526520d, 0)).f526533e == null) goto L18;
            r105 = ((b) ListProtector.get(r107.f526520d, 0)).f526533e.backupBucketName;
            r109 = ((b) ListProtector.get(r107.f526520d, 0)).f526533e.backupOssEndPoint;
            goto L20
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f526529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f526530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f526531c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f526532d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final OSSConfig f526533e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f526534f;

        public b(int r100, String r101, String r102, byte[] r103, OSSConfig r104, boolean r105) {
            this.f526529a = r100;
            this.f526530b = r101;
            this.f526531c = r102;
            this.f526532d = r103;
            this.f526533e = r104;
            this.f526534f = r105;
        }
    }

    public interface c {
    }

    public interface d {
        boolean a(int r100, String r101, String r102, String r103);

        void b(int r100, String r101, String r102);

        void c(String[] r100);

        void d(int r100, int r101, String r102, String[] r103);
    }

    static {
        f526516l = new a();
    }

    public final void b() {
        Object r100 = this.f526522f;
        monitor-enter(r100);
        this.f526517a = new ArrayList();     // Catch: Throwable -> L7
        this.f526518b = new ArrayList();     // Catch: Throwable -> L7
        this.f526520d = new ArrayList();     // Catch: Throwable -> L7
        this.f526519c = new ArrayList();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public a() {
        this.f526517a = new ArrayList();
        this.f526518b = new ArrayList();
        this.f526519c = new ArrayList();
        this.f526520d = new ArrayList();
        this.f526521e = new AtomicInteger(1000);
        this.f526522f = new Object();
        this.f526523g = 0;
        this.f526524h = new ArrayList();
        this.f526525i = new ArrayList();
        this.f526526j = false;
        this.f526527k = new C7107a(this);
    }

    public final void a(d r100, String r101) {
        String[] r102 = new String[10];
        r102[0] = "optionalsCount";
        r102[1] = String.valueOf(this.f526519c.size());
        r102[2] = "requiredsCount";
        r102[3] = String.valueOf(this.f526520d.size());
        r102[4] = "failedRequiredFiles";
        String r103 = "null";
        if (((ArrayList) this.f526524h).size() != 0) goto L5;
        String r104 = "null";
    L6:
        r102[5] = r104;
        r102[6] = "failedOptionalFiles";
        if (((ArrayList) this.f526525i).size() == 0) goto L10;
        r103 = this.f526525i.toString();
    L10:
        r102[7] = r103;
        r102[8] = "useBackup";
        if (this.f526526j == false) goto L13;
        String r105 = "YES";
    L14:
        r102[9] = r105;
        r100.d(this.f526517a.size(), this.f526523g, r101, r102);
        return;
    L13:
        r105 = "NO";
        goto L14
    L5:
        r104 = this.f526524h.toString();
        goto L6
    }

    public final void c(int r100, C7107a r101, d r102) {
        ArrayList<b> r103 = this.f526519c;
        if (r100 != 0) goto L6;
        r103 = this.f526518b;
    L9:
        if (r103 != null) goto L11;
    L21:
        r101.a(r100, 0, 0, r102);
        return;
    L11:
        if (r103.size() == 0) goto L21;
        os7.b r104 = new os7.b(this, r100, r102, r101);
        Object r105 = this.f526522f;
        monitor-enter(r105);
        ts7.c.c(new os7.c(r103, r104));     // Catch: Throwable -> L18
        monitor-exit(r105);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    L6:
        if (r100 != 1) goto L8;
        r103 = this.f526520d;
        ((ArrayList) this.f526524h).clear();
        goto L9
    L8:
        ((ArrayList) this.f526525i).clear();
        goto L9
    }
}
