package xs8;

import android.content.Context;
import com.larus.bmhome.actionbar.model.l0;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.TranslatorWidgetV2;
import com.larus.bmhome.view.actionbar.edit.component.TranslatorWidgetV3;
import com.larus.common.apphost.AppHost;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;

/* JADX INFO: loaded from: classes26.dex */
public final class p extends up8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public l0 f565037l;

    @Override // up8.d
    public final boolean a() {
        return true;
    }

    @Override // up8.b
    public int getType() {
        return 5;
    }

    @Override // up8.d
    public final String g() {
        l0 r100 = this.f565037l;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        com.larus.bmhome.actionbar.model.h r102 = r100.f295275a;
        if (r102 == null) goto L22;
        List<w> r103 = r102.f295167e;
        if (r103 == null) goto L22;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L11:
        if (r105.hasNext() == false) goto L21;
        Object r106 = r105.next();
        Integer r107 = ((w) r106).f295528s;
        if (r107 != null) goto L16;
    L18:
        boolean r108 = false;
    L19:
        if (r108 == false) goto L11;
        r104.add(r106);
        goto L11
    L16:
        if (r107.intValue() != 1) goto L18;
        r108 = true;
        goto L19
    L21:
        ArrayList r110 = r104;
    L23:
        l0 r109 = this.f565037l;
        if (r109 == null) goto L28;
        com.larus.bmhome.actionbar.model.h r111 = r109.f295275a;
        if (r111 == null) goto L28;
        com.larus.bmhome.actionbar.model.h r112 = com.larus.bmhome.actionbar.model.h.a(r111, null, null, null, r110, null, null, 4079);
    L29:
        l0 r113 = this.f565037l;
        if (r113 == null) goto L48;
        com.larus.bmhome.actionbar.model.h r114 = r113.f295276b;
        if (r114 == null) goto L48;
        List<w> r115 = r114.f295167e;
        if (r115 == null) goto L48;
        ArrayList r116 = new ArrayList();
        Iterator<T> r117 = r115.iterator();
    L37:
        if (r117.hasNext() == false) goto L47;
        Object r118 = r117.next();
        Integer r119 = ((w) r118).f295528s;
        if (r119 != null) goto L42;
    L44:
        boolean r120 = false;
    L45:
        if (r120 == false) goto L37;
        r116.add(r118);
        goto L37
    L42:
        if (r119.intValue() != 1) goto L44;
        r120 = true;
        goto L45
    L47:
        ArrayList r121 = r116;
    L49:
        l0 r122 = this.f565037l;
        if (r122 == null) goto L54;
        com.larus.bmhome.actionbar.model.h r123 = r122.f295276b;
        if (r123 == null) goto L54;
        com.larus.bmhome.actionbar.model.h r124 = com.larus.bmhome.actionbar.model.h.a(r123, null, null, null, r121, null, null, 4079);
    L55:
        l0 r125 = this.f565037l;
        if (r125 == null) goto L58;
        l0 r126 = l0.d(r125, r112, r124, null, 28);
    L69:
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L61
        Object r128 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(l0.Companion.serializer()), r126));     // Catch: Throwable -> L61
    L64:
        if (Result.m9455isFailureimpl(r128) == true) goto L68;
        r101 = r128;
    L68:
        return (String) r101;
    L61:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L64
    L58:
        r126 = null;
    L54:
        r124 = null;
    L48:
        r121 = null;
    L28:
        r112 = null;
    L22:
        r110 = null;
        goto L23
    }

    public p() {
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (AppHost.f326268a.isOversea() == false) goto L6;
        return new TranslatorWidgetV2(r100);
    L6:
        return new TranslatorWidgetV3(r100);
    }

    @Override // up8.b
    public final a0 n(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl((l0) xt7.d.f565073b.c(l0.Companion.serializer(), r100));     // Catch: Throwable -> L13
    L15:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L31;
        l0 r105 = (l0) r103;
        com.larus.bmhome.actionbar.model.h r106 = null;
        if (r105 == null) goto L20;
        com.larus.bmhome.actionbar.model.h r107 = r105.f295275a;
    L21:
        if (r107 == null) goto L29;
        if (r105 == null) goto L24;
        r106 = r105.f295276b;
    L24:
        if (r106 == null) goto L29;
        this.f565037l = r105;
        return new a0(Boolean.TRUE, "");
    L29:
        return new a0(Boolean.FALSE, "translator source or target is null");
    L20:
        r107 = null;
        goto L21
    L31:
        return new a0(Boolean.FALSE, r104.getMessage());
    L13:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new a0(Boolean.FALSE, "translator is empty template");
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // up8.b
    public final void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((l0) xt7.d.f565073b.c(l0.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        l0 r104 = (l0) r103;
        if (r104 != null) goto L13;
        return;
    L13:
        com.larus.bmhome.actionbar.model.h r105 = r104.f295275a;
        if (r105 == null) goto L32;
        List<w> r106 = r105.f295167e;
        if (r106 == null) goto L32;
        w r107 = (w) CollectionsKt.firstOrNull(r106);
        if (r107 == null) goto L32;
        l0 r108 = this.f565037l;
        if (r108 == null) goto L32;
        com.larus.bmhome.actionbar.model.h r109 = r108.f295275a;
        if (r109 == null) goto L32;
        List<w> r110 = r109.f295167e;
        if (r110 == null) goto L32;
        Iterator<T> r111 = r110.iterator();
    L27:
        if (r111.hasNext() == false) goto L32;
        w r112 = (w) r111.next();
        if (Intrinsics.areEqual(r112.f295510a, r107.f295510a) == true) goto L30;
        r112.f295528s = 0;
        goto L27
    L30:
        r112.f295528s = 1;
    L32:
        com.larus.bmhome.actionbar.model.h r113 = r104.f295276b;
        if (r113 == null) goto L51;
        List<w> r114 = r113.f295167e;
        if (r114 == null) goto L66;
        w r115 = (w) CollectionsKt.firstOrNull(r114);
        if (r115 == null) goto L67;
        l0 r116 = this.f565037l;
        if (r116 == null) goto L68;
        com.larus.bmhome.actionbar.model.h r117 = r116.f295276b;
        if (r117 == null) goto L69;
        List<w> r118 = r117.f295167e;
        if (r118 == null) goto L70;
        Iterator<T> r119 = r118.iterator();
    L46:
        if (r119.hasNext() == false) goto L71;
        w r120 = (w) r119.next();
        if (Intrinsics.areEqual(r120.f295510a, r115.f295510a) == true) goto L49;
        r120.f295528s = 0;
        goto L46
    L49:
        r120.f295528s = 1;
        goto L46
    L71:
        return;
    L70:
        return;
    L69:
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L51:
        return;
    L5:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
