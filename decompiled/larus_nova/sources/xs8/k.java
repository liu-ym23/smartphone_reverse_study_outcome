package xs8;

import android.content.Context;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.ReferenceImageUploadWidget;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;
import wa8.u;

/* JADX INFO: loaded from: classes26.dex */
public final class k extends up8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public u f565027l;

    @Override // up8.d
    public final boolean a() {
        return true;
    }

    @Override // up8.b
    public int getType() {
        return 8;
    }

    @Override // up8.b
    public final int i() {
        return 1;
    }

    @Override // up8.d
    public final String g() {
        Object r100 = null;
        if (this.f565027l != null) goto L15;
        return null;
    L15:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(u.Companion.serializer()), this.f565027l));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r102) == true) goto L13;
        r100 = r102;
    L13:
        String r103 = (String) r100;
        FLogger.f375446a.i("ReferenceImageUploadController", "collectData result is " + r103);
        return r103;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public k() {
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ReferenceImageUploadWidget(r100);
    }

    @Override // up8.b
    public final a0 n(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl((u) xt7.d.f565073b.c(u.Companion.serializer(), r100));     // Catch: Throwable -> L13
    L15:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L20;
        this.f565027l = (u) r103;
        FLogger.f375446a.i("ReferenceImageUploadController", "referenceImageUpload is " + this.f565027l);
        return new a0(Boolean.TRUE, "");
    L20:
        return new a0(Boolean.FALSE, r104.getMessage());
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new a0(Boolean.FALSE, "feature selector is empty template");
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // up8.b
    public final void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((u) xt7.d.f565073b.c(u.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        u r104 = (u) r103;
        if (r104 != null) goto L13;
        return;
    L13:
        wa8.b r105 = r104.f558890a;
        if (r105 == null) goto L18;
        u r106 = this.f565027l;
        if (r106 == null) goto L18;
        r106.f558890a = r105;
    L18:
        wa8.p r107 = r104.f558891b;
        if (r107 == null) goto L26;
        u r108 = this.f565027l;
        if (r108 == null) goto L27;
        r108.f558891b = r107;
        return;
    L27:
        return;
    L26:
        return;
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
