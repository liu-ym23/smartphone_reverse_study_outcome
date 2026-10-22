package y5;

import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f implements x5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f566193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer[] f566194b;

    @Override // x5.a
    public final void invoke() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl(Integer.valueOf(this.f566194b[0].intValue()));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = 0;
    L10:
        int r102 = ((Number) r101).intValue();
        Object r103 = Result.m9449constructorimpl(Integer.valueOf(this.f566194b[1].intValue()));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r103) == false) goto L18;
        r103 = 0;
    L18:
        int r104 = ((Number) r103).intValue();
        Object r105 = Result.m9449constructorimpl(Integer.valueOf(this.f566194b[2].intValue()));     // Catch: Throwable -> L21
    L24:
        if (Result.m9455isFailureimpl(r105) == false) goto L26;
        r105 = 0;
    L26:
        int r106 = ((Number) r105).intValue();
        Object r107 = Result.m9449constructorimpl(Integer.valueOf(this.f566194b[3].intValue()));     // Catch: Throwable -> L29
    L32:
        if (Result.m9455isFailureimpl(r107) == false) goto L34;
        r107 = 0;
    L34:
        int r108 = ((Number) r107).intValue();
        if (r104 > 0) goto L39;
        if (r108 > 0) goto L39;
        if (r102 > 0) goto L39;
        if (r106 > 0) goto L39;
        return;
    L39:
        ViewGroup.LayoutParams r109 = this.f566193a.getLayoutParams();
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == false) goto L42;
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r109;
    L43:
        if (r110 == null) goto L45;
        r110.leftMargin = r102;
        r110.topMargin = r104;
        r110.rightMargin = r106;
        r110.bottomMargin = r108;
    L45:
        this.f566193a.requestLayout();
        return;
    L42:
        r110 = null;
    L29:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L13:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public f(AppletPopupSchemaParam r100, View r101, Integer[] r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "popupContainer");
        Intrinsics.checkNotNullParameter(r102, GXTemplateKey.FLEXBOX_MARGIN);
        this.f566193a = r101;
        this.f566194b = r102;
    }
}
