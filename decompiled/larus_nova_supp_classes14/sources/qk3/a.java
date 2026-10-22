package qk3;

import android.net.Uri;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.tabkit.events.SecSettingSource;
import com.bytedance.android.shopping.store.tabkit.events.SecurityMonitorEvent;
import com.bytedance.android.shopping.store.tabkit.model.c0;
import com.bytedance.android.shopping.store.utils.n;
import java.util.Iterator;
import java.util.List;
import jj4.b;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(String r7, List r8, Integer r9) {
        if (r9 != null) goto L6;
    L7:
        if (r9 == null) goto L61;
        String r2 = null;
        Object r3 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        if (r7 == null) goto L47;
        Uri r10 = n.c(r7);
        if (r10 == null) goto L47;
        String r4 = r10.getScheme();
        if (r4 != null) goto L16;
    L17:
        int r5 = hk3.a.a;
        int r6 = p.a;
        Object r11 = Boolean.TRUE;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L22
        b r13 = b.b;     // Catch: Throwable -> L22
        Object r14 = jj4.a.a("ec_tabkit_security_scheme_check", Boolean.class, r11, false);     // Catch: Throwable -> L22
        if (r14 != null) goto L29;
        Intrinsics.throwNpe();     // Catch: Throwable -> L22
    L29:
        if (((Boolean) r14).booleanValue() == true) goto L31;
    L30:
        boolean r15 = true;
    L32:
        if (r15 == true) goto L35;
        r10 = null;
    L35:
        if (r10 == null) goto L47;
        String r16 = r10.getHost();
        if (r16 == null) goto L47;
        if (r8 == null) goto L47;
        Iterator r17 = r8.iterator();
    L41:
        if (r17.hasNext() == false) goto L45;
        Object r18 = r17.next();
        if (StringsKt.endsWith$default(r16, (String) r18, false, 2, null) == false) goto L41;
        r3 = r18;
    L45:
        r2 = (String) r3;
        goto L47
    L31:
        r15 = false;
    L22:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Object r20 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r20) == true) goto L27;
        r11 = r20;
    L27:
        r14 = r11;
        goto L29
    L16:
        if (StringsKt.startsWith$default(r4, "http", false, 2, null) == true) goto L30;
    L47:
        if (k.c(r2) == false) goto L50;
        return 1;
    L50:
        if (r9.intValue() != 2) goto L52;
        return 3;
    L52:
        return 2;
    L61:
        return 1;
    L6:
        if (r9.intValue() != 0) goto L7;
        return 1;
    }

    public static void b(c0 r2, String r3, String r4, Uri r5, String r6) {
        SecurityMonitorEvent r0 = new SecurityMonitorEvent();
        r0.setRuleType(r4);
        r0.setRuleTypeV2(r4);
        r0.setVerifyMode(r2.d());
        r0.setVerifyModeV2(r2.d());
        r0.setVersion(r2.e());
        if (r3 == null) goto L5;
        String r1 = n.b(r3);
    L6:
        r0.setUrl(r1);
        r0.setFullUrl(r3);
        r0.setOriginScheme(r5.toString());
        r0.setBizTag(r6);
        SecSettingSource r7 = r2.b;
        if (r7 == null) goto L10;
        String r8 = r7.getType();
        if (r8 == null) goto L10;
    L11:
        r0.setSettingSource(r8);
        r0.post(null, null);
        return;
    L10:
        r8 = "";
        goto L11
    L5:
        r1 = null;
        goto L6
    }
}
