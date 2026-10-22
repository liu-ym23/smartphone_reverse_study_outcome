package com.bytedance.android.window.shop.innerflow.holder.element.commentlist;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.utils.k0;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import wp3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/holder/element/commentlist/CommentListItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentListItemHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int e = 0;
    public final SimpleDraweeView a;
    public final TextView b;
    public final String c;
    public final String d;

    public CommentListItemHolder(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super(r3);
        this.a = r3.findViewById(2131370853);
        this.b = (TextView) r3.findViewById(2131370854);
        this.c = r3.getContext().getString(2131896758);
        this.d = r3.getContext().getString(2131896759);
    }

    public final void T3(b.C0182b r14) {
        int r0 = k0.a;
        TextView r1 = this.b;
        if (r14 == null) goto L5;
        String r15 = r14.b;
    L6:
        String r2 = "";
        if (r15 != null) goto L9;
        String r3 = "";
    L10:
        float r16 = RangesKt.coerceAtLeast(r1.getWidth() - com.bytedance.android.shopping.extensions.b.b(6), 0.0f);
        String r9 = this.c;
        String r10 = this.d;
        Intrinsics.checkNotNullParameter(r1, "textView");
        if (a2.d(r3) == null) goto L71;
        if (r9 == null) goto L17;
        String r5 = a2.d(r9);
        if (r5 == null) goto L17;
        float r11 = r1.getPaint().measureText(r5);
    L18:
        if (r10 != null) goto L20;
    L22:
        float r12 = 0.0f;
    L23:
        Iterator r4 = StringsKt.split$default(r3, new String[]{"\n"}, false, 0, 6, null).iterator();
    L25:
        if (r4.hasNext() == false) goto L29;
        Object r6 = r4.next();
        if ((!StringsKt.isBlank((String) r6)) == false) goto L25;
    L30:
        String r7 = (String) r6;
        if (r7 != null) goto L34;
        r7 = "";
    L34:
        if (r1.getPaint().measureText(r7) > ((r16 - r11) - r12)) goto L43;
        StringBuilder r17 = new StringBuilder();
        if (r9 != null) goto L38;
        r9 = "";
    L38:
        r17.append(r9);
        r17.append(r7);
        if (r10 == null) goto L42;
        r2 = r10;
    L42:
        r17.append(r2);
        r1.setText(r17.toString());
        return;
    L43:
        int r8 = g1.a;
        String r13 = g1.a.c(r1.getContext(), 2131895741, new Object[]{""});
        float r18 = (r11 + r1.getPaint().measureText(r13)) + r12;
    L45:
        if (a2.b(r7) == false) goto L51;
        if (r1.getPaint().measureText(r7) <= (r16 - r18)) goto L51;
        if (r7 != null) goto L49;
        r7 = null;
        goto L45
    L49:
        r7 = r7.substring(0, r7.length() - 1);
    L51:
        StringBuilder r19 = new StringBuilder();
        if (r9 != null) goto L54;
        r9 = "";
    L54:
        r19.append(r9);
        r19.append(r7);
        r19.append(r13);
        if (r10 == null) goto L58;
        r2 = r10;
    L58:
        r19.append(r2);
        r1.setText(r19.toString());
        return;
    L29:
        r6 = null;
        goto L30
    L20:
        if (a2.d(r10) == null) goto L22;
        r12 = r1.getPaint().measureText(r10);
    L17:
        r11 = 0.0f;
        goto L18
    L71:
        return;
    L9:
        r3 = r15;
        goto L10
    L5:
        r15 = null;
        goto L6
    }
}
