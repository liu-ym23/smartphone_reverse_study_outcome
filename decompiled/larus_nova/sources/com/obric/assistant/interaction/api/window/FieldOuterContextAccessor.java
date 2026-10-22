package com.obric.assistant.interaction.api.window;

import android.content.Context;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/assistant/interaction/api/window/FieldOuterContextAccessor;", "Lcom/obric/assistant/interaction/api/window/OuterContextAccessor;", "field", "Ljava/lang/reflect/Field;", "<init>", "(Ljava/lang/reflect/Field;)V", "getOuter", "Landroid/content/Context;", "ctx", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FieldOuterContextAccessor implements OuterContextAccessor {
    private final Field field;

    public FieldOuterContextAccessor(Field r100) {
        Intrinsics.checkNotNullParameter(r100, "field");
        this.field = r100;
    }

    @Override // com.obric.assistant.interaction.api.window.OuterContextAccessor
    public Context getOuter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Object r103 = this.field.get(r100);     // Catch: Throwable -> L9
        if ((r103 instanceof Context) == false) goto L6;
        Context r104 = (Context) r103;     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == true) goto L16;
        r101 = r105;
    L16:
        return (Context) r101;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
