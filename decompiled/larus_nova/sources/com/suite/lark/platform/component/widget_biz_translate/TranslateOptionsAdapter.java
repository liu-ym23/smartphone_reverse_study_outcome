package com.suite.lark.platform.component.widget_biz_translate;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001f !B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J!\u0010\u0016\u001a\u00020\f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000bH\u0000¢\u0006\u0002\b\u0018J\u0015\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u001aJ\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_translate/TranslateOptionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/suite/lark/platform/component/widget_biz_translate/TranslateOptionsAdapter$TranslateItemViewHolder;", "<init>", "()V", "translateItems", "", "Lcom/suite/lark/platform/component/widget_biz_translate/TranslateOptionsAdapter$TranslateItem;", "lastSelectedIndex", "", "itemSelectHandler", "Lkotlin/Function1;", "", "showLabel", "", "resetData", "newItems", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemSelectHandler", "action", "setOnItemSelectHandler$widget_biz_translate_release", "setShowLabel", "setShowLabel$widget_biz_translate_release", "onBindViewHolder", "holder", "position", "getItemCount", "TranslateItemViewHolder", "TranslateItem", "Companion", "widget-biz-translate_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TranslateOptionsAdapter extends RecyclerView.Adapter<TranslateItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f461129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f461130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<? super b, Unit> f461131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f461132d;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00148@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00148@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_translate/TranslateOptionsAdapter$TranslateItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tvLabel", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTvLabel", "()Landroid/widget/TextView;", "checkedIcon", "tvTitle", "value", "", "isSelected", "isSelected$widget_biz_translate_release", "()Z", "setSelected$widget_biz_translate_release", "(Z)V", "", "title", "getTitle$widget_biz_translate_release", "()Ljava/lang/String;", "setTitle$widget_biz_translate_release", "(Ljava/lang/String;)V", "label", "getLabel$widget_biz_translate_release", "setLabel$widget_biz_translate_release", "widget-biz-translate_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TranslateItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f461133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f461134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f461135c;

        public TranslateItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            TextView r101 = (TextView) this.itemView.findViewById(R.id.label_lan);
            r101.setTypeface(Typeface.MONOSPACE);
            this.f461133a = r101;
            this.f461134b = this.itemView.findViewById(R.id.iv_checked);
            this.f461135c = (TextView) this.itemView.findViewById(R.id.title);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f461136a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            r101.getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L15;
            return false;
        L15:
            if (this.f461136a == r101.f461136a) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "TranslateItem(languageId=null, language=null, isSelected=" + this.f461136a + ')';
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f461129a).size();
    }

    public TranslateOptionsAdapter() {
        this.f461129a = new ArrayList();
        this.f461130b = -1;
        this.f461131c = TranslateOptionsAdapter$itemSelectHandler$1.INSTANCE;
        this.f461132d = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        TranslateItemViewHolder r102 = (TranslateItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        b r103 = (b) ListProtector.get(this.f461129a, r101);
        r103.getClass();
        String r104 = StringsKt.trim(null).toString();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "value");
        r102.f461135c.setText(r104);
        Intrinsics.checkNotNullParameter(null, "value");
        r102.f461133a.setText(null);
        TextView r105 = r102.f461133a;
        int r106 = 0;
        if (this.f461132d == false) goto L5;
        int r107 = 0;
    L6:
        r105.setVisibility(r107);
        boolean r108 = r103.f461136a;
        View r109 = r102.f461134b;
        if (r108 == true) goto L10;
        r106 = 8;
    L10:
        r109.setVisibility(r106);
        Log.d("TranslateOptionsAdapter", "onBindViewHolder: current position is : " + r101 + ", item is selected is " + r103.f461136a);
        if (r103.f461136a == false) goto L13;
        Log.i("TranslateOptionsAdapter", "TranslateOptionsAdapter: current select item key is : null");
    L13:
        r102.itemView.setOnClickListener(new com.suite.lark.platform.component.widget_biz_translate.a(this, r101, r103));
        return;
    L5:
        r107 = 8;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new TranslateItemViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.item_tanslate_option, r100, false));
    }
}
