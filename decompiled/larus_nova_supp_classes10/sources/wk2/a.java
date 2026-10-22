package wk2;

import ak2.q;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.g;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPublicBottomScreenProduct;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import vi2.h;
import vi2.k0;
import xi2.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends ak2.c implements q {
    public View a;
    public final Context b;
    public final ECContext c;
    public final com.bytedance.android.livesdk.livecommerce.room.api.e d;

    /* JADX INFO: renamed from: wk2.a$a, reason: collision with other inner class name */
    public static final class C0185a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            a0 r7 = (a0) r6;
            if (((g) r7).statusCode == 0) goto L5;
            this.a.getClass();
            return;
        L5:
            a r0 = this.a;
            r0.getClass();
            ECPublicBottomScreenProduct r8 = r7.a();
            if (r8 == null) goto L33;
            View r1 = th.a.d(r0.b, 2131560779, null, 6);
            r0.a = r1;
            if (r1 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("realView");
        L11:
            y.d(r1.findViewById(2131376506), r8.getCover());
            View r2 = r0.a;
            if (r2 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("realView");
        L14:
            y.d(r2.findViewById(2131376684), r8.getIcon());
            View r3 = r0.a;
            if (r3 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("realView");
        L17:
            TextView r4 = (TextView) r3.findViewById(2131391606);
            String r5 = r8.getTitle();
            String r9 = "";
            if (r5 != null) goto L20;
            r5 = "";
        L20:
            r4.setText(r5);
            View r10 = r0.a;
            if (r10 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("realView");
        L23:
            TextView r11 = (TextView) r10.findViewById(2131391524);
            String r12 = r8.getSubTitle();
            if (r12 == null) goto L27;
            r9 = r12;
        L27:
            r11.setText(r9);
            View r13 = r0.a;
            if (r13 != null) goto L30;
            Intrinsics.throwUninitializedPropertyAccessException("realView");
        L30:
            r13.setOnClickListener(new wk2.b(r0, r8));
            r0.d.O(r0);
            new e("livesdk_video_product_comment_show", r8.getProductId()).k();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ECExceptionMonitor.e((Throwable) r1);
            this.a.getClass();
        }
    }

    static {
    }

    public final void onViewAttached(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
    }

    public final void onViewWillAttach(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
    }

    public final View getView() {
        View r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("realView");
    L5:
        return r0;
    }

    public final void onLoad() {
        String r0 = h.a;
        bk2.c.a(h.e(null, null, si2.g.Q, new k0()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this)), (bk2.d) this.c.getDisposableContext().getValue());
    }

    public final Context getContext() {
        return this.b;
    }

    public a(Context r2, ECContext r3, com.bytedance.android.livesdk.livecommerce.room.api.e r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "ecContext");
        Intrinsics.checkNotNullParameter(r4, "handler");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
