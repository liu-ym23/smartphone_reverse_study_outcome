package ru5;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.OrientationEventListener;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes19.dex */
public final class j extends OrientationEventListener implements ru5.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f539266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f539267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ru5.b f539268c;

    public interface a {
        void a(d r100);
    }

    public static class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ru5.b f539269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<j> f539270b;

        public b(j r100) {
            this.f539269a = i.a.f539265a;
            this.f539270b = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            j r101 = this.f539270b.get();
            if (r101 != null) goto L5;
            return;
        L5:
            ru5.b r102 = this.f539269a;
            r101.f539268c = r102;
            if ((r102 instanceof d) == false) goto L9;
            r101.f539267b.a((d) r102);
            return;
        }
    }

    public final void a(ru5.b r100) {
        if (this.f539266a.hasMessages(1) == false) goto L5;
        this.f539266a.f539269a = r100;
        return;
    L5:
        b r101 = this.f539266a;
        r101.f539269a = r100;
        r101.sendEmptyMessageDelayed(1, 300);
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int r100) {
        if (r100 != (-1)) goto L5;
        this.f539266a.removeMessages(1);
    L5:
        this.f539268c.b(this, r100);
    }

    public j(Context r100, a r101) {
        super(r100, 2);
        this.f539266a = new b(this);
        this.f539267b = r101;
        this.f539268c = i.a.f539265a;
    }
}
