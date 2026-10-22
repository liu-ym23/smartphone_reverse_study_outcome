package yh3;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.PageInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends u33.a implements t43.c, t43.b, t43.d, t43.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f567551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f567552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f567553h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f567554i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f567555j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f567556k;

    public a() {
        throw null;
    }

    @Override // t43.a
    public final String a() {
        return this.f567556k;
    }

    @Override // t43.d
    public final String b() {
        return this.f567554i;
    }

    @Override // t43.b
    public final Map<String, Object> getApiParams() {
        return this.f567552g;
    }

    @Override // t43.c
    public final String getProductID() {
        return this.f567553h;
    }

    public a(r33.a r110, PageInfo r111, e r112, u33.c r113, v33.b r114, u33.b r210, String r211, String r212, boolean r213, String r214, int r215) {
        if ((r215 & 64) == 0) goto L5;
        LinkedHashMap r100 = new LinkedHashMap();
    L6:
        LinkedHashMap r115 = r100;
        if ((r215 & 512) == 0) goto L9;
        boolean r116 = false;
    L10:
        Intrinsics.checkNotNullParameter(r110, "btmInfo");
        Intrinsics.checkNotNullParameter(r111, "pageInfo");
        Intrinsics.checkNotNullParameter(r112, "uiProps");
        Intrinsics.checkNotNullParameter(r113, "yataProps");
        Intrinsics.checkNotNullParameter(r114, "sliceProps");
        Intrinsics.checkNotNullParameter(r210, "trackProps");
        Intrinsics.checkNotNullParameter(r115, "apiParams");
        Intrinsics.checkNotNullParameter(r211, "productID");
        Intrinsics.checkNotNullParameter(r212, "skuSessionID");
        Intrinsics.checkNotNullParameter(r214, "preSessionID");
        super(r111, r110, r114, r113, r210);
        this.f567551f = r112;
        this.f567552g = r115;
        this.f567553h = r211;
        this.f567554i = r212;
        this.f567555j = r116;
        this.f567556k = r214;
        r115.put("b_type_new", Integer.valueOf(j43.a.a()));
        Lazy r101 = ECAppInfoService.f48110a;
        if (we.a.f559330a == false) goto L13;
        String r102 = String.valueOf(j43.a.f497353a);
    L14:
        r115.put("sub_b_type", r102);
        String r103 = r111.getSchemaModel().getQueryParam("shape");
        String r104 = "";
        if (r103 != null) goto L17;
        r103 = "";
    L17:
        r115.put("buy_render_shape", r103);
        if (we.a.f559330a == false) goto L25;
        String r105 = j43.a.b();
        if (r105 == null) goto L23;
        r104 = r105;
    L23:
        r115.put("webcast_appid", r104);
        return;
    L25:
        return;
    L13:
        r102 = "3";
        goto L14
    L9:
        r116 = r213;
        goto L10
    L5:
        r100 = null;
        goto L6
    }
}
