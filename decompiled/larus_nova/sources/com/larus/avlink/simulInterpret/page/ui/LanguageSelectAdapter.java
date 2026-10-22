package com.larus.avlink.simulInterpret.page.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.impl.databinding.LayoutLanguageSelectItemBinding;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/LanguageSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/avlink/simulInterpret/page/ui/LanguageSelectAdapter$LanguageSelectViewHolder;", "currentSelectedLanguage", "Lcom/larus/avlink/simulInterpret/page/model/Language;", "languageList", "", "selectListener", "Lkotlin/Function1;", "", "<init>", "(Lcom/larus/avlink/simulInterpret/page/model/Language;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "LanguageSelectViewHolder", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LanguageSelectAdapter extends RecyclerView.Adapter<LanguageSelectViewHolder> {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/LanguageSelectAdapter$LanguageSelectViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/avlink/impl/databinding/LayoutLanguageSelectItemBinding;", "<init>", "(Lcom/larus/avlink/impl/databinding/LayoutLanguageSelectItemBinding;)V", "bind", "", "language", "Lcom/larus/avlink/simulInterpret/page/model/Language;", "currentSelectedLanguage", "selectListener", "Lkotlin/Function1;", "isLast", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LanguageSelectViewHolder extends RecyclerView.ViewHolder {
        public LanguageSelectViewHolder(LayoutLanguageSelectItemBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            super(r100.f293315a);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter((LanguageSelectViewHolder) r100, "holder");
        com.larus.avlink.simulInterpret.page.model.a r102 = (com.larus.avlink.simulInterpret.page.model.a) ListProtector.get(null, r101);
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.layout_language_select_item, r100, false);
        int r103 = R.id.divider;
        View r104 = ViewBindings.findChildViewById(r102, R.id.divider);
        if (r104 == null) goto L11;
        r103 = R.id.language_selected;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r102, R.id.language_selected);
        if (r105 == null) goto L11;
        r103 = R.id.language_text;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r102, R.id.language_text);
        if (r106 == null) goto L11;
        return new LanguageSelectViewHolder(new LayoutLanguageSelectItemBinding((ConstraintLayout) r102, r104, r105, r106));
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
