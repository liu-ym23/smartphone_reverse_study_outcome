package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model.ColorListItem;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model.ColorValueItem;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0016\u0010\u0019\u001a\u00020\u00182\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\u0018H\u0002J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'H\u0016J&\u0010(\u001a\u00020\u00182\b\u0010)\u001a\u0004\u0018\u00010\u00072\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010+H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "style", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerStyle;", "selectedColor", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem;", "listener", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerTabFragment$ColorPickerListener;", "itemData", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/ee/bear/document/model/toolbar/ItemV2;", "adapter", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerAdapter;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "countOneLine", "", "setListener", "", "setItemData", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "observeData", "onAttach", "context", "Landroid/content/Context;", "updateData", "selectedColorItem", "usedColorList", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorListItem;", "basicColorList", "getStyleString", "", ResourceData.KEY_ID, "Companion", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorPickerFragment extends BaseFragment {
    public static final Map<String, Integer> l = null;
    public ColorPickerStyle e;
    public ColorValueItem f;
    public ColorPickerTabFragment.a g;
    public LiveData<ItemV2> h;
    public ColorPickerAdapter i;
    public final Lazy j;
    public final int k;

    public static final class a {
    }

    static {
        l = MapsKt.mapOf(new Pair[]{TuplesKt.to("used", 2131889752), TuplesKt.to("basic", 2131889753)});
    }

    public ColorPickerFragment() {
        this.e = ColorPickerStyle.FONT_COLOR;
        this.j = LazyKt.lazy(ColorPickerFragment$gson$2.INSTANCE);
        this.k = 8;
    }

    public final String V90(String r7) {
        Iterator<Map.Entry<String, Integer>> r0 = l.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<String, Integer> r1 = r0.next();
        String r2 = r1.getKey();
        int r3 = r1.getValue().intValue();
        if (StringsKt.startsWith$default(r7, r2, false, 2, null) == false) goto L4;
        return getString(r3);
    L9:
        return "";
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        RecyclerView r6 = r4.findViewById(2131384928);
        ColorPickerAdapter r7 = new ColorPickerAdapter(CollectionsKt.emptyList(), this.f, new AnonymousClass1(this));
        this.i = r7;
        r6.setAdapter(r7);
        GridLayoutManager r8 = new GridLayoutManager(getContext(), this.k);
        r8.setSpanSizeLookup(new ColorPickerFragment$onViewCreated$gridLayoutManager$1$1(this));
        r6.setLayoutManager(r8);
        r6.addItemDecoration(new ColorPickerGridItemDecoration((int) j08.b.a(getContext(), 6.0f), this.k));
        LiveData<ItemV2> r9 = this.h;
        if (r9 == null) goto L6;
        r9.observe(this, new b(this));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564887, r3, false);
    }

    public static final void U90(ColorPickerFragment r4, ColorValueItem r5, ColorListItem r6, ColorListItem r7) {
        ArrayList r0 = new ArrayList();
        if (r6 == null) goto L10;
        r0.add(new ColorPickerListItem.TitleItem(r4.V90("used"), ColorPickerItemType.TITLE));
        List<ColorValueItem> r8 = r6.getList();
        if (r8 == null) goto L10;
        Iterator<T> r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        r0.add(new ColorPickerListItem.ColorItem((ColorValueItem) r9.next()));
    L10:
        if (r7 == null) goto L17;
        r0.add(new ColorPickerListItem.TitleItem(r4.V90("basic"), ColorPickerItemType.TITLE));
        List<ColorValueItem> r10 = r7.getList();
        if (r10 == null) goto L17;
        Iterator<T> r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L17;
        r0.add(new ColorPickerListItem.ColorItem((ColorValueItem) r11.next()));
    L17:
        ColorPickerAdapter r12 = r4.i;
        if (r12 == null) goto L23;
        Intrinsics.checkNotNullParameter(r0, "newItems");
        r12.b = r5;
        r12.a = r0;
        r12.notifyDataSetChanged();
        return;
    }
}
