package com.larus.avlink.env.event;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005#$%&'B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0016\u001a\u00020\u000e2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "listener", "Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$OnItemClickListener;", "<init>", "(Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$OnItemClickListener;)V", "currentPopupHolder", "Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$RealItemViewHolder;", "getCurrentPopupHolder", "()Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$RealItemViewHolder;", "setCurrentPopupHolder", "(Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$RealItemViewHolder;)V", "hideCurrentPopup", "", "hasPopupShowing", "", "placeholders", "", "", "internalList", "Lcom/larus/avlink/env/event/api/UserProfileEntry;", "setList", "list", "getItemCount", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "onViewRecycled", "OnItemClickListener", "Companion", "AddViewHolder", "RealItemViewHolder", "PlaceholderViewHolder", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraEnvObservePersonalMemoryListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f292228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RealItemViewHolder f292229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f292230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<n98.e> f292231d;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$AddViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "vDivider", "setDividerVisible", "", "visible", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AddViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f292232a;

        public AddViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f292232a = r100.findViewById(R.id.v_divider);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$PlaceholderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tvContent", "Landroid/widget/TextView;", "ivAddPlaceholder", "Landroid/widget/ImageView;", "vDivider", "bind", "", "text", "", "isLastItem", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PlaceholderViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f292233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f292234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f292235c;

        public PlaceholderViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f292233a = (TextView) r100.findViewById(R.id.tv_content);
            this.f292234b = (ImageView) r100.findViewById(R.id.iv_add_placeholder);
            this.f292235c = r100.findViewById(R.id.v_divider);
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\u0006\u0010\u0019\u001a\u00020\u0012J\u0006\u0010\u001a\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$RealItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "listener", "Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$OnItemClickListener;", "adapter", "Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter;", "<init>", "(Landroid/view/View;Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$OnItemClickListener;Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter;)V", "tvContent", "Landroid/widget/TextView;", "ivAddPlaceholder", "Landroid/widget/ImageView;", "vDivider", "popup", "Lcom/larus/avlink/env/event/PersonalMemoryActionPopupWindow;", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/avlink/env/event/api/UserProfileEntry;", "isLastItem", "", "isFullyVisible", "view", "dismissPopup", "isPopupShowing", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RealItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int f292236g = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f292237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DoraEnvObservePersonalMemoryListAdapter f292238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f292239c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f292240d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f292241e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public j0 f292242f;

        public RealItemViewHolder(View r100, b r101, DoraEnvObservePersonalMemoryListAdapter r102) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "listener");
            Intrinsics.checkNotNullParameter(r102, "adapter");
            super(r100);
            this.f292237a = r101;
            this.f292238b = r102;
            this.f292239c = (TextView) r100.findViewById(R.id.tv_content);
            this.f292240d = (ImageView) r100.findViewById(R.id.iv_add_placeholder);
            this.f292241e = r100.findViewById(R.id.v_divider);
        }
    }

    public static final class a {
    }

    public interface b {
        void L50(n98.e r100);

        void Lx(n98.e r100);

        void r2();
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        int r100 = this.f292231d.size();
        if (r100 > 0) goto L7;
        r100 = this.f292230c.size();
    L7:
        return r100 + 1;
    }

    public final boolean y2() {
        RealItemViewHolder r100 = this.f292229b;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.f292242f == null) goto L7;
        boolean r101 = true;
    L8:
        if (r101 != true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
    }

    public DoraEnvObservePersonalMemoryListAdapter(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f292228a = r100;
        int r101 = com.larus.utils.j0.f375426a;
        this.f292230c = CollectionsKt.listOf(new String[]{com.larus.utils.j0.d(R.string.larus_dora_environmental_data_personal_guide_1_cn), com.larus.utils.j0.d(R.string.larus_dora_environmental_data_personal_guide_2_cn), com.larus.utils.j0.d(R.string.larus_dora_environmental_data_personal_guide_3_cn), com.larus.utils.j0.d(R.string.larus_dora_environmental_data_personal_guide_4_cn)});
        this.f292231d = CollectionsKt.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 != 0) goto L5;
        return 0;
    L5:
        if ((!this.f292231d.isEmpty()) == false) goto L7;
        return 1;
    L7:
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewRecycled(r100);
        if ((r100 instanceof RealItemViewHolder) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r100, this.f292229b) == false) goto L15;
        RealItemViewHolder r101 = (RealItemViewHolder) r100;
        j0 r102 = r101.f292242f;
        if (r102 == null) goto L12;
        PopupWindow r103 = r102.f292288f;
        if (r103 == null) goto L11;
        PopupWindowLancet.handleDismissBeforeOrigin(r103);
        r103.dismiss();
    L11:
        r102.f292288f = null;
    L12:
        r101.f292242f = null;
        this.f292229b = null;
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (Intrinsics.areEqual(r100, this.f292229b) == false) goto L5;
        this.f292229b = null;
    L5:
        int r101 = 0;
        if (r110 != (getItemCount() - 1)) goto L8;
        boolean r102 = true;
    L9:
        int r103 = 8;
        if ((r100 instanceof AddViewHolder) == false) goto L17;
        r100.itemView.setOnClickListener(new a0(this));
        boolean r111 = !r102;
        View r104 = ((AddViewHolder) r100).f292232a;
        if (r111 == true) goto L15;
        r101 = 8;
    L15:
        r104.setVisibility(r101);
        return;
    L17:
        if ((r100 instanceof RealItemViewHolder) == false) goto L36;
        int r112 = r110 - 1;
        if (r112 >= 0) goto L21;
        return;
    L21:
        if (r112 >= this.f292231d.size()) goto L49;
        final n98.e r113 = (n98.e) ListProtector.get(this.f292231d, r112);
        final RealItemViewHolder r105 = (RealItemViewHolder) r100;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r113, MapController.ITEM_LAYER_TAG);
        j0 r106 = r105.f292242f;
        if (r106 == null) goto L28;
        PopupWindow r107 = r106.f292288f;
        if (r107 == null) goto L27;
        PopupWindowLancet.handleDismissBeforeOrigin(r107);
        r107.dismiss();
    L27:
        r106.f292288f = null;
    L28:
        r105.f292242f = null;
        String r108 = r113.a();
        if (r108 != null) goto L31;
        r108 = "";
    L31:
        r105.f292239c.setText(r108);
        r105.f292239c.setTextColor(ContextCompat.getColor(r105.itemView.getContext(), v19.c.b(R.color.larus_neutral_100, r105.itemView.getContext(), R.color.larus_neutral_100)));
        r105.f292240d.setVisibility(8);
        View r109 = r105.f292241e;
        if (r102 == false) goto L34;
        r101 = 8;
    L34:
        r109.setVisibility(r101);
        r105.itemView.setClickable(true);
        r105.itemView.setLongClickable(true);
        r105.itemView.setOnClickListener(new b0(r105, r113));
        r105.itemView.setOnLongClickListener(new c0(r105, r113));
        return;
    L49:
        return;
    L36:
        if ((r100 instanceof PlaceholderViewHolder) == false) goto L51;
        int r114 = r110 - 1;
        if (r114 >= 0) goto L40;
        return;
    L40:
        if (r114 >= this.f292230c.size()) goto L53;
        String r115 = (String) ListProtector.get(this.f292230c, r114);
        PlaceholderViewHolder r116 = (PlaceholderViewHolder) r100;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r115, "text");
        r116.f292233a.setText(r115);
        r116.f292233a.setTextColor(ContextCompat.getColor(r116.itemView.getContext(), v19.c.b(R.color.larus_neutral_50, r116.itemView.getContext(), R.color.larus_neutral_50)));
        r116.f292234b.setVisibility(0);
        View r117 = r116.f292235c;
        if (r102 == true) goto L45;
        r103 = 0;
    L45:
        r117.setVisibility(r103);
        r116.itemView.setClickable(false);
        r116.itemView.setLongClickable(false);
        return;
    L53:
        return;
    L51:
        return;
    L8:
        r102 = false;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 0) goto L5;
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_personal_memory_add, r100, false);
        Intrinsics.checkNotNull(r102);
        return new AddViewHolder(r102);
    L5:
        if (r101 != 1) goto L7;
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_personal_memory_content, r100, false);
        Intrinsics.checkNotNull(r103);
        return new RealItemViewHolder(r103, this.f292228a, this);
    L7:
        if (r101 != 2) goto L10;
        View r104 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_personal_memory_content, r100, false);
        Intrinsics.checkNotNull(r104);
        return new PlaceholderViewHolder(r104);
    L10:
        throw new IllegalArgumentException("Unknown view type");
    }
}
