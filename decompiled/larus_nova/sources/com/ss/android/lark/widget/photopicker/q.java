package com.ss.android.lark.widget.photopicker;

import android.widget.CompoundButton;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class q implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoPreviewPickerFragment f447553a;

    public q(PhotoPreviewPickerFragment r100) {
        this.f447553a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        this.f447553a.f447441l = r101;
        f.d r102 = f.a();
        List<Photo> r103 = this.f447553a.f447448s;
        r102.y();
        if (this.f447553a.f447441l == false) goto L6;
        jdc.c.a("original_image", "none");
        return;
    }
}
