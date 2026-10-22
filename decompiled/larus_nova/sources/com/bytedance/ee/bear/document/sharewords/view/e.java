package com.bytedance.ee.bear.document.sharewords.view;

import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements UDCheckBox.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CCMShareWordsEnhancedView f221834a;

    public e(CCMShareWordsEnhancedView r100) {
        this.f221834a = r100;
    }

    @Override // com.larksuite.component.universe_design.checkbox.UDCheckBox.c
    public final void a(UDCheckBox r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonView");
        ForwardClickableEnhancedView.b r102 = this.f221834a.f221815l;
        if (r102 == null) goto L9;
        if (r101 == false) goto L6;
        String r103 = "1";
    L7:
        r102.a(r103);
        return;
    L6:
        r103 = "0";
        goto L7
    }
}
