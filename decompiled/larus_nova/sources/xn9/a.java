package xn9;

import android.content.Context;
import android.net.Uri;
import com.bytedance.router.c;
import com.larus.home.impl.sdk.SdkSheetsServiceImpl;
import com.larus.home.impl.sdk.SdkSlidesServiceImpl;
import com.larus.home.impl.sdk.n1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.f;
import com.larus.utils.k0;
import com.larus.utils.y0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements q97.a {
    public a() {
    }

    @Override // q97.a
    public final boolean b(c r100) {
        int r101 = k0.f375428a;
        if (r100 == null) goto L7;
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L8:
        String r104 = k0.a(r103);
        if (z2.f365865a.f4() == true) goto L11;
    L17:
        return false;
    L11:
        if (Intrinsics.areEqual(r104, "//flow/doc_detail") == false) goto L13;
    L16:
        return true;
    L13:
        if (Intrinsics.areEqual(r104, "//flow/slides_detail") == true) goto L16;
        if (Intrinsics.areEqual(r104, "//flow/sheet_detail") == false) goto L17;
    L7:
        r103 = null;
        goto L8
    }

    @Override // q97.a
    public final boolean a(Context r110, c r111) {
        if (z2.f365865a.f4() == false) goto L56;
        int r100 = k0.f375428a;
        Integer r101 = null;
        if (r111 == null) goto L9;
        Uri r102 = r111.f267530d;
        if (r102 == null) goto L9;
        String r103 = r102.toString();
    L10:
        String r104 = k0.a(r103);
        if (r104 == null) goto L56;
        int r105 = r104.hashCode();
        if (r105 == (-660592935)) goto L44;
        if (r105 == 185197837) goto L32;
        if (r105 != 438583442) goto L56;
        if (r104.equals("//flow/sheet_detail") == false) goto L56;
        if (r111 == null) goto L56;
        Uri r112 = r111.f267530d;
        if (r112 == null) goto L56;
        String r113 = y0.f(r112, "sheets_token");
        if (r110 == null) goto L56;
        IFlowSdkDepend r106 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r106 == null) goto L30;
        r106.h();
        SdkSheetsServiceImpl.f346130a.h(r110, f.c(new Pair[]{TuplesKt.to("sheets_token", r113), TuplesKt.to("resource_type", 12)}), "multi_task");
    L30:
        return true;
    L32:
        if (r104.equals("//flow/slides_detail") == false) goto L56;
        if (r111 == null) goto L56;
        Uri r114 = r111.f267530d;
        if (r114 == null) goto L56;
        String r115 = y0.f(r114, "slides_token");
        if (r110 == null) goto L56;
        IFlowSdkDepend r107 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r107 == null) goto L42;
        r107.E0();
        SdkSlidesServiceImpl.f346131a.k(r110, r115, "multi_task");
    L42:
        return true;
    L44:
        if (r104.equals("//flow/doc_detail") == false) goto L56;
        if (r111 == null) goto L56;
        Uri r116 = r111.f267530d;
        if (r116 == null) goto L56;
        String r108 = y0.f(r116, "key_doc_id");
        String r117 = y0.f(r116, "resource_type");
        if (r117 == null) goto L51;
        r101 = StringsKt.toIntOrNull(r117);
    L51:
        if (r110 == null) goto L56;
        IFlowSdkDepend r118 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r118 == null) goto L55;
        r118.N();
        n1.f346205a.x(r110, f.c(new Pair[]{TuplesKt.to("key_doc_id", r108), TuplesKt.to("resource_type", r101)}), "multi_task");
    L55:
        return true;
    L9:
        r103 = null;
    L56:
        return false;
    }
}
