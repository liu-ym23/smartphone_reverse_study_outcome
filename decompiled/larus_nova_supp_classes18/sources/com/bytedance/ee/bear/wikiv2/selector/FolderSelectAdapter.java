package com.bytedance.ee.bear.wikiv2.selector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.x4;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0012\u001a\u00020\u00132\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0015H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/FolderSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/wikiv2/selector/FolderSelectAdapter$ViewHolder;", "context", "Landroid/content/Context;", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/contract/AccountService$Account;)V", "getContext", "()Landroid/content/Context;", "getAccount", "()Lcom/bytedance/ee/bear/contract/AccountService$Account;", "list", "", "Lcom/bytedance/ee/bear/list/dto/Document;", "itemClickListener", "Lcom/bytedance/ee/bear/wikiv2/selector/FolderSelectAdapter$OnItemClickListener;", "setList", "", "getItemCount", "", "setOnItemClickListener", "listener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "ViewHolder", "OnItemClickListener", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderSelectAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final Context a;
    public final AccountService.Account b;
    public List<? extends Document> c;
    public a d;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/FolderSelectAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "contentView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getContentView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setContentView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "itemName", "Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "getItemName", "()Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "setItemName", "(Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;)V", "itemIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getItemIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "setItemIcon", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "updateTime", "Landroid/widget/TextView;", "getUpdateTime", "()Landroid/widget/TextView;", "setUpdateTime", "(Landroid/widget/TextView;)V", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final ConstraintLayout a;
        public final SpaceTagTitleView b;
        public final AppCompatImageView c;
        public final TextView d;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131375720);
            this.c = r2.findViewById(2131375773);
            this.b = (SpaceTagTitleView) r2.findViewById(2131375808);
            this.d = (TextView) r2.findViewById(2131391910);
        }
    }

    public interface a {
        void a(View r1, int r2, Document r3);
    }

    public final int getItemCount() {
        return hu5.a.c(this.c);
    }

    public final Context getContext() {
        return this.a;
    }

    public FolderSelectAdapter(Context r2, AccountService.Account r3) {
        Intrinsics.checkNotNullParameter(r3, "account");
        this.a = r2;
        this.b = r3;
        this.c = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        ViewHolder r10 = (ViewHolder) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        Document r0 = (Document) ListProtector.get(this.c, r9);
        r10.a.setTag(Integer.valueOf(r9));
        r10.b.setTitle(t0.g(this.a, r0));
        SpaceTagTitleView r1 = r10.b;
        SpaceTagType[] r2 = new SpaceTagType[2];
        int r3 = SpaceTagType.e;
        boolean r4 = true;
        if (r0.x == false) goto L7;
        int r5 = x4.a;
        if (x4.a(this.b) == false) goto L7;
        boolean r6 = true;
    L8:
        r2[0] = SpaceTagType.Companion.c(r6);
        r2[1] = SpaceTagType.Companion.h(r0.z);
        r1.setLabels(r2);
        r10.d.setText(t0.D(this.a, r0));
        AppCompatImageView r7 = r10.c;
        FolderVersion.a r11 = FolderVersion.Companion;
        int r12 = r0.L1;
        boolean r13 = r0.P1;
        r11.getClass();
        if (FolderVersion.a.a(r12, r13) == false) goto L11;
        int r14 = ua5.a.i(sbb.e.f.b);
    L12:
        r7.setImageResource(r14);
        SelectorConfig.CREATOR.getClass();
        WeakReference<td5.a> r15 = SelectorConfig.k;
        if (r15 == null) goto L19;
        td5.a r16 = r15.get();
        if (r16 == null) goto L19;
        if (r16.a(r0) == true) goto L19;
    L20:
        if (r4 == false) goto L22;
        ((RecyclerView.ViewHolder) r10).itemView.setAlpha(0.3f);
        r10.a.setOnClickListener(new b(r0, this));
        return;
    L22:
        ((RecyclerView.ViewHolder) r10).itemView.setAlpha(1.0f);
        r10.a.setOnClickListener(new c(this, r9, r0));
        return;
    L19:
        r4 = false;
        goto L20
    L11:
        r14 = rbb.b.g();
    L7:
        r6 = false;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131563473, r4, false));
    }
}
