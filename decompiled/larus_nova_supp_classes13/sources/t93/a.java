package t93;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.SoftReference;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static SoftReference<Handler> a;

    /* JADX INFO: renamed from: t93.a$a, reason: collision with other inner class name */
    public final class RunnableC0232a implements Runnable {
        public final /* synthetic */ Function0 a;

        public RunnableC0232a(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final Handler b() {
        SoftReference<Handler> r0 = a;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        Handler r1 = r0.get();
        if (r1 == null) goto L7;
        return r1;
    L7:
        Handler r2 = new Handler(Looper.getMainLooper());
        a = new SoftReference(r2);
        return r2;
    }

    public static final void c(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.invoke();
        return;
    L5:
        b().post(new RunnableC0232a(r2));
    }

    public static final void d(AppCompatTextView r3) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        r3.setTypeface(Typeface.create(r3.getTypeface(), 500, false));
        return;
    }

    public static final View a(View r5, Function1<? super View, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r5, "$this$findViewWithCondition");
        Intrinsics.checkNotNullParameter(r6, "condition");
        if (((Boolean) r6.invoke(r5)).booleanValue() == false) goto L5;
        View r0 = r5;
    L6:
        if (r0 == null) goto L9;
        return r0;
    L9:
        if ((r5 instanceof ViewGroup) == true) goto L11;
        return null;
    L11:
        ViewGroup r7 = (ViewGroup) r5;
        int r1 = r7.getChildCount();
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L25;
        View r3 = r7.getChildAt(r2);
        if (((Boolean) r6.invoke(r3)).booleanValue() == false) goto L16;
        View r4 = r3;
    L17:
        if (r4 != null) goto L18;
        if ((r3 instanceof ViewGroup) == false) goto L24;
        View r8 = a(r3, r6);
        if (r8 == null) goto L24;
        return r8;
    L24:
        r2 = r2 + 1;
        goto L12
    L18:
        return r4;
    L16:
        r4 = null;
        goto L17
    L25:
        return null;
    L5:
        r0 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> e(List<? extends T> r1, int r2, int r3) {
        if (r1.isEmpty() == false) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L22;
        return r1;
    L22:
        int r4 = RangesKt.coerceAtMost(r3, r1.size());     // Catch: Exception -> L16
        if (r2 < 0) goto L15;
        if (r2 > r4) goto L15;
        return r1.subList(r2, r4);
    L15:
        return CollectionsKt.emptyList();
    L16:
        e = move-exception;
        if (HybridAppInfoService.p.isLocalTest() == false) goto L20;
        throw e;
    L20:
        return CollectionsKt.emptyList();
    L5:
        r0 = false;
        goto L6
    }
}
