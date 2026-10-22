package com.bytedance.ee.bear.document.synced.block.references.doc;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.bear.document.synced.block.references.entity.DocReferencesResult;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mbb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\"#$%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001d\u001a\u00020\u00152\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00190\bj\b\u0012\u0004\u0012\u00020\u0019`\u001f2\u0006\u0010 \u001a\u00020\u0010H\u0007J(\u0010!\u001a\u00020\u00152\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00190\bj\b\u0012\u0004\u0012\u00020\u0019`\u001f2\u0006\u0010 \u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/doc/SyncedSourceDocReferencesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemClickListener", "Lcom/bytedance/ee/bear/document/synced/block/references/doc/SyncedSourceDocReferencesAdapter$ItemClickListener;", "<init>", "(Lcom/bytedance/ee/bear/document/synced/block/references/doc/SyncedSourceDocReferencesAdapter$ItemClickListener;)V", "dataList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/synced/block/references/entity/IReferencesModel;", "lastBreakPoint", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "bindNormal", "ref", "Lcom/bytedance/ee/bear/document/synced/block/references/entity/DocReferencesResult$References;", "Lcom/bytedance/ee/bear/document/synced/block/references/doc/SyncedSourceDocReferencesAdapter$NormalViewHolder;", "getLastBreakPoint", "updateBreakPoint", "setData", "data", "Lkotlin/collections/ArrayList;", "noPermissionCount", "appendMore", "Companion", "NormalViewHolder", "TipsViewHolder", "ItemClickListener", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncedSourceDocReferencesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final b a;
    public ArrayList<a45.a> b;
    public String c;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/doc/SyncedSourceDocReferencesAdapter$NormalViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", CustomHeaderConfig.Menu.Style.ICON_STYLE, "Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "tagRoot", "Landroid/view/ViewGroup;", "tagFirst", "tagSecond", "<init>", "(Landroid/view/View;Landroid/widget/ImageView;Landroid/widget/TextView;Landroid/view/ViewGroup;Landroid/widget/TextView;Landroid/widget/TextView;)V", "getIcon", "()Landroid/widget/ImageView;", "getTitle", "()Landroid/widget/TextView;", "getTagRoot", "()Landroid/view/ViewGroup;", "getTagFirst", "getTagSecond", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NormalViewHolder extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final TextView b;
        public final ViewGroup c;
        public final TextView d;
        public final TextView e;

        public NormalViewHolder(View r7) {
            ImageView r0 = (ImageView) r7.findViewById(2131374718);
            TextView r1 = (TextView) r7.findViewById(2131388772);
            ViewGroup r2 = (ViewGroup) r7.findViewById(2131388129);
            TextView r3 = (TextView) r7.findViewById(2131388095);
            TextView r4 = (TextView) r7.findViewById(2131388131);
            Intrinsics.checkNotNullParameter(r7, "itemView");
            Intrinsics.checkNotNullParameter(r0, CustomHeaderConfig.Menu.Style.ICON_STYLE);
            Intrinsics.checkNotNullParameter(r1, "title");
            Intrinsics.checkNotNullParameter(r2, "tagRoot");
            Intrinsics.checkNotNullParameter(r3, "tagFirst");
            Intrinsics.checkNotNullParameter(r4, "tagSecond");
            super(r7);
            this.a = r0;
            this.b = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/doc/SyncedSourceDocReferencesAdapter$TipsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "tips", "Landroid/widget/TextView;", "<init>", "(Landroid/view/View;Landroid/widget/TextView;)V", "getTips", "()Landroid/widget/TextView;", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TipsViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;

        public TipsViewHolder(View r3) {
            TextView r0 = (TextView) r3.findViewById(2131364538);
            Intrinsics.checkNotNullParameter(r3, "itemView");
            Intrinsics.checkNotNullParameter(r0, "tips");
            super(r3);
            this.a = r0;
        }
    }

    public static final class a {
    }

    public interface b {
        void a(DocReferencesResult.References r1);
    }

    static {
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public SyncedSourceDocReferencesAdapter(SyncedSourceDocReferencesFragment.g r2) {
        Intrinsics.checkNotNullParameter(r2, "itemClickListener");
        this.a = r2;
        this.b = new ArrayList();
    }

    public final int getItemViewType(int r2) {
        return ((a45.a) ListProtector.get(this.b, r2)).type();
    }

    public final void y2(DocReferencesResult.References r3) {
        this.c = r3.getObjId() + '-' + r3.getCreateTime();
        StringBuilder r4 = new StringBuilder("lastBreakPoint=");
        r4.append(this.c);
        tt5.a.h("SyncedSourceDocReferencesAdapter", r4.toString());
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        if (r8 >= 0) goto L5;
        return;
    L5:
        if (r8 >= this.b.size()) goto L37;
        a45.a r9 = (a45.a) ListProtector.get(this.b, r8);
        if (r9.type() != 0) goto L33;
        DocReferencesResult.References r10 = (DocReferencesResult.References) r9;
        NormalViewHolder r11 = (NormalViewHolder) r7;
        TextView r0 = r11.b;
        if (TextUtils.isEmpty(r10.getTitle()) == false) goto L12;
        String r2 = LarkContext.getApplication().getString(2131887640);
    L13:
        r0.setText(r2);
        ImageView r1 = r11.a;
        String r3 = r10.getUrl();
        if (r3 != null) goto L16;
        r3 = "";
    L16:
        c.e(r1, r3, IconShape.CIRCLE, new obb.a(IconScene.SYNC_BLOCK));
        if (r10.getPermitted() == true) goto L19;
        r11.a.setAlpha(0.5f);
        r11.b.setTextColor(n.h(((RecyclerView.ViewHolder) r11).itemView.getContext(), 2131106610));
    L21:
        if (TextUtils.isEmpty(r10.getTagFirst()) == true) goto L23;
    L25:
        r11.c.setVisibility(0);
        if (TextUtils.isEmpty(r10.getTagFirst()) == true) goto L28;
        UDTagsDrawable.d.a r4 = new UDTagsDrawable.d.a(((RecyclerView.ViewHolder) r11).itemView.getContext());
        r4.c = r10.getTagFirst();
        r4.c(UDTagsDrawable.TagColorSet.GRAY);
        UDTagsDrawable.d r5 = r4.b();
        TextView r6 = r11.d;
        UDTagsDrawable.a r12 = new UDTagsDrawable.a(((RecyclerView.ViewHolder) r11).itemView.getContext());
        r12.a(r5);
        r6.setBackground(r12.b());
        ViewGroup.LayoutParams r13 = r11.d.getLayoutParams();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r13).setMarginEnd(cu5.c.b(4));
    L29:
        TextView r14 = r11.d;
        r14.setLayoutParams(r14.getLayoutParams());
        if (TextUtils.isEmpty(r10.getTagSecond()) == true) goto L32;
        UDTagsDrawable.d.a r16 = new UDTagsDrawable.d.a(((RecyclerView.ViewHolder) r11).itemView.getContext());
        r16.c = r10.getTagSecond();
        r16.c(UDTagsDrawable.TagColorSet.GRAY);
        UDTagsDrawable.d r17 = r16.b();
        TextView r18 = r11.e;
        UDTagsDrawable.a r19 = new UDTagsDrawable.a(((RecyclerView.ViewHolder) r11).itemView.getContext());
        r19.a(r17);
        r18.setBackground(r19.b());
    L32:
        ((RecyclerView.ViewHolder) r11).itemView.setOnClickListener(new com.bytedance.ee.bear.document.synced.block.references.doc.a(this, r10));
        return;
    L28:
        ViewGroup.LayoutParams r20 = r11.d.getLayoutParams();
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r20).setMarginEnd(0);
        goto L29
    L23:
        if (TextUtils.isEmpty(r10.getTagSecond()) == false) goto L25;
        r11.c.setVisibility(8);
        goto L32
    L19:
        r11.a.setAlpha(1.0f);
        r11.b.setTextColor(n.h(((RecyclerView.ViewHolder) r11).itemView.getContext(), 2131109000));
        goto L21
    L12:
        r2 = r10.getTitle();
        goto L13
    L33:
        int r21 = ((a45.b) r9).a;
        ((TipsViewHolder) r7).a.setText(LarkContext.getApplication().getResources().getQuantityString(2131755033, r21, new Object[]{Integer.valueOf(r21)}));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != 0) goto L6;
        return new NormalViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131561705, r4, false));
    L6:
        return new TipsViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131561706, r4, false));
    }
}
