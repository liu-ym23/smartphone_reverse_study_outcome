package com.larus.sheet.impl;

import androidx.fragment.app.FragmentActivity;
import com.larus.sheet.biz.impl.databinding.LarusLayoutSheetDetailFragmentBinding;
import com.larus.sheet.impl.view.SheetLoadLayout;
import com.larus.sheet.impl.viewmodel.SheetDetailViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class o implements vm9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetFragment f369038a;

    @Override // com.larus.office.base.service.a
    public final Function0<String> getIdGetter() {
        return null;
    }

    @Override // vm9.c
    public final vm9.b getLoadingView() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("getLoadingView loadingView=");
        SheetFragment r102 = this.f369038a;
        int r103 = SheetFragment.R;
        LarusLayoutSheetDetailFragmentBinding r104 = (LarusLayoutSheetDetailFragmentBinding) r102.f360439e;
        if (r104 == null) goto L5;
        SheetLoadLayout r105 = r104.f368945g;
    L6:
        r101.append(r105);
        r100.d("SheetFragment", r101.toString());
        LarusLayoutSheetDetailFragmentBinding r106 = (LarusLayoutSheetDetailFragmentBinding) this.f369038a.f360439e;
        if (r106 != null) goto L9;
        return null;
    L9:
        return r106.f368945g;
    L5:
        r105 = null;
        goto L6
    }

    @Override // vm9.c
    public final void notifyHasReportLoadResultEvent() {
        FLogger.f375446a.d("SheetFragment", "notifyHasReportLoadResultEvent");
        if ((this.f369038a.getActivity() instanceof SheetActivity) == false) goto L8;
        FragmentActivity r100 = this.f369038a.getActivity();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.sheet.impl.SheetActivity");
        SheetDetailViewModel r101 = ((SheetActivity) r100).f368964c;
        if (r101 == null) goto L9;
        r101.setHasReportLaunchResult(true);
        return;
    L9:
        return;
    }

    public o(SheetFragment r100) {
        this.f369038a = r100;
    }

    @Override // vm9.c
    public final void onLoadFailed(int r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("onLoadFailed errorCode=");
        r102.append(r100);
        r102.append(" loadingView=");
        SheetFragment r103 = this.f369038a;
        int r104 = SheetFragment.R;
        LarusLayoutSheetDetailFragmentBinding r105 = (LarusLayoutSheetDetailFragmentBinding) r103.f360439e;
        if (r105 == null) goto L5;
        SheetLoadLayout r106 = r105.f368945g;
    L6:
        r102.append(r106);
        r101.d("SheetFragment", r102.toString());
        if (r100 != (-55)) goto L10;
        this.f369038a.f368978s = true;
        int r107 = nw9.a.f521014b;
        nw9.a.c("delete", Long.valueOf(System.currentTimeMillis() - nw9.a.f521013a), this.f369038a.t9());
        return;
    L10:
        return;
    L5:
        r106 = null;
        goto L6
    }
}
