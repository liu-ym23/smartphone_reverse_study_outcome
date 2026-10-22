package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class n implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f436100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f436101b;

    public n(View r100, Function0<Unit> r101) {
        this.f436100a = r100;
        this.f436101b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f436100a.removeOnLayoutChangeListener(this);
        this.f436101b.invoke();
    }
}
