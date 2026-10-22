package com.ss.android.lark.widget.halfscreen;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarkPhotoPickerView f445931a;

    public d(LarkPhotoPickerView r100) {
        this.f445931a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f445931a.f(new ArrayList(this.f445931a.f445898n.f447457b), this.f445931a.f445903s);
    }
}
