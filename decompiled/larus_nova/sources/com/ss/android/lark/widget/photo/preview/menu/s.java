package com.ss.android.lark.widget.photo.preview.menu;

import android.view.View;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.Statistics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class s implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f447015a;

    public s(q r100) {
        this.f447015a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.ss.android.lark.widget.photopicker.f.a().G();
        q r101 = this.f447015a;
        JSONObject r102 = new JSONObject();
        r101.getClass();
        Statistics.sendEvent("public_picbrowser_click", r102.put("click", "original_image").put(PickerReporterConstants.KEY.TARGET, "public_pic_edit_view"));
        int r103 = com.ss.android.lark.widget.photopicker.utils.e.f447653a;
        if (com.ss.android.lark.widget.photopicker.utils.e.a(r100.getContext(), this.f447015a.f447006a.d()) == true) goto L5;
        return;
    L5:
        this.f447015a.f447006a.d().getPhotoState().getClickLookOrigin().setValue(Boolean.TRUE);
    }
}
