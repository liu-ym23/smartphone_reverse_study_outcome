package uzb;

import android.os.SystemClock;
import android.view.View;
import com.ss.android.lark.passport.base.core.log.PassportLog;

/* JADX INFO: loaded from: classes37.dex */
public final class m {

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View.OnClickListener f552256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f552257b;

        public a(View.OnClickListener r100) {
            this.f552257b = 0;
            this.f552256a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = SystemClock.elapsedRealtime();
            PassportLog.d("ViewUtil", "click time -> " + r101 + " lastTime -> " + this.f552257b);
            if ((r101 - this.f552257b) <= 500) goto L8;
            PassportLog.d("ViewUtil", " click vaild " + (r101 - this.f552257b));
            this.f552257b = r101;
            View.OnClickListener r102 = this.f552256a;
            if (r102 == null) goto L9;
            r102.onClick(r100);
            return;
        L9:
            return;
        }
    }

    public static void a(View r100, View.OnClickListener r101) {
        if (r100 == null) goto L5;
        r100.setOnClickListener(new a(r101));
        return;
    }
}
