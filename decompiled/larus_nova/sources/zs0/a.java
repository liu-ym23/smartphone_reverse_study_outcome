package zs0;

import android.widget.TextView;
import com.bytedance.android.live.base.model.user.ProfileText;
import com.bytedance.android.live.base.model.user.ProfileTextPiece;
import com.bytedance.android.live.base.model.user.ProfileTextPieceImage;
import com.bytedance.android.live.base.model.user.ProfileTextPieceString;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements b {
    public a() {
    }

    @Override // zs0.b
    public final void a(TextView r100, ProfileText r101, ProfileTextPiece r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "profileText");
        Intrinsics.checkNotNullParameter(r102, "profileTextPiece");
        ProfileTextPieceString r103 = r102.getStringValue();
        if (r103 == null) goto L5;
        String r104 = r103.getValue();
    L6:
        if (r104 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == true) goto L15;
        r100.setContentDescription(r104);
        return;
    L15:
        return;
    L8:
        if (r104.length() == 0) goto L11;
        r105 = false;
        goto L12
    L5:
        r104 = null;
        goto L6
    }

    @Override // zs0.b
    public final void b(HSImageView r100, ProfileText r101, ProfileTextPiece r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "profileText");
        Intrinsics.checkNotNullParameter(r102, "profileTextPiece");
        ProfileTextPieceImage r103 = r102.getImageValue();
        if (r103 == null) goto L9;
        k r104 = r103.getImageModel();
        if (r104 == null) goto L9;
        k.b r105 = r104.getImageContent();
        if (r105 == null) goto L9;
        String r106 = r105.getAccessibilityText();
    L10:
        if (r106 != null) goto L12;
    L15:
        boolean r107 = true;
    L16:
        if (r107 == true) goto L18;
        r100.setContentDescription(r106);
        return;
    L18:
        r100.setImportantForAccessibility(2);
        return;
    L12:
        if (r106.length() == 0) goto L15;
        r107 = false;
    L9:
        r106 = null;
        goto L10
    }
}
