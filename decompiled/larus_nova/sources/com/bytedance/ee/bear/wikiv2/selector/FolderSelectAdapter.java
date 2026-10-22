package com.bytedance.ee.bear.wikiv2.selector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.x4;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0012\u001a\u00020\u00132\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0015H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/FolderSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/wikiv2/selector/FolderSelectAdapter$ViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/contract/AccountService$Account;)V", "getContext", "()Landroid/content/Context;", "getAccount", "()Lcom/bytedance/ee/bear/contract/AccountService$Account;", "list", "", "Lcom/bytedance/ee/bear/list/dto/Document;", "itemClickListener", "Lcom/bytedance/ee/bear/wikiv2/selector/FolderSelectAdapter$OnItemClickListener;", "setList", "", "getItemCount", "", "setOnItemClickListener", "listener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "ViewHolder", "OnItemClickListener", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderSelectAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f241075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AccountService$Account f241076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<? extends Document> f241077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f241078d;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/FolderSelectAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "contentView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getContentView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setContentView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "itemName", "Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "getItemName", "()Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "setItemName", "(Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;)V", "itemIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getItemIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "setItemIcon", "(Landroidx/appcompat/widget/AppCompatImageView;)V", UserInfo.UPDATE_TIME, "Landroid/widget/TextView;", "getUpdateTime", "()Landroid/widget/TextView;", "setUpdateTime", "(Landroid/widget/TextView;)V", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConstraintLayout f241079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SpaceTagTitleView f241080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AppCompatImageView f241081c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f241082d;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f241079a = (ConstraintLayout) r100.findViewById(R.id.item_content);
            this.f241081c = (AppCompatImageView) r100.findViewById(R.id.item_icon);
            this.f241080b = (SpaceTagTitleView) r100.findViewById(R.id.item_name);
            this.f241082d = (TextView) r100.findViewById(R.id.update_time);
        }
    }

    public interface a {
        void a(View r100, int r101, Document r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return hu5.a.c(this.f241077c);
    }

    public final Context getContext() {
        return this.f241075a;
    }

    public FolderSelectAdapter(Context r100, AccountService$Account r101) {
        Intrinsics.checkNotNullParameter(r101, "account");
        this.f241075a = r100;
        this.f241076b = r101;
        this.f241077c = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Document r103 = (Document) ListProtector.get(this.f241077c, r101);
        r102.f241079a.setTag(Integer.valueOf(r101));
        r102.f241080b.setTitle(t0.g(this.f241075a, r103));
        SpaceTagTitleView r104 = r102.f241080b;
        SpaceTagType[] r105 = new SpaceTagType[2];
        int r106 = SpaceTagType.f240339e;
        boolean r107 = true;
        if (r103.f227904x == false) goto L7;
        int r108 = x4.f229847a;
        if (x4.a(this.f241076b) == false) goto L7;
        boolean r109 = true;
    L8:
        r105[0] = SpaceTagType.Companion.c(r109);
        r105[1] = SpaceTagType.Companion.h(r103.f227910z);
        r104.setLabels(r105);
        r102.f241082d.setText(t0.D(this.f241075a, r103));
        AppCompatImageView r110 = r102.f241081c;
        FolderVersion.a r111 = FolderVersion.Companion;
        int r112 = r103.L1;
        boolean r113 = r103.P1;
        r111.getClass();
        if (FolderVersion.a.a(r112, r113) == false) goto L11;
        int r114 = ua5.a.i(sbb.e.f541295f.f541317b);
    L12:
        r110.setImageResource(r114);
        SelectorConfig.CREATOR.getClass();
        WeakReference<td5.a> r115 = SelectorConfig.f229368k;
        if (r115 == null) goto L19;
        td5.a r116 = r115.get();
        if (r116 == null) goto L19;
        if (r116.a(r103) == true) goto L19;
    L20:
        if (r107 == false) goto L22;
        r102.itemView.setAlpha(0.3f);
        r102.f241079a.setOnClickListener(new b(r103, this));
        return;
    L22:
        r102.itemView.setAlpha(1.0f);
        r102.f241079a.setOnClickListener(new c(this, r101, r103));
        return;
    L19:
        r107 = false;
        goto L20
    L11:
        r114 = rbb.b.g();
    L7:
        r109 = false;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.list_doc_recycler_item_content, r100, false));
    }
}
