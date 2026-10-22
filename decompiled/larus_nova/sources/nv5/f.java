package nv5;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f520877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f520878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pattern> f520879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Uri> f520880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<d> f520881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f520882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final rv5.b f520883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f520884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f520885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f520886j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f520887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f520888b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<d> f520889c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public rv5.b f520890d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f520891e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<Pattern> f520892f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<Uri> f520893g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f520894h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f520895i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f520896j;

        public a(Context r100) {
            this.f520891e = true;
            this.f520887a = r100;
        }
    }

    public Context getContext() {
        return this.f520877a;
    }

    public f(a r100) {
        Context r101 = r100.f520887a;
        if (r101 == null) goto L36;
        Context r102 = r101.getApplicationContext();
        if (r102 != null) goto L7;
        this.f520877a = r100.f520887a;
    L9:
        if (TextUtils.isEmpty(null) == false) goto L16;
        Context r103 = this.f520877a;
        int r104 = ez5.a.f474883a;
        String r105 = r103.getPackageManager().getPackageInfo(r103.getPackageName(), 0).versionName;     // Catch: Exception -> L13
    L15:
        this.f520884h = r105;
    L18:
        if (TextUtils.isEmpty(r100.f520888b) == true) goto L34;
        this.f520878b = r100.f520888b;
        if (TextUtils.isEmpty(r100.f520895i) == true) goto L32;
        this.f520885i = r100.f520895i;
        this.f520879c = r100.f520892f;
        this.f520881e = r100.f520889c;
        List<Uri> r106 = r100.f520893g;
        if (r106 != null) goto L24;
        this.f520880d = Arrays.asList(new Uri[]{Uri.fromFile(new PolarisFileWrapper(this.f520877a.getFilesDir(), GeckoClient.GECKO_ROOT_DIR))});
    L25:
        this.f520882f = r100.f520894h;
        this.f520883g = r100.f520890d;
        String r107 = r100.f520896j;
        this.f520886j = r107;
        if (TextUtils.isEmpty(r107) == true) goto L30;
        boolean r108 = r100.f520891e;
        return;
    L30:
        throw new IllegalArgumentException("region == null");
    L24:
        this.f520880d = r106;
        goto L25
    L32:
        throw new IllegalArgumentException("host empty");
    L34:
        throw new IllegalArgumentException("accessKey empty");
    L13:
        e = move-exception;
        GeckoLogger.w("getVersion:", e);
        r105 = "null";
        goto L15
    L16:
        this.f520884h = null;
        goto L18
    L7:
        this.f520877a = r102;
        goto L9
    L36:
        throw new IllegalArgumentException("context == null");
    }
}
