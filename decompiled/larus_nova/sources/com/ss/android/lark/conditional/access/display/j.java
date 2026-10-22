package com.ss.android.lark.conditional.access.display;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v7b.b0;
import v7b.n;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class j implements com.ss.android.lark.coremd.base.parse.f {
    public j() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void d(com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void f(com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public static void c(s r100, List r101) {
        if ((r100 instanceof n) == false) goto L6;
        return;
    L6:
        if ((r100 instanceof b0) == false) goto L9;
        ((ArrayList) r101).add(r100);
        return;
    L9:
        s r102 = r100.f553569e;
    L10:
        if (r102 == null) goto L12;
        c(r102, r101);
        r102 = r102.f553572h;
        goto L10
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void a(s r100, Spannable r101) {
        com.ss.android.lark.coremd.base.parse.f.a.b(r100, r101);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void b(com.ss.android.lark.coremd.impl.parse.d r110, s r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "node");
        ArrayList r112 = new ArrayList();
        c(r111, r112);
        Iterator r113 = r112.iterator();
    L4:
        if (r113.hasNext() == false) goto L48;
        b0 r114 = (b0) r113.next();
        String r100 = r114.f553548j;
        Matcher r101 = k.f418068a.matcher(r100);
        b0 r102 = r114;
        boolean r103 = false;
        int r104 = 0;
    L7:
        if (r101.find() == false) goto L42;
        Intrinsics.checkNotNull(r100);
        int r105 = r101.start();
        int r106 = r101.end();
    L10:
        if (r106 <= r105) goto L29;
        int r107 = r106 - 1;
        char r115 = r100.charAt(r107);
        if (r115 == ')') goto L24;
        if (r115 != ',') goto L16;
    L25:
        boolean r116 = true;
    L27:
        if (r116 == false) goto L29;
        r106 = r107;
        goto L10
    L16:
        if (r115 == '.') goto L25;
        if (r115 == ']') goto L21;
    L26:
        r116 = false;
        goto L27
    L21:
        if (e(r100, r105, r106, ']') <= e(r100, r105, r106, '[')) goto L26;
    L24:
        if (e(r100, r105, r106, ')') <= e(r100, r105, r106, '(')) goto L26;
    L29:
        String r108 = r100.substring(r101.start(), r106);
        if (StringsKt.equals(r108, "http://", true) == false) goto L32;
    L35:
        boolean r109 = true;
    L36:
        if (r109 == true) goto L7;
        if (r101.start() <= r104) goto L41;
        b0 r117 = new b0(r100.substring(r104, r101.start()));
        r102.k(r117);
        r102 = r117;
    L41:
        n r118 = new n(r108, r108);
        r102.k(r118);
        r102 = r118;
        r104 = r106;
        r103 = true;
        goto L7
    L32:
        if (StringsKt.equals(r108, "https://", true) == true) goto L35;
        r109 = false;
        goto L36
    L42:
        if (r103 == false) goto L4;
        if (r104 >= r100.length()) goto L47;
        Intrinsics.checkNotNull(r100);
        r102.k(new b0(r100.substring(r104)));
    L47:
        r114.p();
        goto L4
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void g(com.ss.android.lark.coremd.impl.parse.d r100, SpannableStringBuilder r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "charSequence");
    }

    public static int e(String r100, int r101, int r102, char r103) {
        int r104 = 0;
    L3:
        if (r101 >= r102) goto L8;
        if (r100.charAt(r101) != r103) goto L7;
        r104 = r104 + 1;
    L7:
        r101 = r101 + 1;
        goto L3
    L8:
        return r104;
    }
}
