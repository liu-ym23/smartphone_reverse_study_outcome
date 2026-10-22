package defpackage;

import com.bytedance.android.livesdk.gift.model.GiftMsgBoard;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class l0 {
    public static final l a(h2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$comboHint");
        if ((r100 instanceof h1) == true) goto L5;
        r100 = null;
    L5:
        h1 r101 = (h1) r100;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getComboHint();
    }

    public static final GiftMsgBoard b(h2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$giftMsgBoard");
        if ((r100 instanceof h1) == true) goto L5;
        r100 = null;
    L5:
        h1 r101 = (h1) r100;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getGiftMsgBoard();
    }

    public static final List<Long> c(h2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$requiredAssets");
        if ((r100 instanceof h1) == true) goto L5;
        r100 = null;
    L5:
        h1 r101 = (h1) r100;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getRequiredAssets();
    }

    public static final boolean d(h2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isBigGift");
        if (r100.getType() != 2) goto L5;
        return true;
    L5:
        if (r100.getType() != 8) goto L7;
        return true;
    L7:
        if (r100.getType() != 4) goto L9;
        return true;
    L9:
        if (r100.getType() == 13) goto L16;
        return false;
    L16:
        return true;
    }

    public static final boolean e(h2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isFreeDisplay");
        if ((r100 instanceof h1) == true) goto L5;
        r100 = null;
    L5:
        h1 r101 = (h1) r100;
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.isFreeDisplay();
    }
}
