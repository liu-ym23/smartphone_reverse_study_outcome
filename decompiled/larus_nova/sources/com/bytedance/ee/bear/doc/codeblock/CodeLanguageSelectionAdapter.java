package com.bytedance.ee.bear.doc.codeblock;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u0016\u0010\u0019\u001a\u00020\u00162\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u0010\u0010\u001a\u001a\u00020\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u0007R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/doc/codeblock/CodeLanguageSelectionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/doc/codeblock/CodeLanguageSelectionAdapter$ViewHolder;", "<init>", "()V", "codeLanguageList", "", "", "selectedCodeLanguage", "selectedChangeListener", "Lcom/bytedance/ee/bear/doc/codeblock/CodeLanguageSelectionAdapter$OnSelectedChangeListener;", "getSelectedChangeListener", "()Lcom/bytedance/ee/bear/doc/codeblock/CodeLanguageSelectionAdapter$OnSelectedChangeListener;", "setSelectedChangeListener", "(Lcom/bytedance/ee/bear/doc/codeblock/CodeLanguageSelectionAdapter$OnSelectedChangeListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "setCodeLanguageList", "setSelectedCodeLanguage", "ViewHolder", "OnSelectedChangeListener", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeLanguageSelectionAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f217760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f217761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f217762c;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/doc/codeblock/CodeLanguageSelectionAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/doc/codeblock/CodeLanguageSelectionAdapter;Landroid/view/View;)V", "codeLanguageType", "Landroid/widget/TextView;", "getCodeLanguageType", "()Landroid/widget/TextView;", "selectedIcon", "Landroid/widget/ImageView;", "getSelectedIcon", "()Landroid/widget/ImageView;", ItemStyle.ITEM_STYLE_DIVIDER, "getDivider", "()Landroid/view/View;", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f217763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f217764b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f217765c;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f217763a = (TextView) r100.findViewById(R.id.code_language_type);
            this.f217764b = (ImageView) r100.findViewById(R.id.selected_icon);
            this.f217765c = r100.findViewById(R.id.divider);
        }
    }

    public interface a {
        void onSelectCodeLanguage(String r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<String> r100 = this.f217760a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public CodeLanguageSelectionAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        List<String> r103 = this.f217760a;
        if (r103 == null) goto L14;
        r102.f217763a.setText((CharSequence) ListProtector.get(r103, r101));
        ImageView r104 = r102.f217764b;
        int r105 = 8;
        if (TextUtils.equals((CharSequence) ListProtector.get(r103, r101), this.f217761b) == false) goto L7;
        int r106 = 0;
    L8:
        r104.setVisibility(r106);
        View r107 = r102.f217765c;
        if (r101 == (getItemCount() - 1)) goto L12;
        r105 = 0;
    L12:
        r107.setVisibility(r105);
        r102.itemView.setOnClickListener(new com.bytedance.ee.bear.doc.codeblock.a(r102, this));
        return;
    L7:
        r106 = 8;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.code_language_selection_item, r100, false);
        Intrinsics.checkNotNull(r102);
        return new ViewHolder(r102);
    }
}
