package xu5;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import bp5.c;
import com.bytedance.ee.util.ui.k;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    public static final class a implements xu5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Activity> f565096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<Fragment> f565097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f565098c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f565099d;

        public final Activity c() {
            return this.f565096a.get();
        }

        @Override // xu5.a
        public final void a() {
            Activity r100 = c();
            if (r100 == null) goto L6;
            Window r101 = r100.getWindow();
            int r102 = k.b(r101).getSystemUiVisibility();
            k.b(r101).setSystemUiVisibility(r102 & (-1025));
            return;
        }

        @Override // xu5.a
        public final void resetState() {
            Activity r100 = c();
            if (r100 == null) goto L11;
            Integer r101 = this.f565098c;
            if (r101 == null) goto L12;
            int r102 = r101.intValue();
            Boolean r103 = this.f565099d;
            if (r103 == null) goto L9;
            c.e(r100, this.f565097b.get(), r102, r103.booleanValue());
            return;
        L9:
            c.d(r100, this.f565097b.get(), r102);
            return;
        L12:
            return;
        }

        @Override // xu5.a
        public final void saveState() {
            Activity r100 = c();
            if (r100 == null) goto L17;
            this.f565098c = Integer.valueOf(WindowInsetsUtils.c(r100).f427737e);
            if (Build.VERSION.SDK_INT < 23) goto L18;
            View r101 = r100.getWindow().getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L12;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L12;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L12:
            if ((r101.getSystemUiVisibility() & 8192) != 8192) goto L14;
            boolean r103 = true;
        L15:
            this.f565099d = Boolean.valueOf(r103);
            return;
        L14:
            r103 = false;
            goto L15
        L18:
            return;
        }

        public a(Activity r100, Fragment r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            this.f565096a = new WeakReference(r100);
            this.f565097b = new WeakReference(r101);
        }

        @Override // xu5.a
        public final void b(int r100, boolean r101) {
            Activity r102 = c();
            if (r102 == null) goto L6;
            c.e(r102, this.f565097b.get(), r100, r101);
            return;
        }

        public final void d(int r100, boolean r101) {
            Activity r102 = c();
            if (r102 == null) goto L6;
            b(r102.getResources().getColor(r100), r101);
            return;
        }
    }

    static {
    }

    @JvmStatic
    public static final a a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return b(r100, null);
    }

    @JvmStatic
    public static final a b(Activity r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return new a(r100, r101);
    }
}
