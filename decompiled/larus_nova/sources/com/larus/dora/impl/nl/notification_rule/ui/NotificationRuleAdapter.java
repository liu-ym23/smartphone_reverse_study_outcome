package com.larus.dora.impl.nl.notification_rule.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.databinding.LarusDoraItemNotificationRuleSwipeBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001!B]\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0013\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u00062\n\u0010\u001c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/dora/impl/nl/notification_rule/ui/NotificationRuleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/nl/notification_rule/ui/NotificationRuleAdapter$ViewHolder;", "onRuleClick", "Lkotlin/Function1;", "Lcom/larus/dora/api/entity/NotificationRule;", "", "onEditClick", "onDeleteClick", "onLongClick", "Lkotlin/Function2;", "Landroid/view/View;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "items", "", "openedSwipeLayout", "Ljava/lang/ref/WeakReference;", "Lcom/larus/dora/impl/nl/notification_rule/ui/SwipeLayout;", "updateData", "newItems", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "getItem", "closeAllSwipedMenus", "ViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationRuleAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<NotificationRule, Unit> f336308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<NotificationRule, Unit> f336309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<NotificationRule, Unit> f336310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<View, NotificationRule, Unit> f336311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<NotificationRule> f336312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<SwipeLayout> f336313f;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/nl/notification_rule/ui/NotificationRuleAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraItemNotificationRuleSwipeBinding;", "<init>", "(Lcom/larus/dora/impl/nl/notification_rule/ui/NotificationRuleAdapter;Lcom/larus/dora/impl/databinding/LarusDoraItemNotificationRuleSwipeBinding;)V", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/dora/api/entity/NotificationRule;", "isLast", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f336314c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LarusDoraItemNotificationRuleSwipeBinding f336315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NotificationRuleAdapter f336316b;

        public ViewHolder(NotificationRuleAdapter r100, LarusDoraItemNotificationRuleSwipeBinding r101) {
            Intrinsics.checkNotNullParameter(r101, "binding");
            this.f336316b = r100;
            super(r101.f332729a);
            this.f336315a = r101;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f336312e).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        final NotificationRule r103 = (NotificationRule) ListProtector.get(this.f336312e, r101);
        boolean r104 = true;
        int r105 = 0;
        if (r101 == (((ArrayList) this.f336312e).size() - 1)) goto L6;
        r104 = false;
    L6:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        final LarusDoraItemNotificationRuleSwipeBinding r106 = r102.f336315a;
        final NotificationRuleAdapter r107 = r102.f336316b;
        TextView r108 = r106.f332734f;
        String r109 = r103.getRuleDesc();
        if (r109 != null) goto L10;
        r109 = "";
    L10:
        r108.setText(r109);
        ImageView r110 = r106.f332735g;
        Boolean r111 = r103.getStatus();
        if (r111 == null) goto L13;
        boolean r112 = r111.booleanValue();
    L14:
        r110.setSelected(r112);
        View r113 = r106.f332733e;
        if (r104 == false) goto L17;
        r105 = 8;
    L17:
        r113.setVisibility(r105);
        SwipeLayout r114 = r106.f332729a;
        if ((r114 instanceof SwipeLayout) == true) goto L21;
        r114 = null;
    L21:
        if (r114 == null) goto L23;
        r114.setOnSwipeListener(new f0(r107));
    L23:
        e1.d(r106.f332735g, new b0(r107, r103));
        r106.f332732d.setOnLongClickListener(new c0(r107, r103));
        e1.d(r106.f332731c, new d0(r107, r103, r106));
        e1.d(r106.f332730b, new e0(r107, r103, r106));
        return;
    L13:
        r112 = false;
        goto L14
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        View r112 = LayoutInflater.from(r110.getContext()).inflate(R.layout.larus_dora_item_notification_rule_swipe, r110, false);
        int r113 = R.id.btn_delete;
        FrameLayout r100 = (FrameLayout) ViewBindings.findChildViewById(r112, R.id.btn_delete);
        if (r100 == null) goto L17;
        r113 = R.id.btn_edit;
        FrameLayout r101 = (FrameLayout) ViewBindings.findChildViewById(r112, R.id.btn_edit);
        if (r101 == null) goto L17;
        r113 = R.id.content_layout;
        ConstraintLayout r102 = (ConstraintLayout) ViewBindings.findChildViewById(r112, R.id.content_layout);
        if (r102 == null) goto L17;
        r113 = R.id.divider;
        View r103 = ViewBindings.findChildViewById(r112, R.id.divider);
        if (r103 == null) goto L17;
        r113 = R.id.rule_name;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r112, R.id.rule_name);
        if (r104 == null) goto L17;
        r113 = R.id.rule_status_icon;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r112, R.id.rule_status_icon);
        if (r105 == null) goto L17;
        return new ViewHolder(this, new LarusDoraItemNotificationRuleSwipeBinding((SwipeLayout) r112, r100, r101, r102, r103, r104, r105));
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r113)));
    }

    public NotificationRuleAdapter(n r100, p r101, q r102, r r103) {
        Intrinsics.checkNotNullParameter(r100, "onRuleClick");
        Intrinsics.checkNotNullParameter(r101, "onEditClick");
        Intrinsics.checkNotNullParameter(r102, "onDeleteClick");
        Intrinsics.checkNotNullParameter(r103, "onLongClick");
        this.f336308a = r100;
        this.f336309b = r101;
        this.f336310c = r102;
        this.f336311d = r103;
        this.f336312e = new ArrayList();
    }
}
