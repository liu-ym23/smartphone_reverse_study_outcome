package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0017\u0018B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\n\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontPickerAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontItem;", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontPickerAdapter$FontViewHolder;", "onFontSelected", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "selectedPosition", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "updateSelection", "selectedFont", "onDetachedFromRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "FontViewHolder", "Companion", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FontPickerAdapter extends ListAdapter<FontItem, FontViewHolder> {
    public final Function1<FontItem, Unit> a;
    public int b;

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J8\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0011H\u0002J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontPickerAdapter$FontViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontPickerAdapter;Landroid/view/View;)V", "tvFontName", "Landroid/widget/TextView;", "selectedIcon", "Landroid/widget/ImageView;", "divider", "ivFontName", "Landroidx/appcompat/widget/AppCompatImageView;", "fontPickerIcon", "bind", "", "position", "", "fontInfo", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontItem;", "isSelected", "", "displaySvg", "imageView", "drawable", "Landroid/graphics/drawable/Drawable;", "isDisable", "svgUrl", "", "svgWidth", "", "svgHeight", "setBitmapColor", "Landroid/graphics/Bitmap;", "bitmap", "color", "useFontName", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class FontViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int g = 0;
        public final TextView a;
        public final ImageView b;
        public final View c;
        public final AppCompatImageView d;
        public final AppCompatImageView e;
        public final /* synthetic */ FontPickerAdapter f;

        public final void T3(FontItem r3) {
            this.a.setText(r3.getName());
            this.d.setVisibility(8);
            this.a.setVisibility(0);
            Context r0 = this.a.getContext();
            if (Intrinsics.areEqual(r3.isSupport(), Boolean.TRUE) == false) goto L5;
            this.a.setTextColor(ContextCompat.getColor(r0, 2131102418));
            return;
        L5:
            this.a.setTextColor(ContextCompat.getColor(r0, 2131106610));
        }

        public FontViewHolder(FontPickerAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.f = r2;
            super(r3);
            this.a = (TextView) r3.findViewById(2131390656);
            this.b = (ImageView) r3.findViewById(2131376593);
            this.c = r3.findViewById(2131369197);
            this.d = r3.findViewById(2131376258);
            this.e = r3.findViewById(2131373131);
        }
    }

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FontPickerAdapter(Function1<? super FontItem, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onFontSelected");
        super(com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker.a.a);
        this.a = r2;
    }

    public final void onDetachedFromRecyclerView(RecyclerView r5) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onDetachedFromRecyclerView(r5);
        OkHttpClient r6 = j.a;
        tt5.a.h("SvgLoader", "cancelAll() called");
        Iterator<T> r7 = j.d.values().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Job.DefaultImpls.cancel$default((Job) r7.next(), null, 1, null);
        goto L4
    L6:
        j.d.clear();
        j.f.clear();
        OkHttpClient r8 = j.a;
        tt5.a.h("SvgLoader", "clearMemoryCache() called");
        j.c.evictAll();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r21, int r22) {
        FontViewHolder r2 = (FontViewHolder) r21;
        Intrinsics.checkNotNullParameter(r2, "holder");
        FontItem r3 = (FontItem) getItem(r22);
        boolean r5 = true;
        int r6 = 0;
        if (r22 != this.b) goto L5;
        boolean r4 = true;
    L6:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "fontInfo");
        Object r7 = r2.d.getTag();
        if ((r7 instanceof String) == false) goto L9;
        String r8 = (String) r7;
    L11:
        if (Intrinsics.areEqual(r8, r3.getKey()) == true) goto L13;
        r2.d.setImageDrawable(null);
    L13:
        String r9 = r3.getSrc();
        if (r9 != null) goto L16;
    L19:
        boolean r10 = true;
    L21:
        if (r10 == false) goto L23;
        r2.T3(r3);
    L32:
        r2.d.setTag(r3.getKey());
        if (Intrinsics.areEqual(r3.isSupport(), Boolean.FALSE) == false) goto L35;
        r2.e.setVisibility(0);
    L36:
        ImageView r11 = r2.b;
        if (r4 == false) goto L39;
        int r12 = 0;
    L40:
        r11.setVisibility(r12);
        if (r2.getAdapterPosition() == (r2.f.getItemCount() - 1)) goto L44;
        r5 = false;
    L44:
        View r13 = r2.c;
        if (r5 == false) goto L47;
        r6 = 8;
    L47:
        r13.setVisibility(r6);
        ((RecyclerView.ViewHolder) r2).itemView.setOnClickListener(new d(r3, r22, r2, r2.f));
        return;
    L39:
        r12 = 4;
        goto L40
    L35:
        r2.e.setVisibility(8);
        goto L36
    L23:
        r2.d.setVisibility(0);
        r2.a.setVisibility(8);
        OkHttpClient r14 = j.a;
        ImageView r15 = r2.d;
        String r16 = r3.getSrc();
        if (r16 == null) goto L50;
        c r17 = new c(r2, r3);
        Intrinsics.checkNotNullParameter(r15, "imageView");
        Intrinsics.checkNotNullParameter(r16, "svgUrl");
        if (StringsKt.isBlank(r16) == false) goto L28;
        r17.b(r15, r16, new IllegalArgumentException("SVG URL cannot be empty"));
        goto L32
    L28:
        j.a r18 = (j.a) j.c.get(r16);
        if (r18 == null) goto L31;
        com.bytedance.ee.util.ui.m.a(new m(r17, r15, r16, r18));
        goto L32
    L31:
        j.f.put(r16, Boolean.TRUE);
        j.d.put(r16, BuildersKt.launch$default(j.b, ExecutorsKt.from(j.e), null, new SvgLoader$loadSvgFromUrl$job$1(r15, r16, r17, null), 2, null));
        goto L32
    L50:
        throw new IllegalArgumentException("Required value was null.".toString());
    L16:
        if (r9.length() == 0) goto L19;
        r10 = false;
        goto L21
    L9:
        r8 = null;
        goto L11
    L5:
        r4 = false;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131559941, r3, false);
        Intrinsics.checkNotNull(r5);
        return new FontViewHolder(this, r5);
    }
}
