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
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0017\u0018B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\n\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontPickerAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontItem;", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontPickerAdapter$FontViewHolder;", "onFontSelected", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "selectedPosition", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "updateSelection", "selectedFont", "onDetachedFromRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "FontViewHolder", "Companion", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FontPickerAdapter extends ListAdapter<FontItem, FontViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<FontItem, Unit> f238679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f238680b;

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J8\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0011H\u0002J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontPickerAdapter$FontViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontPickerAdapter;Landroid/view/View;)V", "tvFontName", "Landroid/widget/TextView;", "selectedIcon", "Landroid/widget/ImageView;", ItemStyle.ITEM_STYLE_DIVIDER, "ivFontName", "Landroidx/appcompat/widget/AppCompatImageView;", "fontPickerIcon", "bind", "", "position", "", "fontInfo", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontItem;", "isSelected", "", "displaySvg", "imageView", "drawable", "Landroid/graphics/drawable/Drawable;", "isDisable", "svgUrl", "", "svgWidth", "", "svgHeight", "setBitmapColor", "Landroid/graphics/Bitmap;", SimplayerImageStrategy.RESULT_BITMAP, "color", "useFontName", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class FontViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int f238681g = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f238682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f238683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f238684c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AppCompatImageView f238685d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AppCompatImageView f238686e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ FontPickerAdapter f238687f;

        public final void T3(FontItem r100) {
            this.f238682a.setText(r100.getName());
            this.f238685d.setVisibility(8);
            this.f238682a.setVisibility(0);
            Context r101 = this.f238682a.getContext();
            if (Intrinsics.areEqual(r100.isSupport(), Boolean.TRUE) == false) goto L5;
            this.f238682a.setTextColor(ContextCompat.getColor(r101, R.color.icon_n1));
            return;
        L5:
            this.f238682a.setTextColor(ContextCompat.getColor(r101, R.color.text_disable));
        }

        public FontViewHolder(FontPickerAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f238687f = r100;
            super(r101);
            this.f238682a = (TextView) r101.findViewById(R.id.tv_font_name);
            this.f238683b = (ImageView) r101.findViewById(R.id.iv_selected);
            this.f238684c = r101.findViewById(R.id.divider);
            this.f238685d = (AppCompatImageView) r101.findViewById(R.id.iv_font_name);
            this.f238686e = (AppCompatImageView) r101.findViewById(R.id.font_picker_icon);
        }
    }

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FontPickerAdapter(Function1<? super FontItem, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onFontSelected");
        super(com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker.a.f238701a);
        this.f238679a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onDetachedFromRecyclerView(r100);
        OkHttpClient r101 = j.f238723a;
        tt5.a.h("SvgLoader", "cancelAll() called");
        Iterator<T> r102 = j.f238726d.values().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Job.DefaultImpls.cancel$default((Job) r102.next(), null, 1, null);
        goto L4
    L6:
        j.f238726d.clear();
        j.f238728f.clear();
        OkHttpClient r103 = j.f238723a;
        tt5.a.h("SvgLoader", "clearMemoryCache() called");
        j.f238725c.evictAll();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r210, int r211) {
        FontViewHolder r100 = (FontViewHolder) r210;
        Intrinsics.checkNotNullParameter(r100, "holder");
        FontItem r101 = getItem(r211);
        boolean r102 = true;
        int r103 = 0;
        if (r211 != this.f238680b) goto L5;
        boolean r104 = true;
    L6:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "fontInfo");
        Object r105 = r100.f238685d.getTag();
        if ((r105 instanceof String) == false) goto L9;
        String r106 = (String) r105;
    L11:
        if (Intrinsics.areEqual(r106, r101.getKey()) == true) goto L13;
        r100.f238685d.setImageDrawable(null);
    L13:
        String r107 = r101.getSrc();
        if (r107 != null) goto L16;
    L19:
        boolean r108 = true;
    L21:
        if (r108 == false) goto L23;
        r100.T3(r101);
    L32:
        r100.f238685d.setTag(r101.getKey());
        if (Intrinsics.areEqual(r101.isSupport(), Boolean.FALSE) == false) goto L35;
        r100.f238686e.setVisibility(0);
    L36:
        ImageView r109 = r100.f238683b;
        if (r104 == false) goto L39;
        int r110 = 0;
    L40:
        r109.setVisibility(r110);
        if (r100.getAdapterPosition() == (r100.f238687f.getItemCount() - 1)) goto L44;
        r102 = false;
    L44:
        View r111 = r100.f238684c;
        if (r102 == false) goto L47;
        r103 = 8;
    L47:
        r111.setVisibility(r103);
        r100.itemView.setOnClickListener(new d(r101, r211, r100, r100.f238687f));
        return;
    L39:
        r110 = 4;
        goto L40
    L35:
        r100.f238686e.setVisibility(8);
        goto L36
    L23:
        r100.f238685d.setVisibility(0);
        r100.f238682a.setVisibility(8);
        OkHttpClient r112 = j.f238723a;
        AppCompatImageView r113 = r100.f238685d;
        String r114 = r101.getSrc();
        if (r114 == null) goto L50;
        c r115 = new c(r100, r101);
        Intrinsics.checkNotNullParameter(r113, "imageView");
        Intrinsics.checkNotNullParameter(r114, "svgUrl");
        if (StringsKt.isBlank(r114) == false) goto L28;
        r115.b(r113, r114, new IllegalArgumentException("SVG URL cannot be empty"));
        goto L32
    L28:
        j.a r116 = j.f238725c.get(r114);
        if (r116 == null) goto L31;
        com.bytedance.ee.util.ui.m.a(new m(r115, r113, r114, r116));
        goto L32
    L31:
        j.f238728f.put(r114, Boolean.TRUE);
        j.f238726d.put(r114, BuildersKt.launch$default(j.f238724b, ExecutorsKt.from(j.f238727e), null, new SvgLoader$loadSvgFromUrl$job$1(r113, r114, r115, null), 2, null));
        goto L32
    L50:
        throw new IllegalArgumentException("Required value was null.".toString());
    L16:
        if (r107.length() == 0) goto L19;
        r108 = false;
        goto L21
    L9:
        r106 = null;
        goto L11
    L5:
        r104 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.core_doc_sub_toolbar_item_font, r100, false);
        Intrinsics.checkNotNull(r102);
        return new FontViewHolder(this, r102);
    }
}
