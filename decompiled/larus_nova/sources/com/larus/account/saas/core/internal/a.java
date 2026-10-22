package com.larus.account.saas.core.internal;

import b48.j;
import b48.l;
import com.larus.account.saas.runtime.internal.util.GsonHolder;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f286235a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, l> f286236b = null;

    public a() {
    }

    static {
        f286235a = new a();
        f286236b = new ConcurrentHashMap();
    }

    public static d48.f.b c() {
        d48.d r100 = c48.a.f22412a;
        d48.d r101 = c48.a.f22412a;
        if (r101 == null) goto L5;
        r101.f();
        return com.larus.init.task.accountsdk.d.f351138b.a("account_saas_user_info");
    L5:
        d48.f.f466833a.getClass();
        d48.f.a r102 = d48.f.a.f466834a;
        Intrinsics.checkNotNullParameter("account_saas_user_info", "repoName");
        return d48.f.a.b.f466835a;
    }

    public static l a(String r100) {
        if (StringsKt.isBlank(r100) == false) goto L6;
        return null;
    L6:
        ConcurrentHashMap<String, l> r101 = f286236b;
        l r102 = r101.get(r100);
        if (r102 == null) goto L9;
        return r102;
    L9:
        Lazy r103 = GsonHolder.f286473a;
        l r104 = (l) GsonHolder.a(c().getString("account_saas_user_info_" + r100), l.class);
        if (r104 == null) goto L16;
        String r105 = r104.f17639b;
        if (r105 == null) goto L16;
        boolean r106 = true;
        if ((!StringsKt.isBlank(r105)) != true) goto L16;
    L17:
        if (r106 == false) goto L19;
        r101.put(r100, r104);
    L19:
        return r104;
    L16:
        r106 = false;
        goto L17
    }

    private final void update(String r100, l r101) {
        String r102 = null;
        if ((!StringsKt.isBlank(r100)) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        String r103 = r101.f17639b;
        if (r103 != null) goto L11;
        return;
    L11:
        if ((!StringsKt.isBlank(r103)) == false) goto L13;
        r102 = r103;
    L13:
        if (r102 == null) goto L21;
        f286236b.put(r100, r101);
        String r104 = "account_saas_user_info_".concat(r100);
        String r105 = GsonHolder.c(r101);
        if (r105 != null) goto L18;
        r105 = "";
    L18:
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.d("AccountInfoStore", "update: " + r104);
        c().putString(r104, r105);
        return;
    }

    public final b48.b b(b48.b r110, l r111) {
        Intrinsics.checkNotNullParameter(r110, "baseInfo");
        if (r110.f17593a == true) goto L5;
        return r110;
    L5:
        if (r111 != null) goto L7;
        r111 = a(r110.f17595c);
    L11:
        Object r100 = null;
        if (r111 == null) goto L14;
        String r101 = r111.f17639b;
    L16:
        if (Intrinsics.areEqual(r101, r110.f17594b) == true) goto L18;
        return r110;
    L18:
        String r102 = r111.f17641d;
        if (r102 != null) goto L21;
        r102 = r110.f17598f;
    L21:
        String r103 = r102;
        String r104 = r111.f17640c;
        if (r104 != null) goto L24;
        r104 = r110.f17599g;
    L24:
        String r105 = r104;
        String[] r106 = new String[3];
        j r112 = r111.f17642e;
        if (r112 == null) goto L27;
        String r107 = r112.f17635c;
    L28:
        r106[0] = r107;
        if (r112 == null) goto L31;
        String r108 = r112.f17634b;
    L32:
        r106[1] = r108;
        if (r112 == null) goto L35;
        String r113 = r112.f17633a;
    L36:
        r106[2] = r113;
        Iterator r114 = SequencesKt.sequenceOf(r106).iterator();
    L38:
        if (r114.hasNext() == false) goto L49;
        Object r109 = r114.next();
        String r115 = (String) r109;
        if (r115 != null) goto L42;
    L45:
        boolean r116 = true;
    L47:
        if ((!r116) == false) goto L38;
        r100 = r109;
        goto L49
    L42:
        if (StringsKt.isBlank(r115) == true) goto L45;
        r116 = false;
    L49:
        String r117 = (String) r100;
        if (r117 != null) goto L52;
        String r118 = r110.f17600h;
    L53:
        boolean r119 = r110.f17593a;
        String r120 = r110.f17594b;
        String r121 = r110.f17595c;
        int r122 = r110.f17596d;
        String r123 = r110.f17597e;
        Intrinsics.checkNotNullParameter(r120, "userId");
        Intrinsics.checkNotNullParameter(r121, "secUserId");
        Intrinsics.checkNotNullParameter(r123, "userMobile");
        Intrinsics.checkNotNullParameter(r103, "userName");
        Intrinsics.checkNotNullParameter(r105, "screeName");
        Intrinsics.checkNotNullParameter(r118, "avatarUrl");
        return new b48.b(r119, r120, r121, r122, r123, r103, r105, r118);
    L52:
        r118 = r117;
        goto L53
    L35:
        r113 = null;
        goto L36
    L31:
        r108 = null;
        goto L32
    L27:
        r107 = null;
        goto L28
    L14:
        r101 = null;
        goto L16
    L7:
        if (Intrinsics.areEqual(r111.f17639b, r110.f17594b) == true) goto L9;
        return r110;
    L9:
        update(r110.f17595c, r111);
        goto L11
    }
}
