package com.larus.uaigc.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.ChatConstraintLayout;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusDialogCreationTypeSelectBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatConstraintLayout f373102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f373103b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373102a;
    }

    public LarusDialogCreationTypeSelectBinding(ChatConstraintLayout r100, LinearLayout r101) {
        this.f373102a = r100;
        this.f373103b = r101;
    }
}
