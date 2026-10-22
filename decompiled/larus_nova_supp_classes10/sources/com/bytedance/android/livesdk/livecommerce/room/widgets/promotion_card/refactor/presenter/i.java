package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.facebook.drawee.generic.RoundingParams;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i extends InfoItemAnim<Pair<? extends CharSequence, ? extends String>> {
    public i(Query r2, Query r3) {
        super(r2, r3, 0.5f);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.InfoItemAnim
    public final void a(Pair<? extends CharSequence, ? extends String> r4, Query r5) {
        Pair<? extends CharSequence, ? extends String> r6 = r4;
        Intrinsics.checkNotNullParameter(r5, "query");
        Query r0 = r5.b(2131376316);
        r0.g(8);
        Query r7 = r5.b(2131390781);
        r7.g(8);
        if (r6 == null) goto L7;
        CharSequence r2 = (CharSequence) r6.getFirst();
        if (r2 == null) goto L7;
        r7.g(0);
        r7.e(r2);
    L7:
        if (r6 == null) goto L19;
        String r8 = (String) r6.getSecond();
        if (r8 == null) goto L19;
        if (r8.length() <= 0) goto L13;
        boolean r9 = true;
    L14:
        if (r9 == true) goto L17;
        r8 = null;
    L17:
        if (r8 == null) goto L19;
        r0.g(0);
        ECNetImageView r10 = r0.f();
        r10.getHierarchy().setRoundingParams(RoundingParams.asCircle());
        r10.setImageURI(r8);
        return;
    L13:
        r9 = false;
    L19:
        r0.c();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.InfoItemAnim
    public final boolean b(Pair<? extends CharSequence, ? extends String> r3, Pair<? extends CharSequence, ? extends String> r4) {
        Pair<? extends CharSequence, ? extends String> r5 = r3;
        Pair<? extends CharSequence, ? extends String> r6 = r4;
        if (r5 == null) goto L11;
        if (r6 == null) goto L11;
        if (Intrinsics.areEqual((CharSequence) r5.getFirst(), (CharSequence) r6.getFirst()) == false) goto L11;
        if (Intrinsics.areEqual((String) r5.getSecond(), (String) r6.getSecond()) == false) goto L11;
        return false;
    L11:
        return true;
    }
}
