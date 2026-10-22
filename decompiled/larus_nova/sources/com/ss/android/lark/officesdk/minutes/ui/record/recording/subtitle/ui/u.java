package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.MmSubtitleScrollMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmSubtitleScrollHelper f436535a;

    public u(MmSubtitleScrollHelper r100) {
        this.f436535a = r100;
    }

    public final void a() {
        MmSubtitleScrollHelper r100 = this.f436535a;
        String r101 = r100.f436485h;
        if (r101 != null) goto L5;
        return;
    L5:
        r100.f436485h = null;
        if (r100.f436483f != MmSubtitleScrollMode.FOLLOW) goto L30;
        w r102 = r100.f436481d;
        if (r102.f436541e == true) goto L31;
        Intrinsics.checkNotNullParameter(r101, "source");
        if (r102.f436538b == true) goto L12;
        return;
    L12:
        if (r102.f436541e == true) goto L36;
        boolean r103 = r102.d();
        int r104 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.SUBTITLE, "recheckAfterItemHeightChanged", "full=" + r103 + ", stackFromEnd=" + r102.f436540d + ", source=" + r101, null, 8);
        if (r103 == false) goto L24;
        if (r102.f436540d == true) goto L20;
        r102.f(true, r101);
        return;
    L20:
        if (r102.f436539c.getItemCount() <= 0) goto L37;
        LinearLayoutManager r105 = r102.f436539c;
        r105.scrollToPositionWithOffset(r105.getItemCount() - 1, 0);
        return;
    L37:
        return;
    L24:
        if (r102.f436540d == false) goto L27;
        r102.f436540d = false;
        r102.f436539c.setStackFromEnd(false);
    L27:
        if (r102.f436539c.getItemCount() <= 0) goto L35;
        r102.f436539c.scrollToPositionWithOffset(0, 0);
        return;
    L35:
        return;
    L36:
        return;
    L31:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
