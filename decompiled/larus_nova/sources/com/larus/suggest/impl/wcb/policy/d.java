package com.larus.suggest.impl.wcb.policy;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f369966a = null;

    static {
        f369966a = new d();
    }

    public d() {
    }

    public final u a(com.larus.suggest.impl.wcb.request.f r100, hx9.l r101, com.larus.suggest.impl.wcb.request.a r102) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "inputStateTracker");
        String r103 = r100.f370118f.f370102d;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "reqSrc");
        int r104 = r103.hashCode();
        if (r104 == (-818885537)) goto L19;
        if (r104 == (-812728331)) goto L16;
        if (r104 == 54220321) goto L10;
    L39:
        String r105 = "";
    L40:
        r102.f370090d = null;
        if (r105.length() <= 0) goto L43;
        boolean r106 = true;
    L44:
        if (r106 == false) goto L48;
        return new u.b(r105);
    L48:
        if (r101.j() == false) goto L52;
        return new u.b("z lottery guide intercept show");
    L52:
        return u.a.f370006a;
    L43:
        r106 = false;
        goto L44
    L10:
        if (r103.equals("app_foreground") == false) goto L39;
        if (r102.f370088b.b() == false) goto L39;
    L24:
        if (r102.f370087a.f() == false) goto L27;
        r105 = "ime is showing";
        goto L40
    L27:
        if (r102.f370087a.k() == false) goto L30;
        r105 = "user is speaking";
        goto L40
    L30:
        if (r102.f370087a.l() == false) goto L33;
        r105 = "bottom menu showing";
        goto L40
    L33:
        if (r102.f370090d == null) goto L39;
        StringBuilder r107 = new StringBuilder("input triggered ");
        fx9.b r108 = r102.f370090d;
        if (r108 == null) goto L37;
        String r109 = r108.f479117a;
    L38:
        r107.append(r109);
        r105 = r107.toString();
        goto L40
    L37:
        r109 = null;
        goto L38
    L16:
        if (r103.equals("enter_chat_cvs_changed") == false) goto L39;
    L21:
        if (r102.f370088b.a() == true) goto L24;
    L19:
        if (r103.equals("enter_chat") == false) goto L39;
        goto L39
    }
}
