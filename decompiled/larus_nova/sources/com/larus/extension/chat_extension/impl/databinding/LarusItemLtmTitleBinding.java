package com.larus.extension.chat_extension.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common_ui.widget.UrlSpanTextView;

/* JADX INFO: loaded from: classes24.dex */
public final class LarusItemLtmTitleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f342781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemTextToggle f342782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UrlSpanTextView f342783c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f342781a;
    }

    public LarusItemLtmTitleBinding(LinearLayout r100, ItemTextToggle r101, UrlSpanTextView r102) {
        this.f342781a = r100;
        this.f342782b = r101;
        this.f342783c = r102;
    }
}
