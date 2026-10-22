package xs8;

import android.content.Context;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.CommandWidget;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;

/* JADX INFO: loaded from: classes26.dex */
public final class e extends up8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f565012l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.c f565013m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f565014n;

    public e() {
        this(0);
    }

    @Override // up8.d
    public final boolean a() {
        return false;
    }

    @Override // up8.b
    public int getType() {
        return 0;
    }

    @Override // up8.b
    public final int i() {
        return 5;
    }

    @Override // up8.d
    public final String g() {
        Object r100 = null;
        if (this.f565013m != null) goto L6;
        return null;
    L6:
        if (this.f565014n == true) goto L18;
        return null;
    L18:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        Object r102 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(com.larus.bmhome.actionbar.model.c.Companion.serializer()), this.f565013m));     // Catch: Throwable -> L10
    L13:
        if (Result.m9455isFailureimpl(r102) == true) goto L17;
        r100 = r102;
    L17:
        return (String) r100;
    L10:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public final void s() {
        up8.b r100 = this.f551066f;
        if (r100 == null) goto L12;
        List<up8.b> r101 = r100.f();
        if (r101 == null) goto L12;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        up8.b r103 = (up8.b) r102.next();
        if ((r103 instanceof e) == false) goto L8;
        ((e) r103).f565014n = false;
    L12:
        this.f565014n = true;
    }

    public e(int r100) {
        this.f565012l = -1;
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new CommandWidget(r100);
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
        Object r104 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.c) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.c.Companion.serializer(), r100));     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 != null) goto L37;
        com.larus.bmhome.actionbar.model.c r106 = (com.larus.bmhome.actionbar.model.c) r104;
        if (r106 == null) goto L21;
        this.f565013m = r106;
        String r107 = r106.f295019b;
        if (r107 != null) goto L25;
    L28:
        if (r101 == true) goto L30;
        String r108 = r106.f295021d;
        if (CollectionsKt.contains(CollectionsKt.listOf(new String[]{"sync_calendar", "universal_camera", "send_user_message", "single_file", "paste_url"}), r108) == false) goto L35;
    L35:
        return new a0(Boolean.TRUE, 2);
    L30:
        return new a0(Boolean.FALSE, "display text is empty");
    L25:
        if (r107.length() == 0) goto L28;
        r101 = false;
        goto L28
    L21:
        return new a0(Boolean.FALSE, "parse template result is null");
    L37:
        return new a0(Boolean.FALSE, r105.getMessage());
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new a0(Boolean.FALSE, "text template is empty");
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // up8.b
    public final void p(boolean r100) {
        com.larus.bmhome.actionbar.model.c r101 = this.f565013m;
        if (r101 == null) goto L6;
        r101.f295028k = r100;
        return;
    }

    @Override // up8.b
    public final void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.c) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.c.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        com.larus.bmhome.actionbar.model.c r104 = (com.larus.bmhome.actionbar.model.c) r103;
        if (r104 != null) goto L13;
        return;
    L13:
        this.f565013m = r104;
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
