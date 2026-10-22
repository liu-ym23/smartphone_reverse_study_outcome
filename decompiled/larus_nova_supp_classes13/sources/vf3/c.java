package vf3;

import com.bytedance.android.ecom.arch.slice.action.q;
import com.bytedance.android.ecom.arch.slice.action.r;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.kmp.ec.yata.store.node.f;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final a a;
    public final CartViewModel b;
    public final SlcRenderContext c;

    public static final class a implements q {
        public final /* synthetic */ c a;

        /* JADX INFO: renamed from: vf3.c$a$a, reason: collision with other inner class name */
        public static final class RunnableC0236a implements Runnable {
            public final /* synthetic */ a a;
            public final /* synthetic */ r b;

            public RunnableC0236a(a r1, r r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                r r0 = this.b;
                com.bytedance.android.ecom.arch.slice.render.r r1 = r0.c;
                String r2 = null;
                if (r1 == null) goto L5;
                Map r3 = r1.a;
            L6:
                CartViewModel r4 = this.a.a.b;
                Pair[] r5 = new Pair[2];
                r5[0] = TuplesKt.to("trigger", r0.a.getType());
                if (r3 == null) goto L9;
                Object r6 = r3.get("SliceEventPosterKEY");
            L11:
                if ((r6 instanceof f) == true) goto L13;
                r6 = null;
            L13:
                f r7 = (f) r6;
                if (r7 == null) goto L16;
                r2 = r7.getNodeName();
            L16:
                r5[1] = TuplesKt.to("node_name", String.valueOf(r2));
                CartViewModel.doEventAction$default(r4, "yata_cart_click_action", MapsKt.mapOf(r5), null, 4, null);
                return;
            L9:
                r6 = null;
                goto L11
            L5:
                r3 = null;
                goto L6
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(c r1) {
            this.a = r1;
        }

        public final void a(r r4) {
            Intrinsics.checkNotNullParameter(r4, "actionInfo");
            bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
            com.bytedance.android.shopping.new_cart.utils.a.c(this.a.b, "sliceClickCallBack", new RunnableC0236a(this, r4), null);
        }
    }

    public c(CartViewModel r2, SlcRenderContext r3) {
        Intrinsics.checkNotNullParameter(r2, "cartVM");
        this.b = r2;
        this.c = r3;
        this.a = new a(this);
    }
}
