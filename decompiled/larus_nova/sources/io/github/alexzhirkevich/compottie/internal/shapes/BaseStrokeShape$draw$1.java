package io.github.alexzhirkevich.compottie.internal.shapes;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class BaseStrokeShape$draw$1 extends FunctionReferenceImpl implements Function0<Rect> {
    public BaseStrokeShape$draw$1(Object r100) {
        super(0, r100, MutableRectKt.class, "toRect", "toRect(Landroidx/compose/ui/geometry/MutableRect;)Landroidx/compose/ui/geometry/Rect;", 1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Rect invoke() {
        return MutableRectKt.toRect((MutableRect) this.receiver);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Rect invoke() {
        return invoke();
    }
}
