package com.bytedance.ee.bear.container;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v implements bk5.b {

    public static final class a {
    }

    static {
    }

    public v() {
    }

    public final boolean b(BearUrl r2, bk5.e r3, bk5.a r4) {
        Intrinsics.checkNotNullParameter(r2, "bearUrl");
        Intrinsics.checkNotNullParameter(r3, "loaderTypeBefore");
        Intrinsics.checkNotNullParameter(r4, "container");
        return true;
    }

    public final String toString() {
        return "LoadingLayoutInitNode";
    }

    public static BearUrl c(BearUrl r6, bk5.a r7) {
        if (Intrinsics.areEqual(r6.a, sbb.e.n.getType()) == true) goto L5;
        return r6;
    L5:
        String r0 = r6.b;
        BearUrl r1 = null;
        if (r0 == null) goto L46;
        boolean r3 = true;
        if ((!StringsKt.isBlank(r0)) == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L46;
        Serializable r2 = r7.h9().getSerializable("wiki_info");
        if ((r2 instanceof WikiInfo) == false) goto L16;
        WikiInfo r4 = (WikiInfo) r2;
    L18:
        if (r4 != null) goto L20;
    L30:
        WikiInfo r8 = p0.g(new ce5.a(r7.j9()), r0);
        if (r8 != null) goto L33;
        r4 = null;
    L43:
        if (r4 == null) goto L46;
    L45:
        r1 = s45.p.a().Z(s45.p.a().Fd(r6.e, r4.getObjTypeString(), r4.getObjToken(), r6.d));
        goto L46
    L33:
        if (r8.isValidObjInfo() == true) goto L35;
    L37:
        r3 = false;
    L38:
        if (r3 == true) goto L41;
        r8 = null;
    L41:
        r4 = r8;
        goto L43
    L35:
        if (Intrinsics.areEqual(r8.getWikiToken(), r0) == false) goto L37;
    L20:
        if (r4.isValidObjInfo() == true) goto L22;
    L24:
        boolean r5 = false;
    L25:
        if (r5 == true) goto L28;
        r4 = null;
    L28:
        if (r4 == null) goto L30;
    L22:
        if (Intrinsics.areEqual(r4.getWikiToken(), r0) == false) goto L24;
        r5 = true;
        goto L25
    L16:
        r4 = null;
    L46:
        if (r1 != null) goto L49;
        return r6;
    L49:
        return r1;
    }

    public final Object a(BearUrl r2, bk5.e r3, bk5.a r4, Continuation<? super bk5.e> r5) {
        BearUrl r6 = c(r2, r4);     // Catch: Exception -> L6
        sbb.e r7 = sbb.e.e(r6.a);     // Catch: Exception -> L6
        Map<sbb.e, v4> r0 = b4.a;     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r7);     // Catch: Exception -> L6
        Intrinsics.checkNotNullParameter(r7, "documentType");     // Catch: Exception -> L6
        if (b4.a.containsKey(r7) == false) goto L8;
        yx4.d r8 = b4.a(r7).getLoadingLayout(r6);     // Catch: Exception -> L6
    L9:
        r4.i9(r8);
        r4.showLoading();
        return r3;
    L8:
        r8 = null;
    L6:
        e = move-exception;
        Log.e("LoadingLayoutInitNode", "resolve loading layout failed", e);
        goto L8
    }
}
