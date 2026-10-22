package xs8;

import android.content.Context;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.InputBoxWidget;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;

/* JADX INFO: loaded from: classes26.dex */
public final class i extends up8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.p f565023l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f565024m;

    @Override // up8.b
    public int getType() {
        return 3;
    }

    @Override // up8.d
    public final boolean a() {
        com.larus.bmhome.actionbar.model.p r100 = this.f565023l;
        if (r100 == null) goto L5;
        boolean r101 = Intrinsics.areEqual(r100.f295362b, Boolean.TRUE);
    L6:
        if (r101 == false) goto L19;
        String r102 = this.f565024m;
        if (r102 != null) goto L10;
    L15:
        boolean r103 = false;
    L16:
        if (r103 == false) goto L20;
        return true;
    L20:
        return false;
    L10:
        if (r102.length() <= 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 != true) goto L15;
        r103 = true;
        goto L16
    L12:
        r104 = false;
        goto L13
    L19:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    @Override // up8.d
    public final String g() {
        Object r100 = null;
        if (this.f565023l != null) goto L15;
        return null;
    L15:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(com.larus.bmhome.actionbar.model.p.Companion.serializer()), this.f565023l));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r102) == true) goto L14;
        r100 = r102;
    L14:
        return (String) r100;
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public i() {
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new InputBoxWidget(r100);
    }

    @Override // up8.b
    public final a0 n(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.p) xt7.d.f565073b.c(kuc.a.d(com.larus.bmhome.actionbar.model.p.Companion.serializer()), r100));     // Catch: Throwable -> L13
    L15:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L20;
        this.f565023l = (com.larus.bmhome.actionbar.model.p) r103;
        return new a0(Boolean.TRUE, "");
    L20:
        return new a0(Boolean.FALSE, r104.getMessage());
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new a0(Boolean.FALSE, "input box is empty template");
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // up8.b
    public final void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.p) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.p.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        com.larus.bmhome.actionbar.model.p r104 = (com.larus.bmhome.actionbar.model.p) r103;
        if (r104 != null) goto L13;
        return;
    L13:
        this.f565023l = r104;
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
