package gc3;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentPageEvents;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentSliceComponent;
import fc3.c;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public CommentPageEvents a;
    public boolean b;
    public int c;
    public boolean d;
    public final Function0<fc3.a> e;

    public final void b() {
        if (this.b == true) goto L5;
        return;
    L5:
        if (this.c <= 0) goto L7;
        return;
    L7:
        if (this.d == true) goto L17;
        this.d = true;
        CommentPageEvents r0 = this.a;
        if (r0 == null) goto L12;
        List<Map<String, Object>> r1 = r0.getOnAppear();
    L13:
        a(r1, null);
        return;
    L12:
        r1 = null;
        goto L13
    }

    public a(Function0<fc3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContextProvider");
        this.e = r2;
    }

    public final void a(List<? extends Map<String, ? extends Object>> r6, CommentSliceComponent r7) {
        if (r6 == null) goto L15;
        Iterator<T> r8 = r6.iterator();
    L5:
        if (r8.hasNext() == false) goto L25;
        Map r0 = (Map) r8.next();
        SlcCommonAction.a r1 = SlcCommonAction.Companion;
        if (r0 == null) goto L5;
        r1.getClass();
        SlcCommonAction r2 = SlcCommonAction.a.b(r0);
        if (r2 == null) goto L5;
        fc3.a r3 = (fc3.a) this.e.invoke();
        if (r3 == null) goto L5;
        r3.a(new c(r2, null, r7, 6));
        goto L5
    L25:
        return;
    }
}
