package pp0;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import yo2.f;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f530160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f530161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f530162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f530163d;

    public static final class a extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f530164a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            f r100 = this.f530164a.f530162c;
            if (r100 == null) goto L6;
            r100.d();
            return;
        }

        public a(b r100) {
            this.f530164a = r100;
            super(3000, 1000);
        }
    }

    public b() {
        this.f530163d = new a(this);
    }
}
