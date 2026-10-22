package esc;

import android.graphics.Matrix;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Matrix f473829a = null;

    static {
        f473829a = new Matrix();
    }

    public static final void a(Path r100, Path r101, float[] r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$addPath");
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r102, "matrix");
        if ((r100 instanceof AndroidPath) == false) goto L11;
        android.graphics.Path r103 = ((AndroidPath) r100).getInternalPath();
        if ((r101 instanceof AndroidPath) == false) goto L9;
        android.graphics.Path r104 = ((AndroidPath) r101).getInternalPath();
        Matrix r105 = f473829a;
        r105.reset();
        d.b(r105, r102);
        Unit r106 = Unit.INSTANCE;
        r103.addPath(r104, r105);
        AndroidPath_androidKt.asComposePath(r103);
        return;
    L9:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    L11:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }
}
