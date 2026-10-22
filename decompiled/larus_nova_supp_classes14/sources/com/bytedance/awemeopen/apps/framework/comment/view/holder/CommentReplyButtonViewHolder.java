package com.bytedance.awemeopen.apps.framework.comment.view.holder;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtLoadingLayout;
import com.bytedance.awemeopen.apps.framework.comment.CommentPageParam;
import com.bytedance.awemeopen.apps.framework.comment.view.CommentListAdapter;
import com.bytedance.awemeopen.apps.framework.utils.t;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import ky3.b;
import sy3.h;
import sy3.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/holder/CommentReplyButtonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lsy3/j;", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentReplyButtonViewHolder extends RecyclerView.ViewHolder implements j {
    public static final /* synthetic */ int j = 0;
    public final com.bytedance.awemeopen.apps.framework.comment.j a;
    public final CommentPageParam b;
    public final LinearLayout c;
    public final DmtLoadingLayout d;
    public final TextView e;
    public final ImageView f;
    public final ImageView g;
    public final View h;
    public b i;

    public static final class a {
    }

    static {
    }

    public final void U3() {
        b r0 = this.i;
        Intrinsics.checkNotNull(r0);
        long r1 = ((o14.a) r0).replyCommentTotal;
        b r2 = this.i;
        Intrinsics.checkNotNull(r2);
        if (r1 > r2.j) goto L8;
        b r3 = this.i;
        Intrinsics.checkNotNull(r3);
        if (r3.e == 4) goto L8;
        T3(4);
        return;
    L8:
        b r4 = this.i;
        Intrinsics.checkNotNull(r4);
        int r5 = r4.e;
        if (r5 == 0) goto L27;
        if (r5 != 1) goto L12;
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.e.setText(2131894273);
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        return;
    L12:
        if (r5 != 2) goto L14;
        b r6 = this.i;
        if (r6 == null) goto L25;
        Intrinsics.checkNotNull(r6);
        int r7 = r6.i;
        b r8 = this.i;
        Intrinsics.checkNotNull(r8);
        ((o14.a) r8).replyCommentTotal = r7;
        b r9 = this.i;
        Intrinsics.checkNotNull(r9);
        if (r7 > r9.j) goto L25;
        T3(4);
        return;
    L25:
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.e.setText(2131894271);
        this.f.setVisibility(8);
        this.g.setVisibility(0);
        return;
    L14:
        if (r5 == 3) goto L18;
        if (r5 != 4) goto L36;
        ((RecyclerView.ViewHolder) this).itemView.getLayoutParams().height = 0;
        ((RecyclerView.ViewHolder) this).itemView.requestLayout();
        return;
    L36:
        return;
    L18:
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        return;
    L27:
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        TextView r10 = this.e;
        StringCompanionObject r11 = StringCompanionObject.INSTANCE;
        String r12 = r10.getResources().getString(2131894272);
        b r13 = this.i;
        Intrinsics.checkNotNull(r13);
        long r14 = ((o14.a) r13).replyCommentTotal;
        b r15 = this.i;
        Intrinsics.checkNotNull(r15);
        r10.setText(String.format(r12, Arrays.copyOf(new Object[]{t.a(r14 - ((long) r15.i))}, 1)));
        if (this.b.n == false) goto L30;
        TextView r16 = this.e;
        r16.setTextColor(r16.getContext().getResources().getColor(2131100344));
    L30:
        this.f.setVisibility(0);
        this.g.setVisibility(8);
    }

    public final void T3(int r2) {
        b r0 = this.i;
        if (r0 == null) goto L6;
        r0.e = r2;
    L6:
        U3();
    }

    @Override // sy3.j
    public final void O1(b r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "targetReplyButton");
        if (Intrinsics.areEqual(r7, this.i) == false) goto L5;
        T3(r8);
        return;
    L5:
        r7.v(r8);
        CommentListAdapter r9 = this.a.getAdapter();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r7, "commentReplyButton");
        List<T> r0 = r9.l;
        if (r0 == 0) goto L19;
        Iterator r1 = r0.iterator();
        int r3 = 0;
    L9:
        if (r1.hasNext() == false) goto L19;
        o14.a r4 = (o14.a) r1.next();
        if ((r4 instanceof b) == true) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == true) goto L20;
        r3 = r3 + 1;
    L20:
        if (r3 == (-1)) goto L26;
        r9.notifyItemChanged(r3);
        return;
    L26:
        return;
    L13:
        if (Intrinsics.areEqual(((b) r4).d, r7.d) == false) goto L15;
        r5 = true;
    L19:
        r3 = -1;
        goto L20
    }

    public CommentReplyButtonViewHolder(View r6, com.bytedance.awemeopen.apps.framework.comment.j r7, CommentPageParam r8) {
        Intrinsics.checkNotNullParameter(r6, "itemView");
        Intrinsics.checkNotNullParameter(r7, "callback");
        Intrinsics.checkNotNullParameter(r8, "commentPageParam");
        super(r6);
        this.a = r7;
        this.b = r8;
        this.c = (LinearLayout) r6.findViewById(2131377592);
        DmtLoadingLayout r9 = (DmtLoadingLayout) r6.findViewById(2131377593);
        this.d = r9;
        this.e = (TextView) r6.findViewById(2131391289);
        ImageView r0 = (ImageView) r6.findViewById(2131375163);
        this.f = r0;
        ImageView r1 = (ImageView) r6.findViewById(2131375162);
        this.g = r1;
        View r2 = r6.findViewById(2131369197);
        this.h = r2;
        r6.setOnClickListener(new h(this));
        Resources r3 = Resources.getSystem();
        r9.setProgressBarInfo(MathKt.roundToInt(TypedValue.applyDimension(1, 28, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()))));
        if (r8.n == false) goto L6;
        r0.setImageResource(2131231494);
        r1.setImageResource(2131231494);
        r2.setBackgroundColor(r2.getContext().getResources().getColor(2131100287));
        return;
    }
}
