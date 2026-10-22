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

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SoftReference<Handler> f545077a;

    /* JADX INFO: renamed from: t93.a$a, reason: collision with other inner class name */
    public final class RunnableC7699a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f545078a;

        public RunnableC7699a(Function0 r100) {
            this.f545078a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f545078a.invoke();     // Catch: Throwable -> L4
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
        SoftReference<Handler> r100 = f545077a;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        Handler r101 = r100.get();
        if (r101 == null) goto L7;
        return r101;
    L7:
        Handler r102 = new Handler(Looper.getMainLooper());
        f545077a = new SoftReference(r102);
        return r102;
    }

    public static final void c(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        b().post(new RunnableC7699a(r100));
    }

    public static final void d(AppCompatTextView r100) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        r100.setTypeface(Typeface.create(r100.getTypeface(), 500, false));
        return;
    }

    public static final View a(View r100, Function1<? super View, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$findViewWithCondition");
        Intrinsics.checkNotNullParameter(r101, "condition");
        if (r101.invoke(r100).booleanValue() == false) goto L5;
        View r102 = r100;
    L6:
        if (r102 == null) goto L9;
        return r102;
    L9:
        if ((r100 instanceof ViewGroup) == true) goto L11;
        return null;
    L11:
        ViewGroup r103 = (ViewGroup) r100;
        int r104 = r103.getChildCount();
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L25;
        View r106 = r103.getChildAt(r105);
        if (r101.invoke(r106).booleanValue() == false) goto L16;
        View r107 = r106;
    L17:
        if (r107 != null) goto L18;
        if ((r106 instanceof ViewGroup) == false) goto L24;
        View r108 = a(r106, r101);
        if (r108 == null) goto L24;
        return r108;
    L24:
        r105 = r105 + 1;
        goto L12
    L18:
        return r107;
    L16:
        r107 = null;
        goto L17
    L25:
        return null;
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> e(List<? extends T> r100, int r101, int r102) {
        if (r100.isEmpty() == false) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L22;
        return r100;
    L22:
        int r104 = RangesKt.coerceAtMost(r102, r100.size());     // Catch: Exception -> L16
        if (r101 < 0) goto L15;
        if (r101 > r104) goto L15;
        return r100.subList(r101, r104);
    L15:
        return CollectionsKt.emptyList();
    L16:
        e = move-exception;
        if (HybridAppInfoService.f47545p.isLocalTest() == false) goto L20;
        throw e;
    L20:
        return CollectionsKt.emptyList();
    L5:
        r103 = false;
        goto L6
    }
}
