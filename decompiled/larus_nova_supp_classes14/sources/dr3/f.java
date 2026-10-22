package dr3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.window.shop.widget.popup.WindowPopupWindowManager;
import com.bytedance.android.window.shop.widget.popup.entity.WindowPopupActionType;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends e<fr3.a.d, fr3.a.c, ViewGroup> {
    public static final /* synthetic */ int e = 0;
    public final CompositeDisposable c;
    public final List<e<?, ?, ?>> d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Runnable a;

        public b(WindowPopupWindowManager.d r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            this.a.run();
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
    }

    @Override // dr3.e
    public final void dispose() {
        this.c.dispose();
    }

    @Override // dr3.e
    public final boolean isDisposed() {
        return this.c.isDisposed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dr3.e
    public final View b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        LinearLayout r0 = new LinearLayout(r4);
        r0.setOrientation(0);
        r0.setGravity(16);
        int r1 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r0.setPadding(0, com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(((fr3.a.d) ((fr3.a.c) this.b).e).a)), 0, com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(((fr3.a.d) ((fr3.a.c) this.b).e).a)));
        return r0;
    }

    @Override // dr3.e
    public final /* bridge */ /* synthetic */ View d(Context r1, Runnable r2) {
        return e(r1, r2);
    }

    public final ViewGroup e(Context r6, Runnable r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "closeDelegate");
        ViewGroup r0 = (ViewGroup) super.d(r6, r7);
        Iterator<T> r1 = this.d.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        e r2 = (e) r1.next();
        View r3 = r2.d(r6, r7);
        int r4 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r0.addView(r3, com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(r2.b.a)), com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(r2.b.b)));
        goto L4
    L6:
        Iterator<T> r8 = this.a.iterator();
    L7:
        Object r5 = null;
        if (r8.hasNext() == false) goto L15;
        Object r9 = r8.next();
        if (((er3.d) r9).a != WindowPopupActionType.DELAYED_CLOSE_SELF) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L7;
    L17:
        if ((r9 instanceof er3.d.c) == false) goto L20;
        r5 = r9;
    L20:
        er3.d.c r11 = (er3.d.c) r5;
        if (r11 == null) goto L23;
        this.c.add(bg4.b.b(Observable.timer(r11.c, TimeUnit.MILLISECONDS)).subscribe(new b((WindowPopupWindowManager.d) r7), c.a));
    L23:
        return r0;
    L12:
        r10 = false;
        goto L13
    L15:
        r9 = null;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(List<? extends er3.d> r2, fr3.a.c r3, List<? extends e<?, ?, ?>> r4) {
        Intrinsics.checkNotNullParameter(r2, "actions");
        Intrinsics.checkNotNullParameter(r3, "uiConfig");
        Intrinsics.checkNotNullParameter(r4, "elements");
        super(r2, r3);
        this.d = r4;
        this.c = new CompositeDisposable();
    }
}
