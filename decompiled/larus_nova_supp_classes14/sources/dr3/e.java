package dr3;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.window.shop.widget.popup.WindowPopupWindowManager;
import fr3.a;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class e<E, U extends fr3.a<E>, V extends View> implements Disposable {
    public final List<er3.d> a;
    public final U b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ e a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ Runnable c;

        public a(e r1, Context r2, WindowPopupWindowManager.d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            e r6 = this.a;
            Context r0 = this.b;
            Runnable r1 = this.c;
            Iterator<T> r7 = r6.a.iterator();
        L4:
            if (r7.hasNext() == false) goto L12;
            er3.d r2 = (er3.d) r7.next();
            if ((r2 instanceof er3.d.C0119d) == true) goto L7;
            if ((r2 instanceof er3.d.a) == true) goto L10;
            boolean r3 = r2 instanceof er3.d.c;
            goto L4
        L10:
            r1.run();
            goto L4
        L7:
            p.a.openSchema(r0, ((er3.d.C0119d) r2).c);
            goto L4
        }
    }

    public abstract V b(Context r1);

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(List<? extends er3.d> r2, U r3) {
        Intrinsics.checkNotNullParameter(r2, "actions");
        Intrinsics.checkNotNullParameter(r3, "uiConfig");
        this.a = r2;
        this.b = r3;
    }

    public V d(Context r8, Runnable r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "closeDelegate");
        V r0 = (V) b(r8);
        GradientDrawable.Orientation r2 = GradientDrawable.Orientation.TOP_BOTTOM;
        int r4 = this.b.c;
        int r5 = 0;
        GradientDrawable r1 = new GradientDrawable(r2, new int[]{r4, r4});
        fr3.a.C0125a r3 = this.b.d;
        fr3.a.C0125a.f.getClass();
        if ((!Intrinsics.areEqual(r3, fr3.a.C0125a.e)) == false) goto L8;
        float[] r6 = this.b.d.a();
        ArrayList r7 = new ArrayList(8);
    L5:
        if (r5 >= 8) goto L7;
        r7.add(Float.valueOf(q.a(Float.valueOf(r6[r5]))));
        r5 = r5 + 1;
        goto L5
    L7:
        r1.setCornerRadii(CollectionsKt.toFloatArray(r7));
    L8:
        com.bytedance.android.ec.window.base.utils.c.d(r0, r1);
        if (this.a.isEmpty() == true) goto L12;
        r0.setOnClickListener(new a(this, r8, (WindowPopupWindowManager.d) r9));
    L12:
        return r0;
    }
}
