package ak2;

import com.bytedance.android.livesdkapi.commerce.param.ILivePromotionActionListener;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m implements be.b, ILivePromotionActionListener {
    public final Object a;

    public m(be.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a = r2;
    }

    public final void onClickPromotion(String r3, String r4, String r5, JSONObject r6) {
        Object r0 = this.a;
        if ((r0 instanceof be.b) == false) goto L6;
        ((be.b) r0).onClickPromotion(r3, r4, r5, r6);
        return;
    L6:
        if ((r0 instanceof ILivePromotionActionListener) == false) goto L10;
        ((ILivePromotionActionListener) r0).onClickPromotion(r3, r4, r5, r6);
        return;
    }
}
