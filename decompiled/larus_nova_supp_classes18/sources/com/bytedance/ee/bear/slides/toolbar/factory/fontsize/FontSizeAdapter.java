package com.bytedance.ee.bear.slides.toolbar.factory.fontsize;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002)*B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0005H\u0002J2\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\"2\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0017H\u0002J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0002H\u0002J\u0018\u0010'\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0017H\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/fontsize/FontSizeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/slides/toolbar/factory/fontsize/FontSizeAdapter$FontSizeSliderViewHolder;", "items", "", "Lcom/bytedance/ee/bear/slides/toolbar/factory/fontsize/FontSizeItem;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "setItems", "backClickListener", "Lcom/bytedance/ee/bear/slides/toolbar/factory/fontsize/OnBackClickListener;", "onProgressListener", "Lcom/bytedance/ee/bear/slides/toolbar/factory/fontsize/onProgressListener;", "setBackClickListener", "", "setOnProgressListener", "listener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "bindFontSizeSlider", "viewHolder", "item", "initFontSizeSeekBar", "fontSizeData", "calculateSafeFontSizes", "Lkotlin/Triple;", "min", "max", "current", "setupSeekBarListener", "updateFontSizeDisplay", "fontSize", "FontSizeSliderViewHolder", "Companion", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FontSizeAdapter extends RecyclerView.Adapter<FontSizeSliderViewHolder> {
    public static final /* synthetic */ int d = 0;
    public final List<FontSizeItem> a;
    public h b;
    public i c;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/fontsize/FontSizeAdapter$FontSizeSliderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "ivBack", "Landroid/widget/ImageView;", "getIvBack", "()Landroid/widget/ImageView;", "setIvBack", "(Landroid/widget/ImageView;)V", "seekbarFontSize", "Landroidx/appcompat/widget/AppCompatSeekBar;", "getSeekbarFontSize", "()Landroidx/appcompat/widget/AppCompatSeekBar;", "setSeekbarFontSize", "(Landroidx/appcompat/widget/AppCompatSeekBar;)V", "tvFontSizeValue", "Landroid/widget/TextView;", "getTvFontSizeValue", "()Landroid/widget/TextView;", "setTvFontSizeValue", "(Landroid/widget/TextView;)V", "currentSafeMin", "", "getCurrentSafeMin", "()I", "setCurrentSafeMin", "(I)V", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FontSizeSliderViewHolder extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final AppCompatSeekBar b;
        public final TextView c;
        public int d;

        public FontSizeSliderViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.d = 8;
            this.a = (ImageView) r2.findViewById(2131376031);
            this.b = r2.findViewById(2131385761);
            this.c = (TextView) r2.findViewById(2131390658);
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public FontSizeAdapter(List<FontSizeItem> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.a = r2;
    }

    public static void y2(FontSizeSliderViewHolder r2, int r3) {
        String r0 = ((RecyclerView.ViewHolder) r2).itemView.getContext().getString(2131889755);
        r2.c.setText(r0 + ' ' + r3);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        FontSizeSliderViewHolder r8 = (FontSizeSliderViewHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        FontSizeItem r9 = (FontSizeItem) ListProtector.get(this.a, r7);
        r8.a.setOnClickListener(new com.bytedance.ee.bear.slides.toolbar.factory.fontsize.a(this));
        String r0 = r9.getMin();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = CastIntegerProtector.parseInt(r0);
    L6:
        String r3 = r9.getMax();
        if (r3 == null) goto L9;
        int r4 = CastIntegerProtector.parseInt(r3);
    L10:
        String r5 = r9.getValue();
        if (r5 == null) goto L13;
        int r10 = CastIntegerProtector.parseInt(r5);
    L14:
        Triple r11 = new Triple(Integer.valueOf(r2), Integer.valueOf(r4), Integer.valueOf(RangesKt.coerceIn(r10, r2, r4)));
        int r12 = ((Number) r11.component1()).intValue();
        int r13 = ((Number) r11.component2()).intValue();
        int r14 = ((Number) r11.component3()).intValue();
        r8.d = r12;
        r8.b.setMax(r13 - r12);
        r8.b.setProgress(r14 - r12);
        Resources r15 = ((RecyclerView.ViewHolder) r8).itemView.getContext().getResources();
        int r16 = (int) (WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics()).widthPixels * 0.6f);
        ViewGroup.LayoutParams r17 = r8.b.getLayoutParams();
        r17.width = r16;
        r8.b.setLayoutParams(r17);
        r8.b.setOnSeekBarChangeListener(new b(r8, this));
        String r18 = r9.getValue();
        if (r18 == null) goto L17;
        r1 = CastIntegerProtector.parseInt(r18);
    L17:
        y2(r8, r1);
        return;
    L13:
        r10 = 0;
        goto L14
    L9:
        r4 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131561202, r3, false);
        Intrinsics.checkNotNull(r5);
        return new FontSizeSliderViewHolder(r5);
    }
}
