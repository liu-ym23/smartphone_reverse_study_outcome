package jz2;

import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.entity.UnifyErrorDomain;
import com.bytedance.android.monitorV2.event.HybridEvent;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class e extends fz2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NativeCommon f501125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f501126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f501127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f501128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f501129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f501130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f501131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f501132h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f501133i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f501134j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f501135k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f501136l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f501137m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f501138n;

    public e(NativeCommon r100) {
        Intrinsics.checkNotNullParameter(r100, "commonData");
        this.f501125a = r100;
        this.f501127c = new o(UnifyErrorDomain.AnnieXUnifyErrorDomainReserved.getErrorDomain(), "", 0);
        this.f501135k = "";
        this.f501136l = "";
        this.f501137m = "";
        this.f501138n = "";
        r100.addContext("stage", 0);
    }

    public final void a(int r100) {
        this.f501126b = r100;
        this.f501125a.addContext("stage", Integer.valueOf(r100));
    }

    @Override // fz2.a
    public final void fillInJsonObject(JSONObject r100) {
        com.bytedance.android.monitorV2.util.l.n(r100, "stage", this.f501126b);
        com.bytedance.android.monitorV2.util.l.n(r100, "js_exception_count", this.f501128d);
        com.bytedance.android.monitorV2.util.l.n(r100, "native_error_count", this.f501129e);
        com.bytedance.android.monitorV2.util.l.n(r100, "static_count", this.f501130f);
        com.bytedance.android.monitorV2.util.l.n(r100, "fetch_error_count", this.f501131g);
        com.bytedance.android.monitorV2.util.l.n(r100, "jsb_error_count", this.f501132h);
        com.bytedance.android.monitorV2.util.l.n(r100, "res_loader_error_count", this.f501133i);
        com.bytedance.android.monitorV2.util.l.n(r100, "res_loader_error_template_count", this.f501134j);
        com.bytedance.android.monitorV2.util.l.q(r100, "render_status", this.f501135k);
        com.bytedance.android.monitorV2.util.l.q(r100, "dom_state", this.f501136l);
        com.bytedance.android.monitorV2.util.l.q(r100, "rendering_phase", this.f501137m);
        com.bytedance.android.monitorV2.util.l.q(r100, "js_hang", this.f501138n);
    }

    public final void update(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof com.bytedance.android.monitorV2.event.a) == false) goto L36;
        String r101 = r100.f163001a;
        switch(r101.hashCode()) {
            case -892481938: goto L32;
            case 281935726: goto L28;
            case 299602137: goto L24;
            case 1521451035: goto L20;
            case 1727072305: goto L16;
            case 1830775838: goto L12;
            case 1910899023: goto L8;
            default: goto L43;
        };
    L43:
        return;
    L8:
        if (r101.equals("jsbError") == false) goto L44;
        this.f501132h++;
        return;
    L44:
        return;
    L12:
        if (r101.equals("res_loader_error_template") == false) goto L45;
        this.f501134j++;
        return;
    L45:
        return;
    L16:
        if (r101.equals("nativeError") == false) goto L46;
        this.f501129e++;
        return;
    L46:
        return;
    L20:
        if (r101.equals("res_loader_error") == false) goto L47;
        this.f501133i++;
        return;
    L47:
        return;
    L24:
        if (r101.equals("js_exception") == false) goto L48;
        this.f501128d++;
        return;
    L48:
        return;
    L28:
        if (r101.equals("fetchError") == false) goto L49;
        this.f501131g++;
        return;
    L49:
        return;
    L32:
        if (r101.equals("static") == false) goto L50;
        this.f501130f++;
        return;
    L50:
        return;
    }

    public final void b(com.bytedance.android.monitorV2.event.a r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r102, "message");
        String r103 = r100.f163001a;
        switch(r103.hashCode()) {
            case -892481938: goto L34;
            case 281935726: goto L30;
            case 299602137: goto L26;
            case 1521451035: goto L22;
            case 1727072305: goto L14;
            case 1830775838: goto L10;
            case 1910899023: goto L6;
            default: goto L44;
        };
    L44:
        return;
    L6:
        if (r103.equals("jsbError") == false) goto L45;
        this.f501127c = new o(UnifyErrorDomain.AnnieXUnifyErrorDomainContainerJSB.getErrorDomain(), r102, r101);
        return;
    L45:
        return;
    L10:
        if (r103.equals("res_loader_error_template") == false) goto L46;
        this.f501127c = new o(UnifyErrorDomain.AnnieXUnifyErrorDomainResourceLoader.getErrorDomain(), r102, r101);
        return;
    L46:
        return;
    L14:
        if (r103.equals("nativeError") == true) goto L17;
        return;
    L17:
        if (Intrinsics.areEqual(r100.f163006f.containerType, "web") == false) goto L19;
        o r104 = new o(UnifyErrorDomain.AnnieXUnifyErrorDomainEngineWeb.getErrorDomain(), r102, r101);
    L20:
        this.f501127c = r104;
        return;
    L19:
        r104 = new o(UnifyErrorDomain.AnnieXUnifyErrorDomainEngineLynx.getErrorDomain(), r102, r101);
        goto L20
    L22:
        if (r103.equals("res_loader_error") == false) goto L48;
        this.f501127c = new o(UnifyErrorDomain.AnnieXUnifyErrorDomainResourceLoader.getErrorDomain(), r102, r101);
        return;
    L48:
        return;
    L26:
        if (r103.equals("js_exception") == false) goto L49;
        this.f501127c = new o(UnifyErrorDomain.AnnieXUnifyErrorDomainJS.getErrorDomain(), r102, r101);
        return;
    L49:
        return;
    L30:
        if (r103.equals("fetchError") == false) goto L50;
        this.f501127c = new o(UnifyErrorDomain.AnnieXUnifyErrorDomainFetch.getErrorDomain(), r102, r101);
        return;
    L50:
        return;
    L34:
        if (r103.equals("static") == false) goto L51;
        this.f501127c = new o(UnifyErrorDomain.AnnieXUnifyErrorDomainStaticResource.getErrorDomain(), r102, r101);
        return;
    }
}
