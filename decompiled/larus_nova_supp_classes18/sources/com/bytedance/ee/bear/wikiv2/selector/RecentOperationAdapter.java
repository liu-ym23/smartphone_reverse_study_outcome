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
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.list.x4;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003+,-B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u000e\u0010%\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020$H\u0016J\b\u0010*\u001a\u00020$H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationAdapter$ViewHolder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "list", "", "Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationResult$IRecentData;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "listener", "Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationAdapter$OnItemClickListener;", "getListener", "()Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationAdapter$OnItemClickListener;", "setListener", "(Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationAdapter$OnItemClickListener;)V", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "getAccount", "()Lcom/bytedance/ee/bear/contract/AccountService$Account;", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "getUserComponentAbility", "()Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "setUserComponentAbility", "(Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "setOnItemClickListener", "", "onBindViewHolder", "holder", "position", "getItemCount", "Companion", "ViewHolder", "OnItemClickListener", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecentOperationAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final Context a;
    public List<? extends RecentOperationResult.a> b;
    public b c;
    public final AccountService.Account d;
    public ce5.a e;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "contentView", "Landroid/widget/LinearLayout;", "getContentView", "()Landroid/widget/LinearLayout;", "setContentView", "(Landroid/widget/LinearLayout;)V", "itemName", "Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "getItemName", "()Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "setItemName", "(Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;)V", "itemIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getItemIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "setItemIcon", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final LinearLayout a;
        public final SpaceTagTitleView b;
        public final AppCompatImageView c;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            LinearLayout r3 = (LinearLayout) r2.findViewById(2131375720);
            this.a = r3;
            this.b = (SpaceTagTitleView) r3.findViewById(2131375808);
            this.c = r3.findViewById(2131375773);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(View r1, int r2, RecentOperationResult.FolderInfo r3);

        void b(View r1, int r2, RecentOperationResult.WikiInfo r3);
    }

    static {
    }

    public final int getItemCount() {
        List<? extends RecentOperationResult.a> r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final Context getContext() {
        return this.a;
    }

    public RecentOperationAdapter(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r3;
        this.d = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r13, int r14) {
        ViewHolder r15 = (ViewHolder) r13;
        Intrinsics.checkNotNullParameter(r15, "holder");
        List<? extends RecentOperationResult.a> r0 = this.b;
        UserSession r1 = null;
        if (r0 == null) goto L5;
        RecentOperationResult.a r2 = (RecentOperationResult.a) ListProtector.get(r0, r14);
    L6:
        if (r2 != null) goto L8;
        tt5.a.h("RecentOperationAdapter", "recentData is null, return.");
        return;
    L8:
        r15.a.setOnClickListener(new r(r2, this, r14));
        r15.b.setTitle(r2.title(this.a));
        SpaceTagTitleView r16 = r15.b;
        boolean r3 = true;
        SpaceTagType[] r4 = new SpaceTagType[1];
        int r5 = SpaceTagType.e;
        if (r2.external() == false) goto L13;
        int r6 = x4.a;
        if (x4.a(this.d) == false) goto L13;
    L14:
        r4[0] = SpaceTagType.Companion.c(r3);
        r16.setLabels(r4);
        if (TextUtils.isEmpty(r2.description()) == false) goto L19;
        ConstraintLayout.LayoutParams r17 = r15.b.getLayoutParams();
        if ((r17 instanceof ConstraintLayout.LayoutParams) == false) goto L22;
        ConstraintLayout.LayoutParams r18 = r17;
        r18.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r18).bottomMargin = com.bytedance.ee.util.ui.n.d(12);
    L22:
        AppCompatImageView r7 = r15.c;
        String r8 = r2.token();
        int r9 = r2.type();
        String r10 = r2.iconInfo();
        IconShape r11 = IconShape.SQUARE;
        obb.a r12 = new obb.a(Boolean.FALSE, Boolean.valueOf(r2.isShareFolderWithOwner()), null);
        r12.b(IconScene.MQC);
        ce5.a r19 = this.e;
        if (r19 == null) goto L25;
        r1 = r19.b;
    L25:
        r12.g = r1;
        Unit r110 = Unit.INSTANCE;
        mbb.c.d(r7, r8, r9, r10, r11, r12);
        return;
    L19:
        ConstraintLayout.LayoutParams r111 = r15.b.getLayoutParams();
        if ((r111 instanceof ConstraintLayout.LayoutParams) == false) goto L22;
        ConstraintLayout.LayoutParams r112 = r111;
        r112.bottomToBottom = -1;
        ((ViewGroup.MarginLayoutParams) r112).bottomMargin = 0;
    L13:
        r3 = false;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131564506, r4, false));
    }
}
