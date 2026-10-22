package wh5;

import com.bytedance.ee.bear.middleground.permission.permission.doc.DocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements FlowableOnSubscribe {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ d c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ FlowableEmitter<IDocPublicPermission> a;

        public a(FlowableEmitter<IDocPublicPermission> r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IDocPublicPermission r3 = (IDocPublicPermission) r2;
            if (this.a.isCancelled() == true) goto L6;
            this.a.onNext(r3);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ FlowableEmitter<IDocPublicPermission> a;
        public final /* synthetic */ d b;

        public b(FlowableEmitter<IDocPublicPermission> r1, d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r35) {
            Throwable r1 = (Throwable) r35;
            if (this.a.isCancelled() == true) goto L9;
            d r2 = this.b;
            Intrinsics.checkNotNull(r1);
            int r3 = d.a;
            r2.getClass();
            if (ax4.d.b(r1, 4) == false) goto L7;
            this.a.onNext(new DocPublicPermission(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, null, 0, false, false, 0, 0, false, false, false, null, null, null, null, null, null, null, null, 268435455, null));
            return;
        L7:
            this.a.onError(r1);
            return;
        }
    }

    public e(String r1, int r2, d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(FlowableEmitter<IDocPublicPermission> r5) {
        Intrinsics.checkNotNullParameter(r5, "emitter");
        int r0 = wh5.b.a;
        wh5.b.a(this.a, this.b).subscribe(new a(r5), new b(r5, this.c));
    }
}
