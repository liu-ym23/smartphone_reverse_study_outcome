package com.bytedance.ee.bear.bitable.celleditor.editor.linktag;

import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.bean.ViewStatus;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends com.bytedance.ee.bear.bitable.celleditor.editor.a<LinkTagEditorModel> {
    public c(hr4.a r100, com.bytedance.ee.bear.bitable.celleditor.editor.b r101) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        Intrinsics.checkNotNullParameter(r101, "mActionHandler");
        super(r100, r101, 7);
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.a, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void b(CommonEditorModel r100, String r101) {
        LinkTagEditorModel r102 = (LinkTagEditorModel) r100;
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "originData");
        this.f209345t.f210670b.setTitle(r102.getTitle());
        CellEditDragView r103 = this.f209345t.f210670b;
        Integer r104 = r102.getStatus();
        int r105 = ViewStatus.ERROR.getValue();
        if (r104 != null) goto L6;
    L7:
        boolean r106 = true;
    L9:
        r103.setTitleBarVisible(r106);
        super.b(r102, r101);
        return;
    L6:
        if (r104.intValue() != r105) goto L7;
        r106 = false;
        goto L9
    }
}
