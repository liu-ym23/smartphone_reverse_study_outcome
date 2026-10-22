package dr3;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.window.shop.widget.popup.WindowPopupWindowManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import fr3.a;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class e<E, U extends fr3.a<E>, V extends View> implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<er3.d> f469761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final U f469762b;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f469763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f469764b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f469765c;

        public a(e r100, Context r101, WindowPopupWindowManager.d r102) {
            this.f469763a = r100;
            this.f469764b = r101;
            this.f469765c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            e r101 = this.f469763a;
            Context r102 = this.f469764b;
            Runnable r103 = this.f469765c;
            Iterator<T> r104 = r101.f469761a.iterator();
        L4:
            if (r104.hasNext() == false) goto L12;
            er3.d r105 = (er3.d) r104.next();
            if ((r105 instanceof er3.d.C5805d) == true) goto L7;
            if ((r105 instanceof er3.d.a) == true) goto L10;
            boolean r106 = r105 instanceof er3.d.c;
            goto L4
        L10:
            r103.run();
            goto L4
        L7:
            p.f48130a.openSchema(r102, ((er3.d.C5805d) r105).f473581c);
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
    public e(List<? extends er3.d> r100, U r101) {
        Intrinsics.checkNotNullParameter(r100, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r101, "uiConfig");
        this.f469761a = r100;
        this.f469762b = r101;
    }

    public V d(Context r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "closeDelegate");
        V r102 = (V) b(r100);
        GradientDrawable.Orientation r103 = GradientDrawable.Orientation.TOP_BOTTOM;
        int r104 = this.f469762b.f478583c;
        int r105 = 0;
        GradientDrawable r106 = new GradientDrawable(r103, new int[]{r104, r104});
        fr3.a.C5943a r107 = this.f469762b.f478584d;
        fr3.a.C5943a.f478587f.getClass();
        if ((!Intrinsics.areEqual(r107, fr3.a.C5943a.f478586e)) == false) goto L8;
        float[] r108 = this.f469762b.f478584d.a();
        ArrayList r109 = new ArrayList(8);
    L5:
        if (r105 >= 8) goto L7;
        r109.add(Float.valueOf(q.a(Float.valueOf(r108[r105]))));
        r105 = r105 + 1;
        goto L5
    L7:
        r106.setCornerRadii(CollectionsKt.toFloatArray(r109));
    L8:
        com.bytedance.android.ec.window.base.utils.c.d(r102, r106);
        if (this.f469761a.isEmpty() == true) goto L12;
        r102.setOnClickListener(new a(this, r100, (WindowPopupWindowManager.d) r101));
    L12:
        return r102;
    }
}
