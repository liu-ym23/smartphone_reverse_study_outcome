package com.larus.minor.impl.view;

import com.larus.common_ui.widget.SeparatedEditText;
import com.larus.minor.impl.viewmodel.MinorPasswordViewModel;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes30.dex */
public final class k implements SeparatedEditText.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MinorPasswordSettingFragment f359267a;

    public k(MinorPasswordSettingFragment r100) {
        this.f359267a = r100;
    }

    @Override // com.larus.common_ui.widget.SeparatedEditText.b
    public final void a(CharSequence r100) {
        FLogger.f375446a.i("MinorPasswordSettingFragment", "textChanged changeText=" + r100);
        MinorPasswordSettingFragment r101 = this.f359267a;
        int r102 = MinorPasswordSettingFragment.f359235k;
        MinorPasswordViewModel r103 = r101.U90();
        if (r103 == null) goto L6;
        r103.updatePassword(String.valueOf(r100));
        return;
    }

    @Override // com.larus.common_ui.widget.SeparatedEditText.b
    public final void b(CharSequence r100) {
        MinorPasswordSettingFragment r101 = this.f359267a;
        int r102 = MinorPasswordSettingFragment.f359235k;
        MinorPasswordViewModel r103 = r101.U90();
        if (r103 == null) goto L6;
        r103.updatePassword(String.valueOf(r100));
        return;
    }
}
