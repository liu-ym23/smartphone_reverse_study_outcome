package com.bytedance.ee.bear.doc.docupgrade;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.docupgrade.DocUpgradeInfo;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.d;
import com.bytedance.ee.bear.route.h;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.lark.storage.LarkKVStorage;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements d {
    public final DocRedirectToDocxPlugin.DocUpgradeDocxConfig a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.doc.docupgrade.a$a, reason: collision with other inner class name */
    public static final class C0044a {
    }

    static {
    }

    public a(DocRedirectToDocxPlugin.DocUpgradeDocxConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "upgradeConfig");
        this.a = r2;
    }

    public final boolean b(Context r10, BearUrl r11, RouteBean r12) {
        if (r11 != null) goto L61;
        tt5.a.k("DocUpgradeRedirectIntercepter", "onIntercept.. but context or bearUrl is Null");
        return false;
    L61:
    L58:
        e = move-exception;
        tt5.a.f("DocUpgradeRedirectIntercepter", e, false);
    L60:
        return false;
    L7:
        if (PatternProtector.compile(this.a.getAndroidBlackUrlRegex()).matcher(r11.e).find() == false) goto L10;
        return false;
    L10:
        if (TextUtils.equals(r11.a, e.g.getType()) == false) goto L60;
        DocUpgradeInfo r2 = (DocUpgradeInfo) LarkKVStorage.p(ay4.b.a, "doc_upgrade", false).getJSONObject(r11.b, DocUpgradeInfo.class);     // Catch: Exception -> L58
        if (r2 == null) goto L14;
        Integer r4 = Integer.valueOf(r2.getStatus());     // Catch: Exception -> L58
    L15:
        if (r2 == null) goto L18;
        String r5 = r2.getRelateUrl();     // Catch: Exception -> L58
    L19:
        String r6 = "";
        if (r5 != null) goto L22;
        r5 = "";
    L22:
        if (r2 == null) goto L24;
        String r3 = r2.getRelateToken();     // Catch: Exception -> L58
    L25:
        if (r3 == null) goto L28;
        r6 = r3;
    L28:
        if (r4 == null) goto L60;
        if (r4.intValue() != 2) goto L60;
        if (r5.length() <= 0) goto L35;
        boolean r7 = true;
    L36:
        if (r7 == false) goto L60;
        if (r6.length() <= 0) goto L40;
        boolean r8 = true;
    L41:
        if (r8 == false) goto L60;
        if (TextUtils.equals(d25.d.d, r6) == false) goto L50;
        if (r12 != null) goto L47;
        r12 = new RouteBean();     // Catch: Exception -> L58
    L47:
        if (r12.n != null) goto L49;
        r12.n = new Bundle();     // Catch: Exception -> L58
    L49:
        r12.n.putBoolean("force_load_same", true);     // Catch: Exception -> L58
    L50:
        Map r13 = r11.d;     // Catch: Exception -> L58
        if (r13 != null) goto L53;
        r13 = new HashMap();     // Catch: Exception -> L58
    L53:
        HashMap r9 = new HashMap(r13);     // Catch: Exception -> L58
        String[] r14 = this.a.getBlackQueries();     // Catch: Exception -> L58
        int r16 = r14.length;     // Catch: Exception -> L58
        int r17 = 0;
    L54:
        if (r17 >= r16) goto L56;
        r9.remove(r14[r17]);     // Catch: Exception -> L58
        r17 = r17 + 1;     // Catch: Exception -> L58
        goto L54
    L56:
        ((h) org.koin.java.a.c(h.class, null, null, 6)).R3(r10, av5.c.b(r5, r9, true), r12);     // Catch: Exception -> L58
        return true;
    L40:
        r8 = false;
        goto L41
    L35:
        r7 = false;
        goto L36
    L24:
        r3 = null;
        goto L25
    L18:
        r5 = null;
        goto L19
    L14:
        r4 = null;
        goto L15
    }
}
