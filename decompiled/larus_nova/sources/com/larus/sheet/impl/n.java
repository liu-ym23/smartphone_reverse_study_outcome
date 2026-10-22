package com.larus.sheet.impl;

import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.larus.sheet.biz.impl.databinding.LarusLayoutSheetDetailFragmentBinding;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes31.dex */
public final class n implements pw9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetFragment f369037a;

    @Override // pw9.a
    public final void a() {
        this.f369037a.ba0();
        final SheetFragment r100 = this.f369037a;
        LarusLayoutSheetDetailFragmentBinding r101 = (LarusLayoutSheetDetailFragmentBinding) r100.f360439e;
        if (r101 == null) goto L8;
        FrameLayout r102 = r101.f368944f;
        if (r102 == null) goto L9;
        r102.postDelayed(new m(r100), 500);
        return;
    L9:
        return;
    }

    @Override // pw9.a
    public final int b() {
        SheetFragment r100 = this.f369037a;
        int r101 = SheetFragment.R;
        return r100.ha0();
    }

    @Override // pw9.a
    public final int getChatInputHeight() {
        SheetFragment r100 = this.f369037a;
        int r101 = SheetFragment.R;
        return r100.ia0();
    }

    @Override // pw9.a
    public final void requestChatInputFocus() {
        SheetFragment r100 = this.f369037a;
        int r101 = SheetFragment.R;
        LarusLayoutSheetDetailFragmentBinding r102 = (LarusLayoutSheetDetailFragmentBinding) r100.f360439e;
        boolean r103 = false;
        if (r102 == null) goto L9;
        FrameLayout r104 = r102.f368944f;
        if (r104 == null) goto L9;
        if (r104.getVisibility() != 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L24;
        Fragment r106 = this.f369037a.f360440f;
        if (r106 == null) goto L16;
        t1a.b r107 = s1a.a.g(r106);
        if (r107 == null) goto L16;
        va8.o r108 = (va8.o) r107.getAbility(va8.o.class);
    L17:
        if (r108 != null) goto L19;
    L21:
        if (r103 == false) goto L25;
        va8.o.a.a(r108, true);
        r108.i00();
        return;
    L25:
        return;
    L19:
        if (r108.hh() == true) goto L21;
        r103 = true;
    L16:
        r108 = null;
        goto L17
    L24:
        return;
    L9:
        r105 = false;
        goto L10
    }

    public n(SheetFragment r100) {
        this.f369037a = r100;
    }

    @Override // pw9.a
    public final void c(boolean r100) {
        SheetFragment r101 = this.f369037a;
        r101.getClass();
        FLogger.f375446a.i("SheetFragment", "setChatInputVisible() called with: isVisible = " + r100);
        Fragment r102 = r101.f360440f;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.isAdded() == false) goto L9;
        r101.ra0(r100, "setSlidesChatInputVisible");
        return;
    }
}
