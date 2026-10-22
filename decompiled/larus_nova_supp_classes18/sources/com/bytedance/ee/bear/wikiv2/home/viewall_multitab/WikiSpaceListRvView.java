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
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.home.api.DisplayTag;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002,-B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110(J\u0014\u0010)\u001a\u00020&2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0(J\u0006\u0010+\u001a\u00020&R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00060\fR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "spaceList", "", "Lcom/bytedance/ee/bear/wikiv2/home/api/SpaceBean;", "spaceListAdapter", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView$SpaceListAdapter;", "leanmode", "Lcom/bytedance/ee/bear/contract/leanmode/LeanMode;", "cachedRelationIds", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "viewDelegate", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView$ViewDelegate;", "getViewDelegate", "()Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView$ViewDelegate;", "setViewDelegate", "(Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView$ViewDelegate;)V", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "getUserComponentAbility", "()Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "setUserComponentAbility", "(Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;)V", "setCacheRelationIds", "", "cacheRelationSpaceIds", "", "setData", WikiFolderPushPlugin.DATA, "notifyDataSetChanged", "ViewDelegate", "SpaceListAdapter", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceListRvView extends RecyclerView {
    public final List<SpaceBean> a;
    public final SpaceListAdapter b;
    public final ww4.a c;
    public final HashSet<String> d;
    public boolean e;
    public a f;
    public ce5.a g;

    public final class SpaceListAdapter extends RecyclerView.Adapter<SpaceListViewHolder> {
        public final com.bytedance.ee.bear.wikiv2.icon.a a;
        public final boolean b;
        public final /* synthetic */ WikiSpaceListRvView c;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView$SpaceListAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "olds", "", "Lcom/bytedance/ee/bear/wikiv2/home/api/SpaceBean;", "news", "<init>", "(Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView$SpaceListAdapter;Ljava/util/List;Ljava/util/List;)V", "areItemsTheSame", "", "oldItemPosition", "", "newItemPosition", "getOldListSize", "getNewListSize", "areContentsTheSame", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class DiffCallback extends DiffUtil.Callback {
            public final List<SpaceBean> a;
            public final List<SpaceBean> b;

            public final boolean areContentsTheSame(int r1, int r2) {
                return true;
            }

            public final int getNewListSize() {
                return this.b.size();
            }

            public final int getOldListSize() {
                return this.a.size();
            }

            public DiffCallback(List r2, List r3) {
                Intrinsics.checkNotNullParameter(r2, "olds");
                Intrinsics.checkNotNullParameter(r3, "news");
                this.a = r2;
                this.b = r3;
            }

            public final boolean areItemsTheSame(int r2, int r3) {
                return Intrinsics.areEqual(((SpaceBean) ListProtector.get(this.a, r2)).space_id, ((SpaceBean) ListProtector.get(this.b, r3)).space_id);
            }
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001d¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView$SpaceListAdapter$SpaceListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView$SpaceListAdapter;Landroid/view/View;)V", "listItem", "Lcom/bytedance/ee/bear/facade/common/widget/recyclerview/SwipeMenuLayout;", "getListItem", "()Lcom/bytedance/ee/bear/facade/common/widget/recyclerview/SwipeMenuLayout;", "setListItem", "(Lcom/bytedance/ee/bear/facade/common/widget/recyclerview/SwipeMenuLayout;)V", "contentView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getContentView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setContentView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "itemName", "Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "getItemName", "()Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "setItemName", "(Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;)V", "itemIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getItemIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "setItemIcon", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "updateTime", "Landroid/widget/TextView;", "getUpdateTime", "()Landroid/widget/TextView;", "setUpdateTime", "(Landroid/widget/TextView;)V", "itemExternalNotice", "getItemExternalNotice", "setItemExternalNotice", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class SpaceListViewHolder extends RecyclerView.ViewHolder {
            public final SwipeMenuLayout a;
            public final ConstraintLayout b;
            public final SpaceTagTitleView c;
            public final AppCompatImageView d;
            public final TextView e;

            public SpaceListViewHolder(View r2) {
                Intrinsics.checkNotNullParameter(r2, "itemView");
                super(r2);
                this.a = r2.findViewById(2131378129);
                ConstraintLayout r3 = r2.findViewById(2131375720);
                this.b = r3;
                this.c = (SpaceTagTitleView) r3.findViewById(2131375808);
                this.d = r3.findViewById(2131375773);
                this.e = (TextView) r3.findViewById(2131391910);
                AppCompatImageView r4 = r3.findViewById(2131375745);
            }
        }

        public final int getItemCount() {
            return ((ArrayList) this.c.a).size();
        }

        public SpaceListAdapter(WikiSpaceListRvView r1) {
            this.c = r1;
            this.a = new com.bytedance.ee.bear.wikiv2.icon.a();
            this.b = qc5.a.l();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
            SpaceListViewHolder r12 = (SpaceListViewHolder) r10;
            Intrinsics.checkNotNullParameter(r12, "holder");
            SpaceBean r0 = (SpaceBean) ListProtector.get(this.c.a, r11);
            if (this.b == false) goto L5;
            int r1 = com.bytedance.ee.util.ui.n.d(40);
            com.bytedance.ee.bear.wikiv2.icon.a r3 = this.a;
            String r4 = r0.space_id;
            String r5 = r0.space_name;
            String r6 = r0.space_icon_info;
            com.bytedance.ee.bear.wikiv2.icon.b r7 = new com.bytedance.ee.bear.wikiv2.icon.b(r12.d, 2131256279, r1, r1);
            ce5.a r2 = this.c.getUserComponentAbility();
            r3.getClass();
            com.bytedance.ee.bear.wikiv2.icon.a.a(r4, r5, r6, r7, r2);
        L6:
            r12.c.setTitle(r0.space_name);
            ArrayList r8 = new ArrayList();
            DisplayTag r9 = r0.display_tag;
            boolean r13 = false;
            if (r9 != null) goto L9;
            int r14 = SpaceTagType.e;
            r8.add(SpaceTagType.Companion.d(r0.isOpenSharing()));
            if (r0.isOpenSharing() == false) goto L23;
        L25:
            boolean r15 = false;
        L26:
            r8.add(SpaceTagType.Companion.b(r15));
        L27:
            r12.c.setLabels(r8);
            TextView r16 = r12.e;
            if (TextUtils.isEmpty(r0.description) == true) goto L30;
            String r17 = r0.description;
        L31:
            r16.setText(r17);
            r12.a.setSwipeEnable(false);
            r12.b.setOnClickListener(new d(this.c, r0, r11));
            ConstraintLayout r18 = r12.b;
            if (this.c.getEnable() == true) goto L35;
            Intrinsics.checkNotNullParameter(r0, "<this>");
            if (this.c.d.contains(r0.space_id) == true) goto L35;
        L36:
            r18.setEnabled(r13);
            ConstraintLayout r19 = r12.b;
            if (this.c.getEnable() == true) goto L42;
            Intrinsics.checkNotNullParameter(r0, "<this>");
            if (this.c.d.contains(r0.space_id) == true) goto L42;
            float r110 = 0.3f;
        L43:
            r19.setAlpha(r110);
            return;
        L42:
            r110 = 1.0f;
        L35:
            r13 = true;
            goto L36
        L30:
            r17 = this.c.getResources().getString(2131888324);
            goto L31
        L23:
            if (r0.isPublicScope() == false) goto L25;
            r15 = true;
            goto L26
        L9:
            if (r9.isValidInSameTenant() != true) goto L11;
            boolean r20 = true;
        L12:
            if (r20 == false) goto L14;
            boolean r21 = up5.i.a(r0.tenant_id);
        L15:
            int r22 = SpaceTagType.e;
            DisplayTag r23 = r0.display_tag;
            if (r23 == null) goto L18;
            String r24 = r23.getTag_value();
        L19:
            r8.add(SpaceTagType.Companion.e(r24, r21));
            goto L27
        L18:
            r24 = null;
            goto L19
        L14:
            r21 = true;
            goto L15
        L11:
            r20 = false;
            goto L12
        L5:
            r12.d.setImageResource(2131256279);
            goto L6
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            return new SpaceListViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131563472, r4, false));
        }
    }

    public interface a {
        void a(SpaceBean r1, int r2);
    }

    public final boolean getEnable() {
        return this.e;
    }

    public final ce5.a getUserComponentAbility() {
        return this.g;
    }

    public final a getViewDelegate() {
        return this.f;
    }

    public final void setCacheRelationIds(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "cacheRelationSpaceIds");
        this.d.clear();
        this.d.addAll(r2);
    }

    public final void setData(List<? extends SpaceBean> r4) {
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.DATA);
        SpaceListAdapter r0 = this.b;
        List<SpaceBean> r1 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "olds");
        Intrinsics.checkNotNullParameter(r4, "news");
        DiffUtil.calculateDiff(new SpaceListAdapter.DiffCallback(r1, r4)).dispatchUpdatesTo(r0);
        ((ArrayList) this.a).clear();
        ArrayList r2 = (ArrayList) this.a;
        r2.addAll(r4);
    }

    public final void setEnable(boolean r1) {
        this.e = r1;
    }

    public final void setUserComponentAbility(ce5.a r1) {
        this.g = r1;
    }

    public final void setViewDelegate(a r1) {
        this.f = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WikiSpaceListRvView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.a = new ArrayList();
        SpaceListAdapter r5 = new SpaceListAdapter(this);
        this.b = r5;
        this.c = (ww4.a) org.koin.java.a.c(ww4.a.class, null, null, 6);
        this.d = new HashSet();
        this.e = true;
        setLayoutManager(new LinearLayoutManager(getContext()));
        setAdapter(r5);
    }
}
