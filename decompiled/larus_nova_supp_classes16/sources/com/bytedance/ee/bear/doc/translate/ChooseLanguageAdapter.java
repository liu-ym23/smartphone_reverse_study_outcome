package com.bytedance.ee.bear.doc.translate;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0016\u001a\u00020\f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018J\u001c\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u001c\u0010\u001f\u001a\u00020\f2\n\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\u001dH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/doc/translate/ChooseLanguageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/doc/translate/ChooseLanguageAdapter$ChooseLanguageItemViewHolder;", "<init>", "()V", "TAG", "", "languages", "", "Lcom/bytedance/ee/bear/doc/translate/LanguageModel;", "onItemClickListener", "Lkotlin/Function1;", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedLanguage", "getSelectedLanguage", "()Lcom/bytedance/ee/bear/doc/translate/LanguageModel;", "setSelectedLanguage", "(Lcom/bytedance/ee/bear/doc/translate/LanguageModel;)V", "setData", "data", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "ChooseLanguageItemViewHolder", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChooseLanguageAdapter extends RecyclerView.Adapter<ChooseLanguageItemViewHolder> {
    public final String a;
    public final List<LanguageModel> b;
    public Function1<? super LanguageModel, Unit> c;
    public LanguageModel d;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/doc/translate/ChooseLanguageAdapter$ChooseLanguageItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "root", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/doc/translate/ChooseLanguageAdapter;Landroid/view/View;)V", "languageTv", "Landroid/widget/TextView;", "selectedIv", "Landroid/widget/ImageView;", "setContent", "", "text", "", "selected", "", "isLast", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ChooseLanguageItemViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final ImageView b;
        public final /* synthetic */ ChooseLanguageAdapter c;

        public static final class a extends t {
            public final /* synthetic */ ChooseLanguageItemViewHolder c;
            public final /* synthetic */ ChooseLanguageAdapter d;

            public final void a(View r3) {
                LanguageModel r0 = null;
                if (r3 == null) goto L5;
                Object r4 = r3.getTag();
            L7:
                if ((r4 instanceof LanguageModel) == false) goto L9;
                r0 = (LanguageModel) r4;
            L9:
                if (r0 != null) goto L11;
                return;
            L11:
                this.c.b.setVisibility(0);
                Function1<? super LanguageModel, Unit> r5 = this.d.c;
                if (r5 == null) goto L15;
                r5.invoke(r0);
                return;
            L15:
                return;
            L5:
                r4 = null;
                goto L7
            }

            public a(ChooseLanguageItemViewHolder r1, ChooseLanguageAdapter r2) {
                this.c = r1;
                this.d = r2;
            }
        }

        public ChooseLanguageItemViewHolder(ChooseLanguageAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "root");
            this.c = r2;
            super(r3);
            this.a = (TextView) r3.findViewById(2131377157);
            this.b = (ImageView) r3.findViewById(2131385842);
            ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new a(this, r2));
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public ChooseLanguageAdapter() {
        this.a = "ChooseLanguageAdapter";
        this.b = new ArrayList();
    }

    public final void setData(List<? extends LanguageModel> r2) {
        if (r2 != null) goto L4;
    L11:
        ((ArrayList) this.b).clear();
        notifyDataSetChanged();
        return;
    L4:
        if (r2.isEmpty() == true) goto L11;
        if (Intrinsics.areEqual(this.b, r2) == false) goto L9;
        return;
    L9:
        ((ArrayList) this.b).clear();
        ArrayList r0 = (ArrayList) this.b;
        r0.addAll(r2);
        notifyDataSetChanged();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        ChooseLanguageItemViewHolder r6 = (ChooseLanguageItemViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        LanguageModel r7 = (LanguageModel) ListProtector.get(this.b, r5);
        getItemCount();
        ((RecyclerView.ViewHolder) r6).itemView.setTag(r7);
        String r0 = r7.getDisplayText();
        boolean r8 = Objects.equals(this.d, r7);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        tt5.a.d(r6.c.a, "Set language error!, text is null or empty!. languageList: " + r6.c.b);
        r0 = "";
    L5:
        r6.a.setText(r0);
        ImageView r9 = r6.b;
        if (r8 == false) goto L8;
        int r10 = 0;
    L9:
        r9.setVisibility(r10);
        return;
    L8:
        r10 = 8;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ChooseLanguageItemViewHolder(this, LayoutInflater.from(r4.getContext()).inflate(2131559354, r4, false));
    }
}
