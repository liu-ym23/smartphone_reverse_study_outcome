package com.ss.android.ugc.aweme.search.dynamic.core.data;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.search.dynamic.business.SearchReloadMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"trade-search-impl_release"}, k = 2, mv = {1, 4, 3})
public final class SchemaRenderOptionKt {
    public static final SchemaRenderOption a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = UriProtector.getQueryParameter(r100, "search_dynamic_reload_method");
        Integer r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = StringsKt.toIntOrNull(r101);
    L6:
        if (r103 == null) goto L10;
        SearchReloadMethod.f452592a.getClass();
        if (SearchReloadMethod.f452593b.contains(r103) == false) goto L10;
        r102 = r103;
    L10:
        String r104 = UriProtector.getQueryParameter(r100, "start_js_after_process_render");
        if (r104 == null) goto L31;
        int r105 = r104.hashCode();
        if (r105 != 48) goto L15;
        String r106 = "0";
    L30:
        r104.equals(r106);
        goto L31
    L15:
        if (r105 == 49) goto L26;
        if (r105 == 3569038) goto L23;
        if (r105 != 97196323) goto L31;
        r106 = "false";
        goto L30
    L23:
        if (r104.equals("true") == false) goto L31;
    L28:
        boolean r107 = true;
    L33:
        return new SchemaRenderOption(r102, r107);
    L26:
        if (r104.equals("1") == true) goto L28;
    L31:
        r107 = false;
        goto L33
    L5:
        r103 = null;
        goto L6
    }
}
