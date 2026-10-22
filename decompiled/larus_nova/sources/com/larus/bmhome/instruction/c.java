package com.larus.bmhome.instruction;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f311900a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f311901b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, ReplyOption> f311902c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, ReplyOption> f311903d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Boolean> f311904e = null;

    public c() {
    }

    static {
        f311900a = new c();
        f311901b = LazyKt.lazy(new b());
        f311902c = new LinkedHashMap();
        f311903d = new LinkedHashMap();
        f311904e = new LinkedHashMap();
    }

    public static String b(String r100, int r101) {
        return r100 + '-' + r101 + '-' + com.larus.platform.service.o.f365780a.getUserID();
    }

    @Override // com.larus.bmhome.instruction.i
    public final ReplyOption a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        String r102 = b(r100, r101);
        ReplyOption r103 = (ReplyOption) ((LinkedHashMap) f311902c).get(r102);
        if (r103 != null) goto L8;
        ReplyOption r104 = (ReplyOption) ((LinkedHashMap) f311903d).get(r102);
        if (r104 != null) goto L7;
        Object r105 = com.larus.bmhome.view.actionbar.custom.cache.e.f315871a;
        r104 = com.larus.bmhome.view.actionbar.custom.cache.e.b(ReplyOption.Companion, wa8.t0.f558885a, null, null);
    L7:
        r103 = r104;
    L8:
        Object r106 = com.larus.bmhome.view.actionbar.custom.cache.e.f315871a;
        ReplyOption r107 = com.larus.bmhome.view.actionbar.custom.cache.e.a(r103);
        FLogger.f375446a.d("ActiveSwitchHelper", "isSwitchOpen, status: " + r103 + ", realStatus: " + r107);
        return r107;
    }

    public static void c(String r100, int r101, ReplyOption r102) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        String r103 = b(r100, r101);
        Map<String, ReplyOption> r104 = f311903d;
        if (r102 != null) goto L5;
        Object r105 = com.larus.bmhome.view.actionbar.custom.cache.e.f315871a;
        r102 = com.larus.bmhome.view.actionbar.custom.cache.e.b(ReplyOption.Companion, wa8.t0.f558885a, null, null);
    L5:
        r104.put(r103, r102);
        f311904e.put(r103, Boolean.TRUE);
    }

    public static void d(String r100, ReplyOption r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r101, "status");
        f311902c.put(b(r100, r102), r101);
    }
}
