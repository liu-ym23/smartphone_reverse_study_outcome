package com.larus.office.plugins.inputv2.coordinator.document;

import com.larus.office.plugins.inputv2.adapter.g;
import com.larus.utils.logger.FLogger;
import jo9.l;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Boolean, Unit> f362799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f362800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f362801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f362802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f362803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f362804f;

    public static final class a {
    }

    static {
    }

    public final void b() {
        g r100 = this.f362801c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.i() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L16;
        l r101 = (l) r100.g(l.class);
        if (r101 == null) goto L15;
        r101.TX(this.f362804f);
        return;
    L15:
        return;
    }

    public final void a(String r110) {
        if (this.f362802d == true) goto L5;
        return;
    L5:
        g r100 = this.f362801c;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.i() == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L52;
        com.larus.bmhome.chat.component.bottom.reference.a r101 = (com.larus.bmhome.chat.component.bottom.reference.a) r100.f(com.larus.bmhome.chat.component.bottom.reference.a.class);
        l r102 = (l) r100.g(l.class);
        if (r101 == null) goto L50;
        if (r102 == null) goto L53;
        String r103 = this.f362803e;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L41
        boolean r105 = true;
        if (r103 != null) goto L21;
    L24:
        boolean r106 = true;
    L25:
        if (r106 == false) goto L27;
        r101.NR();     // Catch: Throwable -> L41
        r102.mo8561if();     // Catch: Throwable -> L41
        this.f362799a.invoke(Boolean.TRUE);     // Catch: Throwable -> L41
    L39:
        this.f362802d = false;     // Catch: Throwable -> L41
        this.f362803e = null;     // Catch: Throwable -> L41
        this.f362800b.invoke();     // Catch: Throwable -> L41
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L43:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L51;
        r102.mo8561if();
        this.f362802d = false;
        this.f362803e = null;
        FLogger.f375446a.e("OfficeSlides", "应用 Slides 选区失败, from=".concat(r110), r108);
        return;
    L51:
        return;
    L27:
        JSONObject r109 = new JSONObject(r103);     // Catch: Throwable -> L41
        String r111 = r109.optString("text");     // Catch: Throwable -> L41
        Intrinsics.checkNotNull(r111);     // Catch: Throwable -> L41
        if (r111.length() != 0) goto L30;
        boolean r112 = true;
    L31:
        if (r112 == false) goto L33;
        r101.NR();     // Catch: Throwable -> L41
    L34:
        r102.a6(r103);     // Catch: Throwable -> L41
        r102.P(true);     // Catch: Throwable -> L41
        Function1<Boolean, Unit> r113 = this.f362799a;     // Catch: Throwable -> L41
        if (Intrinsics.areEqual(r109.optString("type"), "text") == false) goto L38;
        r105 = false;
    L38:
        r113.invoke(Boolean.valueOf(r105));     // Catch: Throwable -> L41
        goto L39
    L33:
        r101.Dk(r111);     // Catch: Throwable -> L41
        goto L34
    L30:
        r112 = false;
        goto L31
    L21:
        if (r103.length() == 0) goto L24;
        r106 = false;
    L41:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L43
    L53:
        return;
    L50:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function1<? super Boolean, Unit> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onSelectionVisibilityChanged");
        Intrinsics.checkNotNullParameter(r101, "onPanelHeightChanged");
        this.f362799a = r100;
        this.f362800b = r101;
    }
}
