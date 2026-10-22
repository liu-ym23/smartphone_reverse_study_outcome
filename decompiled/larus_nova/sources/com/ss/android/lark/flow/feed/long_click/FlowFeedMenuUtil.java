package com.ss.android.lark.flow.feed.long_click;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.flow.feed.databinding.ItemFlowMenuItemBinding;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowFeedMenuUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f423393a = 0;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ2\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00142\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u0012J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ss/android/lark/flow/feed/long_click/FlowFeedMenuUtil$FeedMenuListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/flow/feed/long_click/FlowFeedMenuUtil$FeedMenuListItemViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dismiss", "Lkotlin/Function0;", "", "actionStatusListener", "Lcom/ss/android/lark/feed/export/feedcard/action/ActionStatusListener;", "isSidebar", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Lcom/ss/android/lark/feed/export/feedcard/action/ActionStatusListener;Z)V", "feedActionMap", "Ljava/util/LinkedHashMap;", "Lcom/ss/android/lark/feed/export/feedcard/action/FeedActionType;", "Lcom/ss/android/lark/feed/export/feedcard/action/IFeedActionFactory;", "Lkotlin/collections/LinkedHashMap;", "feedCardData", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", com.bytedance.android.ec.core.event.a.KEY_SUBJECT, "Lio/reactivex/Observable;", "", "updateData", "data", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FeedMenuListAdapter extends RecyclerView.Adapter<FeedMenuListItemViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f423394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f423395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final aeb.a f423396c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f423397d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public LinkedHashMap<FeedActionType, aeb.c> f423398e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public UIFeedCard f423399f;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            LinkedHashMap<FeedActionType, aeb.c> r100 = this.f423398e;
            if (r100 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("feedActionMap");
            r100 = null;
        L6:
            return r100.keySet().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            FeedMenuListItemViewHolder r102 = (FeedMenuListItemViewHolder) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            if (r101 >= getItemCount()) goto L40;
            LinkedHashMap<FeedActionType, aeb.c> r103 = this.f423398e;
            if (r103 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("feedActionMap");
            r103 = null;
        L8:
            FeedActionType r104 = (FeedActionType) ListProtector.get(CollectionsKt.toList(r103.keySet()), r101);
            LinkedHashMap<FeedActionType, aeb.c> r105 = this.f423398e;
            if (r105 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("feedActionMap");
            r105 = null;
        L11:
            aeb.c r106 = r105.get(r104);
            if (r106 == null) goto L14;
            aeb.e r107 = r106.i();
        L15:
            LinkedHashMap<FeedActionType, aeb.c> r108 = this.f423398e;
            if (r108 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("feedActionMap");
            r108 = null;
        L18:
            aeb.c r109 = r108.get(r104);
            if (r109 == null) goto L21;
            aeb.d r110 = r109.m();
        L22:
            if (r107 == null) goto L39;
            if (r110 == null) goto L41;
            Context r111 = this.f423394a;
            UIFeedCard r112 = this.f423399f;
            if (r112 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("feedCardData");
            r112 = null;
        L28:
            Drawable r113 = UIUtils.getDrawable(r111, r107.b(r112)).mutate();
            r113.setTint(UIUtils.getColor(this.f423394a, r107.a()));
            r102.f423400a.f423379c.setImageDrawable(r113);
            int r114 = UIUtils.dp2px(this.f423394a, 20.0f);
            AppCompatImageView r115 = r102.f423400a.f423379c;
            ViewGroup.LayoutParams r116 = r115.getLayoutParams();
            r116.width = r114;
            r116.height = r114;
            r115.setLayoutParams(r116);
            TextView r117 = r102.f423400a.f423380d;
            UIFeedCard r118 = this.f423399f;
            if (r118 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("feedCardData");
            r118 = null;
        L31:
            r117.setText(r107.d(r118));
            int r119 = 0;
            r102.f423400a.f423380d.setTextSize(0, zz7.b.h(this.f423394a, 16));
            if (this.f423397d == true) goto L34;
            r102.f423400a.f423380d.setTypeface(null, 1);
        L34:
            r102.f423400a.f423380d.setTextColor(UIUtils.getColor(this.f423394a, r107.a()));
            LinearLayout r120 = r102.f423400a.f423378b;
            if (r101 != (getItemCount() - 1)) goto L37;
            r119 = 8;
        L37:
            r120.setVisibility(r119);
            r102.f423400a.f423377a.setOnClickListener(new f(this, r110));
            return;
        L41:
            return;
        L39:
            return;
        L21:
            r110 = null;
            goto L22
        L14:
            r107 = null;
            goto L15
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.item_flow_menu_item, r100, false);
            int r103 = R.id.menu_divider;
            LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r102, R.id.menu_divider);
            if (r104 == null) goto L11;
            r103 = R.id.menu_icon;
            AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.menu_icon);
            if (r105 == null) goto L11;
            r103 = R.id.menu_name;
            TextView r106 = (TextView) ViewBindings.findChildViewById(r102, R.id.menu_name);
            if (r106 == null) goto L11;
            return new FeedMenuListItemViewHolder(new ItemFlowMenuItemBinding((RelativeLayout) r102, r104, r105, r106));
        L11:
            throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
        }

        public FeedMenuListAdapter(Context r100, Function0<Unit> r101, aeb.a r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "dismiss");
            Intrinsics.checkNotNullParameter(r102, "actionStatusListener");
            this.f423394a = r100;
            this.f423395b = r101;
            this.f423396c = r102;
            this.f423397d = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/flow/feed/long_click/FlowFeedMenuUtil$FeedMenuListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ss/android/lark/flow/feed/databinding/ItemFlowMenuItemBinding;", "<init>", "(Lcom/ss/android/lark/flow/feed/databinding/ItemFlowMenuItemBinding;)V", "getBinding", "()Lcom/ss/android/lark/flow/feed/databinding/ItemFlowMenuItemBinding;", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FeedMenuListItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ItemFlowMenuItemBinding f423400a;

        public FeedMenuListItemViewHolder(ItemFlowMenuItemBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            super(r100.f423377a);
            this.f423400a = r100;
        }
    }

    static {
        f423393a = UIHelper.dp2px(7.0f);
    }
}
