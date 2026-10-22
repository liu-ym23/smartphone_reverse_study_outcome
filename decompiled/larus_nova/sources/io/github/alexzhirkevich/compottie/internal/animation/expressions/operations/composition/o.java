package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.composition;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import io.github.alexzhirkevich.compottie.internal.layers.ShapeLayer;
import io.github.alexzhirkevich.compottie.internal.shapes.GroupShape;
import io.github.alexzhirkevich.compottie.internal.shapes.Shape;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class o extends OpShapeContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490865b;

    public o(io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r101) {
        Intrinsics.checkNotNullParameter(r100, "layerOrGroup");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f490864a = r100;
        this.f490865b = r101;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2 r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        Object r103 = this.f490864a.a(r100, r101, r102);
        String r104 = this.f490865b.a(r100, r101, r102).toString();
        if ((r103 instanceof ShapeLayer) == false) goto L6;
        Shape r105 = (Shape) ((Map) ((ShapeLayer) r103).L.getValue()).get(r104);
    L8:
        if (r105 == null) goto L11;
        return r105;
    L11:
        throw new IllegalStateException(("Content '" + r104 + "' wasn't found").toString());
    L6:
        if ((r103 instanceof GroupShape) == false) goto L13;
        r105 = (Shape) ((Map) ((GroupShape) r103).f491460f.getValue()).get(r104);
        goto L8
    L13:
        throw new IllegalStateException(("Can't get '" + r104 + "' content of " + r103).toString());
    }
}
