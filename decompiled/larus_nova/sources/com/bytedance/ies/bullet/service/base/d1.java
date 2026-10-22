package com.bytedance.ies.bullet.service.base;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.gkfs.io.GkFSFileInputStream;
import com.bytedance.ies.argus.api.ArgusResourceType;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes19.dex */
public class d1 {
    public b26.d A;
    public JSONArray B;
    public List<String> C;
    public byte[] D;
    public String E;
    public LoaderName F;
    public ArgusResourceType G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f247858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f247859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ResourceType f247860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ResourceFrom f247861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f247862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f247863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f247864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public InputStream f247865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a26.a f247866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f247867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f247868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f247869l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f247870m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f247871n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f247872o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f247873p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f247874q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f247875r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f247876s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f247877t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f247878u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f247879v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f247880w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f247881x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public WebResourceResponse f247882y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public b26.d f247883z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f247884a = null;

        static {
            int[] r100 = new int[ResourceType.values().length];
            r100[ResourceType.ASSET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L4:
            int[] r101 = new int[ResourceFrom.values().length];
            r101[ResourceFrom.GECKO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L20:
            r101[ResourceFrom.BUILTIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L26:
            r101[ResourceFrom.CDN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L22:
            r101[ResourceFrom.LOCAL_FILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L28:
            r101[ResourceFrom.PRELOAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L10:
            f247884a = r101;
        }
    }

    static {
    }

    public final String a() {
        if (this.f247874q == true) goto L40;
        ResourceFrom r100 = this.f247861d;
        if (r100 != null) goto L8;
        int r101 = -1;
    L10:
        if (r101 == 1) goto L29;
        if (r101 == 2) goto L26;
        if (r101 == 3) goto L22;
        if (r101 == 4) goto L35;
        if (r101 == 5) goto L33;
        return "custom";
    L33:
        return "preload";
    L35:
        return OperationName.OPERATION_OFFLINE_AVAILABLE;
    L22:
        if (this.f247862e == false) goto L24;
        return "cdnCache";
    L24:
        return "cdn";
    L26:
        if (this.f247860c != ResourceType.ASSET) goto L35;
        return "buildIn";
    L29:
        if (this.f247862e == false) goto L31;
        return "gecko";
    L31:
        return "geckoUpdate";
    L8:
        r101 = b.f247884a[r100.ordinal()];
        goto L10
    L40:
        return "preload";
    }

    public byte[] b() {
        if (this.D == null) goto L5;
        y16.b r100 = y16.c.f565659a;
        String r101 = "命中内存缓存 ByteArray, " + this.f247877t + ", " + this.f247858a + ", " + this.f247859b;
        Intrinsics.checkNotNullParameter(r101, "msg");
        y16.c.f565659a.d("[ResourceLoader] PreloadV2 " + r101);
        return this.D;
    L5:
        InputStream r102 = c();
        if (r102 != null) goto L11;
        return null;
    L11:
        return ByteStreamsKt.readBytes(r102);
    }

    public final InputStream c() {
        String r100 = this.f247859b;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        InputStream r102 = this.f247865h;
        if (r102 != null) goto L20;
        DefaultConstructorMarker r103 = null;
        if (r101.exists() == false) goto L17;
        if (r101.isDirectory() == true) goto L17;
        List<Function0<Unit>> r104 = GkFSUtils.f245072a;
        if (GkFSUtils.g(r101.getPath()) == false) goto L19;
        return new GkFSFileInputStream(r101, false, 2, r103);
    L19:
        return new PolarisFileInputStreamWrapper(r101);
    L17:
        return null;
    L20:
        return r102;
    }

    public final String toString() {
        return "[srcUri=" + this.f247858a + ", filePath=" + this.f247859b + ", type=" + this.f247860c + ",from=" + this.f247861d + ", fileStream=" + this.f247865h + ", model=" + this.f247866i + ", accessKey=" + this.f247880w + "}]";
    }

    public final ResourceType getType() {
        return this.f247860c;
    }

    public d1(Uri r110, String r111, ResourceType r112, ResourceFrom r210, boolean r211, long r212, boolean r213, InputStream r214, a26.a r215, String r216, long r217, int r310) {
        a26.a r100 = null;
        if ((r310 & 2) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r310 & 4) == 0) goto L9;
        ResourceType r102 = null;
    L11:
        if ((r310 & 8) == 0) goto L13;
        ResourceFrom r103 = null;
    L15:
        if ((r310 & 16) == 0) goto L17;
        boolean r104 = false;
    L18:
        long r105 = 0;
        if ((r310 & 32) == 0) goto L21;
        long r113 = 0;
    L23:
        if ((r310 & 64) == 0) goto L25;
        boolean r106 = true;
    L27:
        if ((r310 & 128) == 0) goto L29;
        InputStream r114 = null;
    L31:
        if ((r310 & 256) != 0) goto L35;
        r100 = r215;
    L35:
        if ((r310 & 512) == 0) goto L37;
        String r115 = "";
    L39:
        if ((r310 & 1024) != 0) goto L42;
        r105 = r217;
    L42:
        Intrinsics.checkNotNullParameter(r110, "srcUri");
        Intrinsics.checkNotNullParameter(r115, "successLoader");
        this.f247858a = r110;
        this.f247859b = r101;
        this.f247860c = r102;
        this.f247861d = r103;
        this.f247862e = r104;
        this.f247863f = r113;
        this.f247864g = r106;
        this.f247865h = r114;
        this.f247866i = r100;
        this.f247867j = r115;
        this.f247868k = r105;
        this.f247872o = "";
        this.f247873p = "";
        this.f247875r = "";
        this.f247876s = "";
        this.f247877t = "";
        this.f247878u = "";
        this.f247879v = "";
        this.f247880w = "";
        this.f247881x = "";
        this.f247883z = new b26.d("bdx_resourceloader_fetch");
        this.A = new b26.d("bdx_resourceloader_performance");
        this.B = new e1();
        new ArrayList();
        this.F = LoaderName.ResourceLoader;
        this.G = ArgusResourceType.UNKNOWN;
        return;
    L37:
        r115 = r216;
        goto L39
    L29:
        r114 = r214;
        goto L31
    L25:
        r106 = r213;
        goto L27
    L21:
        r113 = r212;
        goto L23
    L17:
        r104 = r211;
        goto L18
    L13:
        r103 = r210;
        goto L15
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}
