package com.bytedance.ee.bear.doc.translate;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0016\u001a\u00020\f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018J\u001c\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u001c\u0010\u001f\u001a\u00020\f2\n\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\u001dH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/doc/translate/ChooseLanguageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/doc/translate/ChooseLanguageAdapter$ChooseLanguageItemViewHolder;", "<init>", "()V", "TAG", "", "languages", "", "Lcom/bytedance/ee/bear/doc/translate/LanguageModel;", "onItemClickListener", "Lkotlin/Function1;", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedLanguage", "getSelectedLanguage", "()Lcom/bytedance/ee/bear/doc/translate/LanguageModel;", "setSelectedLanguage", "(Lcom/bytedance/ee/bear/doc/translate/LanguageModel;)V", "setData", "data", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "ChooseLanguageItemViewHolder", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChooseLanguageAdapter extends RecyclerView.Adapter<ChooseLanguageItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f218317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<LanguageModel> f218318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super LanguageModel, Unit> f218319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LanguageModel f218320d;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/doc/translate/ChooseLanguageAdapter$ChooseLanguageItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", RootDescription.ROOT_ELEMENT, "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/doc/translate/ChooseLanguageAdapter;Landroid/view/View;)V", "languageTv", "Landroid/widget/TextView;", "selectedIv", "Landroid/widget/ImageView;", "setContent", "", "text", "", "selected", "", "isLast", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ChooseLanguageItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f218321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f218322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ChooseLanguageAdapter f218323c;

        public static final class a extends t {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ChooseLanguageItemViewHolder f218324c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ChooseLanguageAdapter f218325d;

            @Override // com.bytedance.ee.bear.widgets.t
            public final void a(View r100) {
                LanguageModel r101 = null;
                if (r100 == null) goto L5;
                Object r102 = r100.getTag();
            L7:
                if ((r102 instanceof LanguageModel) == false) goto L9;
                r101 = (LanguageModel) r102;
            L9:
                if (r101 != null) goto L11;
                return;
            L11:
                this.f218324c.f218322b.setVisibility(0);
                Function1<? super LanguageModel, Unit> r103 = this.f218325d.f218319c;
                if (r103 == null) goto L15;
                r103.invoke(r101);
                return;
            L15:
                return;
            L5:
                r102 = null;
                goto L7
            }

            public a(ChooseLanguageItemViewHolder r100, ChooseLanguageAdapter r101) {
                this.f218324c = r100;
                this.f218325d = r101;
            }
        }

        public ChooseLanguageItemViewHolder(ChooseLanguageAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
            this.f218323c = r100;
            super(r101);
            this.f218321a = (TextView) r101.findViewById(R.id.language_text);
            this.f218322b = (ImageView) r101.findViewById(R.id.selected_language_iv);
            this.itemView.setOnClickListener(new a(this, r100));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f218318b).size();
    }

    public ChooseLanguageAdapter() {
        this.f218317a = "ChooseLanguageAdapter";
        this.f218318b = new ArrayList();
    }

    public final void setData(List<? extends LanguageModel> r100) {
        if (r100 != null) goto L4;
    L11:
        ((ArrayList) this.f218318b).clear();
        notifyDataSetChanged();
        return;
    L4:
        if (r100.isEmpty() == true) goto L11;
        if (Intrinsics.areEqual(this.f218318b, r100) == false) goto L9;
        return;
    L9:
        ((ArrayList) this.f218318b).clear();
        ArrayList r101 = (ArrayList) this.f218318b;
        r101.addAll(r100);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ChooseLanguageItemViewHolder r102 = (ChooseLanguageItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        LanguageModel r103 = (LanguageModel) ListProtector.get(this.f218318b, r101);
        getItemCount();
        r102.itemView.setTag(r103);
        String r104 = r103.getDisplayText();
        boolean r105 = Objects.equals(this.f218320d, r103);
        if (TextUtils.isEmpty(r104) == false) goto L5;
        tt5.a.d(r102.f218323c.f218317a, "Set language error!, text is null or empty!. languageList: " + r102.f218323c.f218318b);
        r104 = "";
    L5:
        r102.f218321a.setText(r104);
        ImageView r106 = r102.f218322b;
        if (r105 == false) goto L8;
        int r107 = 0;
    L9:
        r106.setVisibility(r107);
        return;
    L8:
        r107 = 8;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ChooseLanguageItemViewHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.choose_language_rv_item, r100, false));
    }
}
