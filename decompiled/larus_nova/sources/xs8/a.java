package xs8;

import android.content.Context;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.ButtonRouterWidget;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;

/* JADX INFO: loaded from: classes26.dex */
public final class a extends up8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.a f565006l;

    @Override // up8.b
    public int getType() {
        return 16;
    }

    @Override // up8.b
    public final int i() {
        return 7;
    }

    @Override // up8.d
    public final boolean a() {
        com.larus.bmhome.actionbar.model.a r100 = this.f565006l;
        if (r100 == null) goto L28;
        String r101 = null;
        if (r100 == null) goto L7;
        String r102 = r100.f294947b;
    L9:
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L29;
        com.larus.bmhome.actionbar.model.a r104 = this.f565006l;
        if (r104 == null) goto L19;
        r101 = r104.f294948c;
    L19:
        if (r101 != null) goto L21;
    L24:
        boolean r105 = true;
    L25:
        if (r105 == true) goto L30;
        return true;
    L30:
        return false;
    L21:
        if (r101.length() == 0) goto L24;
        r105 = false;
        goto L25
    L29:
        return false;
    L11:
        if (r102.length() == 0) goto L14;
        r103 = false;
        goto L15
    L7:
        r102 = null;
        goto L9
    L28:
        return false;
    }

    @Override // up8.d
    public final String g() {
        com.larus.bmhome.actionbar.model.a r100 = this.f565006l;
        Object r101 = null;
        if (r100 != null) goto L15;
        return null;
    L15:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl(xt7.d.f565073b.a(com.larus.bmhome.actionbar.model.a.Companion.serializer(), r100));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r103) == true) goto L14;
        r101 = r103;
    L14:
        return (String) r101;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public a() {
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ButtonRouterWidget(r100);
    }

    @Override // up8.b
    public final void m(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
        FLogger.f375446a.d("ButtonRouterController", "Restoring button router state by default params: " + r100);
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
        Object r104 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.a) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.a.Companion.serializer(), r100));     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 != null) goto L41;
        com.larus.bmhome.actionbar.model.a r106 = (com.larus.bmhome.actionbar.model.a) r104;
        if (r106 == null) goto L21;
        String r107 = r106.f294947b;
    L22:
        if (r107 != null) goto L24;
    L27:
        boolean r108 = true;
    L28:
        if (r108 == true) goto L40;
        String r109 = r106.f294948c;
        if (r109 != null) goto L32;
    L35:
        if (r101 == true) goto L40;
        this.f565006l = r106;
        FLogger.f375446a.d("ButtonRouterController", "Button router template parsed successfully: " + r106);
        return new a0(Boolean.TRUE, "");
    L32:
        if (r109.length() == 0) goto L35;
        r101 = false;
    L40:
        return new a0(Boolean.FALSE, "ButtonRouter info is required displayText=" + r106.f294947b + " schema=" + r106.f294948c);
    L24:
        if (r107.length() == 0) goto L27;
        r108 = false;
        goto L28
    L21:
        r107 = null;
        goto L22
    L41:
        FLogger.f375446a.e("ButtonRouterController", "Failed to parse button router template: " + r105.getMessage());
        return new a0(Boolean.FALSE, "Failed to parse button router template: " + r105.getMessage());
    L14:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new a0(Boolean.FALSE, "Button router template is empty");
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // up8.b
    public final void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.a) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.a.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        com.larus.bmhome.actionbar.model.a r104 = (com.larus.bmhome.actionbar.model.a) r103;
        if (r104 != null) goto L14;
        FLogger.f375446a.w("ButtonRouterController", "Failed to restore button router state");
        return;
    L14:
        this.f565006l = r104;
        FLogger.f375446a.d("ButtonRouterController", "Button router state restored: " + r104);
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
