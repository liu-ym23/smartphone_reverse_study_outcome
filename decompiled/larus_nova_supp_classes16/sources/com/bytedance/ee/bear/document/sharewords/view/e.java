package com.bytedance.ee.bear.document.sharewords.view;

import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements UDCheckBox.c {
    public final /* synthetic */ CCMShareWordsEnhancedView a;

    public e(CCMShareWordsEnhancedView r1) {
        this.a = r1;
    }

    public final void a(UDCheckBox r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "buttonView");
        ForwardClickableEnhancedView.b r4 = this.a.l;
        if (r4 == null) goto L9;
        if (r3 == false) goto L6;
        String r5 = DiagramData$RESULT.SUCCESS;
    L7:
        r4.a(r5);
        return;
    L6:
        r5 = DiagramData$RESULT.FAIL;
        goto L7
    }
}
