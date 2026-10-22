package com.bytedance.ee.bear.bitable.itemview.record.list;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/list/ItemViewRenderItemData;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "renderId", "", "getRenderId", "()Ljava/lang/String;", "setRenderId", "(Ljava/lang/String;)V", "renderType", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/RenderType;", "getRenderType", "()Lcom/bytedance/ee/bear/bitable/itemview/record/list/RenderType;", "setRenderType", "(Lcom/bytedance/ee/bear/bitable/itemview/record/list/RenderType;)V", "pureUIType", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/CellPureUIType;", "getPureUIType", "()Lcom/bytedance/ee/bear/bitable/itemview/record/list/CellPureUIType;", "setPureUIType", "(Lcom/bytedance/ee/bear/bitable/itemview/record/list/CellPureUIType;)V", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRenderItemData<T> implements NonProguard {
    private CellPureUIType pureUIType;
    private String renderId;
    private RenderType renderType;
    private T value;

    public ItemViewRenderItemData() {
        this.renderId = "";
    }

    public final CellPureUIType getPureUIType() {
        return this.pureUIType;
    }

    public final String getRenderId() {
        return this.renderId;
    }

    public final RenderType getRenderType() {
        return this.renderType;
    }

    public final T getValue() {
        return this.value;
    }

    public final void setPureUIType(CellPureUIType r100) {
        this.pureUIType = r100;
    }

    public final void setRenderId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.renderId = r100;
    }

    public final void setRenderType(RenderType r100) {
        this.renderType = r100;
    }

    public final void setValue(T r100) {
        this.value = r100;
    }
}
