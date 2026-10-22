package com.larus.asr.session.component;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.larus.asr.VoiceInputType;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class z implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.asr.session.p f287801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceInputType f287802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<f0, Boolean> f287803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<f0, Boolean> f287804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<f0, Unit> f287805e;

    @Override // com.larus.asr.session.component.p0
    public final void b(final b0 r110, final com.larus.asr.session.i r111) {
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r111, BitableAnalytic.SelectSceneClickType.COMPLETE);
        final f0 r100 = r110.getContext();
        final String r101 = r100.f287711m;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        r111.invoke(c0.a.f287687a);
        return;
    L12:
        final AtomicBoolean r103 = new AtomicBoolean(false);
        this.f287801a.Bb(new y(r103, r110, r111, r100, this, r101));
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public /* synthetic */ z(com.larus.asr.session.p r100, Function1 r110, Function1 r111, int r112) {
        Function1 r101 = null;
        if ((r112 & 2) == 0) goto L5;
        VoiceInputType r102 = VoiceInputType.TouchSpeaker;
    L7:
        if ((r112 & 4) == 0) goto L9;
        r110 = new v();
    L9:
        Function1 r103 = r110;
        if ((r112 & 8) == 0) goto L12;
        r101 = new w();
    L12:
        Function1 r104 = r101;
        if ((r112 & 16) == 0) goto L15;
        r111 = new x();
    L15:
        this(r100, r102, r103, r104, r111);
        return;
    L5:
        r102 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public z(com.larus.asr.session.p r100, VoiceInputType r101, Function1<? super f0, Boolean> r102, Function1<? super f0, Boolean> r103, Function1<? super f0, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "sessionContext");
        Intrinsics.checkNotNullParameter(r101, "voiceInputType");
        Intrinsics.checkNotNullParameter(r102, "needVibrateProvider");
        Intrinsics.checkNotNullParameter(r103, "beforeShowSpeaker");
        Intrinsics.checkNotNullParameter(r104, "onPermissionGranted");
        this.f287801a = r100;
        this.f287802b = r101;
        this.f287803c = r102;
        this.f287804d = r103;
        this.f287805e = r104;
    }
}
