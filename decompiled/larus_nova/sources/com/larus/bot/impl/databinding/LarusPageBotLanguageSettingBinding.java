package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusPageBotLanguageSettingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f317956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemGroup f317957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NovaTitleBarEx f317958c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317956a;
    }

    public LarusPageBotLanguageSettingBinding(LinearLayout r100, ItemGroup r101, NovaTitleBarEx r102) {
        this.f317956a = r100;
        this.f317957b = r101;
        this.f317958c = r102;
    }
}
