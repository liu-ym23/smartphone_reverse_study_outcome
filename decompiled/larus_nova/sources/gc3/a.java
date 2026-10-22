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

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CommentPageEvents f480819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f480820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f480821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f480822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<fc3.a> f480823e;

    public final void b() {
        if (this.f480820b == true) goto L5;
        return;
    L5:
        if (this.f480821c <= 0) goto L7;
        return;
    L7:
        if (this.f480822d == true) goto L17;
        this.f480822d = true;
        CommentPageEvents r100 = this.f480819a;
        if (r100 == null) goto L12;
        List<Map<String, Object>> r101 = r100.getOnAppear();
    L13:
        a(r101, null);
        return;
    L12:
        r101 = null;
        goto L13
    }

    public a(Function0<fc3.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "actionContextProvider");
        this.f480823e = r100;
    }

    public final void a(List<? extends Map<String, ? extends Object>> r100, CommentSliceComponent r101) {
        if (r100 == null) goto L15;
        Iterator<T> r102 = r100.iterator();
    L5:
        if (r102.hasNext() == false) goto L25;
        Map r103 = (Map) r102.next();
        SlcCommonAction.a r104 = SlcCommonAction.Companion;
        if (r103 == null) goto L5;
        r104.getClass();
        SlcCommonAction r105 = SlcCommonAction.a.b(r103);
        if (r105 == null) goto L5;
        fc3.a r106 = this.f480823e.invoke();
        if (r106 == null) goto L5;
        r106.a(new c(r105, null, r101, 6));
        goto L5
    L25:
        return;
    }
}
