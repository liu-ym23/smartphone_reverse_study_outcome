package com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseViewSetting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\"R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\t¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/GallerySetting;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseViewSetting;", "<init>", "()V", "showCover", "", "getShowCover", "()Z", "setShowCover", "(Z)V", "showFieldName", "getShowFieldName", "setShowFieldName", "coverFitType", "", "getCoverFitType", "()Ljava/lang/String;", "setCoverFitType", "(Ljava/lang/String;)V", "fieldCount", "", "getFieldCount", "()I", "setFieldCount", "(I)V", "recordCardMode", "getRecordCardMode", "setRecordCardMode", "background", "getBackground", "setBackground", "homepageBoost", "getHomepageBoost", "setHomepageBoost", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/CoverFitType;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GallerySetting extends BaseViewSetting {
    private String background;
    private String coverFitType;
    private int fieldCount;
    private boolean homepageBoost;
    private boolean recordCardMode;
    private boolean showCover;
    private boolean showFieldName;

    public final CoverFitType getCoverFitType() {
        String r100 = this.coverFitType;
        CoverFitType[] r101 = CoverFitType.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        CoverFitType r104 = r101[r103];
        if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L9;
        r103 = r103 + 1;
    L9:
        if (r104 == null) goto L11;
        return r104;
    L11:
        return CoverFitType.FIT;
    L8:
        r104 = null;
        goto L9
    }

    public GallerySetting() {
        this.recordCardMode = true;
        this.background = "";
    }

    public final String getBackground() {
        return this.background;
    }

    public final int getFieldCount() {
        return this.fieldCount;
    }

    public final boolean getHomepageBoost() {
        return this.homepageBoost;
    }

    public final boolean getRecordCardMode() {
        return this.recordCardMode;
    }

    public final boolean getShowCover() {
        return this.showCover;
    }

    public final boolean getShowFieldName() {
        return this.showFieldName;
    }

    /* JADX INFO: renamed from: getCoverFitType, reason: collision with other method in class */
    public final String m8314getCoverFitType() {
        return this.coverFitType;
    }

    public final void setBackground(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.background = r100;
    }

    public final void setCoverFitType(String r100) {
        this.coverFitType = r100;
    }

    public final void setFieldCount(int r100) {
        this.fieldCount = r100;
    }

    public final void setHomepageBoost(boolean r100) {
        this.homepageBoost = r100;
    }

    public final void setRecordCardMode(boolean r100) {
        this.recordCardMode = r100;
    }

    public final void setShowCover(boolean r100) {
        this.showCover = r100;
    }

    public final void setShowFieldName(boolean r100) {
        this.showFieldName = r100;
    }
}
