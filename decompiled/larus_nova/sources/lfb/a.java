package lfb;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.ss.android.lark.filedetail.impl.folder.manage.drawable.property.ExtraVideoProperty;
import com.ss.android.lark.widget.span.BorderProperty;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements b {
    public a() {
    }

    @Override // lfb.b
    public final void b(Canvas r100, Path r101, RectF r102, ExtraVideoProperty r103, Rect r104) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r102, "viewRectF");
        Intrinsics.checkNotNullParameter(r103, "videoParams");
        Intrinsics.checkNotNullParameter(r104, "playRect");
        if (r103.f421677f != 1) goto L5;
        float r105 = r102.right;
        float r106 = r103.f421679h;
        float r107 = r105 - r106;
        float r108 = r102.bottom - r106;
        float r109 = r103.f421678g;
        r104.set((int) (r107 - r109), (int) (r108 - r109), (int) r107, (int) r108);
    L6:
        r103.f421680i.setBounds(r104);
        r103.f421680i.draw(r100);
        return;
    L5:
        float r110 = 2;
        int r111 = (int) (r102.width() / r110);
        int r112 = (int) (r102.height() / r110);
        int r113 = (int) (r103.f421678g / r110);
        r104.set(r111 - r113, r112 - r113, r111 + r113, r112 + r113);
        goto L6
    }

    @Override // lfb.b
    public final void a(Canvas r210, Path r211, RectF r212, BorderProperty r310, ExtraVideoProperty r311, RectF r312, Paint r313) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        Intrinsics.checkNotNullParameter(r211, "path");
        Intrinsics.checkNotNullParameter(r212, "viewRectF");
        Intrinsics.checkNotNullParameter(r310, "borderParams");
        Intrinsics.checkNotNullParameter(r311, "videoParams");
        Intrinsics.checkNotNullParameter(r312, "videoBgRectF");
        Intrinsics.checkNotNullParameter(r313, "videoBgPaint");
        float r100 = r311.f421673b;
        if (r100 != 0.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        float r102 = r212.left;
        float r110 = r212.bottom;
        r312.set(r102, r110 - r100, r212.right, r110);
        if (r311.f421674c != 1) goto L11;
        float r111 = r312.left;
        LinearGradient r103 = new LinearGradient(r111, r312.top, r111, r312.bottom, r311.f421675d, r311.f421676e, Shader.TileMode.CLAMP);
    L12:
        r313.setShader(r103);
        r211.reset();
        r211.addRoundRect(r312, r310.getBorderRadiusPx(), r310.getBorderRadiusPx(), Path.Direction.CW);
        r210.drawPath(r211, r313);
        return;
    L11:
        r103 = new LinearGradient(r312.left, r312.top, r312.right, r212.top, r311.f421675d, r311.f421676e, Shader.TileMode.CLAMP);
        goto L12
    L5:
        r101 = false;
        goto L6
    }
}
