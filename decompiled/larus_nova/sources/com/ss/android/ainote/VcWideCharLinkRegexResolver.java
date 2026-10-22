package com.ss.android.ainote;

import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class VcWideCharLinkRegexResolver implements com.ss.android.lark.keyboard.edittext2.mdeditor.link.b {
    public VcWideCharLinkRegexResolver() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.mdeditor.link.b
    public final List<com.ss.android.lark.keyboard.edittext2.mdeditor.link.b.a> a(int r100, int r101, CharSequence r102) {
        Intrinsics.checkNotNullParameter(r102, "text");
        String r103 = r102.subSequence(r100, r101).toString();
        ArrayList r104 = new ArrayList();
        com.ss.android.lark.keyboard.edittext2.utils.b.e(r103, r104);
        if (r104.size() == 1) goto L6;
        r104 = new ArrayList();
        com.ss.android.lark.keyboard.edittext2.utils.b.a(r103, r104);
    L6:
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L8:
        if (r106.hasNext() == false) goto L13;
        com.ss.android.lark.keyboard.edittext2.utils.b.a r107 = (com.ss.android.lark.keyboard.edittext2.utils.b.a) r106.next();
        String r108 = r107.f429250a;
        final v7b.n r109 = new v7b.n(r108, r108);
        if (r107.f429253d == false) goto L12;
        LarkLinkExtend.f420024f.b(new VcWideCharLinkRegexResolver$parseUrl$1$1(r109));
    L12:
        r105.add(new com.ss.android.lark.keyboard.edittext2.mdeditor.link.b.a(r109, r107.f429251b + r100, r107.f429252c + r100));
        goto L8
    L13:
        return r105;
    }
}
