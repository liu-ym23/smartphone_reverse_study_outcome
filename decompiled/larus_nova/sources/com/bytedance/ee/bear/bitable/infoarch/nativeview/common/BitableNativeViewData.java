package com.bytedance.ee.bear.bitable.infoarch.nativeview.common;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.card.CardViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.GalleryViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridViewData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010'\u001a\u00020\u0011J\b\u0010(\u001a\u00020\u001dH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001e\u0010%\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BitableNativeViewData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "containerType", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/MobileViewContainerType;", "getContainerType", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/MobileViewContainerType;", "setContainerType", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/MobileViewContainerType;)V", "subViewType", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/SubViewType;", "getSubViewType", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/SubViewType;", "setSubViewType", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/SubViewType;)V", "isOpenView", "", "()Ljava/lang/Boolean;", "setOpenView", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "data", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseViewData;", "getData", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseViewData;", "setData", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseViewData;)V", "dataJson", "", "getDataJson", "()Ljava/lang/String;", "setDataJson", "(Ljava/lang/String;)V", "source", "getSource", "setSource", "isClose", "setClose", "isDataValid", "toString", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableNativeViewData implements NonProguard {
    public static final a Companion = null;
    public static final String LOCAL_CACHE = "local_cache";
    private MobileViewContainerType containerType;
    private BaseViewData<?, ?> data;
    private String dataJson;
    private Boolean isClose;
    private Boolean isOpenView;
    private String source;
    private SubViewType subViewType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BitableNativeViewData() {
    }

    public final boolean isDataValid() {
        a r100 = Companion;
        BaseViewData<?, ?> r101 = this.data;
        SubViewType r102 = this.subViewType;
        r100.getClass();
        if (r102 != SubViewType.NativeGrid) goto L7;
        if ((r101 instanceof GridViewData) == false) goto L7;
    L14:
        return true;
    L7:
        if (r102 != SubViewType.NativeCard) goto L11;
        if ((r101 instanceof CardViewData) == true) goto L14;
    L11:
        if (r102 == SubViewType.NativeGallery) goto L13;
    L15:
        return false;
    L13:
        if ((r101 instanceof GalleryViewData) == false) goto L15;
        goto L14
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("BitableNativeViewData(containerType=");
        r100.append(this.containerType);
        r100.append(", subViewType=");
        r100.append(this.subViewType);
        r100.append(", source=");
        r100.append(this.source);
        r100.append(", isOpenView=");
        r100.append(this.isOpenView);
        r100.append(", dataNull=");
        if (this.data != null) goto L5;
        boolean r101 = true;
    L6:
        r100.append(r101);
        r100.append(')');
        return r100.toString();
    L5:
        r101 = false;
        goto L6
    }

    public final MobileViewContainerType getContainerType() {
        return this.containerType;
    }

    public final BaseViewData<?, ?> getData() {
        return this.data;
    }

    public final String getDataJson() {
        return this.dataJson;
    }

    public final String getSource() {
        return this.source;
    }

    public final SubViewType getSubViewType() {
        return this.subViewType;
    }

    public final Boolean isClose() {
        return this.isClose;
    }

    public final Boolean isOpenView() {
        return this.isOpenView;
    }

    public final void setClose(Boolean r100) {
        this.isClose = r100;
    }

    public final void setContainerType(MobileViewContainerType r100) {
        this.containerType = r100;
    }

    public final void setData(BaseViewData<?, ?> r100) {
        this.data = r100;
    }

    public final void setDataJson(String r100) {
        this.dataJson = r100;
    }

    public final void setOpenView(Boolean r100) {
        this.isOpenView = r100;
    }

    public final void setSource(String r100) {
        this.source = r100;
    }

    public final void setSubViewType(SubViewType r100) {
        this.subViewType = r100;
    }
}
