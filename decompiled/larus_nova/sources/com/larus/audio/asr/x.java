package com.larus.audio.asr;

import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements com.larus.media.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f288482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f288483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super lk9.g, Unit> f288484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2<? super lk9.g, ? super lk9.g, Unit> f288485d;

    public x(String r100) {
        Intrinsics.checkNotNullParameter("AsrManager", "tag");
        Intrinsics.checkNotNullParameter(r100, "prefix");
        this.f288482a = "AsrManager";
        this.f288483b = r100;
    }

    @Override // com.larus.media.v
    public final boolean b(lk9.g r100) {
        Intrinsics.checkNotNullParameter(r100, "applicant");
        Intrinsics.checkNotNullParameter(r100, "applicant");
        FLogger.f375446a.i(this.f288482a, this.f288483b + " canMixWith. applicant:" + r100 + ", res: true.");
        return true;
    }

    @Override // com.larus.media.v
    public final void e(lk9.g r100) {
        Intrinsics.checkNotNullParameter(r100, "applicant");
        FLogger.f375446a.i(this.f288482a, this.f288483b + " onMediaInterrupted. applicant:" + r100 + '.');
        Function1<? super lk9.g, Unit> r101 = this.f288484c;
        if (r101 == null) goto L6;
        r101.invoke(r100);
        return;
    }

    @Override // com.larus.media.v
    public final void f(MediaResourceManager.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        FLogger.f375446a.i(this.f288482a, this.f288483b + " broadcast. event: " + r100 + '.');
    }

    @Override // com.larus.media.v
    public final void a(lk9.g r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "applicant");
        FLogger.f375446a.i(this.f288482a, this.f288483b + " onMediaResume. applicant:" + r100 + ", volumeFactor: " + r101 + '.');
    }

    @Override // com.larus.media.v
    public final void d(lk9.g r100, lk9.g r101) {
        Intrinsics.checkNotNullParameter(r100, "current");
        Intrinsics.checkNotNullParameter(r101, "applicant");
        FLogger.f375446a.i(this.f288482a, this.f288483b + " onGainOccupied. applicant:" + r101 + ", current: " + r100 + '.');
    }

    @Override // com.larus.media.v
    public final void g(lk9.g r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "applicant");
        FLogger.f375446a.i(this.f288482a, this.f288483b + " onMediaVolumeChange. applicant:" + r100 + ", volumeFactor: " + r101 + '.');
    }

    @Override // com.larus.media.v
    public final void i(lk9.g r100, lk9.g r101) {
        Intrinsics.checkNotNullParameter(r100, "current");
        Intrinsics.checkNotNullParameter(r101, "applicant");
        FLogger.f375446a.i(this.f288482a, this.f288483b + " onMediaPaused. applicant:" + r101 + ", current: " + r100 + '.');
        Function2<? super lk9.g, ? super lk9.g, Unit> r102 = this.f288485d;
        if (r102 == null) goto L6;
        r102.invoke(r100, r101);
        return;
    }

    @Override // com.larus.media.v
    public final MediaOccupyStrategy c(lk9.g r100, lk9.g r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "current");
        Intrinsics.checkNotNullParameter(r101, "applicant");
        MediaOccupyStrategy r103 = com.larus.media.v.a.a(this, r100, r101, r102);
        FLogger.f375446a.i(this.f288482a, this.f288483b + " execOccupiedStrategy. applicant:" + r101 + ", current: " + r100 + ", strategy: " + r103 + '.');
        return r103;
    }

    @Override // com.larus.media.v
    public final MediaOccupyStrategy h(lk9.g r100, lk9.g r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "current");
        Intrinsics.checkNotNullParameter(r101, "applicant");
        MediaOccupyStrategy r103 = com.larus.media.v.a.b(r100, r101);
        boolean r104 = ObricAsrDelegate.f392831b.a();
        FLogger.f375446a.i(this.f288482a, this.f288483b + " gainOccupiedStrategy. applicant:" + r101 + ", current: " + r100 + ", strategy: " + r103 + ", isDefaultAssistant: " + r104);
        return r103;
    }
}
