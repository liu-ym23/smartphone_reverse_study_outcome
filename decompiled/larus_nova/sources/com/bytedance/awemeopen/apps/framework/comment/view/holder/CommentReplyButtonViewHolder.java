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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
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

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/holder/CommentReplyButtonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lsy3/j;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentReplyButtonViewHolder extends RecyclerView.ViewHolder implements j {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f194300j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.comment.j f194301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommentPageParam f194302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f194303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DmtLoadingLayout f194304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f194305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f194306f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f194307g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f194308h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f194309i;

    public static final class a {
    }

    static {
    }

    public final void U3() {
        b r100 = this.f194309i;
        Intrinsics.checkNotNull(r100);
        long r101 = r100.replyCommentTotal;
        b r102 = this.f194309i;
        Intrinsics.checkNotNull(r102);
        if (r101 > r102.f506632j) goto L8;
        b r103 = this.f194309i;
        Intrinsics.checkNotNull(r103);
        if (r103.f506627e == 4) goto L8;
        T3(4);
        return;
    L8:
        b r104 = this.f194309i;
        Intrinsics.checkNotNull(r104);
        int r105 = r104.f506627e;
        if (r105 == 0) goto L27;
        if (r105 != 1) goto L12;
        this.f194303c.setVisibility(0);
        this.f194304d.setVisibility(8);
        this.f194305e.setText(R.string.aos_reply_comment_expand_more);
        this.f194306f.setVisibility(0);
        this.f194307g.setVisibility(8);
        return;
    L12:
        if (r105 != 2) goto L14;
        b r106 = this.f194309i;
        if (r106 == null) goto L25;
        Intrinsics.checkNotNull(r106);
        int r107 = r106.f506631i;
        b r108 = this.f194309i;
        Intrinsics.checkNotNull(r108);
        r108.replyCommentTotal = r107;
        b r109 = this.f194309i;
        Intrinsics.checkNotNull(r109);
        if (r107 > r109.f506632j) goto L25;
        T3(4);
        return;
    L25:
        this.f194303c.setVisibility(0);
        this.f194304d.setVisibility(8);
        this.f194305e.setText(R.string.aos_reply_comment_collapse);
        this.f194306f.setVisibility(8);
        this.f194307g.setVisibility(0);
        return;
    L14:
        if (r105 == 3) goto L18;
        if (r105 != 4) goto L36;
        this.itemView.getLayoutParams().height = 0;
        this.itemView.requestLayout();
        return;
    L36:
        return;
    L18:
        this.f194303c.setVisibility(8);
        this.f194304d.setVisibility(0);
        return;
    L27:
        this.f194303c.setVisibility(0);
        this.f194304d.setVisibility(8);
        TextView r110 = this.f194305e;
        StringCompanionObject r111 = StringCompanionObject.INSTANCE;
        String r112 = r110.getResources().getString(R.string.aos_reply_comment_expand);
        b r113 = this.f194309i;
        Intrinsics.checkNotNull(r113);
        long r114 = r113.replyCommentTotal;
        b r115 = this.f194309i;
        Intrinsics.checkNotNull(r115);
        r110.setText(String.format(r112, Arrays.copyOf(new Object[]{t.a(r114 - ((long) r115.f506631i))}, 1)));
        if (this.f194302b.f194088n == false) goto L30;
        TextView r116 = this.f194305e;
        r116.setTextColor(r116.getContext().getResources().getColor(R.color.aos_text_tertiary_light));
    L30:
        this.f194306f.setVisibility(0);
        this.f194307g.setVisibility(8);
    }

    public final void T3(int r100) {
        b r101 = this.f194309i;
        if (r101 == null) goto L6;
        r101.f506627e = r100;
    L6:
        U3();
    }

    @Override // sy3.j
    public final void O1(b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "targetReplyButton");
        if (Intrinsics.areEqual(r100, this.f194309i) == false) goto L5;
        T3(r101);
        return;
    L5:
        r100.v(r101);
        CommentListAdapter r102 = this.f194301a.getAdapter();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "commentReplyButton");
        List<T> r103 = r102.f196963l;
        if (r103 == 0) goto L19;
        Iterator r104 = r103.iterator();
        int r105 = 0;
    L9:
        if (r104.hasNext() == false) goto L19;
        o14.a r106 = (o14.a) r104.next();
        if ((r106 instanceof b) == true) goto L13;
    L15:
        boolean r107 = false;
    L16:
        if (r107 == true) goto L20;
        r105 = r105 + 1;
    L20:
        if (r105 == (-1)) goto L26;
        r102.notifyItemChanged(r105);
        return;
    L26:
        return;
    L13:
        if (Intrinsics.areEqual(((b) r106).f506626d, r100.f506626d) == false) goto L15;
        r107 = true;
    L19:
        r105 = -1;
        goto L20
    }

    public CommentReplyButtonViewHolder(View r100, com.bytedance.awemeopen.apps.framework.comment.j r101, CommentPageParam r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "commentPageParam");
        super(r100);
        this.f194301a = r101;
        this.f194302b = r102;
        this.f194303c = (LinearLayout) r100.findViewById(R.id.layout_reply_comment_button);
        DmtLoadingLayout r103 = (DmtLoadingLayout) r100.findViewById(R.id.layout_reply_comment_loading);
        this.f194304d = r103;
        this.f194305e = (TextView) r100.findViewById(R.id.tv_reply_comment_title);
        ImageView r104 = (ImageView) r100.findViewById(R.id.img_reply_comment_expand);
        this.f194306f = r104;
        ImageView r105 = (ImageView) r100.findViewById(R.id.img_reply_comment_collapse);
        this.f194307g = r105;
        View r106 = r100.findViewById(R.id.divider);
        this.f194308h = r106;
        r100.setOnClickListener(new h(this));
        Resources r107 = Resources.getSystem();
        r103.setProgressBarInfo(MathKt.roundToInt(TypedValue.applyDimension(1, 28, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()))));
        if (r102.f194088n == false) goto L6;
        r104.setImageResource(R.drawable.aos_ic_s_s_arrowdown_outlined_12_light);
        r105.setImageResource(R.drawable.aos_ic_s_s_arrowdown_outlined_12_light);
        r106.setBackgroundColor(r106.getContext().getResources().getColor(R.color.aos_line_primary_light));
        return;
    }
}
