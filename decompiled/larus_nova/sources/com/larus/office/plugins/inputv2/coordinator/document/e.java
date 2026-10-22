package com.larus.office.plugins.inputv2.coordinator.document;

import com.larus.office.OfficeInputParam;
import com.larus.office.plugins.inputv2.adapter.g;
import com.larus.office.plugins.inputv2.k0;
import com.larus.office.plugins.inputv2.l0;
import com.larus.utils.logger.FLogger;
import jo9.i;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<OfficeInputParam> f362788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f362789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f362790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f362791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f362792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f362793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f362794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f362795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f362796i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f362797j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f362798k;

    public static final class a {
    }

    static {
    }

    public final void a(String r110) {
        if (this.f362791d == true) goto L5;
        return;
    L5:
        String r100 = this.f362792e;
        String r101 = this.f362793f;
        Integer r102 = this.f362794g;
        g r103 = this.f362790c;
        boolean r104 = true;
        if (r103 != null) goto L8;
    L10:
        boolean r105 = false;
    L12:
        if (r105 == true) goto L14;
        FLogger.f375446a.i("OfficeSheetSelection", "选区暂未应用, wrapper not-ready, from=" + r110);
    L61:
        boolean r111 = false;
    L62:
        if (r111 == false) goto L67;
        this.f362791d = false;
        this.f362792e = null;
        this.f362793f = null;
        this.f362794g = null;
        return;
    L67:
        return;
    L14:
        com.larus.bmhome.chat.component.bottom.reference.a r106 = (com.larus.bmhome.chat.component.bottom.reference.a) r103.f(com.larus.bmhome.chat.component.bottom.reference.a.class);
        i r107 = (i) r103.g(i.class);
        if (r106 == null) goto L52;
        if (r107 == null) goto L52;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L43
        if (r100 != null) goto L21;
    L24:
        boolean r113 = true;
    L25:
        if (r113 == false) goto L27;
        r106.NR();     // Catch: Throwable -> L43
        r107.mo8561if();     // Catch: Throwable -> L43
        b("apply_empty_selection");     // Catch: Throwable -> L43
    L41:
        this.f362789b.invoke();     // Catch: Throwable -> L43
        Object r108 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L43
    L45:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L48;
        FLogger.f375446a.e("OfficeSheetSelection", "应用选区失败, from=" + r110 + ", version=" + r102, r109);
    L48:
        Boolean r114 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r108) == false) goto L51;
        r108 = r114;
    L51:
        r111 = ((Boolean) r108).booleanValue();
        goto L62
    L27:
        if (r101 != null) goto L29;
        r101 = "";
    L29:
        r107.P(true);     // Catch: Throwable -> L43
        if (r101.length() == 0) goto L33;
        r104 = false;
    L33:
        if (r104 == false) goto L35;
        r106.NR();     // Catch: Throwable -> L43
    L36:
        r107.a6(r100);     // Catch: Throwable -> L43
        this.f362795h = r100;     // Catch: Throwable -> L43
        this.f362796i = r101;     // Catch: Throwable -> L43
        this.f362797j = r102;     // Catch: Throwable -> L43
        OfficeInputParam r115 = this.f362788a.invoke();     // Catch: Throwable -> L43
        if (r115 == null) goto L39;
        String r116 = r115.getResourceId();     // Catch: Throwable -> L43
    L40:
        this.f362798k = r116;     // Catch: Throwable -> L43
        goto L41
    L39:
        r116 = null;
        goto L40
    L35:
        r106.Dk(r101);     // Catch: Throwable -> L43
        goto L36
    L21:
        if (r100.length() == 0) goto L24;
        r113 = false;
    L43:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L52:
        FLogger r118 = FLogger.f375446a;
        StringBuilder r119 = new StringBuilder("选区暂未应用, from=");
        r119.append(r110);
        r119.append(", hasReference=");
        if (r106 == null) goto L55;
        boolean r120 = true;
    L56:
        r119.append(r120);
        r119.append(", hasSheet=");
        if (r107 != null) goto L60;
        r104 = false;
    L60:
        r119.append(r104);
        r119.append(", version=");
        r119.append(r102);
        r118.i("OfficeSheetSelection", r119.toString());
        goto L61
    L55:
        r120 = false;
        goto L56
    L8:
        if (r103.i() != true) goto L10;
        r105 = true;
        goto L12
    }

    public final void b(String r100) {
        if (this.f362795h == null) goto L5;
    L6:
        FLogger.f375446a.i("OfficeSheetSelection", "清理选区重放缓存, reason=" + r100);
    L7:
        this.f362795h = null;
        this.f362796i = null;
        this.f362797j = null;
        this.f362798k = null;
        return;
    L5:
        if (this.f362798k == null) goto L7;
        goto L6
    }

    public e(k0 r100, l0 r101) {
        Intrinsics.checkNotNullParameter(r100, "paramsProvider");
        Intrinsics.checkNotNullParameter(r101, "onPanelHeightChanged");
        this.f362788a = r100;
        this.f362789b = r101;
    }
}
