package com.larus.im.internal.audio;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.larus.im.service.audio.a1;
import com.larus.im.service.audio.z0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class q extends a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z0 f347198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f347199b;

    public final int hashCode() {
        return this.f347198a.hashCode();
    }

    @Override // com.larus.im.service.audio.z0
    public final void i() {
        r("onExternalVideoEncoderStarted", null, new l(this));
    }

    @Override // com.larus.im.service.audio.z0
    public final void j() {
        r("onExternalVideoEncoderStopped", null, new j(this));
    }

    @Override // com.larus.im.service.audio.z0
    public final void k() {
        r("onExternalVideoKeyFrameRequested", null, new i(this));
    }

    @Override // com.larus.im.service.audio.z0
    public final void p() {
        r("onRoomTokenWillExpire", "", new n(this));
    }

    @Override // com.larus.im.service.audio.z0
    public final String g() {
        return this.f347199b;
    }

    public q(z0 r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f347198a = r100;
        this.f347199b = r100.g();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof q) == false) goto L7;
        return Intrinsics.areEqual(this.f347198a, ((q) r100).f347198a);
    L7:
        return Intrinsics.areEqual(this.f347198a, r100);
    }

    @Override // com.larus.im.service.audio.z0
    public final void l(final long r100) {
        r("onExternalVideoTargetBitrateUpdated", "targetBitrateBps=" + r100, new h(this, r100));
    }

    @Override // com.larus.im.service.audio.z0
    public final void n(final z0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r100, "event");
        r("onReceiveEvent", r100.toString(), new m(this, r100));
    }

    @Override // com.larus.im.service.audio.z0
    public final void o(final tf9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        Intrinsics.checkNotNullParameter(r100, "frame");
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.f545770d);
        r101.append(Permission.EXECUTE);
        r101.append(r100.f545771e);
        r("onReceiveRemoteEncodedVideoFrame", r101.toString(), new o(this, r100));
    }

    @Override // com.larus.im.service.audio.z0
    public final void m(final byte[] r100, final long r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r100, "data");
        r("onReceiveBinaryData", "messageId: " + r101 + ", size: " + r100.length, new k(this, r100, r101));
    }

    @Override // com.larus.im.service.audio.a1
    public final void q(final String r100, final Object r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r100, "event");
        r("otherEvent", null, new p(this, r100, r101));
    }

    public final void r(String r100, String r101, Function0<Unit> r102) {
        com.larus.im.internal.delegate.c r103 = com.larus.im.internal.delegate.c.f348197a;
        long r104 = r103.elapsedRealtime();
        r102.invoke();
        long r105 = r103.elapsedRealtime() - r104;
        if (r105 <= 5) goto L6;
        fe9.a.f476620a.a("LLMSessionListenerTrace", r100 + " extra: " + r101 + " cost: " + r105 + ", name: " + this.f347199b);
        return;
    }
}
