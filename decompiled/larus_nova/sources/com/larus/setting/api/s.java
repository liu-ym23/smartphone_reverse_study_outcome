package com.larus.setting.api;

import android.view.View;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class s implements ltb.a<mtb.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f367923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f367924b;

    @Override // ltb.a
    public final void onSuccess(mtb.f r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public s(View r100, boolean r101) {
        this.f367923a = r100;
        this.f367924b = r101;
    }

    @Override // ltb.a
    public final void onError(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        View r102 = this.f367923a;
        if (r102 != null) goto L5;
        return;
    L5:
        if ((r102 instanceof ItemTextToggle) == false) goto L9;
        ((ItemTextToggle) r102).setRestoring(true);
        ((ItemTextToggle) this.f367923a).getToggleView().setChecked(true ^ this.f367924b);
        t19.s.f544207a.g(((ItemTextToggle) this.f367923a).getContext(), R.string.larus_LarkIM_Common_NetworkErrorCheck_Toast, false);
        return;
    }
}
