package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model.ColorValueItem;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerListItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerItemType;", "getType", "()Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerItemType;", "TitleItem", "ColorItem", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerListItem$ColorItem;", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerListItem$TitleItem;", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ColorPickerListItem implements NonProguard {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerListItem$ColorItem;", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerListItem;", "colorValueItem", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem;", "<init>", "(Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem;)V", "getColorValueItem", "()Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem;", "type", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerItemType;", "getType", "()Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerItemType;", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ColorItem extends ColorPickerListItem {
        private final ColorValueItem colorValueItem;
        private final ColorPickerItemType type;

        public final ColorValueItem getColorValueItem() {
            return this.colorValueItem;
        }

        @Override // com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.ColorPickerListItem
        public ColorPickerItemType getType() {
            return this.type;
        }

        public ColorItem(ColorValueItem r100) {
            Intrinsics.checkNotNullParameter(r100, "colorValueItem");
            super(null);
            this.colorValueItem = r100;
            this.type = ColorPickerItemType.COLOR_ITEM;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerListItem$TitleItem;", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerListItem;", "title", "", "type", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerItemType;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerItemType;)V", "getTitle", "()Ljava/lang/String;", "getType", "()Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerItemType;", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TitleItem extends ColorPickerListItem {
        private final String title;
        private final ColorPickerItemType type;

        public final String getTitle() {
            return this.title;
        }

        @Override // com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.ColorPickerListItem
        public ColorPickerItemType getType() {
            return this.type;
        }

        public TitleItem(String r100, ColorPickerItemType r101) {
            Intrinsics.checkNotNullParameter(r100, "title");
            Intrinsics.checkNotNullParameter(r101, "type");
            super(null);
            this.title = r100;
            this.type = r101;
        }
    }

    private ColorPickerListItem() {
    }

    public /* synthetic */ ColorPickerListItem(DefaultConstructorMarker r100) {
        this();
    }

    public abstract ColorPickerItemType getType();
}
