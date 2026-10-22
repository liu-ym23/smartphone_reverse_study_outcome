package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.ee.bear.wikiv2.home.api.DisplayTag;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002,-B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110(J\u0014\u0010)\u001a\u00020&2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0(J\u0006\u0010+\u001a\u00020&R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00060\fR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "spaceList", "", "Lcom/bytedance/ee/bear/wikiv2/home/api/SpaceBean;", "spaceListAdapter", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView$SpaceListAdapter;", "leanmode", "Lcom/bytedance/ee/bear/contract/leanmode/LeanMode;", "cachedRelationIds", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "viewDelegate", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView$ViewDelegate;", "getViewDelegate", "()Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView$ViewDelegate;", "setViewDelegate", "(Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView$ViewDelegate;)V", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "getUserComponentAbility", "()Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "setUserComponentAbility", "(Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;)V", "setCacheRelationIds", "", "cacheRelationSpaceIds", "", "setData", "data", "notifyDataSetChanged", "ViewDelegate", "SpaceListAdapter", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceListRvView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SpaceBean> f240731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpaceListAdapter f240732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ww4.a f240733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<String> f240734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f240735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f240736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ce5.a f240737g;

    public final class SpaceListAdapter extends RecyclerView.Adapter<SpaceListViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.ee.bear.wikiv2.icon.a f240738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f240739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WikiSpaceListRvView f240740c;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView$SpaceListAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "olds", "", "Lcom/bytedance/ee/bear/wikiv2/home/api/SpaceBean;", "news", "<init>", "(Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView$SpaceListAdapter;Ljava/util/List;Ljava/util/List;)V", "areItemsTheSame", "", "oldItemPosition", "", "newItemPosition", "getOldListSize", "getNewListSize", "areContentsTheSame", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class DiffCallback extends DiffUtil.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final List<SpaceBean> f240741a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final List<SpaceBean> f240742b;

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public final boolean areContentsTheSame(int r100, int r101) {
                return true;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public final int getNewListSize() {
                return this.f240742b.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public final int getOldListSize() {
                return this.f240741a.size();
            }

            public DiffCallback(List r100, List r101) {
                Intrinsics.checkNotNullParameter(r100, "olds");
                Intrinsics.checkNotNullParameter(r101, "news");
                this.f240741a = r100;
                this.f240742b = r101;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public final boolean areItemsTheSame(int r100, int r101) {
                return Intrinsics.areEqual(((SpaceBean) ListProtector.get(this.f240741a, r100)).space_id, ((SpaceBean) ListProtector.get(this.f240742b, r101)).space_id);
            }
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001d¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView$SpaceListAdapter$SpaceListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView$SpaceListAdapter;Landroid/view/View;)V", "listItem", "Lcom/bytedance/ee/bear/facade/common/widget/recyclerview/SwipeMenuLayout;", "getListItem", "()Lcom/bytedance/ee/bear/facade/common/widget/recyclerview/SwipeMenuLayout;", "setListItem", "(Lcom/bytedance/ee/bear/facade/common/widget/recyclerview/SwipeMenuLayout;)V", "contentView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getContentView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setContentView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "itemName", "Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "getItemName", "()Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "setItemName", "(Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;)V", "itemIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getItemIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "setItemIcon", "(Landroidx/appcompat/widget/AppCompatImageView;)V", UserInfo.UPDATE_TIME, "Landroid/widget/TextView;", "getUpdateTime", "()Landroid/widget/TextView;", "setUpdateTime", "(Landroid/widget/TextView;)V", "itemExternalNotice", "getItemExternalNotice", "setItemExternalNotice", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class SpaceListViewHolder extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final SwipeMenuLayout f240743a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ConstraintLayout f240744b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final SpaceTagTitleView f240745c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final AppCompatImageView f240746d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final TextView f240747e;

            public SpaceListViewHolder(View r100) {
                Intrinsics.checkNotNullParameter(r100, "itemView");
                super(r100);
                this.f240743a = (SwipeMenuLayout) r100.findViewById(R.id.list_item);
                ConstraintLayout r101 = (ConstraintLayout) r100.findViewById(R.id.item_content);
                this.f240744b = r101;
                this.f240745c = (SpaceTagTitleView) r101.findViewById(R.id.item_name);
                this.f240746d = (AppCompatImageView) r101.findViewById(R.id.item_icon);
                this.f240747e = (TextView) r101.findViewById(R.id.update_time);
                AppCompatImageView r102 = (AppCompatImageView) r101.findViewById(R.id.item_external_notice);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f240740c.f240731a).size();
        }

        public SpaceListAdapter(WikiSpaceListRvView r100) {
            this.f240740c = r100;
            this.f240738a = new com.bytedance.ee.bear.wikiv2.icon.a();
            this.f240739b = qc5.a.l();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
            SpaceListViewHolder r112 = (SpaceListViewHolder) r110;
            Intrinsics.checkNotNullParameter(r112, "holder");
            SpaceBean r100 = (SpaceBean) ListProtector.get(this.f240740c.f240731a, r111);
            if (this.f240739b == false) goto L5;
            int r101 = com.bytedance.ee.util.ui.n.d(40);
            com.bytedance.ee.bear.wikiv2.icon.a r102 = this.f240738a;
            String r103 = r100.space_id;
            String r104 = r100.space_name;
            String r105 = r100.space_icon_info;
            com.bytedance.ee.bear.wikiv2.icon.b r106 = new com.bytedance.ee.bear.wikiv2.icon.b(r112.f240746d, R.drawable.ud_icon_wikibook_circle_colorful, r101, r101);
            ce5.a r107 = this.f240740c.getUserComponentAbility();
            r102.getClass();
            com.bytedance.ee.bear.wikiv2.icon.a.a(r103, r104, r105, r106, r107);
        L6:
            r112.f240745c.setTitle(r100.space_name);
            ArrayList r108 = new ArrayList();
            DisplayTag r109 = r100.display_tag;
            boolean r113 = false;
            if (r109 != null) goto L9;
            int r114 = SpaceTagType.f240339e;
            r108.add(SpaceTagType.Companion.d(r100.isOpenSharing()));
            if (r100.isOpenSharing() == false) goto L23;
        L25:
            boolean r115 = false;
        L26:
            r108.add(SpaceTagType.Companion.b(r115));
        L27:
            r112.f240745c.setLabels(r108);
            TextView r116 = r112.f240747e;
            if (TextUtils.isEmpty(r100.description) == true) goto L30;
            String r117 = r100.description;
        L31:
            r116.setText(r117);
            r112.f240743a.setSwipeEnable(false);
            r112.f240744b.setOnClickListener(new d(this.f240740c, r100, r111));
            ConstraintLayout r118 = r112.f240744b;
            if (this.f240740c.getEnable() == true) goto L35;
            Intrinsics.checkNotNullParameter(r100, "<this>");
            if (this.f240740c.f240734d.contains(r100.space_id) == true) goto L35;
        L36:
            r118.setEnabled(r113);
            ConstraintLayout r119 = r112.f240744b;
            if (this.f240740c.getEnable() == true) goto L42;
            Intrinsics.checkNotNullParameter(r100, "<this>");
            if (this.f240740c.f240734d.contains(r100.space_id) == true) goto L42;
            float r120 = 0.3f;
        L43:
            r119.setAlpha(r120);
            return;
        L42:
            r120 = 1.0f;
        L35:
            r113 = true;
            goto L36
        L30:
            r117 = this.f240740c.getResources().getString(R.string.Doc_Wiki_Home_DescriptionEmptyText);
            goto L31
        L23:
            if (r100.isPublicScope() == false) goto L25;
            r115 = true;
            goto L26
        L9:
            if (r109.isValidInSameTenant() != true) goto L11;
            boolean r121 = true;
        L12:
            if (r121 == false) goto L14;
            boolean r122 = up5.i.a(r100.tenant_id);
        L15:
            int r123 = SpaceTagType.f240339e;
            DisplayTag r124 = r100.display_tag;
            if (r124 == null) goto L18;
            String r125 = r124.getTag_value();
        L19:
            r108.add(SpaceTagType.Companion.e(r125, r122));
            goto L27
        L18:
            r125 = null;
            goto L19
        L14:
            r122 = true;
            goto L15
        L11:
            r121 = false;
            goto L12
        L5:
            r112.f240746d.setImageResource(R.drawable.ud_icon_wikibook_circle_colorful);
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            return new SpaceListViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.list_doc_recycler_item, r100, false));
        }
    }

    public interface a {
        void a(SpaceBean r100, int r101);
    }

    public final boolean getEnable() {
        return this.f240735e;
    }

    public final ce5.a getUserComponentAbility() {
        return this.f240737g;
    }

    public final a getViewDelegate() {
        return this.f240736f;
    }

    public final void setCacheRelationIds(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "cacheRelationSpaceIds");
        this.f240734d.clear();
        this.f240734d.addAll(r100);
    }

    public final void setData(List<? extends SpaceBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        SpaceListAdapter r101 = this.f240732b;
        List<SpaceBean> r102 = this.f240731a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "olds");
        Intrinsics.checkNotNullParameter(r100, "news");
        DiffUtil.calculateDiff(new SpaceListAdapter.DiffCallback(r102, r100)).dispatchUpdatesTo(r101);
        ((ArrayList) this.f240731a).clear();
        ArrayList r103 = (ArrayList) this.f240731a;
        r103.addAll(r100);
    }

    public final void setEnable(boolean r100) {
        this.f240735e = r100;
    }

    public final void setUserComponentAbility(ce5.a r100) {
        this.f240737g = r100;
    }

    public final void setViewDelegate(a r100) {
        this.f240736f = r100;
    }

    public WikiSpaceListRvView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f240731a = new ArrayList();
        SpaceListAdapter r102 = new SpaceListAdapter(this);
        this.f240732b = r102;
        this.f240733c = (ww4.a) org.koin.java.a.c(ww4.a.class, null, null, 6);
        this.f240734d = new HashSet();
        this.f240735e = true;
        setLayoutManager(new LinearLayoutManager(getContext()));
        setAdapter(r102);
    }
}
