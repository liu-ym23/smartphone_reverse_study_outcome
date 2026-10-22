package com.bytedance.ee.bear.container;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.b4;
import com.bytedance.ee.bear.document.v4;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.wikiv2.browser.plugin.p0;
import com.ss.android.lark.log.Log;
import java.io.Serializable;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class v implements bk5.b {

    public static final class a {
    }

    static {
    }

    public v() {
    }

    @Override // bk5.b
    public final boolean b(BearUrl r100, bk5.e r101, bk5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bearUrl");
        Intrinsics.checkNotNullParameter(r101, "loaderTypeBefore");
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        return true;
    }

    public final String toString() {
        return "LoadingLayoutInitNode";
    }

    public static BearUrl c(BearUrl r100, bk5.a r101) {
        if (Intrinsics.areEqual(r100.f222560a, sbb.e.f541303n.getType()) == true) goto L5;
        return r100;
    L5:
        String r102 = r100.f222561b;
        BearUrl r103 = null;
        if (r102 == null) goto L46;
        boolean r104 = true;
        if ((!StringsKt.isBlank(r102)) == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L46;
        Serializable r105 = r101.h9().getSerializable("wiki_info");
        if ((r105 instanceof WikiInfo) == false) goto L16;
        WikiInfo r106 = (WikiInfo) r105;
    L18:
        if (r106 != null) goto L20;
    L30:
        WikiInfo r107 = p0.g(new ce5.a(r101.j9()), r102);
        if (r107 != null) goto L33;
        r106 = null;
    L43:
        if (r106 == null) goto L46;
    L45:
        r103 = s45.p.a().Z(s45.p.a().Fd(r100.f222564e, r106.getObjTypeString(), r106.getObjToken(), r100.f222563d));
        goto L46
    L33:
        if (r107.isValidObjInfo() == true) goto L35;
    L37:
        r104 = false;
    L38:
        if (r104 == true) goto L41;
        r107 = null;
    L41:
        r106 = r107;
        goto L43
    L35:
        if (Intrinsics.areEqual(r107.getWikiToken(), r102) == false) goto L37;
    L20:
        if (r106.isValidObjInfo() == true) goto L22;
    L24:
        boolean r108 = false;
    L25:
        if (r108 == true) goto L28;
        r106 = null;
    L28:
        if (r106 == null) goto L30;
    L22:
        if (Intrinsics.areEqual(r106.getWikiToken(), r102) == false) goto L24;
        r108 = true;
        goto L25
    L16:
        r106 = null;
    L46:
        if (r103 != null) goto L49;
        return r100;
    L49:
        return r103;
    }

    @Override // bk5.b
    public final Object a(BearUrl r100, bk5.e r101, bk5.a r102, Continuation<? super bk5.e> r103) {
        BearUrl r104 = c(r100, r102);     // Catch: Exception -> L6
        sbb.e r105 = sbb.e.e(r104.f222560a);     // Catch: Exception -> L6
        Map<sbb.e, v4> r106 = b4.f219150a;     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L6
        Intrinsics.checkNotNullParameter(r105, "documentType");     // Catch: Exception -> L6
        if (b4.f219150a.containsKey(r105) == false) goto L8;
        yx4.d r107 = b4.a(r105).getLoadingLayout(r104);     // Catch: Exception -> L6
    L9:
        r102.i9(r107);
        r102.showLoading();
        return r101;
    L8:
        r107 = null;
    L6:
        e = move-exception;
        Log.e("LoadingLayoutInitNode", "resolve loading layout failed", e);
        goto L8
    }
}
