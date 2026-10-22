package com.bytedance.ee.bear.slides.toolbar.factory.fontsize;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002)*B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0005H\u0002J2\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\"2\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0017H\u0002J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0002H\u0002J\u0018\u0010'\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0017H\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/fontsize/FontSizeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/slides/toolbar/factory/fontsize/FontSizeAdapter$FontSizeSliderViewHolder;", "items", "", "Lcom/bytedance/ee/bear/slides/toolbar/factory/fontsize/FontSizeItem;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "setItems", "backClickListener", "Lcom/bytedance/ee/bear/slides/toolbar/factory/fontsize/OnBackClickListener;", "onProgressListener", "Lcom/bytedance/ee/bear/slides/toolbar/factory/fontsize/onProgressListener;", "setBackClickListener", "", "setOnProgressListener", "listener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "bindFontSizeSlider", "viewHolder", MapController.ITEM_LAYER_TAG, "initFontSizeSeekBar", "fontSizeData", "calculateSafeFontSizes", "Lkotlin/Triple;", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "current", "setupSeekBarListener", "updateFontSizeDisplay", "fontSize", "FontSizeSliderViewHolder", "Companion", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FontSizeAdapter extends RecyclerView.Adapter<FontSizeSliderViewHolder> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f238578d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<FontSizeItem> f238579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f238580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f238581c;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/fontsize/FontSizeAdapter$FontSizeSliderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "ivBack", "Landroid/widget/ImageView;", "getIvBack", "()Landroid/widget/ImageView;", "setIvBack", "(Landroid/widget/ImageView;)V", "seekbarFontSize", "Landroidx/appcompat/widget/AppCompatSeekBar;", "getSeekbarFontSize", "()Landroidx/appcompat/widget/AppCompatSeekBar;", "setSeekbarFontSize", "(Landroidx/appcompat/widget/AppCompatSeekBar;)V", "tvFontSizeValue", "Landroid/widget/TextView;", "getTvFontSizeValue", "()Landroid/widget/TextView;", "setTvFontSizeValue", "(Landroid/widget/TextView;)V", "currentSafeMin", "", "getCurrentSafeMin", "()I", "setCurrentSafeMin", "(I)V", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FontSizeSliderViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f238582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AppCompatSeekBar f238583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f238584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f238585d;

        public FontSizeSliderViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f238585d = 8;
            this.f238582a = (ImageView) r100.findViewById(R.id.iv_back);
            this.f238583b = (AppCompatSeekBar) r100.findViewById(R.id.seekbar_font_size);
            this.f238584c = (TextView) r100.findViewById(R.id.tv_font_size_value);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f238579a.size();
    }

    public FontSizeAdapter(List<FontSizeItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f238579a = r100;
    }

    public static void y2(FontSizeSliderViewHolder r100, int r101) {
        String r102 = r100.itemView.getContext().getString(R.string.LarkCCM_SlidesMobile_FontSize_Header);
        r100.f238584c.setText(r102 + ' ' + r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        FontSizeSliderViewHolder r102 = (FontSizeSliderViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        FontSizeItem r103 = (FontSizeItem) ListProtector.get(this.f238579a, r101);
        r102.f238582a.setOnClickListener(new com.bytedance.ee.bear.slides.toolbar.factory.fontsize.a(this));
        String r104 = r103.getMin();
        int r105 = 0;
        if (r104 == null) goto L5;
        int r106 = CastIntegerProtector.parseInt(r104);
    L6:
        String r107 = r103.getMax();
        if (r107 == null) goto L9;
        int r108 = CastIntegerProtector.parseInt(r107);
    L10:
        String r109 = r103.getValue();
        if (r109 == null) goto L13;
        int r110 = CastIntegerProtector.parseInt(r109);
    L14:
        Triple r111 = new Triple(Integer.valueOf(r106), Integer.valueOf(r108), Integer.valueOf(RangesKt.coerceIn(r110, r106, r108)));
        int r112 = ((Number) r111.component1()).intValue();
        int r113 = ((Number) r111.component2()).intValue();
        int r114 = ((Number) r111.component3()).intValue();
        r102.f238585d = r112;
        r102.f238583b.setMax(r113 - r112);
        r102.f238583b.setProgress(r114 - r112);
        Resources r115 = r102.itemView.getContext().getResources();
        int r116 = (int) (WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics()).widthPixels * 0.6f);
        ViewGroup.LayoutParams r117 = r102.f238583b.getLayoutParams();
        r117.width = r116;
        r102.f238583b.setLayoutParams(r117);
        r102.f238583b.setOnSeekBarChangeListener(new b(r102, this));
        String r118 = r103.getValue();
        if (r118 == null) goto L17;
        r105 = CastIntegerProtector.parseInt(r118);
    L17:
        y2(r102, r105);
        return;
    L13:
        r110 = 0;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.fragment_font_size_slider, r100, false);
        Intrinsics.checkNotNull(r102);
        return new FontSizeSliderViewHolder(r102);
    }
}
