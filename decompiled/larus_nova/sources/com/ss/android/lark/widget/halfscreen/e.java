package com.ss.android.lark.widget.halfscreen;

import android.view.View;
import com.obric.trace.ObricActionBarTrackType;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarkPhotoPickerView f445932a;

    public e(LarkPhotoPickerView r100) {
        this.f445932a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        pac.a.b();
        this.f445932a.h(new ArrayList(this.f445932a.f445898n.f447457b), this.f445932a.f445903s, ObricActionBarTrackType.KEY_BOARD);
    }
}
