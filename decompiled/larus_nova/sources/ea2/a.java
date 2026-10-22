package ea2;

import android.graphics.drawable.Drawable;
import android.text.style.CharacterStyle;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.h5;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements e {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.e
    public final List<CharacterStyle> a(tb2.c r100, Drawable r101) {
        Intrinsics.checkNotNullParameter(r100, "renderPiece");
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r100.getType() == PieceType.IMAGE.getPieceType()) goto L9;
        return null;
    L9:
        if ((r100.getImageValue() instanceof h5) == true) goto L11;
        return null;
    L11:
        ITextPieceImage r102 = r100.getImageValue();
        if (r102 == null) goto L28;
        h5 r103 = (h5) r102;
        ArrayList r104 = new ArrayList();
        int r105 = r103.getTextType();
        if (r105 != 1) goto L16;
        r104.add(new b(r103.getTextContent(), r103.getTextColor(), false, r101));
    L26:
        return r104;
    L16:
        if (r105 != 2) goto L18;
        r104.add(new c(r103.getTextContent(), r103.getTextColor(), r101));
        goto L26
    L18:
        if (r105 != 3) goto L20;
        r104.add(new d(r103.getTextContent(), r103.getTextColor(), r101));
        goto L26
    L20:
        if (r105 != 4) goto L26;
        r104.add(new b(r103.getTextContent(), r103.getTextColor(), true, r101));
        goto L26
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    }
}
