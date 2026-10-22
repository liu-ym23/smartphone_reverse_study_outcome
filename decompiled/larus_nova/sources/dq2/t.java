package dq2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class t extends com.bytedance.android.livesdk.revenue.util.b<qd0.f> {

    public static final class a implements gd0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gq2.c f469651a;

        @Override // gd0.d
        public final void onSuccess() {
            this.f469651a.onSuccess();
        }

        public a(com.bytedance.android.live.revlink.impl.multianchor.connect.a r100) {
            this.f469651a = r100;
        }

        @Override // gd0.d
        public final void onFailed(int r100) {
            this.f469651a.onFailed(r100);
        }
    }

    public final void n() {
        ((qd0.f) this.f157529a).cb();
    }

    public final boolean o() {
        return ((qd0.f) this.f157529a).isRtcEngineOn();
    }

    public t(qd0.f r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        super(r100);
    }

    public final void q(gq2.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        ((qd0.f) this.f157529a).Fh(new a((com.bytedance.android.live.revlink.impl.multianchor.connect.a) r100));
    }
}
