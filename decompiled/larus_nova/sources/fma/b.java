package fma;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.OvalShape;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends OvalShape {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f477889a;

    public final Context getContext() {
        return this.f477889a;
    }

    public b(Context r100) {
        this.f477889a = r100;
    }

    @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public final void draw(Canvas r100, Paint r101) {
        if (r101 == null) goto L5;
        Context r102 = this.f477889a;
        Intrinsics.checkNotNull(r102);
        r101.setColor(ContextCompat.getColor(r102, R.color.ConstTextInverse));
    L5:
        if (r101 == null) goto L8;
        Intrinsics.checkNotNullParameter("#40000000", "<this>");
        r101.setShadowLayer(2.0f, 0.0f, 1.0f, ColorProtector.parseColor("#40000000"));
    L8:
        super.draw(r100, r101);
    }
}
