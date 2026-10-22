package xb2;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.style.CharacterStyle;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.h5;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.e;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tb2.c;
import wb2.f;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements e {
    public b() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.e
    public final List<CharacterStyle> a(c r100, Drawable r101) {
        Intrinsics.checkNotNullParameter(r100, "renderPiece");
        if (r100.getType() != PieceType.IMAGE.getPieceType()) goto L13;
        ITextPieceImage r102 = r100.getImageValue();
        if ((r102 instanceof h5) == true) goto L8;
        r102 = null;
    L8:
        h5 r103 = (h5) r102;
        if (r103 == null) goto L13;
        if (r103.getTextType() != 5) goto L13;
    L14:
        if (r103 != null) goto L17;
        return null;
    L17:
        if ((r101 instanceof NinePatchDrawable) == true) goto L19;
        r101 = null;
    L19:
        NinePatchDrawable r104 = (NinePatchDrawable) r101;
        if (r104 != null) goto L23;
        return null;
    L23:
        return CollectionsKt.listOf(new f(r104, r103.getTextContent(), r103.getTextColor(), r104.getMinimumHeight() * r103.getTextSizeRate()));
    L13:
        r103 = null;
        goto L14
    }
}
