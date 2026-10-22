package com.bytedance.ee.bear.bitable.common;

import com.bytedance.ee.bear.bitable.card.viewmodel.cell.BitableCardButtonLoadingStatus;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.card.CardCellData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.card.CardCellDataParser;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.CommonCellData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.CommonCellDataParser;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.GalleryCellData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.GalleryCellDataParser;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridCellData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridCellDataParser;
import com.bytedance.ee.bear.bitable.itemview.cell.BorderStyleParser;
import com.bytedance.ee.bear.bitable.itemview.cell.ButtonLoadingStatusDeserializer;
import com.bytedance.ee.bear.bitable.itemview.cell.EFieldUITypeParser;
import com.bytedance.ee.bear.bitable.itemview.cell.ItemViewCellParser;
import com.bytedance.ee.bear.bitable.itemview.cell.ItemViewRecordCellData;
import com.bytedance.ee.bear.bitable.itemview.cell.ItemViewRenderItemDataParser;
import com.bytedance.ee.bear.bitable.itemview.cell.PureUITypeParser;
import com.bytedance.ee.bear.bitable.itemview.cell.RenderTypeParser;
import com.bytedance.ee.bear.bitable.itemview.record.list.BorderStyle;
import com.bytedance.ee.bear.bitable.itemview.record.list.CellPureUIType;
import com.bytedance.ee.bear.bitable.itemview.record.list.ItemViewRenderItemData;
import com.bytedance.ee.bear.bitable.itemview.record.list.RenderType;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.PanelData;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.PanelDataParser;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.BitableNativeViewDataParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class BTJson {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<BTJson> f209797b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BTJson f209798c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f209799a;

    public static final class a {
    }

    static {
        Lazy<BTJson> r100 = LazyKt.lazy(BTJson$Companion$_instance$2.INSTANCE);
        f209797b = r100;
        f209798c = r100.getValue();
    }

    public BTJson() {
        this.f209799a = new GsonBuilder().registerTypeAdapter(PanelData.class, new PanelDataParser()).registerTypeAdapter(CardCellData.class, new CardCellDataParser()).registerTypeAdapter(GalleryCellData.class, new GalleryCellDataParser()).registerTypeAdapter(GridCellData.class, new GridCellDataParser()).registerTypeAdapter(CommonCellData.class, new CommonCellDataParser()).registerTypeAdapter(BitableNativeViewData.class, new BitableNativeViewDataParser()).registerTypeAdapter(ItemViewRecordCellData.class, new ItemViewCellParser()).registerTypeAdapter(RenderType.class, new RenderTypeParser()).registerTypeAdapter(CellPureUIType.class, new PureUITypeParser()).registerTypeAdapter(BorderStyle.class, new BorderStyleParser()).registerTypeAdapter(EFieldUIType.class, new EFieldUITypeParser()).registerTypeAdapter(BitableCardButtonLoadingStatus.class, new ButtonLoadingStatusDeserializer()).registerTypeAdapter(ItemViewRenderItemData.class, new ItemViewRenderItemDataParser()).create();
    }

    public final <T> T a(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "valueJson");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return (T) this.f209799a.fromJson(r100, r101);
    L5:
        e = move-exception;
        tt5.a.e("BTJson", "json parse error : ", e, false);
        return null;
    }
}
