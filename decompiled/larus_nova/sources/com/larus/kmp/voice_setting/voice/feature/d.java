package com.larus.kmp.voice_setting.voice.feature;

import com.larus.im.FlowRuntime;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f353294a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f353295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f353296c = null;

    public d() {
    }

    static {
        f353294a = new d();
        f353295b = "";
        f353296c = LazyKt.lazy(new c());
    }

    public static jh9.c b() {
        int r100 = jh9.d.f499111a;
        String r101 = f353295b;
        String r102 = FlowRuntime.b().h().getUserId();
        gd9.z r103 = (gd9.z) f353296c.getValue();
        String r104 = FlowRuntime.b().h().getUserId();
        Intrinsics.checkNotNullParameter(r104, "userId");
        boolean r105 = r103.c("voice_authorize_" + r104, "UgcVoiceProvider");
        Intrinsics.checkNotNullParameter(r101, "currentKey");
        Intrinsics.checkNotNullParameter(r102, "userId");
        Intrinsics.checkNotNullParameter(r102, "userId");
        String r106 = "voice_authorize_" + r102;
        return new jh9.c(r106, !Intrinsics.areEqual(r106, r101), !r105);
    }

    public static void a(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        FlowRuntime.b().e().i("VoiceListDiag", r100);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void update(boolean r100) {
        jh9.c r101 = b();
        if (r101.f499109b == false) goto L5;
        f353295b = r101.f499108a;
    L5:
        a("[repo:authorize:update] authorized=" + r100 + " keyChanged=" + r101.f499109b);
        ((gd9.z) f353296c.getValue()).i(r101.f499108a, r100, "UgcVoiceProvider");
    }
}
