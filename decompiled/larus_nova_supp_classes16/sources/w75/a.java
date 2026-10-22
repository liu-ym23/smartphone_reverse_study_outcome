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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a {
    public final b a;
    public List<Integer> b;
    public final AtomicBoolean c;
    public final AtomicBoolean d;
    public int e;
    public String f;
    public final LinkedHashMap<String, String> g;
    public String h;
    public String i;
    public boolean j;
    public DriveFilePath k;
    public DriveFilePath l;
    public int m;
    public boolean n;
    public boolean o;
    public final int p;
    public int q;
    public String r;
    public boolean s;
    public boolean t;
    public long u;
    public String v;
    public String w;
    public boolean x;
    public int y;

    public final DriveFilePath a() {
        DriveFilePath r0 = this.k;
        if (r0 != null) goto L6;
        DriveFilePath.Companion.getClass();
        return DriveFilePath.a.a();
    L6:
        return r0;
    }

    public final DriveFilePath b() {
        DriveFilePath r0 = this.l;
        if (r0 != null) goto L6;
        DriveFilePath.Companion.getClass();
        return DriveFilePath.a.a();
    L6:
        return r0;
    }

    public final boolean d() {
        b r0 = this.a;
        String r1 = r0.f;
        String r2 = r0.j;
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L7:
        String r3 = this.a.k;
        String r4 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r2);
        if (TextUtils.isEmpty(r3) == false) goto L10;
    L12:
        return false;
    L10:
        if (TextUtils.equals(r3, r4) == false) goto L12;
        return true;
    L5:
        if (TextUtils.equals(r1, r2) == false) goto L7;
        return true;
    }

    public final boolean e() {
        return this.d.get();
    }

    public z i() {
        LinkedHashMap<String, String> r1 = this.g;
        if (hu5.a.e(r1) == true) goto L5;
    L7:
        LinkedHashMap<String, String> r10 = r1;
        if (e() == true) goto L10;
        DriveFilePath r2 = a();
    L11:
        DriveFilePath r7 = r2;
        String r5 = c().b;
        String r6 = this.f;
        long r8 = c().c;
        String r11 = this.h;
        int r12 = this.p;
        boolean r13 = this.j;
        boolean r14 = e();
        long r3 = this.u;
        if (this.n == false) goto L14;
    L17:
        boolean r17 = true;
    L18:
        z r4 = new z(r5, r6, r7, r8, r10, r11, r12, r13, r14, r3, r17, c().k, this.r);
        r4.s = c().h;
        r4.t = c().a();
        r4.q = this.q;
        r4.o = c().a;
        r4.m = this.s;
        return r4;
    L14:
        if (this.c.get() == true) goto L17;
        r17 = false;
        goto L18
    L10:
        r2 = b();
        goto L11
    L5:
        if (TextUtils.isEmpty(this.i) == true) goto L7;
        r1 = new LinkedHashMap();
        r1.put("", this.i);
        goto L7
    }

    public final String toString() {
        return "AbsFileModel{meta=" + this.a + ", serverSupportPreviewType=" + this.b + ", serverPreviewType=" + this.e + ", previewExt='" + this.f + "', videoPreviewUrls=" + this.g + ", extra='" + this.h + "', isStreaming=" + this.j + ", isThumb=" + e() + ", hasCache=" + this.c.get() + ", cachedType=" + this.m + ", isDownloadedFile=" + this.n + ", isCacheFileModel=" + this.o + ", sourceFrom=" + this.v + ", cacheSourceFrom=" + this.w + '}';
    }

    public b c() {
        return this.a;
    }

    public a(b r4) {
        this.b = Collections.synchronizedList(new ArrayList());
        this.c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.e = -1;
        this.g = new LinkedHashMap();
        this.j = false;
        this.m = -1;
        this.p = -1;
        this.v = "";
        this.w = "";
        this.a = r4;
        this.b.addAll(r4.d);
        if (this.b.contains(-2) == true) goto L5;
        this.b.add(-2);
    L5:
        this.p = r4.e;
    }

    public final void f(boolean r2) {
        this.c.set(r2);
    }

    public final void g(boolean r2) {
        this.d.set(r2);
    }

    public final void h(Map r2) {
        this.g.clear();
        if (r2 == null) goto L6;
        this.g.putAll(r2);
        return;
    }
}
