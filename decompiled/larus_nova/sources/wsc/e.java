package wsc;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Spanned;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes41.dex */
public abstract class e {

    public static class a implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f561131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f561132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Rect f561133c;

        /* JADX INFO: renamed from: wsc.e$a$a, reason: collision with other inner class name */
        public class RunnableC8157a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Drawable f561134a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f561135b;

            @Override // java.lang.Runnable
            public final void run() {
                this.f561135b.invalidateDrawable(this.f561134a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC8157a(a r100, Drawable r101) {
                this.f561135b = r100;
                this.f561134a = r101;
            }
        }

        public interface b {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r100) {
            if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
            this.f561131a.post(new RunnableC8157a(this, r100));
            return;
        L6:
            Rect r101 = r100.getBounds();
            if (this.f561133c.equals(r101) == true) goto L9;
            b r102 = (b) this.f561132b;
            r102.f561136a.removeCallbacks(r102);
            r102.f561136a.post(r102);
            this.f561133c = new Rect(r101);
            return;
        L9:
            this.f561131a.invalidate();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r100, Runnable r101) {
            this.f561131a.removeCallbacks(r101);
        }

        public a(TextView r100, b r101, Rect r102) {
            this.f561131a = r100;
            this.f561132b = r101;
            this.f561133c = new Rect(r102);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
            long r103 = r102 - SystemClock.uptimeMillis();
            this.f561131a.postDelayed(r101, r103);
        }
    }

    public static class b implements a.b, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f561136a;

        @Override // java.lang.Runnable
        public final void run() {
            TextView r100 = this.f561136a;     // Catch: Throwable -> L4
            r100.setText(r100.getText());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(TextView r100) {
            this.f561136a = r100;
        }
    }

    public static f[] a(TextView r100) {
        CharSequence r101 = r100.getText();
        if (r101 == null) goto L5;
        int r102 = r101.length();
    L6:
        if (r102 != 0) goto L8;
        return null;
    L8:
        if ((r101 instanceof Spanned) == true) goto L11;
        return null;
    L11:
        return (f[]) ((Spanned) r101).getSpans(0, r102, f.class);
    L5:
        r102 = 0;
        goto L6
    }

    public static void b(TextView r100) {
        if (r100.getTag(R.id.markwon_drawables_scheduler_last_text_hashcode) != null) goto L5;
        return;
    L5:
        r100.setTag(R.id.markwon_drawables_scheduler_last_text_hashcode, null);
        f[] r101 = a(r100);
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.length <= 0) goto L14;
        int r102 = r101.length;
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L15;
        r101[r103].f561138b.c(null);
        r103 = r103 + 1;
        goto L10
    L15:
        return;
    }
}
