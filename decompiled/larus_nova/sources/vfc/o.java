package vfc;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larksuite.component.ui.dialog.LKUIDialog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes38.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f554656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LKUIDialog f554657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f554658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f554659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f554660e;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<o> f554661a;

        public a(o r100) {
            this.f554661a = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            o r101 = this.f554661a.get();
            if (r101 != null) goto L6;
            return;
        L6:
            if (r100.what != 1) goto L12;
            k r102 = new k(r101);
            if (Looper.myLooper() != Looper.getMainLooper()) goto L10;
            r102.run();
            return;
        L10:
            new Handler(Looper.getMainLooper()).post(r102);
            return;
        }
    }

    public o(Context r100) {
        this.f554660e = new a(this);
        this.f554656a = r100;
    }

    public static boolean a(Context r100) {
        if ((r100 instanceof Activity) == false) goto L9;
        Activity r101 = (Activity) r100;
        if (r101.isFinishing() == true) goto L9;
        if (r101.isDestroyed() == true) goto L9;
        return true;
    L9:
        return false;
    }
}
