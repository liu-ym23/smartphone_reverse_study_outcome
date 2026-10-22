package com.ss.android.lark.custom.repeat.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ss.android.lark.ui.CommonTitleBar;

/* JADX INFO: loaded from: classes35.dex */
public final class ActivityChooseRepeatPageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f420296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f420297b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f420296a;
    }

    public ActivityChooseRepeatPageBinding(RelativeLayout r100, RelativeLayout r101, ListView r102, FrameLayout r103, CommonTitleBar r104, TextView r105) {
        this.f420296a = r100;
        this.f420297b = r103;
    }
}
