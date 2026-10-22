package com.bytedance.ee.bear.bitable.infoarch.nativeview.common;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseCellData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseRecordData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.GroupHeaderData;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyData;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR6\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u00010$j\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u0001`%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R6\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020+0$j\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020+`%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\u001a\u0010.\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001fR\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00109\"\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseViewData;", "K", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseCellData;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseRecordData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "empty", "Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyData;", "getEmpty", "()Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyData;", "setEmpty", "(Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyData;)V", "updateStrategy", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/UpdateStrategy;", "getUpdateStrategy", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/UpdateStrategy;", "setUpdateStrategy", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/UpdateStrategy;)V", ContainerPosition.FOOTER, "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "getFooter", "()Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "setFooter", "(Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;)V", "viewId", "", "getViewId", "()Ljava/lang/String;", "setViewId", "(Ljava/lang/String;)V", "tableId", "getTableId", "setTableId", "recordDataMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getRecordDataMap", "()Ljava/util/HashMap;", "setRecordDataMap", "(Ljava/util/HashMap;)V", "groupDataMap", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/uikit/GroupHeaderData;", "getGroupDataMap", "setGroupDataMap", "groupUniqueKey", "getGroupUniqueKey", "setGroupUniqueKey", "uiExtension", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/UIExtension;", "getUiExtension", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/UIExtension;", "setUiExtension", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/UIExtension;)V", "isPartial", "", "()Z", "setPartial", "(Z)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseViewData<K extends BaseCellData, T extends BaseRecordData<K>> implements NonProguard {
    private EmptyData empty;
    private SimpleItemModel footer;
    private HashMap<String, GroupHeaderData> groupDataMap;
    private String groupUniqueKey;
    private boolean isPartial;
    private HashMap<String, T> recordDataMap;
    private String tableId;
    private UIExtension uiExtension;
    private UpdateStrategy updateStrategy;
    private String viewId;

    public BaseViewData() {
        this.updateStrategy = new UpdateStrategy();
        this.viewId = "";
        this.tableId = "";
        this.recordDataMap = new HashMap();
        this.groupDataMap = new HashMap();
        this.groupUniqueKey = "";
    }

    public final EmptyData getEmpty() {
        return this.empty;
    }

    public final SimpleItemModel getFooter() {
        return this.footer;
    }

    public final HashMap<String, GroupHeaderData> getGroupDataMap() {
        return this.groupDataMap;
    }

    public final String getGroupUniqueKey() {
        return this.groupUniqueKey;
    }

    public final HashMap<String, T> getRecordDataMap() {
        return this.recordDataMap;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final UIExtension getUiExtension() {
        return this.uiExtension;
    }

    public final UpdateStrategy getUpdateStrategy() {
        return this.updateStrategy;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final boolean isPartial() {
        return this.isPartial;
    }

    public final void setEmpty(EmptyData r100) {
        this.empty = r100;
    }

    public final void setFooter(SimpleItemModel r100) {
        this.footer = r100;
    }

    public final void setGroupDataMap(HashMap<String, GroupHeaderData> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.groupDataMap = r100;
    }

    public final void setGroupUniqueKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.groupUniqueKey = r100;
    }

    public final void setPartial(boolean r100) {
        this.isPartial = r100;
    }

    public final void setRecordDataMap(HashMap<String, T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recordDataMap = r100;
    }

    public final void setTableId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tableId = r100;
    }

    public final void setUiExtension(UIExtension r100) {
        this.uiExtension = r100;
    }

    public final void setUpdateStrategy(UpdateStrategy r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.updateStrategy = r100;
    }

    public final void setViewId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.viewId = r100;
    }
}
