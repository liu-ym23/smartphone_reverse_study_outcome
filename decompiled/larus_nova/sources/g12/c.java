package g12;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.m2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {
    public static final h1 a(m2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getGift");
        b r101 = (b) r100.castToOrNull(b.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getGift();
    }
}
