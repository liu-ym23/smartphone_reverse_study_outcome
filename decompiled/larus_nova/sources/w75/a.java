package w75;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes16.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f558532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<Integer> f558533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f558534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f558535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f558536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f558537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap<String, String> f558538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f558539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f558540i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f558541j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DriveFilePath f558542k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DriveFilePath f558543l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f558544m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f558545n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f558546o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f558547p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f558548q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f558549r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f558550s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f558551t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f558552u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f558553v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f558554w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f558555x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f558556y;

    public final DriveFilePath a() {
        DriveFilePath r100 = this.f558542k;
        if (r100 != null) goto L6;
        DriveFilePath.Companion.getClass();
        return DriveFilePath.a.a();
    L6:
        return r100;
    }

    public final DriveFilePath b() {
        DriveFilePath r100 = this.f558543l;
        if (r100 != null) goto L6;
        DriveFilePath.Companion.getClass();
        return DriveFilePath.a.a();
    L6:
        return r100;
    }

    public final boolean d() {
        b r100 = this.f558532a;
        String r101 = r100.f558562f;
        String r102 = r100.f558566j;
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L7:
        String r103 = this.f558532a.f558567k;
        String r104 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r102);
        if (TextUtils.isEmpty(r103) == false) goto L10;
    L12:
        return false;
    L10:
        if (TextUtils.equals(r103, r104) == false) goto L12;
        return true;
    L5:
        if (TextUtils.equals(r101, r102) == false) goto L7;
        return true;
    }

    public final boolean e() {
        return this.f558535d.get();
    }

    public z i() {
        LinkedHashMap<String, String> r100 = this.f558538g;
        if (hu5.a.e(r100) == true) goto L5;
    L7:
        LinkedHashMap<String, String> r110 = r100;
        if (e() == true) goto L10;
        DriveFilePath r101 = a();
    L11:
        DriveFilePath r102 = r101;
        String r103 = c().f558558b;
        String r104 = this.f558537f;
        long r105 = c().f558559c;
        String r111 = this.f558539h;
        int r112 = this.f558547p;
        boolean r113 = this.f558541j;
        boolean r114 = e();
        long r106 = this.f558552u;
        if (this.f558545n == false) goto L14;
    L17:
        boolean r115 = true;
    L18:
        z r107 = new z(r103, r104, r102, r105, r110, r111, r112, r113, r114, r106, r115, c().f558567k, this.f558549r);
        r107.f225851s = c().f558564h;
        r107.f225852t = c().a();
        r107.f225849q = this.f558548q;
        r107.f225847o = c().f558557a;
        r107.f225845m = this.f558550s;
        return r107;
    L14:
        if (this.f558534c.get() == true) goto L17;
        r115 = false;
        goto L18
    L10:
        r101 = b();
        goto L11
    L5:
        if (TextUtils.isEmpty(this.f558540i) == true) goto L7;
        r100 = new LinkedHashMap();
        r100.put("", this.f558540i);
        goto L7
    }

    public final String toString() {
        return "AbsFileModel{meta=" + this.f558532a + ", serverSupportPreviewType=" + this.f558533b + ", serverPreviewType=" + this.f558536e + ", previewExt='" + this.f558537f + "', videoPreviewUrls=" + this.f558538g + ", extra='" + this.f558539h + "', isStreaming=" + this.f558541j + ", isThumb=" + e() + ", hasCache=" + this.f558534c.get() + ", cachedType=" + this.f558544m + ", isDownloadedFile=" + this.f558545n + ", isCacheFileModel=" + this.f558546o + ", sourceFrom=" + this.f558553v + ", cacheSourceFrom=" + this.f558554w + '}';
    }

    public b c() {
        return this.f558532a;
    }

    public a(b r100) {
        this.f558533b = Collections.synchronizedList(new ArrayList());
        this.f558534c = new AtomicBoolean(false);
        this.f558535d = new AtomicBoolean(false);
        this.f558536e = -1;
        this.f558538g = new LinkedHashMap();
        this.f558541j = false;
        this.f558544m = -1;
        this.f558547p = -1;
        this.f558553v = "";
        this.f558554w = "";
        this.f558532a = r100;
        this.f558533b.addAll(r100.f558560d);
        if (this.f558533b.contains(-2) == true) goto L5;
        this.f558533b.add(-2);
    L5:
        this.f558547p = r100.f558561e;
    }

    public final void f(boolean r100) {
        this.f558534c.set(r100);
    }

    public final void g(boolean r100) {
        this.f558535d.set(r100);
    }

    public final void h(Map r100) {
        this.f558538g.clear();
        if (r100 == null) goto L6;
        this.f558538g.putAll(r100);
        return;
    }
}
