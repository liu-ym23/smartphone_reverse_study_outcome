package com.bytedance.ee.bear.bitable.homepage.preview;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.SubViewType;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001c\u001a\u00020\u0011J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/preview/BoostViewData;", "Lcom/bytedance/ee/util/io/NonProguard;", "boostData", "Lcom/bytedance/ee/bear/bitable/homepage/preview/HomePageBoostData;", "nativeViewData", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BitableNativeViewData;", "<init>", "(Lcom/bytedance/ee/bear/bitable/homepage/preview/HomePageBoostData;Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BitableNativeViewData;)V", "getBoostData", "()Lcom/bytedance/ee/bear/bitable/homepage/preview/HomePageBoostData;", "setBoostData", "(Lcom/bytedance/ee/bear/bitable/homepage/preview/HomePageBoostData;)V", "getNativeViewData", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BitableNativeViewData;", "setNativeViewData", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BitableNativeViewData;)V", "collapsed", "", "getCollapsed", "()Ljava/lang/Boolean;", "setCollapsed", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "fromCache", "getFromCache", "()Z", "setFromCache", "(Z)V", "isValid", "getCacheObject", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BoostViewData implements NonProguard {
    private HomePageBoostData boostData;
    private Boolean collapsed;
    private boolean fromCache;
    private BitableNativeViewData nativeViewData;

    public final boolean isValid() {
        if (TextUtils.isEmpty(this.boostData.getBaseToken()) == false) goto L5;
    L11:
        return false;
    L5:
        if (this.nativeViewData.getSubViewType() != SubViewType.NativeGallery) goto L11;
        if (this.nativeViewData.getData() == null) goto L9;
    L10:
        return true;
    L9:
        if (TextUtils.isEmpty(this.nativeViewData.getDataJson()) == true) goto L11;
        goto L10
    }

    public final HomePageBoostData getBoostData() {
        return this.boostData;
    }

    public final Boolean getCollapsed() {
        return this.collapsed;
    }

    public final boolean getFromCache() {
        return this.fromCache;
    }

    public final BitableNativeViewData getNativeViewData() {
        return this.nativeViewData;
    }

    public final BoostViewData getCacheObject(boolean r100) {
        HomePageBoostData r101 = this.boostData;
        BitableNativeViewData r102 = new BitableNativeViewData();
        r102.setSubViewType(this.nativeViewData.getSubViewType());
        r102.setContainerType(this.nativeViewData.getContainerType());
        r102.setDataJson(this.nativeViewData.getDataJson());
        BoostViewData r103 = new BoostViewData(r101, r102);
        r103.collapsed = Boolean.valueOf(r100);
        return r103;
    }

    public final void setBoostData(HomePageBoostData r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.boostData = r100;
    }

    public final void setCollapsed(Boolean r100) {
        this.collapsed = r100;
    }

    public final void setFromCache(boolean r100) {
        this.fromCache = r100;
    }

    public final void setNativeViewData(BitableNativeViewData r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.nativeViewData = r100;
    }

    public BoostViewData(HomePageBoostData r100, BitableNativeViewData r101) {
        Intrinsics.checkNotNullParameter(r100, "boostData");
        Intrinsics.checkNotNullParameter(r101, "nativeViewData");
        this.boostData = r100;
        this.nativeViewData = r101;
    }
}
