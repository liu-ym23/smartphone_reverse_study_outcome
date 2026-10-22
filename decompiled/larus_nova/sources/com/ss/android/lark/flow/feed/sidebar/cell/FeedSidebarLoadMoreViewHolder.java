package com.ss.android.lark.flow.feed.sidebar.cell;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import iza.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/flow/feed/sidebar/cell/FeedSidebarLoadMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "sidebarItemConfig", "Lcom/ss/android/lark/biz/officesdk/im/feed/sidebar/SidebarItemConfig;", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "", "<init>", "(Landroid/view/View;Lcom/ss/android/lark/biz/officesdk/im/feed/sidebar/SidebarItemConfig;Lkotlin/jvm/functions/Function0;)V", "textView", "Landroid/widget/TextView;", "bind", "Companion", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedSidebarLoadMoreViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f423507a;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f423508a;

        public a(Function0<Unit> r100) {
            this.f423508a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f423508a.invoke();
        }
    }

    public static final class b {
    }

    static {
    }

    public FeedSidebarLoadMoreViewHolder(View r100, e r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "sidebarItemConfig");
        Intrinsics.checkNotNullParameter(r102, SendEventContainerMethodParamModel.EventKinds.onClick);
        super(r100);
        TextView r103 = (TextView) r100.findViewById(R.id.sidebar_load_more_text);
        this.f423507a = r103;
        if (r101.f496728a == false) goto L5;
        int r104 = UIHelper.dp2px(40.0f);
    L6:
        r103.setPaddingRelative(r101.f496730c + r104, r103.getPaddingTop(), r103.getPaddingEnd(), r103.getPaddingBottom());
        r100.setOnClickListener(new a(r102));
        com.ss.android.lark.flow.feed.utils.b.d("FeedSidebarLoadMoreViewHolder", "init, hasAvatar=" + r101.f496728a + ", avatarOffset=" + r104 + ", titleLeftMargin=" + r101.f496730c + ", paddingStart=" + r103.getPaddingStart());
        return;
    L5:
        r104 = 0;
        goto L6
    }
}
