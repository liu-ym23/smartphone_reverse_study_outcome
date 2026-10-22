package rn;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ec.store.window.popup.ShopPopupWindowManager;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tn.a;

/* JADX INFO: loaded from: classes44.dex */
public abstract class c<E, U extends tn.a<E>, V extends View> implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<sn.d> f538636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final U f538637b;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f538638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f538639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f538640c;

        public a(c r100, Context r101, ShopPopupWindowManager.d r102) {
            this.f538638a = r100;
            this.f538639b = r101;
            this.f538640c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            c r101 = this.f538638a;
            Context r102 = this.f538639b;
            Runnable r103 = this.f538640c;
            Iterator<T> r104 = r101.f538636a.iterator();
        L4:
            if (r104.hasNext() == false) goto L12;
            sn.d r105 = (sn.d) r104.next();
            if ((r105 instanceof sn.d.C7629d) == true) goto L7;
            if ((r105 instanceof sn.d.a) == true) goto L10;
            boolean r106 = r105 instanceof sn.d.c;
            goto L4
        L10:
            r103.run();
            goto L4
        L7:
            p r107 = p.f48130a;
            ((sn.d.C7629d) r105).getClass();
            r107.openSchema(r102, null);
            goto L4
        }
    }

    public abstract V b(Context r100);

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends sn.d> r100, U r101) {
        Intrinsics.checkNotNullParameter(r100, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r101, "uiConfig");
        this.f538636a = r100;
        this.f538637b = r101;
    }

    public V d(Context r110, Runnable r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "closeDelegate");
        V r100 = (V) b(r110);
        GradientDrawable.Orientation r101 = GradientDrawable.Orientation.TOP_BOTTOM;
        int r102 = this.f538637b.f546837c;
        int r103 = 0;
        GradientDrawable r104 = new GradientDrawable(r101, new int[]{r102, r102});
        if ((!Intrinsics.areEqual(this.f538637b.f546838d, tn.a.C7744a.f546840e)) == false) goto L8;
        tn.a.C7744a r105 = this.f538637b.f546838d;
        float r106 = r105.f546841a;
        float r107 = r105.f546842b;
        float r108 = r105.f546843c;
        float r109 = r105.f546844d;
        float[] r112 = {r106, r106, r107, r107, r108, r108, r109, r109};
        ArrayList r113 = new ArrayList(8);
    L5:
        if (r103 >= 8) goto L7;
        r113.add(Float.valueOf(q.a(Float.valueOf(r112[r103]))));
        r103 = r103 + 1;
        goto L5
    L7:
        r104.setCornerRadii(CollectionsKt.toFloatArray(r113));
    L8:
        qc3.a.e(r100, r104);
        if (this.f538636a.isEmpty() == true) goto L12;
        r100.setOnClickListener(new a(this, r110, (ShopPopupWindowManager.d) r111));
    L12:
        return r100;
    }
}
