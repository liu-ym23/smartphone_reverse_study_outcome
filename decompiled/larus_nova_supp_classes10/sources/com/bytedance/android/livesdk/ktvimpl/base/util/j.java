package com.bytedance.android.livesdk.ktvimpl.base.util;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.liveinteract.plantform.utils.h0;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.RegionList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j {
    public static final String a = null;
    public static final String b = null;
    public static final int c = 0;
    public static final long d = 0;
    public static final Integer e = null;
    public static final String f = null;
    public static final boolean g = false;
    public static final boolean h = false;
    public static final HashSet<String> i = null;
    public static final HashSet<String> j = null;
    public static boolean k;
    public static final j l = null;

    public j() {
    }

    static {
        l = new j();
        Boolean r0 = (Boolean) LiveInfraSettingKeys.LIVE_KTV_FAKE_XIGUA_COPYRIGHT.getValue();
        a = "KTVCopyrightUtils";
        b = "UNLIMITED";
        c = -100;
        d = 1128;
        if (r0.booleanValue() == false) goto L5;
        Integer r1 = 247160;
    L9:
        e = r1;
        String r2 = h0.b;
        f = r2;
        if (r0.booleanValue() == true) goto L22;
        Integer r3 = (Integer) LiveInfraSettingKeys.LIVE_KTV_CHECK_COPYRIGHT_OPTION.getValue();
        boolean r4 = false;
        if (r3 != null) goto L15;
    L17:
        if (r3 == null) goto L20;
        r3.intValue();
    L20:
        boolean r5 = true;
    L21:
        if (r5 == true) goto L22;
    L23:
        g = r4;
        boolean r6 = !h0.a.booleanValue();
        h = r6;
        i = new HashSet();
        j = new HashSet();
        String r7 = "init: needCheckAppCopyright: " + r4 + ", needCheckRegionCopyright: " + r6 + ", region: " + r2;
        ALogger.i(bb0.b.b(), "KTVCopyrightUtils :" + r7 + ", invoke class :" + j.class.getSimpleName());
        return;
    L15:
        if (r3.intValue() != 0) goto L17;
        r5 = false;
    L22:
        r4 = true;
        goto L23
    L5:
        IMiddleWareHostContext r8 = jc1.k.f(IMiddleWareHostContext.class);
        if (r8 == null) goto L8;
        r1 = Integer.valueOf(r8.appId());
        goto L9
    L8:
        r1 = null;
        goto L9
    }

    public static boolean i() {
        if (g == false) goto L5;
    L8:
        return true;
    L5:
        if (h == true) goto L8;
        return false;
    }

    public static boolean a() {
        if (i() == true) goto L5;
    L7:
        return false;
    L5:
        if (k == false) goto L7;
        return true;
    }

    public static boolean c(com.bytedance.android.livesdk.ktvimpl.base.sei.k r2) {
        if (r2 != null) goto L6;
        return !i();
    L6:
        return f(r2.e(), r2.f(), String.valueOf(r2.j()));
    }

    public static boolean d(KtvMusic r6) {
        if (r6 == null) goto L4;
        String r0 = String.valueOf(r6.getMId());
        List r1 = r6.getCopyrightedAppIds();
        List r2 = null;
        if (r1 == null) goto L11;
        List r3 = r1;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L12;
        r4.add(Integer.valueOf((int) ((Number) r5.next()).longValue()));
    L12:
        Map r7 = r6.getGlobalCopyrightRegionInfo();
        if (r7 == null) goto L18;
        RegionList r8 = (RegionList) r7.get(Long.valueOf(d));
        if (r8 == null) goto L18;
        r2 = r8.getValues();
    L18:
        return f(r4, r2, r0);
    L11:
        r4 = null;
        goto L12
    L4:
        return !i();
    }

    public static boolean e(Long r7) {
        boolean r1 = true;
        if (i() == true) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L23:
        return false;
    L8:
        if (r7.longValue() == 0) goto L23;
        if (g == false) goto L13;
        boolean r2 = b(null, String.valueOf(r7.longValue()));
    L15:
        if (h == false) goto L24;
        if (r2 == true) goto L18;
    L20:
        r1 = false;
    L22:
        return r1;
    L18:
        if (g(null, String.valueOf(r7.longValue())) == false) goto L20;
    L24:
        return r2;
    L13:
        r2 = true;
        goto L15
    }

    public static void h(View r1) {
        if (i() == false) goto L7;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
        return;
    L8:
        return;
    }

    public static boolean j(KtvContext r2) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        if (k == false) goto L6;
        return false;
    L6:
        if (com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.e(r2) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static void k(com.bytedance.android.livesdk.ktvimpl.base.sei.a r1) {
        Intrinsics.checkNotNullParameter(r1, "model");
        if (i() == true) goto L6;
        return;
    L6:
        if ((r1 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L11;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r2 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r1;
        if (c(r2) == true) goto L12;
        r2.M();
        r2.L();
        r2.N();
        return;
    L12:
        return;
    }

    public static boolean b(List r3, String r4) {
        List r0 = r3;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return i.contains(r4);
    L13:
        if (r3.contains(Integer.valueOf(c)) == false) goto L15;
    L18:
        i.add(r4);
        return true;
    L15:
        if (CollectionsKt.contains(r3, e) == true) goto L18;
        return false;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static boolean g(List r3, String r4) {
        List r0 = r3;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return j.contains(r4);
    L13:
        if (r3.contains(b) == false) goto L15;
    L18:
        j.add(r4);
        return true;
    L15:
        if (r3.contains(f) == true) goto L18;
        return false;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static boolean f(List r2, List r3, String r4) {
        boolean r1 = true;
        if (i() == true) goto L6;
        return true;
    L6:
        if (g == false) goto L8;
        boolean r5 = b(r2, r4);
    L10:
        if (h == false) goto L18;
        if (r5 == true) goto L13;
    L15:
        r1 = false;
    L17:
        return r1;
    L13:
        if (g(r3, r4) == false) goto L15;
    L18:
        return r5;
    L8:
        r5 = true;
        goto L10
    }
}
