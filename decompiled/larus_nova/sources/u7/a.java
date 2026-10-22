package u7;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.util.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f549021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f549022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f549023c;

    /* JADX INFO: renamed from: u7.a$a, reason: collision with other inner class name */
    public static final class RunnableC7843a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f549024a;

        public RunnableC7843a(a r100) {
            this.f549024a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f549024a.f549022b.getVisibility() == 8) goto L9;
            this.f549024a.f549022b.setVisibility(8);     // Catch: Throwable -> L6
            return;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f549025a;

        public b(a r100) {
            this.f549025a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f549025a.f549022b.getVisibility() == 0) goto L9;
            this.f549025a.f549022b.setVisibility(0);     // Catch: Throwable -> L6
            return;
        }
    }

    public abstract View b();

    public void c() {
        ThreadUtils.c(new RunnableC7843a(this));
    }

    public void d() {
        ThreadUtils.c(new b(this));
    }

    public View a() {
        View r100 = b();
        this.f549022b.addView(r100);
        this.f549023c = r100;
        return r100;
    }

    public final Context getContext() {
        return this.f549021a;
    }

    public a(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        this.f549021a = r100;
        this.f549022b = r101;
    }
}
