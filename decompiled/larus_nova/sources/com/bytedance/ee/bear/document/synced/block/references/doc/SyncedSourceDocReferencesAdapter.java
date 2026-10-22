package com.bytedance.ee.bear.document.synced.block.references.doc;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.ee.bear.document.synced.block.references.entity.DocReferencesResult;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larus.nova.R;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mbb.c;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\"#$%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001d\u001a\u00020\u00152\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00190\bj\b\u0012\u0004\u0012\u00020\u0019`\u001f2\u0006\u0010 \u001a\u00020\u0010H\u0007J(\u0010!\u001a\u00020\u00152\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00190\bj\b\u0012\u0004\u0012\u00020\u0019`\u001f2\u0006\u0010 \u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/doc/SyncedSourceDocReferencesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemClickListener", "Lcom/bytedance/ee/bear/document/synced/block/references/doc/SyncedSourceDocReferencesAdapter$ItemClickListener;", "<init>", "(Lcom/bytedance/ee/bear/document/synced/block/references/doc/SyncedSourceDocReferencesAdapter$ItemClickListener;)V", "dataList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/synced/block/references/entity/IReferencesModel;", "lastBreakPoint", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "bindNormal", TemplateNodeType.REF, "Lcom/bytedance/ee/bear/document/synced/block/references/entity/DocReferencesResult$References;", "Lcom/bytedance/ee/bear/document/synced/block/references/doc/SyncedSourceDocReferencesAdapter$NormalViewHolder;", "getLastBreakPoint", "updateBreakPoint", "setData", "data", "Lkotlin/collections/ArrayList;", "noPermissionCount", "appendMore", "Companion", "NormalViewHolder", "TipsViewHolder", "ItemClickListener", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncedSourceDocReferencesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f221919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<a45.a> f221920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f221921c;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/doc/SyncedSourceDocReferencesAdapter$NormalViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "icon", "Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "tagRoot", "Landroid/view/ViewGroup;", "tagFirst", "tagSecond", "<init>", "(Landroid/view/View;Landroid/widget/ImageView;Landroid/widget/TextView;Landroid/view/ViewGroup;Landroid/widget/TextView;Landroid/widget/TextView;)V", "getIcon", "()Landroid/widget/ImageView;", "getTitle", "()Landroid/widget/TextView;", "getTagRoot", "()Landroid/view/ViewGroup;", "getTagFirst", "getTagSecond", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NormalViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f221922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f221923b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ViewGroup f221924c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f221925d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f221926e;

        public NormalViewHolder(View r100) {
            ImageView r101 = (ImageView) r100.findViewById(R.id.icon);
            TextView r102 = (TextView) r100.findViewById(R.id.title);
            ViewGroup r103 = (ViewGroup) r100.findViewById(R.id.tag_root);
            TextView r104 = (TextView) r100.findViewById(R.id.tag_first);
            TextView r105 = (TextView) r100.findViewById(R.id.tag_second);
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "icon");
            Intrinsics.checkNotNullParameter(r102, "title");
            Intrinsics.checkNotNullParameter(r103, "tagRoot");
            Intrinsics.checkNotNullParameter(r104, "tagFirst");
            Intrinsics.checkNotNullParameter(r105, "tagSecond");
            super(r100);
            this.f221922a = r101;
            this.f221923b = r102;
            this.f221924c = r103;
            this.f221925d = r104;
            this.f221926e = r105;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/doc/SyncedSourceDocReferencesAdapter$TipsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "tips", "Landroid/widget/TextView;", "<init>", "(Landroid/view/View;Landroid/widget/TextView;)V", "getTips", "()Landroid/widget/TextView;", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TipsViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f221927a;

        public TipsViewHolder(View r100) {
            TextView r101 = (TextView) r100.findViewById(R.id.bottom_tip);
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "tips");
            super(r100);
            this.f221927a = r101;
        }
    }

    public static final class a {
    }

    public interface b {
        void a(DocReferencesResult.References r100);
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f221920b.size();
    }

    public SyncedSourceDocReferencesAdapter(SyncedSourceDocReferencesFragment.g r100) {
        Intrinsics.checkNotNullParameter(r100, "itemClickListener");
        this.f221919a = r100;
        this.f221920b = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((a45.a) ListProtector.get(this.f221920b, r100)).type();
    }

    public final void y2(DocReferencesResult.References r100) {
        this.f221921c = r100.getObjId() + '-' + r100.getCreateTime();
        StringBuilder r101 = new StringBuilder("lastBreakPoint=");
        r101.append(this.f221921c);
        tt5.a.h("SyncedSourceDocReferencesAdapter", r101.toString());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (r101 >= 0) goto L5;
        return;
    L5:
        if (r101 >= this.f221920b.size()) goto L37;
        a45.a r102 = (a45.a) ListProtector.get(this.f221920b, r101);
        if (r102.type() != 0) goto L33;
        DocReferencesResult.References r103 = (DocReferencesResult.References) r102;
        NormalViewHolder r104 = (NormalViewHolder) r100;
        TextView r105 = r104.f221923b;
        if (TextUtils.isEmpty(r103.getTitle()) == false) goto L12;
        String r106 = LarkContext.getApplication().getString(R.string.Doc_Contract_UntitledDocument);
    L13:
        r105.setText(r106);
        ImageView r107 = r104.f221922a;
        String r108 = r103.getUrl();
        if (r108 != null) goto L16;
        r108 = "";
    L16:
        c.e(r107, r108, IconShape.CIRCLE, new obb.a(IconScene.SYNC_BLOCK));
        if (r103.getPermitted() == true) goto L19;
        r104.f221922a.setAlpha(0.5f);
        r104.f221923b.setTextColor(n.h(r104.itemView.getContext(), R.color.text_disable));
    L21:
        if (TextUtils.isEmpty(r103.getTagFirst()) == true) goto L23;
    L25:
        r104.f221924c.setVisibility(0);
        if (TextUtils.isEmpty(r103.getTagFirst()) == true) goto L28;
        UDTagsDrawable.d.a r109 = new UDTagsDrawable.d.a(r104.itemView.getContext());
        r109.f285353c = r103.getTagFirst();
        r109.c(UDTagsDrawable.TagColorSet.GRAY);
        UDTagsDrawable.d r110 = r109.b();
        TextView r111 = r104.f221925d;
        UDTagsDrawable.a r112 = new UDTagsDrawable.a(r104.itemView.getContext());
        r112.a(r110);
        r111.setBackground(r112.b());
        ViewGroup.LayoutParams r113 = r104.f221925d.getLayoutParams();
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r113).setMarginEnd(cu5.c.b(4));
    L29:
        TextView r114 = r104.f221925d;
        r114.setLayoutParams(r114.getLayoutParams());
        if (TextUtils.isEmpty(r103.getTagSecond()) == true) goto L32;
        UDTagsDrawable.d.a r115 = new UDTagsDrawable.d.a(r104.itemView.getContext());
        r115.f285353c = r103.getTagSecond();
        r115.c(UDTagsDrawable.TagColorSet.GRAY);
        UDTagsDrawable.d r116 = r115.b();
        TextView r117 = r104.f221926e;
        UDTagsDrawable.a r118 = new UDTagsDrawable.a(r104.itemView.getContext());
        r118.a(r116);
        r117.setBackground(r118.b());
    L32:
        r104.itemView.setOnClickListener(new com.bytedance.ee.bear.document.synced.block.references.doc.a(this, r103));
        return;
    L28:
        ViewGroup.LayoutParams r119 = r104.f221925d.getLayoutParams();
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r119).setMarginEnd(0);
        goto L29
    L23:
        if (TextUtils.isEmpty(r103.getTagSecond()) == false) goto L25;
        r104.f221924c.setVisibility(8);
        goto L32
    L19:
        r104.f221922a.setAlpha(1.0f);
        r104.f221923b.setTextColor(n.h(r104.itemView.getContext(), R.color.ud_title_color));
        goto L21
    L12:
        r106 = r103.getTitle();
        goto L13
    L33:
        int r120 = ((a45.b) r102).f1765a;
        ((TipsViewHolder) r100).f221927a.setText(LarkContext.getApplication().getResources().getQuantityString(R.plurals.LarkCCM_Docs_SyncBlock_Hidden_Description, r120, new Object[]{Integer.valueOf(r120)}));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 0) goto L6;
        return new NormalViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.item_synced_source_document, r100, false));
    L6:
        return new TipsViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.item_synced_source_document_tips, r100, false));
    }
}
