package wh5;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements FlowableOnSubscribe {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ d e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ FlowableEmitter<IDocUserPermission> a;

        public a(FlowableEmitter<IDocUserPermission> r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IDocUserPermission r3 = (IDocUserPermission) r2;
            if (this.a.isCancelled() == true) goto L6;
            this.a.onNext(r3);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ FlowableEmitter<IDocUserPermission> a;
        public final /* synthetic */ d b;

        public b(FlowableEmitter<IDocUserPermission> r1, d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            if (this.a.isCancelled() == true) goto L9;
            d r0 = this.b;
            Intrinsics.checkNotNull(r4);
            int r1 = d.a;
            r0.getClass();
            if (ax4.d.b(r4, 4) == false) goto L7;
            this.a.onNext(d.a(this.b, r4));
            return;
        L7:
            this.a.onError(r4);
            return;
        }
    }

    public f(String r1, int r2, String r3, int r4, d r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void subscribe(FlowableEmitter<IDocUserPermission> r5) {
        Intrinsics.checkNotNullParameter(r5, "emitter");
        int r0 = wh5.b.a;
        wh5.b.b(this.a, this.b, this.c, this.d).subscribe(new a(r5), new b(r5, this.e));
    }
}
