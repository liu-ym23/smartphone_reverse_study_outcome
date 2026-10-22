package nv8;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.google.gson.JsonArray;
import com.larus.business.accessbility.impl.AccessibilityHttpService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import defpackage.h;
import defpackage.i;
import defpackage.j;
import defpackage.k;
import defpackage.l;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes26.dex */
public final class d implements j6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f520925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f520926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f520927c;

    public static final class a {
    }

    static {
    }

    @Override // j6.a
    public final j6.b a() {
        boolean r100 = false;
        if (AppHost.f326268a.isDebug() == false) goto L33;
        FLogger r101 = FLogger.f375446a;
        r101.i("AccessibilityHttpConfigProvider", "[getConfigFile] Version is debug, get debug config data");
        Call<i> r102 = ((AccessibilityHttpService) this.f520926b.getValue()).getAccessibilityDebugConfigData();
        if (r102 == null) goto L7;
        SsResponse<i> r103 = r102.execute();
    L8:
        StringBuilder r104 = new StringBuilder("[getAccessibilityDebugConfigData] Success is ");
        if (r103 == null) goto L11;
        Boolean r105 = Boxing.boxBoolean(r103.isSuccessful());
    L12:
        r104.append(r105);
        r101.i("AccessibilityHttpConfigProvider", r104.toString());
        if (r103 != null) goto L15;
    L17:
        if (r100 == false) goto L89;
        i r106 = r103.body();
        if (r106 == null) goto L92;
        j r107 = r106.a();
        if (r107 == null) goto L93;
        Long r108 = r107.b();
        if (r108 == null) goto L90;
        r108.longValue();
        defpackage.b r109 = r107.a();
        if (r109 == null) goto L91;
        JsonArray r110 = r109.a();
        if (r110 == null) goto L94;
        r101.i("AccessibilityHttpConfigProvider", "[getAccessibilityDebugConfigData] data is " + r110);
        return new j6.b(r110.toString(), true);
    L94:
        return null;
    L91:
        return null;
    L90:
        return null;
    L93:
        return null;
    L92:
        return null;
    L89:
        return null;
    L15:
        if (r103.isSuccessful() != true) goto L17;
        r100 = true;
        goto L17
    L11:
        r105 = null;
        goto L12
    L7:
        r103 = null;
        goto L8
    L33:
        FLogger r111 = FLogger.f375446a;
        r111.i("AccessibilityHttpConfigProvider", "[getConfigFile] Version is release, get release config data");
        Call<l> r112 = ((AccessibilityHttpService) this.f520925a.getValue()).getAccessibilityConfig(this.f520927c);
        if (r112 == null) goto L36;
        SsResponse<l> r113 = r112.execute();
    L37:
        StringBuilder r114 = new StringBuilder("[getAccessibilityReleaseConfigData] Success is ");
        if (r113 == null) goto L40;
        Boolean r115 = Boxing.boxBoolean(r113.isSuccessful());
    L41:
        r114.append(r115);
        r111.i("AccessibilityHttpConfigProvider", r114.toString());
        if (r113 != null) goto L44;
    L46:
        boolean r116 = false;
    L47:
        if (r116 == false) goto L95;
        l r117 = r113.body();
        if (r117 == null) goto L97;
        k r118 = r117.a();
        if (r118 == null) goto L98;
        String r119 = r118.c();
        String r120 = r118.a();
        String r121 = r118.b();
        if (r119 != null) goto L57;
    L60:
        boolean r122 = true;
    L61:
        if (r122 == false) goto L64;
        r119 = r120;
    L64:
        if (r119 != null) goto L66;
    L69:
        boolean r123 = true;
    L70:
        if (r123 == true) goto L99;
        Call<h> r124 = ((AccessibilityHttpService) this.f520925a.getValue()).getAccessibilityData(r119);
        if (r124 == null) goto L75;
        SsResponse<h> r125 = r124.execute();
    L76:
        if (r125 != null) goto L78;
    L80:
        if (r100 == false) goto L96;
        h r126 = r125.body();
        if (r126 == null) goto L100;
        r111.i("AccessibilityHttpConfigProvider", "[getAccessibilityReleaseConfigData] data is " + r126);
        if (r121 != null) goto L87;
        r121 = "";
    L87:
        this.f520927c = r121;
        return new j6.b(String.valueOf(r126.a()), true);
    L100:
        return null;
    L96:
        return null;
    L78:
        if (r125.isSuccessful() != true) goto L80;
        r100 = true;
        goto L80
    L75:
        r125 = null;
        goto L76
    L99:
        return null;
    L66:
        if (r119.length() == 0) goto L69;
        r123 = false;
        goto L70
    L57:
        if (r119.length() == 0) goto L60;
        r122 = false;
        goto L61
    L98:
        return null;
    L97:
        return null;
    L95:
        return null;
    L44:
        if (r113.isSuccessful() != true) goto L46;
        r116 = true;
        goto L47
    L40:
        r115 = null;
        goto L41
    L36:
        r113 = null;
        goto L37
    }

    public d() {
        this.f520925a = LazyKt.lazy(new b(this));
        this.f520926b = LazyKt.lazy(new c(this));
        this.f520927c = "";
    }
}
