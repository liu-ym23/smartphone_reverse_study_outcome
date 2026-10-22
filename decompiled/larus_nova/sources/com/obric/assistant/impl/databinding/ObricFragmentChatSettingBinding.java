package com.obric.assistant.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextView;
import com.obric.assistant.common.ui.item.ObricItemTextArrowSubTitle;

/* JADX INFO: loaded from: classes33.dex */
public final class ObricFragmentChatSettingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f389490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemGroup f389491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ItemGroup f389492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ItemTextArrow f389493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ItemTextView f389494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ObricItemTextArrowSubTitle f389495f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f389490a;
    }

    public ObricFragmentChatSettingBinding(LinearLayout r100, ItemGroup r101, ItemGroup r102, ItemTextArrow r103, ItemTextView r104, ObricItemTextArrowSubTitle r105) {
        this.f389490a = r100;
        this.f389491b = r101;
        this.f389492c = r102;
        this.f389493d = r103;
        this.f389494e = r104;
        this.f389495f = r105;
    }
}
