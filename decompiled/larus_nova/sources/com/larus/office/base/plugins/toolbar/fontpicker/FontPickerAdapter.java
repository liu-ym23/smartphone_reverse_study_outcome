package com.larus.office.base.plugins.toolbar.fontpicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.larus.office.base.utils.u;
import com.larus.utils.logger.FLogger;
import gn9.d;
import gn9.e;
import gn9.i;
import in9.g;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import okhttp3.OkHttpClient;
import v19.c;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0017\u0018B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\n\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/fontpicker/FontPickerAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/office/base/plugins/toolbar/model/FontItem;", "Lcom/larus/office/base/plugins/toolbar/fontpicker/FontPickerAdapter$FontViewHolder;", "onFontSelected", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "selectedPosition", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "updateSelection", "selectedFont", "onDetachedFromRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "FontViewHolder", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FontPickerAdapter extends ListAdapter<g, FontViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<g, Unit> f360869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f360870b;

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J8\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0011H\u0002J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/fontpicker/FontPickerAdapter$FontViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/office/base/plugins/toolbar/fontpicker/FontPickerAdapter;Landroid/view/View;)V", "tvFontName", "Landroid/widget/TextView;", "selectedIcon", "Landroid/widget/ImageView;", ItemStyle.ITEM_STYLE_DIVIDER, "ivFontName", "Landroidx/appcompat/widget/AppCompatImageView;", "fontPickerIcon", "bind", "", "position", "", "fontInfo", "Lcom/larus/office/base/plugins/toolbar/model/FontItem;", "isSelected", "", "displaySvg", "imageView", "drawable", "Landroid/graphics/drawable/Drawable;", "isDisable", "svgUrl", "", "svgWidth", "", "svgHeight", "setBitmapColor", "Landroid/graphics/Bitmap;", SimplayerImageStrategy.RESULT_BITMAP, "color", "useFontName", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class FontViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int f360871g = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f360872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f360873b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f360874c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AppCompatImageView f360875d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AppCompatImageView f360876e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ FontPickerAdapter f360877f;

        public final void T3(g r100) {
            this.f360872a.setText(r100.b());
            this.f360875d.setVisibility(8);
            this.f360872a.setVisibility(0);
            Context r101 = this.f360872a.getContext();
            if (Intrinsics.areEqual(r100.d(), Boolean.TRUE) == false) goto L5;
            TextView r102 = this.f360872a;
            Intrinsics.checkNotNull(r101);
            r102.setTextColor(c.a(R.attr.larus_neutral_100, r101, R.color.larus_neutral_100));
            return;
        L5:
            this.f360872a.setTextColor(c.a(R.attr.text_disable, this.itemView.getContext(), R.color.text_disable));
        }

        public FontViewHolder(FontPickerAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f360877f = r100;
            super(r101);
            this.f360872a = (TextView) r101.findViewById(R.id.tv_font_name);
            this.f360873b = (ImageView) r101.findViewById(R.id.iv_selected);
            this.f360874c = r101.findViewById(R.id.divider);
            this.f360875d = (AppCompatImageView) r101.findViewById(R.id.iv_font_name);
            this.f360876e = (AppCompatImageView) r101.findViewById(R.id.font_picker_icon);
        }
    }

    public static final class a {
    }

    static {
    }

    public FontPickerAdapter(i r100) {
        Intrinsics.checkNotNullParameter(r100, "onFontSelected");
        super(d.f481836a);
        this.f360869a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onDetachedFromRecyclerView(r100);
        OkHttpClient r101 = u.f361194a;
        FLogger.f375446a.i("SvgLoader", "cancelAll() called");
        Iterator<T> r102 = u.f361197d.values().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Job.DefaultImpls.cancel$default((Job) r102.next(), null, 1, null);
        goto L4
    L6:
        u.f361197d.clear();
        u.f361199f.clear();
        OkHttpClient r103 = u.f361194a;
        FLogger.f375446a.i("SvgLoader", "clearMemoryCache() called");
        u.f361196c.evictAll();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, final int r110) {
        final FontViewHolder r101 = (FontViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        final g r102 = getItem(r110);
        boolean r103 = true;
        int r104 = 0;
        if (r110 != this.f360870b) goto L5;
        boolean r105 = true;
    L6:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "fontInfo");
        Object r106 = r101.f360875d.getTag();
        if ((r106 instanceof String) == false) goto L9;
        String r107 = (String) r106;
    L11:
        if (Intrinsics.areEqual(r107, r102.a()) == true) goto L13;
        r101.f360875d.setImageDrawable(null);
    L13:
        String r108 = r102.c();
        if (r108 != null) goto L16;
    L19:
        boolean r109 = true;
    L21:
        if (r109 == false) goto L23;
        r101.T3(r102);
    L24:
        r101.f360875d.setTag(r102.a());
        if (Intrinsics.areEqual(r102.d(), Boolean.FALSE) == false) goto L27;
        r101.f360876e.setVisibility(0);
    L28:
        ImageView r111 = r101.f360873b;
        if (r105 == false) goto L31;
        int r112 = 0;
    L32:
        r111.setVisibility(r112);
        if (r101.getAdapterPosition() == (r101.f360877f.getItemCount() - 1)) goto L36;
        r103 = false;
    L36:
        View r113 = r101.f360874c;
        if (r103 == false) goto L39;
        r104 = 8;
    L39:
        r113.setVisibility(r104);
        View r114 = r101.itemView;
        final FontPickerAdapter r115 = r101.f360877f;
        r114.setOnClickListener(new e(r102, r110, r101, r115));
        return;
    L31:
        r112 = 4;
        goto L32
    L27:
        r101.f360876e.setVisibility(8);
        goto L28
    L23:
        r101.f360875d.setVisibility(0);
        r101.f360872a.setVisibility(8);
        OkHttpClient r116 = u.f361194a;
        u.b(r101.f360875d, r102.c(), new com.larus.office.base.plugins.toolbar.fontpicker.a(r101, r102));
        goto L24
    L16:
        if (r108.length() == 0) goto L19;
        r109 = false;
        goto L21
    L9:
        r107 = null;
        goto L11
    L5:
        r105 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_doc_sub_toolbar_item_font, r100, false);
        Intrinsics.checkNotNull(r102);
        return new FontViewHolder(this, r102);
    }
}
