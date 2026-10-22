package com.bytedance.android.shopping.commentv3.uitree.list.rvkit;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv3.comment.WrapContentGridLayoutManager;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/list/rvkit/OffsetLayoutManager;", "Lcom/bytedance/android/shopping/anchorv3/comment/WrapContentGridLayoutManager;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OffsetLayoutManager extends WrapContentGridLayoutManager {
    public final Lazy a;
    public final RecyclerView b;

    public static final class a {
    }

    static {
    }

    public final int computeVerticalScrollOffset(RecyclerView.State r13) {
        Intrinsics.checkNotNullParameter(r13, "state");
        if (getChildCount() != 0) goto L53;
        return 0;
    L53:
        int r14 = findFirstVisibleItemPosition();     // Catch: Exception -> L50
        View r1 = findViewByPosition(r14);     // Catch: Exception -> L50
        if (r1 == null) goto L8;
        float r2 = r1.getY();     // Catch: Exception -> L50
    L9:
        float r3 = -r2;
        int r4 = 0;
    L10:
        if (r4 >= r14) goto L49;
        Integer r5 = (Integer) ((HashMap) this.a.getValue()).get(Integer.valueOf(r4));     // Catch: Exception -> L50
        if (r5 != null) goto L14;
        r5 = 0;     // Catch: Exception -> L50
    L14:
        r3 = r3 + r5.intValue();     // Catch: Exception -> L50
        RecyclerView.Adapter r6 = this.b.getAdapter();     // Catch: Exception -> L50
        if (r6 == null) goto L17;
        int r7 = r6.getItemViewType(r4);     // Catch: Exception -> L50
    L18:
        boolean r10 = true;
        if (r7 == 5) goto L27;
        if (r7 == 51) goto L27;
        if (r7 == 8) goto L27;
        if (r7 == Integer.MIN_VALUE) goto L27;
        if (r7 == 2) goto L27;
        if (r7 == 21) goto L27;
        boolean r8 = false;
    L28:
        if (r8 == true) goto L47;
        int r9 = r4 + 1;     // Catch: Exception -> L50
        if (r9 > r14) goto L34;
        RecyclerView.Adapter r11 = this.b.getAdapter();     // Catch: Exception -> L50
        if (r11 == null) goto L34;
        int r12 = r11.getItemViewType(r9);     // Catch: Exception -> L50
    L35:
        if (r12 == 0) goto L47;
        if (r12 == 5) goto L44;
        if (r12 == 51) goto L44;
        if (r12 == 8) goto L44;
        if (r12 == Integer.MIN_VALUE) goto L44;
        if (r12 == 2) goto L44;
        if (r12 == 21) goto L44;
        r10 = false;
    L44:
        if (r10 == true) goto L47;
        r3 = r3 + com.bytedance.android.shopping.extensions.b.b(8);
    L34:
        r12 = 0;
    L47:
        r4 = r4 + 1;
    L27:
        r8 = true;
        goto L28
    L17:
        r7 = 0;
        goto L18
    L49:
        return (int) r3;
    L8:
        r2 = 0.0f;
    L50:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return 0;
    }

    public final void onLayoutCompleted(RecyclerView.State r5) {
        super/*androidx.recyclerview.widget.GridLayoutManager*/.onLayoutCompleted(r5);
        int r6 = getChildCount();
        if (r6 > 0) goto L5;
        return;
    L5:
        int r0 = 0;
    L6:
        if (r0 >= r6) goto L11;
        View r1 = getChildAt(r0);
        if (r1 == null) goto L10;
        int r2 = getPosition(r1);
        ((HashMap) this.a.getValue()).put(Integer.valueOf(r2), Integer.valueOf(r1.getHeight()));
    L10:
        r0 = r0 + 1;
        goto L6
    }

    public OffsetLayoutManager(RecyclerView r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "hostRv");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.b = r2;
        this.a = LazyKt.lazy(OffsetLayoutManager$heightMap$2.INSTANCE);
    }
}
