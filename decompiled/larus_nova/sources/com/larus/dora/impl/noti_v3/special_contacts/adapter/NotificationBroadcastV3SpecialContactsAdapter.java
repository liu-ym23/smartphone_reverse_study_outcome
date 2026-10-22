package com.larus.dora.impl.noti_v3.special_contacts.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.databinding.LarusDoraItemNotiV3SpecialContactSwipeBinding;
import com.larus.dora.impl.nl.notification_rule.ui.SwipeLayout;
import com.larus.dora.impl.noti_v3.special_contacts.ui.e;
import com.larus.dora.impl.view.DoraTextView;
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
import w59.b;
import w59.c;
import w59.d;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001 B]\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0013\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015J\u0006\u0010\u0016\u001a\u00020\u0006J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001c\u0010\u001c\u001a\u00020\u00062\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/dora/impl/noti_v3/special_contacts/adapter/NotificationBroadcastV3SpecialContactsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/noti_v3/special_contacts/adapter/NotificationBroadcastV3SpecialContactsAdapter$ViewHolder;", "onContactClick", "Lkotlin/Function1;", "Lcom/larus/dora/impl/noti_v3/special_contacts/model/NotificationBroadcastV3SpecialContact;", "", "onEditClick", "onDeleteClick", "onLongClick", "Lkotlin/Function2;", "Landroid/view/View;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "items", "", "openedSwipeLayout", "Ljava/lang/ref/WeakReference;", "Lcom/larus/dora/impl/nl/notification_rule/ui/SwipeLayout;", "updateData", "newItems", "", "closeAllSwipedMenus", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "ViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationBroadcastV3SpecialContactsAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<y59.a, Unit> f336485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<y59.a, Unit> f336486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<y59.a, Unit> f336487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<View, y59.a, Unit> f336488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<y59.a> f336489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<SwipeLayout> f336490f;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/noti_v3/special_contacts/adapter/NotificationBroadcastV3SpecialContactsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraItemNotiV3SpecialContactSwipeBinding;", "<init>", "(Lcom/larus/dora/impl/noti_v3/special_contacts/adapter/NotificationBroadcastV3SpecialContactsAdapter;Lcom/larus/dora/impl/databinding/LarusDoraItemNotiV3SpecialContactSwipeBinding;)V", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/dora/impl/noti_v3/special_contacts/model/NotificationBroadcastV3SpecialContact;", "isLast", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f336491c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LarusDoraItemNotiV3SpecialContactSwipeBinding f336492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NotificationBroadcastV3SpecialContactsAdapter f336493b;

        public ViewHolder(NotificationBroadcastV3SpecialContactsAdapter r100, LarusDoraItemNotiV3SpecialContactSwipeBinding r101) {
            Intrinsics.checkNotNullParameter(r101, "binding");
            this.f336493b = r100;
            super(r101.f332721a);
            this.f336492a = r101;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f336489e).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        final y59.a r103 = (y59.a) ListProtector.get(this.f336489e, r101);
        boolean r104 = true;
        int r105 = 0;
        if (r101 == (((ArrayList) this.f336489e).size() - 1)) goto L6;
        r104 = false;
    L6:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        final LarusDoraItemNotiV3SpecialContactSwipeBinding r106 = r102.f336492a;
        final NotificationBroadcastV3SpecialContactsAdapter r107 = r102.f336493b;
        DoraTextView r108 = r106.f332728h;
        String r109 = r103.c();
        String r110 = "";
        if (r109 != null) goto L10;
        r109 = "";
    L10:
        r108.setText(r109);
        DoraTextView r111 = r106.f332727g;
        String r112 = r103.b();
        if (r112 == null) goto L13;
        r110 = r112;
    L13:
        r111.setText(r110);
        ImageView r113 = r106.f332726f;
        Boolean r114 = r103.e();
        if (r114 == null) goto L16;
        boolean r115 = r114.booleanValue();
    L17:
        r113.setSelected(r115);
        View r116 = r106.f332725e;
        if (r104 == false) goto L20;
        r105 = 8;
    L20:
        r116.setVisibility(r105);
        SwipeLayout r117 = r106.f332721a;
        if ((r117 instanceof SwipeLayout) == true) goto L24;
        r117 = null;
    L24:
        if (r117 == null) goto L26;
        r117.setOnSwipeListener(new a(r107));
    L26:
        e1.d(r106.f332726f, new w59.a(r107, r103));
        r106.f332724d.setOnLongClickListener(new b(r107, r103));
        e1.d(r106.f332723c, new c(r107, r103, r106));
        e1.d(r106.f332722b, new d(r107, r103, r106));
        return;
    L16:
        r115 = false;
        goto L17
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        View r112 = LayoutInflater.from(r110.getContext()).inflate(R.layout.larus_dora_item_noti_v3_special_contact_swipe, r110, false);
        int r113 = R.id.btn_delete;
        FrameLayout r100 = (FrameLayout) ViewBindings.findChildViewById(r112, R.id.btn_delete);
        if (r100 == null) goto L19;
        r113 = R.id.btn_edit;
        FrameLayout r101 = (FrameLayout) ViewBindings.findChildViewById(r112, R.id.btn_edit);
        if (r101 == null) goto L19;
        r113 = R.id.content_layout;
        ConstraintLayout r102 = (ConstraintLayout) ViewBindings.findChildViewById(r112, R.id.content_layout);
        if (r102 == null) goto L19;
        r113 = R.id.divider;
        View r103 = ViewBindings.findChildViewById(r112, R.id.divider);
        if (r103 == null) goto L19;
        r113 = R.id.iv_selection_icon;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r112, R.id.iv_selection_icon);
        if (r104 == null) goto L19;
        r113 = R.id.tv_app_name;
        DoraTextView r105 = (DoraTextView) ViewBindings.findChildViewById(r112, R.id.tv_app_name);
        if (r105 == null) goto L19;
        r113 = R.id.tv_contact_name;
        DoraTextView r106 = (DoraTextView) ViewBindings.findChildViewById(r112, R.id.tv_contact_name);
        if (r106 == null) goto L19;
        return new ViewHolder(this, new LarusDoraItemNotiV3SpecialContactSwipeBinding((SwipeLayout) r112, r100, r101, r102, r103, r104, r105, r106));
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r113)));
    }

    public NotificationBroadcastV3SpecialContactsAdapter(com.larus.dora.impl.noti_v3.special_contacts.ui.b r100, com.larus.dora.impl.noti_v3.special_contacts.ui.c r101, com.larus.dora.impl.noti_v3.special_contacts.ui.d r102, e r103) {
        Intrinsics.checkNotNullParameter(r100, "onContactClick");
        Intrinsics.checkNotNullParameter(r101, "onEditClick");
        Intrinsics.checkNotNullParameter(r102, "onDeleteClick");
        Intrinsics.checkNotNullParameter(r103, "onLongClick");
        this.f336485a = r100;
        this.f336486b = r101;
        this.f336487c = r102;
        this.f336488d = r103;
        this.f336489e = new ArrayList();
    }
}
