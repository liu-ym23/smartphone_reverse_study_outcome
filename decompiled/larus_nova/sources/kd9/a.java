package kd9;

import com.larus.im.service.audio.e1;
import com.larus.im.service.audio.f1;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements com.larus.im.service.audio.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ff9.t f502857a;

    /* JADX INFO: renamed from: kd9.a$a, reason: collision with other inner class name */
    public static final class C6541a {
    }

    static {
    }

    @Override // com.larus.im.service.audio.y
    public final void q() {
        fe9.j r100 = fe9.i.f476629a;
        fe9.j.a.a(fe9.i.f476629a, "ScreenShareRegisterProcessor", "DefaultRTCScreenShareService.registerScreenShareProcessor", null, 12);
        this.f502857a.q();
    }

    @Override // com.larus.im.service.audio.y
    public final void r() {
        fe9.j r100 = fe9.i.f476629a;
        fe9.j.a.a(fe9.i.f476629a, "ScreenShareExternalCaptureEnable", "DefaultRTCScreenShareService.startScreenWithExternalCapture", null, 12);
        this.f502857a.a();
    }

    public a(ff9.t r100) {
        Intrinsics.checkNotNullParameter(r100, "shareService");
        this.f502857a = r100;
    }

    @Override // com.larus.im.service.audio.y
    public final boolean n(f1 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        fe9.j r101 = fe9.i.f476629a;
        fe9.j.a.a(fe9.i.f476629a, "ScreenShareStartRequest", "DefaultRTCScreenShareService.startScreenShare", MapsKt.mapOf(new Pair[]{TuplesKt.to("encoderWidth", Integer.valueOf(r100.f350750g)), TuplesKt.to("encoderHeight", Integer.valueOf(r100.f350751h)), TuplesKt.to("encoderFrameRate", Integer.valueOf(r100.f350749f)), TuplesKt.to("needCheckToCallMode", Boolean.valueOf(r100.f350752i))}), 4);
        boolean r102 = this.f502857a.n(r100);
        fe9.j.a.a(fe9.i.f476629a, "ScreenShareStartResult", "DefaultRTCScreenShareService.startScreenShare", MapsKt.mapOf(TuplesKt.to("result", Boolean.valueOf(r102))), 4);
        return r102;
    }

    @Override // com.larus.im.service.audio.y
    public final void o(e1 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        fe9.j r101 = fe9.i.f476629a;
        fe9.j.a.a(fe9.i.f476629a, "ScreenShareStop", "DefaultRTCScreenShareService.stopScreenShare", MapsKt.mapOf(TuplesKt.to("needCheckToCallMode", Boolean.valueOf(r100.f350739a))), 4);
        this.f502857a.o(r100);
    }

    @Override // com.larus.im.service.audio.y
    public final void p(tf9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        if (r100.f545784h == false) goto L5;
        fe9.j r101 = fe9.i.f476629a;
        fe9.j.a.a(fe9.i.f476629a, "ScreenShareFirstFrame", "DefaultRTCScreenShareService.pushScreenFrame", MapsKt.mapOf(new Pair[]{TuplesKt.to("width", Integer.valueOf(r100.f545780d)), TuplesKt.to("height", Integer.valueOf(r100.f545781e)), TuplesKt.to("rotation", Integer.valueOf(r100.f545782f)), TuplesKt.to("timeUs", Long.valueOf(r100.f545783g)), TuplesKt.to("textureId", Integer.valueOf(r100.f545778b))}), 4);
    L5:
        this.f502857a.p(r100);
    }

    @Override // com.larus.im.service.audio.y
    public final void s(boolean r100) {
        fe9.j r101 = fe9.i.f476629a;
        fe9.j.a.a(fe9.i.f476629a, "ScreenSharePublishToggle", "DefaultRTCScreenShareService.publishScreenVideo", MapsKt.mapOf(TuplesKt.to("publish", Boolean.FALSE)), 4);
    }
}
