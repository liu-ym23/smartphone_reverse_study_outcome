package vk6;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f555524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f555525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f555526c;

    public static final class a implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f555527a;

        public a(f r100) {
            this.f555527a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            f r101 = this.f555527a;
            long r102 = r101.f555524a;
            if (r102 <= 0) goto L5;
            r101.f555525b = (r100 - r102) / 1000000;
        L5:
            r101.f555524a = r100;
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public f() {
        this.f555526c = new a(this);
    }
}
