package xs8;

import android.content.Context;
import com.larus.bmhome.actionbar.model.i0;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.TabSelectorWidget;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;

/* JADX INFO: loaded from: classes26.dex */
public final class n extends up8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public i0 f565033l;

    @Override // up8.d
    public final boolean a() {
        return true;
    }

    @Override // up8.b
    public int getType() {
        return 7;
    }

    @Override // up8.d
    public final String g() {
        i0 r100 = this.f565033l;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<w> r102 = r100.f295197a;
        boolean r103 = false;
        if (r102 == null) goto L19;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r102.iterator();
    L9:
        if (r105.hasNext() == false) goto L20;
        Object r106 = r105.next();
        Integer r107 = ((w) r106).f295528s;
        if (r107 != null) goto L14;
    L16:
        boolean r108 = false;
    L17:
        if (r108 == false) goto L9;
        r104.add(r106);
        goto L9
    L14:
        if (r107.intValue() != 1) goto L16;
        r108 = true;
    L20:
        if (r104 != null) goto L22;
    L23:
        r103 = true;
    L24:
        if (r103 == false) goto L27;
        return null;
    L27:
        if (this.f565033l == null) goto L29;
        i0 r109 = new i0(r104);
    L40:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L32
        Object r111 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(i0.Companion.serializer()), r109));     // Catch: Throwable -> L32
    L35:
        if (Result.m9455isFailureimpl(r111) == true) goto L39;
        r101 = r111;
    L39:
        return (String) r101;
    L32:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L29:
        r109 = null;
        goto L40
    L22:
        if (r104.isEmpty() == false) goto L24;
    L19:
        r104 = null;
        goto L20
    }

    public n() {
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new TabSelectorWidget(r100);
    }

    @Override // up8.b
    public final a0 n(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl((i0) xt7.d.f565073b.c(i0.Companion.serializer(), r100));     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 != null) goto L34;
        i0 r106 = (i0) r104;
        if (r106 == null) goto L21;
        List<w> r107 = r106.f295197a;
    L22:
        List<w> r108 = r107;
        if (r108 != null) goto L25;
    L28:
        if (r101 == true) goto L30;
        this.f565033l = r106;
        return new a0(Boolean.TRUE, "");
    L30:
        return new a0(Boolean.FALSE, "tab option list is empty");
    L25:
        if (r108.isEmpty() == true) goto L28;
        r101 = false;
        goto L28
    L21:
        r107 = null;
        goto L22
    L34:
        return new a0(Boolean.FALSE, r105.getMessage());
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new a0(Boolean.FALSE, "tab selector is empty template");
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // up8.b
    public final void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((i0) xt7.d.f565073b.c(i0.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        i0 r104 = (i0) r103;
        if (r104 != null) goto L13;
        return;
    L13:
        List<w> r105 = r104.f295197a;
        if (r105 == null) goto L29;
        Iterator<T> r106 = r105.iterator();
    L17:
        if (r106.hasNext() == false) goto L44;
        w r107 = (w) r106.next();
        i0 r108 = this.f565033l;
        if (r108 == null) goto L17;
        List<w> r109 = r108.f295197a;
        if (r109 == null) goto L17;
        Iterator<T> r110 = r109.iterator();
    L24:
        if (r110.hasNext() == false) goto L17;
        w r111 = (w) r110.next();
        if (Intrinsics.areEqual(r111.f295510a, r107.f295510a) == true) goto L27;
        r111.f295528s = 0;
        goto L24
    L27:
        r111.f295528s = 1;
        goto L24
    L44:
        return;
    L29:
        return;
    L5:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
