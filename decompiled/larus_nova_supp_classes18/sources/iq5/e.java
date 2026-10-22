package iq5;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.create.g0;
import com.bytedance.ee.bear.list.create.y0;
import com.bytedance.ee.bear.list.t0;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements FlowableOnSubscribe {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ d b;
    public final /* synthetic */ boolean c;

    public static final class a implements gp5.a.InterfaceC0236a {
        public final /* synthetic */ d a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ FlowableEmitter<DocumentCreateInfo> c;

        /* JADX INFO: renamed from: iq5.e$a$a, reason: collision with other inner class name */
        public static final class C0249a<T> implements Consumer {
            public final /* synthetic */ FlowableEmitter<DocumentCreateInfo> a;

            public C0249a(FlowableEmitter<DocumentCreateInfo> r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                DocumentCreateInfo r4 = (DocumentCreateInfo) r3;
                Intrinsics.checkNotNullParameter(r4, "documentCreateInfo");
                tt5.a.h("FolderSelectModel", "create folder success.");
                Toast.cancelLoading();
                if (this.a.isCancelled() == true) goto L6;
                this.a.onNext(r4);
                return;
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ FlowableEmitter<DocumentCreateInfo> a;

            public b(FlowableEmitter<DocumentCreateInfo> r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                Throwable r4 = (Throwable) r3;
                Intrinsics.checkNotNullParameter(r4, "throwable");
                tt5.a.d("FolderSelectModel", "create folder failed, throwable = " + r4);
                Toast.cancelLoading();
                if (this.a.isCancelled() == true) goto L6;
                this.a.onError(r4);
                return;
            }
        }

        @Override // gp5.a.InterfaceC0236a
        public final void a(String r11) {
            Intrinsics.checkNotNullParameter(r11, "text");
            Context r0 = this.a.getContext();
            Context r1 = this.a.getContext();
            if (r1 == null) goto L5;
            String r2 = r1.getString(2131887769);
        L6:
            Toast.showLoading(r0, r2);
            d r3 = this.a;
            g0 r4 = new g0();
            int r5 = sbb.e.f.b;
            d r6 = this.a;
            String r7 = r6.c;
            if (r6.e == false) goto L9;
            String r8 = "shared_subfolder";
        L10:
            Flowable<DocumentCreateInfo> r12 = r4.a(new y0(r5, r11, null, r7, r8, this.b));
            FlowableEmitter<DocumentCreateInfo> r9 = this.c;
            r3.f = r12.subscribe(new C0249a(r9), new b(r9));
            return;
        L9:
            r8 = "personal_subfolder";
            goto L10
        L5:
            r2 = null;
            goto L6
        }

        public a(d r1, boolean r2, FlowableEmitter<DocumentCreateInfo> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public e(FragmentActivity r1, d r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(FlowableEmitter<DocumentCreateInfo> r7) {
        Intrinsics.checkNotNullParameter(r7, "emitter");
        Activity r0 = this.a;
        d r1 = this.b;
        if (r1.e == false) goto L5;
        String r2 = "shared_subfolder";
    L6:
        t0.I(r0, r2, "", r1.c, new a(r1, this.c, r7));
        return;
    L5:
        r2 = "personal_subfolder";
        goto L6
    }
}
