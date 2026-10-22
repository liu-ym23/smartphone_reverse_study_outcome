package com.bytedance.android.window.shop.holder.presenter;

import android.widget.TextView;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends ECWindowHolderBasePresenter {
    public final WindowLayoutType g;

    public a(WindowLayoutType r1) {
        this.g = r1;
    }

    public final void A(QModel r11) {
        String r1 = null;
        if ((r11 instanceof com.bytedance.android.window.shop.repository.tab.entity.o) == true) goto L5;
        r11 = null;
    L5:
        com.bytedance.android.window.shop.repository.tab.entity.o r12 = (com.bytedance.android.window.shop.repository.tab.entity.o) r11;
        if (r12 != null) goto L8;
        return;
    L8:
        WindowLayoutType r0 = this.g;
        String r3 = "";
        if (r0 != null) goto L11;
    L28:
        WindowLayoutType r2 = this.g;
        if (r2 != null) goto L31;
        return;
    L31:
        if (r2.isDoubleColumn() != true) goto L61;
        WindowV2ProductItemVO r4 = r12.k;
        if (r4 == null) goto L39;
        List r5 = r4.e();
        if (r5 == null) goto L39;
        ECRitTag r6 = (ECRitTag) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L39;
        String r7 = r6.getFirstText();
    L40:
        if (r7 != null) goto L43;
        r7 = "";
    L43:
        if ((!StringsKt.isBlank(r7)) == true) goto L46;
        r7 = null;
    L46:
        if (r7 != null) goto L54;
        com.bytedance.android.window.shop.repository.tab.entity.e r13 = r12.j;
        if (r13 == null) goto L55;
        String r14 = r13.d;
        if (r14 == null) goto L55;
        if ((!StringsKt.isBlank(r14)) == false) goto L55;
        r1 = r14;
    L55:
        if (r1 == null) goto L58;
        r3 = r1;
    L58:
        ((TextView) w().b(2131371355).f()).setText(r3);
        return;
    L54:
        r1 = r7;
    L39:
        r7 = null;
        goto L40
    L61:
        return;
    L11:
        if (r0.isSingleColumn() != true) goto L28;
        TextView r8 = (TextView) w().b(2131371355).f();
        com.bytedance.android.window.shop.repository.tab.entity.e r9 = r12.j;
        if (r9 == null) goto L15;
        String r10 = r9.d;
    L16:
        if (r10 != null) goto L18;
        r10 = "";
    L18:
        r8.setText(r10);
        WindowV2ProductItemVO r15 = r12.k;
        TextView r16 = (TextView) w().b(2131387398).f();
        if (r15 != null) goto L21;
        r16.setVisibility(8);
        goto L28
    L21:
        ECRitTag r17 = r15.c(new List[]{r15.e(), r15.d()}, true);
        if (r17 == null) goto L27;
        String r18 = r17.getFirstText();
        if (r18 != null) goto L26;
        r18 = "";
    L26:
        r16.setText(r18);
        r16.setVisibility(0);
        goto L28
    L27:
        r16.setVisibility(8);
        goto L28
    L15:
        r10 = null;
        goto L16
    }
}
