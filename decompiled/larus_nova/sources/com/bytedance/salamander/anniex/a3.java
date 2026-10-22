package com.bytedance.salamander.anniex;

import androidx.camera.video.AudioStats;
import com.lynx.tasm.LynxError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a3 implements w2<d5> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.salamander.adapter.e f267935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c5 f267936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y4 f267937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<? super z4, Unit> f267938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<? super Integer, ? super String, Unit> f267939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<? super d5, Unit> f267940f;

    @Override // com.bytedance.salamander.anniex.w2
    public final void a(d5 r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        com.bytedance.salamander.adapter.e r101 = this.f267935a;
        Function2<? super Integer, ? super String, Unit> r102 = null;
        Function1<? super z4, Unit> r103 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lock");
        r101 = null;
    L5:
        r101.a();
        c5 r104 = this.f267936b;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("diskStorage");
        r104 = null;
    L8:
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "data");
        int r105 = com.bytedance.salamander.adapter.r.f267796a;
        RedirectRuleStorage$save$1 r106 = new RedirectRuleStorage$save$1(r100);
        com.bytedance.salamander.adapter.i r107 = com.bytedance.salamander.adapter.i.f267785d;
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type com.bytedance.salamander.adapter.Queue");
        com.bytedance.salamander.adapter.r.a.a(r106, r107, AudioStats.AUDIO_AMPLITUDE_NONE);
        Function1<? super d5, Unit> r108 = this.f267940f;
        if (r108 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("updateCache");
        r108 = null;
    L11:
        r108.invoke(r100);
        com.bytedance.salamander.adapter.e r109 = this.f267935a;
        if (r109 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("lock");
        r109 = null;
    L14:
        r109.b();
        y4 r110 = this.f267937c;
        if (r110 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("info");
        r110 = null;
    L17:
        z4 r111 = r100.a(r110);
        y4 r112 = this.f267937c;
        if (r112 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("info");
        r112 = null;
    L20:
        a5 r113 = r112.f268528f;
        if (r113 == null) goto L23;
        q2 r114 = r113.f267953a;
    L24:
        if (r114 == null) goto L32;
        y4 r115 = this.f267937c;
        if (r115 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("info");
        r115 = null;
    L28:
        a5 r116 = r115.f268528f;
        Intrinsics.checkNotNull(r116);
        q2 r117 = r116.f267953a;
        String r118 = r100.f268026c;
        if (r118 != null) goto L31;
        r118 = "";
    L31:
        r117.getClass();
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        r117.f268309e = r118;
    L32:
        int r119 = r111.f268539b;
        int r120 = x4.f268501d;
        if (r119 != 0) goto L39;
        Function1<? super z4, Unit> r121 = this.f267938d;
        if (r121 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("success");
    L38:
        r103.invoke(r111);
        return;
    L37:
        r103 = r121;
        goto L38
    L39:
        Function2<? super Integer, ? super String, Unit> r122 = this.f267939e;
        if (r122 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("fail");
    L43:
        r102.invoke(Integer.valueOf(r111.f268539b), r111.f268540c);
        return;
    L42:
        r102 = r122;
        goto L43
    L23:
        r114 = null;
        goto L24
    }

    @Override // com.bytedance.salamander.anniex.w2
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        Function2<? super Integer, ? super String, Unit> r101 = this.f267939e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fail");
        r101 = null;
    L5:
        int r102 = x4.f268501d;
        String r103 = r100.getMessage();
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r101.invoke(2, "Gecko CDN request fail, ".concat(r103));
    }

    public a3(com.bytedance.salamander.adapter.e r100, c5 r101, y4 r102, Function1<? super z4, Unit> r103, Function2<? super Integer, ? super String, Unit> r104, Function1<? super d5, Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "lock");
        Intrinsics.checkNotNullParameter(r101, "diskStorage");
        Intrinsics.checkNotNullParameter(r102, "info");
        Intrinsics.checkNotNullParameter(r103, "success");
        Intrinsics.checkNotNullParameter(r104, "fail");
        Intrinsics.checkNotNullParameter(r105, "updateCache");
        this.f267935a = r100;
        this.f267936b = r101;
        this.f267937c = r102;
        this.f267938d = r103;
        this.f267939e = r104;
        this.f267940f = r105;
    }
}
