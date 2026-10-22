package com.ss.android.ainote;

import android.net.Uri;
import android.webkit.URLUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class VcTaskLinkRegexResolver implements com.ss.android.lark.keyboard.edittext2.mdeditor.link.b {

    public static final class a {
    }

    static {
    }

    public VcTaskLinkRegexResolver() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.mdeditor.link.b
    public final List<com.ss.android.lark.keyboard.edittext2.mdeditor.link.b.a> a(int r100, int r110, CharSequence r111) {
        Intrinsics.checkNotNullParameter(r111, "text");
        String r101 = r111.subSequence(r100, r110).toString();
        String r112 = StringsKt.trim(r101).toString();
        boolean r102 = false;
        if (r112.length() != 0) goto L5;
        boolean r113 = true;
    L6:
        if (r113 == true) goto L50;
        if (URLUtil.isValidUrl(r112) == false) goto L50;
        int r114 = StringsKt.indexOf$default(r101, r112, 0, false, 6, null);
        Uri r103 = UriProtector.parse(r112);     // Catch: Throwable -> L13
    L14:
        if (r103 != null) goto L18;
        return CollectionsKt.emptyList();
    L18:
        if (r103.isOpaque() == true) goto L20;
        String r104 = r103.getPath();
        String r105 = "";
        if (r104 != null) goto L25;
        r104 = "";
    L25:
        if (Intrinsics.areEqual(r104, "/client/todo/detail") == false) goto L27;
        Set<String> r106 = UriProtector.getQueryParameterNames(r103);
        if (r106.contains("suite_entity_num") == false) goto L48;
        if (r106.contains("guid") == false) goto L48;
        if (r106.size() != 2) goto L48;
        String r107 = UriProtector.getQueryParameter(r103, "suite_entity_num");
        if (r107 == null) goto L40;
        r105 = r107;
    L40:
        if (r105.length() != 0) goto L42;
        r102 = true;
    L42:
        if (r102 == true) goto L44;
        final v7b.n r108 = new v7b.n(r112, r105);
        LarkLinkExtend.f420024f.b(new VcTaskLinkRegexResolver$parseUrl$1(r108));
        int r109 = r100 + r114;
        return CollectionsKt.listOf(new com.ss.android.lark.keyboard.edittext2.mdeditor.link.b.a(r108, r109, r112.length() + r109));
    L44:
        return CollectionsKt.emptyList();
    L48:
        return CollectionsKt.emptyList();
    L27:
        return CollectionsKt.emptyList();
    L20:
        return CollectionsKt.emptyList();
    L13:
        r103 = null;
    L50:
        return CollectionsKt.emptyList();
    L5:
        r113 = false;
        goto L6
    }
}
