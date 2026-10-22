package uq5;

import com.bytedance.ee.bear.wikiv2.searchv2.WikiSearchPickerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.panel.WikiTreePanelDialog;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements WikiTreeCtrlView.b {
    public final /* synthetic */ WikiTreePanelDialog a;

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.b
    public final void onUpdate() {
        WikiTreePanelDialog r0 = this.a;
        int r1 = WikiTreePanelDialog.w;
        r0.getClass();
        if (yp5.c.h() == false) goto L29;
        WikiTreeCtrlView r2 = r0.ea0();
        String r3 = null;
        if (r2 == null) goto L8;
        String r4 = r2.getSpaceId();
    L9:
        String r5 = r0.s;
        Intrinsics.checkNotNullParameter(r5, "currentSearchSpaceId");
        if (r4 == null) goto L22;
        boolean r6 = true;
        if (r4.length() <= 0) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == true) goto L17;
    L19:
        r6 = false;
    L20:
        if (r6 == false) goto L22;
        r3 = r4;
        goto L22
    L17:
        if (Intrinsics.areEqual(r4, r5) == true) goto L19;
    L14:
        r7 = false;
    L22:
        if (r3 == null) goto L30;
        r0.s = r3;
        WikiSearchPickerView r8 = r0.r;
        if (r8 == null) goto L28;
        r8.d(r0, r3);
        return;
    L28:
        return;
    L30:
        return;
    L8:
        r4 = null;
        goto L9
    }

    public d(WikiTreePanelDialog r1) {
        this.a = r1;
    }
}
