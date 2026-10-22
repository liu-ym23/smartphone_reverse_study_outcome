package com.bytedance.android.livesdk.livecommerce.room.coupon;

import com.bytedance.android.ec.model.response.IconItem;
import com.bytedance.android.ec.model.response.LottieIconData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"checkCartAnimIsValid", "", "icon", "Lcom/bytedance/android/ec/model/response/IconItem;", "invoke"}, k = 3, mv = {1, 4, 3})
public final class EnterRequestHandler$consumeCartIconV2$1 extends Lambda implements Function1<IconItem, Boolean> {
    public static final EnterRequestHandler$consumeCartIconV2$1 INSTANCE = null;

    static {
        INSTANCE = new EnterRequestHandler$consumeCartIconV2$1();
    }

    public EnterRequestHandler$consumeCartIconV2$1() {
        super(1);
    }

    public final boolean invoke(IconItem r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (cg4.a.a(r4.getAnimatedIcon()) == true) goto L11;
        LottieIconData r5 = r4.getLottieIcon();
        if (r5 != null) goto L10;
        return false;
    L10:
        if (r5.isValid() == true) goto L11;
        return false;
    L11:
        return true;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((IconItem) r1));
    }
}
