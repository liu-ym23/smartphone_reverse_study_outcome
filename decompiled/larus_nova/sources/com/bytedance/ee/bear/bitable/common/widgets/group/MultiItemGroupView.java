package com.bytedance.ee.bear.bitable.common.widgets.group;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.common.widgets.group.GroupMultiItemModel;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.panel.GroupInfo;
import com.bytedance.ee.bear.facade.common.widget.RoundFrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u00012B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aJ\u001e\u0010\u001b\u001a\u00020\u00182\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u001dj\b\u0012\u0004\u0012\u00020\u0015`\u001eJ\u001a\u0010\u001f\u001a\u00020\u00182\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00180!J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\tH&J\u001f\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020\u00182\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0002J+\u0010-\u001a\u00020\u00182\u0014\u0010.\u001a\u00100/R\f0\rR\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00100\u001a\u00028\u0000H&¢\u0006\u0002\u00101R%\u0010\f\u001a\f0\rR\b\u0012\u0004\u0012\u00028\u00000\u00008DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR.\u0010\u0012\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00150\u0013j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/bitable/common/widgets/group/GroupMultiItemModel;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mItemAdapter", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView$ItemAdapter;", "getMItemAdapter", "()Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView$ItemAdapter;", "mItemAdapter$delegate", "Lkotlin/Lazy;", "groupInfoMap", "Ljava/util/HashMap;", "", "Lcom/bytedance/ee/bear/bitable/panel/GroupInfo;", "Lkotlin/collections/HashMap;", "updateItemList", "", "itemList", "", "updateGroupInfo", "groupInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "setOnItemClickListener", "listener", "Lkotlin/Function1;", "onCreateView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "position", "data", "(ILcom/bytedance/ee/bear/bitable/common/widgets/group/GroupMultiItemModel;)I", "sortByGroupId", "items", "onBindContentView", "itemViewHolder", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView$ItemAdapter$ItemViewHolder;", MapController.ITEM_LAYER_TAG, "(Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView$ItemAdapter$ItemViewHolder;Lcom/bytedance/ee/bear/bitable/common/widgets/group/GroupMultiItemModel;)V", "ItemAdapter", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class MultiItemGroupView<T extends GroupMultiItemModel> extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f209964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, GroupInfo> f209965b;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u0016\u0012\u0012\u0012\u00100\u0002R\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u00030\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J&\u0010\u0012\u001a\u00100\u0002R\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J&\u0010\u0016\u001a\u00020\u000e2\u0014\u0010\u0017\u001a\u00100\u0002R\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0014\u0010\u0019\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007J\u001a\u0010\u001b\u001a\u00020\u000e2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\rR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView$ItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView$ItemAdapter$ItemViewHolder;", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView;", "<init>", "(Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView;)V", "mItemList", "", "getMItemList", "()Ljava/util/List;", "setMItemList", "(Ljava/util/List;)V", "mItemClickListener", "Lkotlin/Function1;", "", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "updateItemList", "itemList", "setOnItemClickListener", "listener", "ItemViewHolder", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ItemAdapter extends RecyclerView.Adapter<MultiItemGroupView<T>.ItemAdapter.ItemViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<T> f209966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function1<? super T, Unit> f209967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MultiItemGroupView<T> f209968c;

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00020!¢\u0006\u0002\u0010\"J\u001d\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00028\u00002\u0006\u0010 \u001a\u00020!H\u0002¢\u0006\u0002\u0010\"J\u001a\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u001a\u0010*\u001a\u00020!2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\n \u001b*\u0004\u0018\u00010\u00170\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView$ItemAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "rootView", "Landroid/view/View;", "extendItemView", "<init>", "(Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView$ItemAdapter;Landroid/view/View;Landroid/view/View;)V", "getRootView", "()Landroid/view/View;", "getExtendItemView", "itemWrapper", "getItemWrapper", "setItemWrapper", "(Landroid/view/View;)V", KtvSubElement.CONTAINER, "Lcom/bytedance/ee/bear/facade/common/widget/RoundFrameLayout;", "getContainer", "()Lcom/bytedance/ee/bear/facade/common/widget/RoundFrameLayout;", "setContainer", "(Lcom/bytedance/ee/bear/facade/common/widget/RoundFrameLayout;)V", ItemStyle.ITEM_STYLE_DIVIDER, "getDivider", "groupTitle", "Landroid/widget/TextView;", "getGroupTitle", "()Landroid/widget/TextView;", "bottomDesc", "kotlin.jvm.PlatformType", "getBottomDesc", "onBindView", "", MapController.ITEM_LAYER_TAG, "isLastItem", "", "(Lcom/bytedance/ee/bear/bitable/common/widgets/group/GroupMultiItemModel;Z)V", "onBindContainerStyle", "viewItem", "needShowBottomDesc", "groupPosition", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/GroupMultiItemModel$GroupPosition;", "groupId", "", "needShowGroupTitle", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class ItemViewHolder extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final View f209969a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final View f209970b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final View f209971c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final RoundFrameLayout f209972d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final View f209973e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final TextView f209974f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final TextView f209975g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ MultiItemGroupView<T>.ItemAdapter f209976h;

            public /* synthetic */ class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f209977a = null;

                static {
                    int[] r100 = new int[GroupMultiItemModel.GroupPosition.values().length];
                    r100[GroupMultiItemModel.GroupPosition.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
                L11:
                    r100[GroupMultiItemModel.GroupPosition.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
                L15:
                    r100[GroupMultiItemModel.GroupPosition.BOTTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
                L6:
                    f209977a = r100;
                }
            }

            public ItemViewHolder(ItemAdapter r100, View r101, View r102) {
                Intrinsics.checkNotNullParameter(r101, "rootView");
                Intrinsics.checkNotNullParameter(r102, "extendItemView");
                this.f209976h = r100;
                super(r101);
                this.f209969a = r101;
                this.f209970b = r102;
                ((FrameLayout) r101.findViewById(R.id.item_parent)).addView(r102, new FrameLayout.LayoutParams(-1, -2));
                this.f209971c = r101.findViewById(R.id.item_wrapper);
                this.f209972d = (RoundFrameLayout) r101.findViewById(R.id.item_parent);
                this.f209973e = r101.findViewById(R.id.v_divider);
                this.f209974f = (TextView) r101.findViewById(R.id.groupTitle);
                this.f209975g = (TextView) r101.findViewById(R.id.bottomDesc);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f209966a).size();
        }

        public ItemAdapter(MultiItemGroupView r100) {
            this.f209968c = r100;
            this.f209966a = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            return this.f209968c.r((GroupMultiItemModel) m.j(this.f209966a, r100, null));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
            MultiItemGroupView<T>.ItemAdapter.ItemViewHolder r112 = (ItemViewHolder) r110;
            Intrinsics.checkNotNullParameter(r112, "holder");
            if (r111 >= ((ArrayList) this.f209966a).size()) goto L93;
            GroupMultiItemModel r100 = (GroupMultiItemModel) ListProtector.get(this.f209966a, r111);
            if (r111 != (((ArrayList) this.f209966a).size() - 1)) goto L8;
            boolean r113 = true;
        L9:
            r112.getClass();
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            int r101 = r112.f209972d.getResources().getDimensionPixelSize(R.dimen.space_radius_l);
            ViewGroup.LayoutParams r102 = r112.f209971c.getLayoutParams();
            String r103 = null;
            if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
            ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r102;
        L13:
            int r105 = r112.f209972d.getResources().getDimensionPixelSize(R.dimen.space_kit_len_16);
            int r106 = ItemViewHolder.a.f209977a[r100.getGroupPosition().ordinal()];
            if (r106 != 1) goto L16;
            if (r104 == null) goto L43;
            r104.topMargin = r105;
        L43:
            if (r104 == null) goto L45;
            r104.bottomMargin = 0;
        L45:
            r112.f209973e.setVisibility(0);
            int r114 = 0;
        L46:
            GroupMultiItemModel.GroupPosition r107 = r100.getGroupPosition();
            String r108 = r100.getGroupId();
            if (TextUtils.isEmpty(r108) == false) goto L49;
        L61:
            boolean r109 = false;
        L62:
            if (r109 == false) goto L68;
            TextView r115 = r112.f209974f;
            GroupInfo r116 = r112.f209976h.f209968c.f209965b.get(r100.getGroupId());
            if (r116 == null) goto L66;
            String r117 = r116.getGroupName();
        L67:
            r115.setText(r117);
            r112.f209974f.setVisibility(0);
        L69:
            GroupMultiItemModel.GroupPosition r118 = r100.getGroupPosition();
            String r119 = r100.getGroupId();
            if (TextUtils.isEmpty(r119) == false) goto L72;
        L84:
            boolean r120 = false;
        L85:
            if (r120 == false) goto L90;
            TextView r121 = r112.f209975g;
            GroupInfo r122 = r112.f209976h.f209968c.f209965b.get(r100.getGroupId());
            if (r122 == null) goto L89;
            r103 = r122.getBottomDesc();
        L89:
            r121.setText(r103);
            r112.f209975g.setVisibility(0);
        L91:
            r112.f209972d.a(r101, r101, r114, r114);
            r112.f209972d.f226533e = true;
            r112.f209976h.f209968c.t(r112, r100);
            return;
        L90:
            r112.f209975g.setVisibility(8);
            goto L91
        L72:
            if (r112.f209976h.f209968c.f209965b.containsKey(r119) == false) goto L84;
            GroupInfo r123 = r112.f209976h.f209968c.f209965b.get(r119);
            if (r123 == null) goto L76;
            String r124 = r123.getBottomDesc();
        L78:
            if (TextUtils.isEmpty(r124) == true) goto L84;
            if (r118 != GroupMultiItemModel.GroupPosition.BOTTOM) goto L82;
        L83:
            r120 = true;
            goto L85
        L82:
            if (r118 != GroupMultiItemModel.GroupPosition.SINGLE) goto L84;
        L76:
            r124 = null;
            goto L78
        L66:
            r117 = null;
            goto L67
        L68:
            r112.f209974f.setVisibility(8);
            goto L69
        L49:
            if (r112.f209976h.f209968c.f209965b.containsKey(r108) == false) goto L61;
            GroupInfo r125 = r112.f209976h.f209968c.f209965b.get(r108);
            if (r125 == null) goto L53;
            String r126 = r125.getGroupName();
        L55:
            if (TextUtils.isEmpty(r126) == true) goto L61;
            if (r107 != GroupMultiItemModel.GroupPosition.TOP) goto L59;
        L60:
            r109 = true;
            goto L62
        L59:
            if (r107 != GroupMultiItemModel.GroupPosition.SINGLE) goto L61;
        L53:
            r126 = null;
            goto L55
        L16:
            if (r106 != 2) goto L18;
            if (r104 == null) goto L37;
            r104.topMargin = 0;
        L37:
            if (r104 == null) goto L39;
            r104.bottomMargin = 0;
        L39:
            r112.f209973e.setVisibility(0);
            r101 = 0;
        L40:
            r114 = r101;
            r101 = 0;
            goto L46
        L18:
            if (r106 == 3) goto L27;
            if (r104 == null) goto L21;
            r104.topMargin = r105;
        L21:
            if (r104 == null) goto L26;
            if (r113 == true) goto L25;
            r105 = 0;
        L25:
            r104.bottomMargin = r105;
        L26:
            r112.f209973e.setVisibility(8);
            r114 = r101;
            goto L46
        L27:
            if (r104 == null) goto L29;
            r104.topMargin = 0;
        L29:
            if (r104 == null) goto L34;
            if (r113 == true) goto L33;
            r105 = 0;
        L33:
            r104.bottomMargin = r105;
        L34:
            r112.f209973e.setVisibility(8);
            goto L40
        L12:
            r104 = null;
            goto L13
        L8:
            r113 = false;
            goto L9
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.bitable_panel_item_view, r100, false);
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout r103 = (LinearLayout) r102;
            return new ItemViewHolder(this, r103, this.f209968c.u(r103, r101));
        }
    }

    public MultiItemGroupView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MultiItemGroupView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public abstract int r(GroupMultiItemModel r100);

    public abstract void t(MultiItemGroupView<T>.ItemAdapter.ItemViewHolder r100, T r101);

    public abstract View u(ViewGroup r100, int r101);

    public final MultiItemGroupView<T>.ItemAdapter getMItemAdapter() {
        return (ItemAdapter) this.f209964a.getValue();
    }

    public final void setOnItemClickListener(Function1<? super T, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        MultiItemGroupView<T>.ItemAdapter r101 = getMItemAdapter();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        r101.f209967b = r100;
    }

    public final void v(ArrayList<GroupInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "groupInfo");
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        GroupInfo r102 = (GroupInfo) r101.next();
        this.f209965b.put(r102.getGroupId(), r102);
        goto L4
    }

    public final void w(List<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "itemList");
        if (r100.size() <= 1) goto L30;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<T> r102 = r100.iterator();
    L6:
        int r103 = 0;
        if (r102.hasNext() == false) goto L23;
        T r104 = r102.next();
        if (TextUtils.isEmpty(r104.getGroupId()) == false) goto L11;
        r104.setGroupId(r104.getId());
    L11:
        List r105 = (List) r101.get(r104.getGroupId());
        if (r105 == null) goto L13;
        if (r105.size() != 1) goto L20;
        ((GroupMultiItemModel) ListProtector.get(r105, 0)).setGroupPosition(GroupMultiItemModel.GroupPosition.TOP);
    L20:
        if (r105.size() <= 1) goto L22;
        ((GroupMultiItemModel) ListProtector.get(r105, r105.size() - 1)).setGroupPosition(GroupMultiItemModel.GroupPosition.CENTER);
    L22:
        r104.setGroupPosition(GroupMultiItemModel.GroupPosition.BOTTOM);
        r105.add(r104);
        goto L6
    L13:
        ArrayList r106 = new ArrayList();
        r106.add(r104);
        String r107 = r104.getGroupId();
        if (r107 == null) goto L6;
        r101.put(r107, r106);
        goto L6
    L23:
        Iterator r108 = r101.entrySet().iterator();
    L25:
        if (r108.hasNext() == false) goto L30;
        Iterator r109 = ((List) ((Map.Entry) r108.next()).getValue()).iterator();
    L28:
        if (r109.hasNext() == false) goto L25;
        ListProtector.set(r100, r103, (GroupMultiItemModel) r109.next());
        r103 = r103 + 1;
    L30:
        MultiItemGroupView<T>.ItemAdapter r110 = getMItemAdapter();
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "itemList");
        if (Intrinsics.areEqual(r110.f209966a, r100) == true) goto L45;
        ((ArrayList) r110.f209966a).clear();
        ArrayList r111 = (ArrayList) r110.f209966a;
        r111.addAll(r100);
        r110.notifyDataSetChanged();
        return;
    }

    public MultiItemGroupView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f209964a = LazyKt.lazy(new MultiItemGroupView$mItemAdapter$2(this));
        this.f209965b = new HashMap();
        setLayoutManager(new LinearLayoutManager(r100));
        setAdapter(getMItemAdapter());
    }

    public /* synthetic */ MultiItemGroupView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
