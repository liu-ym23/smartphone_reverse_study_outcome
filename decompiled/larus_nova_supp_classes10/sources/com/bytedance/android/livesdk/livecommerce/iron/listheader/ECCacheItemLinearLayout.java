package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\fB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/ECCacheItemLinearLayout;", "Landroid/view/View;", "T", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECCacheItemLinearLayout<T extends View> extends LinearLayout {

    public interface a<V extends View> {
        void a(V r1, int r2);

        V b();
    }

    public ECCacheItemLinearLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECCacheItemLinearLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(int r8, a<T> r9) {
        Intrinsics.checkNotNullParameter(r9, "itemViewHelper");
        if (r8 != 0) goto L6;
        removeAllViews();     // Catch: Exception -> L28
        setVisibility(8);     // Catch: Exception -> L28
        return;
    L6:
        setVisibility(0);     // Catch: Exception -> L28
        int r2 = getChildCount();     // Catch: Exception -> L28
        int r3 = Math.max(r2, r8);     // Catch: Exception -> L28
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L39;
        if (r4 >= r2) goto L17;
        if (r4 >= r8) goto L17;
        View r5 = getChildAt(r4);     // Catch: Exception -> L28
        if (r5 == null) goto L13;
        r5.setVisibility(0);     // Catch: Exception -> L28
    L13:
        View r6 = getChildAt(r4);     // Catch: Exception -> L28
        if ((r6 instanceof View) == true) goto L16;
        r6 = null;
    L16:
        r9.a(r6, r4);     // Catch: Exception -> L28
    L27:
        r4 = r4 + 1;
    L17:
        if (r8 > r4) goto L23;
        if (r2 <= r4) goto L23;
        View r7 = getChildAt(r4);     // Catch: Exception -> L28
        if (r7 == null) goto L27;
        r7.setVisibility(8);     // Catch: Exception -> L28
    L23:
        if (r2 > r4) goto L27;
        if (r8 <= r4) goto L27;
        View r10 = r9.b();     // Catch: Exception -> L28
        r9.a(r10, r4);     // Catch: Exception -> L28
        addView(r10);     // Catch: Exception -> L28
        goto L27
    L39:
        return;
    L28:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public ECCacheItemLinearLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ECCacheItemLinearLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
