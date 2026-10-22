package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class SearchBarKt$sam$androidx_compose_ui_graphics_ColorProducer$0 implements ColorProducer, FunctionAdapter {
    private final /* synthetic */ Function0 function;

    public SearchBarKt$sam$androidx_compose_ui_graphics_ColorProducer$0(Function0 r1) {
        this.function = r1;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof ColorProducer) == true) goto L5;
        return false;
    L5:
        if ((r3 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
    }

    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    /* JADX INFO: renamed from: invoke-0d7_KjU, reason: not valid java name */
    public final /* synthetic */ long m3072invoke0d7_KjU() {
        return ((Color) this.function.invoke()).unbox-impl();
    }
}
