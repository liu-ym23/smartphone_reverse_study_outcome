package com.bytedance.ee.bear.sheet.exportimage.preview;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SheetImagePreviewFragment f237581c;

    public a(SheetImagePreviewFragment r100) {
        this.f237581c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        ImagePreviewViewModel r101 = this.f237581c.f237534f;
        if (r101 == null) goto L5;
        r101.onClose();
    L5:
        HashMap r102 = new HashMap();
        r102.put("click", "close");
        r102.put(PickerReporterConstants.KEY.TARGET, "none");
        qm5.b.b("ccm_space_docs_topbar_click", r102);
    }
}
