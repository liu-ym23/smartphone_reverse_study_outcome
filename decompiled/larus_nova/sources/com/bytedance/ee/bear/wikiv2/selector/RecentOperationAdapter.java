package com.bytedance.ee.bear.wikiv2.selector;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.list.x4;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003+,-B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u000e\u0010%\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020$H\u0016J\b\u0010*\u001a\u00020$H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationAdapter$ViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "list", "", "Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationResult$IRecentData;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "listener", "Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationAdapter$OnItemClickListener;", "getListener", "()Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationAdapter$OnItemClickListener;", "setListener", "(Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationAdapter$OnItemClickListener;)V", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "getAccount", "()Lcom/bytedance/ee/bear/contract/AccountService$Account;", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "getUserComponentAbility", "()Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "setUserComponentAbility", "(Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "setOnItemClickListener", "", "onBindViewHolder", "holder", "position", "getItemCount", "Companion", "ViewHolder", "OnItemClickListener", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecentOperationAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f241104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends RecentOperationResult.a> f241105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f241106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AccountService$Account f241107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ce5.a f241108e;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "contentView", "Landroid/widget/LinearLayout;", "getContentView", "()Landroid/widget/LinearLayout;", "setContentView", "(Landroid/widget/LinearLayout;)V", "itemName", "Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "getItemName", "()Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "setItemName", "(Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;)V", "itemIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getItemIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "setItemIcon", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinearLayout f241109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SpaceTagTitleView f241110b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AppCompatImageView f241111c;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            LinearLayout r101 = (LinearLayout) r100.findViewById(R.id.item_content);
            this.f241109a = r101;
            this.f241110b = (SpaceTagTitleView) r101.findViewById(R.id.item_name);
            this.f241111c = (AppCompatImageView) r101.findViewById(R.id.item_icon);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(View r100, int r101, RecentOperationResult.FolderInfo r102);

        void b(View r100, int r101, RecentOperationResult.WikiInfo r102);
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<? extends RecentOperationResult.a> r100 = this.f241105b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public final Context getContext() {
        return this.f241104a;
    }

    public RecentOperationAdapter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f241104a = r100;
        this.f241107d = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        ViewHolder r112 = (ViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        List<? extends RecentOperationResult.a> r100 = this.f241105b;
        UserSession r101 = null;
        if (r100 == null) goto L5;
        RecentOperationResult.a r102 = (RecentOperationResult.a) ListProtector.get(r100, r111);
    L6:
        if (r102 != null) goto L8;
        tt5.a.h("RecentOperationAdapter", "recentData is null, return.");
        return;
    L8:
        r112.f241109a.setOnClickListener(new r(r102, this, r111));
        r112.f241110b.setTitle(r102.title(this.f241104a));
        SpaceTagTitleView r113 = r112.f241110b;
        boolean r103 = true;
        SpaceTagType[] r104 = new SpaceTagType[1];
        int r105 = SpaceTagType.f240339e;
        if (r102.external() == false) goto L13;
        int r106 = x4.f229847a;
        if (x4.a(this.f241107d) == false) goto L13;
    L14:
        r104[0] = SpaceTagType.Companion.c(r103);
        r113.setLabels(r104);
        if (TextUtils.isEmpty(r102.description()) == false) goto L19;
        ViewGroup.LayoutParams r114 = r112.f241110b.getLayoutParams();
        if ((r114 instanceof ConstraintLayout.LayoutParams) == false) goto L22;
        ConstraintLayout.LayoutParams r115 = (ConstraintLayout.LayoutParams) r114;
        r115.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r115).bottomMargin = com.bytedance.ee.util.ui.n.d(12);
    L22:
        AppCompatImageView r107 = r112.f241111c;
        String r108 = r102.token();
        int r109 = r102.type();
        String r116 = r102.iconInfo();
        IconShape r117 = IconShape.SQUARE;
        obb.a r118 = new obb.a(Boolean.FALSE, Boolean.valueOf(r102.isShareFolderWithOwner()), null);
        r118.b(IconScene.MQC);
        ce5.a r119 = this.f241108e;
        if (r119 == null) goto L25;
        r101 = r119.f23447b;
    L25:
        r118.f522636g = r101;
        Unit r120 = Unit.INSTANCE;
        mbb.c.d(r107, r108, r109, r116, r117, r118);
        return;
    L19:
        ViewGroup.LayoutParams r121 = r112.f241110b.getLayoutParams();
        if ((r121 instanceof ConstraintLayout.LayoutParams) == false) goto L22;
        ConstraintLayout.LayoutParams r122 = (ConstraintLayout.LayoutParams) r121;
        r122.bottomToBottom = -1;
        ((ViewGroup.MarginLayoutParams) r122).bottomMargin = 0;
    L13:
        r103 = false;
        goto L14
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.selector_doc_recycler_item_content, r100, false));
    }
}
