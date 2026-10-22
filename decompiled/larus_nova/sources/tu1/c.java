package tu1;

import com.bytedance.android.livesdk.dynamicstrategy.impl.express.exception.SimpleExpressException;
import com.bytedance.android.livesdk.dynamicstrategy.impl.express.parse.ExpressNodeType;
import java.util.Deque;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f547598a = 0;

    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f547599b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Deque<b> f547600a;

        /* JADX INFO: renamed from: tu1.c$a$a, reason: collision with other inner class name */
        public static final class C7776a {
        }

        public final void a() {
            int r100 = 0;
        L4:
            if (r100 >= (((LinkedList) this.f547600a).size() - 1)) goto L13;
            b r101 = (b) CollectionsKt.elementAt(this.f547600a, r100);
            r100 = r100 + 1;
            b r102 = (b) CollectionsKt.elementAt(this.f547600a, r100);
            if (Intrinsics.areEqual(r102, f547599b) == true) goto L18;
            if (r101.a() == false) goto L19;
            if (r102.a() == true) goto L20;
            r102.f547597d = (b) ((LinkedList) this.f547600a).pop();
            goto L4
        L20:
            return;
        L19:
            return;
        L18:
            return;
        }

        static {
            f547599b = new b(ExpressNodeType.LEFT_BRACKET, "(");
        }

        public a() {
            this.f547600a = new LinkedList();
        }

        public final void b(b r100) {
            Intrinsics.checkNotNullParameter(r100, "node");
            if (this.f547600a.isEmpty() == true) goto L11;
            b r101 = (b) ((LinkedList) this.f547600a).pop();
            if (r101.a() == false) goto L9;
            r100.f547596c = r101;
            ((LinkedList) this.f547600a).push(r100);
            return;
        L9:
            throw new SimpleExpressException("express parse failed, retire not full node", null, 2, null);
        L11:
            throw new SimpleExpressException("express parse failed, retire null node", null, 2, null);
        }
    }

    static {
    }
}
