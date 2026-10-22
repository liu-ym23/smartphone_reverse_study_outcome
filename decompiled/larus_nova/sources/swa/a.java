package swa;

import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f543740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f543741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f543742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f543743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f543744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EntityDomain f543745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f543746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FileBizDomain f543747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f543748i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f543749j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f543750k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Long f543751l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f543752m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f543753n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f543754o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Long f543755p;

    public final b a() {
        String r100 = this.f543740a;
        Integer r101 = Integer.valueOf(this.f543741b);
        Integer r102 = Integer.valueOf(this.f543742c);
        String r103 = this.f543743d;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pointKey");
        String r104 = null;
    L6:
        String r105 = this.f543744e;
        if (r105 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("entityType");
        String r106 = null;
    L10:
        EntityDomain r107 = this.f543745f;
        if (r107 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("entityDomain");
        EntityDomain r108 = null;
    L14:
        String r109 = this.f543746g;
        if (r109 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("entityOperate");
        String r110 = null;
    L18:
        long r111 = this.f543748i;
        long r112 = this.f543749j;
        FileBizDomain r113 = this.f543747h;
        if (r113 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("fileBizDomain");
        FileBizDomain r210 = null;
    L23:
        return new b(r100, r101, r102, r104, r106, r108, r110, r111, r112, r210, this.f543750k, this.f543751l, this.f543752m, this.f543753n, this.f543754o, this.f543755p);
    L21:
        r210 = r113;
        goto L23
    L17:
        r110 = r109;
        goto L18
    L13:
        r108 = r107;
        goto L14
    L9:
        r106 = r105;
        goto L10
    L5:
        r104 = r103;
        goto L6
    }

    public a() {
        this.f543740a = "";
    }

    public final void b(EntityDomain r100) {
        Intrinsics.checkNotNullParameter(r100, "entityDomain");
        this.f543745f = r100;
    }

    public final void c(FileBizDomain r100) {
        Intrinsics.checkNotNullParameter(r100, "fileBizDomain");
        this.f543747h = r100;
    }
}
