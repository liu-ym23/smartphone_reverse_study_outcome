package sk0;

import com.bytedance.android.live.pushstream.d;
import hh1.v0;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements ec6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f542314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ji6.a f542315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v0 f542316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d0 f542317d;

    public /* synthetic */ b() {
        throw null;
    }

    @Override // ec6.a
    public final void release() {
        this.f542316c.release();
    }

    @Override // ec6.a
    public final ji6.a o() {
        return this.f542315b;
    }

    @Override // ec6.a
    public final v0 p() {
        return this.f542316c;
    }

    @Override // ec6.a
    public final c r() {
        return this.f542314a;
    }

    @Override // ec6.a
    public final ei6.a q(fi6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return this.f542316c.create();
    }

    public b(v0 r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "liveVideoClientFactory");
        this.f542316c = r100;
        this.f542317d = r101;
        d r102 = r100.getLiveStream();
        if (r101 != null) goto L5;
        r101 = r100.getLiveCore();
    L5:
        if (r102 == null) goto L9;
        if (r101 == null) goto L10;
        this.f542314a = new c(r102);
        this.f542315b = new ji6.a(r101);
        return;
    L10:
        return;
    }
}
