package com.bytedance.ee.docsdk.impl.document.plugins.codeblock;

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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0016\u0010\u0018\u001a\u00020\u00112\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u0010\u0010\u0019\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u0006R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionAdapter$ViewHolder;", "()V", "codeLanguageList", "", "", "selectedChangeListener", "Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionAdapter$OnSelectedChangeListener;", "getSelectedChangeListener", "()Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionAdapter$OnSelectedChangeListener;", "setSelectedChangeListener", "(Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionAdapter$OnSelectedChangeListener;)V", "selectedCodeLanguage", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCodeLanguageList", "setSelectedCodeLanguage", "OnSelectedChangeListener", "ViewHolder", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CodeLanguageSelectionAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<String> codeLanguageList;
    private OnSelectedChangeListener selectedChangeListener;
    private String selectedCodeLanguage;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionAdapter$OnSelectedChangeListener;", "", "onSelectCodeLanguage", "", "codeLanguage", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnSelectedChangeListener {
        void onSelectCodeLanguage(String r100);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionAdapter;Landroid/view/View;)V", "codeLanguageType", "Landroid/widget/TextView;", "getCodeLanguageType", "()Landroid/widget/TextView;", ItemStyle.ITEM_STYLE_DIVIDER, "getDivider", "()Landroid/view/View;", "selectedIcon", "Landroid/widget/ImageView;", "getSelectedIcon", "()Landroid/widget/ImageView;", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView codeLanguageType;
        private final View divider;
        private final ImageView selectedIcon;
        final /* synthetic */ CodeLanguageSelectionAdapter this$0;

        public final TextView getCodeLanguageType() {
            return this.codeLanguageType;
        }

        public final View getDivider() {
            return this.divider;
        }

        public final ImageView getSelectedIcon() {
            return this.selectedIcon;
        }

        public ViewHolder(CodeLanguageSelectionAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.this$0 = r100;
            super(r101);
            this.codeLanguageType = (TextView) r101.findViewById(R.id.code_language_type);
            this.selectedIcon = (ImageView) r101.findViewById(R.id.selected_icon);
            this.divider = r101.findViewById(R.id.divider);
        }
    }

    public static /* synthetic */ void y2(ViewHolder r100, CodeLanguageSelectionAdapter r101, View r102) {
        onBindViewHolder$lambda$1$lambda$0(r100, r101, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> r100 = this.codeLanguageList;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public CodeLanguageSelectionAdapter() {
    }

    public final OnSelectedChangeListener getSelectedChangeListener() {
        return this.selectedChangeListener;
    }

    public final void setCodeLanguageList(List<String> r100) {
        this.codeLanguageList = r100;
    }

    public final void setSelectedChangeListener(OnSelectedChangeListener r100) {
        this.selectedChangeListener = r100;
    }

    public final void setSelectedCodeLanguage(String r100) {
        this.selectedCodeLanguage = r100;
    }

    public void onBindViewHolder(final ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        List<String> r102 = this.codeLanguageList;
        if (r102 == null) goto L13;
        r100.getCodeLanguageType().setText((CharSequence) ListProtector.get(r102, r101));
        ImageView r103 = r100.getSelectedIcon();
        int r104 = 0;
        if (TextUtils.equals((CharSequence) ListProtector.get(r102, r101), this.selectedCodeLanguage) == false) goto L7;
        int r105 = 0;
    L8:
        r103.setVisibility(r105);
        View r106 = r100.getDivider();
        if (r101 != (getItemCount() - 1)) goto L11;
        r104 = 8;
    L11:
        r106.setVisibility(r104);
        r100.itemView.setOnClickListener(new b(r100, this));
        return;
    L7:
        r105 = 8;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.code_language_selection_item, r100, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        onBindViewHolder((ViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return onCreateViewHolder(r100, r101);
    }

    private static final void onBindViewHolder$lambda$1$lambda$0(ViewHolder r100, CodeLanguageSelectionAdapter r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "$holder");
        Intrinsics.checkNotNullParameter(r101, "this$0");
        String r103 = r100.getCodeLanguageType().getText().toString();
        r100.getSelectedIcon().setVisibility(0);
        OnSelectedChangeListener r104 = r101.selectedChangeListener;
        if (r104 == null) goto L5;
        r104.onSelectCodeLanguage(r103);
    L5:
        r101.setSelectedCodeLanguage(r103);
        r101.notifyDataSetChanged();
    }
}
