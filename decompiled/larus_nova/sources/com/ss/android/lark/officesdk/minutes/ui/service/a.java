package com.ss.android.lark.officesdk.minutes.ui.service;

import android.app.Activity;
import android.graphics.Point;
import android.view.View;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmBubbleDirection;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements qub.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmRecordingUILaunchMode f436803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ qub.b f436804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ qub.b f436805c;

    @Override // qub.b
    public final qub.a L(Activity r210, rub.a r211) {
        Intrinsics.checkNotNullParameter(r210, "activity");
        Intrinsics.checkNotNullParameter(r211, "config");
        MmRecordingUILaunchMode r100 = this.f436803a;
        View r101 = r211.f539283a;
        String r102 = r211.f539284b;
        CharSequence r103 = r211.f539285c;
        MmBubbleDirection r110 = r211.f539286d;
        boolean r104 = r211.f539287e;
        boolean r111 = r211.f539288f;
        long r112 = r211.f539289g;
        boolean r113 = r211.f539290h;
        Integer r114 = r211.f539291i;
        Integer r115 = r211.f539292j;
        Integer r105 = r211.f539293k;
        Point r106 = r211.f539294l;
        Function0<Unit> r107 = r211.f539295m;
        Function0<Unit> r108 = r211.f539296n;
        Intrinsics.checkNotNullParameter(r101, "anchorView");
        Intrinsics.checkNotNullParameter(r110, "direction");
        Intrinsics.checkNotNullParameter(r100, "uiLaunchMode");
        rub.a r109 = new rub.a(r101, r102, r103, r110, r104, r111, r112, r113, r114, r115, r105, r106, r107, r108, r100);
        int r116 = f.f436814a;
        qub.b r117 = this.f436804b;
        Object r118 = null;
        if (r117 != null) goto L27;
        Activity r119 = r210;
    L21:
        qub.a r120 = (qub.a) r118;
        if (r120 == null) goto L24;
        return r120;
    L24:
        return this.f436805c.L(r119, r109);
    L27:
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L11
        r119 = r210;
        Object r122 = Result.m9449constructorimpl(r117.L(r119, r109));     // Catch: Throwable -> L9
    L14:
        Throwable r123 = Result.m9452exceptionOrNullimpl(r122);
        if (r123 == null) goto L18;
        int r124 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "styleProvider", "host bubble provider failed e=" + r123, null);
    L18:
        if (Result.m9455isFailureimpl(r122) == true) goto L21;
        r118 = r122;
    L9:
        th = th;
    L13:
        Result.Companion r125 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L11:
        th = th;
        r119 = r210;
        goto L13
    }

    public a(MmRecordingUILaunchMode r100, qub.b r101, qub.b r102) {
        this.f436803a = r100;
        this.f436804b = r101;
        this.f436805c = r102;
    }
}
