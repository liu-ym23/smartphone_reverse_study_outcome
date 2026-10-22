package com.ss.android.lark.officesdk.minutes.ui.record.recording.language;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingLanguageSettingView extends FrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f436369g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingViewModel f436370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmRecordingUILaunchMode f436371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f436372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MmRecordingLanguageChooseView f436373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MmRecordingSpokenLanguageView f436374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MmRecordingTranslateLanguageView f436375f;

    public final void a() {
        MmRecordingLanguageChooseView r100 = this.f436373d;
        if (r100 != null) goto L5;
        r100 = new MmRecordingLanguageChooseView(getContext(), this.f436370a, this.f436371b, this.f436372c, new MmRecordingLanguageSettingView$showChoosePage$1(this), new MmRecordingLanguageSettingView$showChoosePage$2(this));
        this.f436373d = r100;
    L5:
        b(r100);
    }

    public final void b(View r100) {
        if (r100.getParent() != null) goto L5;
        addView(r100, new FrameLayout.LayoutParams(-1, -2));
    L5:
        int r101 = getChildCount();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L12;
        View r103 = getChildAt(r102);
        if (Intrinsics.areEqual(r103, r100) == false) goto L10;
        int r104 = 0;
    L11:
        r103.setVisibility(r104);
        r102 = r102 + 1;
        goto L6
    L10:
        r104 = 8;
        goto L11
    }

    public MmRecordingLanguageSettingView(Context r100, MmRecordingViewModel r101, MmRecordingUILaunchMode r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        Intrinsics.checkNotNullParameter(r102, "uiLaunchMode");
        super(r100, null);
        this.f436370a = r101;
        this.f436371b = r102;
        this.f436372c = r103;
        a();
    }
}
