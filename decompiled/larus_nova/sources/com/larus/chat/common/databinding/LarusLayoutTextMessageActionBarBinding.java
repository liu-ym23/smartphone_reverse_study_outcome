package com.larus.chat.common.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.actionbar.NonPriorityMessageActionBar;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutTextMessageActionBarBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f324038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f324039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f324040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f324041d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f324038a;
    }

    public LarusLayoutTextMessageActionBarBinding(NonPriorityMessageActionBar r100, View r101, LinearLayout r102, LinearLayout r103) {
        this.f324038a = r100;
        this.f324039b = r101;
        this.f324040c = r102;
        this.f324041d = r103;
    }
}
