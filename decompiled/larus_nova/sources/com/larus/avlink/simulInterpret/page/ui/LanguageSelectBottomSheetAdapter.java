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
import com.larus.avlink.impl.databinding.LayoutLanguageSelectItemBottomSheetBinding;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/LanguageSelectBottomSheetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/avlink/simulInterpret/page/ui/LanguageSelectBottomSheetAdapter$LanguageSelectViewHolder;", "currentSelectedLanguage", "Lcom/larus/avlink/simulInterpret/page/model/Language;", "languageList", "", "selectListener", "Lkotlin/Function1;", "", "<init>", "(Lcom/larus/avlink/simulInterpret/page/model/Language;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "updateSelectedLanguage", "newSelectedLanguage", "LanguageSelectViewHolder", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LanguageSelectBottomSheetAdapter extends RecyclerView.Adapter<LanguageSelectViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.larus.avlink.simulInterpret.page.model.a f294518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.larus.avlink.simulInterpret.page.model.a> f294519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<com.larus.avlink.simulInterpret.page.model.a, Unit> f294520c;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/LanguageSelectBottomSheetAdapter$LanguageSelectViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/avlink/impl/databinding/LayoutLanguageSelectItemBottomSheetBinding;", "<init>", "(Lcom/larus/avlink/impl/databinding/LayoutLanguageSelectItemBottomSheetBinding;)V", "bind", "", "language", "Lcom/larus/avlink/simulInterpret/page/model/Language;", "currentSelectedLanguage", "selectListener", "Lkotlin/Function1;", "isLast", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LanguageSelectViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f294521b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LayoutLanguageSelectItemBottomSheetBinding f294522a;

        public LanguageSelectViewHolder(LayoutLanguageSelectItemBottomSheetBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            super(r100.f293317a);
            this.f294522a = r100;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f294519b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        LanguageSelectViewHolder r102 = (LanguageSelectViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        final com.larus.avlink.simulInterpret.page.model.a r103 = (com.larus.avlink.simulInterpret.page.model.a) ListProtector.get(this.f294519b, r101);
        com.larus.avlink.simulInterpret.page.model.a r104 = this.f294518a;
        final Function1<com.larus.avlink.simulInterpret.page.model.a, Unit> r105 = this.f294520c;
        boolean r106 = true;
        if (r101 == (getItemCount() - 1)) goto L6;
        r106 = false;
    L6:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "language");
        Intrinsics.checkNotNullParameter(r104, "currentSelectedLanguage");
        Intrinsics.checkNotNullParameter(r105, "selectListener");
        r102.f294522a.f293320d.setText(r103.f294493a);
        if (Intrinsics.areEqual(r103.f294494b, r104.f294494b) == false) goto L9;
        r102.f294522a.f293319c.setVisibility(0);
    L10:
        r102.f294522a.f293317a.setOnClickListener(new j(r105, r103));
        if (r106 == false) goto L13;
        r102.f294522a.f293318b.setVisibility(8);
        return;
    L13:
        r102.f294522a.f293318b.setVisibility(0);
        return;
    L9:
        r102.f294522a.f293319c.setVisibility(8);
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.layout_language_select_item_bottom_sheet, r100, false);
        int r103 = R.id.divider;
        View r104 = ViewBindings.findChildViewById(r102, R.id.divider);
        if (r104 == null) goto L11;
        r103 = R.id.language_selected;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r102, R.id.language_selected);
        if (r105 == null) goto L11;
        r103 = R.id.language_text;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r102, R.id.language_text);
        if (r106 == null) goto L11;
        return new LanguageSelectViewHolder(new LayoutLanguageSelectItemBottomSheetBinding((ConstraintLayout) r102, r104, r105, r106));
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LanguageSelectBottomSheetAdapter(com.larus.avlink.simulInterpret.page.model.a r100, List r101, n r102) {
        Intrinsics.checkNotNullParameter(r100, "currentSelectedLanguage");
        Intrinsics.checkNotNullParameter(r101, "languageList");
        Intrinsics.checkNotNullParameter(r102, "selectListener");
        this.f294518a = r100;
        this.f294519b = r101;
        this.f294520c = r102;
    }
}
