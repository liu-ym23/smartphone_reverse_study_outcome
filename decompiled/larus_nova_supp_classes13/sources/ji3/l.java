package ji3;

import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.text.SlcTextElementView;
import com.bytedance.android.ecom.arch.slice.render.elements.text.SlcTextElementViewManager;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l extends SlcTextElementViewManager {
    public i T4;
    public long U4;
    public final b V4;

    public static final class a {
    }

    public static final class b implements i.a {
        public final /* synthetic */ l a;

        @Override // ji3.i.a
        public final void onTick() {
            this.a.O1();
        }

        public b(l r1) {
            this.a = r1;
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {
        public final /* synthetic */ l a;
        public final /* synthetic */ SlcTextElementView b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r4) {
            Intrinsics.checkNotNullParameter(r4, "v");
            l r5 = this.a;
            if (r5.T4 != null) goto L5;
            r5.T4 = k.a(this.b);
        L5:
            l r6 = this.a;
            i r0 = r6.T4;
            if (r0 == null) goto L13;
            b r7 = r6.V4;
            Intrinsics.checkNotNullParameter(r7, "listener");
            boolean r1 = r0.d.isEmpty();
            if (r0.d.contains(r7) == true) goto L14;
            r0.d.add(r7);
            if (r1 == false) goto L15;
            r0.a(r0.e);
            return;
        L15:
            return;
        L14:
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            l r4 = this.a;
            i r0 = r4.T4;
            if (r0 == null) goto L6;
            b r5 = r4.V4;
            Intrinsics.checkNotNullParameter(r5, "listener");
            r0.d.remove(r5);
            return;
        }

        public c(l r1, SlcTextElementView r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final void O1() {
        long r0 = this.U4 - SystemClock.elapsedRealtime();
        long r2 = 0;
        if (r0 <= 0) goto L5;
        long r4 = r0 / 60000;
        long r1 = (r0 % 60000) / 1000;
        r2 = r4;
    L6:
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        L1(String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r2), Long.valueOf(r1)}, 2)));
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public l(SlcTemplateContext r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.U4 = SystemClock.elapsedRealtime();
        this.V4 = new b(this);
    }

    public final void H0(Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r8, "props");
        long r0 = com.bytedance.android.ecom.arch.slice.render.util.b.l(r8.get("current_time"), System.currentTimeMillis() / 1000) * 1000;
        long r5 = com.bytedance.android.ecom.arch.slice.render.util.b.l(r8.get("expire"), System.currentTimeMillis() / 1000) * 1000;
        this.U4 = (SystemClock.elapsedRealtime() + r5) - r0;
        O1();
    }

    public final void K1(SlcTextElementView r2) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        super.K1(r2);
        r2.addOnAttachStateChangeListener(new c(this, r2));
    }

    public final /* bridge */ /* synthetic */ void x0(View r1) {
        K1((SlcTextElementView) r1);
    }
}
