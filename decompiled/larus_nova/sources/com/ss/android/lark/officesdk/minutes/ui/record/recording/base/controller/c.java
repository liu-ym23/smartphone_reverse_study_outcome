package com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.CloseReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f436188g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<MmRecordingViewModel> f436189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<MmRecordingUILaunchMode> f436190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<FragmentActivity> f436191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Context> f436192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<CloseReason, Unit> f436193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<String> f436194f;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        e r100 = e.f436896a;
        MmRecordingUILaunchMode r101 = this.f436190b.invoke();
        r100.getClass();
        e.b(r101).getCapability().d();
        return false;
    }

    public final boolean a(boolean r100, Function0<Unit> r101) {
        MmRecordingViewModel r102 = this.f436189a.invoke();
        MmRecordingSession r103 = r102.getSession();
        b();
        boolean r104 = r102.isRecordingActiveForFloat();
        int r105 = bwb.b.f21271a;
        MmUiLogScene r106 = MmUiLogScene.FLOAT;
        StringBuilder r107 = new StringBuilder("skip show, support=false, active=");
        r107.append(r104);
        r107.append(", session=");
        if (r103 == null) goto L5;
        boolean r108 = true;
    L6:
        r107.append(r108);
        bwb.b.f(r106, "handleUserLeaveRecordingPage", r107.toString(), this.f436194f.invoke());
        if (r100 == false) goto L10;
        this.f436193e.invoke(CloseReason.USER_CLOSE);
        return true;
    L10:
        return false;
    L5:
        r108 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function0<MmRecordingViewModel> r100, Function0<? extends MmRecordingUILaunchMode> r101, Function0<? extends FragmentActivity> r102, Function0<? extends Context> r103, Function1<? super CloseReason, Unit> r104, Function0<String> r105) {
        Intrinsics.checkNotNullParameter(r100, "viewModelProvider");
        Intrinsics.checkNotNullParameter(r101, "uiLaunchModeProvider");
        Intrinsics.checkNotNullParameter(r102, "activityProvider");
        Intrinsics.checkNotNullParameter(r103, "contextProvider");
        Intrinsics.checkNotNullParameter(r104, "closePage");
        Intrinsics.checkNotNullParameter(r105, "logDetailProvider");
        this.f436189a = r100;
        this.f436190b = r101;
        this.f436191c = r102;
        this.f436192d = r103;
        this.f436193e = r104;
        this.f436194f = r105;
    }
}
