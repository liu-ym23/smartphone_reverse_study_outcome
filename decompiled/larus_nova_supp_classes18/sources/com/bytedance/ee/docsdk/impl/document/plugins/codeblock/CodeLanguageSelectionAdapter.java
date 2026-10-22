package com.bytedance.ee.docsdk.impl.document.plugins.codeblock;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0016\u0010\u0018\u001a\u00020\u00112\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u0010\u0010\u0019\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u0006R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionAdapter$ViewHolder;", "()V", "codeLanguageList", "", "", "selectedChangeListener", "Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionAdapter$OnSelectedChangeListener;", "getSelectedChangeListener", "()Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionAdapter$OnSelectedChangeListener;", "setSelectedChangeListener", "(Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionAdapter$OnSelectedChangeListener;)V", "selectedCodeLanguage", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCodeLanguageList", "setSelectedCodeLanguage", "OnSelectedChangeListener", "ViewHolder", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CodeLanguageSelectionAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<String> codeLanguageList;
    private OnSelectedChangeListener selectedChangeListener;
    private String selectedCodeLanguage;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionAdapter$OnSelectedChangeListener;", "", "onSelectCodeLanguage", "", "codeLanguage", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnSelectedChangeListener {
        void onSelectCodeLanguage(String r1);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionAdapter;Landroid/view/View;)V", "codeLanguageType", "Landroid/widget/TextView;", "getCodeLanguageType", "()Landroid/widget/TextView;", "divider", "getDivider", "()Landroid/view/View;", "selectedIcon", "Landroid/widget/ImageView;", "getSelectedIcon", "()Landroid/widget/ImageView;", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

        public ViewHolder(CodeLanguageSelectionAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.this$0 = r2;
            super(r3);
            this.codeLanguageType = (TextView) r3.findViewById(2131367082);
            this.selectedIcon = (ImageView) r3.findViewById(2131385840);
            this.divider = r3.findViewById(2131369197);
        }
    }

    public static /* synthetic */ void y2(ViewHolder r0, CodeLanguageSelectionAdapter r1, View r2) {
        onBindViewHolder$lambda$1$lambda$0(r0, r1, r2);
    }

    public int getItemCount() {
        List<String> r0 = this.codeLanguageList;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public CodeLanguageSelectionAdapter() {
    }

    public final OnSelectedChangeListener getSelectedChangeListener() {
        return this.selectedChangeListener;
    }

    public final void setCodeLanguageList(List<String> r1) {
        this.codeLanguageList = r1;
    }

    public final void setSelectedChangeListener(OnSelectedChangeListener r1) {
        this.selectedChangeListener = r1;
    }

    public final void setSelectedCodeLanguage(String r1) {
        this.selectedCodeLanguage = r1;
    }

    public void onBindViewHolder(final ViewHolder r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        List<String> r0 = this.codeLanguageList;
        if (r0 == null) goto L13;
        r5.getCodeLanguageType().setText((CharSequence) ListProtector.get(r0, r6));
        ImageView r1 = r5.getSelectedIcon();
        int r2 = 0;
        if (TextUtils.equals((CharSequence) ListProtector.get(r0, r6), this.selectedCodeLanguage) == false) goto L7;
        int r3 = 0;
    L8:
        r1.setVisibility(r3);
        View r4 = r5.getDivider();
        if (r6 != (getItemCount() - 1)) goto L11;
        r2 = 8;
    L11:
        r4.setVisibility(r2);
        ((RecyclerView.ViewHolder) r5).itemView.setOnClickListener(new b(r5, this));
        return;
    L7:
        r3 = 8;
        goto L8
    }

    /* JADX INFO: renamed from: onCreateViewHolder, reason: collision with other method in class */
    public ViewHolder m742onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new ViewHolder(this, LayoutInflater.from(r3.getContext()).inflate(2131559843, r3, false));
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((ViewHolder) r1, r2);
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return m742onCreateViewHolder(r1, r2);
    }

    private static final void onBindViewHolder$lambda$1$lambda$0(ViewHolder r1, CodeLanguageSelectionAdapter r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "$holder");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        String r4 = r1.getCodeLanguageType().getText().toString();
        r1.getSelectedIcon().setVisibility(0);
        OnSelectedChangeListener r5 = r2.selectedChangeListener;
        if (r5 == null) goto L5;
        r5.onSelectCodeLanguage(r4);
    L5:
        r2.setSelectedCodeLanguage(r4);
        r2.notifyDataSetChanged();
    }
}
